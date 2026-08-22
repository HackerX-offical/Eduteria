package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class VideoPopUpMenuLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout videopopuplayout;
    public final RecyclerView videopopuplist;

    private VideoPopUpMenuLayoutBinding(LinearLayout rootView, LinearLayout videopopuplayout, RecyclerView videopopuplist) {
        this.rootView = rootView;
        this.videopopuplayout = videopopuplayout;
        this.videopopuplist = videopopuplist;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VideoPopUpMenuLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static VideoPopUpMenuLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.video_pop_up_menu_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static VideoPopUpMenuLayoutBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.videopopuplist);
        if (recyclerView != null) {
            return new VideoPopUpMenuLayoutBinding(linearLayout, linearLayout, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.videopopuplist)));
    }
}
