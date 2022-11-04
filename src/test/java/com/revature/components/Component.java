package com.revature.components;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// may be better though of as implementers, then parts of web elements can be components
public interface Component {
    WebDriver getDriver();
    WebDriverWait getWait();
    default Alert getAlert() {
        return getWait().until(ExpectedConditions.alertIsPresent());
    }
    String getDomain();


    default WebElement getAnchor(String linktext) {
        return getDriver().findElement(By.linkText(linktext));
    }

    default void clink(String linktext) {
        WebElement anchor = getAnchor(linktext);
        String target = anchor.getAttribute("href");
        anchor.click();
        getWait().until(ExpectedConditions.urlToBe(target));
    }
    default String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    default String getTitle() {
        return getDriver().getTitle();
    }

    default void back() {
        String currentUrl = getCurrentUrl();
        getDriver().navigate().back();
        getWait().until(driver -> {
            return ! driver.getCurrentUrl().equals(currentUrl);
        });
    }

    default void awaitURL() {
        getWait().until(driver -> {
            return validateURL();
        });
    }
    default boolean validateURL(String url) {
        return url.contains(getDomain());
    }
    default boolean validateURL() {
        return validateURL(getDriver().getCurrentUrl());
    }
}
