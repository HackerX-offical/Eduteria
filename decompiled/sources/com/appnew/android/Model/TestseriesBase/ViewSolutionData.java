package com.appnew.android.Model.TestseriesBase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ViewSolutionData implements Serializable {

    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;

    @SerializedName("result")
    @Expose
    private ArrayList<ViewSolutionResult> result = null;

    @SerializedName("parts")
    @Expose
    private List<Part> parts = null;

    public ArrayList<ViewSolutionResult> getResult() {
        return this.result;
    }

    public void setResult(ArrayList<ViewSolutionResult> result) {
        this.result = result;
    }

    public List<Part> getParts() {
        return this.parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
