package com.appnew.android.testmodule.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Social implements Serializable {
    public String name;
    public String option;
    public mcSelection selcted;
    public int tag;
    public boolean select = false;
    public boolean parent = false;
    public boolean swiped = false;

    public boolean isSelect() {
        return this.select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getTag() {
        return this.tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public mcSelection getSelcted() {
        return this.selcted;
    }

    public void setSelcted(mcSelection selcted, boolean select) {
        this.selcted = selcted;
        this.select = select;
    }

    public boolean isParent() {
        return this.parent;
    }

    public void setParent(boolean parent) {
        this.parent = parent;
    }

    public boolean isSwiped() {
        return this.swiped;
    }

    public void setSwiped(boolean swiped) {
        this.swiped = swiped;
    }

    public Social() {
    }

    public Social(String option, String name, int tag) {
        this.option = option;
        this.name = name;
        this.tag = tag;
    }
}
