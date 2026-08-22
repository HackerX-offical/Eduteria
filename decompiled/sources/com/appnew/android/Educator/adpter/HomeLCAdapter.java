package com.appnew.android.Educator.adpter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Educator.model.HomeLiveClassItem;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.ZoomFeatureHelper;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.appnew.android.home.liveclasses.Datum;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class HomeLCAdapter extends RecyclerView.Adapter<HomeLCViewHolder> implements NetworkCall.MyNetworkCallBack {
    private Activity activity;
    Datum liveClassesData;
    private ArrayList<Datum> liveClassesDataList;
    private CardView live_class_cardView;
    private onCardClickListener onCardClickListener;

    public interface onCardClickListener {
        void onCardClick(HomeLiveClassItem homeLiveClassItem);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        return null;
    }

    public HomeLCAdapter(Activity activity, ArrayList<Datum> liveClassesDataList, onCardClickListener onCardClickListener2) {
        this.activity = activity;
        this.liveClassesDataList = liveClassesDataList;
        this.onCardClickListener = onCardClickListener2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HomeLCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeLCViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.home_live_class_item, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(HomeLCViewHolder holder, final int position) {
        this.liveClassesData = this.liveClassesDataList.get(position);
        Glide.with(this.activity).load(this.liveClassesData.getThumbnailUrl()).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new RoundedCorners(12))).placeholder(R.mipmap.both).error(R.mipmap.both).into(holder.home_courseImage);
        holder.home_subCourseName.setText(this.liveClassesData.getTitle() != null ? this.liveClassesData.getTitle() : "");
        holder.home_courseName.setText(this.liveClassesData.getCourse_name() != null ? this.liveClassesData.getCourse_name() : "");
        String startdate = this.liveClassesData.getStartdate();
        String str = "Start Date: ";
        if (!TextUtils.isEmpty(startdate)) {
            try {
                str = "Start Date: " + new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(startdate) * 1000));
            } catch (NumberFormatException unused) {
            }
        }
        holder.home_liveDate.setText(str);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.HomeLCAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ArrayList arrayList = HomeLCAdapter.this.liveClassesDataList;
                if (Helper.isNetworkConnected(HomeLCAdapter.this.activity)) {
                    if (((Datum) arrayList.get(position)).getVideoType().equalsIgnoreCase("5")) {
                        if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("1")) {
                            if (TextUtils.isEmpty(((Datum) arrayList.get(position)).getFileUrl()) && TextUtils.isEmpty(((Datum) arrayList.get(position)).getId())) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivityDatumLiveCls(((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getChatNode(), HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getFileUrl(), "5", ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getTitle(), "0", ((Datum) arrayList.get(position)).getThumbnailUrl(), ((Datum) arrayList.get(position)).getPayload().getCourse_id(), ((Datum) arrayList.get(position)).getPayload().getTile_id(), ((Datum) arrayList.get(position)).getPayload().getTile_type(), ((Datum) arrayList.get(position)).getIschatlock(), String.valueOf(position), "", ((Datum) arrayList.get(position)).getStartdate(), arrayList);
                                return;
                            }
                        }
                        if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("0")) {
                            Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                            return;
                        } else if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("2")) {
                            Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("3")) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (((Datum) arrayList.get(position)).getVideoType().equalsIgnoreCase("4")) {
                        if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("1")) {
                            if (TextUtils.isEmpty(((Datum) arrayList.get(position)).getFileUrl()) && TextUtils.isEmpty(((Datum) arrayList.get(position)).getId())) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else if (((Datum) arrayList.get(position)).getOpenInApp().equalsIgnoreCase("1")) {
                                Helper.GoToLiveVideoActivity(((Datum) arrayList.get(position)).getChatNode(), HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getFileUrl(), ((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getTitle(), "0", ((Datum) arrayList.get(position)).getThumbnailUrl(), ((Datum) arrayList.get(position)).getIschatlock(), ((Datum) arrayList.get(position)).getPayload().getCourse_id(), String.valueOf(position), "", ((Datum) arrayList.get(position)).getPayload().getTile_id(), ((Datum) arrayList.get(position)).getPayload().getTile_type(), ((Datum) arrayList.get(position)).getIs_live(), new ArrayList());
                                return;
                            } else {
                                HomeLCAdapter.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + ((Datum) arrayList.get(position)).getFileUrl())));
                                return;
                            }
                        }
                        if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("0")) {
                            Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                            return;
                        } else if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("2")) {
                            Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("3")) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (((Datum) arrayList.get(position)).getVideoType().equalsIgnoreCase("0")) {
                        Helper.GoToLiveAwsVideoActivityDatumLiveCls(((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getChatNode(), HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getTitle(), "0", ((Datum) arrayList.get(position)).getThumbnailUrl(), ((Datum) arrayList.get(position)).getPayload().getCourse_id(), ((Datum) arrayList.get(position)).getPayload().getTile_id(), ((Datum) arrayList.get(position)).getPayload().getTile_type(), ((Datum) arrayList.get(position)).getIschatlock(), String.valueOf(position), SingleStudy.parentCourseId, ((Datum) arrayList.get(position)).getStartdate(), arrayList);
                        return;
                    }
                    if (((Datum) arrayList.get(position)).getVideoType().equalsIgnoreCase("1")) {
                        if (((Datum) arrayList.get(position)).getOpenInApp() != null && ((Datum) arrayList.get(position)).getOpenInApp().equalsIgnoreCase("1")) {
                            Helper.GoToLiveVideoActivity(((Datum) arrayList.get(position)).getChatNode(), HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getFileUrl(), ((Datum) arrayList.get(position)).getIs_live(), ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getTitle(), "0", ((Datum) arrayList.get(position)).getThumbnailUrl(), ((Datum) arrayList.get(position)).getIschatlock(), ((Datum) arrayList.get(position)).getPayload().getCourse_id(), String.valueOf(position), SingleStudy.parentCourseId, ((Datum) arrayList.get(position)).getPayload().getTile_id(), ((Datum) arrayList.get(position)).getPayload().getTile_type(), ((Datum) arrayList.get(position)).getIs_live(), new ArrayList());
                            return;
                        } else {
                            HomeLCAdapter.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + ((Datum) arrayList.get(position)).getFileUrl())));
                            return;
                        }
                    }
                    if (((Datum) arrayList.get(position)).getVideoType().equalsIgnoreCase("6")) {
                        HomeLCAdapter.this.liveClassesData = (Datum) arrayList.get(position);
                        HomeLCAdapter homeLCAdapter = HomeLCAdapter.this;
                        new NetworkCall(homeLCAdapter, homeLCAdapter.activity).NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", true, false);
                        return;
                    }
                    if (((Datum) arrayList.get(position)).getVideoType().equalsIgnoreCase("7")) {
                        if (((Datum) arrayList.get(position)).getIsdrm().equals("0")) {
                            if (TextUtils.isEmpty(((Datum) arrayList.get(position)).getFileUrl()) && TextUtils.isEmpty(((Datum) arrayList.get(position)).getId())) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivityDatumLiveCls(((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getChatNode(), HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getFileUrl(), "0", ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getTitle(), "0", ((Datum) arrayList.get(position)).getThumbnailUrl(), ((Datum) arrayList.get(position)).getPayload().getCourse_id(), ((Datum) arrayList.get(position)).getPayload().getTile_id(), ((Datum) arrayList.get(position)).getPayload().getTile_type(), ((Datum) arrayList.get(position)).getIschatlock(), String.valueOf(position), "", ((Datum) arrayList.get(position)).getStartdate(), arrayList);
                                return;
                            }
                        }
                        if (((Datum) arrayList.get(position)).getIsdrm().equals("1")) {
                            if (TextUtils.isEmpty(((Datum) arrayList.get(position)).getFileUrl()) && TextUtils.isEmpty(((Datum) arrayList.get(position)).getId())) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToDumVideoCryptActivity(HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), ((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getChatNode(), ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getTitle(), "0", ((Datum) arrayList.get(position)).getThumbnailUrl(), ((Datum) arrayList.get(position)).getPayload().getCourse_id(), ((Datum) arrayList.get(position)).getPayload().getTile_id(), ((Datum) arrayList.get(position)).getPayload().getTile_type(), ((Datum) arrayList.get(position)).getIschatlock(), String.valueOf(position), SingleStudy.parentCourseId, ((Datum) arrayList.get(position)).getStartdate(), "0", arrayList);
                                return;
                            }
                        }
                        return;
                    }
                    if (((Datum) arrayList.get(position)).getVideoType().equalsIgnoreCase("8")) {
                        if (((Datum) arrayList.get(position)).getIsdrm().equals("0")) {
                            if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("1")) {
                                if (TextUtils.isEmpty(((Datum) arrayList.get(position)).getFileUrl()) && TextUtils.isEmpty(((Datum) arrayList.get(position)).getId())) {
                                    Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToLiveAwsVideoActivityDatumLiveCls(((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getChatNode(), HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getFileUrl(), "5", ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getTitle(), "0", ((Datum) arrayList.get(position)).getThumbnailUrl(), ((Datum) arrayList.get(position)).getPayload().getCourse_id(), ((Datum) arrayList.get(position)).getPayload().getTile_id(), ((Datum) arrayList.get(position)).getPayload().getTile_type(), ((Datum) arrayList.get(position)).getIschatlock(), String.valueOf(position), "", ((Datum) arrayList.get(position)).getStartdate(), arrayList);
                                    return;
                                }
                            }
                            if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("0")) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                                return;
                            } else if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("2")) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("3")) {
                                    Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        if (((Datum) arrayList.get(position)).getIsdrm().equals("1")) {
                            if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("1")) {
                                if (TextUtils.isEmpty(((Datum) arrayList.get(position)).getFileUrl()) && TextUtils.isEmpty(((Datum) arrayList.get(position)).getId())) {
                                    Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToDumVideoCryptActivity(HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), ((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getChatNode(), ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getTitle(), "0", ((Datum) arrayList.get(position)).getThumbnailUrl(), ((Datum) arrayList.get(position)).getPayload().getCourse_id(), ((Datum) arrayList.get(position)).getPayload().getTile_id(), ((Datum) arrayList.get(position)).getPayload().getTile_type(), ((Datum) arrayList.get(position)).getIschatlock(), String.valueOf(position), SingleStudy.parentCourseId, ((Datum) arrayList.get(position)).getStartdate(), "0", arrayList);
                                    return;
                                }
                            }
                            if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("0")) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                                return;
                            } else if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("2")) {
                                Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("3")) {
                                    Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    if (((Datum) arrayList.get(position)).getVideoType().equalsIgnoreCase("9")) {
                        if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("1")) {
                            if (((Datum) arrayList.get(position)).getZoom_meeting_id().equalsIgnoreCase("") && ((Datum) arrayList.get(position)).getZoom_meeting_passcode().equalsIgnoreCase("")) {
                                return;
                            }
                            if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                                ZoomFeatureHelper.launchZoomFeature(HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getZoom_meeting_id(), ((Datum) arrayList.get(position)).getZoom_meeting_passcode(), ((Datum) arrayList.get(position)).getZoom_sdk_token(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                                return;
                            }
                            Toast.makeText(HomeLCAdapter.this.activity, "Zoom SDK key not found!", 0).show();
                            return;
                        }
                        if (((Datum) arrayList.get(position)).getLiveStatus().equalsIgnoreCase("2")) {
                            if (!((Datum) arrayList.get(position)).getFileUrl().equalsIgnoreCase("") || !((Datum) arrayList.get(position)).getFileUrl().isEmpty()) {
                                Intent intent = new Intent(HomeLCAdapter.this.activity, (Class<?>) ZoomRecodedPlayer.class);
                                intent.putExtra("videoUrl", ((Datum) arrayList.get(position)).getFileUrl());
                                intent.putExtra(Const.VIDEO_ID, ((Datum) arrayList.get(position)).getId());
                                HomeLCAdapter.this.activity.startActivity(intent);
                                return;
                            }
                            Toast.makeText(HomeLCAdapter.this.activity, "No Video Found !", 0).show();
                            return;
                        }
                        Toast.makeText(HomeLCAdapter.this.activity, "Zoom class is not yet started.", 0).show();
                        return;
                    }
                    if (((Datum) arrayList.get(position)).getVideoType().equalsIgnoreCase("11")) {
                        Datum datum = (Datum) arrayList.get(position);
                        if (datum.getFileUrl() != null && datum.getFileUrl().isEmpty()) {
                            Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        }
                        if (datum.getLiveStatus().equalsIgnoreCase("0")) {
                            Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(datum.getStartdate()) * 1000)), 0).show();
                            return;
                        }
                        if (datum.getLiveStatus().equalsIgnoreCase("2")) {
                            Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        }
                        if (datum.getLiveStatus().equalsIgnoreCase("3")) {
                            Toast.makeText(HomeLCAdapter.this.activity, HomeLCAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                            return;
                        }
                        try {
                            Helper.goToIvsPlayerActivity(HomeLCAdapter.this.activity, ((Datum) arrayList.get(position)).getVideoType(), ((Datum) arrayList.get(position)).getChatNode(), ((Datum) arrayList.get(position)).getFileUrl(), "5", ((Datum) arrayList.get(position)).getId(), ((Datum) arrayList.get(position)).getTitle(), "0", ((Datum) arrayList.get(position)).getThumbnailUrl(), ((Datum) arrayList.get(position)).getPayload().getCourse_id(), ((Datum) arrayList.get(position)).getPayload().getTile_id(), ((Datum) arrayList.get(position)).getPayload().getTile_type(), ((Datum) arrayList.get(position)).getIschatlock(), "", "", ((Datum) arrayList.get(position)).getStartdate(), new ArrayList());
                            return;
                        } catch (Exception e2) {
                            Helper.logPrinter("LiveClass: ", "e", e2.getLocalizedMessage(), "");
                            return;
                        }
                    }
                    if (!((Datum) arrayList.get(position)).getFileUrl().equalsIgnoreCase("") || !((Datum) arrayList.get(position)).getFileUrl().isEmpty()) {
                        Intent intent2 = new Intent(HomeLCAdapter.this.activity, (Class<?>) ZoomRecodedPlayer.class);
                        intent2.putExtra("videoUrl", ((Datum) arrayList.get(position)).getFileUrl());
                        intent2.putExtra(Const.VIDEO_ID, ((Datum) arrayList.get(position)).getId());
                        HomeLCAdapter.this.activity.startActivity(intent2);
                        return;
                    }
                    Toast.makeText(HomeLCAdapter.this.activity, "No Video Found yet please some time !", 0).show();
                    return;
                }
                Helper.showInternetToast(HomeLCAdapter.this.activity);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<Datum> arrayList = this.liveClassesDataList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class HomeLCViewHolder extends RecyclerView.ViewHolder {
        ImageView home_courseImage;
        TextView home_courseName;
        TextView home_liveDate;
        TextView home_subCourseName;

        public HomeLCViewHolder(View itemView) {
            super(itemView);
            this.home_courseImage = (ImageView) itemView.findViewById(R.id.home_courseImage);
            this.home_courseName = (TextView) itemView.findViewById(R.id.home_courseName);
            this.home_subCourseName = (TextView) itemView.findViewById(R.id.home_subCourseName);
            this.home_liveDate = (TextView) itemView.findViewById(R.id.home_liveDate);
            HomeLCAdapter.this.live_class_cardView = (CardView) itemView.findViewById(R.id.live_class_cardView);
            adjustWidthBasedOnScreenSize();
        }

        private void adjustWidthBasedOnScreenSize() {
            DisplayMetrics displayMetrics = HomeLCAdapter.this.activity.getResources().getDisplayMetrics();
            float f2 = displayMetrics.widthPixels / displayMetrics.density;
            ViewGroup.LayoutParams layoutParams = HomeLCAdapter.this.live_class_cardView.getLayoutParams();
            if (f2 >= 720.0f) {
                layoutParams.width = (int) (displayMetrics.density * 485.0f);
            } else if (f2 >= 600.0f) {
                layoutParams.width = (int) (displayMetrics.density * 385.0f);
            } else {
                layoutParams.width = (int) (displayMetrics.density * 285.0f);
            }
            HomeLCAdapter.this.live_class_cardView.setLayoutParams(layoutParams);
        }
    }
}
