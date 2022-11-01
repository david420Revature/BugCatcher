package com.revature.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

// should maybe extend hashmap
public class Browser {
    public static Duration timeout = Duration.ofMillis(1000);
    public static String defaultPageName = "default";

    private final HashMap<String, Page> tabs = new HashMap<>();
    private final WebDriver driver;
    private final WebDriverWait wait;
    private Page cache;

    public Browser(WebDriver driver, String pagename) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, timeout);
            cache = new Page(this);
            tabs.put(
                pagename,
                cache
            );
    }
    public Browser(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        cache = new Page(this);
        tabs.put(
                defaultPageName,
                cache
        );
    }

    public WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getWait() {
        return wait;
    }

    public Page page() {
        if (driver.getWindowHandle().equals(cache.getHandle())) return cache;
        else {
            for (Page page : tabs.values()) {
                if (driver.getWindowHandle().equals(page.getHandle())) {
                    cache = page;
                    return page;
                }
            }
            throw new Error("Page not found");
        }
    }

    public Page get(String key) {
        Page page = tabs.get(key);
        page.switchTo();
        cache = page;
        return page;
    }

    // maybe I should let the page handle making new tabs
    public Page put(String key, String url) {
        Page page;
        if (tabs.containsKey(key)) {
            page = get(key);
            driver.get(url);
            page.updateUrl(url);
        }
        else {
            String handle = driver.getWindowHandle();
            driver.switchTo().newWindow(WindowType.TAB);
            wait.until(driver -> {
                return !driver.getWindowHandle().equals(handle);
            });
            page = new Page(this);
            tabs.put(key, page);
        }
        return page;
    }

    public void remove(String key) {
        Page page = tabs.remove(key);
        page.close();
    }

    public void quit() {
        driver.quit();
    }

}
