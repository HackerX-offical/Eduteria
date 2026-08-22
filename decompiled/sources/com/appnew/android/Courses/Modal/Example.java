package com.appnew.android.Courses.Modal;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: loaded from: classes6.dex */
public class Example {

    @SerializedName("id")
    private String id;

    @SerializedName("permissions")
    private Permissions permissions;

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_QUOTE)
    private String quote;

    @SerializedName("ranges")
    private List<Range> ranges = null;

    @SerializedName("tags")
    private Object tags;

    @SerializedName("text")
    private String text;

    @SerializedName("uri")
    private String uri;

    @SerializedName("user")
    private String user;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public List<Range> getRanges() {
        return this.ranges;
    }

    public void setRanges(List<Range> ranges) {
        this.ranges = ranges;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Object getTags() {
        return this.tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Permissions getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public class Permissions {

        @SerializedName("read")
        private List<String> read = null;

        @SerializedName("admin")
        private List<String> admin = null;

        @SerializedName(DiscoverItems.Item.UPDATE_ACTION)
        private List<String> update = null;

        @SerializedName("delete")
        private List<String> delete = null;

        public Permissions() {
        }

        public List<String> getRead() {
            return this.read;
        }

        public void setRead(List<String> read) {
            this.read = read;
        }

        public List<String> getAdmin() {
            return this.admin;
        }

        public void setAdmin(List<String> admin) {
            this.admin = admin;
        }

        public List<String> getUpdate() {
            return this.update;
        }

        public void setUpdate(List<String> update) {
            this.update = update;
        }

        public List<String> getDelete() {
            return this.delete;
        }

        public void setDelete(List<String> delete) {
            this.delete = delete;
        }
    }

    public class Range {

        @SerializedName("end")
        private String end;

        @SerializedName("endOffset")
        private Integer endOffset;

        @SerializedName("start")
        private String start;

        @SerializedName("startOffset")
        private Integer startOffset;

        public Range() {
        }

        public Integer getEndOffset() {
            return this.endOffset;
        }

        public void setEndOffset(Integer endOffset) {
            this.endOffset = endOffset;
        }

        public Integer getStartOffset() {
            return this.startOffset;
        }

        public void setStartOffset(Integer startOffset) {
            this.startOffset = startOffset;
        }

        public String getStart() {
            return this.start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return this.end;
        }

        public void setEnd(String end) {
            this.end = end;
        }
    }
}
