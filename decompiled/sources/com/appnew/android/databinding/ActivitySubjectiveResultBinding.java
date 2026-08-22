package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySubjectiveResultBinding implements ViewBinding {
    public final View addressProgressBar;
    public final View cartProgressBar;
    public final Button checkcopy;
    public final ImageView cirleImageview;
    public final Button discussion;
    public final ImageView imgTestback;
    public final TextView name;
    public final TextView obtainedMarks;
    public final TextView rank;
    public final TextView remarksDescription;
    public final LinearLayout remarksLinearLayout;
    private final RelativeLayout rootView;
    public final TextView testSeriesName;
    public final TextView title;
    public final Toolbar toolbar;
    public final TextView totalMarks;

    private ActivitySubjectiveResultBinding(RelativeLayout rootView, View addressProgressBar, View cartProgressBar, Button checkcopy, ImageView cirleImageview, Button discussion, ImageView imgTestback, TextView name, TextView obtainedMarks, TextView rank, TextView remarksDescription, LinearLayout remarksLinearLayout, TextView testSeriesName, TextView title, Toolbar toolbar, TextView totalMarks) {
        this.rootView = rootView;
        this.addressProgressBar = addressProgressBar;
        this.cartProgressBar = cartProgressBar;
        this.checkcopy = checkcopy;
        this.cirleImageview = cirleImageview;
        this.discussion = discussion;
        this.imgTestback = imgTestback;
        this.name = name;
        this.obtainedMarks = obtainedMarks;
        this.rank = rank;
        this.remarksDescription = remarksDescription;
        this.remarksLinearLayout = remarksLinearLayout;
        this.testSeriesName = testSeriesName;
        this.title = title;
        this.toolbar = toolbar;
        this.totalMarks = totalMarks;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySubjectiveResultBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySubjectiveResultBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_subjective_result, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySubjectiveResultBinding bind(View rootView) {
        int i = R.id.address_progress_bar;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.address_progress_bar);
        if (viewFindChildViewById != null) {
            i = R.id.cart_progress_bar;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cart_progress_bar);
            if (viewFindChildViewById2 != null) {
                i = R.id.checkcopy;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.checkcopy);
                if (button != null) {
                    i = R.id.cirle_imageview;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cirle_imageview);
                    if (imageView != null) {
                        i = R.id.discussion;
                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.discussion);
                        if (button2 != null) {
                            i = R.id.img_testback;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_testback);
                            if (imageView2 != null) {
                                i = R.id.name;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.name);
                                if (textView != null) {
                                    i = R.id.obtained_marks;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.obtained_marks);
                                    if (textView2 != null) {
                                        i = R.id.rank;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rank);
                                        if (textView3 != null) {
                                            i = R.id.remarks_description;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remarks_description);
                                            if (textView4 != null) {
                                                i = R.id.remarksLinearLayout;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.remarksLinearLayout);
                                                if (linearLayout != null) {
                                                    i = R.id.testSeriesName;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testSeriesName);
                                                    if (textView5 != null) {
                                                        i = R.id.title;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                        if (textView6 != null) {
                                                            i = R.id.toolbar;
                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                                            if (toolbar != null) {
                                                                i = R.id.total_marks;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_marks);
                                                                if (textView7 != null) {
                                                                    return new ActivitySubjectiveResultBinding((RelativeLayout) rootView, viewFindChildViewById, viewFindChildViewById2, button, imageView, button2, imageView2, textView, textView2, textView3, textView4, linearLayout, textView5, textView6, toolbar, textView7);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
