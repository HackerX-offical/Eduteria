package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleRowPeopleBinding implements ViewBinding {
    public final FrameLayout followBtnRL;
    public final CircleImageView imageIV;
    public final ImageView imageIVText;
    public final RelativeLayout imageRL;
    public final TextView nameTV;
    private final RelativeLayout rootView;
    public final TextView specialisationTV;

    private SingleRowPeopleBinding(RelativeLayout rootView, FrameLayout followBtnRL, CircleImageView imageIV, ImageView imageIVText, RelativeLayout imageRL, TextView nameTV, TextView specialisationTV) {
        this.rootView = rootView;
        this.followBtnRL = followBtnRL;
        this.imageIV = imageIV;
        this.imageIVText = imageIVText;
        this.imageRL = imageRL;
        this.nameTV = nameTV;
        this.specialisationTV = specialisationTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowPeopleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowPeopleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_people, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowPeopleBinding bind(View rootView) {
        int i = R.id.followBtnRL;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.followBtnRL);
        if (frameLayout != null) {
            i = R.id.imageIV;
            CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
            if (circleImageView != null) {
                i = R.id.imageIVText;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIVText);
                if (imageView != null) {
                    i = R.id.imageRL;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                    if (relativeLayout != null) {
                        i = R.id.nameTV;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                        if (textView != null) {
                            i = R.id.specialisationTV;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.specialisationTV);
                            if (textView2 != null) {
                                return new SingleRowPeopleBinding((RelativeLayout) rootView, frameLayout, circleImageView, imageView, relativeLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
