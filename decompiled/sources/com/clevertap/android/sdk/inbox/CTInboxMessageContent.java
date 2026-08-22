package com.clevertap.android.sdk.inbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class CTInboxMessageContent implements Parcelable {
    public static final Parcelable.Creator<CTInboxMessageContent> CREATOR = new Parcelable.Creator<CTInboxMessageContent>() { // from class: com.clevertap.android.sdk.inbox.CTInboxMessageContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CTInboxMessageContent createFromParcel(Parcel parcel) {
            return new CTInboxMessageContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CTInboxMessageContent[] newArray(int i) {
            return new CTInboxMessageContent[i];
        }
    };
    private String actionUrl;
    private String contentType;
    private Boolean hasLinks;
    private Boolean hasUrl;
    private String icon;
    private String iconContentDescription;
    private JSONArray links;
    private String media;
    private String mediaContentDescription;
    private String message;
    private String messageColor;
    private String posterUrl;
    private String title;
    private String titleColor;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    CTInboxMessageContent() {
    }

    protected CTInboxMessageContent(Parcel parcel) {
        this.title = parcel.readString();
        this.titleColor = parcel.readString();
        this.message = parcel.readString();
        this.messageColor = parcel.readString();
        this.media = parcel.readString();
        this.mediaContentDescription = parcel.readString();
        this.hasUrl = Boolean.valueOf(parcel.readByte() != 0);
        this.hasLinks = Boolean.valueOf(parcel.readByte() != 0);
        this.actionUrl = parcel.readString();
        this.icon = parcel.readString();
        this.iconContentDescription = parcel.readString();
        try {
            this.links = parcel.readByte() == 0 ? null : new JSONArray(parcel.readString());
        } catch (JSONException e2) {
            Logger.v("Unable to init CTInboxMessageContent with Parcel - " + e2.getLocalizedMessage());
        }
        this.contentType = parcel.readString();
        this.posterUrl = parcel.readString();
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getIcon() {
        return this.icon;
    }

    void setIcon(String str) {
        this.icon = str;
    }

    public String getIconContentDescription() {
        return this.iconContentDescription;
    }

    void setIconContentDescription(String str) {
        this.iconContentDescription = str;
    }

    public String getLinkBGColor(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.has(Constants.KEY_BG) ? jSONObject.getString(Constants.KEY_BG) : "";
        } catch (JSONException e2) {
            Logger.v("Unable to get Link Text Color with JSON - " + e2.getLocalizedMessage());
            return null;
        }
    }

    public String getLinkColor(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.has("color") ? jSONObject.getString("color") : "";
        } catch (JSONException e2) {
            Logger.v("Unable to get Link Text Color with JSON - " + e2.getLocalizedMessage());
            return null;
        }
    }

    public String getLinkCopyText(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            JSONObject jSONObject2 = jSONObject.has("copyText") ? jSONObject.getJSONObject("copyText") : null;
            return (jSONObject2 == null || !jSONObject2.has("text")) ? "" : jSONObject2.getString("text");
        } catch (JSONException e2) {
            Logger.v("Unable to get Link Text with JSON - " + e2.getLocalizedMessage());
            return "";
        }
    }

    public HashMap<String, String> getLinkKeyValue(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(Constants.KEY_KV)) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(Constants.KEY_KV);
                Iterator<String> itKeys = jSONObject2.keys();
                HashMap<String, String> map = new HashMap<>();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject2.getString(next);
                    if (!TextUtils.isEmpty(next)) {
                        map.put(next, string);
                    }
                }
                if (map.isEmpty()) {
                    return null;
                }
                return map;
            } catch (JSONException e2) {
                Logger.v("Unable to get Link Key Value with JSON - " + e2.getLocalizedMessage());
            }
        }
        return null;
    }

    public String getLinkText(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.has("text") ? jSONObject.getString("text") : "";
        } catch (JSONException e2) {
            Logger.v("Unable to get Link Text with JSON - " + e2.getLocalizedMessage());
            return null;
        }
    }

    public String getLinkUrl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.has("url") ? jSONObject.getJSONObject("url") : null;
            if (jSONObject2 == null) {
                return null;
            }
            JSONObject jSONObject3 = jSONObject2.has("android") ? jSONObject2.getJSONObject("android") : null;
            if (jSONObject3 != null && jSONObject3.has("text")) {
                return jSONObject3.getString("text");
            }
            return "";
        } catch (JSONException e2) {
            Logger.v("Unable to get Link URL with JSON - " + e2.getLocalizedMessage());
            return null;
        }
    }

    public JSONArray getLinks() {
        return this.links;
    }

    void setLinks(JSONArray jSONArray) {
        this.links = jSONArray;
    }

    public String getLinktype(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.has("type") ? jSONObject.getString("type") : "";
        } catch (JSONException e2) {
            Logger.v("Unable to get Link Type with JSON - " + e2.getLocalizedMessage());
            return null;
        }
    }

    public boolean isFallbackSettingsEnabled(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            if (jSONObject.has(Constants.KEY_FALLBACK_NOTIFICATION_SETTINGS)) {
                return jSONObject.getBoolean(Constants.KEY_FALLBACK_NOTIFICATION_SETTINGS);
            }
            return false;
        } catch (JSONException e2) {
            Logger.v("Unable to get fallback settings key with JSON - " + e2.getLocalizedMessage());
            return false;
        }
    }

    public String getMedia() {
        return this.media;
    }

    public String getMediaContentDescription() {
        return this.mediaContentDescription;
    }

    void setMedia(String str) {
        this.media = str;
    }

    void setMediaContentDescription(String str) {
        this.mediaContentDescription = str;
    }

    public String getMessage() {
        return this.message;
    }

    void setMessage(String str) {
        this.message = str;
    }

    public String getMessageColor() {
        return this.messageColor;
    }

    void setMessageColor(String str) {
        this.messageColor = str;
    }

    public String getPosterUrl() {
        return this.posterUrl;
    }

    public void setPosterUrl(String str) {
        this.posterUrl = str;
    }

    public String getTitle() {
        return this.title;
    }

    void setTitle(String str) {
        this.title = str;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    void setTitleColor(String str) {
        this.titleColor = str;
    }

    public boolean mediaIsAudio() {
        String contentType = getContentType();
        return (contentType == null || this.media == null || !contentType.startsWith("audio")) ? false : true;
    }

    public boolean mediaIsGIF() {
        String contentType = getContentType();
        return (contentType == null || this.media == null || !contentType.equals("image/gif")) ? false : true;
    }

    public boolean mediaIsImage() {
        String contentType = getContentType();
        return (contentType == null || this.media == null || !contentType.startsWith("image") || contentType.equals("image/gif")) ? false : true;
    }

    public boolean mediaIsVideo() {
        String contentType = getContentType();
        return (contentType == null || this.media == null || !contentType.startsWith("video")) ? false : true;
    }

    public boolean mediaIsStreamable() {
        return mediaIsAudio() || mediaIsVideo();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.titleColor);
        parcel.writeString(this.message);
        parcel.writeString(this.messageColor);
        parcel.writeString(this.media);
        parcel.writeString(this.mediaContentDescription);
        parcel.writeByte(this.hasUrl.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hasLinks.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.icon);
        parcel.writeString(this.iconContentDescription);
        if (this.links == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.links.toString());
        }
        parcel.writeString(this.contentType);
        parcel.writeString(this.posterUrl);
    }

    CTInboxMessageContent initWithJSON(JSONObject jSONObject) {
        String str;
        String str2;
        try {
            JSONObject jSONObject2 = jSONObject.has("title") ? jSONObject.getJSONObject("title") : null;
            if (jSONObject2 == null) {
                str = Constants.KEY_LINKS;
            } else {
                if (jSONObject2.has("text")) {
                    String string = jSONObject2.getString("text");
                    str = Constants.KEY_LINKS;
                    str2 = string;
                } else {
                    str = Constants.KEY_LINKS;
                    str2 = "";
                }
                this.title = str2;
                this.titleColor = jSONObject2.has("color") ? jSONObject2.getString("color") : "";
            }
            JSONObject jSONObject3 = jSONObject.has("message") ? jSONObject.getJSONObject("message") : null;
            if (jSONObject3 != null) {
                this.message = jSONObject3.has("text") ? jSONObject3.getString("text") : "";
                this.messageColor = jSONObject3.has("color") ? jSONObject3.getString("color") : "";
            }
            JSONObject jSONObject4 = jSONObject.has("icon") ? jSONObject.getJSONObject("icon") : null;
            if (jSONObject4 != null) {
                this.icon = jSONObject4.has("url") ? jSONObject4.getString("url") : "";
                this.iconContentDescription = jSONObject4.optString(Constants.KEY_ALT_TEXT, "");
            }
            JSONObject jSONObject5 = jSONObject.has("media") ? jSONObject.getJSONObject("media") : null;
            if (jSONObject5 != null) {
                this.media = jSONObject5.has("url") ? jSONObject5.getString("url") : "";
                this.mediaContentDescription = jSONObject5.optString(Constants.KEY_ALT_TEXT, "");
                this.contentType = jSONObject5.has("content_type") ? jSONObject5.getString("content_type") : "";
                this.posterUrl = jSONObject5.has(Constants.KEY_POSTER_URL) ? jSONObject5.getString(Constants.KEY_POSTER_URL) : "";
            }
            JSONObject jSONObject6 = jSONObject.has("action") ? jSONObject.getJSONObject("action") : null;
            if (jSONObject6 != null) {
                boolean z = true;
                this.hasUrl = Boolean.valueOf(jSONObject6.has(Constants.KEY_HAS_URL) && jSONObject6.getBoolean(Constants.KEY_HAS_URL));
                if (!jSONObject6.has(Constants.KEY_HAS_LINKS) || !jSONObject6.getBoolean(Constants.KEY_HAS_LINKS)) {
                    z = false;
                }
                this.hasLinks = Boolean.valueOf(z);
                JSONObject jSONObject7 = jSONObject6.has("url") ? jSONObject6.getJSONObject("url") : null;
                if (jSONObject7 != null && this.hasUrl.booleanValue()) {
                    JSONObject jSONObject8 = jSONObject7.has("android") ? jSONObject7.getJSONObject("android") : null;
                    if (jSONObject8 != null) {
                        this.actionUrl = jSONObject8.has("text") ? jSONObject8.getString("text") : "";
                    }
                }
                if (jSONObject7 != null && this.hasLinks.booleanValue()) {
                    String str3 = str;
                    this.links = jSONObject6.has(str3) ? jSONObject6.getJSONArray(str3) : null;
                }
            }
            return this;
        } catch (JSONException e2) {
            Logger.v("Unable to init CTInboxMessageContent with JSON - " + e2.getLocalizedMessage());
            return this;
        }
    }
}
