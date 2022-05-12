package com.celonis.pages;

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
    private WebElement processMap;

    @FindBy(css = "g.canvas")
    private WebElement baseLineGraph;

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

    @FindBy(css = "div[title='KPIs']")
    private WebElement kpiIcon;

    @FindBy(css = "div[title='Grouping']")
    private WebElement groupingIcon;

    @FindBy(css = "div[title='Hide activity']")
    private WebElement hideActivityIcon;

    @Override
    @Step("Is page loaded?")
    public boolean isLoaded() {
        return WebUtil.isDisplayed(driver, baseLineGraph);
    }

    @Override
    @Step("Presence of all the elements on the page")
    public boolean isPageElementsLoaded() {
        ArrayList<WebElement> elementsList = new ArrayList<>();
        elementsList.add(processMap);
        elementsList.add(baseLineGraph);
        elementsList.add(processPanel);
        elementsList.add(settingsControl);
        elementsList.add(zoomControls);
        elementsList.add(activitiesControl);
        elementsList.add(connectionsControl);
        elementsList.add(kpiIcon);
        elementsList.add(groupingIcon);
        elementsList.add(hideActivityIcon);

        return WebUtil.verifyElements(elementsList);
    }
}
