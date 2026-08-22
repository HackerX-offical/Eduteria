package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class RetryVideoDialogBinding implements ViewBinding {
    public final TextView body;
    public final Button negativeBtn;
    public final Button positiveBtn;
    private final RelativeLayout rootView;
    public final TextView title;
    public final View view0;

    private RetryVideoDialogBinding(RelativeLayout rootView, TextView body, Button negativeBtn, Button positiveBtn, TextView title, View view0) {
        this.rootView = rootView;
        this.body = body;
        this.negativeBtn = negativeBtn;
        this.positiveBtn = positiveBtn;
        this.title = title;
        this.view0 = view0;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RetryVideoDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RetryVideoDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.retry_video_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RetryVideoDialogBinding bind(View rootView) {
        int i = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.body);
        if (textView != null) {
            i = R.id.negativeBtn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.negativeBtn);
            if (button != null) {
                i = R.id.positiveBtn;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.positiveBtn);
                if (button2 != null) {
                    i = R.id.title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                    if (textView2 != null) {
                        i = R.id.view0;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view0);
                        if (viewFindChildViewById != null) {
                            return new RetryVideoDialogBinding((RelativeLayout) rootView, textView, button, button2, textView2, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
