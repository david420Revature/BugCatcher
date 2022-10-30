package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static LoginPage from(Page page) {
        return new LoginPage(page.driver);
    }

    public static WebElement usernameInput(Page page) {
        return page.driver.findElement(By.name("username"));
    }
    public static WebElement passwordInput(Page page) {
        return page.driver.findElement(By.name("pass"));
    }
    public static WebElement loginButton(Page page) {
        return page.driver.findElement(By.tagName("button"));
    }

    public Page login(String username, String password) {
        LoginPage.usernameInput(this).sendKeys(username);
        LoginPage.passwordInput(this).sendKeys(password);
        return login();
    }
    public Page login() {
        LoginPage.loginButton(this).click();
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

    public static boolean validate(Page page) {
        return (
                page instanceof LoginPage &&
                page.getRelativeURL().equals("/")
        );
    }
}
