package com.celonis.pages;

import com.celonis.base.BasePage;
import com.celonis.util.WebUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".ce-main-layout__header")
    private WebElement headerLayout;

    @FindBy(css = "div.ce-app-switcher__more")
    private WebElement linkMore;

    @FindBy (css = "a[data-testing-uid='ceAppSwitcher-process-mining-link']")
    private WebElement linkProcessAnalytics;

    @Override
    @Step("Is page loaded?")
    public boolean isLoaded() {
        return WebUtil.isDisplayed(driver, headerLayout);
    }

    @Override
    public boolean isPageElementsLoaded() {
        return false;
    }

    @Step("Navigate to Process Analytics")
    public void navigateToProcessAnalytics(){
        linkMore.click();
        WebUtil.isDisplayed(driver, linkProcessAnalytics);
        linkProcessAnalytics.click();
    }
}
