package com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig;

import com.appnew.android.Utils.Const;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.PlayerResponse;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class Args implements Serializable {

    @SerializedName("c")
    private String C;

    @SerializedName("account_playback_token")
    private String accountPlaybackToken;

    @SerializedName("adaptive_fmts")
    private String adaptiveFmts;

    @SerializedName("author")
    private String author;

    @SerializedName("cr")
    private String cr;

    @SerializedName("csi_page_type")
    private String csiPageType;

    @SerializedName("cver")
    private String cver;

    @SerializedName("enablecsi")
    private String enablecsi;

    @SerializedName("enabled_engage_types")
    private String enabledEngageTypes;

    @SerializedName("enablejsapi")
    private String enablejsapi;

    @SerializedName("fexp")
    private String fexp;

    @SerializedName("fflags")
    private String fflags;

    @SerializedName("fmt_list")
    private String fmtList;

    @SerializedName("gapi_hint_params")
    private String gapiHintParams;

    @SerializedName("hl")
    private String hl;

    @SerializedName("host_language")
    private String hostLanguage;

    @SerializedName("innertube_api_key")
    private String innertubeApiKey;

    @SerializedName("innertube_api_version")
    private String innertubeApiVersion;

    @SerializedName("innertube_context_client_version")
    private String innertubeContextClientVersion;

    @SerializedName("length_seconds")
    private String lengthSeconds;

    @SerializedName("loaderUrl")
    private String loaderUrl;

    @SerializedName("player_response")
    private PlayerResponse playerResponse;

    @SerializedName("show_content_thumbnail")
    private boolean showContentThumbnail;

    @SerializedName("ssl")
    private String ssl;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("title")
    private String title;

    @SerializedName("ucid")
    private String ucid;

    @SerializedName("url_encoded_fmt_stream_map")
    private String urlEncodedFmtStreamMap;

    @SerializedName(Const.VIDEO_ID)
    private String videoId;

    @SerializedName("vss_host")
    private String vssHost;

    @SerializedName("watermark")
    private String watermark;

    public boolean isShowContentThumbnail() {
        return this.showContentThumbnail;
    }

    public void setShowContentThumbnail(boolean z) {
        this.showContentThumbnail = z;
    }

    public String getHl() {
        return this.hl;
    }

    public void setHl(String str) {
        this.hl = str;
    }

    public String getLengthSeconds() {
        return this.lengthSeconds;
    }

    public void setLengthSeconds(String str) {
        this.lengthSeconds = str;
    }

    public String getGapiHintParams() {
        return this.gapiHintParams;
    }

    public void setGapiHintParams(String str) {
        this.gapiHintParams = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSsl() {
        return this.ssl;
    }

    public void setSsl(String str) {
        this.ssl = str;
    }

    public String getFmtList() {
        return this.fmtList;
    }

    public void setFmtList(String str) {
        this.fmtList = str;
    }

    public String getCver() {
        return this.cver;
    }

    public void setCver(String str) {
        this.cver = str;
    }

    public String getEnablecsi() {
        return this.enablecsi;
    }

    public void setEnablecsi(String str) {
        this.enablecsi = str;
    }

    public String getVssHost() {
        return this.vssHost;
    }

    public void setVssHost(String str) {
        this.vssHost = str;
    }

    public String getCsiPageType() {
        return this.csiPageType;
    }

    public void setCsiPageType(String str) {
        this.csiPageType = str;
    }

    public String getFexp() {
        return this.fexp;
    }

    public void setFexp(String str) {
        this.fexp = str;
    }

    public String getInnertubeContextClientVersion() {
        return this.innertubeContextClientVersion;
    }

    public void setInnertubeContextClientVersion(String str) {
        this.innertubeContextClientVersion = str;
    }

    public String getAccountPlaybackToken() {
        return this.accountPlaybackToken;
    }

    public void setAccountPlaybackToken(String str) {
        this.accountPlaybackToken = str;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public String getUcid() {
        return this.ucid;
    }

    public void setUcid(String str) {
        this.ucid = str;
    }

    public String getWatermark() {
        return this.watermark;
    }

    public void setWatermark(String str) {
        this.watermark = str;
    }

    public String getUrlEncodedFmtStreamMap() {
        return this.urlEncodedFmtStreamMap;
    }

    public void setUrlEncodedFmtStreamMap(String str) {
        this.urlEncodedFmtStreamMap = str;
    }

    public String getC() {
        return this.C;
    }

    public void setC(String str) {
        this.C = str;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public PlayerResponse getPlayerResponse() {
        return this.playerResponse;
    }

    public void setPlayerResponse(PlayerResponse playerResponse) {
        this.playerResponse = playerResponse;
    }

    public String getEnabledEngageTypes() {
        return this.enabledEngageTypes;
    }

    public void setEnabledEngageTypes(String str) {
        this.enabledEngageTypes = str;
    }

    public String getInnertubeApiKey() {
        return this.innertubeApiKey;
    }

    public void setInnertubeApiKey(String str) {
        this.innertubeApiKey = str;
    }

    public String getCr() {
        return this.cr;
    }

    public void setCr(String str) {
        this.cr = str;
    }

    public String getHostLanguage() {
        return this.hostLanguage;
    }

    public void setHostLanguage(String str) {
        this.hostLanguage = str;
    }

    public String getInnertubeApiVersion() {
        return this.innertubeApiVersion;
    }

    public void setInnertubeApiVersion(String str) {
        this.innertubeApiVersion = str;
    }

    public String getLoaderUrl() {
        return this.loaderUrl;
    }

    public void setLoaderUrl(String str) {
        this.loaderUrl = str;
    }

    public String getAdaptiveFmts() {
        return this.adaptiveFmts;
    }

    public void setAdaptiveFmts(String str) {
        this.adaptiveFmts = str;
    }

    public String getEnablejsapi() {
        return this.enablejsapi;
    }

    public void setEnablejsapi(String str) {
        this.enablejsapi = str;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public String getFflags() {
        return this.fflags;
    }

    public void setFflags(String str) {
        this.fflags = str;
    }

    public String toString() {
        return "Args{show_content_thumbnail = '" + this.showContentThumbnail + "',hl = '" + this.hl + "',length_seconds = '" + this.lengthSeconds + "',gapi_hint_params = '" + this.gapiHintParams + "',title = '" + this.title + "',ssl = '" + this.ssl + "',fmt_list = '" + this.fmtList + "',cver = '" + this.cver + "',enablecsi = '" + this.enablecsi + "',vss_host = '" + this.vssHost + "',csi_page_type = '" + this.csiPageType + "',fexp = '" + this.fexp + "',innertube_context_client_version = '" + this.innertubeContextClientVersion + "',account_playback_token = '" + this.accountPlaybackToken + "',timestamp = '" + this.timestamp + "',ucid = '" + this.ucid + "',watermark = '" + this.watermark + "',url_encoded_fmt_stream_map = '" + this.urlEncodedFmtStreamMap + "',c = '" + this.C + "',author = '" + this.author + "',player_response = '" + this.playerResponse + "',enabled_engage_types = '" + this.enabledEngageTypes + "',innertube_api_key = '" + this.innertubeApiKey + "',cr = '" + this.cr + "',host_language = '" + this.hostLanguage + "',innertube_api_version = '" + this.innertubeApiVersion + "',loaderUrl = '" + this.loaderUrl + "',adaptive_fmts = '" + this.adaptiveFmts + "',enablejsapi = '" + this.enablejsapi + "',video_id = '" + this.videoId + "',fflags = '" + this.fflags + "'}";
    }
}
