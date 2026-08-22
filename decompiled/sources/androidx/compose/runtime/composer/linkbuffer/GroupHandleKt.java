package androidx.compose.runtime.composer.linkbuffer;

import kotlin.Metadata;
import kotlin.UInt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: GroupHandle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\u001a%\u0010\u0004\u001a\u00060\u0001j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0080\b\u001a0\u0010\u0004\u001a\u00060\u0001j\u0002`\u00032\n\u0010\r\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u000e\u001a\u00060\u0006j\u0002`\u00072\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0000\"\u0012\u0010\u0002\u001a\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u001c\u0010\t\u001a\u00020\u0006*\u00060\u0001j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001c\u0010\b\u001a\u00020\u0006*\u00060\u0001j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u000f"}, d2 = {"GroupHandle", "", "NULL_GROUP_HANDLE", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "makeGroupHandle", "groupContext", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "group", "context", "getContext", "(J)I", "getGroup", Message.Thread.PARENT_ATTRIBUTE_NAME, "predecessor", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class GroupHandleKt {
    public static final long NULL_GROUP_HANDLE = -1;

    public static final int getContext(long j) {
        return (int) (j >>> 32);
    }

    public static final int getGroup(long j) {
        return (int) j;
    }

    public static final long makeGroupHandle(int i, int i2) {
        return (((long) UInt.m12488constructorimpl(i2)) & 4294967295L) | (((long) i) << 32);
    }

    public static final long makeGroupHandle(int i, int i2, int i3) {
        long j;
        int iM12488constructorimpl;
        if (i3 >= 0) {
            j = ((long) i2) << 32;
            iM12488constructorimpl = UInt.m12488constructorimpl(i3);
        } else {
            j = ((long) i) << 32;
            iM12488constructorimpl = UInt.m12488constructorimpl(-1);
        }
        return j | (4294967295L & ((long) iM12488constructorimpl));
    }
}
