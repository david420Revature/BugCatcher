package com.revature.customs;

import com.revature.components.PendingDefectsTableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PendingDefect extends CustomElement {

    private PendingDefectsTableComponent component;
    private WebElement selectButton;
    private WebElement description;
    public PendingDefect(WebElement element, PendingDefectsTableComponent component) {
        super(element);
        selectButton = this.findElement(By.tagName("button"));
        description = this.findElement(By.xpath("//td[2]"));
        this.component = component;
    }

    public WebElement getDescription() {
        return description;
    }

    public String getID() {
        return getChild("td",0).getText();
    }

    public DefectAssigner select() {
        selectButton.click();
        WebElement root = findElement(
            By.xpath(
                "ancestor-or-self::div[@id='root']"
            )
        );
        WebElement target = root.findElement(
                By.xpath(
                        "//div[h4]"
                )
        );
        return new DefectAssigner(target, this, component);
    }
}
