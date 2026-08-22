package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCoursesListBinding implements ViewBinding {
    public final TextView delete;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final RecyclerView recyclerCourseList;
    private final RelativeLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView toolbarTitleTV;

    private ActivityCoursesListBinding(RelativeLayout rootView, TextView delete, ImageView imageBack, Toolbar mainToolbar, RecyclerView recyclerCourseList, CheckBox selectAllDelete, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.delete = delete;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.recyclerCourseList = recyclerCourseList;
        this.selectAllDelete = selectAllDelete;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCoursesListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCoursesListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_courses_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCoursesListBinding bind(View rootView) {
        int i = R.id.delete;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
        if (textView != null) {
            i = R.id.image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
            if (imageView != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.recyclerCourseList;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerCourseList);
                    if (recyclerView != null) {
                        i = R.id.select_all_delete;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                        if (checkBox != null) {
                            i = R.id.toolbarTitleTV;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                            if (textView2 != null) {
                                return new ActivityCoursesListBinding((RelativeLayout) rootView, textView, imageView, toolbar, recyclerView, checkBox, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
