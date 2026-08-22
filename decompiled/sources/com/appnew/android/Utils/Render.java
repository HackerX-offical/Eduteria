package com.appnew.android.Utils;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Render.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/Utils/Render;", "", "cx", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getCx", "()Landroid/content/Context;", "setCx", "du", "", "getDu", "()J", "setDu", "(J)V", "animatorSet", "Landroid/animation/AnimatorSet;", "getAnimatorSet", "()Landroid/animation/AnimatorSet;", "setAnimatorSet", "(Landroid/animation/AnimatorSet;)V", "setAnimation", "", "setDuration", TypedValues.TransitionType.S_DURATION, "start", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Render {
    public static final int $stable = 8;
    public AnimatorSet animatorSet;
    private Context cx;
    private long du;

    public Render(Context cx) {
        Intrinsics.checkNotNullParameter(cx, "cx");
        this.cx = cx;
        this.du = 1000L;
    }

    public final Context getCx() {
        return this.cx;
    }

    public final void setCx(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.cx = context;
    }

    public final long getDu() {
        return this.du;
    }

    public final void setDu(long j) {
        this.du = j;
    }

    public final AnimatorSet getAnimatorSet() {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            return animatorSet;
        }
        Intrinsics.throwUninitializedPropertyAccessException("animatorSet");
        return null;
    }

    public final void setAnimatorSet(AnimatorSet animatorSet) {
        Intrinsics.checkNotNullParameter(animatorSet, "<set-?>");
        this.animatorSet = animatorSet;
    }

    public final void setAnimation(AnimatorSet animatorSet) {
        Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
        setAnimatorSet(animatorSet);
    }

    public final void setDuration(long duration) {
        this.du = duration;
    }

    public final void start() {
        getAnimatorSet().setDuration(this.du);
        getAnimatorSet().setInterpolator(new AccelerateInterpolator());
        getAnimatorSet().start();
    }
}
