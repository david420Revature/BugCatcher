package com.revature.steps.manual;

import com.revature.pages.*;
import com.revature.runners.ManualRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    private static LoginPage loginpage;
    private static WebDriver driver;

    private static ManualRunner gui;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        gui = new ManualRunner(driver);
        loginpage = new LoginPage(driver);

        driver.get(loginpage.getURL());
    }

    @After
    public void cleanup() {
        driver.quit();
    }

    // @When() @Then() are also matched by @Given()
    @Given("^([^$]+)$")
    public void manual(String prompt) {
        gui.prompt(prompt);
    }


}
