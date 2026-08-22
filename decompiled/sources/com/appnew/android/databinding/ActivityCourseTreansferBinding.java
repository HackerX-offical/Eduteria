package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCourseTreansferBinding implements ViewBinding {
    public final Button buttonProceed;
    public final RecyclerView courseNameRecycler;
    public final TextView delete;
    public final ImageView imageBack;
    public final RelativeLayout layout1;
    public final EditText mNo;
    public final Toolbar mainToolbar;
    public final RelativeLayout proceed;
    public final ImageView refresh;
    private final RelativeLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView toolbarTitleTV;

    private ActivityCourseTreansferBinding(RelativeLayout rootView, Button buttonProceed, RecyclerView courseNameRecycler, TextView delete, ImageView imageBack, RelativeLayout layout1, EditText mNo, Toolbar mainToolbar, RelativeLayout proceed, ImageView refresh, CheckBox selectAllDelete, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.buttonProceed = buttonProceed;
        this.courseNameRecycler = courseNameRecycler;
        this.delete = delete;
        this.imageBack = imageBack;
        this.layout1 = layout1;
        this.mNo = mNo;
        this.mainToolbar = mainToolbar;
        this.proceed = proceed;
        this.refresh = refresh;
        this.selectAllDelete = selectAllDelete;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCourseTreansferBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCourseTreansferBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_course_treansfer, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCourseTreansferBinding bind(View rootView) {
        int i = R.id.buttonProceed;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buttonProceed);
        if (button != null) {
            i = R.id.course_name_recycler;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.course_name_recycler);
            if (recyclerView != null) {
                i = R.id.delete;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
                if (textView != null) {
                    i = R.id.image_back;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                    if (imageView != null) {
                        i = R.id.layout1;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout1);
                        if (relativeLayout != null) {
                            i = R.id.m_no;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.m_no);
                            if (editText != null) {
                                i = R.id.main_toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                if (toolbar != null) {
                                    i = R.id.proceed;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.proceed);
                                    if (relativeLayout2 != null) {
                                        i = R.id.refresh;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.refresh);
                                        if (imageView2 != null) {
                                            i = R.id.select_all_delete;
                                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                            if (checkBox != null) {
                                                i = R.id.toolbarTitleTV;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                if (textView2 != null) {
                                                    return new ActivityCourseTreansferBinding((RelativeLayout) rootView, button, recyclerView, textView, imageView, relativeLayout, editText, toolbar, relativeLayout2, imageView2, checkBox, textView2);
                                                }
                                            }
                                        }
                                    }
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
