package com.appnew.android.Utils;

import android.view.View;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class videoPlayerDownloadManager {
    public static LinkedHashMap<Long, View> downloadRequests = new LinkedHashMap<>();
    public static videoPlayerDownloadManager eMedicozdownloadmanager;

    public static videoPlayerDownloadManager getInstance() {
        videoPlayerDownloadManager videoplayerdownloadmanager = eMedicozdownloadmanager;
        return videoplayerdownloadmanager == null ? new videoPlayerDownloadManager() : videoplayerdownloadmanager;
    }
}
