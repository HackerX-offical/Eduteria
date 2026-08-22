package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleTimeSlotLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final ImageView selectedImage;
    public final TextView timeSlotTv;

    private SingleTimeSlotLayoutBinding(RelativeLayout rootView, ImageView selectedImage, TextView timeSlotTv) {
        this.rootView = rootView;
        this.selectedImage = selectedImage;
        this.timeSlotTv = timeSlotTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SingleTimeSlotLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleTimeSlotLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_time_slot_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleTimeSlotLayoutBinding bind(View rootView) {
        int i = R.id.selectedImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.selectedImage);
        if (imageView != null) {
            i = R.id.time_slot_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.time_slot_tv);
            if (textView != null) {
                return new SingleTimeSlotLayoutBinding((RelativeLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
