package com.appnew.android.home.model.Search;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class RecentList implements Serializable {
    ArrayList<RecentData> recentList;

    public RecentList(ArrayList<RecentData> recentList) {
        this.recentList = recentList;
    }

    public ArrayList<RecentData> getRecentList() {
        return this.recentList;
    }

    public void setRecentList(ArrayList<RecentData> recentList) {
        this.recentList = recentList;
    }
}
