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
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySuggestionBinding implements ViewBinding {
    public final RelativeLayout SuggestionRL;
    public final EditText comment;
    public final Toolbar mainToolbar;
    public final RatingBar ratting;
    public final RelativeLayout relativeLayout;
    public final RelativeLayout relativeLayout0;
    public final RelativeLayout relativeLayout1;
    public final RelativeLayout rl2;
    private final ConstraintLayout rootView;
    public final RelativeLayout subject1;
    public final Button submitRatting;
    public final Button submitSupport;
    public final EditText suggestionComment;
    public final ImageView suggestionImageBack;
    public final ImageView suggestionImg;
    public final LinearLayout suggestionLl;
    public final RelativeLayout suggestionRelative;
    public final RelativeLayout suggestionRll;
    public final TextView suggestionText;
    public final ImageView supportImg;
    public final RelativeLayout supportRll;
    public final TextView supportText;
    public final TextView toolbarTitleTV;

    private ActivitySuggestionBinding(ConstraintLayout rootView, RelativeLayout SuggestionRL, EditText comment, Toolbar mainToolbar, RatingBar ratting, RelativeLayout relativeLayout, RelativeLayout relativeLayout0, RelativeLayout relativeLayout1, RelativeLayout rl2, RelativeLayout subject1, Button submitRatting, Button submitSupport, EditText suggestionComment, ImageView suggestionImageBack, ImageView suggestionImg, LinearLayout suggestionLl, RelativeLayout suggestionRelative, RelativeLayout suggestionRll, TextView suggestionText, ImageView supportImg, RelativeLayout supportRll, TextView supportText, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.SuggestionRL = SuggestionRL;
        this.comment = comment;
        this.mainToolbar = mainToolbar;
        this.ratting = ratting;
        this.relativeLayout = relativeLayout;
        this.relativeLayout0 = relativeLayout0;
        this.relativeLayout1 = relativeLayout1;
        this.rl2 = rl2;
        this.subject1 = subject1;
        this.submitRatting = submitRatting;
        this.submitSupport = submitSupport;
        this.suggestionComment = suggestionComment;
        this.suggestionImageBack = suggestionImageBack;
        this.suggestionImg = suggestionImg;
        this.suggestionLl = suggestionLl;
        this.suggestionRelative = suggestionRelative;
        this.suggestionRll = suggestionRll;
        this.suggestionText = suggestionText;
        this.supportImg = supportImg;
        this.supportRll = supportRll;
        this.supportText = supportText;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySuggestionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySuggestionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_suggestion, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySuggestionBinding bind(View rootView) {
        int i = R.id.SuggestionRL;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.SuggestionRL);
        if (relativeLayout != null) {
            i = R.id.comment;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.comment);
            if (editText != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.ratting;
                    RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.ratting);
                    if (ratingBar != null) {
                        i = R.id.relative_layout;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relative_layout);
                        if (relativeLayout2 != null) {
                            i = R.id.relative_layout0;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relative_layout0);
                            if (relativeLayout3 != null) {
                                i = R.id.relative_layout1;
                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relative_layout1);
                                if (relativeLayout4 != null) {
                                    i = R.id.rl2;
                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl2);
                                    if (relativeLayout5 != null) {
                                        i = R.id.subject1;
                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subject1);
                                        if (relativeLayout6 != null) {
                                            i = R.id.submit_ratting;
                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_ratting);
                                            if (button != null) {
                                                i = R.id.submit_support;
                                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_support);
                                                if (button2 != null) {
                                                    i = R.id.suggestion_comment;
                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.suggestion_comment);
                                                    if (editText2 != null) {
                                                        i = R.id.suggestion_image_back;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.suggestion_image_back);
                                                        if (imageView != null) {
                                                            i = R.id.suggestion_img;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.suggestion_img);
                                                            if (imageView2 != null) {
                                                                i = R.id.suggestion_ll;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.suggestion_ll);
                                                                if (linearLayout != null) {
                                                                    i = R.id.suggestion_relative;
                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.suggestion_relative);
                                                                    if (relativeLayout7 != null) {
                                                                        i = R.id.suggestion_rll;
                                                                        RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.suggestion_rll);
                                                                        if (relativeLayout8 != null) {
                                                                            i = R.id.suggestion_text;
                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.suggestion_text);
                                                                            if (textView != null) {
                                                                                i = R.id.support_img;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.support_img);
                                                                                if (imageView3 != null) {
                                                                                    i = R.id.support_rll;
                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.support_rll);
                                                                                    if (relativeLayout9 != null) {
                                                                                        i = R.id.support_text;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.support_text);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.toolbarTitleTV;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                            if (textView3 != null) {
                                                                                                return new ActivitySuggestionBinding((ConstraintLayout) rootView, relativeLayout, editText, toolbar, ratingBar, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, button, button2, editText2, imageView, imageView2, linearLayout, relativeLayout7, relativeLayout8, textView, imageView3, relativeLayout9, textView2, textView3);
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
