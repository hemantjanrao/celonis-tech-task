package tests;

import com.celonis.base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest extends BaseTest {
    @Test(description = "Verify valid user login")
    public void validLogin(){

        final String validEmail = "hemantjanrao@gmail.com";
        final String validPassword = "@Test1234";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        assertThat(loginPage.isLoaded()).isTrue();

        loginPage.login(validEmail, validPassword);
        assertThat(homePage.isLoaded()).isTrue();
    }

    @Test(description = "Verify invalid user login")
    public void invalidLogin(){
        final String invalidEmail = "wrong@gmail.com";
        final String validPassword = "@Test1234";

        LoginPage loginPage = new LoginPage(driver);

        assertThat(loginPage.isLoaded()).isTrue();

        loginPage.login(invalidEmail, validPassword);
        assertThat(loginPage.getValidationMessage()).isEqualTo("Email or password are incorrect.");
    }
}

