package com.revature.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface HeaderComponent extends Component {
    default List<WebElement> getNavAnchors() {
        return getDriver().findElements(By.xpath("//div[@id='root']/nav/a[@href]"));
    }
}
