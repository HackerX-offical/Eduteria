package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CourseDetailsTheme2Binding implements ViewBinding {
    public final ConstraintLayout appBarId;
    public final TextView authorname;
    public final ImageView backButton;
    public final TextView bagTextId;
    public final ConstraintLayout constraintLayout2;
    public final ImageView courseImagebg;
    public final TextView courseName;
    public final ImageView dot;
    public final LinearLayout imageRL;
    public final LinearLayoutCompat llCompat;
    public final Button placeOrderId;
    private final RelativeLayout rootView;
    public final AppCompatEditText searchId;
    public final TextView totalPrice;
    public final TextView validityTV;

    private CourseDetailsTheme2Binding(RelativeLayout rootView, ConstraintLayout appBarId, TextView authorname, ImageView backButton, TextView bagTextId, ConstraintLayout constraintLayout2, ImageView courseImagebg, TextView courseName, ImageView dot, LinearLayout imageRL, LinearLayoutCompat llCompat, Button placeOrderId, AppCompatEditText searchId, TextView totalPrice, TextView validityTV) {
        this.rootView = rootView;
        this.appBarId = appBarId;
        this.authorname = authorname;
        this.backButton = backButton;
        this.bagTextId = bagTextId;
        this.constraintLayout2 = constraintLayout2;
        this.courseImagebg = courseImagebg;
        this.courseName = courseName;
        this.dot = dot;
        this.imageRL = imageRL;
        this.llCompat = llCompat;
        this.placeOrderId = placeOrderId;
        this.searchId = searchId;
        this.totalPrice = totalPrice;
        this.validityTV = validityTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CourseDetailsTheme2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CourseDetailsTheme2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.course_details_theme_2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CourseDetailsTheme2Binding bind(View rootView) {
        int i = R.id.appBarId;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.appBarId);
        if (constraintLayout != null) {
            i = R.id.authorname;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.authorname);
            if (textView != null) {
                i = R.id.backButton;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backButton);
                if (imageView != null) {
                    i = R.id.bagTextId;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bagTextId);
                    if (textView2 != null) {
                        i = R.id.constraintLayout2;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.constraintLayout2);
                        if (constraintLayout2 != null) {
                            i = R.id.courseImagebg;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImagebg);
                            if (imageView2 != null) {
                                i = R.id.course_name;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
                                if (textView3 != null) {
                                    i = R.id.dot;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dot);
                                    if (imageView3 != null) {
                                        i = R.id.imageRL;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                                        if (linearLayout != null) {
                                            i = R.id.ll_compat;
                                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.ll_compat);
                                            if (linearLayoutCompat != null) {
                                                i = R.id.placeOrderId;
                                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.placeOrderId);
                                                if (button != null) {
                                                    i = R.id.searchId;
                                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(rootView, R.id.searchId);
                                                    if (appCompatEditText != null) {
                                                        i = R.id.totalPrice;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalPrice);
                                                        if (textView4 != null) {
                                                            i = R.id.validityTV;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTV);
                                                            if (textView5 != null) {
                                                                return new CourseDetailsTheme2Binding((RelativeLayout) rootView, constraintLayout, textView, imageView, textView2, constraintLayout2, imageView2, textView3, imageView3, linearLayout, linearLayoutCompat, button, appCompatEditText, textView4, textView5);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
