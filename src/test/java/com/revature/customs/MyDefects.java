package com.revature.customs;

import com.revature.components.MyDefectsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MyDefects extends CustomElement {

    private MyDefectsComponent component;

    private List<CollapsibleDefect> defects;

    public MyDefects(WebElement element, MyDefectsComponent component) {
        super(element);
        this.component = component;
        List<WebElement> targets = findElements(By.xpath("li/div[@class='Collapsible']"));
        this.defects = targets.stream().map(defectElement -> {
            return new CollapsibleDefect(defectElement, component);
        }).collect(Collectors.toList());
    }

    public List<CollapsibleDefect> getDefects() {
        return defects;
    }


    public CollapsibleDefect getDefect(String defectID) {
        for (CollapsibleDefect defect : defects) {
            String actualID = defect.getDefectID();
            if (actualID.equals(defectID)) return defect;
        }
        throw new RuntimeException("could not find defect id: " + defectID);
    }
}
