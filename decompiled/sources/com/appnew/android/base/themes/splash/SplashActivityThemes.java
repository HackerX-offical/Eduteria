package com.appnew.android.base.themes.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import android.widget.VideoView;
import com.appnew.android.Intro.Activity.CategoryActivity;
import com.appnew.android.Login.Activity.SplashScreen;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Theme.DashboardActivityTheme4;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.Store;
import com.eduteria.app.app.R;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SplashActivityThemes extends Activity implements NetworkCall.MyNetworkCallBack {
    private String bannerId;
    private String contentType;
    Context context;
    private String courseid;
    private String fileId;
    private String folder_id;
    public Intent intent;
    AppEventsLogger logger;
    private String maincouseidAffair;
    Runnable myRunnable;
    NetworkCall networkCall;
    Class nextActivity;
    private String parentid;
    private String postId;
    private String revertApi;
    private String tileId;
    private String tileType;
    private String topicId;
    private UtkashRoom utkashRoom;
    private int SPLASH_TIME_OUT = 0;
    private String fragType = Const.HOME;
    private String videoid = "";
    private String tileid = "";
    private String tiletype = "";
    String media_id = "";
    boolean isexit = false;
    Handler handler = new Handler();
    String type = "";
    String is_security = "0";

    static /* synthetic */ void lambda$showVideo$6(MediaPlayer mediaPlayer) {
    }

    public abstract void onCreateSplash();

    public abstract void onStartSplash();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0139  */
    /* JADX WARN: Type inference failed for: r19v0, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v12 */
    /* JADX WARN: Type inference failed for: r19v2, types: [androidx.media3.exoplayer.ExoPlayer] */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5, types: [androidx.media3.exoplayer.ExoPlayer] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r19) {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.base.themes.splash.SplashActivityThemes.onCreate(android.os.Bundle):void");
    }

    public void setSplashTime(int SPLASH_TIME_OUT) {
        this.SPLASH_TIME_OUT = SPLASH_TIME_OUT;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        onStartSplash();
    }

    public void init_splash(final String is_security) {
        if (!"1".equalsIgnoreCase("1")) {
            if (!"1".equalsIgnoreCase("2")) {
                if (!"1".equalsIgnoreCase("3")) {
                    if (!"1".equalsIgnoreCase("4")) {
                        if (!"1".equalsIgnoreCase("5")) {
                            if (!"1".equalsIgnoreCase("6")) {
                                if ("1".equalsIgnoreCase("7")) {
                                    if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                                        if (SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getPreferences() != null && SharedPreference.getInstance().getLoggedInUser().getPreferences().size() > 0) {
                                            this.nextActivity = DashboardActivityTheme8.class;
                                        } else {
                                            this.nextActivity = CategoryActivity.class;
                                        }
                                        int i = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                                        if (i == 1) {
                                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                                        } else if (i == 2) {
                                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                                        }
                                    } else {
                                        this.nextActivity = Helper.setSignInActivity();
                                        this.logger.logEvent("LoginScreenMove");
                                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                                    }
                                    Runnable runnable = new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            SplashActivityThemes.this.lambda$init_splash$4(is_security);
                                        }
                                    };
                                    this.myRunnable = runnable;
                                    this.handler.postDelayed(runnable, this.SPLASH_TIME_OUT);
                                    return;
                                }
                                return;
                            }
                            if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                                this.nextActivity = DashboardActivityTheme7.class;
                                int i2 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                                if (i2 == 1) {
                                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                                } else if (i2 == 2) {
                                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                                }
                            } else {
                                this.nextActivity = Helper.setSignInActivity();
                                this.logger.logEvent("LoginScreenMove");
                                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                            }
                            Runnable runnable2 = new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SplashActivityThemes.this.lambda$init_splash$4(is_security);
                                }
                            };
                            this.myRunnable = runnable2;
                            this.handler.postDelayed(runnable2, this.SPLASH_TIME_OUT);
                            return;
                        }
                        if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                            this.nextActivity = DashboardActivityTheme5.class;
                            int i3 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                            if (i3 == 1) {
                                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                            } else if (i3 == 2) {
                                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                            }
                        } else {
                            this.nextActivity = Helper.setSignInActivity();
                            this.logger.logEvent("LoginScreenMove");
                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                        }
                        Runnable runnable3 = new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda8
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$init_splash$4(is_security);
                            }
                        };
                        this.myRunnable = runnable3;
                        this.handler.postDelayed(runnable3, this.SPLASH_TIME_OUT);
                        return;
                    }
                    if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                        this.nextActivity = DashboardActivityTheme4.class;
                        int i4 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                        if (i4 == 1) {
                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                        } else if (i4 == 2) {
                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                        }
                    } else {
                        this.nextActivity = Helper.setSignInActivity();
                        this.logger.logEvent("LoginScreenMove");
                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                    }
                    Runnable runnable4 = new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$init_splash$3(is_security);
                        }
                    };
                    this.myRunnable = runnable4;
                    this.handler.postDelayed(runnable4, this.SPLASH_TIME_OUT);
                    return;
                }
                if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                    this.nextActivity = DashboardActivityTheme3.class;
                    int i5 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                    if (i5 == 1) {
                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                    } else if (i5 == 2) {
                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                    }
                } else {
                    this.nextActivity = Helper.setSignInActivity();
                    this.logger.logEvent("LoginScreenMove");
                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                }
                Runnable runnable5 = new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$init_splash$2(is_security);
                    }
                };
                this.myRunnable = runnable5;
                this.handler.postDelayed(runnable5, this.SPLASH_TIME_OUT);
                return;
            }
            if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                this.nextActivity = DashboardActivityTheme2.class;
                int i6 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                if (i6 == 1) {
                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                } else if (i6 == 2) {
                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                }
            } else {
                this.nextActivity = Helper.setSignInActivity();
                this.logger.logEvent("LoginScreenMove");
                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
            }
            Runnable runnable6 = new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$init_splash$1(is_security);
                }
            };
            this.myRunnable = runnable6;
            this.handler.postDelayed(runnable6, this.SPLASH_TIME_OUT);
            return;
        }
        if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
            this.nextActivity = DashboardActivityTheme1.class;
            int i7 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
            if (i7 == 1) {
                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
            } else if (i7 == 2) {
                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
            }
        } else {
            this.nextActivity = Helper.setSignInActivity();
            this.logger.logEvent("LoginScreenMove");
            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
        }
        Runnable runnable7 = new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init_splash$0(is_security);
            }
        };
        this.myRunnable = runnable7;
        this.handler.postDelayed(runnable7, this.SPLASH_TIME_OUT);
    }

    public void CheckDeepLinking() {
        FirebaseDynamicLinks.getInstance().getDynamicLink(getIntent()).addOnSuccessListener(this, new OnSuccessListener() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$CheckDeepLinking$5((PendingDynamicLinkData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$CheckDeepLinking$5(PendingDynamicLinkData pendingDynamicLinkData) {
        Uri link;
        if (pendingDynamicLinkData != null) {
            link = pendingDynamicLinkData.getLink();
            if (link.getBooleanQueryParameter("data", false)) {
                try {
                    link = Uri.parse("https://appapi.videocrypt.in/?".concat(new String(Base64.decode(link.getQueryParameter("data"), 0), "UTF-8")));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            link = null;
        }
        if (link != null) {
            if (link.getBooleanQueryParameter("maincouseid", false)) {
                this.fragType = "course";
                String queryParameter = link.getQueryParameter("maincouseid");
                String queryParameter2 = link.getQueryParameter("iscombo");
                String queryParameter3 = link.getQueryParameter("parentcourseid");
                SharedPreference.getInstance().putString("maincourseid", queryParameter);
                SharedPreference.getInstance().putString("iscombo", queryParameter2);
                if (queryParameter3 == null) {
                    this.parentid = "";
                    SharedPreference.getInstance().putString("parentcourseid", "");
                } else {
                    this.parentid = queryParameter3;
                    SharedPreference.getInstance().putString("parentcourseid", queryParameter3);
                }
            } else if (link.getBooleanQueryParameter("maincouseidlive", false)) {
                this.fragType = "video";
                this.courseid = link.getQueryParameter("maincouseidlive");
                this.fileId = link.getQueryParameter("fieldid");
                this.topicId = link.getQueryParameter("topicid");
                this.tileType = link.getQueryParameter(Const.TILE_TYPE);
                this.revertApi = revertapi(link.toString());
                this.tileId = link.getQueryParameter("tileid");
                this.parentid = link.getQueryParameter(Const.shareparentid);
            } else if (link.getBooleanQueryParameter("maincouseidjw", false)) {
                this.fragType = "jwvideo";
                this.courseid = link.getQueryParameter("maincouseidjw");
                this.fileId = link.getQueryParameter("fieldid");
                this.topicId = link.getQueryParameter("topicid");
                this.tileType = link.getQueryParameter(Const.TILE_TYPE);
                this.revertApi = revertapi(link.toString());
                this.tileId = link.getQueryParameter("tileid");
                this.parentid = link.getQueryParameter(Const.shareparentid);
            } else if (link.getBooleanQueryParameter("mainpdfid", false)) {
                this.fragType = Const.PDF;
                this.courseid = link.getQueryParameter("mainpdfid");
                this.fileId = link.getQueryParameter("fieldid");
                this.topicId = link.getQueryParameter("topicid");
                this.tileType = link.getQueryParameter(Const.TILE_TYPE);
                this.revertApi = revertapi(link.toString());
                this.folder_id = link.getQueryParameter(Const.FOLDER_ID);
                this.contentType = link.getQueryParameter("contentType");
                this.tileId = link.getQueryParameter("tileid");
                this.parentid = link.getQueryParameter(Const.shareparentid);
            } else if (link.getBooleanQueryParameter("testcourseid", false)) {
                this.fragType = Const.TEST;
                this.courseid = link.getQueryParameter("testcourseid");
                this.fileId = link.getQueryParameter("fieldid");
                this.topicId = link.getQueryParameter("topicid");
                this.tileType = link.getQueryParameter(Const.TILE_TYPE);
                this.revertApi = revertapi(link.toString());
                this.tileId = link.getQueryParameter("tileid");
                this.parentid = link.getQueryParameter(Const.shareparentid);
            } else if (link.getQueryParameterNames().contains("postid")) {
                this.fragType = Const.POST;
                this.postId = link.getQueryParameter("postid");
            } else if (link.getQueryParameterNames().contains("maincouseidAffair")) {
                this.fragType = "currentAffair";
                this.maincouseidAffair = link.getQueryParameter("maincouseidAffair");
            } else if (link.getQueryParameterNames().contains("maincouseidAudio")) {
                this.fragType = "audio";
                this.courseid = link.getQueryParameter("maincouseidAudio");
                this.fileId = link.getQueryParameter("fieldid");
                this.topicId = link.getQueryParameter("topicid");
                this.tileType = link.getQueryParameter(Const.TILE_TYPE);
                this.revertApi = revertapi(link.toString());
                this.tileId = link.getQueryParameter("tileid");
                this.parentid = link.getQueryParameter(Const.shareparentid);
            }
            if (this.parentid == null) {
                this.parentid = "";
            }
        }
    }

    public String revertapi(String s) {
        if (s.contains("revertapi=")) {
            String[] strArrSplit = s.split("revertapi=");
            if (strArrSplit.length == 2 && strArrSplit[1].contains("&")) {
                return strArrSplit[1].split("&")[0];
            }
            return "";
        }
        return "";
    }

    public String revertApi(String str) {
        if (str.contains("revertapi=")) {
            return str.split("revertapi=")[1];
        }
        return "";
    }

    /* JADX INFO: renamed from: next, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$init_splash$4(String is_security) {
        openHomePage();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x079a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0963  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0b96  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0ba9  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0bc9  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0d92  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0fc5  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0fd8  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0ff8  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x1186  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x13b9  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x13cc  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x13ec  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x1579  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x17d4  */
    /* JADX WARN: Removed duplicated region for block: B:628:0x17e7  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x1807  */
    /* JADX WARN: Removed duplicated region for block: B:681:0x19c9  */
    /* JADX WARN: Removed duplicated region for block: B:736:0x1bfc  */
    /* JADX WARN: Removed duplicated region for block: B:739:0x1c0f  */
    /* JADX WARN: Removed duplicated region for block: B:741:0x1c2f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0365  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void openHomePage() {
        /*
            Method dump skipped, instruction units count: 8266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.base.themes.splash.SplashActivityThemes.openHomePage():void");
    }

    public void init(SplashScreen splashScreen) {
        if (Helper.isNavigate) {
            if (Helper.isConnected(this)) {
                new NetworkCall(this, this).NetworkAPICall(API.API_GET_APP_VERSION, "", false, false);
            } else {
                Helper.isNoInternet(this.utkashRoom, splashScreen, this.is_security);
            }
        }
    }

    public void showVideo(int videoPath, VideoView videoView) {
        if (videoView != null) {
            try {
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + videoPath));
                videoView.setZOrderOnTop(true);
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda1
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        SplashActivityThemes.lambda$showVideo$6(mediaPlayer);
                    }
                });
                videoView.start();
            } catch (Exception e2) {
                Log.e("Video View:: Exception:", e2.toString());
            }
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CustomContextWrapper.wrap(newBase, SharedPreference.getInstance().getString(Const.APP_LANGUAGE)));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callToNoteTime() {
        this.SPLASH_TIME_OUT += Store.STORE_DELETE_RECORD_FAILED;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.3
            @Override // java.lang.Runnable
            public void run() {
                if (SplashActivityThemes.this.SPLASH_TIME_OUT > 0) {
                    SplashActivityThemes.this.callToNoteTime();
                }
            }
        }, 500L);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.API_GET_APP_VERSION)) {
            return service.getAppVersion();
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_GET_APP_VERSION) && jsonObject.optString("status").equals("true")) {
            JSONObject jSONObject = jsonObject.getJSONObject("data");
            String strOptString = jSONObject.optString("version");
            String strOptString2 = jSONObject.optString("min_version");
            String strOptString3 = jSONObject.optString("force_update");
            String strOptString4 = jSONObject.optString("break_from");
            String strOptString5 = jSONObject.optString("break_to");
            if (jSONObject.has("is_security")) {
                this.is_security = jSONObject.optString("is_security");
            }
            if (jsonObject.has("time")) {
                SharedPreference.getInstance().putInt(Const.CURRENT_HOUR, new Date(jsonObject.optLong("time") * 1000).getHours());
            }
            if (jSONObject.has("permissions")) {
                SharedPreference.getInstance().putString(Const.FloatingMobileNumber, jSONObject.optJSONObject("permissions").optString(Const.FloatingMobileNumber));
                SharedPreference.getInstance().putString(Const.EnableScreenshot, jSONObject.optJSONObject("permissions").optString(Const.EnableScreenshot));
                SharedPreference.getInstance().putString(Const.SHOW_GREETING, jSONObject.optJSONObject("permissions").optString("greeting"));
                SharedPreference.getInstance().putString(Const.EMAIL_SHOW, jSONObject.optJSONObject("permissions").optString(Const.EMAIL_SHOW));
                SharedPreference.getInstance().putString(Const.IS_GOOGLE_LOGIN_ENABLE, jSONObject.optJSONObject("permissions").optString("google_login"));
                SharedPreference.getInstance().putString(Const.DOB_SHOW, jSONObject.optJSONObject("permissions").optString("date_of_birth"));
                SharedPreference.getInstance().putString(Const.EXPERT_SHOW, jSONObject.optJSONObject("permissions").optString(Const.IS_EXPERT));
                SharedPreference.getInstance().putString(Const.COUNTRY_SHOW, jSONObject.optJSONObject("permissions").optString(UserDataStore.COUNTRY));
                SharedPreference.getInstance().putString(Const.SHOW_CERTIFICATE, jSONObject.optJSONObject("permissions").optString(Const.SHOW_CERTIFICATE));
                if (jSONObject.optJSONObject("permissions").has(Const.enableQRCode)) {
                    SharedPreference.getInstance().putString(Const.enableQRCode, jSONObject.optJSONObject("permissions").optString(Const.enableQRCode));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.DRM_LICENSE_URL)) {
                    SharedPreference.getInstance().putString(Const.DRM_LICENSE_URL, jSONObject.optJSONObject("permissions").optString(Const.DRM_LICENSE_URL));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.isNewLoginFLow)) {
                    SharedPreference.getInstance().putString(Const.isNewLoginFLow, jSONObject.optJSONObject("permissions").optString(Const.isNewLoginFLow));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.isAddressNeeded)) {
                    SharedPreference.getInstance().putString(Const.isAddressNeeded, jSONObject.optJSONObject("permissions").optString(Const.isAddressNeeded));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.isLandscapePoll)) {
                    SharedPreference.getInstance().putString(Const.isLandscapePoll, jSONObject.optJSONObject("permissions").optString(Const.isLandscapePoll));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.isDefaultEmail)) {
                    SharedPreference.getInstance().putString(Const.isDefaultEmail, jSONObject.optJSONObject("permissions").optString(Const.isDefaultEmail));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.directPayment)) {
                    SharedPreference.getInstance().putString(Const.directPayment, jSONObject.optJSONObject("permissions").optString(Const.directPayment));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.isChatSettingEnabled)) {
                    SharedPreference.getInstance().putString(Const.isChatSettingEnabled, jSONObject.optJSONObject("permissions").optString(Const.isChatSettingEnabled));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.isGenerateLeaderboardEnabled)) {
                    SharedPreference.getInstance().putString(Const.isGenerateLeaderboardEnabled, jSONObject.optJSONObject("permissions").optString(Const.isGenerateLeaderboardEnabled));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.restrictSystemFont)) {
                    SharedPreference.getInstance().putString(Const.restrictSystemFont, jSONObject.optJSONObject("permissions").optString(Const.restrictSystemFont));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.EnableCleverTap)) {
                    SharedPreference.getInstance().putString(Const.EnableCleverTap, jSONObject.optJSONObject("permissions").optString(Const.EnableCleverTap));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.DEVELOPER_OPTIONS)) {
                    SharedPreference.getInstance().putString(Const.DEVELOPER_OPTIONS, jSONObject.optJSONObject("permissions").optString(Const.DEVELOPER_OPTIONS));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.MARK_AS_DONE)) {
                    SharedPreference.getInstance().putString(Const.MARK_AS_DONE, jSONObject.optJSONObject("permissions").optString(Const.MARK_AS_DONE));
                }
                if (jSONObject.optJSONObject("permissions").has(Const.LEAD_PURCHASE_CTA)) {
                    SharedPreference.getInstance().putString(Const.LEAD_PURCHASE_CTA, jSONObject.optJSONObject("permissions").optString(Const.LEAD_PURCHASE_CTA));
                }
            }
            int i = Integer.parseInt(strOptString);
            int i2 = Integer.parseInt(strOptString2);
            if (Long.parseLong(strOptString4) < System.currentTimeMillis() && Long.parseLong(strOptString5) > System.currentTimeMillis()) {
                getMaintanaceDialog((Activity) this.context, strOptString4, strOptString5);
                return;
            }
            if (strOptString3.equalsIgnoreCase("0")) {
                if (Helper.isvisible.equalsIgnoreCase("0")) {
                    if (i > Helper.getVersionCode(this) || Helper.getVersionCode(this) < i2) {
                        if (Helper.getVersionCode(this) < i2) {
                            strOptString3 = "1";
                        }
                        getVersionUpdateDialog(this, strOptString3);
                        return;
                    }
                    init_splash(this.is_security);
                    return;
                }
                return;
            }
            Helper.isvisible = "0";
            if (i > Helper.getVersionCode(this) || Helper.getVersionCode(this) < i2) {
                if (Helper.getVersionCode(this) < i2) {
                    strOptString3 = "1";
                }
                getVersionUpdateDialog(this, strOptString3);
                return;
            }
            init_splash(this.is_security);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this, "" + jsonstring, 0).show();
    }

    public void getMaintanaceDialog(final Activity ctx, String breakFrom, String breakTo) {
        if (!"1".equalsIgnoreCase("1")) {
            if (!"1".equalsIgnoreCase("2")) {
                if (!"1".equalsIgnoreCase("3")) {
                    if (!"1".equalsIgnoreCase("4")) {
                        if (!"1".equalsIgnoreCase("5")) {
                            if (!"1".equalsIgnoreCase("6")) {
                                if (!"1".equalsIgnoreCase("7") || TextUtils.isEmpty(breakFrom) || TextUtils.isEmpty(breakTo)) {
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
                                    DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.15
                                        @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                                        public void onOKClick() {
                                            ctx.finish();
                                        }
                                    });
                                    return;
                                }
                                if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                                    this.nextActivity = DashboardActivityTheme8.class;
                                    int i = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                                    if (i == 1) {
                                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                                    } else if (i == 2) {
                                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                                    }
                                } else {
                                    this.nextActivity = Helper.setSignInActivity();
                                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                                }
                                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda10
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$getMaintanaceDialog$8();
                                    }
                                }, this.SPLASH_TIME_OUT);
                                return;
                            }
                            if (TextUtils.isEmpty(breakFrom) || TextUtils.isEmpty(breakTo)) {
                                return;
                            }
                            long j3 = Long.parseLong(breakFrom);
                            long j4 = Long.parseLong(breakTo);
                            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
                            Date date3 = new Date(j3);
                            Date date4 = new Date(j4);
                            Date time2 = Calendar.getInstance().getTime();
                            String str2 = simpleDateFormat2.format(time2);
                            if ((time2.after(date3) && time2.before(date4)) || str2.equals(simpleDateFormat2.format(date3)) || str2.equals(simpleDateFormat2.format(date4))) {
                                DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.14
                                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                                    public void onOKClick() {
                                        ctx.finish();
                                    }
                                });
                                return;
                            }
                            if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                                this.nextActivity = DashboardActivityTheme7.class;
                                int i2 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                                if (i2 == 1) {
                                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                                } else if (i2 == 2) {
                                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                                }
                            } else {
                                this.nextActivity = Helper.setSignInActivity();
                                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                            }
                            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda9
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$getMaintanaceDialog$7();
                                }
                            }, this.SPLASH_TIME_OUT);
                            return;
                        }
                        if (TextUtils.isEmpty(breakFrom) || TextUtils.isEmpty(breakTo)) {
                            return;
                        }
                        long j5 = Long.parseLong(breakFrom);
                        long j6 = Long.parseLong(breakTo);
                        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
                        Date date5 = new Date(j5);
                        Date date6 = new Date(j6);
                        Date time3 = Calendar.getInstance().getTime();
                        String str3 = simpleDateFormat3.format(time3);
                        if ((time3.after(date5) && time3.before(date6)) || str3.equals(simpleDateFormat3.format(date5)) || str3.equals(simpleDateFormat3.format(date6))) {
                            DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.12
                                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                                public void onOKClick() {
                                    ctx.finish();
                                }
                            });
                            return;
                        }
                        if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                            this.nextActivity = DashboardActivityTheme5.class;
                            int i3 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                            if (i3 == 1) {
                                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                            } else if (i3 == 2) {
                                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                            }
                        } else {
                            this.nextActivity = Helper.setSignInActivity();
                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                        }
                        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.13
                            @Override // java.lang.Runnable
                            public void run() {
                                SplashActivityThemes splashActivityThemes = SplashActivityThemes.this;
                                splashActivityThemes.lambda$init_splash$4(splashActivityThemes.is_security);
                            }
                        }, this.SPLASH_TIME_OUT);
                        return;
                    }
                    if (TextUtils.isEmpty(breakFrom) || TextUtils.isEmpty(breakTo)) {
                        return;
                    }
                    long j7 = Long.parseLong(breakFrom);
                    long j8 = Long.parseLong(breakTo);
                    SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
                    Date date7 = new Date(j7);
                    Date date8 = new Date(j8);
                    Date time4 = Calendar.getInstance().getTime();
                    String str4 = simpleDateFormat4.format(time4);
                    if ((time4.after(date7) && time4.before(date8)) || str4.equals(simpleDateFormat4.format(date7)) || str4.equals(simpleDateFormat4.format(date8))) {
                        DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.10
                            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                            public void onOKClick() {
                                ctx.finish();
                            }
                        });
                        return;
                    }
                    if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                        this.nextActivity = DashboardActivityTheme4.class;
                        int i4 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                        if (i4 == 1) {
                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                        } else if (i4 == 2) {
                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                        }
                    } else {
                        this.nextActivity = Helper.setSignInActivity();
                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.11
                        @Override // java.lang.Runnable
                        public void run() {
                            SplashActivityThemes splashActivityThemes = SplashActivityThemes.this;
                            splashActivityThemes.lambda$init_splash$4(splashActivityThemes.is_security);
                        }
                    }, this.SPLASH_TIME_OUT);
                    return;
                }
                if (TextUtils.isEmpty(breakFrom) || TextUtils.isEmpty(breakTo)) {
                    return;
                }
                long j9 = Long.parseLong(breakFrom);
                long j10 = Long.parseLong(breakTo);
                SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
                Date date9 = new Date(j9);
                Date date10 = new Date(j10);
                Date time5 = Calendar.getInstance().getTime();
                String str5 = simpleDateFormat5.format(time5);
                if ((time5.after(date9) && time5.before(date10)) || str5.equals(simpleDateFormat5.format(date9)) || str5.equals(simpleDateFormat5.format(date10))) {
                    DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.8
                        @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                        public void onOKClick() {
                            ctx.finish();
                        }
                    });
                    return;
                }
                if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                    this.nextActivity = DashboardActivityTheme3.class;
                    int i5 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                    if (i5 == 1) {
                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                    } else if (i5 == 2) {
                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                    }
                } else {
                    this.nextActivity = Helper.setSignInActivity();
                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                }
                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.9
                    @Override // java.lang.Runnable
                    public void run() {
                        SplashActivityThemes splashActivityThemes = SplashActivityThemes.this;
                        splashActivityThemes.lambda$init_splash$4(splashActivityThemes.is_security);
                    }
                }, this.SPLASH_TIME_OUT);
                return;
            }
            if (TextUtils.isEmpty(breakFrom) || TextUtils.isEmpty(breakTo)) {
                return;
            }
            long j11 = Long.parseLong(breakFrom);
            long j12 = Long.parseLong(breakTo);
            SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
            Date date11 = new Date(j11);
            Date date12 = new Date(j12);
            Date time6 = Calendar.getInstance().getTime();
            String str6 = simpleDateFormat6.format(time6);
            if ((time6.after(date11) && time6.before(date12)) || str6.equals(simpleDateFormat6.format(date11)) || str6.equals(simpleDateFormat6.format(date12))) {
                DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.6
                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                    public void onOKClick() {
                        ctx.finish();
                    }
                });
                return;
            }
            if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                this.nextActivity = DashboardActivityTheme2.class;
                int i6 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                if (i6 == 1) {
                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                } else if (i6 == 2) {
                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                }
            } else {
                this.nextActivity = Helper.setSignInActivity();
                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
            }
            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.7
                @Override // java.lang.Runnable
                public void run() {
                    SplashActivityThemes splashActivityThemes = SplashActivityThemes.this;
                    splashActivityThemes.lambda$init_splash$4(splashActivityThemes.is_security);
                }
            }, this.SPLASH_TIME_OUT);
            return;
        }
        if (TextUtils.isEmpty(breakFrom) || TextUtils.isEmpty(breakTo)) {
            return;
        }
        long j13 = Long.parseLong(breakFrom);
        long j14 = Long.parseLong(breakTo);
        SimpleDateFormat simpleDateFormat7 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
        Date date13 = new Date(j13);
        Date date14 = new Date(j14);
        Date time7 = Calendar.getInstance().getTime();
        String str7 = simpleDateFormat7.format(time7);
        if ((time7.after(date13) && time7.before(date14)) || str7.equals(simpleDateFormat7.format(date13)) || str7.equals(simpleDateFormat7.format(date14))) {
            DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.4
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public void onOKClick() {
                    ctx.finish();
                }
            });
            return;
        }
        if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
            this.nextActivity = DashboardActivityTheme1.class;
            int i7 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
            if (i7 == 1) {
                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
            } else if (i7 == 2) {
                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
            }
        } else {
            this.nextActivity = Helper.setSignInActivity();
            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes.5
            @Override // java.lang.Runnable
            public void run() {
                SplashActivityThemes splashActivityThemes = SplashActivityThemes.this;
                splashActivityThemes.lambda$init_splash$4(splashActivityThemes.is_security);
            }
        }, this.SPLASH_TIME_OUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMaintanaceDialog$7() {
        lambda$init_splash$4(this.is_security);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMaintanaceDialog$8() {
        lambda$init_splash$4(this.is_security);
    }

    public void getVersionUpdateDialog(final Activity ctx, String androidType) {
        final boolean z = !androidType.equalsIgnoreCase("0");
        DialogUtils.makeDialog(ctx, ctx.getString(R.string.update_app_dialog_title), ctx.getString(R.string.update_app_dialog_message), ctx.getResources().getString(R.string.update), ctx.getResources().getString(R.string.cancel), z, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda0
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                SplashActivityThemes.lambda$getVersionUpdateDialog$9(ctx);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.base.themes.splash.SplashActivityThemes$$ExternalSyntheticLambda2
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                this.f$0.lambda$getVersionUpdateDialog$10(z, ctx);
            }
        });
    }

    static /* synthetic */ void lambda$getVersionUpdateDialog$9(Activity activity) {
        Helper.rateapp(activity);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVersionUpdateDialog$10(boolean z, Activity activity) {
        if (z) {
            activity.finish();
        } else {
            init_splash(this.is_security);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Runnable runnable;
        super.onBackPressed();
        Handler handler = this.handler;
        if (handler != null && (runnable = this.myRunnable) != null) {
            handler.removeCallbacks(runnable);
        }
        finishAffinity();
    }
}
