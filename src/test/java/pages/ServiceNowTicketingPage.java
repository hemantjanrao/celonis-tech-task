package pages;

import com.celonis.base.BasePage;
import com.celonis.util.WebUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class ServiceNowTicketingPage extends BasePage {

    private final WebDriver driver;

    protected ServiceNowTicketingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = "div[process-model='processGraph.model']")
    private WebElement processGraph;

    @FindBy(css = "div[ce-process-panel]")
    private WebElement processPanel;

    @FindBy(css = "div[title='Settings']")
    private WebElement settingsControl;

    @FindBy(css = "div.pe-zoom-controls")
    private WebElement zoomControls;

    @FindBy(css = "div.pe-standalone__control--activities")
    private WebElement activitiesControl;

    @FindBy(css = "div.pe-standalone__control--connections")
    private WebElement connectionsControl;

    @Override
    @Step("Is page loaded?")
    public boolean isLoaded() {
        return WebUtil.isDisplayed(driver, processGraph);
    }

    @Override
    @Step("Presence of all the elements on the page")
    public boolean isPageElementsLoaded() {
        ArrayList<WebElement> elementsList = new ArrayList<>();
        elementsList.add(processGraph);
        elementsList.add(processPanel);
        elementsList.add(connectionsControl);
        elementsList.add(settingsControl);
        elementsList.add(zoomControls);
        elementsList.add(activitiesControl);

        return WebUtil.verifyElements(elementsList);
    }
}
