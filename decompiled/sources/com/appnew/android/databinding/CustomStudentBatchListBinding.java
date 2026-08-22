package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomStudentBatchListBinding implements ViewBinding {
    public final TextView batchName;
    private final RelativeLayout rootView;
    public final ImageView studentImage;
    public final TextView studentName;

    private CustomStudentBatchListBinding(RelativeLayout rootView, TextView batchName, ImageView studentImage, TextView studentName) {
        this.rootView = rootView;
        this.batchName = batchName;
        this.studentImage = studentImage;
        this.studentName = studentName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomStudentBatchListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomStudentBatchListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_student_batch_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomStudentBatchListBinding bind(View rootView) {
        int i = R.id.batch_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.batch_name);
        if (textView != null) {
            i = R.id.studentImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.studentImage);
            if (imageView != null) {
                i = R.id.studentName;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentName);
                if (textView2 != null) {
                    return new CustomStudentBatchListBinding((RelativeLayout) rootView, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
