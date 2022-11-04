package com.revature.customs;

import com.revature.components.DefectReporterComponent;
import com.revature.doms.Defect;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

// could make a part interface and extend form for to get most form functions
public class DefectReportForm extends CustomElement {

    private DefectReporterComponent component;

    private WebElement dateField;
    private WebElement descriptionField;
    private WebElement reproductionStepsField;
    private WebElement severityField;
    private WebElement priorityField;
    private WebElement reportButton;

    public DefectReportForm(WebElement element, DefectReporterComponent component) {
        super(element);
        this.component = component;
        dateField = findElement(By.name("dateReported"));
        descriptionField = findElement(By.name("desc"));
        reproductionStepsField = findElement(By.name("stepsToReproduce"));
        severityField = findElement(By.name("severity"));
        priorityField = findElement(By.name("priority"));
        reportButton = findElement(By.xpath("//button[@type='submit']"));
    }

    public void setToday() {
        String string = LocalDate.now().toString();
        String year = string.substring(0, 4);
        String month = string.substring(5, 7);
        String day = string.substring(8, 10); // embarassing
        dateField.sendKeys(month + day + year);
    }

    public void setDescription(String text) {
        descriptionField.sendKeys(text);
    }

    public void setReproductionSteps(String text) {
        reproductionStepsField.sendKeys(text);
    }

    public void setSeverity(String text) {
        String weight = "" + Defect.weigh(text);
        severityField.sendKeys(weight);
    }

    public void setPriority(String text) {
        String weight = "" + Defect.weigh(text);
        priorityField.sendKeys(weight);
    }

    public WebElement getReportButton() {
        return reportButton;
    }

    public DefectReportAlert report() {
        reportButton.click();
        Alert alert = component.getWait().until(ExpectedConditions.alertIsPresent());
        return new DefectReportAlert(alert, component);
    }


}
