package com.appnew.android.feeds;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<model> data;

    public Adapter(List<model> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.paper_title.setText(this.data.get(position).paperTitle);
        holder.img.setImageResource(this.data.get(position).getImage().intValue());
        holder.img.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.Adapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Adapter.this.context.startActivity(new Intent(Adapter.this.context, (Class<?>) ZoomFeedImage.class));
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView paper_title;

        public ViewHolder(View itemView) {
            super(itemView);
            this.img = (ImageView) itemView.findViewById(R.id.img);
            this.paper_title = (TextView) itemView.findViewById(R.id.paper_title);
        }
    }
}
