package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class TeacherStudentDialogBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView stuTv;
    public final TextView teachTv;
    public final View viewDivider;

    private TeacherStudentDialogBinding(RelativeLayout rootView, TextView stuTv, TextView teachTv, View viewDivider) {
        this.rootView = rootView;
        this.stuTv = stuTv;
        this.teachTv = teachTv;
        this.viewDivider = viewDivider;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TeacherStudentDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TeacherStudentDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.teacher_student_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TeacherStudentDialogBinding bind(View rootView) {
        int i = R.id.stuTv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.stuTv);
        if (textView != null) {
            i = R.id.teachTv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.teachTv);
            if (textView2 != null) {
                i = R.id.viewDivider;
                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewDivider);
                if (viewFindChildViewById != null) {
                    return new TeacherStudentDialogBinding((RelativeLayout) rootView, textView, textView2, viewFindChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
