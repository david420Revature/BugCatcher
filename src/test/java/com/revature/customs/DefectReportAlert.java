package com.revature.customs;

import com.revature.components.DefectReporterComponent;
import org.openqa.selenium.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DefectReportAlert extends CustomAlert {

    private DefectReporterComponent component;
    public DefectReportAlert(Alert alert, DefectReporterComponent component) {
        super(alert);
        this.component = component;
    }

    public DefectReportDialog ok() {
        accept();
        return component.getDefectReportDialog();
    }


}
