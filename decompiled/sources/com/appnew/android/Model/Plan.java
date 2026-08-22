package com.appnew.android.Model;

import com.appnew.android.Model.Courses.AmountDescription;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Plan {
    private boolean Expanded;
    private AmountDescription amount_description;
    private String count;
    private String cycle;
    private String id;
    private String name;
    private List<String> tax;

    public boolean isExpanded() {
        return this.Expanded;
    }

    public void setExpanded(boolean expanded) {
        this.Expanded = expanded;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCycle() {
        return this.cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public AmountDescription getAmountDescription() {
        return this.amount_description;
    }

    public void setAmountDescription(AmountDescription amount_description) {
        this.amount_description = amount_description;
    }

    public List<String> getTax() {
        return this.tax;
    }

    public void setTax(List<String> tax) {
        this.tax = tax;
    }
}
