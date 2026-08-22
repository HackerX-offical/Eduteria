package com.appnew.android.JWextractor;

import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public interface JWPlayerExtractorCallBack {
    void onExtractorError(int responseCode, String error);

    void onExtractorSuccess(int responseCode, HashMap<Integer, String> mediaResponseMap, boolean isVideoLive);
}
