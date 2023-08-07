package amazon_automation;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"nav-bb-logo\"]")
    private ExtendedWebElement siteLogo;
    @FindBy(css = "//*[text() = 'Clinic']")
    private ExtendedWebElement headerClinic;
    protected HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(siteLogo);
    }
    @Override
    public void open() {
        super.openURL("https://www.amazon.com/");
    }
    public String readLogo() {
        assertElementPresent(siteLogo);
        return siteLogo.getText();
    }
    public ClinicPage clickClinic() {
        headerClinic.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return new ClinicPage(driver);
    }
}
