package com.epam.doshekenov.page;

import com.epam.doshekenov.model.User;
import com.epam.doshekenov.util.PropertyManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    @FindBy(xpath = "//label[@id='nb-1']")
    private WebElement loginInput;
    @FindBy(id = "nb-2")
    private WebElement passwordInput;
    @FindBy(className = "_nb-button-content")
    private WebElement logInBtn;
    PropertyManager manager = new PropertyManager("email.properties");
    protected User user = new User(manager.getProperty("login"), manager.getProperty("password"));


    public void logIn() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(loginInput)
                .click()
                .sendKeys(user.getLogin())
                .moveToElement(passwordInput)
                .click()
                .sendKeys(user.getPassword())
                .moveToElement(logInBtn)
                .click()
                .perform();
    }



}
