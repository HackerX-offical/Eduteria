package com.appnew.android.Courses.Adapter;

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
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Interfaces.OnItemClickListener;
import com.appnew.android.Courses.Interfaces.OnMyCartItemListener;
import com.appnew.android.Model.Course_Data;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.Basic;
import com.appnew.android.Model.Courses.Course;
import com.appnew.android.Model.Courses.SinglestudyModel;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class IBTPracticeViewAllAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    boolean aBoolean;
    Activity activity;
    Context context;
    ArrayList<Courselist> courseDataArrayList;
    Course_Data course_data_view;
    ArrayList<Course> coursesData;
    String frag_type;
    boolean isCardFlag;
    private OnMyCartItemListener mListener;
    private OnItemClickListener onItemClickListener;
    String leadPayType = "2";
    String leadPayNote = "";

    public IBTPracticeViewAllAdapter(Context context, ArrayList<Course> coursesData) {
        this.context = context;
        this.coursesData = coursesData;
        this.activity = (Activity) context;
    }

    public IBTPracticeViewAllAdapter(Activity activity, ArrayList<Courselist> courseDataArrayList, boolean b2, boolean isCardFlag, String frag_type, OnMyCartItemListener mListener) {
        this.activity = activity;
        this.courseDataArrayList = courseDataArrayList;
        this.aBoolean = b2;
        this.isCardFlag = isCardFlag;
        this.frag_type = frag_type;
        this.mListener = mListener;
        this.context = activity;
    }

    public IBTPracticeViewAllAdapter(Activity activity, Course_Data course_data_view, ArrayList<Courselist> courseDataArrayList, boolean b2, boolean isCardFlag, String frag_type, OnItemClickListener onItemClickListener) {
        this.activity = activity;
        this.courseDataArrayList = courseDataArrayList;
        this.aBoolean = b2;
        this.isCardFlag = isCardFlag;
        this.frag_type = frag_type;
        this.course_data_view = course_data_view;
        this.onItemClickListener = onItemClickListener;
        this.context = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (this.aBoolean) {
            if (this.isCardFlag) {
                return new MyViewHodler(LayoutInflater.from(this.activity).inflate(R.layout.ibt_single_item_exam_prep_viewall_verticale, (ViewGroup) null));
            }
            return new MyViewHodler1(LayoutInflater.from(this.activity).inflate(R.layout.ibt_single_item_exam_prep_viewall, (ViewGroup) null));
        }
        return new VIewAllViewHolder(LayoutInflater.from(this.context).inflate(R.layout.ibt_single_item_test_series1, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (this.aBoolean) {
            if (this.isCardFlag) {
                ((MyViewHodler) holder).setData(this.courseDataArrayList.get(position), position);
                return;
            } else {
                ((MyViewHodler1) holder).setData(this.courseDataArrayList.get(position), position);
                return;
            }
        }
        ((VIewAllViewHolder) holder).setData(this.coursesData.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.aBoolean) {
            return this.courseDataArrayList.size();
        }
        return this.coursesData.size();
    }

    protected class VIewAllViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        RelativeLayout ibt_single_test_series_RL;
        TextView price;
        ImageView thumbnail;
        TextView title;

        public VIewAllViewHolder(View itemView) {
            super(itemView);
            this.thumbnail = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.title = (TextView) itemView.findViewById(R.id.ibt_single_vd_tv_title);
            this.description = (TextView) itemView.findViewById(R.id.ibt_single_vd_tv_day);
            this.price = (TextView) itemView.findViewById(R.id.ibt_single_vd_tv_likes);
            this.ibt_single_test_series_RL = (RelativeLayout) itemView.findViewById(R.id.ibt_single_test_series_RL);
        }

        public void setData(final Course course) {
            Helper.setThumbnailImage(IBTPracticeViewAllAdapter.this.context, course.getCover_image(), IBTPracticeViewAllAdapter.this.context.getDrawable(R.mipmap.course_placeholder), this.thumbnail);
            this.title.setText(course.getTitle());
            if (course.getMrp().equalsIgnoreCase("0")) {
                this.price.setText(IBTPracticeViewAllAdapter.this.context.getResources().getString(R.string.free));
            } else if (!TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getId())) {
                if (course.getFor_dams().equalsIgnoreCase(course.getMrp())) {
                    this.price.setText(IBTPracticeViewAllAdapter.this.context.getResources().getString(R.string.rs) + " " + course.getMrp());
                } else {
                    String string = course.getFor_dams().equalsIgnoreCase("0") ? IBTPracticeViewAllAdapter.this.context.getResources().getString(R.string.free) : course.getFor_dams();
                    StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                    this.price.setText(IBTPracticeViewAllAdapter.this.context.getResources().getString(R.string.rs) + " " + course.getMrp() + " " + string, TextView.BufferType.SPANNABLE);
                    ((Spannable) this.price.getText()).setSpan(strikethroughSpan, 2, new String(course.getMrp()).length() + 2, 33);
                }
            } else if (course.getNon_dams().equalsIgnoreCase(course.getMrp())) {
                this.price.setText(IBTPracticeViewAllAdapter.this.context.getResources().getString(R.string.rs) + " " + course.getMrp());
            } else {
                String string2 = course.getNon_dams().equalsIgnoreCase("0") ? IBTPracticeViewAllAdapter.this.context.getResources().getString(R.string.free) : course.getFor_dams();
                StrikethroughSpan strikethroughSpan2 = new StrikethroughSpan();
                this.price.setText(IBTPracticeViewAllAdapter.this.context.getResources().getString(R.string.rs) + " " + course.getMrp() + " " + string2, TextView.BufferType.SPANNABLE);
                ((Spannable) this.price.getText()).setSpan(strikethroughSpan2, 2, new String(course.getMrp()).length() + 2, 33);
            }
            this.ibt_single_test_series_RL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.IBTPracticeViewAllAdapter.VIewAllViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intent intent = new Intent(IBTPracticeViewAllAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_COURSE);
                    intent.putExtra(Const.COURSES, course);
                    IBTPracticeViewAllAdapter.this.activity.startActivity(intent);
                }
            });
        }
    }

    public class MyViewHodler extends RecyclerView.ViewHolder {
        CardView card_CV;
        TextView descriptionTV;
        ImageView liveImageView;
        TextView mrpCutTV;
        TextView price;
        RelativeLayout tileRL;
        TextView titleTV;
        LinearLayout title_ll;
        TextView validityTextTV;
        ImageView videoImage;
        RelativeLayout videoplayerRL;

        public MyViewHodler(View itemView) {
            super(itemView);
            this.videoImage = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.titleTV = (TextView) itemView.findViewById(R.id.ibt_current_affair_title);
            this.descriptionTV = (TextView) itemView.findViewById(R.id.ibt_single_vd_tv_day);
            this.validityTextTV = (TextView) itemView.findViewById(R.id.validityTextTV);
            this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
            this.price = (TextView) itemView.findViewById(R.id.priceTV);
            this.card_CV = (CardView) itemView.findViewById(R.id.card_CV);
            this.tileRL = (RelativeLayout) itemView.findViewById(R.id.currentAffairRL);
            this.title_ll = (LinearLayout) itemView.findViewById(R.id.title_ll);
            this.videoplayerRL = (RelativeLayout) itemView.findViewById(R.id.videoplayerRL);
            this.liveImageView = (ImageView) itemView.findViewById(R.id.liveIV);
        }

        public void setData(final Courselist course, final int position) {
            if (course.getHolderType() != null && course.getHolderType().equalsIgnoreCase("1")) {
                int dimension = (int) IBTPracticeViewAllAdapter.this.activity.getResources().getDimension(R.dimen.dp140);
                int dimension2 = (int) IBTPracticeViewAllAdapter.this.activity.getResources().getDimension(R.dimen.dp180);
                this.title_ll.setVisibility(0);
                this.card_CV.setRadius(0.0f);
                this.card_CV.setMaxCardElevation(0.0f);
                this.videoImage.setLayoutParams(new RelativeLayout.LayoutParams(dimension, dimension2));
                this.videoImage.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appnew.android.Courses.Adapter.IBTPracticeViewAllAdapter.MyViewHodler.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        MyViewHodler.this.videoImage.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        MyViewHodler.this.videoplayerRL.setLayoutParams(new LinearLayout.LayoutParams(MyViewHodler.this.videoImage.getWidth(), MyViewHodler.this.videoImage.getHeight()));
                    }
                });
                Helper.setThumbnailImage(IBTPracticeViewAllAdapter.this.activity, course.getCover_image(), IBTPracticeViewAllAdapter.this.activity.getDrawable(R.mipmap.book_placeholder), this.videoImage);
            } else {
                int dimension3 = (int) IBTPracticeViewAllAdapter.this.activity.getResources().getDimension(R.dimen.dp180);
                int dimension4 = (int) IBTPracticeViewAllAdapter.this.activity.getResources().getDimension(R.dimen.dp120);
                this.title_ll.setVisibility(8);
                this.card_CV.setMaxCardElevation(0.0f);
                this.videoImage.setLayoutParams(new RelativeLayout.LayoutParams(dimension3, dimension4));
                this.videoImage.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appnew.android.Courses.Adapter.IBTPracticeViewAllAdapter.MyViewHodler.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        MyViewHodler.this.videoImage.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        MyViewHodler.this.videoplayerRL.setLayoutParams(new LinearLayout.LayoutParams(MyViewHodler.this.videoImage.getWidth(), MyViewHodler.this.videoImage.getHeight()));
                    }
                });
                Helper.setThumbnailImage(IBTPracticeViewAllAdapter.this.activity, course.getCover_image(), IBTPracticeViewAllAdapter.this.activity.getDrawable(R.mipmap.course_placeholder), this.videoImage);
            }
            Glide.with(IBTPracticeViewAllAdapter.this.activity).load(Integer.valueOf(R.mipmap.live)).into(this.liveImageView);
            if (course.getIsLive() != null && course.getIsLive().equals("1")) {
                this.liveImageView.setVisibility(0);
            } else {
                this.liveImageView.setVisibility(8);
            }
            this.titleTV.setText(course.getTitle() + "\n");
            course.getCourseAttribute().replace(Constants.SEPARATOR_COMMA, " " + IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.blackdot) + " ");
            this.descriptionTV.setVisibility(8);
            if (!TextUtils.isEmpty(course.getColorCode())) {
                this.videoplayerRL.setBackgroundColor(Color.parseColor(course.getColorCode()));
            }
            this.tileRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.IBTPracticeViewAllAdapter.MyViewHodler.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (position == 15) {
                        IBTPracticeViewAllAdapter.this.onItemClickListener.onItemClick(IBTPracticeViewAllAdapter.this.course_data_view.getCategory_info().getId(), IBTPracticeViewAllAdapter.this.course_data_view);
                        return;
                    }
                    if (TextUtils.isEmpty(course.getMaintenanceText())) {
                        if (course.getHolderType() != null && course.getHolderType().equalsIgnoreCase("2")) {
                            Helper.GoWebViewPDFActivity(IBTPracticeViewAllAdapter.this.activity, course.getTitle(), course.getUrl());
                            return;
                        }
                        if (course.getHolderType() == null || !course.getHolderType().equalsIgnoreCase("3")) {
                            Intent intent = new Intent(IBTPracticeViewAllAdapter.this.activity, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, course.getId());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            IBTPracticeViewAllAdapter.this.activity.startActivity(intent);
                            return;
                        }
                        return;
                    }
                    Helper.getCourseMaintanaceDialog(IBTPracticeViewAllAdapter.this.activity, "", course.getMaintenanceText());
                }
            });
            if (course.getValidity().equalsIgnoreCase("0")) {
                this.validityTextTV.setVisibility(8);
            } else {
                this.validityTextTV.setVisibility(8);
            }
            if (course.getCourseSp().equalsIgnoreCase("0")) {
                this.price.setText(IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.free));
                this.validityTextTV.setText(String.format("%s %s %s", IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity(), (course.getValidity().equalsIgnoreCase("0") || course.getValidity().equalsIgnoreCase("1")) ? IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.month) : IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.months)));
                this.mrpCutTV.setVisibility(8);
            } else {
                if (course.getCourseSp().equalsIgnoreCase(course.getMrp())) {
                    this.mrpCutTV.setVisibility(8);
                    this.validityTextTV.setText(String.format("%s %s %s", IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity(), (course.getValidity().equalsIgnoreCase("0") || course.getValidity().equalsIgnoreCase("1")) ? IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.month) : IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.months)));
                    this.price.setText(com.appnew.android.home.Constants.currencyType + "" + course.getMrp() + "/-");
                    return;
                }
                this.price.setText(String.format("%s %s %s", com.appnew.android.home.Constants.currencyType, course.getCourseSp(), "/-"));
                this.mrpCutTV.setText(String.format("%s %s %s", com.appnew.android.home.Constants.currencyType, course.getMrp(), "/-"), TextView.BufferType.SPANNABLE);
                StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                Spannable spannable = (Spannable) this.mrpCutTV.getText();
                if (com.appnew.android.home.Constants.is_offerPrice.equalsIgnoreCase("0")) {
                    this.mrpCutTV.setVisibility(0);
                } else {
                    this.mrpCutTV.setVisibility(8);
                }
                spannable.setSpan(strikethroughSpan, 2, new String(course.getMrp()).length() + 2, 33);
                this.validityTextTV.setText(String.format("%s %s %s", IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity(), (course.getValidity().equalsIgnoreCase("0") || course.getValidity().equalsIgnoreCase("1")) ? IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.month) : IBTPracticeViewAllAdapter.this.activity.getResources().getString(R.string.months)));
            }
        }
    }

    public class MyViewHodler1 extends RecyclerView.ViewHolder {
        TextView descriptionTV;
        TextView expire_date;
        TextView mrpCutTV;
        TextView next_payment_txt;
        LinearLayout payCompleteLL;
        LinearLayout payNowBtn;
        LinearLayout payNowLL;
        TextView price;
        LinearLayout remove_cart;
        RelativeLayout tileRL;
        TextView titleTV;
        TextView validityTextTV;
        ImageView videoImage;
        RelativeLayout videoplayerRL;

        public MyViewHodler1(View itemView) {
            super(itemView);
            this.videoImage = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.remove_cart = (LinearLayout) itemView.findViewById(R.id.remove_cart);
            this.titleTV = (TextView) itemView.findViewById(R.id.ibt_current_affair_title);
            this.descriptionTV = (TextView) itemView.findViewById(R.id.ibt_single_vd_tv_day);
            this.validityTextTV = (TextView) itemView.findViewById(R.id.validityTextTV);
            this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
            this.expire_date = (TextView) itemView.findViewById(R.id.expire_date);
            this.price = (TextView) itemView.findViewById(R.id.priceTV);
            this.tileRL = (RelativeLayout) itemView.findViewById(R.id.currentAffairRL);
            this.videoplayerRL = (RelativeLayout) itemView.findViewById(R.id.videoplayerRL);
            this.payCompleteLL = (LinearLayout) itemView.findViewById(R.id.payCompleteLL);
            this.payNowLL = (LinearLayout) itemView.findViewById(R.id.payNowLL);
            this.next_payment_txt = (TextView) itemView.findViewById(R.id.next_payment_txt);
            this.payNowBtn = (LinearLayout) itemView.findViewById(R.id.payNowBtn);
        }

        public SinglestudyModel getStudyData(Courselist courselist) {
            return new SinglestudyModel(new Basic(courselist.getCover_image(), courselist.getId(), courselist.getTitle(), courselist.getCourseSp(), courselist.getDescHeaderImage(), courselist.getCourseAttribute(), courselist.getValidity(), courselist.getPayment_type(), courselist.getColorCode(), "", courselist.getMrp(), courselist.getCourseAttribute(), "", "", courselist.getIs_postal_available(), courselist.getHolderType(), ""));
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01c6  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x02ed  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setData(final com.appnew.android.Model.Courselist r19, final int r20) {
            /*
                Method dump skipped, instruction units count: 1278
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Adapter.IBTPracticeViewAllAdapter.MyViewHodler1.setData(com.appnew.android.Model.Courselist, int):void");
        }
    }
}
