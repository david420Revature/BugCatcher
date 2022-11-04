package com.revature.components;

import com.revature.customs.TestCaseSubmitalForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface TestCaseDashComponent extends Component {

    default TestCaseSubmitalForm getTestCaseSubmitalForm() {
        WebElement form = getDriver().findElement(By.xpath(
           "//form"
        ));
        return new TestCaseSubmitalForm(form, this);
    }
}
