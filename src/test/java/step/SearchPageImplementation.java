package step;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import mapping.Mapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SearchPage;

import java.time.Duration;

public class SearchPageImplementation {
    Mapper mapper = new Mapper();
    public WebDriver driver = Driver.getInstance().webDriver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    SearchPage searchPage = new SearchPage(driver);


    @Step("gidiş kalkış varış saatleri filtresinden kalkış saati <10:00> ile <18:00> arası seçilir")
    public void selectTakeOffHourRange(int start, int end) {
        searchPage.selectTakeOffHourRange(start, end);
    }

    @Step("uçuşların kalkış saatlerinin <10:00> ile <18:00> arasında olduğu kontrol edilir")
    public void checkThatTakeOffHourRangeIsCorrect(String start, String end) {
        searchPage.checkThatTakeOffHourRangeIsCorrect(start, end);
    }

    @Step("listelenen uçuşların fiyatlarının artan şekilde geldiği kontrol edilir")
    public void checkThatPriceRangeListedASC() {
        searchPage.checkThatPriceRangeListedASC();
    }
}
