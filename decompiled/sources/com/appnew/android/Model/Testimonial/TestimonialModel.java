package com.appnew.android.Model.Testimonial;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TestimonialModel {

    @SerializedName("cd_time")
    @Expose
    private Long cdTime;

    @SerializedName("data")
    @Expose
    private Data data;

    @SerializedName("interval")
    @Expose
    private Integer interval;

    @SerializedName(Constants.KEY_LIMIT)
    @Expose
    private Integer limit;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("time")
    @Expose
    private Integer time;

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getInterval() {
        return this.interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getCdTime() {
        return this.cdTime;
    }

    public void setCdTime(Long cdTime) {
        this.cdTime = cdTime;
    }

    public class Data {

        @SerializedName("content1")
        @Expose
        private List<Object> content1;

        @SerializedName("content2")
        @Expose
        private List<Object> content2;

        @SerializedName("content3")
        @Expose
        private List<Object> content3;

        @SerializedName("content4")
        @Expose
        private List<Object> content4;

        @SerializedName("content5")
        @Expose
        private List<Object> content5;

        @SerializedName("content6")
        @Expose
        private List<Object> content6;

        @SerializedName("testimonial")
        @Expose
        private ArrayList<Testimonial> testimonial;

        public Data() {
        }

        public ArrayList<Testimonial> getTestimonial() {
            return this.testimonial;
        }

        public void setTestimonial(ArrayList<Testimonial> testimonial) {
            this.testimonial = testimonial;
        }

        public List<Object> getContent1() {
            return this.content1;
        }

        public void setContent1(List<Object> content1) {
            this.content1 = content1;
        }

        public List<Object> getContent2() {
            return this.content2;
        }

        public void setContent2(List<Object> content2) {
            this.content2 = content2;
        }

        public List<Object> getContent3() {
            return this.content3;
        }

        public void setContent3(List<Object> content3) {
            this.content3 = content3;
        }

        public List<Object> getContent4() {
            return this.content4;
        }

        public void setContent4(List<Object> content4) {
            this.content4 = content4;
        }

        public List<Object> getContent5() {
            return this.content5;
        }

        public void setContent5(List<Object> content5) {
            this.content5 = content5;
        }

        public List<Object> getContent6() {
            return this.content6;
        }

        public void setContent6(List<Object> content6) {
            this.content6 = content6;
        }

        public class Testimonial {

            @SerializedName("app_id")
            @Expose
            private String appId;

            @SerializedName(Const.CREATION_TIME)
            @Expose
            private String creationTime;

            @SerializedName("description")
            @Expose
            private String description;

            @SerializedName("file")
            @Expose
            private String file;

            @SerializedName("id")
            @Expose
            private String id;

            @SerializedName("link")
            @Expose
            private String link;

            @SerializedName("title")
            @Expose
            private String title;

            @SerializedName("type")
            @Expose
            private String type;

            @SerializedName("updated_at")
            @Expose
            private String updatedAt;

            public Testimonial() {
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

            public String getCreationTime() {
                return this.creationTime;
            }

            public void setCreationTime(String creationTime) {
                this.creationTime = creationTime;
            }

            public String getAppId() {
                return this.appId;
            }

            public void setAppId(String appId) {
                this.appId = appId;
            }

            public String getUpdatedAt() {
                return this.updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getType() {
                return this.type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLink() {
                return this.link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }
    }
}
