package com.revature.pages;

import com.revature.components.HeaderComponent;
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
