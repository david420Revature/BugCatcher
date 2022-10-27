package com.revature.runners;

import com.revature.pages.Page;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/defect", glue = "com.revature.steps.defect")
public class DefectRunner {
    public static WebDriver managerDriver;
    public static Page managerPage;
    public static WebDriver testerDriver;
    public static Page testerPage;
    public static WebDriver employeeDriver;
    public static Page employeePage;
}