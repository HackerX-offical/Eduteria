package com.appnew.android.PurchaseHistory.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Interfaces.OnSuccessListner;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BillDesk;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Ccav;
import com.appnew.android.Model.EaseBuzz;
import com.appnew.android.Model.EasyPay;
import com.appnew.android.Model.FonePay;
import com.appnew.android.Model.Paytm;
import com.appnew.android.Model.PostFile;
import com.appnew.android.Model.PurchaseHistoryModel;
import com.appnew.android.Model.Rzp;
import com.appnew.android.Payment.Credentials;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.Payment.PreferencesUtil;
import com.appnew.android.PurchaseHistory.PurchaseHistory;
import com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PaymentTypeCheck;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.home.adapters.ExtendAdapter;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.razorpay.Checkout;
import com.tv9news.utils.helpers.AnalyticsConstants;
import datamodels.PWEStaticDataModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class PurchaseHistoryAdapter extends RecyclerView.Adapter<Livetestviewholder> implements NetworkCall.MyNetworkCallBack, OnSuccessListner, PaymentTypeCheck {
    public static String validty = "";
    static BottomSheetDialog watchlist;
    Activity activity;
    String amt;
    BottomSetting bottomSetting;
    PurchaseHistoryModel.Data course;
    private PurchaseHistoryModel.Data coursePaymentTime;
    ArrayList<PurchaseHistoryModel.Data> data;
    private ExtendAdapter extendAdapter;
    public OnSuccessListner onSuccessListner;
    private PaymentViewModel paymentViewModel;
    String rid;
    int server_time;
    ThemeSettings themeSettings;
    private String type;
    public UtkashRoom utkashRoom;
    private String price = "";
    private String id = "";
    private String post_txt = "";
    private String pre_transaction_id = "";
    private String txnToken = "";
    String enc_val = "";
    String scd = "";

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentTypeCancel() {
    }

    public PurchaseHistoryAdapter(Activity activity, ArrayList<PurchaseHistoryModel.Data> data, int server_time, PaymentViewModel paymentViewModel, String type) {
        this.type = "1";
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.activity = activity;
        this.data = data;
        this.onSuccessListner = this;
        this.server_time = server_time;
        this.paymentViewModel = paymentViewModel;
        this.type = type;
        ThemeSettings themeSettingsData = appDatabase.getthemeSettingdao().data();
        this.themeSettings = themeSettingsData;
        if (themeSettingsData != null) {
            this.themeSettings = this.utkashRoom.getthemeSettingdao().data();
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Livetestviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        if (this.type.equalsIgnoreCase("1")) {
            viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.purchase_history_adapter, parent, false);
        } else {
            viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_purchase_history_adapter, parent, false);
        }
        return new Livetestviewholder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final Livetestviewholder holder, final int position) {
        long j;
        int i;
        if (this.type.equalsIgnoreCase("1")) {
            setThumbRatio(holder.imageRL);
            if (this.data.get(position).getCat_type().equalsIgnoreCase("3") && BuildConfig.FLAVOR.equalsIgnoreCase("Narayana") && this.data.get(position).getTest_series_name() != null) {
                holder.title.setText(this.data.get(position).getTest_series_name());
            } else {
                holder.title.setText(this.data.get(position).getTitle());
            }
            holder.liveIV.setVisibility(8);
            boolean zIsEmpty = TextUtils.isEmpty(this.data.get(position).getDesc_header_image());
            int i2 = R.mipmap.square_placeholder;
            if (!zIsEmpty) {
                j = 1000;
                RequestBuilder<Drawable> requestBuilderLoad = Glide.with(this.activity.getApplicationContext()).load(this.data.get(holder.getAbsoluteAdapterPosition()).getDesc_header_image().replaceAll(" ", "%20"));
                RequestOptions requestOptionsPlaceholder = new RequestOptions().placeholder(setThumbAccordingRatio() ? R.mipmap.square_placeholder : R.mipmap.square_placeholder_new);
                if (!setThumbAccordingRatio()) {
                    i2 = R.mipmap.square_placeholder_new;
                }
                requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptionsPlaceholder.error(i2).diskCacheStrategy(DiskCacheStrategy.ALL)).into((ImageView) Objects.requireNonNull(holder.imageCourse));
            } else {
                j = 1000;
                if (!TextUtils.isEmpty(this.data.get(position).getCover_image())) {
                    Glide.with(this.activity.getApplicationContext()).load(this.data.get(holder.getAbsoluteAdapterPosition()).getCover_image().replaceAll(" ", "%20")).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.book_logo).error(R.drawable.book_logo).diskCacheStrategy(DiskCacheStrategy.ALL)).into((ImageView) Objects.requireNonNull(holder.courseImage));
                    RequestBuilder<Drawable> requestBuilderLoad2 = Glide.with(this.activity.getApplicationContext()).load(this.data.get(holder.getAbsoluteAdapterPosition()).getCover_image().replaceAll(" ", "%20"));
                    RequestOptions requestOptionsPlaceholder2 = new RequestOptions().placeholder(setThumbAccordingRatio() ? R.mipmap.square_placeholder : R.mipmap.square_placeholder_new);
                    if (!setThumbAccordingRatio()) {
                        i2 = R.mipmap.square_placeholder_new;
                    }
                    requestBuilderLoad2.apply((BaseRequestOptions<?>) requestOptionsPlaceholder2.error(i2).diskCacheStrategy(DiskCacheStrategy.ALL)).into((ImageView) Objects.requireNonNull(holder.imageCourse));
                } else {
                    holder.courseImage.setImageResource(R.drawable.book_logo);
                    ImageView imageView = holder.imageCourse;
                    if (!setThumbAccordingRatio()) {
                        i2 = R.mipmap.square_placeholder_new;
                    }
                    imageView.setImageResource(i2);
                }
            }
            if (this.data.get(position).getCat_type().equalsIgnoreCase("3") && BuildConfig.FLAVOR.equalsIgnoreCase("Narayana") && this.data.get(position).getTest_series_name() != null) {
                holder.txtTitle.setText(this.data.get(position).getTest_series_name());
            } else {
                holder.txtTitle.setText(this.data.get(position).getTitle());
            }
            holder.purchasedOnTxt.setText("Purchased On: " + Helper.getdate(Long.parseLong(String.valueOf(Long.parseLong(this.data.get(position).getPurchase_date()) * j))));
            if (this.data.get(holder.getAbsoluteAdapterPosition()).getCat_type() != null && this.data.get(holder.getAbsoluteAdapterPosition()).getCat_type().equalsIgnoreCase("1")) {
                holder.expiredLL.setVisibility(8);
                holder.transer_text.setVisibility(8);
            } else {
                holder.transer_text.setVisibility(0);
                holder.expiredLL.setVisibility(0);
            }
            holder.purchase_date.setText(TextUtils.isEmpty(this.data.get(holder.getAbsoluteAdapterPosition()).getPurchase_date()) ? "N/A" : "" + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy ").format(new Date(Long.parseLong(this.data.get(holder.getAbsoluteAdapterPosition()).getPurchase_date()) * j))));
            holder.expiry_date.setText(TextUtils.isEmpty(this.data.get(holder.getAbsoluteAdapterPosition()).getExpiry_date()) ? "N/A" : "" + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy ").format(new Date(Long.parseLong(this.data.get(holder.getAbsoluteAdapterPosition()).getExpiry_date()) * j))));
            holder.expiry_date.setTypeface(Typeface.DEFAULT_BOLD);
            holder.purchase_date.setTypeface(Typeface.DEFAULT_BOLD);
            holder.orderIdTxt.setText(TextUtils.isEmpty(this.data.get(holder.getAbsoluteAdapterPosition()).getTxn_id()) ? "N/A" : this.data.get(holder.getAbsoluteAdapterPosition()).getTxn_id());
            if (TextUtils.isEmpty(this.data.get(holder.getAbsoluteAdapterPosition()).getMrp()) || this.data.get(holder.getAbsoluteAdapterPosition()).getMrp().equalsIgnoreCase("0")) {
                holder.paidLabelTxt.setText(this.activity.getResources().getString(R.string.payment));
                holder.paidAmountTxt.setText(this.activity.getResources().getString(R.string.free_course));
            } else {
                holder.paidLabelTxt.setVisibility(0);
                holder.paidAmountTxt.setText(String.format("%s %s %s", Constants.currencyType, "" + this.data.get(holder.getAbsoluteAdapterPosition()).getMrp(), "/-"));
            }
            if (TextUtils.isEmpty(this.data.get(holder.getAbsoluteAdapterPosition()).getMrp()) || this.data.get(holder.getAbsoluteAdapterPosition()).getMrp().equalsIgnoreCase("0")) {
                holder.payment_layout.setVisibility(8);
            } else {
                holder.payment_layout.setVisibility(0);
                holder.paymentIdTxt.setText(TextUtils.isEmpty(this.data.get(holder.getAbsoluteAdapterPosition()).getPayment_id()) ? "N/A" : this.data.get(holder.getAbsoluteAdapterPosition()).getPayment_id());
            }
            if (!TextUtils.isEmpty(this.data.get(holder.getAbsoluteAdapterPosition()).getExpiry_date()) && this.server_time > Float.parseFloat(this.data.get(holder.getAbsoluteAdapterPosition()).getExpiry_date())) {
                if (this.data.get(holder.getAbsoluteAdapterPosition()).getCat_type() != null && this.data.get(holder.getAbsoluteAdapterPosition()).getCat_type().equalsIgnoreCase("1")) {
                    holder.transer_text.setVisibility(8);
                } else {
                    holder.transer_text.setVisibility(0);
                }
                holder.transer_text.setText(this.activity.getResources().getString(R.string.expired_));
                holder.extend_validy.setVisibility(8);
            } else if (!TextUtils.isEmpty(this.data.get(holder.getAbsoluteAdapterPosition()).getExpiry_date()) && Float.parseFloat(this.data.get(holder.getAbsoluteAdapterPosition()).getExpiry_date()) > Float.parseFloat(this.data.get(holder.getAbsoluteAdapterPosition()).getPurchase_date())) {
                int i3 = ((int) (Float.parseFloat(this.data.get(holder.getAbsoluteAdapterPosition()).getExpiry_date()) - Float.parseFloat(this.data.get(holder.getAbsoluteAdapterPosition()).getPurchase_date()))) / DateTimeConstants.SECONDS_PER_DAY;
                if (this.server_time >= Integer.parseInt(this.data.get(holder.getAbsoluteAdapterPosition()).getPurchase_date())) {
                    int i4 = (this.server_time - Integer.parseInt(this.data.get(holder.getAbsoluteAdapterPosition()).getPurchase_date())) / DateTimeConstants.SECONDS_PER_DAY;
                    if (this.data.get(holder.getAbsoluteAdapterPosition()).getTransaction_status().equalsIgnoreCase("1")) {
                        holder.transer_text.setVisibility(8);
                        if (this.data.get(holder.getAbsoluteAdapterPosition()).getPrices() != null && this.data.get(holder.getAbsoluteAdapterPosition()).getPrices().size() > 0 && i3 != 0) {
                            int i5 = (i4 * 100) / i3;
                            if (i5 < 80) {
                                holder.extend_validy.setBackground(this.activity.getResources().getDrawable(R.drawable.btn_back_with_ripple));
                            } else if (i5 > 80 && i5 < 90) {
                                holder.extend_validy.setBackground(this.activity.getResources().getDrawable(R.drawable.orange_extend));
                            } else {
                                holder.extend_validy.setBackground(this.activity.getResources().getDrawable(R.drawable.range_extend));
                            }
                            holder.extend_validy.setVisibility(0);
                        } else {
                            holder.extend_validy.setVisibility(8);
                        }
                    } else {
                        if (this.data.get(holder.getAbsoluteAdapterPosition()).getCat_type() != null && this.data.get(holder.getAbsoluteAdapterPosition()).getCat_type().equalsIgnoreCase("1")) {
                            i = 8;
                            holder.transer_text.setVisibility(8);
                        } else {
                            i = 8;
                            holder.transer_text.setVisibility(0);
                        }
                        holder.extend_validy.setVisibility(i);
                    }
                }
            }
            if (this.data.get(position).getPayment_mode() != null && this.data.get(position).getPayment_mode().equals("1")) {
                if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
                    holder.emiTxt.setVisibility(8);
                } else {
                    holder.emiTxt.setVisibility(0);
                }
                if (this.data.get(position).getEmi_no() != null && !TextUtils.isEmpty(this.data.get(position).getEmi_no())) {
                    holder.emiTxt.setText("EMI - " + this.data.get(position).getEmi_no());
                } else {
                    holder.emiTxt.setText(PWEStaticDataModel.EMI_DISPLAY_NAME);
                }
            } else {
                holder.emiTxt.setVisibility(8);
            }
            if (this.data.get(holder.getAbsoluteAdapterPosition()).getInvoice_url() == null || this.data.get(holder.getAbsoluteAdapterPosition()).getInvoice_url().equalsIgnoreCase("")) {
                holder.more.setVisibility(8);
            } else {
                holder.more.setVisibility(0);
            }
            holder.more.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PurchaseHistory.adapter.PurchaseHistoryAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(holder, view);
                }
            });
            holder.extend_validy.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PurchaseHistory.adapter.PurchaseHistoryAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(holder, view);
                }
            });
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PurchaseHistory.adapter.PurchaseHistoryAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(position, view);
                }
            });
            return;
        }
        try {
            setThumbRatio(holder.imageRL);
            holder.txtTitle.setText(this.data.get(position).getBook_title());
            holder.purchasedOnTxt.setText("Purchased On: " + Helper.getdate(Long.parseLong(String.valueOf(Long.parseLong(this.data.get(position).getCreated()) * 1000))));
            holder.purchasedQuantityTxt.setText("Quantity: " + this.data.get(position).getQty());
            holder.purchasedPriceTxt.setText("Price: " + Constants.currencyType + this.data.get(position).getBook_price());
            holder.orderId.setText("Order ID: " + this.data.get(position).getOrder_id());
            Glide.with(this.activity.getApplicationContext()).load(this.data.get(holder.getAbsoluteAdapterPosition()).getBook_image().replaceAll(" ", "%20")).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.book_logo).error(R.drawable.book_logo).diskCacheStrategy(DiskCacheStrategy.DATA)).into((ImageView) Objects.requireNonNull(holder.imageCourse));
        } catch (Exception e2) {
            Helper.logPrinter("PurchaseHistoryAdapter", "e", e2.getLocalizedMessage(), "Message");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(final Livetestviewholder livetestviewholder, View view) {
        final PopupMenu popupMenu = new PopupMenu(this.activity, view, 112);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.PurchaseHistory.adapter.PurchaseHistoryAdapter.1
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                if (!item.getTitle().equals("Download Invoice")) {
                    return true;
                }
                popupMenu.dismiss();
                PurchaseHistoryAdapter purchaseHistoryAdapter = PurchaseHistoryAdapter.this;
                purchaseHistoryAdapter.liveAwsActivityInstanceDownload(purchaseHistoryAdapter.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getInvoice_url());
                return true;
            }
        });
        popupMenu.getMenu().add("Download Invoice");
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(Livetestviewholder livetestviewholder, View view) {
        if (this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getPrices() != null && this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getPrices().size() > 0 && this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getTransaction_status().equalsIgnoreCase("1")) {
            openwatchlist_dailog_resource(this.activity, this.data.get(livetestviewholder.getAbsoluteAdapterPosition()));
        } else {
            Snackbar.make(livetestviewholder.extend_validy.getRootView(), this.activity.getResources().getString(R.string.course_has_been_transfer), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$2(int i, View view) {
        Intent intent = new Intent(this.activity, (Class<?>) InstallmentDetailActivity.class);
        intent.putExtra("order_data", this.data.get(i));
        intent.putExtra("fromWhere", Const.Purchase_History);
        intent.putExtra("invoiceUrl", this.data.get(i).getInvoice_url());
        intent.putExtra("admitCard", this.data.get(i).getAdmit_card_url());
        intent.putExtra(Const.SERVER_TIME, this.server_time);
        intent.putExtra("address", this.data.get(i).getAddress());
        intent.putExtra(FirebaseAnalytics.Param.END_DATE, this.data.get(i).getEnd_date());
        intent.putExtra(FirebaseAnalytics.Param.START_DATE, this.data.get(i).getStart_date());
        intent.putExtra("expiry_date", !TextUtils.isEmpty(this.data.get(i).getExpiry_date()) ? this.data.get(i).getExpiry_date() : "0");
        intent.putExtra("course_id", this.data.get(i).getId());
        intent.putExtra(AnalyticsConstants.test_name, this.data.get(i).getTest_series_name());
        intent.putExtra("test_mode", this.data.get(i).getMode());
        intent.putExtra("location", this.data.get(i).getLocation());
        intent.putExtra("description_img", this.data.get(i).getDesc_header_image());
        intent.putExtra("razorpay_subscription_code", this.data.get(i).getRazorpay_subscription_code());
        if (!TextUtils.isEmpty(this.data.get(i).getExpiry_date()) && Long.parseLong(this.data.get(i).getExpiry_date()) > System.currentTimeMillis()) {
            Toast.makeText(this.activity, "Expiry date not found", 0).show();
        }
        if (this.data.get(i).getPayment_mode() != null && this.data.get(i).getPayment_mode().equals("1")) {
            intent.putExtra("type", Const.Installment);
        } else if (this.data.get(i).getPayment_mode() != null && this.data.get(i).getPayment_mode().equals("3")) {
            intent.putExtra("type", "Subscription");
        } else {
            intent.putExtra("type", Const.Normal);
        }
        if (this.data.get(i).getIs_subscription() != null) {
            intent.putExtra("is_subscription", this.data.get(i).getIs_subscription());
        }
        this.activity.startActivity(intent);
    }

    public void openwatchlist_dailog_resource(final Context context, final PurchaseHistoryModel.Data course) {
        for (int i = 0; i < course.getPrices().size(); i++) {
            try {
                course.getPrices().get(i).setIs_select(false);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.videosheetDialogTheme);
        watchlist = bottomSheetDialog;
        bottomSheetDialog.setContentView(R.layout.top_up);
        ((Window) Objects.requireNonNull(watchlist.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        watchlist.setCancelable(false);
        watchlist.setCanceledOnTouchOutside(true);
        ImageView imageView = (ImageView) watchlist.findViewById(R.id.ibt_single_vd_iv);
        TextView textView = (TextView) watchlist.findViewById(R.id.buy_now);
        TextView textView2 = (TextView) watchlist.findViewById(R.id.cname);
        RecyclerView recyclerView = (RecyclerView) watchlist.findViewById(R.id.recycler_view_validy);
        textView2.setText(course.getTitle());
        if (course.getCover_image() != null) {
            Glide.with(context.getApplicationContext()).load(course.getCover_image().replaceAll(" ", "%20")).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder).error(R.mipmap.course_placeholder).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate()).transition(DrawableTransitionOptions.withCrossFade()).into((ImageView) Objects.requireNonNull(imageView));
        }
        if (course.getPrices() != null && course.getPrices().size() > 0) {
            course.getPrices().get(0).setIs_select(true);
            this.extendAdapter = new ExtendAdapter(context, course.getPrices(), watchlist);
            ((RecyclerView) Objects.requireNonNull(recyclerView)).setLayoutManager(new LinearLayoutManager(context, 1, false));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(this.extendAdapter);
        }
        if (!watchlist.isShowing()) {
            watchlist.show();
        }
        ((TextView) Objects.requireNonNull(textView)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PurchaseHistory.adapter.PurchaseHistoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$openwatchlist_dailog_resource$3(course, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$3(PurchaseHistoryModel.Data data, Context context, View view) {
        String str;
        int i = 0;
        while (true) {
            if (i >= data.getPrices().size()) {
                str = "";
                break;
            } else {
                if (data.getPrices().get(i).isIs_select()) {
                    str = "" + i;
                    break;
                }
                i++;
            }
        }
        if (str.equalsIgnoreCase("")) {
            Toast.makeText(context, this.activity.getResources().getString(R.string.select_extend_validity_plan), 0).show();
        } else {
            API_INIT_PAYMENT(data.getPrices().get(Integer.parseInt(str)).getValidity(), data.getPrices().get(Integer.parseInt(str)).getId(), data.getPrices().get(Integer.parseInt(str)).getPrice(), data);
        }
    }

    private void setThumbRatio(RelativeLayout rlThum) {
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

    private boolean setThumbAccordingRatio() {
        BottomSetting bottomSetting = this.bottomSetting;
        return (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0218 A[Catch: Exception -> 0x02cf, TryCatch #0 {Exception -> 0x02cf, blocks: (B:3:0x001a, B:6:0x0056, B:8:0x005c, B:10:0x006f, B:12:0x0075, B:14:0x007f, B:18:0x00a1, B:20:0x00a7, B:22:0x00b6, B:24:0x00bc, B:26:0x00c6, B:28:0x00df, B:30:0x00e5, B:32:0x00f4, B:34:0x00fa, B:36:0x0104, B:38:0x011d, B:40:0x0123, B:42:0x0132, B:44:0x0138, B:46:0x0142, B:48:0x015b, B:50:0x0161, B:52:0x0170, B:54:0x0176, B:56:0x0180, B:59:0x01a2, B:61:0x01a8, B:63:0x01b9, B:65:0x01bf, B:67:0x01c9, B:71:0x01ee, B:73:0x0218, B:113:0x02c9, B:74:0x021f, B:76:0x0225, B:79:0x023c, B:81:0x0242, B:112:0x02b8, B:82:0x024b, B:85:0x0253, B:87:0x0259, B:88:0x0261, B:91:0x0269, B:93:0x026f, B:94:0x0277, B:97:0x027f, B:99:0x0285, B:100:0x028d, B:103:0x0295, B:105:0x029b, B:106:0x02a3, B:109:0x02ab, B:111:0x02b1), top: B:118:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x021f A[Catch: Exception -> 0x02cf, TryCatch #0 {Exception -> 0x02cf, blocks: (B:3:0x001a, B:6:0x0056, B:8:0x005c, B:10:0x006f, B:12:0x0075, B:14:0x007f, B:18:0x00a1, B:20:0x00a7, B:22:0x00b6, B:24:0x00bc, B:26:0x00c6, B:28:0x00df, B:30:0x00e5, B:32:0x00f4, B:34:0x00fa, B:36:0x0104, B:38:0x011d, B:40:0x0123, B:42:0x0132, B:44:0x0138, B:46:0x0142, B:48:0x015b, B:50:0x0161, B:52:0x0170, B:54:0x0176, B:56:0x0180, B:59:0x01a2, B:61:0x01a8, B:63:0x01b9, B:65:0x01bf, B:67:0x01c9, B:71:0x01ee, B:73:0x0218, B:113:0x02c9, B:74:0x021f, B:76:0x0225, B:79:0x023c, B:81:0x0242, B:112:0x02b8, B:82:0x024b, B:85:0x0253, B:87:0x0259, B:88:0x0261, B:91:0x0269, B:93:0x026f, B:94:0x0277, B:97:0x027f, B:99:0x0285, B:100:0x028d, B:103:0x0295, B:105:0x029b, B:106:0x02a3, B:109:0x02ab, B:111:0x02b1), top: B:118:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void API_INIT_PAYMENT(java.lang.String r23, java.lang.String r24, java.lang.String r25, com.appnew.android.Model.PurchaseHistoryModel.Data r26) {
        /*
            Method dump skipped, instruction units count: 724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.PurchaseHistory.adapter.PurchaseHistoryAdapter.API_INIT_PAYMENT(java.lang.String, java.lang.String, java.lang.String, com.appnew.android.Model.PurchaseHistoryModel$Data):void");
    }

    private void dismissCalculatorDialog(BottomSheetDialog watchlist2) {
        if (watchlist2 == null || !watchlist2.isShowing()) {
            return;
        }
        watchlist2.dismiss();
        watchlist2.cancel();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.int_payment)) {
            return null;
        }
        if (this.post_txt.equalsIgnoreCase("")) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setType("3");
            encryptionData.setCourse_id(this.course.getId());
            encryptionData.setPay_via(this.paymentViewModel.getPayVia());
            encryptionData.setTxn_id(this.course.getTxn_id());
            encryptionData.setExtender_id(this.id);
            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (this.post_txt.contains("~!@#$%^&")) {
            this.post_txt = "";
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setPre_transaction_id(this.pre_transaction_id);
            encryptionData2.setTransaction_status("2");
            encryptionData2.setPost_transaction_id(this.post_txt);
            encryptionData2.setCourse_id(this.course.getId());
            encryptionData2.setType("4");
            encryptionData2.setPay_via(this.paymentViewModel.getPayVia());
            encryptionData2.setTxn_id(this.course.getTxn_id());
            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData2)));
        }
        EncryptionData encryptionData3 = new EncryptionData();
        encryptionData3.setPre_transaction_id(this.pre_transaction_id);
        encryptionData3.setTransaction_status("1");
        encryptionData3.setPost_transaction_id(this.post_txt);
        encryptionData3.setCourse_id(this.course.getId());
        encryptionData3.setRid(this.rid);
        encryptionData3.setScd(this.scd);
        encryptionData3.setPid(this.post_txt);
        encryptionData3.setAmt(this.amt);
        encryptionData3.setOrder_id(this.post_txt);
        encryptionData3.setType("4");
        encryptionData3.setTxn_id(this.course.getTxn_id());
        return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData3)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.int_payment)) {
            try {
                if (!jsonstring.optString("status").equals("true")) {
                    RetrofitResponse.GetApiData(this.activity, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                    return;
                }
                this.server_time = Integer.parseInt(jsonstring.optString("time"));
                if (this.post_txt.equalsIgnoreCase("")) {
                    JSONObject jSONObject = jsonstring.getJSONObject("data");
                    if (this.paymentViewModel.getPayVia().equalsIgnoreCase("3")) {
                        paymentGateways(jSONObject, Credentials.RZP);
                        return;
                    }
                    if (this.paymentViewModel.getPayVia().equalsIgnoreCase("6")) {
                        paymentGateways(jSONObject, Credentials.PAYTM);
                        return;
                    }
                    if (this.paymentViewModel.getPayVia().equalsIgnoreCase("7")) {
                        paymentGateways(jSONObject, Credentials.CCAV);
                        return;
                    }
                    if (this.paymentViewModel.getPayVia().equalsIgnoreCase("8")) {
                        paymentGateways(jSONObject, Credentials.FONEPAY);
                        return;
                    }
                    if (this.paymentViewModel.getPayVia().equalsIgnoreCase("9")) {
                        paymentGateways(jSONObject, Credentials.EASEBUZZ);
                        return;
                    } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("11")) {
                        paymentGateways(jSONObject, Credentials.BILLDESK);
                        return;
                    } else {
                        if (this.paymentViewModel.getPayVia().equalsIgnoreCase("13")) {
                            paymentGateways(jSONObject, Credentials.EASYPAY);
                            return;
                        }
                        return;
                    }
                }
                if (this.post_txt.contains("~!@#$%^&")) {
                    this.post_txt = "";
                    Toast.makeText(this.activity, "" + jsonstring.optString("message"), 0).show();
                    return;
                }
                Toast.makeText(this.activity, "" + jsonstring.optString("message"), 0).show();
                UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this.activity);
                if (appDatabase.getMyCourseDao().isRecordExists(MakeMyExam.userId)) {
                    appDatabase.getMyCourseDao().deletedata();
                }
                ((PurchaseHistory) this.activity).refreshdata();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void launch_paymentGateway(String key) {
        Checkout checkout = new Checkout();
        checkout.setKeyID(key);
        checkout.setImage(R.mipmap.ic_launcher);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.activity.getResources().getString(R.string.payment_gateway_name));
            jSONObject.put("theme.color", ContextCompat.getColor(this.activity, R.color.theme_and_header_color));
            jSONObject.put("description", this.course.getTitle() + " #(" + this.course.getId() + "~" + this.id + ")");
            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, "INR");
            jSONObject.put("amount", Math.round(Float.parseFloat(this.price) * 100.0f));
            jSONObject.put("image", this.course.getCover_image());
            jSONObject.put("order_id", this.pre_transaction_id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("email", "true");
            jSONObject2.put("contact", "true");
            jSONObject.put("readonly", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("email", SharedPreference.getInstance().getLoggedInUser().getEmail());
            jSONObject3.put("contact", SharedPreference.getInstance().getLoggedInUser().getMobile());
            jSONObject.put("prefill", jSONObject3);
            checkout.open(this.activity, jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onSuccess(String pot_txt_id) {
        update_payment(pot_txt_id);
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onSuccessEsewa(String productId, String amt, String rid, String scd) {
        update_payment(productId);
        this.amt = amt;
        this.rid = rid;
        this.scd = scd;
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onFailure(String pot_txt_id) {
        update_payment(pot_txt_id);
    }

    public void update_payment(String pot_txt_id) {
        dismissCalculatorDialog(watchlist);
        this.post_txt = pot_txt_id;
        new NetworkCall(this, this.activity).NetworkAPICall(API.int_payment, "", true, false);
    }

    private void paymentGateways(JSONObject data, String mode) {
        EasyPay easyPay;
        BillDesk billDesk;
        EaseBuzz easeBuzz;
        FonePay fonePay;
        Ccav ccav;
        Paytm paytm2;
        Rzp rzp;
        try {
            this.pre_transaction_id = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN);
            String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.RZP);
            String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.PAYTM);
            String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.CCAV);
            String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.FONEPAY);
            String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASEBUZZ);
            String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.BILLDESK);
            String stringPreference7 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASYPAY);
            if (mode.equals(Credentials.RZP)) {
                if (stringPreference == null || stringPreference.isEmpty() || (rzp = (Rzp) new Gson().fromJson(stringPreference, Rzp.class)) == null || rzp.getStatus() == null || !rzp.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                launch_paymentGateway(rzp.getKey());
                return;
            }
            if (mode.equals(Credentials.PAYTM)) {
                if (stringPreference2 == null || stringPreference2.isEmpty() || (paytm2 = (Paytm) new Gson().fromJson(stringPreference2, Paytm.class)) == null || paytm2.getStatus() == null || !paytm2.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.txnToken = data.optString("txnToken");
                this.paymentViewModel.launchPaytmPaymentGateway(this.pre_transaction_id, Math.round(Float.parseFloat(this.price)), this.txnToken, paytm2.getSecret(), paytm2.getUrl());
                return;
            }
            if (mode.equals(Credentials.CCAV)) {
                if (stringPreference3 == null || stringPreference3.isEmpty() || (ccav = (Ccav) new Gson().fromJson(stringPreference3, Ccav.class)) == null || ccav.getStatus() == null || !ccav.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.enc_val = data.optString("txnToken");
                this.paymentViewModel.launchCcAvenuePaymentGateway(this.pre_transaction_id, Math.round(Float.parseFloat(this.price)), this.enc_val, ccav.getSecret(), ccav.getRedirect_url(), ccav.getCancel_url(), ccav.getAndroid_url());
                return;
            }
            if (mode.equals(Credentials.FONEPAY)) {
                if (stringPreference4 == null || stringPreference4.isEmpty() || (fonePay = (FonePay) new Gson().fromJson(stringPreference4, FonePay.class)) == null || fonePay.getStatus() == null || !fonePay.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchFonePayPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price)));
                return;
            }
            if (mode.equals(Credentials.EASEBUZZ)) {
                if (stringPreference5 == null || stringPreference5.isEmpty() || (easeBuzz = (EaseBuzz) new Gson().fromJson(stringPreference5, EaseBuzz.class)) == null || easeBuzz.getStatus() == null || !easeBuzz.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchEaseBuzzPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price)), easeBuzz.getMode());
                return;
            }
            if (mode.equals(Credentials.BILLDESK)) {
                if (stringPreference6 == null || stringPreference6.isEmpty() || (billDesk = (BillDesk) new Gson().fromJson(stringPreference6, BillDesk.class)) == null || billDesk.getStatus() == null || !billDesk.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchBillDeskPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price)));
                return;
            }
            if (!mode.equals(Credentials.EASYPAY) || stringPreference7 == null || stringPreference7.isEmpty() || (easyPay = (EasyPay) new Gson().fromJson(stringPreference7, EasyPay.class)) == null || easyPay.getStatus() == null || !easyPay.getStatus().equalsIgnoreCase("1")) {
                return;
            }
            this.paymentViewModel.launchEasyPayPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void change_time(int server_time) {
        this.server_time = server_time;
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentType(String mode, JSONObject data) {
        String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.RZP);
        String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.PAYTM);
        String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.CCAV);
        String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.FONEPAY);
        String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASEBUZZ);
        String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.BILLDESK);
        String stringPreference7 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASYPAY);
        if (mode.equals(Credentials.RZP)) {
            if (stringPreference != null && !stringPreference.isEmpty()) {
                this.paymentViewModel.setPayVia("3");
            }
        } else if (mode.equals(Credentials.PAYTM)) {
            if (stringPreference2 != null && !stringPreference2.isEmpty()) {
                this.paymentViewModel.setPayVia("6");
            }
        } else if (mode.equals(Credentials.CCAV)) {
            if (stringPreference3 != null && !stringPreference3.isEmpty()) {
                this.paymentViewModel.setPayVia("7");
            }
        } else if (mode.equals(Credentials.FONEPAY)) {
            if (stringPreference4 != null && !stringPreference4.isEmpty()) {
                this.paymentViewModel.setPayVia("8");
            }
        } else if (mode.equals(Credentials.EASEBUZZ)) {
            if (stringPreference5 != null && !stringPreference5.isEmpty()) {
                this.paymentViewModel.setPayVia("9");
            }
        } else if (mode.equals(Credentials.BILLDESK)) {
            if (stringPreference6 != null && !stringPreference6.isEmpty()) {
                this.paymentViewModel.setPayVia("11");
            }
        } else if (mode.equals(Credentials.EASYPAY) && stringPreference7 != null && !stringPreference7.isEmpty()) {
            this.paymentViewModel.setPayVia("13");
        }
        NetworkCall networkCall = new NetworkCall(this, this.activity);
        this.course = this.coursePaymentTime;
        this.price = data.optString(FirebaseAnalytics.Param.PRICE);
        validty = data.optString("validity");
        this.id = data.optString("id");
        networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    public class Livetestviewholder extends RecyclerView.ViewHolder {
        ImageView courseImage;
        TextView emiTxt;
        LinearLayout expiredLL;
        TextView expiry_date;
        TextView extend_validy;
        ImageView forward;
        ImageView imageCourse;
        RelativeLayout imageRL;
        ImageView liveIV;
        ImageView more;
        TextView orderId;
        TextView orderIdTxt;
        TextView paidAmountTxt;
        TextView paidLabelTxt;
        TextView paymentIdTxt;
        LinearLayout payment_layout;
        TextView purchase_date;
        TextView purchasedOnTxt;
        TextView purchasedPriceTxt;
        TextView purchasedQuantityTxt;
        RelativeLayout study_single_itemLL;
        TextView title;
        TextView transer_text;
        TextView txtTitle;

        public Livetestviewholder(View itemView) {
            super(itemView);
            this.imageRL = (RelativeLayout) itemView.findViewById(R.id.imageRL);
            this.courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.paidLabelTxt = (TextView) itemView.findViewById(R.id.paidLabelTxt);
            this.forward = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.more = (ImageView) itemView.findViewById(R.id.more);
            this.title = (TextView) itemView.findViewById(R.id.study_item_titleTV);
            this.expiredLL = (LinearLayout) itemView.findViewById(R.id.expiredLL);
            this.study_single_itemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.purchase_date = (TextView) itemView.findViewById(R.id.purchase_date);
            this.transer_text = (TextView) itemView.findViewById(R.id.transer_text);
            this.extend_validy = (TextView) itemView.findViewById(R.id.extend_validy);
            this.expiry_date = (TextView) itemView.findViewById(R.id.expiry_date);
            this.orderIdTxt = (TextView) itemView.findViewById(R.id.orderIdTxt);
            this.orderId = (TextView) itemView.findViewById(R.id.orderId);
            this.paymentIdTxt = (TextView) itemView.findViewById(R.id.paymentIdTxt);
            this.paidAmountTxt = (TextView) itemView.findViewById(R.id.paidAmountTxt);
            this.payment_layout = (LinearLayout) itemView.findViewById(R.id.payment_layout);
            this.imageCourse = (ImageView) itemView.findViewById(R.id.imageCourse);
            this.txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            this.purchasedOnTxt = (TextView) itemView.findViewById(R.id.purchasedOnTxt);
            this.purchasedPriceTxt = (TextView) itemView.findViewById(R.id.purchasedPriceTxt);
            this.purchasedQuantityTxt = (TextView) itemView.findViewById(R.id.purchasedQuantityTxt);
            this.emiTxt = (TextView) itemView.findViewById(R.id.emiTxt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void liveAwsActivityInstanceDownload(String data) {
        PostFile postFile = new PostFile();
        postFile.setLink(data);
        postFile.setFile_type(Const.COURSE_INVOICE);
        String str = data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1];
        if (!str.contains("")) {
            postFile.setFile_info(data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1]);
        } else {
            postFile.setFile_info(str.replaceAll(" ", "_"));
        }
        try {
            ((PurchaseHistory) this.activity).myPermissionConstantsArrayList = new ArrayList<>();
            ((PurchaseHistory) this.activity).myPermissionConstantsArrayList.add(AppPermissionsRunTime.MyPermissionConstants.PERMISSION_READ_EXTERNAL_STORAGE);
            ((PurchaseHistory) this.activity).myPermissionConstantsArrayList.add(AppPermissionsRunTime.MyPermissionConstants.PERMISSION_WRITE_EXTERNAL_STORAGE);
            Activity activity = this.activity;
            ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList = ((PurchaseHistory) activity).myPermissionConstantsArrayList;
            Objects.requireNonNull((PurchaseHistory) this.activity);
            if (AppPermissionsRunTime.checkPermission(activity, arrayList, 123)) {
                if (Helper.getStorageInstance(this.activity).getRecordObject(Const.COURSE_INVOICE) != null) {
                    Helper.DownloadfilefromURL(this.activity, (PostFile) Helper.getStorageInstance(this.activity).getRecordObject(Const.COURSE_INVOICE));
                    Helper.getStorageInstance(this.activity).deleteRecord(Const.COURSE_INVOICE);
                    return;
                }
                Helper.DownloadfilefromURL(this.activity, postFile);
                return;
            }
            Helper.getStorageInstance(this.activity).addRecordStore(Const.COURSE_INVOICE, postFile);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
