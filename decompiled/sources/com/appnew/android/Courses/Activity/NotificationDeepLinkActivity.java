package com.appnew.android.Courses.Activity;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appnew.android.ApiUpdate;
import com.appnew.android.Login.Activity.SignInActivity;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivityWebFragBinding;
import com.appnew.android.loginRevamp.Activity.SignInNewActivity;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.AudioTable;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: NotificationDeepLinkActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0010\u0010+\u001a\u00020(2\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020(2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010/\u001a\u00020(H\u0002J\b\u00100\u001a\u00020(H\u0016J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0014J\u0014\u00104\u001a\u00020-2\n\u00105\u001a\u0006\u0012\u0002\b\u000306H\u0002J\u001c\u00107\u001a\u00020(2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u00108\u001a\u00020(H\u0002J\u0012\u00109\u001a\u00020(2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/appnew/android/Courses/Activity/NotificationDeepLinkActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityWebFragBinding;", "audioTable", "Lcom/appnew/android/table/AudioTable;", "title", "", "url", "from", Const.NOTIFICATION_CODE, "", "course_id", "fieldid", "id", CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, "", "coupon_for", "topicid", Const.VIDEO_TYPE, "tiletype", "tileid", "revertapi", "type", "imageUrl", Const.MESSAGE_TARGET, "message", Const.shareparentid, Const.FOLDER_ID, Const.FOLDER_CONTENT_TYPE, "solutions", "test_series_name", "test_series_date", "post_id", Const.status_free, "test_id", Constants.PT_NOTIF_ID, "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "pushEventForPushNotification", "logoutUser", "", "setToolBarTitle", "reloadWebView", "onBackPressed", "onNewIntent", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "isActivityInBackStack", "activityClass", "Ljava/lang/Class;", "loadWebView", "getBundledData", "updateUrlAccordingly", "MyBrowser", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationDeepLinkActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private AudioTable audioTable;
    private ActivityWebFragBinding binding;
    private int notification_code;
    private long ts;
    private String title = "";
    private String url = "";
    private String from = "";
    private String course_id = "";
    private String fieldid = "";
    private String id = "";
    private String coupon_for = "";
    private String topicid = "";
    private String video_type = "";
    private String tiletype = "";
    private String tileid = "";
    private String revertapi = "";
    private String type = "";
    private String imageUrl = "";
    private String message_target = "";
    private String message = "";
    private String parentid = "";
    private String folder_id = "";
    private String folderContentType = "";
    private String solutions = "";
    private String test_series_name = "";
    private String test_series_date = "";
    private String post_id = "";
    private String status_free = "";
    private String test_id = "";
    private String notificationId = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NotificationDeepLinkActivity notificationDeepLinkActivity = this;
        Helper.setSystemBarLight(notificationDeepLinkActivity);
        Helper.enableScreenShot(notificationDeepLinkActivity);
        ActivityWebFragBinding activityWebFragBindingInflate = ActivityWebFragBinding.inflate(getLayoutInflater());
        this.binding = activityWebFragBindingInflate;
        ActivityWebFragBinding activityWebFragBinding = null;
        if (activityWebFragBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWebFragBindingInflate = null;
        }
        setContentView(activityWebFragBindingInflate.getRoot());
        ActivityWebFragBinding activityWebFragBinding2 = this.binding;
        if (activityWebFragBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWebFragBinding2 = null;
        }
        setSupportActionBar(activityWebFragBinding2.myProgressToolbar);
        if (!logoutUser()) {
            getBundledData();
        }
        new ApiUpdate(notificationDeepLinkActivity).callApi(API.mark_as_read, "", true, this.notificationId, new Bundle());
        updateUrlAccordingly(this.url);
        try {
            ActivityWebFragBinding activityWebFragBinding3 = this.binding;
            if (activityWebFragBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityWebFragBinding3 = null;
            }
            activityWebFragBinding3.imageIV.setVisibility(8);
            activityWebFragBinding3.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.NotificationDeepLinkActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.onBackPressed();
                }
            });
            activityWebFragBinding3.imageIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.NotificationDeepLinkActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.reloadWebView();
                }
            });
            WebSettings settings = activityWebFragBinding3.webView.getSettings();
            settings.setLoadsImagesAutomatically(true);
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            activityWebFragBinding3.webView.clearCache(true);
            activityWebFragBinding3.webView.clearHistory();
            activityWebFragBinding3.webView.setScrollBarStyle(0);
            WebView webView = activityWebFragBinding3.webView;
            NotificationDeepLinkActivity notificationDeepLinkActivity2 = this;
            ActivityWebFragBinding activityWebFragBinding4 = this.binding;
            if (activityWebFragBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityWebFragBinding = activityWebFragBinding4;
            }
            FrameLayout webframe = activityWebFragBinding.webframe;
            Intrinsics.checkNotNullExpressionValue(webframe, "webframe");
            webView.setWebViewClient(new MyBrowser(notificationDeepLinkActivity2, webframe));
            activityWebFragBinding3.webView.setWebChromeClient(new WebChromeClient() { // from class: com.appnew.android.Courses.Activity.NotificationDeepLinkActivity$onCreate$1$4
                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView view, int newProgress) {
                    ActivityWebFragBinding activityWebFragBinding5 = this.this$0.binding;
                    ActivityWebFragBinding activityWebFragBinding6 = null;
                    if (activityWebFragBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityWebFragBinding5 = null;
                    }
                    activityWebFragBinding5.webframe.setVisibility(0);
                    if (newProgress == 100) {
                        ActivityWebFragBinding activityWebFragBinding7 = this.this$0.binding;
                        if (activityWebFragBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityWebFragBinding6 = activityWebFragBinding7;
                        }
                        activityWebFragBinding6.webframe.setVisibility(8);
                    }
                    super.onProgressChanged(view, newProgress);
                }
            });
            Resources resources = getResources();
            String str = this.from;
            if (str != null && str.length() != 0) {
                loadWebView(this.title, this.url);
                return;
            }
            activityWebFragBinding3.webView.getSettings().setDefaultFontSize((int) resources.getDimension(R.dimen.sp18));
            activityWebFragBinding3.webView.loadUrl(this.url);
            setToolBarTitle(this.title);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void pushEventForPushNotification(String notification_code) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = map;
        map2.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        if (TextUtils.isEmpty(notification_code)) {
            notification_code = "NA";
        }
        map2.put(AnalyticsConstants.push_preview, notification_code);
        map2.put("action_type", "notification_clicked");
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.PUSH_NOTIFICATION, map);
    }

    private final boolean logoutUser() {
        String str = MakeMyExam.userId;
        if (str != null && str.length() != 0) {
            Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
            String id = loggedInUser != null ? loggedInUser.getId() : null;
            if (id != null && id.length() != 0) {
                return false;
            }
        }
        Intent intent = !Helper.isNewLoginFlow() ? new Intent(this, (Class<?>) SignInActivity.class) : new Intent(this, (Class<?>) SignInNewActivity.class);
        intent.putExtra("type", Const.SIGNIN);
        intent.putExtra(Const.OPEN_WITH, "user");
        intent.putExtra(Const.SOCIAL_TYPE, "1");
        intent.setFlags(335544320);
        startActivity(intent);
        finish();
        return true;
    }

    private final void setToolBarTitle(String title) {
        ActivityWebFragBinding activityWebFragBinding = this.binding;
        if (activityWebFragBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWebFragBinding = null;
        }
        TextView textView = activityWebFragBinding.toolbartitleTV;
        textView.setText(title);
        textView.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadWebView() {
        ActivityWebFragBinding activityWebFragBinding = this.binding;
        if (activityWebFragBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWebFragBinding = null;
        }
        if (activityWebFragBinding.webView != null) {
            activityWebFragBinding.webView.reload();
        }
    }

    /* JADX INFO: compiled from: NotificationDeepLinkActivity.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/appnew/android/Courses/Activity/NotificationDeepLinkActivity$MyBrowser;", "Landroid/webkit/WebViewClient;", "context", "Landroid/content/Context;", "webframe", "Landroid/widget/FrameLayout;", "<init>", "(Landroid/content/Context;Landroid/widget/FrameLayout;)V", "shouldOverrideUrlLoading", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "url", "", "request", "Landroid/webkit/WebResourceRequest;", "onPageFinished", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "openPdf", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class MyBrowser extends WebViewClient {
        private final Context context;
        private final FrameLayout webframe;

        public MyBrowser(Context context, FrameLayout webframe) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(webframe, "webframe");
            this.context = context;
            this.webframe = webframe;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url != null) {
                if (StringsKt.endsWith(url, ".pdf", true)) {
                    openPdf(this.context, url);
                } else if (view != null) {
                    view.loadUrl(url);
                }
            }
            this.webframe.setVisibility(0);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Uri url;
            String string;
            if (request != null && (url = request.getUrl()) != null && (string = url.toString()) != null) {
                if (StringsKt.endsWith(string, ".pdf", true)) {
                    openPdf(this.context, string);
                } else if (view != null) {
                    view.loadUrl(string);
                }
            }
            this.webframe.setVisibility(0);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        private final void openPdf(Context context, String url) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(67108864);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(context, context.getString(R.string.no_application_available_to_view_pdf), 0).show();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isActivityInBackStack(DashboardActivityTheme1.class)) {
            super.onBackPressed();
        } else {
            startActivity(new Intent(this, (Class<?>) DashboardActivityTheme1.class));
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        NotificationDeepLinkActivity notificationDeepLinkActivity = this;
        if (Helper.isConnected(notificationDeepLinkActivity) && !logoutUser()) {
            int intExtra = intent.getIntExtra(Const.NOTIFICATION_CODE, 0);
            this.notification_code = intExtra;
            if (intExtra != 0) {
                pushEventForPushNotification(String.valueOf(intExtra));
            }
            String stringExtra = intent.getStringExtra("course_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.course_id = stringExtra;
            String stringExtra2 = intent.getStringExtra("file_id");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.fieldid = stringExtra2;
            String stringExtra3 = intent.getStringExtra("test_id");
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            this.test_id = stringExtra3;
            String stringExtra4 = intent.getStringExtra("coupon_for");
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            this.coupon_for = stringExtra4;
            this.ts = intent.getLongExtra(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, 0L);
            Serializable serializableExtra = intent.getSerializableExtra("audiotable");
            this.audioTable = serializableExtra instanceof AudioTable ? (AudioTable) serializableExtra : null;
            String stringExtra5 = intent.getStringExtra(Const.TOPIC_ID);
            if (stringExtra5 == null) {
                stringExtra5 = "";
            }
            this.topicid = stringExtra5;
            String stringExtra6 = intent.getStringExtra("type");
            if (stringExtra6 == null) {
                stringExtra6 = "";
            }
            this.video_type = stringExtra6;
            String stringExtra7 = intent.getStringExtra(Const.TILE_TYPE);
            if (stringExtra7 == null) {
                stringExtra7 = "";
            }
            this.tiletype = stringExtra7;
            String stringExtra8 = intent.getStringExtra("tile_id");
            if (stringExtra8 == null) {
                stringExtra8 = "";
            }
            this.tileid = stringExtra8;
            String stringExtra9 = intent.getStringExtra(Const.REVERT_API);
            if (stringExtra9 == null) {
                stringExtra9 = "";
            }
            this.revertapi = stringExtra9;
            String stringExtra10 = intent.getStringExtra("type");
            if (stringExtra10 == null) {
                stringExtra10 = "";
            }
            this.type = stringExtra10;
            String stringExtra11 = intent.getStringExtra("title");
            if (stringExtra11 == null) {
                stringExtra11 = "";
            }
            this.title = stringExtra11;
            String stringExtra12 = intent.getStringExtra(TypedValues.AttributesType.S_TARGET);
            if (stringExtra12 == null) {
                stringExtra12 = "";
            }
            this.message_target = stringExtra12;
            String stringExtra13 = intent.getStringExtra("url");
            if (stringExtra13 == null) {
                stringExtra13 = "";
            }
            this.url = stringExtra13;
            String stringExtra14 = intent.getStringExtra("imageUrl");
            if (stringExtra14 == null) {
                stringExtra14 = "";
            }
            this.imageUrl = stringExtra14;
            String stringExtra15 = intent.getStringExtra("description");
            if (stringExtra15 == null) {
                stringExtra15 = "";
            }
            this.message = stringExtra15;
            String stringExtra16 = intent.getStringExtra(Const.shareparentid);
            if (stringExtra16 == null) {
                stringExtra16 = "";
            }
            this.parentid = stringExtra16;
            String stringExtra17 = intent.getStringExtra(Const.FOLDER_ID);
            if (stringExtra17 == null) {
                stringExtra17 = "";
            }
            this.folder_id = stringExtra17;
            String stringExtra18 = intent.getStringExtra(Const.FOLDER_CONTENT_TYPE);
            if (stringExtra18 == null) {
                stringExtra18 = "";
            }
            this.folderContentType = stringExtra18;
            String stringExtra19 = intent.getStringExtra("test_series_name");
            if (stringExtra19 == null) {
                stringExtra19 = "";
            }
            this.test_series_name = stringExtra19;
            String stringExtra20 = intent.getStringExtra("solutions");
            if (stringExtra20 == null) {
                stringExtra20 = "";
            }
            this.solutions = stringExtra20;
            String stringExtra21 = intent.getStringExtra("result_date");
            if (stringExtra21 == null) {
                stringExtra21 = "";
            }
            this.test_series_date = stringExtra21;
            String stringExtra22 = intent.getStringExtra("id");
            if (stringExtra22 == null) {
                stringExtra22 = "";
            }
            this.id = stringExtra22;
            String stringExtra23 = intent.getStringExtra("post_id");
            if (stringExtra23 == null) {
                stringExtra23 = "";
            }
            this.post_id = stringExtra23;
            String stringExtra24 = intent.getStringExtra(Const.status_free);
            this.status_free = stringExtra24 != null ? stringExtra24 : "";
            updateUrlAccordingly(this.url);
            loadWebView(this.title, this.url);
        } else {
            Toast.makeText(notificationDeepLinkActivity, R.string.no_internet_connection, 0).show();
        }
        Log.e("TAG_APP", "onNewIntent:");
    }

    private final boolean isActivityInBackStack(Class<?> activityClass) {
        Object systemService = getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.AppTask> it = ((ActivityManager) systemService).getAppTasks().iterator();
        while (it.hasNext()) {
            ActivityManager.RecentTaskInfo taskInfo = it.next().getTaskInfo();
            ComponentName componentName = taskInfo.topActivity;
            if (Intrinsics.areEqual(componentName != null ? componentName.getClassName() : null, activityClass.getName())) {
                return true;
            }
            ComponentName componentName2 = taskInfo.baseActivity;
            if (Intrinsics.areEqual(componentName2 != null ? componentName2.getClassName() : null, activityClass.getName())) {
                return true;
            }
        }
        return false;
    }

    private final void loadWebView(String title, String url) {
        setToolBarTitle(title);
        ActivityWebFragBinding activityWebFragBinding = this.binding;
        if (activityWebFragBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWebFragBinding = null;
        }
        activityWebFragBinding.webView.getSettings().setDefaultFontSize((int) getResources().getDimension(R.dimen.sp25));
        try {
            WebView webView = activityWebFragBinding.webView;
            String strEncode = URLEncoder.encode(url, "utf-8");
            Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
            webView.loadData(StringsKt.replace$default(strEncode, MqttTopic.SINGLE_LEVEL_WILDCARD, " ", false, 4, (Object) null), "text/html; charset=UTF-8", null);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        activityWebFragBinding.webView.setWebViewClient(new WebViewClient() { // from class: com.appnew.android.Courses.Activity.NotificationDeepLinkActivity$loadWebView$1$1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url2) {
                if (url2 == null) {
                    return false;
                }
                if (!StringsKt.startsWith$default(url2, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(url2, "https://", false, 2, (Object) null)) {
                    return false;
                }
                this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url2)));
                return true;
            }
        });
    }

    private final void getBundledData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.notification_code = intent.getIntExtra(Const.NOTIFICATION_CODE, 0);
            String stringExtra = intent.getStringExtra(Const.NOTIFICATION_ID);
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.notificationId = stringExtra;
            int i = this.notification_code;
            if (i != 0) {
                pushEventForPushNotification(String.valueOf(i));
            }
            String stringExtra2 = intent.getStringExtra("course_id");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.course_id = stringExtra2;
            String stringExtra3 = intent.getStringExtra("file_id");
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            this.fieldid = stringExtra3;
            String stringExtra4 = intent.getStringExtra("test_id");
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            this.test_id = stringExtra4;
            String stringExtra5 = intent.getStringExtra("coupon_for");
            if (stringExtra5 == null) {
                stringExtra5 = "";
            }
            this.coupon_for = stringExtra5;
            this.ts = intent.getLongExtra(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, 0L);
            Serializable serializableExtra = intent.getSerializableExtra("audiotable");
            this.audioTable = serializableExtra instanceof AudioTable ? (AudioTable) serializableExtra : null;
            String stringExtra6 = intent.getStringExtra(Const.TOPIC_ID);
            if (stringExtra6 == null) {
                stringExtra6 = "";
            }
            this.topicid = stringExtra6;
            String stringExtra7 = intent.getStringExtra("type");
            if (stringExtra7 == null) {
                stringExtra7 = "";
            }
            this.video_type = stringExtra7;
            String stringExtra8 = intent.getStringExtra(Const.TILE_TYPE);
            if (stringExtra8 == null) {
                stringExtra8 = "";
            }
            this.tiletype = stringExtra8;
            String stringExtra9 = intent.getStringExtra("tile_id");
            if (stringExtra9 == null) {
                stringExtra9 = "";
            }
            this.tileid = stringExtra9;
            String stringExtra10 = intent.getStringExtra(Const.REVERT_API);
            if (stringExtra10 == null) {
                stringExtra10 = "";
            }
            this.revertapi = stringExtra10;
            String stringExtra11 = intent.getStringExtra("type");
            if (stringExtra11 == null) {
                stringExtra11 = "";
            }
            this.type = stringExtra11;
            String stringExtra12 = intent.getStringExtra("title");
            if (stringExtra12 == null) {
                stringExtra12 = "";
            }
            this.title = stringExtra12;
            String stringExtra13 = intent.getStringExtra(TypedValues.AttributesType.S_TARGET);
            if (stringExtra13 == null) {
                stringExtra13 = "";
            }
            this.message_target = stringExtra13;
            String stringExtra14 = intent.getStringExtra("url");
            if (stringExtra14 == null) {
                stringExtra14 = "";
            }
            this.url = stringExtra14;
            String stringExtra15 = intent.getStringExtra("imageUrl");
            if (stringExtra15 == null) {
                stringExtra15 = "";
            }
            this.imageUrl = stringExtra15;
            String stringExtra16 = intent.getStringExtra("description");
            if (stringExtra16 == null) {
                stringExtra16 = "";
            }
            this.message = stringExtra16;
            String stringExtra17 = intent.getStringExtra(Const.shareparentid);
            if (stringExtra17 == null) {
                stringExtra17 = "";
            }
            this.parentid = stringExtra17;
            String stringExtra18 = intent.getStringExtra(Const.FOLDER_ID);
            if (stringExtra18 == null) {
                stringExtra18 = "";
            }
            this.folder_id = stringExtra18;
            String stringExtra19 = intent.getStringExtra(Const.FOLDER_CONTENT_TYPE);
            if (stringExtra19 == null) {
                stringExtra19 = "";
            }
            this.folderContentType = stringExtra19;
            String stringExtra20 = intent.getStringExtra("test_series_name");
            if (stringExtra20 == null) {
                stringExtra20 = "";
            }
            this.test_series_name = stringExtra20;
            String stringExtra21 = intent.getStringExtra("solutions");
            if (stringExtra21 == null) {
                stringExtra21 = "";
            }
            this.solutions = stringExtra21;
            String stringExtra22 = intent.getStringExtra("result_date");
            if (stringExtra22 == null) {
                stringExtra22 = "";
            }
            this.test_series_date = stringExtra22;
            String stringExtra23 = intent.getStringExtra("id");
            if (stringExtra23 == null) {
                stringExtra23 = "";
            }
            this.id = stringExtra23;
            String stringExtra24 = intent.getStringExtra("post_id");
            if (stringExtra24 == null) {
                stringExtra24 = "";
            }
            this.post_id = stringExtra24;
            String stringExtra25 = intent.getStringExtra(Const.status_free);
            this.status_free = stringExtra25 != null ? stringExtra25 : "";
        }
    }

    private final void updateUrlAccordingly(String url) {
        if (StringsKt.equals("1", this.message_target, true)) {
            this.from = "noti";
            if (TextUtils.isEmpty(url)) {
                this.url = "<img src=\"" + this.imageUrl + "\"/>" + this.message;
            }
        }
    }
}
