package com.revature.customs;

import com.revature.components.TestCaseDashComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TestCaseTable extends CustomElement {
    private TestCaseDashComponent component;
    public TestCaseTable(WebElement element, TestCaseDashComponent component) {
        super(element);
        this.component = component;
    }

    public List<TestCaseRow> getRows() {
        List<WebElement> rows = findElements(By.xpath(
    "tbody//tr"
        ));
        return rows.stream().map(row -> {
            return new TestCaseRow(row, this, component);
        }).collect(Collectors.toList());
    }

    public WebElement getBody() {
        return findElement(By.xpath("tbody"));
    }
}
