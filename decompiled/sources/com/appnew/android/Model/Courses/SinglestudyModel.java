package com.appnew.android.Model.Courses;

import com.appnew.android.Model.Course_subject_master;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class SinglestudyModel implements Serializable {
    private Basic basic;
    private String is_purchased;
    private ArrayList<Course_subject_master> subjects;
    private ArrayList<Cards> tiles;

    public SinglestudyModel() {
    }

    public SinglestudyModel(Basic basic) {
        this.basic = basic;
    }

    public SinglestudyModel(ArrayList<Cards> tiles, Basic basic, String is_purchased, ArrayList<Course_subject_master> subjects) {
        this.tiles = tiles;
        this.basic = basic;
        this.is_purchased = is_purchased;
        this.subjects = subjects;
    }

    public ArrayList<Course_subject_master> getSubjects() {
        return this.subjects;
    }

    public String getIs_purchased() {
        return this.is_purchased;
    }

    public void setIs_purchased(String is_purchased) {
        this.is_purchased = is_purchased;
    }

    public ArrayList<Cards> getTiles() {
        return this.tiles;
    }

    public void setTiles(ArrayList<Cards> tiles) {
        this.tiles = tiles;
    }

    public Basic getBasic() {
        return this.basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }
}
