package com.celonis.pages;

import com.celonis.base.BasePage;
import com.celonis.util.WebUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderToCashPage extends BasePage {

    private final WebDriver driver;

    public OrderToCashPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = "div[data-testing-uid='content-sheet-analysis']")
    private WebElement contentSheetAnalysis;

    @Override
    @Step("Is page loaded?")
    public boolean isLoaded() {
        return WebUtil.isDisplayed(driver, contentSheetAnalysis);
    }

    @Override
    @Step("Presence of all the elements on the page")
    public boolean isPageElementsLoaded() {
        return WebUtil.isDisplayed(driver, contentSheetAnalysis);
    }
}
