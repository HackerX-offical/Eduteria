package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PermissionSettingLayoutBinding implements ViewBinding {
    public final TextView grantPermText;
    public final Toolbar grantpermbottomToolbar;
    private final RelativeLayout rootView;
    public final TextView settingsbtn;
    public final View view1;

    private PermissionSettingLayoutBinding(RelativeLayout rootView, TextView grantPermText, Toolbar grantpermbottomToolbar, TextView settingsbtn, View view1) {
        this.rootView = rootView;
        this.grantPermText = grantPermText;
        this.grantpermbottomToolbar = grantpermbottomToolbar;
        this.settingsbtn = settingsbtn;
        this.view1 = view1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PermissionSettingLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PermissionSettingLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.permission_setting_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PermissionSettingLayoutBinding bind(View rootView) {
        int i = R.id.grant_perm_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.grant_perm_text);
        if (textView != null) {
            i = R.id.grantpermbottomToolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.grantpermbottomToolbar);
            if (toolbar != null) {
                i = R.id.settingsbtn;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.settingsbtn);
                if (textView2 != null) {
                    i = R.id.view1;
                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                    if (viewFindChildViewById != null) {
                        return new PermissionSettingLayoutBinding((RelativeLayout) rootView, textView, toolbar, textView2, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
