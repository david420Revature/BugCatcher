package com.revature.components;

import com.revature.customs.DefectReportDialog;
import com.revature.customs.TestCaseReportDialog;
import com.revature.customs.TestCaseSubmitalForm;
import com.revature.customs.TestCaseTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface TestCaseDashComponent extends Component {

    default TestCaseSubmitalForm getTestCaseSubmitalForm(TestCaseTable targetTable) {
        WebElement form = getDriver().findElement(By.xpath(
           "//form"
        ));
        return new TestCaseSubmitalForm(form, targetTable, this);
    }

    default TestCaseTable getTestCaseTable() {
        WebElement table = getDriver().findElement(By.xpath(
                "//table"
        ));
        return new TestCaseTable(table, this);
    }

    default public TestCaseReportDialog getTestCaseReportDialog() {
        WebElement dialog = getDriver().findElement(By.xpath(
                "/html/body/div[@class='ReactModalPortal']"
        ));
        getWait().until(driver -> {
            return dialog.isDisplayed();
        });
        return new TestCaseReportDialog(dialog, this);
    }


}
