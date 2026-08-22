package com.appnew.android.home.adapters;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.HelperProgress;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class TileDataAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;
    BottomSetting bottomSetting;
    ArrayList<Courselist> courseDataArrayList;
    String isBook;
    UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());

    public TileDataAdapter2(Activity activity, ArrayList<Courselist> courseDataArrayList, String isBook) {
        this.activity = activity;
        this.courseDataArrayList = courseDataArrayList;
        this.isBook = isBook;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHodler(LayoutInflater.from(this.activity).inflate(R.layout.tile_data_item_adapter2, (ViewGroup) null));
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
        ImageView liveImageView;
        ImageView new_course;
        LinearLayout tileRL;
        TextView titleTV;
        LinearLayout title_ll;
        ImageView videoImage;

        public MyViewHodler(View itemView) {
            super(itemView);
            this.videoImage = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.titleTV = (TextView) itemView.findViewById(R.id.ibt_current_affair_title);
            this.tileRL = (LinearLayout) itemView.findViewById(R.id.currentAffairRL);
            this.title_ll = (LinearLayout) itemView.findViewById(R.id.title_ll);
            this.liveImageView = (ImageView) itemView.findViewById(R.id.liveIV);
            this.new_course = (ImageView) itemView.findViewById(R.id.new_course);
        }

        public void setData(final Courselist course, int position) {
            int screenWidth;
            int screenWidth2;
            checkShowVisibility();
            if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
                int screenWidth3 = HelperProgress.getScreenWidth() / 2;
                boolean z = (TileDataAdapter2.this.activity.getResources().getConfiguration().screenLayout & 15) == 4;
                if ((TileDataAdapter2.this.activity.getResources().getConfiguration().screenLayout & 15) == 3) {
                    screenWidth2 = HelperProgress.getScreenWidth() / 2;
                } else if (z) {
                    screenWidth2 = (HelperProgress.getScreenWidth() / 2) + 300;
                } else {
                    screenWidth2 = (HelperProgress.getScreenWidth() / 2) + 100;
                }
                this.videoImage.setLayoutParams(new RelativeLayout.LayoutParams(screenWidth3, screenWidth2));
                this.videoImage.setClipToOutline(true);
            }
            Glide.with(TileDataAdapter2.this.activity).load(Integer.valueOf(R.mipmap.live)).into(this.liveImageView);
            Glide.with(TileDataAdapter2.this.activity).load(Integer.valueOf(R.mipmap.new_)).into(this.new_course);
            if (course.getExtra_json().getIs_live() == null || !course.getExtra_json().getIs_live().equalsIgnoreCase("1")) {
                this.liveImageView.setVisibility(8);
            } else {
                this.liveImageView.setVisibility(0);
            }
            if (course.getExtra_json() != null) {
                if (course.getExtra_json().getIs_new() != null && course.getExtra_json().getIs_new().equals("1")) {
                    this.new_course.setVisibility(0);
                } else {
                    this.new_course.setVisibility(8);
                }
            }
            if (!GenericUtils.isEmpty(TileDataAdapter2.this.isBook) && TileDataAdapter2.this.isBook.equals("1")) {
                int screenWidth4 = HelperProgress.getScreenWidth() / 2;
                boolean z2 = (TileDataAdapter2.this.activity.getResources().getConfiguration().screenLayout & 15) == 4;
                if ((TileDataAdapter2.this.activity.getResources().getConfiguration().screenLayout & 15) == 3) {
                    screenWidth = HelperProgress.getScreenWidth() / 2;
                } else if (z2) {
                    screenWidth = (HelperProgress.getScreenWidth() / 2) + 300;
                } else {
                    screenWidth = (HelperProgress.getScreenWidth() / 2) + 100;
                }
                this.videoImage.setLayoutParams(new RelativeLayout.LayoutParams(screenWidth4, screenWidth));
            }
            if (!GenericUtils.isEmpty(TileDataAdapter2.this.isBook)) {
                if (TileDataAdapter2.this.isBook.equalsIgnoreCase("1") || (TileDataAdapter2.this.bottomSetting != null && TileDataAdapter2.this.bottomSetting.getLayout_type() != null && TileDataAdapter2.this.bottomSetting.getLayout_type().equals("1"))) {
                    if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                        Helper.setThumbnailImage(TileDataAdapter2.this.activity, course.getDescHeaderImage(), TileDataAdapter2.this.activity.getResources().getDrawable(R.mipmap.placeholder), this.videoImage);
                    } else {
                        this.videoImage.setImageResource(R.mipmap.book_placeholder);
                    }
                } else if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(TileDataAdapter2.this.activity, course.getCover_image(), TileDataAdapter2.this.activity.getResources().getDrawable(R.mipmap.placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.book_placeholder);
                }
            } else if ("1".equals("5") || "1".equals("2")) {
                if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(TileDataAdapter2.this.activity, course.getCover_image(), TileDataAdapter2.this.activity.getResources().getDrawable(R.mipmap.placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.book_placeholder);
                }
            } else if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                Helper.setThumbnailImage(TileDataAdapter2.this.activity, course.getDescHeaderImage(), TileDataAdapter2.this.activity.getResources().getDrawable(R.mipmap.placeholder), this.videoImage);
            } else {
                this.videoImage.setImageResource(R.mipmap.book_placeholder);
            }
            TextUtils.isEmpty(course.getColorCode());
            if (!GenericUtils.isEmpty(TileDataAdapter2.this.isBook) && TileDataAdapter2.this.isBook.equals("1")) {
                this.titleTV.setTextSize(12.0f);
            } else {
                this.titleTV.setTextSize(16.0f);
            }
            this.titleTV.setText(course.getTitle());
            this.tileRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter2.MyViewHodler.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (TextUtils.isEmpty(course.getMaintenanceText())) {
                        Intent intent = new Intent(TileDataAdapter2.this.activity, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SHOW_ALL_COURSES);
                        intent.putExtra(Const.COURSE_ID_MAIN, course.getId());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra(AnalyticsConstants.course_name, course.getTitle());
                        Helper.gotoActivity(intent, TileDataAdapter2.this.activity);
                        return;
                    }
                    Helper.getCourseMaintanaceDialog(TileDataAdapter2.this.activity, "", course.getMaintenanceText());
                }
            });
            if (course.getValidity().equals("") || course.getValidity().equals("0") || course.getValidity().equalsIgnoreCase("0 Days") || course.getValidity().equals("-1") || course.getValidity().equalsIgnoreCase("-1 Days")) {
                course.getCourseSp().equalsIgnoreCase("0");
            }
            if (course.getCourseSp().equalsIgnoreCase("0") || course.getCourseSp().equalsIgnoreCase(course.getMrp())) {
                return;
            }
            new StrikethroughSpan();
        }

        public void checkShowVisibility() {
            if (TileDataAdapter2.this.utkashRoom == null || !TileDataAdapter2.this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                return;
            }
            ThemeSettings themeSettingsData = TileDataAdapter2.this.utkashRoom.getthemeSettingdao().data();
            TileDataAdapter2.this.bottomSetting = (BottomSetting) new Gson().fromJson(themeSettingsData.getBottom(), BottomSetting.class);
        }
    }
}
