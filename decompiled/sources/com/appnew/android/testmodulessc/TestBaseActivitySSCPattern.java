package com.appnew.android.testmodulessc;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityTestBaseSscpatternBinding;
import com.appnew.android.databinding.DialogReportErrorBinding;
import com.appnew.android.databinding.SscPatternBackSubmitDialogBinding;
import com.appnew.android.databinding.SscPatternDrawerLayoutBinding;
import com.appnew.android.databinding.SscPatternSectionSwitchDailogBinding;
import com.appnew.android.databinding.SscPatternTimeOutDialogBinding;
import com.appnew.android.databinding.SscSymbolsDialogBinding;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.testmodule.activity.TestSubmissionActivity;
import com.appnew.android.testmodule.model.QuesReportOption;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodule.model.QuestionDump;
import com.appnew.android.testmodule.model.TestBasic;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.appnew.android.testmodulessc.TestBaseActivitySSCPattern;
import com.appnew.android.testmodulessc.adapters.SSCNumBoxAdapter;
import com.appnew.android.testmodulessc.adapters.SSCNumBoxAdapterKt;
import com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapter;
import com.appnew.android.testmodulessc.adapters.SSCQuestionViewPagerAdapterKt;
import com.appnew.android.testmodulessc.adapters.SSCSectionPartAdapter;
import com.appnew.android.testmodulessc.adapters.SSCSectionTabAdapter;
import com.appnew.android.testmodulessc.models.SSCPendingReport;
import com.appnew.android.testmodulessc.models.SSCQuestion;
import com.appnew.android.testmodulessc.models.SSCTestOption;
import com.appnew.android.testmodulessc.models.SSCTestSection;
import com.appnew.android.testmodulessc.utils.PerQuestionTimerManager;
import com.appnew.android.testmodulessc.utils.SSCGsonSafe;
import com.appnew.android.testmodulessc.utils.SSCQuestionReportWorker;
import com.appnew.android.testmodulessc.utils.SSCS3UploadWorker;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: TestBaseActivitySSCPattern.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b6\b\u0007\u0018\u0000 Ö\u00012\u00020\u0001:\u0002Ö\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010^H\u0014J\b\u0010_\u001a\u00020\\H\u0002J\b\u0010`\u001a\u00020\\H\u0002J\b\u0010a\u001a\u00020\\H\u0002J\b\u0010b\u001a\u00020\\H\u0002J\u0016\u0010c\u001a\u00020\\2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\\0eH\u0002J\b\u0010f\u001a\u00020\\H\u0002J\b\u0010g\u001a\u00020\\H\u0002J\u0010\u0010h\u001a\u00020\\2\u0006\u0010i\u001a\u00020\u000eH\u0002J\u0010\u0010j\u001a\u00020\\2\u0006\u0010k\u001a\u000203H\u0002J\b\u0010l\u001a\u00020\\H\u0002J\u0010\u0010m\u001a\u00020\\2\u0006\u0010n\u001a\u00020&H\u0002J\b\u0010o\u001a\u00020&H\u0002J\u0010\u0010p\u001a\u00020\\2\u0006\u0010n\u001a\u00020&H\u0002J\u0010\u0010q\u001a\u00020\\2\u0006\u0010r\u001a\u00020sH\u0002J\u0010\u0010t\u001a\u00020\\2\u0006\u0010u\u001a\u00020vH\u0002J\b\u0010w\u001a\u00020\\H\u0002J \u0010x\u001a\u00020\r2\u0006\u0010F\u001a\u00020\r2\u0006\u00100\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rH\u0002J\u0010\u0010y\u001a\u00020\\2\u0006\u0010z\u001a\u00020\rH\u0002J\b\u0010{\u001a\u00020\\H\u0002J\u0010\u0010|\u001a\u00020\r2\u0006\u0010}\u001a\u00020\rH\u0002J\u0010\u0010~\u001a\u00020\\2\u0006\u0010n\u001a\u00020&H\u0002J\b\u0010\u007f\u001a\u00020\\H\u0002J\u0012\u0010\u0080\u0001\u001a\u00020\\2\u0007\u0010\u0081\u0001\u001a\u00020\rH\u0002J\t\u0010\u0082\u0001\u001a\u00020\\H\u0002J\u001a\u0010\u0083\u0001\u001a\u00020\r2\u000f\u0010\u0084\u0001\u001a\n\u0012\u0005\u0012\u00030\u0086\u00010\u0085\u0001H\u0002J\t\u0010\u0087\u0001\u001a\u00020\rH\u0002J\u0011\u0010\u0088\u0001\u001a\n\u0012\u0005\u0012\u00030\u0086\u00010\u0085\u0001H\u0002J#\u0010\u0089\u0001\u001a\u00020\r2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\rH\u0002J\t\u0010\u008c\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u008d\u0001\u001a\u00020\\H\u0002J\u0012\u0010\u008e\u0001\u001a\u00020\\2\u0007\u0010\u008f\u0001\u001a\u00020\u000eH\u0002J\u0018\u0010\u0090\u0001\u001a\u00020\\2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u0002030\u0011H\u0002J\t\u0010\u0092\u0001\u001a\u00020\\H\u0002J\t\u0010\u0093\u0001\u001a\u00020&H\u0002J\t\u0010\u0094\u0001\u001a\u00020&H\u0002J\t\u0010\u0095\u0001\u001a\u00020\\H\u0002J\t\u0010\u0096\u0001\u001a\u00020\\H\u0002J\t\u0010\u0097\u0001\u001a\u00020\\H\u0002J\t\u0010\u0098\u0001\u001a\u00020\\H\u0002J\u0018\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010\t2\u0006\u0010k\u001a\u000203H\u0002J\u0018\u0010\u009b\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010\t2\u0006\u0010k\u001a\u000203H\u0002J\t\u0010\u009c\u0001\u001a\u00020\\H\u0002J\u0014\u0010\u009d\u0001\u001a\u00020\\2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\nH\u0002J\"\u0010\u009f\u0001\u001a\u00020\\2\u000e\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030¡\u00010\u00112\u0007\u0010\u009e\u0001\u001a\u00020\nH\u0002J\t\u0010¢\u0001\u001a\u00020\\H\u0002J.\u0010£\u0001\u001a\u00020\\2\b\u0010¤\u0001\u001a\u00030¡\u00012\u0007\u0010\u009e\u0001\u001a\u0002032\u0007\u0010¥\u0001\u001a\u00020\r2\u0007\u0010¦\u0001\u001a\u00020AH\u0002J\t\u0010§\u0001\u001a\u00020\\H\u0002J\t\u0010¨\u0001\u001a\u00020\\H\u0002J\t\u0010©\u0001\u001a\u00020\\H\u0002J\t\u0010ª\u0001\u001a\u00020\\H\u0002J\t\u0010«\u0001\u001a\u00020\\H\u0002J\t\u0010¬\u0001\u001a\u00020\\H\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020\\2\u0007\u0010®\u0001\u001a\u00020\u000eH\u0002J\t\u0010¯\u0001\u001a\u00020\\H\u0002J\t\u0010°\u0001\u001a\u00020\\H\u0002J\u000f\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0012\u0010²\u0001\u001a\u00020\r2\u0007\u0010³\u0001\u001a\u00020\u001aH\u0002J\u0012\u0010´\u0001\u001a\u00020\\2\u0007\u0010³\u0001\u001a\u00020\u001aH\u0002J\t\u0010µ\u0001\u001a\u00020\\H\u0002J\u0012\u0010¶\u0001\u001a\u00020\\2\u0007\u0010³\u0001\u001a\u00020\u001aH\u0002J\u0010\u0010·\u0001\u001a\u00020\\2\u0007\u0010¸\u0001\u001a\u00020&J\u0012\u0010¹\u0001\u001a\u00020\\2\u0007\u0010º\u0001\u001a\u00020\u001aH\u0002J\t\u0010»\u0001\u001a\u00020\\H\u0002J\t\u0010¼\u0001\u001a\u00020\u001aH\u0002J\t\u0010½\u0001\u001a\u00020\\H\u0002J\u0012\u0010¾\u0001\u001a\u00020\\2\u0007\u0010¸\u0001\u001a\u00020&H\u0002J\t\u0010¿\u0001\u001a\u00020\\H\u0014J\t\u0010À\u0001\u001a\u00020\\H\u0014J\t\u0010Á\u0001\u001a\u00020\\H\u0014J\u0012\u0010Â\u0001\u001a\u00020\u001a2\u0007\u0010Ã\u0001\u001a\u00020\u001aH\u0002J\t\u0010Ä\u0001\u001a\u00020&H\u0002J\u0012\u0010Å\u0001\u001a\u00020\r2\u0007\u0010Æ\u0001\u001a\u00020\rH\u0002J\t\u0010Ç\u0001\u001a\u00020\\H\u0002J\t\u0010È\u0001\u001a\u00020\\H\u0002J\u0012\u0010É\u0001\u001a\u00020&2\u0007\u0010Ê\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010Ë\u0001\u001a\u00020\u000e2\u0007\u0010Ì\u0001\u001a\u00020\u000eH\u0002J\t\u0010Í\u0001\u001a\u00020\\H\u0002J\t\u0010Î\u0001\u001a\u00020\\H\u0002J\t\u0010Ï\u0001\u001a\u00020\\H\u0002J\t\u0010Ð\u0001\u001a\u00020\\H\u0002J\t\u0010Ñ\u0001\u001a\u00020&H\u0002J\u000f\u0010Ò\u0001\u001a\u00020&2\u0006\u0010k\u001a\u00020\nJ\t\u0010Ó\u0001\u001a\u00020&H\u0002J\t\u0010Ô\u0001\u001a\u00020&H\u0002J\t\u0010Õ\u0001\u001a\u00020\\H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e02X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\r08X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020:02X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001a02X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000¨\u0006×\u0001"}, d2 = {"Lcom/appnew/android/testmodulessc/TestBaseActivitySSCPattern;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityTestBaseSscpatternBinding;", "gson", "Lcom/google/gson/Gson;", "allQuestions", "", "Lcom/appnew/android/testmodulessc/models/SSCQuestion;", "sectionStartIndex", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "sections", "", "Lcom/appnew/android/testmodulessc/models/SSCTestSection;", "getSections", "()Ljava/util/List;", "sections$delegate", "Lkotlin/Lazy;", "testTimer", "Landroid/os/CountDownTimer;", "totalTestMillis", "", "questionAdapter", "Lcom/appnew/android/testmodulessc/adapters/SSCQuestionViewPagerAdapter;", "sectionTabAdapter", "Lcom/appnew/android/testmodulessc/adapters/SSCSectionTabAdapter;", "sectionPartAdapter", "Lcom/appnew/android/testmodulessc/adapters/SSCSectionPartAdapter;", "numBoxAdapter", "Lcom/appnew/android/testmodulessc/adapters/SSCNumBoxAdapter;", "testSeriesBase", "Lcom/appnew/android/testmodule/model/TestseriesBase;", "isAutoSubmitted", "", "isSubmitDialogShowing", "currentQuestionIndex", "questionTimer", "Lcom/appnew/android/testmodulessc/utils/PerQuestionTimerManager;", "isProgrammaticPageChange", "currentLangId", "selectedLang", "isSubmitting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "testSeriesId", "answerMap", "", "Lcom/appnew/android/testmodule/model/Question;", "isLanguageSwitching", "lastQuestionIndex", "sectionLastQuestionMap", "locallyReportedQuestionIds", "", "pendingReports", "Lcom/appnew/android/testmodulessc/models/SSCPendingReport;", "isReportDisabled", "attemptKey", "firstAttempt", "attemptOrReAttempt", "showLeader", "submitDialog", "Landroid/app/Dialog;", "resultRetryCount", "isResultOpened", "resultDate", "courseId", "userId", "isPracticeTest", "lastTickMillis", "isTimeUpHandled", "isExpiredByEndDate", "endDateMillis", "elapsedStartRealtime", "elapsedAllowedDuration", "sectionStartElapsedRealtime", "sectionDurationMap", "lastSectionIndex", "isSectionTimerInitialized", "isSubmissionCompleted", "submissionTriggeredWhileSleep", "sectionSwitchAllowed", "isUserNavigating", "feedbackDispatched", "cachedSectionIndex", "cachedSectionIndexForQuestion", "isSubmitDispatched", "tagSSC", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupInsets", "setupBackPress", "initViews", "onClick", "closeDrawerThen", "action", "Lkotlin/Function0;", "showInstructionDialog", "showSymbolDialog", "updateSelectedSectionNameByIndex", FirebaseAnalytics.Param.INDEX, "saveAnswer", XHTMLText.Q, "notifyFeedbackListenerIfNeeded", "submitTest", "isAuto", "shouldSubmitViaS3", "submitViaS3", "uploadToS3", "file", "Ljava/io/File;", "observeS3Worker", "workId", "Ljava/util/UUID;", "onS3UploadSuccess", "getS3JsonUrl", "submitTestSeriesLater", "s3Url", "openSubmissionScreen", "patchQuestionDumpForS3", "originalDump", "submitViaNormalApi", "fetchTestResultAndOpenScreen", "retryOrFail", "reason", "openResultScreen", "buildSubmissionJson", "dumpList", "Ljava/util/ArrayList;", "Lcom/appnew/android/testmodule/model/QuestionDump;", "generateResultDate", "buildQuestionDumpList", "resolveFibAnswer", "userInputs", "rawRule", "getCurrentSectionIndex", "toggleLanguage", "applyLanguage", "langId", "rebuildQuestions", "source", "updateLanguageUI", "isHindiAvailable", "isEnglishAvailable", "initLanguage", "updateLanguageToggleVisibility", "initTestSeriesBase", "loadQuestions", "buildOptionsFromQuestion", "Lcom/appnew/android/testmodulessc/models/SSCTestOption;", "buildFIBOptions", "setupViewPager", "updateMarkReviewButton", Const.QUESTION, "showPopupErrorTest", "questionReportOptions", "Lcom/appnew/android/testmodule/model/QuesReportOption;", "sendPendingReports", "saveReportLocally", "error", "feedbackMsg", "dialog", "restoreAttemptState", "resetReportStateForAttempt", "setupDrawerSections", "setupQuestionGrid", "setupSectionTabs", "setupBottomButtons", "updateBottomButtons", Constants.INAPP_POSITION, "setupTestName", "updateAttemptCount", "getSSCSections", "formatTime", "ms", "updateTimeLeftText", "setupTestTimer", "updateAllTimers", "forceAutoSubmit", "expiredByEndDate", "syncServerTime", "serverEpochSeconds", "syncServerTimeFromTestJson", "getTrustedNowMillis", "showSubmitDialog", "showTimeOutDialog", "onDestroy", "onPause", "onResume", "getRemainingSectionMillis", "globalRemaining", "hasDeferredResult", "formatResultDate", "epochSeconds", "showResultDeferredSnackAndFinish", "sectionSwitchAllowedFlag", "canNavigateTo", "targetQuestionIndex", "getSectionIndexForQuestion", "questionIndex", "handleSectionTimeExpirySafely", "moveToNextSection", "restoreCurrentSectionSelection", "sectionForceSwitchDialog", "isSectionTimeOver", "canAttemptQuestionInSection", "shouldOpenSubmissionScreen", "shouldShowSubmitLoaderText", "updateSectionSwitchButtonVisibility", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TestBaseActivitySSCPattern extends AppCompatActivity {
    private static OnDataSendListener dataSendListener;
    private String attemptKey;
    private String attemptOrReAttempt;
    private ActivityTestBaseSscpatternBinding binding;
    private int cachedSectionIndex;
    private int cachedSectionIndexForQuestion;
    private final String courseId;
    private int currentQuestionIndex;
    private long elapsedAllowedDuration;
    private long elapsedStartRealtime;
    private long endDateMillis;
    private boolean feedbackDispatched;
    private String firstAttempt;
    private boolean isAutoSubmitted;
    private boolean isExpiredByEndDate;
    private boolean isLanguageSwitching;
    private boolean isPracticeTest;
    private boolean isProgrammaticPageChange;
    private boolean isReportDisabled;
    private boolean isResultOpened;
    private boolean isSectionTimerInitialized;
    private boolean isSubmissionCompleted;
    private boolean isSubmitDialogShowing;
    private final AtomicBoolean isSubmitDispatched;
    private boolean isTimeUpHandled;
    private boolean isUserNavigating;
    private int lastSectionIndex;
    private long lastTickMillis;
    private SSCNumBoxAdapter numBoxAdapter;
    private SSCQuestionViewPagerAdapter questionAdapter;
    private int resultRetryCount;
    private final Map<String, Long> sectionDurationMap;
    private SSCSectionPartAdapter sectionPartAdapter;
    private long sectionStartElapsedRealtime;
    private boolean sectionSwitchAllowed;
    private SSCSectionTabAdapter sectionTabAdapter;
    private String showLeader;
    private boolean submissionTriggeredWhileSleep;
    private Dialog submitDialog;
    private final String tagSSC;
    private TestseriesBase testSeriesBase;
    private CountDownTimer testTimer;
    private long totalTestMillis;
    private final String userId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final Gson gson = new Gson();
    private final List<SSCQuestion> allQuestions = new ArrayList();
    private final LinkedHashMap<String, Integer> sectionStartIndex = new LinkedHashMap<>();

    /* JADX INFO: renamed from: sections$delegate, reason: from kotlin metadata */
    private final Lazy sections = LazyKt.lazy(new Function0() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda39
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f$0.getSSCSections();
        }
    });
    private final PerQuestionTimerManager questionTimer = new PerQuestionTimerManager();
    private int currentLangId = 1;
    private int selectedLang = 1;
    private AtomicBoolean isSubmitting = new AtomicBoolean(false);
    private String testSeriesId = "";
    private final Map<String, Question> answerMap = new LinkedHashMap();
    private int lastQuestionIndex = -1;
    private final Map<String, Integer> sectionLastQuestionMap = new LinkedHashMap();
    private final Set<String> locallyReportedQuestionIds = new LinkedHashSet();
    private final Map<String, SSCPendingReport> pendingReports = new LinkedHashMap();
    private String resultDate = "";

    @JvmStatic
    public static final void setOnDataSendListener(OnDataSendListener onDataSendListener) {
        INSTANCE.setOnDataSendListener(onDataSendListener);
    }

    public TestBaseActivitySSCPattern() {
        String id;
        String str = "";
        String string = SharedPreference.getInstance().getString("id");
        this.courseId = string == null ? "" : string;
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        if (loggedInUser != null && (id = loggedInUser.getId()) != null) {
            str = id;
        }
        this.userId = str;
        this.isPracticeTest = true;
        this.sectionDurationMap = new LinkedHashMap();
        this.lastSectionIndex = -1;
        this.sectionSwitchAllowed = true;
        this.cachedSectionIndex = -1;
        this.cachedSectionIndexForQuestion = -1;
        this.isSubmitDispatched = new AtomicBoolean(false);
        this.tagSSC = "SSC_SUBMIT";
    }

    public static final /* synthetic */ void access$sendPendingReports(TestBaseActivitySSCPattern testBaseActivitySSCPattern) {
        testBaseActivitySSCPattern.sendPendingReports();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SSCTestSection> getSections() {
        return (List) this.sections.getValue();
    }

    /* JADX INFO: compiled from: TestBaseActivitySSCPattern.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/appnew/android/testmodulessc/TestBaseActivitySSCPattern$Companion;", "", "<init>", "()V", "dataSendListener", "Lcom/appnew/android/LiveClass/interface_/OnDataSendListener;", "getDataSendListener$annotations", "setOnDataSendListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void getDataSendListener$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final void setOnDataSendListener(OnDataSendListener listener) {
            TestBaseActivitySSCPattern.dataSendListener = listener;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws JSONException {
        super.onCreate(savedInstanceState);
        SSCSectionPartAdapter sSCSectionPartAdapter = null;
        EdgeToEdge.enable$default(this, null, null, 3, null);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBindingInflate = ActivityTestBaseSscpatternBinding.inflate(getLayoutInflater());
        this.binding = activityTestBaseSscpatternBindingInflate;
        if (activityTestBaseSscpatternBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBindingInflate = null;
        }
        setContentView(activityTestBaseSscpatternBindingInflate.getRoot());
        Helper.enableScreenShot(this);
        setupInsets();
        initTestSeriesBase();
        initViews();
        sectionSwitchAllowedFlag();
        updateLanguageToggleVisibility();
        initLanguage();
        syncServerTimeFromTestJson();
        restoreAttemptState();
        resetReportStateForAttempt();
        setupDrawerSections();
        setupQuestionGrid();
        setupSectionTabs();
        setupViewPager();
        loadQuestions();
        if (!getSections().isEmpty()) {
            SSCSectionPartAdapter sSCSectionPartAdapter2 = this.sectionPartAdapter;
            if (sSCSectionPartAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionPartAdapter");
            } else {
                sSCSectionPartAdapter = sSCSectionPartAdapter2;
            }
            sSCSectionPartAdapter.setSelectedIndex(0);
            updateSelectedSectionNameByIndex(0);
        }
        updateLanguageUI();
        if (!this.allQuestions.isEmpty()) {
            updateMarkReviewButton(this.allQuestions.get(0));
        }
        setupTestName();
        setupTestTimer();
        setupBottomButtons();
        updateAttemptCount();
        onClick();
        setupBackPress();
    }

    private final void setupInsets() {
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(activityTestBaseSscpatternBinding.mainContent, new OnApplyWindowInsetsListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda8
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return TestBaseActivitySSCPattern.setupInsets$lambda$1(view, windowInsetsCompat);
            }
        });
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding3;
        }
        ViewCompat.setOnApplyWindowInsetsListener(activityTestBaseSscpatternBinding2.navDrawerContainer, new OnApplyWindowInsetsListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda9
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return TestBaseActivitySSCPattern.setupInsets$lambda$2(view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setupInsets$lambda$1(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setupInsets$lambda$2(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(0, insets2.top, 0, insets2.bottom);
        return insets;
    }

    private final void setupBackPress() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern.setupBackPress.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = TestBaseActivitySSCPattern.this.binding;
                ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
                if (activityTestBaseSscpatternBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityTestBaseSscpatternBinding = null;
                }
                if (activityTestBaseSscpatternBinding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = TestBaseActivitySSCPattern.this.binding;
                    if (activityTestBaseSscpatternBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding3;
                    }
                    activityTestBaseSscpatternBinding2.drawerLayout.closeDrawer(GravityCompat.END);
                    return;
                }
                TestBaseActivitySSCPattern.this.showSubmitDialog();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void initViews() {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern.initViews():void");
    }

    private final void onClick() {
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.includeToolbar.iconMenu.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.onClick$lambda$9(this.f$0, view);
            }
        });
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding3 = null;
        }
        activityTestBaseSscpatternBinding3.includeToolbar.changeLanguage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggleLanguage();
            }
        });
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = this.binding;
        if (activityTestBaseSscpatternBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding4;
        }
        SscPatternDrawerLayoutBinding sscPatternDrawerLayoutBinding = activityTestBaseSscpatternBinding2.includeDrawerContent;
        sscPatternDrawerLayoutBinding.symbolText.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.onClick$lambda$18$lambda$12(this.f$0, view);
            }
        });
        sscPatternDrawerLayoutBinding.instructionText.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.onClick$lambda$18$lambda$14(this.f$0, view);
            }
        });
        sscPatternDrawerLayoutBinding.btnSubmitTest.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showSubmitDialog();
            }
        });
        updateSectionSwitchButtonVisibility();
        sscPatternDrawerLayoutBinding.btnSectionSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.onClick$lambda$18$lambda$17(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$9(TestBaseActivitySSCPattern testBaseActivitySSCPattern, View view) {
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.drawerLayout.openDrawer(GravityCompat.END);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$18$lambda$12(final TestBaseActivitySSCPattern testBaseActivitySSCPattern, View view) {
        testBaseActivitySSCPattern.closeDrawerThen(new Function0() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TestBaseActivitySSCPattern.onClick$lambda$18$lambda$12$lambda$11(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$18$lambda$12$lambda$11(TestBaseActivitySSCPattern testBaseActivitySSCPattern) {
        testBaseActivitySSCPattern.showSymbolDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$18$lambda$14(final TestBaseActivitySSCPattern testBaseActivitySSCPattern, View view) {
        testBaseActivitySSCPattern.closeDrawerThen(new Function0() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TestBaseActivitySSCPattern.onClick$lambda$18$lambda$14$lambda$13(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$18$lambda$14$lambda$13(TestBaseActivitySSCPattern testBaseActivitySSCPattern) throws JSONException {
        testBaseActivitySSCPattern.showInstructionDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$18$lambda$17(final TestBaseActivitySSCPattern testBaseActivitySSCPattern, View view) {
        testBaseActivitySSCPattern.closeDrawerThen(new Function0() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TestBaseActivitySSCPattern.onClick$lambda$18$lambda$17$lambda$16(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$18$lambda$17$lambda$16(TestBaseActivitySSCPattern testBaseActivitySSCPattern) {
        testBaseActivitySSCPattern.sectionForceSwitchDialog();
        return Unit.INSTANCE;
    }

    private final void closeDrawerThen(final Function0<Unit> action) {
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        if (activityTestBaseSscpatternBinding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
            if (activityTestBaseSscpatternBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTestBaseSscpatternBinding3 = null;
            }
            activityTestBaseSscpatternBinding3.drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern.closeDrawerThen.1
                @Override // androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
                public void onDrawerClosed(View drawerView) {
                    Intrinsics.checkNotNullParameter(drawerView, "drawerView");
                    ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = TestBaseActivitySSCPattern.this.binding;
                    if (activityTestBaseSscpatternBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityTestBaseSscpatternBinding4 = null;
                    }
                    activityTestBaseSscpatternBinding4.drawerLayout.removeDrawerListener(this);
                    action.invoke();
                }
            });
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = this.binding;
            if (activityTestBaseSscpatternBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding4;
            }
            activityTestBaseSscpatternBinding2.drawerLayout.closeDrawer(GravityCompat.END);
            return;
        }
        action.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0225  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void showInstructionDialog() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 637
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern.showInstructionDialog():void");
    }

    private static final boolean showInstructionDialog$isValidDesc(String str) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return false;
        }
        String lowerCase = StringsKt.trim((CharSequence) str2).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return !Intrinsics.areEqual(lowerCase, com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID);
    }

    private final void showSymbolDialog() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        SscSymbolsDialogBinding sscSymbolsDialogBindingInflate = SscSymbolsDialogBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(sscSymbolsDialogBindingInflate, "inflate(...)");
        final Dialog dialog = new Dialog(this, R.style.BottomSheetDialogStyle);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(sscSymbolsDialogBindingInflate.getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawableResource(android.R.color.white);
        }
        sscSymbolsDialogBindingInflate.btnBackToTest.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectedSectionNameByIndex(int index) {
        if (index < 0 || index >= getSections().size()) {
            return;
        }
        String name = getSections().get(index).getName();
        if (name == null) {
            name = "";
        }
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.includeDrawerContent.selectedSectionName.setText(name);
    }

    private final void saveAnswer(Question q) {
        String configId = q.getConfigId();
        if (configId == null) {
            return;
        }
        this.answerMap.put(configId, q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyFeedbackListenerIfNeeded() {
        OnDataSendListener onDataSendListener = dataSendListener;
        if (onDataSendListener != null && Intrinsics.areEqual(SharedPreference.getInstance().getString(Const.LIVE_TEST_FEEDBACK), "1")) {
            String str = this.attemptOrReAttempt;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("attemptOrReAttempt");
                str = null;
            }
            if (StringsKt.equals(str, Const.ATTEMPT, true) && !this.feedbackDispatched) {
                this.feedbackDispatched = true;
                String str2 = this.testSeriesId;
                String str3 = this.attemptOrReAttempt;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("attemptOrReAttempt");
                    str3 = null;
                }
                onDataSendListener.onDataSent(0L, str2, str3, 2);
            }
        }
    }

    private final void submitTest(boolean isAuto) {
        if (!this.isSubmitting.compareAndSet(false, true)) {
            Log.w(this.tagSSC, "Submit already in progress");
            return;
        }
        this.isReportDisabled = true;
        boolean zShouldSubmitViaS3 = shouldSubmitViaS3();
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.submitLoader.setVisibility(0);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding3 = null;
        }
        activityTestBaseSscpatternBinding3.progressBarSubmit.setVisibility(0);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = this.binding;
        if (activityTestBaseSscpatternBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding4;
        }
        activityTestBaseSscpatternBinding2.submitLoaderText.setVisibility(shouldShowSubmitLoaderText() ? 0 : 8);
        CountDownTimer countDownTimer = this.testTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.questionTimer.stop();
        if (zShouldSubmitViaS3) {
            submitViaS3(isAuto);
        } else {
            submitViaNormalApi(isAuto);
        }
    }

    private final boolean shouldSubmitViaS3() {
        String string = SharedPreference.getInstance().getString(Const.TEST_SUBMIT_S3);
        return string != null && StringsKt.equals(string, "1", true);
    }

    private final void submitViaS3(boolean isAuto) {
        try {
            JSONObject jSONObject = new JSONObject(buildSubmissionJson(buildQuestionDumpList()));
            String string = jSONObject.getString("question_dump");
            Intrinsics.checkNotNull(string);
            jSONObject.put("question_dump", patchQuestionDumpForS3(string));
            String string2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            Object objFromJson = new Gson().fromJson(string2, new TypeToken<HashMap<String, String>>() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$submitViaS3$bodyMap$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            HashMap<String, String> map = (HashMap) objFromJson;
            String str = map.get("question_dump");
            if (str == null || !StringsKt.contains$default((CharSequence) str, (CharSequence) "\"answers\"", false, 2, (Object) null)) {
                throw new IllegalArgumentException("S3 BLOCKED: answers[] missing in question_dump".toString());
            }
            HashMap<String, String> map2 = new HashMap<>();
            map2.put(Const.DEVICE_TYPE, "1");
            map2.put(Const.USERID, this.userId);
            String string3 = SharedPreference.getInstance().getString(Const.JWT);
            if (string3 == null) {
                string3 = "";
            }
            map2.put(Const.Jwt, string3);
            map2.put(Const.LANG, String.valueOf(this.currentLangId));
            map2.put("Authorization", API.Bearer);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setHeader(map2);
            encryptionData.setBody(map);
            File file = new File(getCacheDir(), "U" + this.userId + "_T" + this.testSeriesId + "_C" + this.courseId + ".json");
            String json = new Gson().toJson(encryptionData);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            FilesKt.writeText$default(file, json, null, 2, null);
            uploadToS3(file);
        } catch (Exception e2) {
            Log.e(this.tagSSC, "submitViaS3 FAILED → fallback", e2);
            this.isSubmitting.set(false);
            this.isSubmitDispatched.set(false);
            submitViaNormalApi(isAuto);
        }
    }

    private final void uploadToS3(File file) {
        if (this.isSubmitting.get()) {
            if (this.testSeriesId.length() == 0) {
                submitViaNormalApi(false);
                return;
            }
            OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) SSCS3UploadWorker.class);
            Pair[] pairArr = {TuplesKt.to("file_path", file.getAbsolutePath()), TuplesKt.to(Const.TESTSERIES_ID, this.testSeriesId), TuplesKt.to("user_id", this.userId)};
            Data.Builder builder2 = new Data.Builder();
            for (int i = 0; i < 3; i++) {
                Pair pair = pairArr[i];
                builder2.put((String) pair.getFirst(), pair.getSecond());
            }
            OneTimeWorkRequest oneTimeWorkRequestBuild = builder.setInputData(builder2.build()).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
            WorkManager.INSTANCE.getInstance(this).enqueue(oneTimeWorkRequestBuild);
            observeS3Worker(oneTimeWorkRequestBuild.getId());
        }
    }

    private final void observeS3Worker(final UUID workId) {
        final WorkManager companion = WorkManager.INSTANCE.getInstance(this);
        companion.getWorkInfoByIdLiveData(workId).observe(this, new Observer<WorkInfo>() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$observeS3Worker$observer$1

            /* JADX INFO: compiled from: TestBaseActivitySSCPattern.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[WorkInfo.State.values().length];
                    try {
                        iArr[WorkInfo.State.RUNNING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[WorkInfo.State.SUCCEEDED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[WorkInfo.State.FAILED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(WorkInfo value) {
                if (value == null) {
                    return;
                }
                int i = WhenMappings.$EnumSwitchMapping$0[value.getState().ordinal()];
                ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = null;
                if (i != 1) {
                    if (i == 2) {
                        companion.getWorkInfoByIdLiveData(workId).removeObserver(this);
                        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = this.this$0.binding;
                        if (activityTestBaseSscpatternBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding2;
                        }
                        activityTestBaseSscpatternBinding.submitLoaderText.setVisibility(8);
                        this.this$0.onS3UploadSuccess();
                        return;
                    }
                    if (i != 3) {
                        return;
                    }
                    companion.getWorkInfoByIdLiveData(workId).removeObserver(this);
                    this.this$0.isSubmitting.set(false);
                    ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.this$0.binding;
                    if (activityTestBaseSscpatternBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding3;
                    }
                    activityTestBaseSscpatternBinding.submitLoaderText.setVisibility(8);
                    Toast.makeText(this.this$0, "Upload failed. Retrying…", 0).show();
                    return;
                }
                int i2 = value.getProgress().getInt("progress", 0);
                ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = this.this$0.binding;
                if (activityTestBaseSscpatternBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityTestBaseSscpatternBinding4 = null;
                }
                activityTestBaseSscpatternBinding4.submitLoader.setVisibility(0);
                ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding5 = this.this$0.binding;
                if (activityTestBaseSscpatternBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityTestBaseSscpatternBinding5 = null;
                }
                activityTestBaseSscpatternBinding5.progressBarSubmit.setVisibility(0);
                if (this.this$0.shouldShowSubmitLoaderText()) {
                    ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding6 = this.this$0.binding;
                    if (activityTestBaseSscpatternBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityTestBaseSscpatternBinding6 = null;
                    }
                    activityTestBaseSscpatternBinding6.submitLoaderText.setVisibility(0);
                    ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding7 = this.this$0.binding;
                    if (activityTestBaseSscpatternBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding7;
                    }
                    activityTestBaseSscpatternBinding.submitLoaderText.setText(this.this$0.getString(R.string.uploading_progress, new Object[]{Integer.valueOf(i2)}));
                    return;
                }
                ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding8 = this.this$0.binding;
                if (activityTestBaseSscpatternBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding8;
                }
                activityTestBaseSscpatternBinding.submitLoaderText.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onS3UploadSuccess() {
        this.isSubmitting.set(false);
        submitTestSeriesLater(getS3JsonUrl(this.userId, this.testSeriesId, this.courseId));
    }

    private final String getS3JsonUrl(String userId, String testSeriesId, String courseId) {
        return API.API_AMAZON_S3_TEST_SUBMIT_SSC + testSeriesId + "/U" + userId + "_T" + testSeriesId + "_C" + courseId + ".json";
    }

    private final void submitTestSeriesLater(String s3Url) {
        APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUrl(s3Url);
        Call<String> callSubmitTestSeriesLater = aPIInterface.submitTestSeriesLater(AES.encrypt(new Gson().toJson(encryptionData)));
        if (callSubmitTestSeriesLater != null) {
            callSubmitTestSeriesLater.enqueue(new C06511());
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$submitTestSeriesLater$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TestBaseActivitySSCPattern.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J(\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/appnew/android/testmodulessc/TestBaseActivitySSCPattern$submitTestSeriesLater$1", "Lretrofit2/Callback;", "", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", SaslNonza.Response.ELEMENT, "Lretrofit2/Response;", "onFailure", "t", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06511 implements Callback<String> {
        C06511() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<String> call, Response<String> response) throws JSONException {
            String strBody;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful() && (strBody = response.body()) != null && !StringsKt.isBlank(strBody)) {
                TestBaseActivitySSCPattern.this.notifyFeedbackListenerIfNeeded();
                Handler handler = new Handler(Looper.getMainLooper());
                final TestBaseActivitySSCPattern testBaseActivitySSCPattern = TestBaseActivitySSCPattern.this;
                handler.postDelayed(new Runnable() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$submitTestSeriesLater$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TestBaseActivitySSCPattern.access$sendPendingReports(testBaseActivitySSCPattern);
                    }
                }, 400L);
                if (TestBaseActivitySSCPattern.this.hasDeferredResult()) {
                    TestBaseActivitySSCPattern.this.showResultDeferredSnackAndFinish();
                    return;
                } else if (TestBaseActivitySSCPattern.this.shouldOpenSubmissionScreen()) {
                    TestBaseActivitySSCPattern.this.openSubmissionScreen();
                    return;
                } else {
                    TestBaseActivitySSCPattern.this.fetchTestResultAndOpenScreen();
                    return;
                }
            }
            TestBaseActivitySSCPattern testBaseActivitySSCPattern2 = TestBaseActivitySSCPattern.this;
            Toast.makeText(testBaseActivitySSCPattern2, testBaseActivitySSCPattern2.getString(R.string.something_went_wrong), 1).show();
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<String> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            Log.e(TestBaseActivitySSCPattern.this.tagSSC, "submitTestSeriesLater FAILED", t);
            TestBaseActivitySSCPattern testBaseActivitySSCPattern = TestBaseActivitySSCPattern.this;
            Toast.makeText(testBaseActivitySSCPattern, testBaseActivitySSCPattern.getString(R.string.something_went_wrong), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSubmissionScreen() {
        String testSeriesName;
        com.appnew.android.testmodule.model.Data data;
        TestBasic testBasic;
        this.isSubmissionCompleted = true;
        com.appnew.android.home.Constants.REFRESHPAGE = "true";
        com.appnew.android.home.Constants.REFRESHPAGENEW = "true";
        SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, true);
        SharedPreference.getInstance().putBoolean(Const.IS_SUBMIT_TEST_S3, true);
        Intent intent = new Intent(this, (Class<?>) TestSubmissionActivity.class);
        intent.putExtra("result_date", this.resultDate);
        TestseriesBase testseriesBase = this.testSeriesBase;
        if (testseriesBase == null || (data = testseriesBase.getData()) == null || (testBasic = data.getTestBasic()) == null || (testSeriesName = testBasic.getTestSeriesName()) == null) {
            testSeriesName = "";
        }
        intent.putExtra(AnalyticsConstants.test_name, testSeriesName);
        Helper.gotoActivity_finish(intent, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String patchQuestionDumpForS3(java.lang.String r14) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern.patchQuestionDumpForS3(java.lang.String):java.lang.String");
    }

    private final void submitViaNormalApi(boolean isAuto) {
        Log.d(this.tagSSC, "submitViaNormalApi START | isAuto=" + isAuto);
        TestBaseActivitySSCPattern testBaseActivitySSCPattern = this;
        if (!Helper.isNetworkConnected(testBaseActivitySSCPattern)) {
            Toast.makeText(testBaseActivitySSCPattern, getString(R.string.Retry_with_Internet_connection), 1).show();
            this.isSubmitting.set(false);
            return;
        }
        Call<String> callSubmitTestSeries = ((APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class)).submitTestSeries(AES.encrypt(buildSubmissionJson(buildQuestionDumpList())));
        if (callSubmitTestSeries != null) {
            callSubmitTestSeries.enqueue(new C06521());
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$submitViaNormalApi$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TestBaseActivitySSCPattern.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J(\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/appnew/android/testmodulessc/TestBaseActivitySSCPattern$submitViaNormalApi$1", "Lretrofit2/Callback;", "", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", SaslNonza.Response.ELEMENT, "Lretrofit2/Response;", "onFailure", "t", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06521 implements Callback<String> {
        C06521() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<String> call, Response<String> response) throws JSONException {
            String strBody;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            TestBaseActivitySSCPattern.this.isSubmitting.set(false);
            if (!response.isSuccessful() || (strBody = response.body()) == null || StringsKt.isBlank(strBody)) {
                TestBaseActivitySSCPattern testBaseActivitySSCPattern = TestBaseActivitySSCPattern.this;
                Toast.makeText(testBaseActivitySSCPattern, testBaseActivitySSCPattern.getString(R.string.something_went_wrong), 1).show();
                return;
            }
            try {
                String strBody2 = response.body();
                Intrinsics.checkNotNull(strBody2);
                JSONObject jSONObject = new JSONObject(AES.decrypt(StringsKt.trim((CharSequence) strBody2).toString(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                if (jSONObject.optBoolean("status", false) || Intrinsics.areEqual(jSONObject.optString("status"), "1")) {
                    TestBaseActivitySSCPattern.this.notifyFeedbackListenerIfNeeded();
                    Handler handler = new Handler(Looper.getMainLooper());
                    final TestBaseActivitySSCPattern testBaseActivitySSCPattern2 = TestBaseActivitySSCPattern.this;
                    handler.postDelayed(new Runnable() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$submitViaNormalApi$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            TestBaseActivitySSCPattern.access$sendPendingReports(testBaseActivitySSCPattern2);
                        }
                    }, 400L);
                    if (TestBaseActivitySSCPattern.this.hasDeferredResult()) {
                        TestBaseActivitySSCPattern.this.showResultDeferredSnackAndFinish();
                        return;
                    } else {
                        TestBaseActivitySSCPattern.this.fetchTestResultAndOpenScreen();
                        return;
                    }
                }
                Toast.makeText(TestBaseActivitySSCPattern.this, jSONObject.optString("message", "Submission failed"), 1).show();
            } catch (Exception e2) {
                Log.e(TestBaseActivitySSCPattern.this.tagSSC, "DECRYPT FAILED", e2);
                TestBaseActivitySSCPattern testBaseActivitySSCPattern3 = TestBaseActivitySSCPattern.this;
                Toast.makeText(testBaseActivitySSCPattern3, testBaseActivitySSCPattern3.getString(R.string.something_went_wrong), 1).show();
            }
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<String> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            TestBaseActivitySSCPattern.this.isSubmitting.set(false);
            TestBaseActivitySSCPattern.this.isSubmitDispatched.set(false);
            Log.e(TestBaseActivitySSCPattern.this.tagSSC, "API CALL FAILED", t);
            TestBaseActivitySSCPattern testBaseActivitySSCPattern = TestBaseActivitySSCPattern.this;
            Toast.makeText(testBaseActivitySSCPattern, testBaseActivitySSCPattern.getString(R.string.something_went_wrong), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchTestResultAndOpenScreen() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("user_id", MakeMyExam.getUserId());
        jSONObject.put("test_id", this.testSeriesId);
        Call<String> testResult = ((APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class)).getTestResult(AES.encrypt(jSONObject.toString()));
        if (testResult != null) {
            testResult.enqueue(new Callback<String>() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern.fetchTestResultAndOpenScreen.1
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    String strBody;
                    String string;
                    JSONArray jSONArrayOptJSONArray;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (!response.isSuccessful() || (strBody = response.body()) == null || strBody.length() == 0) {
                        TestBaseActivitySSCPattern.this.retryOrFail("Empty result response");
                        return;
                    }
                    try {
                        String strBody2 = response.body();
                        Intrinsics.checkNotNull(strBody2);
                        String strDecrypt = AES.decrypt(StringsKt.trim((CharSequence) strBody2).toString(), AES.generatekeyAPI(), AES.generateVectorAPI());
                        try {
                            JSONObject jSONObject2 = new JSONObject(strDecrypt);
                            if (!jSONObject2.has("data") && !jSONObject2.has("questionBank")) {
                                TestBaseActivitySSCPattern.this.retryOrFail("Result not ready");
                                return;
                            }
                            MakeMyExam.object = strDecrypt;
                            JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("questionBank");
                            if (jSONArrayOptJSONArray2 == null || (string = jSONArrayOptJSONArray2.toString()) == null) {
                                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("data");
                                string = (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("questions")) == null) ? null : jSONArrayOptJSONArray.toString();
                                if (string == null) {
                                    string = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                                }
                            }
                            MakeMyExam.questionbanklist = string;
                            if (TestBaseActivitySSCPattern.this.isResultOpened) {
                                return;
                            }
                            TestBaseActivitySSCPattern.this.isResultOpened = true;
                            TestBaseActivitySSCPattern.this.openResultScreen();
                        } catch (Exception e2) {
                            Log.e(TestBaseActivitySSCPattern.this.tagSSC, "Invalid JSON", e2);
                            TestBaseActivitySSCPattern.this.retryOrFail("Invalid JSON");
                        }
                    } catch (Exception e3) {
                        Log.e(TestBaseActivitySSCPattern.this.tagSSC, "Decrypt failed", e3);
                        TestBaseActivitySSCPattern.this.retryOrFail("Decrypt error");
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Log.e(TestBaseActivitySSCPattern.this.tagSSC, "Result API failed", t);
                    TestBaseActivitySSCPattern.this.retryOrFail("API failure");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryOrFail(String reason) {
        int i = this.resultRetryCount;
        if (i < 1) {
            this.resultRetryCount = i + 1;
            Log.w(this.tagSSC, "Retrying result fetch… (" + reason + ")");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda44
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f$0.fetchTestResultAndOpenScreen();
                }
            }, 1000L);
        } else {
            Toast.makeText(this, "Result is being prepared. Please try again.", 0).show();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openResultScreen() {
        String testSeriesName;
        com.appnew.android.testmodule.model.Data data;
        TestBasic testBasic;
        this.isSubmissionCompleted = true;
        com.appnew.android.home.Constants.REFRESHPAGE = "true";
        com.appnew.android.home.Constants.REFRESHPAGENEW = "true";
        Intent intent = new Intent(this, (Class<?>) QuizActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
        intent.putExtra("status", this.testSeriesId);
        TestseriesBase testseriesBase = this.testSeriesBase;
        if (testseriesBase == null || (data = testseriesBase.getData()) == null || (testBasic = data.getTestBasic()) == null || (testSeriesName = testBasic.getTestSeriesName()) == null) {
            testSeriesName = "";
        }
        intent.putExtra("name", testSeriesName);
        String str = this.firstAttempt;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstAttempt");
            str = null;
        }
        intent.putExtra("first_attempt", str);
        String str3 = this.attemptOrReAttempt;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptOrReAttempt");
            str3 = null;
        }
        intent.putExtra("attemptOrReAttempt", str3);
        String str4 = this.showLeader;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showLeader");
        } else {
            str2 = str4;
        }
        if (Intrinsics.areEqual(str2, "0")) {
            intent.putExtra("show_leader", "0");
        }
        intent.putExtra(Const.TEST_SERIES_ID, this.testSeriesId);
        intent.putExtra(Const.LANG, this.currentLangId);
        Helper.gotoActivity_finish(intent, this);
    }

    private final String buildSubmissionJson(ArrayList<QuestionDump> dumpList) {
        String id;
        HashMap map = new HashMap();
        HashMap map2 = map;
        com.appnew.android.pojo.Userinfo.Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        if (loggedInUser == null || (id = loggedInUser.getId()) == null) {
            id = "";
        }
        map2.put("user_id", id);
        map2.put("test_id", this.testSeriesId);
        map2.put("course_id", this.courseId);
        map2.put("state", "1");
        String str = this.attemptOrReAttempt;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptOrReAttempt");
            str = null;
        }
        map2.put("first_attempt", StringsKt.equals(str, Const.ATTEMPT, true) ? "1" : "0");
        map2.put(Const.IS_PAUSED, "0");
        map2.put("lastSection", String.valueOf(getCurrentSectionIndex()));
        map2.put(Const.LAST_VIEW, String.valueOf(this.currentQuestionIndex));
        map2.put(Const.LANG_USED, String.valueOf(this.currentLangId));
        map2.put(Const.TIME_REMAIN, String.valueOf(this.totalTestMillis / ((long) 1000)));
        map2.put("result_date", generateResultDate());
        map2.put("test_pattern", "1");
        map2.put("question_dump", new Gson().toJson(dumpList));
        String json = new Gson().toJson(map);
        Intrinsics.checkNotNull(json);
        return json;
    }

    private final String generateResultDate() {
        return String.valueOf(System.currentTimeMillis() / ((long) 1000));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.ArrayList<com.appnew.android.testmodule.model.QuestionDump> buildQuestionDumpList() {
        /*
            Method dump skipped, instruction units count: 853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern.buildQuestionDumpList():java.util.ArrayList");
    }

    private final String resolveFibAnswer(List<String> userInputs, String rawRule) {
        String str = rawRule;
        if (str == null || StringsKt.isBlank(str)) {
            return CollectionsKt.joinToString$default(userInputs, Constants.SEPARATOR_COMMA, null, null, 0, null, new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TestBaseActivitySSCPattern.resolveFibAnswer$lambda$38((String) obj);
                }
            }, 30, null);
        }
        try {
            String strOptString = new JSONObject(rawRule).optString(Const.ANSWER);
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String string = StringsKt.trim((CharSequence) strOptString).toString();
            List listSplit$default = StringsKt.split$default((CharSequence) string, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            List listSplit$default2 = StringsKt.split$default((CharSequence) StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(CollectionsKt.joinToString$default(userInputs, Constants.SEPARATOR_COMMA, null, null, 0, null, null, 62, null), MqttTopic.TOPIC_LEVEL_SEPARATOR, Constants.SEPARATOR_COMMA, false, 4, (Object) null), "|", Constants.SEPARATOR_COMMA, false, 4, (Object) null), ";", Constants.SEPARATOR_COMMA, false, 4, (Object) null), "\n", Constants.SEPARATOR_COMMA, false, 4, (Object) null), new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null);
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default2, 10));
            Iterator it2 = listSplit$default2.iterator();
            while (it2.hasNext()) {
                arrayList4.add(StringsKt.trim((CharSequence) it2.next()).toString());
            }
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : arrayList4) {
                if (((String) obj2).length() > 0) {
                    arrayList5.add(obj2);
                }
            }
            ArrayList arrayList6 = arrayList5;
            if (arrayList3.size() != arrayList6.size()) {
                return CollectionsKt.joinToString$default(arrayList6, Constants.SEPARATOR_COMMA, null, null, 0, null, null, 62, null);
            }
            List<Pair> listZip = CollectionsKt.zip(arrayList3, arrayList6);
            if ((listZip instanceof Collection) && listZip.isEmpty()) {
                return string;
            }
            for (Pair pair : listZip) {
                if (!StringsKt.equals((String) pair.component1(), (String) pair.component2(), true)) {
                    return CollectionsKt.joinToString$default(arrayList6, Constants.SEPARATOR_COMMA, null, null, 0, null, null, 62, null);
                }
            }
            return string;
        } catch (Exception e2) {
            Log.e(this.tagSSC, "resolveFibAnswer FAILED", e2);
            return CollectionsKt.joinToString$default(userInputs, Constants.SEPARATOR_COMMA, null, null, 0, null, new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return TestBaseActivitySSCPattern.resolveFibAnswer$lambda$44((String) obj3);
                }
            }, 30, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence resolveFibAnswer$lambda$38(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.trim((CharSequence) it).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence resolveFibAnswer$lambda$44(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.trim((CharSequence) it).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentSectionIndex() {
        if (this.cachedSectionIndexForQuestion == this.currentQuestionIndex) {
            return this.cachedSectionIndex;
        }
        int i = 0;
        int i2 = 0;
        for (Object obj : getSections()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Integer num = this.sectionStartIndex.get(((SSCTestSection) obj).getId());
            if (num != null && num.intValue() <= this.currentQuestionIndex) {
                i = i2;
            }
            i2 = i3;
        }
        this.cachedSectionIndex = i;
        this.cachedSectionIndexForQuestion = this.currentQuestionIndex;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleLanguage() {
        this.isLanguageSwitching = true;
        this.currentLangId = this.currentLangId == 1 ? 2 : 1;
        SharedPreference.getInstance().putInt(Const.PREF_LANG_ID, this.currentLangId);
        applyLanguage(this.currentLangId);
        updateLanguageUI();
    }

    private final void applyLanguage(int langId) {
        com.appnew.android.testmodule.model.Data data;
        List<Question> questions;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding;
        Object next;
        String option1;
        TestseriesBase testseriesBase = this.testSeriesBase;
        if (testseriesBase == null || (data = testseriesBase.getData()) == null) {
            return;
        }
        if (langId == 2) {
            questions = data.getQuestionsHindi();
        } else {
            questions = data.getQuestions();
        }
        List<Question> list = questions;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<T> it = this.allQuestions.iterator();
        int i = 0;
        while (true) {
            activityTestBaseSscpatternBinding = null;
            SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = null;
            if (!it.hasNext()) {
                break;
            }
            Object next2 = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SSCQuestion sSCQuestion = (SSCQuestion) next2;
            String configId = sSCQuestion.getOriginal().getConfigId();
            if (configId != null) {
                Iterator<T> it2 = questions.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (Intrinsics.areEqual(((Question) next).getConfigId(), configId)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                Question question = (Question) next;
                if (question != null) {
                    String question2 = question.getQuestion();
                    if (question2 == null) {
                        question2 = sSCQuestion.getQuestionHtml();
                    }
                    sSCQuestion.setQuestionHtml(question2);
                    int i3 = 0;
                    for (Object obj : sSCQuestion.getOptions()) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        SSCTestOption sSCTestOption = (SSCTestOption) obj;
                        if (i3 == 0) {
                            option1 = question.getOption1();
                            Intrinsics.checkNotNullExpressionValue(option1, "getOption1(...)");
                        } else if (i3 == 1) {
                            option1 = question.getOption2();
                            Intrinsics.checkNotNullExpressionValue(option1, "getOption2(...)");
                        } else if (i3 == 2) {
                            option1 = question.getOption3();
                            Intrinsics.checkNotNullExpressionValue(option1, "getOption3(...)");
                        } else if (i3 == 3) {
                            option1 = question.getOption4();
                            Intrinsics.checkNotNullExpressionValue(option1, "getOption4(...)");
                        } else if (i3 == 4) {
                            option1 = question.getOption5();
                            Intrinsics.checkNotNullExpressionValue(option1, "getOption5(...)");
                        } else if (i3 == 5) {
                            option1 = question.getOption6();
                            Intrinsics.checkNotNullExpressionValue(option1, "getOption6(...)");
                        } else {
                            option1 = sSCTestOption.getText();
                        }
                        sSCTestOption.setText(option1);
                        i3 = i4;
                    }
                    SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter2 = this.questionAdapter;
                    if (sSCQuestionViewPagerAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
                    } else {
                        sSCQuestionViewPagerAdapter = sSCQuestionViewPagerAdapter2;
                    }
                    sSCQuestionViewPagerAdapter.notifyItemChanged(i, SSCQuestionViewPagerAdapterKt.PAYLOAD_LANGUAGE);
                }
            }
            i = i2;
        }
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = this.binding;
        if (activityTestBaseSscpatternBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding2;
        }
        activityTestBaseSscpatternBinding.viewPagerQuestions.post(new Runnable() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                TestBaseActivitySSCPattern.applyLanguage$lambda$49(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyLanguage$lambda$49(TestBaseActivitySSCPattern testBaseActivitySSCPattern) {
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.viewPagerQuestions.setCurrentItem(testBaseActivitySSCPattern.currentQuestionIndex, false);
        testBaseActivitySSCPattern.isLanguageSwitching = false;
    }

    private final void rebuildQuestions(List<? extends Question> source) {
        List<SSCTestOption> listBuildOptionsFromQuestion;
        String answer;
        this.allQuestions.clear();
        this.sectionStartIndex.clear();
        int i = 0;
        for (Question question : source) {
            int i2 = i + 1;
            if (!this.sectionStartIndex.containsKey(question.getSectionId())) {
                LinkedHashMap<String, Integer> linkedHashMap = this.sectionStartIndex;
                String sectionId = question.getSectionId();
                if (sectionId == null) {
                    sectionId = "";
                }
                linkedHashMap.put(sectionId, Integer.valueOf(i));
            }
            boolean z = StringsKt.equals(question.getQuestionType(), "PG", true) && (answer = question.getAnswer()) != null && StringsKt.contains$default((CharSequence) answer, (CharSequence) Constants.SEPARATOR_COMMA, false, 2, (Object) null);
            if (StringsKt.equals(question.getQuestionType(), "FIB", true)) {
                listBuildOptionsFromQuestion = buildFIBOptions(question);
            } else {
                listBuildOptionsFromQuestion = buildOptionsFromQuestion(question);
            }
            List<SSCTestOption> list = listBuildOptionsFromQuestion;
            String id = question.getId();
            if (id == null) {
                id = "";
            }
            String sectionId2 = question.getSectionId();
            if (sectionId2 == null) {
                sectionId2 = "";
            }
            String subjectId = question.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            String sectionName = question.getSectionName();
            if (sectionName == null) {
                sectionName = "";
            }
            String question2 = question.getQuestion();
            if (question2 == null) {
                question2 = "";
            }
            String questionType = question.getQuestionType();
            if (questionType == null) {
                questionType = "SC";
            }
            String str = questionType;
            String font_type = question.getFont_type();
            if (font_type == null) {
                font_type = "0";
            }
            this.allQuestions.add(new SSCQuestion(id, sectionId2, subjectId, sectionName, question2, str, font_type, list, question.getParagraphText(), question.getPosMarks(), question.getNegMarks(), z, question.getSection_question_behaviour(), question));
            i = i2;
        }
    }

    private final void updateLanguageUI() {
        boolean zIsHindiAvailable = isHindiAvailable();
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        ImageView imageView = activityTestBaseSscpatternBinding.includeToolbar.changeLanguage;
        imageView.setEnabled(zIsHindiAvailable);
        imageView.setAlpha(zIsHindiAvailable ? 1.0f : 0.5f);
    }

    private final boolean isHindiAvailable() {
        com.appnew.android.testmodule.model.Data data;
        TestseriesBase testseriesBase = this.testSeriesBase;
        List<Question> questionsHindi = (testseriesBase == null || (data = testseriesBase.getData()) == null) ? null : data.getQuestionsHindi();
        return !(questionsHindi == null || questionsHindi.isEmpty());
    }

    private final boolean isEnglishAvailable() {
        com.appnew.android.testmodule.model.Data data;
        TestseriesBase testseriesBase = this.testSeriesBase;
        List<Question> questions = (testseriesBase == null || (data = testseriesBase.getData()) == null) ? null : data.getQuestions();
        return !(questions == null || questions.isEmpty());
    }

    private final void initLanguage() {
        this.currentLangId = (this.selectedLang == 2 && isHindiAvailable()) ? 2 : 1;
    }

    private final void updateLanguageToggleVisibility() {
        boolean zIsHindiAvailable = isHindiAvailable();
        boolean zIsEnglishAvailable = isEnglishAvailable();
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.includeToolbar.changeLanguage.setVisibility((zIsHindiAvailable && zIsEnglishAvailable) ? 0 : 8);
    }

    private final void initTestSeriesBase() {
        String id;
        com.appnew.android.testmodule.model.Data data;
        TestBasic testBasic;
        String string = SharedPreference.getInstance().getString("test_series");
        if (string == null) {
            return;
        }
        TestseriesBase testseriesBase = (TestseriesBase) this.gson.fromJson(string, TestseriesBase.class);
        this.testSeriesBase = testseriesBase;
        if (testseriesBase == null || (data = testseriesBase.getData()) == null || (testBasic = data.getTestBasic()) == null || (id = testBasic.getId()) == null) {
            id = "";
        }
        this.testSeriesId = id;
    }

    private final void loadQuestions() {
        com.appnew.android.testmodule.model.Data data;
        List<Question> questions;
        TestseriesBase testseriesBase = this.testSeriesBase;
        if (testseriesBase == null || (data = testseriesBase.getData()) == null) {
            return;
        }
        if (this.currentLangId == 2) {
            questions = data.getQuestionsHindi();
        } else {
            questions = data.getQuestions();
        }
        List<Question> list = questions;
        if (list == null || list.isEmpty() || !this.allQuestions.isEmpty()) {
            return;
        }
        rebuildQuestions(questions);
        int size = this.allQuestions.size();
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = this.questionAdapter;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = null;
        if (sSCQuestionViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
            sSCQuestionViewPagerAdapter = null;
        }
        sSCQuestionViewPagerAdapter.notifyItemChanged(0, Integer.valueOf(size));
        SSCNumBoxAdapter sSCNumBoxAdapter = this.numBoxAdapter;
        if (sSCNumBoxAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
            sSCNumBoxAdapter = null;
        }
        sSCNumBoxAdapter.notifyItemChanged(0, Integer.valueOf(size));
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = this.binding;
        if (activityTestBaseSscpatternBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding2;
        }
        activityTestBaseSscpatternBinding.viewPagerQuestions.post(new Runnable() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                TestBaseActivitySSCPattern.loadQuestions$lambda$52(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadQuestions$lambda$52(final TestBaseActivitySSCPattern testBaseActivitySSCPattern) {
        testBaseActivitySSCPattern.currentQuestionIndex = 0;
        testBaseActivitySSCPattern.lastQuestionIndex = 0;
        final Question original = testBaseActivitySSCPattern.allQuestions.get(0).getOriginal();
        testBaseActivitySSCPattern.questionTimer.start(original.getTotalTimeSpent(), new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TestBaseActivitySSCPattern.loadQuestions$lambda$52$lambda$51(original, testBaseActivitySSCPattern, ((Integer) obj).intValue());
            }
        });
        SSCNumBoxAdapter sSCNumBoxAdapter = testBaseActivitySSCPattern.numBoxAdapter;
        if (sSCNumBoxAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
            sSCNumBoxAdapter = null;
        }
        sSCNumBoxAdapter.notifyItemChanged(0, SSCNumBoxAdapterKt.PAYLOAD_CURRENT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadQuestions$lambda$52$lambda$51(Question question, TestBaseActivitySSCPattern testBaseActivitySSCPattern, int i) {
        question.setTotalTimeSpent(i);
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = testBaseActivitySSCPattern.questionAdapter;
        if (sSCQuestionViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
            sSCQuestionViewPagerAdapter = null;
        }
        sSCQuestionViewPagerAdapter.notifyItemChanged(0, SSCQuestionViewPagerAdapterKt.PAYLOAD_TIMER);
        return Unit.INSTANCE;
    }

    private final List<SSCTestOption> buildOptionsFromQuestion(Question q) {
        ArrayList arrayList = new ArrayList();
        buildOptionsFromQuestion$add(arrayList, q.getOption1(), 1);
        buildOptionsFromQuestion$add(arrayList, q.getOption2(), 2);
        buildOptionsFromQuestion$add(arrayList, q.getOption3(), 3);
        buildOptionsFromQuestion$add(arrayList, q.getOption4(), 4);
        buildOptionsFromQuestion$add(arrayList, q.getOption5(), 5);
        buildOptionsFromQuestion$add(arrayList, q.getOption6(), 6);
        return arrayList;
    }

    private static final void buildOptionsFromQuestion$add(List<SSCTestOption> list, String str, int i) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        list.add(new SSCTestOption(i, str, false, null));
    }

    private final List<SSCTestOption> buildFIBOptions(Question q) {
        Regex regex = new Regex("\\bFIB\\b", RegexOption.IGNORE_CASE);
        String question = q.getQuestion();
        if (question == null) {
            question = "";
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(SequencesKt.count(Regex.findAll$default(regex, question, 0, 2, null)), 1);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < iCoerceAtLeast) {
            i++;
            arrayList.add(new SSCTestOption(i, "", false, null));
        }
        return arrayList;
    }

    private final void setupViewPager() {
        this.questionAdapter = new SSCQuestionViewPagerAdapter(this.allQuestions, this.sectionStartIndex, new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TestBaseActivitySSCPattern.setupViewPager$lambda$53(this.f$0, ((Integer) obj).intValue());
            }
        }, new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TestBaseActivitySSCPattern.setupViewPager$lambda$54(this.f$0, (SSCQuestion) obj));
            }
        }, new Function0() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(this.f$0.isReportDisabled);
            }
        }, new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TestBaseActivitySSCPattern.setupViewPager$lambda$56(this.f$0, (SSCQuestion) obj);
            }
        }, new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TestBaseActivitySSCPattern.setupViewPager$lambda$57(this.f$0, (SSCQuestion) obj);
            }
        }, new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TestBaseActivitySSCPattern.setupViewPager$lambda$58(this.f$0, (SSCQuestion) obj);
            }
        });
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        ViewPager2 viewPager2 = activityTestBaseSscpatternBinding.viewPagerQuestions;
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = this.questionAdapter;
        if (sSCQuestionViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
            sSCQuestionViewPagerAdapter = null;
        }
        viewPager2.setAdapter(sSCQuestionViewPagerAdapter);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding3 = null;
        }
        activityTestBaseSscpatternBinding3.viewPagerQuestions.setUserInputEnabled(false);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = this.binding;
        if (activityTestBaseSscpatternBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding4 = null;
        }
        activityTestBaseSscpatternBinding4.viewPagerQuestions.setOffscreenPageLimit(1);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding5 = this.binding;
        if (activityTestBaseSscpatternBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding5;
        }
        activityTestBaseSscpatternBinding2.viewPagerQuestions.registerOnPageChangeCallback(new AnonymousClass7());
        if (this.allQuestions.isEmpty()) {
            return;
        }
        updateBottomButtons(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViewPager$lambda$53(TestBaseActivitySSCPattern testBaseActivitySSCPattern, int i) {
        testBaseActivitySSCPattern.saveAnswer(testBaseActivitySSCPattern.allQuestions.get(i).getOriginal());
        testBaseActivitySSCPattern.updateAttemptCount();
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = testBaseActivitySSCPattern.questionAdapter;
        SSCNumBoxAdapter sSCNumBoxAdapter = null;
        if (sSCQuestionViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
            sSCQuestionViewPagerAdapter = null;
        }
        sSCQuestionViewPagerAdapter.notifyItemChanged(i, SSCQuestionViewPagerAdapterKt.PAYLOAD_ANSWER);
        SSCNumBoxAdapter sSCNumBoxAdapter2 = testBaseActivitySSCPattern.numBoxAdapter;
        if (sSCNumBoxAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
        } else {
            sSCNumBoxAdapter = sSCNumBoxAdapter2;
        }
        sSCNumBoxAdapter.notifyItemChanged(i, SSCNumBoxAdapterKt.PAYLOAD_STATE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupViewPager$lambda$54(TestBaseActivitySSCPattern testBaseActivitySSCPattern, SSCQuestion sscQ) {
        Intrinsics.checkNotNullParameter(sscQ, "sscQ");
        String configId = sscQ.getOriginal().getConfigId();
        String str = configId;
        return (str == null || str.length() == 0 || !testBaseActivitySSCPattern.locallyReportedQuestionIds.contains(configId)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViewPager$lambda$56(TestBaseActivitySSCPattern testBaseActivitySSCPattern, SSCQuestion sscQ) {
        Intrinsics.checkNotNullParameter(sscQ, "sscQ");
        Question original = sscQ.getOriginal();
        if (Intrinsics.areEqual(original.getIs_bookmarked(), "1")) {
            original.setIs_bookmarked("0");
            Toast.makeText(testBaseActivitySSCPattern, testBaseActivitySSCPattern.getString(R.string.unboomark), 0).show();
        } else {
            original.setIs_bookmarked("1");
            Toast.makeText(testBaseActivitySSCPattern, testBaseActivitySSCPattern.getString(R.string.boomark), 0).show();
        }
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = testBaseActivitySSCPattern.binding;
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        int currentItem = activityTestBaseSscpatternBinding.viewPagerQuestions.getCurrentItem();
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter2 = testBaseActivitySSCPattern.questionAdapter;
        if (sSCQuestionViewPagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
        } else {
            sSCQuestionViewPagerAdapter = sSCQuestionViewPagerAdapter2;
        }
        sSCQuestionViewPagerAdapter.notifyItemChanged(currentItem, SSCQuestionViewPagerAdapterKt.PAYLOAD_BOOKMARK);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViewPager$lambda$57(TestBaseActivitySSCPattern testBaseActivitySSCPattern, SSCQuestion q) {
        String str;
        Intrinsics.checkNotNullParameter(q, "q");
        q.getOriginal().setMarkForReview(!q.getOriginal().isMarkForReview());
        TestBaseActivitySSCPattern testBaseActivitySSCPattern2 = testBaseActivitySSCPattern;
        if (q.getOriginal().isMarkForReview()) {
            str = "Marked for review";
        } else {
            str = "Unmarked for review";
        }
        Toast.makeText(testBaseActivitySSCPattern2, str, 0).show();
        testBaseActivitySSCPattern.updateMarkReviewButton(q);
        testBaseActivitySSCPattern.updateAttemptCount();
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = testBaseActivitySSCPattern.binding;
        SSCNumBoxAdapter sSCNumBoxAdapter = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        int currentItem = activityTestBaseSscpatternBinding.viewPagerQuestions.getCurrentItem();
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = testBaseActivitySSCPattern.questionAdapter;
        if (sSCQuestionViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
            sSCQuestionViewPagerAdapter = null;
        }
        sSCQuestionViewPagerAdapter.notifyItemChanged(currentItem, SSCQuestionViewPagerAdapterKt.PAYLOAD_REVIEW);
        SSCNumBoxAdapter sSCNumBoxAdapter2 = testBaseActivitySSCPattern.numBoxAdapter;
        if (sSCNumBoxAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
        } else {
            sSCNumBoxAdapter = sSCNumBoxAdapter2;
        }
        sSCNumBoxAdapter.notifyItemChanged(currentItem, SSCNumBoxAdapterKt.PAYLOAD_STATE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupViewPager$lambda$58(TestBaseActivitySSCPattern testBaseActivitySSCPattern, SSCQuestion sscQuestion) {
        List<QuesReportOption> listEmptyList;
        com.appnew.android.testmodule.model.Data data;
        Intrinsics.checkNotNullParameter(sscQuestion, "sscQuestion");
        String configId = sscQuestion.getOriginal().getConfigId();
        if (configId == null) {
            return Unit.INSTANCE;
        }
        if (testBaseActivitySSCPattern.isReportDisabled) {
            Toast.makeText(testBaseActivitySSCPattern, "Reporting disabled after submit", 0).show();
            return Unit.INSTANCE;
        }
        if (testBaseActivitySSCPattern.locallyReportedQuestionIds.contains(configId)) {
            Toast.makeText(testBaseActivitySSCPattern, "Question reported already", 0).show();
            return Unit.INSTANCE;
        }
        TestseriesBase testseriesBase = testBaseActivitySSCPattern.testSeriesBase;
        if (testseriesBase == null || (data = testseriesBase.getData()) == null || (listEmptyList = data.getQuestionReportOptions()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        testBaseActivitySSCPattern.showPopupErrorTest(listEmptyList, sscQuestion);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$setupViewPager$7, reason: invalid class name */
    /* JADX INFO: compiled from: TestBaseActivitySSCPattern.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/appnew/android/testmodulessc/TestBaseActivitySSCPattern$setupViewPager$7", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass7 extends ViewPager2.OnPageChangeCallback {
        AnonymousClass7() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int position) {
            TestBaseActivitySSCPattern.this.isUserNavigating = false;
            if (TestBaseActivitySSCPattern.this.isLanguageSwitching) {
                TestBaseActivitySSCPattern.this.currentQuestionIndex = position;
                TestBaseActivitySSCPattern.this.lastQuestionIndex = position;
                return;
            }
            if (TestBaseActivitySSCPattern.this.currentQuestionIndex == position) {
                return;
            }
            int iNextIndex = -1;
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = null;
            if (TestBaseActivitySSCPattern.this.lastQuestionIndex != -1) {
                SSCNumBoxAdapter sSCNumBoxAdapter = TestBaseActivitySSCPattern.this.numBoxAdapter;
                if (sSCNumBoxAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
                    sSCNumBoxAdapter = null;
                }
                sSCNumBoxAdapter.notifyItemChanged(TestBaseActivitySSCPattern.this.lastQuestionIndex, SSCNumBoxAdapterKt.PAYLOAD_CURRENT);
            }
            TestBaseActivitySSCPattern.this.lastQuestionIndex = position;
            TestBaseActivitySSCPattern.this.currentQuestionIndex = position;
            TestBaseActivitySSCPattern.this.cachedSectionIndexForQuestion = -1;
            List sections = TestBaseActivitySSCPattern.this.getSections();
            TestBaseActivitySSCPattern testBaseActivitySSCPattern = TestBaseActivitySSCPattern.this;
            ListIterator listIterator = sections.listIterator(sections.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                Integer num = (Integer) testBaseActivitySSCPattern.sectionStartIndex.get(((SSCTestSection) listIterator.previous()).getId());
                if ((num != null ? num.intValue() : Integer.MAX_VALUE) <= position) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            }
            if (iNextIndex >= 0) {
                String id = ((SSCTestSection) TestBaseActivitySSCPattern.this.getSections().get(iNextIndex)).getId();
                if (id == null) {
                    return;
                } else {
                    TestBaseActivitySSCPattern.this.sectionLastQuestionMap.put(id, Integer.valueOf(position));
                }
            }
            SSCNumBoxAdapter sSCNumBoxAdapter2 = TestBaseActivitySSCPattern.this.numBoxAdapter;
            if (sSCNumBoxAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
                sSCNumBoxAdapter2 = null;
            }
            sSCNumBoxAdapter2.notifyItemChanged(position, SSCNumBoxAdapterKt.PAYLOAD_CURRENT);
            TestBaseActivitySSCPattern.this.questionTimer.stop();
            final Question original = ((SSCQuestion) TestBaseActivitySSCPattern.this.allQuestions.get(position)).getOriginal();
            PerQuestionTimerManager perQuestionTimerManager = TestBaseActivitySSCPattern.this.questionTimer;
            int totalTimeSpent = original.getTotalTimeSpent();
            final TestBaseActivitySSCPattern testBaseActivitySSCPattern2 = TestBaseActivitySSCPattern.this;
            perQuestionTimerManager.start(totalTimeSpent, new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$setupViewPager$7$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TestBaseActivitySSCPattern.AnonymousClass7.onPageSelected$lambda$1(original, testBaseActivitySSCPattern2, position, ((Integer) obj).intValue());
                }
            });
            if (iNextIndex >= 0) {
                SSCSectionPartAdapter sSCSectionPartAdapter = TestBaseActivitySSCPattern.this.sectionPartAdapter;
                if (sSCSectionPartAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sectionPartAdapter");
                    sSCSectionPartAdapter = null;
                }
                sSCSectionPartAdapter.setSelectedIndex(iNextIndex);
                TestBaseActivitySSCPattern.this.updateSelectedSectionNameByIndex(iNextIndex);
                SSCSectionTabAdapter sSCSectionTabAdapter = TestBaseActivitySSCPattern.this.sectionTabAdapter;
                if (sSCSectionTabAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sectionTabAdapter");
                    sSCSectionTabAdapter = null;
                }
                sSCSectionTabAdapter.setSelectedPosition(iNextIndex);
                ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = TestBaseActivitySSCPattern.this.binding;
                if (activityTestBaseSscpatternBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding2;
                }
                activityTestBaseSscpatternBinding.recyclerSectionTabs.smoothScrollToPosition(iNextIndex);
                if (TestBaseActivitySSCPattern.this.lastSectionIndex != iNextIndex) {
                    TestBaseActivitySSCPattern.this.sectionStartElapsedRealtime = SystemClock.elapsedRealtime();
                    TestBaseActivitySSCPattern.this.lastSectionIndex = iNextIndex;
                }
            }
            TestBaseActivitySSCPattern.this.updateBottomButtons(position);
            TestBaseActivitySSCPattern testBaseActivitySSCPattern3 = TestBaseActivitySSCPattern.this;
            testBaseActivitySSCPattern3.updateMarkReviewButton((SSCQuestion) testBaseActivitySSCPattern3.allQuestions.get(position));
            TestBaseActivitySSCPattern.this.isProgrammaticPageChange = false;
            TestBaseActivitySSCPattern.this.updateSectionSwitchButtonVisibility();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onPageSelected$lambda$1(Question question, TestBaseActivitySSCPattern testBaseActivitySSCPattern, int i, int i2) {
            question.setTotalTimeSpent(i2);
            SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = testBaseActivitySSCPattern.questionAdapter;
            if (sSCQuestionViewPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
                sSCQuestionViewPagerAdapter = null;
            }
            sSCQuestionViewPagerAdapter.notifyItemChanged(i, SSCQuestionViewPagerAdapterKt.PAYLOAD_TIMER);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMarkReviewButton(SSCQuestion question) {
        if (question == null) {
            return;
        }
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        AppCompatButton btnMarkReview = activityTestBaseSscpatternBinding.btnMarkReview;
        Intrinsics.checkNotNullExpressionValue(btnMarkReview, "btnMarkReview");
        if (question.getOriginal().isMarkForReview()) {
            btnMarkReview.setBackgroundResource(R.drawable.bg_outline_light);
            btnMarkReview.setText(getString(R.string.unmark_review));
            btnMarkReview.setTextColor(ContextCompat.getColor(this, R.color.ssc_blue_light_txt));
        } else {
            btnMarkReview.setBackgroundResource(R.drawable.btn_outline_blue);
            btnMarkReview.setText(getString(R.string.mark_for_review));
            btnMarkReview.setTextColor(ContextCompat.getColor(this, R.color.ssc_blue));
        }
    }

    private final void showPopupErrorTest(final List<? extends QuesReportOption> questionReportOptions, final SSCQuestion question) {
        final DialogReportErrorBinding dialogReportErrorBindingInflate = DialogReportErrorBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogReportErrorBindingInflate, "inflate(...)");
        TestBaseActivitySSCPattern testBaseActivitySSCPattern = this;
        final Dialog dialog = new Dialog(testBaseActivitySSCPattern, R.style.CustomAlertDialog);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(dialogReportErrorBindingInflate.getRoot());
        dialog.show();
        dialogReportErrorBindingInflate.btnSubmit.setBackgroundResource(R.drawable.shape_rect_blue_solid);
        if (Build.VERSION.SDK_INT >= 29) {
            dialogReportErrorBindingInflate.feedbackTV.setTextCursorDrawable(R.drawable.cursor_ssc_blue);
        }
        for (QuesReportOption quesReportOption : questionReportOptions) {
            RadioButton radioButton = new RadioButton(testBaseActivitySSCPattern);
            radioButton.setText(quesReportOption.getTitle());
            radioButton.setButtonTintList(ColorStateList.valueOf(ContextCompat.getColor(testBaseActivitySSCPattern, R.color.ssc_blue)));
            dialogReportErrorBindingInflate.radioError.addView(radioButton);
        }
        dialogReportErrorBindingInflate.ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialogReportErrorBindingInflate.btnSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.showPopupErrorTest$lambda$63(dialogReportErrorBindingInflate, this, questionReportOptions, question, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupErrorTest$lambda$63(DialogReportErrorBinding dialogReportErrorBinding, TestBaseActivitySSCPattern testBaseActivitySSCPattern, List list, SSCQuestion sSCQuestion, Dialog dialog, View view) {
        Object next;
        int checkedRadioButtonId = dialogReportErrorBinding.radioError.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1) {
            Toast.makeText(testBaseActivitySSCPattern, testBaseActivitySSCPattern.getString(R.string.please_select_category), 0).show();
            return;
        }
        String string = StringsKt.trim((CharSequence) dialogReportErrorBinding.feedbackTV.getText().toString()).toString();
        if (string.length() == 0) {
            dialogReportErrorBinding.feedbackTV.setError(testBaseActivitySSCPattern.getString(R.string.msg_field_is_required));
            dialogReportErrorBinding.feedbackTV.requestFocus();
            return;
        }
        String string2 = ((RadioButton) dialogReportErrorBinding.radioError.findViewById(checkedRadioButtonId)).getText().toString();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (StringsKt.equals(((QuesReportOption) next).getTitle(), string2, true)) {
                    break;
                }
            }
        }
        QuesReportOption quesReportOption = (QuesReportOption) next;
        if (quesReportOption != null) {
            testBaseActivitySSCPattern.saveReportLocally(quesReportOption, sSCQuestion.getOriginal(), string, dialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendPendingReports() {
        String str;
        Object next;
        Question original;
        if (this.pendingReports.isEmpty()) {
            return;
        }
        Map.Entry entry = (Map.Entry) CollectionsKt.last(this.pendingReports.entrySet());
        String str2 = (String) entry.getKey();
        SSCPendingReport sSCPendingReport = (SSCPendingReport) entry.getValue();
        Iterator<T> it = this.allQuestions.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((SSCQuestion) next).getOriginal().getConfigId(), str2)) {
                    break;
                }
            }
        }
        SSCQuestion sSCQuestion = (SSCQuestion) next;
        if (sSCQuestion == null || (original = sSCQuestion.getOriginal()) == null) {
            return;
        }
        SSCQuestionReportWorker.Companion companion = SSCQuestionReportWorker.INSTANCE;
        String id = original.getId();
        if (id == null) {
            id = "";
        }
        OneTimeWorkRequest oneTimeWorkRequestBuildRequest = companion.buildRequest(str2, id, sSCPendingReport.getOptionId(), sSCPendingReport.getFeedback(), this.testSeriesId, String.valueOf(this.currentLangId));
        WorkManager companion2 = WorkManager.INSTANCE.getInstance(this);
        String str3 = this.attemptKey;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptKey");
        } else {
            str = str3;
        }
        companion2.enqueueUniqueWork("SSC_REPORT_" + str, ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuildRequest);
    }

    private final void saveReportLocally(QuesReportOption error, Question question, String feedbackMsg, Dialog dialog) {
        String configId = question.getConfigId();
        if (configId == null) {
            return;
        }
        if (this.isReportDisabled) {
            Toast.makeText(this, "Reporting disabled after submit", 0).show();
            dialog.dismiss();
            return;
        }
        boolean zContains = this.locallyReportedQuestionIds.contains(configId);
        this.locallyReportedQuestionIds.add(configId);
        Map<String, SSCPendingReport> map = this.pendingReports;
        String id = error.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        map.put(configId, new SSCPendingReport(id, feedbackMsg));
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        int currentItem = activityTestBaseSscpatternBinding.viewPagerQuestions.getCurrentItem();
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter2 = this.questionAdapter;
        if (sSCQuestionViewPagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
        } else {
            sSCQuestionViewPagerAdapter = sSCQuestionViewPagerAdapter2;
        }
        sSCQuestionViewPagerAdapter.notifyItemChanged(currentItem, SSCQuestionViewPagerAdapterKt.PAYLOAD_REPORT);
        Toast.makeText(this, zContains ? "Report updated" : "Question reported", 0).show();
        dialog.dismiss();
    }

    private final void restoreAttemptState() {
        String str;
        SSCGsonSafe sSCGsonSafe = SSCGsonSafe.INSTANCE;
        SharedPreference sharedPreference = SharedPreference.getInstance();
        String str2 = this.attemptKey;
        Object objFromJson = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptKey");
            str2 = null;
        }
        String string = sharedPreference.getString("REPORTED_IDS_" + str2);
        try {
            str = string;
        } catch (Exception e2) {
            Log.e("SSC_SUBMIT", "fromJson", e2);
        }
        Object objFromJson2 = (str == null || StringsKt.isBlank(str) || Intrinsics.areEqual(string, com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID)) ? null : sSCGsonSafe.getGson().fromJson(string, new TypeToken<Set<? extends String>>() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$restoreAttemptState$$inlined$fromJson$1
        }.getType());
        Set set = (Set) objFromJson2;
        if (set != null) {
            this.locallyReportedQuestionIds.addAll(set);
        }
        SSCGsonSafe sSCGsonSafe2 = SSCGsonSafe.INSTANCE;
        SharedPreference sharedPreference2 = SharedPreference.getInstance();
        String str3 = this.attemptKey;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptKey");
            str3 = null;
        }
        String string2 = sharedPreference2.getString("PENDING_REPORTS_" + str3);
        try {
            String str4 = string2;
            if (str4 != null && !StringsKt.isBlank(str4) && !Intrinsics.areEqual(string2, com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID)) {
                objFromJson = sSCGsonSafe2.getGson().fromJson(string2, new TypeToken<Map<String, ? extends SSCPendingReport>>() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$restoreAttemptState$$inlined$fromJson$2
                }.getType());
            }
        } catch (Exception e3) {
            Log.e("SSC_SUBMIT", "fromJson", e3);
        }
        Map<? extends String, ? extends SSCPendingReport> map = (Map) objFromJson;
        if (map != null) {
            this.pendingReports.putAll(map);
        }
    }

    private final void resetReportStateForAttempt() {
        this.locallyReportedQuestionIds.clear();
        this.pendingReports.clear();
        SharedPreference sharedPreference = SharedPreference.getInstance();
        String str = this.attemptKey;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptKey");
            str = null;
        }
        sharedPreference.remove("REPORTED_IDS_" + str);
        SharedPreference sharedPreference2 = SharedPreference.getInstance();
        String str3 = this.attemptKey;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptKey");
        } else {
            str2 = str3;
        }
        sharedPreference2.remove("PENDING_REPORTS_" + str2);
    }

    private final void setupDrawerSections() {
        TestBaseActivitySSCPattern testBaseActivitySSCPattern = this;
        this.sectionPartAdapter = new SSCSectionPartAdapter(testBaseActivitySSCPattern, getSections(), new Function2() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TestBaseActivitySSCPattern.setupDrawerSections$lambda$67(this.f$0, (SSCTestSection) obj, ((Integer) obj2).intValue());
            }
        });
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        SSCSectionPartAdapter sSCSectionPartAdapter = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        RecyclerView recyclerView = activityTestBaseSscpatternBinding.includeDrawerContent.sectionAsPart;
        recyclerView.setLayoutManager(new LinearLayoutManager(testBaseActivitySSCPattern, 0, false));
        SSCSectionPartAdapter sSCSectionPartAdapter2 = this.sectionPartAdapter;
        if (sSCSectionPartAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionPartAdapter");
        } else {
            sSCSectionPartAdapter = sSCSectionPartAdapter2;
        }
        recyclerView.setAdapter(sSCSectionPartAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDrawerSections$lambda$67(TestBaseActivitySSCPattern testBaseActivitySSCPattern, SSCTestSection section, int i) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(section, "section");
        Integer num = testBaseActivitySSCPattern.sectionLastQuestionMap.get(section.getId());
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Integer num2 = testBaseActivitySSCPattern.sectionStartIndex.get(section.getId());
            if (num2 != null) {
                iIntValue = num2.intValue();
            } else {
                return Unit.INSTANCE;
            }
        }
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = null;
        if (!testBaseActivitySSCPattern.canNavigateTo(iIntValue)) {
            testBaseActivitySSCPattern.restoreCurrentSectionSelection();
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = testBaseActivitySSCPattern.binding;
            if (activityTestBaseSscpatternBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding2;
            }
            activityTestBaseSscpatternBinding.drawerLayout.closeDrawer(GravityCompat.END);
            return Unit.INSTANCE;
        }
        testBaseActivitySSCPattern.updateSelectedSectionNameByIndex(i);
        testBaseActivitySSCPattern.isProgrammaticPageChange = true;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding3 = null;
        }
        activityTestBaseSscpatternBinding3.viewPagerQuestions.setCurrentItem(iIntValue, false);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding4;
        }
        activityTestBaseSscpatternBinding.drawerLayout.closeDrawer(GravityCompat.END);
        return Unit.INSTANCE;
    }

    private final void setupQuestionGrid() {
        this.numBoxAdapter = new SSCNumBoxAdapter(this.allQuestions, getSections(), this.sectionStartIndex, new Function0() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(TestBaseActivitySSCPattern.setupQuestionGrid$lambda$69(this.f$0));
            }
        }, new Function0() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(this.f$0.getCurrentSectionIndex());
            }
        }, this.sectionSwitchAllowed, new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TestBaseActivitySSCPattern.setupQuestionGrid$lambda$71(this.f$0, ((Integer) obj).intValue());
            }
        });
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        SSCNumBoxAdapter sSCNumBoxAdapter = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        RecyclerView recyclerView = activityTestBaseSscpatternBinding.includeDrawerContent.rvQuestionGrid;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 6));
        SSCNumBoxAdapter sSCNumBoxAdapter2 = this.numBoxAdapter;
        if (sSCNumBoxAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
        } else {
            sSCNumBoxAdapter = sSCNumBoxAdapter2;
        }
        recyclerView.setAdapter(sSCNumBoxAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int setupQuestionGrid$lambda$69(TestBaseActivitySSCPattern testBaseActivitySSCPattern) {
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        return activityTestBaseSscpatternBinding.viewPagerQuestions.getCurrentItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupQuestionGrid$lambda$71(TestBaseActivitySSCPattern testBaseActivitySSCPattern, int i) {
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = null;
        if (!testBaseActivitySSCPattern.canNavigateTo(i)) {
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = testBaseActivitySSCPattern.binding;
            if (activityTestBaseSscpatternBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding2;
            }
            activityTestBaseSscpatternBinding.drawerLayout.closeDrawer(GravityCompat.END);
            return Unit.INSTANCE;
        }
        testBaseActivitySSCPattern.isProgrammaticPageChange = true;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding3 = null;
        }
        activityTestBaseSscpatternBinding3.viewPagerQuestions.setCurrentItem(i, false);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding4;
        }
        activityTestBaseSscpatternBinding.drawerLayout.closeDrawer(GravityCompat.END);
        return Unit.INSTANCE;
    }

    private final void setupSectionTabs() {
        TestBaseActivitySSCPattern testBaseActivitySSCPattern = this;
        this.sectionTabAdapter = new SSCSectionTabAdapter(testBaseActivitySSCPattern, getSections(), new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TestBaseActivitySSCPattern.setupSectionTabs$lambda$73(this.f$0, (SSCTestSection) obj);
            }
        });
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        SSCSectionTabAdapter sSCSectionTabAdapter = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.recyclerSectionTabs.setLayoutManager(new LinearLayoutManager(testBaseActivitySSCPattern, 0, false));
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = this.binding;
        if (activityTestBaseSscpatternBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding2 = null;
        }
        RecyclerView recyclerView = activityTestBaseSscpatternBinding2.recyclerSectionTabs;
        SSCSectionTabAdapter sSCSectionTabAdapter2 = this.sectionTabAdapter;
        if (sSCSectionTabAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionTabAdapter");
        } else {
            sSCSectionTabAdapter = sSCSectionTabAdapter2;
        }
        recyclerView.setAdapter(sSCSectionTabAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupSectionTabs$lambda$73(TestBaseActivitySSCPattern testBaseActivitySSCPattern, SSCTestSection section) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(section, "section");
        Integer num = testBaseActivitySSCPattern.sectionLastQuestionMap.get(section.getId());
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Integer num2 = testBaseActivitySSCPattern.sectionStartIndex.get(section.getId());
            if (num2 != null) {
                iIntValue = num2.intValue();
            } else {
                return Unit.INSTANCE;
            }
        }
        if (!testBaseActivitySSCPattern.canNavigateTo(iIntValue)) {
            testBaseActivitySSCPattern.restoreCurrentSectionSelection();
            return Unit.INSTANCE;
        }
        testBaseActivitySSCPattern.isProgrammaticPageChange = true;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.viewPagerQuestions.setCurrentItem(iIntValue, false);
        return Unit.INSTANCE;
    }

    private final void setupBottomButtons() {
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.btnPrevious.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.setupBottomButtons$lambda$74(this.f$0, view);
            }
        });
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding3 = null;
        }
        activityTestBaseSscpatternBinding3.btnSaveNext.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.setupBottomButtons$lambda$75(this.f$0, view);
            }
        });
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = this.binding;
        if (activityTestBaseSscpatternBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding4;
        }
        activityTestBaseSscpatternBinding2.btnMarkReview.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.setupBottomButtons$lambda$76(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBottomButtons$lambda$74(TestBaseActivitySSCPattern testBaseActivitySSCPattern, View view) {
        if (testBaseActivitySSCPattern.isUserNavigating) {
            return;
        }
        testBaseActivitySSCPattern.isUserNavigating = true;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = testBaseActivitySSCPattern.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        int currentItem = activityTestBaseSscpatternBinding.viewPagerQuestions.getCurrentItem();
        if (currentItem <= 0) {
            testBaseActivitySSCPattern.isUserNavigating = false;
            return;
        }
        int i = currentItem - 1;
        if (!testBaseActivitySSCPattern.canNavigateTo(i)) {
            testBaseActivitySSCPattern.isUserNavigating = false;
            return;
        }
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding3;
        }
        activityTestBaseSscpatternBinding2.viewPagerQuestions.setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBottomButtons$lambda$75(TestBaseActivitySSCPattern testBaseActivitySSCPattern, View view) {
        if (testBaseActivitySSCPattern.isUserNavigating) {
            return;
        }
        testBaseActivitySSCPattern.isUserNavigating = true;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = testBaseActivitySSCPattern.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        int currentItem = activityTestBaseSscpatternBinding.viewPagerQuestions.getCurrentItem();
        if (currentItem == CollectionsKt.getLastIndex(testBaseActivitySSCPattern.allQuestions)) {
            testBaseActivitySSCPattern.isUserNavigating = false;
            testBaseActivitySSCPattern.showSubmitDialog();
            return;
        }
        int i = currentItem + 1;
        if (!testBaseActivitySSCPattern.canNavigateTo(i)) {
            testBaseActivitySSCPattern.isUserNavigating = false;
            return;
        }
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = testBaseActivitySSCPattern.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding3;
        }
        activityTestBaseSscpatternBinding2.viewPagerQuestions.setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBottomButtons$lambda$76(TestBaseActivitySSCPattern testBaseActivitySSCPattern, View view) {
        String str;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = testBaseActivitySSCPattern.binding;
        SSCNumBoxAdapter sSCNumBoxAdapter = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        int currentItem = activityTestBaseSscpatternBinding.viewPagerQuestions.getCurrentItem();
        SSCQuestion sSCQuestion = testBaseActivitySSCPattern.allQuestions.get(currentItem);
        sSCQuestion.getOriginal().setMarkForReview(!sSCQuestion.getOriginal().isMarkForReview());
        TestBaseActivitySSCPattern testBaseActivitySSCPattern2 = testBaseActivitySSCPattern;
        if (sSCQuestion.getOriginal().isMarkForReview()) {
            str = "Marked for review";
        } else {
            str = "Unmarked for review";
        }
        Toast.makeText(testBaseActivitySSCPattern2, str, 0).show();
        testBaseActivitySSCPattern.updateMarkReviewButton(sSCQuestion);
        testBaseActivitySSCPattern.updateAttemptCount();
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = testBaseActivitySSCPattern.questionAdapter;
        if (sSCQuestionViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
            sSCQuestionViewPagerAdapter = null;
        }
        sSCQuestionViewPagerAdapter.notifyItemChanged(currentItem, SSCQuestionViewPagerAdapterKt.PAYLOAD_REVIEW);
        SSCNumBoxAdapter sSCNumBoxAdapter2 = testBaseActivitySSCPattern.numBoxAdapter;
        if (sSCNumBoxAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
        } else {
            sSCNumBoxAdapter = sSCNumBoxAdapter2;
        }
        sSCNumBoxAdapter.notifyItemChanged(currentItem, SSCNumBoxAdapterKt.PAYLOAD_STATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBottomButtons(int pos) {
        String str;
        String id;
        Integer num;
        int size = this.allQuestions.size();
        SSCTestSection sSCTestSection = (SSCTestSection) CollectionsKt.getOrNull(getSections(), getCurrentSectionIndex());
        boolean z = this.sectionSwitchAllowed ? pos == 0 : pos == ((sSCTestSection == null || (id = sSCTestSection.getId()) == null || (num = this.sectionStartIndex.get(id)) == null) ? 0 : num.intValue());
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.btnPrevious.setVisibility(z ? 8 : 0);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding3;
        }
        AppCompatButton appCompatButton = activityTestBaseSscpatternBinding2.btnSaveNext;
        if (size <= 1 || pos == size - 1) {
        }
        appCompatButton.setText(str);
    }

    private final void setupTestName() throws JSONException {
        String string = SharedPreference.getInstance().getString("test_series");
        if (string == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(string).getJSONObject("data").getJSONObject("test_basic");
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.includeToolbar.testNameNew.setText(jSONObject.optString("test_series_name"));
    }

    private final void updateAttemptCount() {
        int i;
        List<SSCQuestion> list = this.allQuestions;
        int i2 = 0;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((SSCQuestion) it.next()).getOriginal().isanswer() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        List<SSCQuestion> list2 = this.allQuestions;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (((SSCQuestion) it2.next()).getOriginal().isMarkForReview() && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        int size = this.allQuestions.size() - i;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        SscPatternDrawerLayoutBinding sscPatternDrawerLayoutBinding = activityTestBaseSscpatternBinding.includeDrawerContent;
        sscPatternDrawerLayoutBinding.answeredQuesCount.setText(String.valueOf(i));
        sscPatternDrawerLayoutBinding.unansweredQuesCount.setText(String.valueOf(size));
        sscPatternDrawerLayoutBinding.markedQuesCount.setText(String.valueOf(i2));
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding3;
        }
        activityTestBaseSscpatternBinding2.tvTotalCount.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SSCTestSection> getSSCSections() throws JSONException {
        String string = SharedPreference.getInstance().getString("test_series");
        if (string == null) {
            return CollectionsKt.emptyList();
        }
        JSONArray jSONArray = new JSONObject(string).getJSONObject("data").getJSONArray("test_sections");
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add((SSCTestSection) this.gson.fromJson(jSONArray.getJSONObject(i).toString(), SSCTestSection.class));
        }
        return arrayList;
    }

    private final String formatTime(long ms) {
        long j = ms / ((long) 1000);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        long j2 = 3600;
        long j3 = 60;
        String str = String.format(Locale.US, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j / j2), Long.valueOf((j % j2) / j3), Long.valueOf(j % j3)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final void updateTimeLeftText(long ms) {
        String str;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = null;
        if (ms <= 0) {
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = this.binding;
            if (activityTestBaseSscpatternBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding2;
            }
            activityTestBaseSscpatternBinding.timeLeftTxt.setText(getString(R.string.no_time_left));
            return;
        }
        int i = (int) (ms / ((long) 1000));
        int i2 = i / 60;
        int i3 = i % 60;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding3;
        }
        TextView textView = activityTestBaseSscpatternBinding.timeLeftTxt;
        String str2 = CmcdData.Factory.STREAMING_FORMAT_SS;
        if (i2 > 0) {
            if (i2 <= 1) {
                str2 = "";
            }
            str = "Last " + i2 + " Min" + str2;
        } else if (i3 > 0) {
            if (i3 <= 1) {
                str2 = "";
            }
            str = "Last " + i3 + " Sec" + str2;
        }
        textView.setText(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$setupTestTimer$2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void setupTestTimer() {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern.setupTestTimer():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAllTimers(long ms) {
        long jLongValue;
        TextView textView;
        boolean z = this.sectionSwitchAllowed;
        if (!z) {
            ms = getRemainingSectionMillis(ms);
        }
        String time = formatTime(ms);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        String str = time;
        activityTestBaseSscpatternBinding.includeToolbar.timerText.setText(str);
        Dialog dialog = this.submitDialog;
        if (dialog != null && (textView = (TextView) dialog.findViewById(R.id.tvTimeValue)) != null) {
            textView.setText(str);
        }
        updateTimeLeftText(ms);
        if (!z) {
            SSCTestSection sSCTestSection = (SSCTestSection) CollectionsKt.getOrNull(getSections(), getCurrentSectionIndex());
            Long l = this.sectionDurationMap.get(sSCTestSection != null ? sSCTestSection.getId() : null);
            jLongValue = l != null ? l.longValue() : this.totalTestMillis;
        } else {
            jLongValue = this.totalTestMillis;
        }
        int iCoerceIn = jLongValue > 0 ? RangesKt.coerceIn((int) (((jLongValue - ms) / jLongValue) * 1000), 0, 1000) : 0;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
        if (activityTestBaseSscpatternBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding3;
        }
        activityTestBaseSscpatternBinding2.includeToolbar.pauseProgress.setProgress(iCoerceIn);
    }

    public final void forceAutoSubmit(final boolean expiredByEndDate) {
        if (this.isPracticeTest && expiredByEndDate) {
            return;
        }
        synchronized (this) {
            if (this.isAutoSubmitted) {
                return;
            }
            this.isAutoSubmitted = true;
            this.isTimeUpHandled = true;
            this.isExpiredByEndDate = expiredByEndDate;
            this.submissionTriggeredWhileSleep = !hasWindowFocus();
            Unit unit = Unit.INSTANCE;
            Dialog dialog = this.submitDialog;
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
            this.submitDialog = null;
            CountDownTimer countDownTimer = this.testTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.questionTimer.stop();
            this.lastTickMillis = 0L;
            updateAllTimers(0L);
            SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, true);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    TestBaseActivitySSCPattern.forceAutoSubmit$lambda$85(this.f$0);
                }
            });
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    TestBaseActivitySSCPattern.forceAutoSubmit$lambda$86(this.f$0, expiredByEndDate);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forceAutoSubmit$lambda$85(TestBaseActivitySSCPattern testBaseActivitySSCPattern) {
        if (testBaseActivitySSCPattern.isSubmitDispatched.compareAndSet(false, true)) {
            testBaseActivitySSCPattern.isSubmitting.set(false);
            testBaseActivitySSCPattern.submitTest(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forceAutoSubmit$lambda$86(TestBaseActivitySSCPattern testBaseActivitySSCPattern, boolean z) {
        if (testBaseActivitySSCPattern.isSubmitDialogShowing || testBaseActivitySSCPattern.isFinishing() || testBaseActivitySSCPattern.isDestroyed()) {
            return;
        }
        testBaseActivitySSCPattern.showTimeOutDialog(z);
    }

    private final void syncServerTime(long serverEpochSeconds) {
        SharedPreference.getInstance().putLong("SERVER_TIME_OFFSET", (serverEpochSeconds * ((long) 1000)) - System.currentTimeMillis());
    }

    private final void syncServerTimeFromTestJson() {
        try {
            String string = SharedPreference.getInstance().getString("test_series");
            if (string == null) {
                return;
            }
            long jOptLong = new JSONObject(string).optLong("time", 0L);
            if (jOptLong > 0) {
                syncServerTime(jOptLong);
            }
        } catch (Exception e2) {
            Log.e(this.tagSSC, "Failed to sync server time", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getTrustedNowMillis() {
        return System.currentTimeMillis() + SharedPreference.getInstance().getLong("SERVER_TIME_OFFSET");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSubmitDialog() {
        int i;
        if (isFinishing() || isDestroyed() || this.isSubmitDialogShowing) {
            return;
        }
        this.isSubmitDialogShowing = true;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        if (activityTestBaseSscpatternBinding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
            if (activityTestBaseSscpatternBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTestBaseSscpatternBinding3 = null;
            }
            activityTestBaseSscpatternBinding3.drawerLayout.closeDrawer(GravityCompat.END);
        }
        SscPatternBackSubmitDialogBinding sscPatternBackSubmitDialogBindingInflate = SscPatternBackSubmitDialogBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(sscPatternBackSubmitDialogBindingInflate, "inflate(...)");
        final Dialog dialog = new Dialog(this);
        this.submitDialog = dialog;
        Intrinsics.checkNotNull(dialog);
        dialog.requestWindowFeature(1);
        int i2 = 0;
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(sscPatternBackSubmitDialogBindingInflate.getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawableResource(R.color.gray_transparent);
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                TestBaseActivitySSCPattern.showSubmitDialog$lambda$88(this.f$0, dialogInterface);
            }
        });
        dialog.show();
        sscPatternBackSubmitDialogBindingInflate.tvTimeValue.setText(formatTime(this.lastTickMillis));
        List<SSCQuestion> list = this.allQuestions;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((SSCQuestion) it.next()).getOriginal().isanswer() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        List<SSCQuestion> list2 = this.allQuestions;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (((SSCQuestion) it2.next()).getOriginal().isMarkForReview() && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        int size = this.allQuestions.size() - i;
        sscPatternBackSubmitDialogBindingInflate.tvAttemptedValue.setText(String.valueOf(i));
        sscPatternBackSubmitDialogBindingInflate.tvUnattemptedValue.setText(String.valueOf(size));
        sscPatternBackSubmitDialogBindingInflate.tvMarkedValue.setText(String.valueOf(i2));
        TextView textView = sscPatternBackSubmitDialogBindingInflate.tvTimeValue;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding4 = this.binding;
        if (activityTestBaseSscpatternBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding4;
        }
        textView.setText(activityTestBaseSscpatternBinding2.includeToolbar.timerText.getText().toString());
        sscPatternBackSubmitDialogBindingInflate.btnYes.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.showSubmitDialog$lambda$91(this.f$0, dialog, view);
            }
        });
        sscPatternBackSubmitDialogBindingInflate.btnNo.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.showSubmitDialog$lambda$92(this.f$0, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubmitDialog$lambda$88(TestBaseActivitySSCPattern testBaseActivitySSCPattern, DialogInterface dialogInterface) {
        testBaseActivitySSCPattern.isSubmitDialogShowing = false;
        testBaseActivitySSCPattern.submitDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubmitDialog$lambda$91(TestBaseActivitySSCPattern testBaseActivitySSCPattern, Dialog dialog, View view) {
        testBaseActivitySSCPattern.isSubmitDialogShowing = false;
        dialog.dismiss();
        testBaseActivitySSCPattern.submitTest(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubmitDialog$lambda$92(TestBaseActivitySSCPattern testBaseActivitySSCPattern, Dialog dialog, View view) {
        testBaseActivitySSCPattern.isSubmitDialogShowing = false;
        dialog.dismiss();
        if (testBaseActivitySSCPattern.isAutoSubmitted) {
            testBaseActivitySSCPattern.finish();
        }
    }

    private final void showTimeOutDialog(boolean expiredByEndDate) {
        String str;
        if (isFinishing() || isDestroyed() || this.isSubmitDialogShowing) {
            return;
        }
        Log.d(this.tagSSC, "showTimeOutDialog | expiredByEndDate=" + expiredByEndDate);
        boolean z = true;
        this.isSubmitDialogShowing = true;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        String str2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        if (activityTestBaseSscpatternBinding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = this.binding;
            if (activityTestBaseSscpatternBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTestBaseSscpatternBinding2 = null;
            }
            activityTestBaseSscpatternBinding2.drawerLayout.closeDrawer(GravityCompat.END);
        }
        SscPatternTimeOutDialogBinding sscPatternTimeOutDialogBindingInflate = SscPatternTimeOutDialogBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(sscPatternTimeOutDialogBindingInflate, "inflate(...)");
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(sscPatternTimeOutDialogBindingInflate.getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.clearFlags(2);
        }
        String str3 = this.attemptOrReAttempt;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptOrReAttempt");
            str3 = null;
        }
        if (!StringsKt.equals(str3, Const.ATTEMPT, true)) {
            String str4 = this.attemptOrReAttempt;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("attemptOrReAttempt");
            } else {
                str2 = str4;
            }
            if (!StringsKt.equals(str2, "ReAttempt", true)) {
                z = false;
            }
        }
        TextView textView = sscPatternTimeOutDialogBindingInflate.tvTimeoutTitle;
        if (!expiredByEndDate || !z || this.isPracticeTest) {
        }
        textView.setText(str);
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
            window2.setBackgroundDrawableResource(R.color.gray_transparent);
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda29
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.isSubmitDialogShowing = false;
            }
        });
        sscPatternTimeOutDialogBindingInflate.btnOk.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CountDownTimer countDownTimer = this.testTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.questionTimer.stop();
        Dialog dialog = this.submitDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.submitDialog = null;
        dataSendListener = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.questionTimer.stop();
        SharedPreference sharedPreference = SharedPreference.getInstance();
        String str = this.attemptKey;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptKey");
            str = null;
        }
        sharedPreference.putString("REPORTED_IDS_" + str, new Gson().toJson(this.locallyReportedQuestionIds));
        SharedPreference sharedPreference2 = SharedPreference.getInstance();
        String str3 = this.attemptKey;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptKey");
        } else {
            str2 = str3;
        }
        sharedPreference2.putString("PENDING_REPORTS_" + str2, new Gson().toJson(this.pendingReports));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        boolean z = this.isAutoSubmitted;
        boolean z2 = false;
        if (z && !this.isSubmissionCompleted) {
            if (this.isSubmitDispatched.compareAndSet(false, true)) {
                this.isSubmitting.set(false);
                submitTest(true);
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        long trustedNowMillis = getTrustedNowMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.elapsedStartRealtime;
        boolean z3 = this.isPracticeTest;
        if (!z3) {
            long j = this.endDateMillis;
            if (1 <= j && j <= trustedNowMillis) {
                forceAutoSubmit(true);
                return;
            }
        }
        long j2 = this.elapsedAllowedDuration;
        if (1 <= j2 && j2 <= jElapsedRealtime) {
            if (this.isExpiredByEndDate || (!z3 && this.endDateMillis > 0 && getTrustedNowMillis() >= this.endDateMillis)) {
                z2 = true;
            }
            forceAutoSubmit(z2);
            return;
        }
        if (!this.sectionSwitchAllowed && !this.isUserNavigating && isSectionTimeOver()) {
            handleSectionTimeExpirySafely();
            return;
        }
        if (this.allQuestions.isEmpty()) {
            return;
        }
        int size = this.allQuestions.size();
        int i = this.currentQuestionIndex;
        if (i < 0 || i >= size) {
            return;
        }
        final Question original = this.allQuestions.get(i).getOriginal();
        this.questionTimer.start(original.getTotalTimeSpent(), new Function1() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TestBaseActivitySSCPattern.onResume$lambda$96(original, this, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResume$lambda$96(Question question, TestBaseActivitySSCPattern testBaseActivitySSCPattern, int i) {
        question.setTotalTimeSpent(i);
        SSCQuestionViewPagerAdapter sSCQuestionViewPagerAdapter = testBaseActivitySSCPattern.questionAdapter;
        if (sSCQuestionViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questionAdapter");
            sSCQuestionViewPagerAdapter = null;
        }
        sSCQuestionViewPagerAdapter.notifyItemChanged(testBaseActivitySSCPattern.currentQuestionIndex, SSCQuestionViewPagerAdapterKt.PAYLOAD_TIMER);
        return Unit.INSTANCE;
    }

    private final long getRemainingSectionMillis(long globalRemaining) {
        SSCTestSection sSCTestSection;
        Long l;
        return (this.sectionSwitchAllowed || (sSCTestSection = (SSCTestSection) CollectionsKt.getOrNull(getSections(), getCurrentSectionIndex())) == null || (l = this.sectionDurationMap.get(sSCTestSection.getId())) == null) ? globalRemaining : RangesKt.coerceAtLeast(Math.min(l.longValue() - (SystemClock.elapsedRealtime() - this.sectionStartElapsedRealtime), globalRemaining), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasDeferredResult() {
        try {
            if (StringsKt.isBlank(this.resultDate)) {
                return false;
            }
            return !Intrinsics.areEqual(this.resultDate, "0");
        } catch (Exception e2) {
            Log.e(this.tagSSC, "Failed to parse result date", e2);
            return false;
        }
    }

    private final String formatResultDate(String epochSeconds) {
        long j;
        try {
            if (epochSeconds.length() < 12) {
                j = Long.parseLong(epochSeconds) * ((long) 1000);
            } else {
                j = Long.parseLong(epochSeconds);
            }
            String str = new SimpleDateFormat("dd MMMM yyyy 'at' hh:mm a", Locale.ENGLISH).format(new Date(j));
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e2) {
            Log.e(this.tagSSC, "Failed to format result date", e2);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showResultDeferredSnackAndFinish() {
        com.appnew.android.home.Constants.REFRESHPAGE = "true";
        SharedPreference.getInstance().putString("DEFERRED_RESULT_MSG", "Result will be declared on " + formatResultDate(this.resultDate));
        finish();
    }

    private final void sectionSwitchAllowedFlag() {
        if (SharedPreference.getInstance().getString("test_series") == null) {
            return;
        }
        this.sectionSwitchAllowed = !Intrinsics.areEqual(new JSONObject(r0).getJSONObject("data").getJSONObject("test_basic").optString("allow_user_move", "1"), "0");
    }

    private final boolean canNavigateTo(int targetQuestionIndex) {
        if (this.sectionSwitchAllowed || getSectionIndexForQuestion(this.currentQuestionIndex) == getSectionIndexForQuestion(targetQuestionIndex)) {
            return true;
        }
        Toast.makeText(this, getString(R.string.switching_section_is_not_allowed), 0).show();
        return false;
    }

    private final int getSectionIndexForQuestion(int questionIndex) {
        int i = 0;
        int i2 = 0;
        for (Object obj : getSections()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Integer num = this.sectionStartIndex.get(((SSCTestSection) obj).getId());
            if (num != null && num.intValue() <= questionIndex) {
                i = i2;
            }
            i2 = i3;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSectionTimeExpirySafely() {
        int currentSectionIndex = getCurrentSectionIndex();
        if (currentSectionIndex < CollectionsKt.getLastIndex(getSections())) {
            Toast.makeText(this, R.string.section_switched, 0).show();
            moveToNextSection();
            this.sectionStartElapsedRealtime = SystemClock.elapsedRealtime();
            this.lastSectionIndex = currentSectionIndex + 1;
            updateAllTimers(this.lastTickMillis);
            return;
        }
        forceAutoSubmit(false);
    }

    private final void moveToNextSection() {
        SSCNumBoxAdapter sSCNumBoxAdapter = this.numBoxAdapter;
        SSCNumBoxAdapter sSCNumBoxAdapter2 = null;
        if (sSCNumBoxAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
            sSCNumBoxAdapter = null;
        }
        IntRange sectionRange = sSCNumBoxAdapter.getSectionRange();
        int currentSectionIndex = getCurrentSectionIndex() + 1;
        if (currentSectionIndex < 0 || currentSectionIndex >= getSections().size()) {
            return;
        }
        Integer num = this.sectionStartIndex.get(getSections().get(currentSectionIndex).getId());
        if (num != null) {
            int iIntValue = num.intValue();
            SSCSectionPartAdapter sSCSectionPartAdapter = this.sectionPartAdapter;
            if (sSCSectionPartAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionPartAdapter");
                sSCSectionPartAdapter = null;
            }
            sSCSectionPartAdapter.setSelectedIndex(currentSectionIndex);
            SSCSectionTabAdapter sSCSectionTabAdapter = this.sectionTabAdapter;
            if (sSCSectionTabAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionTabAdapter");
                sSCSectionTabAdapter = null;
            }
            sSCSectionTabAdapter.setSelectedPosition(currentSectionIndex);
            updateSelectedSectionNameByIndex(currentSectionIndex);
            this.isProgrammaticPageChange = true;
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
            if (activityTestBaseSscpatternBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTestBaseSscpatternBinding = null;
            }
            activityTestBaseSscpatternBinding.viewPagerQuestions.setCurrentItem(iIntValue, false);
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = this.binding;
            if (activityTestBaseSscpatternBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityTestBaseSscpatternBinding2 = null;
            }
            activityTestBaseSscpatternBinding2.recyclerSectionTabs.smoothScrollToPosition(currentSectionIndex);
            SSCNumBoxAdapter sSCNumBoxAdapter3 = this.numBoxAdapter;
            if (sSCNumBoxAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
                sSCNumBoxAdapter3 = null;
            }
            IntRange sectionRange2 = sSCNumBoxAdapter3.getSectionRange();
            int iCount = CollectionsKt.count(sectionRange);
            int iCount2 = CollectionsKt.count(sectionRange2);
            SSCNumBoxAdapter sSCNumBoxAdapter4 = this.numBoxAdapter;
            if (sSCNumBoxAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
                sSCNumBoxAdapter4 = null;
            }
            sSCNumBoxAdapter4.notifyItemRangeRemoved(0, iCount);
            SSCNumBoxAdapter sSCNumBoxAdapter5 = this.numBoxAdapter;
            if (sSCNumBoxAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numBoxAdapter");
            } else {
                sSCNumBoxAdapter2 = sSCNumBoxAdapter5;
            }
            sSCNumBoxAdapter2.notifyItemRangeInserted(0, iCount2);
            updateSectionSwitchButtonVisibility();
        }
    }

    private final void restoreCurrentSectionSelection() {
        int currentSectionIndex = getCurrentSectionIndex();
        SSCSectionTabAdapter sSCSectionTabAdapter = this.sectionTabAdapter;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = null;
        if (sSCSectionTabAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionTabAdapter");
            sSCSectionTabAdapter = null;
        }
        sSCSectionTabAdapter.setSelectedPosition(currentSectionIndex);
        SSCSectionPartAdapter sSCSectionPartAdapter = this.sectionPartAdapter;
        if (sSCSectionPartAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionPartAdapter");
            sSCSectionPartAdapter = null;
        }
        sSCSectionPartAdapter.setSelectedIndex(currentSectionIndex);
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = this.binding;
        if (activityTestBaseSscpatternBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestBaseSscpatternBinding = activityTestBaseSscpatternBinding2;
        }
        activityTestBaseSscpatternBinding.recyclerSectionTabs.smoothScrollToPosition(currentSectionIndex);
    }

    private final void sectionForceSwitchDialog() {
        String string;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding2 = null;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        if (activityTestBaseSscpatternBinding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding3 = this.binding;
            if (activityTestBaseSscpatternBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityTestBaseSscpatternBinding2 = activityTestBaseSscpatternBinding3;
            }
            activityTestBaseSscpatternBinding2.drawerLayout.closeDrawer(GravityCompat.END);
        }
        SscPatternSectionSwitchDailogBinding sscPatternSectionSwitchDailogBindingInflate = SscPatternSectionSwitchDailogBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(sscPatternSectionSwitchDailogBindingInflate, "inflate(...)");
        TestBaseActivitySSCPattern testBaseActivitySSCPattern = this;
        final Dialog dialog = new Dialog(testBaseActivitySSCPattern);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(sscPatternSectionSwitchDailogBindingInflate.getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        TextView sectionTitle = sscPatternSectionSwitchDailogBindingInflate.sectionTitle;
        Intrinsics.checkNotNullExpressionValue(sectionTitle, "sectionTitle");
        TextView sectionSubTitle = sscPatternSectionSwitchDailogBindingInflate.sectionSubTitle;
        Intrinsics.checkNotNullExpressionValue(sectionSubTitle, "sectionSubTitle");
        Button btnYesSwitch = sscPatternSectionSwitchDailogBindingInflate.btnYesSwitch;
        Intrinsics.checkNotNullExpressionValue(btnYesSwitch, "btnYesSwitch");
        Button btnNoSwitch = sscPatternSectionSwitchDailogBindingInflate.btnNoSwitch;
        Intrinsics.checkNotNullExpressionValue(btnNoSwitch, "btnNoSwitch");
        final boolean z = getCurrentSectionIndex() >= CollectionsKt.getLastIndex(getSections());
        if (!z) {
            sectionTitle.setText(getString(R.string.alert_i));
            sectionTitle.setTextColor(ContextCompat.getColor(testBaseActivitySSCPattern, android.R.color.holo_red_light));
        } else {
            sectionTitle.setText(getString(R.string.confirm_i));
            sectionTitle.setTextColor(ContextCompat.getColor(testBaseActivitySSCPattern, R.color.green2));
        }
        if (!z) {
            string = getString(R.string.do_you_want_to_switch_the_next_new);
        } else {
            string = getString(R.string.this_is_the_last_section_do_you_want_to_submit_the_test);
        }
        sectionSubTitle.setText(string);
        btnNoSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnYesSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.TestBaseActivitySSCPattern$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestBaseActivitySSCPattern.sectionForceSwitchDialog$lambda$100(dialog, z, this, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sectionForceSwitchDialog$lambda$100(Dialog dialog, boolean z, TestBaseActivitySSCPattern testBaseActivitySSCPattern, View view) {
        dialog.dismiss();
        if (!z) {
            testBaseActivitySSCPattern.moveToNextSection();
        } else {
            testBaseActivitySSCPattern.showSubmitDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSectionTimeOver() {
        SSCTestSection sSCTestSection;
        Long l;
        if (!this.sectionSwitchAllowed && (sSCTestSection = (SSCTestSection) CollectionsKt.getOrNull(getSections(), getCurrentSectionIndex())) != null && (l = this.sectionDurationMap.get(sSCTestSection.getId())) != null) {
            if (SystemClock.elapsedRealtime() - this.sectionStartElapsedRealtime >= l.longValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean canAttemptQuestionInSection(SSCQuestion q) {
        Object next;
        int i;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(q, "q");
        Iterator<T> it = getSections().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((SSCTestSection) next).getId(), q.getSectionId())) {
                break;
            }
        }
        SSCTestSection sSCTestSection = (SSCTestSection) next;
        if (sSCTestSection == null) {
            return true;
        }
        String totalNoOfAttempts = sSCTestSection.getTotalNoOfAttempts();
        int iIntValue = (totalNoOfAttempts == null || (intOrNull = StringsKt.toIntOrNull(totalNoOfAttempts)) == null) ? 0 : intOrNull.intValue();
        if (iIntValue <= 0) {
            return true;
        }
        List<SSCQuestion> list = this.allQuestions;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            i = 0;
            for (SSCQuestion sSCQuestion : list) {
                if (Intrinsics.areEqual(sSCQuestion.getSectionId(), q.getSectionId()) && sSCQuestion.getOriginal().isanswer() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (q.getOriginal().isanswer() || i < iIntValue) {
            return true;
        }
        Toast.makeText(this, "You can attempt only " + iIntValue + " questions", 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldOpenSubmissionScreen() {
        String str = this.attemptOrReAttempt;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptOrReAttempt");
            str = null;
        }
        return StringsKt.equals(str, Const.ATTEMPT, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldShowSubmitLoaderText() {
        if (!shouldSubmitViaS3()) {
            return false;
        }
        String str = this.attemptOrReAttempt;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attemptOrReAttempt");
            str = null;
        }
        return StringsKt.equals(str, Const.ATTEMPT, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSectionSwitchButtonVisibility() {
        boolean z = getCurrentSectionIndex() >= CollectionsKt.getLastIndex(getSections());
        ActivityTestBaseSscpatternBinding activityTestBaseSscpatternBinding = this.binding;
        if (activityTestBaseSscpatternBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestBaseSscpatternBinding = null;
        }
        activityTestBaseSscpatternBinding.includeDrawerContent.btnSectionSwitch.setVisibility((this.sectionSwitchAllowed || z) ? 8 : 0);
    }
}
