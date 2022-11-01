package com.revature.runners;

import com.revature.browser.Browser;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        Set<String, By>
        Browser browser = new Browser(new ChromeDriver(), "default");
        System.out.println(browser.page().getUrl());
        browser.put("Google", "https://www.google.com");
        System.out.println(browser.page().getUrl());
        Browser browser2 = new Browser(new ChromeDriver(), "default");
        browser.quit();
        browser2.quit();
    }
}
