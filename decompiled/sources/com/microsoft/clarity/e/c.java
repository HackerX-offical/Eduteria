package com.microsoft.clarity.e;

import android.content.Context;
import com.csvreader.CsvReader;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.e.b;
import com.microsoft.clarity.i.s;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.commands.ClipRect;
import com.microsoft.clarity.models.display.commands.DisplayCommand;
import com.microsoft.clarity.models.observers.FramePicture;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import com.microsoft.clarity.models.viewhierarchy.WebViewData;
import com.microsoft.clarity.n.j;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.microsoft.clarity.m.a f750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.microsoft.clarity.i.e f751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f752d;

    public static final class a implements com.microsoft.clarity.h.d, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f753a;

        public a(com.microsoft.clarity.f.f fVar) {
            this.f753a = fVar;
        }

        @Override // com.microsoft.clarity.h.d
        public final /* synthetic */ void a(Exception exc, ErrorType errorType) {
            this.f753a.invoke(exc, errorType);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof com.microsoft.clarity.h.d) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(this.f753a, ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f753a;
        }

        public final int hashCode() {
            return this.f753a.hashCode();
        }
    }

    public c(Context context, MaskingMode maskingMode, s skiaParserFactory, com.microsoft.clarity.f.f errorCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(maskingMode, "maskingMode");
        Intrinsics.checkNotNullParameter(skiaParserFactory, "skiaParserFactory");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        this.f749a = new b(maskingMode);
        com.microsoft.clarity.g.g gVar = com.microsoft.clarity.b.a.f689a;
        this.f750b = a.C0184a.d(context);
        this.f751c = skiaParserFactory.a(new a(errorCallback));
    }

    public static void a(DisplayFrame displayFrame) {
        List<DisplayCommand> commands = displayFrame.getCommands();
        ArrayList arrayList = new ArrayList();
        for (Object obj : commands) {
            if (obj instanceof ClipRect) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (b.a.g((ClipRect) obj2)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Long.valueOf((long) ((ClipRect) it.next()).getRect().getLeft()));
        }
        ViewHierarchy viewHierarchy = displayFrame.getViewHierarchy();
        Intrinsics.checkNotNull(viewHierarchy);
        for (WebViewData webViewData : viewHierarchy.getWebViewsData()) {
            if (arrayList3.contains(Long.valueOf(webViewData.getRenderNodeId()))) {
                webViewData.setFoundInDisplayList(true);
            }
        }
    }

    public final DisplayFrame a(FramePicture framePicture) {
        Intrinsics.checkNotNullParameter(framePicture, "framePicture");
        com.microsoft.clarity.n.i.b("Process frame picture for " + framePicture.getActivityName() + CsvReader.Letters.POUND + framePicture.getActivityId() + '.');
        framePicture.getPicture().endRecording();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HashMap<String, Class<?>> map = j.f1093a;
        Method methodA = j.a.a("android.graphics.Picture", "writeToStream", OutputStream.class);
        if (methodA != null) {
            methodA.invoke(framePicture.getPicture(), byteArrayOutputStream);
        }
        byteArrayOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "pictureStream.toByteArray()");
        String strB = com.microsoft.clarity.n.b.b(byteArray);
        if (Intrinsics.areEqual(strB, this.f752d)) {
            com.microsoft.clarity.n.i.b("Skipping identical picture.");
            return null;
        }
        try {
            DisplayFrame displayFrameA = this.f751c.a(byteArray);
            displayFrameA.setViewHierarchy(framePicture.getViewHierarchy());
            displayFrameA.setTimestamp(framePicture.getAbsoluteTimestamp());
            displayFrameA.setActivityName(framePicture.getActivityName());
            displayFrameA.setActivityId(framePicture.getActivityId());
            displayFrameA.setScreenWidth(framePicture.getScreenWidth());
            displayFrameA.setScreenHeight(framePicture.getScreenHeight());
            displayFrameA.setDensity(framePicture.getDensity());
            this.f749a.a(framePicture, displayFrameA);
            a(displayFrameA);
            this.f752d = strB;
            return displayFrameA;
        } catch (Exception e2) {
            this.f750b.a(framePicture.getActivityName() + '_' + framePicture.getAbsoluteTimestamp() + ".bin", byteArray);
            throw e2;
        }
    }
}
