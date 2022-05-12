package com.celonis.pages;

import com.celonis.base.BasePage;
import com.celonis.util.WebUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class PurchaseToPayPage extends BasePage {

    private final WebDriver driver;

    protected PurchaseToPayPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Most common path KPI locators
    private final String caseCountLocator = "//div[contains(@class,'tile__title') " +
            "and text()='Case count']//ancestor::div[@tile='kpiTile.tile']";

    private final String activitiesCountLocator = "//div[contains(@class,'tile__title') " +
            "and text()='Activities count']//ancestor::div[@tile='kpiTile.tile']";

    // Detected deviations locators
    private final String changePriceLocator = "//div[contains(@class,'tile__title') " +
            "and text()='Change Price']//ancestor::div[contains(@class,'activity-tile')]";

    private final String receiveOrderConfirmationLocator = "//div[contains(@class,'tile__title') " +
            "and text()='Receive Order Confirmation']//ancestor::div[contains(@class,'activity-tile')]";

    private final String blockPurchaseOrderLocator = "//div[contains(@class,'tile__title') " +
            "and text()='Block Purchase Order Item']//ancestor::div[contains(@class,'activity-tile')]";

    private final String dunOrderConfirmationLocator = "//div[contains(@class,'tile__title') " +
            "and text()='Dun Order Confirmation']//ancestor::div[contains(@class,'activity-tile')]";


    @FindBy(xpath = caseCountLocator)
    private WebElement caseCountTile;

    @FindBy(xpath = activitiesCountLocator)
    private WebElement activitiesCountTile;

    @FindBy(xpath = changePriceLocator)
    private WebElement changePriceActivityTile;

    @FindBy(xpath = receiveOrderConfirmationLocator)
    private WebElement receiveOrderActivityTile;

    @FindBy(xpath = blockPurchaseOrderLocator)
    private WebElement blockPurchaseOrderActivityTile;

    @FindBy(xpath = dunOrderConfirmationLocator)
    private WebElement dunOrderConfirmationActivityTile;

    @FindBy(css = "div[data='happyPathScanner.happyPathNodes']")
    private WebElement commonPath;

    @FindBy(css = ".fullscreen-app__headline:contains('Process AI')")
    private WebElement lblProcessAI;

    @Override
    @Step("Is page loaded?")
    public boolean isLoaded() {
        return WebUtil.isDisplayed(driver, caseCountTile);
    }

    @Override
    @Step("Presence of all the elements on the page")
    public boolean isPageElementsLoaded() {
        ArrayList<WebElement> elements = new ArrayList<>();
        elements.add(caseCountTile);
        elements.add(activitiesCountTile);
        elements.add(changePriceActivityTile);
        elements.add(receiveOrderActivityTile);
        elements.add(blockPurchaseOrderActivityTile);
        elements.add(commonPath);

        return WebUtil.verifyElements(elements);
    }
}
