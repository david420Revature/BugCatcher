package com.revature.pages;

import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaseEditorPage extends Page {
    private Pattern urlPattern = Pattern.compile(
      "^" + getDomain() + "/caseeditor/(\\d+)$"
    );

    public CaseEditorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean validateURL(String url) {
        Matcher matcher = urlPattern.matcher(url);
        try {
            return matcher.find();
        }
        catch(IllegalStateException e) {
            return false;
        }
    }

    public String getID() {
        Matcher matcher = urlPattern.matcher(getCurrentUrl());
        matcher.find();
        return matcher.group(1);
    }
}
