package com.appnew.android.player;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.JWextractor.JWVideoPlayer;
import com.appnew.android.Model.PlayerPojo.VideoTimeFramePojo;
import com.eduteria.app.app.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class Adapter_recycleveiw_vedio extends RecyclerView.Adapter<Viewholder> {
    private Activity con;
    private String fromwhere;
    private List<VideoTimeFramePojo> product;

    public Adapter_recycleveiw_vedio(Activity con, List<VideoTimeFramePojo> product, String fromwhere) {
        this.con = con;
        this.product = product;
        this.fromwhere = fromwhere;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(this.con).inflate(R.layout.activity_cardview_vedio, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Viewholder holder, int position) {
        final VideoTimeFramePojo videoTimeFramePojo = this.product.get(position);
        holder.text.setText(videoTimeFramePojo.getTime().trim());
        holder.text2.setText(videoTimeFramePojo.getInfo().trim());
        holder.parentCV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.Adapter_recycleveiw_vedio.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Date date;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                try {
                    date = simpleDateFormat.parse("1970-01-01 " + videoTimeFramePojo.getTime());
                } catch (ParseException e2) {
                    e2.printStackTrace();
                    date = null;
                }
                date.getTime();
                if (Adapter_recycleveiw_vedio.this.fromwhere.equalsIgnoreCase("custom")) {
                    ((CustomMediaPlayer) Adapter_recycleveiw_vedio.this.con).setVideoTimeMS((int) date.getTime());
                    return;
                }
                if (Adapter_recycleveiw_vedio.this.fromwhere.equalsIgnoreCase("jw")) {
                    ((JWVideoPlayer) Adapter_recycleveiw_vedio.this.con).setVideoTimeMS((int) date.getTime());
                } else if (Adapter_recycleveiw_vedio.this.fromwhere.equalsIgnoreCase("drm")) {
                    ((VODPlayerActivity) Adapter_recycleveiw_vedio.this.con).setVideoTimeMS((int) date.getTime());
                } else {
                    ((Liveawsactivity) Adapter_recycleveiw_vedio.this.con).setVideoTimeMS((int) date.getTime());
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.product.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private CardView parentCV;
        TextView text;
        TextView text2;

        public Viewholder(View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.vediotime);
            TextView textView = (TextView) itemView.findViewById(R.id.vediotitle);
            this.text2 = textView;
            textView.setSelected(true);
            this.parentCV = (CardView) itemView.findViewById(R.id.parentCV);
        }
    }
}
