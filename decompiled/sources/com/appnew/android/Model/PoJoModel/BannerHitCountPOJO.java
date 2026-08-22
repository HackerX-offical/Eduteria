package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class BannerHitCountPOJO implements Serializable {
    private String banner_id;

    public BannerHitCountPOJO(String banner_id) {
        this.banner_id = banner_id;
    }

    public String getBanner_id() {
        return this.banner_id;
    }

    public void setBanner_id(String banner_id) {
        this.banner_id = banner_id;
    }
}
