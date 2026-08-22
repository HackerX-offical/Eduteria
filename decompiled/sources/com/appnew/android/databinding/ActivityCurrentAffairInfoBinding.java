package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCurrentAffairInfoBinding implements ViewBinding {
    public final Button backBtn;
    public final LinearLayout currentAffairDetailsLL;
    public final ImageView currentAffairImage;
    public final ImageView currentAffairInfoBack;
    public final WebView currentAffairSubject;
    public final TextView currentAffairTittle;
    public final ImageView image;
    public final Toolbar mainToolbar;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final LinearLayout noticeBoardDetails;
    public final FloatingActionButton pdfFloating;
    private final ConstraintLayout rootView;
    public final NestedScrollView scroll;
    public final TextView titleNoticeBoard;
    public final TextView toolbarTitleTV;
    public final WebView webNoticeBoard;

    private ActivityCurrentAffairInfoBinding(ConstraintLayout rootView, Button backBtn, LinearLayout currentAffairDetailsLL, ImageView currentAffairImage, ImageView currentAffairInfoBack, WebView currentAffairSubject, TextView currentAffairTittle, ImageView image, Toolbar mainToolbar, TextView noData, RelativeLayout noDataFoundRL, LinearLayout noticeBoardDetails, FloatingActionButton pdfFloating, NestedScrollView scroll, TextView titleNoticeBoard, TextView toolbarTitleTV, WebView webNoticeBoard) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.currentAffairDetailsLL = currentAffairDetailsLL;
        this.currentAffairImage = currentAffairImage;
        this.currentAffairInfoBack = currentAffairInfoBack;
        this.currentAffairSubject = currentAffairSubject;
        this.currentAffairTittle = currentAffairTittle;
        this.image = image;
        this.mainToolbar = mainToolbar;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.noticeBoardDetails = noticeBoardDetails;
        this.pdfFloating = pdfFloating;
        this.scroll = scroll;
        this.titleNoticeBoard = titleNoticeBoard;
        this.toolbarTitleTV = toolbarTitleTV;
        this.webNoticeBoard = webNoticeBoard;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCurrentAffairInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCurrentAffairInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_current_affair_info, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCurrentAffairInfoBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.currentAffairDetailsLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.currentAffairDetailsLL);
            if (linearLayout != null) {
                i = R.id.currentAffair_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_image);
                if (imageView != null) {
                    i = R.id.currentAffair_info_back;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_info_back);
                    if (imageView2 != null) {
                        i = R.id.currentAffair_subject;
                        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_subject);
                        if (webView != null) {
                            i = R.id.currentAffair_tittle;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_tittle);
                            if (textView != null) {
                                i = R.id.image;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                                if (imageView3 != null) {
                                    i = R.id.main_toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                    if (toolbar != null) {
                                        i = R.id.no_data;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                        if (textView2 != null) {
                                            i = R.id.no_data_found_RL;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                                            if (relativeLayout != null) {
                                                i = R.id.noticeBoardDetails;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.noticeBoardDetails);
                                                if (linearLayout2 != null) {
                                                    i = R.id.pdf_floating;
                                                    FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.pdf_floating);
                                                    if (floatingActionButton != null) {
                                                        i = R.id.scroll;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.scroll);
                                                        if (nestedScrollView != null) {
                                                            i = R.id.titleNoticeBoard;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleNoticeBoard);
                                                            if (textView3 != null) {
                                                                i = R.id.toolbarTitleTV;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                if (textView4 != null) {
                                                                    i = R.id.webNoticeBoard;
                                                                    WebView webView2 = (WebView) ViewBindings.findChildViewById(rootView, R.id.webNoticeBoard);
                                                                    if (webView2 != null) {
                                                                        return new ActivityCurrentAffairInfoBinding((ConstraintLayout) rootView, button, linearLayout, imageView, imageView2, webView, textView, imageView3, toolbar, textView2, relativeLayout, linearLayout2, floatingActionButton, nestedScrollView, textView3, textView4, webView2);
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
