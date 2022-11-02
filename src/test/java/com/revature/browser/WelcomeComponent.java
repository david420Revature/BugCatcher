package com.revature.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface WelcomeComponent extends Component {

    default WebElement getGreetingParagraph() {
        return getDriver().findElement(By.xpath("//nav/p"));
    }
}
