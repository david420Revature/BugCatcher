package com.revature.components;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
