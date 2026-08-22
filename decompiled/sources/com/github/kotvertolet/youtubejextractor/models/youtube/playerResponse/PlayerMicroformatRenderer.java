package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class PlayerMicroformatRenderer implements Serializable {
    private List<String> availableCountries;
    private String category;
    private Description description;
    private Embed embed;
    private String externalChannelId;
    private boolean hasYpcMetadata;
    private boolean isFamilySafe;
    private boolean isUnlisted;
    private String lengthSeconds;
    private String ownerChannelName;
    private String ownerGplusProfileUrl;
    private String ownerProfileUrl;
    private String publishDate;
    private Thumbnail thumbnail;
    private Title title;
    private String uploadDate;
    private String viewCount;

    public Thumbnail getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getOwnerGplusProfileUrl() {
        return this.ownerGplusProfileUrl;
    }

    public void setOwnerGplusProfileUrl(String str) {
        this.ownerGplusProfileUrl = str;
    }

    public String getExternalChannelId() {
        return this.externalChannelId;
    }

    public void setExternalChannelId(String str) {
        this.externalChannelId = str;
    }

    public String getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(String str) {
        this.publishDate = str;
    }

    public Description getDescription() {
        return this.description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getLengthSeconds() {
        return this.lengthSeconds;
    }

    public void setLengthSeconds(String str) {
        this.lengthSeconds = str;
    }

    public Title getTitle() {
        return this.title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public boolean isHasYpcMetadata() {
        return this.hasYpcMetadata;
    }

    public void setHasYpcMetadata(boolean z) {
        this.hasYpcMetadata = z;
    }

    public String getOwnerChannelName() {
        return this.ownerChannelName;
    }

    public void setOwnerChannelName(String str) {
        this.ownerChannelName = str;
    }

    public String getUploadDate() {
        return this.uploadDate;
    }

    public void setUploadDate(String str) {
        this.uploadDate = str;
    }

    public String getOwnerProfileUrl() {
        return this.ownerProfileUrl;
    }

    public void setOwnerProfileUrl(String str) {
        this.ownerProfileUrl = str;
    }

    public boolean isIsUnlisted() {
        return this.isUnlisted;
    }

    public void setIsUnlisted(boolean z) {
        this.isUnlisted = z;
    }

    public Embed getEmbed() {
        return this.embed;
    }

    public void setEmbed(Embed embed) {
        this.embed = embed;
    }

    public String getViewCount() {
        return this.viewCount;
    }

    public void setViewCount(String str) {
        this.viewCount = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public boolean isIsFamilySafe() {
        return this.isFamilySafe;
    }

    public void setIsFamilySafe(boolean z) {
        this.isFamilySafe = z;
    }

    public List<String> getAvailableCountries() {
        return this.availableCountries;
    }

    public void setAvailableCountries(List<String> list) {
        this.availableCountries = list;
    }

    public String toString() {
        return "PlayerMicroformatRenderer{thumbnail = '" + this.thumbnail + "',ownerGplusProfileUrl = '" + this.ownerGplusProfileUrl + "',externalChannelId = '" + this.externalChannelId + "',publishDate = '" + this.publishDate + "',description = '" + this.description + "',lengthSeconds = '" + this.lengthSeconds + "',title = '" + this.title + "',hasYpcMetadata = '" + this.hasYpcMetadata + "',ownerChannelName = '" + this.ownerChannelName + "',uploadDate = '" + this.uploadDate + "',ownerProfileUrl = '" + this.ownerProfileUrl + "',isUnlisted = '" + this.isUnlisted + "',embed = '" + this.embed + "',viewCount = '" + this.viewCount + "',category = '" + this.category + "',isFamilySafe = '" + this.isFamilySafe + "',availableCountries = '" + this.availableCountries + "'}";
    }
}
