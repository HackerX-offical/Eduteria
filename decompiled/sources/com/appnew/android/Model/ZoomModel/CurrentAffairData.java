package com.appnew.android.Model.ZoomModel;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CurrentAffairData implements Serializable {

    @SerializedName(Const.CATEGORY)
    @Expose
    private String category;

    @SerializedName("category_image")
    @Expose
    private String category_image;

    @SerializedName("data")
    @Expose
    private ArrayList<CurrentAffairDataModel> data;

    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_image() {
        return this.category_image;
    }

    public void setCategory_image(String category_image) {
        this.category_image = category_image;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<CurrentAffairDataModel> getData() {
        return this.data;
    }

    public void setData(ArrayList<CurrentAffairDataModel> data) {
        this.data = data;
    }
}
