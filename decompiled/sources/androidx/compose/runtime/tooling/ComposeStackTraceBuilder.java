package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.composer.GroupSourceInformation;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: ComposeStackTraceBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u000eH\u0002J,\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0001H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH&R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/tooling/ComposeStackTraceBuilder;", "", "<init>", "()V", "_trace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "trace", "", "appendTraceFrame", "", "groupKey", "", "groupSourceInformation", "Landroidx/compose/runtime/composer/GroupSourceInformation;", "child", "extractTraceFrame", "targetChild", "sourceInformationOf", "group", "isCall", "", "processEdge", "objectKey", "sourceInformation", "childData", "appendGroupSourceInformation", TypedValues.AttributesType.S_TARGET, ReferenceElement.ATTR_ANCHOR, "Landroidx/compose/runtime/Anchor;", "groupKeyOf", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ComposeStackTraceBuilder {
    public static final int $stable = 8;
    private final List<ComposeStackTraceFrame> _trace = new ArrayList();

    public abstract int groupKeyOf(Anchor anchor);

    public abstract GroupSourceInformation sourceInformationOf(Anchor anchor);

    public final List<ComposeStackTraceFrame> trace() {
        return this._trace;
    }

    private final void appendTraceFrame(int groupKey, GroupSourceInformation groupSourceInformation, Object child) {
        ComposeStackTraceFrame composeStackTraceFrameExtractTraceFrame = extractTraceFrame(groupKey, groupSourceInformation, child);
        if (composeStackTraceFrameExtractTraceFrame != null) {
            this._trace.add(composeStackTraceFrameExtractTraceFrame);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.runtime.tooling.ComposeStackTraceFrame extractTraceFrame(int r12, androidx.compose.runtime.composer.GroupSourceInformation r13, java.lang.Object r14) {
        /*
            r11 = this;
            r0 = 0
            if (r13 == 0) goto Le
            java.lang.String r1 = r13.getSourceInformation()
            if (r1 == 0) goto Le
            androidx.compose.runtime.tooling.SourceInformation r1 = androidx.compose.runtime.tooling.SourceInformationKt.parseSourceInformation(r1)
            goto Lf
        Le:
            r1 = r0
        Lf:
            if (r1 == 0) goto La1
            if (r14 != 0) goto L19
            androidx.compose.runtime.tooling.ComposeStackTraceFrame r13 = new androidx.compose.runtime.tooling.ComposeStackTraceFrame
            r13.<init>(r12, r1, r0)
            return r13
        L19:
            java.util.ArrayList r13 = r13.getGroups()
            r2 = 0
            if (r13 == 0) goto L97
            r3 = r13
            java.util.Collection r3 = (java.util.Collection) r3
            int r3 = r3.size()
            r4 = r2
            r5 = r4
        L29:
            if (r4 >= r3) goto L96
            java.lang.Object r6 = r13.get(r4)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r14)
            if (r7 != 0) goto L96
            androidx.compose.runtime.composer.GroupSourceInformation r7 = r11.sourceInformationOf(r6)
            r8 = 1
            if (r7 == 0) goto L89
            int r9 = r7.getKey()
            r10 = -127(0xffffffffffffff81, float:NaN)
            if (r9 == r10) goto L56
            int r9 = r7.getKey()
            if (r9 != 0) goto L89
            boolean r9 = r6 instanceof androidx.compose.runtime.Anchor
            if (r9 == 0) goto L89
            androidx.compose.runtime.Anchor r6 = (androidx.compose.runtime.Anchor) r6
            int r6 = r11.groupKeyOf(r6)
            if (r6 != r10) goto L89
        L56:
            if (r7 == 0) goto L5d
            java.lang.String r6 = r7.getSourceInformation()
            goto L5e
        L5d:
            r6 = r0
        L5e:
            if (r6 != 0) goto L89
            if (r7 == 0) goto L93
            java.util.ArrayList r6 = r7.getGroups()
            if (r6 == 0) goto L93
            java.util.List r6 = (java.util.List) r6
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            int r7 = r7.size()
            r9 = r2
        L72:
            if (r9 >= r7) goto L93
            java.lang.Object r10 = r6.get(r9)
            androidx.compose.runtime.composer.GroupSourceInformation r10 = r11.sourceInformationOf(r10)
            if (r10 == 0) goto L86
            boolean r10 = r11.isCall(r10)
            if (r10 != r8) goto L86
            int r5 = r5 + 1
        L86:
            int r9 = r9 + 1
            goto L72
        L89:
            if (r7 == 0) goto L93
            boolean r6 = r11.isCall(r7)
            if (r6 != r8) goto L93
            int r5 = r5 + 1
        L93:
            int r4 = r4 + 1
            goto L29
        L96:
            r2 = r5
        L97:
            androidx.compose.runtime.tooling.ComposeStackTraceFrame r13 = new androidx.compose.runtime.tooling.ComposeStackTraceFrame
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)
            r13.<init>(r12, r1, r14)
            return r13
        La1:
            androidx.compose.runtime.tooling.ComposeStackTraceFrame r13 = new androidx.compose.runtime.tooling.ComposeStackTraceFrame
            r13.<init>(r12, r0, r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.tooling.ComposeStackTraceBuilder.extractTraceFrame(int, androidx.compose.runtime.composer.GroupSourceInformation, java.lang.Object):androidx.compose.runtime.tooling.ComposeStackTraceFrame");
    }

    private final GroupSourceInformation sourceInformationOf(Object group) {
        if (group instanceof Anchor) {
            return sourceInformationOf((Anchor) group);
        }
        if (group instanceof GroupSourceInformation) {
            return (GroupSourceInformation) group;
        }
        throw new IllegalStateException(("Unexpected child source info " + group).toString());
    }

    private final boolean isCall(GroupSourceInformation groupSourceInformation) {
        String sourceInformation = groupSourceInformation.getSourceInformation();
        return sourceInformation != null && StringsKt.startsWith$default(sourceInformation, "C", false, 2, (Object) null);
    }

    public final void processEdge(int groupKey, Object objectKey, GroupSourceInformation sourceInformation, Object childData) {
        if (sourceInformation != null || Intrinsics.areEqual(objectKey, Composer.INSTANCE.getEmpty())) {
            if (childData == null || sourceInformation == null) {
                appendTraceFrame(groupKey, sourceInformation, null);
            } else {
                if (appendGroupSourceInformation(groupKey, sourceInformation, childData) || sourceInformation.getClosed()) {
                    return;
                }
                appendTraceFrame(groupKey, sourceInformation, childData);
            }
        }
    }

    private final boolean appendGroupSourceInformation(int groupKey, GroupSourceInformation sourceInformation, Object target) {
        ArrayList<Object> groups = sourceInformation.getGroups();
        boolean z = false;
        if (groups == null) {
            if (!sourceInformation.getClosed()) {
                appendTraceFrame(groupKey, sourceInformation, null);
                return true;
            }
            int dataStartOffset = sourceInformation.getDataStartOffset();
            int dataEndOffset = sourceInformation.getDataEndOffset();
            boolean z2 = target instanceof Integer;
            if (z2) {
                Number number = (Number) target;
                int iIntValue = number.intValue();
                if ((dataStartOffset <= iIntValue && iIntValue < dataEndOffset) || (dataStartOffset == dataEndOffset && z2 && dataStartOffset == number.intValue())) {
                    z = true;
                }
                if (z) {
                    appendTraceFrame(sourceInformation.getKey(), sourceInformation, null);
                }
            }
            return z;
        }
        ArrayList<Object> arrayList = groups;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof Anchor) {
                if (Intrinsics.areEqual(obj, target)) {
                    appendTraceFrame(sourceInformation.getKey(), sourceInformation, obj);
                    return true;
                }
            } else if (obj instanceof GroupSourceInformation) {
                if (appendGroupSourceInformation(groupKey, (GroupSourceInformation) obj, target)) {
                    appendTraceFrame(sourceInformation.getKey(), sourceInformation, obj);
                    return true;
                }
            } else {
                throw new IllegalStateException(("Unexpected child source info " + obj).toString());
            }
        }
        return false;
    }
}
