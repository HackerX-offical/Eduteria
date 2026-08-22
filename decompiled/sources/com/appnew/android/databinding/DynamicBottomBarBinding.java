package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DynamicBottomBarBinding implements ViewBinding {
    public final LinearLayout bottomLL;
    private final RelativeLayout rootView;

    private DynamicBottomBarBinding(RelativeLayout rootView, LinearLayout bottomLL) {
        this.rootView = rootView;
        this.bottomLL = bottomLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DynamicBottomBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DynamicBottomBarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dynamic_bottom_bar, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DynamicBottomBarBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomLL);
        if (linearLayout != null) {
            return new DynamicBottomBarBinding((RelativeLayout) rootView, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.bottomLL)));
    }
}
