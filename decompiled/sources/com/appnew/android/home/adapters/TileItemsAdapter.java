package com.appnew.android.home.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.Courses.Cards;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.home.interfaces.onButtonClicked;
import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class TileItemsAdapter extends RecyclerView.Adapter<MyViewHolder> {
    onButtonClicked buttonClicked;
    private ArrayList<Cards> cards;
    public String contentType;
    private Context context;
    int tilePos = 0;

    public TileItemsAdapter(Context context, String contentType, ArrayList<Cards> cards, onButtonClicked buttonClicked) {
        this.cards = cards;
        this.context = context;
        this.contentType = contentType;
        this.buttonClicked = buttonClicked;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView liveIv;
        public LinearLayout parent;
        public TextView tilesText;
        public LinearLayout tour_ll;

        public MyViewHolder(View view) {
            super(view);
            this.tilesText = (TextView) view.findViewById(R.id.tilesTextTv);
            this.parent = (LinearLayout) view.findViewById(R.id.parentBottom);
            this.tour_ll = (LinearLayout) view.findViewById(R.id.tour_ll);
            this.liveIv = (ImageView) view.findViewById(R.id.liveIV);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(6, 0, 6, 0);
            this.parent.setLayoutParams(layoutParams);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        if ("1".equalsIgnoreCase("6")) {
            viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_layout, parent, false);
        } else {
            viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_tiles, parent, false);
        }
        return new MyViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Cards cards = this.cards.get(position);
        if (cards != null && !TextUtils.isEmpty(cards.getType()) && cards.getType().equalsIgnoreCase(Const.LIVE_VIDEO)) {
            try {
                holder.liveIv.setVisibility(0);
                Glide.with(this.context).asGif().load(Integer.valueOf(R.mipmap.live)).into(holder.liveIv);
            } catch (Exception unused) {
                holder.liveIv.setVisibility(8);
            }
            holder.tilesText.setPadding(Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)), Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)));
        } else {
            holder.liveIv.setVisibility(8);
            holder.tilesText.setPadding(Math.round(Helper.convertDpToPixel(16, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)), Math.round(Helper.convertDpToPixel(16, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)));
        }
        holder.tilesText.setText(cards.getTile_name());
        if (this.contentType.equals(cards.getType() + cards.getId())) {
            if (!"1".equalsIgnoreCase("6")) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor(Constants.BLACK));
                holder.parent.setBackground(gradientDrawable);
                holder.tilesText.setTextColor(-1);
            } else {
                holder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.round_bg_1));
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.whie));
            }
        } else if (!"1".equalsIgnoreCase("6")) {
            holder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.bg_tile_unselected));
            holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.tile_inactive));
        } else {
            holder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.ronded_bg));
            holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
        }
        holder.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileItemsAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TileItemsAdapter.this.contentType = cards.getType() + cards.getId();
                TileItemsAdapter.this.tilePos = position;
                TileItemsAdapter.this.buttonClicked.onTitleClicked(cards, TileItemsAdapter.this.cards, TileItemsAdapter.this.contentType, TileItemsAdapter.this.tilePos);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cards.size();
    }
}
