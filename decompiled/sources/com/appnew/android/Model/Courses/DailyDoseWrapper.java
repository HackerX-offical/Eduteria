package com.appnew.android.Model.Courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class DailyDoseWrapper implements Serializable {

    @SerializedName("dose_menu")
    @Expose
    private ArrayList<DailyDoseMenu> doseMenu;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<DailyDoseMenu> getDoseMenu() {
        return this.doseMenu;
    }

    public void setDoseMenu(ArrayList<DailyDoseMenu> doseMenu) {
        this.doseMenu = doseMenu;
    }
}
