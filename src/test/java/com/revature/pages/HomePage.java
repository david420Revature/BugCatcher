package com.revature.pages;

import com.revature.components.HeaderComponent;
import com.revature.components.PendingDefectsTableComponent;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

public class HomePage extends Page implements HeaderComponent, PendingDefectsTableComponent {

    private Pattern urlValidator = Pattern.compile(
            "^" + getDomain() + "/(\\w+)home$"
    );
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean validateHomeURL(String role) {
        return validateHomeURL(role, getDriver().getCurrentUrl());
    }

    public boolean validateHomeURL(String role, String url) {
        String expectedURL = getDomain() + "/" + role + "home";
        return url.equals(expectedURL);
    }

    @Override
    public boolean validateURL(String url) {
        return urlValidator.matcher(url).find();
    }
}
