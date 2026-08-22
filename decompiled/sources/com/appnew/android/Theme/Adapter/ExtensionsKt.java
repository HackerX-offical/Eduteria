package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: extensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"load", "", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "url", "", "loadGIF", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExtensionsKt {
    public static final void load(ImageView imageView, Context context, String url) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Glide.with(context).load(url).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder)).into(imageView);
    }

    public static final void loadGIF(ImageView imageView, Context context, String url) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Glide.with(context).asGif().load(url).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder)).into(imageView);
    }
}
