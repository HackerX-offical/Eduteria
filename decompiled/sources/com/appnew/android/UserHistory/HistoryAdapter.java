package com.appnew.android.UserHistory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.media3.common.util.Util;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.AudioPlayerActivty;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.UrlObject;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.StoreProvider;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.AudioTable;
import com.appnew.android.table.UserHistroyTable;
import com.appnew.android.table.VideoTable;
import com.appnew.android.table.VideosDownload;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity context;
    private List<UserHistroyTable> historyvideos;
    public boolean is_audio = false;
    UserHistroyTable userHistroyTable;
    private UtkashRoom utkashRoom;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public HistoryAdapter(Context context, List<UserHistroyTable> historyvideos, UtkashRoom utkashRoom) {
        this.historyvideos = historyvideos;
        this.context = (Activity) context;
        this.utkashRoom = utkashRoom;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StreamHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.history_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder sholder, final int position) {
        try {
            final StreamHolder streamHolder = (StreamHolder) sholder;
            streamHolder.video_time.setText(Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCurrent_time())))));
            if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("video")) {
                streamHolder.video_name.setText(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
                streamHolder.courseImage.setImageResource(R.drawable.play_icon);
            }
            if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase(Const.CONCEPT)) {
                streamHolder.video_name.setText(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
                streamHolder.courseImage.setImageResource(R.mipmap.pdf);
            } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("audio")) {
                streamHolder.video_name.setText(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
                streamHolder.courseImage.setImageResource(R.drawable.audio);
            } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("PDF")) {
                streamHolder.video_name.setText(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getPdf_name());
                streamHolder.courseImage.setImageResource(R.mipmap.pdf);
            } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("Youtube Video")) {
                streamHolder.video_name.setText(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
                streamHolder.courseImage.setImageResource(R.drawable.play_icon);
            } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("8")) {
                streamHolder.video_name.setText(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getPdf_name());
                streamHolder.courseImage.setImageResource(R.mipmap.square_placeholder);
            } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("Youtube Audio") || this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("AWS Audio")) {
                streamHolder.video_name.setText(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
                streamHolder.courseImage.setImageResource(R.drawable.audio);
            } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("AWS Video")) {
                streamHolder.video_name.setText(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
                streamHolder.courseImage.setImageResource(R.drawable.play_icon);
            }
            streamHolder.study_single_itemLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.UserHistory.HistoryAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$0(streamHolder, position);
                }
            }));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(StreamHolder streamHolder, int i) {
        if (AudioPlayerService.player != null) {
            if (AudioPlayerService.type.equalsIgnoreCase(Const.YOUTUBE)) {
                if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getYoutube_url() != null && !this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getYoutube_url().equalsIgnoreCase("")) {
                    this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(AudioPlayerService.player.getCurrentPosition()), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), MakeMyExam.userId, "1");
                }
            } else {
                this.utkashRoom.getaudiodao().update_audio_currentpos(AudioPlayerService.videoid, MakeMyExam.userId, Long.valueOf(AudioPlayerService.player.getCurrentPosition()));
            }
            if (AudioPlayerService.player != null) {
                AudioPlayerService.player.release();
                AudioPlayerService.player = null;
            }
        }
        if (AudioPlayerService.isAudioPlaying) {
            Intent intent = new Intent(this.context, (Class<?>) AudioPlayerService.class);
            intent.setAction("Stop_Service");
            Util.startForegroundService(this.context, intent);
            AudioPlayerService.video_currentpos = 0L;
        }
        if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("Concept")) {
            Intent intent2 = new Intent(this.context, (Class<?>) Concept_newActivity.class);
            intent2.putExtra("id", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id());
            intent2.putExtra("name", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
            intent2.putExtra("course_id", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id());
            intent2.putExtra("tile_id", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getTileid());
            intent2.putExtra(StoreProvider.StoreData.MODIFIED_DATE, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getValid_to());
            Helper.gotoActivity(intent2, this.context);
        } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("Youtube Audio")) {
            String[] strArrSplit = new String[0];
            String str = "http://img.youtube.com/vi/" + this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getYoutube_url() + "/0.jpg";
            if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id().contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                strArrSplit = this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id().split(MqttTopic.MULTI_LEVEL_WILDCARD);
                if (strArrSplit.length == 1) {
                    strArrSplit[1] = "";
                }
            } else {
                strArrSplit[0] = this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id();
                strArrSplit[1] = this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id();
            }
            Helper.GoToLiveVideoActivity("", (UserHistoryActivity) this.context, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getYoutube_url(), "1", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name(), "1", str, "1", strArrSplit[1], String.valueOf(i), strArrSplit[0], this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getTileid(), "video", new ArrayList());
        } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("Youtube Video")) {
            String[] strArrSplit2 = new String[0];
            if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id().contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                strArrSplit2 = this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id().split(MqttTopic.MULTI_LEVEL_WILDCARD);
                if (strArrSplit2.length == 1) {
                    strArrSplit2[1] = "";
                }
            } else {
                strArrSplit2[0] = this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id();
                strArrSplit2[1] = this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id();
            }
            if (strArrSplit2.length != 0) {
                Helper.GoToLiveVideoActivity("", (UserHistoryActivity) this.context, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getYoutube_url(), "1", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name(), "0", "", "1", strArrSplit2[1], String.valueOf(i), strArrSplit2[0], this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getTileid(), "video", new ArrayList());
            } else {
                Helper.GoToLiveVideoActivity("", (UserHistoryActivity) this.context, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getYoutube_url(), "1", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name(), "0", "", "1", "0", String.valueOf(i), "", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getTileid(), "video", new ArrayList());
            }
        } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("AWS Audio")) {
            Helper.GoToLiveAwsVideoActivity("0", "", this.context, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getUrl(), "0", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name(), "1", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getYoutube_url(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getTileid(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType(), "1", "", "", new ArrayList());
        } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("AWS Video")) {
            Helper.GoToLiveAwsVideoActivity("0", "", this.context, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getUrl(), "0", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name(), "0", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getYoutube_url(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getTileid(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType(), "1", "", "", new ArrayList());
        } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("PDF")) {
            if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getPdf_download().equalsIgnoreCase("1")) {
                Helper.GoToWebViewPDFActivity(this.context, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getPdf_url(), true, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getPdf_name(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id(), "");
            } else {
                Helper.GoToWebViewPDFActivity(this.context, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getPdf_url(), false, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getPdf_name(), this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id(), "");
            }
        } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("8")) {
            if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("8")) {
                Intent intent3 = new Intent(this.context, (Class<?>) WebViewActivty.class);
                intent3.putExtra("type", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getPdf_name());
                intent3.putExtra("url", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getPdf_url());
                intent3.putExtra(Const.VIDEO_ID, this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id());
                intent3.putExtra("link", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType());
                intent3.putExtra("course_id", this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id());
                Helper.gotoActivity(intent3, this.context);
            }
        } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("audio")) {
            if (this.utkashRoom.getaudiodao().isvideo_exit(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), MakeMyExam.userId)) {
                this.userHistroyTable = this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition());
                this.is_audio = true;
                new NetworkCall(this, this.context).NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", true, false);
            } else {
                Activity activity = this.context;
                Toast.makeText(activity, activity.getResources().getString(R.string.history_not_exist), 0).show();
            }
        } else if (this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getType().equalsIgnoreCase("Video")) {
            if (this.utkashRoom.getvideoDownloadao().isvideo_exit(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), MakeMyExam.userId)) {
                VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), MakeMyExam.userId);
                Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
                if (videosDownload.getIs_complete().equalsIgnoreCase("1")) {
                    Intent intent4 = new Intent(this.context, (Class<?>) DownloadVideoPlayer.class);
                    if (videosDownload.getVideo_type() != null && (videosDownload.getVideo_type().equalsIgnoreCase("6") || videosDownload.getVideo_type().equalsIgnoreCase("7"))) {
                        intent4.putExtra("video_name", videosDownload.getVideo_name());
                        intent4.putExtra(Const.VIDEO_ID, videosDownload.getVideo_id());
                        intent4.putExtra("current_pos", videosDownload.getVideoCurrentPosition());
                        intent4.putExtra("video", videosDownload.getVideo_history());
                        intent4.putExtra("video_time", videosDownload.getVideotime());
                        intent4.putExtra("course_id", videosDownload.getCourse_id());
                        intent4.putExtra("vdc_id", videosDownload.getVdcId());
                        intent4.putExtra("video_url", videosDownload.getLinkByUser(loggedInUser.getId()));
                        intent4.putExtra(Const.remaining_time, videosDownload.getRemaining_time());
                        intent4.putExtra("is_limited", videosDownload.getIs_limited());
                    } else {
                        intent4.putExtra("video_name", videosDownload.getVideo_name());
                        intent4.putExtra(Const.VIDEO_ID, videosDownload.getVideo_id());
                        intent4.putExtra("current_pos", videosDownload.getVideoCurrentPosition());
                        intent4.putExtra("video", videosDownload.getVideo_history());
                        intent4.putExtra("video_time", videosDownload.getVideotime());
                        intent4.putExtra("course_id", videosDownload.getCourse_id());
                        intent4.putExtra("vdc_id", videosDownload.getVdcId());
                        intent4.putExtra(Const.remaining_time, videosDownload.getRemaining_time());
                        intent4.putExtra("is_limited", videosDownload.getIs_limited());
                    }
                    Helper.gotoActivity(intent4, this.context);
                } else {
                    this.userHistroyTable = this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition());
                    new NetworkCall(this, this.context).NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", true, false);
                }
            } else {
                this.userHistroyTable = this.historyvideos.get(streamHolder.getAbsoluteAdapterPosition());
                new NetworkCall(this, this.context).NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", true, false);
            }
        }
        return null;
    }

    private void play_audio(UserHistroyTable userHistroyTable, String link) {
        if (link == null || link.equalsIgnoreCase("")) {
            return;
        }
        AudioTable audioTable = this.utkashRoom.getaudiodao().getuser(userHistroyTable.getVideo_id(), MakeMyExam.userId);
        Intent intent = new Intent(this.context, (Class<?>) AudioPlayerActivty.class);
        AudioPlayerService.videoid = "";
        intent.putExtra("url", link);
        intent.putExtra("videoid", userHistroyTable.getVideo_id());
        intent.putExtra("currentpos", audioTable.getAudio_currentpos());
        intent.putExtra("video_name", userHistroyTable.getVideo_name());
        intent.putExtra("image_url", userHistroyTable.getUrl());
        intent.putExtra("tile_id", userHistroyTable.getTileid());
        intent.putExtra(Const.TILE_TYPE, userHistroyTable.getTopicname());
        intent.putExtra("course_id", userHistroyTable.getCourse_id());
        Helper.gotoActivity(intent, this.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<UserHistroyTable> list = this.historyvideos;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.historyvideos.size();
    }

    public void chnagelist(List<UserHistroyTable> historyvideos) {
        this.historyvideos = historyvideos;
        notifyDataSetChanged();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source")) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setName(this.userHistroyTable.getVideo_id() + "_0_0");
        if (this.userHistroyTable.getCourse_id() != null && this.userHistroyTable.getCourse_id().contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
            encryptionData.setCourse_id(this.userHistroyTable.getCourse_id().split(MqttTopic.MULTI_LEVEL_WILDCARD)[0]);
        }
        encryptionData.setTile_id(this.userHistroyTable.getTileid());
        encryptionData.setType(this.userHistroyTable.getTopicname());
        return service.getVideoLink(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        new Gson();
        apitype.hashCode();
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source")) {
            try {
                if (jsonobject.getString("status").equalsIgnoreCase("true")) {
                    JSONObject jSONObject = new JSONObject(jsonobject.toString());
                    if (jSONObject.has("data")) {
                        String string = jSONObject.getJSONObject("data").getString("link");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        String strOptString = jSONObject2.optString("audio_url");
                        if (this.is_audio) {
                            this.is_audio = false;
                            play_audio(this.userHistroyTable, strOptString);
                            return;
                        }
                        this.is_audio = false;
                        ArrayList arrayList = new ArrayList();
                        if (jSONObject2.has("bitrate_urls") && (jSONArrayOptJSONArray = jSONObject2.optJSONArray("bitrate_urls")) != null && jSONArrayOptJSONArray.length() > 0) {
                            for (int i = 0; i < ((JSONArray) Objects.requireNonNull(jSONArrayOptJSONArray)).length(); i++) {
                                arrayList.add((UrlObject) new Gson().fromJson(jSONArrayOptJSONArray.optJSONObject(i).toString(), UrlObject.class));
                            }
                        }
                        if (this.utkashRoom.getvideoDao().isvideo_exit(this.userHistroyTable.getVideo_id(), MakeMyExam.userId)) {
                            VideoTable videoTable = this.utkashRoom.getvideoDao().getuser(this.userHistroyTable.getVideo_id(), MakeMyExam.userId);
                            Helper.GoToJWVideo_Params_newarray(this.context, string, videoTable.getVideo_id(), videoTable.getVideo_name(), videoTable.getVideo_currentpos(), videoTable.getCourse_id(), this.userHistroyTable.getTileid(), this.userHistroyTable.getTopicname(), arrayList);
                            return;
                        } else {
                            Helper.GoToJWVideo_Params_newarray(this.context, string, this.userHistroyTable.getVideo_id(), this.userHistroyTable.getVideo_name(), this.utkashRoom.getvideoDao().getuser(this.userHistroyTable.getVideo_id(), MakeMyExam.userId).getVideo_currentpos(), this.userHistroyTable.getCourse_id(), this.userHistroyTable.getTileid(), this.userHistroyTable.getTopicname(), arrayList);
                            return;
                        }
                    }
                    Activity activity = this.context;
                    Toast.makeText(activity, activity.getResources().getString(R.string.url_is_not_found), 0).show();
                    return;
                }
                ErrorCallBack(jsonobject.getString("message"), apitype, typeApi);
                RetrofitResponse.GetApiData(this.context, jsonobject.getString("auth_code"), jsonobject.getString("message"), false);
            } catch (Exception unused) {
            }
        }
    }

    public class StreamHolder extends RecyclerView.ViewHolder {
        RelativeLayout cancel_progress_layout;
        ImageView courseImage;
        RelativeLayout delete_layout;
        ImageView download_icon;
        TextView file_mb;
        ProgressBar loadingProgress;
        RelativeLayout pauseLayout;
        TextView pauseTextView;
        TextView percentageTxt;
        CheckBox selected_video;
        RelativeLayout study_single_itemLL;
        TextView video_name;
        TextView video_time;

        public StreamHolder(View itemView) {
            super(itemView);
            this.video_time = (TextView) itemView.findViewById(R.id.history_time);
            this.video_name = (TextView) itemView.findViewById(R.id.video_name);
            this.courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            this.study_single_itemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
        }
    }
}
