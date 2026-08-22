package com.appnew.android.testmodule.model;

import com.appnew.android.testmodule.model.Challenge_Report;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class PdfData implements Serializable {
    PdfListData data;
    ArrayList<Challenge_Report.Errors> errors;
    String is_android_price;
    String message;
    String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PdfListData getData() {
        return this.data;
    }

    public void setData(PdfListData data) {
        this.data = data;
    }

    public String getIs_android_price() {
        return this.is_android_price;
    }

    public void setIs_android_price(String is_android_price) {
        this.is_android_price = is_android_price;
    }

    public ArrayList<Challenge_Report.Errors> getErrors() {
        return this.errors;
    }

    public void setErrors(ArrayList<Challenge_Report.Errors> errors) {
        this.errors = errors;
    }

    public class PdfListData implements Serializable {
        String layer;
        ArrayList<PdfList> list;

        public PdfListData() {
        }

        public String getLayer() {
            return this.layer;
        }

        public void setLayer(String layer) {
            this.layer = layer;
        }

        public ArrayList<PdfList> getList() {
            return this.list;
        }

        public void setList(ArrayList<PdfList> list) {
            this.list = list;
        }
    }

    public class PdfList implements Serializable {
        String chat_node;
        String description;
        String file_type;
        String file_url;
        String id;
        String is_live;
        String is_locked;
        String live_status;
        String thumbnail_url;
        String title;
        String token;
        String video_type;

        public PdfList() {
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFile_url() {
            return this.file_url;
        }

        public void setFile_url(String file_url) {
            this.file_url = file_url;
        }

        public String getToken() {
            return this.token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getThumbnail_url() {
            return this.thumbnail_url;
        }

        public void setThumbnail_url(String thumbnail_url) {
            this.thumbnail_url = thumbnail_url;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFile_type() {
            return this.file_type;
        }

        public void setFile_type(String file_type) {
            this.file_type = file_type;
        }

        public String getVideo_type() {
            return this.video_type;
        }

        public void setVideo_type(String video_type) {
            this.video_type = video_type;
        }

        public String getIs_locked() {
            return this.is_locked;
        }

        public void setIs_locked(String is_locked) {
            this.is_locked = is_locked;
        }

        public String getIs_live() {
            return this.is_live;
        }

        public void setIs_live(String is_live) {
            this.is_live = is_live;
        }

        public String getChat_node() {
            return this.chat_node;
        }

        public void setChat_node(String chat_node) {
            this.chat_node = chat_node;
        }

        public String getLive_status() {
            return this.live_status;
        }

        public void setLive_status(String live_status) {
            this.live_status = live_status;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
