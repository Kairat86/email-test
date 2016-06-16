package com.epam.doshekenov.page;

import com.epam.doshekenov.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {
    private static final String LOGIN = "";
    private static final String PASSWORD = "";
    private final String YANDEX_MAIL_URL = "https://mail.yandex.kz";

    @FindBy(id = "nb-1")
    private WebElement loginInput;
    @FindBy(id = "nb-2")
    private WebElement passwordInput;
    @FindBy(className = "_nb-button-content")
    private WebElement logInBtn;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openYandexMailPage() {
        driver.get(YANDEX_MAIL_URL);
    }

    public void logIn(User user) {
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        logInBtn.click();
    }


}
