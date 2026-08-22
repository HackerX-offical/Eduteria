package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class NotificationCustomLayoutBinding implements ViewBinding {
    public final ImageView appLogoIV;
    public final TextView msg;
    public final LinearLayout notificationDetailsLLC;
    public final ImageView notificationIV;
    private final RelativeLayout rootView;
    public final TextView title;

    private NotificationCustomLayoutBinding(RelativeLayout rootView, ImageView appLogoIV, TextView msg, LinearLayout notificationDetailsLLC, ImageView notificationIV, TextView title) {
        this.rootView = rootView;
        this.appLogoIV = appLogoIV;
        this.msg = msg;
        this.notificationDetailsLLC = notificationDetailsLLC;
        this.notificationIV = notificationIV;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NotificationCustomLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NotificationCustomLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.notification_custom_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NotificationCustomLayoutBinding bind(View rootView) {
        int i = R.id.appLogoIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.appLogoIV);
        if (imageView != null) {
            i = R.id.msg;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.msg);
            if (textView != null) {
                i = R.id.notificationDetailsLLC;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.notificationDetailsLLC);
                if (linearLayout != null) {
                    i = R.id.notificationIV;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                    if (imageView2 != null) {
                        i = R.id.title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                        if (textView2 != null) {
                            return new NotificationCustomLayoutBinding((RelativeLayout) rootView, imageView, textView, linearLayout, imageView2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
