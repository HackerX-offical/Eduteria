package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MyNotesItemAdapterBinding implements ViewBinding {
    public final CardView dataCv;
    public final CardView deleteBtn;
    public final CardView editBtn;
    public final TextView notesDesc;
    public final TextView notesTitle;
    private final RelativeLayout rootView;

    private MyNotesItemAdapterBinding(RelativeLayout rootView, CardView dataCv, CardView deleteBtn, CardView editBtn, TextView notesDesc, TextView notesTitle) {
        this.rootView = rootView;
        this.dataCv = dataCv;
        this.deleteBtn = deleteBtn;
        this.editBtn = editBtn;
        this.notesDesc = notesDesc;
        this.notesTitle = notesTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MyNotesItemAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MyNotesItemAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.my_notes_item_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MyNotesItemAdapterBinding bind(View rootView) {
        int i = R.id.data_cv;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.data_cv);
        if (cardView != null) {
            i = R.id.delete_btn;
            CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.delete_btn);
            if (cardView2 != null) {
                i = R.id.edit_btn;
                CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.edit_btn);
                if (cardView3 != null) {
                    i = R.id.notes_desc;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.notes_desc);
                    if (textView != null) {
                        i = R.id.notes_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notes_title);
                        if (textView2 != null) {
                            return new MyNotesItemAdapterBinding((RelativeLayout) rootView, cardView, cardView2, cardView3, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
