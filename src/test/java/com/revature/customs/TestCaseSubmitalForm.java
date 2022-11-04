package com.revature.customs;

import com.revature.components.TestCaseDashComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

// very good candidate to extend an abstract form class
public class TestCaseSubmitalForm extends CustomElement {

    private TestCaseDashComponent component;
    private TestCaseTable targetTable;
    private WebElement descriptionField;
    private WebElement stepsField;
    private WebElement submitButton;
    public TestCaseSubmitalForm(WebElement element, TestCaseTable targetTable, TestCaseDashComponent component) {
        super(element);
        this.component = component;
        this.targetTable = targetTable;

        descriptionField = findElement(By.name(
            "desc"
        ));
        stepsField = findElement(By.name(
           "steps"
        ));
        submitButton = findElement(By.xpath(
"//button[@type='submit']"
        ));
    }

    public void setDescription(String text) {
        descriptionField.sendKeys(text); // this should just be a getDescriptionField call
    }

    public void setSteps(String text) {
        stepsField.sendKeys(text);
    }

    public void submit() {
        int staleSize = targetTable.getRows().size();
        submitButton.click();
        component.getWait().until(driver -> {
            return targetTable.getRows().size() > staleSize;
        });
    }
}
