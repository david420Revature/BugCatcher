package com.revature.steps.defect;

import com.revature.pages.LoginPage;
import com.revature.runners.DefectRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefectTest {
    @Before
    public void setup() {
        // setup manager
        DefectRunner.managerDriver = new ChromeDriver();
        DefectRunner.managerDriver.get(
                "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=4"
        );
        DefectRunner.managerPage = new LoginPage(DefectRunner.managerDriver);
        DefectRunner.managerPage = ((LoginPage)DefectRunner.managerPage).login("g8tor", "chomp!");

        // setup tester
        DefectRunner.testerDriver = new ChromeDriver();
        DefectRunner.testerDriver.get(
                "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=4"
        );
        DefectRunner.testerPage = new LoginPage(DefectRunner.testerDriver);
        DefectRunner.testerPage = ((LoginPage)DefectRunner.testerPage).login("ryeGuy", "coolbeans");

        // setup employee
        DefectRunner.employeeDriver = new ChromeDriver();
        DefectRunner.employeeDriver.get(
                "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=4"
        );
        DefectRunner.employeePage = new LoginPage(DefectRunner.employeeDriver);
        DefectRunner.employeePage = ((LoginPage)DefectRunner.employeePage).login("cavalier89", "alucard");

    }

    @After
    public void cleanup() {
        DefectRunner.managerDriver.quit();
        DefectRunner.testerDriver.quit();
        DefectRunner.employeeDriver.quit();
    }

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
