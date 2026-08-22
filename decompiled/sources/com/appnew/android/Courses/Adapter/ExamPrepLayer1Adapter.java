package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Fragment.ExamPrepLayer1;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.table.ThemeSettings;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ExamPrepLayer1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;
    BottomSetting bottomSetting;
    ExamPrepItem examPrepItem;
    ExamPrepLayer1 examPrepLayer1;
    boolean isCombo;
    public Lists lists;
    String revertAPI;
    CourseDetail singleStudy;
    String tabTileVisibility;
    private final ThemeSettings themeSettings;
    String tileIdAPI;
    String tileTypeAPI;
    public UtkashRoom utkashRoom;
    int DEFAULT_SPAN_COUNT = 2;
    String noData = "0";

    public ExamPrepLayer1Adapter(Activity activity, ExamPrepItem examPrepItem, Lists lists, ExamPrepLayer1 fragment, CourseDetail singleStudy, boolean isCombo, String tileIdAPI, String tileTypeAPI, String revertAPI, String tabTileVisibility) {
        this.isCombo = false;
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.examPrepItem = examPrepItem;
        this.lists = lists;
        this.activity = activity;
        this.examPrepLayer1 = fragment;
        this.singleStudy = singleStudy;
        this.isCombo = isCombo;
        this.tileTypeAPI = tileTypeAPI;
        this.tileIdAPI = tileIdAPI;
        this.revertAPI = revertAPI;
        this.tabTileVisibility = tabTileVisibility;
        ThemeSettings themeSettingsData = appDatabase.getthemeSettingdao().data();
        this.themeSettings = themeSettingsData;
        if (themeSettingsData != null) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(themeSettingsData.getBottom(), BottomSetting.class);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        if (viewType == 0) {
            if ("1".equalsIgnoreCase("5") || "1".equalsIgnoreCase("7")) {
                viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.single_study_item_new_springboard, parent, false);
            } else {
                viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.single_study_item_new, parent, false);
            }
            return new SingleStudyVideoListHolder(viewInflate);
        }
        return new SingleStudyVideoListHolder(LayoutInflater.from(this.activity).inflate(R.layout.no_data_found, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.noData.equalsIgnoreCase("0") ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (this.noData.equalsIgnoreCase("0")) {
            ((SingleStudyVideoListHolder) holder).setData(this.examPrepItem.getList(), position);
        } else {
            ((SingleStudyVideoListHolder) holder).setData();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        try {
            if (this.examPrepItem.getList().size() > 0) {
                this.noData = "0";
                return this.examPrepItem.getList().size();
            }
            this.noData = "1";
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void sendlist(ExamPrepItem examPrepItem) {
        this.examPrepItem = examPrepItem;
        notifyDataSetChanged();
    }

    public class SingleStudyVideoListHolder extends RecyclerView.ViewHolder {
        TextView count;
        ImageView courseImage;
        ImageView forward;
        CardView ibt_single_sub_vd_RL;
        ImageView liveIV;
        RelativeLayout lockRL;
        TextView no_data;
        RelativeLayout no_data_found_RL;
        RelativeLayout rlThumb;
        LinearLayout study_single_itemLL;
        TextView title;

        public SingleStudyVideoListHolder(View itemView) {
            super(itemView);
            this.no_data = (TextView) itemView.findViewById(R.id.no_data);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.rlThumb = (RelativeLayout) itemView.findViewById(R.id.rlThumb);
            this.courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.forward = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.title = (TextView) itemView.findViewById(R.id.study_item_titleTV);
            this.count = (TextView) itemView.findViewById(R.id.count);
            this.study_single_itemLL = (LinearLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            ImageView imageView = this.forward;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data.setVisibility(8);
                if ("1".equalsIgnoreCase("5")) {
                    if (((CourseActivity) ExamPrepLayer1Adapter.this.activity).contentType.contains("video") && list.get(position).getIs_live() != null && list.get(position).getIs_live().equals("1")) {
                        this.liveIV.setVisibility(0);
                    } else {
                        this.liveIV.setVisibility(8);
                    }
                } else {
                    setThumbRatio(this.rlThumb);
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("Anymiix")) {
                        this.liveIV.setVisibility(8);
                    } else if (((CourseActivity) ExamPrepLayer1Adapter.this.activity).contentType.contains("video")) {
                        if (list.get(position).getIs_live() != null && list.get(position).getIs_live().equals("1")) {
                            this.liveIV.setVisibility(0);
                        } else {
                            this.liveIV.setVisibility(8);
                        }
                    } else if (((CourseActivity) ExamPrepLayer1Adapter.this.activity).contentType.contains("content") && list.get(position).getIs_live() != null && list.get(position).getIs_live().equals("1")) {
                        this.liveIV.setVisibility(0);
                    } else {
                        this.liveIV.setVisibility(8);
                    }
                }
                if ("1".equalsIgnoreCase("7")) {
                    this.count.setVisibility(8);
                    this.count.setText(list.get(position).getCount() + " " + ExamPrepLayer1Adapter.this.tileTypeAPI);
                } else {
                    this.count.setVisibility(8);
                }
                if (!TextUtils.isEmpty(list.get(position).getImage_icon())) {
                    setThumbAccordingRatio(list.get(position).getImage_icon(), this.courseImage);
                } else if (ExamPrepLayer1Adapter.this.bottomSetting != null && ExamPrepLayer1Adapter.this.bottomSetting.getLayout_type() != null && ExamPrepLayer1Adapter.this.bottomSetting.getLayout_type().equals("1")) {
                    this.courseImage.setImageResource(R.mipmap.square_placeholder);
                } else {
                    this.courseImage.setImageResource(R.mipmap.square_placeholder_new);
                }
                this.title.setText(list.get(position).getTitle());
                if (!TextUtils.isEmpty(list.get(position).getC_code())) {
                    this.title.setTextColor(Color.parseColor(list.get(position).getC_code()));
                }
                if (TextUtils.isEmpty(list.get(position).getIs_locked())) {
                    list.get(position).setIs_locked("0");
                }
                if (ExamPrepLayer1Adapter.this.singleStudy != null && ExamPrepLayer1Adapter.this.singleStudy.getData().getCourseDetail() != null && ExamPrepLayer1Adapter.this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(position).setIs_locked("0");
                }
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                this.ibt_single_sub_vd_RL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer1Adapter$SingleStudyVideoListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(list, position, view);
                    }
                });
                return;
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(ArrayList arrayList, int i, View view) {
            if (((Lists) arrayList.get(i)).getIs_locked().equalsIgnoreCase("1")) {
                if (ExamPrepLayer1Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer1Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(ExamPrepLayer1Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer1Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer1Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer1Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                ExamPrepLayer1Adapter.this.activity.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(ExamPrepLayer1Adapter.this.activity, (Class<?>) CourseActivity.class);
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(ExamPrepLayer1Adapter.this.singleStudy != null ? ExamPrepLayer1Adapter.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(ExamPrepLayer1Adapter.this.examPrepItem != null ? ExamPrepLayer1Adapter.this.examPrepItem : new ExamPrepItem()));
            SharedPreference.getInstance().putString("list", new Gson().toJson(ExamPrepLayer1Adapter.this.examPrepItem.getList().get(i) != null ? ExamPrepLayer1Adapter.this.examPrepItem.getList().get(i) : new Lists()));
            intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
            intent2.putExtra(Const.IS_COMBO, ExamPrepLayer1Adapter.this.isCombo);
            intent2.putExtra(Const.LIST_SUBJECT, ExamPrepLayer1Adapter.this.lists);
            intent2.putExtra(Const.TAB_TILE_VISIBILITY, ExamPrepLayer1Adapter.this.tabTileVisibility);
            intent2.putExtra("title", ((CourseActivity) ExamPrepLayer1Adapter.this.activity).lists.getTitle());
            intent2.putExtra("content_type", ((CourseActivity) ExamPrepLayer1Adapter.this.activity).contentType);
            intent2.putExtra(Const.TEST_TYPE, ExamPrepLayer1Adapter.this.examPrepItem.getList().get(i).getCount());
            intent2.putExtra("tile_id", ExamPrepLayer1Adapter.this.tileIdAPI);
            intent2.putExtra(Const.TILE_TYPE, ExamPrepLayer1Adapter.this.tileTypeAPI);
            intent2.putExtra(Const.REVERT_API, ExamPrepLayer1Adapter.this.revertAPI);
            intent2.putExtra("serach_title", ((Lists) arrayList.get(i)).getTitle());
            ExamPrepLayer1Adapter.this.activity.startActivity(intent2);
        }

        private void setThumbRatio(RelativeLayout rlThum) {
            Display defaultDisplay = ((WindowManager) ExamPrepLayer1Adapter.this.activity.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            ViewGroup.LayoutParams layoutParams = rlThum.getLayoutParams();
            if (ExamPrepLayer1Adapter.this.bottomSetting == null || ExamPrepLayer1Adapter.this.bottomSetting.getLayout_type() == null || !ExamPrepLayer1Adapter.this.bottomSetting.getLayout_type().equals("1")) {
                return;
            }
            layoutParams.height = (int) (Helper.grideHeight * displayMetrics.scaledDensity);
            layoutParams.width = (int) (Helper.grideWidth * displayMetrics.scaledDensity);
            rlThum.setLayoutParams(layoutParams);
        }

        private void setThumbAccordingRatio(String url, ImageView thumb) {
            if (ExamPrepLayer1Adapter.this.bottomSetting != null && ExamPrepLayer1Adapter.this.bottomSetting.getLayout_type() != null && ExamPrepLayer1Adapter.this.bottomSetting.getLayout_type().equals("1")) {
                Helper.setThumbnailImage(ExamPrepLayer1Adapter.this.activity, url, ExamPrepLayer1Adapter.this.activity.getDrawable(R.mipmap.square_placeholder), thumb);
            } else {
                Helper.setThumbnailImage(ExamPrepLayer1Adapter.this.activity, url, ExamPrepLayer1Adapter.this.activity.getDrawable(R.mipmap.square_placeholder_new), thumb);
            }
        }

        public void setData() {
            this.no_data_found_RL.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCourseSoldOut() {
        try {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail == null || courseDetail.getData().getCourseDetail() == null || this.singleStudy.getData().getCourseDetail().getExtra_json() == null || this.singleStudy.getData().getCourseDetail().getExtra_json().getSold_out() == null) {
                return false;
            }
            return this.singleStudy.getData().getCourseDetail().getExtra_json().getSold_out().equalsIgnoreCase("1");
        } catch (Exception unused) {
            return false;
        }
    }

    private void handleLiveVideo(ImageView liveIv, Lists video) {
        if (video.getIs_live() != null) {
            if (video.getIs_live().equals("1")) {
                liveIv.setVisibility(0);
                return;
            } else {
                liveIv.setVisibility(8);
                return;
            }
        }
        liveIv.setVisibility(8);
    }
}
