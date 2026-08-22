package com.appnew.android.Utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedRecyclerView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0019\u001aBK\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003J\u0006\u0010\u0018\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/appnew/android/Utils/AnimatedRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", Constants.KEY_ORIENTATION, "", "reverse", "", "animationDuration", "layoutManagerType", "columns", "animation", "animationController", "Landroid/view/animation/LayoutAnimationController;", "<init>", "(Landroid/content/Context;IZIIIILandroid/view/animation/LayoutAnimationController;)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "notifyDataSetChanged", "Builder", "LayoutManagerType", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnimatedRecyclerView extends RecyclerView {
    public static final int $stable = 8;
    private int animation;
    private LayoutAnimationController animationController;
    private int animationDuration;
    private int columns;
    private int layoutManagerType;
    private int orientation;
    private boolean reverse;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedRecyclerView(Context context, int i, boolean z, int i2, int i3, int i4, int i5, LayoutAnimationController layoutAnimationController) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.orientation = i;
        this.reverse = z;
        this.animationDuration = i2;
        this.layoutManagerType = i3;
        this.columns = i4;
        this.animation = i5;
        this.animationController = layoutAnimationController;
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedRecyclerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.orientation = 1;
        this.animationDuration = 600;
        this.columns = 1;
        this.animation = R.anim.layout_animation_from_bottom;
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.orientation = 1;
        this.animationDuration = 600;
        this.columns = 1;
        this.animation = R.anim.layout_animation_from_bottom;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.orientation = 1;
        this.animationDuration = 600;
        this.columns = 1;
        this.animation = R.anim.layout_animation_from_bottom;
        init(context, attributeSet);
    }

    private final void init(Context context, AttributeSet attrs) {
        LayoutAnimationController layoutAnimationControllerLoadLayoutAnimation;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, com.appnew.android.R.styleable.AnimatedRecyclerView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.orientation = typedArrayObtainStyledAttributes.getInt(3, this.orientation);
        this.reverse = typedArrayObtainStyledAttributes.getBoolean(4, this.reverse);
        this.animationDuration = typedArrayObtainStyledAttributes.getInt(0, this.animationDuration);
        this.layoutManagerType = typedArrayObtainStyledAttributes.getInt(5, this.layoutManagerType);
        this.columns = typedArrayObtainStyledAttributes.getInt(1, this.columns);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.animation = resourceId;
        if (this.animationController == null) {
            if (resourceId != -1) {
                layoutAnimationControllerLoadLayoutAnimation = AnimationUtils.loadLayoutAnimation(getContext(), this.animation);
            } else {
                layoutAnimationControllerLoadLayoutAnimation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_from_bottom);
            }
            this.animationController = layoutAnimationControllerLoadLayoutAnimation;
        }
        LayoutAnimationController layoutAnimationController = this.animationController;
        Intrinsics.checkNotNull(layoutAnimationController);
        layoutAnimationController.getAnimation().setDuration(this.animationDuration);
        setLayoutAnimation(this.animationController);
        int i = this.layoutManagerType;
        if (i == 0) {
            setLayoutManager(new LinearLayoutManager(context, this.orientation, this.reverse));
        } else if (i == 1) {
            setLayoutManager(new GridLayoutManager(context, this.columns, this.orientation, this.reverse));
        }
    }

    /* JADX INFO: compiled from: AnimatedRecyclerView.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\u0007J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/appnew/android/Utils/AnimatedRecyclerView$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", Constants.KEY_ORIENTATION, "", "reverse", "", "animationDuration", "layoutManagerType", "columns", "animation", "animationController", "Landroid/view/animation/LayoutAnimationController;", InAppPurchaseConstants.METHOD_BUILD, "Lcom/appnew/android/Utils/AnimatedRecyclerView;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private int animation;
        private LayoutAnimationController animationController;
        private int animationDuration;
        private int columns;
        private final Context context;
        private int layoutManagerType;
        private int orientation;
        private boolean reverse;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.orientation = 1;
            this.animationDuration = 600;
            this.columns = 1;
            this.animation = R.anim.layout_animation_from_bottom;
        }

        public final Builder orientation(int orientation) {
            this.orientation = orientation;
            return this;
        }

        public final Builder reverse(boolean reverse) {
            this.reverse = reverse;
            return this;
        }

        public final Builder animationDuration(int animationDuration) {
            this.animationDuration = animationDuration;
            return this;
        }

        public final Builder layoutManagerType(@LayoutManagerType int layoutManagerType) {
            this.layoutManagerType = layoutManagerType;
            return this;
        }

        public final Builder columns(int columns) {
            this.columns = columns;
            return this;
        }

        public final Builder animation(int animation) {
            this.animation = animation;
            return this;
        }

        public final Builder animationController(LayoutAnimationController animationController) {
            this.animationController = animationController;
            return this;
        }

        public final AnimatedRecyclerView build() {
            return new AnimatedRecyclerView(this.context, this.orientation, this.reverse, this.animationDuration, this.layoutManagerType, this.columns, this.animation, this.animationController);
        }
    }

    public final void notifyDataSetChanged() throws Exception {
        if (getAdapter() != null) {
            RecyclerView.Adapter adapter = getAdapter();
            Intrinsics.checkNotNull(adapter);
            adapter.notifyDataSetChanged();
            scheduleLayoutAnimation();
            return;
        }
        throw new Exception("The adapter must be set");
    }

    /* JADX INFO: compiled from: AnimatedRecyclerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/appnew/android/Utils/AnimatedRecyclerView$LayoutManagerType;", "", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LayoutManagerType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int GRID = 1;
        public static final int LINEAR = 0;

        /* JADX INFO: compiled from: AnimatedRecyclerView.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/appnew/android/Utils/AnimatedRecyclerView$LayoutManagerType$Companion;", "", "<init>", "()V", "LINEAR", "", "GRID", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int GRID = 1;
            public static final int LINEAR = 0;

            private Companion() {
            }
        }
    }
}
