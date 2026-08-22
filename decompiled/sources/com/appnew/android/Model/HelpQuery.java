package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class HelpQuery implements Serializable {
    static HelpQuery helpquery;
    String category;
    String description;
    String title;
    String user_id;

    public static HelpQuery newInstance() {
        HelpQuery helpQuery = new HelpQuery();
        helpquery = helpQuery;
        return helpQuery;
    }

    public static HelpQuery getInstance() {
        if (helpquery == null) {
            helpquery = new HelpQuery();
        }
        return helpquery;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
