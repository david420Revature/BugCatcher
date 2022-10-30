package com.revature.components;

import org.openqa.selenium.*;

import java.util.Iterator;

public class Table extends Component {

    public Table(WebElement element) {
        this.element = element;
    }
    public WebElement head() {
        return this.findElement(By.xpath("./thead"));
    }

    public Iterable<TR> headers() {
        return () -> {
            return new TableIterator(this.head());
        };
    }

    public int index(String text) {
        int span;
        for (WebElement header : headers()) {
            int i = 0;
            for (WebElement th : header.findElements(By.tagName("th"))) {
                if (th.getText().equals(text)) return i;
                try {
                    span = Integer.parseInt(th.getAttribute("colspan"));
                    i += span;
                }
                catch (NumberFormatException e) {
                    i++;
                }

            }
        }
        return -1;
    }

    public WebElement body() {
        return this.findElement(By.xpath("./tbody"));
    }

    public Iterable<TR> rows() {
        return () -> {
           return new TableIterator(this.body());
        };
    }

    public TR row(int index) {
        index++; // so we can use zero indexing
        return new TR(
                this.findElement(By.xpath("./tbody/tr[" + index + "]"))
        );
    }

    public int size() {
        int size = 0;
        for (TR row : this.rows()) {
            size++;
        }
        return size;
    }
}

class TableIterator implements Iterator<TR> {

    private WebElement tableSection;
    private int index;
    private WebElement acc;
    public TableIterator(WebElement tableSection) {
        this.tableSection = tableSection;
        this.index = 1;
    }

    @Override
    public boolean hasNext() {
        try {
            acc = tableSection.findElement(By.xpath("./tr[" + index + "]"));
            index++;
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public TR next() {
        return new TR(acc);
    }

}