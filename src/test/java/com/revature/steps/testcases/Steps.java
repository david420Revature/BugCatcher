package com.revature.steps.testcases;

import com.revature.customs.TestCaseReportDialog;
import com.revature.customs.TestCaseRow;
import com.revature.customs.TestCaseSubmitalForm;
import com.revature.customs.TestCaseTable;
import com.revature.doms.Account;
import com.revature.pages.*;
import com.revature.runners.TestCasesRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    private static TestCasesRunner gui;
    private static Account tester;
    private static TestCaseSubmitalForm testCaseForm;
    private static TestCaseTable testCaseTable;
    private static TestCaseRow testCase;
    private static TestCaseReportDialog dialog;
    private static CaseEditorPage caseEditorPage;


    @Before
    public void setup() {
        driver = new ChromeDriver();
        gui = new TestCasesRunner(driver);
        page = new Page(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        matrixPage = new MatrixPage(driver);
        testCasesPage = new TestCasesPage(driver);
        defectReportPage = new DefectReportPage(driver);
        defectOverviewPage = new DefectOverviewPage(driver);
        caseEditorPage = new CaseEditorPage(driver);
        driver.get(loginPage.getURL());
        tester = Account.getAccountOfRole("tester");
    }

    @After
    public void cleanup() {
        driver.quit();
    }

    @Given("The tester is on the test case dashboard")
    public void goToDashboard() {
        if (loginPage.validateURL()) {
            tester.login(loginPage, homePage);
            homePage.clink("Test Cases");
        }
        testCasesPage.validateURL();
        testCaseTable = testCasesPage.getTestCaseTable();
        testCaseForm = testCasesPage.getTestCaseSubmitalForm(testCaseTable);
        // because a feature calls for a testcase without a selection step
        List<TestCaseRow> rows = testCaseTable.getRows();
        // grabbing the test case created in the previous scenario
        testCase = rows.get(rows.size() - 1);
    }
    @When("The tester types {string} into input with")
    public void the_tester_types_into_input_with(String fieldDescription, String docString) {
        if (fieldDescription.equals("Description")) {
            testCaseForm.setDescription(docString);
        }
        else if (fieldDescription.equals("Steps")) {
            testCaseForm.setSteps(docString);
        }
        else {
            throw new Error("Unable to understand field description");
        }
    }
    @When("^The tester presses the (\\w+) button$")
    public void the_tester_presses_the_button(String buttonName) {
        if (buttonName.equals("submit")) {
            List<TestCaseRow> rows = testCaseTable.getRows();
            int last = rows.size() - 1;
            testCase = testCaseTable.getRows().get(last);
            assert testCase.equals(testCaseTable.getRows().get(last));
            testCaseForm.submit();
        }
        else throw new Error("Unable to find button with name: " + buttonName);

    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        TestCaseRow staleCase = testCase;
        List<TestCaseRow> rows = testCaseTable.getRows();
        int last = rows.size() - 1;
        testCase = rows.get(last);
        Assertions.assertNotEquals(staleCase, testCase);
    }
    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        testCase.getResult().equals("UNEXECUTED");
    }
    @When("^The tester (?:presses|clicks) on details$")
    public void the_tester_presses_on_details() {
        dialog = testCase.getDetails();
    }
    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        Assertions.assertTrue(
                dialog.getID().length() > 0,
                "dialog was missing testcase id"
        );
    }
    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        Assertions.assertEquals(
                dialog.getPerformedBy(),
                "No One"
        );
    }
    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        dialog.close();
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        Assertions.assertTrue(!dialog.isDisplayed(), "dialog was still open");
    }
    @Given("the tester is on the test case editor for a specific test case")
    public void goToCaseEditorForSpecificCase() {
        if (caseEditorPage.validateURL()) {
          page.back();
        }
        goToDashboard();
        String id = testCase.getID();
        testCase.getDetails().editCase();
        caseEditorPage.getID().equals(id);
    }
    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {
        gui.prompt(
                "The fields should be uneditable",
                "The fields were not uneditable"
        );
    }
    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() {
        gui.prompt(
"The test case fields should be editable",
    "The test case fields were editable"
        );
    }
    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() {
        gui.prompt(
"The tester types in a new description into the description text area",
"The tester could not type in a new description into the description text area"
        );
    }
    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() {
        gui.prompt(
"The tester types in a new steps into the steps text area",
"The tester could not type in a new steps into the steps text area"
        );
    }
    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        gui.prompt(
"The tester clicks on the automated check mark",
"The tester could not click on the automated check mark"
        );
    }
    @When("The tester selects ryeGuy for performed from drop down")
    public void the_tester_selects_rye_guy_for_performed_from_drop_down() {
        gui.prompt(
"The tester selects ryeGuy for performed from drop down",
    "The tester could not select ryeGuy for performed from drop down"
        );
    }
    @When("The tester selects FAIL for test result from drop down")
    public void the_tester_selects_fail_for_test_result_from_drop_down() {
        gui.prompt(
"The tester selects FAIL for test result from drop down",
"The tester could not select FAIL for test result from drop down"
        );
    }
    @When("The tester types in a new summary into the summary text area")
    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() {
        gui.prompt(
"The tester types in a new summary into the summary text area",
"The tester could not type in a new summary into the summary text area"
        );
    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        gui.prompt(
"The fields should be populated to their old values",
"The fields were not populated to their old values"
        );
    }
    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
        dialog.editCase();
    }
    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        goToCaseEditorForSpecificCase();
    }
    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {
        gui.prompt("The tester clicks on the edit button");
    }
    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() {
       gui.prompt("The tester clicks save on test case page");
    }
    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        gui.prompt("A confirmation prompt should appear");
    }
    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
        gui.prompt("The tester clicks on Ok");
    }
    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() {
        gui.prompt("An alert says the test case has been saved");
    }
    @When("The Tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button_again() {
        gui.prompt("The Tester clicks on the edit button");
    }
    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {
        gui.prompt("The tester clicks on the reset button");
    }



}
