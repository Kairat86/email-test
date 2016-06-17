package testng.page;

import com.epam.doshekenov.exception.CorruptedMsgException;
import com.epam.doshekenov.model.EmailMessage;
import com.epam.doshekenov.page.EmailAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
    public static final String TENTH_GROUP = "10";
    public static final String ELEVENTH_GROUP = "11";
    public static final String TWELFTH_GROUP = "12";
    private EmailAccountPage emailAccountPage;
    private EmailMessage emailMessage;


    @BeforeClass
    public void initEmailAccountPage() {
        emailAccountPage = new EmailAccountPage(driver);
        emailMessage = new EmailMessage(pm.getProperty("to"));
    }


    @Test(dependsOnGroups = FIRST_GROUP, groups = SECOND_GROUP)
    public void checkMsgIsInDrafts() {
        emailAccountPage.openDrafts();
        emailAccountPage.composeNewMsg(emailMessage);
        emailAccountPage.cancelComposeMsg();
        emailAccountPage.saveToDrafts();
        Assert.assertTrue(emailAccountPage.isMsgPresentInDrafts(emailMessage));
    }

    @Test(dependsOnGroups = SECOND_GROUP,groups = THIRD_GROUP)
    public void msgIntegrityCheckTest() throws CorruptedMsgException {
        emailAccountPage.checkMsgIntegrity(emailMessage);
    }


    @Test(dependsOnGroups = THIRD_GROUP, groups = FOURTH_GROUP)
    public void checkMsgIsNotInDrafts() {
        emailAccountPage.openDraft();
        emailAccountPage.sendMsg();
        emailAccountPage.refresh();
        emailAccountPage.openDrafts();
        Assert.assertFalse(emailAccountPage.isMsgPresentInDrafts(emailMessage));
    }



    @Test(dependsOnGroups = FOURTH_GROUP, groups = FIFTH_GROUP)
    public void checkMsgIsInSentMsgsListTest() {
        emailAccountPage.openSentMessages();
        emailAccountPage.refresh();
        emailAccountPage.composeNewMsg(emailMessage);
        emailAccountPage.cancelComposeMsg();
        emailAccountPage.saveToDrafts();
        emailAccountPage.openSentMessages();
        Assert.assertTrue(emailAccountPage.isMsgPresentInSent(emailMessage));
    }

    @Test(dependsOnGroups = FIFTH_GROUP)
    public void logoutTest() {
        emailAccountPage.logout();
    }
}
