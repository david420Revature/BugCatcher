package com.revature.steps.testcases;

import com.revature.browser.*;
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
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The tester types {string} into input with")
    public void the_tester_types_into_input_with(String string, String docString) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("^The tester presses the (\\w+) button$")
    public void the_tester_presses_the_button(String buttonName) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("the tester is on the test case editor for a specific test case")
    public void the_tester_is_on_the_test_case_editor_for_a_specific_test_case() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The tester selects ryeGuy for performed from drop down")
    public void the_tester_selects_rye_guy_for_performed_from_drop_down() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The tester selects FAIL for test result from drop down")
    public void the_tester_selects_fail_for_test_result_from_drop_down() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The tester types in a new summary into the summary text area")
    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
