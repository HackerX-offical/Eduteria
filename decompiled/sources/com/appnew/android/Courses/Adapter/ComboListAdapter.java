package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ComboListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;
    BottomSetting bottomSetting;
    onButtonClicked buttonClicked;
    ArrayList<Courselist> courseDataArrayList;
    public String isPurchased;
    LeftMenu leftMenu;
    ThemeSettings themeSettings;
    public UtkashRoom utkashRoom;

    public interface onButtonClicked {
        void onCourseClicked(int pos);
    }

    public ComboListAdapter(Activity activity, ArrayList<Courselist> courseDataArrayList, String isPurchased, onButtonClicked buttonClicked) {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.activity = activity;
        this.buttonClicked = buttonClicked;
        this.courseDataArrayList = courseDataArrayList;
        this.isPurchased = isPurchased;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ThemeSettings themeSettingsData = this.utkashRoom.getthemeSettingdao().data();
        this.themeSettings = themeSettingsData;
        if (themeSettingsData != null) {
            this.themeSettings = this.utkashRoom.getthemeSettingdao().data();
            this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
        return new SingleStudyComboListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_combo, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SingleStudyComboListHolder) holder).setData(this.courseDataArrayList, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<Courselist> arrayList = this.courseDataArrayList;
        if (arrayList == null || arrayList.isEmpty()) {
            return 1;
        }
        return this.courseDataArrayList.size();
    }

    public class SingleStudyComboListHolder extends RecyclerView.ViewHolder {
        Button backBtn;
        TextView descriptionTV;
        ImageView eye;
        CardView ibt_single_sub_vd_RL;
        ImageView liveIv;
        RelativeLayout lockRL;
        RelativeLayout no_data_found_RL;
        RelativeLayout thumbRl;
        LinearLayout tileRL;
        TextView titleTV;
        ImageView videoImage;

        public SingleStudyComboListHolder(View itemView) {
            super(itemView);
            this.liveIv = (ImageView) itemView.findViewById(R.id.liveIV);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.videoImage = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.thumbRl = (RelativeLayout) itemView.findViewById(R.id.thumbRl);
            this.titleTV = (TextView) itemView.findViewById(R.id.ibt_current_affair_title);
            this.eye = (ImageView) itemView.findViewById(R.id.open_eye);
            TextView textView = (TextView) itemView.findViewById(R.id.ibt_single_vd_tv_day);
            this.descriptionTV = textView;
            textView.setSelected(true);
            this.tileRL = (LinearLayout) itemView.findViewById(R.id.currentAffairRL);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
        }

        public void setData(final ArrayList<Courselist> courses, final int position) {
            if (courses != null && !courses.isEmpty()) {
                ComboListAdapter.this.setThumbRatio(this.thumbRl);
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                Courselist courselist = courses.get(position);
                if (courselist != null && !TextUtils.isEmpty(courselist.getIsLive()) && courselist.getIsLive().equals("1")) {
                    try {
                        this.liveIv.setVisibility(0);
                        Glide.with(ComboListAdapter.this.activity).asGif().load(Integer.valueOf(R.mipmap.live)).into(this.liveIv);
                    } catch (Exception unused) {
                        this.liveIv.setVisibility(8);
                    }
                } else {
                    this.liveIv.setVisibility(8);
                }
                this.titleTV.setText(courselist.getTitle());
                if (!TextUtils.isEmpty(courselist.getSegment_information())) {
                    this.descriptionTV.setVisibility(0);
                    this.descriptionTV.setText(courselist.getSegment_information());
                } else {
                    this.descriptionTV.setVisibility(8);
                }
                if (ComboListAdapter.this.bottomSetting != null && ComboListAdapter.this.bottomSetting.getLayout_type() != null && ComboListAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                    Helper.setThumbnailImage(ComboListAdapter.this.activity, courselist.getDescHeaderImage(), ComboListAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImage);
                } else {
                    Helper.setThumbnailImage(ComboListAdapter.this.activity, courselist.getDescHeaderImage(), ComboListAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder_new), this.videoImage);
                }
                if (TextUtils.isEmpty(courselist.getIs_locked())) {
                    courselist.setIs_locked("0");
                }
                if (ComboListAdapter.this.isPurchased.equals("1")) {
                    courselist.setIs_locked("0");
                }
                if (courselist.getIs_locked().equals("0")) {
                    this.eye.setVisibility(8);
                    this.lockRL.setVisibility(8);
                } else {
                    this.eye.setVisibility(8);
                    this.lockRL.setVisibility(0);
                }
                this.tileRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ComboListAdapter$SingleStudyComboListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(position, view);
                    }
                });
                return;
            }
            ComboListAdapter.this.handleVisibilityNoData(this.ibt_single_sub_vd_RL, this.no_data_found_RL, this.backBtn);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(int i, View view) {
            if (Helper.isNetworkConnected(ComboListAdapter.this.activity)) {
                ComboListAdapter.this.buttonClicked.onCourseClicked(i);
            } else {
                Helper.showInternetToast(ComboListAdapter.this.activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbRatio(RelativeLayout rlThum) {
        Display defaultDisplay = ((WindowManager) this.activity.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        ViewGroup.LayoutParams layoutParams = rlThum.getLayoutParams();
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) {
            return;
        }
        layoutParams.height = (int) (Helper.grideHeight * displayMetrics.scaledDensity);
        layoutParams.width = (int) (Helper.grideWidth * displayMetrics.scaledDensity);
        rlThum.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVisibilityNoData(CardView ibt_single_sub_vd_RL, RelativeLayout no_data_found_RL, Button backBtn) {
        ibt_single_sub_vd_RL.setVisibility(8);
        no_data_found_RL.setVisibility(0);
        backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ComboListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleVisibilityNoData$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleVisibilityNoData$0(View view) {
        this.activity.finish();
    }
}
