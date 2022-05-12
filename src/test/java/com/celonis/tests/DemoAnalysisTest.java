package com.celonis.tests;

import com.celonis.base.BasePage;
import com.celonis.base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.celonis.pages.HomePage;
import com.celonis.pages.LoginPage;
import com.celonis.pages.WorkspaceDashboardPage;
import com.celonis.pages.WorkspaceFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoAnalysisTest extends BaseTest {

    @Test(description = "Verify analysis pages", dataProvider = "get workspace data")
    public void analysisElementsTest(String workspace){

        final String email = "hemantjanrao@gmail.com";
        final String password = "@Test1234";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        WorkspaceDashboardPage workspaceDashboardPage = new WorkspaceDashboardPage(driver);

        BasePage page = WorkspaceFactory.get(workspace, driver);

        loginPage.login(email, password);
        assertThat(homePage.isLoaded()).isTrue();

        homePage.navigateToProcessAnalytics();
        workspaceDashboardPage.navigateTo(workspace);
        assertThat(workspaceDashboardPage.isAnalysisWorkspaceLoaded(workspace)).isTrue();

        workspaceDashboardPage.openAnalysis();
        assertThat(page.isLoaded()).isTrue();
        assertThat(page.isPageElementsLoaded()).isTrue();
    }

    @DataProvider (name = "get workspace data")
    public Object[][] dataProvider() {
        return new Object [][] {
                {"Order to Cash"}, {"Purchase to Pay"}, {"ServiceNow Ticketing"}
        };
    }
}