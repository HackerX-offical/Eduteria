package com.appnew.android.Notification.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Coupon.Activity.CouponActivity;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.NotificationModel.Datum;
import com.appnew.android.Model.Video;
import com.appnew.android.Notification.NotificationDescription;
import com.appnew.android.Notification.readMoreTV.ReadMoreTextView;
import com.appnew.android.Notification.readMoreTV.TextViewClickListener;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.UserHistory.ConversationReplyActivity;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.StoreProvider;
import com.appnew.android.Utils.ZoomFeatureHelper;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.home.Constants;
import com.appnew.android.table.TestTable;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.eduteria.app.app.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.BiFunction;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class NotificationAdapter extends RecyclerView.Adapter<Notification> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    public Video datuml;
    int lang;
    private NestedScrollView nestedScrollView;
    NetworkCall networkCall;
    List<Datum> notificationlist;
    RecyclerView recyclerView;
    UtkashRoom utkashRoom;
    Video video;
    private Video videodata;
    public String selectedpositionid = "0";
    public int selectedposition = 0;
    public String type = "";
    String first_attempt = "";
    String result_date = "";
    String submition_type = "";
    String quiz_id = "";
    String testname = "";
    String testquestion = "";
    private final int FROM_PDF_SCREEN = 100011;
    String[] langIds = {"1"};
    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, 15) { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter.7
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            Toast.makeText(recyclerView.getContext(), NotificationAdapter.this.activity.getResources().getString(R.string.on_move), 0).show();
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition >= 0 && absoluteAdapterPosition < NotificationAdapter.this.notificationlist.size()) {
                NotificationAdapter notificationAdapter = NotificationAdapter.this;
                notificationAdapter.selectedpositionid = notificationAdapter.notificationlist.get(absoluteAdapterPosition).getId();
                NotificationAdapter.this.selectedposition = absoluteAdapterPosition;
                NotificationAdapter.this.delete_notification_api();
                return;
            }
            NotificationAdapter.this.notifyDataSetChanged();
        }
    };
    private int STORAGE_PERMISSION_TYPE = 3;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public void setNestedScrollView(NestedScrollView nestedScrollView) {
        this.nestedScrollView = nestedScrollView;
    }

    public NotificationAdapter(Activity activity, List<Datum> data) {
        this.activity = activity;
        this.notificationlist = data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Notification onCreateViewHolder(ViewGroup parent, int viewType) {
        this.networkCall = new NetworkCall(this, this.activity);
        this.utkashRoom = UtkashRoom.getAppDatabase(this.activity);
        return new Notification(LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Notification holder, final int position) {
        holder.notification_title.setText(this.notificationlist.get(position).getTitle());
        if (this.notificationlist.get(position).getMessage() != null) {
            holder.descriptionTV.setText(Html.fromHtml(removeImagesFromHtml(this.notificationlist.get(position).getMessage()), 0));
            setupReadMore(holder.descriptionTV);
            String actionElement = this.notificationlist.get(position).getActionElement();
            if (actionElement != null && (actionElement.equalsIgnoreCase("2") || actionElement.equalsIgnoreCase("4") || actionElement.equalsIgnoreCase("6"))) {
                holder.openAction.setVisibility(0);
            } else {
                holder.openAction.setVisibility(8);
            }
        }
        holder.date.setText(Helper.getRelativeTimeManual(this.notificationlist.get(position).getCreated()));
        if (this.notificationlist.get(position).getViewState().equalsIgnoreCase("1")) {
            holder.rl1.setBackgroundDrawable(this.activity.getResources().getDrawable(R.drawable.notifi_selected_color));
        } else {
            Helper.applyPrimaryColorLight(this.activity, holder.rl1, 10.0f, R.drawable.discount_light_bg);
        }
        holder.removeNoti.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(position, view);
            }
        });
        OnSingleClickListener onSingleClickListener = new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onBindViewHolder$1(position);
            }
        });
        holder.rl1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onBindViewHolder$2(position);
            }
        }));
        holder.descriptionTV.setOnTextViewClickListener(new AnonymousClass1(holder));
        holder.openAction.setOnClickListener(onSingleClickListener);
        if (!TextUtils.isEmpty(this.notificationlist.get(position).getExtra().getImage())) {
            holder.notificationIV.setVisibility(0);
            Helper.loadImage(holder.notificationIV, this.notificationlist.get(position).getExtra().getImage(), R.mipmap.placeholder_course, false, false);
        } else {
            holder.notificationIV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
        this.selectedpositionid = this.notificationlist.get(i).getId();
        this.selectedposition = i;
        delete_notification_api();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$1(int i) {
        if (this.notificationlist.get(i).getViewState().equalsIgnoreCase("0")) {
            this.selectedpositionid = this.notificationlist.get(i).getId();
            this.selectedposition = i;
            hit_read_api();
        }
        if (this.notificationlist.get(i).getActionElement() == null) {
            return null;
        }
        if (this.notificationlist.get(i).getActionElement().equalsIgnoreCase("2")) {
            Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
            if ("1".equalsIgnoreCase("6")) {
                intent.putExtra(Const.FRAG_TYPE, Const.SHOW_ALL_COURSES);
            } else {
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            }
            intent.putExtra(Const.COURSE_ID_MAIN, this.notificationlist.get(i).getActionElementId());
            intent.putExtra(Const.COURSE_PARENT_ID, this.notificationlist.get(i).getExtra().getParent_id());
            intent.putExtra(Const.IS_COMBO, false);
            this.activity.startActivity(intent);
            return null;
        }
        if (this.notificationlist.get(i).getActionElement().equalsIgnoreCase("6")) {
            try {
                if (this.notificationlist.get(i).getExtra() != null && !TextUtils.isEmpty(this.notificationlist.get(i).getExtra().getUrl())) {
                    this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.notificationlist.get(i).getExtra().getUrl())));
                } else {
                    Toast.makeText(this.activity, "Link not found.", 0).show();
                }
                return null;
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(this.activity, "No application found to open this link.", 0).show();
                return null;
            }
        }
        if (this.notificationlist.get(i).getActionElement().equalsIgnoreCase("4")) {
            this.selectedposition = i;
            this.type = this.notificationlist.get(i).getExtra().getTiletype();
            hit_api_for_data();
            return null;
        }
        if (this.notificationlist.get(i).getActionElement().equalsIgnoreCase("8")) {
            if (this.notificationlist.get(i).getExtra().getStart_date() == null) {
                return null;
            }
            if (com.appnew.android.Notification.Notification.server_time > Long.parseLong(this.notificationlist.get(i).getExtra().getStart_date()) * 1000 && com.appnew.android.Notification.Notification.server_time < Long.parseLong(this.notificationlist.get(i).getExtra().getEnd_date()) * 1000) {
                if (this.notificationlist.get(i).getExtra().getCoupon_for().equalsIgnoreCase("1")) {
                    Activity activity = this.activity;
                    Toast.makeText(activity, activity.getResources().getString(R.string.eligible_for_all_courses), 0).show();
                    this.activity.finish();
                    return null;
                }
                Helper.gotoActivity_finish(new Intent(this.activity, (Class<?>) CouponActivity.class), this.activity);
                return null;
            }
            if (Long.parseLong(this.notificationlist.get(i).getExtra().getStart_date()) * 1000 > com.appnew.android.Notification.Notification.server_time) {
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.this_coupon_is_available_on) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(this.notificationlist.get(i).getExtra().getStart_date()) * 1000))), 0).show();
                return null;
            }
            if (Long.parseLong(this.notificationlist.get(i).getExtra().getEnd_date()) * 1000 >= com.appnew.android.Notification.Notification.server_time) {
                return null;
            }
            Activity activity2 = this.activity;
            Toast.makeText(activity2, activity2.getResources().getString(R.string.this_coupon_is_expired), 0).show();
            return null;
        }
        if (!this.notificationlist.get(i).getActionElement().equalsIgnoreCase("9")) {
            if (!this.notificationlist.get(i).getActionElement().equalsIgnoreCase("10")) {
                return null;
            }
            Intent intent2 = new Intent(this.activity, (Class<?>) ConversationReplyActivity.class);
            intent2.putExtra(Const.CONTATUS_ID, this.notificationlist.get(i).getExtra().getId());
            intent2.putExtra(Const.APP_ID, "166");
            this.activity.startActivity(intent2);
            return null;
        }
        if (Long.parseLong(this.notificationlist.get(i).getExtra().getResultDate()) * 1000 < System.currentTimeMillis()) {
            if (!Helper.isConnected(this.activity)) {
                Activity activity3 = this.activity;
                Toast.makeText(activity3, activity3.getResources().getString(R.string.no_internet_connection), 0).show();
                return null;
            }
            Constants.SUB_TEST_ID = this.notificationlist.get(i).getExtra().getTest_id();
            Constants.Live_TEST_COURSEID = this.notificationlist.get(i).getExtra().getCourse_id();
            Helper.GoToSubjectiveResultActivity(this.activity, this.notificationlist.get(i).getExtra().getSolutions(), this.notificationlist.get(i).getExtra().getTestSeriesName(), this.notificationlist.get(i).getExtra().getCourse_id(), this.notificationlist.get(i).getId(), Const.SUBJECTIVE_TEST);
            return null;
        }
        Toast.makeText(this.activity, this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(this.notificationlist.get(i).getExtra().getResultDate()) * 1000)), 0).show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$2(int i) {
        if (!this.notificationlist.get(i).getViewState().equalsIgnoreCase("0")) {
            return null;
        }
        this.selectedpositionid = this.notificationlist.get(i).getId();
        this.selectedposition = i;
        hit_read_api();
        return null;
    }

    /* JADX INFO: renamed from: com.appnew.android.Notification.Adapter.NotificationAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements TextViewClickListener {
        final /* synthetic */ Notification val$holder;

        @Override // com.appnew.android.Notification.readMoreTV.TextViewClickListener
        public void onReadMoreClick() {
        }

        AnonymousClass1(final Notification val$holder) {
            this.val$holder = val$holder;
        }

        @Override // com.appnew.android.Notification.readMoreTV.TextViewClickListener
        public void onReadLessClick() {
            if (NotificationAdapter.this.nestedScrollView == null) {
                return;
            }
            NestedScrollView nestedScrollView = NotificationAdapter.this.nestedScrollView;
            final Notification notification = this.val$holder;
            nestedScrollView.post(new Runnable() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReadLessClick$0(notification);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReadLessClick$0(Notification notification) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            notification.itemView.getLocationOnScreen(iArr);
            NotificationAdapter.this.nestedScrollView.getLocationOnScreen(iArr2);
            NotificationAdapter.this.nestedScrollView.smoothScrollTo(0, NotificationAdapter.this.nestedScrollView.getScrollY() + (iArr[1] - iArr2[1]));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    private void hit_api_for_data() {
        this.networkCall.NetworkAPICall(API.API_GET_MASTER_DATA, this.type, true, false);
    }

    private void hit_read_api() {
        this.networkCall.NetworkAPICall(API.mark_as_read, "", false, false);
    }

    public void delete_notification_api() {
        this.networkCall.NetworkAPICall(API.delete_notification, "", false, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.notificationlist.size();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_instructions":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(this.quiz_id);
                encryptionData.setCourse_id(this.notificationlist.get(this.selectedposition).getExtra().getCourse_id());
                return service.API_GET_TEST_INSTRUCTION_DATA(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/notification/mark_as_read":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setId(this.selectedpositionid);
                return service.setread(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_master_data":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setTile_id(this.notificationlist.get(this.selectedposition).getExtra().getTile_id());
                encryptionData3.setType(this.type);
                encryptionData3.setRevert_api("1#0#0#0#0");
                encryptionData3.setCourse_id(this.notificationlist.get(this.selectedposition).getExtra().getCourse_id());
                if (this.notificationlist.get(this.selectedposition).getExtra().getParent_id() != null) {
                    encryptionData3.setParent_id(this.notificationlist.get(this.selectedposition).getExtra().getParent_id());
                }
                encryptionData3.setLayer("3");
                encryptionData3.setPage("1");
                encryptionData3.setFile_id(this.notificationlist.get(this.selectedposition).getExtra().getFile_id());
                encryptionData3.setSubject_id("");
                encryptionData3.setTopic_id(this.notificationlist.get(this.selectedposition).getExtra().getTopic_id());
                return service.getMasterDataVideoThree(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "https://appapi.videocrypt.in/index.php/data_model/notification/delete_notification":
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setId(this.selectedpositionid);
                return service.DeleteNotification(AES.encrypt(new Gson().toJson(encryptionData4)));
            case "https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source":
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setName(this.datuml.getId() + "_0_0");
                encryptionData5.setCourse_id(this.datuml.getPayloadData().getCourse_id());
                encryptionData5.setTile_id(this.datuml.getPayloadData().getTile_id());
                encryptionData5.setType(this.datuml.getPayloadData().getTile_type());
                return service.getVideoLink(AES.encrypt(new Gson().toJson(encryptionData5)));
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_test_data":
                EncryptionData encryptionData6 = new EncryptionData();
                encryptionData6.setTest_id(this.quiz_id);
                encryptionData6.setCourse_id(this.notificationlist.get(this.selectedposition).getExtra().getCourse_id());
                return service.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData6)));
            default:
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0591 A[Catch: Exception -> 0x05fa, TryCatch #4 {Exception -> 0x05fa, blocks: (B:177:0x0587, B:179:0x0591, B:185:0x05ed, B:180:0x05d6, B:182:0x05de, B:184:0x05e5), top: B:216:0x0587 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x05d6 A[Catch: Exception -> 0x05fa, TryCatch #4 {Exception -> 0x05fa, blocks: (B:177:0x0587, B:179:0x0591, B:185:0x05ed, B:180:0x05d6, B:182:0x05de, B:184:0x05e5), top: B:216:0x0587 }] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r21, java.lang.String r22, java.lang.String r23, boolean r24) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Notification.Adapter.NotificationAdapter.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    private void pushEvent() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        map.put(AnalyticsConstants.test_name, this.testname);
        map.put("test_id", this.quiz_id);
        map.put(AnalyticsConstants.content_flag, getContentAccess());
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.TEST_ATTEMPT, map);
    }

    private String getContentAccess() {
        Video video;
        Video video2 = this.videodata;
        return ((video2 == null || TextUtils.isEmpty(video2.getIs_test_purchased()) || !this.videodata.getIs_test_purchased().equals("1")) && (video = this.videodata) != null && !TextUtils.isEmpty(video.getIs_locked()) && this.videodata.getIs_locked().equals("1")) ? "Paid" : "Free";
    }

    private void showPopUp(final InstructionData instructionData) {
        Dialog dialog;
        CheckBox checkBox;
        int i;
        View viewInflate = ((LayoutInflater) this.activity.getSystemService("layout_inflater")).inflate(R.layout.popup_basicinfo_quiz_career, (ViewGroup) null, false);
        Dialog dialog2 = new Dialog(this.activity, R.style.CustomAlertDialog);
        dialog2.requestWindowFeature(1);
        dialog2.setCanceledOnTouchOutside(true);
        dialog2.setContentView(viewInflate);
        dialog2.getWindow().setLayout(-1, -1);
        dialog2.show();
        final TestBasicInst testBasic = instructionData.getTestBasic();
        TextView textView = (TextView) viewInflate.findViewById(R.id.quizTitleTV);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.marksTextValueTV);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.section_time);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.numQuesValueTV);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.sectionValueTV);
        final TextView textView5 = (TextView) viewInflate.findViewById(R.id.languageSpinnerTV);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.quizTimeValueTV);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.remarksTV);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.check_box);
        final TextView textView8 = (TextView) viewInflate.findViewById(R.id.generalInstrValueTV);
        Button button = (Button) viewInflate.findViewById(R.id.startQuizBtn);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.sectionListLL);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.general_layout);
        if (TextUtils.isEmpty(testBasic.getLang_id())) {
            dialog = dialog2;
        } else {
            dialog = dialog2;
            this.langIds = testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA);
        }
        if (testBasic.getTest_assets() != null) {
            checkBox = checkBox2;
            if (testBasic.getTest_assets().getHide_inst_time().equalsIgnoreCase("0")) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(4);
            }
        } else {
            checkBox = checkBox2;
        }
        addSectionView(linearLayout2, instructionData);
        if (SharedPreference.getInstance().getBoolean(Const.RE_ATTEMPT)) {
            textView7.setVisibility(8);
        } else {
            textView7.setVisibility(8);
        }
        if (testBasic.getMulti_description().size() > 0) {
            linearLayout3.setVisibility(0);
            if (testBasic.getMulti_description() != null && testBasic.getMulti_description().size() > 0) {
                textView8.setText(Html.fromHtml(testBasic.getMulti_description().get(0).getDescription()));
            }
        } else if (testBasic.getDescription().isEmpty()) {
            linearLayout3.setVisibility(8);
        } else {
            linearLayout3.setVisibility(0);
            textView8.setVisibility(0);
            textView8.setText(Html.fromHtml(testBasic.getDescription()));
        }
        if (!BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
            if (testBasic.getLang_id().length() > 1) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        NotificationAdapter notificationAdapter = NotificationAdapter.this;
                        TextView textView9 = textView5;
                        TestBasicInst testBasicInst = testBasic;
                        TextView textView10 = textView8;
                        notificationAdapter.showPopMenuForLangauge1(textView9, testBasicInst, textView10, textView10);
                    }
                });
            }
            i = 0;
            if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else {
                if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                }
                i = 0;
            }
        } else {
            if (testBasic.getLang_id().length() > 2) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        NotificationAdapter.this.showPopMenuForLangauge(textView8, textView5, testBasic);
                    }
                });
            }
            i = 0;
            if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("3")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[2]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("9")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[3]);
                i = 0;
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else {
                i = 0;
                if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("6")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[4]);
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("10")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[5]);
                    i = 0;
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("11")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[6]);
                    i = 0;
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("12")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[7]);
                    i = 0;
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                } else {
                    i = 0;
                    if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("5")) {
                        textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[8]);
                        this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                    }
                }
            }
        }
        textView.setText(testBasic.getTestSeriesName());
        textView3.setText(testBasic.getTotalQuestions());
        textView6.setText(testBasic.getTimeInMins());
        textView2.setText(testBasic.getTotalMarks());
        button.setTag(testBasic);
        final Dialog dialog3 = dialog;
        final CheckBox checkBox3 = checkBox;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    Toast.makeText(NotificationAdapter.this.activity, NotificationAdapter.this.activity.getResources().getString(R.string.please_add_question), 0).show();
                    return;
                }
                if (checkBox3.isChecked()) {
                    dialog3.dismiss();
                    NotificationAdapter.this.quiz_id = testBasic.getId();
                    NotificationAdapter notificationAdapter = NotificationAdapter.this;
                    new NetworkCall(notificationAdapter, notificationAdapter.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                    return;
                }
                Toast.makeText(NotificationAdapter.this.activity, NotificationAdapter.this.activity.getResources().getString(R.string.please_check_following_instructions), 0).show();
            }
        });
        ArrayList arrayList = new ArrayList();
        int i2 = i;
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            if (!arrayList.isEmpty() && ((TestSectionInst) arrayList.get(i - 1)).getSectionId().equalsIgnoreCase(testSectionInst.getSectionId())) {
                arrayList.add(testSectionInst);
            } else {
                i2++;
                arrayList.add(testSectionInst);
            }
            i++;
        }
        textView4.setText("" + i2);
    }

    private void addSectionView(LinearLayout sectionListLL, InstructionData instructionData) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            String sectionId = testSectionInst.getSectionId();
            float floatSafe = Helper.parseFloatSafe(testSectionInst.getSectionTiming());
            if (map.containsKey(sectionId)) {
                map.merge(sectionId, Float.valueOf(floatSafe), new BiFunction() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$$ExternalSyntheticLambda8
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return Float.valueOf(Float.sum(((Float) obj).floatValue(), ((Float) obj2).floatValue()));
                    }
                });
            } else {
                map.put(sectionId, Float.valueOf(floatSafe));
            }
        }
        int i = 0;
        for (TestSectionInst testSectionInst2 : instructionData.getTestSections()) {
            String hide_inst_time = "";
            if (!arrayList.isEmpty() && ((TestSectionInst) arrayList.get(i - 1)).getSectionId().equalsIgnoreCase(testSectionInst2.getSectionId())) {
                testSectionInst2.setName("");
                testSectionInst2.setSectionTiming("");
                arrayList.add(testSectionInst2);
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    float fFloatValue = ((Float) entry.getValue()).floatValue();
                    if (str.equalsIgnoreCase(testSectionInst2.getSectionId())) {
                        testSectionInst2.setSectionTiming(String.valueOf(fFloatValue));
                    }
                }
                arrayList.add(testSectionInst2);
            }
            if (instructionData.getTestBasic().getTest_assets() != null) {
                hide_inst_time = instructionData.getTestBasic().getTest_assets().getHide_inst_time();
            }
            sectionListLL.addView(initSectionListView(testSectionInst2, i, hide_inst_time));
            i++;
        }
    }

    public LinearLayout initSectionListView(TestSectionInst testSectionInst, int tag, String hide_inst_time) {
        String string;
        int intSafe;
        ArrayList arrayList = new ArrayList();
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.layout_option_section_list_view, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.secNameTV);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.totQuesTV);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.totNoAttmtsTV);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.totTimeTV);
        TextView textView5 = (TextView) linearLayout.findViewById(R.id.maxMarksTV);
        TextView textView6 = (TextView) linearLayout.findViewById(R.id.markPerQuesTV);
        TextView textView7 = (TextView) linearLayout.findViewById(R.id.negMarkPerQuesTV);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        if (!hide_inst_time.equalsIgnoreCase("")) {
            if (hide_inst_time.equalsIgnoreCase("0")) {
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(4);
            }
        }
        if ((BuildConfig.FLAVOR.equalsIgnoreCase("mahendra") || BuildConfig.FLAVOR.equalsIgnoreCase("resodigital")) && !TextUtils.isEmpty(testSectionInst.getSection_aliase())) {
            string = testSectionInst.getSection_aliase().toString();
        } else if (!TextUtils.isEmpty(testSectionInst.getSectionPart())) {
            string = testSectionInst.getName() + "\n(" + testSectionInst.getSectionPart() + ")";
        } else {
            string = testSectionInst.getName();
        }
        textView.setText(string);
        textView2.setText(testSectionInst.getTotalQuestions());
        textView3.setText(TextUtils.isEmpty(testSectionInst.getTotalNumOfAttempts()) ? "" : testSectionInst.getTotalNumOfAttempts());
        textView4.setText(testSectionInst.getSectionTiming());
        float floatSafe = Helper.parseFloatSafe(testSectionInst.getMarksPerQuestion());
        if (!TextUtils.isEmpty(testSectionInst.getTotalNumOfAttempts())) {
            intSafe = Helper.parseIntSafe(testSectionInst.getTotalNumOfAttempts());
        } else {
            intSafe = Helper.parseIntSafe(testSectionInst.getTotalQuestions());
        }
        textView5.setText(String.valueOf(floatSafe * intSafe));
        textView6.setText(testSectionInst.getMarksPerQuestion());
        textView7.setText(String.valueOf(Helper.parseFloatSafe(testSectionInst.getNegativeMarks())));
        linearLayout.setTag(Integer.valueOf(tag));
        arrayList.add(linearLayout);
        return linearLayout;
    }

    public void showPopMenuForLangauge(final TextView textView, final View v, final TestBasicInst testBasicInst) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter.5
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.english))) {
                    NotificationAdapter.this.lang = 1;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.hindi))) {
                    NotificationAdapter.this.lang = 2;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.kannada))) {
                    NotificationAdapter.this.lang = 3;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(2).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.malayalam))) {
                    NotificationAdapter.this.lang = 4;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(3).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.marathi))) {
                    NotificationAdapter.this.lang = 5;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(4).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.odia))) {
                    NotificationAdapter.this.lang = 6;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(5).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.sanskrit))) {
                    NotificationAdapter.this.lang = 7;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(6).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.tamil))) {
                    NotificationAdapter.this.lang = 8;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(7).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.urdu))) {
                    NotificationAdapter.this.lang = 9;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(8).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.bangauli))) {
                    NotificationAdapter.this.lang = 10;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(9).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.assami))) {
                    NotificationAdapter.this.lang = 11;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(10).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.gujrati))) {
                    NotificationAdapter.this.lang = 12;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(11).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.oriya))) {
                    NotificationAdapter.this.lang = 13;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(12).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                }
                return false;
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("3")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[2]);
            }
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("4")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[3]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("5")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[4]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("6")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[5]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("7")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[6]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("8")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[7]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("9")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[8]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("10")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[9]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("11")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[10]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("12")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[11]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("13")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[12]);
            }
        }
        popupMenu.show();
    }

    public void showPopMenuForLangauge1(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vv) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter.6
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.hindi))) {
                    NotificationAdapter.this.lang = 2;
                    if (testBasicInst.getMulti_description().size() > 0 && testBasicInst.getMulti_description().get(1).getDescription() != null) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    }
                } else if (item.getTitle().toString().equals(NotificationAdapter.this.activity.getResources().getString(R.string.english))) {
                    NotificationAdapter.this.lang = 1;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
                    }
                }
                return false;
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            }
        }
        popupMenu.show();
    }

    public void openWebPage(Context context, String url) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            intent.setFlags(1073741824);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, " You don't have any browser to open the file", 1).show();
        }
    }

    public class Notification extends RecyclerView.ViewHolder {
        TextView date;
        ReadMoreTextView descriptionTV;
        ShapeableImageView notificationIV;
        TextView notification_title;
        ImageView openAction;
        ImageView removeNoti;
        ConstraintLayout rl1;

        public Notification(View itemView) {
            super(itemView);
            this.rl1 = (ConstraintLayout) itemView.findViewById(R.id.rl1);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.removeNoti);
            this.removeNoti = imageView;
            imageView.setVisibility(8);
            this.date = (TextView) itemView.findViewById(R.id.date);
            this.notification_title = (TextView) itemView.findViewById(R.id.notification_title);
            this.descriptionTV = (ReadMoreTextView) itemView.findViewById(R.id.descriptionTV);
            this.notificationIV = (ShapeableImageView) itemView.findViewById(R.id.notificationIV);
            this.openAction = (ImageView) itemView.findViewById(R.id.openAction);
        }
    }

    public String getdate(String timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp))));
    }

    private void notificationNavigation(Video video, ArrayList<Video> videoArrayList) {
        if (this.type.equalsIgnoreCase(Const.FOLDER)) {
            this.type = video.getPayloadData().getTile_type();
        }
        if (this.type.equals("video")) {
            if (video.getVideo_type().equalsIgnoreCase("9")) {
                if (video.getLive_status().equalsIgnoreCase("1")) {
                    if (video.getZoom_meeting_id().equalsIgnoreCase("") || video.getZoom_meeting_passcode().equalsIgnoreCase("")) {
                        return;
                    }
                    if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                        ZoomFeatureHelper.launchZoomFeature(this.activity, video.getZoom_meeting_id(), video.getZoom_meeting_passcode(), video.getZoom_sdk_token(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                        return;
                    } else {
                        Toast.makeText(this.activity, "Zoom SDK key not found!", 0).show();
                        return;
                    }
                }
                if (video.getLive_status().equalsIgnoreCase("2")) {
                    if (!video.getFile_url().equalsIgnoreCase("") || !video.getFile_url().isEmpty()) {
                        Intent intent = new Intent(this.activity, (Class<?>) ZoomRecodedPlayer.class);
                        intent.putExtra("videoUrl", video.getFile_url());
                        intent.putExtra(Const.VIDEO_ID, video.getId());
                        intent.putExtra("bookmark", video.getIs_bookmarked());
                        this.activity.startActivity(intent);
                        return;
                    }
                    Toast.makeText(this.activity, "No Video Found !", 0).show();
                    return;
                }
                Toast.makeText(this.activity, "Zoom class is not yet started.", 0).show();
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("7")) {
                if (video.getIs_drm().equals("0")) {
                    if (video.getIs_locked().equalsIgnoreCase("1")) {
                        Intent intent2 = new Intent(this.activity, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        this.activity.startActivity(intent2);
                        return;
                    }
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), addToList(video));
                    return;
                }
                if (video.getIs_drm().equals("1")) {
                    if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                        Activity activity = this.activity;
                        Toast.makeText(activity, activity.getResources().getString(R.string.url_is_not_found), 0).show();
                        return;
                    } else {
                        Helper.GoToVideoCryptActivity(this.activity, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), addToList(video));
                        return;
                    }
                }
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("8")) {
                if (video.getIs_drm().equals("0")) {
                    if (video.getIs_locked().equalsIgnoreCase("1")) {
                        Intent intent3 = new Intent(this.activity, (Class<?>) CourseActivity.class);
                        intent3.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent3.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                        intent3.putExtra(Const.COURSE_PARENT_ID, "");
                        intent3.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        this.activity.startActivity(intent3);
                        return;
                    }
                    if (video.getLive_status().equalsIgnoreCase("0")) {
                        Toast.makeText(this.activity, this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        return;
                    }
                    if (video.getLive_status().equalsIgnoreCase("1")) {
                        Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), addToList(video));
                        return;
                    }
                    if (video.getLive_status().equalsIgnoreCase("2")) {
                        Activity activity2 = this.activity;
                        Toast.makeText(activity2, activity2.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    } else {
                        if (video.getLive_status().equalsIgnoreCase("3")) {
                            Activity activity3 = this.activity;
                            Toast.makeText(activity3, activity3.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                            return;
                        }
                        return;
                    }
                }
                if (video.getIs_drm().equals("1")) {
                    if (video.getLive_status().equalsIgnoreCase("1")) {
                        if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                            Activity activity4 = this.activity;
                            Toast.makeText(activity4, activity4.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToVideoCryptActivity(this.activity, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), addToList(video));
                            return;
                        }
                    }
                    if (video.getLive_status().equalsIgnoreCase("0")) {
                        Toast.makeText(this.activity, this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        return;
                    }
                    if (video.getLive_status().equalsIgnoreCase("2")) {
                        Activity activity5 = this.activity;
                        Toast.makeText(activity5, activity5.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    } else {
                        if (video.getLive_status().equalsIgnoreCase("3")) {
                            Activity activity6 = this.activity;
                            Toast.makeText(activity6, activity6.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("5")) {
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    Intent intent4 = new Intent(this.activity, (Class<?>) CourseActivity.class);
                    intent4.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent4.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent4.putExtra(Const.COURSE_PARENT_ID, "");
                    intent4.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    this.activity.startActivity(intent4);
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("1")) {
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), addToList(video));
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("2")) {
                    Activity activity7 = this.activity;
                    Toast.makeText(activity7, activity7.getResources().getString(R.string.live_class_is_ended), 0).show();
                    return;
                } else {
                    if (video.getLive_status().equalsIgnoreCase("3")) {
                        Activity activity8 = this.activity;
                        Toast.makeText(activity8, activity8.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                        return;
                    }
                    return;
                }
            }
            if (video.getVideo_type().equalsIgnoreCase("0")) {
                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), addToList(video));
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("6")) {
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    Intent intent5 = new Intent(this.activity, (Class<?>) CourseActivity.class);
                    intent5.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent5.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent5.putExtra(Const.COURSE_PARENT_ID, "");
                    intent5.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    Helper.gotoActivity(intent5, this.activity);
                    return;
                }
                jwvideo(video);
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                Intent intent6 = new Intent(this.activity, (Class<?>) CourseActivity.class);
                intent6.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent6.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                intent6.putExtra(Const.COURSE_PARENT_ID, "");
                intent6.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                this.activity.startActivity(intent6);
                return;
            }
            if (video.getOpen_in_app() != null && video.getOpen_in_app().equalsIgnoreCase("1")) {
                if (video.getVideo_type().equalsIgnoreCase("4")) {
                    if (video.getLive_status().equalsIgnoreCase("0")) {
                        Toast.makeText(this.activity, this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        return;
                    }
                    if (video.getLive_status().equalsIgnoreCase("1")) {
                        if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                            Helper.showStreamSelectionBottomSheet(this.activity, video, this.selectedposition, videoArrayList);
                            return;
                        } else {
                            Helper.GoToLiveVideoActivity(video.getChat_node(), this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", "", video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                            return;
                        }
                    }
                    if (video.getLive_status().equalsIgnoreCase("2")) {
                        Activity activity9 = this.activity;
                        Toast.makeText(activity9, activity9.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    } else {
                        if (video.getLive_status().equalsIgnoreCase("3")) {
                            Activity activity10 = this.activity;
                            Toast.makeText(activity10, activity10.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                            return;
                        }
                        return;
                    }
                }
                if (video.getVideo_type().equalsIgnoreCase("1")) {
                    if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                        Helper.showStreamSelectionBottomSheet(this.activity, video, this.selectedposition, videoArrayList);
                        return;
                    } else {
                        Helper.GoToLiveVideoActivity(video.getChat_node(), this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", "", video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                        return;
                    }
                }
                return;
            }
            this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + video.getFile_url())));
            return;
        }
        if (this.type.equals(Const.PDF) || this.type.equals(Const.CONCEPT) || this.type.equals("link")) {
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                Intent intent7 = new Intent(this.activity, (Class<?>) CourseActivity.class);
                intent7.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent7.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                intent7.putExtra(Const.COURSE_PARENT_ID, "");
                intent7.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                Helper.gotoActivity(intent7, this.activity);
                return;
            }
            if (!video.getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(video.getFile_url())) {
                Activity activity11 = this.activity;
                Toast.makeText(activity11, activity11.getResources().getString(R.string.no_pdf_found), 0).show();
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("8")) {
                openWebPage(this.activity, video.getFile_url());
            }
            if (video.getFile_type().equalsIgnoreCase("7")) {
                Intent intent8 = new Intent(this.activity, (Class<?>) Concept_newActivity.class);
                intent8.putExtra("id", video.getId());
                intent8.putExtra("name", video.getTitle());
                intent8.putExtra("course_id", video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
                intent8.putExtra(StoreProvider.StoreData.MODIFIED_DATE, video.getModified());
                intent8.putExtra("tile_id", video.getPayloadData().getTile_id());
                Helper.gotoActivity(intent8, this.activity);
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("1")) {
                Helper.GoToWebViewPDFActivity(this.activity, video.getId(), video.getFile_url(), !TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1"), video.getTitle(), video.getPayloadData().getCourse_id(), video.getIs_share());
                return;
            }
            return;
        }
        if (this.type.equals(Const.TEST)) {
            inittest(videoArrayList);
            return;
        }
        if (this.type.equalsIgnoreCase(Const.SUBJECTIVE_TEST) || this.type.equalsIgnoreCase(Const.Daily_assignment)) {
            showsubjectivepopup(videoArrayList);
            return;
        }
        if (this.type.equalsIgnoreCase("image")) {
            Intent intent9 = new Intent(this.activity, (Class<?>) NotificationDescription.class);
            intent9.putExtra("urlType", "IMAGE");
            intent9.putExtra("title", video.getTitle());
            intent9.putExtra("url", video.getFile_url());
            intent9.putExtra("description", video.getDescription());
            Helper.gotoActivity(intent9, this.activity);
            return;
        }
        this.type = "";
    }

    private ArrayList<Video> addToList(Video video) {
        ArrayList<Video> arrayList = new ArrayList<>();
        arrayList.add(video);
        return arrayList;
    }

    private void showsubjectivepopup(ArrayList<Video> videoArrayList) {
        Button button;
        Button button2;
        Button button3;
        final Button button4;
        ((com.appnew.android.Notification.Notification) this.activity).video = videoArrayList.get(0);
        this.video = videoArrayList.get(0);
        View viewInflate = ((LayoutInflater) this.activity.getSystemService("layout_inflater")).inflate(R.layout.subjectivepopup, (ViewGroup) null, false);
        final Dialog dialog = new Dialog(this.activity, R.style.CustomAlertDialog);
        dialog.requestWindowFeature(1);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(viewInflate);
        dialog.getWindow().setLayout(-1, -1);
        dialog.show();
        Constants.SUB_TEST_ID = videoArrayList.get(0).getId();
        TextView textView = (TextView) viewInflate.findViewById(R.id.ibt_single_sub_vd_tv_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.durationTV);
        Button button5 = (Button) viewInflate.findViewById(R.id.paper);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ibt_single_sub_vd_iv);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.backimag);
        AppCompatTextView appCompatTextView = (AppCompatTextView) viewInflate.findViewById(R.id.test_name);
        Button button6 = (Button) viewInflate.findViewById(R.id.upload);
        Button button7 = (Button) viewInflate.findViewById(R.id.booklet);
        Button button8 = (Button) viewInflate.findViewById(R.id.marks);
        if (!this.video.getEnd_date().equalsIgnoreCase("0") && !this.video.getEnd_date().equalsIgnoreCase("")) {
            textView2.setVisibility(0);
            button = button8;
            button3 = button7;
            button2 = button6;
            textView2.setText("Test Start: " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(this.video.getStart_date()) * 1000))) + "\nTest End: " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(this.video.getEnd_date()) * 1000))));
        } else {
            button = button8;
            button2 = button6;
            button3 = button7;
            textView2.setVisibility(8);
        }
        appCompatTextView.setText(this.video.getTest_series_name());
        textView.setText(this.video.getTest_series_name());
        if (this.video.getImage() == null || this.video.getImage().equalsIgnoreCase("")) {
            imageView.setImageResource(R.mipmap.square_placeholder);
        } else {
            Helper.setThumbnailImage(this.activity, this.video.getImage(), this.activity.getDrawable(R.mipmap.square_placeholder), imageView);
        }
        if (this.video.getAttempt().equalsIgnoreCase("0")) {
            button4 = button2;
            button4.setText("Upload");
        } else {
            button4 = button2;
            button4.setText("View");
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationAdapter.lambda$showsubjectivepopup$3(dialog, view);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showsubjectivepopup$4(view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showsubjectivepopup$5(button4, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showsubjectivepopup$6(view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.Adapter.NotificationAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showsubjectivepopup$7(view);
            }
        });
    }

    static /* synthetic */ void lambda$showsubjectivepopup$3(Dialog dialog, View view) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showsubjectivepopup$4(View view) {
        if (System.currentTimeMillis() < Long.parseLong(this.video.getStart_date()) * 1000) {
            Toast.makeText(this.activity, "Test will start on " + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(this.video.getStart_date()) * 1000)), 0).show();
            return;
        }
        if (!Helper.isConnected(this.activity)) {
            Toast.makeText(this.activity, "No Internet Connection", 0).show();
            return;
        }
        if (this.video.getIs_locked().equalsIgnoreCase("1")) {
            Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent.putExtra(Const.COURSE_ID_MAIN, this.video.getPayloadData().getCourse_id());
            intent.putExtra(Const.COURSE_PARENT_ID, "");
            intent.putExtra(Const.IS_COMBO, false);
            SharedPreference.getInstance().putString("id", this.video.getPayloadData().getCourse_id());
            this.activity.startActivity(intent);
            return;
        }
        if (!this.video.getQuestion().equalsIgnoreCase("")) {
            Constants.SUB_TEST_ID = this.video.getId();
            Helper.GoToWebViewPDFActivity(this.activity, this.video.getId(), this.video.getQuestion(), true, this.video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r9.length - 1].split("\\.")[0], this.video.getPayloadData().getCourse_id(), this.video.getIs_share());
            return;
        }
        Toast.makeText(this.activity, "File not found.", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showsubjectivepopup$5(Button button, View view) {
        if (button.getText().toString().equalsIgnoreCase("View")) {
            Intent intent = new Intent(this.activity, (Class<?>) PdfDetailScreen.class);
            intent.putExtra(Const.THUMBNAIL, this.video.getThumbnail_url());
            intent.putExtra("url", this.video.getAnswers_by_student());
            intent.putExtra(Const.FORWHAT, "forNotification");
            this.activity.startActivity(intent);
            return;
        }
        if (System.currentTimeMillis() < Long.parseLong(this.video.getStart_date()) * 1000) {
            Toast.makeText(this.activity, "Test will start on " + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(this.video.getStart_date()) * 1000)), 0).show();
            return;
        }
        if (!Helper.isConnected(this.activity)) {
            Toast.makeText(this.activity, "No Internet Connection", 0).show();
            return;
        }
        if (this.video.getIs_locked().equalsIgnoreCase("1")) {
            Intent intent2 = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent2.putExtra(Const.COURSE_ID_MAIN, this.video.getPayloadData().getCourse_id());
            intent2.putExtra(Const.COURSE_PARENT_ID, "");
            intent2.putExtra(Const.IS_COMBO, false);
            SharedPreference.getInstance().putString("id", this.video.getPayloadData().getCourse_id());
            this.activity.startActivity(intent2);
            return;
        }
        Constants.SUB_TEST_ID = this.video.getId();
        checkStoragePermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showsubjectivepopup$6(View view) {
        if (Long.parseLong(this.video.getResult_date()) * 1000 < System.currentTimeMillis()) {
            if (!Helper.isConnected(this.activity)) {
                Toast.makeText(this.activity, "No Internet Connection", 0).show();
                return;
            }
            if (this.video.getIs_locked().equalsIgnoreCase("1")) {
                Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, this.video.getPayloadData().getCourse_id());
                intent.putExtra(Const.COURSE_PARENT_ID, "");
                intent.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", this.video.getPayloadData().getCourse_id());
                this.activity.startActivity(intent);
                return;
            }
            if (!this.video.getAnswers().equalsIgnoreCase("")) {
                Constants.SUB_TEST_ID = this.video.getId();
                Helper.GoToWebViewPDFActivity(this.activity, this.video.getId(), this.video.getAnswers(), true, this.video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r9.length - 1].split("\\.")[0], this.video.getPayloadData().getCourse_id(), this.video.getIs_share());
                return;
            }
            Toast.makeText(this.activity, "File Not found.", 0).show();
            return;
        }
        Toast.makeText(this.activity, "Result will be available on " + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(this.video.getResult_date()) * 1000)), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showsubjectivepopup$7(View view) {
        if (Long.parseLong(this.video.getResult_date()) * 1000 < System.currentTimeMillis()) {
            if (!Helper.isConnected(this.activity)) {
                Toast.makeText(this.activity, "No Internet Connection", 0).show();
                return;
            }
            if (this.video.getIs_locked().equalsIgnoreCase("1")) {
                Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, this.video.getPayloadData().getCourse_id());
                intent.putExtra(Const.COURSE_PARENT_ID, "");
                intent.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", this.video.getPayloadData().getCourse_id());
                this.activity.startActivity(intent);
                return;
            }
            Constants.SUB_TEST_ID = this.video.getId();
            Helper.GoToSubjectiveResultActivity(this.activity, this.video.getSolutions(), this.video.getTest_series_name(), this.video.getPayloadData().getCourse_id(), this.video.getId(), this.type);
            return;
        }
        Toast.makeText(this.activity, "Result will be available on " + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(this.video.getResult_date()) * 1000)), 0).show();
    }

    private void inittest(ArrayList<Video> videoArrayList) {
        if (videoArrayList.get(0).getIs_locked().equalsIgnoreCase("1")) {
            Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent.putExtra(Const.COURSE_ID_MAIN, videoArrayList.get(0).getPayloadData().getCourse_id());
            intent.putExtra(Const.COURSE_PARENT_ID, "");
            intent.putExtra(Const.IS_COMBO, false);
            SharedPreference.getInstance().putString("id", videoArrayList.get(0).getPayloadData().getCourse_id());
            this.activity.startActivity(intent);
            return;
        }
        if (videoArrayList.get(0).getState().equals("1")) {
            if (videoArrayList.get(0).getResult_date().equalsIgnoreCase("") || videoArrayList.get(0).getResult_date().equalsIgnoreCase("1") || videoArrayList.get(0).getResult_date().equalsIgnoreCase("0")) {
                if (videoArrayList.get(0).getState().equalsIgnoreCase("1")) {
                    this.first_attempt = "1";
                } else {
                    this.first_attempt = "1";
                }
                Intent intent2 = new Intent(this.activity, (Class<?>) QuizActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                intent2.putExtra("status", videoArrayList.get(0).getId());
                intent2.putExtra("name", videoArrayList.get(0).getTest_series_name());
                intent2.putExtra("first_attempt", this.first_attempt);
                Helper.gotoActivity(intent2, this.activity);
                return;
            }
            if (MakeMyExam.getTime_server() <= Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000) {
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000)), 0).show();
                return;
            }
            if (Long.parseLong(videoArrayList.get(0).getEnd_date()) < 1640066737) {
                this.submition_type = "1";
                this.quiz_id = videoArrayList.get(0).getId();
                this.first_attempt = "0";
                this.result_date = videoArrayList.get(0).getResult_date();
                SharedPreference.getInstance().putString("id", videoArrayList.get(0).getPayloadData().getCourse_id());
                this.testname = videoArrayList.get(0).getTest_series_name();
                this.testquestion = videoArrayList.get(0).getTotal_questions();
                this.videodata = videoArrayList.get(0);
                if (this.video.getMode().equalsIgnoreCase("1")) {
                    Toast.makeText(this.activity, "You can attempt the test offline from your test center", 0).show();
                    return;
                } else {
                    hit_api_for_iniializetest();
                    return;
                }
            }
            if (videoArrayList.get(0).getState().equalsIgnoreCase("1")) {
                this.first_attempt = "1";
            } else {
                this.first_attempt = "1";
            }
            Intent intent3 = new Intent(this.activity, (Class<?>) QuizActivity.class);
            intent3.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
            intent3.putExtra("status", videoArrayList.get(0).getId());
            intent3.putExtra("name", videoArrayList.get(0).getTest_series_name());
            intent3.putExtra("first_attempt", this.first_attempt);
            Helper.gotoActivity(intent3, this.activity);
            return;
        }
        if (MakeMyExam.getTime_server() < Long.parseLong(videoArrayList.get(0).getEnd_date()) * 1000) {
            if (MakeMyExam.getTime_server() < Long.parseLong(videoArrayList.get(0).getStart_date()) * 1000) {
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getStart_date()) * 1000)), 0).show();
                return;
            }
            TestTable testTableTest_data = this.utkashRoom.getTestDao().test_data(videoArrayList.get(0).getId(), MakeMyExam.userId);
            if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                Activity activity = this.activity;
                Toast.makeText(activity, activity.getResources().getString(R.string.you_have_already_attempted_the_test), 0).show();
                return;
            } else {
                this.first_attempt = "1";
                this.submition_type = videoArrayList.get(0).getSubmission_type();
                inittest(videoArrayList.get(0));
                return;
            }
        }
        if (Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000 > MakeMyExam.getTime_server()) {
            Toast.makeText(this.activity, this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000)), 0).show();
            return;
        }
        if (MakeMyExam.getTime_server() > Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000) {
            if (Long.parseLong(videoArrayList.get(0).getEnd_date()) < 1640066737) {
                this.submition_type = "1";
                this.quiz_id = videoArrayList.get(0).getId();
                this.first_attempt = "0";
                this.result_date = videoArrayList.get(0).getResult_date();
                SharedPreference.getInstance().putString("id", videoArrayList.get(0).getPayloadData().getCourse_id());
                this.testname = videoArrayList.get(0).getTest_series_name();
                this.testquestion = videoArrayList.get(0).getTotal_questions();
                this.videodata = videoArrayList.get(0);
                if (this.video.getMode().equalsIgnoreCase("1")) {
                    Toast.makeText(this.activity, "You can attempt the test offline from your test center", 0).show();
                    return;
                } else {
                    hit_api_for_iniializetest();
                    return;
                }
            }
            Intent intent4 = new Intent(this.activity, (Class<?>) QuizActivity.class);
            intent4.putExtra(Const.FRAG_TYPE, "leader_board");
            intent4.putExtra("status", videoArrayList.get(0).getId());
            intent4.putExtra("name", videoArrayList.get(0).getTest_series_name());
            Helper.gotoActivity(intent4, this.activity);
        }
    }

    private void inittest(Video video) {
        if (video.getIs_locked().equalsIgnoreCase("1")) {
            Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
            intent.putExtra(Const.COURSE_PARENT_ID, "");
            intent.putExtra(Const.IS_COMBO, false);
            SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
            this.activity.startActivity(intent);
            return;
        }
        this.quiz_id = video.getId();
        this.first_attempt = "1";
        this.result_date = video.getResult_date();
        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
        this.testname = video.getTest_series_name();
        this.testquestion = video.getTotal_questions();
        this.videodata = video;
        if (video.getMode().equalsIgnoreCase("1")) {
            Toast.makeText(this.activity, "You can attempt the test offline from your test center", 0).show();
        } else {
            hit_api_for_iniializetest();
        }
    }

    private void checkStoragePermission() {
        OpenChooser();
    }

    private void OpenChooser() {
        if (this.STORAGE_PERMISSION_TYPE == 3) {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/pdf");
            intent.putExtra("android.provider.extra.INITIAL_URI", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
            this.activity.startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 1203);
        }
    }

    public void hit_api_for_iniializetest() {
        new NetworkCall(this, this.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
    }

    private void jwvideo(Video videoData) {
        this.datuml = videoData;
        this.networkCall.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", true, false);
    }

    private void setupReadMore(final TextView descriptionTV) {
        ReadMoreTextView readMoreTextView = new ReadMoreTextView(this.activity);
        ReadMoreTextView.INSTANCE.setDEFAULT_TRIM_LENGTH(descriptionTV.getText().length());
        ReadMoreTextView.INSTANCE.setDEFAULT_TRIM_LINES(3);
        readMoreTextView.setCollapsedText(this.activity.getResources().getString(R.string.resizable_text_read_more));
        readMoreTextView.setExpandedText(this.activity.getResources().getString(R.string.resizable_text_read_less));
    }

    private static String removeImagesFromHtml(String html) {
        return html.replaceAll("<img.*?>", "");
    }
}
