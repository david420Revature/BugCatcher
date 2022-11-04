package com.revature.pages;

import com.revature.components.DefectReporterComponent;
import com.revature.components.HeaderComponent;
import org.openqa.selenium.WebDriver;

public class DefectReportPage extends Page implements HeaderComponent, DefectReporterComponent {
    public DefectReportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean validateURL(String url) {
        return url.equals(getDomain() + "/defectreporter");
    }
}
