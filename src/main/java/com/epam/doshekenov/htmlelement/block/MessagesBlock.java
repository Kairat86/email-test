package com.epam.doshekenov.htmlelement.block;

import com.epam.doshekenov.model.EmailMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(className = "b-messages")
public class MessagesBlock extends HtmlElement {

    private static final Logger logger = LoggerFactory.getLogger(MessagesBlock.class.getSimpleName());

    @FindBy(xpath = "//span[@class='b-messages__firstline-wrapper']")
    private List<WebElement> messages;
    private WebElement foundElm;


    public boolean isMsgPresent(EmailMessage message, WebDriverWait wait) {
        logger.debug("Number fo massages to search among: " + messages.size());
        wait.until(ExpectedConditions.visibilityOfAllElements(messages));
        logger.debug("Number fo massages after wait: " + messages.size());
        logger.debug("Searching for: " + message.toString());
        for (WebElement msg : messages) {
            EmailMessage candidateMsg = convertToMsgObj(msg);
            logger.debug("Candidate message: " + candidateMsg.toString());
            if (candidateMsg.equals(message)) {
                foundElm = msg;
                logger.debug("found the message");
                return true;
            }
        }
        logger.debug("The message was not found");
        return false;
    }

    private EmailMessage convertToMsgObj(WebElement msg) {
        EmailMessage message = new EmailMessage();
        message.setSubject(msg.findElement(By.className("b-messages__subject")).getText());
        message.setMsgText(msg.findElement(By.className("b-messages__firstline")).getText());
        return message;
    }

    public void openFoundElm() {
        foundElm.click();
    }
}
