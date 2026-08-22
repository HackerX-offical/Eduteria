package com.appnew.android.home.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Model.BillDesk;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Ccav;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.DueEmiTable;
import com.appnew.android.Model.EaseBuzz;
import com.appnew.android.Model.EasyPay;
import com.appnew.android.Model.FonePay;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Paytm;
import com.appnew.android.Model.Rzp;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.Credentials;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.Payment.PreferencesUtil;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PaymentTypeCheck;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.Constants;
import com.appnew.android.home.interfaces.onButtonClicked;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.VideosDownload;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.razorpay.Checkout;
import com.tv9news.utils.helpers.AnalyticsConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class PaidCourseAdapter extends RecyclerView.Adapter<MyViewHolder> implements NetworkCall.MyNetworkCallBack, PaymentTypeCheck {
    public static CircleImageView adharImage = null;
    public static String adharImhPath = "";
    public static Courselist course = null;
    public static String forWhat = "";
    public static String imagepath = "";
    public static String pre_transaction_id = "";
    public static CircleImageView userImage;
    static BottomSheetDialog watchlist;
    private Activity activity;
    String amt;
    private BottomSetting bottomSetting;
    onButtonClicked buttonClicked;
    public String contentType;
    private Context context;
    private Courselist coursePaymentTime;
    private List<Courselist> courselists;
    private ExtendAdapter extendAdapter;
    LeftMenu leftMenu;
    PaymentViewModel paymentViewModel;
    String rid;
    UtkashRoom utkashRoom;
    int containerWidth = 0;
    int delet_pos = 0;
    private String price = "";
    private String id = "";
    private String post_txt = "";
    private String txnToken = "";
    String enc_val = "";
    String scd = "";
    int server_time = Integer.parseInt(String.valueOf(MakeMyExam.getTime_server() / 1000));

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentTypeCancel() {
    }

    public PaidCourseAdapter(Context context, List<Courselist> courselists, int server_time, PaymentViewModel paymentViewModel) {
        this.courselists = courselists;
        this.context = context;
        this.activity = (Activity) context;
        this.paymentViewModel = paymentViewModel;
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this.activity);
        this.utkashRoom = appDatabase;
        ThemeSettings themeSettingsData = appDatabase.getthemeSettingdao().data();
        if (themeSettingsData == null || themeSettingsData.getLeft_menu() == null) {
            return;
        }
        this.leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
        this.bottomSetting = (BottomSetting) new Gson().fromJson(themeSettingsData.getBottom(), BottomSetting.class);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.remove_course)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(course.getId());
            encryptionData.setTxn_id(course.getTxn_id());
            return service.remove_course(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.int_payment)) {
            return null;
        }
        if (this.post_txt.equalsIgnoreCase("")) {
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setType("3");
            encryptionData2.setCourse_id(course.getId());
            encryptionData2.setPay_via(this.paymentViewModel.getPayVia());
            encryptionData2.setTxn_id(course.getTxn_id());
            encryptionData2.setExtender_id(this.id);
            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData2)));
        }
        if (this.post_txt.contains("~!@#$%^&")) {
            this.post_txt = "";
            EncryptionData encryptionData3 = new EncryptionData();
            encryptionData3.setPre_transaction_id(pre_transaction_id);
            encryptionData3.setTransaction_status("2");
            encryptionData3.setPost_transaction_id("");
            encryptionData3.setCourse_id(course.getId());
            encryptionData3.setType("4");
            encryptionData3.setRid(this.rid);
            encryptionData3.setScd(this.scd);
            encryptionData3.setPid(this.post_txt);
            encryptionData3.setAmt(this.amt);
            encryptionData3.setOrder_id(this.post_txt);
            encryptionData3.setTxn_id(course.getTxn_id());
            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData3)));
        }
        EncryptionData encryptionData4 = new EncryptionData();
        encryptionData4.setPre_transaction_id(pre_transaction_id);
        encryptionData4.setTransaction_status("1");
        encryptionData4.setPost_transaction_id(this.post_txt);
        encryptionData4.setCourse_id(course.getId());
        encryptionData4.setRid(this.rid);
        encryptionData4.setScd(this.scd);
        encryptionData4.setPid(this.post_txt);
        encryptionData4.setAmt(this.amt);
        encryptionData4.setOrder_id(this.post_txt);
        encryptionData4.setType("4");
        encryptionData4.setTxn_id(course.getTxn_id());
        return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData4)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.remove_course)) {
            try {
                if (jsonstring.optString("status").equals("true")) {
                    this.utkashRoom.getuserhistorydao().delete(course.getId() + MqttTopic.MULTI_LEVEL_WILDCARD, MakeMyExam.userId);
                    List<VideosDownload> list = this.utkashRoom.getvideoDownloadao().getallcourse_id(course.getId() + MqttTopic.MULTI_LEVEL_WILDCARD, MakeMyExam.userId);
                    if (list != null && list.size() > 0) {
                        for (VideosDownload videosDownload : list) {
                            File file = new File(this.activity.getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                            File file2 = new File(this.activity.getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADING_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                            if (file.exists()) {
                                file.delete();
                            }
                            if (file2.exists()) {
                                file2.delete();
                            }
                            this.utkashRoom.getvideoDownloadao().delete(videosDownload.getVideo_id(), videosDownload.getCourse_id(), MakeMyExam.userId);
                        }
                    }
                    ((MyLibraryActivty) this.activity).myDBClass.getMyCourseDao().delete(course.getId(), course.getTxn_id());
                    this.courselists.remove(this.delet_pos);
                    this.utkashRoom.getCourseDetaildata().deletecoursedetail(course.getId(), MakeMyExam.userId);
                    notifidata(this.courselists);
                    return;
                }
                RetrofitResponse.GetApiData(this.context, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (apitype.equals(API.int_payment)) {
            try {
                if (jsonstring.optString("status").equals("true")) {
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
                        Toast.makeText(this.context, "" + jsonstring.optString("message"), 0).show();
                        return;
                    }
                    FacebookEventLogger.logPurchased(this.activity);
                    Toast.makeText(this.context, "" + jsonstring.optString("message"), 0).show();
                    UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this.activity);
                    if (appDatabase.getMyCourseDao().isRecordExists(MakeMyExam.userId)) {
                        appDatabase.getMyCourseDao().deletedata();
                    }
                    ((MyLibraryActivty) this.context).finish();
                    return;
                }
                RetrofitResponse.GetApiData(this.context, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                Toast.makeText(this.context, jsonstring.optString("message"), 0).show();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
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
            pre_transaction_id = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN);
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
                launch_paymentGateway(rzp.getKey(), this.price);
                return;
            }
            if (mode.equals(Credentials.PAYTM)) {
                if (stringPreference2 == null || stringPreference2.isEmpty() || (paytm2 = (Paytm) new Gson().fromJson(stringPreference2, Paytm.class)) == null || paytm2.getStatus() == null || !paytm2.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.txnToken = data.optString("txnToken");
                this.paymentViewModel.launchPaytmPaymentGateway(pre_transaction_id, Math.round(Float.parseFloat(this.price)), this.txnToken, paytm2.getSecret(), paytm2.getUrl());
                return;
            }
            if (mode.equals(Credentials.CCAV)) {
                if (stringPreference3 == null || stringPreference3.isEmpty() || (ccav = (Ccav) new Gson().fromJson(stringPreference3, Ccav.class)) == null || ccav.getStatus() == null || !ccav.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.enc_val = data.optString("txnToken");
                this.paymentViewModel.launchCcAvenuePaymentGateway(pre_transaction_id, Math.round(Float.parseFloat(this.price) * 100.0f), this.enc_val, ccav.getSecret(), ccav.getRedirect_url(), ccav.getCancel_url(), ccav.getAndroid_url());
                return;
            }
            if (mode.equals(Credentials.FONEPAY)) {
                if (stringPreference4 == null || stringPreference4.isEmpty() || (fonePay = (FonePay) new Gson().fromJson(stringPreference4, FonePay.class)) == null || fonePay.getStatus() == null || !fonePay.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchFonePayPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price) * 100.0f));
                return;
            }
            if (mode.equals(Credentials.EASEBUZZ)) {
                if (stringPreference5 == null || stringPreference5.isEmpty() || (easeBuzz = (EaseBuzz) new Gson().fromJson(stringPreference5, EaseBuzz.class)) == null || easeBuzz.getStatus() == null || !easeBuzz.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchEaseBuzzPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price) * 100.0f), easeBuzz.getMode());
                return;
            }
            if (mode.equals(Credentials.BILLDESK)) {
                if (stringPreference6 == null || stringPreference6.isEmpty() || (billDesk = (BillDesk) new Gson().fromJson(stringPreference6, BillDesk.class)) == null || billDesk.getStatus() == null || !billDesk.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchBillDeskPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price) * 100.0f));
                return;
            }
            if (!mode.equals(Credentials.EASYPAY) || stringPreference7 == null || stringPreference7.isEmpty() || (easyPay = (EasyPay) new Gson().fromJson(stringPreference7, EasyPay.class)) == null || easyPay.getStatus() == null || !easyPay.getStatus().equalsIgnoreCase("1")) {
                return;
            }
            this.paymentViewModel.launchEasyPayPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price) * 100.0f));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void launch_paymentGateway(String razorkey, String price) {
        Checkout checkout = new Checkout();
        checkout.setKeyID(razorkey);
        checkout.setImage(R.mipmap.ic_launcher);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.activity.getResources().getString(R.string.payment_gateway_name));
            jSONObject.put("theme.color", ContextCompat.getColor(this.activity, R.color.theme_and_header_color));
            jSONObject.put("description", course.getTitle() + " #(" + course.getId() + "~" + this.id + ")");
            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, "INR");
            jSONObject.put("amount", Math.round(Float.parseFloat(price) * 100.0f));
            jSONObject.put("image", course.getDescHeaderImage());
            jSONObject.put("order_id", pre_transaction_id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("email", "true");
            jSONObject2.put("contact", "true");
            jSONObject.put("readonly", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("email", SharedPreference.getInstance().getLoggedInUser().getEmail());
            jSONObject3.put("contact", SharedPreference.getInstance().getLoggedInUser().getMobile());
            jSONObject.put("prefill", jSONObject3);
            checkout.open((MyLibraryActivty) this.context, jSONObject);
        } catch (Exception e2) {
            e2.toString();
        }
    }

    public void update_payment(String pot_txt_id) {
        dismissCalculatorDialog(watchlist);
        this.post_txt = pot_txt_id;
        NetworkCall networkCall = new NetworkCall(this, this.context);
        if (MakeMyExam.getUserId().equalsIgnoreCase("0")) {
            return;
        }
        networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    public void update_payment_esewa(String pot_txt_id, String amt, String rid, String scd) {
        dismissCalculatorDialog(watchlist);
        this.post_txt = pot_txt_id;
        this.rid = rid;
        this.scd = scd;
        this.amt = amt;
        NetworkCall networkCall = new NetworkCall(this, this.context);
        if (MakeMyExam.getUserId().equalsIgnoreCase("0")) {
            return;
        }
        networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    public void notifidata(List<Courselist> courselists) {
        this.courselists = courselists;
        notifyDataSetChanged();
    }

    public void notifidata(List<Courselist> courselists, String type) {
        if (type.equalsIgnoreCase(this.context.getResources().getString(R.string.last_read))) {
            Collections.reverse(courselists);
        }
        this.courselists = courselists;
        notifyDataSetChanged();
    }

    public void filterList(ArrayList<Courselist> courselists) {
        this.courselists = courselists;
        notifyDataSetChanged();
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
        course = this.coursePaymentTime;
        this.price = data.optString(FirebaseAnalytics.Param.PRICE);
        this.id = data.optString("id");
        new NetworkCall(this, this.context).NetworkAPICall(API.int_payment, "", true, false);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView alert_text;
        RelativeLayout course__validty;
        TextView course_name;
        RelativeLayout days_layout;
        ImageView delete;
        TextView extend_validy;
        ImageView ibt_single_vd_iv;
        RelativeLayout mycourse_layout;
        RelativeLayout progess_layout;
        TextView progrees_value_text;
        ProgressBar progress_value;
        TextView remaing_days;
        TextView start_date;
        TextView total_days;

        public MyViewHolder(View view) {
            super(view);
            this.course_name = (TextView) view.findViewById(R.id.course_name);
            this.course__validty = (RelativeLayout) view.findViewById(R.id.course__validty);
            this.progess_layout = (RelativeLayout) view.findViewById(R.id.progess_layout);
            this.ibt_single_vd_iv = (ImageView) view.findViewById(R.id.ibt_single_vd_iv);
            this.remaing_days = (TextView) view.findViewById(R.id.remaing_days);
            this.total_days = (TextView) view.findViewById(R.id.total_days);
            this.progress_value = (ProgressBar) view.findViewById(R.id.progress_value);
            this.alert_text = (TextView) view.findViewById(R.id.alert_text);
            this.extend_validy = (TextView) view.findViewById(R.id.extend_validy);
            this.delete = (ImageView) view.findViewById(R.id.delete);
            this.mycourse_layout = (RelativeLayout) view.findViewById(R.id.mycourse_layout);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.paid_course_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        try {
            DueEmiTable dueEmiData = this.utkashRoom.getDueEmi().getDueEmiData(this.courselists.get(holder.getAbsoluteAdapterPosition()).getId());
            holder.course_name.setText(this.courselists.get(holder.getAbsoluteAdapterPosition()).getTitle());
            if (this.courselists.get(holder.getAbsoluteAdapterPosition()).getCat_type().equalsIgnoreCase("3")) {
                holder.progess_layout.setVisibility(8);
                holder.course__validty.setVisibility(8);
            } else {
                holder.progess_layout.setVisibility(0);
                holder.course__validty.setVisibility(0);
            }
            setThumbRatio(holder.ibt_single_vd_iv);
            if (this.leftMenu != null && this.courselists.get(holder.getAbsoluteAdapterPosition()).getDelete() == 1 && (this.leftMenu.getCourse_delete().equalsIgnoreCase("1") || this.leftMenu.getCourse_delete().equalsIgnoreCase(""))) {
                holder.delete.setVisibility(0);
            } else {
                holder.delete.setVisibility(8);
            }
            if (Integer.parseInt(this.courselists.get(holder.getAbsoluteAdapterPosition()).getExpiry_date()) != 0 && Integer.parseInt(this.courselists.get(holder.getAbsoluteAdapterPosition()).getExpiry_date()) > Integer.parseInt(this.courselists.get(holder.getAbsoluteAdapterPosition()).getPurchase_date())) {
                int i = (Integer.parseInt(this.courselists.get(holder.getAbsoluteAdapterPosition()).getExpiry_date()) - Integer.parseInt(this.courselists.get(holder.getAbsoluteAdapterPosition()).getPurchase_date())) / DateTimeConstants.SECONDS_PER_DAY;
                if (this.server_time >= Integer.parseInt(this.courselists.get(holder.getAbsoluteAdapterPosition()).getPurchase_date())) {
                    if (this.courselists.get(holder.getAbsoluteAdapterPosition()).getCat_type().equalsIgnoreCase("3")) {
                        holder.progess_layout.setVisibility(8);
                        holder.course__validty.setVisibility(8);
                    } else {
                        holder.progess_layout.setVisibility(0);
                        holder.course__validty.setVisibility(0);
                    }
                    holder.total_days.setText(this.context.getResources().getString(R.string.validity_) + i + this.context.getResources().getString(R.string._days));
                    int i2 = (this.server_time - Integer.parseInt(this.courselists.get(holder.getAbsoluteAdapterPosition()).getPurchase_date())) / DateTimeConstants.SECONDS_PER_DAY;
                    int i3 = i - i2;
                    holder.remaing_days.setText(this.context.getResources().getString(R.string.remaining_day) + (i3 >= 0 ? Integer.valueOf(i3) : "0"));
                    if (i != 0) {
                        int i4 = i2 * 100;
                        if (i4 / i > 80 && i4 / i < 90) {
                            holder.mycourse_layout.setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_mycourse_remaining));
                            holder.progress_value.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.progress_drawable_remaining));
                        } else if (i4 / i > 90) {
                            holder.mycourse_layout.setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_mycourse));
                            holder.progress_value.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.progress_drawable_red));
                        } else {
                            holder.mycourse_layout.setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_mycourse));
                            holder.progress_value.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.progress_drawable));
                        }
                        holder.progress_value.setProgress(i4 / i);
                        if (this.courselists.get(holder.getAbsoluteAdapterPosition()).getPrices() != null && this.courselists.get(holder.getAbsoluteAdapterPosition()).getPrices().size() > 0) {
                            holder.alert_text.setVisibility(0);
                            int i5 = i4 / i;
                            if (i5 < 80) {
                                holder.extend_validy.setBackground(this.context.getResources().getDrawable(R.drawable.btn_back_with_ripple));
                            } else if (i5 > 80 && i5 < 90) {
                                holder.extend_validy.setBackground(this.context.getResources().getDrawable(R.drawable.orange_extend));
                            } else {
                                holder.extend_validy.setBackground(this.context.getResources().getDrawable(R.drawable.range_extend));
                            }
                            if (dueEmiData != null) {
                                holder.extend_validy.setVisibility(8);
                                holder.alert_text.setVisibility(8);
                            } else {
                                holder.extend_validy.setVisibility(0);
                                holder.alert_text.setVisibility(0);
                            }
                        } else {
                            holder.extend_validy.setVisibility(8);
                        }
                    } else {
                        holder.alert_text.setVisibility(8);
                        holder.extend_validy.setVisibility(8);
                    }
                }
            }
            if (this.courselists.get(holder.getAbsoluteAdapterPosition()).getDescHeaderImage() != null) {
                Glide.with(this.context.getApplicationContext()).load(this.courselists.get(holder.getAbsoluteAdapterPosition()).getDescHeaderImage().replaceAll(" ", "%20")).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder_new).error(R.mipmap.square_placeholder_new).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate()).into((ImageView) Objects.requireNonNull(holder.ibt_single_vd_iv));
            } else if (this.courselists.get(holder.getAbsoluteAdapterPosition()).getCover_image() != null) {
                Glide.with(this.context.getApplicationContext()).load(this.courselists.get(holder.getAbsoluteAdapterPosition()).getCover_image().replaceAll(" ", "%20")).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder_new).error(R.mipmap.square_placeholder_new).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate()).into((ImageView) Objects.requireNonNull(holder.ibt_single_vd_iv));
            }
            holder.mycourse_layout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.adapters.PaidCourseAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$0(holder);
                }
            }));
            holder.extend_validy.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.adapters.PaidCourseAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$1(holder);
                }
            }));
            holder.delete.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.PaidCourseAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(position, view);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(MyViewHolder myViewHolder) {
        actionOfAdapterItem(myViewHolder);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$1(MyViewHolder myViewHolder) {
        if (this.courselists.get(myViewHolder.getAbsoluteAdapterPosition()).getPrices() == null || this.courselists.get(myViewHolder.getAbsoluteAdapterPosition()).getPrices().size() <= 0) {
            return null;
        }
        openwatchlist_dailog_resource(this.context, this.courselists.get(myViewHolder.getAbsoluteAdapterPosition()));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$2(int i, View view) {
        this.delet_pos = i;
        alert_dialog();
    }

    private void actionOfAdapterItem(MyViewHolder holder) {
        Helper.comboinside = false;
        if ("1".equalsIgnoreCase("6")) {
            if (TextUtils.isEmpty(this.courselists.get(holder.getAbsoluteAdapterPosition()).getMaintenanceText())) {
                Constants.IS_FROM_LIBRARY = true;
                this.courselists.get(holder.getAbsoluteAdapterPosition()).setLastread("" + MakeMyExam.getTime_server());
                ((MyLibraryActivty) this.context).myDBClass.getMyCourseDao().update_course_lastread("" + MakeMyExam.getTime_server(), this.courselists.get(holder.getAbsoluteAdapterPosition()).getId(), MakeMyExam.userId);
                Bundle bundle = new Bundle();
                bundle.putString(Const.FRAG_TYPE, Const.SHOW_ALL_COURSES);
                bundle.putString(Const.COURSE_ID_MAIN, this.courselists.get(holder.getAbsoluteAdapterPosition()).getId());
                bundle.putString("valid_to", this.courselists.get(holder.getAbsoluteAdapterPosition()).getExpiry_date());
                bundle.putString(Const.COURSE_PARENT_ID, "");
                bundle.putBoolean(Const.IS_COMBO, false);
                bundle.putString(AnalyticsConstants.course_name, this.courselists.get(holder.getAbsoluteAdapterPosition()).getTitle());
                bundle.putString(Const.COMBO_ID, this.courselists.get(holder.getAbsoluteAdapterPosition()).getCombo_course_ids());
                bundle.putString(Const.CONTENT_TYPE_1, this.courselists.get(holder.getAbsoluteAdapterPosition()).getContent_type());
                Helper.gotoActivityWithBundle(this.activity, CourseActivity.class, bundle);
                return;
            }
            Helper.getCourseMaintanaceDialog((Activity) this.context, "", this.courselists.get(holder.getAbsoluteAdapterPosition()).getMaintenanceText());
            return;
        }
        if (TextUtils.isEmpty(this.courselists.get(holder.getAbsoluteAdapterPosition()).getMaintenanceText())) {
            Constants.IS_FROM_LIBRARY = true;
            this.courselists.get(holder.getAbsoluteAdapterPosition()).setLastread("" + MakeMyExam.getTime_server());
            ((MyLibraryActivty) this.context).myDBClass.getMyCourseDao().update_course_lastread("" + MakeMyExam.getTime_server(), this.courselists.get(holder.getAbsoluteAdapterPosition()).getId(), MakeMyExam.userId);
            Bundle bundle2 = new Bundle();
            bundle2.putString(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            bundle2.putString(Const.COURSE_ID_MAIN, this.courselists.get(holder.getAbsoluteAdapterPosition()).getId());
            bundle2.putString("valid_to", this.courselists.get(holder.getAbsoluteAdapterPosition()).getExpiry_date());
            bundle2.putString(Const.COURSE_PARENT_ID, "");
            bundle2.putBoolean(Const.IS_COMBO, false);
            bundle2.putString(AnalyticsConstants.course_name, this.courselists.get(holder.getAbsoluteAdapterPosition()).getTitle());
            bundle2.putString(Const.COMBO_ID, this.courselists.get(holder.getAbsoluteAdapterPosition()).getCombo_course_ids());
            bundle2.putString(Const.CONTENT_TYPE_1, this.courselists.get(holder.getAbsoluteAdapterPosition()).getContent_type());
            Helper.gotoActivityWithBundle(this.activity, CourseActivity.class, bundle2);
            return;
        }
        Helper.getCourseMaintanaceDialog((Activity) this.context, "", this.courselists.get(holder.getAbsoluteAdapterPosition()).getMaintenanceText());
    }

    private void alert_dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setTitle(this.context.getResources().getString(R.string.delete));
        builder.setMessage(this.context.getResources().getString(R.string.are_you_sure_you_want_to_course_delete));
        builder.setNegativeButton(this.context.getResources().getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.home.adapters.PaidCourseAdapter$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(this.context.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.home.adapters.PaidCourseAdapter$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$alert_dialog$4(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$4(DialogInterface dialogInterface, int i) {
        delete_free_course(this.courselists.get(this.delet_pos));
        dialogInterface.dismiss();
        dialogInterface.cancel();
    }

    private void delete_free_course(Courselist course2) {
        course = course2;
        new NetworkCall(this, this.context).NetworkAPICall(API.remove_course, "", true, false);
    }

    private void setThumbRatio(ImageView rlThum) {
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

    public void openwatchlist_dailog_resource(final Context context, final Courselist course2) {
        for (int i = 0; i < course2.getPrices().size(); i++) {
            try {
                course2.getPrices().get(i).setIs_select(false);
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
        textView2.setText(course2.getTitle());
        if (course2.getDescHeaderImage() != null) {
            Glide.with(context.getApplicationContext()).load(course2.getDescHeaderImage().replaceAll(" ", "%20")).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder_new).error(R.mipmap.square_placeholder_new).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate()).transition(DrawableTransitionOptions.withCrossFade()).into((ImageView) Objects.requireNonNull(imageView));
        }
        if (course2.getPrices() != null && course2.getPrices().size() > 0) {
            course2.getPrices().get(0).setIs_select(true);
            this.extendAdapter = new ExtendAdapter(context, course2.getPrices(), watchlist);
            ((RecyclerView) Objects.requireNonNull(recyclerView)).setLayoutManager(new LinearLayoutManager(context, 1, false));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(this.extendAdapter);
        }
        if (!watchlist.isShowing()) {
            watchlist.show();
        }
        this.paymentViewModel.setCourseId(course2.getId());
        ((TextView) Objects.requireNonNull(textView)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.PaidCourseAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$openwatchlist_dailog_resource$5(course2, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$5(Courselist courselist, Context context, View view) {
        String str;
        int i = 0;
        while (true) {
            if (i >= courselist.getPrices().size()) {
                str = "";
                break;
            } else {
                if (courselist.getPrices().get(i).isIs_select()) {
                    str = "" + i;
                    break;
                }
                i++;
            }
        }
        if (str.equalsIgnoreCase("")) {
            Toast.makeText(context, context.getResources().getString(R.string.select_extend_validity_plan), 0).show();
        } else {
            API_INIT_PAYMENT(courselist.getPrices().get(Integer.parseInt(str)).getId(), courselist.getPrices().get(Integer.parseInt(str)).getPrice(), courselist);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0258 A[PHI: r19
      0x0258: PHI (r19v1 java.lang.String) = (r19v0 java.lang.String), (r19v0 java.lang.String), (r19v3 java.lang.String) binds: [B:73:0x0211, B:75:0x0217, B:83:0x0256] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x027a A[Catch: Exception -> 0x0346, TryCatch #0 {Exception -> 0x0346, blocks: (B:6:0x0029, B:9:0x0071, B:11:0x0077, B:13:0x008a, B:15:0x0090, B:17:0x009a, B:21:0x00bc, B:23:0x00c2, B:25:0x00d1, B:27:0x00d7, B:29:0x00e1, B:31:0x00fa, B:33:0x0100, B:35:0x010f, B:37:0x0115, B:39:0x011f, B:41:0x0138, B:43:0x013e, B:45:0x014d, B:47:0x0153, B:49:0x015d, B:51:0x0176, B:53:0x017c, B:55:0x018b, B:57:0x0191, B:59:0x019b, B:62:0x01bd, B:64:0x01c3, B:66:0x01d4, B:68:0x01da, B:70:0x01e4, B:74:0x0213, B:76:0x0219, B:78:0x022a, B:80:0x0230, B:82:0x023a, B:85:0x025a, B:87:0x027a, B:133:0x0340, B:88:0x0281, B:90:0x0287, B:93:0x029e, B:95:0x02a4, B:132:0x0331, B:96:0x02ad, B:99:0x02b5, B:101:0x02bb, B:102:0x02c4, B:105:0x02cc, B:107:0x02d2, B:108:0x02da, B:111:0x02e2, B:113:0x02e8, B:114:0x02f0, B:117:0x02f8, B:119:0x02fe, B:120:0x0306, B:123:0x030e, B:125:0x0314, B:126:0x031c, B:129:0x0324, B:131:0x032a), top: B:138:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0281 A[Catch: Exception -> 0x0346, TryCatch #0 {Exception -> 0x0346, blocks: (B:6:0x0029, B:9:0x0071, B:11:0x0077, B:13:0x008a, B:15:0x0090, B:17:0x009a, B:21:0x00bc, B:23:0x00c2, B:25:0x00d1, B:27:0x00d7, B:29:0x00e1, B:31:0x00fa, B:33:0x0100, B:35:0x010f, B:37:0x0115, B:39:0x011f, B:41:0x0138, B:43:0x013e, B:45:0x014d, B:47:0x0153, B:49:0x015d, B:51:0x0176, B:53:0x017c, B:55:0x018b, B:57:0x0191, B:59:0x019b, B:62:0x01bd, B:64:0x01c3, B:66:0x01d4, B:68:0x01da, B:70:0x01e4, B:74:0x0213, B:76:0x0219, B:78:0x022a, B:80:0x0230, B:82:0x023a, B:85:0x025a, B:87:0x027a, B:133:0x0340, B:88:0x0281, B:90:0x0287, B:93:0x029e, B:95:0x02a4, B:132:0x0331, B:96:0x02ad, B:99:0x02b5, B:101:0x02bb, B:102:0x02c4, B:105:0x02cc, B:107:0x02d2, B:108:0x02da, B:111:0x02e2, B:113:0x02e8, B:114:0x02f0, B:117:0x02f8, B:119:0x02fe, B:120:0x0306, B:123:0x030e, B:125:0x0314, B:126:0x031c, B:129:0x0324, B:131:0x032a), top: B:138:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void API_INIT_PAYMENT(java.lang.String r24, java.lang.String r25, com.appnew.android.Model.Courselist r26) {
        /*
            Method dump skipped, instruction units count: 843
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.home.adapters.PaidCourseAdapter.API_INIT_PAYMENT(java.lang.String, java.lang.String, com.appnew.android.Model.Courselist):void");
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
        return this.courselists.size();
    }
}
