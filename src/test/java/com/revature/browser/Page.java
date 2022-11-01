package com.revature.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Page implements LoginComponent, HomeComponent {
    private WebDriver driver;
    private WebDriverWait wait;

    private ArrayList<Account> accounts = new ArrayList<>();

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(100));
        accounts.add(new Account("g8tor", "chomp!", "manager"));
        accounts.add(new Account("ryeGuy", "coolbeans", "tester"));
        accounts.add(new Account("cavalier89", "alucard", "tester"));
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
    public List<Account> getAccounts() {
        return accounts;
    }

    public void get(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }
}
