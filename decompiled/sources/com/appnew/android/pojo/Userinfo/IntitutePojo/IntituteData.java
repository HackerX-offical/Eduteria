package com.appnew.android.pojo.Userinfo.IntitutePojo;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class IntituteData implements Serializable {
    private String domain;
    private String id;
    private boolean isExpand = false;
    private String logo;
    private String owner_name;
    private String title;

    public boolean isExpand() {
        return this.isExpand;
    }

    public void setExpand(boolean expand) {
        this.isExpand = expand;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner_name() {
        return this.owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
