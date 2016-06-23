package testng.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import testng.driver.WebDriverDecorator;

import java.io.File;
import java.io.IOException;

public class ChromeDriverCreator extends WebDriverCreator {

    public static final String PATH_TO_CHROMEDRIVER = "C:\\Users\\Kairat_Doshekenov\\Desktop\\Internship\\ChromeDriver\\chromedriver.exe";

    @Override
    public WebDriverDecorator factoryMethod() {
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File(PATH_TO_CHROMEDRIVER)).build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new WebDriverDecorator(new ChromeDriver(service));
        return driver;
    }
}
