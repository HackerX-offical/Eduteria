package androidx.compose.ui.input.key;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/input/key/KeyEvent;", "", "nativeKeyEvent", "Landroid/view/KeyEvent;", "Landroidx/compose/ui/input/key/NativeKeyEvent;", "constructor-impl", "(Landroid/view/KeyEvent;)Landroid/view/KeyEvent;", "getNativeKeyEvent", "()Landroid/view/KeyEvent;", "Landroid/view/KeyEvent;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class KeyEvent {
    private final android.view.KeyEvent nativeKeyEvent;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyEvent m7127boximpl(android.view.KeyEvent keyEvent) {
        return new KeyEvent(keyEvent);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static android.view.KeyEvent m7128constructorimpl(android.view.KeyEvent keyEvent) {
        return keyEvent;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7129equalsimpl(android.view.KeyEvent keyEvent, Object obj) {
        return (obj instanceof KeyEvent) && Intrinsics.areEqual(keyEvent, ((KeyEvent) obj).m7133unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7130equalsimpl0(android.view.KeyEvent keyEvent, android.view.KeyEvent keyEvent2) {
        return Intrinsics.areEqual(keyEvent, keyEvent2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7131hashCodeimpl(android.view.KeyEvent keyEvent) {
        return keyEvent.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7132toStringimpl(android.view.KeyEvent keyEvent) {
        return "KeyEvent(nativeKeyEvent=" + keyEvent + ')';
    }

    public boolean equals(Object other) {
        return m7129equalsimpl(this.nativeKeyEvent, other);
    }

    public int hashCode() {
        return m7131hashCodeimpl(this.nativeKeyEvent);
    }

    public String toString() {
        return m7132toStringimpl(this.nativeKeyEvent);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ android.view.KeyEvent m7133unboximpl() {
        return this.nativeKeyEvent;
    }

    private /* synthetic */ KeyEvent(android.view.KeyEvent keyEvent) {
        this.nativeKeyEvent = keyEvent;
    }

    public final android.view.KeyEvent getNativeKeyEvent() {
        return this.nativeKeyEvent;
    }
}
