package com.appnew.android.Model.TestPDFData;

import com.appnew.android.Utils.TestService;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TestPDFQuiz implements Serializable {

    @SerializedName(TestService.action)
    @Expose
    private TestJson testJson;

    public TestJson getTestJson() {
        return this.testJson;
    }

    public void setTestJson(TestJson testJson) {
        this.testJson = testJson;
    }
}
