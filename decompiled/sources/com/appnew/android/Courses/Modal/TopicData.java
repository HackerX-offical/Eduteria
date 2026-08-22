package com.appnew.android.Courses.Modal;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TopicData implements Serializable {

    @SerializedName(Const.COLOR_CODE)
    @Expose
    private String colorCode;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("is_live")
    @Expose
    private String is_live;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName(Const.PARENT_ID)
    @Expose
    private String parentId;
    public boolean Expanded = false;

    @SerializedName("sub_topic")
    @Expose
    private List<SubTopic> subTopic = null;

    public boolean isSetExpanded() {
        return this.Expanded;
    }

    public void setSetExpanded(boolean expanded) {
        this.Expanded = expanded;
    }

    public String getIs_live() {
        return this.is_live;
    }

    public void setIs_live(String is_live) {
        this.is_live = is_live;
    }

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

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public List<SubTopic> getSubTopic() {
        return this.subTopic;
    }

    public void setSubTopic(List<SubTopic> subTopic) {
        this.subTopic = subTopic;
    }
}
