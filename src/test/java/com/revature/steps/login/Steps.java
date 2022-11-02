package com.revature.steps.login;

import com.revature.browser.HomePage;
import com.revature.browser.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    // whenever we are on the loginpage we use the loginpage object
    // whenever we are on the homepage we use the homepage object
    private static WebDriver driver;
    private static LoginPage loginpage;
    private static HomePage homepage;


    @Before
    public void setup() {
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        driver.get(loginpage.getDomain() + "/?dev=4");
    }

    @After
    public void cleanup() {
        driver.quit();
    }

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        loginpage.validateURL();
    }

    @When("^The employee types (?:in )?(.+?) into (?:the )?username input$")
    public void employeeTypesUsername(String username) {

        loginpage.getUserNameInput().sendKeys(username);
    }

    @When("^The employee types (?:in )?(.+?) into (?:the )?password input$")
    public void employeeTypesPassword(String password) {

        loginpage.getPasswordInput().sendKeys(password);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        loginpage.getLoginButton().click();
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        String text = loginpage.getAlert().getText(); // should be static that calls on page
        if (text.toLowerCase().contains("password")) Assertions.fail("alert contained a reference to a bad password");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        String text = loginpage.getAlert().getText();
        if (text.toLowerCase().contains("username")) Assertions.fail("alert contained a reference to a bad username");
    }

    @Then("^the employee should be on the (.+?) page$")
    public void theEmployeeShouldBeOn(String role) {
        loginpage.getWait().until( driver -> {
            return homepage.validateHomeURL(role.toLowerCase());
        });
    }

    @Then("^The employee should see their name (.+?) on the home page$")
    public void theEmployeeSeesFullname(String fullName) {
        String text = homepage.getGreetingParagraph().getText();
        Assertions.assertTrue(text.contains(fullName));
    }

}
