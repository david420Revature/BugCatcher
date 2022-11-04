package com.revature.customs;

import com.revature.components.DefectReporterComponent;
import com.revature.components.TestCaseDashComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCaseReportDialog extends CustomElement {
    Pattern pattern = Pattern.compile("Case (\\d+)");

    private TestCaseDashComponent component;
    private WebElement idElement;
    private WebElement closeButton;
    private WebElement editButton;
    private WebElement performedBy;

    public TestCaseReportDialog(WebElement element, TestCaseDashComponent component) {
        super(element);
        this.component = component;
        idElement = findElement(By.xpath(
                "//h3"
        ));
        closeButton = findElement(By.xpath(
                "//button[text()='Close']"
        ));
        editButton = findElement(By.xpath(
           "//button/descendant-or-self::*[text()='Edit']"
        ));
        performedBy = findElement(By.xpath(
           "//h4/following-sibling::p[text()='No One']"
        ));
    }

    public String getID() {
        Matcher matcher = pattern.matcher(getText());
        matcher.find();
        return matcher.group(1);
    }

    public String getPerformedBy() {
        return performedBy.getText();
    }

    public void close() {
        closeButton.click();
        component.getWait().until(driver -> {
            return ! this.isDisplayed();
        });
    }
}
