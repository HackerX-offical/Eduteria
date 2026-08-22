package com.example.myapplication.messenger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.AndroidUtils;
import com.eduteria.app.app.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageSwipeController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0016J \u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0019H\u0016J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019H\u0016J@\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0015H\u0016J\u0018\u0010+\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0003J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020'H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/example/myapplication/messenger/MessageSwipeController;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "context", "Landroid/content/Context;", "swipeControllerActions", "Lcom/example/myapplication/messenger/SwipeControllerActions;", "<init>", "(Landroid/content/Context;Lcom/example/myapplication/messenger/SwipeControllerActions;)V", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "shareRound", "currentItemViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mView", "Landroid/view/View;", "dX", "", "replyButtonProgress", "lastReplyButtonAnimationTime", "", "swipeBack", "", "isVibrate", "startTracking", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "onMove", TypedValues.AttributesType.S_TARGET, "onSwiped", "", "direction", "convertToAbsoluteDirection", "flags", "layoutDirection", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dY", "actionState", "isCurrentlyActive", "setTouchListener", "drawReplyButton", "canvas", "convertTodp", "pixel", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageSwipeController extends ItemTouchHelper.Callback {
    public static final int $stable = 8;
    private final Context context;
    private RecyclerView.ViewHolder currentItemViewHolder;
    private float dX;
    private Drawable imageDrawable;
    private boolean isVibrate;
    private long lastReplyButtonAnimationTime;
    private View mView;
    private float replyButtonProgress;
    private Drawable shareRound;
    private boolean startTracking;
    private boolean swipeBack;
    private final SwipeControllerActions swipeControllerActions;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public MessageSwipeController(Context context, SwipeControllerActions swipeControllerActions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(swipeControllerActions, "swipeControllerActions");
        this.context = context;
        this.swipeControllerActions = swipeControllerActions;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.mView = viewHolder.itemView;
        Drawable drawable = this.context.getDrawable(R.drawable.ic_alert);
        Intrinsics.checkNotNull(drawable);
        this.imageDrawable = drawable;
        Drawable drawable2 = this.context.getDrawable(R.drawable.ic_address);
        Intrinsics.checkNotNull(drawable2);
        this.shareRound = drawable2;
        return ItemTouchHelper.Callback.makeMovementFlags(0, 8);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        if (this.swipeBack) {
            this.swipeBack = false;
            return 0;
        }
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c2, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Canvas canvas;
        MessageSwipeController messageSwipeController;
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (actionState == 1) {
            setTouchListener(recyclerView, viewHolder);
        }
        View view = this.mView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view = null;
        }
        if (view.getTranslationX() > convertTodp(-130) || dX < this.dX) {
            super.onChildDraw(c2, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            canvas = c2;
            messageSwipeController = this;
            messageSwipeController.dX = dX;
            messageSwipeController.startTracking = true;
        } else {
            canvas = c2;
            messageSwipeController = this;
        }
        messageSwipeController.currentItemViewHolder = viewHolder;
        drawReplyButton(canvas);
    }

    private final void setTouchListener(RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder) {
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.example.myapplication.messenger.MessageSwipeController$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return MessageSwipeController.setTouchListener$lambda$0(this.f$0, viewHolder, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setTouchListener$lambda$0(MessageSwipeController messageSwipeController, RecyclerView.ViewHolder viewHolder, View view, MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            z = false;
        }
        messageSwipeController.swipeBack = z;
        if (z) {
            View view2 = messageSwipeController.mView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view2 = null;
            }
            if (Math.abs(view2.getTranslationX()) >= messageSwipeController.convertTodp(100)) {
                messageSwipeController.swipeControllerActions.showReplyUI(viewHolder.getAdapterPosition());
            }
        }
        return false;
    }

    private final void drawReplyButton(Canvas canvas) {
        float f2;
        float fMin;
        int translationX;
        if (this.currentItemViewHolder == null) {
            return;
        }
        View view = this.mView;
        Drawable drawable = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view = null;
        }
        float translationX2 = view.getTranslationX();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMin = Math.min(17L, jCurrentTimeMillis - this.lastReplyButtonAnimationTime);
        this.lastReplyButtonAnimationTime = jCurrentTimeMillis;
        boolean z = translationX2 >= ((float) convertTodp(30));
        if (z) {
            float f3 = this.replyButtonProgress;
            if (f3 < 1.0f) {
                float f4 = f3 + (jMin / 180.0f);
                this.replyButtonProgress = f4;
                if (f4 > 1.0f) {
                    this.replyButtonProgress = 1.0f;
                } else {
                    View view2 = this.mView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mView");
                        view2 = null;
                    }
                    view2.invalidate();
                }
            }
        } else if (translationX2 <= 0.0f) {
            this.replyButtonProgress = 0.0f;
            this.startTracking = false;
            this.isVibrate = false;
        } else {
            float f5 = this.replyButtonProgress;
            if (f5 > 0.0f) {
                float f6 = f5 - (jMin / 180.0f);
                this.replyButtonProgress = f6;
                if (f6 < 0.1f) {
                    this.replyButtonProgress = 0.0f;
                } else {
                    View view3 = this.mView;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mView");
                        view3 = null;
                    }
                    view3.invalidate();
                }
            }
        }
        if (z) {
            float f7 = this.replyButtonProgress;
            f2 = f7 <= 0.8f ? (f7 / 0.8f) * 1.2f : 1.2f - (((f7 - 0.8f) / 0.2f) * 0.2f);
            fMin = Math.min(255.0f, 255 * (f7 / 0.8f));
        } else {
            f2 = this.replyButtonProgress;
            fMin = Math.min(255.0f, 255 * f2);
        }
        int i = (int) fMin;
        Drawable drawable2 = this.shareRound;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareRound");
            drawable2 = null;
        }
        drawable2.setAlpha(i);
        Drawable drawable3 = this.imageDrawable;
        if (drawable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageDrawable");
            drawable3 = null;
        }
        drawable3.setAlpha(i);
        if (this.startTracking && !this.isVibrate) {
            View view4 = this.mView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view4 = null;
            }
            if (view4.getTranslationX() >= convertTodp(100)) {
                View view5 = this.mView;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mView");
                    view5 = null;
                }
                view5.performHapticFeedback(3, 2);
                this.isVibrate = true;
            }
        }
        View view6 = this.mView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view6 = null;
        }
        if (view6.getTranslationX() > convertTodp(130)) {
            translationX = convertTodp(130) / 2;
        } else {
            View view7 = this.mView;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
                view7 = null;
            }
            translationX = (int) (view7.getTranslationX() / 2);
        }
        View view8 = this.mView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view8 = null;
        }
        int top = view8.getTop();
        View view9 = this.mView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mView");
            view9 = null;
        }
        float measuredHeight = top + (view9.getMeasuredHeight() / 2);
        Drawable drawable4 = this.shareRound;
        if (drawable4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareRound");
            drawable4 = null;
        }
        drawable4.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(this.context, R.color.green), PorterDuff.Mode.MULTIPLY));
        Drawable drawable5 = this.shareRound;
        if (drawable5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareRound");
            drawable5 = null;
        }
        float f8 = translationX;
        drawable5.setBounds((int) (f8 - (convertTodp(18) * f2)), (int) (measuredHeight - (convertTodp(18) * f2)), (int) ((convertTodp(18) * f2) + f8), (int) ((convertTodp(18) * f2) + measuredHeight));
        Drawable drawable6 = this.shareRound;
        if (drawable6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareRound");
            drawable6 = null;
        }
        drawable6.draw(canvas);
        Drawable drawable7 = this.imageDrawable;
        if (drawable7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageDrawable");
            drawable7 = null;
        }
        drawable7.setBounds((int) (f8 - (convertTodp(12) * f2)), (int) (measuredHeight - (convertTodp(11) * f2)), (int) (f8 + (convertTodp(12) * f2)), (int) (measuredHeight + (convertTodp(10) * f2)));
        Drawable drawable8 = this.imageDrawable;
        if (drawable8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageDrawable");
            drawable8 = null;
        }
        drawable8.draw(canvas);
        Drawable drawable9 = this.shareRound;
        if (drawable9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareRound");
            drawable9 = null;
        }
        drawable9.setAlpha(255);
        Drawable drawable10 = this.imageDrawable;
        if (drawable10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageDrawable");
        } else {
            drawable = drawable10;
        }
        drawable.setAlpha(255);
    }

    private final int convertTodp(int pixel) {
        return AndroidUtils.INSTANCE.dp(pixel, this.context);
    }
}
