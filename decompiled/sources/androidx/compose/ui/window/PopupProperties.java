package androidx.compose.ui.window;

import android.os.IBinder;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eB;\b\u0016\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0011BO\b\u0017\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0014BC\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0015B1\b\u0017\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0016BE\b\u0016\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0017Be\b\u0016\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u0018J\u0013\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010*\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b'\u0010\u001c¨\u0006+"}, d2 = {"Landroidx/compose/ui/window/PopupProperties;", "", "flags", "", "inheritSecurePolicy", "", "dismissOnBackPress", "dismissOnClickOutside", "excludeFromSystemGesture", "usePlatformDefaultWidth", "windowType", "windowToken", "Landroid/os/IBinder;", "<init>", "(IZZZZZILandroid/os/IBinder;)V", "focusable", "clippingEnabled", "(ZZZZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZZ)V", "(IZZZZZ)V", "(ZZZZ)V", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZZILandroid/os/IBinder;)V", "getFlags$ui", "()I", "getInheritSecurePolicy$ui", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getExcludeFromSystemGesture", "getUsePlatformDefaultWidth", "getWindowType", "getWindowToken", "()Landroid/os/IBinder;", "getFocusable", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getClippingEnabled", "equals", "other", "hashCode", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupProperties {
    public static final int $stable = 0;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final boolean excludeFromSystemGesture;
    private final int flags;
    private final boolean inheritSecurePolicy;
    private final boolean usePlatformDefaultWidth;
    private final IBinder windowToken;
    private final int windowType;

    public PopupProperties(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2, IBinder iBinder) {
        this.flags = i;
        this.inheritSecurePolicy = z;
        this.dismissOnBackPress = z2;
        this.dismissOnClickOutside = z3;
        this.excludeFromSystemGesture = z4;
        this.usePlatformDefaultWidth = z5;
        this.windowType = i2;
        this.windowToken = iBinder;
    }

    public /* synthetic */ PopupProperties(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2, IBinder iBinder, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? true : z, (i3 & 4) != 0 ? true : z2, (i3 & 8) != 0 ? true : z3, (i3 & 16) != 0 ? true : z4, (i3 & 32) != 0 ? false : z5, (i3 & 64) != 0 ? 1002 : i2, (i3 & 128) != 0 ? null : iBinder);
    }

    /* JADX INFO: renamed from: getFlags$ui, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: getInheritSecurePolicy$ui, reason: from getter */
    public final boolean getInheritSecurePolicy() {
        return this.inheritSecurePolicy;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final boolean getExcludeFromSystemGesture() {
        return this.excludeFromSystemGesture;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public final int getWindowType() {
        return this.windowType;
    }

    public final IBinder getWindowToken() {
        return this.windowToken;
    }

    public /* synthetic */ PopupProperties(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4, (i & 16) != 0 ? false : z5);
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this(z, z2, z3, SecureFlagPolicy.Inherit, true, z4, z5, 1002, (IBinder) null);
    }

    public /* synthetic */ PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i & 16) != 0 ? true : z4, (i & 32) != 0 ? true : z5, (i & 64) != 0 ? false : z6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public /* synthetic */ PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5, boolean z6) {
        this(z, z2, z3, secureFlagPolicy, z4, z5, z6, 1002, (IBinder) null);
    }

    public /* synthetic */ PopupProperties(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? true : z2, (i2 & 8) != 0 ? true : z3, (i2 & 16) != 0 ? true : z4, (i2 & 32) != 0 ? false : z5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public /* synthetic */ PopupProperties(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this(i, z, z2, z3, z4, z5, 1002, (IBinder) null);
    }

    public /* synthetic */ PopupProperties(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public /* synthetic */ PopupProperties(boolean z, boolean z2, boolean z3, boolean z4) {
        this(z, z2, z3, SecureFlagPolicy.Inherit, true, z4);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PopupProperties(boolean r2, boolean r3, boolean r4, androidx.compose.ui.window.SecureFlagPolicy r5, boolean r6, boolean r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = 0
        L5:
            r9 = r8 & 2
            r0 = 1
            if (r9 == 0) goto Lb
            r3 = r0
        Lb:
            r9 = r8 & 4
            if (r9 == 0) goto L10
            r4 = r0
        L10:
            r9 = r8 & 8
            if (r9 == 0) goto L16
            androidx.compose.ui.window.SecureFlagPolicy r5 = androidx.compose.ui.window.SecureFlagPolicy.Inherit
        L16:
            r9 = r8 & 16
            if (r9 == 0) goto L1b
            r6 = r0
        L1b:
            r8 = r8 & 32
            if (r8 == 0) goto L27
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2e
        L27:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2e:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupProperties.<init>(boolean, boolean, boolean, androidx.compose.ui.window.SecureFlagPolicy, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5) {
        this(z, z2, z3, secureFlagPolicy, z4, z5, false, 0, null, RendererCapabilities.DECODER_SUPPORT_MASK, null);
    }

    public /* synthetic */ PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5, boolean z6, int i, IBinder iBinder, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? true : z2, (i2 & 4) != 0 ? true : z3, (i2 & 8) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i2 & 16) != 0 ? true : z4, (i2 & 32) != 0 ? true : z5, (i2 & 64) != 0 ? false : z6, (i2 & 128) != 0 ? 1002 : i, (i2 & 256) != 0 ? null : iBinder);
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5, boolean z6, int i, IBinder iBinder) {
        this(AndroidPopup_androidKt.createFlags(z, secureFlagPolicy, z5), secureFlagPolicy == SecureFlagPolicy.Inherit, z2, z3, z4, z6, i, iBinder);
    }

    public final boolean getFocusable() {
        return (this.flags & 8) == 0;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        if (this.inheritSecurePolicy) {
            return SecureFlagPolicy.Inherit;
        }
        if ((this.flags & 8192) == 0) {
            return SecureFlagPolicy.SecureOff;
        }
        return SecureFlagPolicy.SecureOn;
    }

    public final boolean getClippingEnabled() {
        return (this.flags & 512) == 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PopupProperties)) {
            return false;
        }
        PopupProperties popupProperties = (PopupProperties) other;
        return this.flags == popupProperties.flags && this.inheritSecurePolicy == popupProperties.inheritSecurePolicy && this.dismissOnBackPress == popupProperties.dismissOnBackPress && this.dismissOnClickOutside == popupProperties.dismissOnClickOutside && this.excludeFromSystemGesture == popupProperties.excludeFromSystemGesture && this.usePlatformDefaultWidth == popupProperties.usePlatformDefaultWidth && this.windowType == popupProperties.windowType && Intrinsics.areEqual(this.windowToken, popupProperties.windowToken);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.flags * 31) + Boolean.hashCode(this.inheritSecurePolicy)) * 31) + Boolean.hashCode(this.dismissOnBackPress)) * 31) + Boolean.hashCode(this.dismissOnClickOutside)) * 31) + Boolean.hashCode(this.excludeFromSystemGesture)) * 31) + Boolean.hashCode(this.usePlatformDefaultWidth)) * 31) + this.windowType) * 31;
        IBinder iBinder = this.windowToken;
        return iHashCode + (iBinder != null ? iBinder.hashCode() : 0);
    }
}
