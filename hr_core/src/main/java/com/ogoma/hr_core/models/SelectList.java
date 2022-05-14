package com.ogoma.hr_core.models;

import java.util.List;

public class SelectList<T> {
    private List<T> items;
    private T selectedValue;

    public SelectList(List<T> items) {
        this.items = items;
    }

    public SelectList(List<T> items, T selected) {
        this.items=items;
        this.selectedValue=selected;
    }
}
