package com.appnew.android.LiveClass.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
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
import androidx.media3.common.util.Util;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.PdfListActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.AudioPlayerActivty;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.UrlObject;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.ZoomFeatureHelper;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.appnew.android.home.liveclasses.Datum;
import com.appnew.android.table.AudioTable;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.VideoTable;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class Liveclassadapter extends RecyclerView.Adapter<Livevideoviewholder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    BottomSetting bottomSetting;
    ArrayList<Datum> data;
    Datum datuml;
    private String fromTab;
    boolean is_audio;
    LeftMenu leftMenu;
    ThemeSettings themeSettings;
    Long time;
    UtkashRoom utkashRoom;

    public Liveclassadapter(Activity activity, ArrayList<Datum> data, Long time) {
        this.fromTab = "";
        this.is_audio = false;
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.activity = activity;
        this.data = data;
        this.time = time;
    }

    public Liveclassadapter(Activity activity, ArrayList<Datum> data, Long time, String fromTab) {
        this.fromTab = "";
        this.is_audio = false;
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.activity = activity;
        this.data = data;
        this.time = time;
        this.fromTab = fromTab;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Livevideoviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        if (this.themeSettings != null) {
            this.themeSettings = this.utkashRoom.getthemeSettingdao().data();
            this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
        if ("1".equalsIgnoreCase("5")) {
            viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_class_adapter_theme5, parent, false);
        } else {
            viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_class_adapter, parent, false);
        }
        return new Livevideoviewholder(viewInflate);
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [com.appnew.android.LiveClass.Adapter.Liveclassadapter$1] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final Livevideoviewholder holder, final int position) {
        holder.title.setText(this.data.get(position).getTitle());
        holder.watch_now.setVisibility(8);
        if (this.fromTab.equalsIgnoreCase(Const.COMPLETED)) {
            if (SharedPreference.getInstance().getString(Const.AUDIO_LISTEN).equalsIgnoreCase("1") && !this.data.get(position).getVideoType().equalsIgnoreCase("1") && !this.data.get(position).getVideoType().equalsIgnoreCase("4") && !this.data.get(position).getVideoType().equalsIgnoreCase("8") && !this.data.get(position).getIsdrm().equals("1")) {
                holder.listne_now.setVisibility(0);
                if (AudioPlayerService.isAudioPlaying && AudioPlayerService.videoid.equalsIgnoreCase(this.data.get(position).getId())) {
                    holder.listne_now.setText(this.activity.getResources().getString(R.string.stop));
                } else {
                    holder.listne_now.setText(this.activity.getResources().getString(R.string.listen_));
                }
            } else {
                holder.listne_now.setVisibility(8);
            }
        }
        if (Helper.isShowShareButton(this.leftMenu)) {
            holder.share.setVisibility(0);
        } else {
            holder.share.setVisibility(8);
        }
        holder.maincard.setEnabled(false);
        if (this.data.get(position).getCourse_name() == null) {
            holder.course_name.setVisibility(8);
        } else {
            holder.course_name.setText(this.data.get(position).getCourse_name());
        }
        holder.timing.setText("Start Date: " + new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(this.data.get(position).getStartdate()) * 1000)));
        holder.timerr = 0L;
        holder.timerr = (Long.parseLong(this.data.get(position).getStartdate()) * 1000) - (this.time.longValue() * 1000);
        holder.timer = new CountDownTimer(holder.timerr, holder.timecount) { // from class: com.appnew.android.LiveClass.Adapter.Liveclassadapter.1
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                holder.time.setText(Liveclassadapter.this.concerter(millisUntilFinished));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                holder.time.setText("00:00:00");
                Liveclassadapter.this.notifyadap(holder, position);
            }
        }.start();
        if (this.data.get(position).getLiveStatus() != null && this.data.get(position).getLiveStatus().equals("1")) {
            holder.liveIV.setVisibility(0);
        } else {
            holder.liveIV.setVisibility(8);
        }
        if (this.data.get(position).getLiveStatus() != null) {
            if (this.data.get(position).getVideoType().equalsIgnoreCase("9")) {
                if (this.data.get(position).getLiveStatus().equals("1")) {
                    holder.liveIV.setVisibility(0);
                } else {
                    holder.liveIV.setVisibility(8);
                }
            }
        } else {
            holder.liveIV.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.data.get(position).getThumbnailUrl())) {
            setThumbAccordingRatio(this.data.get(position).getThumbnailUrl(), holder.courseImage);
        } else {
            holder.courseImage.setImageResource(R.mipmap.square_placeholder_new);
        }
        holder.watch_now.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.LiveClass.Adapter.Liveclassadapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onBindViewHolder$0(position);
            }
        }));
        holder.listne_now.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.LiveClass.Adapter.Liveclassadapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onBindViewHolder$1(holder, position);
            }
        }));
        if (SharedPreference.getInstance().getString(Const.PDFVIEW_ON_VIDEOLIST).equalsIgnoreCase("1") && !TextUtils.isEmpty(this.data.get(position).getHad_pdf()) && this.data.get(position).getHad_pdf().equalsIgnoreCase("1")) {
            holder.pdf_TV.setVisibility(0);
            holder.pdf_TV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveClass.Adapter.Liveclassadapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (!Helper.isConnected(Liveclassadapter.this.activity)) {
                        Toast.makeText(Liveclassadapter.this.activity, Liveclassadapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                        return;
                    }
                    Intent intent = new Intent(Liveclassadapter.this.activity, (Class<?>) PdfListActivity.class);
                    intent.putExtra(Const.VIDEO_ID, Liveclassadapter.this.data.get(position).getId());
                    intent.putExtra("course_id", Liveclassadapter.this.data.get(position).getPayload().getCourse_id());
                    Helper.gotoActivity(intent, Liveclassadapter.this.activity);
                }
            });
        } else {
            holder.pdf_TV.setVisibility(8);
        }
        holder.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.LiveClass.Adapter.Liveclassadapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onBindViewHolder$2(position);
            }
        }));
        setDateTimeForKrantikari(holder.itemView, this.data.get(position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(int i) {
        if (Helper.isNetworkConnected(this.activity)) {
            this.is_audio = false;
            Helper.audio_service_close(this.activity);
            if (this.data.get(i).getVideoType().equalsIgnoreCase("5")) {
                if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                    if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                        Activity activity = this.activity;
                        Toast.makeText(activity, activity.getResources().getString(R.string.url_is_not_found), 0).show();
                    } else {
                        Helper.GoToLiveAwsVideoActivityDatumLiveCls(this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), "5", this.data.get(i).getId(), this.data.get(i).getTitle(), "0", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getStartdate(), this.data);
                    }
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("0")) {
                    Activity activity2 = this.activity;
                    Toast.makeText(activity2, activity2.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                    Activity activity3 = this.activity;
                    Toast.makeText(activity3, activity3.getResources().getString(R.string.live_class_is_ended), 0).show();
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("3")) {
                    Activity activity4 = this.activity;
                    Toast.makeText(activity4, activity4.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("4")) {
                if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                    if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                        Activity activity5 = this.activity;
                        Toast.makeText(activity5, activity5.getResources().getString(R.string.url_is_not_found), 0).show();
                    } else if (this.data.get(i).getOpenInApp().equalsIgnoreCase("1")) {
                        if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                            Helper.showStreamSelectionBottomSheetLive(this.activity, this.data.get(i), i, this.data);
                        } else {
                            Helper.GoToLiveVideoActivity(this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), this.data.get(i).getVideoType(), this.data.get(i).getId(), this.data.get(i).getTitle(), "0", this.data.get(i).getThumbnailUrl(), this.data.get(i).getIschatlock(), this.data.get(i).getPayload().getCourse_id(), String.valueOf(i), "", this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIs_live(), new ArrayList());
                        }
                    } else {
                        this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + this.data.get(i).getFileUrl())));
                    }
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("0")) {
                    Activity activity6 = this.activity;
                    Toast.makeText(activity6, activity6.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                    Activity activity7 = this.activity;
                    Toast.makeText(activity7, activity7.getResources().getString(R.string.live_class_is_ended), 0).show();
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("3")) {
                    Activity activity8 = this.activity;
                    Toast.makeText(activity8, activity8.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("0")) {
                Helper.GoToLiveAwsVideoActivityDatumLiveCls(this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.activity, this.data.get(i).getId(), this.data.get(i).getVideoType(), this.data.get(i).getId(), this.data.get(i).getTitle(), "0", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getStartdate(), this.data);
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("1")) {
                if (this.data.get(i).getOpenInApp() != null && this.data.get(i).getOpenInApp().equalsIgnoreCase("1")) {
                    if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                        Helper.showStreamSelectionBottomSheetLive(this.activity, this.data.get(i), i, this.data);
                    } else {
                        Helper.GoToLiveVideoActivity(this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), this.data.get(i).getIs_live(), this.data.get(i).getId(), this.data.get(i).getTitle(), "0", this.data.get(i).getThumbnailUrl(), this.data.get(i).getIschatlock(), this.data.get(i).getPayload().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIs_live(), new ArrayList());
                    }
                } else {
                    this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + this.data.get(i).getFileUrl())));
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("6")) {
                this.datuml = this.data.get(i);
                new NetworkCall(this, this.activity).NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", true, false);
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("7")) {
                if (this.data.get(i).getIsdrm().equals("0")) {
                    if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                        Activity activity9 = this.activity;
                        Toast.makeText(activity9, activity9.getResources().getString(R.string.url_is_not_found), 0).show();
                    } else {
                        Helper.GoToLiveAwsVideoActivityDatumLiveCls(this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), "0", this.data.get(i).getId(), this.data.get(i).getTitle(), "0", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), "", this.data.get(i).getStartdate(), this.data);
                    }
                } else if (this.data.get(i).getIsdrm().equals("1")) {
                    if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                        Activity activity10 = this.activity;
                        Toast.makeText(activity10, activity10.getResources().getString(R.string.url_is_not_found), 0).show();
                    } else {
                        Helper.GoToDumVideoCryptActivity(this.activity, this.data.get(i).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.data.get(i).getId(), this.data.get(i).getVideoType(), this.data.get(i).getId(), this.data.get(i).getTitle(), "0", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getStartdate(), "0", this.data);
                    }
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("8")) {
                if (this.data.get(i).getIsdrm().equals("0")) {
                    if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                        if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                            Activity activity11 = this.activity;
                            Toast.makeText(activity11, activity11.getResources().getString(R.string.url_is_not_found), 0).show();
                        } else {
                            Helper.GoToLiveAwsVideoActivityDatumLiveCls(this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), "5", this.data.get(i).getId(), this.data.get(i).getTitle(), "0", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), "", this.data.get(i).getStartdate(), this.data);
                        }
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("0")) {
                        Activity activity12 = this.activity;
                        Toast.makeText(activity12, activity12.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                        Activity activity13 = this.activity;
                        Toast.makeText(activity13, activity13.getResources().getString(R.string.live_class_is_ended), 0).show();
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("3")) {
                        Activity activity14 = this.activity;
                        Toast.makeText(activity14, activity14.getResources().getString(R.string.live_class_is_ended), 0).show();
                    }
                } else if (this.data.get(i).getIsdrm().equals("1")) {
                    if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                        if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                            Activity activity15 = this.activity;
                            Toast.makeText(activity15, activity15.getResources().getString(R.string.url_is_not_found), 0).show();
                        } else {
                            Helper.GoToDumVideoCryptActivity(this.activity, this.data.get(i).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.data.get(i).getId(), this.data.get(i).getVideoType(), this.data.get(i).getId(), this.data.get(i).getTitle(), "0", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getStartdate(), "0", this.data);
                        }
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("0")) {
                        Activity activity16 = this.activity;
                        Toast.makeText(activity16, activity16.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                        Activity activity17 = this.activity;
                        Toast.makeText(activity17, activity17.getResources().getString(R.string.live_class_is_ended), 0).show();
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("3")) {
                        Activity activity18 = this.activity;
                        Toast.makeText(activity18, activity18.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                    }
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("9")) {
                if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                    if (!this.data.get(i).getZoom_meeting_id().equalsIgnoreCase("") || !this.data.get(i).getZoom_meeting_passcode().equalsIgnoreCase("")) {
                        if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                            ZoomFeatureHelper.launchZoomFeature(this.activity, this.data.get(i).getZoom_meeting_id(), this.data.get(i).getZoom_meeting_passcode(), this.data.get(i).getZoom_sdk_token(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                        } else {
                            Toast.makeText(this.activity, "Zoom SDK key not found!", 0).show();
                        }
                    }
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                    if (!this.data.get(i).getFileUrl().equalsIgnoreCase("") || !this.data.get(i).getFileUrl().isEmpty()) {
                        Intent intent = new Intent(this.activity, (Class<?>) ZoomRecodedPlayer.class);
                        intent.putExtra("videoUrl", this.data.get(i).getFileUrl());
                        intent.putExtra(Const.VIDEO_ID, this.data.get(i).getId());
                        this.activity.startActivity(intent);
                    } else {
                        Toast.makeText(this.activity, "No Video Found !", 0).show();
                    }
                } else {
                    Toast.makeText(this.activity, "Zoom class is not yet started.", 0).show();
                }
            } else if (!this.data.get(i).getFileUrl().equalsIgnoreCase("") || !this.data.get(i).getFileUrl().isEmpty()) {
                Intent intent2 = new Intent(this.activity, (Class<?>) ZoomRecodedPlayer.class);
                intent2.putExtra("videoUrl", this.data.get(i).getFileUrl());
                intent2.putExtra(Const.VIDEO_ID, this.data.get(i).getId());
                this.activity.startActivity(intent2);
            } else {
                Toast.makeText(this.activity, "No Video Found yet please some time !", 0).show();
            }
            return null;
        }
        Helper.showInternetToast(this.activity);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$1(Livevideoviewholder livevideoviewholder, int i) {
        if (Helper.isNetworkConnected(this.activity)) {
            try {
                if (livevideoviewholder.listne_now.getText().toString().equalsIgnoreCase("STOP")) {
                    try {
                        Helper.audio_service_close(this.activity);
                        notifyDataSetChanged();
                    } catch (Exception unused) {
                    }
                    return null;
                }
                try {
                    Helper.audio_service_close(this.activity);
                    notifyDataSetChanged();
                } catch (Exception e2) {
                    Log.e("TAG", "onBindViewHolder: " + e2.getLocalizedMessage());
                }
            } catch (Exception e3) {
                Log.e("Exception: ", "holder.listne_now click --> " + e3.getLocalizedMessage());
            }
            SharedPreference.getInstance().putString("OnListenClick", "OnListenClick");
            if (this.data.get(i).getVideoType().equalsIgnoreCase("5")) {
                if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                    if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                        Activity activity = this.activity;
                        Toast.makeText(activity, activity.getResources().getString(R.string.url_is_not_found), 0).show();
                    } else {
                        Helper.GoToLiveAwsVideoActivityDatumLiveCls(this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), "5", this.data.get(i).getId(), this.data.get(i).getTitle(), "1", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), "", this.data.get(i).getStartdate(), this.data);
                    }
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("0")) {
                    Activity activity2 = this.activity;
                    Toast.makeText(activity2, activity2.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                    Activity activity3 = this.activity;
                    Toast.makeText(activity3, activity3.getResources().getString(R.string.live_class_is_ended), 0).show();
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("3")) {
                    Activity activity4 = this.activity;
                    Toast.makeText(activity4, activity4.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("4")) {
                if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                    if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                        Activity activity5 = this.activity;
                        Toast.makeText(activity5, activity5.getResources().getString(R.string.url_is_not_found), 0).show();
                    } else if (this.data.get(i).getOpenInApp().equalsIgnoreCase("1")) {
                        Helper.GoToLiveVideoActivity(this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), this.data.get(i).getVideoType(), this.data.get(i).getId(), this.data.get(i).getTitle(), "1", this.data.get(i).getThumbnailUrl(), this.data.get(i).getIschatlock(), this.data.get(i).getPayload().getCourse_id(), String.valueOf(i), "", this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIs_live(), new ArrayList());
                    } else {
                        this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + this.data.get(i).getFileUrl())));
                    }
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("0")) {
                    Activity activity6 = this.activity;
                    Toast.makeText(activity6, activity6.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                    Activity activity7 = this.activity;
                    Toast.makeText(activity7, activity7.getResources().getString(R.string.live_class_is_ended), 0).show();
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("3")) {
                    Activity activity8 = this.activity;
                    Toast.makeText(activity8, activity8.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("0")) {
                Helper.GoToLiveAwsVideoActivityDatumLiveCls(this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.activity, this.data.get(i).getId(), this.data.get(i).getVideoType(), this.data.get(i).getId(), this.data.get(i).getTitle(), "1", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getStartdate(), this.data);
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("1")) {
                if (this.data.get(i).getOpenInApp() != null && this.data.get(i).getOpenInApp().equalsIgnoreCase("1")) {
                    Helper.GoToLiveVideoActivity(this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), this.data.get(i).getIs_live(), this.data.get(i).getId(), this.data.get(i).getTitle(), "1", this.data.get(i).getThumbnailUrl(), this.data.get(i).getIschatlock(), this.data.get(i).getPayload().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIs_live(), new ArrayList());
                } else {
                    this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + this.data.get(i).getFileUrl())));
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("6")) {
                this.datuml = this.data.get(i);
                new NetworkCall(this, this.activity).NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", true, false);
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("7")) {
                if (this.data.get(i).getIsdrm().equals("0")) {
                    if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                        Activity activity9 = this.activity;
                        Toast.makeText(activity9, activity9.getResources().getString(R.string.url_is_not_found), 0).show();
                    } else {
                        Helper.GoToLiveAwsVideoActivityDatumLiveCls(this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), "0", this.data.get(i).getId(), this.data.get(i).getTitle(), "1", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getStartdate(), this.data);
                    }
                } else if (this.data.get(i).getIsdrm().equals("1")) {
                    if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                        Activity activity10 = this.activity;
                        Toast.makeText(activity10, activity10.getResources().getString(R.string.url_is_not_found), 0).show();
                    } else {
                        Helper.GoToDumVideoCryptActivity(this.activity, this.data.get(i).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.data.get(i).getId(), this.data.get(i).getVideoType(), this.data.get(i).getId(), this.data.get(i).getTitle(), "1", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getStartdate(), "0", this.data);
                    }
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("8")) {
                if (this.data.get(i).getIsdrm().equals("0")) {
                    if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                        if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                            Activity activity11 = this.activity;
                            Toast.makeText(activity11, activity11.getResources().getString(R.string.url_is_not_found), 0).show();
                        } else {
                            Helper.GoToLiveAwsVideoActivity(this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.activity, this.data.get(i).getFileUrl(), "5", this.data.get(i).getId(), this.data.get(i).getTitle(), "1", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), "", "", this.data.get(i).getStartdate(), new ArrayList());
                        }
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("0")) {
                        Activity activity12 = this.activity;
                        Toast.makeText(activity12, activity12.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                        Activity activity13 = this.activity;
                        Toast.makeText(activity13, activity13.getResources().getString(R.string.live_class_is_ended), 0).show();
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("3")) {
                        Activity activity14 = this.activity;
                        Toast.makeText(activity14, activity14.getResources().getString(R.string.live_class_is_ended), 0).show();
                    }
                } else if (this.data.get(i).getIsdrm().equals("1")) {
                    if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                        if (TextUtils.isEmpty(this.data.get(i).getFileUrl()) && TextUtils.isEmpty(this.data.get(i).getId())) {
                            Activity activity15 = this.activity;
                            Toast.makeText(activity15, activity15.getResources().getString(R.string.url_is_not_found), 0).show();
                        } else {
                            Helper.GoToDumVideoCryptActivity(this.activity, this.data.get(i).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), this.data.get(i).getVideoType(), this.data.get(i).getChatNode(), this.data.get(i).getId(), this.data.get(i).getVideoType(), this.data.get(i).getId(), this.data.get(i).getTitle(), "1", this.data.get(i).getThumbnailUrl(), this.data.get(i).getPayload().getCourse_id(), this.data.get(i).getPayload().getTile_id(), this.data.get(i).getPayload().getTile_type(), this.data.get(i).getIschatlock(), String.valueOf(i), SingleStudy.parentCourseId, this.data.get(i).getStartdate(), "0", this.data);
                        }
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("0")) {
                        Activity activity16 = this.activity;
                        Toast.makeText(activity16, activity16.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                        Activity activity17 = this.activity;
                        Toast.makeText(activity17, activity17.getResources().getString(R.string.live_class_is_ended), 0).show();
                    } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("3")) {
                        Activity activity18 = this.activity;
                        Toast.makeText(activity18, activity18.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                    }
                }
            } else if (this.data.get(i).getVideoType().equalsIgnoreCase("9")) {
                if (this.data.get(i).getLiveStatus().equalsIgnoreCase("1")) {
                    if (!this.data.get(i).getZoom_meeting_id().equalsIgnoreCase("") || !this.data.get(i).getZoom_meeting_passcode().equalsIgnoreCase("")) {
                        if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                            ZoomFeatureHelper.launchZoomFeature(this.activity, this.data.get(i).getZoom_meeting_id(), this.data.get(i).getZoom_meeting_passcode(), this.data.get(i).getZoom_sdk_token(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                        } else {
                            Toast.makeText(this.activity, "Zoom SDK key not found!", 0).show();
                        }
                    }
                } else if (this.data.get(i).getLiveStatus().equalsIgnoreCase("2")) {
                    if (!this.data.get(i).getFileUrl().equalsIgnoreCase("") || !this.data.get(i).getFileUrl().isEmpty()) {
                        Intent intent = new Intent(this.activity, (Class<?>) ZoomRecodedPlayer.class);
                        intent.putExtra("videoUrl", this.data.get(i).getFileUrl());
                        intent.putExtra(Const.VIDEO_ID, this.data.get(i).getId());
                        this.activity.startActivity(intent);
                    } else {
                        Toast.makeText(this.activity, "No Video Found !", 0).show();
                    }
                } else {
                    Toast.makeText(this.activity, "Zoom class is not yet started.", 0).show();
                }
            }
        } else {
            Helper.showInternetToast(this.activity);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$2(int i) {
        sharelivevideolink(i);
        return null;
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

    private void setDateTimeForKrantikari(View itemView, Datum video) {
        try {
            if ("1".equalsIgnoreCase("1") && BuildConfig.FLAVOR.equalsIgnoreCase("dsl")) {
                try {
                    TextView textView = (TextView) itemView.findViewById(R.id.liveDate);
                    TextView textView2 = (TextView) itemView.findViewById(R.id.timing);
                    TextView textView3 = (TextView) itemView.findViewById(R.id.liveTime);
                    textView3.setVisibility(0);
                    textView.setVisibility(0);
                    textView2.setVisibility(8);
                    String str = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(video.getStartdate()) * 1000));
                    String str2 = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(video.getEnd_date()) * 1000));
                    textView.setText("Start Date : " + str);
                    textView3.setText("End Date : " + str2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void extractJWPlayerUrl(String mediaUrl, AudioTable audioTable, Datum videoData) {
        if (mediaUrl == null || mediaUrl.equalsIgnoreCase("")) {
            return;
        }
        if (AudioPlayerService.player != null) {
            AudioPlayerService.player.release();
            AudioPlayerService.player = null;
        }
        if (AudioPlayerService.isAudioPlaying) {
            Intent intent = new Intent(this.activity, (Class<?>) AudioPlayerService.class);
            intent.setAction("Stop_Service");
            Util.startForegroundService(this.activity, intent);
            AudioPlayerService.video_currentpos = 0L;
            AudioPlayerService.media_id = "";
        }
        Intent intent2 = new Intent(this.activity, (Class<?>) AudioPlayerActivty.class);
        AudioPlayerService.videoid = "";
        AudioPlayerService.media_id = "";
        intent2.putExtra("url", mediaUrl);
        intent2.putExtra("videoid", videoData.getId());
        intent2.putExtra("currentpos", audioTable.getAudio_currentpos());
        intent2.putExtra("video_name", videoData.getTitle());
        intent2.putExtra("image_url", videoData.getThumbnailUrl());
        intent2.putExtra("course_id", videoData.getPayload().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
        intent2.putExtra("tile_id", videoData.getPayload().getTile_id());
        intent2.putExtra(Const.TILE_TYPE, videoData.getPayload().getTile_type());
        Helper.gotoActivity(intent2, this.activity);
    }

    private void sharelivevideolink(int adapterPosition) {
        Helper.shareLiveClass(this.activity, this.data.get(adapterPosition).getPayload().getCourse_id(), this.data.get(adapterPosition).getId(), this.data.get(adapterPosition).getPayload().getTopic_id(), this.data.get(adapterPosition).getPayload().getTile_type(), this.data.get(adapterPosition).getPayload().getTile_id(), this.data.get(adapterPosition).getPayload().getRevert_api(), "video", this.data.get(adapterPosition).getThumbnailUrl(), this.data.get(adapterPosition).getTitle(), "", this.data.get(adapterPosition).getIs_locked());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source")) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setName(this.datuml.getId() + "_0_0");
        encryptionData.setCourse_id(this.datuml.getPayload().getCourse_id());
        encryptionData.setTile_id(this.datuml.getPayload().getTile_id());
        encryptionData.setType(this.datuml.getPayload().getTile_type());
        return service.getVideoLink(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        new Gson();
        apitype.hashCode();
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source")) {
            try {
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    JSONObject jSONObject = new JSONObject(jsonstring.toString());
                    if (jSONObject.has("data")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        String string = jSONObject.getJSONObject("data").getString("link");
                        String strOptString = jSONObject2.optString("audio_url");
                        if (jSONObject2.has("bitrate_urls") && (jSONArrayOptJSONArray = jSONObject2.optJSONArray("bitrate_urls")) != null && jSONArrayOptJSONArray.length() > 0) {
                            ArrayList<UrlObject> arrayList = new ArrayList<>();
                            for (int i = 0; i < ((JSONArray) Objects.requireNonNull(jSONArrayOptJSONArray)).length(); i++) {
                                arrayList.add((UrlObject) new Gson().fromJson(jSONArrayOptJSONArray.optJSONObject(i).toString(), UrlObject.class));
                            }
                            this.datuml.setBitrate_urls(arrayList);
                        }
                        if (this.is_audio) {
                            this.is_audio = false;
                            if (!this.utkashRoom.getaudiodao().isvideo_exit(this.datuml.getId(), MakeMyExam.userId)) {
                                AudioTable audioTable = new AudioTable();
                                audioTable.setVideo_id(this.datuml.getId());
                                audioTable.setJw_url(this.datuml.getThumbnailUrl());
                                audioTable.setVideo_name(this.datuml.getTitle());
                                audioTable.setAudio_currentpos(0L);
                                audioTable.setUser_id(MakeMyExam.userId);
                                audioTable.setCourse_id(this.datuml.getPayload().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
                                this.utkashRoom.getaudiodao().addUser(audioTable);
                                extractJWPlayerUrl(strOptString, audioTable, this.datuml);
                            } else {
                                AudioTable audioTable2 = new AudioTable();
                                audioTable2.setVideo_id(this.datuml.getId());
                                audioTable2.setJw_url(this.datuml.getThumbnailUrl());
                                audioTable2.setVideo_name(this.datuml.getTitle());
                                audioTable2.setAudio_currentpos(this.utkashRoom.getaudiodao().getuser(this.datuml.getId(), MakeMyExam.userId).getAudio_currentpos());
                                extractJWPlayerUrl(strOptString, audioTable2, this.datuml);
                            }
                        } else if (this.utkashRoom.getvideoDao().isvideo_exit(this.datuml.getId(), MakeMyExam.userId)) {
                            Helper.GoToJWVideo_Params_newarray(this.activity, string, this.datuml.getId(), this.datuml.getTitle(), this.utkashRoom.getvideoDao().getuser(this.datuml.getId(), MakeMyExam.userId).getVideo_currentpos(), this.datuml.getPayload().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD, this.datuml.getPayload().getTile_id(), this.datuml.getPayload().getTile_type(), this.datuml.getBitrate_urls());
                        } else {
                            VideoTable videoTable = new VideoTable();
                            videoTable.setVideo_id(this.datuml.getId());
                            videoTable.setVideo_name(this.datuml.getTitle());
                            videoTable.setJw_url(string);
                            videoTable.setVideo_currentpos(0L);
                            videoTable.setUser_id(MakeMyExam.userId);
                            videoTable.setCourse_id(this.datuml.getPayload().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
                            Helper.GoToJWVideo_Params_newarray(this.activity, string, this.datuml.getId(), this.datuml.getTitle(), 0L, this.datuml.getPayload().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD, this.datuml.getPayload().getTile_id(), this.datuml.getPayload().getTile_type(), this.datuml.getBitrate_urls());
                            this.utkashRoom.getvideoDao().addUser(videoTable);
                        }
                    }
                }
                this.is_audio = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        this.is_audio = false;
    }

    public class Livevideoviewholder extends RecyclerView.ViewHolder {
        ImageView courseImage;
        TextView course_name;
        ImageView forward;
        TextView listne_now;
        TextView liveDate;
        ImageView liveIV;
        CardView maincard;
        TextView pdf_TV;
        ImageView share;
        TextView startedin;
        LinearLayout study_single_itemLL;
        RelativeLayout thumbRl;
        TextView time;
        long timecount;
        CountDownTimer timer;
        long timerr;
        TextView timing;
        TextView title;
        TextView watch_now;

        public Livevideoviewholder(View itemView) {
            super(itemView);
            this.timecount = 1L;
            this.courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            this.thumbRl = (RelativeLayout) itemView.findViewById(R.id.thumbRl);
            this.time = (TextView) itemView.findViewById(R.id.time);
            this.course_name = (TextView) itemView.findViewById(R.id.course_name);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.watch_now = (TextView) itemView.findViewById(R.id.watch_now);
            this.startedin = (TextView) itemView.findViewById(R.id.startedin);
            this.listne_now = (TextView) itemView.findViewById(R.id.listne_now);
            this.pdf_TV = (TextView) itemView.findViewById(R.id.pdf_TV);
            this.title = (TextView) itemView.findViewById(R.id.study_item_titleTV);
            this.study_single_itemLL = (LinearLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.maincard = (CardView) itemView.findViewById(R.id.maincard);
            this.liveDate = (TextView) itemView.findViewById(R.id.liveDate);
            this.timing = (TextView) itemView.findViewById(R.id.timing);
        }
    }

    public String getdate(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(Long.parseLong(String.valueOf(timestamp)))));
    }

    private void setThumbAccordingRatio(String url, ImageView thumb) {
        Activity activity = this.activity;
        Helper.setThumbnailImage(activity, url, activity.getDrawable(R.mipmap.square_placeholder_new), thumb);
    }

    public String getTiming(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(String.valueOf(timestamp))));
    }

    public String concerter(long time) {
        return String.format("%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(time)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))));
    }

    public void notifyadap(Livevideoviewholder holder, int position) {
        if (this.fromTab.equalsIgnoreCase("live")) {
            if (this.data.get(position).getLiveStatus().equalsIgnoreCase("1")) {
                holder.watch_now.setVisibility(0);
            } else if (this.data.get(position).getLiveStatus().equalsIgnoreCase("0")) {
                if (Long.parseLong(this.data.get(position).getStartdate()) * 1000 > System.currentTimeMillis()) {
                    holder.watch_now.setVisibility(8);
                } else {
                    holder.watch_now.setVisibility(0);
                }
            }
        }
        if (!this.fromTab.equalsIgnoreCase(Const.COMPLETED)) {
            holder.listne_now.setVisibility(8);
        } else {
            holder.watch_now.setVisibility(0);
        }
        if (position >= 0 && position < this.data.size() && this.data.get(position) != null && this.data.get(position).getLiveStatus().equalsIgnoreCase("0")) {
            if (this.data.get(position).getIs_live().equalsIgnoreCase("0")) {
                holder.startedin.setText(R.string.class_will_start_soon);
            }
            holder.startedin.setTextColor(this.activity.getResources().getColor(R.color.notification_red));
        } else {
            holder.startedin.setVisibility(8);
        }
        holder.time.setVisibility(8);
        holder.maincard.setEnabled(true);
    }

    public void removeItem(int position) {
        this.data.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.data.size());
    }
}
