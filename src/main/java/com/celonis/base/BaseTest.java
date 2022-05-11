package com.celonis.base;

import com.celonis.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static com.celonis.config.ConfigurationManager.configuration;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverManager.getDriver(configuration().browser());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(configuration().url());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
