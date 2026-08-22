package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SmallCustomNotificationLayoutBinding implements ViewBinding {
    public final TextView msg;
    public final LinearLayout notificationDetailsLLC;
    public final ImageView notificationIV;
    private final LinearLayout rootView;
    public final TextView title;

    private SmallCustomNotificationLayoutBinding(LinearLayout rootView, TextView msg, LinearLayout notificationDetailsLLC, ImageView notificationIV, TextView title) {
        this.rootView = rootView;
        this.msg = msg;
        this.notificationDetailsLLC = notificationDetailsLLC;
        this.notificationIV = notificationIV;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SmallCustomNotificationLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SmallCustomNotificationLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.small_custom_notification_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SmallCustomNotificationLayoutBinding bind(View rootView) {
        int i = R.id.msg;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.msg);
        if (textView != null) {
            i = R.id.notificationDetailsLLC;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.notificationDetailsLLC);
            if (linearLayout != null) {
                i = R.id.notificationIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                if (imageView != null) {
                    i = R.id.title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                    if (textView2 != null) {
                        return new SmallCustomNotificationLayoutBinding((LinearLayout) rootView, textView, linearLayout, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
