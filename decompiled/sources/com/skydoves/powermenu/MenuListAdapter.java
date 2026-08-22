package com.skydoves.powermenu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.ImageViewCompat;
import com.skydoves.powermenu.databinding.ItemPowerMenuLibrarySkydovesBinding;

/* JADX INFO: loaded from: classes9.dex */
public class MenuListAdapter extends MenuBaseAdapter<PowerMenuItem> implements IPowerMenuAdapter {
    private int iconColor;
    private int iconPadding;
    private int iconSize;
    private int menuColor;
    private boolean selectedEffect;
    private int selectedMenuColor;
    private int selectedTextColor;
    private int textColor;
    private int textGravity;
    private int textSize;
    private Typeface textTypeface;

    public MenuListAdapter(ListView listView) {
        super(listView);
        this.textColor = -2;
        this.menuColor = -2;
        this.selectedTextColor = -2;
        this.selectedMenuColor = -2;
        this.iconColor = -2;
        this.textSize = 12;
        this.iconSize = 35;
        this.iconPadding = 7;
        this.textGravity = GravityCompat.START;
        this.textTypeface = null;
        this.selectedEffect = true;
    }

    @Override // com.skydoves.powermenu.MenuBaseAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (view == null) {
            view = ItemPowerMenuLibrarySkydovesBinding.inflate(LayoutInflater.from(context), viewGroup, false).getRoot();
        }
        PowerMenuItem powerMenuItem = (PowerMenuItem) getItem(i);
        View viewFindViewById = view.findViewById(R.id.item_power_menu_layout);
        TextView textView = (TextView) view.findViewById(R.id.item_power_menu_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_power_menu_icon);
        textView.setText(powerMenuItem.title);
        textView.setTextSize(this.textSize);
        textView.setGravity(this.textGravity);
        Typeface typeface = this.textTypeface;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        if (powerMenuItem.icon != 0) {
            imageView.getLayoutParams().width = ConvertUtil.convertDpToPixel(this.iconSize, context);
            imageView.getLayoutParams().height = ConvertUtil.convertDpToPixel(this.iconSize, context);
            imageView.setImageResource(powerMenuItem.icon);
            int i2 = this.iconColor;
            if (i2 != -2) {
                ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(i2));
            }
            if (imageView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) imageView.getLayoutParams()).rightMargin = ConvertUtil.convertDpToPixel(this.iconPadding, context);
            }
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (powerMenuItem.isSelected) {
            setSelectedPosition(i);
            int i3 = this.selectedMenuColor;
            if (i3 == -2) {
                viewFindViewById.setBackgroundColor(-1);
            } else {
                viewFindViewById.setBackgroundColor(i3);
            }
            int i4 = this.selectedTextColor;
            if (i4 == -2) {
                textView.setTextColor(ResourceUtil.getAccentColor(context));
            } else {
                textView.setTextColor(i4);
            }
        } else {
            int i5 = this.menuColor;
            if (i5 == -2) {
                viewFindViewById.setBackgroundColor(-1);
            } else {
                viewFindViewById.setBackgroundColor(i5);
            }
            int i6 = this.textColor;
            if (i6 == -2) {
                textView.setTextColor(-16777216);
            } else {
                textView.setTextColor(i6);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    @Override // com.skydoves.powermenu.MenuBaseAdapter, com.skydoves.powermenu.IMenuItem
    public void setSelectedPosition(int i) {
        super.setSelectedPosition(i);
        if (this.selectedEffect) {
            for (int i2 = 0; i2 < getItemList().size(); i2++) {
                PowerMenuItem powerMenuItem = (PowerMenuItem) getItem(i2);
                powerMenuItem.setIsSelected(false);
                if (i2 == i) {
                    powerMenuItem.setIsSelected(true);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setTextColor(int i) {
        this.textColor = i;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setMenuColor(int i) {
        this.menuColor = i;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setSelectedTextColor(int i) {
        this.selectedTextColor = i;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setSelectedMenuColor(int i) {
        this.selectedMenuColor = i;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setSelectedEffect(boolean z) {
        this.selectedEffect = z;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setTextSize(int i) {
        this.textSize = i;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setIconSize(int i) {
        this.iconSize = i;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setIconColor(int i) {
        this.iconColor = i;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setIconPadding(int i) {
        this.iconPadding = i;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setTextGravity(int i) {
        this.textGravity = i;
    }

    @Override // com.skydoves.powermenu.IPowerMenuAdapter
    public void setTextTypeface(Typeface typeface) {
        this.textTypeface = typeface;
    }
}
