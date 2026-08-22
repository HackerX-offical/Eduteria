package com.appnew.android.testmodule.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class InstructionData implements Serializable {

    @SerializedName("test_basic")
    @Expose
    private TestBasicInst testBasic;

    @SerializedName("test_sections")
    @Expose
    private List<TestSectionInst> testSections = null;

    public TestBasicInst getTestBasic() {
        return this.testBasic;
    }

    public void setTestBasic(TestBasicInst testBasic) {
        this.testBasic = testBasic;
    }

    public List<TestSectionInst> getTestSections() {
        return this.testSections;
    }

    public void setTestSections(List<TestSectionInst> testSections) {
        this.testSections = testSections;
    }
}
