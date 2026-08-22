package com.appnew.android.Theme.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.Video;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.table.VideosDownload;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class RecentWatchAdapter extends RecyclerView.Adapter<SliderAdapterViewHolder> {
    Context context;
    private ArrayList<Video> recentWatchModels;
    public UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());

    public RecentWatchAdapter(Context context, ArrayList<Video> recentWatchModel) {
        this.recentWatchModels = new ArrayList<>();
        this.recentWatchModels = recentWatchModel;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SliderAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.child_recent_watch, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {
        if (this.recentWatchModels.get(position).getThumbnail_url() != null && !TextUtils.isEmpty(this.recentWatchModels.get(position).getThumbnail_url())) {
            Glide.with(this.context).load(this.recentWatchModels.get(position).getThumbnail_url()).placeholder(R.mipmap.square_placeholder_new).error(R.mipmap.square_placeholder_new).into(viewHolder.img_thumb);
        } else {
            Glide.with(this.context).load(Integer.valueOf(R.mipmap.square_placeholder_new)).placeholder(R.mipmap.square_placeholder_new).error(R.mipmap.square_placeholder_new).into(viewHolder.img_thumb);
        }
        if (TextUtils.isEmpty(this.recentWatchModels.get(position).getVideo_name())) {
            viewHolder.tv_subject.setVisibility(8);
        } else {
            viewHolder.tv_subject.setText(this.recentWatchModels.get(position).getVideo_name());
            viewHolder.tv_subject.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.recentWatchModels.get(position).getCourse_name())) {
            viewHolder.tv_course.setVisibility(8);
        } else {
            viewHolder.tv_course.setText(this.recentWatchModels.get(position).getCourse_name());
            viewHolder.tv_course.setVisibility(0);
        }
        int i = 1;
        int i2 = (this.recentWatchModels.get(position).getTotal_time().equalsIgnoreCase("") || this.recentWatchModels.get(position).getTotal_time().contains("-")) ? 1 : Integer.parseInt(this.recentWatchModels.get(position).getTotal_time());
        if (!this.recentWatchModels.get(position).getMultiplayer().equalsIgnoreCase("") && !this.recentWatchModels.get(position).getMultiplayer().equalsIgnoreCase("0")) {
            i = Integer.parseInt(this.recentWatchModels.get(position).getMultiplayer());
        }
        if (!this.recentWatchModels.get(position).getTime_left().equalsIgnoreCase("") && !this.recentWatchModels.get(position).getTime_left().contains("-")) {
            Integer.parseInt(this.recentWatchModels.get(position).getTime_left());
        }
        if (this.recentWatchModels.get(position).getIs_live() != null && !this.recentWatchModels.get(position).getIs_live().equalsIgnoreCase("1")) {
            long jLongValue = this.utkashRoom.getyoutubedata().isUserExist(this.recentWatchModels.get(position).getVideo_id(), MakeMyExam.userId, "0") ? this.utkashRoom.getyoutubedata().getyoutubedata(MakeMyExam.userId, this.recentWatchModels.get(position).getVideo_id(), "0") : 0L;
            if (this.utkashRoom.getvideoDownloadao().isvideo_exit(this.recentWatchModels.get(position).getVideo_id(), MakeMyExam.userId)) {
                VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(this.recentWatchModels.get(position).getVideo_id(), "1", MakeMyExam.userId);
                jLongValue = (videosDownload == null || videosDownload.getVideoCurrentPosition() == null) ? 0L : videosDownload.getVideoCurrentPosition().longValue();
            }
            int i3 = jLongValue != 0 ? (int) (jLongValue / 1000) : 0;
            viewHolder.simple_ProgressBar.setMax(i2 != 0 ? i2 / i : 100);
            viewHolder.simple_ProgressBar.setProgress(i2 != 0 ? i3 : 0);
        } else {
            viewHolder.simple_ProgressBar.setMax(100);
            viewHolder.simple_ProgressBar.setProgress(100);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.RecentWatchAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!Helper.isConnected(RecentWatchAdapter.this.context)) {
                    Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.no_internet_connection), 0).show();
                    return;
                }
                if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type().equalsIgnoreCase("5")) {
                    if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("1")) {
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id() == null || ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id().equalsIgnoreCase("")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToLiveAwsVideoActivity(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getChat_node(), (Activity) RecentWatchAdapter.this.context, ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_name(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getThumbnail_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getTile_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getType(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_chat_lock(), String.valueOf(position), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time(), new ArrayList());
                            return;
                        }
                    }
                    if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("0")) {
                        Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time()) * 1000)), 0).show();
                        return;
                    } else if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("2")) {
                        Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    } else {
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("3")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        }
                        return;
                    }
                }
                if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type().equalsIgnoreCase("0")) {
                    Helper.GoToLiveAwsVideoActivity(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getChat_node(), (Activity) RecentWatchAdapter.this.context, ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_name(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getThumbnail_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getTile_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getType(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_chat_lock(), String.valueOf(position), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time(), new ArrayList());
                    return;
                }
                if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type().equalsIgnoreCase("1")) {
                    Helper.audio_service_close((Activity) RecentWatchAdapter.this.context);
                    if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getOpen_in_app() != null && ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getOpen_in_app().equalsIgnoreCase("1")) {
                        Helper.GoToLiveVideoActivity(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getChat_node(), (Activity) RecentWatchAdapter.this.context, ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_name(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getThumbnail_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_chat_lock(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), String.valueOf(position), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getTile_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getType(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_bookmarked(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live(), new ArrayList());
                        return;
                    } else {
                        RecentWatchAdapter.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url())));
                        return;
                    }
                }
                if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type().equalsIgnoreCase("4")) {
                    Helper.audio_service_close((Activity) RecentWatchAdapter.this.context);
                    if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("1")) {
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url() == null || ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url().equalsIgnoreCase("")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getOpen_in_app() != null && ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getOpen_in_app().equalsIgnoreCase("1")) {
                            Helper.GoToLiveVideoActivity(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getChat_node(), (Activity) RecentWatchAdapter.this.context, ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_name(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getThumbnail_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_chat_lock(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), String.valueOf(position), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getTile_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getType(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_bookmarked(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live(), new ArrayList());
                            return;
                        } else {
                            RecentWatchAdapter.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url())));
                            return;
                        }
                    }
                    if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("0")) {
                        Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time()) * 1000)), 0).show();
                        return;
                    } else if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("2")) {
                        Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    } else {
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("3")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        }
                        return;
                    }
                }
                if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type().equalsIgnoreCase("7")) {
                    if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_drm().equals("0")) {
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id() == null || ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id().equalsIgnoreCase("")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToLiveAwsVideoActivity(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getChat_node(), (Activity) RecentWatchAdapter.this.context, ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_name(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getThumbnail_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getTile_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getType(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_chat_lock(), String.valueOf(position), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time(), RecentWatchAdapter.this.recentWatchModels);
                            return;
                        }
                    }
                    if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_drm().equals("1")) {
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id() == null || ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id().equalsIgnoreCase("")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToVideoCryptActivity((Activity) RecentWatchAdapter.this.context, ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getChat_node(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_name(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getThumbnail_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getTile_id(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_chat_lock(), String.valueOf(position), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_bookmarked(), new ArrayList());
                            return;
                        }
                    }
                    return;
                }
                if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type().equalsIgnoreCase("8")) {
                    if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_drm().equals("0")) {
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("1")) {
                            if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id() == null || ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id().equalsIgnoreCase("")) {
                                Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getChat_node(), (Activity) RecentWatchAdapter.this.context, ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_name(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getThumbnail_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getTile_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getType(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_chat_lock(), String.valueOf(position), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time(), RecentWatchAdapter.this.recentWatchModels);
                                return;
                            }
                        }
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("0")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time()) * 1000)), 0).show();
                            return;
                        } else if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("2")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("3")) {
                                Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_drm().equals("1")) {
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("1")) {
                            if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id() == null || ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id().equalsIgnoreCase("")) {
                                Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToVideoCryptActivity((Activity) RecentWatchAdapter.this.context, ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_type(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getChat_node(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getFile_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getVideo_name(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getThumbnail_url(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getTile_id(), "0", ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_chat_lock(), String.valueOf(position), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getCourse_id(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time(), ((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_bookmarked(), new ArrayList());
                                return;
                            }
                        }
                        if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("0")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getStart_time()) * 1000)), 0).show();
                        } else if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("2")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_is_ended), 0).show();
                        } else if (((Video) RecentWatchAdapter.this.recentWatchModels.get(position)).getIs_live().equalsIgnoreCase("3")) {
                            Toast.makeText(RecentWatchAdapter.this.context, RecentWatchAdapter.this.context.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                        }
                    }
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.recentWatchModels.size();
    }

    static class SliderAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView img_thumb;
        View itemView;
        ProgressBar simple_ProgressBar;
        TextView tv_course;
        TextView tv_subject;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            this.img_thumb = (ImageView) itemView.findViewById(R.id.img_thumb);
            this.tv_subject = (TextView) itemView.findViewById(R.id.tv_subject);
            this.tv_course = (TextView) itemView.findViewById(R.id.tv_course);
            this.simple_ProgressBar = (ProgressBar) itemView.findViewById(R.id.simple_ProgressBar);
            this.itemView = itemView;
        }
    }
}
