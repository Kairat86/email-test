package testng.page;

import com.epam.doshekenov.model.User;
import com.epam.doshekenov.page.MainPage;
import com.epam.doshekenov.util.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testng.driver.WebDriverDecoratorInstance;
import testng.factory.ChromeDriverCreator;
import testng.factory.FirefoxDriverCreator;


import java.net.MalformedURLException;

public class MainPageTest {

    public static final String FIRST_GROUP = "1";
    private static final String HUB = "http://localhost:4444/wd/hub";
    private MainPage mainPage;
    protected WebDriver driver;
    private User user;
    protected PropertyManager pm;

    @BeforeClass
    public void initMainPage() throws MalformedURLException {
        driver = WebDriverDecoratorInstance.getInstance(new FirefoxDriverCreator());
        mainPage = new MainPage(driver);
        pm = new PropertyManager("email.properties");
        user = new User(pm.getProperty("login"), pm.getProperty("password"));
    }

    @Test(groups = FIRST_GROUP)
    public void testLogin() {
        mainPage.openYandexMailPage();
        mainPage.logIn(user);
    }
}
