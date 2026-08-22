package com.appnew.android.testmodule.adapter;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.testmodule.model.Social;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class FIB_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity ctx;
    private int items;
    private OnItemClickListener mOnItemClickListener;
    int pagerposition;
    ArrayList tags;

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Social obj, int bg, int circle, boolean select);
    }

    public interface OnStartDragListener {
        void onStartDrag(RecyclerView.ViewHolder viewHolder);
    }

    public FIB_Adapter(Activity context, int position, ArrayList tags) {
        new ArrayList();
        this.tags = tags;
        this.pagerposition = position;
        this.ctx = context;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageButton bt_move;
        public ImageView image;
        public EditText optionEditTV;
        public TextView optionIconTV;
        public LinearLayout viewLL;

        public OriginalViewHolder(View v) {
            super(v);
            this.viewLL = (LinearLayout) v.findViewById(R.id.viewLL);
            this.optionIconTV = (TextView) v.findViewById(R.id.optionIconTV);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OriginalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_option_test_view_fib, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.tags.size();
    }

    private class GenericTextWatcher implements TextWatcher {
        private int tag;
        private View view;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        private GenericTextWatcher(View view, int tag) {
            this.view = view;
            this.tag = tag;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string = editable.toString();
            FIB_Adapter.this.tags.remove(this.tag);
            FIB_Adapter.this.tags.add(this.tag, string);
        }
    }
}
