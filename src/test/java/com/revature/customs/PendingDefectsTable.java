package com.revature.customs;

import com.revature.components.PendingDefectsTableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class PendingDefectsTable extends CustomElement {

    private PendingDefectsTableComponent component;
    public PendingDefectsTable(WebElement element, PendingDefectsTableComponent component) {
        super(element);
        this.component = component;
    }

    public List<PendingDefect> getPendingDefects() {
        List<WebElement> elements = this.findElements(
                By.xpath("tbody//tr")
        );
        return elements.stream().map(element -> {
            return new PendingDefect(element, component);
        }).collect(Collectors.toList());
    }
}
