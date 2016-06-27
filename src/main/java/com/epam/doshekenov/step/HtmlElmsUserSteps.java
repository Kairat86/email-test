package com.epam.doshekenov.step;

import com.epam.doshekenov.htmlelement.page.InboxPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.testng.Assert;

public class HtmlElmsUserSteps extends ScenarioSteps {

    InboxPage inboxPage;

    public HtmlElmsUserSteps() {
        this.inboxPage = new InboxPage();
    }

    @Step
    public void isTheHomePage() {
        inboxPage.open();
    }

    @Step
    public void enterCredentialsAndClickLoginButton() {
        inboxPage.logIn();
    }

    @Step
    public void isTheYandexEmailInboxPage() {
        inboxPage.checkURL();
    }

    @Step
    public void clickComposeBtn() {
        inboxPage.openDraftsList();
        inboxPage.composeNewMsg();
    }

    @Step
    public void clickCancelBtn() {
        inboxPage.cancelComposingMsg();
        inboxPage.saveMsgToDrafts();
    }

    @Step
    public void findMsgInDraftsList() {
        inboxPage.openDraftsList();
        boolean msgPresentInDrafts = inboxPage.isMsgPresent();
        Assert.assertTrue(msgPresentInDrafts);
    }

    @Step
    public void openSavedDraft() {
        inboxPage.openFoundMsg();
    }


    @Step
    public void send() {
        inboxPage.send();
    }

    @Step
    public void findMsgInSentList() {
        inboxPage.openSentList();
        Assert.assertTrue(inboxPage.isMsgPresent());
    }


}
