package com.revature.steps.defect;

import com.revature.browser.*;
import com.revature.runners.Defect;
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

    private static Defect gui;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        gui = new Defect(driver);
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

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        gui.prompt(
                "The manager is logged in as a manager",
                "The manager was not logged in as a manager"
        );
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        gui.prompt(
                "The manager is on the home page",
                "The manager was not on the home page"
        );
    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        gui.prompt(
                "The manager should see pending defects",
                "The manager did not see pending defects"
        );
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        gui.prompt(
                "The manager clicks on the select button for a defect",
                "The manager could not click on the select button for a defect"
        );
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        gui.prompt(
                "The defect description should appear in bold",
                "The defect description did not appear in bold"
        );
    }
    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {
        gui.prompt(
                "The manager selects an tester from the drop down",
                "The manager could not select an tester from the drop down"
        );
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        gui.prompt(
          "The manager clicks assign",
                "The manager could not click assign"
        );
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        gui.prompt(
                "The defect should disappear from the list",
                "The defect did not disappear from the list"
        );
    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() {
        gui.prompt(
"The assigned tester is on their home page",
    "The assigned tester was not on their home page"
        );
    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        gui.prompt(
"The tester should see the pending defect",
    "The tester could not see the pending defect"
        );
    }
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() {
        gui.prompt(
"The tester is on the Home Page",
 "The test was not on the Home Page"
        );
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        gui.prompt(
"The tester can can see only defects assigned to them",
"The tester could see defects that were not assigned to them"
        );
    }
    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        gui.prompt(
"The tester changes to defect to any status",
    "The tester could not changes to defect to any status"
        );
    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        gui.prompt(
"The tester should see the defect has a different status",
"The tester could not see that the defect had a different status"
        );
    }
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() {
        gui.prompt(
          "The employee is on the Defect Reporter Page",
          "The employee was not on the Defect Reporter Page"
        );
    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        gui.prompt(
                "The employee selects todays date",
                "The employee could not select todays date"
        );
    }
    @When("The employee types in {string} with")
    public void the_employee_types_in_with(String string, String docString) {
        gui.prompt(
"The employee types in {string} with "
                + " " + string
                + " " + docString,
    "The employee could not type in {string} with "
                        + " " + string
                        + " " + docString
        );
    }
    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
        gui.prompt(
"The employee selects high priority",
    "The employee could not high priority"
        );
    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        gui.prompt(
          "The employee selects low severity",
          "The employee could not select low severity"
        );
    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        gui.prompt(
"The employee clicks the report button",
"The employee could not click the report button"
        );
    }
    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        gui.prompt(
"No confirmation dialog appears",
    "A confirmation dialog appeared"
        );
    }
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        gui.prompt(
"There should be a confirmation box",
    "There was not a confirmation box"
        );
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        gui.prompt(
"The employee clicks Ok",
    "The employee could not clicks Ok"
        );
    }
    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        gui.prompt(
"A modal should appear with a Defect ID",
    "A modal did not appear with a Defect ID"
        );
    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        gui.prompt(
"The employee clicks close",
    "The employee could not clicks close"
        );
    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        gui.prompt(
"The modal should disappear",
"The modal did not disappear"
        );
    }



}
