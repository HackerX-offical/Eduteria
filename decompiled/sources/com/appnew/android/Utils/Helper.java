package com.appnew.android.Utils;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.content.IntentCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amulyakhare.textdrawable.TextDrawable;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Activity.WebFragActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.Modal.CartItems;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.JWextractor.JWVideoPlayer;
import com.appnew.android.LiveClass.Activity.LiveClassActivity;
import com.appnew.android.Login.Activity.LoginCatActivity;
import com.appnew.android.Login.Activity.SignInActivity;
import com.appnew.android.Login.Activity.SplashScreen;
import com.appnew.android.Model.BottomMenu;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.Courses.SinglestudyModel;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.PollLocalResult;
import com.appnew.android.Model.PostFile;
import com.appnew.android.Model.Sme.ExpertLeftMenu;
import com.appnew.android.Model.UrlObject;
import com.appnew.android.Model.Video;
import com.appnew.android.PDFViewerJS.PDFViewerJS;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.retrofit.NimbusRetrofitApi;
import com.appnew.android.Utils.Network.retrofit.RetrofitClient;
import com.appnew.android.Utils.shortcuts.Shortsuts;
import com.appnew.android.Webview.PdfHtmlAcivity;
import com.appnew.android.databinding.BottomSheetStreamYtBinding;
import com.appnew.android.home.Constants;
import com.appnew.android.home.liveclasses.Datum;
import com.appnew.android.home.model.Menu;
import com.appnew.android.loginRevamp.Activity.LoginCatNewActivity;
import com.appnew.android.loginRevamp.Activity.SignInNewActivity;
import com.appnew.android.player.LiveStreamingYoutube;
import com.appnew.android.player.Liveawsactivity;
import com.appnew.android.player.VODPlayerActivity;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.BottomMenuTable;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.testmodule.activity.SubjectiveResultActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageView;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.db.Column;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.LicenseCheckerCallback;
import com.google.android.vending.licensing.ServerManagedPolicy;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tv9news.utils.helpers.AnalyticsConstants;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Helper {
    private static Dialog dialog;
    public static LicenseChecker mChecker;
    public static GoogleSignInClient mGoogleSignInClient;
    public static ProgressDialog progressBar;
    public static videoPlayerStorage storage;
    private static final byte[] SALT = {-46, 65, Ascii.RS, -128, -103, -57, 74, -64, 51, 88, -95, -45, 77, -117, -36, -113, -11, 32, -64, 89};
    public static boolean comboinside = false;
    public static boolean isNavigate = true;
    public static int grideHeight = 90;
    public static int grideWidth = 90;
    static int i = 0;
    private static String paymenttype = "";
    public static String isvisible = "0";
    public static String google_signin = "";
    private static String firebaseToken = null;

    public interface OnTokenReceivedListener {
        void onTokenReceived(String token);
    }

    public static String getHtmlUpdatedData(String value) {
        return value;
    }

    public static void logPrinter(String ClassName, String errorType, String response, String Message) {
    }

    public static void logUser(Activity activity) {
    }

    public static void setSystemBarLight(Activity act) {
        if (Build.VERSION.SDK_INT >= 30) {
            new WindowInsetsControllerCompat(act.getWindow(), act.findViewById(R.id.content)).setAppearanceLightStatusBars(false);
        }
    }

    public static void DeveloperOpt(Activity act) {
        try {
            if (TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.DEVELOPER_OPTIONS)) || !SharedPreference.getInstance().getString(Const.DEVELOPER_OPTIONS).equalsIgnoreCase("1")) {
                return;
            }
            if (Settings.Secure.getInt(act.getContentResolver(), "development_settings_enabled", 0) == 1 || Settings.Secure.getInt(act.getContentResolver(), "adb_enabled", 0) == 1) {
                DeveloperOptionDialog.getInstance().dismissDialog();
                DeveloperOptionDialog.getInstance().showDialog(act);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean isInValidIndianMobile(String mobile) {
        if (mobile == null) {
            return false;
        }
        return !mobile.matches("^(\\+91[\\-\\s]?)?[0]?(91)?[6789]\\d{9}$");
    }

    public static videoPlayerStorage getStorageInstance(Context activity) {
        try {
            storage = new videoPlayerStorage(activity, activity.getString(com.eduteria.app.app.R.string.app_name), activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return storage;
    }

    public static String getdate(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(Long.parseLong(String.valueOf(timestamp))));
    }

    public static String getDateTime(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(String.valueOf(timestamp))));
    }

    public static String getTimeOnly(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(String.valueOf(timestamp))));
    }

    public static void GoToLiveAwsVideoActivity1(final String videotype, final String chatnode, final Activity activity, final String Url, final String islive, final String vid, final String title, final String is_audio, final String thubnail, final String course_id, final String tileid, final String tiletype, final String islocked, final String pos, final String parentid, final String bookmark, final ArrayList<Video> videoArrayList) {
        if (SharedPreference.getInstance().getString(Const.BITRATE_SELECTION).equalsIgnoreCase("1")) {
            final Dialog dialog2 = new Dialog(activity);
            dialog2.setContentView(com.eduteria.app.app.R.layout.custom_quality_dialog);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog2.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            final RecyclerView recyclerView = (RecyclerView) dialog2.findViewById(com.eduteria.app.app.R.id.qualityRecycler);
            final ProgressBar progressBar2 = (ProgressBar) dialog2.findViewById(com.eduteria.app.app.R.id.qualityProgressBar);
            final ArrayList arrayList = new ArrayList();
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    Helper.lambda$GoToLiveAwsVideoActivity1$2(Url, arrayList, recyclerView, activity, videotype, chatnode, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, bookmark, videoArrayList, dialog2, progressBar2);
                }
            });
            dialog2.show();
            return;
        }
        playVideoActivity(videotype, chatnode, activity, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, bookmark, videoArrayList, "", 0);
    }

    static /* synthetic */ void lambda$GoToLiveAwsVideoActivity1$2(final String str, final ArrayList arrayList, final RecyclerView recyclerView, final Activity activity, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final String str13, final String str14, final String str15, final ArrayList arrayList2, final Dialog dialog2, final ProgressBar progressBar2) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return;
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (line.contains("RESOLUTION")) {
                        for (String str16 : line.split(Constants.SEPARATOR_COMMA)) {
                            if (str16.contains("RESOLUTION")) {
                                arrayList.add(str16);
                            }
                        }
                    }
                } else {
                    bufferedReader.close();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Helper.lambda$GoToLiveAwsVideoActivity1$1(recyclerView, activity, arrayList, str2, str3, str, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, arrayList2, dialog2, progressBar2);
                        }
                    });
                    bufferedReader.close();
                    return;
                }
            } finally {
            }
            e2.printStackTrace();
            return;
        }
    }

    static /* synthetic */ void lambda$GoToLiveAwsVideoActivity1$1(RecyclerView recyclerView, final Activity activity, ArrayList arrayList, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final String str13, final String str14, final String str15, final ArrayList arrayList2, final Dialog dialog2, ProgressBar progressBar2) {
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        QualityAdapter qualityAdapter = new QualityAdapter(activity, arrayList, new QualityAdapter.OnItemClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda22
            @Override // com.appnew.android.Utils.Helper.QualityAdapter.OnItemClickListener
            public final void onItemClick(String str16, int i2) {
                Helper.lambda$GoToLiveAwsVideoActivity1$0(str, str2, activity, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, arrayList2, dialog2, str16, i2);
            }
        });
        progressBar2.setVisibility(8);
        recyclerView.setAdapter(qualityAdapter);
    }

    static /* synthetic */ void lambda$GoToLiveAwsVideoActivity1$0(String str, String str2, Activity activity, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, ArrayList arrayList, Dialog dialog2, String str16, int i2) {
        playVideoActivity(str, str2, activity, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, arrayList, str16, i2);
        dialog2.dismiss();
    }

    public static boolean checkEnable() {
        return BuildConfig.FLAVOR.equalsIgnoreCase("NextToppers");
    }

    public static void removeConnection(DatabaseReference mFirebaseDatabaseReference1) {
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/");
        databaseReferenceChild.onDisconnect().removeValue();
        databaseReferenceChild.setValue(true);
    }

    public static void SingleClick(final View itemView) {
        itemView.setEnabled(false);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                itemView.setEnabled(true);
            }
        }, 2000L);
    }

    public static ArrayList CheckLiveStatus(ArrayList<Datum> livevideocompleted, int classType) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < livevideocompleted.size(); i2++) {
            if (livevideocompleted.get(i2).getVideoType().equalsIgnoreCase("4") || livevideocompleted.get(i2).getVideoType().equalsIgnoreCase("5") || livevideocompleted.get(i2).getVideoType().equalsIgnoreCase("8")) {
                if (classType == 0 && livevideocompleted.get(i2).getLiveStatus().equalsIgnoreCase("1")) {
                    arrayList.add(livevideocompleted.get(i2));
                }
            } else {
                arrayList.add(livevideocompleted.get(i2));
            }
        }
        return livevideocompleted;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.appnew.android.Utils.Helper$1] */
    public static void CountDownTimer(long timerr, long timeInSec, final TextView dialogTimer) {
        new CountDownTimer(timerr, timeInSec) { // from class: com.appnew.android.Utils.Helper.1
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                dialogTimer.setText(Helper.concerter(millisUntilFinished));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                dialogTimer.setText("00:00");
            }
        }.start();
    }

    public static class QualityAdapter extends RecyclerView.Adapter<ViewHolder> {
        private Activity context;
        OnItemClickListener listener;
        private ArrayList<String> qualityList;

        public interface OnItemClickListener {
            void onItemClick(String quality, int position);
        }

        public QualityAdapter(Activity context, ArrayList<String> qualityList, OnItemClickListener listener) {
            this.context = context;
            this.qualityList = qualityList;
            this.listener = listener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(this.context).inflate(com.eduteria.app.app.R.layout.new_item_shap, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final String str = this.qualityList.get(position);
            holder.button.setText(str.split("[=x]")[2] + "p");
            holder.button.setBackground(this.context.getResources().getDrawable(com.eduteria.app.app.R.drawable.background_bg_next_coupon));
            holder.button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.Helper$QualityAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(str, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, int i, View view) {
            OnItemClickListener onItemClickListener = this.listener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(str.split("[=x]")[2], i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.qualityList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            Button button;

            public ViewHolder(View itemView) {
                super(itemView);
                this.button = (Button) itemView.findViewById(com.eduteria.app.app.R.id.bitrateButton);
            }
        }
    }

    public static void GoToLiveAwsVideoActivity(final String videotype, final String chatnode, final Activity activity, final String Url, final String islive, final String vid, final String title, final String is_audio, final String thubnail, final String course_id, final String tileid, final String tiletype, final String islocked, final String pos, final String parentid, final String starttime, final ArrayList<Video> videoArrayList) {
        if (videoArrayList.get(Integer.parseInt(pos)).getIs_drm().equalsIgnoreCase("1") || videoArrayList.get(Integer.parseInt(pos)).getIs_live().equalsIgnoreCase("1")) {
            Intent intent = new Intent(activity, (Class<?>) Liveawsactivity.class);
            intent.putExtra(Const.VIDEO_LINK, Url);
            intent.putExtra("Chat_node", chatnode);
            intent.putExtra(Const.VIDEO_TYPE, videotype);
            intent.putExtra("live", islive);
            intent.putExtra(Const.VIDEO_ID, vid);
            intent.putExtra("video_name", title);
            intent.putExtra("isaudio", is_audio);
            intent.putExtra("thumbnail", thubnail);
            intent.putExtra("tileid", tileid);
            intent.putExtra("tiletype", tiletype);
            intent.putExtra("courseid", course_id);
            intent.putExtra("islocked", islocked);
            intent.putExtra(Const.shareparentid, parentid);
            intent.putExtra(Constants.INAPP_POSITION, pos);
            intent.putExtra("starttime", starttime);
            SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
            gotoActivity(intent, activity);
            return;
        }
        if (SharedPreference.getInstance().getString(Const.BITRATE_SELECTION).equalsIgnoreCase("1")) {
            final Dialog dialog2 = new Dialog(activity);
            dialog2.setContentView(com.eduteria.app.app.R.layout.custom_quality_dialog);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog2.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            final RecyclerView recyclerView = (RecyclerView) dialog2.findViewById(com.eduteria.app.app.R.id.qualityRecycler);
            final ProgressBar progressBar2 = (ProgressBar) dialog2.findViewById(com.eduteria.app.app.R.id.qualityProgressBar);
            final ArrayList arrayList = new ArrayList();
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    Helper.lambda$GoToLiveAwsVideoActivity$6(videoArrayList, pos, arrayList, recyclerView, activity, videotype, chatnode, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, parentid, starttime, dialog2, progressBar2);
                }
            });
            dialog2.show();
            return;
        }
        GoToLiveAwsPlayerActivity(videotype, chatnode, activity, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, starttime, videoArrayList, "", 0);
    }

    static /* synthetic */ void lambda$GoToLiveAwsVideoActivity$6(final ArrayList arrayList, final String str, final ArrayList arrayList2, final RecyclerView recyclerView, final Activity activity, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final String str13, final String str14, final String str15, final Dialog dialog2, final ProgressBar progressBar2) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new URL(((Video) arrayList.get(Integer.parseInt(str))).getFile_url()).openStream()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return;
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (line.contains("RESOLUTION")) {
                        for (String str16 : line.split(Constants.SEPARATOR_COMMA)) {
                            if (str16.contains("RESOLUTION")) {
                                arrayList2.add(str16);
                            }
                        }
                    }
                } else {
                    bufferedReader.close();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            Helper.lambda$GoToLiveAwsVideoActivity$5(recyclerView, activity, arrayList2, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str, str14, str15, arrayList, dialog2, progressBar2);
                        }
                    });
                    bufferedReader.close();
                    return;
                }
            } finally {
            }
            e2.printStackTrace();
            return;
        }
    }

    static /* synthetic */ void lambda$GoToLiveAwsVideoActivity$5(RecyclerView recyclerView, final Activity activity, ArrayList arrayList, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final String str13, final String str14, final String str15, final ArrayList arrayList2, final Dialog dialog2, ProgressBar progressBar2) {
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        QualityAdapter qualityAdapter = new QualityAdapter(activity, arrayList, new QualityAdapter.OnItemClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda10
            @Override // com.appnew.android.Utils.Helper.QualityAdapter.OnItemClickListener
            public final void onItemClick(String str16, int i2) {
                Helper.lambda$GoToLiveAwsVideoActivity$4(str, str2, activity, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, arrayList2, dialog2, str16, i2);
            }
        });
        progressBar2.setVisibility(8);
        recyclerView.setAdapter(qualityAdapter);
    }

    static /* synthetic */ void lambda$GoToLiveAwsVideoActivity$4(String str, String str2, Activity activity, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, ArrayList arrayList, Dialog dialog2, String str16, int i2) {
        GoToLiveAwsPlayerActivity(str, str2, activity, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, arrayList, str16, i2);
        dialog2.dismiss();
    }

    public static void GoToLiveAwsVideoActivityDatumLiveCls(final String videotype, final String chatnode, final Activity activity, final String Url, final String islive, final String vid, final String title, final String is_audio, final String thubnail, final String course_id, final String tileid, final String tiletype, final String islocked, final String pos, final String parentid, final String starttime, final ArrayList<Datum> videoArrayList) {
        if (videoArrayList.get(Integer.parseInt(pos)).getIsdrm().equalsIgnoreCase("1") || videoArrayList.get(Integer.parseInt(pos)).getIs_live().equalsIgnoreCase("1")) {
            Intent intent = new Intent(activity, (Class<?>) Liveawsactivity.class);
            intent.putExtra(Const.VIDEO_LINK, Url);
            intent.putExtra("Chat_node", chatnode);
            intent.putExtra(Const.VIDEO_TYPE, videotype);
            intent.putExtra("live", islive);
            intent.putExtra(Const.VIDEO_ID, vid);
            intent.putExtra("video_name", title);
            intent.putExtra("isaudio", is_audio);
            intent.putExtra("thumbnail", thubnail);
            intent.putExtra("tileid", tileid);
            intent.putExtra("tiletype", tiletype);
            intent.putExtra("courseid", course_id);
            intent.putExtra("islocked", islocked);
            intent.putExtra(Const.shareparentid, parentid);
            intent.putExtra(Constants.INAPP_POSITION, pos);
            intent.putExtra("starttime", starttime);
            SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
            gotoActivity(intent, activity);
            return;
        }
        if (SharedPreference.getInstance().getString(Const.BITRATE_SELECTION).equalsIgnoreCase("1")) {
            final Dialog dialog2 = new Dialog(activity);
            dialog2.setContentView(com.eduteria.app.app.R.layout.custom_quality_dialog);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog2.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            final RecyclerView recyclerView = (RecyclerView) dialog2.findViewById(com.eduteria.app.app.R.id.qualityRecycler);
            final ProgressBar progressBar2 = (ProgressBar) dialog2.findViewById(com.eduteria.app.app.R.id.qualityProgressBar);
            final ArrayList arrayList = new ArrayList();
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    Helper.lambda$GoToLiveAwsVideoActivityDatumLiveCls$9(videoArrayList, pos, arrayList, recyclerView, activity, videotype, chatnode, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, parentid, starttime, dialog2, progressBar2);
                }
            });
            dialog2.show();
            return;
        }
        GoToLiveAwsPlayerActivityForLiveCls(videotype, chatnode, activity, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, starttime, videoArrayList, "", 0);
    }

    static /* synthetic */ void lambda$GoToLiveAwsVideoActivityDatumLiveCls$9(final ArrayList arrayList, final String str, final ArrayList arrayList2, final RecyclerView recyclerView, final Activity activity, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final String str13, final String str14, final String str15, final Dialog dialog2, final ProgressBar progressBar2) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new URL(((Datum) arrayList.get(Integer.parseInt(str))).getFileUrl()).openStream()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return;
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (line.contains("RESOLUTION")) {
                        for (String str16 : line.split(Constants.SEPARATOR_COMMA)) {
                            if (str16.contains("RESOLUTION")) {
                                arrayList2.add(str16);
                            }
                        }
                    }
                } else {
                    bufferedReader.close();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            Helper.lambda$GoToLiveAwsVideoActivityDatumLiveCls$8(recyclerView, activity, arrayList2, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str, str14, str15, arrayList, dialog2, progressBar2);
                        }
                    });
                    bufferedReader.close();
                    return;
                }
            } finally {
            }
            e2.printStackTrace();
            return;
        }
    }

    static /* synthetic */ void lambda$GoToLiveAwsVideoActivityDatumLiveCls$8(RecyclerView recyclerView, final Activity activity, ArrayList arrayList, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final String str13, final String str14, final String str15, final ArrayList arrayList2, final Dialog dialog2, ProgressBar progressBar2) {
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        QualityAdapter qualityAdapter = new QualityAdapter(activity, arrayList, new QualityAdapter.OnItemClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda24
            @Override // com.appnew.android.Utils.Helper.QualityAdapter.OnItemClickListener
            public final void onItemClick(String str16, int i2) {
                Helper.lambda$GoToLiveAwsVideoActivityDatumLiveCls$7(str, str2, activity, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, arrayList2, dialog2, str16, i2);
            }
        });
        progressBar2.setVisibility(8);
        recyclerView.setAdapter(qualityAdapter);
    }

    static /* synthetic */ void lambda$GoToLiveAwsVideoActivityDatumLiveCls$7(String str, String str2, Activity activity, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, ArrayList arrayList, Dialog dialog2, String str16, int i2) {
        GoToLiveAwsPlayerActivityForLiveCls(str, str2, activity, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, arrayList, str16, i2);
        dialog2.dismiss();
    }

    public static void GoToLiveAwsPlayerActivity(String videotype, String chatnode, Activity activity, String Url, String islive, String vid, String title, String is_audio, String thubnail, String course_id, String tileid, String tiletype, String islocked, String pos, String parentid, String starttime, ArrayList<Video> videoArrayList, String videoQuality, int position) {
        Intent intent = new Intent(activity, (Class<?>) Liveawsactivity.class);
        intent.putExtra(Const.RESOLUTION, videoQuality);
        intent.putExtra(Const.RESOLUTION_POSITION, position);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra(Const.VIDEO_TYPE, videotype);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("courseid", course_id);
        intent.putExtra("islocked", islocked);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra(Constants.INAPP_POSITION, pos);
        intent.putExtra("starttime", starttime);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static void GoToLiveAwsPlayerActivityForLiveCls(String videotype, String chatnode, Activity activity, String Url, String islive, String vid, String title, String is_audio, String thubnail, String course_id, String tileid, String tiletype, String islocked, String pos, String parentid, String starttime, ArrayList<Datum> videoArrayList, String videoQuality, int position) {
        Intent intent = new Intent(activity, (Class<?>) Liveawsactivity.class);
        intent.putExtra(Const.RESOLUTION, videoQuality);
        intent.putExtra(Const.RESOLUTION_POSITION, position);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra(Const.VIDEO_TYPE, videotype);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("courseid", course_id);
        intent.putExtra("islocked", islocked);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra(Constants.INAPP_POSITION, pos);
        intent.putExtra("starttime", starttime);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static void GoToLiveAwsVideoActivityIvs(String videotype, String chatnode, Activity activity, String Url, String islive, String vid, String title, String is_audio, String thubnail, String course_id, String tileid, String tiletype, String islocked, String pos, String parentid, String starttime) {
        Intent intent = new Intent(activity, (Class<?>) Liveawsactivity.class);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra(Const.VIDEO_TYPE, videotype);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("courseid", course_id);
        intent.putExtra("islocked", islocked);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra(Constants.INAPP_POSITION, pos);
        intent.putExtra("starttime", starttime);
        intent.putExtra("isIvs", "1");
        gotoActivity(intent, activity);
    }

    public static void GoToLiveAwsVideoActivity(String videotype, String chatnode, Activity activity, String Url, String islive, String vid, String title, String is_audio, String thubnail, String course_id, String tileid, String tiletype, String islocked, String pos, String parentid, ArrayList<Video> videoArrayList) {
        Intent intent = new Intent(activity, (Class<?>) Liveawsactivity.class);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra(Const.VIDEO_TYPE, videotype);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("courseid", course_id);
        intent.putExtra("islocked", islocked);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra(Constants.INAPP_POSITION, pos);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static void shareTestg(final Activity activity, String maincourseid, String fieldid, String topicid, String tile_type, String tileid, String revertapi, String type, String image, String name, String parentid) {
        Progress progress;
        String str;
        Progress progress2 = new Progress(activity);
        progress2.show();
        String str2 = parentid;
        if (str2.equalsIgnoreCase(maincourseid)) {
            str2 = null;
        }
        if (str2 == null || str2.isEmpty()) {
            progress = progress2;
            str = "testcourseid=" + maincourseid + "&fieldid=" + fieldid + "&topicid=" + topicid + "&tile_type=" + tile_type + "&tileid=" + tileid + "&revertapi=" + revertapi + "&type=" + type;
        } else {
            progress = progress2;
            str = "testcourseid=" + maincourseid + "&fieldid=" + fieldid + "&topicid=" + topicid + "&tile_type=" + tile_type + "&parentid=" + str2 + "&tileid=" + tileid + "&revertapi=" + revertapi + "&type=" + type;
        }
        if (SharedPreference.getInstance().getString(Const.SHARE_LINK_WITH_FIREBASE).equalsIgnoreCase("1")) {
            final Progress progress3 = progress;
            FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse("https://appapi.videocrypt.in/?data=" + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0))).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(image)).setTitle(name).build()).setDomainUriPrefix(API.DYNAMIC_LINK_PREFIX).setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build()).buildShortDynamicLink().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda34
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Helper.lambda$shareTestg$10(progress3, activity, task);
                }
            });
            return;
        }
        String strShareDataEncrypt = AES.shareDataEncrypt("?" + str.trim());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", getDynamicLinkUrl(activity) + strShareDataEncrypt);
        activity.startActivity(Intent.createChooser(intent, "Share via"));
        progress.dismiss();
    }

    static /* synthetic */ void lambda$shareTestg$10(Progress progress, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Course link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
            return;
        }
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink2 = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Course link", shortLink2.toString(), String.format(shortLink2.toString(), new Object[0]));
        } else {
            progress.dismiss();
            Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.live_could_not_be_generated_please_try_again), 0).show();
        }
    }

    public static String getDate(long milliSeconds, String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(new Date(milliSeconds));
    }

    public static boolean checkStartTime(long startTime) {
        return startTime > Long.parseLong(SharedPreference.getInstance().getString(Const.SERVER_TIME));
    }

    public static boolean checkStartTime1(long endTime) {
        return endTime > Long.parseLong(SharedPreference.getInstance().getString(Const.SERVER_TIME));
    }

    public static void shareCourse(final Activity activity, String maincourseid, String iscombo, String parentcourseid, String name, String image, String title) {
        final Progress progress = new Progress(activity);
        progress.show();
        String str = (parentcourseid == null || parentcourseid.isEmpty()) ? "maincouseid=" + maincourseid + "&iscombo=" + iscombo + "&comboid=" : "maincouseid=" + maincourseid + "&iscombo=" + iscombo + "&parentcourseid=" + parentcourseid + "&comboid=";
        if (SharedPreference.getInstance().getString(Const.SHARE_LINK_WITH_FIREBASE).equalsIgnoreCase("1")) {
            FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse("https://appapi.videocrypt.in/?data=" + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0))).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(image)).setTitle(title).build()).setDomainUriPrefix(API.DYNAMIC_LINK_PREFIX).setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build()).buildShortDynamicLink().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda35
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Helper.lambda$shareCourse$11(progress, activity, task);
                }
            });
            return;
        }
        String strShareDataEncrypt = AES.shareDataEncrypt("?" + str.trim());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", getDynamicLinkUrl(activity) + strShareDataEncrypt);
        activity.startActivity(Intent.createChooser(intent, "Share via"));
        progress.dismiss();
    }

    static /* synthetic */ void lambda$shareCourse$11(Progress progress, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Course link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
            return;
        }
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink2 = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Course link", shortLink2.toString(), String.format(shortLink2.toString(), new Object[0]));
        } else {
            progress.dismiss();
            Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.live_could_not_be_generated_please_try_again), 0).show();
        }
    }

    public static String getDynamicLinkUrl(Activity activity) {
        return "https://" + activity.getResources().getString(com.eduteria.app.app.R.string.host_link) + activity.getResources().getString(com.eduteria.app.app.R.string.package_name) + "?token=";
    }

    public static TextDrawable GetDrawableWithCustomColor(String text, Context context, int color) {
        if (TextUtils.isEmpty(text)) {
            return null;
        }
        return TextDrawable.builder().buildRound(text, color);
    }

    public static void dismissProgressDialog() {
        try {
            Dialog dialog2 = dialog;
            if (dialog2 == null || !dialog2.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void showProgressDialog(final Context context) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                Helper.lambda$showProgressDialog$12(context);
            }
        });
    }

    static /* synthetic */ void lambda$showProgressDialog$12(Context context) {
        try {
            dismissProgressDialog();
            Dialog dialog2 = new Dialog(context, com.eduteria.app.app.R.style.TransparentDialog);
            dialog = dialog2;
            dialog2.requestWindowFeature(1);
            View viewInflate = LayoutInflater.from(context).inflate(com.eduteria.app.app.R.layout.progress_layout_new, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.appNameLoader);
            if (BuildConfig.FLAVOR.equalsIgnoreCase("arene")) {
                textView.setVisibility(0);
                textView.setText("Bonding with Abhishek Sir");
            }
            dialog.setContentView(viewInflate);
            dialog.setCancelable(false);
            dialog.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String convertSeconds(int seconds) {
        String strValueOf;
        String string;
        int i2 = seconds / 3600;
        int i3 = (seconds % 3600) / 60;
        int i4 = seconds % 60;
        String str = i2 > 0 ? String.valueOf(i2) + " h" : "";
        String str2 = "0";
        StringBuilder sbAppend = new StringBuilder().append((i3 >= 10 || i3 <= 0 || i2 <= 0) ? "" : "0");
        if (i3 > 0) {
            strValueOf = (i2 <= 0 || i4 != 0) ? String.valueOf(i3) + " min" : String.valueOf(i3);
        } else {
            strValueOf = "";
        }
        String string2 = sbAppend.append(strValueOf).toString();
        if (i4 == 0 && (i2 > 0 || i3 > 0)) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            if (i4 >= 10 || (i2 <= 0 && i3 <= 0)) {
                str2 = "";
            }
            string = sb.append(str2).append(String.valueOf(i4)).append(" sec").toString();
        }
        return str + (i2 > 0 ? " " : "") + string2 + (i3 > 0 ? " " : "") + string;
    }

    public static void showToastSecurity(Activity activity) {
        Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.unable_to_load_due_to_security), 0).show();
    }

    public static boolean DataNotValid(EditText view, Context context) {
        view.setError(context.getString(com.eduteria.app.app.R.string.this_field_is_required));
        view.requestFocus();
        return false;
    }

    public static boolean DataNotValid(AutoCompleteTextView view, Context context) {
        view.setError(context.getString(com.eduteria.app.app.R.string.this_field_is_required));
        view.requestFocus();
        return false;
    }

    public static boolean DataNotValid(TextInputLayout view, Context context) {
        view.setError(context.getString(com.eduteria.app.app.R.string.this_field_is_required));
        view.requestFocus();
        return false;
    }

    public static boolean isNetworkConnected(Context ctx) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ctx.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void goToDownloadsOfflineMode(Activity context) {
        if (SharedPreference.getInstance().getString(Const.DOWNLOAD_VISIBLE_WITH_INTERNET).equalsIgnoreCase("1")) {
            buildDialogNoInternet(context);
            return;
        }
        if (SharedPreference.getInstance().getLoggedInUser() == null || SharedPreference.getInstance().getLoggedInUser().getId() == null || SharedPreference.getInstance().getLoggedInUser() == null || SharedPreference.getInstance().getLoggedInUser().getId().equalsIgnoreCase("0")) {
            return;
        }
        MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
        MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
        context.startActivityForResult(new Intent(context, (Class<?>) DownloadActivity.class), 1000);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static void showSnackBar(View view, CharSequence text) {
        if (view != null) {
            try {
                final Snackbar snackbarMake = Snackbar.make(view, text, -2);
                TextView textView = (TextView) snackbarMake.getView().findViewById(com.eduteria.app.app.R.id.snackbar_text);
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                textView.setMaxLines(5);
                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Utils.Helper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        snackbarMake.dismiss();
                    }
                }, 4000L);
                snackbarMake.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String getPlayerState(int playbackState) {
        if (playbackState == 1) {
            return "STATE_IDLE = First Time Loading...";
        }
        if (playbackState == 2) {
            return "STATE_BUFFERING = Loading... ";
        }
        if (playbackState == 3) {
            return "STATE_READY = Video Play";
        }
        if (playbackState == 4) {
            return "STATE_ENDED = Video End";
        }
        return "";
    }

    public static boolean checkXposed(Activity activity) {
        return securityForRoot(activity);
    }

    public static boolean securityForRoot(final Activity activity) {
        boolean z;
        String str;
        PackageManager packageManager = activity.getPackageManager();
        for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(128)) {
            try {
                str = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(applicationInfo.packageName, 128));
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (applicationInfo.packageName.contains("de.robv.android.xposed.installer") || applicationInfo.packageName.contains("de.robv.android.xposed.installer.WelcomeActivity") || applicationInfo.packageName.contains("com.liof.screenrecfree") || applicationInfo.packageName.contains("com.hecorat.screenrecorder.free") || applicationInfo.packageName.contains("me.weishu.exp") || applicationInfo.packageName.contains("io.virtualapp") || applicationInfo.packageName.contains("vidma.screenrecorder.videorecorder.videoeditor.pro") || applicationInfo.packageName.contains("de.robv.android.xposed:api:82") || applicationInfo.packageName.contains("de.robv.android.xposed:api:82:sources") || str.equalsIgnoreCase("VirtualXposed") || applicationInfo.packageName.contains("com.topjohnwu.magisk")) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            DialogUtils.makeSingleButtonDialog(activity, "", activity.getResources().getString(com.eduteria.app.app.R.string.screen_capturing_msg), activity.getResources().getString(com.eduteria.app.app.R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.3
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public void onOKClick() {
                    activity.finish();
                }
            });
        } else {
            if (bluestack() != null && bluestack().contains("bluestack")) {
                DialogUtils.makeSingleButtonDialog(activity, "", activity.getResources().getString(com.eduteria.app.app.R.string.physical_device_msg), activity.getResources().getString(com.eduteria.app.app.R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.4
                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                    public void onOKClick() {
                        activity.finish();
                    }
                });
                return true;
            }
            if (RootUtil.isDeviceRooted()) {
                DialogUtils.makeSingleButtonDialog(activity, "", "isdevicerooted", activity.getResources().getString(com.eduteria.app.app.R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.5
                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                    public void onOKClick() {
                        activity.finish();
                    }
                });
                return true;
            }
            if (RootUtil.detectFullRoot(activity)) {
                DialogUtils.makeSingleButtonDialog(activity, "", "detectfullroot", activity.getResources().getString(com.eduteria.app.app.R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.6
                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                    public void onOKClick() {
                        activity.finish();
                    }
                });
                return true;
            }
            if (RootUtil.check_proxy(activity)) {
                DialogUtils.makeSingleButtonDialog(activity, "VPN Enabled.", "Please disable your VPN to continue...", activity.getResources().getString(com.eduteria.app.app.R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.7
                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                    public void onOKClick() {
                        activity.finish();
                    }
                });
                return true;
            }
            if (Build.HOST.startsWith("Build") || "google_sdk".equals(Build.PRODUCT) || EmulatorDetector.isEmulator(activity) || Build.MODEL.contains("Emulator") || Build.HARDWARE.contains("BlueStack") || Build.MANUFACTURER.contains("Genymotion")) {
                DialogUtils.makeSingleButtonDialog(activity, "", "Host error", activity.getResources().getString(com.eduteria.app.app.R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.8
                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                    public void onOKClick() {
                        activity.finish();
                    }
                });
                return true;
            }
            if (!isNetworkConnected(activity)) {
                DialogUtils.makeSingleButtonDialog(activity, "", activity.getResources().getString(com.eduteria.app.app.R.string.no_internet_connection), activity.getResources().getString(com.eduteria.app.app.R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.9
                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                    public void onOKClick() {
                        activity.finish();
                    }
                });
            }
        }
        return z;
    }

    public static String bluestack() {
        return "Build.PRODUCT: " + Build.PRODUCT + "\nBuild.MANUFACTURER: " + Build.MANUFACTURER + "\nBuild.BRAND: " + Build.BRAND + "\nBuild.DEVICE: " + Build.DEVICE + "\nBuild.MODEL: " + Build.MODEL + "\nBuild.HARDWARE: " + Build.HARDWARE + "\nBuild.FINGERPRINT: " + Build.FINGERPRINT;
    }

    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    }

    public static void rateapp(Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + activity.getPackageName()));
        intent.addFlags(1208483840);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + activity.getPackageName())));
        }
    }

    public static String getVersionName(Activity activity) {
        try {
            PackageInfo packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
            if (!"https://appapi.videocrypt.in/".equalsIgnoreCase("https://appapi.videocrypt.in/")) {
                if ("https://appapi.videocrypt.in/".equalsIgnoreCase("https://preprod.videocrypt.in/")) {
                    return packageInfo.versionName + " - Preprod";
                }
                return packageInfo.versionName + " - Staging";
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int getVersionCode(Activity activity) {
        try {
            return activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static ArrayList<String> gettitleList(Activity activity) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!"1".equalsIgnoreCase("1")) {
            if (!"1".equalsIgnoreCase("2")) {
                if (!"1".equalsIgnoreCase("3")) {
                    if ("1".equalsIgnoreCase("4")) {
                        arrayList.add(activity.getString(com.eduteria.app.app.R.string.specialities));
                        arrayList.add(activity.getString(com.eduteria.app.app.R.string.course));
                        arrayList.add(activity.getString(com.eduteria.app.app.R.string.video));
                        arrayList.add(activity.getString(com.eduteria.app.app.R.string.savedNotes));
                        arrayList.add(activity.getString(com.eduteria.app.app.R.string.rewardpoints));
                        arrayList.add(activity.getString(com.eduteria.app.app.R.string.feedback));
                        arrayList.add(activity.getString(com.eduteria.app.app.R.string.appSettings));
                        arrayList.add(activity.getString(com.eduteria.app.app.R.string.logout));
                    }
                    return arrayList;
                }
                arrayList.add(activity.getString(com.eduteria.app.app.R.string.specialities));
                arrayList.add(activity.getString(com.eduteria.app.app.R.string.course));
                arrayList.add(activity.getString(com.eduteria.app.app.R.string.video));
                arrayList.add(activity.getString(com.eduteria.app.app.R.string.savedNotes));
                arrayList.add(activity.getString(com.eduteria.app.app.R.string.rewardpoints));
                arrayList.add(activity.getString(com.eduteria.app.app.R.string.feedback));
                arrayList.add(activity.getString(com.eduteria.app.app.R.string.appSettings));
                arrayList.add(activity.getString(com.eduteria.app.app.R.string.logout));
                return arrayList;
            }
            arrayList.add(activity.getString(com.eduteria.app.app.R.string.video));
            arrayList.add(activity.getString(com.eduteria.app.app.R.string.savedNotes));
            arrayList.add(activity.getString(com.eduteria.app.app.R.string.rewardpoints));
            arrayList.add(activity.getString(com.eduteria.app.app.R.string.feedback));
            arrayList.add(activity.getString(com.eduteria.app.app.R.string.appSettings));
            arrayList.add(activity.getString(com.eduteria.app.app.R.string.logout));
            return arrayList;
        }
        arrayList.add(activity.getString(com.eduteria.app.app.R.string.specialities));
        arrayList.add(activity.getString(com.eduteria.app.app.R.string.course));
        arrayList.add(activity.getString(com.eduteria.app.app.R.string.video));
        arrayList.add(activity.getString(com.eduteria.app.app.R.string.savedNotes));
        arrayList.add(activity.getString(com.eduteria.app.app.R.string.rewardpoints));
        arrayList.add(activity.getString(com.eduteria.app.app.R.string.feedback));
        arrayList.add(activity.getString(com.eduteria.app.app.R.string.appSettings));
        arrayList.add(activity.getString(com.eduteria.app.app.R.string.logout));
        return arrayList;
    }

    public static Bitmap decodeSampledBitmap(String url, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(url, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(url, options);
    }

    public static byte[] FileToByteArray(String file) {
        File file2 = new File(file);
        int length = (int) file2.length();
        byte[] bArr = new byte[length];
        try {
            new FileInputStream(file2).read(bArr);
            for (int i2 = 0; i2 < length; i2++) {
                System.out.print((char) bArr[i2]);
            }
        } catch (FileNotFoundException e2) {
            System.out.println("File Not Found.");
            e2.printStackTrace();
        } catch (IOException e3) {
            System.out.println("Error Reading The File.");
            e3.printStackTrace();
        }
        return bArr;
    }

    public static void DownloadfilefromURL(final Activity activity, final PostFile postFile) {
        progressBar = new ProgressDialog(new ContextThemeWrapper(activity, R.style.Theme.Holo.Light.Dialog));
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + Environment.DIRECTORY_DOWNLOADS + MqttTopic.TOPIC_LEVEL_SEPARATOR + activity.getResources().getString(com.eduteria.app.app.R.string.download_file_directory_name));
            if (!file.exists()) {
                file.mkdirs();
            }
            final File file2 = new File(file.getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + postFile.getFile_info());
            if (!file2.exists()) {
                final DownloadManager downloadManager = (DownloadManager) activity.getSystemService("download");
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(postFile.getLink()));
                request.setAllowedNetworkTypes(3).setNotificationVisibility(1).setTitle(activity.getResources().getString(com.eduteria.app.app.R.string.app_name)).setAllowedOverRoaming(true);
                File file3 = new File(Environment.getExternalStorageDirectory().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + Environment.DIRECTORY_DOWNLOADS + MqttTopic.TOPIC_LEVEL_SEPARATOR + activity.getResources().getString(com.eduteria.app.app.R.string.download_file_directory_name));
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                request.setDestinationUri(Uri.fromFile(file2));
                request.allowScanningByMediaScanner();
                final Long lValueOf = Long.valueOf(downloadManager.enqueue(request));
                ProgressDialog progressDialog = new ProgressDialog(new ContextThemeWrapper(activity, R.style.Theme.Holo.Light.Dialog));
                progressBar = progressDialog;
                progressDialog.setCancelable(false);
                progressBar.setMessage("Downloading...");
                progressBar.setProgressStyle(1);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.setIndeterminate(false);
                progressBar.setProgressDrawable(activity.getResources().getDrawable(com.eduteria.app.app.R.drawable.progress_bar_download));
                progressBar.setButton(-2, "Cancel", new DialogInterface.OnClickListener() { // from class: com.appnew.android.Utils.Helper.10
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog2, int which) {
                        Long l;
                        DownloadManager downloadManager2 = downloadManager;
                        if (downloadManager2 != null && (l = lValueOf) != null) {
                            downloadManager2.remove(l.longValue());
                        }
                        try {
                            dialog2.dismiss();
                        } catch (Exception unused) {
                        }
                    }
                });
                try {
                    progressBar.show();
                } catch (Exception unused) {
                }
                final boolean z = true;
                new Thread(new Runnable() { // from class: com.appnew.android.Utils.Helper.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity activity2;
                        Runnable runnable;
                        try {
                            try {
                                try {
                                    DownloadManager downloadManager2 = (DownloadManager) activity.getSystemService("download");
                                    boolean z2 = true;
                                    while (z2) {
                                        DownloadManager.Query query = new DownloadManager.Query();
                                        query.setFilterById(lValueOf.longValue());
                                        Cursor cursorQuery = downloadManager2.query(query);
                                        cursorQuery.moveToFirst();
                                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("bytes_so_far"));
                                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("total_size"));
                                        if (cursorQuery.getInt(cursorQuery.getColumnIndex("status")) == 8) {
                                            z2 = false;
                                        }
                                        final int i4 = (int) ((((long) i2) * 100) / ((long) i3));
                                        activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Utils.Helper.11.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                Helper.progressBar.setProgress(i4);
                                            }
                                        });
                                        cursorQuery.close();
                                    }
                                    activity2 = activity;
                                    runnable = new Runnable() { // from class: com.appnew.android.Utils.Helper.11.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                if (Helper.progressBar != null && Helper.progressBar.isShowing()) {
                                                    Helper.progressBar.dismiss();
                                                }
                                            } catch (Exception unused2) {
                                            }
                                            try {
                                                Helper.showFiles(file2, activity, postFile.getFile_type().equals(Const.PDF) ? postFile.getFile_type() : Const.DOC, z);
                                            } catch (Exception e2) {
                                                Log.d("showFiles", "showFiles: " + e2.getMessage());
                                            }
                                        }
                                    };
                                } catch (Throwable unused2) {
                                    if (Helper.progressBar != null && Helper.progressBar.isShowing()) {
                                        Helper.progressBar.dismiss();
                                    }
                                    activity2 = activity;
                                    runnable = new Runnable() { // from class: com.appnew.android.Utils.Helper.11.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                if (Helper.progressBar != null && Helper.progressBar.isShowing()) {
                                                    Helper.progressBar.dismiss();
                                                }
                                            } catch (Exception unused22) {
                                            }
                                            try {
                                                Helper.showFiles(file2, activity, postFile.getFile_type().equals(Const.PDF) ? postFile.getFile_type() : Const.DOC, z);
                                            } catch (Exception e2) {
                                                Log.d("showFiles", "showFiles: " + e2.getMessage());
                                            }
                                        }
                                    };
                                    activity2.runOnUiThread(runnable);
                                }
                            } catch (Exception unused3) {
                                activity2 = activity;
                                runnable = new Runnable() { // from class: com.appnew.android.Utils.Helper.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (Helper.progressBar != null && Helper.progressBar.isShowing()) {
                                                Helper.progressBar.dismiss();
                                            }
                                        } catch (Exception unused22) {
                                        }
                                        try {
                                            Helper.showFiles(file2, activity, postFile.getFile_type().equals(Const.PDF) ? postFile.getFile_type() : Const.DOC, z);
                                        } catch (Exception e2) {
                                            Log.d("showFiles", "showFiles: " + e2.getMessage());
                                        }
                                    }
                                };
                                activity2.runOnUiThread(runnable);
                            } catch (Throwable th) {
                                activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Utils.Helper.11.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (Helper.progressBar != null && Helper.progressBar.isShowing()) {
                                                Helper.progressBar.dismiss();
                                            }
                                        } catch (Exception unused22) {
                                        }
                                        try {
                                            Helper.showFiles(file2, activity, postFile.getFile_type().equals(Const.PDF) ? postFile.getFile_type() : Const.DOC, z);
                                        } catch (Exception e2) {
                                            Log.d("showFiles", "showFiles: " + e2.getMessage());
                                        }
                                    }
                                });
                                throw th;
                            }
                            activity2.runOnUiThread(runnable);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            try {
                                if (Helper.progressBar == null || !Helper.progressBar.isShowing()) {
                                    return;
                                }
                                Helper.progressBar.dismiss();
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }).start();
                return;
            }
            try {
                showFiles(file2, activity, postFile.getFile_type().equals(Const.PDF) ? postFile.getFile_type() : Const.DOC, false);
            } catch (Exception unused2) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int getStatus(Context context, long downloadId) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(downloadId);
        Cursor cursorQuery = downloadManager.query(query);
        if (!cursorQuery.moveToFirst()) {
            return -1;
        }
        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
        cursorQuery.close();
        return i2;
    }

    public static void getimage(Context ctx) {
        try {
            FileInputStream fileInputStreamOpenFileInput = ctx.openFileInput("sample-ppt");
            fileInputStreamOpenFileInput.read();
            fileInputStreamOpenFileInput.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static void sendLink(Activity activity, String subject, String msg, String msgHtml) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", msg);
        intent.putExtra("android.intent.extra.SUBJECT", subject);
        intent.putExtra(IntentCompat.EXTRA_HTML_TEXT, msgHtml);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent);
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        int i4 = 1;
        if (i2 <= reqHeight && i3 <= reqWidth) {
            return 1;
        }
        int i5 = i2 / 2;
        int i6 = i3 / 2;
        while (i5 / i4 >= reqHeight && i6 / i4 >= reqWidth) {
            i4 *= 2;
        }
        return i4;
    }

    public static boolean DataNotValid(Context context, EditText view) {
        view.setError(context.getResources().getString(com.eduteria.app.app.R.string.thisfieldrequired));
        view.requestFocus();
        return false;
    }

    public static boolean DataNotValid(EditText view, int type, Context context) {
        if (type == 1) {
            view.setError(context.getString(com.eduteria.app.app.R.string.this_email_id_is_invalid));
        } else if (type == 2) {
            view.setError(context.getString(com.eduteria.app.app.R.string.this_number_is_invalid));
        } else if (type == 3) {
            view.setError(context.getString(com.eduteria.app.app.R.string.password_must_contain_at_least_8_characters));
        } else if (type == 4) {
            view.setError(context.getString(com.eduteria.app.app.R.string.confirm_password_did_not_match));
        } else if (type == 5) {
            view.setError(context.getString(com.eduteria.app.app.R.string.pincode_must_contain_6_characters));
        } else if (type == 6) {
            view.setError(context.getString(com.eduteria.app.app.R.string.this_field_is_required));
        }
        view.requestFocus();
        return false;
    }

    public static String GetText(EditText text) {
        return text.getText().toString().trim();
    }

    public static boolean isConnected(Context ctx) {
        NetworkInfo activeNetworkInfo;
        return ctx != null && (activeNetworkInfo = ((ConnectivityManager) ctx.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public static void getCourseMaintanaceDialog(final Activity ctx, String title, String msg) {
        DialogUtils.makeSingleButtonDialog(ctx, title, msg, ctx.getResources().getString(com.eduteria.app.app.R.string.ok), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.12
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
            }
        });
    }

    public static void getMaintanaceDialog(final Activity ctx, String breakFrom, String breakTo) {
        if (TextUtils.isEmpty(breakFrom) || TextUtils.isEmpty(breakTo)) {
            return;
        }
        long j = Long.parseLong(breakFrom);
        long j2 = Long.parseLong(breakTo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
        Date date = new Date(j);
        Date date2 = new Date(j2);
        Date time = Calendar.getInstance().getTime();
        String str = simpleDateFormat.format(time);
        if ((time.after(date) && time.before(date2)) || str.equals(simpleDateFormat.format(date)) || str.equals(simpleDateFormat.format(date2))) {
            DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(com.eduteria.app.app.R.string.maintain_app_dialog_title), ctx.getString(com.eduteria.app.app.R.string.maintain_app_dialog_message), ctx.getResources().getString(com.eduteria.app.app.R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.13
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public void onOKClick() {
                    ctx.finish();
                }
            });
        }
    }

    public static boolean isEMIPayImmediate(final Activity ctx, String validTo) {
        if (TextUtils.isEmpty(validTo)) {
            return false;
        }
        long j = Long.parseLong(validTo) * 1000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
        Date date = new Date(j);
        simpleDateFormat.format(date);
        Date time = Calendar.getInstance().getTime();
        simpleDateFormat.format(time);
        return date.before(time);
    }

    public static void getVersionUpdateDialog(final Activity ctx, String androidType) {
        boolean z;
        if (androidType.equalsIgnoreCase("0")) {
            isvisible = "1";
            z = false;
        } else {
            z = true;
        }
        final boolean z2 = z;
        DialogUtils.makeDialog(ctx, ctx.getString(com.eduteria.app.app.R.string.update_app_dialog_title), ctx.getString(com.eduteria.app.app.R.string.update_app_dialog_message), ctx.getResources().getString(com.eduteria.app.app.R.string.update), ctx.getResources().getString(com.eduteria.app.app.R.string.cancel), z2, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.14
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                Helper.rateapp(ctx);
                ctx.finish();
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Utils.Helper.15
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public void onCancelClick() {
                if (z2) {
                    Intent intent = new Intent(ctx, (Class<?>) SplashScreen.class);
                    intent.putExtra("EXIT", true);
                    intent.addFlags(67108864);
                    intent.addFlags(268435456);
                    intent.addFlags(32768);
                    ctx.startActivity(intent);
                    ctx.finish();
                }
            }
        });
    }

    public static void GoToOtpVerificationActivity(Activity activity, String otp, int type, String FragType, boolean resetPass, boolean isChangePass, boolean isphone, Drawable flag, String c_code) {
        Intent intent = new Intent(activity, setLoginCatActivity());
        intent.putExtra(Const.OTP, otp);
        intent.putExtra("type", String.valueOf(type));
        intent.putExtra(Const.RESET_PASS, resetPass);
        intent.putExtra(Const.IS_CHANGE_PASS, isChangePass);
        intent.putExtra("isphone", isphone);
        intent.putExtra(Const.FRAG_TYPE, FragType);
        intent.putExtra(Const.C_FLAG, convertDrawableToByteArray(flag));
        intent.putExtra("c_code", c_code);
        gotoActivity(intent, activity);
    }

    public static void GoToOtpVerificationActivity(Activity activity, String otp, int type, String FragType, String LoginWithOtp, boolean isphone, Drawable flag, String c_code) {
        Intent intent = new Intent(activity, setLoginCatActivity());
        intent.putExtra(Const.OTP, otp);
        intent.putExtra("type", String.valueOf(type));
        intent.putExtra(Const.LoginWithOtp, LoginWithOtp);
        intent.putExtra("isphone", isphone);
        intent.putExtra(Const.FRAG_TYPE, FragType);
        intent.putExtra(Const.C_FLAG, convertDrawableToByteArray(flag));
        intent.putExtra("c_code", c_code);
        gotoActivity(intent, activity);
    }

    public static void GoToRegistrationActivity(Activity activity, String FragType, String otp, boolean isChangePass, String socialType, String isSocial, byte[] flag, String c_code, String c_name, String c_name_code) {
        Intent intent = new Intent(activity, setLoginCatActivity());
        intent.putExtra(Const.OTP, otp);
        intent.putExtra(Const.FRAG_TYPE, FragType);
        intent.putExtra(Const.IS_CHANGE_PASS, isChangePass);
        intent.putExtra(Const.SOCIAL_TYPE, socialType);
        intent.putExtra(Const.IS_SOCIAL, isSocial);
        intent.putExtra(Const.C_FLAG, flag);
        intent.putExtra("c_code", c_code);
        intent.putExtra(Const.C_NAME, c_name);
        intent.putExtra(Const.C_NAME_CODE, c_name_code);
        gotoActivity(intent, activity);
    }

    public static void GoToRegistrationActivity(Activity activity, String FragType, String otp, boolean isChangePass, String socialType, String isSocial, byte[] flag, String c_code, String c_name, String c_name_code, boolean isUpdate) {
        Intent intent = new Intent(activity, setLoginCatActivity());
        intent.putExtra(Const.OTP, otp);
        intent.putExtra(Const.FRAG_TYPE, FragType);
        intent.putExtra(Const.IS_CHANGE_PASS, isChangePass);
        intent.putExtra(Const.SOCIAL_TYPE, socialType);
        intent.putExtra(Const.IS_SOCIAL, isSocial);
        intent.putExtra(Const.C_FLAG, flag);
        intent.putExtra("c_code", c_code);
        intent.putExtra(Const.C_NAME, c_name);
        intent.putExtra(Const.C_NAME_CODE, c_name_code);
        intent.putExtra("isUpdate", isUpdate);
        gotoActivity(intent, activity);
    }

    public static void GoToRegistrationActivity(Activity activity, String FragType, String otp, boolean isChangePass, String socialType, String isSocial, byte[] flag, String c_code, String c_name, String c_name_code, boolean isUpdate, boolean isPhone) {
        Intent intent = new Intent(activity, setLoginCatActivity());
        intent.putExtra(Const.OTP, otp);
        intent.putExtra(Const.FRAG_TYPE, FragType);
        intent.putExtra(Const.IS_CHANGE_PASS, isChangePass);
        intent.putExtra(Const.SOCIAL_TYPE, socialType);
        intent.putExtra(Const.IS_SOCIAL, isSocial);
        intent.putExtra(Const.C_FLAG, flag);
        intent.putExtra("c_code", c_code);
        intent.putExtra(Const.C_NAME, c_name);
        intent.putExtra(Const.C_NAME_CODE, c_name_code);
        intent.putExtra("isUpdate", isUpdate);
        intent.putExtra("isphone", isPhone);
        gotoActivity(intent, activity);
    }

    public static void GoToOtpVerificationActivity1(Activity activity, String otp, int type, String FragType, boolean resetPass, String socialType, String isSocial, boolean isPhone) {
        Intent intent = new Intent(activity, setLoginCatActivity());
        intent.putExtra(Const.OTP, otp);
        intent.putExtra("type", String.valueOf(type));
        intent.putExtra(Const.RESET_PASS, resetPass);
        intent.putExtra(Const.FRAG_TYPE, FragType);
        intent.putExtra(Const.SOCIAL_TYPE, socialType);
        intent.putExtra(Const.IS_SOCIAL, isSocial);
        intent.putExtra("isphone", isPhone);
        gotoActivity(intent, activity);
    }

    public static void GoToOtpVerificationActivity2(Activity activity, String otp, int type, String FragType, boolean resetPass, String socialType, String isSocial, String c_code, Drawable flag, String c_name, String c_nameCode, boolean isPhone) {
        Intent intent = new Intent(activity, setLoginCatActivity());
        intent.putExtra(Const.OTP, otp);
        intent.putExtra("type", String.valueOf(type));
        intent.putExtra(Const.RESET_PASS, resetPass);
        intent.putExtra(Const.FRAG_TYPE, FragType);
        intent.putExtra(Const.SOCIAL_TYPE, socialType);
        intent.putExtra(Const.IS_SOCIAL, isSocial);
        intent.putExtra(Const.C_FLAG, convertDrawableToByteArray(flag));
        intent.putExtra("c_code", c_code);
        intent.putExtra(Const.C_NAME, c_name);
        intent.putExtra(Const.C_NAME_CODE, c_nameCode);
        intent.putExtra("isphone", isPhone);
        gotoActivity(intent, activity);
    }

    public static byte[] convertDrawableToByteArray(Drawable d2) {
        try {
            Bitmap bitmap = ((BitmapDrawable) d2).getBitmap();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap getBitmapToByteArr(byte[] bytearr) {
        return BitmapFactory.decodeByteArray(bytearr, 0, bytearr.length);
    }

    public static void ShowKeyboard(Context ctx) {
        ((InputMethodManager) ctx.getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public static void HideKeyboard(Activity ctx) {
        InputMethodManager inputMethodManager = (InputMethodManager) ctx.getSystemService("input_method");
        View currentFocus = ctx.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(ctx);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }

    public static void closeHideKeyboard(Activity cnx) {
        InputMethodManager inputMethodManager = (InputMethodManager) cnx.getSystemService("input_method");
        try {
            if (cnx.getCurrentFocus() != null) {
                if (inputMethodManager.isAcceptingText() || inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(cnx.getCurrentFocus().getWindowToken(), 0);
                }
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void GoToChangePasswordActivity(Activity activity, String otp, String FragType, boolean resetPass, boolean isChangePass, boolean isphone) {
        Intent intent = new Intent(activity, setLoginCatActivity());
        intent.putExtra(Const.OTP, otp);
        intent.putExtra(Const.RESET_PASS, resetPass);
        intent.putExtra(Const.FRAG_TYPE, FragType);
        intent.putExtra(Const.IS_CHANGE_PASS, isChangePass);
        intent.putExtra("isphone", isphone);
        gotoActivity(intent, activity);
    }

    public static void GuestSignOutUser(final Context context) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appnew.android.Utils.Helper.16
            @Override // java.lang.Runnable
            public void run() {
                Helper.ClearUserData(context);
                Shortsuts.INSTANCE.updateShortcuts(context);
                Intent intent = new Intent(context, Helper.setSignInActivity());
                intent.putExtra("type", Const.SIGNIN);
                intent.putExtra(Const.OPEN_WITH, Const.GUEST_OPEN);
                intent.putExtra(Const.SOCIAL_TYPE, "1");
                intent.setFlags(268468224);
                context.startActivity(intent);
                ((Activity) context).finish();
            }
        });
    }

    public static void SignOutUser(final Context context) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appnew.android.Utils.Helper.17
            @Override // java.lang.Runnable
            public void run() {
                Helper.isvisible = "0";
                Helper.ClearUserData(context);
                Shortsuts.INSTANCE.updateShortcuts(context);
                Intent intent = new Intent(context, Helper.setSignInActivity());
                intent.putExtra("type", Const.SIGNIN);
                intent.putExtra(Const.OPEN_WITH, Const.GUEST_OPEN);
                intent.putExtra(Const.SOCIAL_TYPE, "1");
                intent.setFlags(268468224);
                if (Helper.mGoogleSignInClient != null) {
                    Helper.mGoogleSignInClient.signOut();
                }
                context.startActivity(intent);
                ((Activity) context).finish();
            }
        });
    }

    public static void ClearUserData(Context context) {
        SharedPreference.getInstance().putString(Const.GET_DIVISION, "0");
        SharedPreference.getInstance().putString(Const.GET_SUB_DIVISION, "0");
        SharedPreference.getInstance().putInt(Const.LANGUAGE, 1);
        SharedPreference.getInstance().putString(Const.APP_LANGUAGE, Const.ENGLISH);
        CustomContextWrapper.wrap(context, Const.ENGLISH);
        changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE), context);
        SharedPreference sharedPreference = SharedPreference.getInstance();
        sharedPreference.ClearLoggedInUser();
        sharedPreference.ClearUserCoupon();
        sharedPreference.remove(Const.MASTER_FEED_HIT_RESPONSE);
        sharedPreference.remove(Const.MASTER_REGISTRATION_HIT_RESPONSE);
        sharedPreference.remove(Const.FEED_PREFERENCE);
        sharedPreference.remove(Const.JWT);
        sharedPreference.remove(Const.IS_COUPON_AVAILABLE);
        sharedPreference.remove(Const.SERVER_TIME);
        sharedPreference.remove("key");
        sharedPreference.remove(Const.FIREBASE_TOKEN_ID);
        sharedPreference.putString("key", "");
        sharedPreference.remove(Const.MODERATOR_SELECTED_STREAM);
        sharedPreference.putBoolean(Const.IS_USER_LOGGED_IN, false);
        sharedPreference.putBoolean(Const.IS_USER_REGISTRATION_DONE, false);
        sharedPreference.putBoolean(Const.IS_NOTIFICATION_BLOCKED, false);
        DbAdapter.getInstance(context).deleteAll(DbAdapter.TABLE_NAME_COLORCODE);
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(context);
        appDatabase.getTestDao().deletedata();
        appDatabase.getFolderDetails().deleteData();
        appDatabase.gethtmllink().deletedata();
        SharedPreference.getInstance().putString("catName", null);
        SharedPreference.getInstance().putString("sub_cat_id", null);
        SharedPreference.getInstance().putString("sub_cat_ids", null);
        SharedPreference.getInstance().putString("cd_time_installment", null);
        SharedPreference.getInstance().putString("theme_color_hai_bhai", null);
        SharedPreference.getInstance().putInt("UserScreenTime", 0);
        if (AudioPlayerService.player != null) {
            if (AudioPlayerService.type.equalsIgnoreCase(Const.YOUTUBE)) {
                appDatabase.getyoutubedata().updateTime(Long.valueOf(AudioPlayerService.player.getCurrentPosition()), AudioPlayerService.videoid, MakeMyExam.userId, "1");
            } else {
                appDatabase.getaudiodao().update_audio_currentpos(AudioPlayerService.videoid, MakeMyExam.userId, Long.valueOf(AudioPlayerService.player.getCurrentPosition()));
            }
            if (AudioPlayerService.player != null) {
                AudioPlayerService.player.release();
                AudioPlayerService.player = null;
            }
        }
        if (AudioPlayerService.isAudioPlaying) {
            Intent intent = new Intent(context, (Class<?>) AudioPlayerService.class);
            intent.setAction("Stop_Service");
            Util.startForegroundService(context, intent);
            AudioPlayerService.video_currentpos = 0L;
        }
        if (VideoDownloadService.isServiceRunning) {
            try {
                VideoDownloadService.action = VideoDownloadService.CANCEL;
                appDatabase.getvideoDownloadao().delete_viavideoid(VideoDownloadService.video_id, MakeMyExam.userId);
                MakeMyExam.userId = "0";
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void clearappdata(Context context) {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(context);
        appDatabase.getMasterAllCatDao().deletedata();
        appDatabase.getMastercatDao().deletedata();
        appDatabase.getcoursetypemaster().deletedata();
        appDatabase.getaudiodao().deletedata();
        appDatabase.getMyCourseDao().deletedata();
        appDatabase.getuserhistorydao().deletedata();
        appDatabase.getvideoDao().deletedata();
        appDatabase.getyoutubedata().deletedata();
        appDatabase.getLaunguages().deletedata();
        appDatabase.getCoursedata().deletedata();
        appDatabase.getCourseDetaildata().deletedata();
        appDatabase.getHomeApiStatusdata().deletedata();
        appDatabase.getpigibag().deletedata();
        appDatabase.getapidao().deletedata();
        appDatabase.getuserwisecourse().deletedata();
        appDatabase.getthemeSettingdao().deletedata();
        appDatabase.getBannerTableDao().deleteBanners();
        appDatabase.getTopperReviewDao().deleteTopperReview();
        appDatabase.getFeedDao().deletedata();
        appDatabase.getDueEmi().deleteAllDueEmi();
        UtkashRoom.destroyInstance();
    }

    public static void closeKeyboard(Activity cnx) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) cnx.getSystemService("input_method");
            if (inputMethodManager.isAcceptingText() || inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(cnx.getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
    }

    public static void setMargins(View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }

    public static void gotoActivityWithBundle(Activity context, Class<?> className, Bundle bundle) {
        Intent intent = new Intent(context, className);
        intent.putExtras(bundle);
        context.startActivity(intent);
        if (!"1".equalsIgnoreCase("7")) {
            context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
        } else {
            context.overridePendingTransition(0, 0);
        }
    }

    public static void gotoActivity(Activity context, Class<?> className, String type) {
        Intent intent = new Intent(context, className);
        intent.putExtra(Const.FRAG_TYPE, Const.CREATE_TEST_FRAG_ONE);
        context.startActivity(intent);
        if (!"1".equalsIgnoreCase("7")) {
            context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
        } else {
            context.overridePendingTransition(0, 0);
        }
    }

    public static void gotoActivityTheme7(Activity context, Class<?> className, String type) {
        Intent intent = new Intent(context, className);
        intent.putExtra(Const.FRAG_TYPE, Const.CREATE_TEST_FRAG_ONE);
        context.startActivity(intent);
        if (!"1".equalsIgnoreCase("7")) {
            context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
        } else {
            context.overridePendingTransition(0, 0);
        }
    }

    public static void gotoActivity(Intent intent, Activity context) {
        context.startActivity(intent);
        context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
    }

    public static void gotoActivityTheme7(Intent intent, Activity context) {
        context.startActivity(intent);
        if (!"1".equalsIgnoreCase("7")) {
            context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
        } else {
            context.overridePendingTransition(0, 0);
        }
    }

    public static void gotoActivityForResult(Intent intent, Activity context, int requestCode) {
        context.startActivityForResult(intent, requestCode);
        if (!"1".equalsIgnoreCase("7")) {
            context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
        } else {
            context.overridePendingTransition(0, 0);
        }
    }

    public static void gotoActivity_finish(Intent intent, Activity context) {
        context.startActivity(intent);
        if (!"1".equalsIgnoreCase("7")) {
            context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
        } else {
            context.overridePendingTransition(0, 0);
        }
        context.finish();
    }

    public static void gotoActivity_finish_1(Intent intent, Activity context) {
        context.finish();
        context.startActivity(intent);
        if (!"1".equalsIgnoreCase("7")) {
            context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
        } else {
            context.overridePendingTransition(0, 0);
        }
    }

    public static void gotoActivity(Activity context, Class<?> className) {
        context.startActivity(new Intent(context, className));
        context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
    }

    public static void gotoActivityTheme7(Activity context, Class<?> className) {
        context.startActivity(new Intent(context, className));
        if (!"1".equalsIgnoreCase("7")) {
            context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
        } else {
            context.overridePendingTransition(0, 0);
        }
    }

    public static String getHtmlUpdatedDatas(String value) {
        if (!TextUtils.isEmpty(value)) {
            return Base64.encodeToString(value.trim().getBytes(), 0);
        }
        return "";
    }

    public static void showWebDatas(Activity activity, String data, WebView webView) {
        webView.loadData(data, "text/html; charset=UTF-8", AbstractHttpOverXmpp.Base64.ELEMENT);
    }

    public static void showWebData(Activity activity, String data, final WebView webView) {
        final String strValueOf = String.valueOf(Html.fromHtml(Html.fromHtml(data).toString()));
        activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Utils.Helper.18
            @Override // java.lang.Runnable
            public void run() {
                webView.loadData(strValueOf, Mimetypes.MIMETYPE_HTML, "UTF-8");
            }
        });
    }

    public static void showToast(Context activity, String msg, int visibility) {
        if (visibility == 1) {
            Toast.makeText(activity, msg, 0).show();
        } else {
            Toast.makeText(activity, msg, 1).show();
        }
    }

    public static void showInternetToast(Context activity) {
        if ((activity instanceof DownloadVideoPlayer) || (activity instanceof DownloadActivity)) {
            return;
        }
        Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.internet_error_message), 0).show();
    }

    public static SpannableString typeface(Typeface typeface, CharSequence string) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new TypefaceSpan(String.valueOf(typeface)), 0, spannableString.length(), 33);
        return spannableString;
    }

    public static int count(String s, char c2) {
        int i2 = 0;
        for (int i3 = 0; i3 < s.length(); i3++) {
            if (s.charAt(i3) == c2) {
                i2++;
            }
        }
        return i2;
    }

    public static void GoToLiveVideoActivity(String chatnode, Activity activity, String Url, String islive, String vid, String title, String is_audio, String thubnail, String islocked, String courseid, String pos, String parentid, String tileid, String tiletype, String is_ved_live, ArrayList<Video> videoArrayList) {
        Intent intent = new Intent(activity, (Class<?>) LiveStreamingYoutube.class);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("islocked", islocked);
        intent.putExtra("courseid", courseid);
        intent.putExtra(Constants.INAPP_POSITION, pos);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("is_ved_live", is_ved_live);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static void GoToLiveVideoActivity(String chatnode, Activity activity, String Url, String islive, String vid, String title, String is_audio, String thubnail, String islocked, String courseid, String pos, String parentid, String tileid, String tiletype, ArrayList<Video> videoArrayList) {
        Intent intent = new Intent(activity, (Class<?>) LiveStreamingYoutube.class);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("islocked", islocked);
        intent.putExtra("courseid", courseid);
        intent.putExtra(Constants.INAPP_POSITION, pos);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static void GoToLiveVideoActivity(String chatnode, Activity activity, String Url, String islive, String vid, String title, String is_audio, String thubnail, String islocked, String courseid, String pos, String parentid, String tileid, String tiletype, String bookmark, String is_ved_live, ArrayList<Video> videoArrayList) {
        Intent intent = new Intent(activity, (Class<?>) LiveStreamingYoutube.class);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("islocked", islocked);
        intent.putExtra("courseid", courseid);
        intent.putExtra(Constants.INAPP_POSITION, pos);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("bookmark", bookmark);
        intent.putExtra("is_ved_live", is_ved_live);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static void changeLang(String lang, Context ctx) {
        if (lang.equalsIgnoreCase("")) {
            return;
        }
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration(ctx.getResources().getConfiguration());
        configuration.setLocale(locale);
        ctx.createConfigurationContext(configuration);
        SharedPreference.getInstance().putString(Const.APP_LANGUAGE, lang);
        if (lang.equals(Const.ENGLISH)) {
            SharedPreference.getInstance().putInt(Const.LANGUAGE, 1);
        } else {
            SharedPreference.getInstance().putInt(Const.LANGUAGE, 2);
        }
    }

    public static String getAppUrl(Context ctx) {
        return "https://play.google.com/store/apps/details?id=" + ctx.getPackageName();
    }

    public static void aDialogOnPermissionDenied(final Activity mContext) {
        DialogUtils.makeSingleButtonDialog(mContext, mContext.getResources().getString(com.eduteria.app.app.R.string.alert), mContext.getResources().getString(com.eduteria.app.app.R.string.reGrantPermissionMsg), mContext.getResources().getString(R.string.yes), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.19
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts(AnalyticsConstants.PACKAGE, mContext.getPackageName(), null));
                intent.addFlags(268468224);
                mContext.startActivity(intent);
            }
        });
    }

    public static void showFiles(File filepath, Activity activity, String type, boolean finalFlag) {
        if (activity != null) {
            type.hashCode();
            if (type.equals(Const.DOC)) {
                MimeTypeMap singleton = MimeTypeMap.getSingleton();
                Intent intent = new Intent("android.intent.action.VIEW");
                String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(filepath.getName().substring(filepath.getName().lastIndexOf(InstructionFileId.DOT) + 1));
                intent.setFlags(268435456);
                intent.setFlags(1);
                intent.setDataAndType(UtkarshFileProvider.getUriForFile(activity, "com.eduteria.app.app.provider", filepath), mimeTypeFromExtension);
                try {
                    activity.startActivity(intent);
                    return;
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.unable_to_open_the_file_no_application_available), 1).show();
                    return;
                }
            }
            if (type.equals(Const.PDF)) {
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW");
                intent2.addFlags(1);
                intent2.setDataAndType(UtkarshFileProvider.getUriForFile(activity, "com.eduteria.app.app.provider", filepath), "application/pdf");
                try {
                    gotoActivity(intent2, activity);
                } catch (ActivityNotFoundException unused2) {
                    Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.unable_to_open_the_file_no_application_available), 0).show();
                }
            }
        }
    }

    public static Cipher getCipher(String token) throws GeneralSecurityException {
        String strGenerateLibVectorAPI = AES.generateLibVectorAPI(token);
        byte[] bytes = AES.generateLibkeyAPI(token).getBytes();
        byte[] bytes2 = strGenerateLibVectorAPI.getBytes();
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(2, new SecretKeySpec(bytes, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM), new IvParameterSpec(bytes2));
        return cipher;
    }

    public static String formatSeconds(int timeInSeconds) {
        int i2 = timeInSeconds / 3600;
        int i3 = timeInSeconds - (i2 * 3600);
        int i4 = i3 / 60;
        int i5 = i3 - (i4 * 60);
        String str = (i2 < 10 ? "0" : "") + i2 + ":";
        if (i4 < 10) {
            str = str + "0";
        }
        String str2 = str + i4 + ":";
        if (i5 < 10) {
            str2 = str2 + "0";
        }
        return str2 + i5;
    }

    public static int getValueInDP(Context context, int value) {
        return (int) TypedValue.applyDimension(1, value, context.getResources().getDisplayMetrics());
    }

    public static void GoToJWVideo_Params(Activity activity, String Url, String video_id, String title, Long current_pos, String course_id) {
        Intent intent = new Intent(activity, (Class<?>) JWVideoPlayer.class);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra(Const.VIDEO_ID, video_id);
        intent.putExtra("current_pos", current_pos);
        intent.putExtra("title", title);
        intent.putExtra("course_id", course_id);
        gotoActivity(intent, activity);
    }

    public static void GoToJWVideo_Params_newarray(Activity activity, String Url, String video_id, String title, Long current_pos, String course_id, String tileid, String tile_type, ArrayList<UrlObject> bitrate_urls) {
        Intent intent = new Intent(activity, (Class<?>) JWVideoPlayer.class);
        if (bitrate_urls == null || bitrate_urls.size() <= 0) {
            intent.putExtra("url_object", "");
        } else {
            intent.putExtra("url_object", new Gson().toJson(bitrate_urls));
        }
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra(Const.VIDEO_ID, video_id);
        intent.putExtra("current_pos", current_pos);
        intent.putExtra("title", title);
        intent.putExtra("course_id", course_id);
        intent.putExtra("tile_id", tileid);
        intent.putExtra(Const.TILE_TYPE, tile_type);
        gotoActivity(intent, activity);
    }

    public static void audio_service_close(Activity activity) {
        try {
            if (activity instanceof LiveClassActivity) {
                if (AudioPlayerService.player != null) {
                    if (AudioPlayerService.type.equalsIgnoreCase(Const.YOUTUBE)) {
                        ((LiveClassActivity) activity).myDBClass.getyoutubedata().updateTime(Long.valueOf(AudioPlayerService.player.getCurrentPosition()), AudioPlayerService.videoid, MakeMyExam.userId, "1");
                    } else {
                        ((LiveClassActivity) activity).myDBClass.getaudiodao().update_audio_currentpos(AudioPlayerService.videoid, MakeMyExam.userId, Long.valueOf(AudioPlayerService.player.getCurrentPosition()));
                    }
                    if (AudioPlayerService.player != null) {
                        AudioPlayerService.player.release();
                        AudioPlayerService.player = null;
                    }
                }
            } else if (AudioPlayerService.player != null) {
                if (AudioPlayerService.type.equalsIgnoreCase(Const.YOUTUBE)) {
                    UtkashRoom.getAppDatabase(activity).getyoutubedata().updateTime(Long.valueOf(AudioPlayerService.player.getCurrentPosition()), AudioPlayerService.videoid, MakeMyExam.userId, "1");
                } else {
                    UtkashRoom.getAppDatabase(activity).getaudiodao().update_audio_currentpos(AudioPlayerService.videoid, MakeMyExam.userId, Long.valueOf(AudioPlayerService.player.getCurrentPosition()));
                }
                if (AudioPlayerService.player != null) {
                    AudioPlayerService.player.release();
                    AudioPlayerService.player = null;
                }
            }
            if (AudioPlayerService.isAudioPlaying) {
                Intent intent = new Intent(activity, (Class<?>) AudioPlayerService.class);
                intent.setAction("Stop_Service");
                Util.startForegroundService(activity, intent);
                AudioPlayerService.video_currentpos = 0L;
            }
        } catch (Exception e2) {
            if (AudioPlayerService.player != null) {
                AudioPlayerService.player.release();
                AudioPlayerService.player = null;
            }
            if (AudioPlayerService.isAudioPlaying) {
                Intent intent2 = new Intent(activity, (Class<?>) AudioPlayerService.class);
                intent2.setAction("Stop_Service");
                Util.startForegroundService(activity, intent2);
                AudioPlayerService.video_currentpos = 0L;
            }
            e2.printStackTrace();
        }
    }

    public static void openWebPage(Context context, String url) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            intent.setFlags(1073741824);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, " You don't have any browser to open the pdf", 1).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void shareLiveClass(final android.app.Activity r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30) {
        /*
            Method dump skipped, instruction units count: 579
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.Helper.shareLiveClass(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void lambda$shareLiveClass$13(Progress progress, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Video link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
            return;
        }
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink2 = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Video link", shortLink2.toString(), String.format(shortLink2.toString(), new Object[0]));
        } else {
            progress.dismiss();
            Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.link_could_not_be_generated_please_try_again), 0).show();
        }
    }

    public static void shareAudio(final Activity activity, String maincourseid, String fieldid, String topicid, String tile_type, String tileid, String revertapi, String type, String image, String name, String parentid) {
        final Progress progress = new Progress(activity);
        progress.show();
        String str = (parentid == null || parentid.isEmpty()) ? "maincouseidAudio=" + maincourseid + "&fieldid=" + fieldid + "&topicid=" + topicid + "&tile_type=" + tile_type + "&tileid=" + tileid + "&revertapi=" + revertapi + "&type=" + type : "maincouseidAudio=" + maincourseid + "&fieldid=" + fieldid + "&parentid=" + parentid + "&topicid=" + topicid + "&tile_type=" + tile_type + "&tileid=" + tileid + "&revertapi=" + revertapi + "&type=" + type;
        if (SharedPreference.getInstance().getString(Const.SHARE_LINK_WITH_FIREBASE).equalsIgnoreCase("1")) {
            FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse("https://appapi.videocrypt.in/?data=" + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0))).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(image)).setTitle(name).build()).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(image)).setTitle(name).build()).setDomainUriPrefix(API.DYNAMIC_LINK_PREFIX).setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build()).buildShortDynamicLink().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Helper.lambda$shareAudio$14(progress, activity, task);
                }
            });
            return;
        }
        String strShareDataEncrypt = AES.shareDataEncrypt("?" + str.trim());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", getDynamicLinkUrl(activity) + strShareDataEncrypt);
        activity.startActivity(Intent.createChooser(intent, "Share via"));
        progress.dismiss();
    }

    static /* synthetic */ void lambda$shareAudio$14(Progress progress, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Audio link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
            return;
        }
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink2 = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Audio link", shortLink2.toString(), String.format(shortLink2.toString(), new Object[0]));
        } else {
            progress.dismiss();
            Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.link_could_not_be_generated_please_try_again), 0).show();
        }
    }

    public static void sharejwvideo(final Activity activity, String maincourseid, String fieldid, String topicid, String tile_type, String tileid, String revertapi, String type, String image, String name, String parentid) {
        Progress progress;
        String str;
        Progress progress2 = new Progress(activity);
        progress2.show();
        if (parentid == null || parentid.isEmpty()) {
            progress = progress2;
            str = "maincouseidjw=" + maincourseid + "&fieldid=" + fieldid + "&topicid=" + topicid + "&tile_type=" + tile_type + "&tileid=" + tileid + "&revertapi=" + revertapi + "&type=" + type;
        } else {
            progress = progress2;
            str = "maincouseidjw=" + maincourseid + "&fieldid=" + fieldid + "&parentid=" + parentid + "&topicid=" + topicid + "&tile_type=" + tile_type + "&tileid=" + tileid + "&revertapi=" + revertapi + "&type=" + type;
        }
        if (SharedPreference.getInstance().getString(Const.SHARE_LINK_WITH_FIREBASE).equalsIgnoreCase("1")) {
            final Progress progress3 = progress;
            FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse("https://appapi.videocrypt.in/?data=" + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0))).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(image)).setTitle(name).build()).setDomainUriPrefix(API.DYNAMIC_LINK_PREFIX).setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build()).buildShortDynamicLink().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda28
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Helper.lambda$sharejwvideo$15(progress3, activity, task);
                }
            });
            return;
        }
        String strShareDataEncrypt = AES.shareDataEncrypt("?" + str.trim());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", getDynamicLinkUrl(activity) + strShareDataEncrypt);
        activity.startActivity(Intent.createChooser(intent, "Share via"));
        progress.dismiss();
    }

    static /* synthetic */ void lambda$sharejwvideo$15(Progress progress, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Video link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
            return;
        }
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink2 = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Video link", shortLink2.toString(), String.format(shortLink2.toString(), new Object[0]));
        } else {
            progress.dismiss();
            Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.link_could_not_be_generated_please_try_again), 0).show();
        }
    }

    public static void sharePdf(final Activity activity, String maincourseid, String fieldid, String topicid, String tile_type, String tileid, String revertapi, final String type, String image, String name, String parentid) {
        Progress progress;
        String str;
        Progress progress2 = new Progress(activity);
        progress2.show();
        if (parentid == null || parentid.isEmpty()) {
            progress = progress2;
            str = "mainpdfid=" + maincourseid + "&fieldid=" + fieldid + "&topicid=" + topicid + "&tile_type=" + tile_type + "&tileid=" + tileid + "&revertapi=" + revertapi + "&type=" + type;
        } else {
            progress = progress2;
            str = "mainpdfid=" + maincourseid + "&fieldid=" + fieldid + "&topicid=" + topicid + "&parentid=" + parentid + "&tile_type=" + tile_type + "&tileid=" + tileid + "&revertapi=" + revertapi + "&type=" + type;
        }
        if (SharedPreference.getInstance().getString(Const.SHARE_LINK_WITH_FIREBASE).equalsIgnoreCase("1")) {
            final Progress progress3 = progress;
            FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse("https://appapi.videocrypt.in/?data=" + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0))).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(image)).setTitle(name).build()).setDomainUriPrefix(API.DYNAMIC_LINK_PREFIX).setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build()).buildShortDynamicLink().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda25
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Helper.lambda$sharePdf$16(progress3, type, activity, task);
                }
            });
            return;
        }
        String strShareDataEncrypt = AES.shareDataEncrypt("?" + str.trim());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", getDynamicLinkUrl(activity) + strShareDataEncrypt);
        activity.startActivity(Intent.createChooser(intent, "Share via"));
        progress.dismiss();
    }

    static /* synthetic */ void lambda$sharePdf$16(Progress progress, String str, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            if (str.equalsIgnoreCase("7")) {
                sendLink(activity, "Pdf link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
                return;
            } else {
                sendLink(activity, "Concept link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
                return;
            }
        }
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink2 = ((ShortDynamicLink) task.getResult()).getShortLink();
            if (str.equalsIgnoreCase("7")) {
                sendLink(activity, "Pdf link", shortLink2.toString(), String.format(shortLink2.toString(), new Object[0]));
                return;
            } else {
                sendLink(activity, "Concept link", shortLink2.toString(), String.format(shortLink2.toString(), new Object[0]));
                return;
            }
        }
        progress.dismiss();
        Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.link_could_not_be_generated_please_try_again), 0).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void sharePdf(final android.app.Activity r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32) {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.Helper.sharePdf(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void lambda$sharePdf$17(Progress progress, String str, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            if (str.equalsIgnoreCase("7")) {
                sendLink(activity, "Pdf link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
                return;
            } else {
                sendLink(activity, "Concept link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
                return;
            }
        }
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink2 = ((ShortDynamicLink) task.getResult()).getShortLink();
            if (str.equalsIgnoreCase("7")) {
                sendLink(activity, "Pdf link", shortLink2.toString(), String.format(shortLink2.toString(), new Object[0]));
                return;
            } else {
                sendLink(activity, "Concept link", shortLink2.toString(), String.format(shortLink2.toString(), new Object[0]));
                return;
            }
        }
        progress.dismiss();
        Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.link_could_not_be_generated_please_try_again), 0).show();
    }

    public static String changeAMPM(String date) {
        return date.replace("am", "AM").replace("pm", "PM");
    }

    public static void backButtonClick(Activity activity) {
        hideSoftKeyboard(activity);
        activity.finish();
    }

    public static void shareToWhatsApp(Activity activity, String subject, String msg, String msgHtml) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.setPackage("com.whatsapp");
        intent.putExtra("android.intent.extra.TEXT", msg);
        intent.putExtra("android.intent.extra.SUBJECT", subject);
        intent.putExtra(IntentCompat.EXTRA_HTML_TEXT, msgHtml);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(activity, "Whatsapp have not been installed.", 0).show();
        }
    }

    public static void gotoActivity_withour_intent(Activity context, Class<?> className) {
        context.startActivity(new Intent(context, className));
        context.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
    }

    public static void sharePost(final Activity activity, String maincourseid, String image, String title) {
        final Progress progress = new Progress(activity);
        progress.show();
        String str = "postid=" + maincourseid;
        if (SharedPreference.getInstance().getString(Const.SHARE_LINK_WITH_FIREBASE).equalsIgnoreCase("1")) {
            FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse("https://appapi.videocrypt.in/?data=" + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0))).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(image)).setTitle(title).build()).setDomainUriPrefix(API.DYNAMIC_LINK_PREFIX).setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build()).buildShortDynamicLink().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda27
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Helper.lambda$sharePost$18(progress, activity, task);
                }
            });
            return;
        }
        String strShareDataEncrypt = AES.shareDataEncrypt("?" + str.trim());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", getDynamicLinkUrl(activity) + strShareDataEncrypt);
        activity.startActivity(Intent.createChooser(intent, "Share via"));
        progress.dismiss();
    }

    static /* synthetic */ void lambda$sharePost$18(Progress progress, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            String str = String.format(shortLink.toString(), new Object[0]);
            if (BuildConfig.FLAVOR.equalsIgnoreCase("DishaPublication")) {
                sendLink(activity, "Course link", shortLink.toString(), str);
                return;
            } else {
                shareToWhatsApp(activity, "Course link", shortLink.toString(), str);
                return;
            }
        }
        progress.dismiss();
        Toast.makeText(activity, "Link could not be generated please try again! : ", 0).show();
    }

    public static void shareBanner(final Activity activity, String mainbannerid, String image, String title) {
        final Progress progress = new Progress(activity);
        progress.show();
        String str = "bannerid=" + mainbannerid;
        if (SharedPreference.getInstance().getString(Const.SHARE_LINK_WITH_FIREBASE).equalsIgnoreCase("1")) {
            FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse("https://appapi.videocrypt.in/?data=" + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0))).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(image)).setTitle(title).build()).setDomainUriPrefix(API.DYNAMIC_LINK_PREFIX).setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build()).buildShortDynamicLink().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda12
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Helper.lambda$shareBanner$19(progress, activity, task);
                }
            });
            return;
        }
        String strShareDataEncrypt = AES.shareDataEncrypt("?" + str.trim());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", getDynamicLinkUrl(activity) + strShareDataEncrypt);
        activity.startActivity(Intent.createChooser(intent, "Share via"));
        progress.dismiss();
    }

    static /* synthetic */ void lambda$shareBanner$19(Progress progress, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            shareToWhatsApp(activity, "Banner link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
        } else {
            progress.dismiss();
            Toast.makeText(activity, "Link could not be generated please try again! : ", 0).show();
        }
    }

    public static boolean isValidUrl(String linkToCheck) {
        return Pattern.compile("^((https?:\\/\\/(www)?)|(www)).+(\\..{2,4})(\\/)?.+$").matcher(linkToCheck).matches();
    }

    public static void isNoInternet(UtkashRoom utkashRoom, SplashScreen splashScreen, String is_security) {
        if (utkashRoom != null) {
            try {
                if (utkashRoom.getthemeSettingdao() != null) {
                    if (utkashRoom.getthemeSettingdao().is_setting_exit()) {
                        ThemeSettings themeSettingsData = utkashRoom.getthemeSettingdao().data();
                        if (themeSettingsData != null) {
                            LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
                            BottomMenu bottomMenu = (BottomMenu) new Gson().fromJson(themeSettingsData.getBottom(), BottomMenu.class);
                            if ((leftMenu != null && leftMenu.getDownloads() != null && leftMenu.getDownloads().equalsIgnoreCase("1")) || (bottomMenu != null && bottomMenu.getDownloads() != null && bottomMenu.getDownloads().equalsIgnoreCase("1"))) {
                                if (SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getId() != null) {
                                    if (SharedPreference.getInstance().getLoggedInUser() != null && !SharedPreference.getInstance().getLoggedInUser().getId().equalsIgnoreCase("0")) {
                                        splashScreen.init_splash(is_security);
                                        return;
                                    } else {
                                        buildDialogNoInternet(splashScreen);
                                        return;
                                    }
                                }
                                buildDialogNoInternet(splashScreen);
                                return;
                            }
                            buildDialogNoInternet(splashScreen);
                            return;
                        }
                        buildDialogNoInternet(splashScreen);
                        return;
                    }
                    buildDialogNoInternet(splashScreen);
                }
            } catch (SQLiteDiskIOException e2) {
                Log.e("DatabaseHelper", "SQLiteDiskIOException during onUpgrade: " + e2.getMessage());
            } catch (SQLiteFullException e3) {
                Log.e("DatabaseHelper", "SQLiteFullException during onUpgrade: " + e3.getMessage());
            } catch (IllegalStateException e4) {
                Log.e("DatabaseHelper", "IllegalStateException (DB closed): " + e4.getMessage());
            } catch (Exception e5) {
                Log.e("DatabaseHelper", "Unhandled Exception: " + e5.getMessage());
            }
        }
    }

    public static void startVideoDownloadService(Context context, Intent videoDownloadIntent) {
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                ContextCompat.startForegroundService(context, videoDownloadIntent);
                return;
            } catch (ForegroundServiceStartNotAllowedException unused) {
                Log.d("TAGForegroundNotAllow", "Foreground service not allowed on API 31+");
                return;
            }
        }
        ContextCompat.startForegroundService(context, videoDownloadIntent);
    }

    public static void setSplashScreen(Activity activity, ImageView splashImage, final ImageView splashGIF, VideoView splashVideo, ProgressBar progressBar2, String splashType) {
        String strSubstring;
        if (splashType.equalsIgnoreCase("1")) {
            splashGIF.setVisibility(0);
        } else if (splashType.equalsIgnoreCase("2")) {
            splashVideo.setVisibility(0);
        } else {
            splashImage.setVisibility(0);
        }
        if (SharedPreference.getInstance().getString(Const.SPLASH_URL) != null && !SharedPreference.getInstance().getString(Const.SPLASH_URL).isEmpty()) {
            String string = SharedPreference.getInstance().getString(Const.SPLASH_URL);
            try {
                String path = new URL(string).getPath();
                strSubstring = path.substring(path.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
            } catch (MalformedURLException unused) {
                strSubstring = "";
            }
            if (getFileExist(strSubstring, activity).exists()) {
                if (strSubstring.contains("gif")) {
                    splashGIF.setVisibility(0);
                    splashImage.setVisibility(8);
                    splashVideo.setVisibility(8);
                } else if (isImageUrl(strSubstring)) {
                    splashGIF.setVisibility(8);
                    splashImage.setVisibility(0);
                    splashVideo.setVisibility(8);
                } else {
                    splashGIF.setVisibility(8);
                    splashImage.setVisibility(8);
                    splashVideo.setVisibility(0);
                }
                String string2 = getFileExist(strSubstring, activity).toString();
                if (string2.contains(".gif")) {
                    Glide.with(activity).asGif().load(string2).into(new CustomTarget<GifDrawable>() { // from class: com.appnew.android.Utils.Helper.20
                        @Override // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable placeholder) {
                        }

                        @Override // com.bumptech.glide.request.target.Target
                        public /* bridge */ /* synthetic */ void onResourceReady(Object resource, Transition transition) {
                            onResourceReady((GifDrawable) resource, (Transition<? super GifDrawable>) transition);
                        }

                        public void onResourceReady(GifDrawable resource, Transition<? super GifDrawable> transition) {
                            resource.setLoopCount(1);
                            splashGIF.setImageDrawable(resource);
                            resource.start();
                        }
                    });
                    return;
                }
                if (isImageUrl(string2)) {
                    Glide.with(activity).load(string2).into(splashImage);
                    return;
                }
                splashVideo.setVideoURI(Uri.parse(string2));
                splashVideo.setZOrderOnTop(true);
                splashVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.appnew.android.Utils.Helper.21
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mp) {
                    }
                });
                splashVideo.start();
                return;
            }
            if (splashType.equalsIgnoreCase("1")) {
                Glide.with(activity).asGif().load(Integer.valueOf(com.eduteria.app.app.R.drawable.splash_logo)).into(new CustomTarget<GifDrawable>() { // from class: com.appnew.android.Utils.Helper.22
                    @Override // com.bumptech.glide.request.target.Target
                    public void onLoadCleared(Drawable placeholder) {
                    }

                    @Override // com.bumptech.glide.request.target.Target
                    public /* bridge */ /* synthetic */ void onResourceReady(Object resource, Transition transition) {
                        onResourceReady((GifDrawable) resource, (Transition<? super GifDrawable>) transition);
                    }

                    public void onResourceReady(GifDrawable resource, Transition<? super GifDrawable> transition) {
                        resource.setLoopCount(1);
                        splashGIF.setImageDrawable(resource);
                        resource.start();
                    }
                });
            } else if (splashType.equalsIgnoreCase("2")) {
                splashVideo.setVideoURI(Uri.parse("android.resource://" + activity.getPackageName() + "/2131952148"));
                splashVideo.setZOrderOnTop(true);
                splashVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.appnew.android.Utils.Helper.23
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mp) {
                    }
                });
                splashVideo.start();
            } else {
                Glide.with(activity).load(Integer.valueOf(com.eduteria.app.app.R.mipmap.splash_logo)).into(splashImage);
            }
            if (isImageUrl(strSubstring) || strSubstring.contains("gif") || strSubstring.contains("mp4")) {
                new DownloadTask(activity, strSubstring, progressBar2).execute(string);
                return;
            }
            return;
        }
        if (splashType.equalsIgnoreCase("1")) {
            Glide.with(activity).asGif().load(Integer.valueOf(com.eduteria.app.app.R.drawable.splash_logo)).into(new CustomTarget<GifDrawable>() { // from class: com.appnew.android.Utils.Helper.24
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object resource, Transition transition) {
                    onResourceReady((GifDrawable) resource, (Transition<? super GifDrawable>) transition);
                }

                public void onResourceReady(GifDrawable resource, Transition<? super GifDrawable> transition) {
                    resource.setLoopCount(1);
                    splashGIF.setImageDrawable(resource);
                    resource.start();
                }
            });
            return;
        }
        if (splashType.equalsIgnoreCase("2")) {
            splashVideo.setVideoURI(Uri.parse("android.resource://" + activity.getPackageName() + "/2131952148"));
            splashVideo.setZOrderOnTop(true);
            splashVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.appnew.android.Utils.Helper.25
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mp) {
                }
            });
            splashVideo.start();
            return;
        }
        Glide.with(activity).load(Integer.valueOf(com.eduteria.app.app.R.mipmap.splash_logo)).into(splashImage);
    }

    public static boolean isImageUrl(String imageUrl) {
        String lowerCase = imageUrl.toLowerCase();
        return lowerCase.endsWith(".png") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg");
    }

    public static boolean NotBeSameAlternateMobileNumber(String alternateNumber, String mobileNumber) {
        return alternateNumber.equals(mobileNumber);
    }

    public static void setLoginImage(Activity activity, ImageView loginImage) {
        try {
            JSONObject jSONObject = new JSONObject(SharedPreference.getInstance().getString(Const.SPLASH_DATA));
            if (TextUtils.isEmpty(jSONObject.get("login_logo").toString())) {
                return;
            }
            if (getFileExist(getEndPoint(jSONObject.get("login_logo").toString()), activity).exists()) {
                Glide.with(activity).load(getFileExist(getEndPoint(jSONObject.get("login_logo").toString()), activity).toString()).into(loginImage);
            } else {
                Glide.with(activity).load(Integer.valueOf(com.eduteria.app.app.R.mipmap.ic_logo_login)).into(loginImage);
            }
        } catch (JSONException unused) {
            Glide.with(activity).load(Integer.valueOf(com.eduteria.app.app.R.mipmap.ic_logo_login)).into(loginImage);
        }
    }

    public static void setHeaderImage(Activity activity, ImageView loginImage) {
        try {
            JSONObject jSONObject = new JSONObject(SharedPreference.getInstance().getString(Const.SPLASH_DATA));
            if (TextUtils.isEmpty(jSONObject.get("header_logo").toString())) {
                return;
            }
            if (getFileExist(getEndPoint(jSONObject.get("header_logo").toString()), activity).exists()) {
                Glide.with(activity).load(getFileExist(getEndPoint(jSONObject.get("header_logo").toString()), activity).toString()).into(loginImage);
            } else {
                Glide.with(activity).load(Integer.valueOf(com.eduteria.app.app.R.mipmap.ic_logo_header)).into(loginImage);
            }
        } catch (JSONException unused) {
            Glide.with(activity).load(Integer.valueOf(com.eduteria.app.app.R.mipmap.ic_logo_header)).into(loginImage);
        }
    }

    public static String getEndPoint(String Url) {
        try {
            String path = new URL(Url).getPath();
            return path.substring(path.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static class DownloadTask extends AsyncTask<String, Integer, String> {
        public Context context;
        public String endPoint;
        public ProgressBar progressBar;

        public DownloadTask(Context context, String endPoint, ProgressBar progressBar) {
            this.context = context;
            this.endPoint = endPoint;
            this.progressBar = progressBar;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            if (this.endPoint.contains(".mp4")) {
                this.progressBar.setVisibility(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate((Object[]) progress);
            if (this.endPoint.contains(".mp4")) {
                try {
                    this.progressBar.setIndeterminate(false);
                    this.progressBar.setMax(100);
                    this.progressBar.setProgress(progress[0].intValue());
                } catch (Exception e2) {
                    Log.d("TAGPDFDETAIL", "onProgressUpdate: " + e2.getMessage());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            this.progressBar.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0083, code lost:
        
            r4.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0086, code lost:
        
            if (r2 == null) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
        
            r2.close();
         */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:90:? A[SYNTHETIC] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String doInBackground(java.lang.String... r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 243
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.Helper.DownloadTask.doInBackground(java.lang.String[]):java.lang.String");
        }
    }

    public static File getFileExist(String fileName, Activity activity) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(activity.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
    }

    private static class WebViewClickListener implements View.OnLongClickListener {
        WebView web;

        WebViewClickListener(WebView option1_webview) {
            this.web = option1_webview;
            option1_webview.setLongClickable(false);
            this.web.setHapticFeedbackEnabled(false);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            v.setLongClickable(false);
            v.setHapticFeedbackEnabled(false);
            return true;
        }
    }

    public static void TestWebHTMLLoad(WebView clickableWebView, String description) {
        boolean z;
        String strDecodeHtmlEntities;
        String hTMLWidthForImage;
        String strReplaceAll = "";
        if (description != null) {
            try {
                strReplaceAll = description.replaceAll("(?i)(background-color|background)\\s*:\\s*#ffffff\\s*;?", "");
            } catch (Exception unused) {
                return;
            }
        }
        if (Pattern.compile("(?i)(font-family:\\s*['\"]?)(Kruti Dev|Kruti Dev 010|kruti dev 021|Kruti Dev 011 Regular)(['\"]?)").matcher(strReplaceAll).find()) {
            strReplaceAll = "<style type='text/css'>@font-face {  font-family: 'localKrutiDev';  src: url('fonts/k010_regular.ttf') format('truetype');}* {  font-family: 'localKrutiDev' !important;}</style>" + strReplaceAll.replaceAll("(?i)(font-family\\s*:\\s*['\"]?)(Kruti Dev 010)(['\"]?)", "$1localKrutiDev$3");
            z = true;
        } else {
            z = false;
        }
        clickableWebView.getSettings().setJavaScriptEnabled(true);
        clickableWebView.setLongClickable(false);
        clickableWebView.setOnLongClickListener(new WebViewClickListener(clickableWebView));
        if (strReplaceAll.contains("math-tex")) {
            hTMLWidthForImage = getOfflineKatexConfig(strReplaceAll);
        } else {
            if (strReplaceAll.contains(StringUtils.LT_ENCODE) || strReplaceAll.contains(StringUtils.GT_ENCODE) || strReplaceAll.contains("&amp;lt;") || strReplaceAll.contains("&amp;gt;")) {
                strDecodeHtmlEntities = decodeHtmlEntities(strReplaceAll);
            } else {
                strDecodeHtmlEntities = cleanHTMLWithSymbolFont(strReplaceAll);
            }
            if (z) {
                strDecodeHtmlEntities = strDecodeHtmlEntities.replaceAll("(?i)font-family\\s*:\\s*['\"]?Kruti Dev[^;'\"]*['\"]?", "font-family:'localKrutiDev'");
            }
            hTMLWidthForImage = getHTMLWidthForImage(removeBrokenStyleText(strDecodeHtmlEntities, !z));
        }
        clickableWebView.loadDataWithBaseURL("file:///android_asset/", hTMLWidthForImage, Mimetypes.MIMETYPE_HTML, "UTF-8", "about:blank");
    }

    public static String decodeHtmlEntities(String input) {
        if (input == null) {
            return "";
        }
        return input.replace(StringUtils.LT_ENCODE, "<").replace(StringUtils.GT_ENCODE, ">").replace(StringUtils.AMP_ENCODE, "&").replace(StringUtils.QUOTE_ENCODE, "\"").replace("&#39;", "'").replace("&nbsp;", " ");
    }

    public static String removeBrokenStyleText(String html, boolean removeStyleTags) {
        if (html == null) {
            return "";
        }
        String strReplaceAll = html.replaceAll("\\*\\s*\\{[^}]*\\}", "");
        return removeStyleTags ? strReplaceAll.replaceAll("<style[^>]*>.*?</style>", "") : strReplaceAll;
    }

    public static String getHTMLWidthForImage(String htmlStr) {
        if (htmlStr == null) {
            return "";
        }
        return "<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><style>img{max-width: 100%; height: auto;}</style></head><body>" + htmlStr + "</body></html>";
    }

    public static String cleanHTMLWithSymbolFont(String html) {
        if (html == null) {
            return "";
        }
        return Pattern.compile("(?i)font-family\\s*:\\s*['\"]?Symbol['\"]?").matcher(html).find() ? getSymbolFontCSS() + html : html;
    }

    private static String getSymbolFontCSS() {
        return "    <style>\n        @font-face {\n            font-family: 'Symbol';\n            src: url('file:///android_asset/fonts/symbol.ttf') format('truetype');\n            font-weight: normal;\n            font-style: normal;\n        }\n    </style>\n";
    }

    private static String getOfflineKatexConfig(String formulaString) {
        return String.format("<!DOCTYPE html>\n<html>\n    <head>\n        <meta charset=\"UTF-8\">\n        <title>Auto-render test</title>\n\n        <!-- KaTeX -->\n        <link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/katex/katex.min.css\">\n        <script type=\"text/javascript\" src=\"file:///android_asset/katex/katex.min.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///android_asset/katex/contrib/auto-render.min.js\"></script>\n\n        <!-- Symbol Font -->\n        %s\n\n        <style type='text/css'>\n            body {\n                font-size: 0px;\n                color: #000000;\n                padding: 0px;\n            }\n        </style>\n    </head>\n    <body>\n        %s\n        <script>\n            renderMathInElement(document.body);\n        </script>\n    </body>\n</html>\n", getSymbolFontCSS(), formulaString);
    }

    public static boolean isColorTooLight(int color) {
        return ((((double) Color.red(color)) * 0.299d) + (((double) Color.green(color)) * 0.587d)) + (((double) Color.blue(color)) * 0.114d) > 210.0d;
    }

    public static void setTextLimit(EditText mobileNumberEditText, int number) {
        mobileNumberEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(number)});
    }

    public static void load(WebView clickableWebView, String description) {
        try {
            clickableWebView.getSettings().setCacheMode(1);
            if ((description.contains(StringUtils.LT_ENCODE) || description.contains(StringUtils.GT_ENCODE)) && !BuildConfig.FLAVOR.equalsIgnoreCase("resodigital")) {
                description = String.valueOf(Html.fromHtml(description));
            }
            clickableWebView.loadDataWithBaseURL(com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID, getOfflineKatexConfig(description), Mimetypes.MIMETYPE_HTML, "UTF-8", "about:blank");
        } catch (Exception unused) {
        }
    }

    public static class MySpannable extends ClickableSpan {
        private boolean isUnderline;

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
        }

        public MySpannable(boolean isUnderline) {
            this.isUnderline = isUnderline;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(this.isUnderline);
            ds.setColor(Color.parseColor("#33A2D9"));
        }
    }

    public static AlertDialog startCast(final Activity context) {
        if (context == null || context.isFinishing() || context.isDestroyed()) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Screen Mirroring feature supports below mentioned conditions");
        builder.setMessage(com.eduteria.app.app.R.string.screen_mirror_dialog_msg);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                Helper.lambda$startCast$20(context, dialogInterface, i2);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        ((TextView) alertDialogCreate.findViewById(R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
        return alertDialogCreate;
    }

    static /* synthetic */ void lambda$startCast$20(Activity activity, DialogInterface dialogInterface, int i2) {
        try {
            try {
                activity.startActivity(new Intent("android.settings.WIFI_DISPLAY_SETTINGS"));
            } catch (ActivityNotFoundException unused) {
                activity.startActivity(new Intent("android.settings.CAST_SETTINGS"));
            }
        } catch (Exception unused2) {
            Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.tv_not_supported), 1).show();
        }
    }

    public static void activityAnimation(Activity activity) {
        activity.overridePendingTransition(com.eduteria.app.app.R.anim.activity_in, com.eduteria.app.app.R.anim.activity_out);
    }

    public static NimbusRetrofitApi getApi() {
        return (NimbusRetrofitApi) RetrofitClient.getClient("").create(NimbusRetrofitApi.class);
    }

    public static String getVideoId(String watchLink) {
        if (watchLink.contains("?")) {
            watchLink = watchLink.replace("?", "~").split("~")[0];
        }
        return watchLink.trim().substring(r3.split("\\s+")[0].length() - 11);
    }

    public static void showDialog(final Activity activity, String Message) {
        DialogUtils.makeSingleButtonDialog(activity, "", Message, activity.getResources().getString(com.eduteria.app.app.R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.26
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
            }
        });
    }

    public static Cipher getCipher() throws GeneralSecurityException {
        String str = VideoDownloadService.LOCAL_ENCRYPTION_KEY;
        String strGenerateLibVectorAPI = AES.generateLibVectorAPI(str);
        byte[] bytes = AES.generateLibkeyAPI(str).getBytes();
        byte[] bytes2 = strGenerateLibVectorAPI.getBytes();
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(2, new SecretKeySpec(bytes, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM), new IvParameterSpec(bytes2));
        return cipher;
    }

    public static boolean isAppInstalled(Activity activity, String packageName) {
        try {
            activity.getPackageManager().getPackageInfo(packageName, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static float convertDpToPixel(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static void fetchFirebaseToken(Context context, final OnTokenReceivedListener listener) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda13
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                Helper.lambda$fetchFirebaseToken$21(listener, task);
            }
        });
    }

    static /* synthetic */ void lambda$fetchFirebaseToken$21(OnTokenReceivedListener onTokenReceivedListener, Task task) {
        if (task.isSuccessful() && task.getResult() != null && !TextUtils.isEmpty((CharSequence) task.getResult())) {
            firebaseToken = (String) task.getResult();
            Log.d("FirebaseToken", "Fetched Firebase Token: " + firebaseToken);
            if (onTokenReceivedListener != null) {
                onTokenReceivedListener.onTokenReceived(firebaseToken);
                return;
            }
            return;
        }
        Log.e("FirebaseToken", "Failed to fetch Firebase Token", task.getException());
        if (onTokenReceivedListener != null) {
            onTokenReceivedListener.onTokenReceived(null);
        }
    }

    public static void refreshFirebaseToken(Context context, final OnTokenReceivedListener listener) {
        Log.d("refreshToken", "Starting token refresh...");
        FirebaseMessaging.getInstance().deleteToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                Helper.lambda$refreshFirebaseToken$23(listener, task);
            }
        });
    }

    static /* synthetic */ void lambda$refreshFirebaseToken$23(final OnTokenReceivedListener onTokenReceivedListener, Task task) {
        if (task.isSuccessful()) {
            Log.d("refreshToken", "Old token deleted successfully");
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda18
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    Helper.lambda$refreshFirebaseToken$22(onTokenReceivedListener, task2);
                }
            });
        } else {
            Log.e("refreshToken", "Failed to delete token: ", task.getException());
            if (onTokenReceivedListener != null) {
                onTokenReceivedListener.onTokenReceived(null);
            }
        }
    }

    static /* synthetic */ void lambda$refreshFirebaseToken$22(OnTokenReceivedListener onTokenReceivedListener, Task task) {
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            if (!TextUtils.isEmpty(str)) {
                firebaseToken = str;
                Log.d("refreshToken", "New token fetched: " + str);
                if (onTokenReceivedListener != null) {
                    onTokenReceivedListener.onTokenReceived(str);
                    return;
                }
                return;
            }
            Log.w("refreshToken", "Token fetch returned empty");
            if (onTokenReceivedListener != null) {
                onTokenReceivedListener.onTokenReceived(null);
                return;
            }
            return;
        }
        Log.e("refreshToken", "Token fetch failed: ", task.getException());
        if (onTokenReceivedListener != null) {
            onTokenReceivedListener.onTokenReceived(null);
        }
    }

    public static void setThumbnailImage(Context context, String url, Drawable placeholder, ImageView imageView) {
        if (context == null || imageView == null) {
            return;
        }
        if (placeholder == null) {
            try {
                placeholder = ResourcesCompat.getDrawable(context.getResources(), com.eduteria.app.app.R.mipmap.placeholder_course, context.getTheme());
            } catch (Exception unused) {
                imageView.setImageDrawable(placeholder);
                return;
            }
        }
        Glide.with(context.getApplicationContext()).load(!TextUtils.isEmpty(url) ? url.replaceAll(" ", "%20") : "").apply((BaseRequestOptions<?>) new RequestOptions().placeholder(placeholder).error(placeholder).fallback(placeholder).diskCacheStrategy(DiskCacheStrategy.DATA)).into(imageView);
    }

    public static boolean isStringValid(String string) {
        return (string == null || TextUtils.isEmpty(string) || string.equalsIgnoreCase("")) ? false : true;
    }

    public static boolean isAdharValid(String string) {
        return (string == null || TextUtils.isEmpty(string) || string.equalsIgnoreCase("") || string.length() != 12) ? false : true;
    }

    public static boolean isPinCodeValid(String string) {
        return (string == null || TextUtils.isEmpty(string) || string.equalsIgnoreCase("") || string.length() != 6) ? false : true;
    }

    public static ArrayList<CartItems> getMyCourseCart(Activity activity) {
        Gson gson = new Gson();
        new ArrayList();
        ArrayList<CartItems> arrayList = new ArrayList<>();
        ArrayList<CartItems> arrayList2 = (ArrayList) gson.fromJson(activity.getSharedPreferences(Const.SHARED_PREFS.NAME, 0).getString(Const.SHARED_PREFS.CART_LIST, ""), new TypeToken<List<CartItems>>() { // from class: com.appnew.android.Utils.Helper.27
        }.getType());
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (CartItems cartItems : arrayList2) {
                if (cartItems.getUser_id().equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getId())) {
                    arrayList.add(cartItems);
                }
            }
        }
        return arrayList;
    }

    public static void buyNowCourses(Activity activity, SinglestudyModel singleStudy) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(singleStudy);
        Intent intent = new Intent(activity, (Class<?>) CourseActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.COURSE_INVOICE);
        intent.putExtra(Const.EMI_TYPE, Const.EMI_INSTALLMENT);
        intent.putExtra(Const.SINGLE_STUDY, arrayList);
        activity.startActivity(intent);
    }

    public static void buyNowCourses(Activity activity, CourseDetailData courseDetailData) {
        Intent intent = new Intent(activity, (Class<?>) CourseActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.COURSE_INVOICE);
        intent.putExtra("CourseDetailData", courseDetailData);
        activity.startActivity(intent);
    }

    public static void addToMyCartCourses(Activity activity, CartItems item, boolean isAdd, boolean isBuyNow, Button addToCart) {
        new ArrayList();
        ArrayList<CartItems> myCourseCart = getMyCourseCart(activity);
        if (isAdd) {
            Iterator<CartItems> it = myCourseCart.iterator();
            while (it.hasNext()) {
                if (item.getCourse_id().equals(it.next().getCourse_id())) {
                    if (isBuyNow) {
                        Intent intent = new Intent(activity, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.MYCART);
                        activity.startActivity(intent);
                        return;
                    }
                    return;
                }
            }
            myCourseCart.add(item);
            if (addToCart != null) {
                addToCart.setText(activity.getResources().getString(com.eduteria.app.app.R.string.remove_from_cart));
            }
        } else {
            boolean z = false;
            for (int i2 = 0; i2 < myCourseCart.size(); i2++) {
                if (myCourseCart.get(i2).getCourse_id().equals(item.getCourse_id()) && !z) {
                    myCourseCart.remove(i2);
                    z = true;
                }
            }
            if (addToCart != null) {
                addToCart.setText(activity.getResources().getString(com.eduteria.app.app.R.string.add_to_cart));
            }
        }
        SharedPreferences.Editor editorEdit = activity.getSharedPreferences(Const.SHARED_PREFS.NAME, 0).edit();
        editorEdit.putString(Const.SHARED_PREFS.CART_LIST, new Gson().toJson(myCourseCart));
        editorEdit.commit();
        if (isBuyNow) {
            Intent intent2 = new Intent(activity, (Class<?>) CourseActivity.class);
            intent2.putExtra(Const.FRAG_TYPE, Const.MYCART);
            activity.startActivity(intent2);
        }
    }

    public static void GoWebViewPDFActivity(Context activity, String title, String url) {
        Intent intent = new Intent(activity, (Class<?>) WebFragActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        gotoActivity(intent, (Activity) activity);
    }

    public static void GoToWebViewPDFActivity(Context activity, String v_id, String url, boolean isDownload, String pdf_name, String course_id, String bookmark, String fileType, String isShare, String subjective_paper) {
        Intent intent;
        if (url.contains(".pdf") || url.contains(".zip")) {
            String strReplace = url.contains(".zip") ? url.replace(".zip", ".pdf") : url;
            if (BuildConfig.FLAVOR.equalsIgnoreCase("labaa")) {
                intent = new Intent(activity, (Class<?>) PDFViewerJS.class);
            } else {
                intent = new Intent(activity, (Class<?>) PdfDetailScreen.class);
            }
            intent.putExtra("title", v_id);
            intent.putExtra("url", strReplace);
            intent.putExtra("pdf_name", pdf_name);
            intent.putExtra("save", false);
            intent.putExtra(Const.IS_DOWNLOAD, isDownload);
            intent.putExtra("is_share", isShare);
            intent.putExtra("bookmark", bookmark);
            intent.putExtra("file_type", fileType);
            intent.putExtra("subjective_paper", subjective_paper);
            if (!course_id.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                intent.putExtra("course_id", course_id + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent.putExtra("course_id", course_id);
            }
            activity.startActivity(intent);
            return;
        }
        if (url.contains(".ws")) {
            GoToWS(activity, v_id, url, isDownload, pdf_name, v_id, course_id);
        } else {
            Toast.makeText(activity, "Please Provide Pdf or Ws File Only.", 0).show();
        }
    }

    public static void GoToWebViewPDFActivity(Context activity, String v_id, String url, boolean isDownload, String pdf_name, String course_id, String isShare) {
        Intent intent;
        if (url.contains(".pdf") || url.contains(".zip")) {
            String strReplace = url.contains(".zip") ? url.replace(".zip", ".pdf") : url;
            if (BuildConfig.FLAVOR.equalsIgnoreCase("labaa")) {
                intent = new Intent(activity, (Class<?>) PDFViewerJS.class);
            } else {
                intent = new Intent(activity, (Class<?>) PdfDetailScreen.class);
            }
            intent.putExtra("title", v_id);
            intent.putExtra("url", strReplace);
            intent.putExtra("pdf_name", pdf_name);
            intent.putExtra("save", false);
            intent.putExtra(Const.IS_DOWNLOAD, isDownload);
            intent.putExtra("is_share", isShare);
            if (course_id == null || !course_id.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                intent.putExtra("course_id", course_id + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent.putExtra("course_id", course_id);
            }
            activity.startActivity(intent);
            return;
        }
        if (url.contains(".ws")) {
            GoToWS(activity, v_id, url, isDownload, pdf_name, v_id, course_id);
        } else {
            Toast.makeText(activity, "Please Provide Pdf or Ws File Only.", 0).show();
        }
    }

    public static void GoToWebViewPDFActivity1(Context activity, String v_id, String url, boolean isDownload, String pdf_name, String course_id, String result) {
        if (url.contains(".pdf") || url.contains(".zip")) {
            String strReplace = url.contains(".zip") ? url.replace(".zip", ".pdf") : url;
            Intent intent = new Intent(activity, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("title", v_id);
            intent.putExtra("url", strReplace);
            intent.putExtra("pdf_name", pdf_name);
            intent.putExtra("save", false);
            intent.putExtra(Const.IS_DOWNLOAD, isDownload);
            intent.putExtra("rank", result);
            if (course_id == null || !course_id.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                intent.putExtra("course_id", course_id + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent.putExtra("course_id", course_id);
            }
            activity.startActivity(intent);
            return;
        }
        if (url.contains(".ws")) {
            GoToWS(activity, v_id, url, isDownload, pdf_name, v_id, course_id);
        }
    }

    public static void shareCurrentAffair(final Activity activity, String maincourseid, String parentcourseid, String name, String image, String title) {
        String str;
        final Progress progress = new Progress(activity);
        progress.show();
        if (parentcourseid == null || parentcourseid.isEmpty()) {
            str = "maincouseidAffair=" + maincourseid;
        } else {
            str = "maincouseidAffair=" + maincourseid + "&parentcourseid=" + parentcourseid;
        }
        if (SharedPreference.getInstance().getString(Const.SHARE_LINK_WITH_FIREBASE).equalsIgnoreCase("1")) {
            FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse("https://appapi.videocrypt.in/?data=" + Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0))).setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setImageUrl(Uri.parse(image)).setTitle(title).build()).setDomainUriPrefix(API.DYNAMIC_LINK_PREFIX).setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build()).buildShortDynamicLink().addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda20
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Helper.lambda$shareCurrentAffair$24(progress, activity, task);
                }
            });
            return;
        }
        String strShareDataEncrypt = AES.shareDataEncrypt("?" + str.trim());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", getDynamicLinkUrl(activity) + strShareDataEncrypt);
        activity.startActivity(Intent.createChooser(intent, "Share via"));
        progress.dismiss();
    }

    static /* synthetic */ void lambda$shareCurrentAffair$24(Progress progress, Activity activity, Task task) {
        progress.dismiss();
        if (task.isSuccessful()) {
            Uri shortLink = ((ShortDynamicLink) task.getResult()).getShortLink();
            sendLink(activity, "Course link", shortLink.toString(), String.format(shortLink.toString(), new Object[0]));
        } else {
            progress.dismiss();
            Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.link_could_not_be_generated_please_try_again), 0).show();
        }
    }

    public static void callPaymentTypeDialog(Context context, ArrayList data, final PaymentTypeCheck paymentTypeCheck, final JSONObject paymentData) {
        try {
            paymenttype = "";
            final Dialog dialog2 = new Dialog(context, com.eduteria.app.app.R.style.TransparentDialog);
            dialog2.requestWindowFeature(1);
            dialog2.setContentView(com.eduteria.app.app.R.layout.dialog_choose_payment_gateway);
            dialog2.getWindow().setLayout(-1, -1);
            LayoutInflater.from(context).inflate(com.eduteria.app.app.R.layout.dialog_choose_payment_gateway, (ViewGroup) null);
            dialog2.setCancelable(false);
            RecyclerView recyclerView = (RecyclerView) dialog2.findViewById(com.eduteria.app.app.R.id.rv_paymentMode);
            Button button = (Button) dialog2.findViewById(com.eduteria.app.app.R.id.btn_cancel);
            Button button2 = (Button) dialog2.findViewById(com.eduteria.app.app.R.id.btn_submit);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
            recyclerView.setAdapter(new PaymentModeAdapter(context, data));
            recyclerView.setNestedScrollingEnabled(false);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Helper.lambda$callPaymentTypeDialog$25(dialog2, paymentTypeCheck, paymentData, view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Helper.lambda$callPaymentTypeDialog$26(dialog2, paymentTypeCheck, view);
                }
            });
            dialog2.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$callPaymentTypeDialog$25(Dialog dialog2, PaymentTypeCheck paymentTypeCheck, JSONObject jSONObject, View view) {
        dialog2.dismiss();
        paymentTypeCheck.onPaymentType(paymenttype, jSONObject);
    }

    static /* synthetic */ void lambda$callPaymentTypeDialog$26(Dialog dialog2, PaymentTypeCheck paymentTypeCheck, View view) {
        dialog2.dismiss();
        paymentTypeCheck.onPaymentTypeCancel();
    }

    public static void GoToWebViewPDFActivity(Context activity, String v_id, String url, boolean isDownload, String pdf_name, String course_id, boolean saved, String from, boolean uploadPdf) {
        if (url.contains(".pdf") || url.contains(".zip")) {
            String strReplace = url.contains(".zip") ? url.replace(".zip", ".pdf") : url;
            Intent intent = new Intent(activity, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("title", v_id);
            intent.putExtra("url", strReplace);
            intent.putExtra("pdf_name", pdf_name);
            intent.putExtra("save", saved);
            intent.putExtra(Const.IS_DOWNLOAD, isDownload);
            intent.putExtra("from", from);
            intent.putExtra("uploadPdf", uploadPdf);
            if (!course_id.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                intent.putExtra("course_id", course_id + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent.putExtra("course_id", course_id);
            }
            activity.startActivity(intent);
            return;
        }
        if (url.contains(".ws")) {
            GoToWS(activity, v_id, url, isDownload, pdf_name, v_id, course_id);
        } else {
            Toast.makeText(activity, "Please Provide Pdf or Ws File Only.", 0).show();
        }
    }

    public static void GoToPDFScreenActivity(Activity activity, String v_id, String url, boolean isDownload, String pdf_name, String course_id, boolean saved) {
        if (url.contains(".pdf") || url.contains(".zip")) {
            String strReplace = url.contains(".zip") ? url.replace(".zip", ".pdf") : url;
            Intent intent = new Intent(activity, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("title", v_id);
            intent.putExtra("url", strReplace);
            intent.putExtra("pdf_name", pdf_name);
            intent.putExtra("save", saved);
            intent.putExtra(Const.IS_DOWNLOAD, isDownload);
            if (!course_id.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                intent.putExtra("course_id", course_id + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent.putExtra("course_id", course_id);
            }
            activity.startActivityForResult(intent, 100011);
            return;
        }
        if (url.contains(".ws")) {
            GoToWS(activity, v_id, url, isDownload, pdf_name, v_id, course_id);
        }
    }

    public static void GoToSubjectiveResultActivity(Context activity, String solutions, String title, String id, String videoId, String contenttype) {
        Intent intent = new Intent(activity, (Class<?>) SubjectiveResultActivity.class);
        intent.putExtra("url", solutions);
        intent.putExtra("title", title);
        intent.putExtra("id", id);
        intent.putExtra(Const.VIDEO_ID, videoId);
        intent.putExtra("content", contenttype);
        intent.putExtra("test_id", com.appnew.android.home.Constants.SUB_TEST_ID);
        activity.startActivity(intent);
    }

    public static void GoToWS(Context activity, String title, String url, boolean isDownload, String pdf_name, String video_id, String course_id) {
        Intent intent = new Intent(activity, (Class<?>) PdfHtmlAcivity.class);
        intent.putExtra("url", url);
        intent.putExtra("type", pdf_name);
        intent.putExtra("file_type", "ws");
        intent.putExtra(Const.VIDEO_ID, title);
        intent.putExtra("course_id", course_id);
        activity.startActivity(intent);
    }

    public static String getDaySuffix(final int n) {
        Preconditions.checkArgument(n >= 1 && n <= 31, "illegal day of month: " + n);
        if (n >= 11 && n <= 13) {
            return "th";
        }
        int i2 = n % 10;
        if (i2 == 1) {
            return "st";
        }
        if (i2 == 2) {
            return "nd";
        }
        if (i2 != 3) {
            return "th";
        }
        return "rd";
    }

    public static TextDrawable GetDrawable(String text, Context context, String userid) {
        String strSubstring;
        if (!TextUtils.isEmpty(text) && !text.isEmpty()) {
            strSubstring = text.substring(0, 1);
        } else {
            strSubstring = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        }
        TextDrawable.IShapeBuilder iShapeBuilderBuilder = TextDrawable.builder();
        int[] iArr = Const.color;
        DbAdapter dbAdapter = DbAdapter.getInstance(context);
        if (TextUtils.isEmpty(userid)) {
            userid = "1";
        }
        return iShapeBuilderBuilder.buildRound(strSubstring, iArr[dbAdapter.getColor(userid).intValue()]);
    }

    public static ArrayList<Menu> getBottomMenu(List<BottomMenuTable> bottomMenu) {
        ArrayList<Menu> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < bottomMenu.size(); i2++) {
            if (bottomMenu.get(i2) != null) {
                arrayList.add(new Menu(bottomMenu.get(i2).getType(), "0", bottomMenu.get(i2).getTitle(), bottomMenu.get(i2).getTitle(), bottomMenu.get(i2).getType(), "0", 0, bottomMenu.get(i2).getIcon(), bottomMenu.get(i2).getParam_value(), new ArrayList()));
            }
        }
        return arrayList;
    }

    public static ArrayList<Menu> getLeftMenu(LeftMenu leftMenu, Context context) {
        com.appnew.android.home.Constants.is_offerPrice = leftMenu.getHide_offer_price();
        com.appnew.android.home.Constants.is_Show_Search = leftMenu.getIs_show_search();
        ArrayList<Menu> arrayList = new ArrayList<>();
        if (leftMenu.getDownloads().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("1", "0", context.getResources().getString(com.eduteria.app.app.R.string.download), context.getResources().getString(com.eduteria.app.app.R.string.download), "1", "0", com.eduteria.app.app.R.mipmap.ic_downloads, "1", new ArrayList()));
        }
        if (leftMenu.getCourse_group_chat().equalsIgnoreCase("1")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.Course_Chat, "0", context.getResources().getString(com.eduteria.app.app.R.string.chat), context.getResources().getString(com.eduteria.app.app.R.string.chat), Constants.LEFT_NAV_KEY.Course_Chat, "0", com.eduteria.app.app.R.drawable.chat, Constants.LEFT_NAV_KEY.Course_Chat, new ArrayList()));
        }
        if (!SharedPreference.getInstance().getBoolean("Expert_key")) {
            if (leftMenu.getAttendance_report().equalsIgnoreCase("1")) {
                arrayList.add(new Menu(Constants.LEFT_NAV_KEY.attendance_report, "0", context.getResources().getString(com.eduteria.app.app.R.string.attendance_report), context.getResources().getString(com.eduteria.app.app.R.string.attendance_report), Constants.LEFT_NAV_KEY.attendance_report, "0", com.eduteria.app.app.R.mipmap.attendance, Constants.LEFT_NAV_KEY.attendance_report, new ArrayList()));
            }
            if (SharedPreference.getInstance().getString(Const.cumulative_test_report).equalsIgnoreCase("1")) {
                arrayList.add(new Menu(Constants.LEFT_NAV_KEY.STUDENT_RESULT, "0", context.getResources().getString(com.eduteria.app.app.R.string.student_result), context.getResources().getString(com.eduteria.app.app.R.string.student_result), Constants.LEFT_NAV_KEY.STUDENT_RESULT, "0", com.eduteria.app.app.R.mipmap.attempted_result_screen, Constants.LEFT_NAV_KEY.STUDENT_RESULT, new ArrayList()));
            }
        }
        if (SharedPreference.getInstance().getBoolean("Expert_key")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.TEACHER_TIME_TABLE, "0", context.getResources().getString(com.eduteria.app.app.R.string.time_table), context.getResources().getString(com.eduteria.app.app.R.string.time_table), Constants.LEFT_NAV_KEY.TEACHER_TIME_TABLE, "0", com.eduteria.app.app.R.mipmap.ic_downloads, Constants.LEFT_NAV_KEY.TEACHER_TIME_TABLE, new ArrayList()));
        }
        if (SharedPreference.getInstance().getString(Const.notice_board).equalsIgnoreCase("1")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.NOTICE_BOARD, "0", context.getResources().getString(com.eduteria.app.app.R.string.notice_board), context.getResources().getString(com.eduteria.app.app.R.string.notice_board), Constants.LEFT_NAV_KEY.NOTICE_BOARD, "0", com.eduteria.app.app.R.mipmap.ic_downloads, Constants.LEFT_NAV_KEY.NOTICE_BOARD, new ArrayList()));
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("rankersGurukuls")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.LEFT_DOUBT, "0", "Doubt", context.getResources().getString(com.eduteria.app.app.R.string.notice_board), Constants.LEFT_NAV_KEY.LEFT_DOUBT, "0", com.eduteria.app.app.R.drawable.doubt_new, Constants.LEFT_NAV_KEY.LEFT_DOUBT, new ArrayList()));
        }
        if (leftMenu.getDownloads().equalsIgnoreCase("1") && BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.pdfDownload, "0", "PDF Downloads", "PDF Downloads", Constants.LEFT_NAV_KEY.pdfDownload, "0", com.eduteria.app.app.R.mipmap.ic_downloads, Constants.LEFT_NAV_KEY.pdfDownload, new ArrayList()));
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("DishaPublication")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.book_history, "0", "Book Purchase History", "Book Purchase History", Constants.LEFT_NAV_KEY.book_history, "0", com.eduteria.app.app.R.mipmap.book_magazine, Constants.LEFT_NAV_KEY.book_history, new ArrayList()));
        }
        if (leftMenu.getTest_scan().equalsIgnoreCase("1")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.test_scan, "0", "Scan Test QR", "Scan Test QR", Constants.LEFT_NAV_KEY.test_scan, "0", com.eduteria.app.app.R.mipmap.cam_scanner, Constants.LEFT_NAV_KEY.test_scan, new ArrayList()));
        }
        if (leftMenu.getCustom_payment().equalsIgnoreCase("1")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.custom_payment, "0", context.getResources().getString(com.eduteria.app.app.R.string.custom_payment), context.getResources().getString(com.eduteria.app.app.R.string.custom_payment), Constants.LEFT_NAV_KEY.custom_payment, "0", com.eduteria.app.app.R.drawable.ic_custom_payment, Constants.LEFT_NAV_KEY.custom_payment, new ArrayList()));
        }
        if (leftMenu.getBook_store().equalsIgnoreCase("1")) {
            if (BuildConfig.FLAVOR.equalsIgnoreCase("IBSStudyApp")) {
                arrayList.add(new Menu(Constants.LEFT_NAV_KEY.book_store, "0", "App Tutorial", "App Tutorial", Constants.LEFT_NAV_KEY.book_store, "0", com.eduteria.app.app.R.mipmap.book_store, Constants.LEFT_NAV_KEY.book_store, new ArrayList()));
            } else {
                arrayList.add(new Menu(Constants.LEFT_NAV_KEY.book_store, "0", context.getResources().getString(com.eduteria.app.app.R.string.book_store), context.getResources().getString(com.eduteria.app.app.R.string.book_store), Constants.LEFT_NAV_KEY.book_store, "0", com.eduteria.app.app.R.mipmap.book_store, Constants.LEFT_NAV_KEY.book_store, new ArrayList()));
            }
        }
        if (leftMenu.getCoursetransfer().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("18", "0", context.getResources().getString(com.eduteria.app.app.R.string.course_transfer), context.getResources().getString(com.eduteria.app.app.R.string.course_transfer), "18", "0", com.eduteria.app.app.R.mipmap.ic_storage_usage, "18", new ArrayList()));
        }
        if (leftMenu.getCoupon().equalsIgnoreCase("1") && SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE) != null && SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).length() > 0 && !SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("0")) {
            arrayList.add(new Menu("20", "0", context.getResources().getString(com.eduteria.app.app.R.string.coupons), context.getResources().getString(com.eduteria.app.app.R.string.coupons), "20", "0", com.eduteria.app.app.R.mipmap.coupon_default, "20", new ArrayList()));
        }
        if (leftMenu.getUsagehistory().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("3", "0", context.getResources().getString(com.eduteria.app.app.R.string.usage_history), context.getResources().getString(com.eduteria.app.app.R.string.usage_history), "3", "0", com.eduteria.app.app.R.mipmap.ic_usage_history, "3", new ArrayList()));
        }
        if (leftMenu.getPurchasehistory().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("15", "0", context.getResources().getString(com.eduteria.app.app.R.string.purchase_history), context.getResources().getString(com.eduteria.app.app.R.string.purchase_history), "15", "0", com.eduteria.app.app.R.mipmap.ic_purchase_history, "15", new ArrayList()));
        }
        if (leftMenu.getTest_report().equalsIgnoreCase("1")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.testReport, "0", context.getResources().getString(com.eduteria.app.app.R.string.test_report), context.getResources().getString(com.eduteria.app.app.R.string.purchase_history), Constants.LEFT_NAV_KEY.testReport, "0", com.eduteria.app.app.R.mipmap.ic_purchase_history, Constants.LEFT_NAV_KEY.testReport, new ArrayList()));
        }
        if (leftMenu.getInvitefriends().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("6", "0", context.getResources().getString(com.eduteria.app.app.R.string.invite_friends), context.getResources().getString(com.eduteria.app.app.R.string.invite_friends), "6", "0", com.eduteria.app.app.R.mipmap.ic_invite_friends, "6", new ArrayList()));
        }
        if (leftMenu.getUser_preference().equalsIgnoreCase("1")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.change_preference, "0", context.getResources().getString(com.eduteria.app.app.R.string.change_preference), context.getResources().getString(com.eduteria.app.app.R.string.logout), Constants.LEFT_NAV_KEY.change_preference, "0", com.eduteria.app.app.R.mipmap.change_course, Constants.LEFT_NAV_KEY.change_preference, new ArrayList()));
        }
        if (leftMenu.getContactus().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("5", "0", context.getResources().getString(com.eduteria.app.app.R.string.contact_us), context.getResources().getString(com.eduteria.app.app.R.string.contact_us), "5", "0", com.eduteria.app.app.R.mipmap.ic_contact_us, "5", new ArrayList()));
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("tradeWithHiren")) {
            if (leftMenu.getContact_us_query().equalsIgnoreCase("1")) {
                arrayList.add(new Menu(Constants.LEFT_NAV_KEY.contact_us_query, "0", context.getResources().getString(com.eduteria.app.app.R.string.contact_us), context.getResources().getString(com.eduteria.app.app.R.string.inquiry), Constants.LEFT_NAV_KEY.contact_us_query, "0", com.eduteria.app.app.R.mipmap.ic_contact_us, Constants.LEFT_NAV_KEY.contact_us_query, new ArrayList()));
            }
        } else if (leftMenu.getContact_us_query().equalsIgnoreCase("1")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.contact_us_query, "0", context.getResources().getString(com.eduteria.app.app.R.string.inquiry), context.getResources().getString(com.eduteria.app.app.R.string.inquiry), Constants.LEFT_NAV_KEY.contact_us_query, "0", com.eduteria.app.app.R.mipmap.inquiry_act, Constants.LEFT_NAV_KEY.contact_us_query, new ArrayList()));
        }
        if (leftMenu.getSettings().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("21", "0", context.getResources().getString(com.eduteria.app.app.R.string.privacy_policy_text), context.getResources().getString(com.eduteria.app.app.R.string.privacy_policy_text), "21", "0", com.eduteria.app.app.R.mipmap.privacy_policy_setting, "21", new ArrayList()));
        }
        if (leftMenu.getSettings().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("10", "0", context.getResources().getString(com.eduteria.app.app.R.string.term_of_service_text), context.getResources().getString(com.eduteria.app.app.R.string.term_of_service_text), "10", "0", com.eduteria.app.app.R.mipmap.terms_setting, "10", new ArrayList()));
        }
        if (!BuildConfig.FLAVOR.equalsIgnoreCase("tradeWithHiren") && leftMenu.getSettings().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("11", "0", context.getResources().getString(com.eduteria.app.app.R.string.rate_us), context.getResources().getString(com.eduteria.app.app.R.string.rate_us), "11", "0", com.eduteria.app.app.R.mipmap.review_setting, "11", new ArrayList()));
        }
        if (leftMenu.getFeedback().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("22", "0", Const.FEEDBACK, Const.FEEDBACK, "22", "0", com.eduteria.app.app.R.mipmap.review_setting, "22", new ArrayList()));
        }
        if (leftMenu.getCurrent_affair().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("25", "0", "Current Affair", "Current Affair", "25", "0", BuildConfig.FLAVOR.equalsIgnoreCase("ICSHomework") ? com.eduteria.app.app.R.mipmap.current_affairs : com.eduteria.app.app.R.mipmap.review_setting, "25", new ArrayList()));
        }
        if (leftMenu.getUser_support().equalsIgnoreCase("1")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.user_support, "0", "User Support", "User Support", Constants.LEFT_NAV_KEY.user_support, "0", com.eduteria.app.app.R.drawable.user_support, Constants.LEFT_NAV_KEY.user_support, new ArrayList()));
        }
        if (leftMenu.getBook_mark().equalsIgnoreCase("1")) {
            arrayList.add(new Menu(Constants.LEFT_NAV_KEY.bookmark, "0", "Bookmark", "Bookmark", Constants.LEFT_NAV_KEY.bookmark, "0", com.eduteria.app.app.R.drawable.ic_bookmark, Constants.LEFT_NAV_KEY.bookmark, new ArrayList()));
        }
        if (leftMenu.getFaq().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("4", "0", "FAQ", "FAQ", "4", "0", com.eduteria.app.app.R.mipmap.terms_setting, "4", new ArrayList()));
        }
        if (leftMenu.getLogout().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("9", "0", context.getResources().getString(com.eduteria.app.app.R.string.logout), context.getResources().getString(com.eduteria.app.app.R.string.logout), "9", "0", com.eduteria.app.app.R.mipmap.ic_log_out, "9", new ArrayList()));
        }
        return arrayList;
    }

    public static ArrayList<Menu> getSmeLeftMenu(ExpertLeftMenu leftMenu, Context context) {
        ArrayList<Menu> arrayList = new ArrayList<>();
        if (leftMenu.getContactus().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("7", "0", "Contactus", "Contactus", "7", "0", com.eduteria.app.app.R.drawable.user_support, "7", new ArrayList()));
        }
        if (leftMenu.getReports().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("8", "0", "Reports", "Reports", "8", "0", com.eduteria.app.app.R.drawable.user_support, "8", new ArrayList()));
        }
        if (leftMenu.getLogout().equalsIgnoreCase("1")) {
            arrayList.add(new Menu("9", "0", context.getResources().getString(com.eduteria.app.app.R.string.logout), context.getResources().getString(com.eduteria.app.app.R.string.logout), "9", "0", com.eduteria.app.app.R.mipmap.ic_log_out, "9", new ArrayList()));
        }
        return arrayList;
    }

    public static ArrayList<Menu> getLeftMenu() {
        ArrayList<Menu> arrayList = new ArrayList<>();
        if (!"1".equalsIgnoreCase("1")) {
            if (!"1".equalsIgnoreCase("2")) {
                if (!"1".equalsIgnoreCase("3")) {
                    if ("1".equalsIgnoreCase("4")) {
                        arrayList.add(new Menu("1", "0", "Downloads", "Downloads", "1", "0", com.eduteria.app.app.R.mipmap.ic_downloads, "1", new ArrayList()));
                        if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE) != null && SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).length() > 0 && !SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("0")) {
                            arrayList.add(new Menu("20", "0", "Coupon", "Coupon", "20", "0", com.eduteria.app.app.R.mipmap.coupon_default, "20", new ArrayList()));
                        }
                        arrayList.add(new Menu("3", "0", "Usage History", "Usage History", "3", "0", com.eduteria.app.app.R.mipmap.ic_usage_history, "3", new ArrayList()));
                        arrayList.add(new Menu("15", "0", "Purchase History", "Purchase History", "15", "0", com.eduteria.app.app.R.mipmap.ic_purchase_history, "15", new ArrayList()));
                        arrayList.add(new Menu("6", "0", "Invite Friends", "Invite Friends", "6", "0", com.eduteria.app.app.R.mipmap.ic_invite_friends, "6", new ArrayList()));
                        arrayList.add(new Menu("5", "0", "Contact Us", "Contact Us", "5", "0", com.eduteria.app.app.R.mipmap.ic_contact_us, "5", new ArrayList()));
                        if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
                            arrayList.add(new Menu("16", "0", "App Tutorial", "App Tutorial", "16", "0", com.eduteria.app.app.R.mipmap.ic_app_tutorial, "16", new ArrayList()));
                            arrayList.add(new Menu("19", "0", "Chat with us", "Chat with us", "9", "0", com.eduteria.app.app.R.mipmap.chatbot1, "19", new ArrayList()));
                            arrayList.add(new Menu("14", "0", "Offline Batch", "Offline Batch", "14", "0", com.eduteria.app.app.R.mipmap.ic_offline_batch, "14", new ArrayList()));
                            arrayList.add(new Menu("4", "0", "FAQ", "FAQ", "4", "0", com.eduteria.app.app.R.mipmap.ic_faq, "4", new ArrayList()));
                        }
                        arrayList.add(new Menu("8", "0", "Settings", "Settings", "8", "0", com.eduteria.app.app.R.mipmap.ic_settings, "8", new ArrayList()));
                        arrayList.add(new Menu("9", "0", Const.LOGOUT, Const.LOGOUT, "9", "0", com.eduteria.app.app.R.mipmap.ic_log_out, "9", new ArrayList()));
                    }
                    return arrayList;
                }
                arrayList.add(new Menu("1", "0", "Downloads", "Downloads", "1", "0", com.eduteria.app.app.R.mipmap.ic_downloads, "1", new ArrayList()));
                arrayList.add(new Menu("18", "0", "Course Transfer", "Course Transfer", "18", "0", com.eduteria.app.app.R.mipmap.ic_storage_usage, "18", new ArrayList()));
                if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE) != null && SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).length() > 0 && !SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("0")) {
                    arrayList.add(new Menu("20", "0", "Coupon", "Coupon", "20", "0", com.eduteria.app.app.R.mipmap.coupon_default, "20", new ArrayList()));
                }
                arrayList.add(new Menu("3", "0", "Usage History", "Usage History", "3", "0", com.eduteria.app.app.R.mipmap.ic_usage_history, "3", new ArrayList()));
                arrayList.add(new Menu("15", "0", "Purchase History", "Purchase History", "15", "0", com.eduteria.app.app.R.mipmap.ic_purchase_history, "15", new ArrayList()));
                arrayList.add(new Menu("6", "0", "Invite Friends", "Invite Friends", "6", "0", com.eduteria.app.app.R.mipmap.ic_invite_friends, "6", new ArrayList()));
                arrayList.add(new Menu("5", "0", "Contact Us", "Contact Us", "5", "0", com.eduteria.app.app.R.mipmap.ic_contact_us, "5", new ArrayList()));
                if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
                    arrayList.add(new Menu("16", "0", "App Tutorial", "App Tutorial", "16", "0", com.eduteria.app.app.R.mipmap.ic_app_tutorial, "16", new ArrayList()));
                    arrayList.add(new Menu("19", "0", "Chat with us", "Chat with us", "9", "0", com.eduteria.app.app.R.mipmap.chatbot1, "19", new ArrayList()));
                    arrayList.add(new Menu("14", "0", "Offline Batch", "Offline Batch", "14", "0", com.eduteria.app.app.R.mipmap.ic_offline_batch, "14", new ArrayList()));
                    arrayList.add(new Menu("4", "0", "FAQ", "FAQ", "4", "0", com.eduteria.app.app.R.mipmap.ic_faq, "4", new ArrayList()));
                }
                arrayList.add(new Menu("8", "0", "Settings", "Settings", "8", "0", com.eduteria.app.app.R.mipmap.ic_settings, "8", new ArrayList()));
                arrayList.add(new Menu("9", "0", Const.LOGOUT, Const.LOGOUT, "9", "0", com.eduteria.app.app.R.mipmap.ic_log_out, "9", new ArrayList()));
                return arrayList;
            }
            if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE) != null && SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).length() > 0 && !SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("0")) {
                arrayList.add(new Menu("20", "0", "Coupon", "Coupon", "20", "0", com.eduteria.app.app.R.mipmap.coupon_default, "20", new ArrayList()));
            }
            arrayList.add(new Menu("15", "0", "Purchase History", "Purchase History", "15", "0", com.eduteria.app.app.R.mipmap.ic_purchase_history, "15", new ArrayList()));
            arrayList.add(new Menu("6", "0", "Invite Friends", "Invite Friends", "6", "0", com.eduteria.app.app.R.mipmap.ic_invite_friends, "6", new ArrayList()));
            arrayList.add(new Menu("5", "0", "Contact Us", "Contact Us", "5", "0", com.eduteria.app.app.R.mipmap.ic_contact_us, "5", new ArrayList()));
            if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
                arrayList.add(new Menu("16", "0", "App Tutorial", "App Tutorial", "16", "0", com.eduteria.app.app.R.mipmap.ic_app_tutorial, "16", new ArrayList()));
                arrayList.add(new Menu("19", "0", "Chat with us", "Chat with us", "9", "0", com.eduteria.app.app.R.mipmap.chatbot1, "19", new ArrayList()));
                arrayList.add(new Menu("14", "0", "Offline Batch", "Offline Batch", "14", "0", com.eduteria.app.app.R.mipmap.ic_offline_batch, "14", new ArrayList()));
                arrayList.add(new Menu("4", "0", "FAQ", "FAQ", "4", "0", com.eduteria.app.app.R.mipmap.ic_faq, "4", new ArrayList()));
            }
            arrayList.add(new Menu("8", "0", "Settings", "Settings", "8", "0", com.eduteria.app.app.R.mipmap.ic_settings, "8", new ArrayList()));
            arrayList.add(new Menu("9", "0", Const.LOGOUT, Const.LOGOUT, "9", "0", com.eduteria.app.app.R.mipmap.ic_log_out, "9", new ArrayList()));
            return arrayList;
        }
        if (!"166".equalsIgnoreCase("116") && !"166".equalsIgnoreCase("106")) {
            arrayList.add(new Menu("1", "0", "Downloads", "Downloads", "1", "0", com.eduteria.app.app.R.mipmap.ic_downloads, "1", new ArrayList()));
        }
        if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE) != null && SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).length() > 0 && !SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("0")) {
            arrayList.add(new Menu("20", "0", "Coupon", "Coupon", "20", "0", com.eduteria.app.app.R.mipmap.coupon_default, "20", new ArrayList()));
        }
        if (!"166".equalsIgnoreCase("116") && !"166".equalsIgnoreCase("106")) {
            arrayList.add(new Menu("3", "0", "Usage History", "Usage History", "3", "0", com.eduteria.app.app.R.mipmap.ic_usage_history, "3", new ArrayList()));
        }
        arrayList.add(new Menu("15", "0", "Purchase History", "Purchase History", "15", "0", com.eduteria.app.app.R.mipmap.ic_purchase_history, "15", new ArrayList()));
        arrayList.add(new Menu("6", "0", "Invite Friends", "Invite Friends", "6", "0", com.eduteria.app.app.R.mipmap.ic_invite_friends, "6", new ArrayList()));
        arrayList.add(new Menu("5", "0", "Contact Us", "Contact Us", "5", "0", com.eduteria.app.app.R.mipmap.ic_contact_us, "5", new ArrayList()));
        if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
            arrayList.add(new Menu("16", "0", "App Tutorial", "App Tutorial", "16", "0", com.eduteria.app.app.R.mipmap.ic_app_tutorial, "16", new ArrayList()));
            arrayList.add(new Menu("19", "0", "Chat with us", "Chat with us", "9", "0", com.eduteria.app.app.R.mipmap.chatbot1, "19", new ArrayList()));
            arrayList.add(new Menu("14", "0", "Offline Batch", "Offline Batch", "14", "0", com.eduteria.app.app.R.mipmap.ic_offline_batch, "14", new ArrayList()));
            arrayList.add(new Menu("4", "0", "FAQ", "FAQ", "4", "0", com.eduteria.app.app.R.mipmap.ic_faq, "4", new ArrayList()));
        }
        arrayList.add(new Menu("8", "0", "Settings", "Settings", "8", "0", com.eduteria.app.app.R.mipmap.ic_settings, "8", new ArrayList()));
        arrayList.add(new Menu("9", "0", Const.LOGOUT, Const.LOGOUT, "9", "0", com.eduteria.app.app.R.mipmap.ic_log_out, "9", new ArrayList()));
        arrayList.add(new Menu(Constants.LEFT_NAV_KEY.custom_payment, "0", "Custom Payment", "Custom Payment", Constants.LEFT_NAV_KEY.custom_payment, "0", com.eduteria.app.app.R.drawable.ic_custom_payment, Constants.LEFT_NAV_KEY.custom_payment, new ArrayList()));
        return arrayList;
    }

    public static void GoToVideoCryptActivity(Activity activity, String tokon, String user_ID, String deviceID, String videotype, String chatnode, String Url, String islive, String vid, String title, String is_audio, String thubnail, String course_id, String tileid, String tiletype, String islocked, String pos, String parentid, String bookmark, ArrayList<Video> videoArrayList) {
        Intent intent = new Intent(activity, (Class<?>) VODPlayerActivity.class);
        intent.putExtra("vcd_id", tokon);
        intent.putExtra(SDKConstants.PARAM_USER_ID, user_ID);
        intent.putExtra(Column.DEVICE_ID, deviceID);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra(Const.VIDEO_TYPE, videotype);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("courseid", course_id);
        intent.putExtra("islocked", islocked);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra(com.clevertap.android.sdk.Constants.INAPP_POSITION, pos);
        intent.putExtra("bookmark", bookmark);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static void GoToVODPlayerActivity(Activity activity, String tokon, String user_ID, String deviceID, String videotype, String chatnode, String Url, String islive, String vid, String title, String is_audio, String thubnail, String course_id, String tileid, String tiletype, String islocked, String pos, String parentid, String startTime, String bookmark, ArrayList<Video> videoArrayList, String quality, int position) {
        Intent intent = new Intent(activity, (Class<?>) VODPlayerActivity.class);
        intent.putExtra(Const.RESOLUTION, quality);
        intent.putExtra(Const.RESOLUTION_POSITION, position);
        intent.putExtra("vcd_id", tokon);
        intent.putExtra(SDKConstants.PARAM_USER_ID, user_ID);
        intent.putExtra(Column.DEVICE_ID, deviceID);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra(Const.VIDEO_TYPE, videotype);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("courseid", course_id);
        intent.putExtra("islocked", islocked);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra(com.clevertap.android.sdk.Constants.INAPP_POSITION, pos);
        intent.putExtra("start_time", startTime);
        intent.putExtra("bookmark", bookmark);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static void GoToVideoCryptActivity(final Activity activity, final String tokon, final String user_ID, final String deviceID, final String videotype, final String chatnode, final String Url, final String islive, final String vid, final String title, final String is_audio, final String thubnail, final String course_id, final String tileid, final String tiletype, final String islocked, final String pos, final String parentid, final String startTime, final String bookmark, final ArrayList<Video> videoArrayList) {
        if (videoArrayList.get(Integer.parseInt(pos)).getIs_live().equalsIgnoreCase("1")) {
            GoToVODPlayerActivity(activity, tokon, user_ID, deviceID, videotype, chatnode, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, startTime, bookmark, videoArrayList, "", 0);
            return;
        }
        if (videoArrayList.get(Integer.parseInt(pos)).getBitrate_urls() != null && SharedPreference.getInstance().getString(Const.BITRATE_SELECTION).equalsIgnoreCase("1")) {
            final Dialog dialog2 = new Dialog(activity);
            dialog2.setContentView(com.eduteria.app.app.R.layout.custom_quality_dialog);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog2.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            int i2 = 0;
            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            RecyclerView recyclerView = (RecyclerView) dialog2.findViewById(com.eduteria.app.app.R.id.qualityRecycler);
            ProgressBar progressBar2 = (ProgressBar) dialog2.findViewById(com.eduteria.app.app.R.id.qualityProgressBar);
            ArrayList arrayList = new ArrayList();
            while (true) {
                i = i2;
                if (i < videoArrayList.get(Integer.parseInt(pos)).getBitrate_urls().size()) {
                    arrayList.add("REXO=x" + videoArrayList.get(Integer.parseInt(pos)).getBitrate_urls().get(i).getTitle().replace("p", ""));
                    i2 = i + 1;
                } else {
                    recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                    QualityAdapter qualityAdapter = new QualityAdapter(activity, arrayList, new QualityAdapter.OnItemClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda33
                        @Override // com.appnew.android.Utils.Helper.QualityAdapter.OnItemClickListener
                        public final void onItemClick(String str, int i3) {
                            Helper.lambda$GoToVideoCryptActivity$27(activity, tokon, user_ID, deviceID, videotype, chatnode, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, startTime, bookmark, videoArrayList, dialog2, str, i3);
                        }
                    });
                    progressBar2.setVisibility(8);
                    recyclerView.setAdapter(qualityAdapter);
                    dialog2.show();
                    return;
                }
            }
        } else {
            GoToVODPlayerActivity(activity, tokon, user_ID, deviceID, videotype, chatnode, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, startTime, bookmark, videoArrayList, "", 0);
        }
    }

    static /* synthetic */ void lambda$GoToVideoCryptActivity$27(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, ArrayList arrayList, Dialog dialog2, String str20, int i2) {
        GoToVODPlayerActivity(activity, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, arrayList, str20, i2);
        dialog2.dismiss();
    }

    public static void GoToDumVODPlayerActivity(Activity activity, String tokon, String user_ID, String deviceID, String videotype, String chatnode, String Url, String islive, String vid, String title, String is_audio, String thubnail, String course_id, String tileid, String tiletype, String islocked, String pos, String parentid, String startTime, String bookmark, ArrayList<Datum> videoArrayList) {
        Intent intent = new Intent(activity, (Class<?>) VODPlayerActivity.class);
        intent.putExtra("vcd_id", tokon);
        intent.putExtra(SDKConstants.PARAM_USER_ID, user_ID);
        intent.putExtra(Column.DEVICE_ID, deviceID);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra(Const.VIDEO_TYPE, videotype);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("courseid", course_id);
        intent.putExtra("islocked", islocked);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra(com.clevertap.android.sdk.Constants.INAPP_POSITION, pos);
        intent.putExtra("start_time", startTime);
        intent.putExtra("bookmark", bookmark);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static void GoToDumVideoCryptActivity(final Activity activity, final String tokon, final String user_ID, final String deviceID, final String videotype, final String chatnode, final String Url, final String islive, final String vid, final String title, final String is_audio, final String thubnail, final String course_id, final String tileid, final String tiletype, final String islocked, final String pos, final String parentid, final String startTime, final String bookmark, final ArrayList<Datum> videoArrayList) {
        if (videoArrayList.get(Integer.parseInt(pos)).getIs_live().equalsIgnoreCase("1")) {
            GoToDumVODPlayerActivity(activity, tokon, user_ID, deviceID, videotype, chatnode, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, startTime, bookmark, videoArrayList);
            return;
        }
        ArrayList<UrlObject> bitrate_urls = videoArrayList.get(Integer.parseInt(pos)).getBitrate_urls();
        if (SharedPreference.getInstance().getString(Const.BITRATE_SELECTION).equalsIgnoreCase("1") && bitrate_urls != null && !bitrate_urls.isEmpty()) {
            final Dialog dialog2 = new Dialog(activity);
            dialog2.setContentView(com.eduteria.app.app.R.layout.custom_quality_dialog);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialog2.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            RecyclerView recyclerView = (RecyclerView) dialog2.findViewById(com.eduteria.app.app.R.id.qualityRecycler);
            ProgressBar progressBar2 = (ProgressBar) dialog2.findViewById(com.eduteria.app.app.R.id.qualityProgressBar);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < bitrate_urls.size(); i2++) {
                arrayList.add("REXO=x" + bitrate_urls.get(i2).getTitle().replace("p", ""));
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            QualityAdapter qualityAdapter = new QualityAdapter(activity, arrayList, new QualityAdapter.OnItemClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda11
                @Override // com.appnew.android.Utils.Helper.QualityAdapter.OnItemClickListener
                public final void onItemClick(String str, int i3) {
                    Helper.lambda$GoToDumVideoCryptActivity$28(activity, tokon, user_ID, deviceID, videotype, chatnode, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, startTime, bookmark, videoArrayList, dialog2, str, i3);
                }
            });
            progressBar2.setVisibility(8);
            recyclerView.setAdapter(qualityAdapter);
            dialog2.show();
            return;
        }
        GoToDumVODPlayerActivity(activity, tokon, user_ID, deviceID, videotype, chatnode, Url, islive, vid, title, is_audio, thubnail, course_id, tileid, tiletype, islocked, pos, parentid, startTime, bookmark, videoArrayList);
    }

    static /* synthetic */ void lambda$GoToDumVideoCryptActivity$28(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, ArrayList arrayList, Dialog dialog2, String str20, int i2) {
        GoToDumVODPlayerActivity(activity, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, arrayList);
        dialog2.dismiss();
    }

    public static boolean IsValidUrl(String urlString) {
        try {
            new URL(urlString);
            if (URLUtil.isValidUrl(urlString)) {
                if (Patterns.WEB_URL.matcher(urlString).matches()) {
                    return true;
                }
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    public static String getTextFromEditText(EditText editText) {
        try {
            String strTrim = editText.getText().toString().trim();
            if (!TextUtils.isEmpty(strTrim)) {
                if (!strTrim.equalsIgnoreCase("")) {
                    return strTrim;
                }
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean checkMobileNumber(String mobile) {
        return Patterns.PHONE.matcher(mobile).matches() && mobile.length() == 10 && !isInValidIndianMobile(mobile);
    }

    public static boolean isNullChek(String msg) {
        return (msg == null || TextUtils.isEmpty(msg)) ? false : true;
    }

    public static int converToIntCountryCode(String cCode) {
        if (cCode == null || cCode.equalsIgnoreCase("")) {
            return 0;
        }
        try {
            return Integer.parseInt(cCode.replace(MqttTopic.SINGLE_LEVEL_WILDCARD, ""));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void enableErrorInTextview(TextView errorText, String msg) {
        if (msg != null && !msg.equalsIgnoreCase("")) {
            errorText.setError(msg);
            errorText.setTextColor(SupportMenu.CATEGORY_MASK);
            errorText.requestFocus();
            return;
        }
        errorText.setError(null);
    }

    public static void buildDialogNoInternet(final Activity activity) {
        try {
            DialogUtils.makeDialog(activity, activity.getResources().getString(com.eduteria.app.app.R.string.app_name), activity.getResources().getString(com.eduteria.app.app.R.string.internet_connection_not_available), activity.getResources().getString(com.eduteria.app.app.R.string.yes), activity.getResources().getString(com.eduteria.app.app.R.string.no), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.Helper.28
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public void onOKClick() {
                    if (Build.VERSION.SDK_INT >= 29) {
                        activity.startActivity(new Intent("android.settings.panel.action.INTERNET_CONNECTIVITY"));
                    } else {
                        activity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                    }
                    activity.finish();
                }
            }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Utils.Helper.29
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
                public void onCancelClick() {
                    activity.finish();
                }
            });
        } catch (Exception unused) {
        }
    }

    public static void openWhatsapp(Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wa.me/" + ((LeftMenu) new Gson().fromJson(UtkashRoom.getAppDatabase(context).getthemeSettingdao().data().getLeft_menu(), LeftMenu.class)).getMobile_number())));
    }

    public static void doCheck(Context activity) {
        final boolean[] zArr = {false};
        LicenseChecker licenseChecker = new LicenseChecker(activity, new ServerManagedPolicy(activity, new AESObfuscator(SALT, activity.getPackageName(), Settings.Secure.getString(activity.getContentResolver(), "android_id"))), "".trim());
        mChecker = licenseChecker;
        licenseChecker.checkAccess(new LicenseCheckerCallback() { // from class: com.appnew.android.Utils.Helper.30
            @Override // com.google.android.vending.licensing.LicenseCheckerCallback
            public void allow(int reason) {
                MakeMyExam.lvlresponse = true;
                zArr[0] = true;
            }

            @Override // com.google.android.vending.licensing.LicenseCheckerCallback
            public void dontAllow(int reason) {
                MakeMyExam.lvlresponse = false;
                zArr[0] = false;
            }

            @Override // com.google.android.vending.licensing.LicenseCheckerCallback
            public void applicationError(int errorCode) {
                MakeMyExam.lvlresponse = false;
                zArr[0] = false;
            }
        });
    }

    public static String getHtmlText(String fonePayUrl) {
        return fonePayUrl.replace("\\/", MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static boolean isValidGSTNo(String str) {
        Pattern patternCompile = Pattern.compile("^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$");
        if (str == null) {
            return false;
        }
        return patternCompile.matcher(str).matches();
    }

    public static class PaymentModeAdapter extends RecyclerView.Adapter<ViewHolder> {
        Context context;
        private ViewHolder holderTemp;
        ArrayList<JsonObject> paymentModeList;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        public PaymentModeAdapter(Context activity, ArrayList<JsonObject> coursesDataArrayList) {
            this.context = activity;
            this.paymentModeList = coursesDataArrayList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(com.eduteria.app.app.R.layout.paymentmode_child, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final ViewHolder sholder, final int position) {
            sholder.rb_mode.setText(this.paymentModeList.get(position).get("mode_name").getAsString());
            if (position == 0) {
                this.holderTemp = sholder;
                sholder.rb_mode.setChecked(true);
                Helper.paymenttype = this.paymentModeList.get(position).get("name").getAsString();
            } else {
                sholder.rb_mode.setChecked(false);
            }
            sholder.rb_mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.Utils.Helper.PaymentModeAdapter.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        if (PaymentModeAdapter.this.holderTemp != null) {
                            PaymentModeAdapter.this.holderTemp.rb_mode.setChecked(false);
                        }
                        PaymentModeAdapter.this.holderTemp = sholder;
                        Helper.paymenttype = PaymentModeAdapter.this.paymentModeList.get(position).get("name").getAsString();
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.paymentModeList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public RadioButton rb_mode;

            public ViewHolder(View itemView) {
                super(itemView);
                this.rb_mode = (RadioButton) itemView.findViewById(com.eduteria.app.app.R.id.rb_mode);
            }
        }
    }

    public static boolean isBehindLiveWindow(PlaybackException e2) {
        if (e2.errorCode != 0) {
            return false;
        }
        for (Throwable cause = e2.getCause(); cause != null; cause = cause.getCause()) {
            if (cause instanceof BehindLiveWindowException) {
                return true;
            }
        }
        return false;
    }

    public static void facebookCustomEventUser(Context context, String userId, String userName) {
        try {
            AppEventsLogger appEventsLoggerNewLogger = AppEventsLogger.newLogger(context);
            Bundle bundle = new Bundle();
            bundle.putString("userId", userId);
            bundle.putString("userName", userName);
            appEventsLoggerNewLogger.logEvent("AndroidUserRegisterDetails", bundle);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void facebookCustomEvent(Context context, Bundle bundle) {
        try {
            AppEventsLogger.newLogger(context).logEvent("AndroidUserRegisterDetails", bundle);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String getLoggedInUserInfo(Context context) {
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        return "userId=" + ((loggedInUser == null || loggedInUser.getId() == null) ? "unknown_user" : loggedInUser.getId()) + ", userName=" + ((loggedInUser == null || loggedInUser.getName() == null) ? "unknown_user_name" : loggedInUser.getName()) + ", userMobile=" + ((loggedInUser == null || loggedInUser.getMobile() == null) ? "unknown_user_mobile" : loggedInUser.getMobile()) + ", userEmail=" + ((loggedInUser == null || loggedInUser.getEmail() == null) ? "unknown_user_email" : loggedInUser.getEmail());
    }

    public static ArrayList<MasterCat> createPreferencesFromMasterCat(ArrayList<MasterCat> masterCatList, ArrayList<MasteAllCatTable> masterAllCatTables) {
        ArrayList arrayList = new ArrayList();
        for (MasterCat masterCat : masterCatList) {
            Iterator<MasteAllCatTable> it = masterAllCatTables.iterator();
            while (true) {
                if (it.hasNext()) {
                    MasteAllCatTable next = it.next();
                    if (next.getMaster_type().equals(masterCat.getId()) && next.getParent_id().equals("0")) {
                        arrayList.add(next);
                        break;
                    }
                }
            }
        }
        ArrayList<MasterCat> arrayList2 = new ArrayList<>();
        if (arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String id = ((MasteAllCatTable) it2.next()).getId();
                Iterator<MasteAllCatTable> it3 = masterAllCatTables.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        MasteAllCatTable next2 = it3.next();
                        if (id.equals(next2.getParent_id())) {
                            for (MasterCat masterCat2 : masterCatList) {
                                if (next2.getMaster_type().equals(masterCat2.getId())) {
                                    arrayList2.add(masterCat2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    public static boolean isValidAadhaarNumber(String str) {
        Pattern patternCompile = Pattern.compile("^[2-9][0-9]{11}$");
        if (str == null) {
            return false;
        }
        return patternCompile.matcher(str).matches();
    }

    public static void applyPrimaryColorLight(Context context, View view, float cornerRadiusDp, int drawableResId) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int iBlendARGB = ColorUtils.blendARGB(typedValue.data, -1, 0.9f);
        float f2 = cornerRadiusDp * context.getResources().getDisplayMetrics().density;
        GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(context, drawableResId);
        if (gradientDrawable != null) {
            gradientDrawable.setColor(iBlendARGB);
            gradientDrawable.setCornerRadius(f2);
            view.setBackground(gradientDrawable);
        }
    }

    public static void setBackgroundShapeColor(Context context, View view, float cornerRadiusDp, int drawableResId, int color) {
        int iBlendARGB = ColorUtils.blendARGB(color, -1, 0.9f);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(color);
        }
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = cornerRadiusDp * f2;
        int i2 = (int) (f2 * 2.0f);
        GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(context, drawableResId);
        if (gradientDrawable != null) {
            gradientDrawable.setColor(iBlendARGB);
            gradientDrawable.setCornerRadius(f3);
            gradientDrawable.setStroke(i2, color);
            view.setBackground(gradientDrawable);
        }
    }

    public static boolean isTrishulThemeNew() {
        return BuildConfig.FLAVOR.equalsIgnoreCase("trishulDefenceAcademy") || BuildConfig.FLAVOR.equalsIgnoreCase("guru365") || BuildConfig.FLAVOR.equalsIgnoreCase("examwarriorNew") || BuildConfig.FLAVOR.equalsIgnoreCase("GuidanceGuru") || BuildConfig.FLAVOR.equalsIgnoreCase("rela");
    }

    public static boolean isTricksWale() {
        return BuildConfig.FLAVOR.equalsIgnoreCase("tricksWale");
    }

    public static boolean isIkipUI() {
        return BuildConfig.FLAVOR.equalsIgnoreCase("ikip") || BuildConfig.FLAVOR.equalsIgnoreCase("pateltutorial") || BuildConfig.FLAVOR.equalsIgnoreCase("Lawlegends") || BuildConfig.FLAVOR.equalsIgnoreCase("patelsirclasses") || BuildConfig.FLAVOR.equalsIgnoreCase("defenceclasseslucknow");
    }

    public static boolean isWindowsPrimary() {
        return BuildConfig.FLAVOR.equals("pateltutorial") || BuildConfig.FLAVOR.equals("patelsirclasses") || BuildConfig.FLAVOR.equals("Lawlegends") || BuildConfig.FLAVOR.equals("defenceclasseslucknow");
    }

    public static boolean isToolbarBackgroundTrans() {
        return BuildConfig.FLAVOR.equals("defenceclasseslucknow");
    }

    public static void testQuestionFont(ClickableWebView tvQuestion, int position, String htmlAsString, String fontType) {
        String str;
        if (fontType.equalsIgnoreCase("2")) {
            str = "<html><head>  <style type=\"text/css\">\n        @font-face {\n            font-family:Symbol;\n            src: url(\"file:///android_asset/fonts/symbol.ttf\")\n        }\n        @font-face {\n            font-family:Narad;\n            src: url(\"file:///android_asset/fonts/Narad.ttf\")\n        }\n        @font-face {\n            font-family:Walkman-Chanakya-901;\n            src: url(\"file:///android_asset/fonts/CHANAKYA.ttf\")\n        }\n        body {\n           \n            font-size: medium;\n            text-align: justify;\n        }\n        .Narad {\n            font-family:Narad;\n        }\n    </style></head><body>";
        } else {
            str = "<html><head>  <style type=\"text/css\">\n        @font-face {\n            font-family:Kruti dev 010;\n            src: url(\"file:///android_asset/fonts/kruti_dev.ttf\")\n        }\n        body {\n           \n            font-size: medium;\n            text-align: justify;\n        }\n        .kruti_dev {\n            font-family: Kruti dev 010;\n        }\n    </style></head><body>";
        }
        TestWebHTMLLoad(tvQuestion, "Q-" + (position + 1) + " " + str + htmlAsString.replace(StringUtils.LT_ENCODE, "<").replace(StringUtils.GT_ENCODE, ">") + "</body></html>");
    }

    public static void testOptionFont(WebView tvQuestion_, String htmlAsString, String fontType) {
        String str;
        if (fontType.equalsIgnoreCase("2")) {
            str = "<html><head>  <style type=\"text/css\">\n        @font-face {\n            font-family:Symbol;\n            src: url(\"file:///android_asset/fonts/symbol.ttf\")\n        }\n        @font-face {\n            font-family:Narad;\n            src: url(\"file:///android_asset/fonts/Narad.ttf\")\n        }\n        @font-face {\n            font-family:Walkman-Chanakya-901;\n            src: url(\"file:///android_asset/fonts/CHANAKYA.ttf\")\n        }\n        body {\n           \n            font-size: medium;\n            text-align: justify;\n        }\n        .Narad {\n            font-family:Narad;\n        }\n    </style></head><body>";
        } else {
            str = "<html><head>  <style type=\"text/css\">\n        @font-face {\n            font-family:Kruti dev 010;\n            src: url(\"file:///android_asset/fonts/kruti_dev.ttf\")\n        }\n        body {\n           \n            font-size: medium;\n            text-align: justify;\n        }\n        .kruti_dev {\n            font-family: Kruti dev 010;\n        }\n    </style></head><body>";
        }
        TestWebHTMLLoad(tvQuestion_, str + htmlAsString.replace(StringUtils.LT_ENCODE, "<").replace(StringUtils.GT_ENCODE, ">") + "</body></html>");
    }

    public static boolean isTestResume(String setType) {
        boolean z = true;
        if (!SharedPreference.getInstance().getString(Const.RESUME_TEST).equalsIgnoreCase("1") ? !SharedPreference.getInstance().getString(Const.RESUME_TEST).equalsIgnoreCase("2") ? !SharedPreference.getInstance().getString(Const.RESUME_TEST).equalsIgnoreCase("3") : TextUtils.isEmpty(setType) || !setType.equalsIgnoreCase("1") : TextUtils.isEmpty(setType) || !setType.equalsIgnoreCase("0")) {
            z = false;
        }
        Log.d("TAGCHECKRESUME", "RESUME_TEST: " + SharedPreference.getInstance().getString(Const.RESUME_TEST) + " IsTestResume: " + z);
        return z;
    }

    public static boolean isLiveTest(String testSeriesType) {
        return TextUtils.isEmpty(testSeriesType) || !testSeriesType.equalsIgnoreCase("1");
    }

    public static boolean isLearnPracticeAfterEndDate() {
        return SharedPreference.getInstance().getString(Const.PRACTICE_TEST).equalsIgnoreCase("0");
    }

    public static boolean isLearnPracticeHide() {
        return SharedPreference.getInstance().getString(Const.PRACTICE_TEST).equalsIgnoreCase("1");
    }

    public static boolean isLearnPracticeAfterSubmit() {
        return SharedPreference.getInstance().getString(Const.PRACTICE_TEST).equalsIgnoreCase("2");
    }

    public static String getUserJWT() {
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.JWT))) {
            return SharedPreference.getInstance().getString(Const.JWT);
        }
        return "";
    }

    public static boolean isShowingFloatingMobile() {
        return !SharedPreference.getInstance().getString(Const.FloatingMobileNumber).equalsIgnoreCase("1");
    }

    public static String checkAndGetCourseTileData(JSONObject jsonObject, int i2, String key) {
        if (jsonObject != null) {
            try {
                if (jsonObject.has("tiles") && !jsonObject.isNull("tiles") && jsonObject.getJSONArray("tiles").length() > 0 && jsonObject.getJSONArray("tiles").getJSONObject(i2).has(key) && !jsonObject.getJSONArray("tiles").getJSONObject(i2).isNull(key)) {
                    return jsonObject.getJSONArray("tiles").getJSONObject(i2).getString(key);
                }
            } catch (JSONException unused) {
            }
        }
        return "";
    }

    public static boolean isRestrictSystemFont() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.restrictSystemFont)) && SharedPreference.getInstance().getString(Const.restrictSystemFont).equalsIgnoreCase("1");
    }

    public static boolean enableQRCode() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.enableQRCode)) && SharedPreference.getInstance().getString(Const.enableQRCode).equalsIgnoreCase("1");
    }

    public static boolean directPayment() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.directPayment)) && SharedPreference.getInstance().getString(Const.directPayment).equalsIgnoreCase("1");
    }

    public static boolean isChatSettingEnabled() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.isChatSettingEnabled)) && SharedPreference.getInstance().getString(Const.isChatSettingEnabled).equalsIgnoreCase("1");
    }

    public static boolean isGenerateLeaderboardEnabled() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.isGenerateLeaderboardEnabled)) && SharedPreference.getInstance().getString(Const.isGenerateLeaderboardEnabled).equalsIgnoreCase("1");
    }

    public static ArrayList<PollLocalResult> getFilteredPollLocalResults(String videoId, String pollId, String userId, String type) {
        ArrayList<PollLocalResult> pollLoacalResultData = getPollLoacalResultData();
        ArrayList<PollLocalResult> arrayList = new ArrayList<>();
        for (PollLocalResult pollLocalResult : pollLoacalResultData) {
            if (videoId.equals(pollLocalResult.getVideoId()) && pollId.equals(pollLocalResult.getPollId()) && userId.equals(pollLocalResult.getUserId()) && type.equals(pollLocalResult.getType())) {
                arrayList.add(pollLocalResult);
            }
        }
        return arrayList;
    }

    public static ArrayList<PollLocalResult> getPollLoacalResultData() {
        String string = SharedPreference.getInstance().getString(Const.POLL_LOCAL_RESULT, null);
        return !TextUtils.isEmpty(string) ? (ArrayList) new Gson().fromJson(string, new TypeToken<List<PollLocalResult>>() { // from class: com.appnew.android.Utils.Helper.31
        }.getType()) : new ArrayList<>();
    }

    public static void setPollLoacalResultData(ArrayList<PollLocalResult> response) {
        SharedPreference.getInstance().putString(Const.POLL_LOCAL_RESULT, new Gson().toJson(response));
    }

    public static void clearPollLoacalResultData() {
        setPollLoacalResultData(new ArrayList());
    }

    public static String getDivisionID() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.GET_DIVISION)) ? SharedPreference.getInstance().getString(Const.GET_DIVISION) : "0";
    }

    public static String getSubDivisionID() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.GET_SUB_DIVISION)) ? SharedPreference.getInstance().getString(Const.GET_SUB_DIVISION) : "0";
    }

    public static String getUserMobile() {
        return (SharedPreference.getInstance().getLoggedInUser() == null || TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getMobile())) ? "" : SharedPreference.getInstance().getLoggedInUser().getMobile();
    }

    public static boolean isDefaultEmail() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.isDefaultEmail)) && SharedPreference.getInstance().getString(Const.isDefaultEmail).equalsIgnoreCase("1");
    }

    public static boolean isNewLoginFlow() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.isNewLoginFLow)) && SharedPreference.getInstance().getString(Const.isNewLoginFLow).equalsIgnoreCase("1");
    }

    public static boolean isAddressShowAfter() {
        Log.d("TAGAddressModule", "isAddressNeeded: " + SharedPreference.getInstance().getString(Const.isAddressNeeded));
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.isAddressNeeded)) && SharedPreference.getInstance().getString(Const.isAddressNeeded).equalsIgnoreCase("1");
    }

    public static boolean isHideProfilePop() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.HIDE_PROFILE_POPUP)) && SharedPreference.getInstance().getString(Const.HIDE_PROFILE_POPUP).equalsIgnoreCase("1");
    }

    public static boolean isUserProfileCheckExist(boolean isphone) {
        Log.d("TAGIsUserProfileCheckExist", "date_of_birth: " + SharedPreference.getInstance().getString(Const.DOB_SHOW) + "\nfather_name: " + SharedPreference.getInstance().getString(Const.FATHER_SHOW) + "\nprofile_picture: " + SharedPreference.getInstance().getString(Const.PHOTO_SHOW) + "\nprofile_teacher: " + SharedPreference.getInstance().getString(Const.PROFILE_TEACHER) + "\ngender: " + SharedPreference.getInstance().getString(Const.GENDER_SHOW) + "\ncaste_category: " + SharedPreference.getInstance().getString(Const.CASTE_SHOW) + "\naddress: " + SharedPreference.getInstance().getString(Const.ADDRESS_SHOW) + "\nalt_mobile: " + SharedPreference.getInstance().getString(Const.ALTERNATE_SHOW) + "\nproof_marksheet: " + SharedPreference.getInstance().getString(Const.MARKSHEET_SHOW) + "\npin_code: " + SharedPreference.getInstance().getString(Const.PIN_CODE_SHOW) + "\nlanguage: " + SharedPreference.getInstance().getString(Const.LANG_SHOW) + "\nshow_rollno: " + SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER) + "\nisphone: " + isphone + "\nshow_form_email: " + SharedPreference.getInstance().getString(Const.EMAIL_FORM_SHOW) + "\nis_gstin: " + SharedPreference.getInstance().getString(Const.IS_GSTIN) + "\ncountry: " + SharedPreference.getInstance().getString(Const.COUNTRY_SHOW) + "\nis_expert: " + SharedPreference.getInstance().getString(Const.EXPERT_SHOW) + "\nis_state_validate: " + SharedPreference.getInstance().getString(Const.HIDE_CITY_STATE) + "\nshow_student_class: " + SharedPreference.getInstance().getString(Const.SHOW_STUDENT_CLASS) + "\n");
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.DOB_SHOW)) && SharedPreference.getInstance().getString(Const.DOB_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.FATHER_SHOW)) && SharedPreference.getInstance().getString(Const.FATHER_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.PHOTO_SHOW)) && SharedPreference.getInstance().getString(Const.PHOTO_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.PROFILE_TEACHER)) && SharedPreference.getInstance().getString(Const.PROFILE_TEACHER).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.GENDER_SHOW)) && SharedPreference.getInstance().getString(Const.GENDER_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.CASTE_SHOW)) && SharedPreference.getInstance().getString(Const.CASTE_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.ADDRESS_SHOW)) && SharedPreference.getInstance().getString(Const.ADDRESS_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.ALTERNATE_SHOW)) && SharedPreference.getInstance().getString(Const.ALTERNATE_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.MARKSHEET_SHOW)) && SharedPreference.getInstance().getString(Const.MARKSHEET_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.PIN_CODE_SHOW)) && SharedPreference.getInstance().getString(Const.PIN_CODE_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LANG_SHOW)) && SharedPreference.getInstance().getString(Const.LANG_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER)) && SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER).equalsIgnoreCase("1")) {
            return true;
        }
        if (isphone && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.EMAIL_FORM_SHOW)) && SharedPreference.getInstance().getString(Const.EMAIL_FORM_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.IS_GSTIN)) && SharedPreference.getInstance().getString(Const.IS_GSTIN).equalsIgnoreCase("1")) {
            return true;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.COUNTRY_SHOW)) && SharedPreference.getInstance().getString(Const.COUNTRY_SHOW).equalsIgnoreCase("1")) {
            return true;
        }
        if (TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.EXPERT_SHOW)) || !SharedPreference.getInstance().getString(Const.EXPERT_SHOW).equalsIgnoreCase("1")) {
            return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.HIDE_CITY_STATE)) && SharedPreference.getInstance().getString(Const.HIDE_CITY_STATE).equalsIgnoreCase("0");
        }
        return true;
    }

    public static boolean checkProfilePermission(String key) {
        return SharedPreference.getInstance().getString(key) != null && SharedPreference.getInstance().getString(key).equalsIgnoreCase("1");
    }

    public static Class<? extends AppCompatActivity> setSignInActivity() {
        return isNewLoginFlow() ? SignInNewActivity.class : SignInActivity.class;
    }

    public static Class<? extends AppCompatActivity> setLoginCatActivity() {
        return isNewLoginFlow() ? LoginCatNewActivity.class : LoginCatActivity.class;
    }

    public static void setStatusBarIconsLight(Context context, Window window, boolean lightIcons) {
        if (window == null || context == null) {
            return;
        }
        try {
            window.setStatusBarColor(ResourcesCompat.getColor(context.getResources(), lightIcons ? com.eduteria.app.app.R.color.colorPrimary : com.eduteria.app.app.R.color.white, context.getTheme()));
            int i2 = 0;
            if (Build.VERSION.SDK_INT >= 30) {
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    if (!lightIcons) {
                        i2 = 8;
                    }
                    insetsController.setSystemBarsAppearance(i2, 8);
                    return;
                }
                return;
            }
            View decorView = window.getDecorView();
            if (decorView != null) {
                if (!lightIcons) {
                    i2 = 8192;
                }
                decorView.setSystemUiVisibility(i2);
            }
        } catch (Exception e2) {
            Log.e("StatusBar", "Failed to set status bar icon color", e2);
        }
    }

    public static void adjustFontScale(Activity activity, Configuration configuration, float scale) {
        configuration.fontScale = scale;
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
        activity.getResources().updateConfiguration(configuration, displayMetrics);
    }

    public static void enableScreenShot(Activity activity) {
        try {
            AppCompatDelegate.setDefaultNightMode(1);
            if (isRestrictSystemFont()) {
                adjustFontScale(activity, activity.getResources().getConfiguration(), 1.0f);
            }
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.EnableScreenshot)) ? Arrays.asList(SharedPreference.getInstance().getString(Const.EnableScreenshot).split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)).contains(MakeMyExam.userId) : false) {
                return;
            }
            activity.getWindow().setFlags(8192, 8192);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void ResultScreenShot(Activity activity) {
        try {
            AppCompatDelegate.setDefaultNightMode(1);
            activity.getWindow().clearFlags(8192);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void goToIvsPlayerActivity(Context context, String videotype, String chatnode, String Url, String islive, String vid, String title, String is_audio, String thumbnail, String course_id, String tileid, String tiletype, String islocked, String pos, String parentid, String starttime, ArrayList<Video> videoArrayList) {
        try {
            Intent intent = new Intent(context, Class.forName("com.appnew.android.player.ivs_player.LiveIvsPlayerActivity"));
            intent.putExtra(Const.VIDEO_LINK, Url);
            intent.putExtra("Chat_node", chatnode);
            intent.putExtra(Const.VIDEO_TYPE, videotype);
            intent.putExtra("live", islive);
            intent.putExtra(Const.VIDEO_ID, vid);
            intent.putExtra("video_name", title);
            intent.putExtra("isaudio", is_audio);
            intent.putExtra("thumbnail", thumbnail);
            intent.putExtra("tileid", tileid);
            intent.putExtra("tiletype", tiletype);
            intent.putExtra("courseid", course_id);
            intent.putExtra("islocked", islocked);
            intent.putExtra(Const.shareparentid, parentid);
            intent.putExtra(com.clevertap.android.sdk.Constants.INAPP_POSITION, pos);
            intent.putExtra("starttime", starttime);
            intent.putExtra(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
            gotoActivity(intent, (Activity) context);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static CropImageOptions cropImageOptions(Context context) {
        CropImageOptions cropImageOptions = new CropImageOptions();
        cropImageOptions.guidelines = CropImageView.Guidelines.ON;
        cropImageOptions.toolbarColor = Integer.valueOf(context.getColor(com.eduteria.app.app.R.color.white));
        cropImageOptions.toolbarBackButtonColor = Integer.valueOf(context.getColor(com.eduteria.app.app.R.color.black));
        cropImageOptions.activityMenuIconColor = context.getColor(com.eduteria.app.app.R.color.black);
        cropImageOptions.activityMenuTextColor = Integer.valueOf(context.getColor(com.eduteria.app.app.R.color.black));
        return cropImageOptions;
    }

    public static String concerter(long time) {
        return String.format("%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(time)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))));
    }

    public static void loadImage(ImageView imageView, String url, int placeholderImage, boolean isGif, boolean isCircle) {
        if (!isGif && placeholderImage == 0) {
            placeholderImage = com.eduteria.app.app.R.color.gray_light;
        }
        try {
            Context context = imageView.getContext();
            if (isGif) {
                Glide.with(context).asGif().load(Integer.valueOf(com.eduteria.app.app.R.mipmap.live)).into(imageView);
                return;
            }
            if (isCircle) {
                RequestManager requestManagerWith = Glide.with(context);
                if (TextUtils.isEmpty(url)) {
                    url = "";
                }
                requestManagerWith.load(url).apply((BaseRequestOptions<?>) RequestOptions.circleCropTransform()).apply((BaseRequestOptions<?>) new RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)).placeholder(placeholderImage).error(placeholderImage).into(imageView);
                return;
            }
            RequestManager requestManagerWith2 = Glide.with(context);
            if (TextUtils.isEmpty(url)) {
                url = "";
            }
            requestManagerWith2.load(url).fitCenter().apply((BaseRequestOptions<?>) new RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)).placeholder(placeholderImage).error(placeholderImage).into(imageView);
        } catch (Exception unused) {
            imageView.setImageResource(placeholderImage);
        }
    }

    public static String getRelativeTimeManual(String timestamp) {
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - Long.parseLong(timestamp);
        if (jCurrentTimeMillis < 60) {
            return "Just now";
        }
        if (jCurrentTimeMillis < 3600) {
            return (jCurrentTimeMillis / 60) + " min ago";
        }
        if (jCurrentTimeMillis < 86400) {
            return (jCurrentTimeMillis / 3600) + " hours ago";
        }
        if (jCurrentTimeMillis < 172800) {
            return "Yesterday";
        }
        if (jCurrentTimeMillis < 2592000) {
            return (jCurrentTimeMillis / 86400) + " days ago";
        }
        if (jCurrentTimeMillis < 31536000) {
            return (jCurrentTimeMillis / 2592000) + " months ago";
        }
        return (jCurrentTimeMillis / 31536000) + " years ago";
    }

    private static void playVideoActivity(String videotype, String chatnode, Activity activity, String Url, String islive, String vid, String title, String is_audio, String thubnail, String course_id, String tileid, String tiletype, String islocked, String pos, String parentid, String bookmark, ArrayList<Video> videoArrayList, String videoQuality, int position) {
        Intent intent = new Intent(activity, (Class<?>) Liveawsactivity.class);
        intent.putExtra(Const.RESOLUTION, videoQuality);
        intent.putExtra(Const.RESOLUTION_POSITION, position);
        intent.putExtra(Const.VIDEO_LINK, Url);
        intent.putExtra("Chat_node", chatnode);
        intent.putExtra(Const.VIDEO_TYPE, videotype);
        intent.putExtra("live", islive);
        intent.putExtra(Const.VIDEO_ID, vid);
        intent.putExtra("video_name", title);
        intent.putExtra("isaudio", is_audio);
        intent.putExtra("thumbnail", thubnail);
        intent.putExtra("tileid", tileid);
        intent.putExtra("tiletype", tiletype);
        intent.putExtra("courseid", course_id);
        intent.putExtra("islocked", islocked);
        intent.putExtra(Const.shareparentid, parentid);
        intent.putExtra(com.clevertap.android.sdk.Constants.INAPP_POSITION, pos);
        intent.putExtra("bookmark", bookmark);
        SharedPreference.getInstance().putString(Const.ALL_VIDEOS_LIST, new Gson().toJson(videoArrayList));
        gotoActivity(intent, activity);
    }

    public static ArrayList<Video> addToList(Video video) {
        ArrayList<Video> arrayList = new ArrayList<>();
        arrayList.add(video);
        return arrayList;
    }

    public static ArrayList<Datum> addToList(Datum video) {
        ArrayList<Datum> arrayList = new ArrayList<>();
        arrayList.add(video);
        return arrayList;
    }

    public static boolean isShowShareButton(LeftMenu leftMenu) {
        return (leftMenu == null || leftMenu.getShare_content() == null || !leftMenu.getShare_content().equalsIgnoreCase("1")) ? false : true;
    }

    public static String getColumnName(int index) {
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            sb.insert(0, (char) ((index % 26) + 65));
            index = (index / 26) - 1;
        }
        return sb.toString();
    }

    public static void removeEditTextWhiteSpace(EditText editText) {
        try {
            InputFilter inputFilter = new InputFilter() { // from class: com.appnew.android.Utils.Helper.32
                @Override // android.text.InputFilter
                public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                    if (source.toString().contains(" ")) {
                        return "";
                    }
                    return null;
                }
            };
            InputFilter[] filters = editText.getFilters();
            InputFilter[] inputFilterArr = new InputFilter[filters.length + 1];
            System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
            inputFilterArr[filters.length] = inputFilter;
            editText.setFilters(inputFilterArr);
        } catch (Exception e2) {
            Log.d("TAGHELPER", "removeEditTextWhiteSpace: " + e2.getMessage());
        }
    }

    public static boolean isLandscapePoll() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.isLandscapePoll)) && SharedPreference.getInstance().getString(Const.isLandscapePoll).equalsIgnoreCase("1");
    }

    public static boolean isShowMarkAsDone(String videotype) {
        if (TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.MARK_AS_DONE)) || !SharedPreference.getInstance().getString(Const.MARK_AS_DONE).equalsIgnoreCase("1") || TextUtils.isEmpty(videotype)) {
            return false;
        }
        return videotype.equalsIgnoreCase("1") || videotype.equalsIgnoreCase("7");
    }

    public static boolean isPendingPurchaseBanner() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LEAD_PURCHASE_CTA)) && SharedPreference.getInstance().getString(Const.LEAD_PURCHASE_CTA).equalsIgnoreCase("1");
    }

    public static boolean isDashboardLiveClass() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.DASHBOARD_LIVE_CLASS)) && SharedPreference.getInstance().getString(Const.DASHBOARD_LIVE_CLASS).equalsIgnoreCase("1");
    }

    public static boolean isQuestionReportOption() {
        return !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.QUESTION_REPORT_OPTION)) && SharedPreference.getInstance().getString(Const.QUESTION_REPORT_OPTION).equalsIgnoreCase("1");
    }

    public static String sanitizeFilenameForS3(String input) {
        String strSubstring;
        if (input == null) {
            input = "";
        }
        int iLastIndexOf = input.lastIndexOf(46);
        if (iLastIndexOf != -1 && iLastIndexOf != 0 && iLastIndexOf < input.length() - 1) {
            strSubstring = input.substring(iLastIndexOf);
            input = input.substring(0, iLastIndexOf);
        } else {
            strSubstring = ".pdf";
        }
        String strReplaceAll = input.replaceAll("[^a-zA-Z0-9._-]", "").replaceAll("\\.", "_");
        if (strReplaceAll.isEmpty()) {
            strReplaceAll = Const.ANSWER;
        }
        return strReplaceAll + strSubstring.toLowerCase();
    }

    public static void preventLeadingSpaces(final EditText editText) {
        if (editText == null) {
            return;
        }
        try {
            editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda32
                @Override // android.text.InputFilter
                public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                    return Helper.lambda$preventLeadingSpaces$29(charSequence, i2, i3, spanned, i4, i5);
                }
            }});
            editText.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Utils.Helper.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    if (s == null || s.length() <= 0 || s.charAt(0) != ' ') {
                        return;
                    }
                    String strTrim = s.toString().trim();
                    editText.setText(strTrim);
                    editText.setSelection(strTrim.length());
                }
            });
        } catch (Exception e2) {
            Log.d("TAGHELPER", "preventLeadingSpaces: " + e2.getMessage());
        }
    }

    static /* synthetic */ CharSequence lambda$preventLeadingSpaces$29(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (i4 == 0 && charSequence != null && charSequence.toString().startsWith(" ")) {
            return "";
        }
        return null;
    }

    public static void showStreamSelectionBottomSheet(final Activity activity, Object videoObj, final int position, final ArrayList<Video> videoArrayList) {
        final Video video;
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity, com.eduteria.app.app.R.style.BottomSheetDialogStyle);
        final BottomSheetStreamYtBinding bottomSheetStreamYtBindingInflate = BottomSheetStreamYtBinding.inflate(LayoutInflater.from(activity));
        bottomSheetDialog.setContentView(bottomSheetStreamYtBindingInflate.getRoot());
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                Helper.lambda$showStreamSelectionBottomSheet$30(dialogInterface);
            }
        });
        bottomSheetStreamYtBindingInflate.streamTitle.setText("Choose Player");
        if ("3".equalsIgnoreCase(SharedPreference.getInstance().getString(Const.Youtube_Player_Control))) {
            bottomSheetStreamYtBindingInflate.stream3Layout.setVisibility(0);
        }
        if (videoObj instanceof Video) {
            video = (Video) videoObj;
        } else if (videoObj instanceof Lists) {
            Lists lists = (Lists) videoObj;
            Video video2 = new Video();
            video2.setId(lists.getId());
            video2.setTitle(lists.getTitle());
            video2.setFile_url(lists.getFile_url());
            video2.setVideo_type(lists.getVideo_type());
            video2.setThumbnail_url(lists.getThumbnail_url());
            video2.setIs_chat_lock(lists.getIs_chat_lock());
            video2.setChat_node(lists.getChat_node());
            video2.setIs_bookmarked("0");
            video2.setIs_live(lists.getIs_live() != null ? lists.getIs_live() : "0");
            video2.setPayloadData(lists.getPayload());
            video = video2;
        } else {
            bottomSheetDialog.dismiss();
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Helper.lambda$showStreamSelectionBottomSheet$31(bottomSheetDialog, bottomSheetStreamYtBindingInflate, video, activity, position, videoArrayList, view);
            }
        };
        bottomSheetStreamYtBindingInflate.stream1Layout.setOnClickListener(onClickListener);
        bottomSheetStreamYtBindingInflate.stream2Layout.setOnClickListener(onClickListener);
        bottomSheetStreamYtBindingInflate.stream3Layout.setOnClickListener(onClickListener);
        bottomSheetDialog.show();
    }

    static /* synthetic */ void lambda$showStreamSelectionBottomSheet$30(DialogInterface dialogInterface) {
        try {
            View viewFindViewById = ((BottomSheetDialog) dialogInterface).findViewById(com.eduteria.app.app.R.id.design_bottom_sheet);
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundResource(R.color.transparent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$showStreamSelectionBottomSheet$31(BottomSheetDialog bottomSheetDialog, BottomSheetStreamYtBinding bottomSheetStreamYtBinding, Video video, Activity activity, int i2, ArrayList arrayList, View view) {
        String str;
        bottomSheetDialog.dismiss();
        if (view == bottomSheetStreamYtBinding.stream1Layout) {
            str = "stream1";
        } else if (view == bottomSheetStreamYtBinding.stream2Layout) {
            str = "stream2";
        } else {
            str = view == bottomSheetStreamYtBinding.stream3Layout ? "stream3" : "";
        }
        SharedPreference.getInstance().putString(Const.SELECTED_STREAM_YT, str);
        if (video.getIs_bookmarked() != null && video.getIs_live() != null) {
            GoToLiveVideoActivity(video.getChat_node(), activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i2), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_bookmarked(), video.getIs_live(), arrayList);
        } else if (video.getIs_live() != null) {
            GoToLiveVideoActivity(video.getChat_node(), activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i2), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_live(), arrayList);
        } else {
            GoToLiveVideoActivity(video.getChat_node(), activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i2), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), arrayList);
        }
    }

    public static ArrayList<Video> convertDatumListToVideoList(ArrayList<Datum> datumList) {
        ArrayList<Video> arrayList = new ArrayList<>();
        if (datumList != null && !datumList.isEmpty()) {
            for (Datum datum : datumList) {
                Video video = new Video();
                video.setId(datum.getId());
                video.setTitle(datum.getTitle());
                video.setFile_url(datum.getFileUrl());
                video.setVideo_type(datum.getVideoType());
                video.setThumbnail_url(datum.getThumbnailUrl());
                video.setIs_chat_lock(datum.getIs_locked());
                video.setChat_node(datum.getChatNode());
                video.setIs_live(datum.getIs_live());
                video.setPayloadData(datum.getPayload());
                arrayList.add(video);
            }
        }
        return arrayList;
    }

    public static void showStreamSelectionBottomSheetLive(final Activity activity, final Datum videoData, final int position, ArrayList<Datum> datumList) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity, com.eduteria.app.app.R.style.BottomSheetDialogStyle);
        final BottomSheetStreamYtBinding bottomSheetStreamYtBindingInflate = BottomSheetStreamYtBinding.inflate(LayoutInflater.from(activity));
        bottomSheetDialog.setContentView(bottomSheetStreamYtBindingInflate.getRoot());
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda30
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                Helper.lambda$showStreamSelectionBottomSheetLive$32(dialogInterface);
            }
        });
        bottomSheetStreamYtBindingInflate.streamTitle.setText("Choose Player");
        if ("3".equalsIgnoreCase(SharedPreference.getInstance().getString(Const.Youtube_Player_Control))) {
            bottomSheetStreamYtBindingInflate.stream3Layout.setVisibility(0);
        }
        final ArrayList<Video> arrayListConvertDatumListToVideoList = convertDatumListToVideoList(datumList);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Helper.lambda$showStreamSelectionBottomSheetLive$33(bottomSheetDialog, bottomSheetStreamYtBindingInflate, videoData, activity, position, arrayListConvertDatumListToVideoList, view);
            }
        };
        bottomSheetStreamYtBindingInflate.stream1Layout.setOnClickListener(onClickListener);
        bottomSheetStreamYtBindingInflate.stream2Layout.setOnClickListener(onClickListener);
        bottomSheetStreamYtBindingInflate.stream3Layout.setOnClickListener(onClickListener);
        bottomSheetDialog.show();
    }

    static /* synthetic */ void lambda$showStreamSelectionBottomSheetLive$32(DialogInterface dialogInterface) {
        try {
            View viewFindViewById = ((BottomSheetDialog) dialogInterface).findViewById(com.eduteria.app.app.R.id.design_bottom_sheet);
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundResource(R.color.transparent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$showStreamSelectionBottomSheetLive$33(BottomSheetDialog bottomSheetDialog, BottomSheetStreamYtBinding bottomSheetStreamYtBinding, Datum datum, Activity activity, int i2, ArrayList arrayList, View view) {
        String str;
        bottomSheetDialog.dismiss();
        if (view == bottomSheetStreamYtBinding.stream1Layout) {
            str = "stream1";
        } else if (view == bottomSheetStreamYtBinding.stream2Layout) {
            str = "stream2";
        } else {
            str = view == bottomSheetStreamYtBinding.stream3Layout ? "stream3" : "";
        }
        SharedPreference.getInstance().putString(Const.SELECTED_STREAM_YT, str);
        if (datum.getIs_live() != null && datum.getPayload() != null) {
            GoToLiveVideoActivity(datum.getChatNode(), activity, datum.getFileUrl(), datum.getVideoType(), datum.getId(), datum.getTitle(), "0", datum.getThumbnailUrl(), datum.getIs_locked(), datum.getPayload().getCourse_id(), String.valueOf(i2), SingleStudy.parentCourseId, datum.getPayload().getTile_id(), datum.getPayload().getTile_type(), datum.getIs_live(), arrayList);
        } else {
            Toast.makeText(activity, "Invalid video data", 0).show();
        }
    }

    public static float parseFloatSafe(String value) {
        if (value != null && !value.isEmpty()) {
            try {
                return Float.parseFloat(value);
            } catch (NumberFormatException unused) {
            }
        }
        return 0.0f;
    }

    public static int parseIntSafe(String value) {
        if (value != null && !value.isEmpty()) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public static void firebaseAnalytics(Activity activity, String Course_Name, String Course_Amount, String Course_Tax, String Pre_Transaction_Id, String Course_Id, String Payment_type, String type) {
        String str;
        FirebaseAnalytics firebaseAnalytics;
        str = (SharedPreference.getInstance().getLoggedInUser() == null || SharedPreference.getInstance().getLoggedInUser().getName() == null || SharedPreference.getInstance().getLoggedInUser().getMobile() == null) ? "" : "User_Name=" + SharedPreference.getInstance().getLoggedInUser().getName() + ", User_Number" + SharedPreference.getInstance().getLoggedInUser().getMobile();
        firebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        type.hashCode();
        switch (type) {
            case "SignIn":
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.METHOD, "Mobile");
                bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, Const.SIGNUP);
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SIGN_UP, bundle);
                break;
            case "Purchase_Completed":
                Bundle bundle2 = new Bundle();
                double d2 = Double.parseDouble(Course_Amount.replaceAll("[^\\d.]", ""));
                bundle2.putString(FirebaseAnalytics.Param.CURRENCY, "INR");
                bundle2.putDouble("value", d2);
                bundle2.putString("transaction_id", Pre_Transaction_Id);
                bundle2.putString(FirebaseAnalytics.Param.SCREEN_NAME, str);
                bundle2.putString(FirebaseAnalytics.Param.ITEM_ID, Course_Id);
                bundle2.putString(FirebaseAnalytics.Param.ITEM_NAME, Course_Name);
                bundle2.putDouble(FirebaseAnalytics.Param.PRICE, d2);
                bundle2.putInt(FirebaseAnalytics.Param.QUANTITY, 1);
                firebaseAnalytics.logEvent("purchase_completed", bundle2);
                break;
            case "Install":
                Bundle bundle3 = new Bundle();
                bundle3.putString("device_model", Build.MODEL);
                bundle3.putString("android_version", Build.VERSION.RELEASE);
                bundle3.putString("app_version", SharedPreference.getInstance().getString("Version"));
                firebaseAnalytics.logEvent("app_installed", bundle3);
                break;
            case "CourseDetails":
                if (SharedPreference.getInstance().getString("course_event").equalsIgnoreCase("1")) {
                    String strSanitizeEventName = sanitizeEventName(Course_Name);
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(FirebaseAnalytics.Param.CURRENCY, "INR");
                    bundle4.putString(FirebaseAnalytics.Param.ITEM_ID, Course_Id);
                    bundle4.putString(FirebaseAnalytics.Param.PRICE, Course_Amount);
                    firebaseAnalytics.logEvent(strSanitizeEventName + '_' + Course_Id, bundle4);
                    break;
                }
                break;
            case "Login":
                if (SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getMobile() != null) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putString(FirebaseAnalytics.Param.METHOD, Const.MOBILE);
                    bundle5.putString(FirebaseAnalytics.Param.SCREEN_NAME, Const.LOGIN);
                    firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, bundle5);
                    break;
                }
                break;
            case "Checkout":
                Bundle bundle6 = new Bundle();
                bundle6.putString(FirebaseAnalytics.Param.CURRENCY, "INR");
                bundle6.putString(FirebaseAnalytics.Param.SCREEN_NAME, str);
                bundle6.putDouble("value", Double.parseDouble(Course_Amount));
                Bundle bundle7 = new Bundle();
                bundle7.putString(FirebaseAnalytics.Param.ITEM_ID, Course_Id);
                bundle7.putString(FirebaseAnalytics.Param.ITEM_NAME, Course_Name);
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(bundle7);
                bundle6.putParcelableArrayList(FirebaseAnalytics.Param.ITEMS, arrayList);
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.BEGIN_CHECKOUT, bundle6);
                break;
            case "Purchase":
                Bundle bundle8 = new Bundle();
                double d3 = Double.parseDouble(Course_Amount.replaceAll("[^\\d.]", ""));
                bundle8.putString(FirebaseAnalytics.Param.CURRENCY, "INR");
                bundle8.putDouble("value", d3);
                bundle8.putString("transaction_id", Pre_Transaction_Id);
                Bundle bundle9 = new Bundle();
                bundle9.putString(FirebaseAnalytics.Param.ITEM_ID, Course_Id);
                bundle9.putString(FirebaseAnalytics.Param.ITEM_NAME, Course_Name);
                bundle9.putDouble(FirebaseAnalytics.Param.PRICE, d3);
                bundle9.putInt(FirebaseAnalytics.Param.QUANTITY, 1);
                bundle9.putString("course_id", Course_Id);
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                arrayList2.add(bundle9);
                bundle8.putParcelableArrayList(FirebaseAnalytics.Param.ITEMS, arrayList2);
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.PURCHASE, bundle8);
                break;
            case "Banner":
                Bundle bundle10 = new Bundle();
                bundle10.putString(FirebaseAnalytics.Param.CURRENCY, "INR");
                bundle10.putString(FirebaseAnalytics.Param.ITEM_NAME, Course_Id + "--" + Course_Name);
                bundle10.putString(FirebaseAnalytics.Param.SCREEN_NAME, str);
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_PROMOTION, bundle10);
                break;
            case "Course":
                Bundle bundle11 = new Bundle();
                bundle11.putString(FirebaseAnalytics.Param.CURRENCY, "INR");
                bundle11.putString("value", Course_Name + "--" + Course_Amount);
                Bundle bundle12 = new Bundle();
                bundle12.putString(FirebaseAnalytics.Param.ITEM_ID, Course_Id);
                bundle12.putString(FirebaseAnalytics.Param.ITEM_NAME, Course_Name);
                new ArrayList().add(bundle12);
                bundle11.putString(FirebaseAnalytics.Param.SCREEN_NAME, str);
                firebaseAnalytics.logEvent("course_view", bundle11);
                break;
        }
    }

    public static void firebaseAnalytics(Activity activity, String name) {
        if (BuildConfig.FLAVOR.equals("mypathshala")) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(activity);
            Bundle bundle = new Bundle();
            bundle.putString("User_Name", SharedPreference.getInstance().getLoggedInUser().getUsername());
            bundle.putString("User_Id", SharedPreference.getInstance().getLoggedInUser().getId());
            firebaseAnalytics.logEvent(name, bundle);
        }
    }

    public static void FirstInstall(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("app_prefs", 0);
        if (sharedPreferences.getBoolean("first_install", true)) {
            FacebookEventLogger.logApplicationInstall(context);
            sharedPreferences.edit().putBoolean("first_install", false).apply();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void resolveTestPattern(Activity activity, String testPattern, Runnable onOldPattern, Runnable onSSCPattern) {
        if (testPattern == null || testPattern.isEmpty()) {
            testPattern = "0";
        }
        switch (testPattern.hashCode()) {
            case 48:
                if (testPattern.equals("0")) {
                    onOldPattern.run();
                    return;
                }
                break;
            case 49:
                if (testPattern.equals("1")) {
                    onSSCPattern.run();
                    return;
                }
                break;
            case 50:
                testPattern.equals("2");
                break;
        }
        showTestPatternBottomSheet(activity, onOldPattern, onSSCPattern);
    }

    public static void showTestPatternBottomSheet(Activity activity, final Runnable onOldPattern, final Runnable onSSCPattern) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity, com.eduteria.app.app.R.style.BottomSheetDialogStyle);
        BottomSheetStreamYtBinding bottomSheetStreamYtBindingInflate = BottomSheetStreamYtBinding.inflate(LayoutInflater.from(activity));
        bottomSheetDialog.setContentView(bottomSheetStreamYtBindingInflate.getRoot());
        try {
            View viewFindViewById = bottomSheetDialog.findViewById(com.eduteria.app.app.R.id.design_bottom_sheet);
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundResource(R.color.transparent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        bottomSheetStreamYtBindingInflate.streamTitle.setText("Choose Test Pattern");
        ((TextView) bottomSheetStreamYtBindingInflate.stream1Layout.getChildAt(0)).setText("SSC Pattern Test");
        ((TextView) bottomSheetStreamYtBindingInflate.stream2Layout.getChildAt(0)).setText("Normal Test");
        bottomSheetStreamYtBindingInflate.stream3Layout.setVisibility(8);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bottomSheetStreamYtBindingInflate.stream1Layout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Helper.lambda$showTestPatternBottomSheet$34(atomicBoolean, bottomSheetDialog, onSSCPattern, view);
            }
        });
        bottomSheetStreamYtBindingInflate.stream2Layout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.Helper$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Helper.lambda$showTestPatternBottomSheet$35(atomicBoolean, bottomSheetDialog, onOldPattern, view);
            }
        });
        bottomSheetDialog.show();
    }

    static /* synthetic */ void lambda$showTestPatternBottomSheet$34(AtomicBoolean atomicBoolean, BottomSheetDialog bottomSheetDialog, Runnable runnable, View view) {
        if (atomicBoolean.getAndSet(true)) {
            return;
        }
        bottomSheetDialog.dismiss();
        runnable.run();
    }

    static /* synthetic */ void lambda$showTestPatternBottomSheet$35(AtomicBoolean atomicBoolean, BottomSheetDialog bottomSheetDialog, Runnable runnable, View view) {
        if (atomicBoolean.getAndSet(true)) {
            return;
        }
        bottomSheetDialog.dismiss();
        runnable.run();
    }

    public static boolean isNotResumeTest() {
        return SharedPreference.getInstance().getString(Const.RESUME_TEST).equalsIgnoreCase("0");
    }

    public static boolean isPracticeTest() {
        return isLearnPracticeAfterEndDate() || isLearnPracticeAfterSubmit();
    }

    public static String sanitizeEventName(String courseTitle) {
        if (courseTitle == null || courseTitle.isEmpty()) {
            return "unknown_event";
        }
        String strReplaceAll = courseTitle.trim().toLowerCase().replaceAll("[^a-z0-9_]", "_").replaceAll("_{2,}", "_");
        if (Character.isDigit(strReplaceAll.charAt(0))) {
            strReplaceAll = "n_" + strReplaceAll;
        }
        if (strReplaceAll.startsWith("_")) {
            strReplaceAll = strReplaceAll.substring(1);
        }
        if (strReplaceAll.endsWith("_") && strReplaceAll.length() > 1) {
            strReplaceAll = strReplaceAll.substring(0, strReplaceAll.length() - 1);
        }
        if (strReplaceAll.length() > 30) {
            strReplaceAll = strReplaceAll.substring(0, 30);
            if (strReplaceAll.endsWith("_")) {
                strReplaceAll = strReplaceAll.substring(0, strReplaceAll.length() - 1);
            }
        }
        return strReplaceAll.isEmpty() ? "n_" : strReplaceAll;
    }

    public static void secureScreen(Activity activity) {
        activity.getWindow().setFlags(8192, 8192);
    }
}
