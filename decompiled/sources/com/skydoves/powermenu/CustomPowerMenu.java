package com.skydoves.powermenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.skydoves.powermenu.MenuBaseAdapter;
import com.skydoves.powermenu.databinding.LayoutMaterialPowerMenuLibrarySkydovesBinding;
import com.skydoves.powermenu.databinding.LayoutPowerMenuLibrarySkydovesBinding;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class CustomPowerMenu<T, E extends MenuBaseAdapter<T>> extends AbstractPowerMenu<T, E> {
    private LayoutPowerMenuLibrarySkydovesBinding binding;
    private LayoutMaterialPowerMenuLibrarySkydovesBinding materialBinding;

    public static abstract class Factory<T, E extends MenuBaseAdapter<T>> {
        public abstract CustomPowerMenu<T, E> create(Context context, LifecycleOwner lifecycleOwner);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T extends com.skydoves.powermenu.MenuBaseAdapter<E>, com.skydoves.powermenu.MenuBaseAdapter] */
    protected CustomPowerMenu(Context context, AbstractMenuBuilder abstractMenuBuilder) {
        super(context, abstractMenuBuilder);
        Builder builder = (Builder) abstractMenuBuilder;
        if (builder.menuItemClickListener != null) {
            setOnMenuItemClickListener(builder.menuItemClickListener);
        }
        if (builder.selected != -1) {
            setSelectedPosition(builder.selected);
        }
        this.adapter = builder.adapter;
        this.adapter.setListView(getMenuListView());
        this.menuListView.setAdapter(this.adapter);
        addItemList(builder.Ts);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T extends com.skydoves.powermenu.MenuBaseAdapter<E>, com.skydoves.powermenu.MenuBaseAdapter] */
    @Override // com.skydoves.powermenu.AbstractPowerMenu
    protected void initialize(Context context, Boolean bool) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (bool.booleanValue()) {
            this.materialBinding = LayoutMaterialPowerMenuLibrarySkydovesBinding.inflate(layoutInflaterFrom, null, false);
        } else {
            this.binding = LayoutPowerMenuLibrarySkydovesBinding.inflate(layoutInflaterFrom, null, false);
        }
        this.adapter = new MenuBaseAdapter(this.menuListView);
        super.initialize(context, bool);
    }

    @Override // com.skydoves.powermenu.AbstractPowerMenu
    View getMenuRoot(Boolean bool) {
        if (bool.booleanValue()) {
            return this.materialBinding.getRoot();
        }
        return this.binding.getRoot();
    }

    @Override // com.skydoves.powermenu.AbstractPowerMenu
    ListView getMenuList(Boolean bool) {
        if (bool.booleanValue()) {
            return this.materialBinding.powerMenuListView;
        }
        return this.binding.powerMenuListView;
    }

    @Override // com.skydoves.powermenu.AbstractPowerMenu
    CardView getMenuCard(Boolean bool) {
        if (bool.booleanValue()) {
            return this.materialBinding.powerMenuCard;
        }
        return this.binding.powerMenuCard;
    }

    public static class Builder<T, E extends MenuBaseAdapter<T>> extends AbstractMenuBuilder {
        private final List<T> Ts;
        private final E adapter;
        private OnMenuItemClickListener<T> menuItemClickListener = null;

        public Builder(Context context, E e2) {
            this.context = context;
            this.Ts = new ArrayList();
            this.adapter = e2;
            this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public Builder<T, E> setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            return this;
        }

        public Builder<T, E> setShowBackground(boolean z) {
            this.showBackground = z;
            return this;
        }

        public Builder<T, E> setOnMenuItemClickListener(Object obj) {
            this.menuItemClickListener = (OnMenuItemClickListener) obj;
            return this;
        }

        public Builder<T, E> setOnBackgroundClickListener(View.OnClickListener onClickListener) {
            this.backgroundClickListener = onClickListener;
            return this;
        }

        public Builder<T, E> setOnDismissListener(OnDismissedListener onDismissedListener) {
            this.onDismissedListener = onDismissedListener;
            return this;
        }

        public Builder<T, E> setHeaderView(int i) {
            this.headerView = this.layoutInflater.inflate(i, (ViewGroup) null);
            return this;
        }

        public Builder<T, E> setHeaderView(View view) {
            this.headerView = view;
            return this;
        }

        public Builder<T, E> setFooterView(int i) {
            this.footerView = this.layoutInflater.inflate(i, (ViewGroup) null);
            return this;
        }

        public Builder<T, E> setFooterView(View view) {
            this.footerView = view;
            return this;
        }

        public Builder<T, E> setAnimation(MenuAnimation menuAnimation) {
            this.menuAnimation = menuAnimation;
            return this;
        }

        public Builder<T, E> setAnimationStyle(int i) {
            this.animationStyle = i;
            return this;
        }

        public Builder<T, E> setMenuRadius(float f2) {
            this.menuRadius = f2;
            return this;
        }

        public Builder<T, E> setMenuShadow(float f2) {
            this.menuShadow = f2;
            return this;
        }

        public Builder<T, E> setWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder<T, E> setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder<T, E> setPadding(int i) {
            this.padding = i;
            return this;
        }

        public Builder<T, E> setSize(int i, int i2) {
            this.width = i;
            this.height = i2;
            return this;
        }

        public Builder<T, E> setDividerHeight(int i) {
            this.dividerHeight = i;
            return this;
        }

        public Builder<T, E> setDivider(Drawable drawable) {
            this.divider = drawable;
            return this;
        }

        public Builder<T, E> setBackgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder<T, E> setBackgroundColorResource(int i) {
            this.backgroundColor = ContextCompat.getColor(this.context, i);
            return this;
        }

        public Builder<T, E> setBackgroundAlpha(float f2) {
            this.backgroundAlpha = f2;
            return this;
        }

        public Builder<T, E> setBackgroundSystemUiVisibility(int i) {
            this.backgroundSystemUiVisibility = i;
            return this;
        }

        public Builder<T, E> setFocusable(boolean z) {
            this.focusable = z;
            return this;
        }

        public Builder<T, E> setSelected(int i) {
            this.selected = i;
            return this;
        }

        public Builder<T, E> setIsClipping(boolean z) {
            this.isClipping = z;
            return this;
        }

        public Builder<T, E> setDismissIfShowAgain(boolean z) {
            this.dismissIfShowAgain = z;
            return this;
        }

        public Builder<T, E> setAutoDismiss(boolean z) {
            this.autoDismiss = z;
            return this;
        }

        public Builder<T, E> addItem(Object obj) {
            this.Ts.add(obj);
            return this;
        }

        public Builder<T, E> addItem(int i, Object obj) {
            this.Ts.add(i, obj);
            return this;
        }

        public Builder<T, E> addItemList(List<T> list) {
            this.Ts.addAll(list);
            return this;
        }

        public Builder<T, E> setPreferenceName(String str) {
            this.preferenceName = str;
            return this;
        }

        public Builder<T, E> setInitializeRule(Lifecycle.Event event, int i) {
            this.initializeRule = event;
            this.defaultPosition = i;
            return this;
        }

        public Builder<T, E> setCircularEffect(CircularEffect circularEffect) {
            this.circularEffect = circularEffect;
            return this;
        }

        public Builder<T, E> setIsMaterial(Boolean bool) {
            this.isMaterial = bool;
            return this;
        }

        public CustomPowerMenu<T, E> build() {
            return new CustomPowerMenu<>(this.context, this);
        }
    }
}
