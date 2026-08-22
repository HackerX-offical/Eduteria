package com.appnew.android.testmodule.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.appnew.android.testmodule.model.TestSection;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class PartAdapter extends ArrayAdapter<TestSection> {
    Context context;
    ArrayList<TestSection> partLiast;

    public PartAdapter(Context context, ArrayList<TestSection> partLiast) {
        super(context, 0, partLiast);
        new ArrayList();
        this.partLiast = partLiast;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_part, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tvName);
        if (TextUtils.isEmpty(this.partLiast.get(position).getSectionPart())) {
            textView.setText(this.partLiast.get(position).getName());
            return convertView;
        }
        textView.setText(this.partLiast.get(position).getName() + this.context.getResources().getString(R.string.part) + this.partLiast.get(position).getSectionPart() + ")");
        return convertView;
    }
}
