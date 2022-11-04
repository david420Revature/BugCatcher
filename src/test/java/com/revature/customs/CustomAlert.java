package com.revature.customs;

import org.openqa.selenium.Alert;

public class CustomAlert implements Alert {

    private Alert alert;

    public CustomAlert(Alert alert) {
        this.alert = alert;
    }

    @Override
    public void dismiss() {
        alert.dismiss();
    }

    @Override
    public void accept() {
        alert.accept();
    }

    @Override
    public String getText() {
        return alert.getText();
    }

    @Override
    public void sendKeys(String keysToSend) {
        alert.sendKeys(keysToSend);
    }
}
