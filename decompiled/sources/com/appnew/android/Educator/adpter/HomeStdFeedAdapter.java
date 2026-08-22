package com.appnew.android.Educator.adpter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.Testimonial.TestimonialModel;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class HomeStdFeedAdapter extends RecyclerView.Adapter<HomeStdFeedViewHolder> {
    private Context context;
    private ArrayList<TestimonialModel.Data.Testimonial> testimonialList;

    public HomeStdFeedAdapter(Context context, ArrayList<TestimonialModel.Data.Testimonial> testimonialList) {
        this.context = context;
        this.testimonialList = testimonialList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HomeStdFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeStdFeedViewHolder(LayoutInflater.from(this.context).inflate(R.layout.home_std_feedback_item, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(HomeStdFeedViewHolder holder, int position) {
        TestimonialModel.Data.Testimonial testimonial = this.testimonialList.get(position);
        Glide.with(this.context).load(testimonial.getFile()).into(holder.home_stdFeedBack_teacherImage);
        holder.home_stdFeedBack_feedbackTxt.setText(Html.fromHtml(testimonial.getDescription()));
        holder.home_stdFeedBack_teacherName.setText(testimonial.getTitle());
        ArrayList arrayList = new ArrayList();
        arrayList.add("#EAFFED");
        arrayList.add("#F9EEFF");
        arrayList.add("#FFA07A");
        arrayList.add("#D8BFD8");
        arrayList.add("#FFB6C1");
        arrayList.add("#FFEBCD");
        arrayList.add("#FFE4E1");
        arrayList.add("#FFFFF0");
        arrayList.add("#F5F5F5");
        arrayList.add("#F8F8FF");
        arrayList.add("#FFF8DC");
        arrayList.add("#E0FFFF");
        holder.home_stdFeedBackCard.setCardBackgroundColor(Color.parseColor((String) arrayList.get(new Random().nextInt(11))));
        final String link = testimonial.getLink();
        if (!link.isEmpty()) {
            holder.home_stdFeedBack_video.setVisibility(0);
            holder.home_stdFeedBack_video.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.HomeStdFeedAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(link, view);
                }
            });
        } else {
            holder.home_stdFeedBack_video.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(String str, View view) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<TestimonialModel.Data.Testimonial> arrayList = this.testimonialList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class HomeStdFeedViewHolder extends RecyclerView.ViewHolder {
        CardView home_stdFeedBackCard;
        TextView home_stdFeedBack_feedbackTxt;
        ImageView home_stdFeedBack_teacherImage;
        TextView home_stdFeedBack_teacherName;
        ImageView home_stdFeedBack_video;

        public HomeStdFeedViewHolder(View itemView) {
            super(itemView);
            this.home_stdFeedBack_teacherImage = (ImageView) itemView.findViewById(R.id.home_stdFeedBack_teacherImage);
            this.home_stdFeedBack_feedbackTxt = (TextView) itemView.findViewById(R.id.home_stdFeedBack_feedbackTxt);
            this.home_stdFeedBack_teacherName = (TextView) itemView.findViewById(R.id.home_stdFeedBack_teacherName);
            this.home_stdFeedBackCard = (CardView) itemView.findViewById(R.id.home_stdFeedBackCard);
            this.home_stdFeedBack_video = (ImageView) itemView.findViewById(R.id.testimonialvideo);
        }
    }
}
