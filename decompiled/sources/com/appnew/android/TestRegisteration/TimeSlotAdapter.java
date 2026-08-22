package com.appnew.android.TestRegisteration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class TimeSlotAdapter extends RecyclerView.Adapter<MyViewHolder> {
    onButtonClicked buttonClicked;
    private JSONArray cards;
    public String contentType;
    private Context context;
    MyViewHolder holderOld;
    String test_position;
    int tilePos = 0;

    public interface onButtonClicked {
        void onTitleClicked(JSONObject jsonObject, String timeSelected);
    }

    public TimeSlotAdapter(Context context, JSONArray cards, onButtonClicked buttonClicked, String test_position) {
        this.context = context;
        this.cards = cards;
        this.buttonClicked = buttonClicked;
        this.test_position = test_position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView selectedImage;
        public TextView time_slot_tv;

        public MyViewHolder(View view) {
            super(view);
            this.time_slot_tv = (TextView) view.findViewById(R.id.time_slot_tv);
            this.selectedImage = (ImageView) view.findViewById(R.id.selectedImage);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_time_slot_layout, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        JSONObject jSONObjectOptJSONObject = this.cards.optJSONObject(position);
        String strOptString = jSONObjectOptJSONObject.optString(FirebaseAnalytics.Param.START_DATE);
        final String str = new SimpleDateFormat("dd MMM yyyy").format(new Date(Long.parseLong(strOptString) * 1000)).toUpperCase() + ",  " + new SimpleDateFormat("hh:mm a").format(new Date(Long.parseLong(strOptString) * 1000)).toUpperCase() + " - " + new SimpleDateFormat("hh:mm a").format(new Date(Long.parseLong(jSONObjectOptJSONObject.optString(FirebaseAnalytics.Param.END_DATE)) * 1000)).toUpperCase();
        holder.time_slot_tv.setText(jSONObjectOptJSONObject.optString("test_series_name") + "\n" + str);
        holder.time_slot_tv.setTextColor(this.context.getResources().getColor(R.color.black_text_color));
        holder.time_slot_tv.setBackgroundResource(R.drawable.gray_stroke_bg);
        holder.selectedImage.setVisibility(8);
        if (this.test_position.equalsIgnoreCase(jSONObjectOptJSONObject.optString("id")) || position == 0) {
            MyViewHolder myViewHolder = this.holderOld;
            if (myViewHolder != null) {
                myViewHolder.time_slot_tv.setTextColor(this.context.getResources().getColor(R.color.black_text_color));
                this.holderOld.time_slot_tv.setBackgroundResource(R.drawable.gray_stroke_bg);
                this.holderOld.selectedImage.setVisibility(8);
            }
            holder.time_slot_tv.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
            holder.time_slot_tv.setBackgroundResource(R.drawable.primary_stroke_bg);
            holder.selectedImage.setVisibility(0);
            this.holderOld = holder;
            try {
                this.buttonClicked.onTitleClicked(this.cards.optJSONObject(position), str);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.TimeSlotAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TimeSlotAdapter.this.holderOld != null) {
                    TimeSlotAdapter.this.holderOld.time_slot_tv.setTextColor(TimeSlotAdapter.this.context.getResources().getColor(R.color.black_text_color));
                    TimeSlotAdapter.this.holderOld.time_slot_tv.setBackgroundResource(R.drawable.gray_stroke_bg);
                    TimeSlotAdapter.this.holderOld.selectedImage.setVisibility(8);
                }
                holder.time_slot_tv.setTextColor(TimeSlotAdapter.this.context.getResources().getColor(R.color.colorPrimary));
                holder.time_slot_tv.setBackgroundResource(R.drawable.primary_stroke_bg);
                TimeSlotAdapter.this.holderOld = holder;
                holder.selectedImage.setVisibility(0);
                try {
                    TimeSlotAdapter.this.buttonClicked.onTitleClicked(TimeSlotAdapter.this.cards.optJSONObject(position), str);
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cards.length();
    }
}
