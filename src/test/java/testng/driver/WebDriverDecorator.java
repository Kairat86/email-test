package testng.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class WebDriverDecorator implements WebDriver, HasInputDevices {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverDecorator.class.getSimpleName());
    private WebDriver webDriver;

    public WebDriverDecorator(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void get(String s) {
        webDriver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        logger.debug("Searching for elements located by " + by.toString());
        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        logger.debug("Searching for an element located by " + by.toString());
        return webDriver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return webDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }


    @Override
    public Keyboard getKeyboard() {
        if (webDriver instanceof ChromeDriver) {
            return ((ChromeDriver) webDriver).getKeyboard();
        } else if (webDriver instanceof FirefoxDriver) {
            return ((FirefoxDriver) webDriver).getKeyboard();
        }
        return ((RemoteWebDriver) webDriver).getKeyboard();
    }

    @Override
    public Mouse getMouse() {
        if (webDriver instanceof ChromeDriver) {
            return ((ChromeDriver) webDriver).getMouse();
        } else if (webDriver instanceof FirefoxDriver) {
            return ((FirefoxDriver) webDriver).getMouse();
        }
        return ((RemoteWebDriver) webDriver).getMouse();
    }
}
