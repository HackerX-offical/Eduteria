package com.appnew.android.Courses.Modal;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class VODTimeList implements Serializable {
    ArrayList<VODTimeDB> vodTimeDBArrayList;

    public VODTimeList(ArrayList<VODTimeDB> vodTimeDBArrayList) {
        this.vodTimeDBArrayList = vodTimeDBArrayList;
    }

    public ArrayList<VODTimeDB> getVodTimeDBArrayList() {
        return this.vodTimeDBArrayList;
    }

    public void setVodTimeDBArrayList(ArrayList<VODTimeDB> vodTimeDBArrayList) {
        this.vodTimeDBArrayList = vodTimeDBArrayList;
    }
}
