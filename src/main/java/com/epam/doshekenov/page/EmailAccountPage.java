package com.epam.doshekenov.page;

import com.epam.doshekenov.exception.CorruptedMsgException;
import com.epam.doshekenov.model.EmailMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmailAccountPage extends Page {

    private static final Logger logger = LoggerFactory.getLogger(EmailAccountPage.class.getSimpleName());

    WebDriverWait wait;
    @FindBy(className = "js-toolbar-item-title-compose")
    private WebElement composeMsgBtn;
    @FindBy(className = "js-compose-mail-input_to")
    private WebElement receiverEmailInput;
    @FindBy(id = "compose-subj")
    private WebElement subjectElement;
    @FindBy(id = "compose-send")
    private WebElement textArea;
    @FindBy(id = "nb-35")
    private WebElement cancelBtn;
    @FindBy(className = "b-popup__focus-me")
    private WebElement saveBtn;
    @FindBy(xpath = "//a[@class='b-folders__folder__link'][@href='#draft']")
    private WebElement draftsElement;
    @FindBy(xpath = "//a[@class='b-messages__message__link daria-action']")
    private List<WebElement> draftMessages;
    @FindBy(xpath = "//span[@class='b-messages__message__left__wrapper']")
    private List<WebElement> sentMessages;
    @FindBy(id = "compose-submit")
    private WebElement sendBtn;
    private WebElement foundDraft;
    @FindBy(className = "b-yabble__text__content")
    private WebElement emailAddress;
    @FindBy(xpath = "//a[@class='b-folders__folder__link'][@href='#sent']")
    private WebElement sentMsgsElement;
    @FindBy(className = "header-user-pic")
    private WebElement avaPic;
    @FindBy(xpath = "//div[@class='b-mail-dropdown__item']")
    private List<WebElement> dropDownElements;
    private EmailMessage message;


    public EmailAccountPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void composeNewMsg(EmailMessage emailMessage) {
        wait.until(ExpectedConditions.visibilityOf(composeMsgBtn)).click();
        setReceiverEmail(emailMessage.getTo());
        setSubject(emailMessage.getSubject());
        setMsgTxt(emailMessage.getMsgText());
    }


    private void setReceiverEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(receiverEmailInput));
        receiverEmailInput.findElement(By.tagName("input")).sendKeys(email);
    }

    private void setSubject(String subject) {
        subjectElement.sendKeys(subject);
    }

    private void setMsgTxt(String msg) {
        textArea.sendKeys(msg);
    }

    public void cancelComposeMsg() {
        cancelBtn.click();
    }

    public void saveToDrafts() {
        saveBtn.click();
    }

    public void openDrafts() {
        wait.until(ExpectedConditions.visibilityOf(draftsElement)).click();
    }


    public boolean isMsgPresentInDrafts(EmailMessage emailMessage) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(draftMessages));
        } catch (TimeoutException te) {
            logger.debug("list is empty");
            return false;
        }

        return checkMsgPresence(draftMessages, emailMessage);
    }

    public boolean isMsgPresentInSent(EmailMessage emailMessage) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(sentMessages));
        } catch (TimeoutException te) {
            logger.debug("list is empty");
            return false;
        }

        return checkMsgPresence(draftMessages, emailMessage);

    }

    private boolean checkMsgPresence(List<WebElement> draftMessages, EmailMessage emailMessage) {
        for (WebElement e : draftMessages) {
            WebElement subjectInput = e.findElement(By.className("b-messages__subject"));
            WebElement toInput = e.findElement(By.className("b-messages__from__text"));
            System.out.println(subjectInput.getText() + "-" + emailMessage.getSubject());
            if (subjectInput.getText().equals(emailMessage.getSubject()) && toInput.getText().equals(emailMessage.getTo())) {
                foundDraft = e;
                return true;
            }
        }
        return false;
    }


    public void checkMsgIntegrity(EmailMessage emailMessage) throws CorruptedMsgException {
        String text = foundDraft.findElement(By.className("b-messages__firstline")).getText();
        if (!text.equals(emailMessage.getMsgText())) {
            throw new CorruptedMsgException("Message was corrupted!");
        }
    }

    public void openDraft() {
        foundDraft.findElement(By.className("b-messages__firstline-wrapper")).click();
    }

    public void sendMsg() {
        wait.until(ExpectedConditions.visibilityOf(emailAddress));
        sendBtn.click();
    }

    public void openSentMessages() {
        wait.until(ExpectedConditions.visibilityOf(sentMsgsElement));
        sentMsgsElement.click();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void logout() {
        avaPic.click();
        By locator = By.className("b-mail-dropdown__item");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        List<WebElement> elements = driver.findElements(locator);
        elements.get(elements.size() - 1).click();
        System.out.println("finish");
    }

    public void setMessage(EmailMessage message) {
        this.message = message;
    }

    public boolean testMethod(EmailMessage emailMessage) {
        try {
            driver.navigate().refresh();
            wait.until(ExpectedConditions.invisibilityOfAllElements(draftMessages));
            WebElement subjectInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("b-messages__subject")));
            WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("b-messages__from__text")));
            System.out.println(subjectInput.getText() + "-" + toInput.getText());
        } catch (TimeoutException te) {
            te.printStackTrace();
            return false;
        }
        return true;
    }
}
