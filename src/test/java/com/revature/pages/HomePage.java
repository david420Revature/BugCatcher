package com.revature.pages;

import com.revature.components.DefectAssigner;
import com.revature.components.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class HomePage extends Page {

    public static WebElement greeting(Page page) {
        return page.driver.findElement(By.cssSelector("#root > nav > p"));
    }

    public static Table defectTable(Page page) {
        return new Table(page.driver.findElement(
                By.xpath("/html/body//table[//*[contains(text(), 'Defect')]]")
        ));
    }

    public static DefectAssigner defectAssigner(Page page) {
        return new DefectAssigner(page.driver.findElement(
           By.xpath("/html/body//div[button[text()='Assign']]")
        ));
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public assign() {
        Table assigner = HomePage.defectAssigner(this);
        List<WebElement> defects = assigner.rows();

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(100));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(defects));
    }

    public static HomePage from(Page page) {
        return new HomePage(page.driver);
    }

    public static boolean validate(Page page, String role) {
        return page.getRelativeURL().equals("/" + role + "home");
    }
}
