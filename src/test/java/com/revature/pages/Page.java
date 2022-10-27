package com.revature.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Page {
    protected static Pattern urlPattern = Pattern.compile("(https?)://([^/]+)(/[^\\?#]*)?((?:\\?|#).*)?");
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
    public Map<String, WebElement> elements;

    public boolean validateURL() {
        return true;
    }

    public boolean validateURL(String ...args) {
        return true;
    }

    public String getProtocol() {
        Matcher matcher = urlPattern.matcher(driver.getCurrentUrl());
        matcher.find();
        String protocol = matcher.group(1);
        return protocol;
    }

    public String getFullDomainName() {
        Matcher matcher = urlPattern.matcher(driver.getCurrentUrl());
        matcher.find();
        String fullDomainName = matcher.group(2);
        return fullDomainName;
    }
    public String getRelativeURL() {
        Matcher matcher = urlPattern.matcher(driver.getCurrentUrl());
        matcher.find();
        String relativeURL = matcher.group(3);
        return relativeURL;
    }

    public String getURLTrailers() {
        Matcher matcher = urlPattern.matcher(driver.getCurrentUrl());
        matcher.find();
        String trailers = matcher.group(3);
        return trailers;
    }

    public void sendKeys(String key, CharSequence text) {
        WebElement element = elements.get(key);
        element.sendKeys(text);
    }

    public void click(String key) {
        WebElement element = elements.get(key);
        element.click();
    }

    public String alertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        return text;
    }
}
