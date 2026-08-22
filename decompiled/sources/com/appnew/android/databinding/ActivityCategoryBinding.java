package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCategoryBinding implements ViewBinding {
    public final TextView backText;
    public final RelativeLayout headerLayout;
    public final ImageView image;
    public final RelativeLayout layoutParent;
    public final LinearLayout nextBack;
    public final LinearLayout nextLayout;
    public final TextView nextText;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final Space space;
    public final TextView step;
    public final TextView text1;
    public final TextView textViewUP;
    public final RelativeLayout titleinnerRL;
    public final TextView toolbartitleTV;

    private ActivityCategoryBinding(RelativeLayout rootView, TextView backText, RelativeLayout headerLayout, ImageView image, RelativeLayout layoutParent, LinearLayout nextBack, LinearLayout nextLayout, TextView nextText, ProgressBar progressBar, Space space, TextView step, TextView text1, TextView textViewUP, RelativeLayout titleinnerRL, TextView toolbartitleTV) {
        this.rootView = rootView;
        this.backText = backText;
        this.headerLayout = headerLayout;
        this.image = image;
        this.layoutParent = layoutParent;
        this.nextBack = nextBack;
        this.nextLayout = nextLayout;
        this.nextText = nextText;
        this.progressBar = progressBar;
        this.space = space;
        this.step = step;
        this.text1 = text1;
        this.textViewUP = textViewUP;
        this.titleinnerRL = titleinnerRL;
        this.toolbartitleTV = toolbartitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCategoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCategoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_category, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCategoryBinding bind(View rootView) {
        int i = R.id.back_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.back_text);
        if (textView != null) {
            i = R.id.header_layout;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.header_layout);
            if (relativeLayout != null) {
                i = R.id.image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                if (imageView != null) {
                    i = R.id.layout_parent;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout_parent);
                    if (relativeLayout2 != null) {
                        i = R.id.next_back;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.next_back);
                        if (linearLayout != null) {
                            i = R.id.next_layout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.next_layout);
                            if (linearLayout2 != null) {
                                i = R.id.next_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.next_text);
                                if (textView2 != null) {
                                    i = R.id.progressBar;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                    if (progressBar != null) {
                                        i = R.id.space;
                                        Space space = (Space) ViewBindings.findChildViewById(rootView, R.id.space);
                                        if (space != null) {
                                            i = R.id.step;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.step);
                                            if (textView3 != null) {
                                                i = R.id.text1;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text1);
                                                if (textView4 != null) {
                                                    i = R.id.textViewUP;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textViewUP);
                                                    if (textView5 != null) {
                                                        i = R.id.titleinnerRL;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.titleinnerRL);
                                                        if (relativeLayout3 != null) {
                                                            i = R.id.toolbartitleTV;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                                            if (textView6 != null) {
                                                                return new ActivityCategoryBinding((RelativeLayout) rootView, textView, relativeLayout, imageView, relativeLayout2, linearLayout, linearLayout2, textView2, progressBar, space, textView3, textView4, textView5, relativeLayout3, textView6);
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
