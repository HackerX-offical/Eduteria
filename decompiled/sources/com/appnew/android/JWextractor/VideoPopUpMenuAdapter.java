package com.appnew.android.JWextractor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.recyclerview.widget.RecyclerView;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class VideoPopUpMenuAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "VideoPopUp Adapter";
    private static int selectedPlayBackQuality = 0;
    public static int selectedPlayBackSpeed = 3;
    private static String stringQuality;
    private JWVideoPlayer activity;
    private List<ViewHolder> holderList;
    private boolean isJWPlayer;
    private boolean isLiveStream;
    private boolean isRecordedLive;
    private boolean isVimeo;
    private Context mContext;
    private Player player;
    private JWVideoPlayer playerActivity;
    private String popUpContext;
    private List<Integer> popUpQualityList;
    private String[] popUpSpeedList;
    private List<String> stringResolutionList;

    public VideoPopUpMenuAdapter(Context mContext, String[] popUpList, ExoPlayer player, String popUpContext) {
        this.isRecordedLive = false;
        this.mContext = mContext;
        this.popUpSpeedList = popUpList;
        this.player = player;
        this.popUpContext = popUpContext;
        this.holderList = new ArrayList();
    }

    public VideoPopUpMenuAdapter(JWVideoPlayer activity, List<Integer> popUpList, Player player, String popUpContext, int selectedQuality, List<String> resolutionList, String sQuality, boolean isJwplayer, boolean isLive, boolean isRecordedLiv) {
        this.isRecordedLive = false;
        new ArrayList();
        this.popUpQualityList = popUpList;
        this.player = player;
        this.popUpContext = popUpContext;
        this.holderList = new ArrayList();
        this.activity = activity;
        selectedPlayBackQuality = selectedQuality;
        this.stringResolutionList = resolutionList;
        stringQuality = sQuality;
        this.isJWPlayer = isJwplayer;
        this.isVimeo = this.isVimeo;
        this.isLiveStream = isLive;
        this.isRecordedLive = isRecordedLiv;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView popUpItemText;
        RelativeLayout popUpLinearLayout;

        public ViewHolder(View v) {
            super(v);
            this.popUpItemText = (TextView) v.findViewById(R.id.videopopupitemtext);
            this.popUpLinearLayout = (RelativeLayout) v.findViewById(R.id.popupitemholder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        JWVideoPlayer jWVideoPlayer = this.activity;
        if (jWVideoPlayer != null) {
            viewInflate = LayoutInflater.from(jWVideoPlayer).inflate(R.layout.video_pop_up_menu_item, parent, false);
        } else {
            viewInflate = LayoutInflater.from(this.playerActivity).inflate(R.layout.video_pop_up_menu_item, parent, false);
        }
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        this.holderList.add(holder);
        holder.popUpItemText.setText(this.stringResolutionList.get(position));
        for (int i = 0; i < this.stringResolutionList.size(); i++) {
            if (stringQuality.equalsIgnoreCase(this.stringResolutionList.get(position))) {
                holder.popUpItemText.setTextColor(this.activity.getResources().getColor(R.color.theme_and_header_color));
            }
        }
        holder.popUpLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.JWextractor.VideoPopUpMenuAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(ViewHolder viewHolder, int i, View view) {
        for (int i2 = 0; i2 < this.holderList.size(); i2++) {
            this.holderList.get(i2).popUpItemText.setTextColor(this.activity.getResources().getColor(R.color.colorActionBarText));
        }
        selectedPlayBackQuality = viewHolder.getAbsoluteAdapterPosition();
        stringQuality = this.stringResolutionList.get(i);
        viewHolder.popUpItemText.setTextColor(this.activity.getResources().getColor(R.color.colorAccent));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.popUpContext.equalsIgnoreCase(TransferTable.COLUMN_SPEED)) {
            return this.popUpSpeedList.length;
        }
        return this.stringResolutionList.size();
    }
}
