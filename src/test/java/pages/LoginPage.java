package pages;

import com.celonis.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    @Step("Is page loaded?")
    public boolean isLoaded() {
        return btnSignIn.isDisplayed();
    }

    @FindBy(id = "ce-input-0")
    private WebElement inputEmail;

    @FindBy(id = "ce-input-1")
    private WebElement inputPassword;

    @FindBy(css = "button[data-testing-uid = 'login-form-submit-button']")
    private WebElement btnSignIn;

    @FindBy(css = "span.ce-validation__hint")
    private WebElement lblValidationMessage;

    @Step("Login to application")
    public void login(String email, String password){
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        btnSignIn.click();
    }

    @Step("Get validation message")
    public String getValidationMessage(){
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOf(lblValidationMessage));
        return lblValidationMessage.getText();
    }

}
