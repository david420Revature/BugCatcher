package com.revature.customs;

import com.revature.components.TestCaseDashComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// very good candidate to extend an abstract form class
public class TestCaseSubmitalForm extends CustomElement {

    private TestCaseDashComponent component;
    private WebElement descriptionField;
    private WebElement stepsField;
    private WebElement submitButton;
    public TestCaseSubmitalForm(WebElement element, TestCaseDashComponent component) {
        super(element);
        this.component = component;
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

    public WebElement getSubmitButton() {
        return submitButton;
    }
}
