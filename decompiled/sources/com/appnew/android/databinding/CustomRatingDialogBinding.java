package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomRatingDialogBinding implements ViewBinding {
    public final ImageView cross;
    public final RelativeLayout editProfile;
    public final EditText ratingComment;
    private final LinearLayout rootView;
    public final RatingBar sendCourseRating;
    public final RelativeLayout subject1;
    public final Button submitRating;

    private CustomRatingDialogBinding(LinearLayout rootView, ImageView cross, RelativeLayout editProfile, EditText ratingComment, RatingBar sendCourseRating, RelativeLayout subject1, Button submitRating) {
        this.rootView = rootView;
        this.cross = cross;
        this.editProfile = editProfile;
        this.ratingComment = ratingComment;
        this.sendCourseRating = sendCourseRating;
        this.subject1 = subject1;
        this.submitRating = submitRating;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomRatingDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomRatingDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_rating_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomRatingDialogBinding bind(View rootView) {
        int i = R.id.cross;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross);
        if (imageView != null) {
            i = R.id.edit_Profile;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.edit_Profile);
            if (relativeLayout != null) {
                i = R.id.ratingComment;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.ratingComment);
                if (editText != null) {
                    i = R.id.sendCourseRating;
                    RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.sendCourseRating);
                    if (ratingBar != null) {
                        i = R.id.subject1;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subject1);
                        if (relativeLayout2 != null) {
                            i = R.id.submitRating;
                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitRating);
                            if (button != null) {
                                return new CustomRatingDialogBinding((LinearLayout) rootView, imageView, relativeLayout, editText, ratingBar, relativeLayout2, button);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
