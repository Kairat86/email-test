package com.epam.doshekenov.htmlelement.page;

import com.epam.doshekenov.htmlelement.block.LoginFormBlock;
import com.epam.doshekenov.model.EmailMessage;
import com.epam.doshekenov.util.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class MainPage {

    private static final Logger loggger = LoggerFactory.getLogger(MainPage.class.getSimpleName());
    public static final String EMAIL_PROPERTIES = "email.properties";
    public static final String YANDEX_EMAIL = "http://mail.yandex.kz";
    public static final String RECEIVER = "receiver";
    protected EmailMessage message;
    protected WebDriverWait wait;
    protected WebDriver driver;
    private LoginFormBlock loginFormBlock;
    private String pass;
    private String login;

    public MainPage() {
        this.driver = new FirefoxDriver();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        PropertyManager manager = new PropertyManager(EMAIL_PROPERTIES);
        login = manager.getProperty("login");
        pass = manager.getProperty("password");
        message = new EmailMessage(manager.getProperty(RECEIVER));
        wait = new WebDriverWait(driver, 4);
        loggger.debug("Initialized main page");
    }

    public void logIn() {
        loginFormBlock.login(login, pass);
    }

    public void open() {
        driver.get(YANDEX_EMAIL);
    }
}
