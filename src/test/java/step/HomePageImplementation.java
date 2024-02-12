package step;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import mapping.Mapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class HomePageImplementation {
    Mapper mapper = new Mapper();
    public WebDriver driver = Driver.getInstance().webDriver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    HomePage homePage = new HomePage(driver);

    @Step("gidiş yönü olarak <İstanbul> seçilir")
    public void selectGoToDirection(String str) {
        homePage.selectGoToDirection(str);
    }

    @Step("dönüş yönü olarak <Ankara> seçilir")
    public void selectFromDirection(String str) {
        homePage.selectFromDirection(str);
    }

    @Step("gidiş tarihi <gün> <ay> <yıl> olarak seçilir")
    public void selectGoToDate(String day, String month, String year) {
        homePage.selectGoToDate(day, month, year);
    }

    @Step("dönüş tarihi <gün> <ay> <yıl> olarak seçilir")
    public void selectFromDate(String day, String month, String year) {
        homePage.selectFromDate(day, month, year);
    }

    @Step("yetişkin yolcu sayısı <1> olarak seçilir")
    public void selectAdultPassengerNumber(int count) {
        homePage.selectAdultPassengerNumber(count);
    }

    @Step("çocuk yolcu sayısı <0> olarak seçilir")
    public void selectChildPassengerCount(int count) {
        homePage.selectChildPassengerCount(count);
    }

    @Step("bebek yolcu sayısı <0> olarak seçilir")
    public void selectBabyPassengerCount(int count) {
        homePage.selectBabyPassengerCount(count);
    }

    @Step("uçak sınıfı <Ekonomi/Business> olarak seçilir")
    public void selectFlightType(String str) {
        homePage.selectFlightType(str);
    }
}
