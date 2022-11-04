package com.revature.customs;

import org.openqa.selenium.*;

import java.util.List;

public abstract class CustomElement implements WebElement {
    private WebElement element;
    public CustomElement(WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        this.element.click();
    }

    @Override
    public void submit() {
        this.element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        this.element.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        this.element.clear();
    }

    @Override
    public String getTagName() {
        return this.element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return this.element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return this.element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return this.element.isEnabled();
    }

    @Override
    public String getText() {
        return this.element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return this.element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return this.element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return this.element.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return this.element.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return this.element.getScreenshotAs(target);
    }

    public WebElement getChild(String tagName, int index) {
        index++;
        return findElement(
            By.xpath(
         tagName + "[" + index + "]"
            )
        );
    }
}
