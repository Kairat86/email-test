package com.epam.doshekenov.step;

import com.epam.doshekenov.exception.CorruptedMsgException;
import com.epam.doshekenov.model.EmailMessage;
import com.epam.doshekenov.page.EmailAccountPage;
import com.epam.doshekenov.util.PropertyManager;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.testng.Assert;

public class EndUserSteps extends ScenarioSteps {

    public static final String EMAIL_PROPERTIES = "email.properties";
    public static final String RECEIVER = "receiver";
    private final EmailMessage message;
    private EmailAccountPage accountPage;

    public EndUserSteps() {
        message = new EmailMessage(new PropertyManager(EMAIL_PROPERTIES).getProperty(RECEIVER));
    }

    @Step
    public void isTheHomePage() {
        accountPage.open();
    }

    @Step
    public void enterCredentialsAndClickLoginButton() {
        accountPage.logIn();
    }

    @Step
    public void isTheYandexEmailInboxPage() {
        accountPage.checkURL();
    }

    @Step
    public void clickComposeBtn() {
        accountPage.composeNewMsg(message);
    }

    @Step
    public void clickCancelBtn() {
        accountPage.cancelComposeMsg();
    }

    @Step
    public void findMsgInDraftsList() {
        accountPage.openDrafts();
        boolean msgPresentInDrafts = accountPage.isMsgPresentInDrafts(message);
        Assert.assertTrue(msgPresentInDrafts);
        System.out.println(msgPresentInDrafts);
    }

    @Step
    public void openSavedDraft() {
        accountPage.openDraft();
    }

    @Step
    public void checkMsg() throws CorruptedMsgException {
        System.out.println(message.getClass().getSimpleName() + ": " + message.getMsgText());
        accountPage.checkMsgIntegrity(message);
    }

    @Step
    public void send() {
        accountPage.sendMsg();
    }

    @Step
    public void findMsgInSentList() {
        accountPage.refresh();
        accountPage.openSentMessages();
        accountPage.isMsgPresentInSent(message);
        Assert.assertTrue(accountPage.isMsgPresentInSent(message));
    }


}
