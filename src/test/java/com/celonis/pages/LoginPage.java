package com.celonis.pages;

import com.celonis.base.BasePage;
import com.celonis.util.WebUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id = "ce-input-0")
    private WebElement inputEmail;

    @FindBy(id = "ce-input-1")
    private WebElement inputPassword;

    @FindBy(css = "button[data-testing-uid = 'login-form-submit-button']")
    private WebElement btnSignIn;

    @FindBy(css = "span.ce-validation__hint")
    private WebElement lblValidationMessage;

    @Override
    @Step("Is page loaded?")
    public boolean isLoaded() {
        return WebUtil.isDisplayed(driver, btnSignIn);
    }

    @Override
    @Step("Presence of all the elements on the page")
    public boolean isPageElementsLoaded() {
        return false;
    }

    @Step("Login to application")
    public void login(String email, String password){
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        btnSignIn.click();
    }

    @Step("Get validation message")
    public String getValidationMessage(){
        WebUtil.isDisplayed(driver, lblValidationMessage);
        return lblValidationMessage.getText();
    }
}
