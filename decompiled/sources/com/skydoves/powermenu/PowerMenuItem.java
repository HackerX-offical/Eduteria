package com.skydoves.powermenu;

/* JADX INFO: loaded from: classes9.dex */
public class PowerMenuItem {
    protected int icon;
    protected boolean isSelected;
    protected Object tag;
    protected CharSequence title;

    public PowerMenuItem(CharSequence charSequence) {
        this.title = charSequence;
    }

    public PowerMenuItem(CharSequence charSequence, Object obj) {
        this.title = charSequence;
        this.tag = obj;
    }

    public PowerMenuItem(CharSequence charSequence, int i) {
        this.title = charSequence;
        this.icon = i;
    }

    public PowerMenuItem(CharSequence charSequence, int i, Object obj) {
        this.title = charSequence;
        this.icon = i;
        this.tag = obj;
    }

    public PowerMenuItem(CharSequence charSequence, boolean z) {
        this.title = charSequence;
        this.isSelected = z;
    }

    public PowerMenuItem(CharSequence charSequence, boolean z, Object obj) {
        this.title = charSequence;
        this.isSelected = z;
        this.tag = obj;
    }

    public PowerMenuItem(CharSequence charSequence, int i, boolean z) {
        this.title = charSequence;
        this.icon = i;
        this.isSelected = z;
    }

    public PowerMenuItem(CharSequence charSequence, int i, boolean z, Object obj) {
        this.title = charSequence;
        this.icon = i;
        this.isSelected = z;
        this.tag = obj;
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public void setTitle(CharSequence charSequence) {
        this.title = charSequence;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setIsSelected(boolean z) {
        this.isSelected = z;
    }

    public Object getTag() {
        return this.tag;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int i) {
        this.icon = i;
    }
}
