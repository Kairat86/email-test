package testng.driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testng.factory.WebDriverCreator;

public class WebDriverDecoratorInstance {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverDecoratorInstance.class.getSimpleName());

    private static WebDriverDecorator driver;

    private WebDriverDecoratorInstance() {
    }

    public static WebDriver getInstance(WebDriverCreator creator) {
        if (driver == null) {
            driver = creator.factoryMethod();
        } else {
            logger.debug("Instance has already been created by " + creator.getClass().getSimpleName());
        }
        return driver;
    }
}
