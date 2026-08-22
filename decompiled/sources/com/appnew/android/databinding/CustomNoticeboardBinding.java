package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomNoticeboardBinding implements ViewBinding {
    public final TextView noticeDate;
    public final TextView noticeText;
    public final TextView noticeTitle;
    private final LinearLayout rootView;

    private CustomNoticeboardBinding(LinearLayout rootView, TextView noticeDate, TextView noticeText, TextView noticeTitle) {
        this.rootView = rootView;
        this.noticeDate = noticeDate;
        this.noticeText = noticeText;
        this.noticeTitle = noticeTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomNoticeboardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomNoticeboardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_noticeboard, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomNoticeboardBinding bind(View rootView) {
        int i = R.id.noticeDate;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.noticeDate);
        if (textView != null) {
            i = R.id.noticeText;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noticeText);
            if (textView2 != null) {
                i = R.id.noticeTitle;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.noticeTitle);
                if (textView3 != null) {
                    return new CustomNoticeboardBinding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
