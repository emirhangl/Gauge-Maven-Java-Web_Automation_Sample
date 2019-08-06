package Step;

import Mapping.Mapper;
import Driver.Driver;
import Pages.BasePage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class StepImplementation {
    Mapper mapper = new Mapper();
    public WebDriver driver = Driver.getInstance().webDriver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    BasePage basePage=new BasePage(driver);

    @Step("<url> Sayfasına gidilir")
    public void navigateTo(String url) {
        basePage.navigateTo(url);
    }

    @Step("<Saniye> Saniyesi kadar beklenir")
    public void waitSeconds(int seconds) {
        basePage.waitSeconds(seconds);
    }

    @Step("<by> butonuna tıklanır")
    public void clickElement(String by) {
        basePage.clickElement(by);
    }

    @Step("<by> alanına <text> yazılır")
    public void sendKeys(String by, String text) {
        basePage.sendKeys(by, text);
    }

    @Step("<by> alanı silinir")
    public void deleteTextbox(String by) {
        basePage.clearTextbox(by);
    }

    @Step("<by> elementinin görülmesi beklenir")
    public void waitForTheElement(String by) {
        basePage.waitUntilElementAppear(by);
    }

    @Step("<by> alanının üzerine mouse ile gelinir")
    public void hoverOnTheElement(String by) {
        basePage.hoverOnElement(by);
    }

    @Step("Herhangi bir pop up varsa kapatılır")
    public void closeThePopUps() {
        basePage.acceptPopupIfExits();
    }

    @Step("Klavyeden TAB tuşuna basılır")
    public void pressTAB() {
        driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);
    }

    @Step("Klavyeden ENTER tuşuna basılır")
    public void pressENTER() {
        driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
    }

    @Step("<byList> listesinden rastgele bir elemana tıklanır")
    public void clickRandomElementFromByList(String byList) {
        List<WebElement> elements = driver.findElements(mapper.getElementFromJSON(byList));
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size() + 1);
        WebElement element = elements.get(randomNumber);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


}
