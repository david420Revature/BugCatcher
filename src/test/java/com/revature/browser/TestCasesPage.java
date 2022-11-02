package com.revature.browser;

import org.openqa.selenium.WebDriver;

public class TestCasesPage extends Page implements HeaderComponent {
    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean validateURL(String url) {
        return url.equals(getDomain() + "/testcases");
    }
}
