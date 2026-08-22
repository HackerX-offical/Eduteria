package com.appnew.android.player;

import android.content.Context;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DefaultDataSourceFactory;
import androidx.media3.exoplayer.source.MergingMediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.eduteria.app.app.R;
import com.github.kotvertolet.youtubejextractor.YoutubeJExtractor;
import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.models.AdaptiveAudioStream;
import com.github.kotvertolet.youtubejextractor.models.AdaptiveVideoStream;
import com.github.kotvertolet.youtubejextractor.models.newModels.VideoPlayerConfig;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.MuxedStream;
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.StreamingData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: YoutubeVideoExtractor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0013\u001a\u00020\nH\u0002J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0006\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/appnew/android/player/YoutubeVideoExtractor;", "Ljava/lang/Thread;", "videoId", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "Lcom/github/kotvertolet/youtubejextractor/models/youtube/playerResponse/MuxedStream;", "", "<init>", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "getVideoId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getListener", "()Lkotlin/jvm/functions/Function1;", "extractYoutubeVideos", "extractYoutubeVideosMerged", "extractYoutubeVideosAudio", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class YoutubeVideoExtractor extends Thread {
    public static final int $stable = 8;
    private final Context context;
    private final Function1<List<MuxedStream>, Unit> listener;
    private final String videoId;

    public final String getVideoId() {
        return this.videoId;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function1<List<MuxedStream>, Unit> getListener() {
        return this.listener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public YoutubeVideoExtractor(String videoId, Context context, Function1<? super List<MuxedStream>, Unit> listener) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.videoId = videoId;
        this.context = context;
        this.listener = listener;
        extractYoutubeVideos();
    }

    private final void extractYoutubeVideos() {
        new Thread(new Runnable() { // from class: com.appnew.android.player.YoutubeVideoExtractor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                YoutubeVideoExtractor.extractYoutubeVideos$lambda$1(this.f$0);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void extractYoutubeVideos$lambda$1(YoutubeVideoExtractor youtubeVideoExtractor) {
        try {
            StreamingData streamingData = new YoutubeJExtractor().extract(youtubeVideoExtractor.videoId).getStreamingData();
            List<MuxedStream> muxedStreams = streamingData != null ? streamingData.getMuxedStreams() : null;
            Intrinsics.checkNotNull(muxedStreams, "null cannot be cast to non-null type java.util.ArrayList<com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.MuxedStream>");
            youtubeVideoExtractor.listener.invoke(XtensionFunctionKt.removeDuplicates((ArrayList) muxedStreams));
        } catch (ExtractionException | YoutubeRequestException | Exception unused) {
        }
    }

    public final void extractYoutubeVideosMerged(final String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        new Thread(new Runnable() { // from class: com.appnew.android.player.YoutubeVideoExtractor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                YoutubeVideoExtractor.extractYoutubeVideosMerged$lambda$3(videoId, this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void extractYoutubeVideosMerged$lambda$3(String str, YoutubeVideoExtractor youtubeVideoExtractor) {
        List<AdaptiveVideoStream> adaptiveVideoStreams;
        try {
            VideoPlayerConfig videoPlayerConfigExtract = new YoutubeJExtractor().extract(str);
            Context context = youtubeVideoExtractor.context;
            DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context, context.getString(R.string.app_name)));
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            StreamingData streamingData = videoPlayerConfigExtract.getStreamingData();
            Integer numValueOf = (streamingData == null || (adaptiveVideoStreams = streamingData.getAdaptiveVideoStreams()) == null) ? null : Integer.valueOf(adaptiveVideoStreams.size());
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            for (int i = 0; i < iIntValue; i++) {
                StreamingData streamingData2 = videoPlayerConfigExtract.getStreamingData();
                List<AdaptiveVideoStream> adaptiveVideoStreams2 = streamingData2 != null ? streamingData2.getAdaptiveVideoStreams() : null;
                Intrinsics.checkNotNull(adaptiveVideoStreams2);
                if (StringsKt.equals(adaptiveVideoStreams2.get(i).getExtension(), "mp4", true)) {
                    ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(defaultDataSourceFactory);
                    StreamingData streamingData3 = videoPlayerConfigExtract.getStreamingData();
                    List<AdaptiveVideoStream> adaptiveVideoStreams3 = streamingData3 != null ? streamingData3.getAdaptiveVideoStreams() : null;
                    Intrinsics.checkNotNull(adaptiveVideoStreams3);
                    ProgressiveMediaSource progressiveMediaSourceCreateMediaSource = factory.createMediaSource(MediaItem.fromUri(adaptiveVideoStreams3.get(i).getUrl()));
                    Intrinsics.checkNotNullExpressionValue(progressiveMediaSourceCreateMediaSource, "createMediaSource(...)");
                    ProgressiveMediaSource.Factory factory2 = new ProgressiveMediaSource.Factory(defaultDataSourceFactory);
                    StreamingData streamingData4 = videoPlayerConfigExtract.getStreamingData();
                    List<AdaptiveAudioStream> adaptiveAudioStreams = streamingData4 != null ? streamingData4.getAdaptiveAudioStreams() : null;
                    Intrinsics.checkNotNull(adaptiveAudioStreams);
                    ProgressiveMediaSource progressiveMediaSourceCreateMediaSource2 = factory2.createMediaSource(MediaItem.fromUri(adaptiveAudioStreams.get(i).getUrl()));
                    Intrinsics.checkNotNullExpressionValue(progressiveMediaSourceCreateMediaSource2, "createMediaSource(...)");
                    arrayList.add(new MergingMediaSource(progressiveMediaSourceCreateMediaSource, progressiveMediaSourceCreateMediaSource2));
                }
            }
        } catch (ExtractionException | YoutubeRequestException | Exception unused) {
        }
    }

    private final void extractYoutubeVideosAudio() {
        new Thread(new Runnable() { // from class: com.appnew.android.player.YoutubeVideoExtractor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                YoutubeVideoExtractor.extractYoutubeVideosAudio$lambda$5(this.f$0);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void extractYoutubeVideosAudio$lambda$5(YoutubeVideoExtractor youtubeVideoExtractor) {
        List<AdaptiveAudioStream> adaptiveAudioStreams;
        try {
            VideoPlayerConfig videoPlayerConfigExtract = new YoutubeJExtractor().extract(youtubeVideoExtractor.videoId);
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            StreamingData streamingData = videoPlayerConfigExtract.getStreamingData();
            Integer numValueOf = (streamingData == null || (adaptiveAudioStreams = streamingData.getAdaptiveAudioStreams()) == null) ? null : Integer.valueOf(adaptiveAudioStreams.size());
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            for (int i = 0; i < iIntValue; i++) {
                StreamingData streamingData2 = videoPlayerConfigExtract.getStreamingData();
                List<AdaptiveVideoStream> adaptiveVideoStreams = streamingData2 != null ? streamingData2.getAdaptiveVideoStreams() : null;
                Intrinsics.checkNotNull(adaptiveVideoStreams);
                if (StringsKt.equals(adaptiveVideoStreams.get(i).getExtension(), "mp4", true)) {
                    StreamingData streamingData3 = videoPlayerConfigExtract.getStreamingData();
                    List<AdaptiveAudioStream> adaptiveAudioStreams2 = streamingData3 != null ? streamingData3.getAdaptiveAudioStreams() : null;
                    Intrinsics.checkNotNull(adaptiveAudioStreams2);
                    arrayList.add(adaptiveAudioStreams2.get(i));
                }
            }
        } catch (ExtractionException | YoutubeRequestException | Exception unused) {
        }
    }
}
