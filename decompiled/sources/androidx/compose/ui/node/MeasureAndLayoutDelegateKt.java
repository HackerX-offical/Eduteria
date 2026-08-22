package androidx.compose.ui.node;

import android.os.Trace;
import androidx.compose.runtime.tooling.ComposeToolingFlags;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: MeasureAndLayoutDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006\u001a2\u0010\u0007\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"traceMeasureLayout", ExifInterface.GPS_DIRECTION_TRUE, "label", "", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "traceMeasureLayoutIf", AMPExtension.Condition.ATTRIBUTE_NAME, "", "(ZLjava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MeasureAndLayoutDelegateKt {
    public static final <T> T traceMeasureLayout(String str, Function0<? extends T> function0) {
        if (!ComposeToolingFlags.isVerboseTracingEnabled) {
            return function0.invoke();
        }
        Trace.beginSection(str);
        try {
            return function0.invoke();
        } finally {
            Trace.endSection();
        }
    }

    public static final <T> T traceMeasureLayoutIf(boolean z, String str, Function0<? extends T> function0) {
        if (!ComposeToolingFlags.isVerboseTracingEnabled || !z) {
            return function0.invoke();
        }
        Trace.beginSection(str);
        try {
            return function0.invoke();
        } finally {
            Trace.endSection();
        }
    }
}
