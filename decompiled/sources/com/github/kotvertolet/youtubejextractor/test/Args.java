package com.github.kotvertolet.youtubejextractor.test;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class Args {

    @SerializedName("player_response")
    private String playerResponse;

    public String getPlayerResponse() {
        return this.playerResponse;
    }

    public void setPlayerResponse(String str) {
        this.playerResponse = str;
    }

    public String toString() {
        return "Args{player_response = '" + this.playerResponse + "'}";
    }
}
