package testng.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import testng.driver.WebDriverDecorator;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverCreator extends WebDriverCreator {

    private static final String HUB_URL = "http://localhost:4444/wd/hub";

    @Override
    public WebDriverDecorator factoryMethod() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("chrome");
            driver = new WebDriverDecorator(new RemoteWebDriver(new URL(HUB_URL), desiredCapabilities));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
