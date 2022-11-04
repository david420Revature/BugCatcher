package com.revature.customs;

import com.revature.components.DefectReporterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DefectReportDialog extends CustomElement {
    Pattern pattern = Pattern.compile("Defect (\\d+)");

    private DefectReporterComponent component;
    private WebElement message;
    private WebElement closeButton;
    public DefectReportDialog(WebElement element, DefectReporterComponent component) {
        super(element);
        this.component = component;
        message = findElement(By.xpath(
            "//h4"
        ));
        closeButton = findElement(By.xpath(
            "//button[text()='Close']"
        ));
    }

    public String getID() {
        Matcher matcher = pattern.matcher(getText());
        matcher.find();
        return matcher.group(1);
    }

    public void close() {
        closeButton.click();
        component.getWait().until(driver -> {
           return ! this.isDisplayed();
        });
    }
}
