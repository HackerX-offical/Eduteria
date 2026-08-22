package com.appnew.android.Utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Attention.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0011"}, d2 = {"Lcom/appnew/android/Utils/Attention;", "", "<init>", "()V", "Bounce", "Landroid/animation/AnimatorSet;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", ExifInterface.TAG_FLASH, "Pulse", "Ruberband", "Shake", "Standup", "Swing", "Tada", "Wave", "Wobble", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Attention {
    public static final int $stable = 0;

    public final AnimatorSet Bounce(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, 0.0f, -30.0f, 0.0f, -15.0f, 0.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat);
        return animatorSet;
    }

    public final AnimatorSet Flash(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f, 1.0f, 0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat);
        return animatorSet;
    }

    public final AnimatorSet Pulse(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat2, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    public final AnimatorSet Ruberband(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.25f, 0.75f, 1.15f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.75f, 1.25f, 0.85f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat2, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    public final AnimatorSet Shake(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.25f, 0.75f, 1.15f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.75f, 1.25f, 0.85f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat2, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    public final AnimatorSet Standup(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        float width = (((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight()) / 2) + view.getPaddingLeft();
        float height = view.getHeight() - view.getPaddingBottom();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "pivotX", width, width, width, width, width);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "pivotY", height, height, height, height, height);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat2, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "rotationX", 55.0f, -30.0f, 15.0f, -15.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat3, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        return animatorSet;
    }

    public final AnimatorSet Swing(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, 10.0f, -10.0f, 6.0f, -6.0f, 3.0f, -3.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat);
        return animatorSet;
    }

    public final AnimatorSet Tada(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.9f, 0.9f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.1f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat2, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, -3.0f, -3.0f, 3.0f, -3.0f, 3.0f, -3.0f, 3.0f, -3.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat3, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        return animatorSet;
    }

    public final AnimatorSet Wave(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        float width = (((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight()) / 2) + view.getPaddingLeft();
        float height = view.getHeight() - view.getPaddingBottom();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 12.0f, -12.0f, 3.0f, -3.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "pivotX", width, width, width, width, width);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat2, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "pivotY", height, height, height, height, height);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat3, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        return animatorSet;
    }

    public final AnimatorSet Wobble(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        float width = (float) (((double) view.getWidth()) / 100.0d);
        float f2 = width * 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", f2, (-25.0f) * width, 20.0f * width, (-15.0f) * width, 10.0f * width, width * (-5.0f), f2, 0.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, -5.0f, 3.0f, -3.0f, 2.0f, -1.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat2, "ofFloat(...)");
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }
}
