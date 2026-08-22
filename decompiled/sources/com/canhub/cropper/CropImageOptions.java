package com.canhub.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.core.internal.view.SupportMenu;
import androidx.work.WorkInfo;
import com.canhub.cropper.CropImageView;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CropImageOptions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\bW\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bá\u0005\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\n\u0012\b\b\u0003\u0010\u000b\u001a\u00020\n\u0012\b\b\u0003\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0015\u0012\b\b\u0003\u0010\u001f\u001a\u00020\n\u0012\b\b\u0003\u0010 \u001a\u00020\u0015\u0012\b\b\u0003\u0010!\u001a\u00020\n\u0012\b\b\u0003\u0010\"\u001a\u00020\n\u0012\b\b\u0003\u0010#\u001a\u00020\n\u0012\b\b\u0003\u0010$\u001a\u00020\u0015\u0012\b\b\u0003\u0010%\u001a\u00020\u0015\u0012\b\b\u0003\u0010&\u001a\u00020\n\u0012\b\b\u0003\u0010'\u001a\u00020\u0015\u0012\b\b\u0003\u0010(\u001a\u00020\u0015\u0012\b\b\u0003\u0010)\u001a\u00020\u0015\u0012\b\b\u0003\u0010*\u001a\u00020\u0015\u0012\b\b\u0003\u0010+\u001a\u00020\u0015\u0012\b\b\u0003\u0010,\u001a\u00020\u0015\u0012\b\b\u0003\u0010-\u001a\u00020\u0015\u0012\b\b\u0003\u0010.\u001a\u00020\u0015\u0012\b\b\u0002\u0010/\u001a\u000200\u0012\b\b\u0003\u00101\u001a\u00020\u0015\u0012\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00105\u001a\u000206\u0012\b\b\u0002\u00107\u001a\u00020\u0015\u0012\b\b\u0003\u00108\u001a\u00020\u0015\u0012\b\b\u0003\u00109\u001a\u00020\u0015\u0012\b\b\u0002\u0010:\u001a\u00020;\u0012\b\b\u0002\u0010<\u001a\u00020\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010?\u001a\u00020\u0015\u0012\b\b\u0002\u0010@\u001a\u00020\u0003\u0012\b\b\u0002\u0010A\u001a\u00020\u0003\u0012\b\b\u0002\u0010B\u001a\u00020\u0003\u0012\b\b\u0002\u0010C\u001a\u00020\u0015\u0012\b\b\u0002\u0010D\u001a\u00020\u0003\u0012\b\b\u0002\u0010E\u001a\u00020\u0003\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u000100\u0012\b\b\u0003\u0010G\u001a\u00020\u0015\u0012\b\b\u0002\u0010H\u001a\u00020\u0003\u0012\b\b\u0002\u0010I\u001a\u00020\u0003\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K\u0012\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010M\u0012\b\b\u0003\u0010N\u001a\u00020\n\u0012\b\b\u0003\u0010O\u001a\u00020\u0015\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010K\u0012\b\b\u0003\u0010Q\u001a\u00020\u0015\u0012\n\b\u0003\u0010R\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0003\u0010S\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0003\u0010T\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0003\u0010U\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bV\u0010WJ\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\t\u0010\\\u001a\u00020\bHÆ\u0003J\t\u0010]\u001a\u00020\nHÆ\u0003J\t\u0010^\u001a\u00020\nHÆ\u0003J\t\u0010_\u001a\u00020\nHÆ\u0003J\t\u0010`\u001a\u00020\u000eHÆ\u0003J\t\u0010a\u001a\u00020\u0010HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0015HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0015HÆ\u0003J\t\u0010k\u001a\u00020\nHÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0015HÆ\u0003J\t\u0010n\u001a\u00020\u0015HÆ\u0003J\t\u0010o\u001a\u00020\nHÆ\u0003J\t\u0010p\u001a\u00020\u0015HÆ\u0003J\t\u0010q\u001a\u00020\nHÆ\u0003J\t\u0010r\u001a\u00020\nHÆ\u0003J\t\u0010s\u001a\u00020\nHÆ\u0003J\t\u0010t\u001a\u00020\u0015HÆ\u0003J\t\u0010u\u001a\u00020\u0015HÆ\u0003J\t\u0010v\u001a\u00020\nHÆ\u0003J\t\u0010w\u001a\u00020\u0015HÆ\u0003J\t\u0010x\u001a\u00020\u0015HÆ\u0003J\t\u0010y\u001a\u00020\u0015HÆ\u0003J\t\u0010z\u001a\u00020\u0015HÆ\u0003J\t\u0010{\u001a\u00020\u0015HÆ\u0003J\t\u0010|\u001a\u00020\u0015HÆ\u0003J\t\u0010}\u001a\u00020\u0015HÆ\u0003J\t\u0010~\u001a\u00020\u0015HÆ\u0003J\t\u0010\u007f\u001a\u000200HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0015HÆ\u0003J\u0012\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\f\u0010\u0083\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\n\u0010\u0084\u0001\u001a\u000206HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020;HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010>HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010KHÆ\u0003J\u0012\u0010\u0097\u0001\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010MHÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0015HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010KHÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0015HÆ\u0003J\u0012\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\u0012\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\u0012\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\u0012\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001Jè\u0005\u0010 \u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0003\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00152\b\b\u0003\u0010\u001f\u001a\u00020\n2\b\b\u0003\u0010 \u001a\u00020\u00152\b\b\u0003\u0010!\u001a\u00020\n2\b\b\u0003\u0010\"\u001a\u00020\n2\b\b\u0003\u0010#\u001a\u00020\n2\b\b\u0003\u0010$\u001a\u00020\u00152\b\b\u0003\u0010%\u001a\u00020\u00152\b\b\u0003\u0010&\u001a\u00020\n2\b\b\u0003\u0010'\u001a\u00020\u00152\b\b\u0003\u0010(\u001a\u00020\u00152\b\b\u0003\u0010)\u001a\u00020\u00152\b\b\u0003\u0010*\u001a\u00020\u00152\b\b\u0003\u0010+\u001a\u00020\u00152\b\b\u0003\u0010,\u001a\u00020\u00152\b\b\u0003\u0010-\u001a\u00020\u00152\b\b\u0003\u0010.\u001a\u00020\u00152\b\b\u0002\u0010/\u001a\u0002002\b\b\u0003\u00101\u001a\u00020\u00152\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00152\b\b\u0003\u00108\u001a\u00020\u00152\b\b\u0003\u00109\u001a\u00020\u00152\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010?\u001a\u00020\u00152\b\b\u0002\u0010@\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020\u00152\b\b\u0002\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020\u00032\n\b\u0002\u0010F\u001a\u0004\u0018\u0001002\b\b\u0003\u0010G\u001a\u00020\u00152\b\b\u0002\u0010H\u001a\u00020\u00032\b\b\u0002\u0010I\u001a\u00020\u00032\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K2\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010M2\b\b\u0003\u0010N\u001a\u00020\n2\b\b\u0003\u0010O\u001a\u00020\u00152\n\b\u0002\u0010P\u001a\u0004\u0018\u00010K2\b\b\u0003\u0010Q\u001a\u00020\u00152\n\b\u0003\u0010R\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010S\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010T\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010U\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0003\u0010¡\u0001J\u0007\u0010¢\u0001\u001a\u00020\u0015J\u0016\u0010£\u0001\u001a\u00020\u00032\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001HÖ\u0003J\n\u0010¦\u0001\u001a\u00020\u0015HÖ\u0001J\n\u0010§\u0001\u001a\u00020KHÖ\u0001J\u001b\u0010¨\u0001\u001a\u00030©\u00012\b\u0010ª\u0001\u001a\u00030«\u00012\u0007\u0010¬\u0001\u001a\u00020\u0015R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010XR\u0014\u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00020;8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010@\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010E\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010G\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010I\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010N\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010O\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Q\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010R\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010XR\u0016\u0010S\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010XR\u0016\u0010T\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010XR\u0016\u0010U\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010X¨\u0006\u00ad\u0001"}, d2 = {"Lcom/canhub/cropper/CropImageOptions;", "Landroid/os/Parcelable;", "imageSourceIncludeGallery", "", "imageSourceIncludeCamera", "cropShape", "Lcom/canhub/cropper/CropImageView$CropShape;", "cornerShape", "Lcom/canhub/cropper/CropImageView$CropCornerShape;", "cropCornerRadius", "", "snapRadius", "touchRadius", "guidelines", "Lcom/canhub/cropper/CropImageView$Guidelines;", "scaleType", "Lcom/canhub/cropper/CropImageView$ScaleType;", "showCropOverlay", "showCropLabel", "showProgressBar", "progressBarColor", "", "autoZoomEnabled", "multiTouchEnabled", "centerMoveEnabled", "canChangeCropWindow", "maxZoom", "initialCropWindowPaddingRatio", "fixAspectRatio", "aspectRatioX", "aspectRatioY", "borderLineThickness", "borderLineColor", "borderCornerThickness", "borderCornerOffset", "borderCornerLength", "borderCornerColor", "circleCornerFillColorHexValue", "guidelinesThickness", "guidelinesColor", "backgroundColor", "minCropWindowWidth", "minCropWindowHeight", "minCropResultWidth", "minCropResultHeight", "maxCropResultWidth", "maxCropResultHeight", "activityTitle", "", "activityMenuIconColor", "activityMenuTextColor", "customOutputUri", "Landroid/net/Uri;", "outputCompressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "outputCompressQuality", "outputRequestWidth", "outputRequestHeight", "outputRequestSizeOptions", "Lcom/canhub/cropper/CropImageView$RequestSizeOptions;", "noOutputImage", "initialCropWindowRectangle", "Landroid/graphics/Rect;", "initialRotation", "allowRotation", "allowFlipping", "allowCounterRotation", "rotationDegrees", "flipHorizontally", "flipVertically", "cropMenuCropButtonTitle", "cropMenuCropButtonIcon", "skipEditing", "showIntentChooser", "intentChooserTitle", "", "intentChooserPriorityList", "", "cropperLabelTextSize", "cropperLabelTextColor", "cropperLabelText", "activityBackgroundColor", "toolbarColor", "toolbarTitleColor", "toolbarBackButtonColor", "toolbarTintColor", "<init>", "(ZZLcom/canhub/cropper/CropImageView$CropShape;Lcom/canhub/cropper/CropImageView$CropCornerShape;FFFLcom/canhub/cropper/CropImageView$Guidelines;Lcom/canhub/cropper/CropImageView$ScaleType;ZZZIZZZZIFZIIFIFFFIIFIIIIIIIILjava/lang/CharSequence;ILjava/lang/Integer;Landroid/net/Uri;Landroid/graphics/Bitmap$CompressFormat;IIILcom/canhub/cropper/CropImageView$RequestSizeOptions;ZLandroid/graphics/Rect;IZZZIZZLjava/lang/CharSequence;IZZLjava/lang/String;Ljava/util/List;FILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "()Ljava/lang/Integer;", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", Constants.COPY_TYPE, "(ZZLcom/canhub/cropper/CropImageView$CropShape;Lcom/canhub/cropper/CropImageView$CropCornerShape;FFFLcom/canhub/cropper/CropImageView$Guidelines;Lcom/canhub/cropper/CropImageView$ScaleType;ZZZIZZZZIFZIIFIFFFIIFIIIIIIIILjava/lang/CharSequence;ILjava/lang/Integer;Landroid/net/Uri;Landroid/graphics/Bitmap$CompressFormat;IIILcom/canhub/cropper/CropImageView$RequestSizeOptions;ZLandroid/graphics/Rect;IZZZIZZLjava/lang/CharSequence;IZZLjava/lang/String;Ljava/util/List;FILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/canhub/cropper/CropImageOptions;", "describeContents", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class CropImageOptions implements Parcelable {
    public static final Parcelable.Creator<CropImageOptions> CREATOR = new Creator();
    public int activityBackgroundColor;
    public int activityMenuIconColor;
    public Integer activityMenuTextColor;
    public CharSequence activityTitle;
    public boolean allowCounterRotation;
    public boolean allowFlipping;
    public boolean allowRotation;
    public int aspectRatioX;
    public int aspectRatioY;
    public boolean autoZoomEnabled;
    public int backgroundColor;
    public int borderCornerColor;
    public float borderCornerLength;
    public float borderCornerOffset;
    public float borderCornerThickness;
    public int borderLineColor;
    public float borderLineThickness;
    public boolean canChangeCropWindow;
    public boolean centerMoveEnabled;
    public int circleCornerFillColorHexValue;
    public CropImageView.CropCornerShape cornerShape;
    public float cropCornerRadius;
    public int cropMenuCropButtonIcon;
    public CharSequence cropMenuCropButtonTitle;
    public CropImageView.CropShape cropShape;
    public String cropperLabelText;
    public int cropperLabelTextColor;
    public float cropperLabelTextSize;
    public Uri customOutputUri;
    public boolean fixAspectRatio;
    public boolean flipHorizontally;
    public boolean flipVertically;
    public CropImageView.Guidelines guidelines;
    public int guidelinesColor;
    public float guidelinesThickness;
    public boolean imageSourceIncludeCamera;
    public boolean imageSourceIncludeGallery;
    public float initialCropWindowPaddingRatio;
    public Rect initialCropWindowRectangle;
    public int initialRotation;
    public List<String> intentChooserPriorityList;
    public String intentChooserTitle;
    public int maxCropResultHeight;
    public int maxCropResultWidth;
    public int maxZoom;
    public int minCropResultHeight;
    public int minCropResultWidth;
    public int minCropWindowHeight;
    public int minCropWindowWidth;
    public boolean multiTouchEnabled;
    public boolean noOutputImage;
    public Bitmap.CompressFormat outputCompressFormat;
    public int outputCompressQuality;
    public int outputRequestHeight;
    public CropImageView.RequestSizeOptions outputRequestSizeOptions;
    public int outputRequestWidth;
    public int progressBarColor;
    public int rotationDegrees;
    public CropImageView.ScaleType scaleType;
    public boolean showCropLabel;
    public boolean showCropOverlay;
    public boolean showIntentChooser;
    public boolean showProgressBar;
    public boolean skipEditing;
    public float snapRadius;
    public Integer toolbarBackButtonColor;
    public Integer toolbarColor;
    public Integer toolbarTintColor;
    public Integer toolbarTitleColor;
    public float touchRadius;

    /* JADX INFO: compiled from: CropImageOptions.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CropImageOptions> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CropImageOptions createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            CropImageView.Guidelines guidelines;
            CropImageView.ScaleType scaleType;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            int i;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            Integer num;
            boolean z13;
            Integer num2;
            boolean z14;
            boolean z15;
            Integer num3;
            Uri uri;
            boolean z16;
            Integer num4;
            boolean z17;
            boolean z18;
            Integer num5;
            boolean z19;
            boolean z20;
            boolean z21;
            CropImageView.RequestSizeOptions requestSizeOptions;
            Rect rect;
            boolean z22;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z23 = true;
            boolean z24 = false;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = true;
                z23 = false;
            }
            if (parcel.readInt() != 0) {
                z2 = false;
                z24 = z;
            } else {
                z2 = false;
            }
            CropImageView.CropShape cropShapeValueOf = CropImageView.CropShape.valueOf(parcel.readString());
            CropImageView.CropCornerShape cropCornerShapeValueOf = CropImageView.CropCornerShape.valueOf(parcel.readString());
            boolean z25 = z2;
            float f2 = parcel.readFloat();
            float f3 = parcel.readFloat();
            float f4 = parcel.readFloat();
            CropImageView.Guidelines guidelinesValueOf = CropImageView.Guidelines.valueOf(parcel.readString());
            CropImageView.ScaleType scaleTypeValueOf = CropImageView.ScaleType.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                z3 = z25;
                guidelines = guidelinesValueOf;
                scaleType = scaleTypeValueOf;
                z4 = z;
            } else {
                z3 = z25;
                guidelines = guidelinesValueOf;
                scaleType = scaleTypeValueOf;
                z4 = z3;
            }
            if (parcel.readInt() != 0) {
                z5 = z3;
                z3 = z;
            } else {
                z5 = z3;
            }
            if (parcel.readInt() != 0) {
                z6 = z5;
                z5 = z;
            } else {
                z6 = z5;
            }
            int i2 = parcel.readInt();
            if (parcel.readInt() != 0) {
                z7 = z6;
                i = i2;
                z8 = z;
            } else {
                z7 = z6;
                i = i2;
                z8 = z7;
            }
            if (parcel.readInt() != 0) {
                z9 = z7;
                z7 = z;
            } else {
                z9 = z7;
            }
            if (parcel.readInt() != 0) {
                z10 = z9;
                z9 = z;
            } else {
                z10 = z9;
            }
            if (parcel.readInt() != 0) {
                z11 = z10;
                z10 = z;
            } else {
                z11 = z10;
            }
            int i3 = parcel.readInt();
            boolean z26 = z11;
            float f5 = parcel.readFloat();
            if (parcel.readInt() != 0) {
                z12 = z26;
                z26 = z;
            } else {
                z12 = z26;
            }
            int i4 = parcel.readInt();
            boolean z27 = z12;
            int i5 = parcel.readInt();
            float f6 = parcel.readFloat();
            int i6 = parcel.readInt();
            float f7 = parcel.readFloat();
            float f8 = parcel.readFloat();
            float f9 = parcel.readFloat();
            int i7 = parcel.readInt();
            int i8 = parcel.readInt();
            float f10 = parcel.readFloat();
            int i9 = parcel.readInt();
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            int i14 = parcel.readInt();
            int i15 = parcel.readInt();
            int i16 = parcel.readInt();
            CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            int i17 = parcel.readInt();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Uri uri2 = (Uri) parcel.readParcelable(CropImageOptions.class.getClassLoader());
            Bitmap.CompressFormat compressFormatValueOf = Bitmap.CompressFormat.valueOf(parcel.readString());
            int i18 = parcel.readInt();
            int i19 = parcel.readInt();
            int i20 = parcel.readInt();
            CropImageView.RequestSizeOptions requestSizeOptionsValueOf = CropImageView.RequestSizeOptions.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                num = null;
                z13 = true;
            } else {
                num = null;
                z13 = z27;
            }
            Rect rect2 = (Rect) parcel.readParcelable(CropImageOptions.class.getClassLoader());
            Integer num6 = num;
            int i21 = parcel.readInt();
            if (parcel.readInt() != 0) {
                num2 = num6;
                z14 = true;
            } else {
                num2 = num6;
                z14 = z27;
            }
            if (parcel.readInt() != 0) {
                z15 = true;
                num3 = numValueOf;
                uri = uri2;
                z16 = true;
            } else {
                z15 = true;
                num3 = numValueOf;
                uri = uri2;
                z16 = z27;
            }
            if (parcel.readInt() != 0) {
                num4 = num2;
                z18 = z15;
                z17 = z18;
            } else {
                num4 = num2;
                z17 = z15;
                z18 = z27;
            }
            int i22 = parcel.readInt();
            if (parcel.readInt() != 0) {
                num5 = num4;
                z19 = z17;
            } else {
                num5 = num4;
                z19 = z27;
            }
            if (parcel.readInt() != 0) {
                z20 = z17;
            } else {
                z20 = z17;
                z17 = z27;
            }
            CharSequence charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            boolean z28 = z20;
            int i23 = parcel.readInt();
            if (parcel.readInt() != 0) {
                z21 = z27;
                requestSizeOptions = requestSizeOptionsValueOf;
                rect = rect2;
                z22 = z28;
            } else {
                z21 = z27;
                requestSizeOptions = requestSizeOptionsValueOf;
                rect = rect2;
                z22 = z21;
            }
            if (parcel.readInt() == 0) {
                z28 = z21;
            }
            return new CropImageOptions(z23, z24, cropShapeValueOf, cropCornerShapeValueOf, f2, f3, f4, guidelines, scaleType, z4, z3, z5, i, z8, z7, z9, z10, i3, f5, z26, i4, i5, f6, i6, f7, f8, f9, i7, i8, f10, i9, i10, i11, i12, i13, i14, i15, i16, charSequence, i17, num3, uri, compressFormatValueOf, i18, i19, i20, requestSizeOptions, z13, rect, i21, z14, z16, z18, i22, z19, z17, charSequence2, i23, z22, z28, parcel.readString(), parcel.createStringArrayList(), parcel.readFloat(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() == 0 ? num5 : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? num5 : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? num5 : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? num5 : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CropImageOptions[] newArray(int i) {
            return new CropImageOptions[i];
        }
    }

    public CropImageOptions() {
        this(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
    }

    public CropImageOptions(boolean z) {
        this(z, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -2, -1, 63, null);
    }

    public CropImageOptions(boolean z, boolean z2) {
        this(z, z2, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -4, -1, 63, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape) {
        this(z, z2, cropShape, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -8, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape) {
        this(z, z2, cropShape, cornerShape, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -16, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2) {
        this(z, z2, cropShape, cornerShape, f2, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -32, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3) {
        this(z, z2, cropShape, cornerShape, f2, f3, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -64, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -256, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, WorkInfo.STOP_REASON_UNKNOWN, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1024, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -2048, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -4096, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -8192, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -16384, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -32768, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, SupportMenu.CATEGORY_MASK, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -131072, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -262144, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -524288, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1048576, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -2097152, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -4194304, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -8388608, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -16777216, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -33554432, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -67108864, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -134217728, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -268435456, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -536870912, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1073741824, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, Integer.MIN_VALUE, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -2, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -4, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -8, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -16, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -32, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -64, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -256, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, WorkInfo.STOP_REASON_UNKNOWN, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -1024, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -2048, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -4096, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -8192, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -16384, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -32768, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, SupportMenu.CATEGORY_MASK, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -131072, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -262144, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -524288, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -1048576, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -2097152, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -4194304, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -8388608, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -16777216, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -33554432, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -67108864, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -134217728, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -268435456, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, null, 0.0f, 0, null, 0, null, null, null, null, 0, -536870912, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, 0.0f, 0, null, 0, null, null, null, null, 0, -1073741824, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f11) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f11, 0, null, 0, null, null, null, null, 0, Integer.MIN_VALUE, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f11, int i23) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f11, i23, null, 0, null, null, null, null, 0, 0, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f11, int i23, String str2) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f11, i23, str2, 0, null, null, null, null, 0, 0, 62, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f11, int i23, String str2, int i24) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f11, i23, str2, i24, null, null, null, null, 0, 0, 60, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f11, int i23, String str2, int i24, Integer num2) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f11, i23, str2, i24, num2, null, null, null, 0, 0, 56, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f11, int i23, String str2, int i24, Integer num2, Integer num3) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f11, i23, str2, i24, num2, num3, null, null, 0, 0, 48, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f11, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4) {
        this(z, z2, cropShape, cornerShape, f2, f3, f4, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f5, z10, i3, i4, f6, i5, f7, f8, f9, i6, i7, f10, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f11, i23, str2, i24, num2, num3, num4, null, 0, 0, 32, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CropImageOptions copy$default(CropImageOptions cropImageOptions, boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cropCornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, Integer num, Uri uri, Bitmap.CompressFormat compressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions requestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence2, int i22, boolean z17, boolean z18, String str, List list, float f11, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4, Integer num5, int i25, int i26, int i27, Object obj) {
        Integer num6;
        Integer num7;
        int i28;
        boolean z19;
        boolean z20;
        CharSequence charSequence3;
        int i29;
        boolean z21;
        boolean z22;
        String str3;
        List list2;
        float f12;
        String str4;
        int i30;
        Integer num8;
        Integer num9;
        int i31;
        int i32;
        Integer num10;
        Uri uri2;
        Bitmap.CompressFormat compressFormat2;
        int i33;
        int i34;
        int i35;
        CropImageView.RequestSizeOptions requestSizeOptions2;
        boolean z23;
        Rect rect2;
        int i36;
        boolean z24;
        boolean z25;
        boolean z26;
        float f13;
        float f14;
        int i37;
        int i38;
        float f15;
        int i39;
        int i40;
        int i41;
        int i42;
        int i43;
        int i44;
        int i45;
        int i46;
        CharSequence charSequence4;
        boolean z27;
        boolean z28;
        int i47;
        boolean z29;
        boolean z30;
        boolean z31;
        int i48;
        float f16;
        boolean z32;
        int i49;
        int i50;
        float f17;
        int i51;
        float f18;
        boolean z33;
        CropImageView.CropShape cropShape2;
        CropImageView.CropCornerShape cropCornerShape2;
        float f19;
        float f20;
        float f21;
        CropImageView.Guidelines guidelines2;
        CropImageView.ScaleType scaleType2;
        boolean z34;
        boolean z35;
        boolean z36 = (i25 & 1) != 0 ? cropImageOptions.imageSourceIncludeGallery : z;
        boolean z37 = (i25 & 2) != 0 ? cropImageOptions.imageSourceIncludeCamera : z2;
        CropImageView.CropShape cropShape3 = (i25 & 4) != 0 ? cropImageOptions.cropShape : cropShape;
        CropImageView.CropCornerShape cropCornerShape3 = (i25 & 8) != 0 ? cropImageOptions.cornerShape : cropCornerShape;
        float f22 = (i25 & 16) != 0 ? cropImageOptions.cropCornerRadius : f2;
        float f23 = (i25 & 32) != 0 ? cropImageOptions.snapRadius : f3;
        float f24 = (i25 & 64) != 0 ? cropImageOptions.touchRadius : f4;
        CropImageView.Guidelines guidelines3 = (i25 & 128) != 0 ? cropImageOptions.guidelines : guidelines;
        CropImageView.ScaleType scaleType3 = (i25 & 256) != 0 ? cropImageOptions.scaleType : scaleType;
        boolean z38 = (i25 & 512) != 0 ? cropImageOptions.showCropOverlay : z3;
        boolean z39 = (i25 & 1024) != 0 ? cropImageOptions.showCropLabel : z4;
        boolean z40 = (i25 & 2048) != 0 ? cropImageOptions.showProgressBar : z5;
        int i52 = (i25 & 4096) != 0 ? cropImageOptions.progressBarColor : i;
        boolean z41 = z36;
        boolean z42 = (i25 & 8192) != 0 ? cropImageOptions.autoZoomEnabled : z6;
        boolean z43 = (i25 & 16384) != 0 ? cropImageOptions.multiTouchEnabled : z7;
        boolean z44 = (i25 & 32768) != 0 ? cropImageOptions.centerMoveEnabled : z8;
        boolean z45 = (i25 & 65536) != 0 ? cropImageOptions.canChangeCropWindow : z9;
        int i53 = (i25 & 131072) != 0 ? cropImageOptions.maxZoom : i2;
        float f25 = (i25 & 262144) != 0 ? cropImageOptions.initialCropWindowPaddingRatio : f5;
        boolean z46 = (i25 & 524288) != 0 ? cropImageOptions.fixAspectRatio : z10;
        int i54 = (i25 & 1048576) != 0 ? cropImageOptions.aspectRatioX : i3;
        int i55 = (i25 & 2097152) != 0 ? cropImageOptions.aspectRatioY : i4;
        float f26 = (i25 & 4194304) != 0 ? cropImageOptions.borderLineThickness : f6;
        int i56 = (i25 & 8388608) != 0 ? cropImageOptions.borderLineColor : i5;
        float f27 = (i25 & 16777216) != 0 ? cropImageOptions.borderCornerThickness : f7;
        float f28 = (i25 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? cropImageOptions.borderCornerOffset : f8;
        float f29 = (i25 & 67108864) != 0 ? cropImageOptions.borderCornerLength : f9;
        int i57 = (i25 & 134217728) != 0 ? cropImageOptions.borderCornerColor : i6;
        int i58 = (i25 & 268435456) != 0 ? cropImageOptions.circleCornerFillColorHexValue : i7;
        float f30 = (i25 & 536870912) != 0 ? cropImageOptions.guidelinesThickness : f10;
        int i59 = (i25 & 1073741824) != 0 ? cropImageOptions.guidelinesColor : i8;
        int i60 = (i25 & Integer.MIN_VALUE) != 0 ? cropImageOptions.backgroundColor : i9;
        int i61 = (i26 & 1) != 0 ? cropImageOptions.minCropWindowWidth : i10;
        int i62 = (i26 & 2) != 0 ? cropImageOptions.minCropWindowHeight : i11;
        int i63 = (i26 & 4) != 0 ? cropImageOptions.minCropResultWidth : i12;
        int i64 = (i26 & 8) != 0 ? cropImageOptions.minCropResultHeight : i13;
        int i65 = (i26 & 16) != 0 ? cropImageOptions.maxCropResultWidth : i14;
        int i66 = (i26 & 32) != 0 ? cropImageOptions.maxCropResultHeight : i15;
        CharSequence charSequence5 = (i26 & 64) != 0 ? cropImageOptions.activityTitle : charSequence;
        int i67 = (i26 & 128) != 0 ? cropImageOptions.activityMenuIconColor : i16;
        Integer num11 = (i26 & 256) != 0 ? cropImageOptions.activityMenuTextColor : num;
        Uri uri3 = (i26 & 512) != 0 ? cropImageOptions.customOutputUri : uri;
        Bitmap.CompressFormat compressFormat3 = (i26 & 1024) != 0 ? cropImageOptions.outputCompressFormat : compressFormat;
        int i68 = (i26 & 2048) != 0 ? cropImageOptions.outputCompressQuality : i17;
        int i69 = (i26 & 4096) != 0 ? cropImageOptions.outputRequestWidth : i18;
        int i70 = (i26 & 8192) != 0 ? cropImageOptions.outputRequestHeight : i19;
        CropImageView.RequestSizeOptions requestSizeOptions3 = (i26 & 16384) != 0 ? cropImageOptions.outputRequestSizeOptions : requestSizeOptions;
        boolean z47 = (i26 & 32768) != 0 ? cropImageOptions.noOutputImage : z11;
        Rect rect3 = (i26 & 65536) != 0 ? cropImageOptions.initialCropWindowRectangle : rect;
        int i71 = (i26 & 131072) != 0 ? cropImageOptions.initialRotation : i20;
        boolean z48 = (i26 & 262144) != 0 ? cropImageOptions.allowRotation : z12;
        boolean z49 = (i26 & 524288) != 0 ? cropImageOptions.allowFlipping : z13;
        boolean z50 = (i26 & 1048576) != 0 ? cropImageOptions.allowCounterRotation : z14;
        int i72 = (i26 & 2097152) != 0 ? cropImageOptions.rotationDegrees : i21;
        boolean z51 = (i26 & 4194304) != 0 ? cropImageOptions.flipHorizontally : z15;
        boolean z52 = (i26 & 8388608) != 0 ? cropImageOptions.flipVertically : z16;
        CharSequence charSequence6 = (i26 & 16777216) != 0 ? cropImageOptions.cropMenuCropButtonTitle : charSequence2;
        int i73 = (i26 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? cropImageOptions.cropMenuCropButtonIcon : i22;
        boolean z53 = (i26 & 67108864) != 0 ? cropImageOptions.skipEditing : z17;
        boolean z54 = (i26 & 134217728) != 0 ? cropImageOptions.showIntentChooser : z18;
        String str5 = (i26 & 268435456) != 0 ? cropImageOptions.intentChooserTitle : str;
        List list3 = (i26 & 536870912) != 0 ? cropImageOptions.intentChooserPriorityList : list;
        float f31 = (i26 & 1073741824) != 0 ? cropImageOptions.cropperLabelTextSize : f11;
        int i74 = (i26 & Integer.MIN_VALUE) != 0 ? cropImageOptions.cropperLabelTextColor : i23;
        float f32 = f31;
        String str6 = (i27 & 1) != 0 ? cropImageOptions.cropperLabelText : str2;
        int i75 = (i27 & 2) != 0 ? cropImageOptions.activityBackgroundColor : i24;
        Integer num12 = (i27 & 4) != 0 ? cropImageOptions.toolbarColor : num2;
        Integer num13 = (i27 & 8) != 0 ? cropImageOptions.toolbarTitleColor : num3;
        Integer num14 = (i27 & 16) != 0 ? cropImageOptions.toolbarBackButtonColor : num4;
        if ((i27 & 32) != 0) {
            num7 = num14;
            num6 = cropImageOptions.toolbarTintColor;
            z19 = z51;
            z20 = z52;
            charSequence3 = charSequence6;
            i29 = i73;
            z21 = z53;
            z22 = z54;
            str3 = str5;
            list2 = list3;
            f12 = f32;
            str4 = str6;
            i30 = i75;
            num8 = num12;
            num9 = num13;
            i31 = i74;
            num10 = num11;
            uri2 = uri3;
            compressFormat2 = compressFormat3;
            i33 = i68;
            i34 = i69;
            i35 = i70;
            requestSizeOptions2 = requestSizeOptions3;
            z23 = z47;
            rect2 = rect3;
            i36 = i71;
            z24 = z48;
            z25 = z49;
            z26 = z50;
            i28 = i72;
            f14 = f29;
            i37 = i57;
            i38 = i58;
            f15 = f30;
            i39 = i59;
            i40 = i60;
            i41 = i61;
            i42 = i62;
            i43 = i63;
            i44 = i64;
            i45 = i65;
            i46 = i66;
            charSequence4 = charSequence5;
            i32 = i67;
            z27 = z43;
            i47 = i52;
            z29 = z42;
            z30 = z44;
            z31 = z45;
            i48 = i53;
            f16 = f25;
            z32 = z46;
            i49 = i54;
            i50 = i55;
            f17 = f26;
            i51 = i56;
            f18 = f27;
            f13 = f28;
            z33 = z37;
            cropShape2 = cropShape3;
            cropCornerShape2 = cropCornerShape3;
            f19 = f22;
            f20 = f23;
            f21 = f24;
            guidelines2 = guidelines3;
            scaleType2 = scaleType3;
            z34 = z38;
            z35 = z39;
            z28 = z40;
        } else {
            num6 = num5;
            num7 = num14;
            i28 = i72;
            z19 = z51;
            z20 = z52;
            charSequence3 = charSequence6;
            i29 = i73;
            z21 = z53;
            z22 = z54;
            str3 = str5;
            list2 = list3;
            f12 = f32;
            str4 = str6;
            i30 = i75;
            num8 = num12;
            num9 = num13;
            i31 = i74;
            i32 = i67;
            num10 = num11;
            uri2 = uri3;
            compressFormat2 = compressFormat3;
            i33 = i68;
            i34 = i69;
            i35 = i70;
            requestSizeOptions2 = requestSizeOptions3;
            z23 = z47;
            rect2 = rect3;
            i36 = i71;
            z24 = z48;
            z25 = z49;
            z26 = z50;
            f13 = f28;
            f14 = f29;
            i37 = i57;
            i38 = i58;
            f15 = f30;
            i39 = i59;
            i40 = i60;
            i41 = i61;
            i42 = i62;
            i43 = i63;
            i44 = i64;
            i45 = i65;
            i46 = i66;
            charSequence4 = charSequence5;
            z27 = z43;
            z28 = z40;
            i47 = i52;
            z29 = z42;
            z30 = z44;
            z31 = z45;
            i48 = i53;
            f16 = f25;
            z32 = z46;
            i49 = i54;
            i50 = i55;
            f17 = f26;
            i51 = i56;
            f18 = f27;
            z33 = z37;
            cropShape2 = cropShape3;
            cropCornerShape2 = cropCornerShape3;
            f19 = f22;
            f20 = f23;
            f21 = f24;
            guidelines2 = guidelines3;
            scaleType2 = scaleType3;
            z34 = z38;
            z35 = z39;
        }
        return cropImageOptions.copy(z41, z33, cropShape2, cropCornerShape2, f19, f20, f21, guidelines2, scaleType2, z34, z35, z28, i47, z29, z27, z30, z31, i48, f16, z32, i49, i50, f17, i51, f18, f13, f14, i37, i38, f15, i39, i40, i41, i42, i43, i44, i45, i46, charSequence4, i32, num10, uri2, compressFormat2, i33, i34, i35, requestSizeOptions2, z23, rect2, i36, z24, z25, z26, i28, z19, z20, charSequence3, i29, z21, z22, str3, list2, f12, i31, str4, i30, num8, num9, num7, num6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getImageSourceIncludeGallery() {
        return this.imageSourceIncludeGallery;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getShowCropOverlay() {
        return this.showCropOverlay;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getShowCropLabel() {
        return this.showCropLabel;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getProgressBarColor() {
        return this.progressBarColor;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getAutoZoomEnabled() {
        return this.autoZoomEnabled;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getMultiTouchEnabled() {
        return this.multiTouchEnabled;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getCenterMoveEnabled() {
        return this.centerMoveEnabled;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getCanChangeCropWindow() {
        return this.canChangeCropWindow;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getMaxZoom() {
        return this.maxZoom;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final float getInitialCropWindowPaddingRatio() {
        return this.initialCropWindowPaddingRatio;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getImageSourceIncludeCamera() {
        return this.imageSourceIncludeCamera;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getFixAspectRatio() {
        return this.fixAspectRatio;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getAspectRatioX() {
        return this.aspectRatioX;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getAspectRatioY() {
        return this.aspectRatioY;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final float getBorderLineThickness() {
        return this.borderLineThickness;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final int getBorderLineColor() {
        return this.borderLineColor;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final float getBorderCornerThickness() {
        return this.borderCornerThickness;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final float getBorderCornerOffset() {
        return this.borderCornerOffset;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final float getBorderCornerLength() {
        return this.borderCornerLength;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final int getBorderCornerColor() {
        return this.borderCornerColor;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final int getCircleCornerFillColorHexValue() {
        return this.circleCornerFillColorHexValue;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CropImageView.CropShape getCropShape() {
        return this.cropShape;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final float getGuidelinesThickness() {
        return this.guidelinesThickness;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final int getGuidelinesColor() {
        return this.guidelinesColor;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final int getMinCropWindowWidth() {
        return this.minCropWindowWidth;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final int getMinCropWindowHeight() {
        return this.minCropWindowHeight;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final int getMinCropResultWidth() {
        return this.minCropResultWidth;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final int getMinCropResultHeight() {
        return this.minCropResultHeight;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final int getMaxCropResultWidth() {
        return this.maxCropResultWidth;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final int getMaxCropResultHeight() {
        return this.maxCropResultHeight;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final CharSequence getActivityTitle() {
        return this.activityTitle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CropImageView.CropCornerShape getCornerShape() {
        return this.cornerShape;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final int getActivityMenuIconColor() {
        return this.activityMenuIconColor;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final Integer getActivityMenuTextColor() {
        return this.activityMenuTextColor;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final Uri getCustomOutputUri() {
        return this.customOutputUri;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final Bitmap.CompressFormat getOutputCompressFormat() {
        return this.outputCompressFormat;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final int getOutputCompressQuality() {
        return this.outputCompressQuality;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final int getOutputRequestWidth() {
        return this.outputRequestWidth;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final int getOutputRequestHeight() {
        return this.outputRequestHeight;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final CropImageView.RequestSizeOptions getOutputRequestSizeOptions() {
        return this.outputRequestSizeOptions;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final boolean getNoOutputImage() {
        return this.noOutputImage;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final Rect getInitialCropWindowRectangle() {
        return this.initialCropWindowRectangle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getCropCornerRadius() {
        return this.cropCornerRadius;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final int getInitialRotation() {
        return this.initialRotation;
    }

    /* JADX INFO: renamed from: component51, reason: from getter */
    public final boolean getAllowRotation() {
        return this.allowRotation;
    }

    /* JADX INFO: renamed from: component52, reason: from getter */
    public final boolean getAllowFlipping() {
        return this.allowFlipping;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final boolean getAllowCounterRotation() {
        return this.allowCounterRotation;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final int getRotationDegrees() {
        return this.rotationDegrees;
    }

    /* JADX INFO: renamed from: component55, reason: from getter */
    public final boolean getFlipHorizontally() {
        return this.flipHorizontally;
    }

    /* JADX INFO: renamed from: component56, reason: from getter */
    public final boolean getFlipVertically() {
        return this.flipVertically;
    }

    /* JADX INFO: renamed from: component57, reason: from getter */
    public final CharSequence getCropMenuCropButtonTitle() {
        return this.cropMenuCropButtonTitle;
    }

    /* JADX INFO: renamed from: component58, reason: from getter */
    public final int getCropMenuCropButtonIcon() {
        return this.cropMenuCropButtonIcon;
    }

    /* JADX INFO: renamed from: component59, reason: from getter */
    public final boolean getSkipEditing() {
        return this.skipEditing;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getSnapRadius() {
        return this.snapRadius;
    }

    /* JADX INFO: renamed from: component60, reason: from getter */
    public final boolean getShowIntentChooser() {
        return this.showIntentChooser;
    }

    /* JADX INFO: renamed from: component61, reason: from getter */
    public final String getIntentChooserTitle() {
        return this.intentChooserTitle;
    }

    public final List<String> component62() {
        return this.intentChooserPriorityList;
    }

    /* JADX INFO: renamed from: component63, reason: from getter */
    public final float getCropperLabelTextSize() {
        return this.cropperLabelTextSize;
    }

    /* JADX INFO: renamed from: component64, reason: from getter */
    public final int getCropperLabelTextColor() {
        return this.cropperLabelTextColor;
    }

    /* JADX INFO: renamed from: component65, reason: from getter */
    public final String getCropperLabelText() {
        return this.cropperLabelText;
    }

    /* JADX INFO: renamed from: component66, reason: from getter */
    public final int getActivityBackgroundColor() {
        return this.activityBackgroundColor;
    }

    /* JADX INFO: renamed from: component67, reason: from getter */
    public final Integer getToolbarColor() {
        return this.toolbarColor;
    }

    /* JADX INFO: renamed from: component68, reason: from getter */
    public final Integer getToolbarTitleColor() {
        return this.toolbarTitleColor;
    }

    /* JADX INFO: renamed from: component69, reason: from getter */
    public final Integer getToolbarBackButtonColor() {
        return this.toolbarBackButtonColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getTouchRadius() {
        return this.touchRadius;
    }

    /* JADX INFO: renamed from: component70, reason: from getter */
    public final Integer getToolbarTintColor() {
        return this.toolbarTintColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CropImageView.Guidelines getGuidelines() {
        return this.guidelines;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final CropImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public final CropImageOptions copy(boolean imageSourceIncludeGallery, boolean imageSourceIncludeCamera, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float cropCornerRadius, float snapRadius, float touchRadius, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean showCropOverlay, boolean showCropLabel, boolean showProgressBar, int progressBarColor, boolean autoZoomEnabled, boolean multiTouchEnabled, boolean centerMoveEnabled, boolean canChangeCropWindow, int maxZoom, float initialCropWindowPaddingRatio, boolean fixAspectRatio, int aspectRatioX, int aspectRatioY, float borderLineThickness, int borderLineColor, float borderCornerThickness, float borderCornerOffset, float borderCornerLength, int borderCornerColor, int circleCornerFillColorHexValue, float guidelinesThickness, int guidelinesColor, int backgroundColor, int minCropWindowWidth, int minCropWindowHeight, int minCropResultWidth, int minCropResultHeight, int maxCropResultWidth, int maxCropResultHeight, CharSequence activityTitle, int activityMenuIconColor, Integer activityMenuTextColor, Uri customOutputUri, Bitmap.CompressFormat outputCompressFormat, int outputCompressQuality, int outputRequestWidth, int outputRequestHeight, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean noOutputImage, Rect initialCropWindowRectangle, int initialRotation, boolean allowRotation, boolean allowFlipping, boolean allowCounterRotation, int rotationDegrees, boolean flipHorizontally, boolean flipVertically, CharSequence cropMenuCropButtonTitle, int cropMenuCropButtonIcon, boolean skipEditing, boolean showIntentChooser, String intentChooserTitle, List<String> intentChooserPriorityList, float cropperLabelTextSize, int cropperLabelTextColor, String cropperLabelText, int activityBackgroundColor, Integer toolbarColor, Integer toolbarTitleColor, Integer toolbarBackButtonColor, Integer toolbarTintColor) {
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
        return new CropImageOptions(imageSourceIncludeGallery, imageSourceIncludeCamera, cropShape, cornerShape, cropCornerRadius, snapRadius, touchRadius, guidelines, scaleType, showCropOverlay, showCropLabel, showProgressBar, progressBarColor, autoZoomEnabled, multiTouchEnabled, centerMoveEnabled, canChangeCropWindow, maxZoom, initialCropWindowPaddingRatio, fixAspectRatio, aspectRatioX, aspectRatioY, borderLineThickness, borderLineColor, borderCornerThickness, borderCornerOffset, borderCornerLength, borderCornerColor, circleCornerFillColorHexValue, guidelinesThickness, guidelinesColor, backgroundColor, minCropWindowWidth, minCropWindowHeight, minCropResultWidth, minCropResultHeight, maxCropResultWidth, maxCropResultHeight, activityTitle, activityMenuIconColor, activityMenuTextColor, customOutputUri, outputCompressFormat, outputCompressQuality, outputRequestWidth, outputRequestHeight, outputRequestSizeOptions, noOutputImage, initialCropWindowRectangle, initialRotation, allowRotation, allowFlipping, allowCounterRotation, rotationDegrees, flipHorizontally, flipVertically, cropMenuCropButtonTitle, cropMenuCropButtonIcon, skipEditing, showIntentChooser, intentChooserTitle, intentChooserPriorityList, cropperLabelTextSize, cropperLabelTextColor, cropperLabelText, activityBackgroundColor, toolbarColor, toolbarTitleColor, toolbarBackButtonColor, toolbarTintColor);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropImageOptions)) {
            return false;
        }
        CropImageOptions cropImageOptions = (CropImageOptions) other;
        return this.imageSourceIncludeGallery == cropImageOptions.imageSourceIncludeGallery && this.imageSourceIncludeCamera == cropImageOptions.imageSourceIncludeCamera && this.cropShape == cropImageOptions.cropShape && this.cornerShape == cropImageOptions.cornerShape && Float.compare(this.cropCornerRadius, cropImageOptions.cropCornerRadius) == 0 && Float.compare(this.snapRadius, cropImageOptions.snapRadius) == 0 && Float.compare(this.touchRadius, cropImageOptions.touchRadius) == 0 && this.guidelines == cropImageOptions.guidelines && this.scaleType == cropImageOptions.scaleType && this.showCropOverlay == cropImageOptions.showCropOverlay && this.showCropLabel == cropImageOptions.showCropLabel && this.showProgressBar == cropImageOptions.showProgressBar && this.progressBarColor == cropImageOptions.progressBarColor && this.autoZoomEnabled == cropImageOptions.autoZoomEnabled && this.multiTouchEnabled == cropImageOptions.multiTouchEnabled && this.centerMoveEnabled == cropImageOptions.centerMoveEnabled && this.canChangeCropWindow == cropImageOptions.canChangeCropWindow && this.maxZoom == cropImageOptions.maxZoom && Float.compare(this.initialCropWindowPaddingRatio, cropImageOptions.initialCropWindowPaddingRatio) == 0 && this.fixAspectRatio == cropImageOptions.fixAspectRatio && this.aspectRatioX == cropImageOptions.aspectRatioX && this.aspectRatioY == cropImageOptions.aspectRatioY && Float.compare(this.borderLineThickness, cropImageOptions.borderLineThickness) == 0 && this.borderLineColor == cropImageOptions.borderLineColor && Float.compare(this.borderCornerThickness, cropImageOptions.borderCornerThickness) == 0 && Float.compare(this.borderCornerOffset, cropImageOptions.borderCornerOffset) == 0 && Float.compare(this.borderCornerLength, cropImageOptions.borderCornerLength) == 0 && this.borderCornerColor == cropImageOptions.borderCornerColor && this.circleCornerFillColorHexValue == cropImageOptions.circleCornerFillColorHexValue && Float.compare(this.guidelinesThickness, cropImageOptions.guidelinesThickness) == 0 && this.guidelinesColor == cropImageOptions.guidelinesColor && this.backgroundColor == cropImageOptions.backgroundColor && this.minCropWindowWidth == cropImageOptions.minCropWindowWidth && this.minCropWindowHeight == cropImageOptions.minCropWindowHeight && this.minCropResultWidth == cropImageOptions.minCropResultWidth && this.minCropResultHeight == cropImageOptions.minCropResultHeight && this.maxCropResultWidth == cropImageOptions.maxCropResultWidth && this.maxCropResultHeight == cropImageOptions.maxCropResultHeight && Intrinsics.areEqual(this.activityTitle, cropImageOptions.activityTitle) && this.activityMenuIconColor == cropImageOptions.activityMenuIconColor && Intrinsics.areEqual(this.activityMenuTextColor, cropImageOptions.activityMenuTextColor) && Intrinsics.areEqual(this.customOutputUri, cropImageOptions.customOutputUri) && this.outputCompressFormat == cropImageOptions.outputCompressFormat && this.outputCompressQuality == cropImageOptions.outputCompressQuality && this.outputRequestWidth == cropImageOptions.outputRequestWidth && this.outputRequestHeight == cropImageOptions.outputRequestHeight && this.outputRequestSizeOptions == cropImageOptions.outputRequestSizeOptions && this.noOutputImage == cropImageOptions.noOutputImage && Intrinsics.areEqual(this.initialCropWindowRectangle, cropImageOptions.initialCropWindowRectangle) && this.initialRotation == cropImageOptions.initialRotation && this.allowRotation == cropImageOptions.allowRotation && this.allowFlipping == cropImageOptions.allowFlipping && this.allowCounterRotation == cropImageOptions.allowCounterRotation && this.rotationDegrees == cropImageOptions.rotationDegrees && this.flipHorizontally == cropImageOptions.flipHorizontally && this.flipVertically == cropImageOptions.flipVertically && Intrinsics.areEqual(this.cropMenuCropButtonTitle, cropImageOptions.cropMenuCropButtonTitle) && this.cropMenuCropButtonIcon == cropImageOptions.cropMenuCropButtonIcon && this.skipEditing == cropImageOptions.skipEditing && this.showIntentChooser == cropImageOptions.showIntentChooser && Intrinsics.areEqual(this.intentChooserTitle, cropImageOptions.intentChooserTitle) && Intrinsics.areEqual(this.intentChooserPriorityList, cropImageOptions.intentChooserPriorityList) && Float.compare(this.cropperLabelTextSize, cropImageOptions.cropperLabelTextSize) == 0 && this.cropperLabelTextColor == cropImageOptions.cropperLabelTextColor && Intrinsics.areEqual(this.cropperLabelText, cropImageOptions.cropperLabelText) && this.activityBackgroundColor == cropImageOptions.activityBackgroundColor && Intrinsics.areEqual(this.toolbarColor, cropImageOptions.toolbarColor) && Intrinsics.areEqual(this.toolbarTitleColor, cropImageOptions.toolbarTitleColor) && Intrinsics.areEqual(this.toolbarBackButtonColor, cropImageOptions.toolbarBackButtonColor) && Intrinsics.areEqual(this.toolbarTintColor, cropImageOptions.toolbarTintColor);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Boolean.hashCode(this.imageSourceIncludeGallery) * 31) + Boolean.hashCode(this.imageSourceIncludeCamera)) * 31) + this.cropShape.hashCode()) * 31) + this.cornerShape.hashCode()) * 31) + Float.hashCode(this.cropCornerRadius)) * 31) + Float.hashCode(this.snapRadius)) * 31) + Float.hashCode(this.touchRadius)) * 31) + this.guidelines.hashCode()) * 31) + this.scaleType.hashCode()) * 31) + Boolean.hashCode(this.showCropOverlay)) * 31) + Boolean.hashCode(this.showCropLabel)) * 31) + Boolean.hashCode(this.showProgressBar)) * 31) + Integer.hashCode(this.progressBarColor)) * 31) + Boolean.hashCode(this.autoZoomEnabled)) * 31) + Boolean.hashCode(this.multiTouchEnabled)) * 31) + Boolean.hashCode(this.centerMoveEnabled)) * 31) + Boolean.hashCode(this.canChangeCropWindow)) * 31) + Integer.hashCode(this.maxZoom)) * 31) + Float.hashCode(this.initialCropWindowPaddingRatio)) * 31) + Boolean.hashCode(this.fixAspectRatio)) * 31) + Integer.hashCode(this.aspectRatioX)) * 31) + Integer.hashCode(this.aspectRatioY)) * 31) + Float.hashCode(this.borderLineThickness)) * 31) + Integer.hashCode(this.borderLineColor)) * 31) + Float.hashCode(this.borderCornerThickness)) * 31) + Float.hashCode(this.borderCornerOffset)) * 31) + Float.hashCode(this.borderCornerLength)) * 31) + Integer.hashCode(this.borderCornerColor)) * 31) + Integer.hashCode(this.circleCornerFillColorHexValue)) * 31) + Float.hashCode(this.guidelinesThickness)) * 31) + Integer.hashCode(this.guidelinesColor)) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + Integer.hashCode(this.minCropWindowWidth)) * 31) + Integer.hashCode(this.minCropWindowHeight)) * 31) + Integer.hashCode(this.minCropResultWidth)) * 31) + Integer.hashCode(this.minCropResultHeight)) * 31) + Integer.hashCode(this.maxCropResultWidth)) * 31) + Integer.hashCode(this.maxCropResultHeight)) * 31) + this.activityTitle.hashCode()) * 31) + Integer.hashCode(this.activityMenuIconColor)) * 31;
        Integer num = this.activityMenuTextColor;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Uri uri = this.customOutputUri;
        int iHashCode3 = (((((((((((((iHashCode2 + (uri == null ? 0 : uri.hashCode())) * 31) + this.outputCompressFormat.hashCode()) * 31) + Integer.hashCode(this.outputCompressQuality)) * 31) + Integer.hashCode(this.outputRequestWidth)) * 31) + Integer.hashCode(this.outputRequestHeight)) * 31) + this.outputRequestSizeOptions.hashCode()) * 31) + Boolean.hashCode(this.noOutputImage)) * 31;
        Rect rect = this.initialCropWindowRectangle;
        int iHashCode4 = (((((((((((((((iHashCode3 + (rect == null ? 0 : rect.hashCode())) * 31) + Integer.hashCode(this.initialRotation)) * 31) + Boolean.hashCode(this.allowRotation)) * 31) + Boolean.hashCode(this.allowFlipping)) * 31) + Boolean.hashCode(this.allowCounterRotation)) * 31) + Integer.hashCode(this.rotationDegrees)) * 31) + Boolean.hashCode(this.flipHorizontally)) * 31) + Boolean.hashCode(this.flipVertically)) * 31;
        CharSequence charSequence = this.cropMenuCropButtonTitle;
        int iHashCode5 = (((((((iHashCode4 + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + Integer.hashCode(this.cropMenuCropButtonIcon)) * 31) + Boolean.hashCode(this.skipEditing)) * 31) + Boolean.hashCode(this.showIntentChooser)) * 31;
        String str = this.intentChooserTitle;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.intentChooserPriorityList;
        int iHashCode7 = (((((iHashCode6 + (list == null ? 0 : list.hashCode())) * 31) + Float.hashCode(this.cropperLabelTextSize)) * 31) + Integer.hashCode(this.cropperLabelTextColor)) * 31;
        String str2 = this.cropperLabelText;
        int iHashCode8 = (((iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.activityBackgroundColor)) * 31;
        Integer num2 = this.toolbarColor;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.toolbarTitleColor;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.toolbarBackButtonColor;
        int iHashCode11 = (iHashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.toolbarTintColor;
        return iHashCode11 + (num5 != null ? num5.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.imageSourceIncludeGallery;
        boolean z2 = this.imageSourceIncludeCamera;
        CropImageView.CropShape cropShape = this.cropShape;
        CropImageView.CropCornerShape cropCornerShape = this.cornerShape;
        float f2 = this.cropCornerRadius;
        float f3 = this.snapRadius;
        float f4 = this.touchRadius;
        CropImageView.Guidelines guidelines = this.guidelines;
        CropImageView.ScaleType scaleType = this.scaleType;
        boolean z3 = this.showCropOverlay;
        boolean z4 = this.showCropLabel;
        boolean z5 = this.showProgressBar;
        int i = this.progressBarColor;
        boolean z6 = this.autoZoomEnabled;
        boolean z7 = this.multiTouchEnabled;
        boolean z8 = this.centerMoveEnabled;
        boolean z9 = this.canChangeCropWindow;
        int i2 = this.maxZoom;
        float f5 = this.initialCropWindowPaddingRatio;
        boolean z10 = this.fixAspectRatio;
        int i3 = this.aspectRatioX;
        int i4 = this.aspectRatioY;
        float f6 = this.borderLineThickness;
        int i5 = this.borderLineColor;
        float f7 = this.borderCornerThickness;
        float f8 = this.borderCornerOffset;
        float f9 = this.borderCornerLength;
        int i6 = this.borderCornerColor;
        int i7 = this.circleCornerFillColorHexValue;
        float f10 = this.guidelinesThickness;
        int i8 = this.guidelinesColor;
        int i9 = this.backgroundColor;
        int i10 = this.minCropWindowWidth;
        int i11 = this.minCropWindowHeight;
        int i12 = this.minCropResultWidth;
        int i13 = this.minCropResultHeight;
        int i14 = this.maxCropResultWidth;
        int i15 = this.maxCropResultHeight;
        CharSequence charSequence = this.activityTitle;
        int i16 = this.activityMenuIconColor;
        Integer num = this.activityMenuTextColor;
        Uri uri = this.customOutputUri;
        Bitmap.CompressFormat compressFormat = this.outputCompressFormat;
        int i17 = this.outputCompressQuality;
        int i18 = this.outputRequestWidth;
        int i19 = this.outputRequestHeight;
        CropImageView.RequestSizeOptions requestSizeOptions = this.outputRequestSizeOptions;
        boolean z11 = this.noOutputImage;
        Rect rect = this.initialCropWindowRectangle;
        int i20 = this.initialRotation;
        boolean z12 = this.allowRotation;
        boolean z13 = this.allowFlipping;
        boolean z14 = this.allowCounterRotation;
        int i21 = this.rotationDegrees;
        boolean z15 = this.flipHorizontally;
        boolean z16 = this.flipVertically;
        CharSequence charSequence2 = this.cropMenuCropButtonTitle;
        return "CropImageOptions(imageSourceIncludeGallery=" + z + ", imageSourceIncludeCamera=" + z2 + ", cropShape=" + cropShape + ", cornerShape=" + cropCornerShape + ", cropCornerRadius=" + f2 + ", snapRadius=" + f3 + ", touchRadius=" + f4 + ", guidelines=" + guidelines + ", scaleType=" + scaleType + ", showCropOverlay=" + z3 + ", showCropLabel=" + z4 + ", showProgressBar=" + z5 + ", progressBarColor=" + i + ", autoZoomEnabled=" + z6 + ", multiTouchEnabled=" + z7 + ", centerMoveEnabled=" + z8 + ", canChangeCropWindow=" + z9 + ", maxZoom=" + i2 + ", initialCropWindowPaddingRatio=" + f5 + ", fixAspectRatio=" + z10 + ", aspectRatioX=" + i3 + ", aspectRatioY=" + i4 + ", borderLineThickness=" + f6 + ", borderLineColor=" + i5 + ", borderCornerThickness=" + f7 + ", borderCornerOffset=" + f8 + ", borderCornerLength=" + f9 + ", borderCornerColor=" + i6 + ", circleCornerFillColorHexValue=" + i7 + ", guidelinesThickness=" + f10 + ", guidelinesColor=" + i8 + ", backgroundColor=" + i9 + ", minCropWindowWidth=" + i10 + ", minCropWindowHeight=" + i11 + ", minCropResultWidth=" + i12 + ", minCropResultHeight=" + i13 + ", maxCropResultWidth=" + i14 + ", maxCropResultHeight=" + i15 + ", activityTitle=" + ((Object) charSequence) + ", activityMenuIconColor=" + i16 + ", activityMenuTextColor=" + num + ", customOutputUri=" + uri + ", outputCompressFormat=" + compressFormat + ", outputCompressQuality=" + i17 + ", outputRequestWidth=" + i18 + ", outputRequestHeight=" + i19 + ", outputRequestSizeOptions=" + requestSizeOptions + ", noOutputImage=" + z11 + ", initialCropWindowRectangle=" + rect + ", initialRotation=" + i20 + ", allowRotation=" + z12 + ", allowFlipping=" + z13 + ", allowCounterRotation=" + z14 + ", rotationDegrees=" + i21 + ", flipHorizontally=" + z15 + ", flipVertically=" + z16 + ", cropMenuCropButtonTitle=" + ((Object) charSequence2) + ", cropMenuCropButtonIcon=" + this.cropMenuCropButtonIcon + ", skipEditing=" + this.skipEditing + ", showIntentChooser=" + this.showIntentChooser + ", intentChooserTitle=" + this.intentChooserTitle + ", intentChooserPriorityList=" + this.intentChooserPriorityList + ", cropperLabelTextSize=" + this.cropperLabelTextSize + ", cropperLabelTextColor=" + this.cropperLabelTextColor + ", cropperLabelText=" + this.cropperLabelText + ", activityBackgroundColor=" + this.activityBackgroundColor + ", toolbarColor=" + this.toolbarColor + ", toolbarTitleColor=" + this.toolbarTitleColor + ", toolbarBackButtonColor=" + this.toolbarBackButtonColor + ", toolbarTintColor=" + this.toolbarTintColor + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.imageSourceIncludeGallery ? 1 : 0);
        dest.writeInt(this.imageSourceIncludeCamera ? 1 : 0);
        dest.writeString(this.cropShape.name());
        dest.writeString(this.cornerShape.name());
        dest.writeFloat(this.cropCornerRadius);
        dest.writeFloat(this.snapRadius);
        dest.writeFloat(this.touchRadius);
        dest.writeString(this.guidelines.name());
        dest.writeString(this.scaleType.name());
        dest.writeInt(this.showCropOverlay ? 1 : 0);
        dest.writeInt(this.showCropLabel ? 1 : 0);
        dest.writeInt(this.showProgressBar ? 1 : 0);
        dest.writeInt(this.progressBarColor);
        dest.writeInt(this.autoZoomEnabled ? 1 : 0);
        dest.writeInt(this.multiTouchEnabled ? 1 : 0);
        dest.writeInt(this.centerMoveEnabled ? 1 : 0);
        dest.writeInt(this.canChangeCropWindow ? 1 : 0);
        dest.writeInt(this.maxZoom);
        dest.writeFloat(this.initialCropWindowPaddingRatio);
        dest.writeInt(this.fixAspectRatio ? 1 : 0);
        dest.writeInt(this.aspectRatioX);
        dest.writeInt(this.aspectRatioY);
        dest.writeFloat(this.borderLineThickness);
        dest.writeInt(this.borderLineColor);
        dest.writeFloat(this.borderCornerThickness);
        dest.writeFloat(this.borderCornerOffset);
        dest.writeFloat(this.borderCornerLength);
        dest.writeInt(this.borderCornerColor);
        dest.writeInt(this.circleCornerFillColorHexValue);
        dest.writeFloat(this.guidelinesThickness);
        dest.writeInt(this.guidelinesColor);
        dest.writeInt(this.backgroundColor);
        dest.writeInt(this.minCropWindowWidth);
        dest.writeInt(this.minCropWindowHeight);
        dest.writeInt(this.minCropResultWidth);
        dest.writeInt(this.minCropResultHeight);
        dest.writeInt(this.maxCropResultWidth);
        dest.writeInt(this.maxCropResultHeight);
        TextUtils.writeToParcel(this.activityTitle, dest, flags);
        dest.writeInt(this.activityMenuIconColor);
        Integer num = this.activityMenuTextColor;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeParcelable(this.customOutputUri, flags);
        dest.writeString(this.outputCompressFormat.name());
        dest.writeInt(this.outputCompressQuality);
        dest.writeInt(this.outputRequestWidth);
        dest.writeInt(this.outputRequestHeight);
        dest.writeString(this.outputRequestSizeOptions.name());
        dest.writeInt(this.noOutputImage ? 1 : 0);
        dest.writeParcelable(this.initialCropWindowRectangle, flags);
        dest.writeInt(this.initialRotation);
        dest.writeInt(this.allowRotation ? 1 : 0);
        dest.writeInt(this.allowFlipping ? 1 : 0);
        dest.writeInt(this.allowCounterRotation ? 1 : 0);
        dest.writeInt(this.rotationDegrees);
        dest.writeInt(this.flipHorizontally ? 1 : 0);
        dest.writeInt(this.flipVertically ? 1 : 0);
        TextUtils.writeToParcel(this.cropMenuCropButtonTitle, dest, flags);
        dest.writeInt(this.cropMenuCropButtonIcon);
        dest.writeInt(this.skipEditing ? 1 : 0);
        dest.writeInt(this.showIntentChooser ? 1 : 0);
        dest.writeString(this.intentChooserTitle);
        dest.writeStringList(this.intentChooserPriorityList);
        dest.writeFloat(this.cropperLabelTextSize);
        dest.writeInt(this.cropperLabelTextColor);
        dest.writeString(this.cropperLabelText);
        dest.writeInt(this.activityBackgroundColor);
        Integer num2 = this.toolbarColor;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.toolbarTitleColor;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        Integer num4 = this.toolbarBackButtonColor;
        if (num4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num4.intValue());
        }
        Integer num5 = this.toolbarTintColor;
        if (num5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num5.intValue());
        }
    }

    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f11, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4, Integer num5) {
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
        this.imageSourceIncludeGallery = z;
        this.imageSourceIncludeCamera = z2;
        this.cropShape = cropShape;
        this.cornerShape = cornerShape;
        this.cropCornerRadius = f2;
        this.snapRadius = f3;
        this.touchRadius = f4;
        this.guidelines = guidelines;
        this.scaleType = scaleType;
        this.showCropOverlay = z3;
        this.showCropLabel = z4;
        this.showProgressBar = z5;
        this.progressBarColor = i;
        this.autoZoomEnabled = z6;
        this.multiTouchEnabled = z7;
        this.centerMoveEnabled = z8;
        this.canChangeCropWindow = z9;
        this.maxZoom = i2;
        this.initialCropWindowPaddingRatio = f5;
        this.fixAspectRatio = z10;
        this.aspectRatioX = i3;
        this.aspectRatioY = i4;
        this.borderLineThickness = f6;
        this.borderLineColor = i5;
        this.borderCornerThickness = f7;
        this.borderCornerOffset = f8;
        this.borderCornerLength = f9;
        this.borderCornerColor = i6;
        this.circleCornerFillColorHexValue = i7;
        this.guidelinesThickness = f10;
        this.guidelinesColor = i8;
        this.backgroundColor = i9;
        this.minCropWindowWidth = i10;
        this.minCropWindowHeight = i11;
        this.minCropResultWidth = i12;
        this.minCropResultHeight = i13;
        this.maxCropResultWidth = i14;
        this.maxCropResultHeight = i15;
        this.activityTitle = activityTitle;
        this.activityMenuIconColor = i16;
        this.activityMenuTextColor = num;
        this.customOutputUri = uri;
        this.outputCompressFormat = outputCompressFormat;
        this.outputCompressQuality = i17;
        this.outputRequestWidth = i18;
        this.outputRequestHeight = i19;
        this.outputRequestSizeOptions = outputRequestSizeOptions;
        this.noOutputImage = z11;
        this.initialCropWindowRectangle = rect;
        this.initialRotation = i20;
        this.allowRotation = z12;
        this.allowFlipping = z13;
        this.allowCounterRotation = z14;
        this.rotationDegrees = i21;
        this.flipHorizontally = z15;
        this.flipVertically = z16;
        this.cropMenuCropButtonTitle = charSequence;
        this.cropMenuCropButtonIcon = i22;
        this.skipEditing = z17;
        this.showIntentChooser = z18;
        this.intentChooserTitle = str;
        this.intentChooserPriorityList = list;
        this.cropperLabelTextSize = f11;
        this.cropperLabelTextColor = i23;
        this.cropperLabelText = str2;
        this.activityBackgroundColor = i24;
        this.toolbarColor = num2;
        this.toolbarTitleColor = num3;
        this.toolbarBackButtonColor = num4;
        this.toolbarTintColor = num5;
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1".toString());
        }
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ".toString());
        }
        if (f5 < 0.0f || f5 >= 0.5d) {
            throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5".toString());
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.".toString());
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.".toString());
        }
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.".toString());
        }
        if (f7 < 0.0f) {
            throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.".toString());
        }
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.".toString());
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ".toString());
        }
        if (i12 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ".toString());
        }
        if (i13 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ".toString());
        }
        if (i14 < i12) {
            throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width".toString());
        }
        if (i15 < i13) {
            throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height".toString());
        }
        if (i18 < 0) {
            throw new IllegalArgumentException("Cannot set request width value to a number < 0 ".toString());
        }
        if (i19 < 0) {
            throw new IllegalArgumentException("Cannot set request height value to a number < 0 ".toString());
        }
        if (i21 < 0 || i21 > 360) {
            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360".toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cropCornerShape, float f2, float f3, float f4, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f5, boolean z10, int i3, int i4, float f6, int i5, float f7, float f8, float f9, int i6, int i7, float f10, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, Integer num, Uri uri, Bitmap.CompressFormat compressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions requestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence2, int i22, boolean z17, boolean z18, String str, List list, float f11, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4, Integer num5, int i25, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z19;
        int i28;
        float fApplyDimension;
        float f12;
        int i29;
        int i30;
        float fApplyDimension2;
        float f13;
        float fApplyDimension3;
        float f14;
        float fApplyDimension4;
        float f15;
        int i31;
        float fApplyDimension5;
        float f16;
        int iArgb;
        int i32;
        int i33;
        int i34;
        int iApplyDimension;
        int i35;
        int iApplyDimension2;
        CropImageView.RequestSizeOptions requestSizeOptions2;
        int i36;
        float fApplyDimension6;
        boolean z20 = (i25 & 1) != 0 ? true : z;
        boolean z21 = (i25 & 2) != 0 ? true : z2;
        CropImageView.CropShape cropShape2 = (i25 & 4) != 0 ? CropImageView.CropShape.RECTANGLE : cropShape;
        CropImageView.CropCornerShape cropCornerShape2 = (i25 & 8) != 0 ? CropImageView.CropCornerShape.RECTANGLE : cropCornerShape;
        float fApplyDimension7 = (i25 & 16) != 0 ? TypedValue.applyDimension(1, 10.0f, Resources.getSystem().getDisplayMetrics()) : f2;
        float fApplyDimension8 = (i25 & 32) != 0 ? TypedValue.applyDimension(1, 3.0f, Resources.getSystem().getDisplayMetrics()) : f3;
        float fApplyDimension9 = (i25 & 64) != 0 ? TypedValue.applyDimension(1, 24.0f, Resources.getSystem().getDisplayMetrics()) : f4;
        CropImageView.Guidelines guidelines2 = (i25 & 128) != 0 ? CropImageView.Guidelines.ON : guidelines;
        CropImageView.ScaleType scaleType2 = (i25 & 256) != 0 ? CropImageView.ScaleType.FIT_CENTER : scaleType;
        boolean z22 = (i25 & 512) != 0 ? true : z3;
        boolean z23 = (i25 & 1024) != 0 ? false : z4;
        boolean z24 = (i25 & 2048) != 0 ? true : z5;
        int iRgb = (i25 & 4096) != 0 ? Color.rgb(153, 51, 153) : i;
        boolean z25 = (i25 & 8192) != 0 ? true : z6;
        boolean z26 = z20;
        boolean z27 = (i25 & 16384) != 0 ? false : z7;
        boolean z28 = (i25 & 32768) != 0 ? true : z8;
        boolean z29 = (i25 & 65536) != 0 ? true : z9;
        int i37 = (i25 & 131072) != 0 ? 4 : i2;
        float f17 = (i25 & 262144) != 0 ? 0.0f : f5;
        boolean z30 = (i25 & 524288) != 0 ? false : z10;
        int i38 = (i25 & 1048576) != 0 ? 1 : i3;
        int i39 = (i25 & 2097152) != 0 ? 1 : i4;
        if ((i25 & 4194304) != 0) {
            z19 = z27;
            i28 = iRgb;
            fApplyDimension = TypedValue.applyDimension(1, 3.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            z19 = z27;
            i28 = iRgb;
            fApplyDimension = f6;
        }
        int iArgb2 = (i25 & 8388608) != 0 ? Color.argb(170, 255, 255, 255) : i5;
        if ((i25 & 16777216) != 0) {
            f12 = fApplyDimension;
            i29 = iArgb2;
            i30 = 1;
            fApplyDimension2 = TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            f12 = fApplyDimension;
            i29 = iArgb2;
            i30 = 1;
            fApplyDimension2 = f7;
        }
        if ((i25 & GroupFlagsKt.HasAuxSlotFlag) != 0) {
            f13 = fApplyDimension2;
            fApplyDimension3 = TypedValue.applyDimension(i30, 5.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            f13 = fApplyDimension2;
            fApplyDimension3 = f8;
        }
        if ((i25 & 67108864) != 0) {
            f14 = fApplyDimension3;
            fApplyDimension4 = TypedValue.applyDimension(i30, 14.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            f14 = fApplyDimension3;
            fApplyDimension4 = f9;
        }
        int i40 = (i25 & 134217728) != 0 ? -1 : i6;
        int i41 = (i25 & 268435456) != 0 ? -1 : i7;
        if ((i25 & 536870912) != 0) {
            f15 = fApplyDimension4;
            i31 = i40;
            fApplyDimension5 = TypedValue.applyDimension(1, 1.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            f15 = fApplyDimension4;
            i31 = i40;
            fApplyDimension5 = f10;
        }
        int iArgb3 = (i25 & 1073741824) != 0 ? Color.argb(170, 255, 255, 255) : i8;
        if ((i25 & Integer.MIN_VALUE) != 0) {
            f16 = fApplyDimension5;
            iArgb = Color.argb(119, 0, 0, 0);
        } else {
            f16 = fApplyDimension5;
            iArgb = i9;
        }
        if ((i26 & 1) != 0) {
            i32 = iArgb3;
            i33 = iArgb;
            i34 = 1;
            iApplyDimension = (int) TypedValue.applyDimension(1, 42.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            i32 = iArgb3;
            i33 = iArgb;
            i34 = 1;
            iApplyDimension = i10;
        }
        if ((i26 & 2) != 0) {
            i35 = iApplyDimension;
            iApplyDimension2 = (int) TypedValue.applyDimension(i34, 42.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            i35 = iApplyDimension;
            iApplyDimension2 = i11;
        }
        int i42 = (i26 & 4) != 0 ? 40 : i12;
        int i43 = (i26 & 8) != 0 ? 40 : i13;
        int i44 = (i26 & 16) != 0 ? 99999 : i14;
        int i45 = (i26 & 32) != 0 ? 99999 : i15;
        CharSequence charSequence3 = (i26 & 64) != 0 ? "" : charSequence;
        int i46 = (i26 & 128) != 0 ? 0 : i16;
        int i47 = iApplyDimension2;
        Integer num6 = (i26 & 256) != 0 ? null : num;
        Uri uri2 = (i26 & 512) != 0 ? null : uri;
        Bitmap.CompressFormat compressFormat2 = (i26 & 1024) != 0 ? Bitmap.CompressFormat.JPEG : compressFormat;
        int i48 = (i26 & 2048) != 0 ? 90 : i17;
        int i49 = (i26 & 4096) != 0 ? 0 : i18;
        int i50 = (i26 & 8192) != 0 ? 0 : i19;
        CropImageView.RequestSizeOptions requestSizeOptions3 = (i26 & 16384) != 0 ? CropImageView.RequestSizeOptions.NONE : requestSizeOptions;
        boolean z31 = (i26 & 32768) != 0 ? false : z11;
        Rect rect2 = (i26 & 65536) != 0 ? null : rect;
        int i51 = (i26 & 131072) != 0 ? -1 : i20;
        boolean z32 = (i26 & 262144) != 0 ? true : z12;
        boolean z33 = (i26 & 524288) != 0 ? true : z13;
        boolean z34 = (i26 & 1048576) != 0 ? false : z14;
        int i52 = (i26 & 2097152) != 0 ? 90 : i21;
        boolean z35 = (i26 & 4194304) != 0 ? false : z15;
        boolean z36 = (i26 & 8388608) != 0 ? false : z16;
        CharSequence charSequence4 = (i26 & 16777216) != 0 ? null : charSequence2;
        int i53 = (i26 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? 0 : i22;
        boolean z37 = (i26 & 67108864) != 0 ? false : z17;
        boolean z38 = (i26 & 134217728) != 0 ? false : z18;
        String str3 = (i26 & 268435456) != 0 ? null : str;
        List listEmptyList = (i26 & 536870912) != 0 ? CollectionsKt.emptyList() : list;
        if ((i26 & 1073741824) != 0) {
            requestSizeOptions2 = requestSizeOptions3;
            i36 = i42;
            fApplyDimension6 = TypedValue.applyDimension(2, 20.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            requestSizeOptions2 = requestSizeOptions3;
            i36 = i42;
            fApplyDimension6 = f11;
        }
        float f18 = f12;
        int i54 = i29;
        float f19 = f13;
        float f20 = f14;
        float f21 = f15;
        int i55 = i31;
        float f22 = fApplyDimension9;
        CropImageView.Guidelines guidelines3 = guidelines2;
        CropImageView.ScaleType scaleType3 = scaleType2;
        boolean z39 = z22;
        boolean z40 = z23;
        boolean z41 = z24;
        int i56 = i28;
        boolean z42 = z19;
        boolean z43 = z21;
        this(z26, z43, cropShape2, cropCornerShape2, fApplyDimension7, fApplyDimension8, f22, guidelines3, scaleType3, z39, z40, z41, i56, z25, z42, z28, z29, i37, f17, z30, i38, i39, f18, i54, f19, f20, f21, i55, i41, f16, i32, i33, i35, i47, i36, i43, i44, i45, charSequence3, i46, num6, uri2, compressFormat2, i48, i49, i50, requestSizeOptions2, z31, rect2, i51, z32, z33, z34, i52, z35, z36, charSequence4, i53, z37, z38, str3, listEmptyList, fApplyDimension6, (i26 & Integer.MIN_VALUE) != 0 ? -1 : i23, (i27 & 1) != 0 ? "" : str2, (i27 & 2) != 0 ? -1 : i24, (i27 & 4) != 0 ? null : num2, (i27 & 8) != 0 ? null : num3, (i27 & 16) != 0 ? null : num4, (i27 & 32) != 0 ? null : num5);
    }
}
