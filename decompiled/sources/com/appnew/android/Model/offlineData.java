package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class offlineData implements Serializable {
    long downloadid;
    String id;
    boolean isdownloadcomplete;
    boolean isdownloadinprogress;
    boolean islatest;
    String link;
    String type;

    public boolean isIslatest() {
        return this.islatest;
    }

    public void setIslatest(boolean islatest) {
        this.islatest = islatest;
    }

    public long getDownloadid() {
        return this.downloadid;
    }

    public void setDownloadid(long downloadid) {
        this.downloadid = downloadid;
    }

    public offlineData(String id, String link, boolean isdownloadinprogress, boolean isdownloadcomplete, String type, long downloadid, boolean islatest) {
        this.id = id;
        this.link = link;
        this.isdownloadinprogress = isdownloadinprogress;
        this.isdownloadcomplete = isdownloadcomplete;
        this.type = type;
        this.downloadid = downloadid;
        this.islatest = islatest;
    }

    public offlineData(String id, String link, boolean isdownloadinprogress, boolean isdownloadcomplete, String type, long downloadid) {
        this.islatest = false;
        this.id = id;
        this.link = link;
        this.isdownloadinprogress = isdownloadinprogress;
        this.isdownloadcomplete = isdownloadcomplete;
        this.type = type;
        this.downloadid = downloadid;
    }

    public boolean isIsdownloadcomplete() {
        return this.isdownloadcomplete;
    }

    public void setIsdownloadcomplete(boolean isdownloadcomplete) {
        this.isdownloadcomplete = isdownloadcomplete;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isIsdownloadinprogress() {
        return this.isdownloadinprogress;
    }

    public void setIsdownloadinprogress(boolean isdownloadinprogress) {
        this.isdownloadinprogress = isdownloadinprogress;
    }
}
