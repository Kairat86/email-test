package testng.factory;

import org.openqa.selenium.WebDriver;
import testng.driver.WebDriverDecorator;

public abstract class WebDriverCreator {

    protected WebDriverDecorator driver;

    public abstract WebDriverDecorator factoryMethod();
}
