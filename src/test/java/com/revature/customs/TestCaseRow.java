package com.revature.customs;

import com.revature.components.TestCaseDashComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCaseRow extends CustomElement {
    private TestCaseDashComponent component;
    public TestCaseRow(WebElement element, TestCaseTable parent, TestCaseDashComponent component) {
        super(element);
        this.component = component;
    }

    public String getID() {
        return getChild("td", 0).getText();
    }

    public String getResult() {
        return getChild("td", 1).getText();
    }

    public TestCaseReportDialog getDetails() {
        WebElement detailsButton = findElement(By.xpath(
                "td[4]/button"
        ));
        detailsButton.click();
        return component.getTestCaseReportDialog();
    }
}
