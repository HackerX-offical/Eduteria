package com.appnew.android.Model.NotificationModel;

import com.appnew.android.Utils.StoreProvider;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class Datum {

    @SerializedName("action_element")
    @Expose
    private String actionElement;

    @SerializedName("action_element_id")
    @Expose
    private String actionElementId;

    @SerializedName(StoreProvider.StoreData.CREATED_DATE)
    @Expose
    private String created;

    @SerializedName("extra")
    @Expose
    private Extras extra = null;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("view_state")
    @Expose
    private String viewState;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getActionElement() {
        return this.actionElement;
    }

    public void setActionElement(String actionElement) {
        this.actionElement = actionElement;
    }

    public String getActionElementId() {
        return this.actionElementId;
    }

    public void setActionElementId(String actionElementId) {
        this.actionElementId = actionElementId;
    }

    public Extras getExtra() {
        return this.extra;
    }

    public void setExtra(Extras extra) {
        this.extra = extra;
    }

    public String getViewState() {
        return this.viewState;
    }

    public void setViewState(String viewState) {
        this.viewState = viewState;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
