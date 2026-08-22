package com.appnew.android.Model.TestReportModel;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u0086\u0001\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0$\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003¢\u0006\u0004\b.\u0010/J\n\u0010\u0084\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020%0$HÆ\u0003J\u0010\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020'0$HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0003HÆ\u0003J¦\u0003\u0010¬\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020'0$2\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u0003HÆ\u0001J\u0016\u0010\u00ad\u0001\u001a\u00030®\u00012\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010°\u0001\u001a\u00030±\u0001HÖ\u0001J\n\u0010²\u0001\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00101\"\u0004\b=\u00103R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00101\"\u0004\b?\u00103R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00101\"\u0004\bA\u00103R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00101\"\u0004\bC\u00103R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00101\"\u0004\bE\u00103R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00101\"\u0004\bG\u00103R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00101\"\u0004\bI\u00103R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00101\"\u0004\bK\u00103R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00101\"\u0004\bM\u00103R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00101\"\u0004\bO\u00103R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00101\"\u0004\bQ\u00103R\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00101\"\u0004\bS\u00103R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00101\"\u0004\bU\u00103R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00101\"\u0004\bW\u00103R\u001e\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00101\"\u0004\bY\u00103R\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00101\"\u0004\b[\u00103R\u001e\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00101\"\u0004\b]\u00103R\u001e\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00101\"\u0004\b_\u00103R\u001e\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00101\"\u0004\ba\u00103R\u001e\u0010\u001b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00101\"\u0004\bc\u00103R\u001e\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00101\"\u0004\be\u00103R\u001e\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00101\"\u0004\bg\u00103R\u001e\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00101\"\u0004\bi\u00103R\u001e\u0010\u001f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u00101\"\u0004\bk\u00103R\u001e\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u00101\"\u0004\bm\u00103R\u001e\u0010!\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u00101\"\u0004\bo\u00103R\u001e\u0010\"\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u00101\"\u0004\bq\u00103R$\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010&\u001a\b\u0012\u0004\u0012\u00020'0$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010s\"\u0004\bw\u0010uR\u001e\u0010(\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u00101\"\u0004\by\u00103R\u001e\u0010)\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u00101\"\u0004\b{\u00103R\u001e\u0010*\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u00101\"\u0004\b}\u00103R\u001e\u0010+\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u00101\"\u0004\b\u007f\u00103R \u0010,\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u00101\"\u0005\b\u0081\u0001\u00103R \u0010-\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u00101\"\u0005\b\u0083\u0001\u00103¨\u0006³\u0001"}, d2 = {"Lcom/appnew/android/Model/TestReportModel/Data;", "", "appId", "", "attempted", "avgMark", "correctCount", "courseId", "creationTime", "cutOff", "dayWise", "firstAttempt", "hideScore", "id", "incorrectCount", "langUsed", "lastView", "marks", "nonAttempt", "percentage", "omrUrl", "question_pdf", "percentile", "questionDump", "rank", "remark", "reportOrigin", "result", "downloadPdf", "hideRank", "resultType", "solution_url", "rewardPoints", "skipTotal", "state", "subject", "", "Lcom/appnew/android/Model/TestReportModel/Subject;", "leaderBoard", "Lcom/appnew/android/Model/TestReportModel/LeaderBoard;", "testSeriesId", "testSeriesMarks", "testSeriesName", "timeRemain", "totalTestSeriesTime", "userId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getAttempted", "setAttempted", "getAvgMark", "setAvgMark", "getCorrectCount", "setCorrectCount", "getCourseId", "setCourseId", "getCreationTime", "setCreationTime", "getCutOff", "setCutOff", "getDayWise", "setDayWise", "getFirstAttempt", "setFirstAttempt", "getHideScore", "setHideScore", "getId", "setId", "getIncorrectCount", "setIncorrectCount", "getLangUsed", "setLangUsed", "getLastView", "setLastView", "getMarks", "setMarks", "getNonAttempt", "setNonAttempt", "getPercentage", "setPercentage", "getOmrUrl", "setOmrUrl", "getQuestion_pdf", "setQuestion_pdf", "getPercentile", "setPercentile", "getQuestionDump", "setQuestionDump", "getRank", "setRank", "getRemark", "setRemark", "getReportOrigin", "setReportOrigin", "getResult", "setResult", "getDownloadPdf", "setDownloadPdf", "getHideRank", "setHideRank", "getResultType", "setResultType", "getSolution_url", "setSolution_url", "getRewardPoints", "setRewardPoints", "getSkipTotal", "setSkipTotal", "getState", "setState", "getSubject", "()Ljava/util/List;", "setSubject", "(Ljava/util/List;)V", "getLeaderBoard", "setLeaderBoard", "getTestSeriesId", "setTestSeriesId", "getTestSeriesMarks", "setTestSeriesMarks", "getTestSeriesName", "setTestSeriesName", "getTimeRemain", "setTimeRemain", "getTotalTestSeriesTime", "setTotalTestSeriesTime", "getUserId", "setUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Data {
    public static final int $stable = 8;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("attempted")
    private String attempted;

    @SerializedName("avg_mark")
    private String avgMark;

    @SerializedName("correct_count")
    private String correctCount;

    @SerializedName("course_id")
    private String courseId;

    @SerializedName(Const.CREATION_TIME)
    private String creationTime;

    @SerializedName("cut_off")
    private String cutOff;

    @SerializedName("day_wise")
    private String dayWise;

    @SerializedName("download_pdf")
    private String downloadPdf;

    @SerializedName("first_attempt")
    private String firstAttempt;

    @SerializedName("hide_rank")
    private String hideRank;

    @SerializedName("hide_score")
    private String hideScore;

    @SerializedName("id")
    private String id;

    @SerializedName("incorrect_count")
    private String incorrectCount;

    @SerializedName(Const.LANG_USED)
    private String langUsed;

    @SerializedName(Const.LAST_VIEW)
    private String lastView;

    @SerializedName("leader_board")
    private List<LeaderBoard> leaderBoard;

    @SerializedName("marks")
    private String marks;

    @SerializedName("non_attempt")
    private String nonAttempt;

    @SerializedName("omr_url")
    private String omrUrl;

    @SerializedName("percentage")
    private String percentage;

    @SerializedName("percentile")
    private String percentile;

    @SerializedName("question_dump")
    private String questionDump;

    @SerializedName("question_pdf")
    private String question_pdf;

    @SerializedName("rank")
    private String rank;

    @SerializedName("remark")
    private String remark;

    @SerializedName("report_origin")
    private String reportOrigin;

    @SerializedName("result")
    private String result;

    @SerializedName("result_type")
    private String resultType;

    @SerializedName("reward_points")
    private String rewardPoints;

    @SerializedName("skip_total")
    private String skipTotal;

    @SerializedName("solution_url")
    private String solution_url;

    @SerializedName("state")
    private String state;

    @SerializedName("subject")
    private List<Subject> subject;

    @SerializedName(Const.TESTSERIES_ID)
    private String testSeriesId;

    @SerializedName("test_series_marks")
    private String testSeriesMarks;

    @SerializedName("test_series_name")
    private String testSeriesName;

    @SerializedName(Const.TIME_REMAIN)
    private String timeRemain;

    @SerializedName("total_test_series_time")
    private String totalTestSeriesTime;

    @SerializedName("user_id")
    private String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, List list, List list2, String str33, String str34, String str35, String str36, String str37, String str38, int i, int i2, Object obj) {
        String str39 = (i & 1) != 0 ? data.appId : str;
        return data.copy(str39, (i & 2) != 0 ? data.attempted : str2, (i & 4) != 0 ? data.avgMark : str3, (i & 8) != 0 ? data.correctCount : str4, (i & 16) != 0 ? data.courseId : str5, (i & 32) != 0 ? data.creationTime : str6, (i & 64) != 0 ? data.cutOff : str7, (i & 128) != 0 ? data.dayWise : str8, (i & 256) != 0 ? data.firstAttempt : str9, (i & 512) != 0 ? data.hideScore : str10, (i & 1024) != 0 ? data.id : str11, (i & 2048) != 0 ? data.incorrectCount : str12, (i & 4096) != 0 ? data.langUsed : str13, (i & 8192) != 0 ? data.lastView : str14, (i & 16384) != 0 ? data.marks : str15, (i & 32768) != 0 ? data.nonAttempt : str16, (i & 65536) != 0 ? data.percentage : str17, (i & 131072) != 0 ? data.omrUrl : str18, (i & 262144) != 0 ? data.question_pdf : str19, (i & 524288) != 0 ? data.percentile : str20, (i & 1048576) != 0 ? data.questionDump : str21, (i & 2097152) != 0 ? data.rank : str22, (i & 4194304) != 0 ? data.remark : str23, (i & 8388608) != 0 ? data.reportOrigin : str24, (i & 16777216) != 0 ? data.result : str25, (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? data.downloadPdf : str26, (i & 67108864) != 0 ? data.hideRank : str27, (i & 134217728) != 0 ? data.resultType : str28, (i & 268435456) != 0 ? data.solution_url : str29, (i & 536870912) != 0 ? data.rewardPoints : str30, (i & 1073741824) != 0 ? data.skipTotal : str31, (i & Integer.MIN_VALUE) != 0 ? data.state : str32, (i2 & 1) != 0 ? data.subject : list, (i2 & 2) != 0 ? data.leaderBoard : list2, (i2 & 4) != 0 ? data.testSeriesId : str33, (i2 & 8) != 0 ? data.testSeriesMarks : str34, (i2 & 16) != 0 ? data.testSeriesName : str35, (i2 & 32) != 0 ? data.timeRemain : str36, (i2 & 64) != 0 ? data.totalTestSeriesTime : str37, (i2 & 128) != 0 ? data.userId : str38);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getHideScore() {
        return this.hideScore;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getIncorrectCount() {
        return this.incorrectCount;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getLangUsed() {
        return this.langUsed;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getLastView() {
        return this.lastView;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getMarks() {
        return this.marks;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getNonAttempt() {
        return this.nonAttempt;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getPercentage() {
        return this.percentage;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getOmrUrl() {
        return this.omrUrl;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getQuestion_pdf() {
        return this.question_pdf;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAttempted() {
        return this.attempted;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getPercentile() {
        return this.percentile;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getQuestionDump() {
        return this.questionDump;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getRank() {
        return this.rank;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getReportOrigin() {
        return this.reportOrigin;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getDownloadPdf() {
        return this.downloadPdf;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getHideRank() {
        return this.hideRank;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getResultType() {
        return this.resultType;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getSolution_url() {
        return this.solution_url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvgMark() {
        return this.avgMark;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getRewardPoints() {
        return this.rewardPoints;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getSkipTotal() {
        return this.skipTotal;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getState() {
        return this.state;
    }

    public final List<Subject> component33() {
        return this.subject;
    }

    public final List<LeaderBoard> component34() {
        return this.leaderBoard;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getTestSeriesId() {
        return this.testSeriesId;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getTestSeriesMarks() {
        return this.testSeriesMarks;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final String getTestSeriesName() {
        return this.testSeriesName;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final String getTimeRemain() {
        return this.timeRemain;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final String getTotalTestSeriesTime() {
        return this.totalTestSeriesTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCorrectCount() {
        return this.correctCount;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCourseId() {
        return this.courseId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCreationTime() {
        return this.creationTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCutOff() {
        return this.cutOff;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDayWise() {
        return this.dayWise;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFirstAttempt() {
        return this.firstAttempt;
    }

    public final Data copy(String appId, String attempted, String avgMark, String correctCount, String courseId, String creationTime, String cutOff, String dayWise, String firstAttempt, String hideScore, String id, String incorrectCount, String langUsed, String lastView, String marks, String nonAttempt, String percentage, String omrUrl, String question_pdf, String percentile, String questionDump, String rank, String remark, String reportOrigin, String result, String downloadPdf, String hideRank, String resultType, String solution_url, String rewardPoints, String skipTotal, String state, List<Subject> subject, List<LeaderBoard> leaderBoard, String testSeriesId, String testSeriesMarks, String testSeriesName, String timeRemain, String totalTestSeriesTime, String userId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(attempted, "attempted");
        Intrinsics.checkNotNullParameter(avgMark, "avgMark");
        Intrinsics.checkNotNullParameter(correctCount, "correctCount");
        Intrinsics.checkNotNullParameter(courseId, "courseId");
        Intrinsics.checkNotNullParameter(creationTime, "creationTime");
        Intrinsics.checkNotNullParameter(cutOff, "cutOff");
        Intrinsics.checkNotNullParameter(dayWise, "dayWise");
        Intrinsics.checkNotNullParameter(firstAttempt, "firstAttempt");
        Intrinsics.checkNotNullParameter(hideScore, "hideScore");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(incorrectCount, "incorrectCount");
        Intrinsics.checkNotNullParameter(langUsed, "langUsed");
        Intrinsics.checkNotNullParameter(lastView, "lastView");
        Intrinsics.checkNotNullParameter(marks, "marks");
        Intrinsics.checkNotNullParameter(nonAttempt, "nonAttempt");
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        Intrinsics.checkNotNullParameter(omrUrl, "omrUrl");
        Intrinsics.checkNotNullParameter(question_pdf, "question_pdf");
        Intrinsics.checkNotNullParameter(percentile, "percentile");
        Intrinsics.checkNotNullParameter(questionDump, "questionDump");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(reportOrigin, "reportOrigin");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(downloadPdf, "downloadPdf");
        Intrinsics.checkNotNullParameter(hideRank, "hideRank");
        Intrinsics.checkNotNullParameter(resultType, "resultType");
        Intrinsics.checkNotNullParameter(solution_url, "solution_url");
        Intrinsics.checkNotNullParameter(rewardPoints, "rewardPoints");
        Intrinsics.checkNotNullParameter(skipTotal, "skipTotal");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(leaderBoard, "leaderBoard");
        Intrinsics.checkNotNullParameter(testSeriesId, "testSeriesId");
        Intrinsics.checkNotNullParameter(testSeriesMarks, "testSeriesMarks");
        Intrinsics.checkNotNullParameter(testSeriesName, "testSeriesName");
        Intrinsics.checkNotNullParameter(timeRemain, "timeRemain");
        Intrinsics.checkNotNullParameter(totalTestSeriesTime, "totalTestSeriesTime");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new Data(appId, attempted, avgMark, correctCount, courseId, creationTime, cutOff, dayWise, firstAttempt, hideScore, id, incorrectCount, langUsed, lastView, marks, nonAttempt, percentage, omrUrl, question_pdf, percentile, questionDump, rank, remark, reportOrigin, result, downloadPdf, hideRank, resultType, solution_url, rewardPoints, skipTotal, state, subject, leaderBoard, testSeriesId, testSeriesMarks, testSeriesName, timeRemain, totalTestSeriesTime, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.appId, data.appId) && Intrinsics.areEqual(this.attempted, data.attempted) && Intrinsics.areEqual(this.avgMark, data.avgMark) && Intrinsics.areEqual(this.correctCount, data.correctCount) && Intrinsics.areEqual(this.courseId, data.courseId) && Intrinsics.areEqual(this.creationTime, data.creationTime) && Intrinsics.areEqual(this.cutOff, data.cutOff) && Intrinsics.areEqual(this.dayWise, data.dayWise) && Intrinsics.areEqual(this.firstAttempt, data.firstAttempt) && Intrinsics.areEqual(this.hideScore, data.hideScore) && Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.incorrectCount, data.incorrectCount) && Intrinsics.areEqual(this.langUsed, data.langUsed) && Intrinsics.areEqual(this.lastView, data.lastView) && Intrinsics.areEqual(this.marks, data.marks) && Intrinsics.areEqual(this.nonAttempt, data.nonAttempt) && Intrinsics.areEqual(this.percentage, data.percentage) && Intrinsics.areEqual(this.omrUrl, data.omrUrl) && Intrinsics.areEqual(this.question_pdf, data.question_pdf) && Intrinsics.areEqual(this.percentile, data.percentile) && Intrinsics.areEqual(this.questionDump, data.questionDump) && Intrinsics.areEqual(this.rank, data.rank) && Intrinsics.areEqual(this.remark, data.remark) && Intrinsics.areEqual(this.reportOrigin, data.reportOrigin) && Intrinsics.areEqual(this.result, data.result) && Intrinsics.areEqual(this.downloadPdf, data.downloadPdf) && Intrinsics.areEqual(this.hideRank, data.hideRank) && Intrinsics.areEqual(this.resultType, data.resultType) && Intrinsics.areEqual(this.solution_url, data.solution_url) && Intrinsics.areEqual(this.rewardPoints, data.rewardPoints) && Intrinsics.areEqual(this.skipTotal, data.skipTotal) && Intrinsics.areEqual(this.state, data.state) && Intrinsics.areEqual(this.subject, data.subject) && Intrinsics.areEqual(this.leaderBoard, data.leaderBoard) && Intrinsics.areEqual(this.testSeriesId, data.testSeriesId) && Intrinsics.areEqual(this.testSeriesMarks, data.testSeriesMarks) && Intrinsics.areEqual(this.testSeriesName, data.testSeriesName) && Intrinsics.areEqual(this.timeRemain, data.timeRemain) && Intrinsics.areEqual(this.totalTestSeriesTime, data.totalTestSeriesTime) && Intrinsics.areEqual(this.userId, data.userId);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.appId.hashCode() * 31) + this.attempted.hashCode()) * 31) + this.avgMark.hashCode()) * 31) + this.correctCount.hashCode()) * 31) + this.courseId.hashCode()) * 31) + this.creationTime.hashCode()) * 31) + this.cutOff.hashCode()) * 31) + this.dayWise.hashCode()) * 31) + this.firstAttempt.hashCode()) * 31) + this.hideScore.hashCode()) * 31) + this.id.hashCode()) * 31) + this.incorrectCount.hashCode()) * 31) + this.langUsed.hashCode()) * 31) + this.lastView.hashCode()) * 31) + this.marks.hashCode()) * 31) + this.nonAttempt.hashCode()) * 31) + this.percentage.hashCode()) * 31) + this.omrUrl.hashCode()) * 31) + this.question_pdf.hashCode()) * 31) + this.percentile.hashCode()) * 31) + this.questionDump.hashCode()) * 31) + this.rank.hashCode()) * 31) + this.remark.hashCode()) * 31) + this.reportOrigin.hashCode()) * 31) + this.result.hashCode()) * 31) + this.downloadPdf.hashCode()) * 31) + this.hideRank.hashCode()) * 31) + this.resultType.hashCode()) * 31) + this.solution_url.hashCode()) * 31) + this.rewardPoints.hashCode()) * 31) + this.skipTotal.hashCode()) * 31) + this.state.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.leaderBoard.hashCode()) * 31) + this.testSeriesId.hashCode()) * 31) + this.testSeriesMarks.hashCode()) * 31) + this.testSeriesName.hashCode()) * 31) + this.timeRemain.hashCode()) * 31) + this.totalTestSeriesTime.hashCode()) * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "Data(appId=" + this.appId + ", attempted=" + this.attempted + ", avgMark=" + this.avgMark + ", correctCount=" + this.correctCount + ", courseId=" + this.courseId + ", creationTime=" + this.creationTime + ", cutOff=" + this.cutOff + ", dayWise=" + this.dayWise + ", firstAttempt=" + this.firstAttempt + ", hideScore=" + this.hideScore + ", id=" + this.id + ", incorrectCount=" + this.incorrectCount + ", langUsed=" + this.langUsed + ", lastView=" + this.lastView + ", marks=" + this.marks + ", nonAttempt=" + this.nonAttempt + ", percentage=" + this.percentage + ", omrUrl=" + this.omrUrl + ", question_pdf=" + this.question_pdf + ", percentile=" + this.percentile + ", questionDump=" + this.questionDump + ", rank=" + this.rank + ", remark=" + this.remark + ", reportOrigin=" + this.reportOrigin + ", result=" + this.result + ", downloadPdf=" + this.downloadPdf + ", hideRank=" + this.hideRank + ", resultType=" + this.resultType + ", solution_url=" + this.solution_url + ", rewardPoints=" + this.rewardPoints + ", skipTotal=" + this.skipTotal + ", state=" + this.state + ", subject=" + this.subject + ", leaderBoard=" + this.leaderBoard + ", testSeriesId=" + this.testSeriesId + ", testSeriesMarks=" + this.testSeriesMarks + ", testSeriesName=" + this.testSeriesName + ", timeRemain=" + this.timeRemain + ", totalTestSeriesTime=" + this.totalTestSeriesTime + ", userId=" + this.userId + ")";
    }

    public Data(String appId, String attempted, String avgMark, String correctCount, String courseId, String creationTime, String cutOff, String dayWise, String firstAttempt, String hideScore, String id, String incorrectCount, String langUsed, String lastView, String marks, String nonAttempt, String percentage, String omrUrl, String question_pdf, String percentile, String questionDump, String rank, String remark, String reportOrigin, String result, String downloadPdf, String hideRank, String resultType, String solution_url, String rewardPoints, String skipTotal, String state, List<Subject> subject, List<LeaderBoard> leaderBoard, String testSeriesId, String testSeriesMarks, String testSeriesName, String timeRemain, String totalTestSeriesTime, String userId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(attempted, "attempted");
        Intrinsics.checkNotNullParameter(avgMark, "avgMark");
        Intrinsics.checkNotNullParameter(correctCount, "correctCount");
        Intrinsics.checkNotNullParameter(courseId, "courseId");
        Intrinsics.checkNotNullParameter(creationTime, "creationTime");
        Intrinsics.checkNotNullParameter(cutOff, "cutOff");
        Intrinsics.checkNotNullParameter(dayWise, "dayWise");
        Intrinsics.checkNotNullParameter(firstAttempt, "firstAttempt");
        Intrinsics.checkNotNullParameter(hideScore, "hideScore");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(incorrectCount, "incorrectCount");
        Intrinsics.checkNotNullParameter(langUsed, "langUsed");
        Intrinsics.checkNotNullParameter(lastView, "lastView");
        Intrinsics.checkNotNullParameter(marks, "marks");
        Intrinsics.checkNotNullParameter(nonAttempt, "nonAttempt");
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        Intrinsics.checkNotNullParameter(omrUrl, "omrUrl");
        Intrinsics.checkNotNullParameter(question_pdf, "question_pdf");
        Intrinsics.checkNotNullParameter(percentile, "percentile");
        Intrinsics.checkNotNullParameter(questionDump, "questionDump");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(reportOrigin, "reportOrigin");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(downloadPdf, "downloadPdf");
        Intrinsics.checkNotNullParameter(hideRank, "hideRank");
        Intrinsics.checkNotNullParameter(resultType, "resultType");
        Intrinsics.checkNotNullParameter(solution_url, "solution_url");
        Intrinsics.checkNotNullParameter(rewardPoints, "rewardPoints");
        Intrinsics.checkNotNullParameter(skipTotal, "skipTotal");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(leaderBoard, "leaderBoard");
        Intrinsics.checkNotNullParameter(testSeriesId, "testSeriesId");
        Intrinsics.checkNotNullParameter(testSeriesMarks, "testSeriesMarks");
        Intrinsics.checkNotNullParameter(testSeriesName, "testSeriesName");
        Intrinsics.checkNotNullParameter(timeRemain, "timeRemain");
        Intrinsics.checkNotNullParameter(totalTestSeriesTime, "totalTestSeriesTime");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.appId = appId;
        this.attempted = attempted;
        this.avgMark = avgMark;
        this.correctCount = correctCount;
        this.courseId = courseId;
        this.creationTime = creationTime;
        this.cutOff = cutOff;
        this.dayWise = dayWise;
        this.firstAttempt = firstAttempt;
        this.hideScore = hideScore;
        this.id = id;
        this.incorrectCount = incorrectCount;
        this.langUsed = langUsed;
        this.lastView = lastView;
        this.marks = marks;
        this.nonAttempt = nonAttempt;
        this.percentage = percentage;
        this.omrUrl = omrUrl;
        this.question_pdf = question_pdf;
        this.percentile = percentile;
        this.questionDump = questionDump;
        this.rank = rank;
        this.remark = remark;
        this.reportOrigin = reportOrigin;
        this.result = result;
        this.downloadPdf = downloadPdf;
        this.hideRank = hideRank;
        this.resultType = resultType;
        this.solution_url = solution_url;
        this.rewardPoints = rewardPoints;
        this.skipTotal = skipTotal;
        this.state = state;
        this.subject = subject;
        this.leaderBoard = leaderBoard;
        this.testSeriesId = testSeriesId;
        this.testSeriesMarks = testSeriesMarks;
        this.testSeriesName = testSeriesName;
        this.timeRemain = timeRemain;
        this.totalTestSeriesTime = totalTestSeriesTime;
        this.userId = userId;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final String getAttempted() {
        return this.attempted;
    }

    public final void setAttempted(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attempted = str;
    }

    public final String getAvgMark() {
        return this.avgMark;
    }

    public final void setAvgMark(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avgMark = str;
    }

    public final String getCorrectCount() {
        return this.correctCount;
    }

    public final void setCorrectCount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.correctCount = str;
    }

    public final String getCourseId() {
        return this.courseId;
    }

    public final void setCourseId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.courseId = str;
    }

    public final String getCreationTime() {
        return this.creationTime;
    }

    public final void setCreationTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.creationTime = str;
    }

    public final String getCutOff() {
        return this.cutOff;
    }

    public final void setCutOff(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cutOff = str;
    }

    public final String getDayWise() {
        return this.dayWise;
    }

    public final void setDayWise(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dayWise = str;
    }

    public final String getFirstAttempt() {
        return this.firstAttempt;
    }

    public final void setFirstAttempt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstAttempt = str;
    }

    public final String getHideScore() {
        return this.hideScore;
    }

    public final void setHideScore(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hideScore = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getIncorrectCount() {
        return this.incorrectCount;
    }

    public final void setIncorrectCount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.incorrectCount = str;
    }

    public final String getLangUsed() {
        return this.langUsed;
    }

    public final void setLangUsed(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.langUsed = str;
    }

    public final String getLastView() {
        return this.lastView;
    }

    public final void setLastView(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastView = str;
    }

    public final String getMarks() {
        return this.marks;
    }

    public final void setMarks(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.marks = str;
    }

    public final String getNonAttempt() {
        return this.nonAttempt;
    }

    public final void setNonAttempt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nonAttempt = str;
    }

    public final String getPercentage() {
        return this.percentage;
    }

    public final void setPercentage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.percentage = str;
    }

    public final String getOmrUrl() {
        return this.omrUrl;
    }

    public final void setOmrUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.omrUrl = str;
    }

    public final String getQuestion_pdf() {
        return this.question_pdf;
    }

    public final void setQuestion_pdf(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.question_pdf = str;
    }

    public final String getPercentile() {
        return this.percentile;
    }

    public final void setPercentile(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.percentile = str;
    }

    public final String getQuestionDump() {
        return this.questionDump;
    }

    public final void setQuestionDump(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.questionDump = str;
    }

    public final String getRank() {
        return this.rank;
    }

    public final void setRank(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rank = str;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final void setRemark(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.remark = str;
    }

    public final String getReportOrigin() {
        return this.reportOrigin;
    }

    public final void setReportOrigin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reportOrigin = str;
    }

    public final String getResult() {
        return this.result;
    }

    public final void setResult(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.result = str;
    }

    public final String getDownloadPdf() {
        return this.downloadPdf;
    }

    public final void setDownloadPdf(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.downloadPdf = str;
    }

    public final String getHideRank() {
        return this.hideRank;
    }

    public final void setHideRank(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hideRank = str;
    }

    public final String getResultType() {
        return this.resultType;
    }

    public final void setResultType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resultType = str;
    }

    public final String getSolution_url() {
        return this.solution_url;
    }

    public final void setSolution_url(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.solution_url = str;
    }

    public final String getRewardPoints() {
        return this.rewardPoints;
    }

    public final void setRewardPoints(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rewardPoints = str;
    }

    public final String getSkipTotal() {
        return this.skipTotal;
    }

    public final void setSkipTotal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.skipTotal = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.state = str;
    }

    public final List<Subject> getSubject() {
        return this.subject;
    }

    public final void setSubject(List<Subject> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subject = list;
    }

    public final List<LeaderBoard> getLeaderBoard() {
        return this.leaderBoard;
    }

    public final void setLeaderBoard(List<LeaderBoard> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.leaderBoard = list;
    }

    public final String getTestSeriesId() {
        return this.testSeriesId;
    }

    public final void setTestSeriesId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testSeriesId = str;
    }

    public final String getTestSeriesMarks() {
        return this.testSeriesMarks;
    }

    public final void setTestSeriesMarks(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testSeriesMarks = str;
    }

    public final String getTestSeriesName() {
        return this.testSeriesName;
    }

    public final void setTestSeriesName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testSeriesName = str;
    }

    public final String getTimeRemain() {
        return this.timeRemain;
    }

    public final void setTimeRemain(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeRemain = str;
    }

    public final String getTotalTestSeriesTime() {
        return this.totalTestSeriesTime;
    }

    public final void setTotalTestSeriesTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalTestSeriesTime = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }
}
