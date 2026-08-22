package com.appnew.android.home.model.Search;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class RecentData implements Serializable {
    String queryData;
    String userId;

    public RecentData(String userId, String queryData) {
        this.userId = userId;
        this.queryData = queryData;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQueryData() {
        return this.queryData;
    }

    public void setQueryData(String queryData) {
        this.queryData = queryData;
    }
}
