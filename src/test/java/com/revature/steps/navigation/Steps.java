package com.revature.steps.navigation;

import com.revature.browser.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        if (!
                page.getCurrentUrl().equals(page.getDomain() + page.getHomeTrailer("manager"))
        ) throw new AssertionError("manager was not on the manager homepage");
    }
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {

        List<String> expecteds = new ArrayList<>();
        expecteds.add(page.getDomain() + page.getTestCaseTrailer());
        expecteds.add(page.getDomain() + page.getMatricesTrailer());
        expecteds.add(page.getDomain() + page.getDefectReporterTrailer());
        expecteds.add(page.getDomain() + page.getDefectOverviewTrailer());

        List<String> actuals = page.getAnchors().stream().map(anchor -> {
            return anchor.getAttribute("href");
        }).collect(Collectors.toList());

        expecteds.forEach(expected -> {
            boolean match = actuals.stream().anyMatch(actual -> actual.equals(expected));
            if (!match) throw new AssertionError("Unable to find " + expected);
        });
    }
    @When("^The manager clicks on (.+)$")
    public void the_manager_clicks_on(String linktext) {
        page.clink(linktext);
    }
    @Then("^The title of (?:the )?page should be (.+)$")
    public void the_title_of_the_page_should_be(String expectedTitle) {
        String actualTitle = page.getTitle();
        if (! expectedTitle.equals(actualTitle)) {
            throw new AssertionError(actualTitle + " page title did not match " + expectedTitle);
        }
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        page.back();
    }

    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException("Unimplemented due to poor step definition");
    }

}
