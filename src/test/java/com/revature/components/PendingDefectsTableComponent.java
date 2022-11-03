package com.revature.components;

import com.revature.customs.PendingDefect;
import com.revature.customs.PendingDefectsTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface PendingDefectsTableComponent extends Component {

    default PendingDefectsTable getPendingDefectsTableElement() {
        return new PendingDefectsTable(
                getDriver().findElement(
                By.xpath("//table[thead[tr[th[text()='Defect ID']]]]")
            )
        );
    };




}
