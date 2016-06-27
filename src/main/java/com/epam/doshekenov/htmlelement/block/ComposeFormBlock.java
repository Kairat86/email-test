package com.epam.doshekenov.htmlelement.block;

import com.epam.doshekenov.model.EmailMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(className = "compose-form")
public class ComposeFormBlock extends HtmlElement {

    private static final Logger logger = LoggerFactory.getLogger(ComposeFormBlock.class.getSimpleName());

    @FindBy(className = "js-compose-mail-input_to")
    private TextInput receiverEmailInput;
    @FindBy(id = "compose-send")
    private TextInput msgTextInput;
    @FindBy(id = "compose-subj")
    private TextInput msgSubjInput;
    @FindBy(id = "nb-35")
    private Button cancelBtn;
    @FindBy(xpath = "//button[@data-action='dialog.save']")
    private Button saveToDraftsBtn;
    @FindBy(id = "compose-submit")
    private Button sendBtn;
    @FindBy(className = "b-yabble__text__content")
    private WebElement emailAddressInput;


    public void composeNewMsg(EmailMessage message, WebDriverWait wait) {
        receiverEmailInput.findElement(By.tagName("input")).sendKeys(message.getTo());
        msgSubjInput.sendKeys(message.getSubject());
        msgTextInput.sendKeys(message.getMsgText());
    }

    public void cancel() {
        cancelBtn.click();
    }

    public void saveToDrafts() {
        saveToDraftsBtn.click();
    }

    public boolean checkMsgIntegrity(EmailMessage message) {
        boolean equals = msgTextInput.getText().equals(message.getMsgText());
        if (equals) {
            logger.debug("Message is OK");
        }
        logger.debug(msgTextInput.getText());
        return equals;
    }

    public void send(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(emailAddressInput));
        sendBtn.click();
    }
}
