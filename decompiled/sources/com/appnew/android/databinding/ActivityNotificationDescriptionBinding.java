package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityNotificationDescriptionBinding implements ViewBinding {
    public final TextView dateTime;
    public final ImageView descriptionImageView;
    public final TextView descriptionTextView;
    public final TextView descriptionUrlTV;
    public final ImageView imageBack;
    public final ConstraintLayout layout;
    public final Toolbar mainToolbar;
    public final TextView markasread;
    private final RelativeLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityNotificationDescriptionBinding(RelativeLayout rootView, TextView dateTime, ImageView descriptionImageView, TextView descriptionTextView, TextView descriptionUrlTV, ImageView imageBack, ConstraintLayout layout, Toolbar mainToolbar, TextView markasread, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.dateTime = dateTime;
        this.descriptionImageView = descriptionImageView;
        this.descriptionTextView = descriptionTextView;
        this.descriptionUrlTV = descriptionUrlTV;
        this.imageBack = imageBack;
        this.layout = layout;
        this.mainToolbar = mainToolbar;
        this.markasread = markasread;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNotificationDescriptionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityNotificationDescriptionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_notification_description, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityNotificationDescriptionBinding bind(View rootView) {
        int i = R.id.date_time;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_time);
        if (textView != null) {
            i = R.id.description_imageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.description_imageView);
            if (imageView != null) {
                i = R.id.description_textView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.description_textView);
                if (textView2 != null) {
                    i = R.id.description_urlTV;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.description_urlTV);
                    if (textView3 != null) {
                        i = R.id.image_back;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                        if (imageView2 != null) {
                            i = R.id.layout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                            if (constraintLayout != null) {
                                i = R.id.main_toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                if (toolbar != null) {
                                    i = R.id.markasread;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.markasread);
                                    if (textView4 != null) {
                                        i = R.id.toolbarTitleTV;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                        if (textView5 != null) {
                                            return new ActivityNotificationDescriptionBinding((RelativeLayout) rootView, textView, imageView, textView2, textView3, imageView2, constraintLayout, toolbar, textView4, textView5);
                                        }
                                    }
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
