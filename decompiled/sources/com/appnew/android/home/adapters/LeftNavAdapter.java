package com.appnew.android.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.home.Activity.HomeActivity;
import com.appnew.android.home.model.Menu;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class LeftNavAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    LeftNavAdapterListener mListener;
    private List<Menu> menuList;

    public interface LeftNavAdapterListener {
        void onItemClick(Menu menu);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView expandIV;
        LinearLayout feedsLL;
        public ImageView iconIV;
        public TextView nameTV;
        RecyclerView recyclerView;
        public SwitchCompat switchCompat;

        public MyViewHolder(View view) {
            super(view);
            this.nameTV = (TextView) view.findViewById(R.id.nameTV);
            this.iconIV = (ImageView) view.findViewById(R.id.iconIV);
            this.switchCompat = (SwitchCompat) view.findViewById(R.id.switchCompat);
            this.expandIV = (ImageView) view.findViewById(R.id.expandIV);
            this.feedsLL = (LinearLayout) view.findViewById(R.id.feedsLL);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.LeftNavAdapter.MyViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LeftNavAdapter.this.mListener != null) {
                        try {
                            LeftNavAdapter.this.mListener.onItemClick((Menu) LeftNavAdapter.this.menuList.get(MyViewHolder.this.getAbsoluteAdapterPosition()));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public LeftNavAdapter(Context context, List<Menu> menuList) {
        this.menuList = menuList;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left_navigation, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Menu menu = this.menuList.get(position);
        holder.setIsRecyclable(false);
        holder.nameTV.setText(menu.getName());
        holder.iconIV.setImageResource(menu.getImage());
        removeColorTint(holder);
        if (menu.getHaveChild().equalsIgnoreCase("1")) {
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
            final LeftNavAdapter leftNavAdapter = new LeftNavAdapter(this.context, menu.getSubMenu());
            holder.recyclerView.setAdapter(leftNavAdapter);
            if (menu.isExpanded()) {
                holder.expandIV.setBackground(this.context.getResources().getDrawable(com.appnew.android.R.drawable.ic_action_expand_less));
                holder.recyclerView.setVisibility(0);
            } else {
                holder.expandIV.setBackground(this.context.getResources().getDrawable(com.appnew.android.R.drawable.ic_action_expand_more));
                holder.recyclerView.setVisibility(8);
            }
            leftNavAdapter.setLeftNavAdapterListener(new LeftNavAdapterListener() { // from class: com.appnew.android.home.adapters.LeftNavAdapter.1
                @Override // com.appnew.android.home.adapters.LeftNavAdapter.LeftNavAdapterListener
                public void onItemClick(Menu menu2) {
                    if (menu2.getHaveChild().equalsIgnoreCase("1")) {
                        if (menu2.isExpanded()) {
                            menu2.setExpanded(false);
                        } else {
                            menu2.setExpanded(true);
                        }
                    }
                    ((HomeActivity) LeftNavAdapter.this.context).handleLeftMenuClick(menu2);
                    leftNavAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    private void removeColorTint(MyViewHolder holder) {
        if (BuildConfig.FLAVOR.equalsIgnoreCase("IBSStudyApp") || BuildConfig.FLAVOR.equalsIgnoreCase("eduSportIndia")) {
            holder.iconIV.setImageTintList(null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.menuList.size();
    }

    public void setLeftNavAdapterListener(LeftNavAdapterListener listener) {
        this.mListener = listener;
    }
}
