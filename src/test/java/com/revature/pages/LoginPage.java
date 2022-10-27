package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
        elements = new HashMap<>();

        elements.put(
                "usernameInput",
                driver.findElement(By.name("username"))
        );

        elements.put(
                "passwordInput",
                driver.findElement(By.name("pass"))
        );

        elements.put(
                "loginButton",
                driver.findElement(By.tagName("button"))
        );
    }

    public Page login() {
        click("loginButton");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
        wait.until(
                ExpectedConditions.or(
                    ExpectedConditions.alertIsPresent(),
                        ExpectedConditions.urlMatches(
                                getProtocol() + "://" +
                                        getFullDomainName() + "/" +
                                        "\\w+home"
                        )

                )
        );
        try {
            String originalHandle = driver.getWindowHandle();
            driver.switchTo().alert();
            driver.switchTo().window(originalHandle);
            return this;
        }
        catch (NoAlertPresentException e) {
            return new HomePage(driver);
        }
    }

    @Override
    public boolean validateURL() {
        return this.getRelativeURL().equals("/");
    }
}
