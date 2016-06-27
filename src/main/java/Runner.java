import com.epam.doshekenov.htmlelement.block.LoginFormBlock;
import com.epam.doshekenov.htmlelement.page.InboxPage;
import com.epam.doshekenov.htmlelement.page.MainPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@DefaultUrl("http://mail.yandex.kz")
public class Runner extends PageObject {

    private static WebDriver driver;
    private LoginFormBlock loginFormBlock;

    @FindBy(id = "nb-1")
    private WebElement loginInput;

    public Runner() {

    }

    public static void main(String[] args) {
        InboxPage inboxPage = new InboxPage();
        inboxPage.open();
        inboxPage.logIn();
        inboxPage.openDraftsList();
        inboxPage.composeNewMsg();
        inboxPage.cancelComposingMsg();
        inboxPage.saveMsgToDrafts();
        inboxPage.isMsgPresent();
        inboxPage.openFoundMsg();
        inboxPage.send();
        inboxPage.openSentList();
        inboxPage.isMsgPresent();

    }

    private void method() {
        driver = getDriver();
        open();
        waitFor(ExpectedConditions.visibilityOf(loginFormBlock));
        System.out.println(loginFormBlock.getText());
        waitFor(ExpectedConditions.visibilityOf(loginInput));
        System.out.println(loginInput.getText());
    }
}
