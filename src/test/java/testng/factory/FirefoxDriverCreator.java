package testng.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import testng.driver.WebDriverDecorator;

import java.io.File;


public class FirefoxDriverCreator extends WebDriverCreator {

    public static final String PATH_TO_FIREFOX_BINARY = "C:\\Users\\Kairat_Doshekenov\\Desktop\\Internship\\FF44\\firefox.exe";

    @Override
    public WebDriverDecorator factoryMethod() {
        FirefoxBinary binary = new FirefoxBinary(new File(PATH_TO_FIREFOX_BINARY));
        FirefoxProfile profile = new FirefoxProfile();
        driver = new WebDriverDecorator(new FirefoxDriver(binary, profile));
        return driver;
    }
}
