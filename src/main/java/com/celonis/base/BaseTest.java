package com.celonis.base;

import com.celonis.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

import static com.celonis.config.ConfigurationManager.configuration;

public abstract class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp( Method testMethod){
        logger.info(String.format("=============== Test [ %s ] started ===============", testMethod.getName()));

        driver = DriverManager.getDriver(configuration().browser());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configuration().timeout()));

        driver.get(configuration().url());
        logger.info(String.format("Navigating to URL = [ %s ]", configuration().url()));

        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method testMethod, ITestResult result){

        if(ITestResult.FAILURE==result.getStatus()){
            captureScreenshot(driver);
        }

        logger.info(String.format("=============== Test [ %s ] finished ===============", testMethod.getName()));
        driver.quit();
    }

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public byte[] captureScreenshot(WebDriver d) {
        return ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
    }
}
