package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import com.github.kotvertolet.youtubejextractor.utils.StringUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class Cipher implements Serializable {
    private String s;
    private String sp;
    private String url;

    public Cipher(String str, String str2, String str3) {
        this.s = str;
        this.sp = str2;
        this.url = str3;
    }

    public String getS() {
        return StringUtils.urlDecode(this.s);
    }

    public void setS(String str) {
        this.s = str;
    }

    public String getSp() {
        return this.sp;
    }

    public void setSp(String str) {
        this.sp = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
