package com.appnew.android.Model.DivisionModel;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class DivisionModel {
    private String id;
    private String parent_id;
    private String status;
    private ArrayList<SubDivision> sub_divisions;
    private String title;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<SubDivision> getSub_divisions() {
        return this.sub_divisions;
    }

    public void setSub_divisions(ArrayList<SubDivision> sub_divisions) {
        this.sub_divisions = sub_divisions;
    }
}
