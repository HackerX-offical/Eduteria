package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DatePickDialogBinding implements ViewBinding {
    public final ImageView cross;
    public final RelativeLayout editProfile;
    public final EditText endDate;
    private final LinearLayout rootView;
    public final EditText startDate;
    public final Button submitFilter;

    private DatePickDialogBinding(LinearLayout rootView, ImageView cross, RelativeLayout editProfile, EditText endDate, EditText startDate, Button submitFilter) {
        this.rootView = rootView;
        this.cross = cross;
        this.editProfile = editProfile;
        this.endDate = endDate;
        this.startDate = startDate;
        this.submitFilter = submitFilter;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DatePickDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DatePickDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.date_pick_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DatePickDialogBinding bind(View rootView) {
        int i = R.id.cross;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross);
        if (imageView != null) {
            i = R.id.edit_Profile;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.edit_Profile);
            if (relativeLayout != null) {
                i = R.id.endDate;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.endDate);
                if (editText != null) {
                    i = R.id.startDate;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.startDate);
                    if (editText2 != null) {
                        i = R.id.submitFilter;
                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitFilter);
                        if (button != null) {
                            return new DatePickDialogBinding((LinearLayout) rootView, imageView, relativeLayout, editText, editText2, button);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
