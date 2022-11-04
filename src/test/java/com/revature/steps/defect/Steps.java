package com.revature.steps.defect;

import com.revature.customs.*;
import com.revature.doms.Defect;
import com.revature.pages.*;
import com.revature.doms.Account;
import com.revature.runners.DefectRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
    // these should probably be declared with the runner somehow
    private static PendingDefect pendingDefect;
    private static PendingDefectsTable pendingDefectsTable;
    private static Page page;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static DefectReportPage defectReportPage;
    private static WebDriver driver;
    private static Account manager;
    private static Account tester;

    private static DefectAssigner defectAssigner;
    private static MyDefects myDefects;
    private static CollapsibleDefect collapsibleDefect;
    private static String defectID;
    private static String defectStatus;
    private static DefectReportForm defectReportForm;
    private static DefectReportAlert confirmationAlert;
    private static DefectReportDialog confirmationDialog;

    @Before
    public void setup() {
        tester = Account.getAccountOfRole("tester");
        manager = Account.getAccountOfRole("manager");
        driver = new ChromeDriver();
        page = new Page(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        defectReportPage = new DefectReportPage(driver);
        driver.get(loginPage.getURL());
    }

    @After
    public void cleanup() {
        driver.quit();
    }

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        manager.login(loginPage, homePage);
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        homePage.validateURL();
    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        pendingDefectsTable = homePage.getPendingDefectsTableElement();
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        pendingDefect = pendingDefectsTable.getPendingDefects().get(0);
        defectID = pendingDefect.getID();
        defectAssigner = pendingDefect.select();
        Assertions.assertTrue(defectAssigner.isDisplayed());
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        Assertions.assertTrue(
            pendingDefect.getDescription().getText().equals(
                    defectAssigner.getMessage().getText()
            )
        );
        Assertions.assertTrue(
          defectAssigner.getMessage().getCssValue(
                  "font-weight"
          ).equals("700")
        );
    }
    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {
        defectAssigner.select(0);
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        defectAssigner.assign();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        try {
            pendingDefect.isDisplayed();
            throw new AssertionError("Pending defect is still displayed");
        }
        catch (StaleElementReferenceException e) {}
    }
    @Given("^The (?:assigned )?tester is on the(?:ir)? [hH]ome [pP]age$")
    public void the_assigned_tester_is_on_their_home_page() {
        if (!homePage.validateHomeURL("tester")) {
            tester.login(loginPage, homePage);
        }
    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        myDefects = homePage.getMyDefectsElement();
        collapsibleDefect = myDefects.getDefect(defectID);
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        myDefects = homePage.getMyDefectsElement();
        for (CollapsibleDefect defect : myDefects.getDefects()) {
            String assignment = defect.getAssigned();
            Assertions.assertTrue(
                assignment.equals(tester.getUsername())
            );
        }
    }
    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        collapsibleDefect = myDefects.getDefects().get(0);
        defectStatus = collapsibleDefect.getStatus();
        defectStatus =
                defectStatus.equals(Defect.validStatuses[0]) ?
                Defect.validStatuses[1] :
                Defect.validStatuses[0];
        collapsibleDefect.setStatus(defectStatus);
    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        // because we set defectStatus to the new status, we can check for a match
        defectStatus.equals(collapsibleDefect.getStatus());
    }
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() {
        if (!defectReportPage.validateURL()) {
            if (loginPage.validateURL()) {
                manager.login(loginPage, homePage);
                homePage.clink("Report a Defect"); // could use method
            }
            else {
                throw new Error("unimplemented");
            }
        }
        // setting this up whenever we go to this page
        defectReportForm = defectReportPage.getDefectReportForm();
    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        defectReportForm.setToday();
    }
    @When("The employee types in {string} with")
    public void the_employee_types_in_with(String string, String docString) {
        if (string.equals("Description")) {
            defectReportForm.setDescription(docString);
        }
        else if (string.equals("Steps")){
            defectReportForm.setReproductionSteps(docString);
        }
        else {
            throw new Error(string + " prompt not known");
        }
    }
    @When("^The employee selects (\\w+) priority$")
    public void the_employee_selects_priority(String priority) {
        defectReportForm.setPriority(priority);
    }
    @When("^The employee selects (\\w+) severity$")
    public void the_employee_selects_severity(String severity) {
        defectReportForm.setSeverity(severity);
    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        defectReportForm.getReportButton().click();
    }
    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        try {
            defectReportPage.getDriver().switchTo().alert();
            Assertions.fail("a confirmation dialog appeared");
        }
        catch(NoAlertPresentException e) {}
    }
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        Alert alert = defectReportPage.getAlert();
        confirmationAlert = new DefectReportAlert(alert, defectReportPage);
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        confirmationDialog = confirmationAlert.ok();
    }
    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        Assertions.assertTrue(
                confirmationDialog.getID().length() > 0,
                "No ID was present"
        );
    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        confirmationDialog.close();
    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        try {
            page.getAlert();
            Assertions.fail("alert still exists");
        }
        catch (TimeoutException e) {}
    }



}
