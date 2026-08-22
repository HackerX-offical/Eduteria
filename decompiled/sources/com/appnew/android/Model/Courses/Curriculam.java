package com.appnew.android.Model.Courses;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Curriculam implements Serializable {
    private ArrayList<File_meta> file_meta;
    private String title;
    private String topic_id;

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<File_meta> getFile_meta() {
        return this.file_meta;
    }

    public void setFile_meta(ArrayList<File_meta> file_meta) {
        this.file_meta = file_meta;
    }

    public class File_meta implements Serializable {
        private String count;
        private String description;
        private String file;
        private String id;
        private String image;
        private String isPurchased;
        private String is_bookmarked;
        private String is_user_attemp;
        private String link;
        private String tag = "12";
        private String title;
        private String video_type;
        private int viewType;

        public File_meta() {
        }

        public String getIsPurchased() {
            return this.isPurchased;
        }

        public void setIsPurchased(String isPurchased) {
            this.isPurchased = isPurchased;
        }

        public String getIs_bookmarked() {
            return this.is_bookmarked;
        }

        public int getViewType() {
            return this.viewType;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
        }

        public String isIs_bookmarked() {
            return this.is_bookmarked;
        }

        public void setIs_bookmarked(String is_bookmarked) {
            this.is_bookmarked = is_bookmarked;
        }

        public String getIs_user_attemp() {
            return this.is_user_attemp;
        }

        public void setIs_user_attemp(String is_user_attemp) {
            this.is_user_attemp = is_user_attemp;
        }

        public String getVideo_type() {
            return this.video_type;
        }

        public void setVideo_type(String video_type) {
            this.video_type = video_type;
        }

        public String getImage() {
            return this.image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String isIs_user_attemp() {
            return this.is_user_attemp;
        }

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

        public String getLink() {
            return this.link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCount() {
            return this.count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getTag() {
            return this.tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }
}
