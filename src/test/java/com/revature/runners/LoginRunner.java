package com.revature.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/login", glue = "com.revature.steps.login")
public class LoginRunner implements Runner {
    public static String home = "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=4";
}
