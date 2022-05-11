package com.celonis.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.celonis.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class BasePage {
    protected BasePage(WebDriver driver) {
        initElements(new AjaxElementLocatorFactory(driver, configuration().timeout()), this);
    }

    public abstract boolean isLoaded();
}
