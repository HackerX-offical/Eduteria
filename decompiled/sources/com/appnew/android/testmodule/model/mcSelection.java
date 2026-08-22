package com.appnew.android.testmodule.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mcSelection implements Serializable {
    private int bgcolor_code;
    private int circlecolor_code;
    private int position;
    public boolean select;

    public int getBgcolor_code() {
        return this.bgcolor_code;
    }

    public void setBgcolor_code(int bgcolor_code) {
        this.bgcolor_code = bgcolor_code;
    }

    public int getCirclecolor_code() {
        return this.circlecolor_code;
    }

    public void setCirclecolor_code(int circlecolor_code) {
        this.circlecolor_code = circlecolor_code;
    }

    public mcSelection(int position, int bgcolor_code, int circlecolor_code, boolean select) {
        this.position = position;
        this.bgcolor_code = bgcolor_code;
        this.circlecolor_code = circlecolor_code;
        this.select = select;
    }

    public boolean isSelect() {
        return this.select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getColor_code() {
        return this.bgcolor_code;
    }

    public void setColor_code(int bgcolor_code) {
        this.bgcolor_code = bgcolor_code;
    }
}
