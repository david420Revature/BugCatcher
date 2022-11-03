package com.revature.components;

import com.revature.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface HeaderComponent extends Component {

    default WebElement getHeaderElement() {
        return getDriver().findElement(By.xpath("/html/body//nav[1]"));
    }

    default WebElement getGreetingParagraph() {
        return getHeaderElement().findElement(By.tagName("p"));
    }

    default List<WebElement> getHeaderAnchors() {
        return getHeaderElement().findElements(By.xpath("//a[@href]"));
    }
}
