package com.revature.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;

public class TR extends Component {
    public TR(WebElement tr) {
        this.element = tr;
    }

    public WebElement col(int index) {
        index++;
        return this.findElement(By.xpath("./td[" + index + "]|./th[" + index + "]"));
    }
}

class TRIterator implements Iterator<WebElement> {

    private WebElement tr;
    private int index;
    private WebElement acc;
    public TRIterator(WebElement tr) {
        this.tr = tr;
        this.index = 1;
    }

    @Override
    public boolean hasNext() {
        acc = tr.findElement(By.xpath("./tr[" + index + "]"));
        index++;
        return (acc != null);
    }

    @Override
    public WebElement next() {
        return acc;
    }

}