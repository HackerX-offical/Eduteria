package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.SingleStudyAdapter;
import com.appnew.android.Courses.overview.adapter.OverviewRVAdapter;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.FAQs.FaqData;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Overview.OverviewData;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.testmodule.activity.ViewSolutionActivity;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class ShowAllClassesMainCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    SingleStudyAdapter.onButtonClicked buttonClicked;
    public String contentType;
    ArrayList<Courselist> courseDataArrayList;
    CourseDetail courseDetail;
    ExamPrepItem examPrepItem;
    ArrayList<FaqData> faqData;
    private String first_attempt;
    String isSkip;
    int lang;
    OverviewData overviewData;
    String parentCourseId;
    int position_delete;
    private String quiz_id;
    private String quiz_name;
    String revertAPI;
    ThemeSettings themeSettings;
    String tileIdAPI;
    TileTitleClick tileTitleClick;
    String tileTypeAPI;
    List<TilesItem> tilesItem;
    private String totalQuestion;
    private Lists videodata;
    int viewType;
    boolean isCombo = false;
    Boolean isLodded = true;
    int tilePos = 0;
    String is_purchase = "";
    public UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
    private String result_date = "";
    private String submission_type = "";

    public interface TileTitleClick {
        void onTileTitleClicked(List<TilesItem> tiles, String isPurchased, String tile_id);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public ShowAllClassesMainCategoryAdapter(Activity activity, List<TilesItem> tilesItem, CourseDetail courseDetail, ExamPrepItem examPrepItem, int viewType) {
        this.courseDetail = courseDetail;
        this.activity = activity;
        this.tilesItem = tilesItem;
        this.examPrepItem = examPrepItem;
        this.viewType = viewType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new SingleStudyHeaderHolder(LayoutInflater.from(this.activity).inflate(R.layout.single_word_cat, (ViewGroup) null));
        }
        if (viewType == 2) {
            return new OverViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.single_card_layout, (ViewGroup) null));
        }
        return new SingleStudyHeaderHolder(LayoutInflater.from(this.activity).inflate(R.layout.single_word_cat, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 1) {
            ((SingleStudyHeaderHolder) holder).setDataHeader(this.tilesItem, position);
        } else if (getItemViewType(position) == 2) {
            ((OverViewHolder) holder).setData(this.courseDetail.getData().getCourseDetail(), this.overviewData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.tilesItem.size();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
        encryptionData.setCoupon_applied("0");
        encryptionData.setParent_id(this.parentCourseId);
        return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            try {
                if (jsonobject.optString("status").equals("true")) {
                    this.utkashRoom.getCourseDetaildata().deletecoursedetail(this.courseDetail.getData().getCourseDetail().getId(), MakeMyExam.userId);
                    Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                    Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, !this.parentCourseId.equalsIgnoreCase("") ? this.parentCourseId : this.courseDetail.getData().getCourseDetail().getId());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, this.courseDetail.getData().getCourseDetail().getTitle());
                    Helper.gotoActivity_finish(intent, this.activity);
                    return;
                }
                Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                RetrofitResponse.GetApiData(this.activity, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void initButton(CourseDetailData course, RelativeLayout buttonLow, Button buyNowBtn, TextView mrpCutTV, LinearLayout priceLL, Button myLibBtn, TextView price, int position) {
        if (!this.isCombo) {
            if (course.getIsPurchased().equalsIgnoreCase("1")) {
                buttonLow.setVisibility(8);
                return;
            }
            buttonLow.setVisibility(0);
            int i = (int) (Float.parseFloat(course.getMrp()) + Float.parseFloat(course.getTax()));
            if (i == 0) {
                buyNowBtn.setVisibility(8);
                mrpCutTV.setVisibility(8);
                priceLL.setVisibility(8);
                myLibBtn.setVisibility(0);
                return;
            }
            buyNowBtn.setVisibility(0);
            priceLL.setVisibility(0);
            myLibBtn.setVisibility(8);
            price.setText(String.format("%s %s %s", Constants.currencyType, "" + i, "/-"));
            if (Integer.parseInt(course.getCourseSp()) > 0) {
                mrpCutTV.setText(String.format("%s %s %s", Constants.currencyType, course.getCourseSp().trim(), "/-"), TextView.BufferType.SPANNABLE);
                StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                Spannable spannable = (Spannable) mrpCutTV.getText();
                if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                    mrpCutTV.setVisibility(0);
                } else {
                    mrpCutTV.setVisibility(8);
                }
                spannable.setSpan(strikethroughSpan, 2, new String(course.getCourseSp()).length() + 2, 33);
                return;
            }
            mrpCutTV.setVisibility(8);
            return;
        }
        buttonLow.setVisibility(8);
    }

    public class OverViewHolder extends RecyclerView.ViewHolder {
        Button backBtn;
        RelativeLayout no_data_found_RL;
        RecyclerView recyclerView;

        OverViewHolder(View itemView) {
            super(itemView);
            this.recyclerView = (RecyclerView) itemView.findViewById(R.id.overviewRV);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
        }

        public void setData(CourseDetailData basic, OverviewData overview) {
            boolean z;
            boolean z2;
            if (overview != null) {
                this.recyclerView.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (ShowAllClassesMainCategoryAdapter.this.isLodded.booleanValue()) {
                    if (overview.getData().getVisibility().equalsIgnoreCase("1")) {
                        z = false;
                        z2 = false;
                    } else if (overview.getData().getVisibility().equalsIgnoreCase("2")) {
                        z2 = false;
                        z = true;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    OverviewRVAdapter overviewRVAdapter = new OverviewRVAdapter(ShowAllClassesMainCategoryAdapter.this.activity, basic, overview, this.recyclerView, z, z2);
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(ShowAllClassesMainCategoryAdapter.this.activity, 1, false));
                    this.recyclerView.setAdapter(overviewRVAdapter);
                    ShowAllClassesMainCategoryAdapter.this.isLodded = false;
                    return;
                }
                return;
            }
            this.recyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ShowAllClassesMainCategoryAdapter.OverViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ShowAllClassesMainCategoryAdapter.this.activity.finish();
                }
            });
        }
    }

    public class SingleStudyHeaderHolder extends RecyclerView.ViewHolder {
        TextView header;

        public SingleStudyHeaderHolder(View itemView) {
            super(itemView);
            this.header = (TextView) itemView.findViewById(R.id.headerName);
        }

        public void setDataHeader(final List<TilesItem> tilesItem, final int pos) {
            this.header.setText(tilesItem.get(pos).getTileName());
            this.header.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ShowAllClassesMainCategoryAdapter.SingleStudyHeaderHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ShowAllClassesMainCategoryAdapter.this.tileTitleClick.onTileTitleClicked(ShowAllClassesMainCategoryAdapter.this.courseDetail.getData().getTiles(), ShowAllClassesMainCategoryAdapter.this.courseDetail.getData().getCourseDetail().getIsPurchased(), ((TilesItem) tilesItem.get(pos)).getId());
                }
            });
        }

        public class TileItemsAdapter extends RecyclerView.Adapter<MyViewHolder> {
            private List<TilesItem> cards;
            private Context context;

            public TileItemsAdapter(Context context, ArrayList<TilesItem> cards) {
                this.cards = cards;
                this.context = context;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new MyViewHolder(LayoutInflater.from(ShowAllClassesMainCategoryAdapter.this.activity).inflate(R.layout.tile_view_new, (ViewGroup) null));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(final MyViewHolder holder, final int position) {
                if (this.cards.get(position).getType().equalsIgnoreCase(Const.OVERVIEW)) {
                    holder.background_ll.setVisibility(8);
                }
                if (this.cards.get(position).getType().equalsIgnoreCase("video")) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.ic_video_lectures);
                }
                if (this.cards.get(position).getType().equalsIgnoreCase(Const.PDF)) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.ic_pdf);
                }
                if (this.cards.get(position).getType().equalsIgnoreCase(Const.COMBO)) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.ic_test);
                }
                if (this.cards.get(position).getType().equalsIgnoreCase(Const.TEST)) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.ic_test);
                }
                if (this.cards.get(position).getType().equalsIgnoreCase(Const.FAQ)) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.ic_faq);
                }
                if (this.cards.get(position).getType().equalsIgnoreCase(Const.SUBJECTIVE_TEST)) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.ic_test);
                }
                final TilesItem tilesItem = this.cards.get(position);
                int i = position % 4;
                if (i == 0) {
                    holder.background_ll.setBackgroundResource(R.drawable.tiles_round_corner_bg_blue);
                } else if (i == 1) {
                    holder.background_ll.setBackgroundResource(R.drawable.tiles_round_corner_bg_green);
                } else if (i == 2) {
                    holder.background_ll.setBackgroundResource(R.drawable.tiles_round_corner_bg_red);
                } else if (i == 3) {
                    holder.background_ll.setBackgroundResource(R.drawable.tiles_round_corner_bg_black);
                } else {
                    holder.background_ll.setBackgroundResource(R.drawable.tiles_round_corner_bg_blue);
                }
                holder.tile_title.setText(this.cards.get(position).getTileName());
                holder.background_ll.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ShowAllClassesMainCategoryAdapter.SingleStudyHeaderHolder.TileItemsAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        ShowAllClassesMainCategoryAdapter.this.contentType = tilesItem.getType() + tilesItem.getId();
                        ShowAllClassesMainCategoryAdapter.this.tilePos = position;
                        ShowAllClassesMainCategoryAdapter.this.buttonClicked.onTitleClicked(tilesItem, ShowAllClassesMainCategoryAdapter.this.courseDetail.getData().getTiles(), ShowAllClassesMainCategoryAdapter.this.tilePos);
                    }
                });
            }

            public class MyViewHolder extends RecyclerView.ViewHolder {
                public RelativeLayout background_ll;
                public TextView batch_name_txt;
                TextView description_text;
                public ImageView tile_img;
                public TextView tile_title;

                public MyViewHolder(View view) {
                    super(view);
                    this.background_ll = (RelativeLayout) view.findViewById(R.id.background_ll);
                    this.tile_img = (ImageView) view.findViewById(R.id.tile_img);
                    this.tile_title = (TextView) view.findViewById(R.id.tile_title);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.cards.size();
            }
        }
    }

    public class SingleStudyTestListHolder extends RecyclerView.ViewHolder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        LinearLayout attemptLL;
        Button backBtn;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        TextView learn;
        LeftMenu leftMenu;
        RelativeLayout lockRL;
        RelativeLayout no_data_found_RL;
        RelativeLayout parentLL;
        TextView practice;
        ImageView share;
        TextView startdate;
        RelativeLayout studyitemLL;
        TextView subItemRV;
        TextView titleCategory;

        public SingleStudyTestListHolder(View itemView) {
            super(itemView);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.subItemRV = (TextView) itemView.findViewById(R.id.subItemRV);
            this.startdate = (TextView) itemView.findViewById(R.id.startdate);
            this.attemptLL = (LinearLayout) itemView.findViewById(R.id.attemptLL);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
            this.learn = (TextView) itemView.findViewById(R.id.learn);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.practice = (TextView) itemView.findViewById(R.id.practice);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            this.leftMenu = (LeftMenu) new Gson().fromJson(ShowAllClassesMainCategoryAdapter.this.themeSettings.getLeft_menu(), LeftMenu.class);
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (TextUtils.isEmpty(list.get(position).getIs_locked())) {
                    list.get(position).setIs_locked("0");
                }
                if (ShowAllClassesMainCategoryAdapter.this.courseDetail != null && ShowAllClassesMainCategoryAdapter.this.courseDetail.getData().getCourseDetail() != null && ShowAllClassesMainCategoryAdapter.this.courseDetail.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(position).setIs_locked("0");
                }
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                this.share.setVisibility(8);
                this.subItemRV.setVisibility(0);
                this.attemptLL.setVisibility(8);
                this.learn.setVisibility(8);
                this.practice.setVisibility(8);
                if (!TextUtils.isEmpty(list.get(position).getImage_icon())) {
                    Helper.setThumbnailImage(ShowAllClassesMainCategoryAdapter.this.activity, list.get(position).getImage_icon(), ShowAllClassesMainCategoryAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                }
                this.subItemRV.setVisibility(8);
                this.subItemRV.setText("Total : " + list.get(position).getCount());
                this.titleCategory.setText(list.get(position).getTitle());
                this.studyitemLL.setEnabled(true);
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ShowAllClassesMainCategoryAdapter.SingleStudyTestListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (((Lists) list.get(position)).getIs_locked().equalsIgnoreCase("1")) {
                            if (ShowAllClassesMainCategoryAdapter.this.isCourseSoldOut()) {
                                Toast.makeText(ShowAllClassesMainCategoryAdapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(ShowAllClassesMainCategoryAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, ShowAllClassesMainCategoryAdapter.this.courseDetail);
                            Helper.gotoActivity(intent, ShowAllClassesMainCategoryAdapter.this.activity);
                        }
                    }
                });
                return;
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ShowAllClassesMainCategoryAdapter.SingleStudyTestListHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ShowAllClassesMainCategoryAdapter.this.activity.finish();
                }
            });
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(ShowAllClassesMainCategoryAdapter.this.activity)) {
                final Progress progress = new Progress(ShowAllClassesMainCategoryAdapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.ShowAllClassesMainCategoryAdapter.SingleStudyTestListHolder.3
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        JSONObject jSONObject;
                        progress.dismiss();
                        if (response.body() != null) {
                            ResultTestSeries_Report resultTestSeries_Report = null;
                            try {
                                jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                                try {
                                    resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(jSONObject.toString(), ResultTestSeries_Report.class);
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                jSONObject = null;
                            }
                            if (resultTestSeries_Report == null) {
                                Helper.showToastSecurity(ShowAllClassesMainCategoryAdapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(ShowAllClassesMainCategoryAdapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            ShowAllClassesMainCategoryAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        ShowAllClassesMainCategoryAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, ShowAllClassesMainCategoryAdapter.this.lang);
                                    Helper.gotoActivity(intent, ShowAllClassesMainCategoryAdapter.this.activity);
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(ShowAllClassesMainCategoryAdapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        progress.dismiss();
                    }
                });
                return;
            }
            Toast.makeText(ShowAllClassesMainCategoryAdapter.this.activity, R.string.Retry_with_Internet_connection, 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(ShowAllClassesMainCategoryAdapter.this.activity)) {
                final Progress progress = new Progress(ShowAllClassesMainCategoryAdapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.ShowAllClassesMainCategoryAdapter.SingleStudyTestListHolder.4
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        JSONObject jSONObject;
                        progress.dismiss();
                        if (response.body() != null) {
                            ResultTestSeries_Report resultTestSeries_Report = null;
                            try {
                                jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                                try {
                                    resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(jSONObject.toString(), ResultTestSeries_Report.class);
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                jSONObject = null;
                            }
                            if (resultTestSeries_Report == null) {
                                Helper.showToastSecurity(ShowAllClassesMainCategoryAdapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                        Intent intent = new Intent(ShowAllClassesMainCategoryAdapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                        intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                        intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                        intent.putExtra("name", quiz_name);
                                        intent.putExtra("type", "learn");
                                        if (!resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                            if (resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                                ShowAllClassesMainCategoryAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                            }
                                        } else {
                                            ShowAllClassesMainCategoryAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                        }
                                        intent.putExtra(Const.LANG, ShowAllClassesMainCategoryAdapter.this.lang);
                                        Helper.gotoActivity(intent, ShowAllClassesMainCategoryAdapter.this.activity);
                                        return;
                                    }
                                    Toast.makeText(ShowAllClassesMainCategoryAdapter.this.activity, "No Question Found", 0).show();
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(ShowAllClassesMainCategoryAdapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        progress.dismiss();
                    }
                });
                return;
            }
            Toast.makeText(ShowAllClassesMainCategoryAdapter.this.activity, R.string.Retry_with_Internet_connection, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCourseSoldOut() {
        try {
            CourseDetail courseDetail = this.courseDetail;
            if (courseDetail == null || courseDetail.getData().getCourseDetail() == null || this.courseDetail.getData().getCourseDetail().getExtra_json() == null || this.courseDetail.getData().getCourseDetail().getExtra_json().getSold_out() == null) {
                return false;
            }
            return this.courseDetail.getData().getCourseDetail().getExtra_json().getSold_out().equalsIgnoreCase("1");
        } catch (Exception unused) {
            return false;
        }
    }
}
