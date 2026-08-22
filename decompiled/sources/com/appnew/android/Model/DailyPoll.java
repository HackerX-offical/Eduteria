package com.appnew.android.Model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class DailyPoll implements Serializable {
    private String description;
    private String id;
    private JsonClass json;
    private String meta_url;
    private String post_type;
    private String text;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeta_url() {
        return this.meta_url;
    }

    public void setMeta_url(String meta_url) {
        this.meta_url = meta_url;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPost_type() {
        return this.post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public JsonClass getJson() {
        return this.json;
    }

    public void setJson(JsonClass json) {
        this.json = json;
    }

    public class JsonClass {
        private String attempt_index;
        private ArrayList<OptionsValue> options;
        private int right_ans;
        private String total_attempt;
        private String view_type;

        public JsonClass() {
        }

        public String getView_type() {
            return this.view_type;
        }

        public void setView_type(String view_type) {
            this.view_type = view_type;
        }

        public String getTotal_attempt() {
            return this.total_attempt;
        }

        public void setTotal_attempt(String total_attempt) {
            this.total_attempt = total_attempt;
        }

        public String getAttempt_index() {
            return this.attempt_index;
        }

        public void setAttempt_index(String attempt_index) {
            this.attempt_index = attempt_index;
        }

        public int getRight_ans() {
            return this.right_ans;
        }

        public void setRight_ans(int right_ans) {
            this.right_ans = right_ans;
        }

        public ArrayList<OptionsValue> getOptions() {
            return this.options;
        }

        public void setOptions(ArrayList<OptionsValue> options) {
            this.options = options;
        }
    }

    public class OptionsValue {
        private String attempt_count;
        private String attempt_percentage = "";
        private String option;

        public OptionsValue() {
        }

        public String getAttempt_percentage() {
            return this.attempt_percentage;
        }

        public void setAttempt_percentage(String attempt_percentage) {
            this.attempt_percentage = attempt_percentage;
        }

        public String getOption() {
            return this.option;
        }

        public void setOption(String option) {
            this.option = option;
        }

        public String getAttempt_count() {
            return this.attempt_count;
        }

        public void setAttempt_count(String attempt_count) {
            this.attempt_count = attempt_count;
        }
    }

    public String toString() {
        return "DailyPoll{id='" + this.id + "', meta_url='" + this.meta_url + "', text='" + this.text + "', post_type='" + this.post_type + "', json=" + this.json + '}';
    }
}
