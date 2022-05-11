package com.celonis.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private  DriverManager(){}

    public static WebDriver getDriver(String browser){
        return BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
    }
}
