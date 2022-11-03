package com.revature.pages;

import com.revature.components.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page implements Component {
    private WebDriver driver;
    private WebDriverWait wait;
    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(100));
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
    public void awaitURL() {
        getWait().until(driver -> {
           return validateURL();
        });
    }
    public boolean validateURL(String url) {
        return url.contains(getDomain());
    }
    public boolean validateURL() {
        return validateURL(getDriver().getCurrentUrl());
    }

}
