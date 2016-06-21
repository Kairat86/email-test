package com.epam.doshekenov.page;

import com.epam.doshekenov.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Page {
    private static final String LOGIN = "";
    private static final String PASSWORD = "";
    private static final String YANDEX_MAIL_URL = "http://mail.yandex.kz";


    @FindBy(xpath = "//label[@id='nb-1']")
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
        Actions actions = new Actions(driver);
        actions.moveToElement(loginInput);
        actions.click();
        actions.sendKeys(user.getLogin());
        actions.build().perform();
        actions.moveToElement(passwordInput);
        actions.click();
        actions.sendKeys(user.getPassword());
        actions.build().perform();
        actions.moveToElement(logInBtn);
        actions.click().perform();
    }


}
