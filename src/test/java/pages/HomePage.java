package pages;

import com.thoughtworks.gauge.Step;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectGoToDirection(String str) {
        // clicks on Nereden
        clickElement(By.cssSelector("label[data-testid='flight-origin-input-comp']"));

        // types İstanbul
        sendKeys(By.cssSelector("input[data-testid='endesign-flight-origin-autosuggestion-input']"), str);

        // select İstanbul Tüm Havalimanları
        clickElement(By.cssSelector("div[data-testid='autosuggestion-custom-item-istanbul-city-country']"));
    }

    public void selectFromDirection(String str){
        // clicks on Nereye
        clickElement(By.cssSelector("label[data-testid='flight-destination-input-comp']"));

        // types Ankara
        sendKeys(By.cssSelector("input[data-testid='endesign-flight-destination-autosuggestion-input']"), str);

        // select İstanbul Tüm Havalimanları
        clickElement(By.cssSelector("div[data-testid='autosuggestion-custom-item-ankara-esenboga-havalimani']"));
    }

    public void selectGoToDate(String day, String month, String year){
        // clicks on Gidiş tarihi
        clickElement(By.cssSelector("div[data-testid='enuygun-homepage-flight-departureDate-datepicker-popover-button']"));

        clickElement(By.cssSelector("button[data-day='"+ day +"']"));
    }

    public void selectFromDate(String day, String month, String year){
        // clicks on Gidiş tarihi
        clickElement(By.cssSelector("label[data-testid='enuygun-homepage-flight-returnDate-input-comp']"));

        clickElement(By.cssSelector("button[data-day='"+ day +"']"));
    }

    public void selectAdultPassengerNumber(int count) {
        // clicks on Yolcu sayısı
        clickElement(By.cssSelector("div[data-testid='enuygun-homepage-flight-selectPassengerAndCabin']"));

        WebElement countElement = findElement(By.cssSelector("div[data-testid='flight-adult-counter-count']"));
        waitSeconds(2);
        int currentCount = Integer.parseInt(countElement.getText());

        while (count != currentCount){
            clickElement(By.cssSelector("button[data-testid='flight-adult-counter-plus-button']"));
            currentCount++;
        }
    }

    public void selectChildPassengerCount(int count) {
        WebElement countElement = findElement(By.cssSelector("div[data-testid='flight-child-counter-count']"));
        int currentCount = Integer.parseInt(countElement.getText());

        while (count != currentCount) {
            clickElement(By.cssSelector("button[data-testid='flight-child-counter-plus-button']"));
            currentCount++;
        }
    }

    public void selectBabyPassengerCount(int count) {
        WebElement countElement = findElement(By.cssSelector("div[data-testid='flight-infant-counter-count']"));
        int currentCount = Integer.parseInt(countElement.getText());

        while (count != currentCount) {
            clickElement(By.cssSelector("button[data-testid='flight-infant-counter-plus-button']"));
            currentCount++;
        }
    }


    public void selectFlightType(String str) {
        if (str == "Ekonomi"){
            clickElement(By.cssSelector("button[data-testid='enuygun-homepage-flight-ekonomiCabin']"));
        }else if(str == "Business"){
            clickElement(By.cssSelector("button[data-testid='enuygun-homepage-flight-businessCabin']"));
        }
    }
}
