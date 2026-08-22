package com.appnew.android.player;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.PlayerPojo.DoubtItemData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class DoubtVideoAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Activity context;
    private String doubtPublishStatus;
    private boolean isOperator;
    private boolean isShowSubmit;
    private List<DoubtItemData> items;

    public DoubtVideoAdapter(Activity context, List<DoubtItemData> items, String doubtPublishStatus, boolean isOperator, boolean isShowSubmit) {
        this.context = context;
        this.items = items;
        this.doubtPublishStatus = doubtPublishStatus;
        this.isOperator = isOperator;
        this.isShowSubmit = isShowSubmit;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView doubtImageView;
        public ImageView imageView;
        public LinearLayout ll_vote_btn;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.ll_vote_btn = (LinearLayout) view.findViewById(R.id.ll_vote_btn);
            this.doubtImageView = (ImageView) view.findViewById(R.id.doubtImageView);
            this.imageView = (ImageView) view.findViewById(R.id.item_image);
            this.textView = (TextView) view.findViewById(R.id.voteTxt);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doubt_video_item_layout, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String string;
        final DoubtItemData doubtItemData = this.items.get(position);
        Activity activity = this.context;
        if (activity instanceof Liveawsactivity) {
            this.doubtPublishStatus = ((Liveawsactivity) activity).doubtPublishStatus;
            this.isOperator = ((Liveawsactivity) this.context).isOperator;
            this.isShowSubmit = ((Liveawsactivity) this.context).isShowSubmit;
        } else if (activity instanceof VODPlayerActivity) {
            this.doubtPublishStatus = ((VODPlayerActivity) activity).doubtPublishStatus;
            this.isOperator = ((VODPlayerActivity) this.context).isOperator;
            this.isShowSubmit = ((VODPlayerActivity) this.context).isShowSubmit;
        } else if (activity instanceof LiveStreamingYoutube) {
            this.doubtPublishStatus = ((LiveStreamingYoutube) activity).getDoubtPublishStatus();
            this.isOperator = ((LiveStreamingYoutube) this.context).getIsOperator();
            this.isShowSubmit = ((LiveStreamingYoutube) this.context).getIsShowSubmit();
        }
        if (this.isOperator || this.doubtPublishStatus.equalsIgnoreCase("publishCompletedDoubt")) {
            string = (!TextUtils.isEmpty(doubtItemData.getUpvotes()) ? doubtItemData.getUpvotes() : "0") + " " + this.context.getResources().getString(R.string.upvote);
        } else {
            string = this.context.getResources().getString(R.string.upvote);
        }
        holder.textView.setText(string);
        Glide.with(holder.doubtImageView.getContext()).load(!TextUtils.isEmpty(doubtItemData.getImage()) ? doubtItemData.getImage() : "").fitCenter().apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC)).placeholder(R.mipmap.placeholder_course).error(R.mipmap.placeholder_course).into(holder.doubtImageView);
        if (!TextUtils.isEmpty(doubtItemData.getIs_upVoted()) && doubtItemData.getIs_upVoted().equalsIgnoreCase("1")) {
            holder.imageView.setImageResource(R.mipmap.upvote_active);
        } else {
            holder.imageView.setImageResource(R.mipmap.upvote);
        }
        holder.ll_vote_btn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.DoubtVideoAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(doubtItemData, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(DoubtItemData doubtItemData, int i, View view) {
        if (this.doubtPublishStatus.equalsIgnoreCase("publishCompletedDoubt")) {
            Toast.makeText(this.context, "Doubt session has been ended", 0).show();
            return;
        }
        if (!this.isShowSubmit) {
            Toast.makeText(this.context, "Doubts already submitted", 0).show();
            return;
        }
        String strValueOf = "1";
        if (!TextUtils.isEmpty(doubtItemData.getIs_upVoted()) && doubtItemData.getIs_upVoted().equalsIgnoreCase("1")) {
            String strValueOf2 = "0";
            doubtItemData.setIs_upVoted("0");
            if (!TextUtils.isEmpty(doubtItemData.getUpvotes()) && TextUtils.isDigitsOnly(doubtItemData.getUpvotes()) && Integer.parseInt(doubtItemData.getUpvotes()) > 0) {
                strValueOf2 = String.valueOf(Integer.parseInt(doubtItemData.getUpvotes()) - 1);
            }
            doubtItemData.setUpvotes(strValueOf2);
        } else {
            doubtItemData.setIs_upVoted("1");
            if (!TextUtils.isEmpty(doubtItemData.getUpvotes()) && TextUtils.isDigitsOnly(doubtItemData.getUpvotes())) {
                strValueOf = String.valueOf(Integer.parseInt(doubtItemData.getUpvotes()) + 1);
            }
            doubtItemData.setUpvotes(strValueOf);
        }
        notifyItemChanged(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public String getSelectedDoubts() {
        List<DoubtItemData> list = this.items;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (DoubtItemData doubtItemData : this.items) {
                if (!TextUtils.isEmpty(doubtItemData.getIs_upVoted()) && doubtItemData.getIs_upVoted().equalsIgnoreCase("1")) {
                    arrayList.add(doubtItemData.getPosition());
                }
            }
            if (!arrayList.isEmpty()) {
                return TextUtils.join(Constants.SEPARATOR_COMMA, arrayList);
            }
        }
        return "";
    }
}
