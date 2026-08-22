package androidx.window.embedding;

import android.app.Activity;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverlayInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Landroidx/window/embedding/OverlayInfo;", "", "overlayTag", "", "currentOverlayAttributes", "Landroidx/window/embedding/OverlayAttributes;", "activityStack", "Landroidx/window/embedding/ActivityStack;", "<init>", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;Landroidx/window/embedding/ActivityStack;)V", "getOverlayTag", "()Ljava/lang/String;", "getCurrentOverlayAttributes", "()Landroidx/window/embedding/OverlayAttributes;", "getActivityStack", "()Landroidx/window/embedding/ActivityStack;", "contains", "", "activity", "Landroid/app/Activity;", InAppPurchaseConstants.METHOD_TO_STRING, "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OverlayInfo {
    private final ActivityStack activityStack;
    private final OverlayAttributes currentOverlayAttributes;
    private final String overlayTag;

    public OverlayInfo(String overlayTag, OverlayAttributes overlayAttributes, ActivityStack activityStack) {
        Intrinsics.checkNotNullParameter(overlayTag, "overlayTag");
        this.overlayTag = overlayTag;
        this.currentOverlayAttributes = overlayAttributes;
        this.activityStack = activityStack;
    }

    public final String getOverlayTag() {
        return this.overlayTag;
    }

    public final OverlayAttributes getCurrentOverlayAttributes() {
        return this.currentOverlayAttributes;
    }

    public final ActivityStack getActivityStack() {
        return this.activityStack;
    }

    public final boolean contains(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActivityStack activityStack = this.activityStack;
        if (activityStack != null) {
            return activityStack.contains(activity);
        }
        return false;
    }

    public String toString() {
        return "OverlayInfo: {tag=" + this.overlayTag + ", currentOverlayAttrs=" + this.currentOverlayAttributes + ", activityStack=" + this.activityStack + '}';
    }
}
