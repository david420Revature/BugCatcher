package com.revature.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/defect", glue = "com.revature.steps.defect")
public class DefectRunner extends ManualRunner {}
