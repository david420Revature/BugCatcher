package com.revature.browser;

import org.openqa.selenium.WebDriver;

public class DefectOverviewPage extends Page implements HeaderComponent {
    public DefectOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean validateURL(String url) {
        return url.equals(getDomain() + "/defectoverview");
    }
}
