package com.appnew.android.home.model.topperDeskData;

import android.os.Parcel;
import android.os.Parcelable;
import com.appnew.android.Utils.StoreProvider;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class ToppersDeskData implements Parcelable {
    public static final Parcelable.Creator<ToppersDeskData> CREATOR = new Parcelable.Creator<ToppersDeskData>() { // from class: com.appnew.android.home.model.topperDeskData.ToppersDeskData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ToppersDeskData createFromParcel(Parcel in) {
            return new ToppersDeskData(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ToppersDeskData[] newArray(int size) {
            return new ToppersDeskData[size];
        }
    };

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName(StoreProvider.StoreData.CREATED_DATE)
    @Expose
    private String created;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName(StoreProvider.StoreData.MODIFIED_DATE)
    @Expose
    private String modified;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("video_url")
    @Expose
    private String videoUrl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return this.modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    protected ToppersDeskData(Parcel in) {
        this.id = in.readString();
        this.type = in.readString();
        this.author = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.imageUrl = in.readString();
        this.videoUrl = in.readString();
        this.status = in.readString();
        this.created = in.readString();
        this.modified = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.type);
        dest.writeString(this.author);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.imageUrl);
        dest.writeString(this.videoUrl);
        dest.writeString(this.status);
        dest.writeString(this.created);
        dest.writeString(this.modified);
    }
}
