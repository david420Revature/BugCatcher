package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
        elements = new HashMap<>();

        elements.put("greeting", driver.findElement(By.cssSelector("#root > nav > p")));
    }

    @Override
    public boolean validateURL() {
        return false;
    }

    @Override
    public boolean validateURL(String ...args) {
        String role = args[0].toLowerCase();
        return this.getRelativeURL().equals("/" + role + "home");
    }
}
