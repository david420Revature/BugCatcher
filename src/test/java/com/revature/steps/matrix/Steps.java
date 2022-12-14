package com.revature.steps.matrix;

import com.revature.doms.Account;
import com.revature.pages.*;
import com.revature.runners.MatrixRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    private static MatrixRunner gui;
    private static Account manager;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        gui = new MatrixRunner(driver);
        page = new Page(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        matrixPage = new MatrixPage(driver);
        testCasesPage = new TestCasesPage(driver);
        defectReportPage = new DefectReportPage(driver);
        defectOverviewPage = new DefectOverviewPage(driver);
        driver.get(loginPage.getURL());
        manager = Account.getAccountOfRole("manager");
        manager.login(loginPage, homePage);
    }

    @After
    public void cleanup() {
        driver.quit();
    }

    @Given("A manager is on their home page")
    public void a_manager_is_on_their_home_page() {
        homePage.validateHomeURL("manager");
    }
    @Then("A manager can pull up a form to make a new matrix")
    public void a_manager_can_pull_up_a_form_to_make_a_new_matrix() {
        gui.prompt(
"A manager can pull up a form to make a new matrix",
    "A manager could not pull up a form to make a new matrix"
        );
    }
    @When("A manager creates a title for a matrix")
    public void a_manager_creates_a_title_for_a_matrix() {
        gui.prompt(
"A manager creates a title for a matrix (remember for later)",
    "A manager could not a title for a matrix"
        );
    }
    @When("A manager adds requirements to a matrix")
    public void a_manager_adds_requirements_to_a_matrix() {
        gui.prompt(
"A manager adds requirements to a matrix",
    "A manager could not add requirements to a matrix"
        );
    }
    @When("A manager saves a matrix")
    public void a_manager_saves_a_matrix() {
        gui.prompt(
"A manager saves a matrix",
"A manager could not save a matrix"
        );
        // an alert is generated that needs to be dismissed
        try {
            page.getAlert().dismiss();
        }
        catch (Exception e) {
            // in case the user dismissed the alert
        }
    }
    @Then("The matrix should be visible for all testers and managers")
    public void the_matrix_should_be_visible_for_all_testers_and_managers() {
        // this prompt assumes we are on the matrices page
        homePage.clink("Matrices");
        gui.prompt(
            "Check that the matrix was created",
                "The tester could not find the created matrix"
        );
    }

    @Given("A manager or tester has selected a matrix")
    public void a_manager_or_tester_has_selected_a_matrix() {
        // this prompt assumes wer are on the Matrices page
        homePage.clink("Matrices");
        gui.prompt(
"A manager or tester has selected a matrix",
    "A manager or tester couldn't select a matrix"
        );
    }
    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() {
        gui.prompt(
"A manager or tester adds or removes defects",
    "A manager or tester was not able to add or remove defects"
        );
    }
    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_test_cases() {
        gui.prompt(
"A manager or tester adds or removes Test Cases",
    "A manager or tester could not add or remove Test Cases"
        );
    }
    @When("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() {
        gui.prompt(
"A manager or tester confirms their changes",
    "A manager or tester could not confirm their changes"
        );
        // an alert is generated that needs to be dismissed
        try {
            page.getAlert().dismiss();
        }
        catch (Exception e) {
            // in case the user dismissed the alert
        }
    }
    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        // because refreshing the page does not work
        matrixPage.clink("Home");
        homePage.clink("Matrices");
        gui.prompt(
"Then the matrix should be saved",
    "Thee matrix was not saved"
        );
    }

}
