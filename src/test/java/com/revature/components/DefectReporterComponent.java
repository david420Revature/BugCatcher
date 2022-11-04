package com.revature.components;

import com.revature.customs.DefectReportDialog;
import com.revature.customs.DefectReportForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface DefectReporterComponent extends Component {
    default public DefectReportForm getDefectReportForm() {
        WebElement form = getDriver().findElement(By.xpath(
            "/html/body/div[@id='root']/form[@id='defectReport']"
        ));
        return new DefectReportForm(form, this);
    }

    default public DefectReportDialog getDefectReportDialog() {
        WebElement dialog = getDriver().findElement(By.xpath(
           "/html/body/div[@class='ReactModalPortal']"
        ));
        getWait().until(driver -> {
            return dialog.isDisplayed();
        });
        return new DefectReportDialog(dialog, this);
    }
}
