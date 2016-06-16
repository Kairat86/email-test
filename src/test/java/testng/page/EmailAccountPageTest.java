package testng.page;

import com.epam.doshekenov.exception.CorruptedMsgException;
import com.epam.doshekenov.model.EmailMessage;
import com.epam.doshekenov.page.EmailAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class EmailAccountPageTest extends MainPageTest {

    private static final String SECOND_GROUP = "2";
    private static final String THIRD_GROUP = "3";
    private static final String FOURTH_GROUP = "4";
    private static final String FIFTH_GROUP = "5";
    private static final String SIXTH_GROUP = "6";
    private static final String SEVENTH_GROUP = "7";
    private static final String EIGHTH_GROUP = "8";
    private static final String NINTH_GROUP = "9";
    private EmailAccountPage emailAccountPage;
    private EmailMessage emailMessage;


    @BeforeClass
    public void initEmailAccountPage() {
        emailAccountPage = new EmailAccountPage(driver);
        emailMessage = new EmailMessage(pm.getProperty("to"));
    }


    @Test(dependsOnGroups = SECOND_GROUP, groups = THIRD_GROUP)
    public void composeNewMsgTest() {
        emailAccountPage.composeNewMsg(emailMessage);
    }

    @Test(dependsOnGroups = THIRD_GROUP, groups = FOURTH_GROUP)
    public void cancelBtnClickTest() {
        emailAccountPage.cancelComposeMsg();
    }

    @Test(dependsOnGroups = FIRST_GROUP, groups = SECOND_GROUP)
    public void openDraftsTest() {
        emailAccountPage.openDrafts();
    }

    @Test(dependsOnGroups = FOURTH_GROUP, groups = FIFTH_GROUP)
    public void saveToDraftsBtnClickTest() {
        emailAccountPage.saveToDrafts();
    }

    @Test(dependsOnGroups = FIFTH_GROUP, groups = SIXTH_GROUP)
    public void checkMsgIsInDrafts() {
        Assert.assertTrue(emailAccountPage.isMsgPresent(emailMessage));
    }

    @Test(dependsOnGroups = FIFTH_GROUP)
    public void msgIntegrityCheckTest() throws CorruptedMsgException {
        emailAccountPage.checkMsgIntegrity(emailMessage);
    }

    @Test(dependsOnGroups = SIXTH_GROUP, groups = SEVENTH_GROUP)
    public void openDraftClickTest() {
        emailAccountPage.openDraft();
    }

    @Test(dependsOnGroups = SEVENTH_GROUP, groups = EIGHTH_GROUP)
    public void sendBtnClickTest() {
        emailAccountPage.sendMsg();
    }

    @Test(dependsOnGroups = EIGHTH_GROUP, groups = NINTH_GROUP)
    public void openDraftsAfterSendMsgTest() {
        emailAccountPage.refresh();
        emailAccountPage.openDrafts();
    }

    @Test(dependsOnGroups = NINTH_GROUP)
    public void logoutTest() {
        emailAccountPage.logout();
    }
}
