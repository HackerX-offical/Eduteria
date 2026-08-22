package com.appnew.android.home.model.FilterData;

import com.appnew.android.table.LanguagesTable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Data {

    @SerializedName("languages")
    @Expose
    private List<LanguagesTable> languages = null;

    @SerializedName("subjects")
    @Expose
    private List<Subject> subjects = null;

    public List<LanguagesTable> getLanguages() {
        return this.languages;
    }

    public void setLanguages(List<LanguagesTable> languages) {
        this.languages = languages;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
