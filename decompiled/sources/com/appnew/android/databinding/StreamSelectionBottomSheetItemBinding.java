package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class StreamSelectionBottomSheetItemBinding implements ViewBinding {
    public final RelativeLayout parentRL;
    private final RelativeLayout rootView;
    public final CheckBox streamCB;
    public final TextView streamText;

    private StreamSelectionBottomSheetItemBinding(RelativeLayout rootView, RelativeLayout parentRL, CheckBox streamCB, TextView streamText) {
        this.rootView = rootView;
        this.parentRL = parentRL;
        this.streamCB = streamCB;
        this.streamText = streamText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StreamSelectionBottomSheetItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static StreamSelectionBottomSheetItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.stream_selection_bottom_sheet_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static StreamSelectionBottomSheetItemBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i = R.id.streamCB;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.streamCB);
        if (checkBox != null) {
            i = R.id.streamText;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.streamText);
            if (textView != null) {
                return new StreamSelectionBottomSheetItemBinding(relativeLayout, relativeLayout, checkBox, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
