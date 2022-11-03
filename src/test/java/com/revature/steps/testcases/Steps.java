package com.revature.steps.testcases;

import com.revature.pages.*;
import com.revature.runners.TestCases;
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

    private static TestCases gui;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        gui = new TestCases(driver);
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

    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() {
        gui.prompt(
"The tester is on the test case dashboard",
                "The tester was not on the test case dashboard"
        );
    }
    @When("The tester types {string} into input with")
    public void the_tester_types_into_input_with(String string, String docString) {
        gui.prompt(
    "The tester types " +string + " into input with" + docString,
        "The tester could not type " +string + " into input with" + docString
        );
    }
    @When("^The tester presses the (\\w+) button$")
    public void the_tester_presses_the_button(String buttonName) {
        gui.prompt(
"The tester presses the " + buttonName + " button",
"The tester could not press the " + buttonName + " button"
        );
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        gui.prompt(
    "The test case should appear at the bottom of the table",
        "The test case did not appear at the bottom of the table"
        );
    }
    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        gui.prompt(
"The test case result should say UNEXECUTED",
    "The test case result did not say UNEXECUTED"
        );
    }
    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        gui.prompt(
    "The tester presses on details",
    "The tester could not press on details"
        );
    }
    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        gui.prompt(
"A test case modal should appear showing the case ID",
    "A test case modal did not appear showing the case ID"
        );
    }
    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        gui.prompt(
"The performed by field should say No One",
    "The performed by field did not say No One"
        );
    }
    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        gui.prompt(
"The tester presses the close buttton",
"The tester could not press the close button"
        );
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        gui.prompt(
          "The Modal should be closed",
          "The Modal did not close"
        );
    }
    @Given("the tester is on the test case editor for a specific test case")
    public void the_tester_is_on_the_test_case_editor_for_a_specific_test_case() {
        gui.prompt(
"the tester is on the test case editor for a specific test case",
"the tester was not on the test case editor for a specific test case"
        );
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
    @When("The tester clicks on details")
    public void the_tester_clicks_on_details() {
        gui.prompt(
"The tester clicks on details",
    "The tester could not click on details"
        );
    }
    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
        gui.prompt("The Tester clicks on edit within the modal");
    }
    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        gui.prompt("The Tester should be on the case editor for that case");
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
