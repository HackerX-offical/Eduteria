package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewYouTubePlayer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0004"}, d2 = {"readHTMLFromUTF8File", "", "inputStream", "Ljava/io/InputStream;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WebViewYouTubePlayerKt {
    public static final String readHTMLFromUTF8File(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        InputStream inputStream2 = inputStream;
        try {
            try {
                String strJoinToString$default = CollectionsKt.joinToString$default(TextStreamsKt.readLines(new BufferedReader(new InputStreamReader(inputStream, "utf-8"))), "\n", null, null, 0, null, null, 62, null);
                CloseableKt.closeFinally(inputStream2, null);
                return strJoinToString$default;
            } catch (Exception unused) {
                throw new RuntimeException("Can't parse HTML file.");
            }
        } finally {
        }
    }
}
