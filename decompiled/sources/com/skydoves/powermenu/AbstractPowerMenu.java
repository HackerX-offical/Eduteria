package com.skydoves.powermenu;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.skydoves.powermenu.MenuBaseAdapter;
import com.skydoves.powermenu.databinding.LayoutPowerBackgroundLibrarySkydovesBinding;
import com.skydoves.powermenu.kotlin.ContextExtensionsKt;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractPowerMenu<E, T extends MenuBaseAdapter<E>> implements IMenuItem<E>, LifecycleObserver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected T adapter;
    private boolean autoDismiss;
    protected View backgroundView;
    protected PopupWindow backgroundWindow;
    private CircularEffect circularEffect;
    protected int contentViewPadding;
    private int defaultPosition;
    private boolean dismissIfShowAgain;
    protected View footerView;
    protected View headerView;
    protected Lifecycle.Event initializeRule;
    protected LayoutInflater layoutInflater;
    protected LifecycleOwner lifecycleOwner;
    protected CardView menuCard;
    protected OnMenuItemClickListener<E> menuItemClickListener;
    protected ListView menuListView;
    protected View menuView;
    protected PopupWindow menuWindow;
    protected OnDismissedListener onDismissedListener;
    protected boolean showBackground = true;
    protected boolean allowTouchBackground = false;
    protected boolean fixedHeight = false;
    protected boolean isShowing = false;
    private final AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() { // from class: com.skydoves.powermenu.AbstractPowerMenu.1
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (AbstractPowerMenu.this.autoDismiss) {
                AbstractPowerMenu.this.dismiss();
            }
            AbstractPowerMenu.this.menuItemClickListener.onItemClick(i, AbstractPowerMenu.this.menuListView.getItemAtPosition(i));
        }
    };
    private final OnMenuItemClickListener<E> onMenuItemClickListener = new OnMenuItemClickListener() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda13
        @Override // com.skydoves.powermenu.OnMenuItemClickListener
        public final void onItemClick(int i, Object obj) {
            AbstractPowerMenu.lambda$new$0(i, obj);
        }
    };
    private final View.OnClickListener background_clickListener = new View.OnClickListener() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda14
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f$0.m12342lambda$new$1$comskydovespowermenuAbstractPowerMenu(view);
        }
    };
    private final View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda15
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f$0.m12343lambda$new$2$comskydovespowermenuAbstractPowerMenu(view, motionEvent);
        }
    };
    private final View.OnClickListener headerFooterClickListener = new View.OnClickListener() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda16
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AbstractPowerMenu.lambda$new$3(view);
        }
    };

    static /* synthetic */ void lambda$new$0(int i, Object obj) {
    }

    static /* synthetic */ void lambda$new$3(View view) {
    }

    abstract CardView getMenuCard(Boolean bool);

    abstract ListView getMenuList(Boolean bool);

    abstract View getMenuRoot(Boolean bool);

    /* JADX INFO: renamed from: lambda$new$1$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12342lambda$new$1$comskydovespowermenuAbstractPowerMenu(View view) {
        if (this.allowTouchBackground) {
            return;
        }
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$new$2$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ boolean m12343lambda$new$2$comskydovespowermenuAbstractPowerMenu(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4 || this.showBackground) {
            return false;
        }
        dismiss();
        return true;
    }

    protected AbstractPowerMenu(Context context, AbstractMenuBuilder abstractMenuBuilder) {
        initialize(context, abstractMenuBuilder.isMaterial);
        setShowBackground(abstractMenuBuilder.showBackground);
        setAnimation(abstractMenuBuilder.menuAnimation);
        setMenuRadius(abstractMenuBuilder.menuRadius);
        setMenuShadow(abstractMenuBuilder.menuShadow);
        setBackgroundColor(abstractMenuBuilder.backgroundColor);
        setBackgroundAlpha(abstractMenuBuilder.backgroundAlpha);
        setBackgroundSystemUiVisibility(abstractMenuBuilder.backgroundSystemUiVisibility);
        setFocusable(abstractMenuBuilder.focusable);
        setIsClipping(abstractMenuBuilder.isClipping);
        setAutoDismiss(abstractMenuBuilder.autoDismiss);
        setDefaultPosition(abstractMenuBuilder.defaultPosition);
        setDismissIfShowAgain(abstractMenuBuilder.dismissIfShowAgain);
        if (abstractMenuBuilder.lifecycleOwner != null) {
            setLifecycleOwner(abstractMenuBuilder.lifecycleOwner);
        }
        if (abstractMenuBuilder.backgroundClickListener != null) {
            setOnBackgroundClickListener(abstractMenuBuilder.backgroundClickListener);
        }
        if (abstractMenuBuilder.onDismissedListener != null) {
            setOnDismissedListener(abstractMenuBuilder.onDismissedListener);
        }
        if (abstractMenuBuilder.headerView != null) {
            setHeaderView(abstractMenuBuilder.headerView);
        }
        if (abstractMenuBuilder.footerView != null) {
            setFooterView(abstractMenuBuilder.footerView);
        }
        if (abstractMenuBuilder.animationStyle != -1) {
            setAnimationStyle(abstractMenuBuilder.animationStyle);
        }
        if (abstractMenuBuilder.width != 0) {
            setWidth(abstractMenuBuilder.width);
        }
        if (abstractMenuBuilder.height != 0) {
            setHeight(abstractMenuBuilder.height);
        }
        if (abstractMenuBuilder.padding != 0) {
            setPadding(abstractMenuBuilder.padding);
        }
        if (abstractMenuBuilder.divider != null) {
            setDivider(abstractMenuBuilder.divider);
        }
        if (abstractMenuBuilder.dividerHeight != 0) {
            setDividerHeight(abstractMenuBuilder.dividerHeight);
        }
        if (abstractMenuBuilder.preferenceName != null) {
            setPreferenceName(abstractMenuBuilder.preferenceName);
        }
        if (abstractMenuBuilder.initializeRule != null) {
            setInitializeRule(abstractMenuBuilder.initializeRule);
        }
        if (abstractMenuBuilder.circularEffect != null) {
            setCircularEffect(abstractMenuBuilder.circularEffect);
        }
    }

    protected void initialize(Context context, Boolean bool) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.layoutInflater = layoutInflaterFrom;
        RelativeLayout root = LayoutPowerBackgroundLibrarySkydovesBinding.inflate(layoutInflaterFrom, null, false).getRoot();
        this.backgroundView = root;
        root.setOnClickListener(this.background_clickListener);
        this.backgroundView.setAlpha(0.5f);
        PopupWindow popupWindow = new PopupWindow(this.backgroundView, -1, -1);
        this.backgroundWindow = popupWindow;
        popupWindow.setClippingEnabled(false);
        this.menuView = getMenuRoot(bool);
        this.menuListView = getMenuList(bool);
        this.menuCard = getMenuCard(bool);
        this.menuWindow = new PopupWindow(this.menuView, -2, -2);
        setFocusable(false);
        setTouchInterceptor(this.onTouchListener);
        setOnMenuItemClickListener(this.onMenuItemClickListener);
        this.contentViewPadding = ConvertUtil.convertDpToPixel(10.0f, context);
        MenuPreferenceManager.initialize(context);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(this);
        this.lifecycleOwner = lifecycleOwner;
    }

    public void setFocusable(boolean z) {
        this.menuWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.menuWindow.setOutsideTouchable(!z);
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.menuWindow.setTouchInterceptor(onTouchListener);
    }

    public OnMenuItemClickListener<E> getOnMenuItemClickListener() {
        return this.menuItemClickListener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener<E> onMenuItemClickListener) {
        this.menuItemClickListener = onMenuItemClickListener;
        this.menuListView.setOnItemClickListener(this.itemClickListener);
    }

    private void showPopup(final View view, final Runnable runnable) {
        if (!isShowing() && ViewCompat.isAttachedToWindow(view) && !ContextExtensionsKt.isFinishing(view.getContext())) {
            this.isShowing = true;
            view.post(new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m12360lambda$showPopup$4$comskydovespowermenuAbstractPowerMenu(view, runnable);
                }
            });
        } else if (this.dismissIfShowAgain) {
            dismiss();
        }
    }

    /* JADX INFO: renamed from: lambda$showPopup$4$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12360lambda$showPopup$4$comskydovespowermenuAbstractPowerMenu(View view, Runnable runnable) {
        if (this.showBackground) {
            this.backgroundWindow.showAtLocation(view, 17, 0, 0);
        }
        doMenuEffect();
        runnable.run();
    }

    /* JADX INFO: renamed from: lambda$showAsDropDown$5$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12354lambda$showAsDropDown$5$comskydovespowermenuAbstractPowerMenu(View view) {
        this.menuWindow.showAsDropDown(view);
    }

    public void showAsDropDown(final View view) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12354lambda$showAsDropDown$5$comskydovespowermenuAbstractPowerMenu(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsDropDown$6$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12355lambda$showAsDropDown$6$comskydovespowermenuAbstractPowerMenu(View view, int i, int i2) {
        this.menuWindow.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(final View view, final int i, final int i2) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12355lambda$showAsDropDown$6$comskydovespowermenuAbstractPowerMenu(view, i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorLeftTop$7$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12348xd65ceb14(View view) {
        this.menuWindow.showAsDropDown(view, 0, -view.getMeasuredHeight());
    }

    public void showAsAnchorLeftTop(final View view) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12348xd65ceb14(view);
            }
        });
    }

    public void showAsAnchorLeftTop(final View view, final int i, final int i2) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12349xddc22033(view, i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorLeftTop$8$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12349xddc22033(View view, int i, int i2) {
        this.menuWindow.showAsDropDown(view, i, i2 - view.getMeasuredHeight());
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorLeftBottom$9$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12347xa338b6c(View view) {
        this.menuWindow.showAsDropDown(view, 0, -getContentViewPadding());
    }

    public void showAsAnchorLeftBottom(final View view) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12347xa338b6c(view);
            }
        });
    }

    public void showAsAnchorLeftBottom(final View view, final int i, final int i2) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12346x8350be84(view, i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorLeftBottom$10$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12346x8350be84(View view, int i, int i2) {
        this.menuWindow.showAsDropDown(view, i, i2 - getContentViewPadding());
    }

    public void showAsAnchorRightTop(final View view) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12352x67de7dea(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorRightTop$11$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12352x67de7dea(View view) {
        this.menuWindow.showAsDropDown(view, (view.getMeasuredWidth() / 2) + (getContentViewWidth() / 2), -view.getMeasuredHeight());
    }

    public void showAsAnchorRightTop(final View view, final int i, final int i2) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12353x6f43b309(view, i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorRightTop$12$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12353x6f43b309(View view, int i, int i2) {
        this.menuWindow.showAsDropDown(view, i + (view.getMeasuredWidth() / 2) + (getContentViewWidth() / 2), i2 - view.getMeasuredHeight());
    }

    public void showAsAnchorRightBottom(final View view) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12350xc3a37354(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorRightBottom$13$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12350xc3a37354(View view) {
        this.menuWindow.showAsDropDown(view, (view.getMeasuredWidth() / 2) + (getContentViewWidth() / 2), -getContentViewPadding());
    }

    public void showAsAnchorRightBottom(final View view, final int i, final int i2) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12351xcb08a873(view, i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorRightBottom$14$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12351xcb08a873(View view, int i, int i2) {
        this.menuWindow.showAsDropDown(view, i + (view.getMeasuredWidth() / 2) + (getContentViewWidth() / 2), i2 - getContentViewPadding());
    }

    public void showAsAnchorCenter(final View view) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12344xfde6bf62(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorCenter$15$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12344xfde6bf62(View view) {
        this.menuWindow.showAsDropDown(view, (view.getMeasuredWidth() / 2) - (getContentViewWidth() / 2), ((-view.getMeasuredHeight()) / 2) - (getContentViewHeight() / 2));
    }

    public void showAsAnchorCenter(final View view, final int i, final int i2) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12345x54bf481(view, i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAsAnchorCenter$16$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12345x54bf481(View view, int i, int i2) {
        this.menuWindow.showAsDropDown(view, (i + (view.getMeasuredWidth() / 2)) - (getContentViewWidth() / 2), (i2 - (view.getMeasuredHeight() / 2)) - (getContentViewHeight() / 2));
    }

    /* JADX INFO: renamed from: lambda$showAtCenter$17$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12356lambda$showAtCenter$17$comskydovespowermenuAbstractPowerMenu(View view) {
        this.menuWindow.showAtLocation(view, 17, 0, 0);
    }

    public void showAtCenter(final View view) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12356lambda$showAtCenter$17$comskydovespowermenuAbstractPowerMenu(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAtCenter$18$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12357lambda$showAtCenter$18$comskydovespowermenuAbstractPowerMenu(View view, int i, int i2) {
        this.menuWindow.showAtLocation(view, 17, i, i2);
    }

    public void showAtCenter(final View view, final int i, final int i2) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12357lambda$showAtCenter$18$comskydovespowermenuAbstractPowerMenu(view, i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAtLocation$19$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12358x36d6b72a(View view, int i, int i2) {
        this.menuWindow.showAtLocation(view, 0, i, i2);
    }

    public void showAtLocation(final View view, final int i, final int i2) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12358x36d6b72a(view, i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showAtLocation$20$com-skydoves-powermenu-AbstractPowerMenu, reason: not valid java name */
    /* synthetic */ void m12359xd98947d4(View view, int i, int i2, int i3) {
        this.menuWindow.showAtLocation(view, i, i2, i3);
    }

    public void showAtLocation(final View view, final int i, final int i2, final int i3) {
        showPopup(view, new Runnable() { // from class: com.skydoves.powermenu.AbstractPowerMenu$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12359xd98947d4(view, i, i2, i3);
            }
        });
    }

    private void doMenuEffect() {
        if (getCircularEffect() != null) {
            if (getCircularEffect().equals(CircularEffect.BODY)) {
                circularRevealed(this.menuWindow.getContentView());
            } else if (getCircularEffect().equals(CircularEffect.INNER)) {
                circularRevealed(getListView());
            }
        }
    }

    private void circularRevealed(View view) {
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.skydoves.powermenu.AbstractPowerMenu.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                view2.removeOnLayoutChangeListener(this);
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view2, (view2.getLeft() + view2.getRight()) / 2, (view2.getTop() + view2.getBottom()) / 2, 0.0f, Math.max(view2.getWidth(), view2.getHeight()));
                animatorCreateCircularReveal.setDuration(900L);
                animatorCreateCircularReveal.start();
            }
        });
    }

    public void dismiss() {
        if (isShowing()) {
            this.menuWindow.dismiss();
            this.backgroundWindow.dismiss();
            this.isShowing = false;
            OnDismissedListener onDismissedListener = this.onDismissedListener;
            if (onDismissedListener != null) {
                onDismissedListener.onDismissed();
            }
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public int getContentViewWidth() {
        int width = this.menuWindow.getContentView().getWidth();
        return width == 0 ? getMeasuredContentView().getMeasuredWidth() : width;
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public int getContentViewHeight() {
        int height = this.menuWindow.getContentView().getHeight();
        if (height != 0) {
            return height;
        }
        int contentViewHeight = height + getAdapter().getContentViewHeight() + getContentViewPadding();
        if (getHeaderView() != null) {
            contentViewHeight += getHeaderView().getMeasuredHeight();
        }
        return getFooterView() != null ? contentViewHeight + getFooterView().getMeasuredHeight() : contentViewHeight;
    }

    protected View getMeasuredContentView() {
        View contentView = this.menuWindow.getContentView();
        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return contentView;
    }

    protected int getContentViewPadding() {
        return this.contentViewPadding;
    }

    public void setWidth(int i) {
        this.menuWindow.setWidth(i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.menuListView.getLayoutParams();
        layoutParams.width = i - this.contentViewPadding;
        getMenuListView().setLayoutParams(layoutParams);
    }

    public void setHeight(int i) {
        this.fixedHeight = true;
        this.menuWindow.setHeight(i);
    }

    public void setPadding(int i) {
        this.menuListView.setPadding(i, i, i, i);
    }

    protected void setMeasuredHeight(int i) {
        this.menuWindow.setHeight(i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.menuListView.getLayoutParams();
        layoutParams.height = i - this.contentViewPadding;
        getMenuListView().setLayoutParams(layoutParams);
    }

    public void setDividerHeight(int i) {
        this.menuListView.setDividerHeight(i);
    }

    public void setDivider(Drawable drawable) {
        this.menuListView.setDivider(drawable);
    }

    public void setShowBackground(boolean z) {
        this.showBackground = z;
    }

    public void setOnDismissedListener(OnDismissedListener onDismissedListener) {
        this.onDismissedListener = onDismissedListener;
    }

    public void setOnBackgroundClickListener(View.OnClickListener onClickListener) {
        this.backgroundView.setOnClickListener(onClickListener);
    }

    public void setAnimation(MenuAnimation menuAnimation) {
        if (menuAnimation == MenuAnimation.NONE) {
            this.menuWindow.setAnimationStyle(0);
            return;
        }
        if (menuAnimation == MenuAnimation.DROP_DOWN) {
            this.menuWindow.setAnimationStyle(-1);
            return;
        }
        if (menuAnimation == MenuAnimation.FADE) {
            this.menuWindow.setAnimationStyle(R.style.FadeMenuAnimation);
            this.backgroundWindow.setAnimationStyle(R.style.FadeMenuAnimation);
            return;
        }
        if (menuAnimation == MenuAnimation.SHOWUP_BOTTOM_LEFT) {
            this.menuWindow.setAnimationStyle(R.style.ShowUpAnimation_BL);
            return;
        }
        if (menuAnimation == MenuAnimation.SHOWUP_BOTTOM_RIGHT) {
            this.menuWindow.setAnimationStyle(R.style.ShowUpAnimation_BR);
            return;
        }
        if (menuAnimation == MenuAnimation.SHOWUP_TOP_LEFT) {
            this.menuWindow.setAnimationStyle(R.style.ShowUpAnimation_TL);
            return;
        }
        if (menuAnimation == MenuAnimation.SHOWUP_TOP_RIGHT) {
            this.menuWindow.setAnimationStyle(R.style.ShowUpAnimation_TR);
            return;
        }
        if (menuAnimation == MenuAnimation.SHOW_UP_CENTER) {
            this.menuWindow.setAnimationStyle(R.style.ShowUpAnimation_Center);
            return;
        }
        if (menuAnimation == MenuAnimation.ELASTIC_BOTTOM_LEFT) {
            this.menuWindow.setAnimationStyle(R.style.ElasticMenuAnimation_BL);
            return;
        }
        if (menuAnimation == MenuAnimation.ELASTIC_BOTTOM_RIGHT) {
            this.menuWindow.setAnimationStyle(R.style.ElasticMenuAnimation_BR);
            return;
        }
        if (menuAnimation == MenuAnimation.ELASTIC_TOP_LEFT) {
            this.menuWindow.setAnimationStyle(R.style.ElasticMenuAnimation_TL);
        } else if (menuAnimation == MenuAnimation.ELASTIC_TOP_RIGHT) {
            this.menuWindow.setAnimationStyle(R.style.ElasticMenuAnimation_TR);
        } else if (menuAnimation == MenuAnimation.ELASTIC_CENTER) {
            this.menuWindow.setAnimationStyle(R.style.ElasticMenuAnimation_Center);
        }
    }

    public void setAnimationStyle(int i) {
        this.menuWindow.setAnimationStyle(i);
    }

    public void setMenuRadius(float f2) {
        this.menuCard.setRadius(f2);
    }

    public void setMenuShadow(float f2) {
        this.menuCard.setCardElevation(f2);
    }

    public void setIsClipping(boolean z) {
        this.menuWindow.setClippingEnabled(z);
    }

    public void setSelection(int i) {
        this.menuListView.setSelection(i);
    }

    public void setBackgroundColor(int i) {
        this.backgroundView.setBackgroundColor(i);
    }

    public void setBackgroundAlpha(float f2) {
        this.backgroundView.setAlpha(f2);
    }

    public void setBackgroundSystemUiVisibility(int i) {
        this.backgroundView.setSystemUiVisibility(i);
    }

    public void setHeaderView(View view) {
        if (this.headerView == null) {
            this.menuListView.addHeaderView(view);
            this.headerView = view;
            view.setOnClickListener(this.headerFooterClickListener);
            this.headerView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    public void setHeaderView(View view, Object obj, boolean z) {
        if (this.headerView == null) {
            this.menuListView.addHeaderView(view, obj, z);
            this.headerView = view;
            view.setOnClickListener(this.headerFooterClickListener);
            this.headerView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    public void setHeaderView(int i) {
        if (this.headerView == null) {
            setHeaderView(this.layoutInflater.inflate(i, (ViewGroup) null, false));
        }
    }

    public void setFooterView(View view) {
        if (this.footerView == null) {
            this.menuListView.addFooterView(view);
            this.footerView = view;
            view.setOnClickListener(this.headerFooterClickListener);
            this.footerView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    public void setFooterView(View view, Object obj, boolean z) {
        if (this.footerView == null) {
            this.menuListView.addFooterView(view, obj, z);
            this.footerView = view;
            view.setOnClickListener(this.headerFooterClickListener);
            this.footerView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    public void setFooterView(int i) {
        if (this.footerView == null) {
            setFooterView(this.layoutInflater.inflate(i, (ViewGroup) null, false));
        }
    }

    private boolean checkRuleValidates(Lifecycle.Event event) {
        return getInitializeRule() != null && getInitializeRule().equals(event);
    }

    public void invokeOnMenuListener(int i) {
        if (i < 0 || i >= getItemList().size() || getOnMenuItemClickListener() == null) {
            return;
        }
        getOnMenuItemClickListener().onItemClick(getPreferencePosition(i), getItemList().get(getPreferencePosition(i)));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        if (checkRuleValidates(Lifecycle.Event.ON_CREATE)) {
            invokeOnMenuListener(this.defaultPosition);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        if (checkRuleValidates(Lifecycle.Event.ON_START)) {
            invokeOnMenuListener(this.defaultPosition);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        if (checkRuleValidates(Lifecycle.Event.ON_RESUME)) {
            invokeOnMenuListener(this.defaultPosition);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        dismiss();
    }

    public T getAdapter() {
        return this.adapter;
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void addItem(E e2) {
        getAdapter().addItem(e2);
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void addItem(int i, E e2) {
        getAdapter().addItem(i, e2);
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void addItemList(List<E> list) {
        getAdapter().addItemList(list);
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public ListView getListView() {
        return getAdapter().getListView();
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void setListView(ListView listView) {
        getAdapter().setListView(getMenuListView());
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public int getSelectedPosition() {
        return getAdapter().getSelectedPosition();
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void setSelectedPosition(int i) {
        getAdapter().setSelectedPosition(i);
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void removeItem(E e2) {
        getAdapter().removeItem(e2);
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void removeItem(int i) {
        getAdapter().removeItem(i);
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public void clearItems() {
        getAdapter().clearItems();
    }

    @Override // com.skydoves.powermenu.IMenuItem
    public List<E> getItemList() {
        return getAdapter().getItemList();
    }

    public ListView getMenuListView() {
        return this.menuListView;
    }

    public View getHeaderView() {
        return this.headerView;
    }

    public View getFooterView() {
        return this.footerView;
    }

    public void setAutoDismiss(boolean z) {
        this.autoDismiss = z;
    }

    public void setDismissIfShowAgain(boolean z) {
        this.dismissIfShowAgain = z;
    }

    public String getPreferenceName() {
        return getAdapter().getPreferenceName();
    }

    public int getPreferencePosition(int i) {
        return MenuPreferenceManager.getInstance().getPosition(getAdapter().getPreferenceName(), i);
    }

    public void setPreferencePosition(int i) {
        MenuPreferenceManager menuPreferenceManager = MenuPreferenceManager.getInstance();
        if (menuPreferenceManager == null || getPreferenceName() == null) {
            return;
        }
        menuPreferenceManager.setPosition(getPreferenceName(), i);
    }

    private void setPreferenceName(String str) {
        getAdapter().setPreference(str);
    }

    public void clearPreference() {
        if (getAdapter().getPreferenceName() != null) {
            MenuPreferenceManager.getInstance().clearPosition(getAdapter().getPreferenceName());
        }
    }

    private void setInitializeRule(Lifecycle.Event event) {
        this.initializeRule = event;
    }

    private Lifecycle.Event getInitializeRule() {
        return this.initializeRule;
    }

    private void setDefaultPosition(int i) {
        this.defaultPosition = i;
    }

    public CircularEffect getCircularEffect() {
        return this.circularEffect;
    }

    public void setCircularEffect(CircularEffect circularEffect) {
        this.circularEffect = circularEffect;
    }
}
