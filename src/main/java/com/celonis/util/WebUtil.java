package com.celonis.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.celonis.config.ConfigurationManager.configuration;

public class WebUtil {

    private static final Logger logger = LogManager.getLogger(WebUtil.class);

    private WebUtil() {
    }

    public static void waitForElementDisplay(WebDriver driver, WebElement element, long timeOut){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            logger.error(String.format("Element not displayed after %d seconds", timeOut));
            logger.error(String.format("Exception : %s", e));
        }
    }

    public static boolean isDisplayed(WebDriver driver, WebElement element) {
        waitForElementDisplay(driver, element, configuration().timeout());
        return element.isDisplayed();
    }

    public static boolean verifyElements(List<WebElement> list){
        ArrayList<WebElement> checkElements = new ArrayList<>();
        for(WebElement element: list){
            try{
                element.isDisplayed();
            } catch (NotFoundException e){
                checkElements.add(element);
                logger.error(e);
            }
        }
        if(!checkElements.isEmpty()){
            logger.error(String.format("Elements not displayed are: %s", checkElements));
            return false;
        }
        return true;
    }
}
