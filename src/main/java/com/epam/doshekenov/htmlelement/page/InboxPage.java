package com.epam.doshekenov.htmlelement.page;


import com.epam.doshekenov.htmlelement.block.ComposeFormBlock;
import com.epam.doshekenov.htmlelement.block.MessagesBlock;
import com.epam.doshekenov.htmlelement.block.NavigationBlock;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPage extends MainPage {

    public static final String INBOX = "#inbox";
    @FindBy(className = "js-toolbar-item-title-compose")
    private WebElement composeMsgBtn;
    private ComposeFormBlock composeFormBlock;
    private NavigationBlock navigationBlock;
    private MessagesBlock messagesBlock;

    public void checkURL() {
        driver.getCurrentUrl().contains(INBOX);
    }

    public void composeNewMsg() {
        long t1 = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(composeMsgBtn));
        long t2 = System.currentTimeMillis();
        composeMsgBtn.click();
        composeFormBlock.composeNewMsg(message, wait);
    }

    public void cancelComposingMsg() {
        composeFormBlock.cancel();
    }

    public void saveMsgToDrafts() {
        composeFormBlock.saveToDrafts();
    }

    public void openDraftsList() {
        driver.navigate().refresh();
        navigationBlock.openDraftsList(wait);
    }

    public boolean isMsgPresent() {
        return messagesBlock.isMsgPresent(message, wait);
    }

    public void openFoundMsg() {
        messagesBlock.openFoundElm(wait);
    }

    public void send() {
        composeFormBlock.send(wait);
    }

    public void openSentList() {
        driver.navigate().refresh();
        navigationBlock.openSentList();
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
