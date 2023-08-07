package amazon_automation;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ClinicPage extends AbstractPage {
    @FindBy(xpath = "")
    private ExtendedWebElement covidButton;

    protected ClinicPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(covidButton);
    }
    public String readCovidOption() {
        assertElementPresent(covidButton);
        return covidButton.getText();
    }
}
