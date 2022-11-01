package com.revature.steps.navigation;

import com.revature.browser.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Steps {

    private static Page page;

    @Before
    public void setup() {
        page = new Page(new ChromeDriver());
        page.get(page.getLoginUrl());
    }

    @After
    public void cleanup() {
        page.quit();
    }

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        page.login("manager");
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("^The manager clicks on (.+)$")
    public void the_manager_clicks_on(String linktext) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("^The title of page should be (.+)$")
    public void the_title_of_page_should_be(String title) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The title of page should be Test Case Overivew")
    public void the_title_of_page_should_be_test_case_overivew() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
