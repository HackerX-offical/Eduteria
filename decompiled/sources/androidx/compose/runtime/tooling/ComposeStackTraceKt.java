package androidx.compose.runtime.tooling;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MovableContentKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ComposeStackTrace.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b*\u00060\tj\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u000b\u001a\u00020\b*\u00060\tj\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u0005H\u0000\u001a\u0018\u0010\u000f\u001a\u00020\b*\u00060\tj\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"tryAttachComposeStackTrace", "", "", "trace", "Lkotlin/Function0;", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "attachComposeStackTrace", "appendStackTrace", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "appendSourceInformationStackTrace", "filterInternalFramesByGroupKey", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "appendGroupKeyStackTrace", "RuntimePackageHash", "", "IncludeDebugInfo", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ComposeStackTraceKt {
    private static final boolean IncludeDebugInfo = false;
    private static final String RuntimePackageHash = "9igjgp";

    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean tryAttachComposeStackTrace(java.lang.Throwable r5, kotlin.jvm.functions.Function0<androidx.compose.runtime.tooling.ComposeStackTrace> r6) {
        /*
            java.util.List r0 = kotlin.ExceptionsKt.getSuppressedExceptions(r5)
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            r2 = 0
            r3 = r2
        Ld:
            if (r3 >= r1) goto L1d
            java.lang.Object r4 = r0.get(r3)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r4 = r4 instanceof androidx.compose.runtime.tooling.DiagnosticComposeException
            if (r4 == 0) goto L1a
            return r2
        L1a:
            int r3 = r3 + 1
            goto Ld
        L1d:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L66
            androidx.compose.runtime.tooling.ComposeStackTrace r6 = (androidx.compose.runtime.tooling.ComposeStackTrace) r6     // Catch: java.lang.Throwable -> L66
            if (r6 == 0) goto L57
            boolean r0 = r6.getHasSourceInformation()     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L49
            java.util.List r0 = r6.getFrames()     // Catch: java.lang.Throwable -> L66
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L66
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L66
            r3 = r2
        L37:
            if (r3 >= r1) goto L57
            java.lang.Object r4 = r0.get(r3)     // Catch: java.lang.Throwable -> L66
            androidx.compose.runtime.tooling.ComposeStackTraceFrame r4 = (androidx.compose.runtime.tooling.ComposeStackTraceFrame) r4     // Catch: java.lang.Throwable -> L66
            androidx.compose.runtime.tooling.SourceInformation r4 = r4.getSourceInfo()     // Catch: java.lang.Throwable -> L66
            if (r4 == 0) goto L46
            goto L55
        L46:
            int r3 = r3 + 1
            goto L37
        L49:
            java.util.List r0 = r6.getFrames()     // Catch: java.lang.Throwable -> L66
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L66
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L66
            if (r0 != 0) goto L57
        L55:
            r0 = 1
            r2 = r0
        L57:
            if (r2 == 0) goto L62
            androidx.compose.runtime.tooling.DiagnosticComposeException r0 = new androidx.compose.runtime.tooling.DiagnosticComposeException     // Catch: java.lang.Throwable -> L66
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch: java.lang.Throwable -> L66
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L66
            goto L63
        L62:
            r0 = 0
        L63:
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch: java.lang.Throwable -> L66
            goto L68
        L66:
            r6 = move-exception
            r0 = r6
        L68:
            if (r0 == 0) goto L6d
            kotlin.ExceptionsKt.addSuppressed(r5, r0)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.tooling.ComposeStackTraceKt.tryAttachComposeStackTrace(java.lang.Throwable, kotlin.jvm.functions.Function0):boolean");
    }

    public static final Throwable attachComposeStackTrace(Throwable th, Function0<ComposeStackTrace> function0) {
        tryAttachComposeStackTrace(th, function0);
        return th;
    }

    public static final void appendStackTrace(StringBuilder sb, ComposeStackTrace composeStackTrace) {
        if (composeStackTrace.getHasSourceInformation()) {
            appendSourceInformationStackTrace(sb, composeStackTrace);
        } else {
            appendGroupKeyStackTrace(sb, composeStackTrace);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[PHI: r9
      0x003d: PHI (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v13 java.lang.String) binds: [B:7:0x002a, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void appendSourceInformationStackTrace(java.lang.StringBuilder r12, androidx.compose.runtime.tooling.ComposeStackTrace r13) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.tooling.ComposeStackTraceKt.appendSourceInformationStackTrace(java.lang.StringBuilder, androidx.compose.runtime.tooling.ComposeStackTrace):void");
    }

    public static final List<ComposeStackTraceFrame> filterInternalFramesByGroupKey(ComposeStackTrace composeStackTrace) {
        int[] iArr = {201, 202, 204, 206, 207, 125, ComposerKt.defaultsKey, MovableContentKt.movableContentKey, 200};
        int size = composeStackTrace.getFrames().size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            ComposeStackTraceFrame composeStackTraceFrame = composeStackTrace.getFrames().get(i);
            if (!ArraysKt.contains(iArr, composeStackTraceFrame.getGroupKey())) {
                if (composeStackTraceFrame.getGroupKey() == 100) {
                    int i3 = i + 2;
                    if (i3 < size && composeStackTrace.getFrames().get(i3).getGroupKey() == 1000) {
                        break;
                    }
                    CollectionsKt.removeLastOrNull(arrayList);
                } else {
                    arrayList.add(composeStackTraceFrame);
                }
            }
            i = i2;
        }
        return arrayList;
    }

    public static final void appendGroupKeyStackTrace(StringBuilder sb, ComposeStackTrace composeStackTrace) {
        List<ComposeStackTraceFrame> listFilterInternalFramesByGroupKey = filterInternalFramesByGroupKey(composeStackTrace);
        int size = listFilterInternalFramesByGroupKey.size();
        for (int i = 0; i < size; i++) {
            ComposeStackTraceFrame composeStackTraceFrame = listFilterInternalFramesByGroupKey.get(i);
            sb.append("\tat $$compose.m$");
            sb.append(composeStackTraceFrame.getGroupKey());
            sb.append("(SourceFile:1)");
            sb.append('\n');
        }
    }
}
