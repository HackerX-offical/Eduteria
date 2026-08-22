package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemFolderTypeBinding implements ViewBinding {
    public final TextView folderTitle;
    public final ImageView icon;
    public final RelativeLayout mainRl;
    private final CardView rootView;

    private ItemFolderTypeBinding(CardView rootView, TextView folderTitle, ImageView icon, RelativeLayout mainRl) {
        this.rootView = rootView;
        this.folderTitle = folderTitle;
        this.icon = icon;
        this.mainRl = mainRl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemFolderTypeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemFolderTypeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_folder_type, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemFolderTypeBinding bind(View rootView) {
        int i = R.id.folderTitle;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.folderTitle);
        if (textView != null) {
            i = R.id.icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.icon);
            if (imageView != null) {
                i = R.id.mainRl;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mainRl);
                if (relativeLayout != null) {
                    return new ItemFolderTypeBinding((CardView) rootView, textView, imageView, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
