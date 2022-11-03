package com.revature.pages;

import com.revature.components.LoginComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    @Override
    public WebElement getLoginElement() {
        return getDriver().findElement(By.xpath("/html/body//fieldset[1]"));
    }
}
