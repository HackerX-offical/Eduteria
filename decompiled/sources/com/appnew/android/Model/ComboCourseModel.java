package com.appnew.android.Model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ComboCourseModel implements Serializable {
    private ArrayList<Courselist> data;

    public ArrayList<Courselist> getData() {
        return this.data;
    }

    public void setData(ArrayList<Courselist> data) {
        this.data = data;
    }
}
