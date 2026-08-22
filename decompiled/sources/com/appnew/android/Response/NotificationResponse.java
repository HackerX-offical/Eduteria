package com.appnew.android.Response;

import com.appnew.android.Model.User;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class NotificationResponse implements Serializable {
    private User action_performed_by;
    private String activity_type;
    private String comment_id;
    private String creation_time;
    private ExtraNotification extra;
    private String id;
    private String message;
    private String post_id;
    private int view_state;

    public String getMessages() {
        return this.message;
    }

    public void setMessages(String message) {
        this.message = message;
    }

    public String getComment_id() {
        return this.comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public int getView_state() {
        return this.view_state;
    }

    public void setView_state(int view_state) {
        this.view_state = view_state;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public User getAction_performed_by() {
        return this.action_performed_by;
    }

    public void setAction_performed_by(User action_performed_by) {
        this.action_performed_by = action_performed_by;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getActivity_type() {
        return this.activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public ExtraNotification getExtra() {
        return this.extra;
    }

    public void setExtra(ExtraNotification extra) {
        this.extra = extra;
    }
}
