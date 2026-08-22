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
public final class CreateTestCourseItemAdapterBinding implements ViewBinding {
    public final ImageView checkIV;
    public final ImageView ibtSingleVdIv;
    public final ImageView liveIV;
    private final LinearLayout rootView;
    public final LinearLayout tileRL;
    public final TextView title;
    public final RelativeLayout videoplayerRL;

    private CreateTestCourseItemAdapterBinding(LinearLayout rootView, ImageView checkIV, ImageView ibtSingleVdIv, ImageView liveIV, LinearLayout tileRL, TextView title, RelativeLayout videoplayerRL) {
        this.rootView = rootView;
        this.checkIV = checkIV;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.liveIV = liveIV;
        this.tileRL = tileRL;
        this.title = title;
        this.videoplayerRL = videoplayerRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CreateTestCourseItemAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CreateTestCourseItemAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.create_test_course_item_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CreateTestCourseItemAdapterBinding bind(View rootView) {
        int i = R.id.checkIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.checkIV);
        if (imageView != null) {
            i = R.id.ibt_single_vd_iv;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
            if (imageView2 != null) {
                i = R.id.liveIV;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                if (imageView3 != null) {
                    i = R.id.tileRL;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.tileRL);
                    if (linearLayout != null) {
                        i = R.id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                        if (textView != null) {
                            i = R.id.videoplayerRL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.videoplayerRL);
                            if (relativeLayout != null) {
                                return new CreateTestCourseItemAdapterBinding((LinearLayout) rootView, imageView, imageView2, imageView3, linearLayout, textView, relativeLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
