package com.appnew.android.Model;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.StoreProvider;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.tv9news.utils.helpers.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TestReport.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0003\b»\u0001\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B÷\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0001\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003¢\u0006\u0004\b1\u00102J\n\u0010\u008f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0001HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010°\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010º\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0003HÆ\u0003JÖ\u0003\u0010½\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u0003HÆ\u0001J\u0016\u0010¾\u0001\u001a\u00030¿\u00012\t\u0010À\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010Á\u0001\u001a\u00030Â\u0001HÖ\u0001J\n\u0010Ã\u0001\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00104\"\u0004\b>\u00106R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00104\"\u0004\b@\u00106R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00104\"\u0004\bB\u00106R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00104\"\u0004\bD\u00106R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00104\"\u0004\bF\u00106R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00104\"\u0004\bH\u00106R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00104\"\u0004\bJ\u00106R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00104\"\u0004\bL\u00106R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00104\"\u0004\bN\u00106R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00104\"\u0004\bP\u00106R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00104\"\u0004\bR\u00106R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00104\"\u0004\bT\u00106R\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00104\"\u0004\bU\u00106R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u00104\"\u0004\bV\u00106R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u00104\"\u0004\bW\u00106R\u001e\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u00104\"\u0004\bX\u00106R\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00104\"\u0004\bZ\u00106R\u001e\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R\u001e\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00104\"\u0004\b^\u00106R\u001e\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00104\"\u0004\b`\u00106R\u001e\u0010\u001b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u00104\"\u0004\bb\u00106R\u001e\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00104\"\u0004\bd\u00106R\u001e\u0010\u001d\u001a\u00020\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001e\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00104\"\u0004\bj\u00106R\u001e\u0010\u001f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u00104\"\u0004\bl\u00106R\u001e\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00104\"\u0004\bn\u00106R\u001e\u0010!\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00104\"\u0004\bp\u00106R\u001e\u0010\"\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u00104\"\u0004\br\u00106R\u001e\u0010#\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u00104\"\u0004\bt\u00106R\u001e\u0010$\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u00104\"\u0004\bv\u00106R\u001e\u0010%\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u00104\"\u0004\bx\u00106R\u001e\u0010&\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u00104\"\u0004\bz\u00106R\u001e\u0010'\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u00104\"\u0004\b|\u00106R\u001e\u0010(\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u00104\"\u0004\b~\u00106R\u001f\u0010)\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u00104\"\u0005\b\u0080\u0001\u00106R \u0010*\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u00104\"\u0005\b\u0082\u0001\u00106R \u0010+\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u00104\"\u0005\b\u0084\u0001\u00106R \u0010,\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u00104\"\u0005\b\u0086\u0001\u00106R \u0010-\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u00104\"\u0005\b\u0088\u0001\u00106R \u0010.\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u00104\"\u0005\b\u008a\u0001\u00106R \u0010/\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u00104\"\u0005\b\u008c\u0001\u00106R \u00100\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u00104\"\u0005\b\u008e\u0001\u00106¨\u0006Ä\u0001"}, d2 = {"Lcom/appnew/android/Model/TestReportData;", "", "allowUserMove", "", "appId", "attemptLimit", "autoAssigning", "backendUserId", "considerTime", StoreProvider.StoreData.CREATED_DATE, "dailyAssigment", "description", "description2", "difficultyLevel", "downloadPdf", "endDate", "faculty", "id", "image", "isCalcAllowed", "isFeeds", "isRank", "isReattempt", "langId", "markingScheme", "mode", "passingCutoff", FirebaseAnalytics.Param.PRICE, "publish", "qrCode", "questionPdf", "resultDate", "rewardPoints", "setType", "solutionUrl", "startDate", "subjectId", "testAssets", "testCode", "testSeriesId", "testSeriesName", "testType", "timeBoundation", "timeInMins", "topicId", "totalMarks", "totalQuestions", "userId", "userName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllowUserMove", "()Ljava/lang/String;", "setAllowUserMove", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAttemptLimit", "setAttemptLimit", "getAutoAssigning", "setAutoAssigning", "getBackendUserId", "setBackendUserId", "getConsiderTime", "setConsiderTime", "getCreated", "setCreated", "getDailyAssigment", "setDailyAssigment", "getDescription", "setDescription", "getDescription2", "setDescription2", "getDifficultyLevel", "setDifficultyLevel", "getDownloadPdf", "setDownloadPdf", "getEndDate", "setEndDate", "getFaculty", "setFaculty", "getId", "setId", "getImage", "setImage", "setCalcAllowed", "setFeeds", "setRank", "setReattempt", "getLangId", "setLangId", "getMarkingScheme", "setMarkingScheme", "getMode", "setMode", "getPassingCutoff", "setPassingCutoff", "getPrice", "setPrice", "getPublish", "setPublish", "getQrCode", "()Ljava/lang/Object;", "setQrCode", "(Ljava/lang/Object;)V", "getQuestionPdf", "setQuestionPdf", "getResultDate", "setResultDate", "getRewardPoints", "setRewardPoints", "getSetType", "setSetType", "getSolutionUrl", "setSolutionUrl", "getStartDate", "setStartDate", "getSubjectId", "setSubjectId", "getTestAssets", "setTestAssets", "getTestCode", "setTestCode", "getTestSeriesId", "setTestSeriesId", "getTestSeriesName", "setTestSeriesName", "getTestType", "setTestType", "getTimeBoundation", "setTimeBoundation", "getTimeInMins", "setTimeInMins", "getTopicId", "setTopicId", "getTotalMarks", "setTotalMarks", "getTotalQuestions", "setTotalQuestions", "getUserId", "setUserId", "getUserName", "setUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TestReportData {
    public static final int $stable = 8;

    @SerializedName("allow_user_move")
    private String allowUserMove;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("attempt_limit")
    private String attemptLimit;

    @SerializedName("auto_assigning")
    private String autoAssigning;

    @SerializedName("backend_user_id")
    private String backendUserId;

    @SerializedName("consider_time")
    private String considerTime;

    @SerializedName(StoreProvider.StoreData.CREATED_DATE)
    private String created;

    @SerializedName("daily_assigment")
    private String dailyAssigment;

    @SerializedName("description")
    private String description;

    @SerializedName("description_2")
    private String description2;

    @SerializedName("difficulty_level")
    private String difficultyLevel;

    @SerializedName("download_pdf")
    private String downloadPdf;

    @SerializedName(FirebaseAnalytics.Param.END_DATE)
    private String endDate;

    @SerializedName("faculty")
    private String faculty;

    @SerializedName("id")
    private String id;

    @SerializedName("image")
    private String image;

    @SerializedName("is_calc_allowed")
    private String isCalcAllowed;

    @SerializedName("is_feeds")
    private String isFeeds;

    @SerializedName("is_rank")
    private String isRank;

    @SerializedName(Const.IS_REATTEMPT)
    private String isReattempt;

    @SerializedName("lang_id")
    private String langId;

    @SerializedName("marking_scheme")
    private String markingScheme;

    @SerializedName("mode")
    private String mode;

    @SerializedName("passing_cutoff")
    private String passingCutoff;

    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private String price;

    @SerializedName("publish")
    private String publish;

    @SerializedName("qr_code")
    private Object qrCode;

    @SerializedName("question_pdf")
    private String questionPdf;

    @SerializedName("result_date")
    private String resultDate;

    @SerializedName("reward_points")
    private String rewardPoints;

    @SerializedName("set_type")
    private String setType;

    @SerializedName("solution_url")
    private String solutionUrl;

    @SerializedName(FirebaseAnalytics.Param.START_DATE)
    private String startDate;

    @SerializedName(Const.SUBJECT_ID)
    private String subjectId;

    @SerializedName("test_assets")
    private String testAssets;

    @SerializedName("test_code")
    private String testCode;

    @SerializedName(Const.TESTSERIES_ID)
    private String testSeriesId;

    @SerializedName("test_series_name")
    private String testSeriesName;

    @SerializedName(Const.TEST_TYPE)
    private String testType;

    @SerializedName("time_boundation")
    private String timeBoundation;

    @SerializedName("time_in_mins")
    private String timeInMins;

    @SerializedName(Const.TOPIC_ID)
    private String topicId;

    @SerializedName("total_marks")
    private String totalMarks;

    @SerializedName("total_questions")
    private String totalQuestions;

    @SerializedName("user_id")
    private String userId;

    @SerializedName(AnalyticsConstants.user_name)
    private String userName;

    public static /* synthetic */ TestReportData copy$default(TestReportData testReportData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, Object obj, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, int i, int i2, Object obj2) {
        String str46 = (i & 1) != 0 ? testReportData.allowUserMove : str;
        return testReportData.copy(str46, (i & 2) != 0 ? testReportData.appId : str2, (i & 4) != 0 ? testReportData.attemptLimit : str3, (i & 8) != 0 ? testReportData.autoAssigning : str4, (i & 16) != 0 ? testReportData.backendUserId : str5, (i & 32) != 0 ? testReportData.considerTime : str6, (i & 64) != 0 ? testReportData.created : str7, (i & 128) != 0 ? testReportData.dailyAssigment : str8, (i & 256) != 0 ? testReportData.description : str9, (i & 512) != 0 ? testReportData.description2 : str10, (i & 1024) != 0 ? testReportData.difficultyLevel : str11, (i & 2048) != 0 ? testReportData.downloadPdf : str12, (i & 4096) != 0 ? testReportData.endDate : str13, (i & 8192) != 0 ? testReportData.faculty : str14, (i & 16384) != 0 ? testReportData.id : str15, (i & 32768) != 0 ? testReportData.image : str16, (i & 65536) != 0 ? testReportData.isCalcAllowed : str17, (i & 131072) != 0 ? testReportData.isFeeds : str18, (i & 262144) != 0 ? testReportData.isRank : str19, (i & 524288) != 0 ? testReportData.isReattempt : str20, (i & 1048576) != 0 ? testReportData.langId : str21, (i & 2097152) != 0 ? testReportData.markingScheme : str22, (i & 4194304) != 0 ? testReportData.mode : str23, (i & 8388608) != 0 ? testReportData.passingCutoff : str24, (i & 16777216) != 0 ? testReportData.price : str25, (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? testReportData.publish : str26, (i & 67108864) != 0 ? testReportData.qrCode : obj, (i & 134217728) != 0 ? testReportData.questionPdf : str27, (i & 268435456) != 0 ? testReportData.resultDate : str28, (i & 536870912) != 0 ? testReportData.rewardPoints : str29, (i & 1073741824) != 0 ? testReportData.setType : str30, (i & Integer.MIN_VALUE) != 0 ? testReportData.solutionUrl : str31, (i2 & 1) != 0 ? testReportData.startDate : str32, (i2 & 2) != 0 ? testReportData.subjectId : str33, (i2 & 4) != 0 ? testReportData.testAssets : str34, (i2 & 8) != 0 ? testReportData.testCode : str35, (i2 & 16) != 0 ? testReportData.testSeriesId : str36, (i2 & 32) != 0 ? testReportData.testSeriesName : str37, (i2 & 64) != 0 ? testReportData.testType : str38, (i2 & 128) != 0 ? testReportData.timeBoundation : str39, (i2 & 256) != 0 ? testReportData.timeInMins : str40, (i2 & 512) != 0 ? testReportData.topicId : str41, (i2 & 1024) != 0 ? testReportData.totalMarks : str42, (i2 & 2048) != 0 ? testReportData.totalQuestions : str43, (i2 & 4096) != 0 ? testReportData.userId : str44, (i2 & 8192) != 0 ? testReportData.userName : str45);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAllowUserMove() {
        return this.allowUserMove;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDescription2() {
        return this.description2;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDifficultyLevel() {
        return this.difficultyLevel;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDownloadPdf() {
        return this.downloadPdf;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getFaculty() {
        return this.faculty;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getIsCalcAllowed() {
        return this.isCalcAllowed;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getIsFeeds() {
        return this.isFeeds;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getIsRank() {
        return this.isRank;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getIsReattempt() {
        return this.isReattempt;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getLangId() {
        return this.langId;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getMarkingScheme() {
        return this.markingScheme;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getPassingCutoff() {
        return this.passingCutoff;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getPublish() {
        return this.publish;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Object getQrCode() {
        return this.qrCode;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getQuestionPdf() {
        return this.questionPdf;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getResultDate() {
        return this.resultDate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAttemptLimit() {
        return this.attemptLimit;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getRewardPoints() {
        return this.rewardPoints;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getSetType() {
        return this.setType;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getSolutionUrl() {
        return this.solutionUrl;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final String getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getTestAssets() {
        return this.testAssets;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getTestCode() {
        return this.testCode;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final String getTestSeriesId() {
        return this.testSeriesId;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final String getTestSeriesName() {
        return this.testSeriesName;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final String getTestType() {
        return this.testType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAutoAssigning() {
        return this.autoAssigning;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final String getTimeBoundation() {
        return this.timeBoundation;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final String getTimeInMins() {
        return this.timeInMins;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final String getTopicId() {
        return this.topicId;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final String getTotalMarks() {
        return this.totalMarks;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final String getTotalQuestions() {
        return this.totalQuestions;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBackendUserId() {
        return this.backendUserId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getConsiderTime() {
        return this.considerTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDailyAssigment() {
        return this.dailyAssigment;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final TestReportData copy(String allowUserMove, String appId, String attemptLimit, String autoAssigning, String backendUserId, String considerTime, String created, String dailyAssigment, String description, String description2, String difficultyLevel, String downloadPdf, String endDate, String faculty, String id, String image, String isCalcAllowed, String isFeeds, String isRank, String isReattempt, String langId, String markingScheme, String mode, String passingCutoff, String price, String publish, Object qrCode, String questionPdf, String resultDate, String rewardPoints, String setType, String solutionUrl, String startDate, String subjectId, String testAssets, String testCode, String testSeriesId, String testSeriesName, String testType, String timeBoundation, String timeInMins, String topicId, String totalMarks, String totalQuestions, String userId, String userName) {
        Intrinsics.checkNotNullParameter(allowUserMove, "allowUserMove");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(attemptLimit, "attemptLimit");
        Intrinsics.checkNotNullParameter(autoAssigning, "autoAssigning");
        Intrinsics.checkNotNullParameter(backendUserId, "backendUserId");
        Intrinsics.checkNotNullParameter(considerTime, "considerTime");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(dailyAssigment, "dailyAssigment");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(description2, "description2");
        Intrinsics.checkNotNullParameter(difficultyLevel, "difficultyLevel");
        Intrinsics.checkNotNullParameter(downloadPdf, "downloadPdf");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(faculty, "faculty");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(isCalcAllowed, "isCalcAllowed");
        Intrinsics.checkNotNullParameter(isFeeds, "isFeeds");
        Intrinsics.checkNotNullParameter(isRank, "isRank");
        Intrinsics.checkNotNullParameter(isReattempt, "isReattempt");
        Intrinsics.checkNotNullParameter(langId, "langId");
        Intrinsics.checkNotNullParameter(markingScheme, "markingScheme");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(passingCutoff, "passingCutoff");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(publish, "publish");
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        Intrinsics.checkNotNullParameter(questionPdf, "questionPdf");
        Intrinsics.checkNotNullParameter(resultDate, "resultDate");
        Intrinsics.checkNotNullParameter(rewardPoints, "rewardPoints");
        Intrinsics.checkNotNullParameter(setType, "setType");
        Intrinsics.checkNotNullParameter(solutionUrl, "solutionUrl");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(testAssets, "testAssets");
        Intrinsics.checkNotNullParameter(testCode, "testCode");
        Intrinsics.checkNotNullParameter(testSeriesId, "testSeriesId");
        Intrinsics.checkNotNullParameter(testSeriesName, "testSeriesName");
        Intrinsics.checkNotNullParameter(testType, "testType");
        Intrinsics.checkNotNullParameter(timeBoundation, "timeBoundation");
        Intrinsics.checkNotNullParameter(timeInMins, "timeInMins");
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        Intrinsics.checkNotNullParameter(totalMarks, "totalMarks");
        Intrinsics.checkNotNullParameter(totalQuestions, "totalQuestions");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        return new TestReportData(allowUserMove, appId, attemptLimit, autoAssigning, backendUserId, considerTime, created, dailyAssigment, description, description2, difficultyLevel, downloadPdf, endDate, faculty, id, image, isCalcAllowed, isFeeds, isRank, isReattempt, langId, markingScheme, mode, passingCutoff, price, publish, qrCode, questionPdf, resultDate, rewardPoints, setType, solutionUrl, startDate, subjectId, testAssets, testCode, testSeriesId, testSeriesName, testType, timeBoundation, timeInMins, topicId, totalMarks, totalQuestions, userId, userName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestReportData)) {
            return false;
        }
        TestReportData testReportData = (TestReportData) other;
        return Intrinsics.areEqual(this.allowUserMove, testReportData.allowUserMove) && Intrinsics.areEqual(this.appId, testReportData.appId) && Intrinsics.areEqual(this.attemptLimit, testReportData.attemptLimit) && Intrinsics.areEqual(this.autoAssigning, testReportData.autoAssigning) && Intrinsics.areEqual(this.backendUserId, testReportData.backendUserId) && Intrinsics.areEqual(this.considerTime, testReportData.considerTime) && Intrinsics.areEqual(this.created, testReportData.created) && Intrinsics.areEqual(this.dailyAssigment, testReportData.dailyAssigment) && Intrinsics.areEqual(this.description, testReportData.description) && Intrinsics.areEqual(this.description2, testReportData.description2) && Intrinsics.areEqual(this.difficultyLevel, testReportData.difficultyLevel) && Intrinsics.areEqual(this.downloadPdf, testReportData.downloadPdf) && Intrinsics.areEqual(this.endDate, testReportData.endDate) && Intrinsics.areEqual(this.faculty, testReportData.faculty) && Intrinsics.areEqual(this.id, testReportData.id) && Intrinsics.areEqual(this.image, testReportData.image) && Intrinsics.areEqual(this.isCalcAllowed, testReportData.isCalcAllowed) && Intrinsics.areEqual(this.isFeeds, testReportData.isFeeds) && Intrinsics.areEqual(this.isRank, testReportData.isRank) && Intrinsics.areEqual(this.isReattempt, testReportData.isReattempt) && Intrinsics.areEqual(this.langId, testReportData.langId) && Intrinsics.areEqual(this.markingScheme, testReportData.markingScheme) && Intrinsics.areEqual(this.mode, testReportData.mode) && Intrinsics.areEqual(this.passingCutoff, testReportData.passingCutoff) && Intrinsics.areEqual(this.price, testReportData.price) && Intrinsics.areEqual(this.publish, testReportData.publish) && Intrinsics.areEqual(this.qrCode, testReportData.qrCode) && Intrinsics.areEqual(this.questionPdf, testReportData.questionPdf) && Intrinsics.areEqual(this.resultDate, testReportData.resultDate) && Intrinsics.areEqual(this.rewardPoints, testReportData.rewardPoints) && Intrinsics.areEqual(this.setType, testReportData.setType) && Intrinsics.areEqual(this.solutionUrl, testReportData.solutionUrl) && Intrinsics.areEqual(this.startDate, testReportData.startDate) && Intrinsics.areEqual(this.subjectId, testReportData.subjectId) && Intrinsics.areEqual(this.testAssets, testReportData.testAssets) && Intrinsics.areEqual(this.testCode, testReportData.testCode) && Intrinsics.areEqual(this.testSeriesId, testReportData.testSeriesId) && Intrinsics.areEqual(this.testSeriesName, testReportData.testSeriesName) && Intrinsics.areEqual(this.testType, testReportData.testType) && Intrinsics.areEqual(this.timeBoundation, testReportData.timeBoundation) && Intrinsics.areEqual(this.timeInMins, testReportData.timeInMins) && Intrinsics.areEqual(this.topicId, testReportData.topicId) && Intrinsics.areEqual(this.totalMarks, testReportData.totalMarks) && Intrinsics.areEqual(this.totalQuestions, testReportData.totalQuestions) && Intrinsics.areEqual(this.userId, testReportData.userId) && Intrinsics.areEqual(this.userName, testReportData.userName);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.allowUserMove.hashCode() * 31) + this.appId.hashCode()) * 31) + this.attemptLimit.hashCode()) * 31) + this.autoAssigning.hashCode()) * 31) + this.backendUserId.hashCode()) * 31) + this.considerTime.hashCode()) * 31) + this.created.hashCode()) * 31) + this.dailyAssigment.hashCode()) * 31) + this.description.hashCode()) * 31) + this.description2.hashCode()) * 31) + this.difficultyLevel.hashCode()) * 31) + this.downloadPdf.hashCode()) * 31) + this.endDate.hashCode()) * 31) + this.faculty.hashCode()) * 31) + this.id.hashCode()) * 31) + this.image.hashCode()) * 31) + this.isCalcAllowed.hashCode()) * 31) + this.isFeeds.hashCode()) * 31) + this.isRank.hashCode()) * 31) + this.isReattempt.hashCode()) * 31) + this.langId.hashCode()) * 31) + this.markingScheme.hashCode()) * 31) + this.mode.hashCode()) * 31) + this.passingCutoff.hashCode()) * 31) + this.price.hashCode()) * 31) + this.publish.hashCode()) * 31) + this.qrCode.hashCode()) * 31) + this.questionPdf.hashCode()) * 31) + this.resultDate.hashCode()) * 31) + this.rewardPoints.hashCode()) * 31) + this.setType.hashCode()) * 31) + this.solutionUrl.hashCode()) * 31) + this.startDate.hashCode()) * 31) + this.subjectId.hashCode()) * 31) + this.testAssets.hashCode()) * 31) + this.testCode.hashCode()) * 31) + this.testSeriesId.hashCode()) * 31) + this.testSeriesName.hashCode()) * 31) + this.testType.hashCode()) * 31) + this.timeBoundation.hashCode()) * 31) + this.timeInMins.hashCode()) * 31) + this.topicId.hashCode()) * 31) + this.totalMarks.hashCode()) * 31) + this.totalQuestions.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userName.hashCode();
    }

    public String toString() {
        return "TestReportData(allowUserMove=" + this.allowUserMove + ", appId=" + this.appId + ", attemptLimit=" + this.attemptLimit + ", autoAssigning=" + this.autoAssigning + ", backendUserId=" + this.backendUserId + ", considerTime=" + this.considerTime + ", created=" + this.created + ", dailyAssigment=" + this.dailyAssigment + ", description=" + this.description + ", description2=" + this.description2 + ", difficultyLevel=" + this.difficultyLevel + ", downloadPdf=" + this.downloadPdf + ", endDate=" + this.endDate + ", faculty=" + this.faculty + ", id=" + this.id + ", image=" + this.image + ", isCalcAllowed=" + this.isCalcAllowed + ", isFeeds=" + this.isFeeds + ", isRank=" + this.isRank + ", isReattempt=" + this.isReattempt + ", langId=" + this.langId + ", markingScheme=" + this.markingScheme + ", mode=" + this.mode + ", passingCutoff=" + this.passingCutoff + ", price=" + this.price + ", publish=" + this.publish + ", qrCode=" + this.qrCode + ", questionPdf=" + this.questionPdf + ", resultDate=" + this.resultDate + ", rewardPoints=" + this.rewardPoints + ", setType=" + this.setType + ", solutionUrl=" + this.solutionUrl + ", startDate=" + this.startDate + ", subjectId=" + this.subjectId + ", testAssets=" + this.testAssets + ", testCode=" + this.testCode + ", testSeriesId=" + this.testSeriesId + ", testSeriesName=" + this.testSeriesName + ", testType=" + this.testType + ", timeBoundation=" + this.timeBoundation + ", timeInMins=" + this.timeInMins + ", topicId=" + this.topicId + ", totalMarks=" + this.totalMarks + ", totalQuestions=" + this.totalQuestions + ", userId=" + this.userId + ", userName=" + this.userName + ")";
    }

    public TestReportData(String allowUserMove, String appId, String attemptLimit, String autoAssigning, String backendUserId, String considerTime, String created, String dailyAssigment, String description, String description2, String difficultyLevel, String downloadPdf, String endDate, String faculty, String id, String image, String isCalcAllowed, String isFeeds, String isRank, String isReattempt, String langId, String markingScheme, String mode, String passingCutoff, String price, String publish, Object qrCode, String questionPdf, String resultDate, String rewardPoints, String setType, String solutionUrl, String startDate, String subjectId, String testAssets, String testCode, String testSeriesId, String testSeriesName, String testType, String timeBoundation, String timeInMins, String topicId, String totalMarks, String totalQuestions, String userId, String userName) {
        Intrinsics.checkNotNullParameter(allowUserMove, "allowUserMove");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(attemptLimit, "attemptLimit");
        Intrinsics.checkNotNullParameter(autoAssigning, "autoAssigning");
        Intrinsics.checkNotNullParameter(backendUserId, "backendUserId");
        Intrinsics.checkNotNullParameter(considerTime, "considerTime");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(dailyAssigment, "dailyAssigment");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(description2, "description2");
        Intrinsics.checkNotNullParameter(difficultyLevel, "difficultyLevel");
        Intrinsics.checkNotNullParameter(downloadPdf, "downloadPdf");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(faculty, "faculty");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(isCalcAllowed, "isCalcAllowed");
        Intrinsics.checkNotNullParameter(isFeeds, "isFeeds");
        Intrinsics.checkNotNullParameter(isRank, "isRank");
        Intrinsics.checkNotNullParameter(isReattempt, "isReattempt");
        Intrinsics.checkNotNullParameter(langId, "langId");
        Intrinsics.checkNotNullParameter(markingScheme, "markingScheme");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(passingCutoff, "passingCutoff");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(publish, "publish");
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        Intrinsics.checkNotNullParameter(questionPdf, "questionPdf");
        Intrinsics.checkNotNullParameter(resultDate, "resultDate");
        Intrinsics.checkNotNullParameter(rewardPoints, "rewardPoints");
        Intrinsics.checkNotNullParameter(setType, "setType");
        Intrinsics.checkNotNullParameter(solutionUrl, "solutionUrl");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(testAssets, "testAssets");
        Intrinsics.checkNotNullParameter(testCode, "testCode");
        Intrinsics.checkNotNullParameter(testSeriesId, "testSeriesId");
        Intrinsics.checkNotNullParameter(testSeriesName, "testSeriesName");
        Intrinsics.checkNotNullParameter(testType, "testType");
        Intrinsics.checkNotNullParameter(timeBoundation, "timeBoundation");
        Intrinsics.checkNotNullParameter(timeInMins, "timeInMins");
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        Intrinsics.checkNotNullParameter(totalMarks, "totalMarks");
        Intrinsics.checkNotNullParameter(totalQuestions, "totalQuestions");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        this.allowUserMove = allowUserMove;
        this.appId = appId;
        this.attemptLimit = attemptLimit;
        this.autoAssigning = autoAssigning;
        this.backendUserId = backendUserId;
        this.considerTime = considerTime;
        this.created = created;
        this.dailyAssigment = dailyAssigment;
        this.description = description;
        this.description2 = description2;
        this.difficultyLevel = difficultyLevel;
        this.downloadPdf = downloadPdf;
        this.endDate = endDate;
        this.faculty = faculty;
        this.id = id;
        this.image = image;
        this.isCalcAllowed = isCalcAllowed;
        this.isFeeds = isFeeds;
        this.isRank = isRank;
        this.isReattempt = isReattempt;
        this.langId = langId;
        this.markingScheme = markingScheme;
        this.mode = mode;
        this.passingCutoff = passingCutoff;
        this.price = price;
        this.publish = publish;
        this.qrCode = qrCode;
        this.questionPdf = questionPdf;
        this.resultDate = resultDate;
        this.rewardPoints = rewardPoints;
        this.setType = setType;
        this.solutionUrl = solutionUrl;
        this.startDate = startDate;
        this.subjectId = subjectId;
        this.testAssets = testAssets;
        this.testCode = testCode;
        this.testSeriesId = testSeriesId;
        this.testSeriesName = testSeriesName;
        this.testType = testType;
        this.timeBoundation = timeBoundation;
        this.timeInMins = timeInMins;
        this.topicId = topicId;
        this.totalMarks = totalMarks;
        this.totalQuestions = totalQuestions;
        this.userId = userId;
        this.userName = userName;
    }

    public final String getAllowUserMove() {
        return this.allowUserMove;
    }

    public final void setAllowUserMove(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.allowUserMove = str;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final String getAttemptLimit() {
        return this.attemptLimit;
    }

    public final void setAttemptLimit(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attemptLimit = str;
    }

    public final String getAutoAssigning() {
        return this.autoAssigning;
    }

    public final void setAutoAssigning(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.autoAssigning = str;
    }

    public final String getBackendUserId() {
        return this.backendUserId;
    }

    public final void setBackendUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backendUserId = str;
    }

    public final String getConsiderTime() {
        return this.considerTime;
    }

    public final void setConsiderTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.considerTime = str;
    }

    public final String getCreated() {
        return this.created;
    }

    public final void setCreated(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.created = str;
    }

    public final String getDailyAssigment() {
        return this.dailyAssigment;
    }

    public final void setDailyAssigment(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dailyAssigment = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final String getDescription2() {
        return this.description2;
    }

    public final void setDescription2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description2 = str;
    }

    public final String getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public final void setDifficultyLevel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.difficultyLevel = str;
    }

    public final String getDownloadPdf() {
        return this.downloadPdf;
    }

    public final void setDownloadPdf(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.downloadPdf = str;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final void setEndDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endDate = str;
    }

    public final String getFaculty() {
        return this.faculty;
    }

    public final void setFaculty(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.faculty = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image = str;
    }

    public final String isCalcAllowed() {
        return this.isCalcAllowed;
    }

    public final void setCalcAllowed(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isCalcAllowed = str;
    }

    public final String isFeeds() {
        return this.isFeeds;
    }

    public final void setFeeds(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isFeeds = str;
    }

    public final String isRank() {
        return this.isRank;
    }

    public final void setRank(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isRank = str;
    }

    public final String isReattempt() {
        return this.isReattempt;
    }

    public final void setReattempt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isReattempt = str;
    }

    public final String getLangId() {
        return this.langId;
    }

    public final void setLangId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.langId = str;
    }

    public final String getMarkingScheme() {
        return this.markingScheme;
    }

    public final void setMarkingScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.markingScheme = str;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mode = str;
    }

    public final String getPassingCutoff() {
        return this.passingCutoff;
    }

    public final void setPassingCutoff(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.passingCutoff = str;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setPrice(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.price = str;
    }

    public final String getPublish() {
        return this.publish;
    }

    public final void setPublish(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.publish = str;
    }

    public final Object getQrCode() {
        return this.qrCode;
    }

    public final void setQrCode(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.qrCode = obj;
    }

    public final String getQuestionPdf() {
        return this.questionPdf;
    }

    public final void setQuestionPdf(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.questionPdf = str;
    }

    public final String getResultDate() {
        return this.resultDate;
    }

    public final void setResultDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resultDate = str;
    }

    public final String getRewardPoints() {
        return this.rewardPoints;
    }

    public final void setRewardPoints(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rewardPoints = str;
    }

    public final String getSetType() {
        return this.setType;
    }

    public final void setSetType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.setType = str;
    }

    public final String getSolutionUrl() {
        return this.solutionUrl;
    }

    public final void setSolutionUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.solutionUrl = str;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final void setStartDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startDate = str;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final void setSubjectId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectId = str;
    }

    public final String getTestAssets() {
        return this.testAssets;
    }

    public final void setTestAssets(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testAssets = str;
    }

    public final String getTestCode() {
        return this.testCode;
    }

    public final void setTestCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testCode = str;
    }

    public final String getTestSeriesId() {
        return this.testSeriesId;
    }

    public final void setTestSeriesId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testSeriesId = str;
    }

    public final String getTestSeriesName() {
        return this.testSeriesName;
    }

    public final void setTestSeriesName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testSeriesName = str;
    }

    public final String getTestType() {
        return this.testType;
    }

    public final void setTestType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testType = str;
    }

    public final String getTimeBoundation() {
        return this.timeBoundation;
    }

    public final void setTimeBoundation(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeBoundation = str;
    }

    public final String getTimeInMins() {
        return this.timeInMins;
    }

    public final void setTimeInMins(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeInMins = str;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final void setTopicId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.topicId = str;
    }

    public final String getTotalMarks() {
        return this.totalMarks;
    }

    public final void setTotalMarks(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalMarks = str;
    }

    public final String getTotalQuestions() {
        return this.totalQuestions;
    }

    public final void setTotalQuestions(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalQuestions = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userName = str;
    }
}
