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
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomBookmarkListNewBinding implements ViewBinding {
    public final TextView bookmarkCount;
    public final ImageView bookmarkImage;
    public final TextView bookmarkSubject;
    public final TextView bookmarkTittle;
    public final ClickableWebView bookmarkTittleQuestion;
    public final TextView dateTime;
    public final ImageView imgBookmark;
    public final ImageView imgPlayPause;
    public final LinearLayout llFirst;
    private final RelativeLayout rootView;
    public final ImageView shareCurrentAffair;

    private CustomBookmarkListNewBinding(RelativeLayout rootView, TextView bookmarkCount, ImageView bookmarkImage, TextView bookmarkSubject, TextView bookmarkTittle, ClickableWebView bookmarkTittleQuestion, TextView dateTime, ImageView imgBookmark, ImageView imgPlayPause, LinearLayout llFirst, ImageView shareCurrentAffair) {
        this.rootView = rootView;
        this.bookmarkCount = bookmarkCount;
        this.bookmarkImage = bookmarkImage;
        this.bookmarkSubject = bookmarkSubject;
        this.bookmarkTittle = bookmarkTittle;
        this.bookmarkTittleQuestion = bookmarkTittleQuestion;
        this.dateTime = dateTime;
        this.imgBookmark = imgBookmark;
        this.imgPlayPause = imgPlayPause;
        this.llFirst = llFirst;
        this.shareCurrentAffair = shareCurrentAffair;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomBookmarkListNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomBookmarkListNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_bookmark_list_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomBookmarkListNewBinding bind(View rootView) {
        int i = R.id.bookmark_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookmark_count);
        if (textView != null) {
            i = R.id.bookmark_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.bookmark_image);
            if (imageView != null) {
                i = R.id.bookmark_subject;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookmark_subject);
                if (textView2 != null) {
                    i = R.id.bookmark_tittle;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookmark_tittle);
                    if (textView3 != null) {
                        i = R.id.bookmark_tittle_question;
                        ClickableWebView clickableWebView = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.bookmark_tittle_question);
                        if (clickableWebView != null) {
                            i = R.id.date_time;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_time);
                            if (textView4 != null) {
                                i = R.id.img_bookmark;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_bookmark);
                                if (imageView2 != null) {
                                    i = R.id.img_play_pause;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_play_pause);
                                    if (imageView3 != null) {
                                        i = R.id.ll_first;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_first);
                                        if (linearLayout != null) {
                                            i = R.id.shareCurrentAffair;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shareCurrentAffair);
                                            if (imageView4 != null) {
                                                return new CustomBookmarkListNewBinding((RelativeLayout) rootView, textView, imageView, textView2, textView3, clickableWebView, textView4, imageView2, imageView3, linearLayout, imageView4);
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
