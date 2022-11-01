package com.revature.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface LoginComponent extends Component {

    default String getLoginUrl() {
        return "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=4";
    }
    default WebElement getUserNameInput() {
      return getDriver().findElement(By.name("username"));
    }
    default WebElement getPasswordInput() {
        return getDriver().findElement(By.name("pass"));
    }
    default WebElement getLoginButton() {
        return getDriver().findElement(By.xpath("//button[text()='Login']"));
    }
    default void login(String username, String password) {
        getUserNameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        login();
    }
    default void login() {
        getLoginButton().click();
        getWait().until(driver -> {
            return ! driver.getCurrentUrl().equals(getLoginUrl());
        });
    }
}
