package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCreateTestOneBinding implements ViewBinding {
    public final RelativeLayout btnpcd;
    public final Button buttonProceed;
    public final RecyclerView createTestRV;
    public final LinearLayout llnote;
    public final TextView maxCount;
    public final RelativeLayout parentLL;
    private final RelativeLayout rootView;
    public final TextView topText;

    private FragmentCreateTestOneBinding(RelativeLayout rootView, RelativeLayout btnpcd, Button buttonProceed, RecyclerView createTestRV, LinearLayout llnote, TextView maxCount, RelativeLayout parentLL, TextView topText) {
        this.rootView = rootView;
        this.btnpcd = btnpcd;
        this.buttonProceed = buttonProceed;
        this.createTestRV = createTestRV;
        this.llnote = llnote;
        this.maxCount = maxCount;
        this.parentLL = parentLL;
        this.topText = topText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCreateTestOneBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCreateTestOneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_create_test_one, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCreateTestOneBinding bind(View rootView) {
        int i = R.id.btnpcd;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.btnpcd);
        if (relativeLayout != null) {
            i = R.id.buttonProceed;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buttonProceed);
            if (button != null) {
                i = R.id.createTestRV;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.createTestRV);
                if (recyclerView != null) {
                    i = R.id.llnote;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llnote);
                    if (linearLayout != null) {
                        i = R.id.maxCount;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.maxCount);
                        if (textView != null) {
                            RelativeLayout relativeLayout2 = (RelativeLayout) rootView;
                            i = R.id.topText;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.topText);
                            if (textView2 != null) {
                                return new FragmentCreateTestOneBinding(relativeLayout2, relativeLayout, button, recyclerView, linearLayout, textView, relativeLayout2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
