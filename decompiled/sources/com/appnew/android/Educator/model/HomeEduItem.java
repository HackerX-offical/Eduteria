package com.appnew.android.Educator.model;

/* JADX INFO: loaded from: classes6.dex */
public class HomeEduItem {
    String educatorExp;
    String educatorName;
    int educatorProfileImage;

    public HomeEduItem(int educatorProfileImage, String educatorName, String educatorExp) {
        this.educatorProfileImage = educatorProfileImage;
        this.educatorName = educatorName;
        this.educatorExp = educatorExp;
    }

    public int getEducatorProfileImage() {
        return this.educatorProfileImage;
    }

    public void setEducatorProfileImage(int educatorProfileImage) {
        this.educatorProfileImage = educatorProfileImage;
    }

    public String getEducatorName() {
        return this.educatorName;
    }

    public void setEducatorName(String educatorName) {
        this.educatorName = educatorName;
    }

    public String getEducatorExp() {
        return this.educatorExp;
    }

    public void setEducatorExp(String educatorExp) {
        this.educatorExp = educatorExp;
    }
}
