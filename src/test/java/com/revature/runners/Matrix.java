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
@CucumberOptions(features = "classpath:features/matrix", glue = "com.revature.steps.matrix")
public class Matrix extends ManualRunner {

    private JFrame window;
    public JFrame getWindow() {
        return window;
    }
    public WebDriverWait getWait() {
        return wait;
    }
    public Matrix(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        window = new JFrame("Test");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(this);
        window.setLocation(120, 70);
        window.setSize(700, 200);
    }

    public void prompt(String promptMessage, String failMessage) {
        getWindow().setVisible(true);
        setText(promptMessage);
        getWait().until(driver -> {
            return ready();
        });
        getWindow().setVisible(false);
        if (getFail() || getStop()) Assertions.fail(failMessage);
    }

    public void prompt(String message) {
        prompt(message, "could not: " + message);
    }
}
