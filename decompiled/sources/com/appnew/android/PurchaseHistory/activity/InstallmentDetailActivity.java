package com.appnew.android.PurchaseHistory.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Dao.DueEmiDao;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Model.BillDesk;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.Data;
import com.appnew.android.Model.Ccav;
import com.appnew.android.Model.Courses.InstallmentResponse;
import com.appnew.android.Model.DueEmiTable;
import com.appnew.android.Model.EaseBuzz;
import com.appnew.android.Model.EasyPay;
import com.appnew.android.Model.Emi;
import com.appnew.android.Model.ExpiredEmiModel;
import com.appnew.android.Model.FonePay;
import com.appnew.android.Model.ModelInstallments;
import com.appnew.android.Model.Paytm;
import com.appnew.android.Model.PostFile;
import com.appnew.android.Model.PurchaseHistoryModel;
import com.appnew.android.Model.QRPaymentData;
import com.appnew.android.Model.Rzp;
import com.appnew.android.Model.SubscriptionModel;
import com.appnew.android.Model.TxnTokenData;
import com.appnew.android.Model.subscription.SubscriptionAllData;
import com.appnew.android.Payment.Credentials;
import com.appnew.android.Payment.IOnViewDetailsClick;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.Payment.PreferencesUtil;
import com.appnew.android.PurchaseHistory.adapter.AdapterInstallmentDetailsq;
import com.appnew.android.PurchaseHistory.adapter.PurchaseHistoryAdapter;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Theme.DashboardActivityTheme4;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PaymentTypeCheck;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.UpdateProfileDialogUtils;
import com.appnew.android.Webview.WebViewActivtyNew;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivityInstallmentDetailBinding;
import com.appnew.android.home.Constants;
import com.appnew.android.home.adapters.ExtendAdapter;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.eduteria.app.app.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: InstallmentDetailActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 °\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004°\u0002±\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010É\u0001\u001a\u00030Ê\u00012\n\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0014J\n\u0010Í\u0001\u001a\u00030Ê\u0001H\u0002J\u001d\u0010Î\u0001\u001a\u00030Ê\u00012\b\u0010Ï\u0001\u001a\u00030¤\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\rH\u0002J4\u0010Ð\u0001\u001a\u00030Ê\u00012\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010±\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010°\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010\u00ad\u0001\u001a\u00020\rH\u0002J\n\u0010Ò\u0001\u001a\u00030Ê\u0001H\u0003J6\u0010Ó\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010Ô\u00012\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010\u000f2\n\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001H\u0016J5\u0010Ù\u0001\u001a\u00030Ê\u00012\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u00012\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010Ü\u0001\u001a\u00020lH\u0016J\n\u0010Ý\u0001\u001a\u00030Ê\u0001H\u0002J\u0015\u0010Þ\u0001\u001a\u00030Ê\u00012\t\u0010ß\u0001\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010à\u0001\u001a\u00030Ê\u00012\u000e\u0010á\u0001\u001a\t\u0012\u0004\u0012\u00020~0\u009e\u0001H\u0002J\n\u0010â\u0001\u001a\u00030Ê\u0001H\u0002J\u0014\u0010ã\u0001\u001a\u00030Ê\u00012\b\u0010ä\u0001\u001a\u00030å\u0001H\u0002J+\u0010æ\u0001\u001a\u00030Ê\u00012\t\u0010Ú\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J'\u0010ç\u0001\u001a\u00030Ê\u00012\u0007\u0010è\u0001\u001a\u00020P2\t\u0010é\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010ê\u0001\u001a\u00020lH\u0016J\u0014\u0010ë\u0001\u001a\u00030Ê\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010ì\u0001\u001a\u00030Ê\u00012\u0006\u0010V\u001a\u00020WH\u0002J\u001e\u0010í\u0001\u001a\u00030Ê\u00012\u0007\u0010î\u0001\u001a\u00020P2\t\u0010ï\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010ð\u0001\u001a\u00030Ê\u00012\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u001e\u0010ÿ\u0001\u001a\u00030Ê\u00012\t\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u000f2\u0007\u0010\u0019\u001a\u00030Û\u0001H\u0016J\u001e\u0010\u0081\u0002\u001a\u00030Ê\u00012\t\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u000f2\u0007\u0010\u0019\u001a\u00030Û\u0001H\u0002J\n\u0010\u0082\u0002\u001a\u00030Ê\u0001H\u0016J\t\u0010\u0083\u0002\u001a\u00020lH\u0002J\u0014\u0010\u0084\u0002\u001a\u00030Ê\u00012\b\u0010\u0085\u0002\u001a\u00030\u0086\u0002H\u0002J\n\u0010\u0087\u0002\u001a\u00030Ê\u0001H\u0002J\u0013\u0010\u0088\u0002\u001a\u00030Ê\u00012\u0007\u0010è\u0001\u001a\u00020PH\u0002J\n\u0010\u0089\u0002\u001a\u00030Ê\u0001H\u0002J\b\u0010\u008f\u0002\u001a\u00030Ê\u0001J6\u0010\u0090\u0002\u001a\u00030Ê\u00012\b\u0010\u0091\u0002\u001a\u00030\u0092\u00022\u0007\u0010\u0093\u0002\u001a\u00020\u000f2\u0007\u0010\u0094\u0002\u001a\u00020\u000f2\u0007\u0010\u0095\u0002\u001a\u00020\u000f2\u0007\u0010\u0096\u0002\u001a\u00020\u000fJ\b\u0010\u0097\u0002\u001a\u00030Ê\u0001J\u0011\u0010¨\u0002\u001a\u00030Ê\u00012\u0007\u0010\u0019\u001a\u00030Û\u0001J\u0007\u0010©\u0002\u001a\u00020PJ\u0007\u0010ª\u0002\u001a\u00020PJ\b\u0010«\u0002\u001a\u00030Ê\u0001J\u0014\u0010¬\u0002\u001a\u00030Ê\u00012\n\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0092\u0002J\b\u0010\u00ad\u0002\u001a\u00030Ê\u0001J\u0013\u0010®\u0002\u001a\u00030Ê\u00012\u0007\u0010¯\u0002\u001a\u00020\u000fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001c\u00101\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010,\"\u0004\b3\u0010.R\u001c\u00104\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\u001a\u00107\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.R\u001c\u0010:\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R\u001c\u0010=\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010,\"\u0004\b?\u0010.R\u001c\u0010@\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010,\"\u0004\bB\u0010.R\u001c\u0010C\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010,\"\u0004\bE\u0010.R\u001c\u0010F\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010,\"\u0004\bH\u0010.R\u001c\u0010I\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010,\"\u0004\bK\u0010.R\u001c\u0010L\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010,\"\u0004\bN\u0010.R\u001e\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010,\"\u0004\bj\u0010.R\u001a\u0010k\u001a\u00020lX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u0010\u0010q\u001a\u0004\u0018\u00010rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010s\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bt\u0010R\"\u0004\bu\u0010TR\u001e\u0010v\u001a\u0004\u0018\u00010wX\u0086\u000e¢\u0006\u0010\n\u0002\u0010|\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001d\u0010}\u001a\u00020~X\u0086.¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R \u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R \u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0015\u0010\u0095\u0001\u001a\u00030\u0090\u00018F¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0092\u0001R \u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R&\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020~0\u009e\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\"\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R\u0015\u0010©\u0001\u001a\u00030¤\u00018F¢\u0006\b\u001a\u0006\bª\u0001\u0010¦\u0001R\u0012\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u001b\"\u0005\b¯\u0001\u0010\u001dR\u000f\u0010°\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010±\u0001\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010²\u0001\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010³\u0001\u001a\u00020lX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010´\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010µ\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u0010,\"\u0005\b·\u0001\u0010.R\u001f\u0010¸\u0001\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010,\"\u0005\bº\u0001\u0010.R\u001f\u0010»\u0001\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010,\"\u0005\b½\u0001\u0010.R\u001f\u0010¾\u0001\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u0010,\"\u0005\bÀ\u0001\u0010.R\"\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R\u001d\u0010Ç\u0001\u001a\u00020lX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0001\u0010n\"\u0005\bÈ\u0001\u0010pR \u0010ñ\u0001\u001a\u00030ò\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\bó\u0001\u0010ô\u0001\"\u0006\bõ\u0001\u0010ö\u0001R\u0010\u0010÷\u0001\u001a\u00030ø\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010ù\u0001\u001a\u0005\u0018\u00010ú\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R \u0010\u008a\u0002\u001a\u00030ø\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0002\u0010\u008c\u0002\"\u0006\b\u008d\u0002\u0010\u008e\u0002R\"\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0099\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010\u009d\u0002R\u0012\u0010\u009e\u0002\u001a\u0005\u0018\u00010\u009f\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010 \u0002\u001a\u0005\u0018\u00010¡\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¢\u0002\u0010£\u0002\"\u0006\b¤\u0002\u0010¥\u0002R\u0012\u0010¦\u0002\u001a\u0005\u0018\u00010§\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006²\u0002"}, d2 = {"Lcom/appnew/android/PurchaseHistory/activity/InstallmentDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/appnew/android/Payment/IOnViewDetailsClick;", "Lcom/razorpay/PaymentResultListener;", "Lcom/appnew/android/Utils/PaymentTypeCheck;", "<init>", "()V", "bottomSetting", "Lcom/appnew/android/Model/BottomSetting;", "themeSettings", "Lcom/appnew/android/table/ThemeSettings;", "coursePaymentTime", "Lcom/appnew/android/Model/PurchaseHistoryModel$Data;", "pos_txn_id", "", "payMode", "myPermissionConstantsArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Utils/AppPermissionsRunTime$MyPermissionConstants;", "Lkotlin/collections/ArrayList;", "getMyPermissionConstantsArrayList", "()Ljava/util/ArrayList;", "setMyPermissionConstantsArrayList", "(Ljava/util/ArrayList;)V", "data", "getData", "()Lcom/appnew/android/Model/PurchaseHistoryModel$Data;", "setData", "(Lcom/appnew/android/Model/PurchaseHistoryModel$Data;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "type", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "is_subscription", "set_subscription", "razorpay_subscription_code", "getRazorpay_subscription_code", "setRazorpay_subscription_code", FirebaseAnalytics.Param.END_DATE, "getEnd_date", "setEnd_date", "expiry_date1", "getExpiry_date1", "setExpiry_date1", "invoiceUrl", "getInvoiceUrl", "setInvoiceUrl", "invoice2Url", "getInvoice2Url", "setInvoice2Url", "bookAddress", "getBookAddress", "setBookAddress", "admitCard", "getAdmitCard", "setAdmitCard", "test_mode", "getTest_mode", "setTest_mode", "location", "getLocation", "setLocation", "fromWhere", "getFromWhere", "setFromWhere", Const.SERVER_TIME, "", "getServer_time", "()Ljava/lang/Integer;", "setServer_time", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "watchlist", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "getWatchlist", "()Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "setWatchlist", "(Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V", "modelInstallmentDetails", "Lcom/appnew/android/Model/ModelInstallments;", "getModelInstallmentDetails", "()Lcom/appnew/android/Model/ModelInstallments;", "setModelInstallmentDetails", "(Lcom/appnew/android/Model/ModelInstallments;)V", "subscriptionModel", "Lcom/appnew/android/Model/SubscriptionModel;", "getSubscriptionModel", "()Lcom/appnew/android/Model/SubscriptionModel;", "setSubscriptionModel", "(Lcom/appnew/android/Model/SubscriptionModel;)V", "razorkey", "getRazorkey", "setRazorkey", "isfailure", "", "getIsfailure", "()Z", "setIsfailure", "(Z)V", "extendAdapter", "Lcom/appnew/android/home/adapters/ExtendAdapter;", Const.POSITION, "getPosition", "setPosition", "t1", "", "getT1", "()Ljava/lang/Float;", "setT1", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "emiData", "Lcom/appnew/android/Model/Emi;", "getEmiData", "()Lcom/appnew/android/Model/Emi;", "setEmiData", "(Lcom/appnew/android/Model/Emi;)V", Const.COURSESLIST, "Lcom/appnew/android/Model/ExpiredEmiModel;", "getCourseList", "()Lcom/appnew/android/Model/ExpiredEmiModel;", "setCourseList", "(Lcom/appnew/android/Model/ExpiredEmiModel;)V", "dueEmiList", "Lcom/appnew/android/Model/DueEmiTable;", "getDueEmiList", "()Lcom/appnew/android/Model/DueEmiTable;", "setDueEmiList", "(Lcom/appnew/android/Model/DueEmiTable;)V", "_mBinding", "Lcom/appnew/android/databinding/ActivityInstallmentDetailBinding;", "get_mBinding", "()Lcom/appnew/android/databinding/ActivityInstallmentDetailBinding;", "set_mBinding", "(Lcom/appnew/android/databinding/ActivityInstallmentDetailBinding;)V", "mBinding", "getMBinding", "adapterInstallmentDetails", "Lcom/appnew/android/PurchaseHistory/adapter/AdapterInstallmentDetailsq;", "getAdapterInstallmentDetails", "()Lcom/appnew/android/PurchaseHistory/adapter/AdapterInstallmentDetailsq;", "setAdapterInstallmentDetails", "(Lcom/appnew/android/PurchaseHistory/adapter/AdapterInstallmentDetailsq;)V", "arraylist", "", "getArraylist", "()Ljava/util/List;", "setArraylist", "(Ljava/util/List;)V", "_context", "Landroid/content/Context;", "get_context", "()Landroid/content/Context;", "set_context", "(Landroid/content/Context;)V", "activity", "getActivity", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "course", "getCourse", "setCourse", FirebaseAnalytics.Param.PRICE, "id", Const.COURSE_INIT_PAYMENT_TOKEN, "isEmi", "txnToken", "enc_val", "getEnc_val", "setEnc_val", "rid", "getRid", "setRid", "amt", "getAmt", "setAmt", "scd", "getScd", "setScd", "paymentViewModel", "Lcom/appnew/android/Payment/PaymentViewModel;", "getPaymentViewModel", "()Lcom/appnew/android/Payment/PaymentViewModel;", "setPaymentViewModel", "(Lcom/appnew/android/Payment/PaymentViewModel;)V", "isPayViaQR", "setPayViaQR", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setSubscriptionData", "openwatchlist_dailog_resource", "context", "API_INIT_PAYMENT", "validity", "getExtendValidityDetails", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "gotoDashboardPage", "launch_paymentGateway", "key", "setCourseExpireDate", "emi", "success_dailog", "setViewData", "courseDetail", "Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "ErrorCallBack", "onViewDetailsClick", "position1", "ttl", "isQRPay", "onPaymentSuccess", "dismissCalculatorDialog", "onPaymentError", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, CmcdData.Factory.STREAMING_FORMAT_SS, "downloadInvoice", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "total", "", "path1", "Ljava/io/File;", "getPath1", "()Ljava/io/File;", "setPath1", "(Ljava/io/File;)V", "onPaymentType", "mode", "callPaymentPage", "onPaymentTypeCancel", "setThumbAccordingRatio", "setThumbRatio", "rlThum", "Landroid/widget/ImageView;", "AddToLibrary", "makeOnlinePayment", "pushEventForFreeCourse", "mLastClickTime", "getMLastClickTime", "()J", "setMLastClickTime", "(J)V", "showUpdateStatePopup", "submitUpdateStateData", "dialog", "Landroid/app/Dialog;", "submitType", "stateId", "districtId", "addressJson", "finishPayment", "txnTokenData", "Lcom/appnew/android/Model/TxnTokenData;", "getTxnTokenData", "()Lcom/appnew/android/Model/TxnTokenData;", "setTxnTokenData", "(Lcom/appnew/android/Model/TxnTokenData;)V", "mFirebaseDatabaseReferenceQRPay", "Lcom/google/firebase/database/DatabaseReference;", "qrPayValueEventListener", "Lcom/google/firebase/database/ValueEventListener;", "getQrPayValueEventListener", "()Lcom/google/firebase/database/ValueEventListener;", "setQrPayValueEventListener", "(Lcom/google/firebase/database/ValueEventListener;)V", "countDownTimer", "Landroid/os/CountDownTimer;", "manageQRPayment", "getDeviceWidthWithInsets", "getDeviceHeightWithInsets", "openQRCode", "qrPaymentCallback", "enableScreenshot", "showMessage", "message", "Companion", "DownloadTask", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstallmentDetailActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, IOnViewDetailsClick, PaymentResultListener, PaymentTypeCheck {
    public static final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    public static String countForCheck;
    private Context _context;
    private ActivityInstallmentDetailBinding _mBinding;
    public AdapterInstallmentDetailsq adapterInstallmentDetails;
    private String admitCard;
    private String amt;
    private BottomSetting bottomSetting;
    private CountDownTimer countDownTimer;
    private PurchaseHistoryModel.Data course;
    public ExpiredEmiModel courseList;
    private PurchaseHistoryModel.Data coursePaymentTime;
    private PurchaseHistoryModel.Data data;
    public DueEmiTable dueEmiList;
    public Emi emiData;
    private String end_date;
    private ExtendAdapter extendAdapter;
    private String fromWhere;
    private String invoiceUrl;
    private boolean isEmi;
    private boolean isPayViaQR;
    private String is_subscription;
    private boolean isfailure;
    private String location;
    private DatabaseReference mFirebaseDatabaseReferenceQRPay;
    private long mLastClickTime;
    private ModelInstallments modelInstallmentDetails;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    public NetworkCall networkCall;
    private File path1;
    private PaymentViewModel paymentViewModel;
    private Integer position;
    public ProgressDialog progressDialog;
    private ValueEventListener qrPayValueEventListener;
    private String razorpay_subscription_code;
    public RecyclerView recyclerView;
    private String rid;
    private Integer server_time;
    private SubscriptionModel subscriptionModel;
    private Float t1;
    private String test_mode;
    private ThemeSettings themeSettings;
    private long total;
    private TxnTokenData txnTokenData;
    private String type;
    private UtkashRoom utkashRoom;
    private BottomSheetDialog watchlist;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String pos_txn_id = "";
    private String payMode = "";
    private String expiry_date1 = "";
    private String invoice2Url = "";
    private String bookAddress = "";
    private String razorkey = "";
    private List<Emi> arraylist = CollectionsKt.emptyList();
    private String price = "";
    private String id = "";
    private String pre_transaction_id = "";
    private String txnToken = "";
    private String enc_val = "";
    private String scd = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openQRCode$lambda$46$lambda$45() {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    /* JADX INFO: compiled from: InstallmentDetailActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/appnew/android/PurchaseHistory/activity/InstallmentDetailActivity$Companion;", "", "<init>", "()V", "countForCheck", "", "getCountForCheck", "()Ljava/lang/String;", "setCountForCheck", "(Ljava/lang/String;)V", "REQUEST_CODE_PERMISSION_MULTIPLE", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getCountForCheck() {
            String str = InstallmentDetailActivity.countForCheck;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("countForCheck");
            return null;
        }

        public final void setCountForCheck(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            InstallmentDetailActivity.countForCheck = str;
        }
    }

    public final ArrayList<AppPermissionsRunTime.MyPermissionConstants> getMyPermissionConstantsArrayList() {
        ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList = this.myPermissionConstantsArrayList;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("myPermissionConstantsArrayList");
        return null;
    }

    public final void setMyPermissionConstantsArrayList(ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.myPermissionConstantsArrayList = arrayList;
    }

    public final PurchaseHistoryModel.Data getData() {
        return this.data;
    }

    public final void setData(PurchaseHistoryModel.Data data) {
        this.data = data;
    }

    public final NetworkCall getNetworkCall() {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            return networkCall;
        }
        Intrinsics.throwUninitializedPropertyAccessException("networkCall");
        return null;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        Intrinsics.checkNotNullParameter(networkCall, "<set-?>");
        this.networkCall = networkCall;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    /* JADX INFO: renamed from: is_subscription, reason: from getter */
    public final String getIs_subscription() {
        return this.is_subscription;
    }

    public final void set_subscription(String str) {
        this.is_subscription = str;
    }

    public final String getRazorpay_subscription_code() {
        return this.razorpay_subscription_code;
    }

    public final void setRazorpay_subscription_code(String str) {
        this.razorpay_subscription_code = str;
    }

    public final String getEnd_date() {
        return this.end_date;
    }

    public final void setEnd_date(String str) {
        this.end_date = str;
    }

    public final String getExpiry_date1() {
        return this.expiry_date1;
    }

    public final void setExpiry_date1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expiry_date1 = str;
    }

    public final String getInvoiceUrl() {
        return this.invoiceUrl;
    }

    public final void setInvoiceUrl(String str) {
        this.invoiceUrl = str;
    }

    public final String getInvoice2Url() {
        return this.invoice2Url;
    }

    public final void setInvoice2Url(String str) {
        this.invoice2Url = str;
    }

    public final String getBookAddress() {
        return this.bookAddress;
    }

    public final void setBookAddress(String str) {
        this.bookAddress = str;
    }

    public final String getAdmitCard() {
        return this.admitCard;
    }

    public final void setAdmitCard(String str) {
        this.admitCard = str;
    }

    public final String getTest_mode() {
        return this.test_mode;
    }

    public final void setTest_mode(String str) {
        this.test_mode = str;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation(String str) {
        this.location = str;
    }

    public final String getFromWhere() {
        return this.fromWhere;
    }

    public final void setFromWhere(String str) {
        this.fromWhere = str;
    }

    public final Integer getServer_time() {
        return this.server_time;
    }

    public final void setServer_time(Integer num) {
        this.server_time = num;
    }

    public final BottomSheetDialog getWatchlist() {
        return this.watchlist;
    }

    public final void setWatchlist(BottomSheetDialog bottomSheetDialog) {
        this.watchlist = bottomSheetDialog;
    }

    public final ModelInstallments getModelInstallmentDetails() {
        return this.modelInstallmentDetails;
    }

    public final void setModelInstallmentDetails(ModelInstallments modelInstallments) {
        this.modelInstallmentDetails = modelInstallments;
    }

    public final SubscriptionModel getSubscriptionModel() {
        return this.subscriptionModel;
    }

    public final void setSubscriptionModel(SubscriptionModel subscriptionModel) {
        this.subscriptionModel = subscriptionModel;
    }

    public final String getRazorkey() {
        return this.razorkey;
    }

    public final void setRazorkey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.razorkey = str;
    }

    public final boolean getIsfailure() {
        return this.isfailure;
    }

    public final void setIsfailure(boolean z) {
        this.isfailure = z;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final void setPosition(Integer num) {
        this.position = num;
    }

    public final Float getT1() {
        return this.t1;
    }

    public final void setT1(Float f2) {
        this.t1 = f2;
    }

    public final Emi getEmiData() {
        Emi emi = this.emiData;
        if (emi != null) {
            return emi;
        }
        Intrinsics.throwUninitializedPropertyAccessException("emiData");
        return null;
    }

    public final void setEmiData(Emi emi) {
        Intrinsics.checkNotNullParameter(emi, "<set-?>");
        this.emiData = emi;
    }

    public final ExpiredEmiModel getCourseList() {
        ExpiredEmiModel expiredEmiModel = this.courseList;
        if (expiredEmiModel != null) {
            return expiredEmiModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Const.COURSESLIST);
        return null;
    }

    public final void setCourseList(ExpiredEmiModel expiredEmiModel) {
        Intrinsics.checkNotNullParameter(expiredEmiModel, "<set-?>");
        this.courseList = expiredEmiModel;
    }

    public final DueEmiTable getDueEmiList() {
        DueEmiTable dueEmiTable = this.dueEmiList;
        if (dueEmiTable != null) {
            return dueEmiTable;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dueEmiList");
        return null;
    }

    public final void setDueEmiList(DueEmiTable dueEmiTable) {
        Intrinsics.checkNotNullParameter(dueEmiTable, "<set-?>");
        this.dueEmiList = dueEmiTable;
    }

    public final ActivityInstallmentDetailBinding get_mBinding() {
        return this._mBinding;
    }

    public final void set_mBinding(ActivityInstallmentDetailBinding activityInstallmentDetailBinding) {
        this._mBinding = activityInstallmentDetailBinding;
    }

    public final ActivityInstallmentDetailBinding getMBinding() {
        ActivityInstallmentDetailBinding activityInstallmentDetailBinding = this._mBinding;
        Intrinsics.checkNotNull(activityInstallmentDetailBinding);
        return activityInstallmentDetailBinding;
    }

    public final AdapterInstallmentDetailsq getAdapterInstallmentDetails() {
        AdapterInstallmentDetailsq adapterInstallmentDetailsq = this.adapterInstallmentDetails;
        if (adapterInstallmentDetailsq != null) {
            return adapterInstallmentDetailsq;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapterInstallmentDetails");
        return null;
    }

    public final void setAdapterInstallmentDetails(AdapterInstallmentDetailsq adapterInstallmentDetailsq) {
        Intrinsics.checkNotNullParameter(adapterInstallmentDetailsq, "<set-?>");
        this.adapterInstallmentDetails = adapterInstallmentDetailsq;
    }

    public final List<Emi> getArraylist() {
        return this.arraylist;
    }

    public final void setArraylist(List<Emi> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.arraylist = list;
    }

    public final Context get_context() {
        return this._context;
    }

    public final void set_context(Context context) {
        this._context = context;
    }

    public final Context getActivity() {
        Context context = this._context;
        Intrinsics.checkNotNull(context);
        return context;
    }

    public final PurchaseHistoryModel.Data getCourse() {
        return this.course;
    }

    public final void setCourse(PurchaseHistoryModel.Data data) {
        this.course = data;
    }

    public final String getEnc_val() {
        return this.enc_val;
    }

    public final void setEnc_val(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.enc_val = str;
    }

    public final String getRid() {
        return this.rid;
    }

    public final void setRid(String str) {
        this.rid = str;
    }

    public final String getAmt() {
        return this.amt;
    }

    public final void setAmt(String str) {
        this.amt = str;
    }

    public final String getScd() {
        return this.scd;
    }

    public final void setScd(String str) {
        this.scd = str;
    }

    public final PaymentViewModel getPaymentViewModel() {
        return this.paymentViewModel;
    }

    public final void setPaymentViewModel(PaymentViewModel paymentViewModel) {
        this.paymentViewModel = paymentViewModel;
    }

    /* JADX INFO: renamed from: isPayViaQR, reason: from getter */
    public final boolean getIsPayViaQR() {
        return this.isPayViaQR;
    }

    public final void setPayViaQR(boolean z) {
        this.isPayViaQR = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0a20  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ec  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r24) {
        /*
            Method dump skipped, instruction units count: 3769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(InstallmentDetailActivity installmentDetailActivity, View view) {
        Intent intent = new Intent(installmentDetailActivity, (Class<?>) WebViewActivtyNew.class);
        PurchaseHistoryModel.Data data = installmentDetailActivity.data;
        intent.putExtra("url", data != null ? data.getTrack_url() : null);
        intent.putExtra("title", "Track Order");
        intent.putExtra("file_type", "");
        installmentDetailActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$14(String str, InstallmentDetailActivity installmentDetailActivity, View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(installmentDetailActivity.getPackageManager()) != null) {
            installmentDetailActivity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$15(InstallmentDetailActivity installmentDetailActivity, View view) {
        PurchaseHistoryModel.Data data = installmentDetailActivity.data;
        Intrinsics.checkNotNull(data);
        if (data.getAdmit_card_url() != null) {
            PurchaseHistoryModel.Data data2 = installmentDetailActivity.data;
            Intrinsics.checkNotNull(data2);
            if (!data2.getAdmit_card_url().equals("")) {
                Intent intent = new Intent(installmentDetailActivity, (Class<?>) PdfDetailScreen.class);
                PurchaseHistoryModel.Data data3 = installmentDetailActivity.data;
                Intrinsics.checkNotNull(data3);
                intent.putExtra("url", data3.getAdmit_card_url());
                PurchaseHistoryModel.Data data4 = installmentDetailActivity.data;
                Intrinsics.checkNotNull(data4);
                intent.putExtra("title", data4.getTitle());
                intent.putExtra("pdf_name", "Admit Card");
                PurchaseHistoryModel.Data data5 = installmentDetailActivity.data;
                Intrinsics.checkNotNull(data5);
                intent.putExtra("cat_type", data5.getCat_type());
                PurchaseHistoryModel.Data data6 = installmentDetailActivity.data;
                Intrinsics.checkNotNull(data6);
                intent.putExtra("course_id", data6.getId());
                intent.putExtra("save", false);
                intent.putExtra("download_file", false);
                intent.putExtra(Const.IS_DOWNLOAD, true);
                installmentDetailActivity.startActivity(intent);
                return;
            }
        }
        installmentDetailActivity.getNetworkCall().NetworkAPICall(API.GET_ADMIT_CARD_URL, "", true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$16(InstallmentDetailActivity installmentDetailActivity, View view) {
        String str = installmentDetailActivity.invoiceUrl;
        if (str != null && str.length() != 0) {
            String str2 = installmentDetailActivity.invoiceUrl;
            Intrinsics.checkNotNull(str2);
            installmentDetailActivity.downloadInvoice(str2);
            return;
        }
        Helper.showToast(installmentDetailActivity, installmentDetailActivity.getResources().getString(R.string.invoice_not_found), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$17(InstallmentDetailActivity installmentDetailActivity, View view) {
        String str = installmentDetailActivity.invoice2Url;
        if (str != null && str.length() != 0) {
            String str2 = installmentDetailActivity.invoice2Url;
            Intrinsics.checkNotNull(str2);
            installmentDetailActivity.downloadInvoice(str2);
            return;
        }
        Helper.showToast(installmentDetailActivity, installmentDetailActivity.getResources().getString(R.string.invoice_not_found), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$18(InstallmentDetailActivity installmentDetailActivity, View view) {
        String str = installmentDetailActivity.invoiceUrl;
        if (str != null && str.length() != 0) {
            String str2 = installmentDetailActivity.invoiceUrl;
            Intrinsics.checkNotNull(str2);
            installmentDetailActivity.downloadInvoice(str2);
            return;
        }
        Helper.showToast(installmentDetailActivity, installmentDetailActivity.getResources().getString(R.string.invoice_not_found), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$20(InstallmentDetailActivity installmentDetailActivity, View view) {
        PurchaseHistoryModel.Data data = installmentDetailActivity.data;
        Intrinsics.checkNotNull(data);
        if (data.getPrices() != null) {
            PurchaseHistoryModel.Data data2 = installmentDetailActivity.data;
            Intrinsics.checkNotNull(data2);
            if (data2.getPrices().size() > 0) {
                PurchaseHistoryModel.Data data3 = installmentDetailActivity.data;
                Intrinsics.checkNotNull(data3);
                if (StringsKt.equals(data3.getTransaction_status(), "1", true)) {
                    Context activity = installmentDetailActivity.getActivity();
                    PurchaseHistoryModel.Data data4 = installmentDetailActivity.data;
                    Intrinsics.checkNotNull(data4);
                    installmentDetailActivity.openwatchlist_dailog_resource(activity, data4);
                    return;
                }
            }
        }
        View rootView = installmentDetailActivity.getMBinding().extendValidy.getRootView();
        if (rootView != null) {
            Snackbar.make(rootView, installmentDetailActivity.getActivity().getResources().getString(R.string.course_has_been_transfer), 0).show();
        }
    }

    private final void setSubscriptionData() {
        String expiry_date;
        TextView textView = getMBinding().subscriptionTitle;
        PurchaseHistoryModel.Data data = this.data;
        textView.setText(data != null ? data.getTitle() : null);
        PurchaseHistoryModel.Data data2 = this.data;
        if (!GenericUtils.isEmpty(data2 != null ? data2.getExpiry_date() : null)) {
            PurchaseHistoryModel.Data data3 = this.data;
            Long lValueOf = (data3 == null || (expiry_date = data3.getExpiry_date()) == null) ? null : Long.valueOf(Long.parseLong(expiry_date));
            Intrinsics.checkNotNull(lValueOf);
            getMBinding().subscriptionDescription.setText("Mont   hly plan valid till " + new SimpleDateFormat("dd MMM, yyyy", Locale.getDefault()).format(new Date(lValueOf.longValue() * ((long) 1000))));
        }
        TextView textView2 = getMBinding().subscriptionPrice;
        String str = Constants.currencyType;
        PurchaseHistoryModel.Data data4 = this.data;
        textView2.setText(str + " " + (data4 != null ? data4.getMrp() : null) + "/-");
        TextView textView3 = getMBinding().subscriptionActive;
        PurchaseHistoryModel.Data data5 = this.data;
        if (!StringsKt.equals$default(data5 != null ? data5.getSubscription_status() : null, "0", false, 2, null)) {
            PurchaseHistoryModel.Data data6 = this.data;
            if (!StringsKt.equals$default(data6 != null ? data6.getIs_subscription() : null, "6", false, 2, null)) {
                PurchaseHistoryModel.Data data7 = this.data;
                if (StringsKt.equals$default(data7 != null ? data7.getSubscription_status() : null, "7", false, 2, null)) {
                    textView3.setText(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED);
                    Helper.setBackgroundShapeColor(getActivity(), getMBinding().subscriptionActive, 6.0f, R.drawable.discount_bg, Color.parseColor("#ED7E18"));
                    return;
                } else {
                    textView3.setText(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED);
                    Helper.setBackgroundShapeColor(getActivity(), getMBinding().subscriptionActive, 6.0f, R.drawable.discount_bg, Color.parseColor("#D00000"));
                    return;
                }
            }
        }
        textView3.setText("Active");
        Helper.setBackgroundShapeColor(getActivity(), getMBinding().subscriptionActive, 6.0f, R.drawable.discount_bg, Color.parseColor("#00a651"));
    }

    private final void openwatchlist_dailog_resource(final Context context, final PurchaseHistoryModel.Data course) {
        try {
            int size = course.getPrices().size();
            for (int i = 0; i < size; i++) {
                course.getPrices().get(i).setIs_select(false);
            }
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.videosheetDialogTheme);
            this.watchlist = bottomSheetDialog;
            Intrinsics.checkNotNull(bottomSheetDialog);
            bottomSheetDialog.setContentView(R.layout.top_up);
            BottomSheetDialog bottomSheetDialog2 = this.watchlist;
            Intrinsics.checkNotNull(bottomSheetDialog2);
            Window window = bottomSheetDialog2.getWindow();
            Intrinsics.checkNotNull(window);
            window.getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            BottomSheetDialog bottomSheetDialog3 = this.watchlist;
            Intrinsics.checkNotNull(bottomSheetDialog3);
            bottomSheetDialog3.setCancelable(false);
            BottomSheetDialog bottomSheetDialog4 = this.watchlist;
            Intrinsics.checkNotNull(bottomSheetDialog4);
            bottomSheetDialog4.setCanceledOnTouchOutside(true);
            BottomSheetDialog bottomSheetDialog5 = this.watchlist;
            Intrinsics.checkNotNull(bottomSheetDialog5);
            ImageView imageView = (ImageView) bottomSheetDialog5.findViewById(R.id.ibt_single_vd_iv);
            BottomSheetDialog bottomSheetDialog6 = this.watchlist;
            Intrinsics.checkNotNull(bottomSheetDialog6);
            TextView textView = (TextView) bottomSheetDialog6.findViewById(R.id.buy_now);
            BottomSheetDialog bottomSheetDialog7 = this.watchlist;
            Intrinsics.checkNotNull(bottomSheetDialog7);
            TextView textView2 = (TextView) bottomSheetDialog7.findViewById(R.id.cname);
            BottomSheetDialog bottomSheetDialog8 = this.watchlist;
            Intrinsics.checkNotNull(bottomSheetDialog8);
            RecyclerView recyclerView = (RecyclerView) bottomSheetDialog8.findViewById(R.id.recycler_view_validy);
            Intrinsics.checkNotNull(textView2);
            textView2.setText(course.getTitle());
            if (course.getCover_image() != null && imageView != null) {
                RequestManager requestManagerWith = Glide.with(context.getApplicationContext());
                String cover_image = course.getCover_image();
                Intrinsics.checkNotNullExpressionValue(cover_image, "getCover_image(...)");
                requestManagerWith.load(new Regex(" ").replace(cover_image, "%20")).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder).error(R.mipmap.course_placeholder).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate()).transition(DrawableTransitionOptions.withCrossFade()).into(imageView);
            }
            if (course.getPrices() != null && course.getPrices().size() > 0) {
                course.getPrices().get(0).setIs_select(true);
                this.extendAdapter = new ExtendAdapter(context, course.getPrices(), this.watchlist);
                if (recyclerView != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
                }
                Intrinsics.checkNotNull(recyclerView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(this.extendAdapter);
            }
            BottomSheetDialog bottomSheetDialog9 = this.watchlist;
            Intrinsics.checkNotNull(bottomSheetDialog9);
            if (!bottomSheetDialog9.isShowing()) {
                BottomSheetDialog bottomSheetDialog10 = this.watchlist;
                Intrinsics.checkNotNull(bottomSheetDialog10);
                bottomSheetDialog10.show();
            }
            TextView textView3 = (TextView) Objects.requireNonNull(textView);
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InstallmentDetailActivity.openwatchlist_dailog_resource$lambda$26(course, context, this, view);
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void openwatchlist_dailog_resource$lambda$26(com.appnew.android.Model.PurchaseHistoryModel.Data r23, android.content.Context r24, com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity r25, android.view.View r26) {
        /*
            Method dump skipped, instruction units count: 1185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity.openwatchlist_dailog_resource$lambda$26(com.appnew.android.Model.PurchaseHistoryModel$Data, android.content.Context, com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity, android.view.View):void");
    }

    private final void API_INIT_PAYMENT(String validity, String id, String price, PurchaseHistoryModel.Data course) {
        Intrinsics.checkNotNull(price);
        this.price = price;
        PurchaseHistoryAdapter.validty = validity;
        this.id = id;
        NetworkCall networkCall = new NetworkCall(this, getActivity());
        if (StringsKt.equals(MakeMyExam.getUserId(), "0", true)) {
            return;
        }
        this.isfailure = false;
        this.pos_txn_id = "";
        networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    private final void getExtendValidityDetails() {
        PurchaseHistoryModel.Data data = this.data;
        Log.e("TAG_APP", "getExtendValidityDetails: " + (data != null ? data.getExpiry_date() : null));
        PurchaseHistoryModel.Data data2 = this.data;
        String expiry_date = data2 != null ? data2.getExpiry_date() : null;
        Intrinsics.checkNotNull(expiry_date);
        float f2 = Float.parseFloat(expiry_date);
        PurchaseHistoryModel.Data data3 = this.data;
        String purchase_date = data3 != null ? data3.getPurchase_date() : null;
        Intrinsics.checkNotNull(purchase_date);
        int i = ((int) (f2 - Float.parseFloat(purchase_date))) / DateTimeConstants.SECONDS_PER_DAY;
        Integer num = this.server_time;
        Intrinsics.checkNotNull(num);
        int iIntValue = num.intValue();
        PurchaseHistoryModel.Data data4 = this.data;
        String purchase_date2 = data4 != null ? data4.getPurchase_date() : null;
        Intrinsics.checkNotNull(purchase_date2);
        if (iIntValue >= Integer.parseInt(purchase_date2)) {
            Integer num2 = this.server_time;
            Intrinsics.checkNotNull(num2);
            int iIntValue2 = num2.intValue();
            PurchaseHistoryModel.Data data5 = this.data;
            Intrinsics.checkNotNull(data5);
            String purchase_date3 = data5.getPurchase_date();
            Intrinsics.checkNotNullExpressionValue(purchase_date3, "getPurchase_date(...)");
            int i2 = (iIntValue2 - Integer.parseInt(purchase_date3)) / DateTimeConstants.SECONDS_PER_DAY;
            PurchaseHistoryModel.Data data6 = this.data;
            Intrinsics.checkNotNull(data6);
            if (StringsKt.equals(data6.getTransaction_status(), "1", true)) {
                PurchaseHistoryModel.Data data7 = this.data;
                Intrinsics.checkNotNull(data7);
                if (data7.getPrices() != null) {
                    PurchaseHistoryModel.Data data8 = this.data;
                    Intrinsics.checkNotNull(data8);
                    if (data8.getPrices().size() > 0) {
                        if (i != 0) {
                            int i3 = (i2 * 100) / i;
                            if (i3 < 80) {
                                Button button = getMBinding().extendValidy;
                                if (button != null) {
                                    button.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_extend_green));
                                }
                            } else if (81 <= i3 && i3 < 90) {
                                getMBinding().extendValidy.setBackground(getActivity().getResources().getDrawable(R.drawable.btn_extend_orange));
                            } else {
                                getMBinding().extendValidy.setBackground(getActivity().getResources().getDrawable(R.drawable.range_extend));
                            }
                            UtkashRoom utkashRoom = this.utkashRoom;
                            Intrinsics.checkNotNull(utkashRoom);
                            DueEmiDao dueEmi = utkashRoom.getDueEmi();
                            PurchaseHistoryModel.Data data9 = this.data;
                            if (dueEmi.getDueEmiData(data9 != null ? data9.getId() : null) == null) {
                                getMBinding().extendValidy.setVisibility(0);
                                return;
                            } else {
                                getMBinding().extendValidy.setVisibility(8);
                                return;
                            }
                        }
                        getMBinding().extendValidy.setVisibility(8);
                        return;
                    }
                }
                getMBinding().extendValidy.setVisibility(8);
                return;
            }
            getMBinding().extendValidy.setVisibility(8);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (apitype != null) {
            switch (apitype.hashCode()) {
                case -1235256825:
                    if (apitype.equals(API.GET_SUBSCRIPTION_DATA)) {
                        EncryptionData encryptionData = new EncryptionData();
                        encryptionData.setSubscription_code(this.razorpay_subscription_code);
                        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
                        Intrinsics.checkNotNull(service);
                        return service.getSubscriptionData(strEncrypt);
                    }
                    break;
                case 114126311:
                    if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                        EncryptionData encryptionData2 = new EncryptionData();
                        PurchaseHistoryModel.Data data = this.data;
                        Intrinsics.checkNotNull(data);
                        encryptionData2.setCourse_id(data.getId());
                        encryptionData2.setCoupon_applied("0");
                        encryptionData2.setParent_id("");
                        String strEncrypt2 = AES.encrypt(new Gson().toJson(encryptionData2));
                        Intrinsics.checkNotNull(service);
                        return service.free_transactionInstalmment(strEncrypt2);
                    }
                    break;
                case 750643905:
                    if (apitype.equals(API.CourseDetail_JS)) {
                        EncryptionData encryptionData3 = new EncryptionData();
                        PurchaseHistoryModel.Data data2 = this.data;
                        encryptionData3.setCourse_id(data2 != null ? data2.getId() : null);
                        encryptionData3.setParent_id("");
                        String strEncrypt3 = AES.encrypt(new Gson().toJson(encryptionData3));
                        Intrinsics.checkNotNull(service);
                        return service.getCourseData(strEncrypt3);
                    }
                    break;
                case 1120247029:
                    if (apitype.equals(API.Installment_Details)) {
                        EncryptionData encryptionData4 = new EncryptionData();
                        PurchaseHistoryModel.Data data3 = this.data;
                        encryptionData4.setCourse_id(data3 != null ? data3.getId() : null);
                        encryptionData4.setUser_id(MakeMyExam.getUserId());
                        encryptionData4.setParent_id("");
                        PurchaseHistoryModel.Data data4 = this.data;
                        encryptionData4.setSubscription_code(data4 != null ? data4.getSubscription_code() : null);
                        String strEncrypt4 = AES.encrypt(new Gson().toJson(encryptionData4));
                        Intrinsics.checkNotNull(service);
                        return service.getCourseInstallmentDetails(strEncrypt4);
                    }
                    break;
                case 1741920054:
                    if (apitype.equals(API.GET_ADMIT_CARD_URL)) {
                        EncryptionData encryptionData5 = new EncryptionData();
                        PurchaseHistoryModel.Data data5 = this.data;
                        encryptionData5.setTxn_id(data5 != null ? data5.getPayment_id() : null);
                        String strEncrypt5 = AES.encrypt(new Gson().toJson(encryptionData5));
                        Intrinsics.checkNotNull(service);
                        return service.getAdmitCardUrl(strEncrypt5);
                    }
                    break;
                case 2002393681:
                    if (apitype.equals(API.int_payment)) {
                        if (this.isEmi) {
                            String str = this.pos_txn_id;
                            if (str == null || str.length() != 0) {
                                EncryptionData encryptionData6 = new EncryptionData();
                                PurchaseHistoryModel.Data data6 = this.data;
                                encryptionData6.setCourse_id(data6 != null ? data6.getId() : null);
                                encryptionData6.setPre_transaction_id(this.pre_transaction_id);
                                encryptionData6.setPost_transaction_id(this.pos_txn_id);
                                encryptionData6.setTransaction_status("1");
                                PaymentViewModel paymentViewModel = this.paymentViewModel;
                                encryptionData6.setPay_via(paymentViewModel != null ? paymentViewModel.getPayVia() : null);
                                encryptionData6.setRid(this.rid);
                                encryptionData6.setScd(this.scd);
                                encryptionData6.setPid(this.pos_txn_id);
                                encryptionData6.setAmt(this.amt);
                                encryptionData6.setOrder_id(this.pos_txn_id);
                                encryptionData6.setType("2");
                                String strEncrypt6 = AES.encrypt(new Gson().toJson(encryptionData6));
                                Intrinsics.checkNotNull(service);
                                return service.int_payment(strEncrypt6);
                            }
                            EncryptionData encryptionData7 = new EncryptionData();
                            PurchaseHistoryModel.Data data7 = this.data;
                            encryptionData7.setCourse_id(data7 != null ? data7.getId() : null);
                            encryptionData7.setCourse_price(String.valueOf(Float.parseFloat(getEmiData().getEmiMrp())));
                            encryptionData7.setTax(String.valueOf(Float.parseFloat(getEmiData().getEmiTax())));
                            PaymentViewModel paymentViewModel2 = this.paymentViewModel;
                            encryptionData7.setPay_via(paymentViewModel2 != null ? paymentViewModel2.getPayVia() : null);
                            encryptionData7.setCoupon_applied("0");
                            encryptionData7.setPayment_mode("1");
                            if (!this.isfailure || this.isEmi) {
                                encryptionData7.setTransaction_status("1");
                                encryptionData7.setType("1");
                            } else {
                                encryptionData7.setTransaction_status("2");
                                encryptionData7.setType("2");
                            }
                            encryptionData7.setSubscription_code(getEmiData().getSubscriptionCode());
                            encryptionData7.setPlan_id(getEmiData().getPlaneId());
                            String strEncrypt7 = AES.encrypt(new Gson().toJson(encryptionData7));
                            Intrinsics.checkNotNull(service);
                            return service.int_payment(strEncrypt7);
                        }
                        if (StringsKt.equals(this.pos_txn_id, "", true)) {
                            EncryptionData encryptionData8 = new EncryptionData();
                            encryptionData8.setType("3");
                            PurchaseHistoryModel.Data data8 = this.course;
                            Intrinsics.checkNotNull(data8);
                            encryptionData8.setCourse_id(data8.getId());
                            PaymentViewModel paymentViewModel3 = this.paymentViewModel;
                            encryptionData8.setPay_via(paymentViewModel3 != null ? paymentViewModel3.getPayVia() : null);
                            PurchaseHistoryModel.Data data9 = this.course;
                            Intrinsics.checkNotNull(data9);
                            encryptionData8.setTxn_id(data9.getTxn_id());
                            encryptionData8.setTransaction_status("2");
                            encryptionData8.setExtender_id(this.id);
                            if (this.isfailure) {
                                encryptionData8.setTransaction_status("2");
                            } else {
                                encryptionData8.setTransaction_status("1");
                            }
                            encryptionData8.setRid(this.rid);
                            encryptionData8.setScd(this.scd);
                            encryptionData8.setPid(this.pos_txn_id);
                            encryptionData8.setAmt(this.amt);
                            encryptionData8.setOrder_id(this.pos_txn_id);
                            String strEncrypt8 = AES.encrypt(new Gson().toJson(encryptionData8));
                            Intrinsics.checkNotNull(service);
                            return service.int_payment(strEncrypt8);
                        }
                        String str2 = this.pos_txn_id;
                        if (str2 == null || !StringsKt.contains$default((CharSequence) str2, (CharSequence) "~!@#$%^&", false, 2, (Object) null)) {
                            EncryptionData encryptionData9 = new EncryptionData();
                            encryptionData9.setPre_transaction_id(this.pre_transaction_id);
                            encryptionData9.setTransaction_status("1");
                            encryptionData9.setPost_transaction_id(this.pos_txn_id);
                            PurchaseHistoryModel.Data data10 = this.course;
                            Intrinsics.checkNotNull(data10);
                            encryptionData9.setCourse_id(data10.getId());
                            encryptionData9.setType("4");
                            encryptionData9.setRid(this.rid);
                            encryptionData9.setScd(this.scd);
                            encryptionData9.setPid(this.pos_txn_id);
                            encryptionData9.setAmt(this.amt);
                            encryptionData9.setOrder_id(this.pos_txn_id);
                            PaymentViewModel paymentViewModel4 = this.paymentViewModel;
                            encryptionData9.setPay_via(paymentViewModel4 != null ? paymentViewModel4.getPayVia() : null);
                            PurchaseHistoryModel.Data data11 = this.course;
                            Intrinsics.checkNotNull(data11);
                            encryptionData9.setTxn_id(data11.getTxn_id());
                            String strEncrypt9 = AES.encrypt(new Gson().toJson(encryptionData9));
                            Intrinsics.checkNotNull(service);
                            return service.int_payment(strEncrypt9);
                        }
                        this.pos_txn_id = "";
                        EncryptionData encryptionData10 = new EncryptionData();
                        encryptionData10.setPre_transaction_id(this.pre_transaction_id);
                        encryptionData10.setTransaction_status("1");
                        encryptionData10.setPost_transaction_id(this.pos_txn_id);
                        PurchaseHistoryModel.Data data12 = this.course;
                        Intrinsics.checkNotNull(data12);
                        encryptionData10.setCourse_id(data12.getId());
                        encryptionData10.setType("4");
                        PaymentViewModel paymentViewModel5 = this.paymentViewModel;
                        encryptionData10.setPay_via(paymentViewModel5 != null ? paymentViewModel5.getPayVia() : null);
                        PurchaseHistoryModel.Data data13 = this.course;
                        Intrinsics.checkNotNull(data13);
                        encryptionData10.setTxn_id(data13.getTxn_id());
                        encryptionData10.setRid(this.rid);
                        encryptionData10.setScd(this.scd);
                        encryptionData10.setPid(this.pos_txn_id);
                        encryptionData10.setAmt(this.amt);
                        encryptionData10.setOrder_id(this.pos_txn_id);
                        String strEncrypt10 = AES.encrypt(new Gson().toJson(encryptionData10));
                        Intrinsics.checkNotNull(service);
                        return service.int_payment(strEncrypt10);
                    }
                    break;
            }
        }
        System.out.print((Object) "Nothing will happen");
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        LinearLayoutCompat linearLayoutCompat;
        LinearLayoutCompat linearLayoutCompat2;
        if (apitype != null) {
            switch (apitype.hashCode()) {
                case -1235256825:
                    if (apitype.equals(API.GET_SUBSCRIPTION_DATA)) {
                        if (!Intrinsics.areEqual(jsonstring != null ? jsonstring.optString("status") : null, "true")) {
                            RetrofitResponse.GetApiData(this, jsonstring != null ? jsonstring.optString("auth_code") : null, jsonstring != null ? jsonstring.optString("message") : null, false);
                            return;
                        }
                        ActivityInstallmentDetailBinding mBinding = getMBinding();
                        if (mBinding != null && (linearLayoutCompat = mBinding.cvrInstallment) != null) {
                            linearLayoutCompat.setVisibility(0);
                        }
                        this.subscriptionModel = (SubscriptionModel) new Gson().fromJson(jsonstring.toString(), SubscriptionModel.class);
                        SubscriptionModel subscriptionModel = this.subscriptionModel;
                        Intrinsics.checkNotNull(subscriptionModel);
                        String str = this.is_subscription;
                        SubscriptionModel subscriptionModel2 = this.subscriptionModel;
                        Intrinsics.checkNotNull(subscriptionModel2);
                        setAdapterInstallmentDetails(new AdapterInstallmentDetailsq(subscriptionModel.getData(), this, str, subscriptionModel2.getTime(), Const.SUBSCRIPTION));
                        getRecyclerView().setAdapter(getAdapterInstallmentDetails());
                        SubscriptionModel subscriptionModel3 = this.subscriptionModel;
                        Intrinsics.checkNotNull(subscriptionModel3);
                        if (StringsKt.equals(subscriptionModel3.getData().get(0).getPayment_mode(), "3", true)) {
                            SubscriptionModel subscriptionModel4 = this.subscriptionModel;
                            Intrinsics.checkNotNull(subscriptionModel4);
                            if (GenericUtils.isEmpty(subscriptionModel4.getData().get(0).getPurchase_date())) {
                                return;
                            }
                            SubscriptionModel subscriptionModel5 = this.subscriptionModel;
                            Intrinsics.checkNotNull(subscriptionModel5);
                            String purchase_date = subscriptionModel5.getData().get(0).getPurchase_date();
                            Long lValueOf = purchase_date != null ? Long.valueOf(Long.parseLong(purchase_date)) : null;
                            Intrinsics.checkNotNull(lValueOf);
                            getMBinding().subscriptionDate.setText("Purchased on :- " + new SimpleDateFormat("dd MMM, yyyy", Locale.getDefault()).format(new Date(lValueOf.longValue() * ((long) 1000))));
                            return;
                        }
                        return;
                    }
                    break;
                case 114126311:
                    if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                        if (!Intrinsics.areEqual(jsonstring != null ? jsonstring.optString("status") : null, "true")) {
                            RetrofitResponse.GetApiData(this, jsonstring != null ? jsonstring.optString("auth_code") : null, jsonstring != null ? jsonstring.optString("message") : null, false);
                            return;
                        }
                        pushEventForFreeCourse();
                        if (Helper.isNewLoginFlow()) {
                            showUpdateStatePopup();
                            return;
                        } else {
                            success_dailog();
                            return;
                        }
                    }
                    break;
                case 750643905:
                    if (apitype.equals(API.CourseDetail_JS)) {
                        if (!Intrinsics.areEqual(jsonstring != null ? jsonstring.optString("status") : null, "true")) {
                            RetrofitResponse.GetApiData(this, jsonstring != null ? jsonstring.optString("auth_code") : null, jsonstring != null ? jsonstring.optString("message") : null, false);
                            return;
                        }
                        JSONObject jSONObjectOptJSONObject = jsonstring.optJSONObject("data");
                        Intrinsics.checkNotNull(jSONObjectOptJSONObject);
                        Object objFromJson = new Gson().fromJson(jSONObjectOptJSONObject.optJSONObject(Const.COURSE_DETAIL).toString(), (Class<Object>) CourseDetailData.class);
                        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                        Object objFromJson2 = new Gson().fromJson(jSONObjectOptJSONObject.optJSONObject("instalment").toString(), (Class<Object>) InstallmentResponse.class);
                        Intrinsics.checkNotNullExpressionValue(objFromJson2, "fromJson(...)");
                        InstallmentResponse installmentResponse = (InstallmentResponse) objFromJson2;
                        CourseDetail courseDetail = new CourseDetail();
                        Data data = new Data();
                        data.setCourseDetail((CourseDetailData) objFromJson);
                        if (jSONObjectOptJSONObject.optJSONObject("subscription_all_data") != null) {
                            Object objFromJson3 = new Gson().fromJson(jSONObjectOptJSONObject.optJSONObject("subscription_all_data").toString(), (Class<Object>) SubscriptionAllData.class);
                            Intrinsics.checkNotNullExpressionValue(objFromJson3, "fromJson(...)");
                            data.setSubscriptionAllData((SubscriptionAllData) objFromJson3);
                        }
                        data.setInstalment(installmentResponse);
                        courseDetail.setData(data);
                        return;
                    }
                    break;
                case 1120247029:
                    if (apitype.equals(API.Installment_Details)) {
                        if (!Intrinsics.areEqual(jsonstring != null ? jsonstring.optString("status") : null, "true")) {
                            RetrofitResponse.GetApiData(this, jsonstring != null ? jsonstring.optString("auth_code") : null, jsonstring != null ? jsonstring.optString("message") : null, false);
                            return;
                        }
                        ActivityInstallmentDetailBinding mBinding2 = getMBinding();
                        if (mBinding2 != null && (linearLayoutCompat2 = mBinding2.cvrInstallment) != null) {
                            linearLayoutCompat2.setVisibility(0);
                        }
                        this.modelInstallmentDetails = (ModelInstallments) new Gson().fromJson(jsonstring.toString(), ModelInstallments.class);
                        INSTANCE.setCountForCheck("");
                        ModelInstallments modelInstallments = this.modelInstallmentDetails;
                        Intrinsics.checkNotNull(modelInstallments);
                        Iterator<T> it = modelInstallments.getEmi().iterator();
                        int i = -1;
                        while (true) {
                            if (it.hasNext()) {
                                i++;
                                if (((Emi) it.next()).getTxnStatus().equals("0")) {
                                    INSTANCE.setCountForCheck(String.valueOf(i));
                                }
                            }
                        }
                        INSTANCE.setCountForCheck(String.valueOf(i));
                        ModelInstallments modelInstallments2 = this.modelInstallmentDetails;
                        Intrinsics.checkNotNull(modelInstallments2);
                        String str2 = this.is_subscription;
                        ModelInstallments modelInstallments3 = this.modelInstallmentDetails;
                        Intrinsics.checkNotNull(modelInstallments3);
                        setAdapterInstallmentDetails(new AdapterInstallmentDetailsq(modelInstallments2.getEmi(), this, this, str2, modelInstallments3.getTime()));
                        getRecyclerView().setAdapter(getAdapterInstallmentDetails());
                        ModelInstallments modelInstallments4 = this.modelInstallmentDetails;
                        Intrinsics.checkNotNull(modelInstallments4);
                        setCourseExpireDate(modelInstallments4.getEmi());
                        return;
                    }
                    break;
                case 1741920054:
                    if (apitype.equals(API.GET_ADMIT_CARD_URL)) {
                        if (!Intrinsics.areEqual(jsonstring != null ? jsonstring.optString("status") : null, "true")) {
                            RetrofitResponse.GetApiData(this, jsonstring != null ? jsonstring.optString("auth_code") : null, jsonstring != null ? jsonstring.optString("message") : null, false);
                            return;
                        }
                        String strOptString = jsonstring.optString("data");
                        Intrinsics.checkNotNull(strOptString);
                        if (strOptString == null && strOptString.equals("")) {
                            Toast.makeText(this, "Admit Cart Not Generated Yet !", 0).show();
                            return;
                        }
                        Intent intent = new Intent(this, (Class<?>) PdfDetailScreen.class);
                        intent.putExtra("url", strOptString);
                        PurchaseHistoryModel.Data data2 = this.data;
                        Intrinsics.checkNotNull(data2);
                        intent.putExtra("title", data2.getTitle());
                        intent.putExtra("pdf_name", "Admit Card");
                        PurchaseHistoryModel.Data data3 = this.data;
                        Intrinsics.checkNotNull(data3);
                        intent.putExtra("cat_type", data3.getCat_type());
                        PurchaseHistoryModel.Data data4 = this.data;
                        Intrinsics.checkNotNull(data4);
                        intent.putExtra("course_id", data4.getId());
                        intent.putExtra("save", false);
                        intent.putExtra("download_file", false);
                        intent.putExtra(Const.IS_DOWNLOAD, true);
                        startActivity(intent);
                        return;
                    }
                    break;
                case 2002393681:
                    if (apitype.equals(API.int_payment)) {
                        if (this.isEmi) {
                            if (!Intrinsics.areEqual(jsonstring != null ? jsonstring.optString("status") : null, "true")) {
                                Toast.makeText(this, (jsonstring != null ? jsonstring.optString("message") : null), 0).show();
                                if (this.isfailure) {
                                    this.isfailure = false;
                                    this.pos_txn_id = "";
                                    return;
                                }
                                return;
                            }
                            if (this.isfailure) {
                                this.isfailure = false;
                                this.pos_txn_id = "";
                                return;
                            }
                            String str3 = this.pos_txn_id;
                            if (str3 != null && str3.length() != 0) {
                                FacebookEventLogger.logPurchased(getActivity());
                                if (Helper.isNewLoginFlow()) {
                                    showUpdateStatePopup();
                                    return;
                                } else {
                                    success_dailog();
                                    return;
                                }
                            }
                            JSONObject jSONObject = jsonstring.getJSONObject("data");
                            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                            PaymentViewModel paymentViewModel = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel != null ? paymentViewModel.getPayVia() : null, "3", false, 2, null)) {
                                callPaymentPage(Credentials.RZP, jSONObject);
                                return;
                            }
                            PaymentViewModel paymentViewModel2 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel2 != null ? paymentViewModel2.getPayVia() : null, "6", false, 2, null)) {
                                callPaymentPage(Credentials.PAYTM, jSONObject);
                                return;
                            }
                            PaymentViewModel paymentViewModel3 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel3 != null ? paymentViewModel3.getPayVia() : null, "7", false, 2, null)) {
                                callPaymentPage(Credentials.CCAV, jSONObject);
                                return;
                            }
                            PaymentViewModel paymentViewModel4 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel4);
                            if (paymentViewModel4.getPayVia().equals("8")) {
                                callPaymentPage(Credentials.FONEPAY, jSONObject);
                                return;
                            }
                            PaymentViewModel paymentViewModel5 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel5);
                            if (paymentViewModel5.getPayVia().equals("9")) {
                                callPaymentPage(Credentials.EASEBUZZ, jSONObject);
                                return;
                            }
                            PaymentViewModel paymentViewModel6 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel6);
                            if (paymentViewModel6.getPayVia().equals("11")) {
                                callPaymentPage(Credentials.BILLDESK, jSONObject);
                                return;
                            }
                            PaymentViewModel paymentViewModel7 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel7);
                            if (paymentViewModel7.getPayVia().equals("13")) {
                                callPaymentPage(Credentials.EASYPAY, jSONObject);
                                return;
                            }
                            PaymentViewModel paymentViewModel8 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel8);
                            if (!StringsKt.equals(paymentViewModel8.getPayVia(), "14", true)) {
                                PaymentViewModel paymentViewModel9 = this.paymentViewModel;
                                Intrinsics.checkNotNull(paymentViewModel9);
                                if (!StringsKt.equals(paymentViewModel9.getPayVia(), "15", true)) {
                                    PaymentViewModel paymentViewModel10 = this.paymentViewModel;
                                    Intrinsics.checkNotNull(paymentViewModel10);
                                    if (!StringsKt.equals(paymentViewModel10.getPayVia(), "21", true)) {
                                        PaymentViewModel paymentViewModel11 = this.paymentViewModel;
                                        Intrinsics.checkNotNull(paymentViewModel11);
                                        if (!StringsKt.equals(paymentViewModel11.getPayVia(), "22", true)) {
                                            PaymentViewModel paymentViewModel12 = this.paymentViewModel;
                                            Intrinsics.checkNotNull(paymentViewModel12);
                                            if (!StringsKt.equals(paymentViewModel12.getPayVia(), "23", true)) {
                                                PaymentViewModel paymentViewModel13 = this.paymentViewModel;
                                                Intrinsics.checkNotNull(paymentViewModel13);
                                                if (!StringsKt.equals(paymentViewModel13.getPayVia(), "24", true)) {
                                                    PaymentViewModel paymentViewModel14 = this.paymentViewModel;
                                                    Intrinsics.checkNotNull(paymentViewModel14);
                                                    if (!StringsKt.equals(paymentViewModel14.getPayVia(), "18", true)) {
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            manageQRPayment(jSONObject);
                            return;
                        }
                        try {
                            Intrinsics.checkNotNull(jsonstring);
                            if (!Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                                if (this.isfailure) {
                                    this.isfailure = false;
                                    this.pos_txn_id = "";
                                }
                                Toast.makeText(getActivity(), jsonstring.optString("message"), 0).show();
                                RetrofitResponse.GetApiData(getActivity(), jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                                return;
                            }
                            String strOptString2 = jsonstring.optString("time");
                            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                            this.server_time = Integer.valueOf(Integer.parseInt(strOptString2));
                            if (this.isfailure) {
                                this.isfailure = false;
                                this.pos_txn_id = "";
                                return;
                            }
                            if (!StringsKt.equals(this.pos_txn_id, "", true)) {
                                String str4 = this.pos_txn_id;
                                Intrinsics.checkNotNull(str4);
                                if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "~!@#$%^&", false, 2, (Object) null)) {
                                    this.pos_txn_id = "";
                                    Toast.makeText(getActivity(), jsonstring.optString("message"), 0).show();
                                    return;
                                } else {
                                    Toast.makeText(getActivity(), jsonstring.optString("message"), 0).show();
                                    gotoDashboardPage();
                                    return;
                                }
                            }
                            JSONObject jSONObject2 = jsonstring.getJSONObject("data");
                            PaymentViewModel paymentViewModel15 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel15 != null ? paymentViewModel15.getPayVia() : null, "3", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject2);
                                callPaymentPage(Credentials.RZP, jSONObject2);
                                return;
                            }
                            PaymentViewModel paymentViewModel16 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel16 != null ? paymentViewModel16.getPayVia() : null, "6", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject2);
                                callPaymentPage(Credentials.PAYTM, jSONObject2);
                                return;
                            }
                            PaymentViewModel paymentViewModel17 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel17 != null ? paymentViewModel17.getPayVia() : null, "7", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject2);
                                callPaymentPage(Credentials.CCAV, jSONObject2);
                                return;
                            }
                            PaymentViewModel paymentViewModel18 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel18 != null ? paymentViewModel18.getPayVia() : null, "8", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject2);
                                callPaymentPage(Credentials.FONEPAY, jSONObject2);
                                return;
                            }
                            PaymentViewModel paymentViewModel19 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel19 != null ? paymentViewModel19.getPayVia() : null, "9", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject2);
                                callPaymentPage(Credentials.EASEBUZZ, jSONObject2);
                                return;
                            }
                            PaymentViewModel paymentViewModel20 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel20 != null ? paymentViewModel20.getPayVia() : null, "11", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject2);
                                callPaymentPage(Credentials.BILLDESK, jSONObject2);
                                return;
                            }
                            PaymentViewModel paymentViewModel21 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel21 != null ? paymentViewModel21.getPayVia() : null, "13", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject2);
                                callPaymentPage(Credentials.EASYPAY, jSONObject2);
                                return;
                            }
                            PaymentViewModel paymentViewModel22 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel22);
                            if (!StringsKt.equals(paymentViewModel22.getPayVia(), "14", true)) {
                                PaymentViewModel paymentViewModel23 = this.paymentViewModel;
                                Intrinsics.checkNotNull(paymentViewModel23);
                                if (!StringsKt.equals(paymentViewModel23.getPayVia(), "15", true)) {
                                    PaymentViewModel paymentViewModel24 = this.paymentViewModel;
                                    Intrinsics.checkNotNull(paymentViewModel24);
                                    if (!StringsKt.equals(paymentViewModel24.getPayVia(), "21", true)) {
                                        PaymentViewModel paymentViewModel25 = this.paymentViewModel;
                                        Intrinsics.checkNotNull(paymentViewModel25);
                                        if (!StringsKt.equals(paymentViewModel25.getPayVia(), "22", true)) {
                                            PaymentViewModel paymentViewModel26 = this.paymentViewModel;
                                            Intrinsics.checkNotNull(paymentViewModel26);
                                            if (!StringsKt.equals(paymentViewModel26.getPayVia(), "23", true)) {
                                                PaymentViewModel paymentViewModel27 = this.paymentViewModel;
                                                Intrinsics.checkNotNull(paymentViewModel27);
                                                if (!StringsKt.equals(paymentViewModel27.getPayVia(), "24", true)) {
                                                    PaymentViewModel paymentViewModel28 = this.paymentViewModel;
                                                    Intrinsics.checkNotNull(paymentViewModel28);
                                                    if (!StringsKt.equals(paymentViewModel28.getPayVia(), "18", true)) {
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            Intrinsics.checkNotNull(jSONObject2);
                            manageQRPayment(jSONObject2);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    break;
            }
        }
        System.out.print((Object) "Nothing will happen");
    }

    private final void gotoDashboardPage() {
        InstallmentDetailActivity installmentDetailActivity = this;
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(installmentDetailActivity);
        Intrinsics.checkNotNullExpressionValue(appDatabase, "getAppDatabase(...)");
        if (appDatabase.getMyCourseDao().isRecordExists(MakeMyExam.userId)) {
            appDatabase.getMyCourseDao().deletedata();
        }
        Intent intent = new Intent(installmentDetailActivity, (Class<?>) DashboardActivityTheme1.class);
        if (!StringsKt.equals("1", "1", true)) {
            if (!StringsKt.equals("1", "2", true)) {
                if (!StringsKt.equals("1", "3", true)) {
                    if (!StringsKt.equals("1", "4", true)) {
                        if (!StringsKt.equals("1", "5", true)) {
                            if (!StringsKt.equals("1", "6", true)) {
                                if (StringsKt.equals("1", "7", true)) {
                                    intent = new Intent(installmentDetailActivity, (Class<?>) DashboardActivityTheme8.class);
                                }
                            } else {
                                intent = new Intent(installmentDetailActivity, (Class<?>) DashboardActivityTheme7.class);
                            }
                        } else {
                            intent = new Intent(installmentDetailActivity, (Class<?>) DashboardActivityTheme5.class);
                        }
                    } else {
                        intent = new Intent(installmentDetailActivity, (Class<?>) DashboardActivityTheme4.class);
                    }
                } else {
                    intent = new Intent(installmentDetailActivity, (Class<?>) DashboardActivityTheme3.class);
                }
            } else {
                intent = new Intent(installmentDetailActivity, (Class<?>) DashboardActivityTheme2.class);
            }
        } else {
            intent = new Intent(installmentDetailActivity, (Class<?>) DashboardActivityTheme1.class);
        }
        intent.setFlags(335577088);
        Helper.gotoActivity_finish(intent, this);
    }

    private final void launch_paymentGateway(String key) {
        if (this.course == null) {
            this.course = this.data;
        }
        Checkout checkout = new Checkout();
        checkout.setKeyID(key);
        checkout.setImage(R.mipmap.ic_launcher);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getActivity().getResources().getString(R.string.payment_gateway_name));
            jSONObject.put("theme.color", ContextCompat.getColor(getActivity(), R.color.theme_and_header_color));
            PurchaseHistoryModel.Data data = this.course;
            Intrinsics.checkNotNull(data);
            String title = data.getTitle();
            PurchaseHistoryModel.Data data2 = this.course;
            Intrinsics.checkNotNull(data2);
            jSONObject.put("description", title + " #(" + data2.getId() + "~" + this.id + ")");
            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, "INR");
            if (this.isEmi) {
                jSONObject.put("amount", Math.round(Float.parseFloat(getEmiData().getTotalMrp()) * 100));
            } else {
                jSONObject.put("amount", Math.round(Double.parseDouble(this.price)));
            }
            PurchaseHistoryModel.Data data3 = this.course;
            Intrinsics.checkNotNull(data3);
            jSONObject.put("image", data3.getCover_image());
            jSONObject.put("order_id", this.pre_transaction_id);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("email", "true");
            jSONObject2.put("contact", "true");
            jSONObject.put("readonly", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("email", SharedPreference.getInstance().getLoggedInUser().getEmail());
            jSONObject3.put("contact", SharedPreference.getInstance().getLoggedInUser().getMobile());
            jSONObject.put("prefill", jSONObject3);
            checkout.open((Activity) getActivity(), jSONObject);
        } catch (Exception unused) {
        }
    }

    private final void setCourseExpireDate(List<Emi> emi) {
        TextView textView;
        String emiValidity = "";
        for (Emi emi2 : emi) {
            if (StringsKt.equals(emi2.getEmi_status(), "Paid", true)) {
                emiValidity = emi2.getEmiValidity();
            }
        }
        if (emiValidity.length() > 0) {
            String str = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date(Long.parseLong(emiValidity) * ((long) 1000)));
            ActivityInstallmentDetailBinding mBinding = getMBinding();
            if (mBinding == null || (textView = mBinding.expiresOnValueTxt) == null) {
                return;
            }
            textView.setText(str.toString());
        }
    }

    private final void success_dailog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.success_dialog);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setSoftInputMode(16);
        getWindow().setSoftInputMode(3);
        Window window2 = dialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        int i = (int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d);
        Window window3 = dialog.getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setLayout(i, -2);
        Window window4 = dialog.getWindow();
        Intrinsics.checkNotNull(window4);
        window4.setGravity(17);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        View viewFindViewById = dialog.findViewById(R.id.et_order_id);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = dialog.findViewById(R.id.cvrCourseName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((TextInputLayout) viewFindViewById2).setVisibility(8);
        View viewFindViewById3 = dialog.findViewById(R.id.et_transaction_id);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        View viewFindViewById4 = dialog.findViewById(R.id.course_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ((EditText) viewFindViewById).setText(this.pre_transaction_id);
        ((EditText) viewFindViewById3).setText(this.pos_txn_id);
        View viewFindViewById5 = dialog.findViewById(R.id.btn_my_course);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        Button button = (Button) viewFindViewById5;
        button.setText(getResources().getString(R.string.ok));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InstallmentDetailActivity.success_dailog$lambda$29(this.f$0, view);
            }
        });
        dialog.show();
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                InstallmentDetailActivity.success_dailog$lambda$30(dialog, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void success_dailog$lambda$29(InstallmentDetailActivity installmentDetailActivity, View view) {
        try {
            UtkashRoom utkashRoom = installmentDetailActivity.utkashRoom;
            Intrinsics.checkNotNull(utkashRoom);
            DueEmiDao dueEmi = utkashRoom.getDueEmi();
            PurchaseHistoryModel.Data data = installmentDetailActivity.data;
            Intrinsics.checkNotNull(data);
            dueEmi.deleteRecord(data.getId());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        installmentDetailActivity.gotoDashboardPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void success_dailog$lambda$30(Dialog dialog, DialogInterface dialogInterface) {
        dialog.dismiss();
        dialog.cancel();
    }

    private final void setViewData(CourseDetail courseDetail) {
        ImageView imageView;
        PurchaseHistoryModel.Data data;
        ImageView imageView2;
        ShapeableImageView shapeableImageView;
        ImageView imageView3;
        ShapeableImageView shapeableImageView2;
        String upcoming_emi_date;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView4;
        ShapeableImageView shapeableImageView3;
        ImageView imageView5;
        ShapeableImageView shapeableImageView4;
        ImageView imageView6;
        ShapeableImageView shapeableImageView5;
        ActivityInstallmentDetailBinding mBinding = getMBinding();
        if (mBinding != null && (data = this.data) != null) {
            mBinding.orderId.setText(data.getPre_transaction_id());
            mBinding.lateFeePanalty.setText(Constants.currencyType + " " + data.getPanelty_amount() + " /-");
            if (!data.getPenalty_paid().equals("0")) {
                TextView lateFeePanalty = mBinding.lateFeePanalty;
                Intrinsics.checkNotNullExpressionValue(lateFeePanalty, "lateFeePanalty");
                lateFeePanalty.setVisibility(0);
            } else {
                TextView lateFeePanalty2 = mBinding.lateFeePanalty;
                Intrinsics.checkNotNullExpressionValue(lateFeePanalty2, "lateFeePanalty");
                lateFeePanalty2.setVisibility(0);
            }
            InstallmentDetailActivity installmentDetailActivity = this;
            Glide.with((FragmentActivity) installmentDetailActivity).load(courseDetail.getData().getCourseDetail().getDescHeaderImage()).into(mBinding.videoImage);
            mBinding.upcomingInstallmentAmount.setText(Constants.currencyType + " " + data.getUpcoming_emi_amount() + " /-");
            mBinding.price.setText(Constants.currencyType + " " + data.getMrp() + " /-");
            mBinding.priceValueTxt.setText(Constants.currencyType + " " + data.getMrp() + " /-");
            mBinding.titleTV.setText(data.getTitle());
            BottomSetting bottomSetting = this.bottomSetting;
            if (bottomSetting != null) {
                Intrinsics.checkNotNull(bottomSetting);
                if (bottomSetting.getLayout_type() != null) {
                    BottomSetting bottomSetting2 = this.bottomSetting;
                    Intrinsics.checkNotNull(bottomSetting2);
                    if (bottomSetting2.getLayout_type().equals("1")) {
                        ActivityInstallmentDetailBinding mBinding2 = getMBinding();
                        ViewGroup.LayoutParams layoutParams = (mBinding2 == null || (shapeableImageView5 = mBinding2.imageIV) == null) ? null : shapeableImageView5.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = "1:1";
                        ActivityInstallmentDetailBinding mBinding3 = getMBinding();
                        ViewGroup.LayoutParams layoutParams2 = (mBinding3 == null || (imageView6 = mBinding3.videoImage) == null) ? null : imageView6.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ((ConstraintLayout.LayoutParams) layoutParams2).dimensionRatio = "1:1";
                    }
                }
            }
            if (!TextUtils.isEmpty(data.getDesc_header_image())) {
                if (setThumbAccordingRatio()) {
                    ActivityInstallmentDetailBinding mBinding4 = getMBinding();
                    if (mBinding4 != null && (shapeableImageView4 = mBinding4.imageIV) != null) {
                        Glide.with((FragmentActivity) installmentDetailActivity).load(data.getDesc_header_image()).placeholder(R.mipmap.square_placeholder).into(shapeableImageView4);
                    }
                    ActivityInstallmentDetailBinding mBinding5 = getMBinding();
                    if (mBinding5 != null && (imageView5 = mBinding5.videoImage) != null) {
                        Glide.with((FragmentActivity) installmentDetailActivity).load(data.getDesc_header_image()).placeholder(R.mipmap.square_placeholder).into(imageView5);
                    }
                } else {
                    ActivityInstallmentDetailBinding mBinding6 = getMBinding();
                    if (mBinding6 != null && (shapeableImageView3 = mBinding6.imageIV) != null) {
                        Glide.with((FragmentActivity) installmentDetailActivity).load(data.getDesc_header_image()).placeholder(R.mipmap.placeholder_course).into(shapeableImageView3);
                    }
                    ActivityInstallmentDetailBinding mBinding7 = getMBinding();
                    if (mBinding7 != null && (imageView4 = mBinding7.videoImage) != null) {
                        Glide.with((FragmentActivity) installmentDetailActivity).load(data.getDesc_header_image()).placeholder(R.mipmap.placeholder_course).into(imageView4);
                    }
                }
            } else if (setThumbAccordingRatio()) {
                ActivityInstallmentDetailBinding mBinding8 = getMBinding();
                if (mBinding8 != null && (shapeableImageView2 = mBinding8.imageIV) != null) {
                    Glide.with((FragmentActivity) installmentDetailActivity).load(data.getCover_image()).placeholder(R.mipmap.square_placeholder).into(shapeableImageView2);
                }
                ActivityInstallmentDetailBinding mBinding9 = getMBinding();
                if (mBinding9 != null && (imageView3 = mBinding9.videoImage) != null) {
                    Glide.with((FragmentActivity) installmentDetailActivity).load(data.getCover_image()).placeholder(R.mipmap.square_placeholder).into(imageView3);
                }
            } else {
                ActivityInstallmentDetailBinding mBinding10 = getMBinding();
                if (mBinding10 != null && (shapeableImageView = mBinding10.imageIV) != null) {
                    Glide.with((FragmentActivity) installmentDetailActivity).load(data.getCover_image()).placeholder(R.mipmap.placeholder_course).into(shapeableImageView);
                }
                ActivityInstallmentDetailBinding mBinding11 = getMBinding();
                if (mBinding11 != null && (imageView2 = mBinding11.videoImage) != null) {
                    Glide.with((FragmentActivity) installmentDetailActivity).load(data.getCover_image()).placeholder(R.mipmap.placeholder_course).into(imageView2);
                }
            }
            ActivityInstallmentDetailBinding mBinding12 = getMBinding();
            if (mBinding12 != null && (textView4 = mBinding12.coursenameTV) != null) {
                textView4.setText(String.valueOf(data.getTitle()));
            }
            ActivityInstallmentDetailBinding mBinding13 = getMBinding();
            if (mBinding13 != null && (textView3 = mBinding13.priceValueTxt) != null) {
                textView3.setText(Constants.currencyType + " " + data.getMrp());
            }
            if (!GenericUtils.isEmpty(data.getExpiry_date())) {
                String expiry_date = data.getExpiry_date();
                Long lValueOf = expiry_date != null ? Long.valueOf(Long.parseLong(expiry_date)) : null;
                Intrinsics.checkNotNull(lValueOf);
                String str = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date(lValueOf.longValue() * ((long) 1000)));
                ActivityInstallmentDetailBinding mBinding14 = getMBinding();
                if (mBinding14 != null && (textView2 = mBinding14.expiresOnValueTxt) != null) {
                    textView2.setText(" " + str);
                }
            }
            if (!GenericUtils.isEmpty(data.getPurchase_date())) {
                String purchase_date = data.getPurchase_date();
                Long lValueOf2 = purchase_date != null ? Long.valueOf(Long.parseLong(purchase_date)) : null;
                Intrinsics.checkNotNull(lValueOf2);
                String str2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date(lValueOf2.longValue() * ((long) 1000)));
                ActivityInstallmentDetailBinding mBinding15 = getMBinding();
                if (mBinding15 != null && (textView = mBinding15.purchasedOnValueTxt) != null) {
                    textView.setText(" " + str2);
                }
            }
            if (!GenericUtils.isEmpty(data.getPayment_mode()) && data.getPayment_mode().equals("1")) {
                mBinding.PaymentType.setText(getResources().getString(R.string.installment_));
            } else {
                mBinding.PaymentType.setText(getResources().getString(R.string.normal));
            }
            PurchaseHistoryModel.Data data2 = this.data;
            if (!GenericUtils.isEmpty(data2 != null ? data2.getUpcoming_emi_date() : null)) {
                PurchaseHistoryModel.Data data3 = this.data;
                Long lValueOf3 = (data3 == null || (upcoming_emi_date = data3.getUpcoming_emi_date()) == null) ? null : Long.valueOf(Long.parseLong(upcoming_emi_date));
                Intrinsics.checkNotNull(lValueOf3);
                mBinding.paymentStatus.setText(getActivity().getResources().getString(R.string.upcoming_installment) + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date(lValueOf3.longValue() * ((long) 1000))));
            }
            if (!GenericUtils.isEmpty(data.getDues())) {
                LinearLayout duePaymentLL = mBinding.duePaymentLL;
                Intrinsics.checkNotNullExpressionValue(duePaymentLL, "duePaymentLL");
                duePaymentLL.setVisibility(0);
                mBinding.duePayment.setText(Constants.currencyType + " " + data.getDues() + " /-");
            } else {
                LinearLayout duePaymentLL2 = mBinding.duePaymentLL;
                Intrinsics.checkNotNullExpressionValue(duePaymentLL2, "duePaymentLL");
                duePaymentLL2.setVisibility(8);
            }
            LinearLayout openLayoutLL = mBinding.openLayoutLL;
            Intrinsics.checkNotNullExpressionValue(openLayoutLL, "openLayoutLL");
            LinearLayout linearLayout = openLayoutLL;
            String order_status = data.getOrder_status();
            Boolean boolValueOf = order_status != null ? Boolean.valueOf(StringsKt.equals(order_status, "closed", true)) : null;
            Intrinsics.checkNotNull(boolValueOf);
            linearLayout.setVisibility(!boolValueOf.booleanValue() ? 0 : 8);
            TextView tvPaymentStatus = mBinding.tvPaymentStatus;
            Intrinsics.checkNotNullExpressionValue(tvPaymentStatus, "tvPaymentStatus");
            TextView textView5 = tvPaymentStatus;
            String order_status2 = data.getOrder_status();
            Boolean boolValueOf2 = order_status2 != null ? Boolean.valueOf(StringsKt.equals(order_status2, "closed", true)) : null;
            Intrinsics.checkNotNull(boolValueOf2);
            textView5.setVisibility(boolValueOf2.booleanValue() ? 0 : 8);
            mBinding.paymentCode.setText(data.getProduct_code());
            mBinding.status.setText(data.getOrder_status());
            mBinding.ProductName.setText(data.getTitle());
            mBinding.coursenameTV.setText(data.getTitle());
            if (!GenericUtils.isEmpty(data.getUpcoming_emi_amount())) {
                LinearLayout totalPaymentDueLL = mBinding.totalPaymentDueLL;
                Intrinsics.checkNotNullExpressionValue(totalPaymentDueLL, "totalPaymentDueLL");
                totalPaymentDueLL.setVisibility(0);
                if (!GenericUtils.isEmpty(data.getTax()) && !Intrinsics.areEqual(data.getTax(), "0")) {
                    String tax = data.getTax();
                    Intrinsics.checkNotNullExpressionValue(tax, "getTax(...)");
                    double d2 = Double.parseDouble(tax);
                    String upcoming_emi_amount = data.getUpcoming_emi_amount();
                    Intrinsics.checkNotNullExpressionValue(upcoming_emi_amount, "getUpcoming_emi_amount(...)");
                    double d3 = Double.parseDouble(upcoming_emi_amount) + d2;
                    TextView textView6 = mBinding.totalPaymentDue;
                    String str3 = Constants.currencyType;
                    String panelty_amount = data.getPanelty_amount();
                    Intrinsics.checkNotNullExpressionValue(panelty_amount, "getPanelty_amount(...)");
                    textView6.setText(str3 + " " + (d3 + ((double) Integer.parseInt(panelty_amount))) + " /-");
                } else {
                    TextView textView7 = mBinding.totalPaymentDue;
                    String str4 = Constants.currencyType;
                    String upcoming_emi_amount2 = data.getUpcoming_emi_amount();
                    Intrinsics.checkNotNullExpressionValue(upcoming_emi_amount2, "getUpcoming_emi_amount(...)");
                    int i = Integer.parseInt(upcoming_emi_amount2);
                    String panelty_amount2 = data.getPanelty_amount();
                    Intrinsics.checkNotNullExpressionValue(panelty_amount2, "getPanelty_amount(...)");
                    textView7.setText(str4 + " " + (i + Integer.parseInt(panelty_amount2)) + " /-");
                }
            } else {
                LinearLayout totalPaymentDueLL2 = mBinding.totalPaymentDueLL;
                Intrinsics.checkNotNullExpressionValue(totalPaymentDueLL2, "totalPaymentDueLL");
                totalPaymentDueLL2.setVisibility(8);
            }
        }
        ActivityInstallmentDetailBinding mBinding16 = getMBinding();
        if (mBinding16 == null || (imageView = mBinding16.imageBack) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onBackPressed();
            }
        });
    }

    @Override // com.appnew.android.Payment.IOnViewDetailsClick
    public void onViewDetailsClick(int position1, String ttl, boolean isQRPay) {
        if (StringsKt.equals(MakeMyExam.getUserId(), "0", true)) {
            return;
        }
        if (StringsKt.equals(ttl, "Add", true)) {
            AddToLibrary();
        } else {
            this.isPayViaQR = isQRPay;
            makeOnlinePayment(position1);
        }
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String pos_txn_id) {
        this.pos_txn_id = pos_txn_id;
        getNetworkCall().NetworkAPICall(API.int_payment, "", true, false);
        if (this.isEmi) {
            return;
        }
        BottomSheetDialog bottomSheetDialog = this.watchlist;
        Intrinsics.checkNotNull(bottomSheetDialog);
        dismissCalculatorDialog(bottomSheetDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissCalculatorDialog(BottomSheetDialog watchlist) {
        if (watchlist == null || !watchlist.isShowing()) {
            return;
        }
        watchlist.dismiss();
        watchlist.cancel();
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        JSONObject jSONObjectOptJSONObject;
        this.pos_txn_id = "";
        this.isfailure = true;
        if (s != null) {
            try {
                JSONObject jSONObject = new JSONObject(s);
                if (jSONObject.has("error") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("error")) != null && jSONObjectOptJSONObject.has("description")) {
                    String strOptString = jSONObjectOptJSONObject.optString("description");
                    if (!TextUtils.isEmpty(strOptString) && strOptString.equals("undefined")) {
                        strOptString = "Payment Failed.";
                    }
                    Toast.makeText(getActivity(), strOptString, 0).show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.isEmi) {
            getNetworkCall().NetworkAPICall(API.int_payment, "", true, false);
            return;
        }
        BottomSheetDialog bottomSheetDialog = this.watchlist;
        Intrinsics.checkNotNull(bottomSheetDialog);
        dismissCalculatorDialog(bottomSheetDialog);
    }

    private final void downloadInvoice(String data) {
        final PostFile postFile = new PostFile();
        postFile.setLink(data);
        postFile.setFile_type(Const.COURSE_INVOICE);
        String str = data;
        String str2 = ((String[]) new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(str, 0).toArray(new String[0]))[new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(str, 0).toArray(new String[0]).length - 1];
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "", false, 2, (Object) null)) {
            postFile.setFile_info(new Regex(" ").replace(str2, "_"));
        } else {
            postFile.setFile_info(((String[]) new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(str, 0).toArray(new String[0]))[new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(str, 0).toArray(new String[0]).length - 1]);
        }
        try {
            Dexter.withContext(getActivity()).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity.downloadInvoice.1
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) throws Throwable {
                    Intrinsics.checkNotNullParameter(report, "report");
                    if (Helper.isConnected(InstallmentDetailActivity.this.getActivity())) {
                        if (Helper.getStorageInstance(InstallmentDetailActivity.this.getActivity()).getRecordObject(Const.COURSE_INVOICE) != null) {
                            Object recordObject = Helper.getStorageInstance(InstallmentDetailActivity.this.getActivity()).getRecordObject(Const.COURSE_INVOICE);
                            Intrinsics.checkNotNull(recordObject, "null cannot be cast to non-null type com.appnew.android.Model.PostFile");
                            Helper.DownloadfilefromURL((Activity) InstallmentDetailActivity.this.getActivity(), (PostFile) recordObject);
                            Helper.getStorageInstance(InstallmentDetailActivity.this.getActivity()).deleteRecord(Const.COURSE_INVOICE);
                            return;
                        }
                        Helper.DownloadfilefromURL((Activity) InstallmentDetailActivity.this.getActivity(), postFile);
                        return;
                    }
                    Context activity = InstallmentDetailActivity.this.getActivity();
                    String string = InstallmentDetailActivity.this.getActivity().getResources().getString(R.string.no_internet_connection);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    XtensionFunctionKt.showSmallLengthToast(activity, string);
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    Intrinsics.checkNotNullParameter(permissions, "permissions");
                    Intrinsics.checkNotNullParameter(token, "token");
                    token.continuePermissionRequest();
                }
            }).check();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final ProgressDialog getProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            return progressDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        return null;
    }

    public final void setProgressDialog(ProgressDialog progressDialog) {
        Intrinsics.checkNotNullParameter(progressDialog, "<set-?>");
        this.progressDialog = progressDialog;
    }

    public final File getPath1() {
        return this.path1;
    }

    public final void setPath1(File file) {
        this.path1 = file;
    }

    /* JADX INFO: compiled from: InstallmentDetailActivity.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\b\u0010\"\u001a\u00020#H\u0014J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0014J%\u0010&\u001a\u00020#2\u0016\u0010'\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030(\"\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010)J%\u0010*\u001a\u00020\u00022\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020(\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"}, d2 = {"Lcom/appnew/android/PurchaseHistory/activity/InstallmentDetailActivity$DownloadTask;", "Landroid/os/AsyncTask;", "", "", "context", "Landroid/content/Context;", "urlPath", "name", "<init>", "(Lcom/appnew/android/PurchaseHistory/activity/InstallmentDetailActivity;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "fileOutputStream", "Ljava/io/FileOutputStream;", "getFileOutputStream", "()Ljava/io/FileOutputStream;", "setFileOutputStream", "(Ljava/io/FileOutputStream;)V", "inputStream", "Ljava/io/InputStream;", "getInputStream", "()Ljava/io/InputStream;", "setInputStream", "(Ljava/io/InputStream;)V", "bao", "Ljava/io/ByteArrayOutputStream;", "getBao", "()Ljava/io/ByteArrayOutputStream;", "setBao", "(Ljava/io/ByteArrayOutputStream;)V", "arrayPdf", "", "getArrayPdf", "()[B", "setArrayPdf", "([B)V", "onPreExecute", "", "onPostExecute", "result", "onProgressUpdate", "values", "", "([Ljava/lang/Integer;)V", "doInBackground", NativeProtocol.WEB_DIALOG_PARAMS, "([Ljava/lang/String;)Ljava/lang/String;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DownloadTask extends AsyncTask<String, Integer, String> {
        private byte[] arrayPdf;
        private ByteArrayOutputStream bao;
        private final Context context;
        private FileOutputStream fileOutputStream;
        private InputStream inputStream;
        private final String name;
        final /* synthetic */ InstallmentDetailActivity this$0;
        private final String urlPath;

        public DownloadTask(InstallmentDetailActivity installmentDetailActivity, Context context, String urlPath, String name) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(urlPath, "urlPath");
            Intrinsics.checkNotNullParameter(name, "name");
            this.this$0 = installmentDetailActivity;
            this.context = context;
            this.urlPath = urlPath;
            this.name = name;
            this.arrayPdf = new byte[0];
        }

        public final FileOutputStream getFileOutputStream() {
            return this.fileOutputStream;
        }

        public final void setFileOutputStream(FileOutputStream fileOutputStream) {
            this.fileOutputStream = fileOutputStream;
        }

        public final InputStream getInputStream() {
            return this.inputStream;
        }

        public final void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public final ByteArrayOutputStream getBao() {
            return this.bao;
        }

        public final void setBao(ByteArrayOutputStream byteArrayOutputStream) {
            this.bao = byteArrayOutputStream;
        }

        public final byte[] getArrayPdf() {
            return this.arrayPdf;
        }

        public final void setArrayPdf(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.arrayPdf = bArr;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            if (this.this$0.progressDialog == null || !this.this$0.getProgressDialog().isShowing()) {
                return;
            }
            this.this$0.getProgressDialog().dismiss();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            this.this$0.getProgressDialog().dismiss();
            if (result != null) {
                Toast.makeText(this.context, "Error while reading....", 0).show();
            } else {
                this.this$0.getProgressDialog().dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... values) {
            Intrinsics.checkNotNullParameter(values, "values");
            super.onProgressUpdate(Arrays.copyOf(values, values.length));
            this.this$0.getProgressDialog().setIndeterminate(false);
            this.this$0.getProgressDialog().setMax(100);
            ProgressDialog progressDialog = this.this$0.getProgressDialog();
            Integer num = values[0];
            Intrinsics.checkNotNull(num);
            progressDialog.setProgress(num.intValue());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00b2, code lost:
        
            r14 = r13.inputStream;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14);
            r14.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00d8, code lost:
        
            return "";
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00dd, code lost:
        
            return "";
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String doInBackground(java.lang.String... r14) {
            /*
                Method dump skipped, instruction units count: 402
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity.DownloadTask.doInBackground(java.lang.String[]):java.lang.String");
        }
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentType(String mode, JSONObject data) {
        PaymentViewModel paymentViewModel;
        PaymentViewModel paymentViewModel2;
        PaymentViewModel paymentViewModel3;
        Intrinsics.checkNotNullParameter(data, "data");
        this.isfailure = false;
        this.pos_txn_id = "";
        this.payMode = mode;
        String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.RZP);
        String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.PAYTM);
        String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.CCAV);
        String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.FONEPAY);
        String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.EASEBUZZ);
        String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.BILLDESK);
        String stringPreference7 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.EASYPAY);
        if (StringsKt.equals(mode, Credentials.RZP, true)) {
            if (stringPreference != null && stringPreference.length() != 0 && (paymentViewModel3 = this.paymentViewModel) != null) {
                paymentViewModel3.setPayVia(this.isPayViaQR ? "14" : "3");
            }
        } else if (StringsKt.equals(mode, Credentials.PAYTM, true)) {
            if (stringPreference2 != null && stringPreference2.length() != 0 && (paymentViewModel2 = this.paymentViewModel) != null) {
                paymentViewModel2.setPayVia(this.isPayViaQR ? "21" : "6");
            }
        } else if (StringsKt.equals(mode, Credentials.CCAV, true)) {
            if (stringPreference3 != null && stringPreference3.length() != 0 && (paymentViewModel = this.paymentViewModel) != null) {
                paymentViewModel.setPayVia(this.isPayViaQR ? "22" : "7");
            }
        } else if (StringsKt.equals(mode, Credentials.FONEPAY, true)) {
            if (stringPreference4 != null && stringPreference4.length() != 0) {
                PaymentViewModel paymentViewModel4 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel4);
                paymentViewModel4.setPayVia(this.isPayViaQR ? "23" : "8");
            }
        } else if (StringsKt.equals(mode, Credentials.EASEBUZZ, true)) {
            if (stringPreference5 != null && stringPreference5.length() != 0) {
                PaymentViewModel paymentViewModel5 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel5);
                paymentViewModel5.setPayVia(this.isPayViaQR ? "15" : "9");
            }
        } else if (StringsKt.equals(mode, Credentials.BILLDESK, true)) {
            if (stringPreference6 != null && stringPreference6.length() != 0) {
                PaymentViewModel paymentViewModel6 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel6);
                paymentViewModel6.setPayVia(this.isPayViaQR ? "24" : "11");
            }
        } else if (StringsKt.equals(mode, Credentials.EASYPAY, true) && stringPreference7 != null && stringPreference7.length() != 0) {
            PaymentViewModel paymentViewModel7 = this.paymentViewModel;
            Intrinsics.checkNotNull(paymentViewModel7);
            paymentViewModel7.setPayVia(this.isPayViaQR ? "18" : "13");
        }
        if (this.isEmi) {
            this.position = Integer.valueOf(data.optInt(com.clevertap.android.sdk.Constants.INAPP_POSITION));
            ModelInstallments modelInstallments = this.modelInstallmentDetails;
            Intrinsics.checkNotNull(modelInstallments);
            List<Emi> emi = modelInstallments.getEmi();
            Integer num = this.position;
            Intrinsics.checkNotNull(num);
            setEmiData(emi.get(num.intValue()));
            getNetworkCall().NetworkAPICall(API.int_payment, "", true, false);
            return;
        }
        String strOptString = data.optString("validity");
        String strOptString2 = data.optString("id");
        String strOptString3 = data.optString(FirebaseAnalytics.Param.PRICE);
        PurchaseHistoryModel.Data data2 = this.coursePaymentTime;
        if (data2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coursePaymentTime");
            data2 = null;
        }
        API_INIT_PAYMENT(strOptString, strOptString2, strOptString3, data2);
    }

    private final void callPaymentPage(String mode, JSONObject data) {
        String mrp;
        String mrp2;
        String mrp3;
        String mrp4;
        String mrp5;
        String mrp6;
        try {
            this.pre_transaction_id = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN);
            String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.RZP);
            String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.PAYTM);
            String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.CCAV);
            String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.FONEPAY);
            String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.EASEBUZZ);
            String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.BILLDESK);
            String stringPreference7 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.EASYPAY);
            if (StringsKt.equals(mode, Credentials.RZP, true)) {
                if (stringPreference == null || stringPreference.length() == 0) {
                    return;
                }
                launch_paymentGateway(((Rzp) new Gson().fromJson(stringPreference, Rzp.class)).getKey());
                return;
            }
            Integer numValueOf = null;
            if (StringsKt.equals(mode, Credentials.PAYTM, true)) {
                if (stringPreference2 == null || stringPreference2.length() == 0) {
                    return;
                }
                Paytm paytm2 = (Paytm) new Gson().fromJson(stringPreference2, Paytm.class);
                this.txnToken = data.optString("txnToken");
                if (this.isEmi) {
                    PaymentViewModel paymentViewModel = this.paymentViewModel;
                    if (paymentViewModel != null) {
                        String str = this.pre_transaction_id;
                        Intrinsics.checkNotNull(str);
                        int iRound = Math.round(Float.parseFloat(getEmiData().getEmiMrp()));
                        String str2 = this.txnToken;
                        String secret = paytm2.getSecret();
                        Intrinsics.checkNotNull(secret);
                        String url = paytm2.getUrl();
                        Intrinsics.checkNotNull(url);
                        paymentViewModel.launchPaytmPaymentGateway(str, iRound, str2, secret, url);
                        return;
                    }
                    return;
                }
                PaymentViewModel paymentViewModel2 = this.paymentViewModel;
                if (paymentViewModel2 != null) {
                    String str3 = this.pre_transaction_id;
                    Intrinsics.checkNotNull(str3);
                    PurchaseHistoryModel.Data data2 = this.data;
                    if (data2 != null && (mrp6 = data2.getMrp()) != null) {
                        numValueOf = Integer.valueOf(MathKt.roundToInt(Double.parseDouble(mrp6)));
                    }
                    Intrinsics.checkNotNull(numValueOf);
                    int iIntValue = numValueOf.intValue();
                    String str4 = this.txnToken;
                    String secret2 = paytm2.getSecret();
                    Intrinsics.checkNotNull(secret2);
                    String url2 = paytm2.getUrl();
                    Intrinsics.checkNotNull(url2);
                    paymentViewModel2.launchPaytmPaymentGateway(str3, iIntValue, str4, secret2, url2);
                    return;
                }
                return;
            }
            if (StringsKt.equals(mode, Credentials.CCAV, true)) {
                if (stringPreference3 == null || stringPreference3.length() == 0) {
                    return;
                }
                Ccav ccav = (Ccav) new Gson().fromJson(stringPreference3, Ccav.class);
                this.enc_val = data.optString("txnToken");
                if (this.isEmi) {
                    PaymentViewModel paymentViewModel3 = this.paymentViewModel;
                    if (paymentViewModel3 != null) {
                        String str5 = this.pre_transaction_id;
                        Intrinsics.checkNotNull(str5);
                        int iRound2 = Math.round(Float.parseFloat(getEmiData().getEmiMrp()));
                        String str6 = this.enc_val;
                        String secret3 = ccav.getSecret();
                        Intrinsics.checkNotNull(secret3);
                        String redirect_url = ccav.getRedirect_url();
                        Intrinsics.checkNotNull(redirect_url);
                        String cancel_url = ccav.getCancel_url();
                        Intrinsics.checkNotNull(cancel_url);
                        String android_url = ccav.getAndroid_url();
                        Intrinsics.checkNotNull(android_url);
                        paymentViewModel3.launchCcAvenuePaymentGateway(str5, iRound2, str6, secret3, redirect_url, cancel_url, android_url);
                        return;
                    }
                    return;
                }
                PaymentViewModel paymentViewModel4 = this.paymentViewModel;
                if (paymentViewModel4 != null) {
                    String str7 = this.pre_transaction_id;
                    Intrinsics.checkNotNull(str7);
                    PurchaseHistoryModel.Data data3 = this.data;
                    if (data3 != null && (mrp5 = data3.getMrp()) != null) {
                        numValueOf = Integer.valueOf(MathKt.roundToInt(Double.parseDouble(mrp5)));
                    }
                    Intrinsics.checkNotNull(numValueOf);
                    int iIntValue2 = numValueOf.intValue();
                    String str8 = this.enc_val;
                    String secret4 = ccav.getSecret();
                    Intrinsics.checkNotNull(secret4);
                    String redirect_url2 = ccav.getRedirect_url();
                    Intrinsics.checkNotNull(redirect_url2);
                    String cancel_url2 = ccav.getCancel_url();
                    Intrinsics.checkNotNull(cancel_url2);
                    String android_url2 = ccav.getAndroid_url();
                    Intrinsics.checkNotNull(android_url2);
                    paymentViewModel4.launchCcAvenuePaymentGateway(str7, iIntValue2, str8, secret4, redirect_url2, cancel_url2, android_url2);
                    return;
                }
                return;
            }
            if (StringsKt.equals(mode, Credentials.FONEPAY, true)) {
                if (stringPreference4 == null || stringPreference4.length() == 0) {
                    return;
                }
                FonePay fonePay = (FonePay) new Gson().fromJson(stringPreference4, FonePay.class);
                if ((fonePay != null ? fonePay.getStatus() : null) == null || !StringsKt.equals(fonePay.getStatus(), "1", true)) {
                    return;
                }
                String strOptString = data.optString("txnToken");
                if (this.isEmi) {
                    PaymentViewModel paymentViewModel5 = this.paymentViewModel;
                    Intrinsics.checkNotNull(paymentViewModel5);
                    Intrinsics.checkNotNull(strOptString);
                    paymentViewModel5.launchFonePayPaymentGateway(strOptString, Math.round(Float.parseFloat(getEmiData().getEmiMrp())));
                    return;
                }
                PaymentViewModel paymentViewModel6 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel6);
                Intrinsics.checkNotNull(strOptString);
                PurchaseHistoryModel.Data data4 = this.data;
                if (data4 != null && (mrp4 = data4.getMrp()) != null) {
                    numValueOf = Integer.valueOf(MathKt.roundToInt(Double.parseDouble(mrp4)));
                }
                Intrinsics.checkNotNull(numValueOf);
                paymentViewModel6.launchFonePayPaymentGateway(strOptString, numValueOf.intValue());
                return;
            }
            if (StringsKt.equals(mode, Credentials.EASEBUZZ, true)) {
                if (stringPreference5 == null || stringPreference5.length() == 0) {
                    return;
                }
                EaseBuzz easeBuzz = (EaseBuzz) new Gson().fromJson(stringPreference5, EaseBuzz.class);
                if ((easeBuzz != null ? easeBuzz.getStatus() : null) == null || !StringsKt.equals(easeBuzz.getStatus(), "1", true)) {
                    return;
                }
                String strOptString2 = data.optString("txnToken");
                if (this.isEmi) {
                    PaymentViewModel paymentViewModel7 = this.paymentViewModel;
                    Intrinsics.checkNotNull(paymentViewModel7);
                    Intrinsics.checkNotNull(strOptString2);
                    int iRound3 = Math.round(Float.parseFloat(getEmiData().getEmiMrp()));
                    String mode2 = easeBuzz.getMode();
                    Intrinsics.checkNotNull(mode2);
                    paymentViewModel7.launchEaseBuzzPaymentGateway(strOptString2, iRound3, mode2);
                    return;
                }
                PaymentViewModel paymentViewModel8 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel8);
                Intrinsics.checkNotNull(strOptString2);
                PurchaseHistoryModel.Data data5 = this.data;
                if (data5 != null && (mrp3 = data5.getMrp()) != null) {
                    numValueOf = Integer.valueOf(MathKt.roundToInt(Double.parseDouble(mrp3)));
                }
                Intrinsics.checkNotNull(numValueOf);
                int iIntValue3 = numValueOf.intValue();
                String mode3 = easeBuzz.getMode();
                Intrinsics.checkNotNull(mode3);
                paymentViewModel8.launchEaseBuzzPaymentGateway(strOptString2, iIntValue3, mode3);
                return;
            }
            if (StringsKt.equals(mode, Credentials.BILLDESK, true)) {
                if (stringPreference6 == null || stringPreference6.length() == 0) {
                    return;
                }
                BillDesk billDesk = (BillDesk) new Gson().fromJson(stringPreference6, BillDesk.class);
                if ((billDesk != null ? billDesk.getStatus() : null) == null || !StringsKt.equals(billDesk.getStatus(), "1", true)) {
                    return;
                }
                String strOptString3 = data.optString("txnToken");
                if (this.isEmi) {
                    PaymentViewModel paymentViewModel9 = this.paymentViewModel;
                    Intrinsics.checkNotNull(paymentViewModel9);
                    Intrinsics.checkNotNull(strOptString3);
                    paymentViewModel9.launchBillDeskPaymentGateway(strOptString3, Math.round(Float.parseFloat(getEmiData().getEmiMrp())));
                    return;
                }
                PaymentViewModel paymentViewModel10 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel10);
                Intrinsics.checkNotNull(strOptString3);
                PurchaseHistoryModel.Data data6 = this.data;
                if (data6 != null && (mrp2 = data6.getMrp()) != null) {
                    numValueOf = Integer.valueOf(MathKt.roundToInt(Double.parseDouble(mrp2)));
                }
                Intrinsics.checkNotNull(numValueOf);
                paymentViewModel10.launchBillDeskPaymentGateway(strOptString3, numValueOf.intValue());
                return;
            }
            if (!StringsKt.equals(mode, Credentials.EASYPAY, true) || stringPreference7 == null || stringPreference7.length() == 0) {
                return;
            }
            EasyPay easyPay = (EasyPay) new Gson().fromJson(stringPreference7, EasyPay.class);
            if ((easyPay != null ? easyPay.getStatus() : null) == null || !StringsKt.equals(easyPay.getStatus(), "1", true)) {
                return;
            }
            String strOptString4 = data.optString("txnToken");
            if (this.isEmi) {
                PaymentViewModel paymentViewModel11 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel11);
                Intrinsics.checkNotNull(strOptString4);
                paymentViewModel11.launchEasyPayPaymentGateway(strOptString4, Math.round(Float.parseFloat(getEmiData().getEmiMrp())));
                return;
            }
            PaymentViewModel paymentViewModel12 = this.paymentViewModel;
            Intrinsics.checkNotNull(paymentViewModel12);
            Intrinsics.checkNotNull(strOptString4);
            PurchaseHistoryModel.Data data7 = this.data;
            if (data7 != null && (mrp = data7.getMrp()) != null) {
                numValueOf = Integer.valueOf(MathKt.roundToInt(Double.parseDouble(mrp)));
            }
            Intrinsics.checkNotNull(numValueOf);
            paymentViewModel12.launchEasyPayPaymentGateway(strOptString4, numValueOf.intValue());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentTypeCancel() {
        this.pre_transaction_id = "";
    }

    private final boolean setThumbAccordingRatio() {
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting == null) {
            return false;
        }
        Intrinsics.checkNotNull(bottomSetting);
        if (bottomSetting.getLayout_type() == null) {
            return false;
        }
        BottomSetting bottomSetting2 = this.bottomSetting;
        Intrinsics.checkNotNull(bottomSetting2);
        return bottomSetting2.getLayout_type().equals("1");
    }

    private final void setThumbRatio(ImageView rlThum) {
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null) {
            Intrinsics.checkNotNull(bottomSetting);
            if (bottomSetting.getLayout_type() != null) {
                BottomSetting bottomSetting2 = this.bottomSetting;
                Intrinsics.checkNotNull(bottomSetting2);
                if (bottomSetting2.getLayout_type().equals("1")) {
                    ViewGroup.LayoutParams layoutParams = rlThum.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = "1:1";
                }
            }
        }
    }

    private final void AddToLibrary() {
        getNetworkCall().NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false);
    }

    private final void makeOnlinePayment(int position1) {
        String str;
        String str2;
        PaymentViewModel paymentViewModel;
        PaymentViewModel paymentViewModel2;
        PaymentViewModel paymentViewModel3;
        PaymentViewModel paymentViewModel4;
        PaymentViewModel paymentViewModel5;
        EaseBuzz easeBuzz;
        EasyPay easyPay;
        Ccav ccav;
        Paytm paytm2;
        try {
            ArrayList arrayList = new ArrayList();
            String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.RZP);
            String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.PAYTM);
            String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.CCAV);
            String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.EASYPAY);
            String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(getActivity(), Credentials.EASEBUZZ);
            if (stringPreference == null || stringPreference.length() == 0) {
                str = Credentials.EASEBUZZ;
            } else {
                Gson gson = new Gson();
                str = Credentials.EASEBUZZ;
                Rzp rzp = (Rzp) gson.fromJson(stringPreference, Rzp.class);
                if (rzp != null && rzp.getStatus() != null && StringsKt.equals(rzp.getStatus(), "1", true)) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("name", Credentials.RZP);
                    jsonObject.addProperty("mode_name", getString(R.string.razorpay));
                    arrayList.add(jsonObject);
                }
            }
            if (stringPreference2 != null && stringPreference2.length() != 0 && (paytm2 = (Paytm) new Gson().fromJson(stringPreference2, Paytm.class)) != null && paytm2.getStatus() != null && StringsKt.equals(paytm2.getStatus(), "1", true)) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("name", Credentials.PAYTM);
                jsonObject2.addProperty("mode_name", getString(R.string.f577paytm));
                arrayList.add(jsonObject2);
            }
            if (stringPreference3 != null && stringPreference3.length() != 0 && (ccav = (Ccav) new Gson().fromJson(stringPreference3, Ccav.class)) != null && ccav.getStatus() != null && StringsKt.equals(ccav.getStatus(), "1", true)) {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("name", Credentials.CCAV);
                jsonObject3.addProperty("mode_name", getString(R.string.ccavenue));
                arrayList.add(jsonObject3);
            }
            if (stringPreference4 != null && stringPreference4.length() != 0 && (easyPay = (EasyPay) new Gson().fromJson(stringPreference4, EasyPay.class)) != null && easyPay.getStatus() != null && StringsKt.equals(easyPay.getStatus(), "1", true)) {
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("name", Credentials.EASYPAY);
                jsonObject4.addProperty("mode_name", getString(R.string.f575easypay));
                arrayList.add(jsonObject4);
            }
            if (stringPreference5 == null || stringPreference5.length() == 0 || (easeBuzz = (EaseBuzz) new Gson().fromJson(stringPreference5, EaseBuzz.class)) == null || easeBuzz.getStatus() == null || !StringsKt.equals(easeBuzz.getStatus(), "1", true)) {
                str2 = str;
            } else {
                JsonObject jsonObject5 = new JsonObject();
                str2 = str;
                jsonObject5.addProperty("name", str2);
                jsonObject5.addProperty("mode_name", getString(R.string.easybuzz));
                arrayList.add(jsonObject5);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.clevertap.android.sdk.Constants.INAPP_POSITION, position1);
            PurchaseHistoryModel.Data data = this.data;
            Intrinsics.checkNotNull(data);
            this.coursePaymentTime = data;
            if (arrayList.size() > 1) {
                Helper.callPaymentTypeDialog(this, arrayList, this, jSONObject);
                return;
            }
            if (arrayList.size() == 1) {
                String asString = ((JsonObject) arrayList.get(0)).get("name").getAsString();
                Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
                if (StringsKt.equals(asString, Credentials.RZP, true)) {
                    if (stringPreference != null && stringPreference.length() != 0 && (paymentViewModel5 = this.paymentViewModel) != null) {
                        paymentViewModel5.setPayVia(this.isPayViaQR ? "14" : "3");
                    }
                } else if (StringsKt.equals(asString, Credentials.PAYTM, true)) {
                    if (stringPreference2 != null && stringPreference2.length() != 0 && (paymentViewModel4 = this.paymentViewModel) != null) {
                        paymentViewModel4.setPayVia(this.isPayViaQR ? "21" : "6");
                    }
                } else if (StringsKt.equals(asString, Credentials.CCAV, true)) {
                    if (stringPreference3 != null && stringPreference3.length() != 0 && (paymentViewModel3 = this.paymentViewModel) != null) {
                        paymentViewModel3.setPayVia(this.isPayViaQR ? "22" : "7");
                    }
                } else if (StringsKt.equals(asString, Credentials.EASYPAY, true)) {
                    if (stringPreference4 != null && stringPreference4.length() != 0 && (paymentViewModel2 = this.paymentViewModel) != null) {
                        paymentViewModel2.setPayVia(this.isPayViaQR ? "18" : "13");
                    }
                } else if (StringsKt.equals(asString, str2, true) && stringPreference5 != null && stringPreference5.length() != 0 && (paymentViewModel = this.paymentViewModel) != null) {
                    paymentViewModel.setPayVia(this.isPayViaQR ? "15" : "9");
                }
                this.position = Integer.valueOf(position1);
                ModelInstallments modelInstallments = this.modelInstallmentDetails;
                Intrinsics.checkNotNull(modelInstallments);
                List<Emi> emi = modelInstallments.getEmi();
                Integer num = this.position;
                Intrinsics.checkNotNull(num);
                setEmiData(emi.get(num.intValue()));
                this.isfailure = false;
                this.pos_txn_id = "";
                getNetworkCall().NetworkAPICall(API.int_payment, "", true, false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void pushEventForFreeCourse() {
        String id;
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = map;
        map2.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map2.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        PurchaseHistoryModel.Data data = this.data;
        String title = "NA";
        if (data != null) {
            Intrinsics.checkNotNull(data);
            id = data.getId();
        } else {
            id = "NA";
        }
        map2.put("course_id", id);
        PurchaseHistoryModel.Data data2 = this.data;
        if (data2 != null) {
            Intrinsics.checkNotNull(data2);
            title = data2.getTitle();
        }
        map2.put(AnalyticsConstants.course_name, title);
        AnalyticEvents.INSTANCE.pushEvents(getActivity(), AnalyticsConstants.FREE_USER, map);
    }

    public final long getMLastClickTime() {
        return this.mLastClickTime;
    }

    public final void setMLastClickTime(long j) {
        this.mLastClickTime = j;
    }

    public final void showUpdateStatePopup() {
        UpdateProfileDialogUtils.makeDialogForStateUpdate(this, false, new UpdateProfileDialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity.showUpdateStatePopup.1
            @Override // com.appnew.android.Utils.UpdateProfileDialogUtils.onDialogUtilsOkClick
            public void onOKClick(Dialog dialog, String submitType, String stateId, String districtId, String addressJson) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                Intrinsics.checkNotNullParameter(submitType, "submitType");
                Intrinsics.checkNotNullParameter(stateId, "stateId");
                Intrinsics.checkNotNullParameter(districtId, "districtId");
                Intrinsics.checkNotNullParameter(addressJson, "addressJson");
                try {
                    if (SystemClock.elapsedRealtime() - InstallmentDetailActivity.this.getMLastClickTime() < 1000) {
                        return;
                    }
                    InstallmentDetailActivity.this.setMLastClickTime(SystemClock.elapsedRealtime());
                    if (!Intrinsics.areEqual(submitType, "1") && !Intrinsics.areEqual(submitType, "2")) {
                        dialog.dismiss();
                        InstallmentDetailActivity.this.finishPayment();
                        return;
                    }
                    InstallmentDetailActivity.this.submitUpdateStateData(dialog, submitType, stateId, districtId, addressJson);
                } catch (Exception e2) {
                    Log.d("Dialog", "makeDialog: " + e2.getMessage());
                }
            }
        });
    }

    public final void submitUpdateStateData(final Dialog dialog, String submitType, final String stateId, final String districtId, String addressJson) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(submitType, "submitType");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        Intrinsics.checkNotNullParameter(districtId, "districtId");
        Intrinsics.checkNotNullParameter(addressJson, "addressJson");
        InstallmentDetailActivity installmentDetailActivity = this;
        if (Helper.isNetworkConnected(installmentDetailActivity)) {
            Helper.showProgressDialog(installmentDetailActivity);
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            if (Intrinsics.areEqual(submitType, "1")) {
                encryptionData.setState(stateId);
            } else {
                encryptionData.setState(stateId);
                encryptionData.setAddress(addressJson);
            }
            Call<String> callUpdateprofile = aPIInterface.updateprofile(AES.encrypt(new Gson().toJson(encryptionData)));
            if (callUpdateprofile == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            callUpdateprofile.enqueue(new Callback<String>() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity.submitUpdateStateData.1
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    Helper.dismissProgressDialog();
                    try {
                        Intrinsics.checkNotNull(response);
                        if (response.body() != null) {
                            JSONObject jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                            com.appnew.android.pojo.Userinfo.Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
                            loggedInUser.setState(stateId);
                            loggedInUser.setCity(districtId);
                            SharedPreference.getInstance().setLoggedInUserr(loggedInUser);
                            Toast.makeText(this, jSONObject.getString("message"), 1).show();
                            dialog.dismiss();
                            this.finishPayment();
                        }
                    } catch (Exception e2) {
                        Log.d("Dialog", "onResponse: " + e2.getMessage());
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Helper.dismissProgressDialog();
                    InstallmentDetailActivity installmentDetailActivity2 = this;
                    Toast.makeText(installmentDetailActivity2, installmentDetailActivity2.getResources().getString(R.string.something_went_wrong), 1).show();
                }
            });
            return;
        }
        Toast.makeText(installmentDetailActivity, getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    public final void finishPayment() {
        try {
            UtkashRoom utkashRoom = this.utkashRoom;
            Intrinsics.checkNotNull(utkashRoom);
            DueEmiDao dueEmi = utkashRoom.getDueEmi();
            PurchaseHistoryModel.Data data = this.data;
            Intrinsics.checkNotNull(data);
            dueEmi.deleteRecord(data.getId());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        gotoDashboardPage();
    }

    public final TxnTokenData getTxnTokenData() {
        return this.txnTokenData;
    }

    public final void setTxnTokenData(TxnTokenData txnTokenData) {
        this.txnTokenData = txnTokenData;
    }

    public final ValueEventListener getQrPayValueEventListener() {
        return this.qrPayValueEventListener;
    }

    public final void setQrPayValueEventListener(ValueEventListener valueEventListener) {
        this.qrPayValueEventListener = valueEventListener;
    }

    public final void manageQRPayment(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.pre_transaction_id = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN);
        this.txnToken = data.optString("txnToken");
        TxnTokenData txnTokenData = (TxnTokenData) new Gson().fromJson(this.txnToken, TxnTokenData.class);
        this.txnTokenData = txnTokenData;
        if (txnTokenData == null) {
            showMessage("QR data not found!");
            return;
        }
        if (TextUtils.isEmpty(txnTokenData != null ? txnTokenData.getImage_url() : null)) {
            showMessage("QR image not found!");
            return;
        }
        TxnTokenData txnTokenData2 = this.txnTokenData;
        if (!TextUtils.isEmpty(txnTokenData2 != null ? txnTokenData2.getCreated_at() : null)) {
            TxnTokenData txnTokenData3 = this.txnTokenData;
            if (!TextUtils.isEmpty(txnTokenData3 != null ? txnTokenData3.getClose_by() : null)) {
                if (TextUtils.isEmpty(this.pre_transaction_id)) {
                    showMessage("Transaction id not found!");
                    return;
                } else {
                    openQRCode();
                    return;
                }
            }
        }
        showMessage("Payment duration not valid!");
    }

    public final int getDeviceWidthWithInsets() {
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsets windowInsets = windowManager.getCurrentWindowMetrics().getWindowInsets();
            Intrinsics.checkNotNullExpressionValue(windowInsets, "getWindowInsets(...)");
            Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
            return (windowManager.getCurrentWindowMetrics().getBounds().width() - insets.left) - insets.right;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public final int getDeviceHeightWithInsets() {
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsets windowInsets = windowManager.getCurrentWindowMetrics().getWindowInsets();
            Intrinsics.checkNotNullExpressionValue(windowInsets, "getWindowInsets(...)");
            Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
            return (windowManager.getCurrentWindowMetrics().getBounds().height() - insets.top) - insets.bottom;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final void openQRCode() {
        final Dialog dialog;
        final RelativeLayout relativeLayout;
        final LinearLayout linearLayout;
        ImageView imageView;
        final ImageView imageView2;
        final TextView textView;
        RequestBuilder<Bitmap> requestBuilderAsBitmap;
        TxnTokenData txnTokenData;
        try {
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_qr_payment);
            dialog.setCancelable(false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            relativeLayout = (RelativeLayout) dialog.findViewById(R.id.mainQRRL);
            linearLayout = (LinearLayout) dialog.findViewById(R.id.qrLoader);
            imageView = (ImageView) dialog.findViewById(R.id.iv_close);
            imageView2 = (ImageView) dialog.findViewById(R.id.iv_qr_image);
            textView = (TextView) dialog.findViewById(R.id.time);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            requestBuilderAsBitmap = Glide.with((FragmentActivity) this).asBitmap();
            txnTokenData = this.txnTokenData;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            requestBuilderAsBitmap.load(txnTokenData != null ? txnTokenData.getImage_url() : null).timeout(10000).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity.openQRCode.1
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                /* JADX WARN: Type inference failed for: r0v3, types: [com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$openQRCode$1$onResourceReady$1$1] */
                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    final InstallmentDetailActivity installmentDetailActivity = InstallmentDetailActivity.this;
                    LinearLayout linearLayout2 = linearLayout;
                    final Dialog dialog2 = dialog;
                    ImageView imageView3 = imageView2;
                    RelativeLayout relativeLayout2 = relativeLayout;
                    final TextView textView2 = textView;
                    installmentDetailActivity.enableScreenshot();
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                    installmentDetailActivity.qrPaymentCallback(dialog2);
                    if (imageView3 != null) {
                        imageView3.setImageBitmap(resource);
                    }
                    ViewGroup.LayoutParams layoutParams = relativeLayout2 != null ? relativeLayout2.getLayoutParams() : null;
                    if (layoutParams != null) {
                        layoutParams.width = imageView3 != null ? imageView3.getWidth() : installmentDetailActivity.getDeviceWidthWithInsets() - (installmentDetailActivity.getDeviceWidthWithInsets() / 4);
                    }
                    if (layoutParams != null) {
                        layoutParams.height = imageView3 != null ? imageView3.getHeight() : installmentDetailActivity.getDeviceHeightWithInsets() - (installmentDetailActivity.getDeviceHeightWithInsets() / 10);
                    }
                    if (relativeLayout2 != null) {
                        relativeLayout2.setLayoutParams(layoutParams);
                    }
                    TxnTokenData txnTokenData2 = installmentDetailActivity.getTxnTokenData();
                    String close_by = txnTokenData2 != null ? txnTokenData2.getClose_by() : null;
                    Intrinsics.checkNotNull(close_by);
                    long j = 1000;
                    long j2 = Long.parseLong(close_by) * j;
                    TxnTokenData txnTokenData3 = installmentDetailActivity.getTxnTokenData();
                    String created_at = txnTokenData3 != null ? txnTokenData3.getCreated_at() : null;
                    Intrinsics.checkNotNull(created_at);
                    final long j3 = j2 - (Long.parseLong(created_at) * j);
                    installmentDetailActivity.countDownTimer = new CountDownTimer(j3) { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$openQRCode$1$onResourceReady$1$1
                        @Override // android.os.CountDownTimer
                        public void onTick(long millisUntilFinished) {
                            long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % ((long) 60);
                            TextView textView3 = textView2;
                            if (textView3 != null) {
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String str = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
                                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                                textView3.setText(str);
                            }
                            if (millisUntilFinished <= 30000 && millisUntilFinished > 0) {
                                TextView textView4 = textView2;
                                if (textView4 != null) {
                                    textView4.setBackgroundTintList(ContextCompat.getColorStateList(installmentDetailActivity.getApplicationContext(), R.color.md_amber_A400));
                                    return;
                                }
                                return;
                            }
                            if (millisUntilFinished <= 120000 && millisUntilFinished > 30000) {
                                TextView textView5 = textView2;
                                if (textView5 != null) {
                                    textView5.setBackgroundTintList(ContextCompat.getColorStateList(installmentDetailActivity.getApplicationContext(), R.color.rewards_color));
                                    return;
                                }
                                return;
                            }
                            TextView textView6 = textView2;
                            if (textView6 != null) {
                                textView6.setBackgroundTintList(ContextCompat.getColorStateList(installmentDetailActivity.getApplicationContext(), R.color.md_lime_500));
                            }
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TextView textView3 = textView2;
                            if (textView3 != null) {
                                textView3.setText("Expired");
                            }
                            installmentDetailActivity.showMessage("QR Expired");
                            Dialog dialog3 = dialog2;
                            if (dialog3 != null) {
                                dialog3.dismiss();
                            }
                        }
                    }.start();
                }

                @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                public void onLoadFailed(Drawable errorDrawable) {
                    InstallmentDetailActivity.this.showMessage("Invalid QR code!");
                    Dialog dialog2 = dialog;
                    if (dialog2 != null) {
                        dialog2.dismiss();
                    }
                }
            });
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$$ExternalSyntheticLambda11
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InstallmentDetailActivity.openQRCode$lambda$46(this.f$0, dialog, view);
                    }
                });
            }
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$$ExternalSyntheticLambda12
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    InstallmentDetailActivity.openQRCode$lambda$47(this.f$0, dialogInterface);
                }
            });
            dialog.show();
        } catch (Exception e3) {
            e = e3;
            Log.d("TAGINSTANTPURCHASE", "Error: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openQRCode$lambda$46(InstallmentDetailActivity installmentDetailActivity, final Dialog dialog, View view) {
        DialogUtils.makeDialog(installmentDetailActivity, "", "Are you sure want to close!", installmentDetailActivity.getResources().getString(R.string.confirm), installmentDetailActivity.getResources().getString(R.string.cancel), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$$ExternalSyntheticLambda13
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                InstallmentDetailActivity.openQRCode$lambda$46$lambda$44(dialog);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$$ExternalSyntheticLambda14
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                InstallmentDetailActivity.openQRCode$lambda$46$lambda$45();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openQRCode$lambda$46$lambda$44(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openQRCode$lambda$47(InstallmentDetailActivity installmentDetailActivity, DialogInterface dialogInterface) {
        ValueEventListener valueEventListener;
        DatabaseReference databaseReference = installmentDetailActivity.mFirebaseDatabaseReferenceQRPay;
        if (databaseReference != null && (valueEventListener = installmentDetailActivity.qrPayValueEventListener) != null) {
            if (databaseReference != null) {
                Intrinsics.checkNotNull(valueEventListener);
                databaseReference.removeEventListener(valueEventListener);
            }
            Log.d("TAGINSTANTPURCHASE", "removefirebaseDatabaseReferenceQRPay");
        }
        CountDownTimer countDownTimer = installmentDetailActivity.countDownTimer;
        if (countDownTimer == null || countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }

    public final void qrPaymentCallback(final Dialog dialog) {
        String str = this.pre_transaction_id;
        Log.d("TAGINSTANTPURCHASE", "pre_transaction_id: " + str);
        this.mFirebaseDatabaseReferenceQRPay = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/qrcode_payment_status/" + str);
        this.qrPayValueEventListener = new ValueEventListener() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity.qrPaymentCallback.1
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                String string;
                Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                try {
                    if (dataSnapshot.getValue() == null) {
                        Log.d("TAGINSTANTPURCHASE", "noData: " + dataSnapshot.getValue());
                        return;
                    }
                    Log.d("TAGINSTANTPURCHASE", "onDataChange: " + dataSnapshot.getValue());
                    if (dataSnapshot.getValue() != null) {
                        QRPaymentData qRPaymentData = (QRPaymentData) dataSnapshot.getValue(QRPaymentData.class);
                        Long transaction_status = qRPaymentData != null ? qRPaymentData.getTransaction_status() : null;
                        if (transaction_status == null || (string = transaction_status.toString()) == null) {
                            string = "0";
                        }
                        if (qRPaymentData == null || TextUtils.isEmpty(String.valueOf(qRPaymentData.getPre_transaction_id())) || TextUtils.isEmpty(String.valueOf(qRPaymentData.getPost_transaction_id())) || !string.equals("1")) {
                            return;
                        }
                        InstallmentDetailActivity.this.pre_transaction_id = String.valueOf(qRPaymentData.getPre_transaction_id());
                        InstallmentDetailActivity.this.pos_txn_id = String.valueOf(qRPaymentData.getPost_transaction_id());
                        NetworkCall networkCall = InstallmentDetailActivity.this.getNetworkCall();
                        Intrinsics.checkNotNull(networkCall);
                        networkCall.NetworkAPICall(API.int_payment, "", true, false);
                        Dialog dialog2 = dialog;
                        if (dialog2 == null || !dialog2.isShowing()) {
                            return;
                        }
                        dialog.dismiss();
                    }
                } catch (Exception e2) {
                    Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
                }
            }
        };
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceQRPay;
        Intrinsics.checkNotNull(databaseReference);
        ValueEventListener valueEventListener = this.qrPayValueEventListener;
        Intrinsics.checkNotNull(valueEventListener);
        databaseReference.addValueEventListener(valueEventListener);
    }

    public final void enableScreenshot() {
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(8192);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMessage(final String message) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                InstallmentDetailActivity.showMessage$lambda$48(message, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMessage$lambda$48(String str, InstallmentDetailActivity installmentDetailActivity) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Toast.makeText(installmentDetailActivity.getActivity(), str2, 0).show();
    }
}
