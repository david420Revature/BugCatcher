package com.revature.runners;

import com.revature.pages.Page;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/login", glue = "com.revature.steps")
public class LoginRunner {
    public static WebDriver chromeDriver;
    public static Page page;
}
