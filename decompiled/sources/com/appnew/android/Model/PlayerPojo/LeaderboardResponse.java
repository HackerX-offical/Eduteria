package com.appnew.android.Model.PlayerPojo;

import com.appnew.android.Model.PollLeaderboard;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class LeaderboardResponse implements Serializable {
    List<PollLeaderboard> data = null;
    String message;
    String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PollLeaderboard> getData() {
        return this.data;
    }

    public void setData(List<PollLeaderboard> data) {
        this.data = data;
    }
}
