package com.revature.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface HomeComponent extends Component {
    default String getHomeTrailer(String role) {
        return "/" + role + "home";
    }
    default WebElement getGreetingParagraph() {
        return getDriver().findElement(By.xpath("//nav/p"));
    }
}
