package com.appnew.android.home.model;

import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.StoreProvider;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Menu implements Serializable {

    @SerializedName(StoreProvider.StoreData.CREATED_DATE)
    @Expose
    private String created;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("description1")
    @Expose
    private String description1;

    @SerializedName("feed_type")
    @Expose
    private String feedType;

    @SerializedName("have_child")
    @Expose
    private String haveChild;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private int image;
    private String imageUrl;

    @SerializedName("link_level")
    @Expose
    private String linkLevel;

    @SerializedName("menu_type_id")
    @Expose
    private String menuTypeId;

    @SerializedName(StoreProvider.StoreData.MODIFIED_DATE)
    @Expose
    private String modified;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("name1")
    @Expose
    private String name1;

    @SerializedName(Const.PARENT_ID)
    @Expose
    private String parentId;

    @SerializedName(Const.POSITION)
    @Expose
    private String position;

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName(Const.STUDY_TYPE)
    @Expose
    private String studyType;

    @SerializedName("study_type_detail")
    @Expose
    private String studyTypeDetail;

    @SerializedName("sub_menu")
    @Expose
    private List<Menu> subMenu;

    @SerializedName("type_name")
    @Expose
    private String typeName;

    @SerializedName("type_code")
    @Expose
    private String type_code;

    @SerializedName("web_link")
    @Expose
    private String webLink;
    private Boolean isSelected = false;
    private boolean selected = false;
    private boolean expanded = false;

    public Boolean getSelected() {
        return this.isSelected;
    }

    public void setSelected(Boolean selected) {
        this.isSelected = selected;
    }

    public Menu(String type_code) {
        this.type_code = type_code;
    }

    public Menu() {
    }

    public Menu(String id, String type_code) {
        this.id = id;
        this.type_code = type_code;
    }

    public Menu(String id, String parentId, String name, String name1, String menuTypeId, String haveChild, int image, String type_code, List<Menu> subMenu) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.name1 = name1;
        this.menuTypeId = menuTypeId;
        this.haveChild = haveChild;
        this.image = image;
        this.type_code = type_code;
        this.subMenu = subMenu;
    }

    public Menu(String id, String parentId, String name, String name1, String menuTypeId, String haveChild, int image, String imageUrl, String type_code, List<Menu> subMenu) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.name1 = name1;
        this.menuTypeId = menuTypeId;
        this.haveChild = haveChild;
        this.image = image;
        this.type_code = type_code;
        this.subMenu = subMenu;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return this.name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription1() {
        return this.description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getLinkLevel() {
        return this.linkLevel;
    }

    public void setLinkLevel(String linkLevel) {
        this.linkLevel = linkLevel;
    }

    public String getWebLink() {
        return this.webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public String getStudyType() {
        return this.studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getStudyTypeDetail() {
        return this.studyTypeDetail;
    }

    public void setStudyTypeDetail(String studyTypeDetail) {
        this.studyTypeDetail = studyTypeDetail;
    }

    public String getFeedType() {
        return this.feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getMenuTypeId() {
        return this.menuTypeId;
    }

    public String getHaveChild() {
        return this.haveChild;
    }

    public int getImage() {
        return this.image;
    }

    public String getPosition() {
        return this.position;
    }

    public String getCreated() {
        return this.created;
    }

    public String getModified() {
        return this.modified;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public List<Menu> getSubMenu() {
        return this.subMenu;
    }

    public String getType_code() {
        return this.type_code;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
