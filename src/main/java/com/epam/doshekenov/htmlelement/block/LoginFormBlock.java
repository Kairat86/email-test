package com.epam.doshekenov.htmlelement.block;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//form[@method='POST']")
public class LoginFormBlock extends HtmlElement {

    @FindBy(id = "nb-1")
    private TextInput loginInput;

    @FindBy(id = "nb-2")
    private TextInput passInput;

    @FindBy(className = "_nb-button-content")
    private Button loginBtn;

    public LoginFormBlock() {
    }

    public void login(String login, String pass) {
        loginInput.sendKeys(login);
        passInput.sendKeys(pass);
        loginBtn.click();
    }

}
