package com.revature.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface HomeComponent extends Component {
    default String getHomeUrl(String role) {
        return "https://bugcatcher-jasdhir.coe.revaturelabs.com/" + role + "home";
    }
    default WebElement getGreetingParagraph() {
        return getDriver().findElement(By.xpath("//nav/p"));
    }
}
