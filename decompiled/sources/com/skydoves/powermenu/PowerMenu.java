package com.skydoves.powermenu;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.skydoves.powermenu.databinding.LayoutMaterialPowerMenuLibrarySkydovesBinding;
import com.skydoves.powermenu.databinding.LayoutPowerMenuLibrarySkydovesBinding;
import com.skydoves.powermenu.kotlin.PowerMenuDsl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class PowerMenu extends AbstractPowerMenu<PowerMenuItem, MenuListAdapter> implements IPowerMenuAdapter {
    private LayoutPowerMenuLibrarySkydovesBinding binding;
    private LayoutMaterialPowerMenuLibrarySkydovesBinding materialBinding;

    public static abstract class Factory {
        public abstract PowerMenu create(Context context, LifecycleOwner lifecycleOwner);
    }

    protected PowerMenu(Context context, AbstractMenuBuilder abstractMenuBuilder) {
        super(context, abstractMenuBuilder);
        Builder builder = (Builder) abstractMenuBuilder;
        setSelectedEffect(builder.selectedEffect);
        if (builder.menuItemClickListener != null) {
            setOnMenuItemClickListener(builder.menuItemClickListener);
        }
        if (builder.textColor != -2) {
            setTextColor(builder.textColor);
        }
        if (builder.menuColor != -2) {
            setMenuColor(builder.menuColor);
        }
        if (builder.selectedTextColor != -2) {
            setSelectedTextColor(builder.selectedTextColor);
        }
        if (builder.selectedMenuColor != -2) {
            setSelectedMenuColor(builder.selectedMenuColor);
        }
        if (builder.selected != -1) {
            setSelectedPosition(builder.selected);
        }
        if (builder.textSize != 12) {
            setTextSize(builder.textSize);
        }
        if (builder.textGravity != 8388611) {
            setTextGravity(builder.textGravity);
        }
        if (builder.textTypeface != null) {
            setTextTypeface(builder.textTypeface);
        }
        if (builder.iconSize != 35) {
            setIconSize(builder.iconSize);
        }
        if (builder.iconPadding != 7) {
            setIconPadding(builder.iconPadding);
        }
        if (builder.iconColor != -2) {
            setIconColor(builder.iconColor);
        }
        this.menuListView.setAdapter(this.adapter);
        addItemList(builder.powerMenuItems);
    }

    @Override // com.skydoves.powermenu.AbstractPowerMenu
    protected void initialize(Context context, Boolean bool) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (bool.booleanValue()) {
            this.materialBinding = LayoutMaterialPowerMenuLibrarySkydovesBinding.inflate(layoutInflaterFrom, null, false);
        } else {
            this.binding = LayoutPowerMenuLibrarySkydovesBinding.inflate(layoutInflaterFrom, null, false);
        }
        super.initialize(context, bool);
        this.adapter = new MenuListAdapter(this.menuListView);
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

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setTextColor(int i) {
        getAdapter().setTextColor(i);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setMenuColor(int i) {
        getAdapter().setMenuColor(i);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setSelectedTextColor(int i) {
        getAdapter().setSelectedTextColor(i);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setSelectedMenuColor(int i) {
        getAdapter().setSelectedMenuColor(i);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setSelectedEffect(boolean z) {
        getAdapter().setSelectedEffect(z);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setIconSize(int i) {
        getAdapter().setIconSize(i);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setIconColor(int i) {
        getAdapter().setIconColor(i);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setIconPadding(int i) {
        getAdapter().setIconPadding(i);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setTextSize(int i) {
        getAdapter().setTextSize(i);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setTextGravity(int i) {
        getAdapter().setTextGravity(i);
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setTextTypeface(Typeface typeface) {
        getAdapter().setTextTypeface(typeface);
    }

    @PowerMenuDsl
    public static class Builder extends AbstractMenuBuilder {
        private final List<PowerMenuItem> powerMenuItems;
        private OnMenuItemClickListener<PowerMenuItem> menuItemClickListener = null;
        private int textColor = -2;
        private int menuColor = -2;
        private boolean selectedEffect = true;
        private int selectedTextColor = -2;
        private int selectedMenuColor = -2;
        private int textSize = 12;
        private int textGravity = GravityCompat.START;
        private Typeface textTypeface = null;

        public Builder(Context context) {
            this.context = context;
            this.powerMenuItems = new ArrayList();
            this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public Builder setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            return this;
        }

        public Builder setShowBackground(boolean z) {
            this.showBackground = z;
            return this;
        }

        public Builder setOnMenuItemClickListener(OnMenuItemClickListener<PowerMenuItem> onMenuItemClickListener) {
            this.menuItemClickListener = onMenuItemClickListener;
            return this;
        }

        public Builder setOnBackgroundClickListener(View.OnClickListener onClickListener) {
            this.backgroundClickListener = onClickListener;
            return this;
        }

        public Builder setOnDismissListener(OnDismissedListener onDismissedListener) {
            this.onDismissedListener = onDismissedListener;
            return this;
        }

        public Builder setHeaderView(int i) {
            this.headerView = this.layoutInflater.inflate(i, (ViewGroup) null);
            return this;
        }

        public Builder setHeaderView(View view) {
            this.headerView = view;
            return this;
        }

        public Builder setFooterView(int i) {
            this.footerView = this.layoutInflater.inflate(i, (ViewGroup) null);
            return this;
        }

        public Builder setFooterView(View view) {
            this.footerView = view;
            return this;
        }

        public Builder setAnimation(MenuAnimation menuAnimation) {
            this.menuAnimation = menuAnimation;
            return this;
        }

        public Builder setAnimationStyle(int i) {
            this.animationStyle = i;
            return this;
        }

        public Builder setMenuRadius(float f2) {
            this.menuRadius = f2;
            return this;
        }

        public Builder setMenuShadow(float f2) {
            this.menuShadow = f2;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setSize(int i, int i2) {
            this.width = i;
            this.height = i2;
            return this;
        }

        public Builder setPadding(int i) {
            this.padding = i;
            return this;
        }

        public Builder setTextColor(int i) {
            this.textColor = i;
            return this;
        }

        public Builder setTextColorResource(int i) {
            this.textColor = ContextCompat.getColor(this.context, i);
            return this;
        }

        public Builder setTextSize(int i) {
            this.textSize = i;
            return this;
        }

        public Builder setTextGravity(int i) {
            this.textGravity = i;
            return this;
        }

        public Builder setTextTypeface(Typeface typeface) {
            this.textTypeface = typeface;
            return this;
        }

        public Builder setIconColor(int i) {
            this.iconColor = i;
            return this;
        }

        public Builder setIconSize(int i) {
            this.iconSize = i;
            return this;
        }

        public Builder setIconPadding(int i) {
            this.iconPadding = i;
            return this;
        }

        public Builder setMenuColor(int i) {
            this.menuColor = i;
            return this;
        }

        public Builder setMenuColorResource(int i) {
            this.menuColor = ContextCompat.getColor(this.context, i);
            return this;
        }

        public Builder setSelectedTextColor(int i) {
            this.selectedTextColor = i;
            return this;
        }

        public Builder setSelectedTextColorResource(int i) {
            this.selectedTextColor = ContextCompat.getColor(this.context, i);
            return this;
        }

        public Builder setSelectedMenuColor(int i) {
            this.selectedMenuColor = i;
            return this;
        }

        public Builder setSelectedMenuColorResource(int i) {
            this.selectedMenuColor = ContextCompat.getColor(this.context, i);
            return this;
        }

        public Builder setSelectedEffect(boolean z) {
            this.selectedEffect = z;
            return this;
        }

        public Builder setDividerHeight(int i) {
            this.dividerHeight = i;
            return this;
        }

        public Builder setDivider(Drawable drawable) {
            this.divider = drawable;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder setBackgroundColorResource(int i) {
            this.backgroundColor = ContextCompat.getColor(this.context, i);
            return this;
        }

        public Builder setBackgroundAlpha(float f2) {
            this.backgroundAlpha = f2;
            return this;
        }

        public Builder setBackgroundSystemUiVisibility(int i) {
            this.backgroundSystemUiVisibility = i;
            return this;
        }

        public Builder setFocusable(boolean z) {
            this.focusable = z;
            return this;
        }

        public Builder setSelected(int i) {
            this.selected = i;
            return this;
        }

        public Builder setIsClipping(boolean z) {
            this.isClipping = z;
            return this;
        }

        public Builder setAutoDismiss(boolean z) {
            this.autoDismiss = z;
            return this;
        }

        public Builder setDismissIfShowAgain(boolean z) {
            this.dismissIfShowAgain = z;
            return this;
        }

        public Builder addItem(PowerMenuItem powerMenuItem) {
            this.powerMenuItems.add(powerMenuItem);
            return this;
        }

        public Builder addItem(int i, PowerMenuItem powerMenuItem) {
            this.powerMenuItems.add(i, powerMenuItem);
            return this;
        }

        public Builder addItemList(List<PowerMenuItem> list) {
            this.powerMenuItems.addAll(list);
            return this;
        }

        public Builder setPreferenceName(String str) {
            this.preferenceName = str;
            return this;
        }

        public Builder setInitializeRule(Lifecycle.Event event, int i) {
            this.initializeRule = event;
            this.defaultPosition = i;
            return this;
        }

        public Builder setCircularEffect(CircularEffect circularEffect) {
            this.circularEffect = circularEffect;
            return this;
        }

        public Builder setIsMaterial(Boolean bool) {
            this.isMaterial = bool;
            return this;
        }

        public PowerMenu build() {
            return new PowerMenu(this.context, this);
        }
    }
}
