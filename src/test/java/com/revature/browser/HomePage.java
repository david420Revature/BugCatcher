package com.revature.browser;

import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

public class HomePage extends Page implements WelcomeComponent, HeaderComponent {

    private Pattern urlValidator = Pattern.compile(
            "^" + getDomain() + "/(\\w+)home$"
    );
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean validateHomeURL(String role) {
        String expectedURL = getDomain() + "/" + role + "home";
        String actualURL = getDriver().getCurrentUrl();
        return actualURL.equals(expectedURL);
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
