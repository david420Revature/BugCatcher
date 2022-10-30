package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportPage extends Page {

    public static ReportPage from(Page page) {
        return new ReportPage(page.driver);
    }

    public ReportPage(WebDriver driver) {
        super(driver);
    }

    public static WebElement found(Page page) {
        return page.driver.findElement(By.name("dateReported"));
    }

    public static WebElement description(Page page) {
        return page.driver.findElement(By.name("desc"));
    }

    public static WebElement reproduction(Page page) {
        return page.driver.findElement(By.name("stepsToReproduce"));
    }

    public static WebElement severity(Page page) {
        return page.driver.findElement(By.name("severity"));
    }

    public static WebElement priority(Page page) {
        return page.driver.findElement(By.name("priority"));
    }

    public static WebElement submit(Page page) {
        return page.driver.findElement(By.xpath("//button[@type='submit']"));
    }

}
