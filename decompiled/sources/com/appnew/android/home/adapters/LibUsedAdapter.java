package com.appnew.android.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.home.model.LibUsedModel;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class LibUsedAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private String[] sectionTitles = new LibUsedModel().getLibName();
    private String[] sectionDesc = new LibUsedModel().getLibDesc();

    public LibUsedAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mSectionDesc;
        public TextView mSectionName;

        public ViewHolder(View v) {
            super(v);
            this.mSectionName = (TextView) v.findViewById(R.id.libnametext);
            this.mSectionDesc = (TextView) v.findViewById(R.id.libdesctext);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.libusedlistitem, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mSectionName.setText(this.sectionTitles[position]);
        String[] strArr = this.sectionDesc;
        if (strArr.length == position || strArr.length < position) {
            return;
        }
        holder.mSectionDesc.setText(this.sectionDesc[position]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.sectionTitles.length;
    }
}
