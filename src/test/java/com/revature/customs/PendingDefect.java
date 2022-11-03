package com.revature.customs;

import com.revature.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PendingDefect extends CustomElement {

    private WebElement selectButton;
    public PendingDefect(WebElement element) {
        super(element);
        selectButton = this.findElement(By.tagName("button"));
    }

    public void select() {
        selectButton.click();
    }
}
