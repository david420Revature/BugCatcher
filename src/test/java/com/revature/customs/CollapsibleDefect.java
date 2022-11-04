package com.revature.customs;

import com.revature.components.MyDefectsComponent;
import com.revature.doms.Defect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollapsibleDefect extends CustomElement {

    private MyDefectsComponent component;

    private static String idIndicator = "ID:";
    private static String assignedIndicator = "Assigned To:";
    private static Pattern idPattern = Pattern.compile(
      "(?<=" + idIndicator + ").+"
    );
    private static Pattern assignedPattern = Pattern.compile(
            "(?<=" + assignedIndicator + ").+"
    );

    private WebElement idElement;
    private WebElement assignedElement;
    private WebElement changeStatusButton;
    private WebElement statusElement;
    public CollapsibleDefect(WebElement element, MyDefectsComponent component) {
        super(element);
        this.component = component;
        idElement = findElement(
                By.xpath(
                        ".//p/b[contains(text(),'" +
                                idIndicator +
                                "')]"
                )
        );
        assignedElement = findElement(
                By.xpath("//p[contains(text(), '" + assignedIndicator + "')]")
        );
        changeStatusButton = findElement(
            By.xpath("//button[text()='Change Status']")
        );
        StringBuffer xpathBuffer = new StringBuffer();
        for (int i = 0; i < Defect.validStatuses.length; i++) {
            String status = Defect.validStatuses[i];
            xpathBuffer.append(
                    "//p/b[text()='" + status + "']"
            );
            if (i != Defect.validStatuses.length - 1) {
                xpathBuffer.append("|");
            }
        }
        statusElement = findElement(
                By.xpath(xpathBuffer.toString()) // should use substring
        );
    }

    public String getDefectID() {
        Matcher matcher = idPattern.matcher(idElement.getText());
        matcher.find();
        String result = matcher.group(0);
        return result.trim();
    }

    public String getAssigned() {
        if (!assignedElement.isDisplayed()) {
            click();
            component.getWait().until(driver -> {
                return assignedElement.isDisplayed();
            });
        };
        String text = assignedElement.getText();
        Matcher matcher = assignedPattern.matcher(text);
        matcher.find();
        return matcher.group(0).trim();
    }

    public String getStatus() {
        return statusElement.getText();
    }

    public WebElement getStatusSetter(String status) {
        return findElement(By.xpath("//button[text()='" + status + "']"));
    }

    public void setStatus(String status) {
        if (!changeStatusButton.isDisplayed()) {
            click();
            component.getWait().until(driver -> {
                return statusElement.isDisplayed();
            });
        }
        WebElement statusSetter = getStatusSetter(status);
        if (!statusSetter.isDisplayed()) {
            changeStatusButton.click();
            component.getWait().until(driver -> {
               return statusSetter.isDisplayed();
            });
        }
        statusSetter.click();
        component.getWait().until(driver -> {
           return statusElement.getText().equals(status);
        });
    }
}
