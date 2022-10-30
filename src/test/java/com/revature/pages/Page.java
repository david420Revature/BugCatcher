package com.revature.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Page {
    protected static Pattern urlPattern = Pattern.compile("(https?)://([^/]+)(/[^\\?#]*)?((?:\\?|#).*)?");
    protected WebDriver driver;


    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public Page refresh() {
        driver.navigate().refresh();
        return this;
    }
    public String url() {
        return driver.getCurrentUrl();
    }
    public Cookie cookie(String name) {
        return driver.manage().getCookieNamed(name);
    }
    public Collection<Cookie> cookies() {
        return driver.manage().getCookies();
    }
    public String title() {
        return driver.getTitle();
    }
    public void quit() {
        driver.quit();
    }
    public Page close() {
        driver.close();
        return this;
    }
    public String windowHandle() {
        return driver.getWindowHandle();
    }
    public Page window(String handle) {
        driver.switchTo().window(handle);
        return this;
    }
    public Page get(String url) {
        driver.get(url);
        return this;
    }

    public Page clink(String linktext) {
        WebElement anchor = this.driver.findElement(By.linkText(linktext));
        String href = anchor.getAttribute("href");
        anchor.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
        wait.until(ExpectedConditions.urlToBe(href));
        return this;
    }

    public Page clink(String linktext, String url) {
        this.driver.findElement(By.linkText(linktext)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
        wait.until(ExpectedConditions.urlToBe(url));
        return this;
    }
    public String relURL(String rel) {
        return this.getProtocol() + "://" + this.getFullDomainName() + rel;
    }
    public Page back() {
        driver.navigate().back();
        return this;
    }
    public Page forward() {
        driver.navigate().forward();
        return this;
    }
    public Page to(String url) {
        driver.navigate().to(url);
        return this;
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

    public String alertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        return text;
    }

    public void alertAccept() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
