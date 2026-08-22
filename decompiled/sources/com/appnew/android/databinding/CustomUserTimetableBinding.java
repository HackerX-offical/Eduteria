package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomUserTimetableBinding implements ViewBinding {
    public final RecyclerView DateTableRecycler;
    public final ImageView arrow1;
    public final ImageView arrow2;
    public final TextView batchId;
    public final RelativeLayout batchRL;
    public final RelativeLayout rlThum;
    private final RelativeLayout rootView;
    public final RecyclerView timeTableRecycler;

    private CustomUserTimetableBinding(RelativeLayout rootView, RecyclerView DateTableRecycler, ImageView arrow1, ImageView arrow2, TextView batchId, RelativeLayout batchRL, RelativeLayout rlThum, RecyclerView timeTableRecycler) {
        this.rootView = rootView;
        this.DateTableRecycler = DateTableRecycler;
        this.arrow1 = arrow1;
        this.arrow2 = arrow2;
        this.batchId = batchId;
        this.batchRL = batchRL;
        this.rlThum = rlThum;
        this.timeTableRecycler = timeTableRecycler;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomUserTimetableBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomUserTimetableBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_user_timetable, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomUserTimetableBinding bind(View rootView) {
        int i = R.id.DateTableRecycler;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.DateTableRecycler);
        if (recyclerView != null) {
            i = R.id.arrow1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow1);
            if (imageView != null) {
                i = R.id.arrow2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow2);
                if (imageView2 != null) {
                    i = R.id.batchId;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.batchId);
                    if (textView != null) {
                        i = R.id.batchRL;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.batchRL);
                        if (relativeLayout != null) {
                            i = R.id.rlThum;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rlThum);
                            if (relativeLayout2 != null) {
                                i = R.id.timeTableRecycler;
                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.timeTableRecycler);
                                if (recyclerView2 != null) {
                                    return new CustomUserTimetableBinding((RelativeLayout) rootView, recyclerView, imageView, imageView2, textView, relativeLayout, relativeLayout2, recyclerView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
