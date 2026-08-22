package com.github.kotvertolet.youtubejextractor.test;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class Response {

    @SerializedName("args")
    private Args args;

    public Args getArgs() {
        return this.args;
    }

    public void setArgs(Args args) {
        this.args = args;
    }

    public String toString() {
        return "Response{args = '" + this.args + "'}";
    }
}
