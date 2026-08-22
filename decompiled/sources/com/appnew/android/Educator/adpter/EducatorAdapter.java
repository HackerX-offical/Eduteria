package com.appnew.android.Educator.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Educator.model.EducatorItem;
import com.appnew.android.Model.Educator.LabelItem;
import com.appnew.android.Utils.Helper;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class EducatorAdapter extends RecyclerView.Adapter<EduViewHolder> {
    private Context context;
    private ArrayList<EducatorItem> educatorItemsList;
    private ItemOnClickListener itemOnClickListener;
    private ArrayList<LabelItem> labelItems;
    private int pos = 0;

    public interface ItemOnClickListener {
        void onLabelClick(View view, int position, LabelItem labelItem);
    }

    public EducatorAdapter(Context context, ArrayList<LabelItem> labelItems, ItemOnClickListener itemOnClickListener) {
        this.context = context;
        this.labelItems = labelItems;
        this.itemOnClickListener = itemOnClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EduViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EduViewHolder(LayoutInflater.from(this.context).inflate(R.layout.educator_item_list, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final EduViewHolder holder, final int position) {
        final LabelItem labelItem = this.labelItems.get(position);
        holder.item_text.setText(labelItem.getName());
        int i = this.pos;
        final int i2 = i == position ? R.drawable.tab_bg_select : R.drawable.discount_bg;
        if (i == position) {
            Helper.applyPrimaryColorLight(this.context, holder.eduRelative, 17.5f, i2);
            holder.item_text.setTextColor(ContextCompat.getColor(this.context, R.color.colorPrimary));
        } else {
            holder.eduRelative.setBackground(ContextCompat.getDrawable(this.context, R.drawable.tab_bg_unselect));
            holder.item_text.setTextColor(ContextCompat.getColor(this.context, R.color.gray_dark2));
        }
        holder.eduRelative.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.EducatorAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EducatorAdapter.this.pos = position;
                EducatorAdapter.this.notifyDataSetChanged();
                EducatorAdapter.this.itemOnClickListener.onLabelClick(v, position, labelItem);
                Helper.applyPrimaryColorLight(EducatorAdapter.this.context, holder.eduRelative, 17.5f, i2);
                holder.item_text.setTextColor(ContextCompat.getColor(EducatorAdapter.this.context, R.color.colorPrimary));
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.labelItems.size();
    }

    public class EduViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout eduRelative;
        TextView item_text;

        public EduViewHolder(View itemView) {
            super(itemView);
            this.item_text = (TextView) itemView.findViewById(R.id.item_text);
            this.eduRelative = (RelativeLayout) itemView.findViewById(R.id.eduRelative);
        }
    }
}
