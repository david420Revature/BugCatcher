package com.revature.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface LoginComponent extends Component {

    WebElement getLoginElement();
    default WebElement getUserNameInput() {
      return getLoginElement().findElement(By.name("username"));
    }
    default WebElement getPasswordInput() {
        return getLoginElement().findElement(By.name("pass"));
    }
    default WebElement getLoginButton() {
        return getLoginElement().findElement(By.xpath("//button[text()='Login']"));
    }

}
