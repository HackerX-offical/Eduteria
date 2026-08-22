package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityViewConversationPageBinding implements ViewBinding {
    public final NoDataFoundBinding dataNotFoundLL;
    public final TextView delete;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final RecyclerView noteList;
    private final ConstraintLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView toolbarTitleTV;

    private ActivityViewConversationPageBinding(ConstraintLayout rootView, NoDataFoundBinding dataNotFoundLL, TextView delete, ImageView imageBack, Toolbar mainToolbar, RecyclerView noteList, CheckBox selectAllDelete, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.dataNotFoundLL = dataNotFoundLL;
        this.delete = delete;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.noteList = noteList;
        this.selectAllDelete = selectAllDelete;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityViewConversationPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityViewConversationPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_view_conversation_page, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityViewConversationPageBinding bind(View rootView) {
        int i = R.id.dataNotFoundLL;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dataNotFoundLL);
        if (viewFindChildViewById != null) {
            NoDataFoundBinding noDataFoundBindingBind = NoDataFoundBinding.bind(viewFindChildViewById);
            i = R.id.delete;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
            if (textView != null) {
                i = R.id.image_back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                if (imageView != null) {
                    i = R.id.main_toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                    if (toolbar != null) {
                        i = R.id.note_list;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.note_list);
                        if (recyclerView != null) {
                            i = R.id.select_all_delete;
                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                            if (checkBox != null) {
                                i = R.id.toolbarTitleTV;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                if (textView2 != null) {
                                    return new ActivityViewConversationPageBinding((ConstraintLayout) rootView, noDataFoundBindingBind, textView, imageView, toolbar, recyclerView, checkBox, textView2);
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
