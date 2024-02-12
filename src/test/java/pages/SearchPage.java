package pages;

import org.bouncycastle.asn1.x509.Time;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    Actions builder = new Actions(driver);


    public void selectTakeOffHourRange(int startTime, int endTime) {
        // click Gidiş kalkış / varış saatleri
        clickElement(By.cssSelector("div.ctx-filter-departure-return-time"));
        waitSeconds(2);

        increaseMinDepartureTimeByOneHour(startTime);
        waitSeconds(2);

        decreaseMaxDepartureTimeByOneHour(endTime);
        waitSeconds(4);
    }

    private void increaseMinDepartureTimeByOneHour(int startTime) {
        WebElement element = findElement(By.cssSelector("div[data-testid='departureDepartureTimeSlider'] > div > div.rc-slider-handle-1"));
        builder.clickAndHold(element).moveByOffset(10 * startTime, 0).release().build().perform();
    }

    private void decreaseMaxDepartureTimeByOneHour(int endTime) {
        WebElement element = findElement(By.cssSelector("div[data-testid='departureDepartureTimeSlider'] > div > div.rc-slider-handle-2"));
        builder.clickAndHold(element).moveByOffset(-10 * (24 - endTime), 0).release().build().perform();
    }

    public void checkThatTakeOffHourRangeIsCorrect(String start, String end) {
        // departure time element list
        List<WebElement> elements = findElements(By.cssSelector("div[data-testid='departureTime']"));

        for (WebElement element : elements) {
            Assert.assertTrue("KALKIŞ SAATİ BELİRTİLEN ARALIKTA DEĞİL! \n Element: " + element
                    , isInTimeRange(element.getText(), start, end));
        }
    }

    public boolean isInTimeRange(String time, String startTime, String endTime) {
        LocalTime givenTime = LocalTime.parse(time);
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        return !givenTime.isBefore(start) && !givenTime.isAfter(end);
    }

    public void checkThatPriceRangeListedASC() {
        // fiyat int list document.querySelector("div[data-price]").getAttribute("data-price")  10.5
        List<WebElement> elements = findElements(By.cssSelector("div[data-price]"));

        double[] priceArray = new double[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            // String değerlerini double'a dönüştür
            priceArray[i] = Double.parseDouble(elements.get(i).getAttribute("data-price"));
        }
        Assert.assertTrue("ARAMA EKRANINDA FİYAT SIRALAMASI KÜÇÜKTEN BÜYÜĞE SIRALI DEĞİL \n Liste: " + priceArray.toString()
                , isPriceListSorted(priceArray));
    }

    public static boolean isPriceListSorted(double[] priceArray) {
        // Fiyat listesini küçükten büyüğe sırala
        double[] sortedPrices = priceArray.clone();
        Arrays.sort(sortedPrices);

        // Sıralanmış fiyat listesi ile verilen fiyat listesini karşılaştır
        return Arrays.equals(priceArray, sortedPrices);
    }
}
