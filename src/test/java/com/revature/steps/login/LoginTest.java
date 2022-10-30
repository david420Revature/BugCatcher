package com.revature.steps.login;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.Page;
import com.revature.runners.LoginRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collection;

public class LoginTest {

    private Page page;

    @Before
    public void setup() {
        page = new Page(new ChromeDriver());
        page.get(LoginRunner.home);
    }

    @After
    public void cleanup() {
        page.quit();
    }

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        String relurl = page.getRelativeURL();
        if (! page.getRelativeURL().equals("/")) Assertions.fail("Driver was not on login page");
    }

    @When("^The employee types (?:in )?(.+?) into (?:the )?username input$")
    public void employeeTypesUsername(String username) {
        LoginPage.usernameInput(page).sendKeys(username);
    }

    @When("^The employee types (?:in )?(.+?) into (?:the )?password input$")
    public void employeeTypesPassword(String password) {
        LoginPage.passwordInput(page).sendKeys(password);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        LoginPage.from(page).login();
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        String text = page.alertText();
        if (text.toLowerCase().contains("password")) Assertions.fail("alert contained a reference to a bad password");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        String text = page.alertText();
        if (text.toLowerCase().contains("username")) Assertions.fail("alert contained a reference to a bad username");
    }

    @Then("^the employee should be on the (.+?) page$")
    public void theEmployeeShouldBeOn(String role) {
        String relurl = page.getRelativeURL();
        Assertions.assertEquals(relurl,"/" + role.toLowerCase() + "home");
    }

    @Then("^The employee should see their name (.+?) on the home page$")
    public void theEmployeeSeesFullname(String fullName) {
        Collection<Cookie> list = page.cookies();
        System.out.println(list);
        String text = HomePage.greeting(page).getText();
        Assertions.assertTrue(text.contains(fullName));
    }

}
