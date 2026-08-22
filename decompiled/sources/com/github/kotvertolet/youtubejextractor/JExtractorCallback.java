package com.github.kotvertolet.youtubejextractor;

import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.models.newModels.VideoPlayerConfig;

/* JADX INFO: loaded from: classes7.dex */
public interface JExtractorCallback {
    void onError(Exception exc);

    void onNetworkException(YoutubeRequestException youtubeRequestException);

    void onSuccess(VideoPlayerConfig videoPlayerConfig);
}
