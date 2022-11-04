package com.revature.customs;

import com.revature.components.PendingDefectsTableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class DefectAssigner extends CustomElement {

    private PendingDefectsTableComponent component;

    private PendingDefect pendingDefect;
    private WebElement message;
    private WebElement input;
    private WebElement datalist;
    private WebElement button;
    public DefectAssigner(WebElement element,
                          PendingDefect pendingDefect,
                          PendingDefectsTableComponent component
    ) {
        super(element);
        message = findElement(By.tagName("h4"));
        input = findElement(By.tagName("input"));
        datalist = findElement(By.tagName("datalist"));
        button = findElement(By.tagName("button"));
        this.pendingDefect = pendingDefect;
        this.component = component;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getButton() {
        return button;
    }

    public void select(int index) {
        index++;
        WebElement option = datalist.findElement(
            By.xpath(
                    "option[" + index + "]"
            )
        );
        input.sendKeys(option.getAttribute("value"));
    }

    public void assign() {
        button.click();
        component.getWait().until(driver -> {
           try {
               return ! pendingDefect.isDisplayed();
           }
           catch(StaleElementReferenceException e) {
               return true;
           }
        });
    }
}
