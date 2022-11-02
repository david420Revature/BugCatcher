package com.revature.browser;

import org.openqa.selenium.WebDriver;

public class MatrixPage extends Page implements HeaderComponent {
    public MatrixPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean validateURL(String url) {
        return url.equals(getDomain() + "/matrices");
    }
}
