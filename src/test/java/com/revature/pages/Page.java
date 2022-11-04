package com.revature.pages;

import com.revature.components.Component;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page implements Component {
    private WebDriver driver;
    private WebDriverWait wait;
    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(1000));
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public WebDriverWait getWait() {
        return wait;
    }

    @Override
    public String getDomain() {
        return "https://bugcatcher-jasdhir.coe.revaturelabs.com";
    }


}
