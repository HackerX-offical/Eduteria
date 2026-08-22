package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class RecyclerTransChatLayoutBinding implements ViewBinding {
    public final CircleImageView ivAdmin;
    public final LinearLayout llAdmin;
    private final LinearLayout rootView;
    public final TextView tvAdmin;
    public final TextView tvTime;
    public final TextView tvUsername;

    private RecyclerTransChatLayoutBinding(LinearLayout rootView, CircleImageView ivAdmin, LinearLayout llAdmin, TextView tvAdmin, TextView tvTime, TextView tvUsername) {
        this.rootView = rootView;
        this.ivAdmin = ivAdmin;
        this.llAdmin = llAdmin;
        this.tvAdmin = tvAdmin;
        this.tvTime = tvTime;
        this.tvUsername = tvUsername;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RecyclerTransChatLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RecyclerTransChatLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.recycler_trans_chat_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RecyclerTransChatLayoutBinding bind(View rootView) {
        int i = R.id.iv_admin;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.iv_admin);
        if (circleImageView != null) {
            i = R.id.ll_admin;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_admin);
            if (linearLayout != null) {
                i = R.id.tv_admin;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_admin);
                if (textView != null) {
                    i = R.id.tv_time;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_time);
                    if (textView2 != null) {
                        i = R.id.tv_username;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_username);
                        if (textView3 != null) {
                            return new RecyclerTransChatLayoutBinding((LinearLayout) rootView, circleImageView, linearLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
