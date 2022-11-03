package com.revature.steps.navigation;

import com.revature.pages.*;
import com.revature.pages.doms.Account;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Steps {
    // these should probably be declared with the runner somehow
    private static Page page;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static MatrixPage matrixPage;
    private static TestCasesPage testCasesPage;
    private static DefectReportPage defectReportPage;
    private static DefectOverviewPage defectOverviewPage;
    private static WebDriver driver;
    private static Account manager;
    private static Account tester;

    @Before
    public void setup() {
        manager = Account.getAccountOfRole("manager");
        driver = new ChromeDriver();
        page = new Page(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        matrixPage = new MatrixPage(driver);
        testCasesPage = new TestCasesPage(driver);
        defectReportPage = new DefectReportPage(driver);
        defectOverviewPage = new DefectOverviewPage(driver);
        driver.get(loginPage.getURL());
    }

    @After
    public void cleanup() {
        driver.quit();
    }

    @Given("/The manager is logged in as a (\\w+)/")
    public void the_manager_is_logged_in_as_a(String role) {
        manager.login(loginPage, homePage);
    }
    @Given("/The (\\w+) is on the home page/")
    public void the_manager_is_on_the_home_page(String role) {
        homePage.validateHomeURL(role.toLowerCase()); // would be nice to have an enum of roles
    }
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        ArrayList<Page> pages = new ArrayList<>();
        Collections.addAll(
            pages,
            matrixPage,
            testCasesPage,
            defectReportPage,
            defectOverviewPage
        );

        List<WebElement> anchors = homePage.getHeaderAnchors();
        pages.forEach(page -> {
            boolean match = anchors.stream().anyMatch(anchor -> {
                String href = anchor.getAttribute("href");
                boolean result = page.validateURL(href);
                return result;
            });
            if (!match) throw new AssertionError("Unable to find an expected nav link");
        });
    }
    @When("^The manager clicks on (.+)$")
    public void the_manager_clicks_on(String linktext) {
        homePage.clink(linktext);
    }
    @Then("^The title of (?:the )?page should be (.+)$")
    public void the_title_of_the_page_should_be(String expectedTitle) {
        // maybe I should build from a page class
        String actualTitle = homePage.getTitle();
        if (! expectedTitle.equals(actualTitle)) {
            throw new AssertionError(actualTitle + " page title did not match " + expectedTitle);
        }
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        page.back();
    }

    @Then("^The manager should be on the home page and the title of page is (\\w+)$")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is(String title) {
        Assertions.assertTrue(homePage.validateURL(), "manager was not on homepage");
        Assertions.assertTrue(driver.getTitle().equals(title));
    }

}
