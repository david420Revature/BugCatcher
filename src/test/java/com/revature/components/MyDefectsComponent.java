package com.revature.components;

import com.revature.customs.MyDefects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface MyDefectsComponent extends Component {
    default MyDefects getMyDefectsElement() {
        WebElement target = getDriver().findElement(
                By.xpath("//h3[text()='My Defects']/following-sibling::ul")
        );
        return new MyDefects(target, this);
    }
}
