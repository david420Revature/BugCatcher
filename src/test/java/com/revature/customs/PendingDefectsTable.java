package com.revature.customs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class PendingDefectsTable extends CustomElement {
    public PendingDefectsTable(WebElement element) {
        super(element);
    }

    public List<PendingDefect> getPendingDefects() {
        List<WebElement> elements = this.findElements(
                By.xpath("tbody//tr")
        );
        return elements.stream().map(element -> {
            return new PendingDefect(element);
        }).collect(Collectors.toList());
    }
}
