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
public final class VideoPopUpMenuItemBinding implements ViewBinding {
    public final RelativeLayout popupitemholder;
    private final RelativeLayout rootView;
    public final TextView videopopupitemtext;

    private VideoPopUpMenuItemBinding(RelativeLayout rootView, RelativeLayout popupitemholder, TextView videopopupitemtext) {
        this.rootView = rootView;
        this.popupitemholder = popupitemholder;
        this.videopopupitemtext = videopopupitemtext;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VideoPopUpMenuItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static VideoPopUpMenuItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.video_pop_up_menu_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static VideoPopUpMenuItemBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.videopopupitemtext);
        if (textView != null) {
            return new VideoPopUpMenuItemBinding(relativeLayout, relativeLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.videopopupitemtext)));
    }
}
