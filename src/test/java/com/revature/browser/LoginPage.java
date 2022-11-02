package com.revature.browser;

import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

public class LoginPage extends Page implements LoginComponent {

    private Pattern urlValidator = Pattern.compile(
            "^" + getURL() + "$"
    );
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return getDomain() + "/\\?dev=4";
    }

    @Override
    public boolean validateURL(String url) {
        boolean result = urlValidator.matcher(url).find();
        return result;
    }
}
