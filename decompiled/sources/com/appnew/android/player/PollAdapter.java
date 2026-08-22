package com.appnew.android.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.PlayerPojo.LeaderboardResponse;
import com.appnew.android.Model.PlayerPojo.Polldata;
import com.appnew.android.Model.PollLeaderboard;
import com.appnew.android.Model.SendUserData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class PollAdapter extends RecyclerView.Adapter<Viewholder> implements NetworkCall.MyNetworkCallBack {
    int Selectedpos;
    private Activity con;
    private Context context;
    NetworkCall networkCall;
    private ArrayList<Polldata> polldata;
    ProgressBar progress1;
    ProgressBar progress2;
    ProgressBar progress3;
    ProgressBar progress4;
    ImageView radioButton1;
    ImageView radioButton2;
    ImageView radioButton3;
    ImageView radioButton4;
    View typeA;
    View typeB;
    View typeC;
    View typeD;
    private ScheduledFuture updateFuture;
    BottomSheetDialog watchlist;
    private Handler handler = new Handler();
    long userAttemptedTime = 0;
    long userTotalTime = 0;
    long mLastClickTime = 0;
    String pollKey = "";
    String select = "";

    public PollAdapter(Activity con, ArrayList<Polldata> polldata) {
        this.con = con;
        this.context = con;
        this.polldata = polldata;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.con);
        this.networkCall = new NetworkCall(this, this.con);
        return new Viewholder(layoutInflaterFrom.inflate(R.layout.activity_cardview_poll, (ViewGroup) null));
    }

    /* JADX WARN: Type inference failed for: r1v25, types: [com.appnew.android.player.PollAdapter$1] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Viewholder holder, int position) {
        PollAdapter pollAdapter;
        final Viewholder viewholder;
        final int i;
        if (this.polldata.get(holder.getAbsoluteAdapterPosition()).getStatus().equalsIgnoreCase("1")) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = 15;
            layoutParams.leftMargin = 15;
            layoutParams.rightMargin = 15;
            layoutParams.bottomMargin = 15;
            holder.mainlayout.setLayoutParams(layoutParams);
            holder.takeAPollBtn.setClickable(true);
            holder.takeAPollBtn.setEnabled(true);
            holder.timerr = 0L;
            holder.timerr = Long.parseLong(this.polldata.get(holder.getAbsoluteAdapterPosition()).getValidTill()) - (System.currentTimeMillis() / holder.timecount);
            holder.timerr *= holder.timecount;
            this.userTotalTime = holder.timerr;
            if (holder.timer != null) {
                holder.timer.cancel();
            }
            pollAdapter = this;
            viewholder = holder;
            i = position;
            viewholder.timer = new CountDownTimer(holder.timerr, holder.timecount) { // from class: com.appnew.android.player.PollAdapter.1
                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    PollAdapter.this.userAttemptedTime = millisUntilFinished;
                    viewholder.time.setText(PollAdapter.this.concerter(millisUntilFinished));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    viewholder.time.setText(PollAdapter.this.context.getResources().getString(R.string.expired_));
                    PollAdapter.this.notifyadap(viewholder, i);
                }
            }.start();
        } else {
            pollAdapter = this;
            viewholder = holder;
            i = position;
            viewholder.mainlayout.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
        }
        if (pollAdapter.polldata.get(viewholder.getAbsoluteAdapterPosition()).getAnswer().equalsIgnoreCase("0")) {
            viewholder.buyNowBtn.setText(pollAdapter.con.getResources().getString(R.string.survey));
            viewholder.pollNumber.setText(pollAdapter.con.getResources().getString(R.string.poll));
        } else {
            viewholder.buyNowBtn.setText(pollAdapter.con.getResources().getString(R.string.quiz));
            viewholder.pollNumber.setText(pollAdapter.con.getResources().getString(R.string.poll));
        }
        if (Long.parseLong(pollAdapter.polldata.get(i).getValidTill()) > System.currentTimeMillis() / 1000) {
            if (pollAdapter.polldata.get(viewholder.getAbsoluteAdapterPosition()).getMyAnswer().equalsIgnoreCase("0")) {
                if (pollAdapter.polldata.get(viewholder.getAbsoluteAdapterPosition()).getAnswer().equalsIgnoreCase("0")) {
                    viewholder.takeAPollBtn.setText(pollAdapter.con.getResources().getString(R.string.take_survey));
                    viewholder.leaderBoardBtn.setVisibility(8);
                } else {
                    viewholder.takeAPollBtn.setText(pollAdapter.con.getResources().getString(R.string.take_poll));
                    viewholder.leaderBoardBtn.setVisibility(8);
                }
            } else {
                viewholder.takeAPollBtn.setText(pollAdapter.con.getResources().getString(R.string.submitted));
                viewholder.leaderBoardBtn.setVisibility(8);
            }
        } else if (!pollAdapter.polldata.get(viewholder.getAbsoluteAdapterPosition()).getAnswer().equalsIgnoreCase("0")) {
            if (pollAdapter.polldata.get(viewholder.getAbsoluteAdapterPosition()).getDisable_result().equalsIgnoreCase("0")) {
                viewholder.takeAPollBtn.setText(pollAdapter.con.getResources().getString(R.string.result));
                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.PollAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PollAdapter.this.con instanceof Liveawsactivity) {
                            viewholder.leaderBoardBtn.setVisibility(((Liveawsactivity) PollAdapter.this.context).isFirebaseChat ? 8 : 0);
                            return;
                        }
                        if (PollAdapter.this.con instanceof LiveStreamingYoutube) {
                            viewholder.leaderBoardBtn.setVisibility(((LiveStreamingYoutube) PollAdapter.this.context).getIsFirebaseChat() ? 8 : 0);
                        } else if (PollAdapter.this.con instanceof VODPlayerActivity) {
                            viewholder.leaderBoardBtn.setVisibility(((VODPlayerActivity) PollAdapter.this.context).isFirebaseChat ? 8 : 0);
                        } else {
                            viewholder.leaderBoardBtn.setVisibility(8);
                        }
                    }
                }, 1000L);
            } else {
                viewholder.leaderBoardBtn.setVisibility(8);
                viewholder.takeAPollBtn.setText(pollAdapter.con.getResources().getString(R.string.expired_));
            }
        } else if (pollAdapter.polldata.get(viewholder.getAbsoluteAdapterPosition()).getDisable_result().equalsIgnoreCase("0")) {
            viewholder.takeAPollBtn.setText(pollAdapter.con.getResources().getString(R.string.survey_result));
            viewholder.leaderBoardBtn.setVisibility(8);
        } else {
            viewholder.leaderBoardBtn.setVisibility(8);
            viewholder.takeAPollBtn.setText(pollAdapter.con.getResources().getString(R.string.expired_));
        }
        try {
            viewholder.expireddate.setText(getdate(pollAdapter.polldata.get(i).getValidTill()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        viewholder.takeAPollBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onBindViewHolder$0(viewholder);
            }
        }));
        viewholder.leaderBoardBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onBindViewHolder$1(viewholder);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(Viewholder viewholder) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return null;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        if (Helper.isNetworkConnected(this.con)) {
            if (viewholder.takeAPollBtn.getText().equals("Take Poll") || viewholder.takeAPollBtn.getText().equals("Take Survey")) {
                this.Selectedpos = viewholder.getAbsoluteAdapterPosition();
                openwatchlist_dailog_resource(this.con, this.polldata.get(viewholder.getAbsoluteAdapterPosition()));
            } else if (viewholder.takeAPollBtn.getText().equals("Expired")) {
                Toast.makeText(this.con, this.context.getResources().getString(R.string.poll_is_expired), 0).show();
            } else if (viewholder.takeAPollBtn.getText().equals("Survey Result") || viewholder.takeAPollBtn.getText().equals("Result")) {
                openwatchlist_dailog_resource_result(this.con, this.polldata.get(viewholder.getAbsoluteAdapterPosition()));
            } else if (viewholder.takeAPollBtn.getText().equals("Submitted") && !this.polldata.get(viewholder.getAbsoluteAdapterPosition()).getAnswer().equalsIgnoreCase("0") && this.polldata.get(viewholder.getAbsoluteAdapterPosition()).getDisable_result().equalsIgnoreCase("0")) {
                Toast.makeText(this.con, this.context.getResources().getString(R.string.poll_result_will_display_soon), 0).show();
            }
        } else {
            Helper.showInternetToast(this.con);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$1(Viewholder viewholder) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return null;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        if (Helper.isNetworkConnected(this.con)) {
            try {
                this.pollKey = this.polldata.get(viewholder.getAbsoluteAdapterPosition()).getRendomkey();
                Activity activity = this.con;
                if (activity instanceof Liveawsactivity) {
                    ((Liveawsactivity) activity).isLandscape = false;
                    if (((Liveawsactivity) this.con).isFirebaseChat) {
                        this.networkCall.NetworkAPICall(API.getLeaderBoardForPoll, "", true, false);
                    } else {
                        Activity activity2 = this.con;
                        ((Liveawsactivity) activity2).sendWSMessage(((Liveawsactivity) activity2).leaderboardPollDataStr(this.pollKey), "GET_LEADERBOARD", this.pollKey);
                    }
                } else if (activity instanceof LiveStreamingYoutube) {
                    ((LiveStreamingYoutube) activity).setLandscape(false);
                    if (((LiveStreamingYoutube) this.con).getIsFirebaseChat()) {
                        this.networkCall.NetworkAPICall(API.getLeaderBoardForPoll, "", true, false);
                    } else {
                        Activity activity3 = this.con;
                        ((LiveStreamingYoutube) activity3).sendWSMessage(((LiveStreamingYoutube) activity3).leaderboardPollDataStr(this.pollKey), "GET_LEADERBOARD", this.pollKey);
                    }
                } else if (activity instanceof VODPlayerActivity) {
                    ((VODPlayerActivity) activity).isLandscape = false;
                    if (((VODPlayerActivity) this.con).isFirebaseChat) {
                        this.networkCall.NetworkAPICall(API.getLeaderBoardForPoll, "", true, false);
                    } else {
                        Activity activity4 = this.con;
                        ((VODPlayerActivity) activity4).sendWSMessage(((VODPlayerActivity) activity4).leaderboardPollDataStr(this.pollKey), "GET_LEADERBOARD", this.pollKey);
                    }
                } else {
                    this.networkCall.NetworkAPICall(API.getLeaderBoardForPoll, "", true, false);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            Helper.showInternetToast(this.con);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(Viewholder holder) {
        super.onViewDetachedFromWindow(holder);
    }

    public String concerter(long time) {
        TimeUnit.MILLISECONDS.toHours(time);
        TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(time));
        return String.format("%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.polldata.size();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.submitpoll)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setAnswer(this.select);
            encryptionData.setPoll_id(this.polldata.get(this.Selectedpos).getId());
            return service.sendpoll(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.getLeaderBoardForPoll)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setPoll_key(this.pollKey);
        return service.getLeaderBoardForPoll(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.submitpoll)) {
            if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                try {
                    if (this.watchlist.isShowing()) {
                        this.watchlist.dismiss();
                    }
                    Activity activity = this.con;
                    if (activity instanceof CustomMediaPlayer) {
                        ((CustomMediaPlayer) activity).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select);
                    } else if (activity instanceof LiveStreamingYoutube) {
                        ((LiveStreamingYoutube) activity).setLandscape(false);
                        ((LiveStreamingYoutube) this.con).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select);
                    } else if (activity instanceof VODPlayerActivity) {
                        ((VODPlayerActivity) activity).isLandscape = false;
                        ((VODPlayerActivity) this.con).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select);
                    } else if (activity instanceof Liveawsactivity) {
                        ((Liveawsactivity) activity).isLandscape = false;
                        ((Liveawsactivity) this.con).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select);
                    }
                    this.polldata.get(this.Selectedpos).setMyAnswer(this.select);
                    this.select = "";
                    notifyItemChanged(this.Selectedpos);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
            RetrofitResponse.GetApiData(this.con, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
            return;
        }
        if (apitype.equals(API.getLeaderBoardForPoll)) {
            if (jsonstring.optBoolean("status")) {
                try {
                    if (jsonstring.has("data")) {
                        JSONArray jSONArrayOptJSONArray = jsonstring.optJSONArray("data");
                        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                            Toast.makeText(this.con, "No Leaderboard found", 0).show();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            arrayList.add((PollLeaderboard) new Gson().fromJson(jSONArrayOptJSONArray.opt(i).toString(), PollLeaderboard.class));
                        }
                        if (arrayList.size() <= 3) {
                            Toast.makeText(this.con, "No Leaderboard found", 0).show();
                            return;
                        } else {
                            open_dailog_leader_board(this.con, arrayList, false);
                            return;
                        }
                    }
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        apitype.hashCode();
        if (apitype.equals(API.submitpoll)) {
            Toast.makeText(this.con, this.context.getResources().getString(R.string.error_in_submit_poll), 0).show();
        } else if (apitype.equals(API.getLeaderBoardForPoll)) {
            Toast.makeText(this.con, "No Leaderboard found", 0).show();
        }
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        Button buyNowBtn;
        TextView expireddate;
        Button leaderBoardBtn;
        RelativeLayout mainlayout;
        TextView pollNumber;
        long singlecount;
        Button takeAPollBtn;
        TextView time;
        long timecount;
        CountDownTimer timer;
        long timerr;

        public Viewholder(View itemView) {
            super(itemView);
            this.timecount = 1000L;
            this.singlecount = 1L;
            this.time = (TextView) itemView.findViewById(R.id.time);
            this.takeAPollBtn = (Button) itemView.findViewById(R.id.takeAPollBtn);
            this.expireddate = (TextView) itemView.findViewById(R.id.expireddate);
            this.mainlayout = (RelativeLayout) itemView.findViewById(R.id.mainlayout);
            this.pollNumber = (TextView) itemView.findViewById(R.id.pollNumber);
            this.buyNowBtn = (Button) itemView.findViewById(R.id.buyNowBtn);
            this.leaderBoardBtn = (Button) itemView.findViewById(R.id.leaderBoardBtn);
        }
    }

    public void openwatchlist_dailog_resource(final Context context, final Polldata poll) {
        try {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogStyle);
            this.watchlist = bottomSheetDialog;
            bottomSheetDialog.setContentView(R.layout.pollquestion_next_toppers);
            ((Window) Objects.requireNonNull(this.watchlist.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            this.watchlist.setCancelable(false);
            this.watchlist.setCanceledOnTouchOutside(true);
            TextView textView = (TextView) this.watchlist.findViewById(R.id.txt1);
            Button button = (Button) this.watchlist.findViewById(R.id.cancel);
            Button button2 = (Button) this.watchlist.findViewById(R.id.submit);
            button.setVisibility(0);
            button2.setVisibility(0);
            Button button3 = (Button) this.watchlist.findViewById(R.id.buyNowBtn);
            this.typeA = this.watchlist.findViewById(R.id.typeA);
            this.typeB = this.watchlist.findViewById(R.id.typeB);
            this.typeC = this.watchlist.findViewById(R.id.typeC);
            this.typeD = this.watchlist.findViewById(R.id.typeD);
            if (poll.getAnswer().equalsIgnoreCase("0")) {
                button3.setText(this.con.getResources().getString(R.string.survey));
            } else {
                button3.setText(this.con.getResources().getString(R.string.quiz));
            }
            button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$2(context, poll);
                }
            }));
            final ImageView imageView = (ImageView) this.typeA.findViewById(R.id.radioButton1);
            TextView textView2 = (TextView) this.typeA.findViewById(R.id.option1);
            final ProgressBar progressBar = (ProgressBar) this.typeA.findViewById(R.id.progress1);
            RelativeLayout relativeLayout = (RelativeLayout) this.typeA.findViewById(R.id.option1Layout);
            final ImageView imageView2 = (ImageView) this.typeB.findViewById(R.id.radioButton1);
            TextView textView3 = (TextView) this.typeB.findViewById(R.id.option1);
            final ProgressBar progressBar2 = (ProgressBar) this.typeB.findViewById(R.id.progress1);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.typeB.findViewById(R.id.option1Layout);
            final ImageView imageView3 = (ImageView) this.typeC.findViewById(R.id.radioButton1);
            TextView textView4 = (TextView) this.typeC.findViewById(R.id.option1);
            final ProgressBar progressBar3 = (ProgressBar) this.typeC.findViewById(R.id.progress1);
            RelativeLayout relativeLayout3 = (RelativeLayout) this.typeC.findViewById(R.id.option1Layout);
            final ImageView imageView4 = (ImageView) this.typeD.findViewById(R.id.radioButton1);
            TextView textView5 = (TextView) this.typeD.findViewById(R.id.option1);
            final ProgressBar progressBar4 = (ProgressBar) this.typeD.findViewById(R.id.progress1);
            RelativeLayout relativeLayout4 = (RelativeLayout) this.typeD.findViewById(R.id.option1Layout);
            try {
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$openwatchlist_dailog_resource$3(imageView, context, imageView2, imageView3, imageView4, progressBar, progressBar2, progressBar3, progressBar4, view);
                    }
                });
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$openwatchlist_dailog_resource$4(imageView, imageView2, context, imageView3, imageView4, progressBar, progressBar2, progressBar3, progressBar4, view);
                    }
                });
                relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$openwatchlist_dailog_resource$5(imageView, imageView2, imageView3, context, imageView4, progressBar, progressBar2, progressBar3, progressBar4, view);
                    }
                });
                relativeLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$openwatchlist_dailog_resource$6(imageView, imageView2, imageView3, imageView4, context, progressBar, progressBar2, progressBar3, progressBar4, view);
                    }
                });
                textView2.setText(poll.getOption1());
                textView3.setText(poll.getOption2());
                textView4.setText(poll.getOption3());
                textView5.setText(poll.getOption4());
                if (poll.getOption1().equalsIgnoreCase("")) {
                    this.typeA.setVisibility(8);
                } else {
                    this.typeA.setVisibility(0);
                }
                if (poll.getOption2().equalsIgnoreCase("")) {
                    this.typeB.setVisibility(8);
                } else {
                    this.typeB.setVisibility(0);
                }
                if (poll.getOption3().equalsIgnoreCase("")) {
                    this.typeC.setVisibility(8);
                } else {
                    this.typeC.setVisibility(0);
                }
                if (poll.getOption4().equalsIgnoreCase("")) {
                    this.typeD.setVisibility(8);
                } else {
                    this.typeD.setVisibility(0);
                }
                if (poll.getQuestion() != null && !TextUtils.isEmpty(poll.getQuestion())) {
                    textView.setText(Html.fromHtml(poll.getQuestion()));
                } else {
                    textView.setText("");
                }
                button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$7();
                    }
                }));
                if (this.watchlist.isShowing()) {
                    return;
                }
                this.watchlist.show();
                return;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        e.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$2(Context context, Polldata polldata) {
        if (this.select.equalsIgnoreCase("")) {
            Toast.makeText(this.con, context.getResources().getString(R.string.please_select_answer), 0).show();
            return null;
        }
        if (Helper.isNetworkConnected(this.con)) {
            if (Long.parseLong(polldata.getValidTill()) > System.currentTimeMillis() / 1000) {
                Log.e("TAG_APP", "openwatchlist_dailog_resource: " + this.polldata.get(this.Selectedpos).getAnswer().equalsIgnoreCase("0") + "test " + this.polldata.get(this.Selectedpos).getAnswer().equalsIgnoreCase(this.select));
                try {
                    if (this.watchlist.isShowing()) {
                        this.watchlist.dismiss();
                    }
                    Activity activity = this.con;
                    if (activity instanceof CustomMediaPlayer) {
                        ((CustomMediaPlayer) activity).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select);
                    } else if (activity instanceof LiveStreamingYoutube) {
                        ((LiveStreamingYoutube) activity).setLandscape(false);
                        if (!this.polldata.get(this.Selectedpos).getAnswer().equalsIgnoreCase("0") && this.polldata.get(this.Selectedpos).getAnswer().equalsIgnoreCase(this.select)) {
                            ((LiveStreamingYoutube) this.con).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select, new SendUserData(SharedPreference.getInstance().getLoggedInUser().getName(), MakeMyExam.getUserId(), "" + (Long.parseLong(this.polldata.get(this.Selectedpos).getValidTill()) - (System.currentTimeMillis() / 1000)), this.select));
                        } else {
                            ((LiveStreamingYoutube) this.con).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select);
                        }
                    } else if (activity instanceof VODPlayerActivity) {
                        ((VODPlayerActivity) activity).isLandscape = false;
                        if (!this.polldata.get(this.Selectedpos).getAnswer().equalsIgnoreCase("0") && this.polldata.get(this.Selectedpos).getAnswer().equalsIgnoreCase(this.select)) {
                            ((VODPlayerActivity) this.con).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select, new SendUserData(SharedPreference.getInstance().getLoggedInUser().getName(), MakeMyExam.getUserId(), "" + (Long.parseLong(this.polldata.get(this.Selectedpos).getValidTill()) - (System.currentTimeMillis() / 1000)), this.select));
                        } else {
                            ((VODPlayerActivity) this.con).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select);
                        }
                    } else if (activity instanceof Liveawsactivity) {
                        ((Liveawsactivity) activity).isLandscape = false;
                        if (!this.polldata.get(this.Selectedpos).getAnswer().equalsIgnoreCase("0") && this.polldata.get(this.Selectedpos).getAnswer().equalsIgnoreCase(this.select)) {
                            ((Liveawsactivity) this.con).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select, new SendUserData(SharedPreference.getInstance().getLoggedInUser().getName(), MakeMyExam.getUserId(), "" + (Long.parseLong(this.polldata.get(this.Selectedpos).getValidTill()) - (System.currentTimeMillis() / 1000)), this.select));
                        } else {
                            ((Liveawsactivity) this.con).setpollcount(this.polldata.get(this.Selectedpos).getRendomkey(), this.select);
                        }
                    }
                    this.polldata.get(this.Selectedpos).setMyAnswer(this.select);
                    this.select = "";
                    notifyItemChanged(this.Selectedpos);
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            Toast.makeText(this.con, context.getResources().getString(R.string.expired_), 0).show();
            notifyItemChanged(this.Selectedpos);
            return null;
        }
        Helper.showInternetToast(this.con);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$3(ImageView imageView, Context context, ImageView imageView2, ImageView imageView3, ImageView imageView4, ProgressBar progressBar, ProgressBar progressBar2, ProgressBar progressBar3, ProgressBar progressBar4, View view) {
        this.select = "1";
        imageView.setImageResource(R.mipmap.correct_tick);
        imageView.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        imageView2.setImageResource(R.mipmap.not_attempted);
        imageView2.clearColorFilter();
        imageView3.setImageResource(R.mipmap.not_attempted);
        imageView3.clearColorFilter();
        imageView4.setImageResource(R.mipmap.not_attempted);
        imageView4.clearColorFilter();
        progressBar.setProgress(100);
        progressBar2.setProgress(0);
        progressBar3.setProgress(0);
        progressBar4.setProgress(0);
        progressBar.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_app));
        progressBar2.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
        progressBar3.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
        progressBar4.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$4(ImageView imageView, ImageView imageView2, Context context, ImageView imageView3, ImageView imageView4, ProgressBar progressBar, ProgressBar progressBar2, ProgressBar progressBar3, ProgressBar progressBar4, View view) {
        this.select = "2";
        imageView.setImageResource(R.mipmap.not_attempted);
        imageView.clearColorFilter();
        imageView2.setImageResource(R.mipmap.correct_tick);
        imageView2.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        imageView3.setImageResource(R.mipmap.not_attempted);
        imageView3.clearColorFilter();
        imageView4.setImageResource(R.mipmap.not_attempted);
        imageView4.clearColorFilter();
        progressBar.setProgress(0);
        progressBar2.setProgress(100);
        progressBar3.setProgress(0);
        progressBar4.setProgress(0);
        progressBar.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
        progressBar2.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_app));
        progressBar3.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
        progressBar4.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$5(ImageView imageView, ImageView imageView2, ImageView imageView3, Context context, ImageView imageView4, ProgressBar progressBar, ProgressBar progressBar2, ProgressBar progressBar3, ProgressBar progressBar4, View view) {
        this.select = "3";
        imageView.setImageResource(R.mipmap.not_attempted);
        imageView.clearColorFilter();
        imageView2.setImageResource(R.mipmap.not_attempted);
        imageView2.clearColorFilter();
        imageView3.setImageResource(R.mipmap.correct_tick);
        imageView3.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        imageView4.setImageResource(R.mipmap.not_attempted);
        imageView4.clearColorFilter();
        progressBar.setProgress(0);
        progressBar2.setProgress(0);
        progressBar3.setProgress(100);
        progressBar4.setProgress(0);
        progressBar.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
        progressBar2.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
        progressBar3.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_app));
        progressBar4.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$6(ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, Context context, ProgressBar progressBar, ProgressBar progressBar2, ProgressBar progressBar3, ProgressBar progressBar4, View view) {
        this.select = "4";
        imageView.setImageResource(R.mipmap.not_attempted);
        imageView.clearColorFilter();
        imageView2.setImageResource(R.mipmap.not_attempted);
        imageView2.clearColorFilter();
        imageView3.setImageResource(R.mipmap.not_attempted);
        imageView3.clearColorFilter();
        imageView4.setImageResource(R.mipmap.correct_tick);
        imageView4.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        progressBar.setProgress(0);
        progressBar2.setProgress(0);
        progressBar3.setProgress(0);
        progressBar4.setProgress(100);
        progressBar.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
        progressBar2.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
        progressBar3.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar));
        progressBar4.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$7() {
        this.watchlist.dismiss();
        return null;
    }

    public void open_dailog_leader_board(Context context, List<PollLeaderboard> leaderboardList, boolean isForAll) {
        final PollAdapter pollAdapter;
        try {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogStyle);
            this.watchlist = bottomSheetDialog;
            bottomSheetDialog.setContentView(R.layout.leaderboard_poll);
            ((Window) Objects.requireNonNull(this.watchlist.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            this.watchlist.setCancelable(false);
            this.watchlist.setCanceledOnTouchOutside(true);
            TextView textView = (TextView) this.watchlist.findViewById(R.id.time);
            ImageView imageView = (ImageView) this.watchlist.findViewById(R.id.close_lb);
            CardView cardView = (CardView) this.watchlist.findViewById(R.id.cardView2);
            CardView cardView2 = (CardView) this.watchlist.findViewById(R.id.cardView1);
            CardView cardView3 = (CardView) this.watchlist.findViewById(R.id.cardView3);
            TextView textView2 = (TextView) this.watchlist.findViewById(R.id.student1);
            TextView textView3 = (TextView) this.watchlist.findViewById(R.id.student2);
            TextView textView4 = (TextView) this.watchlist.findViewById(R.id.student3);
            TextView textView5 = (TextView) this.watchlist.findViewById(R.id.studentTwo);
            TextView textView6 = (TextView) this.watchlist.findViewById(R.id.studentOne);
            TextView textView7 = (TextView) this.watchlist.findViewById(R.id.studentThree);
            try {
                RecyclerView recyclerView = (RecyclerView) this.watchlist.findViewById(R.id.recyclerViewRank);
                recyclerView.setNestedScrollingEnabled(false);
                textView.setText(isForAll ? "Answered" : "Time");
                int i = 1;
                if (TextUtils.isEmpty(leaderboardList.get(1).getUser_id())) {
                    unSelectUserCard(context, cardView2, textView2, textView6, leaderboardList.get(i).getName());
                } else if (leaderboardList.get(1).getUser_id().equalsIgnoreCase(MakeMyExam.getUserId())) {
                    selectUserCard(context, cardView2, textView2, textView6, leaderboardList.get(1).getName());
                } else {
                    i = 1;
                    unSelectUserCard(context, cardView2, textView2, textView6, leaderboardList.get(i).getName());
                }
                if (!TextUtils.isEmpty(leaderboardList.get(0).getUser_id()) && leaderboardList.get(0).getUser_id().equalsIgnoreCase(MakeMyExam.getUserId())) {
                    selectUserCard(context, cardView, textView3, textView5, leaderboardList.get(0).getName());
                } else {
                    unSelectUserCard(context, cardView, textView3, textView5, leaderboardList.get(0).getName());
                }
                if (!TextUtils.isEmpty(leaderboardList.get(2).getUser_id()) && leaderboardList.get(2).getUser_id().equalsIgnoreCase(MakeMyExam.getUserId())) {
                    selectUserCard(context, cardView3, textView4, textView7, leaderboardList.get(2).getName());
                    pollAdapter = this;
                } else {
                    pollAdapter = this;
                    pollAdapter.unSelectUserCard(context, cardView3, textView4, textView7, leaderboardList.get(2).getName());
                }
                ArrayList arrayList = new ArrayList();
                int i2 = 3;
                while (i2 < leaderboardList.size()) {
                    PollLeaderboard pollLeaderboard = leaderboardList.get(i2);
                    i2++;
                    pollLeaderboard.setRank("" + i2);
                    arrayList.add(pollLeaderboard);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(pollAdapter.con));
                recyclerView.setAdapter(new RankAdapter(pollAdapter.con, arrayList, isForAll));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$open_dailog_leader_board$8(view);
                    }
                });
                if (pollAdapter.watchlist.isShowing()) {
                    return;
                }
                pollAdapter.watchlist.show();
                return;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        e.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$open_dailog_leader_board$8(View view) {
        this.watchlist.dismiss();
    }

    private void selectUserCard(Context context, CardView cardView, TextView student, TextView studentText, String name) {
        cardView.setRadius(TypedValue.applyDimension(1, 7.0f, Resources.getSystem().getDisplayMetrics()));
        cardView.setCardElevation(TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics()));
        cardView.setCardBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.colorPrimary, context.getTheme()));
        student.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.white, context.getTheme()));
        student.setText(name);
        studentText.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.white, context.getTheme()));
    }

    private void unSelectUserCard(Context context, CardView cardView, TextView student, TextView studentText, String name) {
        cardView.setRadius(TypedValue.applyDimension(1, 7.0f, Resources.getSystem().getDisplayMetrics()));
        cardView.setCardElevation(TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics()));
        cardView.setCardBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.white, context.getTheme()));
        student.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.colorPrimary, context.getTheme()));
        student.setText(name);
        studentText.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.colorPrimary, context.getTheme()));
    }

    public void openwatchlist_dailog_resource_result(Context context, Polldata polldata) {
        try {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogStyle);
            this.watchlist = bottomSheetDialog;
            bottomSheetDialog.setContentView(R.layout.pollquestion_next_toppers);
            ((Window) Objects.requireNonNull(this.watchlist.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            this.watchlist.setCancelable(false);
            this.watchlist.setCanceledOnTouchOutside(true);
            TextView textView = (TextView) this.watchlist.findViewById(R.id.txt1);
            Button button = (Button) this.watchlist.findViewById(R.id.cancel);
            Button button2 = (Button) this.watchlist.findViewById(R.id.submit);
            button.setVisibility(0);
            button2.setVisibility(8);
            Button button3 = (Button) this.watchlist.findViewById(R.id.buyNowBtn);
            this.typeA = this.watchlist.findViewById(R.id.typeA);
            this.typeB = this.watchlist.findViewById(R.id.typeB);
            this.typeC = this.watchlist.findViewById(R.id.typeC);
            this.typeD = this.watchlist.findViewById(R.id.typeD);
            if (polldata.getAnswer().equalsIgnoreCase("0")) {
                button3.setText(this.con.getResources().getString(R.string.survey_result));
            } else {
                button3.setText(this.con.getResources().getString(R.string.quiz_result));
            }
            if (polldata.getQuestion() != null && !TextUtils.isEmpty(polldata.getQuestion())) {
                textView.setText(Html.fromHtml(polldata.getQuestion()));
            } else {
                textView.setText("");
            }
            Activity activity = this.con;
            if (activity instanceof Liveawsactivity) {
                ((Liveawsactivity) context).isLandscape = false;
                ((Liveawsactivity) context).getServeyData(polldata);
            } else if (activity instanceof LiveStreamingYoutube) {
                ((LiveStreamingYoutube) context).setLandscape(false);
                ((LiveStreamingYoutube) context).getServeyData(polldata);
            } else if (activity instanceof VODPlayerActivity) {
                ((VODPlayerActivity) context).isLandscape = false;
                ((VODPlayerActivity) context).getServeyData(polldata);
            } else {
                ((CustomMediaPlayer) context).getServeyData(polldata);
            }
            button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource_result$9();
                }
            }));
            this.watchlist.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource_result$9() {
        this.watchlist.dismiss();
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public String getdate(String timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * 1000)));
    }

    public void SetServeyresult(Polldata polldata, HashMap<String, Float> servaydata) {
        this.radioButton1 = (ImageView) this.typeA.findViewById(R.id.radioButton1);
        TextView textView = (TextView) this.typeA.findViewById(R.id.option1);
        this.progress1 = (ProgressBar) this.typeA.findViewById(R.id.progress1);
        TextView textView2 = (TextView) this.typeA.findViewById(R.id.percentage1);
        this.radioButton2 = (ImageView) this.typeB.findViewById(R.id.radioButton1);
        TextView textView3 = (TextView) this.typeB.findViewById(R.id.option1);
        this.progress2 = (ProgressBar) this.typeB.findViewById(R.id.progress1);
        TextView textView4 = (TextView) this.typeB.findViewById(R.id.percentage1);
        this.radioButton3 = (ImageView) this.typeC.findViewById(R.id.radioButton1);
        TextView textView5 = (TextView) this.typeC.findViewById(R.id.option1);
        this.progress3 = (ProgressBar) this.typeC.findViewById(R.id.progress1);
        TextView textView6 = (TextView) this.typeC.findViewById(R.id.percentage1);
        this.radioButton4 = (ImageView) this.typeD.findViewById(R.id.radioButton1);
        TextView textView7 = (TextView) this.typeD.findViewById(R.id.option1);
        this.progress4 = (ProgressBar) this.typeD.findViewById(R.id.progress1);
        TextView textView8 = (TextView) this.typeD.findViewById(R.id.percentage1);
        textView.setText(polldata.getOption1());
        textView3.setText(polldata.getOption2());
        textView5.setText(polldata.getOption3());
        textView7.setText(polldata.getOption4());
        textView2.setVisibility(0);
        textView4.setVisibility(0);
        textView6.setVisibility(0);
        textView8.setVisibility(0);
        this.progress1.setProgress((int) Float.parseFloat(String.valueOf(servaydata.get("perA"))));
        textView2.setText(String.format("%.2f", servaydata.get("perA")) + "%");
        this.progress1.setMax(100);
        if (polldata.getOption1().equalsIgnoreCase("")) {
            this.typeA.setVisibility(8);
        } else {
            this.typeA.setVisibility(0);
        }
        this.progress2.setProgress((int) Float.parseFloat(String.valueOf(servaydata.get("perB"))));
        this.progress2.setMax(100);
        textView4.setText(String.format("%.2f", servaydata.get("perB")) + "%");
        if (polldata.getOption2().equalsIgnoreCase("")) {
            this.typeB.setVisibility(8);
        } else {
            this.typeB.setVisibility(0);
        }
        this.progress3.setProgress((int) Float.parseFloat(String.valueOf(servaydata.get("perC"))));
        this.progress3.setMax(100);
        textView6.setText(String.format("%.2f", servaydata.get("perC")) + "%");
        if (polldata.getOption3().equalsIgnoreCase("")) {
            this.typeC.setVisibility(8);
        } else {
            this.typeC.setVisibility(0);
        }
        this.progress4.setProgress((int) Float.parseFloat(String.valueOf(servaydata.get("perD"))));
        this.progress4.setMax(100);
        textView8.setText(String.format("%.2f", servaydata.get("perD")) + "%");
        if (polldata.getOption4().equalsIgnoreCase("")) {
            this.typeD.setVisibility(8);
        } else {
            this.typeD.setVisibility(0);
        }
        if (polldata.getAnswer().equalsIgnoreCase("0")) {
            showForZeroResultsNextToppes(polldata.getMyAnswer());
        } else {
            showpollresultForNextToppers(polldata);
        }
        if (this.watchlist.isShowing()) {
            return;
        }
        this.watchlist.show();
    }

    private void showForZeroResultsNextToppes(String answer) {
        answer.hashCode();
        switch (answer) {
            case "1":
                this.radioButton1.setImageResource(R.mipmap.correct_tick);
                this.progress1.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_green));
                break;
            case "2":
                this.radioButton2.setImageResource(R.mipmap.correct_tick);
                this.progress2.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_green));
                break;
            case "3":
                this.radioButton3.setImageResource(R.mipmap.correct_tick);
                this.progress3.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_green));
                break;
            case "4":
                this.radioButton4.setImageResource(R.mipmap.correct_tick);
                this.progress4.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_green));
                break;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void showpollresultForNextToppers(Polldata polldata) {
        String myAnswer = polldata.getMyAnswer();
        String answer = polldata.getAnswer();
        if (answer.equalsIgnoreCase(myAnswer)) {
            myAnswer.hashCode();
            switch (myAnswer) {
                case "1":
                    this.radioButton1.setImageResource(R.mipmap.correct_tick);
                    this.progress1.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_green));
                    break;
                case "2":
                    this.radioButton2.setImageResource(R.mipmap.correct_tick);
                    this.progress2.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_green));
                    break;
                case "3":
                    this.radioButton3.setImageResource(R.mipmap.correct_tick);
                    this.progress3.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_green));
                    break;
                case "4":
                    this.radioButton4.setImageResource(R.mipmap.correct_tick);
                    this.progress4.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_green));
                    break;
            }
        }
        myAnswer.hashCode();
        switch (myAnswer) {
            case "1":
                this.radioButton1.setImageResource(R.mipmap.incorrect_tick);
                this.progress1.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_red));
                break;
            case "2":
                this.radioButton2.setImageResource(R.mipmap.incorrect_tick);
                this.progress2.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_red));
                break;
            case "3":
                this.radioButton3.setImageResource(R.mipmap.incorrect_tick);
                this.progress3.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_red));
                break;
            case "4":
                this.radioButton4.setImageResource(R.mipmap.incorrect_tick);
                this.progress4.setProgressDrawable(this.con.getResources().getDrawable(R.drawable.custom_progress_bar_red));
                break;
        }
        answer.hashCode();
        switch (answer.hashCode()) {
            case 49:
                if (!answer.equals("1")) {
                }
                break;
            case 50:
                if (!answer.equals("2")) {
                }
                break;
            case 51:
                if (!answer.equals("3")) {
                }
                break;
            case 52:
                if (!answer.equals("4")) {
                }
                break;
            default:
                break;
        }
        /*  JADX ERROR: Method code generation error
            java.lang.NullPointerException: Switch insn not found in header
            	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:88)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.PollAdapter.showpollresultForNextToppers(com.appnew.android.Model.PlayerPojo.Polldata):void");
    }

    public void notifyadap(final Viewholder holder, int position) {
        if (!this.polldata.get(position).getAnswer().equalsIgnoreCase("0")) {
            if (this.polldata.get(position).getDisable_result().equalsIgnoreCase("0")) {
                holder.takeAPollBtn.setText(this.con.getResources().getString(R.string.result));
                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.PollAdapter$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$notifyadap$10(holder);
                    }
                }, 1000L);
                return;
            } else {
                holder.leaderBoardBtn.setVisibility(8);
                holder.takeAPollBtn.setText(this.con.getResources().getString(R.string.expired_));
                return;
            }
        }
        if (this.polldata.get(position).getDisable_result().equalsIgnoreCase("0")) {
            holder.takeAPollBtn.setText(this.con.getResources().getString(R.string.survey_result));
            holder.leaderBoardBtn.setVisibility(8);
        } else {
            holder.leaderBoardBtn.setVisibility(8);
            holder.takeAPollBtn.setText(this.con.getResources().getString(R.string.expired_));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyadap$10(Viewholder viewholder) {
        Activity activity = this.con;
        if (activity instanceof Liveawsactivity) {
            viewholder.leaderBoardBtn.setVisibility(((Liveawsactivity) this.context).isFirebaseChat ? 8 : 0);
            return;
        }
        if (activity instanceof LiveStreamingYoutube) {
            viewholder.leaderBoardBtn.setVisibility(((LiveStreamingYoutube) this.context).getIsFirebaseChat() ? 8 : 0);
        } else if (activity instanceof VODPlayerActivity) {
            viewholder.leaderBoardBtn.setVisibility(((VODPlayerActivity) this.context).isFirebaseChat ? 8 : 0);
        } else {
            viewholder.leaderBoardBtn.setVisibility(8);
        }
    }

    public void showLeaderboard(LeaderboardResponse leaderboardResponse, boolean isForAll) {
        if (leaderboardResponse != null) {
            try {
                if (leaderboardResponse.getData() != null && leaderboardResponse.getData().size() > 3) {
                    open_dailog_leader_board(this.con, leaderboardResponse.getData(), isForAll);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        Toast.makeText(this.con, "No Leaderboard found", 0).show();
    }
}
