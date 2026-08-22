package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Notification.readMoreTV.ReadMoreTextView;
import com.eduteria.app.app.R;
import com.google.android.material.imageview.ShapeableImageView;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class NotificationAdapterBinding implements ViewBinding {
    public final TextView date;
    public final ReadMoreTextView descriptionTV;
    public final ShapeableImageView notificationIV;
    public final LinearLayout notificationLL;
    public final TextView notificationTitle;
    public final ImageView openAction;
    public final CircleImageView profileImage;
    public final ImageView removeNoti;
    public final ConstraintLayout rl1;
    private final RelativeLayout rootView;

    private NotificationAdapterBinding(RelativeLayout rootView, TextView date, ReadMoreTextView descriptionTV, ShapeableImageView notificationIV, LinearLayout notificationLL, TextView notificationTitle, ImageView openAction, CircleImageView profileImage, ImageView removeNoti, ConstraintLayout rl1) {
        this.rootView = rootView;
        this.date = date;
        this.descriptionTV = descriptionTV;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.notificationTitle = notificationTitle;
        this.openAction = openAction;
        this.profileImage = profileImage;
        this.removeNoti = removeNoti;
        this.rl1 = rl1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NotificationAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NotificationAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.notification_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NotificationAdapterBinding bind(View rootView) {
        int i = R.id.date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.date);
        if (textView != null) {
            i = R.id.descriptionTV;
            ReadMoreTextView readMoreTextView = (ReadMoreTextView) ViewBindings.findChildViewById(rootView, R.id.descriptionTV);
            if (readMoreTextView != null) {
                i = R.id.notificationIV;
                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                if (shapeableImageView != null) {
                    i = R.id.notificationLL;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                    if (linearLayout != null) {
                        i = R.id.notification_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notification_title);
                        if (textView2 != null) {
                            i = R.id.openAction;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.openAction);
                            if (imageView != null) {
                                i = R.id.profileImage;
                                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                if (circleImageView != null) {
                                    i = R.id.removeNoti;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.removeNoti);
                                    if (imageView2 != null) {
                                        i = R.id.rl1;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.rl1);
                                        if (constraintLayout != null) {
                                            return new NotificationAdapterBinding((RelativeLayout) rootView, textView, readMoreTextView, shapeableImageView, linearLayout, textView2, imageView, circleImageView, imageView2, constraintLayout);
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
