package com.revature.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DefectAssigner extends Component {
    public DefectAssigner(WebElement element) {
        this.element = element;
    }

    public WebElement description() {
        return this.findElement(By.tagName("h4"));
    }

    public WebElement input() {
        return this.findElement(By.xpath("./input[@list='employees']"));
    }

    public List<WebElement> datalist() {
        return this.findElements(By.xpath("./datalist[@id='employees']//option[@value]"));
    }

    public void select(int index) {
        String value = datalist().get(index).getAttribute("value");
        input().sendKeys(value);
    }

    public WebElement button() {
        return this.findElement(By.tagName("button"));
    }

}
