package com.appnew.android.testmodule.model;

/* JADX INFO: loaded from: classes6.dex */
public class TopicModel {
    private final String topicId;
    private final String topicName;
    private final String topic_alias;
    private final String total_no_of_attempts;
    private final int userClickPosition;

    public TopicModel(String topicName, String topicId, int userClickPosition, String total_no_of_attempts, String topic_alias) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.userClickPosition = userClickPosition;
        this.total_no_of_attempts = total_no_of_attempts;
        this.topic_alias = topic_alias;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public String getTopicId() {
        return this.topicId;
    }

    public String getTotal_no_of_attempts() {
        return this.total_no_of_attempts;
    }

    public int getUserClickPosition() {
        return this.userClickPosition;
    }

    public String getTopic_alias() {
        return this.topic_alias;
    }
}
