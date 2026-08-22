package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CommentLayoutBinding implements ViewBinding {
    public final LinearLayout bottomlayout;
    public final RecyclerView commentRecyerler;
    public final EditText etMessage;
    public final ImageView ivSend;
    public final LinearLayout linearLayout;
    private final RelativeLayout rootView;

    private CommentLayoutBinding(RelativeLayout rootView, LinearLayout bottomlayout, RecyclerView commentRecyerler, EditText etMessage, ImageView ivSend, LinearLayout linearLayout) {
        this.rootView = rootView;
        this.bottomlayout = bottomlayout;
        this.commentRecyerler = commentRecyerler;
        this.etMessage = etMessage;
        this.ivSend = ivSend;
        this.linearLayout = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CommentLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CommentLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.comment_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CommentLayoutBinding bind(View rootView) {
        int i = R.id.bottomlayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomlayout);
        if (linearLayout != null) {
            i = R.id.comment_recyerler;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.comment_recyerler);
            if (recyclerView != null) {
                i = R.id.et_message;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_message);
                if (editText != null) {
                    i = R.id.iv_send;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_send);
                    if (imageView != null) {
                        i = R.id.linearLayout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout);
                        if (linearLayout2 != null) {
                            return new CommentLayoutBinding((RelativeLayout) rootView, linearLayout, recyclerView, editText, imageView, linearLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
