package com.appnew.android.Login.Activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;
import com.appnew.android.BuildConfig;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.DrmLogPrinter;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SecurityUtils;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.Store;
import com.eduteria.app.app.R;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class SplashScreen extends Activity implements NetworkCall.MyNetworkCallBack {
    private static int SPLASH_TIME_OUT;
    public static Intent intent;
    Context context;
    private String courseid;
    private String deeplinkUrl;
    private String fileId;
    private String filetype;
    private String maincouseidAffair;
    Runnable myRunnable;
    NetworkCall networkCall;
    Class nextActivity;
    private String parentid;
    private String pdfid;
    private String pdftitle;
    private String pdfurl;
    private String postId;
    ProgressBar progressBar;
    private String revertApi;
    ImageView splashGIF;
    ImageView splashImage;
    RelativeLayout splashRelative;
    VideoView splashVideo;
    private String tileId;
    private String tileType;
    private String topicId;
    private UtkashRoom utkashRoom;
    DrmLogPrinter drmLogPrinter = new DrmLogPrinter();
    private String fragType = Const.HOME;
    private String comboId = "";
    private String videoid = "";
    private String media_id = "";
    private String tileid = "";
    private String tiletype = "";
    boolean isexit = false;
    Handler handler = new Handler();
    String type = "";
    String is_security = "0";
    String SplashType = "0";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03a3 A[Catch: Exception -> 0x03ab, TryCatch #1 {Exception -> 0x03ab, blocks: (B:102:0x0393, B:104:0x03a3, B:105:0x03a7), top: B:112:0x0393 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03a7 A[Catch: Exception -> 0x03ab, TRY_LEAVE, TryCatch #1 {Exception -> 0x03ab, blocks: (B:102:0x0393, B:104:0x03a3, B:105:0x03a7), top: B:112:0x0393 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0372  */
    /* JADX WARN: Type inference failed for: r21v0, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v14 */
    /* JADX WARN: Type inference failed for: r21v2, types: [androidx.media3.exoplayer.ExoPlayer] */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r21v6, types: [androidx.media3.exoplayer.ExoPlayer] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r21) {
        /*
            Method dump skipped, instruction units count: 944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Login.Activity.SplashScreen.onCreate(android.os.Bundle):void");
    }

    private void enableEdgeToEdgeUI() {
        Window window = getWindow();
        window.setFlags(512, 512);
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(1);
                insetsController.setSystemBarsAppearance(8, 8);
            }
        } else {
            window.getDecorView().setSystemUiVisibility(9984);
        }
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
    }

    private void UniversalLink() {
        Uri data = getIntent().getData();
        if (data != null) {
            String strValueOf = String.valueOf(data);
            String dynamicLinkUrl = Helper.getDynamicLinkUrl(this);
            if (strValueOf.startsWith(dynamicLinkUrl)) {
                Uri uri = Uri.parse(AES.shareDataDecrypt(strValueOf.substring(dynamicLinkUrl.length())));
                if (uri.getBooleanQueryParameter("maincouseid", false)) {
                    this.fragType = "course";
                    String queryParameter = uri.getQueryParameter("maincouseid");
                    String queryParameter2 = uri.getQueryParameter("iscombo");
                    this.comboId = uri.getQueryParameter("comboid");
                    String queryParameter3 = uri.getQueryParameter("parentcourseid");
                    SharedPreference.getInstance().putString("maincourseid", queryParameter);
                    SharedPreference.getInstance().putString("iscombo", queryParameter2);
                    if (queryParameter3 == null) {
                        this.parentid = "";
                        SharedPreference.getInstance().putString("parentcourseid", "");
                    } else {
                        this.parentid = queryParameter3;
                        SharedPreference.getInstance().putString("parentcourseid", queryParameter3);
                    }
                } else if (uri.getBooleanQueryParameter("maincouseidlive", false)) {
                    this.fragType = "video";
                    this.courseid = uri.getQueryParameter("maincouseidlive");
                    this.fileId = uri.getQueryParameter("fieldid");
                    this.topicId = uri.getQueryParameter("topicid");
                    this.tileType = uri.getQueryParameter(Const.TILE_TYPE);
                    this.revertApi = revertapi(uri.toString());
                    this.tileId = uri.getQueryParameter("tileid");
                    this.parentid = uri.getQueryParameter(Const.shareparentid);
                } else if (uri.getBooleanQueryParameter("maincouseidjw", false)) {
                    this.fragType = "jwvideo";
                    this.courseid = uri.getQueryParameter("maincouseidjw");
                    this.fileId = uri.getQueryParameter("fieldid");
                    this.topicId = uri.getQueryParameter("topicid");
                    this.tileType = uri.getQueryParameter(Const.TILE_TYPE);
                    this.revertApi = revertapi(uri.toString());
                    this.tileId = uri.getQueryParameter("tileid");
                    this.parentid = uri.getQueryParameter(Const.shareparentid);
                } else if (uri.getBooleanQueryParameter("mainpdfid", false)) {
                    this.fragType = Const.PDF;
                    this.courseid = uri.getQueryParameter("mainpdfid");
                    this.fileId = uri.getQueryParameter("fieldid");
                    this.topicId = uri.getQueryParameter("topicid");
                    this.tileType = uri.getQueryParameter(Const.TILE_TYPE);
                    this.revertApi = revertapi(uri.toString());
                    this.tileId = uri.getQueryParameter("tileid");
                    this.parentid = uri.getQueryParameter(Const.shareparentid);
                } else if (uri.getBooleanQueryParameter("testcourseid", false)) {
                    this.fragType = Const.TEST;
                    this.courseid = uri.getQueryParameter("testcourseid");
                    this.fileId = uri.getQueryParameter("fieldid");
                    this.topicId = uri.getQueryParameter("topicid");
                    this.tileType = uri.getQueryParameter(Const.TILE_TYPE);
                    this.revertApi = revertapi(uri.toString());
                    this.tileId = uri.getQueryParameter("tileid");
                    this.parentid = uri.getQueryParameter(Const.shareparentid);
                } else if (uri.getQueryParameterNames().contains("postid")) {
                    this.fragType = Const.POST;
                    this.postId = uri.getQueryParameter("postid");
                } else if (uri.getQueryParameterNames().contains("maincouseidAffair")) {
                    this.fragType = "currentAffair";
                    this.maincouseidAffair = uri.getQueryParameter("maincouseidAffair");
                }
                if (this.parentid == null) {
                    this.parentid = "";
                }
            }
        }
    }

    public void changeAppIcon(String iconNumber) {
        PackageManager packageManager = getPackageManager();
        ComponentName componentName = new ComponentName(this, "com.appnew.android.ActivityAlias1");
        ComponentName componentName2 = new ComponentName(this, "com.appnew.android.ActivityAlias2");
        ComponentName componentName3 = new ComponentName(this, "com.appnew.android.ActivityAlias3");
        ComponentName componentName4 = new ComponentName(this, "com.appnew.android.Login.Activity.SplashScreen");
        if (iconNumber.equalsIgnoreCase("1")) {
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } else if (iconNumber.equalsIgnoreCase("2")) {
            packageManager.setComponentEnabledSetting(componentName2, 1, 1);
        } else if (iconNumber.equalsIgnoreCase("3")) {
            packageManager.setComponentEnabledSetting(componentName3, 1, 1);
        }
        packageManager.setComponentEnabledSetting(componentName4, 2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callToNoteTime() {
        SPLASH_TIME_OUT += Store.STORE_DELETE_RECORD_FAILED;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Login.Activity.SplashScreen.2
            @Override // java.lang.Runnable
            public void run() {
                if (SplashScreen.SPLASH_TIME_OUT > 0) {
                    SplashScreen.this.callToNoteTime();
                }
            }
        }, 500L);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (Helper.isConnected(this)) {
            callToNoteTime();
            this.networkCall.NetworkAPICall(API.API_GET_APP_VERSION, "", false, false);
            getStudentClass();
            return;
        }
        Helper.isNoInternet(this.utkashRoom, this, this.is_security);
    }

    private void getStudentClass() {
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
            if (SharedPreference.getInstance().getString("Student_List") == null || SharedPreference.getInstance().getString("Student_List").equalsIgnoreCase("")) {
                this.networkCall.NetworkAPICall(API.API_STUDENT_CLASS, "", false, false);
            }
        }
    }

    public void init_splash(final String is_security) {
        if (!"1".equalsIgnoreCase("1")) {
            if (!"1".equalsIgnoreCase("2")) {
                if ("1".equalsIgnoreCase("3")) {
                    if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                        this.nextActivity = DashboardActivityTheme3.class;
                        int i = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                        if (i == 1) {
                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                        } else if (i == 2) {
                            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                        }
                    } else {
                        this.nextActivity = Helper.setSignInActivity();
                        FacebookEventLogger.logLoginScreen(this);
                        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                    }
                    Runnable runnable = new Runnable() { // from class: com.appnew.android.Login.Activity.SplashScreen$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$init_splash$2(is_security);
                        }
                    };
                    this.myRunnable = runnable;
                    this.handler.postDelayed(runnable, SPLASH_TIME_OUT);
                    return;
                }
                return;
            }
            if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                this.nextActivity = DashboardActivityTheme2.class;
                int i2 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
                if (i2 == 1) {
                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
                } else if (i2 == 2) {
                    Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
                }
            } else {
                this.nextActivity = Helper.setSignInActivity();
                FacebookEventLogger.logLoginScreen(this);
                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
            }
            Runnable runnable2 = new Runnable() { // from class: com.appnew.android.Login.Activity.SplashScreen$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$init_splash$1(is_security);
                }
            };
            this.myRunnable = runnable2;
            this.handler.postDelayed(runnable2, SPLASH_TIME_OUT);
            return;
        }
        if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
            this.nextActivity = DashboardActivityTheme1.class;
            int i3 = SharedPreference.getInstance().getInt(Const.LANGUAGE);
            if (i3 == 1) {
                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
            } else if (i3 == 2) {
                Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
            }
        } else {
            this.nextActivity = Helper.setSignInActivity();
            FacebookEventLogger.logLoginScreen(this);
            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
        }
        Runnable runnable3 = new Runnable() { // from class: com.appnew.android.Login.Activity.SplashScreen$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init_splash$0(is_security);
            }
        };
        this.myRunnable = runnable3;
        this.handler.postDelayed(runnable3, SPLASH_TIME_OUT);
    }

    public void CheckDeepLinking() {
        FirebaseDynamicLinks.getInstance().getDynamicLink(getIntent()).addOnSuccessListener(this, new OnSuccessListener() { // from class: com.appnew.android.Login.Activity.SplashScreen$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$CheckDeepLinking$3((PendingDynamicLinkData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$CheckDeepLinking$3(PendingDynamicLinkData pendingDynamicLinkData) {
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

    /* JADX INFO: renamed from: next, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$init_splash$2(String is_security) {
        if ("1".equalsIgnoreCase(is_security)) {
            SecurityUtils.INSTANCE.checkSecurityAsync(this, new SecurityUtils.SecurityCallback() { // from class: com.appnew.android.Login.Activity.SplashScreen.3
                @Override // com.appnew.android.Utils.SecurityUtils.SecurityCallback
                public void onSecurityRiskDetected(String reason) {
                    SplashScreen splashScreen = SplashScreen.this;
                    DialogUtils.makeSingleButtonDialog(splashScreen, "", reason, splashScreen.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Login.Activity.SplashScreen.3.1
                        @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                        public void onOKClick() {
                            SplashScreen.this.finish();
                        }
                    });
                }

                @Override // com.appnew.android.Utils.SecurityUtils.SecurityCallback
                public void onSafe() {
                    SplashScreen.this.openHomePage();
                }
            });
            SecurityUtils.INSTANCE.startDisplayWatcher(this, new SecurityUtils.SecurityCallback() { // from class: com.appnew.android.Login.Activity.SplashScreen.4
                @Override // com.appnew.android.Utils.SecurityUtils.SecurityCallback
                public void onSafe() {
                }

                @Override // com.appnew.android.Utils.SecurityUtils.SecurityCallback
                public void onSecurityRiskDetected(String reason) {
                    SplashScreen splashScreen = SplashScreen.this;
                    DialogUtils.makeSingleButtonDialog(splashScreen, "", reason, splashScreen.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Login.Activity.SplashScreen.4.1
                        @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                        public void onOKClick() {
                            SplashScreen.this.finish();
                        }
                    });
                }
            });
        } else {
            openHomePage();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0726  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x08de  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0911  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0287  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void openHomePage() {
        /*
            Method dump skipped, instruction units count: 2828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Login.Activity.SplashScreen.openHomePage():void");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CustomContextWrapper.wrap(newBase, SharedPreference.getInstance().getString(Const.APP_LANGUAGE)));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    public String bluestack() {
        return "Build.PRODUCT: " + Build.PRODUCT + "\nBuild.MANUFACTURER: " + Build.MANUFACTURER + "\nBuild.BRAND: " + Build.BRAND + "\nBuild.DEVICE: " + Build.DEVICE + "\nBuild.MODEL: " + Build.MODEL + "\nBuild.HARDWARE: " + Build.HARDWARE + "\nBuild.FINGERPRINT: " + Build.FINGERPRINT;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.API_GET_APP_VERSION)) {
            return service.getAppVersion();
        }
        if (apitype.equals(API.API_STUDENT_CLASS)) {
            return service.getStudentClass();
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_GET_APP_VERSION)) {
            if (jsonObject.optString("status").equals("true")) {
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
                if (jSONObject.has(Const.SPLASH_DATA)) {
                    SharedPreference.getInstance().putString(Const.SPLASH_DATA, String.valueOf(jSONObject.optJSONObject(Const.SPLASH_DATA)));
                    if (jSONObject.optJSONObject(Const.SPLASH_DATA).has("type")) {
                        jSONObject.optJSONObject(Const.SPLASH_DATA).get("type").equals("video");
                    }
                    if (jSONObject.optJSONObject(Const.SPLASH_DATA).has(Const.SPLASH_URL)) {
                        SharedPreference.getInstance().putString(Const.SPLASH_URL, jSONObject.optJSONObject(Const.SPLASH_DATA).get(Const.SPLASH_URL).toString());
                    }
                    if (jSONObject.optJSONObject(Const.SPLASH_DATA).has(Const.SPLASH_TIMING)) {
                        SharedPreference.getInstance().putString(Const.SPLASH_TIMING, jSONObject.optJSONObject(Const.SPLASH_DATA).get(Const.SPLASH_TIMING).toString());
                    }
                }
                if (jSONObject.has(Const.DIVISION)) {
                    SharedPreference.getInstance().putString(Const.DIVISION, jSONObject.getJSONArray(Const.DIVISION).toString());
                }
                if (jSONObject.has("in_release")) {
                    SharedPreference.getInstance().putString("in_release", jSONObject.optString("in_release"));
                }
                if (jSONObject.has("in_release_user")) {
                    SharedPreference.getInstance().putString("in_release_user", jSONObject.optString("in_release_user"));
                }
                if (jSONObject.has("permissions")) {
                    SharedPreference.getInstance().putString(Const.FloatingMobileNumber, jSONObject.optJSONObject("permissions").optString(Const.FloatingMobileNumber));
                    SharedPreference.getInstance().putString(Const.EnableScreenshot, jSONObject.optJSONObject("permissions").optString(Const.EnableScreenshot));
                    SharedPreference.getInstance().putString(Const.SHOW_GREETING, jSONObject.optJSONObject("permissions").optString("greeting"));
                    SharedPreference.getInstance().putString(Const.EMAIL_SHOW, jSONObject.optJSONObject("permissions").optString(Const.EMAIL_SHOW));
                    SharedPreference.getInstance().putString(Const.IS_GOOGLE_LOGIN_ENABLE, jSONObject.optJSONObject("permissions").optString("google_login"));
                    SharedPreference.getInstance().putString(Const.DOB_SHOW, jSONObject.optJSONObject("permissions").optString("date_of_birth"));
                    SharedPreference.getInstance().putString(Const.EXPERT_SHOW, jSONObject.optJSONObject("permissions").optString(Const.IS_EXPERT));
                    SharedPreference.getInstance().putString(Const.HIDE_CITY_STATE, jSONObject.optJSONObject("permissions").optString("is_state_validate"));
                    SharedPreference.getInstance().putString(Const.IS_GSTIN, jSONObject.optJSONObject("permissions").optString(Const.IS_GSTIN));
                    SharedPreference.getInstance().putString(Const.DRM_ACCESS_KEY, jSONObject.optJSONObject("permissions").optString(Const.DRM_ACCESS_KEY));
                    SharedPreference.getInstance().putString(Const.DRM_SECRET_KEY, jSONObject.optJSONObject("permissions").optString(Const.DRM_SECRET_KEY));
                    SharedPreference.getInstance().putString(Const.VIDEOCRYPT_ACCOUNT_ID, jSONObject.optJSONObject("permissions").optString(Const.VIDEOCRYPT_ACCOUNT_ID));
                    SharedPreference.getInstance().putString(Const.ENABLE_TEST_SCREENSHOT, jSONObject.optJSONObject("permissions").optString(Const.ENABLE_TEST_SCREENSHOT));
                    if (jSONObject.optJSONObject("permissions").has(UserDataStore.COUNTRY)) {
                        SharedPreference.getInstance().putString(Const.COUNTRY_SHOW, jSONObject.optJSONObject("permissions").optString(UserDataStore.COUNTRY));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.EMAIL_FORM_SHOW)) {
                        SharedPreference.getInstance().putString(Const.EMAIL_FORM_SHOW, jSONObject.optJSONObject("permissions").optString(Const.EMAIL_FORM_SHOW));
                    } else {
                        SharedPreference.getInstance().putString(Const.EMAIL_FORM_SHOW, "1");
                    }
                    if (jSONObject.optJSONObject("permissions").has("gender")) {
                        jSONObject.optJSONObject("permissions").optString("gender");
                        SharedPreference.getInstance().putString(Const.GENDER_SHOW, jSONObject.optJSONObject("permissions").optString("gender"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("caste_category")) {
                        jSONObject.optJSONObject("permissions").optString("caste_category");
                        SharedPreference.getInstance().putString(Const.CASTE_SHOW, jSONObject.optJSONObject("permissions").optString("caste_category"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("father_name")) {
                        jSONObject.optJSONObject("permissions").optString("father_name");
                        SharedPreference.getInstance().putString(Const.FATHER_SHOW, jSONObject.optJSONObject("permissions").optString("father_name"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("address")) {
                        jSONObject.optJSONObject("permissions").optString("address");
                        SharedPreference.getInstance().putString(Const.ADDRESS_SHOW, jSONObject.optJSONObject("permissions").optString("address"));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.MARKSHEET_SHOW)) {
                        jSONObject.optJSONObject("permissions").optString(Const.MARKSHEET_SHOW);
                        SharedPreference.getInstance().putString(Const.MARKSHEET_SHOW, jSONObject.optJSONObject("permissions").optString(Const.MARKSHEET_SHOW));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.PROFILE_PICTURE)) {
                        jSONObject.optJSONObject("permissions").optString(Const.PROFILE_PICTURE);
                        SharedPreference.getInstance().putString(Const.PHOTO_SHOW, jSONObject.optJSONObject("permissions").optString(Const.PROFILE_PICTURE));
                    }
                    if (jSONObject.optJSONObject("permissions").has("alt_mobile")) {
                        jSONObject.optJSONObject("permissions").optString("alt_mobile");
                        SharedPreference.getInstance().putString(Const.ALTERNATE_SHOW, jSONObject.optJSONObject("permissions").optString("alt_mobile"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("pin_code")) {
                        SharedPreference.getInstance().putString(Const.PIN_CODE_SHOW, jSONObject.optJSONObject("permissions").optString("pin_code"));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.LANGUAGE)) {
                        SharedPreference.getInstance().putString(Const.LANG_SHOW, jSONObject.optJSONObject("permissions").optString(Const.LANGUAGE));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.ATTENDANCE_REPORT)) {
                        SharedPreference.getInstance().putString(Const.ATTENDANCE_REPORT, jSONObject.optJSONObject("permissions").optString(Const.ATTENDANCE_REPORT));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.CONTACTUS_MOBILE1)) {
                        SharedPreference.getInstance().putString(Const.CONTACTUS_MOBILE1, jSONObject.optJSONObject("permissions").optString(Const.CONTACTUS_MOBILE1));
                    }
                    if (jSONObject.optJSONObject("permissions").has("contactus_mobile2")) {
                        SharedPreference.getInstance().putString(Const.CONTACTUS_MOBILE2, jSONObject.optJSONObject("permissions").optString("contactus_mobile2"));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.CHANGE_CONTACT)) {
                        SharedPreference.getInstance().putString(Const.CHANGE_CONTACT, jSONObject.optJSONObject("permissions").optString(Const.CHANGE_CONTACT));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.GOVERNMENET_ID)) {
                        SharedPreference.getInstance().putString(Const.GOVERNMENET_ID, jSONObject.optJSONObject("permissions").optString(Const.GOVERNMENET_ID));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.EMAIL_UPDATE_POPUP)) {
                        SharedPreference.getInstance().putString(Const.EMAIL_UPDATE_POPUP, jSONObject.optJSONObject("permissions").optString(Const.EMAIL_UPDATE_POPUP));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.CUSTOM_YOUTUBE_PLAYER)) {
                        SharedPreference.getInstance().putString(Const.CUSTOM_YOUTUBE_PLAYER, jSONObject.optJSONObject("permissions").optString(Const.CUSTOM_YOUTUBE_PLAYER));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.WHATSAPP_CHANNEL_DATA)) {
                        SharedPreference.getInstance().putString(Const.WHATSAPP_CHANNEL_DATA, jSONObject.optJSONObject("permissions").optString(Const.WHATSAPP_CHANNEL_DATA));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.HIDE_SIGNUP)) {
                        SharedPreference.getInstance().putString(Const.HIDE_SIGNUP, jSONObject.optJSONObject("permissions").optString(Const.HIDE_SIGNUP));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.TEACHER_TIME_TABLE)) {
                        SharedPreference.getInstance().putString(Const.TEACHER_TIME_TABLE, jSONObject.optJSONObject("permissions").optString(Const.TEACHER_TIME_TABLE));
                    }
                    if (jSONObject.optJSONObject("permissions").has("doubt_firebase_chat")) {
                        SharedPreference.getInstance().putString(Const.DOUBT_FIREBASE_CHAT, jSONObject.optJSONObject("permissions").optString("doubt_firebase_chat"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("cumulative_test_report")) {
                        SharedPreference.getInstance().putString(Const.cumulative_test_report, jSONObject.optJSONObject("permissions").optString("cumulative_test_report"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("notice_board")) {
                        SharedPreference.getInstance().putString(Const.notice_board, jSONObject.optJSONObject("permissions").optString("notice_board"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("hide_FIB")) {
                        SharedPreference.getInstance().putString(Const.HIDE_FIB, jSONObject.optJSONObject("permissions").optString("hide_FIB"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("horizontal_course")) {
                        SharedPreference.getInstance().putString(Const.HORIZONTAL_COURSE, jSONObject.optJSONObject("permissions").optString("horizontal_course"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("PdfView_On_VideoList")) {
                        SharedPreference.getInstance().putString(Const.PDFVIEW_ON_VIDEOLIST, jSONObject.optJSONObject("permissions").optString("PdfView_On_VideoList"));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.CUSTOM_TESTSERIES_UI)) {
                        SharedPreference.getInstance().putString(Const.CUSTOM_TESTSERIES_UI, jSONObject.optJSONObject("permissions").optString(Const.CUSTOM_TESTSERIES_UI));
                    }
                    if (jSONObject.optJSONObject("permissions").has("course_event")) {
                        SharedPreference.getInstance().putString("course_event", jSONObject.optJSONObject("permissions").optString("course_event"));
                    }
                    if (jSONObject.optJSONObject("permissions").has("rank_compayer")) {
                        SharedPreference.getInstance().putString("rank_compayer", jSONObject.optJSONObject("permissions").optString("rank_compayer"));
                    }
                    SharedPreference.getInstance().putString(Const.SHOW_CERTIFICATE, jSONObject.optJSONObject("permissions").optString(Const.SHOW_CERTIFICATE));
                    SharedPreference.getInstance().putString(Const.IS_AUTO_PLAY, jSONObject.optJSONObject("permissions").optString("video_autoplay"));
                    SharedPreference.getInstance().putString(Const.IS_RECENT_WATCH, jSONObject.optJSONObject("permissions").optString("recent_watch"));
                    SharedPreference.getInstance().putString(Const.AUDIO_LISTEN, jSONObject.optJSONObject("permissions").optString(Const.AUDIO_LISTEN));
                    SharedPreference.getInstance().putString(Const.MY_DOWNLOAD_TABS, jSONObject.optJSONObject("permissions").optString("my_downloads_tab"));
                    SharedPreference.getInstance().putString(Const.IN_APP_DOWNLOADS, jSONObject.optJSONObject("permissions").optString(Const.IN_APP_DOWNLOADS));
                    SharedPreference.getInstance().putString(Const.YOUTUBE_DOWNLOAD, jSONObject.optJSONObject("permissions").optString(Const.YOUTUBE_DOWNLOAD));
                    SharedPreference.getInstance().putString(Const.IS_HOME_GRID, jSONObject.optJSONObject("permissions").optString(Const.IS_HOME_GRID));
                    SharedPreference.getInstance().putString(Const.OTP_LOGIN, jSONObject.optJSONObject("permissions").optString(Const.OTP_LOGIN));
                    if (jSONObject.optJSONObject("permissions").optString(Const.Youtube_Player_Control) != null) {
                        SharedPreference.getInstance().putString(Const.Youtube_Player_Control, jSONObject.optJSONObject("permissions").optString(Const.Youtube_Player_Control));
                    }
                    SharedPreference.getInstance().putString(Const.IS_LIVE_CLASS_PDF_SHOW, jSONObject.optJSONObject("permissions").optString(Const.IS_LIVE_CLASS_PDF_SHOW));
                    SharedPreference.getInstance().putString(Const.SAME_CONTENT_VIEW, jSONObject.optJSONObject("permissions").optString(Const.SAME_CONTENT_VIEW));
                    SharedPreference.getInstance().putString(Const.PREFERENCE_SELECTION_TYPE, jSONObject.optJSONObject("permissions").optString(Const.PREFERENCE_SELECTION_TYPE));
                    if (jSONObject.optJSONObject("permissions").has(Const.HIDE_FEED_CATEGORY)) {
                        SharedPreference.getInstance().putString(Const.HIDE_FEED_CATEGORY, jSONObject.optJSONObject("permissions").optString(Const.HIDE_FEED_CATEGORY));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.DASHBOARD_LIVE_CLASS)) {
                        SharedPreference.getInstance().putString(Const.DASHBOARD_LIVE_CLASS, jSONObject.optJSONObject("permissions").optString(Const.DASHBOARD_LIVE_CLASS));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.dashboard_TrendingCourses)) {
                        SharedPreference.getInstance().putString(Const.dashboard_TrendingCourses, jSONObject.optJSONObject("permissions").optString(Const.dashboard_TrendingCourses));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.DASHBOARD_EDUCATORSECTION)) {
                        SharedPreference.getInstance().putString(Const.DASHBOARD_EDUCATORSECTION, jSONObject.optJSONObject("permissions").optString(Const.DASHBOARD_EDUCATORSECTION));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.DASHBOARD_TESTIMONIAL)) {
                        SharedPreference.getInstance().putString(Const.DASHBOARD_TESTIMONIAL, jSONObject.optJSONObject("permissions").optString(Const.DASHBOARD_TESTIMONIAL));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.DASHBOARD_WHATSAPP_BANNER)) {
                        SharedPreference.getInstance().putString(Const.DASHBOARD_WHATSAPP_BANNER, jSONObject.optJSONObject("permissions").optString(Const.DASHBOARD_WHATSAPP_BANNER));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.DASHBOARD_SOCIALMEDIA_ICONS)) {
                        SharedPreference.getInstance().putString(Const.DASHBOARD_SOCIALMEDIA_ICONS, jSONObject.optJSONObject("permissions").optString(Const.DASHBOARD_SOCIALMEDIA_ICONS));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.CUSTOM_TESTSERIES_UI)) {
                        SharedPreference.getInstance().putString(Const.CUSTOM_TESTSERIES_UI, jSONObject.optJSONObject("permissions").optString(Const.CUSTOM_TESTSERIES_UI));
                    }
                    SharedPreference.getInstance().putString(Const.ENROLL_NOW, jSONObject.optJSONObject("permissions").optString(Const.ENROLL_NOW));
                    SharedPreference.getInstance().putString(Const.SHOW_STUDENT_CLASS, jSONObject.optJSONObject("permissions").optString(Const.SHOW_STUDENT_CLASS));
                    SharedPreference.getInstance().putString(Const.SHOW_ROLL_NUMBER, jSONObject.optJSONObject("permissions").optString(Const.SHOW_ROLL_NUMBER));
                    SharedPreference.getInstance().putString(Const.SHOW_SCHOLARSHIP_APPLIED, jSONObject.optJSONObject("permissions").optString(Const.SHOW_SCHOLARSHIP_APPLIED));
                    if (jSONObject.optJSONObject("permissions").has(Const.enableQRCode)) {
                        SharedPreference.getInstance().putString(Const.enableQRCode, jSONObject.optJSONObject("permissions").optString(Const.enableQRCode));
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
                    if (jSONObject.optJSONObject("permissions").has(Const.restrictSystemFont)) {
                        SharedPreference.getInstance().putString(Const.restrictSystemFont, jSONObject.optJSONObject("permissions").optString(Const.restrictSystemFont));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.EnableCleverTap)) {
                        SharedPreference.getInstance().putString(Const.EnableCleverTap, jSONObject.optJSONObject("permissions").optString(Const.EnableCleverTap));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.DEVELOPER_OPTIONS)) {
                        SharedPreference.getInstance().putString(Const.DEVELOPER_OPTIONS, jSONObject.optJSONObject("permissions").optString(Const.DEVELOPER_OPTIONS));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.LOGIN_MESSAGE)) {
                        SharedPreference.getInstance().putString(Const.LOGIN_MESSAGE, jSONObject.optJSONObject("permissions").optString(Const.LOGIN_MESSAGE));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.MAX_SPEED)) {
                        SharedPreference.getInstance().putString(Const.MAX_SPEED, jSONObject.optJSONObject("permissions").optString(Const.MAX_SPEED));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.GRID_TILE)) {
                        SharedPreference.getInstance().putString(Const.GRID_TILE, jSONObject.optJSONObject("permissions").optString(Const.GRID_TILE));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.WEBVIEW_PDF)) {
                        SharedPreference.getInstance().putString(Const.WEBVIEW_PDF, jSONObject.optJSONObject("permissions").optString(Const.WEBVIEW_PDF));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.TILE_CONTENT_MANAGE)) {
                        SharedPreference.getInstance().putString(Const.TILE_CONTENT_MANAGE, jSONObject.optJSONObject("permissions").optString(Const.TILE_CONTENT_MANAGE));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.IS_DAILY_QUESTION)) {
                        SharedPreference.getInstance().putString(Const.IS_DAILY_QUESTION, jSONObject.optJSONObject("permissions").optString(Const.IS_DAILY_QUESTION));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.PROFILE_TEACHER)) {
                        SharedPreference.getInstance().putString(Const.PROFILE_TEACHER, jSONObject.optJSONObject("permissions").optString(Const.PROFILE_TEACHER));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.AUTO_FILL_OTP)) {
                        SharedPreference.getInstance().putString(Const.AUTO_FILL_OTP, jSONObject.optJSONObject("permissions").optString(Const.AUTO_FILL_OTP));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.HARVEST_CLASS_TIME_HIDE)) {
                        SharedPreference.getInstance().putString(Const.HARVEST_CLASS_TIME_HIDE, jSONObject.optJSONObject("permissions").optString(Const.HARVEST_CLASS_TIME_HIDE));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.BITRATE_SELECTION)) {
                        SharedPreference.getInstance().putString(Const.BITRATE_SELECTION, jSONObject.optJSONObject("permissions").optString(Const.BITRATE_SELECTION));
                    }
                    if (jSONObject.optJSONObject("permissions").has(Const.DOWNLOAD_VISIBLE_WITH_INTERNET)) {
                        SharedPreference.getInstance().putString(Const.DOWNLOAD_VISIBLE_WITH_INTERNET, jSONObject.optJSONObject("permissions").optString(Const.DOWNLOAD_VISIBLE_WITH_INTERNET));
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
                return;
            }
            return;
        }
        if (apitype.equals(API.API_STUDENT_CLASS) && jsonObject.optString("status").equals("true")) {
            SharedPreference.getInstance().putString("Student_List", jsonObject.toString());
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this, "" + jsonstring, 0).show();
    }

    public void getMaintanaceDialog(final Activity ctx, String breakFrom, String breakTo) {
        if (!"1".equalsIgnoreCase("1")) {
            if (!"1".equalsIgnoreCase("2")) {
                if (!"1".equalsIgnoreCase("3") || TextUtils.isEmpty(breakFrom) || TextUtils.isEmpty(breakTo)) {
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
                    DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Login.Activity.SplashScreen.9
                        @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                        public void onOKClick() {
                            ctx.finish();
                        }
                    });
                    return;
                }
                if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                    this.nextActivity = DashboardActivityTheme3.class;
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
                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Login.Activity.SplashScreen.10
                    @Override // java.lang.Runnable
                    public void run() {
                        SplashScreen splashScreen = SplashScreen.this;
                        splashScreen.lambda$init_splash$2(splashScreen.is_security);
                    }
                }, SPLASH_TIME_OUT);
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
                DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Login.Activity.SplashScreen.7
                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                    public void onOKClick() {
                        ctx.finish();
                    }
                });
                return;
            }
            if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
                this.nextActivity = DashboardActivityTheme2.class;
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
            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Login.Activity.SplashScreen.8
                @Override // java.lang.Runnable
                public void run() {
                    SplashScreen splashScreen = SplashScreen.this;
                    splashScreen.lambda$init_splash$2(splashScreen.is_security);
                }
            }, SPLASH_TIME_OUT);
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
            DialogUtils.makeSingleButtonDialog(ctx, ctx.getString(R.string.maintain_app_dialog_title), ctx.getString(R.string.maintain_app_dialog_message), ctx.getResources().getString(R.string.close), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Login.Activity.SplashScreen.5
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public void onOKClick() {
                    ctx.finish();
                }
            });
            return;
        }
        if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && SharedPreference.getInstance().getBoolean(Const.IS_USER_REGISTRATION_DONE)) {
            this.nextActivity = DashboardActivityTheme1.class;
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
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Login.Activity.SplashScreen.6
            @Override // java.lang.Runnable
            public void run() {
                SplashScreen splashScreen = SplashScreen.this;
                splashScreen.lambda$init_splash$2(splashScreen.is_security);
            }
        }, SPLASH_TIME_OUT);
    }

    public void getVersionUpdateDialog(final Activity ctx, String androidType) {
        final boolean z = !androidType.equalsIgnoreCase("0");
        DialogUtils.makeDialog(ctx, ctx.getString(R.string.update_app_dialog_title), ctx.getString(R.string.update_app_dialog_message), ctx.getResources().getString(R.string.update), ctx.getResources().getString(R.string.cancel), z, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Login.Activity.SplashScreen.11
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                Helper.rateapp(ctx);
                ctx.finish();
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Login.Activity.SplashScreen$$ExternalSyntheticLambda4
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                this.f$0.lambda$getVersionUpdateDialog$4(z, ctx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVersionUpdateDialog$4(boolean z, Activity activity) {
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
        finishAffinity();
        Handler handler = this.handler;
        if (handler == null || (runnable = this.myRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }
}
