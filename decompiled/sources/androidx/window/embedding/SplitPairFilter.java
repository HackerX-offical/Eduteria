package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplitPairFilter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0013\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001f"}, d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "_primaryActivityName", "Landroidx/window/core/ActivityComponentInfo;", "_secondaryActivityName", "secondaryActivityIntentAction", "", "<init>", "(Landroidx/window/core/ActivityComponentInfo;Landroidx/window/core/ActivityComponentInfo;Ljava/lang/String;)V", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityName", "matchesActivityPair", "", "primaryActivity", "Landroid/app/Activity;", "secondaryActivity", "matchesActivityIntentPair", "secondaryActivityIntent", "Landroid/content/Intent;", InAppPurchaseConstants.METHOD_TO_STRING, "equals", "other", "hashCode", "", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SplitPairFilter {
    private final ActivityComponentInfo _primaryActivityName;
    private final ActivityComponentInfo _secondaryActivityName;

    /* JADX INFO: renamed from: secondaryActivityIntentAction, reason: from kotlin metadata and from toString */
    private final String secondaryActivityAction;

    public SplitPairFilter(ActivityComponentInfo _primaryActivityName, ActivityComponentInfo _secondaryActivityName, String str) {
        Intrinsics.checkNotNullParameter(_primaryActivityName, "_primaryActivityName");
        Intrinsics.checkNotNullParameter(_secondaryActivityName, "_secondaryActivityName");
        this._primaryActivityName = _primaryActivityName;
        this._secondaryActivityName = _secondaryActivityName;
        this.secondaryActivityAction = str;
        MatcherUtils.INSTANCE.validateComponentName$window_release(_primaryActivityName.getPackageName(), _primaryActivityName.getClassName());
        MatcherUtils.INSTANCE.validateComponentName$window_release(_secondaryActivityName.getPackageName(), _secondaryActivityName.getClassName());
    }

    /* JADX INFO: renamed from: getSecondaryActivityIntentAction, reason: from getter */
    public final String getSecondaryActivityAction() {
        return this.secondaryActivityAction;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplitPairFilter(ComponentName primaryActivityName, ComponentName secondaryActivityName, String str) {
        this(new ActivityComponentInfo(primaryActivityName), new ActivityComponentInfo(secondaryActivityName), str);
        Intrinsics.checkNotNullParameter(primaryActivityName, "primaryActivityName");
        Intrinsics.checkNotNullParameter(secondaryActivityName, "secondaryActivityName");
    }

    public final ComponentName getPrimaryActivityName() {
        return new ComponentName(this._primaryActivityName.getPackageName(), this._primaryActivityName.getClassName());
    }

    public final ComponentName getSecondaryActivityName() {
        return new ComponentName(this._secondaryActivityName.getPackageName(), this._secondaryActivityName.getClassName());
    }

    public final boolean matchesActivityPair(Activity primaryActivity, Activity secondaryActivity) {
        Intrinsics.checkNotNullParameter(primaryActivity, "primaryActivity");
        Intrinsics.checkNotNullParameter(secondaryActivity, "secondaryActivity");
        if (!MatcherUtils.INSTANCE.isActivityMatching$window_release(primaryActivity, this._primaryActivityName) || !MatcherUtils.INSTANCE.isActivityMatching$window_release(secondaryActivity, this._secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityAction;
        if (str == null) {
            return true;
        }
        Intent intent = secondaryActivity.getIntent();
        return Intrinsics.areEqual(str, intent != null ? intent.getAction() : null);
    }

    public final boolean matchesActivityIntentPair(Activity primaryActivity, Intent secondaryActivityIntent) {
        Intrinsics.checkNotNullParameter(primaryActivity, "primaryActivity");
        Intrinsics.checkNotNullParameter(secondaryActivityIntent, "secondaryActivityIntent");
        if (!MatcherUtils.INSTANCE.isActivityMatching$window_release(primaryActivity, this._primaryActivityName) || !MatcherUtils.INSTANCE.isIntentMatching$window_release(secondaryActivityIntent, this._secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityAction;
        return str == null || Intrinsics.areEqual(str, secondaryActivityIntent.getAction());
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + getPrimaryActivityName() + ", secondaryActivityName=" + getSecondaryActivityName() + ", secondaryActivityAction=" + this.secondaryActivityAction + '}';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.window.embedding.SplitPairFilter");
        SplitPairFilter splitPairFilter = (SplitPairFilter) other;
        return Intrinsics.areEqual(this._primaryActivityName, splitPairFilter._primaryActivityName) && Intrinsics.areEqual(this._secondaryActivityName, splitPairFilter._secondaryActivityName) && Intrinsics.areEqual(this.secondaryActivityAction, splitPairFilter.secondaryActivityAction);
    }

    public int hashCode() {
        int iHashCode = ((this._primaryActivityName.hashCode() * 31) + this._secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityAction;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
