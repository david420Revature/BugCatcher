package com.revature.browser;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.function.BiFunction;

public class Page {
    private final Browser browser;
    private final String handle;
    private final HashMap<String, By> components = new HashMap<>();
    private String url;

    public Page(Browser browser) {
        super();
        this.browser = browser;
        this.handle = browser.getDriver().getWindowHandle();
        url = browser.getDriver().getCurrentUrl();
    }

    public Browser getBrowser() {
        return browser;
    }
    public String getHandle() {
        return this.handle;
    }
    public String getUrl() {
        return url;
    }

    public Component component(String key) {
        By by = components.get(key);
        return new Component(this, by);

    }

    public void replaceAll(BiFunction<? super String, ? super By, ? extends By> set) {
        components.replaceAll(set);
    }

    public void switchTo() {
        browser.getDriver().switchTo().window(handle);
        browser.getWait().until(driver -> {
            return driver.getWindowHandle().equals(handle);
        });
    }

    public void switchFrom() {
        browser.getWait().until(driver -> {
            return ! driver.getWindowHandle().equals(handle);
        });
    }

    public void updateUrl() {
        browser.getWait().until(driver -> {
            return ! driver.getCurrentUrl().equals(url);
        });
        url = browser.getDriver().getCurrentUrl();
    }

    public void updateUrl(String otherUrl) {
        browser.getWait().until(driver -> {
            return driver.getCurrentUrl().equals(otherUrl);
        });
        url = otherUrl;
    }

    public void close() {
        browser.getDriver().close();
        switchFrom();
    }
}
