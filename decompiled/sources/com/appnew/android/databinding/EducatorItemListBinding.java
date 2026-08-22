package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class EducatorItemListBinding implements ViewBinding {
    public final RelativeLayout eduRelative;
    public final TextView itemText;
    private final RelativeLayout rootView;

    private EducatorItemListBinding(RelativeLayout rootView, RelativeLayout eduRelative, TextView itemText) {
        this.rootView = rootView;
        this.eduRelative = eduRelative;
        this.itemText = itemText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static EducatorItemListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EducatorItemListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.educator_item_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EducatorItemListBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.item_text);
        if (textView != null) {
            return new EducatorItemListBinding(relativeLayout, relativeLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.item_text)));
    }
}
