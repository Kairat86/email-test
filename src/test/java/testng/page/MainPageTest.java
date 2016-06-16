package testng.page;

import com.epam.doshekenov.model.User;
import com.epam.doshekenov.page.MainPage;
import com.epam.doshekenov.util.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageTest {

    public static final String FIRST_GROUP = "1";
    private MainPage mainPage;
    protected WebDriver driver;
    private User user;
    protected PropertyManager pm;

    @BeforeClass
    public void initMainPage() {
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        pm = new PropertyManager("email.properties");
        user = new User(pm.getProperty("login"), pm.getProperty("password"));

    }

    @Test(groups = FIRST_GROUP)
    public void getRequestTest() {
        mainPage.openYandexMailPage();
    }

    @Test(groups = FIRST_GROUP)
    public void loginTest() {
        mainPage.logIn(user);
    }

}
