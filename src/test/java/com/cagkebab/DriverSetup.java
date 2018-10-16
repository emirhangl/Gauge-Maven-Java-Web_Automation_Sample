package com.cagkebab;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSetup {
    public static WebDriver driver;

    @BeforeSuite
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/sahabt/webDrivers/chromedriver");
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    public static WebDriver getDriver() {
        String browser = System.getenv("BROWSER");
        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        switch (browser) {
            case "IE":
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "RemoteChromeDriver":
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setCapability("key", System.getProperty("key"));
                capability.setPlatform(org.openqa.selenium.Platform.MAC);
                try {
                     return new RemoteWebDriver(new URL("http://172.16.1.183:4444/wd/hub"),capability);
                } catch (MalformedURLException e) { e.printStackTrace(); }
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

        }
    }

    @AfterSuite
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
