package com.revature.browser;

import org.openqa.selenium.WebDriver;

public class DefectReportPage extends Page implements HeaderComponent {
    public DefectReportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean validateURL(String url) {
        return url.equals(getDomain() + "/defectreporter");
    }
}
