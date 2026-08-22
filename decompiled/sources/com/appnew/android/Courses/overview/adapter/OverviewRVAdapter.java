package com.appnew.android.Courses.overview.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Overview.Description;
import com.appnew.android.Model.Overview.OverviewData;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.home.Constants;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class OverviewRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    CourseDetailData basic;
    private OverviewData basicData;
    Context context;
    public boolean isBoth;
    public boolean isHindi;
    public int position;
    RecyclerView recyclerView;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position;
    }

    public OverviewRVAdapter(Context context, CourseDetailData basic, OverviewData basicData, RecyclerView recyclerView, boolean isHindi, boolean isBoth) {
        this.context = context;
        this.basic = basic;
        this.basicData = basicData;
        this.recyclerView = recyclerView;
        this.isHindi = isHindi;
        this.isBoth = isBoth;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HeaderViewHolder(LayoutInflater.from(this.context).inflate(R.layout.overview_header_layout, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder sholder, final int position) {
        this.position = position;
        final HeaderViewHolder headerViewHolder = (HeaderViewHolder) sholder;
        if (this.basicData.getData() != null) {
            CourseDetailData courseDetailData = this.basic;
            OverviewData overviewData = this.basicData;
            headerViewHolder.setData(courseDetailData, overviewData, !this.isHindi ? overviewData.getData().getDescription() : overviewData.getData().getDescription2(), this.isHindi, this.isBoth);
        } else {
            headerViewHolder.hideLayouts();
            headerViewHolder.hindiTextView.setVisibility(8);
            headerViewHolder.engTextView.setVisibility(8);
        }
        headerViewHolder.hindiTextView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.overview.adapter.OverviewRVAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(headerViewHolder, view);
            }
        });
        headerViewHolder.engTextView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.overview.adapter.OverviewRVAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$1(headerViewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(HeaderViewHolder headerViewHolder, View view) {
        signInClick(headerViewHolder.hindiTextView, headerViewHolder.engTextView, this.isBoth);
        CourseDetailData courseDetailData = this.basic;
        OverviewData overviewData = this.basicData;
        headerViewHolder.setData(courseDetailData, overviewData, overviewData.getData().getDescription2(), true, this.isBoth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(HeaderViewHolder headerViewHolder, View view) {
        signUpClick(headerViewHolder.hindiTextView, headerViewHolder.engTextView, this.isBoth);
        CourseDetailData courseDetailData = this.basic;
        OverviewData overviewData = this.basicData;
        headerViewHolder.setData(courseDetailData, overviewData, overviewData.getData().getDescription(), false, this.isBoth);
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        LinearLayout bookidLL;
        LinearLayout ceoOneLL;
        WebView ceoTwoTV;
        TextView courseid;
        LinearLayout descMainLL;
        WebView descriptionOneTV;
        TextView engTextView;
        TextView hindiTextView;
        LinearLayout relatedCoursesLL;
        RecyclerView relatedCoursesRv;
        TextView titleOneTV;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            this.hindiTextView = (TextView) itemView.findViewById(R.id.hindiTextView);
            this.engTextView = (TextView) itemView.findViewById(R.id.engTextView);
            this.relatedCoursesRv = (RecyclerView) itemView.findViewById(R.id.relatedCoursesRv);
            this.titleOneTV = (TextView) itemView.findViewById(R.id.titleOneTV);
            this.bookidLL = (LinearLayout) itemView.findViewById(R.id.bookidLL);
            this.courseid = (TextView) itemView.findViewById(R.id.courseid);
            this.descMainLL = (LinearLayout) itemView.findViewById(R.id.descMainLL);
            WebView webView = (WebView) itemView.findViewById(R.id.descriptionOneTV);
            this.descriptionOneTV = webView;
            webView.setBackgroundColor(0);
            this.descriptionOneTV.setHapticFeedbackEnabled(false);
            this.descriptionOneTV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.Courses.overview.adapter.OverviewRVAdapter.HeaderViewHolder.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View v) {
                    return true;
                }
            });
            this.descriptionOneTV.setLongClickable(false);
            this.ceoOneLL = (LinearLayout) itemView.findViewById(R.id.ceoOneLL);
            this.relatedCoursesLL = (LinearLayout) itemView.findViewById(R.id.relatedCoursesLL);
            WebView webView2 = (WebView) itemView.findViewById(R.id.ceoTwoTV);
            this.ceoTwoTV = webView2;
            webView2.setBackgroundColor(0);
            if (BuildConfig.FLAVOR.equalsIgnoreCase("banglaguru")) {
                this.hindiTextView.setText("বাংলা");
            }
            this.ceoTwoTV.setHapticFeedbackEnabled(false);
            this.ceoTwoTV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.Courses.overview.adapter.OverviewRVAdapter.HeaderViewHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View v) {
                    return true;
                }
            });
            this.ceoTwoTV.setLongClickable(false);
        }

        public void setData(final CourseDetailData basicData, final OverviewData data, Description descriptions, boolean isHindi, boolean isBoth) {
            this.descMainLL.setVisibility(0);
            if (basicData.getIsPurchased().equalsIgnoreCase("1")) {
                this.bookidLL.setVisibility(8);
                this.courseid.setText(TextUtils.isEmpty(basicData.getId()) ? "N/A" : basicData.getId());
            } else {
                this.bookidLL.setVisibility(8);
            }
            if (descriptions.getHeading() != null && !TextUtils.isEmpty(descriptions.getHeading())) {
                this.titleOneTV.setVisibility(0);
                this.titleOneTV.setText(TextUtils.isEmpty(descriptions.getHeading()) ? "" : descriptions.getHeading());
            } else {
                this.titleOneTV.setVisibility(8);
            }
            if (descriptions.getData() != null && !TextUtils.isEmpty(descriptions.getData())) {
                this.descriptionOneTV.setVisibility(0);
                Helper.showWebDatas((Activity) OverviewRVAdapter.this.context, Helper.getHtmlUpdatedDatas(descriptions.getData()), this.descriptionOneTV);
            } else {
                this.descriptionOneTV.setVisibility(8);
            }
            if (isHindi) {
                if (descriptions.getData() != null && !TextUtils.isEmpty(descriptions.getData())) {
                    this.descriptionOneTV.setVisibility(0);
                    Helper.showWebDatas((Activity) OverviewRVAdapter.this.context, Helper.getHtmlUpdatedDatas((!TextUtils.isEmpty(data.getData().getDescription2().getData()) ? data.getData().getDescription2() : data.getData().getDescription()).getData()), this.descriptionOneTV);
                } else {
                    this.descriptionOneTV.setVisibility(8);
                }
            } else if (descriptions.getData() != null && !TextUtils.isEmpty(descriptions.getData())) {
                this.descriptionOneTV.setVisibility(0);
                Helper.showWebDatas((Activity) OverviewRVAdapter.this.context, Helper.getHtmlUpdatedDatas(data.getData().getDescription().getData()), this.descriptionOneTV);
            } else {
                this.descriptionOneTV.setVisibility(8);
            }
            if (data.getData().getRelatedCourses() != null && data.getData().getRelatedCourses().size() > 0) {
                this.relatedCoursesLL.setVisibility(0);
                OverviewRVAdapter overviewRVAdapter = OverviewRVAdapter.this;
                RelatedDataAdapter relatedDataAdapter = overviewRVAdapter.new RelatedDataAdapter((Activity) overviewRVAdapter.context, data.getData().getRelatedCourses());
                this.relatedCoursesRv.setLayoutManager(new LinearLayoutManager(OverviewRVAdapter.this.context, 0, false));
                this.relatedCoursesRv.setAdapter(relatedDataAdapter);
                this.relatedCoursesRv.setNestedScrollingEnabled(false);
            } else {
                this.relatedCoursesLL.setVisibility(8);
            }
            if (isHindi) {
                OverviewRVAdapter.this.signInClick(this.hindiTextView, this.engTextView, isBoth);
            } else {
                OverviewRVAdapter.this.signUpClick(this.hindiTextView, this.engTextView, isBoth);
            }
        }

        public void hideLayouts() {
            this.descMainLL.setVisibility(8);
        }
    }

    public void signUpClick(TextView hindiTextView, TextView engTextView, boolean isBoth) {
        engTextView.setTextColor(this.context.getResources().getColor(R.color.whiteApp));
        engTextView.setBackground(this.context.getResources().getDrawable(R.drawable.round_black_bg));
        hindiTextView.setTextColor(this.context.getResources().getColor(R.color.black_overlay));
        hindiTextView.setBackground(this.context.getResources().getDrawable(R.drawable.round_white_bg));
        if (isBoth) {
            engTextView.setVisibility(0);
            hindiTextView.setVisibility(0);
        } else {
            engTextView.setVisibility(8);
            hindiTextView.setVisibility(8);
        }
    }

    public void signInClick(TextView hindiTextView, TextView engTextView, boolean isBoth) {
        hindiTextView.setTextColor(this.context.getResources().getColor(R.color.whiteApp));
        hindiTextView.setBackground(this.context.getResources().getDrawable(R.drawable.round_black_bg));
        engTextView.setTextColor(this.context.getResources().getColor(R.color.black_overlay));
        engTextView.setBackground(this.context.getResources().getDrawable(R.drawable.round_white_bg));
        if (isBoth) {
            hindiTextView.setVisibility(0);
            engTextView.setVisibility(0);
        } else {
            hindiTextView.setVisibility(8);
            engTextView.setVisibility(8);
        }
    }

    public class RelatedDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Activity activity;
        ArrayList<Courselist> courseDataArrayList;

        public RelatedDataAdapter(Activity activity, ArrayList<Courselist> courseDataArrayList) {
            this.activity = activity;
            this.courseDataArrayList = courseDataArrayList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHodler(LayoutInflater.from(this.activity).inflate(R.layout.related_course_item_adapter, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyViewHodler) holder).setData(this.courseDataArrayList.get(position), position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.courseDataArrayList.size();
        }

        public class MyViewHodler extends RecyclerView.ViewHolder {
            CardView card_CV;
            ImageView liveImageView;
            TextView mrpCutTV;
            TextView price;
            LinearLayout tileRL;
            TextView titleTV;
            LinearLayout title_ll;
            TextView validityTextTV;
            ImageView videoImage;
            RelativeLayout videoplayerRL;

            public MyViewHodler(View itemView) {
                super(itemView);
                this.videoImage = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
                this.titleTV = (TextView) itemView.findViewById(R.id.ibt_current_affair_title);
                this.validityTextTV = (TextView) itemView.findViewById(R.id.validityTextTV);
                this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
                this.price = (TextView) itemView.findViewById(R.id.priceTV);
                this.card_CV = (CardView) itemView.findViewById(R.id.card_CV);
                this.tileRL = (LinearLayout) itemView.findViewById(R.id.currentAffairRL);
                this.title_ll = (LinearLayout) itemView.findViewById(R.id.title_ll);
                this.videoplayerRL = (RelativeLayout) itemView.findViewById(R.id.videoplayerRL);
                this.liveImageView = (ImageView) itemView.findViewById(R.id.liveIV);
            }

            public void setData(final Courselist course, int position) {
                Glide.with(RelatedDataAdapter.this.activity).load(Integer.valueOf(R.mipmap.live)).into(this.liveImageView);
                if (course.getIsLive() != null && course.getIsLive().equals("1")) {
                    this.liveImageView.setVisibility(0);
                } else {
                    this.liveImageView.setVisibility(8);
                }
                if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(RelatedDataAdapter.this.activity, course.getCover_image(), RelatedDataAdapter.this.activity.getResources().getDrawable(R.mipmap.book_placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.book_placeholder);
                }
                this.titleTV.setText(course.getTitle());
                if (!TextUtils.isEmpty(course.getColorCode())) {
                    this.videoplayerRL.setBackgroundColor(Color.parseColor(course.getColorCode()));
                }
                this.tileRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.overview.adapter.OverviewRVAdapter$RelatedDataAdapter$MyViewHodler$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(course, view);
                    }
                });
                if (course.getValidity().equalsIgnoreCase("0")) {
                    this.validityTextTV.setVisibility(8);
                } else {
                    this.validityTextTV.setVisibility(0);
                }
                if (course.getCourseSp().equalsIgnoreCase("0")) {
                    this.price.setText(RelatedDataAdapter.this.activity.getResources().getString(R.string.free));
                    this.price.setTextAlignment(2);
                    this.validityTextTV.setText(String.format("%s %s", OverviewRVAdapter.this.context.getResources().getString(R.string.validity), course.getValidity()));
                    this.mrpCutTV.setVisibility(8);
                    return;
                }
                if (course.getCourseSp().equalsIgnoreCase(course.getMrp())) {
                    this.mrpCutTV.setVisibility(8);
                    this.validityTextTV.setText(String.format("%s %s", OverviewRVAdapter.this.context.getResources().getString(R.string.validity), course.getValidity(), Boolean.valueOf(course.getValidity().equalsIgnoreCase("0"))));
                    this.price.setText(OverviewRVAdapter.this.context.getResources().getString(R.string.rs) + "" + course.getMrp() + "/-");
                    return;
                }
                this.price.setText(String.format("%s %s %s", OverviewRVAdapter.this.context.getResources().getString(R.string.rs), course.getCourseSp(), "/-"));
                this.mrpCutTV.setText(String.format("%s %s %s", OverviewRVAdapter.this.context.getResources().getString(R.string.rs), course.getMrp(), "/-"), TextView.BufferType.SPANNABLE);
                StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                Spannable spannable = (Spannable) this.mrpCutTV.getText();
                if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                    this.mrpCutTV.setVisibility(0);
                } else {
                    this.mrpCutTV.setVisibility(8);
                }
                spannable.setSpan(strikethroughSpan, 2, new String(course.getMrp()).length() + 2, 33);
                this.validityTextTV.setText(String.format("%s %s", OverviewRVAdapter.this.context.getResources().getString(R.string.validity), course.getValidity(), Boolean.valueOf(course.getValidity().equalsIgnoreCase("0"))));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$setData$0(Courselist courselist, View view) {
                if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                    ((CourseActivity) RelatedDataAdapter.this.activity).isrelated = 1;
                    Intent intent = new Intent(RelatedDataAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                    RelatedDataAdapter.this.activity.startActivity(intent);
                    return;
                }
                Helper.getCourseMaintanaceDialog(RelatedDataAdapter.this.activity, "", courselist.getMaintenanceText());
            }
        }
    }
}
