package com.revature.browser;

import org.openqa.selenium.By;

@FunctionalInterface
public interface ComponentGenerator {
    public Component generate(Page page, By by);
}
