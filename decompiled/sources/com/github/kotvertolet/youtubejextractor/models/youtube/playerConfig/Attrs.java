package com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class Attrs implements Serializable {

    @SerializedName("id")
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "Attrs{id = '" + this.id + "'}";
    }
}
