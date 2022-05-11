package com.celonis.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public enum BrowserFactory {
    CHROME{
        @Override
        public WebDriver createDriver() {
            return WebDriverManager.getInstance(DriverManagerType.CHROME).create();
        }
    },
    FIREFOX{
        @Override
        public WebDriver createDriver() {
            return WebDriverManager.getInstance(DriverManagerType.FIREFOX).create();
        }
    };
    public abstract WebDriver createDriver();
}
