package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentQuestionBookMarkBinding implements ViewBinding {
    public final Button backBtn;
    public final ImageView image;
    public final TextView noData;
    public final RecyclerView queBookmarklistRecycler;
    public final RelativeLayout questionBookmarkRL;
    private final FrameLayout rootView;

    private FragmentQuestionBookMarkBinding(FrameLayout rootView, Button backBtn, ImageView image, TextView noData, RecyclerView queBookmarklistRecycler, RelativeLayout questionBookmarkRL) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.image = image;
        this.noData = noData;
        this.queBookmarklistRecycler = queBookmarklistRecycler;
        this.questionBookmarkRL = questionBookmarkRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentQuestionBookMarkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentQuestionBookMarkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_question_book_mark, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentQuestionBookMarkBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
            if (imageView != null) {
                i = R.id.no_data;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                if (textView != null) {
                    i = R.id.que_bookmarklist_recycler;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.que_bookmarklist_recycler);
                    if (recyclerView != null) {
                        i = R.id.questionBookmark_RL;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.questionBookmark_RL);
                        if (relativeLayout != null) {
                            return new FragmentQuestionBookMarkBinding((FrameLayout) rootView, button, imageView, textView, recyclerView, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
