package jbehave;

import com.epam.doshekenov.exception.CorruptedMsgException;
import com.epam.doshekenov.step.HtmlElmsUserSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class YandexEmailSteps {

    @Steps
    HtmlElmsUserSteps endUser;

    @Given("the user is on http://mail.yandex.kz page")
    public void givenTheUserIsOnYandexEmailPage() {
        endUser.isTheHomePage();
    }

    @When("user enters login, password and clicks login button")
    public void whenUserEntersCredentialsAndClicksLoginButton() {
        endUser.enterCredentialsAndClickLoginButton();
    }

    @Then("user should get to yandex email inbox page")
    public void userShouldGetToYandexEmailInboxPage() {
        endUser.isTheYandexEmailInboxPage();
    }


    @Given("user starts composing a message")
    public void givenTheUserIsInHisEmailInboxPage() {
        endUser.clickComposeBtn();
    }

    @When("user clicks cancel button")
    public void userClicksCancelBtn() {
        endUser.clickCancelBtn();
    }


    @Then("he should be able to find his message in drafts list")
    public void shouldBeAbleToFindHisMsgInDraftsList() {
        endUser.findMsgInDraftsList();
    }

    @Given("that a user opens a saved draft")
    public void userChecksAndOpensSavedDraft() throws CorruptedMsgException {
        endUser.openSavedDraft();
    }

    @When("he checks it for integrity and sends it")
    public void sendMsg() {
        endUser.send();
    }


    @Then("he should be able to find his message in sent messages list")
    public void shouldBeAbleToFindMsgInSentMsgsList() {
        endUser.findMsgInSentList();
    }
}
