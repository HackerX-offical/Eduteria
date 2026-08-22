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
public final class SlowNetworkDialogBinding implements ViewBinding {
    public final TextView body;
    public final TextView body2;
    public final TextView body3;
    public final Button negativeBtn;
    public final Button positiveBtn;
    private final RelativeLayout rootView;
    public final TextView title;
    public final View view0;

    private SlowNetworkDialogBinding(RelativeLayout rootView, TextView body, TextView body2, TextView body3, Button negativeBtn, Button positiveBtn, TextView title, View view0) {
        this.rootView = rootView;
        this.body = body;
        this.body2 = body2;
        this.body3 = body3;
        this.negativeBtn = negativeBtn;
        this.positiveBtn = positiveBtn;
        this.title = title;
        this.view0 = view0;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SlowNetworkDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SlowNetworkDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.slow_network_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SlowNetworkDialogBinding bind(View rootView) {
        int i = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.body);
        if (textView != null) {
            i = R.id.body2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.body2);
            if (textView2 != null) {
                i = R.id.body3;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.body3);
                if (textView3 != null) {
                    i = R.id.negativeBtn;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.negativeBtn);
                    if (button != null) {
                        i = R.id.positiveBtn;
                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.positiveBtn);
                        if (button2 != null) {
                            i = R.id.title;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                            if (textView4 != null) {
                                i = R.id.view0;
                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view0);
                                if (viewFindChildViewById != null) {
                                    return new SlowNetworkDialogBinding((RelativeLayout) rootView, textView, textView2, textView3, button, button2, textView4, viewFindChildViewById);
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
