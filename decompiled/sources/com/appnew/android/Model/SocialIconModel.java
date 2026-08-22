package com.appnew.android.Model;

/* JADX INFO: loaded from: classes6.dex */
public class SocialIconModel {
    private int social_icon;
    private String social_icon_title;

    public SocialIconModel(String social_icon_title, int social_icon) {
        this.social_icon_title = social_icon_title;
        this.social_icon = social_icon;
    }

    public String getSocial_icon_title() {
        return this.social_icon_title;
    }

    public void setSocial_icon_title(String social_icon_title) {
        this.social_icon_title = social_icon_title;
    }

    public int getSocial_icon() {
        return this.social_icon;
    }

    public void setSocial_icon(int social_icon) {
        this.social_icon = social_icon;
    }
}
