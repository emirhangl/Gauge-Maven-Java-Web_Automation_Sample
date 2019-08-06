import Mapping.Mapper;
import com.cagkebab.Driver;
import com.cagkebab.DriverSetup;
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

public class StepImplementation extends DriverSetup {
    Mapper mapper = new Mapper();
    public WebDriver driver = Driver.getInstance().webDriver;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Step("<url> Sayfasına gidilir")
    public void navigateTo(String url) {
        driver.get(url);
    }

    @Step("<Saniye> Saniyesi kadar bekle")
    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("<by> butonuna tıklanır")
    public void clickElement(String by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper.getElementFromJSON(by))).click();
    }

    @Step("<by> alanına <text> yazılır")
    public void sendKeys(String by, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper.getElementFromJSON(by))).sendKeys(text);
    }

    @Step("<by> alanı silinir")
    public void deleteTextbox(String by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper.getElementFromJSON(by))).clear();
    }

    @Step("<by> elementinin görülmesi beklenir")
    public void waitForTheElement(String by) {
        Assert.assertTrue(by + " elemanı sayfada görülemedi!",
                wait.until(ExpectedConditions.presenceOfElementLocated(mapper.getElementFromJSON(by))).isDisplayed());
    }

    @Step("<by> alanının üzerine mouse ile gelinir")
    public void hoverOnTheElement(String by) {
        WebElement element = driver.findElement(mapper.getElementFromJSON(by));
        element.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        waitSeconds(3);
    }

    @Step("Herhangi bir pop up varsa kapatılır")
    public void closeThePopUps() {
        if (driver.switchTo().alert() != null) {
            driver.switchTo().alert().dismiss();
        }
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
