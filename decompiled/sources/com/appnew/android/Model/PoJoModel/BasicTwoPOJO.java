package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class BasicTwoPOJO implements Serializable {
    private String chapter_id;
    private String data_required;
    private String id;
    private String sub_topic_id;
    private String subject_id;
    private String topic_id;
    private String unit_id;

    public BasicTwoPOJO(String id, String subject_id, String unit_id, String chapter_id, String topic_id, String sub_topic_id, String data_required) {
        this.id = id;
        this.subject_id = subject_id;
        this.unit_id = unit_id;
        this.chapter_id = chapter_id;
        this.topic_id = topic_id;
        this.sub_topic_id = sub_topic_id;
        this.data_required = data_required;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getUnit_id() {
        return this.unit_id;
    }

    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getChapter_id() {
        return this.chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getSub_topic_id() {
        return this.sub_topic_id;
    }

    public void setSub_topic_id(String sub_topic_id) {
        this.sub_topic_id = sub_topic_id;
    }

    public String getData_required() {
        return this.data_required;
    }

    public void setData_required(String data_required) {
        this.data_required = data_required;
    }
}
