package com.revature.components;

import org.openqa.selenium.*;

import java.util.List;

public abstract class Component implements WebElement {

    protected WebElement element;

    public void click() {
        this.element.click();
    }

    public void submit() {
        this.element.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        this.element.sendKeys(keysToSend);
    }

    public void clear() {
        this.element.clear();
    }

    public String getTagName() {
        return this.element.getTagName();
    }

    public String getAttribute(String name) {
        return this.element.getAttribute(name);
    }

    public boolean isSelected() {
        return this.element.isSelected();
    }

    public boolean isEnabled() {
        return this.element.isEnabled();
    }

    public String getText() {
        return this.element.getText();
    }

    public List<WebElement> findElements(By by) {
        return this.element.findElements(by);
    }

    public WebElement findElement(By by) {
        return this.element.findElement(by);
    }

    public boolean isDisplayed() {
        return this.element.isDisplayed();
    }

    public Point getLocation() {
        return this.element.getLocation();
    }

    public Dimension getSize() {
        return this.element.getSize();
    }

    public Rectangle getRect() {
        return this.element.getRect();
    }

    public String getCssValue(String propertyName) {
        return this.element.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return this.element.getScreenshotAs(target);
    }
}
