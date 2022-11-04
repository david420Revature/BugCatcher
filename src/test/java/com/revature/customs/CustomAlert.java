package com.revature.customs;

import org.openqa.selenium.Alert;

public abstract class CustomAlert implements Alert {

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

    // implement a CustomContainer interface
    @Override
    public boolean equals(Object custom) {
        try {
            return this.alert.equals(((CustomAlert) custom).alert);
        }
        catch (ClassCastException e) {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return this.alert.hashCode();
    }
}
