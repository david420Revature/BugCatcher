package com.revature.pages;

import com.revature.components.HeaderComponent;
import com.revature.components.TestCaseDashComponent;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends Page implements HeaderComponent, TestCaseDashComponent {
    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean validateURL(String url) {
        return url.equals(getDomain() + "/testcases");
    }
}
