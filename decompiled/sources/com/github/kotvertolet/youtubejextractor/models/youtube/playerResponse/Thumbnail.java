package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class Thumbnail implements Serializable {
    private List<ThumbnailsItem> thumbnails;

    public List<ThumbnailsItem> getThumbnails() {
        return this.thumbnails;
    }

    public void setThumbnails(List<ThumbnailsItem> list) {
        this.thumbnails = list;
    }

    public String toString() {
        return "Thumbnail{thumbnails = '" + this.thumbnails + "'}";
    }
}
