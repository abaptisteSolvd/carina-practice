package amazon_automation;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTests implements IAbstractTest {
    @Test
    @MethodOwner(owner = "andre")
    @TestPriority(Priority.P3)
    public void testOpenHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertEquals(homePage.readLogo(), "Amazon");

    }

    @Test
    @MethodOwner(owner = "andre")
    @TestPriority(Priority.P3)
    public void testOpenClinicPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ClinicPage clinicPage = homePage.clickClinic();
        Assert.assertTrue(clinicPage.isPageOpened(), "Clinic page is not opened");
        Assert.assertEquals(clinicPage.readCovidOption(), "POSITIVE TEST REQUIRED");

    }
}
