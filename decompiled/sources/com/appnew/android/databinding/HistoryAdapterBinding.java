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
public final class HistoryAdapterBinding implements ViewBinding {
    public final ImageView courseImage;
    public final TextView historyTime;
    private final RelativeLayout rootView;
    public final RelativeLayout studySingleItemLL;
    public final TextView videoName;

    private HistoryAdapterBinding(RelativeLayout rootView, ImageView courseImage, TextView historyTime, RelativeLayout studySingleItemLL, TextView videoName) {
        this.rootView = rootView;
        this.courseImage = courseImage;
        this.historyTime = historyTime;
        this.studySingleItemLL = studySingleItemLL;
        this.videoName = videoName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HistoryAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HistoryAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.history_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HistoryAdapterBinding bind(View rootView) {
        int i = R.id.courseImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImage);
        if (imageView != null) {
            i = R.id.history_time;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.history_time);
            if (textView != null) {
                i = R.id.study_single_itemLL;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                if (relativeLayout != null) {
                    i = R.id.video_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.video_name);
                    if (textView2 != null) {
                        return new HistoryAdapterBinding((RelativeLayout) rootView, imageView, textView, relativeLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
