package com.revature.steps.manual;

import com.revature.browser.*;
import com.revature.runners.Manual;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    private static LoginPage loginpage;
    private static WebDriver driver;

    private static Manual gui;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        gui = new Manual(driver);
        loginpage = new LoginPage(driver);

        driver.get(loginpage.getURL());
    }

    @After
    public void cleanup() {
        driver.quit();
    }

    // @When() @Then() are also matched by @Given()
    @Given("^(.+)$")
    public void manuall(String prompt) {
        gui.prompt(prompt, "failed: " + prompt);
    }

}
