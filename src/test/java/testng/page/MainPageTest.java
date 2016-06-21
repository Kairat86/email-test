package testng.page;

import com.epam.doshekenov.model.User;
import com.epam.doshekenov.page.MainPage;
import com.epam.doshekenov.util.PropertyManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MainPageTest {

    public static final String FIRST_GROUP = "1";
    private static final String HUB = "http://localhost:4444/wd/hub";
    private MainPage mainPage;
    protected WebDriver driver;
    private User user;
    protected PropertyManager pm;

    @Parameters({"browser", "port"})
    @BeforeClass
    public void initMainPage(String browser, String port) throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName(browser);
        driver = new RemoteWebDriver(new URL(HUB), capability);
        mainPage = new MainPage(driver);
        pm = new PropertyManager("email.properties");
        user = new User(pm.getProperty("login"), pm.getProperty("password"));


    }


    @Test(groups = FIRST_GROUP)
    public void loginTest() {
        mainPage.openYandexMailPage();
        mainPage.logIn(user);
    }

}
