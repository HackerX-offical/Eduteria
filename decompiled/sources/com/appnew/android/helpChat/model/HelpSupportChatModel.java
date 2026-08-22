package com.appnew.android.helpChat.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class HelpSupportChatModel implements Serializable {
    private List<DataBean> data;

    public List<DataBean> getData() {
        return this.data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        private String category;
        private String close_date;
        private String description;
        private String file;
        private String id;
        private String query_id;
        private String time;
        private String title;
        private String user_id;

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuery_id() {
            return this.query_id;
        }

        public void setQuery_id(String query_id) {
            this.query_id = query_id;
        }

        public String getUser_id() {
            return this.user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getCategory() {
            return this.category;
        }

        public void setCategory(String category) {
            this.category = category;
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

        public String getFile() {
            return this.file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getClose_date() {
            return this.close_date;
        }

        public void setClose_date(String close_date) {
            this.close_date = close_date;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
