package com.revature.steps;

import com.revature.pages.LoginPage;
import com.revature.runners.LoginRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Before
    public void setup() {
        LoginRunner.chromeDriver = new ChromeDriver();
        LoginRunner.chromeDriver.get(
          "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=4"
        );
        LoginRunner.page = new LoginPage(LoginRunner.chromeDriver);
    }

    @After
    public void cleanup() {
        LoginRunner.chromeDriver.quit();
    }

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        if (
                ! LoginRunner.page.validateURL() || ! (LoginRunner.page instanceof LoginPage)
        ) Assertions.fail("Driver was not on login page");
    }

    @When("^The employee types (?:in )?(.+?) into (?:the )?username input$")
    public void employeeTypesUsername(String username) {
        LoginRunner.page.sendKeys("usernameInput", username);
    }

    @When("^The employee types (?:in )?(.+?) into (?:the )?password input$")
    public void employeeTypesPassword(String password) {
        LoginRunner.page.sendKeys("passwordInput", password);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        LoginPage loginpage = (LoginPage)LoginRunner.page;
        LoginRunner.page = loginpage.login();
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        String text = LoginRunner.page.alertText();
        if (text.toLowerCase().contains("password")) Assertions.fail("alert contained a reference to a bad password");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        String text = LoginRunner.page.alertText();
        if (text.toLowerCase().contains("username")) Assertions.fail("alert contained a reference to a bad username");
    }

    @Then("^the employee should be on the (.+?) page$")
    public void theEmployeeShouldBeOn(String role) {
        String relurl = LoginRunner.page.getRelativeURL();
        Assertions.assertEquals(relurl,"/" + role.toLowerCase() + "home");
    }

    @Then("^The employee should see their name (.+?) on the home page$")
    public void theEmployeeSeesFullname(String fullName) {
        String text = LoginRunner.page.elements.get("greeting").getText();
        Assertions.assertTrue(text.contains(fullName));
    }

}
