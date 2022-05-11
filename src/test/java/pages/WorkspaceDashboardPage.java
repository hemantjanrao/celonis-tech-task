package pages;

import com.celonis.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspaceDashboardPage extends BasePage {

    public WorkspaceDashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Is page loaded?")
    public boolean isLoaded() {
        return sidebar.isDisplayed();
    }

    @FindBy(css = "workspaces-sidebar .ce-burger-content")
    private WebElement sidebar;

    @FindBy(css = "workspace-section.workspaces__section")
    private WebElement workspaceSection;

    @FindBy(xpath = "//a[starts-with(@data-testing-uid,'analysisListComponent-analysisName')]")
    private WebElement analysisName;

    @Step("Navigate to the workspace")
    public void navigateTo(String workspaceName){
        By workspacesLocator = By.xpath(String.format("//a[contains(@title, '%s')]", workspaceName));
        WebElement workspace = sidebar.findElements(workspacesLocator).get(0);
        workspace.click();
    }

    @Step("Is analysis workspace loaded?")
    public boolean isAnalysisWorkspaceLoaded(String workspaceName){
        String workspaceLocator = String.format("//h3[contains(text(), '%s')]", workspaceName);
        return workspaceSection.findElement(By.xpath(workspaceLocator)).isDisplayed();
    }

    @Step("Open analysis")
    public void openAnalysis(){
        analysisName.click();
    }
}
