package com.revature.browser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Component {
    WebDriver getDriver();
    WebDriverWait getWait();
    default Alert getAlert() {
        return getWait().until(ExpectedConditions.alertIsPresent());
    }
}
