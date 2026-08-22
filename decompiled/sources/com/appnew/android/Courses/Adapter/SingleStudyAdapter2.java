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
import com.appnew.android.Model.Overview.OverviewData;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class SingleStudyAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    SingleStudyAdapter.onButtonClicked buttonClicked;
    public String contentType;
    ArrayList<Courselist> courseDataArrayList;
    ExamPrepItem examPrepItem;
    ArrayList<FaqData> faqData;
    private String first_attempt;
    boolean isCombo;
    String isSkip;
    String is_purchase;
    int lang;
    OverviewData overviewData;
    String parentCourseId;
    int position_delete;
    private String quiz_id;
    private String quiz_name;
    String revertAPI;
    CourseDetail singleStudy;
    String tileIdAPI;
    int tilePos;
    String tileTypeAPI;
    private String totalQuestion;
    private Lists videodata;
    Boolean isLodded = true;
    public UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
    private String result_date = "";
    private String submission_type = "";

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }

    public SingleStudyAdapter2(Activity activity, CourseDetail singleStudy, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, SingleStudyAdapter.onButtonClicked buttonClicked, String parentCourseId, boolean isCombo, String isSkip, int tilePos, String tileIdAPI, String tileTypeAPI, String revertAPI) {
        this.isCombo = false;
        this.tilePos = 0;
        this.is_purchase = "";
        this.singleStudy = singleStudy;
        this.activity = activity;
        this.examPrepItem = examPrepItem;
        this.overviewData = overviewData;
        this.buttonClicked = buttonClicked;
        this.courseDataArrayList = courseDataArrayList;
        this.faqData = faqData;
        this.parentCourseId = parentCourseId;
        this.isCombo = isCombo;
        this.isSkip = isSkip;
        this.tilePos = tilePos;
        this.tileTypeAPI = tileTypeAPI;
        this.tileIdAPI = tileIdAPI;
        this.revertAPI = revertAPI;
        this.is_purchase = singleStudy.getData().getCourseDetail().getIsPurchased();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new SingleStudyHeaderHolder(LayoutInflater.from(this.activity).inflate(R.layout.coursedetail_buy_layout, parent, false));
        }
        return new OverViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.course_overview_layout, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            ((SingleStudyHeaderHolder) holder).setDataHeader(this.singleStudy);
        } else if (getItemViewType(position) == 3) {
            ((OverViewHolder) holder).setData(this.singleStudy.getData().getCourseDetail(), this.overviewData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        this.contentType.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI);
        return 3;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(this.singleStudy.getData().getCourseDetail().getId());
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
                    this.utkashRoom.getCourseDetaildata().deletecoursedetail(this.singleStudy.getData().getCourseDetail().getId(), MakeMyExam.userId);
                    Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                    Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, !this.parentCourseId.equalsIgnoreCase("") ? this.parentCourseId : this.singleStudy.getData().getCourseDetail().getId());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, this.singleStudy.getData().getCourseDetail().getTitle());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initButton(CourseDetailData course, RelativeLayout buttonLow, Button buyNowBtn, TextView mrpCutTV, LinearLayout priceLL, Button myLibBtn, TextView price, int position) {
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
                if (SingleStudyAdapter2.this.isLodded.booleanValue()) {
                    if (overview.getData() != null && overview.getData().getVisibility().equalsIgnoreCase("1")) {
                        z = false;
                        z2 = false;
                    } else if (overview.getData() == null || !overview.getData().getVisibility().equalsIgnoreCase("2")) {
                        z = false;
                        z2 = true;
                    } else {
                        z2 = false;
                        z = true;
                    }
                    OverviewRVAdapter overviewRVAdapter = new OverviewRVAdapter(SingleStudyAdapter2.this.activity, basic, overview, this.recyclerView, z, z2);
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter2.this.activity, 1, false));
                    this.recyclerView.setAdapter(overviewRVAdapter);
                    SingleStudyAdapter2.this.isLodded = false;
                    return;
                }
                return;
            }
            this.recyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter2.OverViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter2.this.activity.finish();
                }
            });
        }
    }

    public class SingleStudyHeaderHolder extends RecyclerView.ViewHolder {
        TextView basic_program_txt;
        TextView batch_name_txt;
        RelativeLayout buttonLow;
        Button buyNowBtn;
        RoundedImageView header_banner;
        TextView meduium_txt;
        TextView mrpCutTV;
        Button myLibBtn;
        public LinearLayout parent;
        TextView price;
        LinearLayout priceLL;
        RelativeLayout rl_buy;
        TileItemsAdapter tileItemsAdapter;
        RecyclerView tileRv;

        public SingleStudyHeaderHolder(View itemView) {
            super(itemView);
            this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
            this.price = (TextView) itemView.findViewById(R.id.priceTV);
            this.buyNowBtn = (Button) itemView.findViewById(R.id.buyNowBtn);
            this.myLibBtn = (Button) itemView.findViewById(R.id.myLibBtn);
            this.buttonLow = (RelativeLayout) itemView.findViewById(R.id.buttonLow);
            this.priceLL = (LinearLayout) itemView.findViewById(R.id.priceLL);
            this.buyNowBtn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : SingleStudyAdapter2.this.activity.getResources().getString(R.string.buy_now));
            this.rl_buy = (RelativeLayout) itemView.findViewById(R.id.rl_buy);
            this.parent = (LinearLayout) itemView.findViewById(R.id.parentBottom);
            this.basic_program_txt = (TextView) itemView.findViewById(R.id.basic_program_txt);
            this.batch_name_txt = (TextView) itemView.findViewById(R.id.batch_name_txt);
            this.meduium_txt = (TextView) itemView.findViewById(R.id.meduium_txt);
            this.header_banner = (RoundedImageView) itemView.findViewById(R.id.header_banner);
            this.tileRv = (RecyclerView) itemView.findViewById(R.id.tileRv);
        }

        public void setDataHeader(final CourseDetail singleStudy) {
            CourseDetailData courseDetail = singleStudy.getData().getCourseDetail();
            if (courseDetail.getSkip_payment() != null && courseDetail.getSkip_payment().equalsIgnoreCase("1")) {
                this.rl_buy.setVisibility(8);
            } else {
                this.rl_buy.setVisibility(0);
            }
            if (singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                if (!TextUtils.isEmpty(singleStudy.getData().getCourseDetail().getDescHeaderImage())) {
                    Helper.setThumbnailImage(SingleStudyAdapter2.this.activity, singleStudy.getData().getCourseDetail().getDescHeaderImage(), SingleStudyAdapter2.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.header_banner);
                } else {
                    this.header_banner.setImageResource(R.mipmap.square_placeholder);
                }
            } else {
                if (!TextUtils.isEmpty(singleStudy.getData().getCourseDetail().getDescHeaderImage())) {
                    Helper.setThumbnailImage(SingleStudyAdapter2.this.activity, singleStudy.getData().getCourseDetail().getDescHeaderImage(), SingleStudyAdapter2.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.header_banner);
                } else {
                    this.header_banner.setImageResource(R.mipmap.square_placeholder);
                }
                if (singleStudy.getData().getCourseDetail() != null && ((GenericUtils.isEmpty(singleStudy.getData().getCourseDetail().getAuthor().getTitle()) || singleStudy.getData().getCourseDetail().getAuthor().getTitle().equalsIgnoreCase("Utkarsh classes")) && !singleStudy.getData().getCourseDetail().getValidity().equals("") && !singleStudy.getData().getCourseDetail().getValidity().equals("0") && !singleStudy.getData().getCourseDetail().getValidity().equalsIgnoreCase("0 Days") && !singleStudy.getData().getCourseDetail().getValidity().equals("-1"))) {
                    singleStudy.getData().getCourseDetail().getValidity().equalsIgnoreCase("-1 Days");
                }
            }
            ArrayList arrayList = new ArrayList();
            if (singleStudy.getData().getTiles() != null) {
                for (TilesItem tilesItem : singleStudy.getData().getTiles()) {
                    if (!tilesItem.getTileName().equalsIgnoreCase("Content")) {
                        arrayList.add(tilesItem);
                    }
                }
            }
            this.tileItemsAdapter = new TileItemsAdapter(SingleStudyAdapter2.this.activity, arrayList);
            this.tileRv.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter2.this.activity, 1, false));
            this.tileRv.setAdapter(this.tileItemsAdapter);
            SingleStudyAdapter2.this.initButton(singleStudy.getData().getCourseDetail(), this.buttonLow, this.buyNowBtn, this.mrpCutTV, this.priceLL, this.myLibBtn, this.price, getAbsoluteAdapterPosition());
            this.batch_name_txt.setText(singleStudy.getData().getCourseDetail().getTitle());
            this.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter2$SingleStudyHeaderHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setDataHeader$0(singleStudy, view);
                }
            });
            this.myLibBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter2$SingleStudyHeaderHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setDataHeader$1(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setDataHeader$0(CourseDetail courseDetail, View view) {
            if (SingleStudyAdapter2.this.isCourseSoldOut()) {
                Toast.makeText(SingleStudyAdapter2.this.activity, R.string.sold_out_msg, 0).show();
                return;
            }
            Intent intent = new Intent(SingleStudyAdapter2.this.activity, (Class<?>) PurchaseActivity.class);
            intent.putExtra(Const.SINGLE_STUDY, courseDetail);
            Helper.gotoActivity(intent, SingleStudyAdapter2.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setDataHeader$1(View view) {
            SingleStudyAdapter2 singleStudyAdapter2 = SingleStudyAdapter2.this;
            new NetworkCall(singleStudyAdapter2, singleStudyAdapter2.activity).NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false);
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
                return new MyViewHolder(LayoutInflater.from(SingleStudyAdapter2.this.activity).inflate(R.layout.tile_view_new, (ViewGroup) null));
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
                if (this.cards.get(position).getType().equalsIgnoreCase(Const.Daily_assignment)) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.daily_assignments);
                }
                if (this.cards.get(position).getType().equalsIgnoreCase("image")) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.ic_image);
                }
                if (this.cards.get(position).getType().equalsIgnoreCase("link")) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.ic_link);
                }
                if (this.cards.get(position).getType().equalsIgnoreCase(Const.CONCEPT)) {
                    holder.background_ll.setVisibility(0);
                    holder.tile_img.setImageResource(com.appnew.android.R.drawable.ic_note);
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
                holder.background_ll.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter2.SingleStudyHeaderHolder.TileItemsAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (!tilesItem.getType().equalsIgnoreCase(Const.FOLDER)) {
                            SingleStudyAdapter2.this.contentType = tilesItem.getType() + tilesItem.getId();
                        }
                        SingleStudyAdapter2.this.contentType = tilesItem.getType() + tilesItem.getId();
                        SingleStudyAdapter2.this.tilePos = position;
                        SingleStudyAdapter2.this.buttonClicked.onTitleClicked(tilesItem, SingleStudyAdapter2.this.singleStudy.getData().getTiles(), SingleStudyAdapter2.this.tilePos);
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
}
