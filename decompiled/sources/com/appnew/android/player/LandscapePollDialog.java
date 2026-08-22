package com.appnew.android.player;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.PlayerPojo.Polldata;
import com.appnew.android.Model.PollLeaderboard;
import com.appnew.android.Model.SendUserData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: LandscapePollDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010û\u0001\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020oH\u0007J<\u0010þ\u0001\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020o2'\u0010ÿ\u0001\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u0081\u00020\u0080\u0002j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u0081\u0002`\u0082\u0002H\u0007J%\u0010\u0083\u0002\u001a\u00030ü\u00012\u000f\u0010\u0084\u0002\u001a\n\u0012\u0005\u0012\u00030\u0086\u00020\u0085\u00022\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002H\u0007J\u001d\u0010\u0089\u0002\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020o2\b\u0010\u008a\u0002\u001a\u00030\u0088\u0002H\u0007J\u0015\u0010\u008b\u0002\u001a\u00030ü\u00012\t\u0010\u008c\u0002\u001a\u0004\u0018\u00010\rH\u0007J\u0011\u0010\u008d\u0002\u001a\u00030ü\u00012\u0007\u0010\u008c\u0002\u001a\u00020\rJ\u0013\u0010\u008e\u0002\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020oH\u0007J<\u0010\u008f\u0002\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020o2'\u0010ÿ\u0001\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u0081\u00020\u0080\u0002j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u0081\u0002`\u0082\u0002H\u0007J\u0013\u0010\u0090\u0002\u001a\u00030ü\u00012\u0007\u0010\u0091\u0002\u001a\u00020\u0005H\u0002J\u0013\u0010\u0092\u0002\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020oH\u0002J\u0013\u0010\u0093\u0002\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020oH\u0007J\u0010\u0010\u0094\u0002\u001a\u00020\u00052\u0007\u0010\u0095\u0002\u001a\u00020\u0005J\u0010\u0010\u0096\u0002\u001a\u00020\u00052\u0007\u0010ã\u0001\u001a\u00020\"J\u0013\u0010\u0097\u0002\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020oH\u0007J\u0013\u0010\u0098\u0002\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020oH\u0007J%\u0010\u0099\u0002\u001a\u00030ü\u00012\u000f\u0010\u009a\u0002\u001a\n\u0012\u0005\u0012\u00030\u0086\u00020\u0085\u00022\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002H\u0007J9\u0010\u009b\u0002\u001a\u00030ü\u00012\b\u0010\u009c\u0002\u001a\u00030\u009d\u00022\b\u0010\u009e\u0002\u001a\u00030À\u00012\u0007\u0010\u009f\u0002\u001a\u00020W2\u0007\u0010 \u0002\u001a\u00020W2\t\u0010¡\u0002\u001a\u0004\u0018\u00010\u0005J9\u0010¢\u0002\u001a\u00030ü\u00012\b\u0010\u009c\u0002\u001a\u00030\u009d\u00022\b\u0010\u009e\u0002\u001a\u00030À\u00012\u0007\u0010\u009f\u0002\u001a\u00020W2\u0007\u0010 \u0002\u001a\u00020W2\t\u0010¡\u0002\u001a\u0004\u0018\u00010\u0005J\u0013\u0010£\u0002\u001a\u00030ü\u00012\u0007\u0010ý\u0001\u001a\u00020oH\u0007J\b\u0010¤\u0002\u001a\u00030ü\u0001J\b\u0010¥\u0002\u001a\u00030ü\u0001J\u001a\u0010¦\u0002\u001a\u00030ü\u00012\u0007\u0010§\u0002\u001a\u0002062\u0007\u0010¨\u0002\u001a\u000206J2\u0010©\u0002\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010ª\u00022\u0007\u0010«\u0002\u001a\u00020\u00052\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u00052\b\u0010\u00ad\u0002\u001a\u00030®\u0002H\u0016J2\u0010¯\u0002\u001a\u00030ü\u00012\b\u0010°\u0002\u001a\u00030±\u00022\u0007\u0010«\u0002\u001a\u00020\u00052\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u00052\b\u0010²\u0002\u001a\u00030\u0088\u0002H\u0017J)\u0010³\u0002\u001a\u00030ü\u00012\t\u0010°\u0002\u001a\u0004\u0018\u00010\u00052\u0007\u0010«\u0002\u001a\u00020\u00052\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010´\u0002\u001a\u00030\u0088\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010*R\u001a\u00102\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001c\u0010D\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\u001c\u0010G\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010>\"\u0004\bI\u0010@R\u001c\u0010J\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\u001c\u0010M\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010>\"\u0004\bO\u0010@R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010Y\"\u0004\b^\u0010[R\u001c\u0010_\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010Y\"\u0004\ba\u0010[R\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010h\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010e\"\u0004\bj\u0010gR\u001c\u0010k\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010e\"\u0004\bm\u0010gR\u001a\u0010n\u001a\u00020oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010S\"\u0004\bv\u0010UR\u001c\u0010w\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010S\"\u0004\by\u0010UR\u001c\u0010z\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010S\"\u0004\b|\u0010UR\u001c\u0010}\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010S\"\u0004\b\u007f\u0010UR\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010Y\"\u0005\b\u0082\u0001\u0010[R\u001f\u0010\u0083\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010Y\"\u0005\b\u0085\u0001\u0010[R\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010Y\"\u0005\b\u0088\u0001\u0010[R\u001f\u0010\u0089\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010Y\"\u0005\b\u008b\u0001\u0010[R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u008f\u0001\"\u0006\b\u0094\u0001\u0010\u0091\u0001R\"\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u008f\u0001\"\u0006\b\u0097\u0001\u0010\u0091\u0001R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u008f\u0001\"\u0006\b\u009a\u0001\u0010\u0091\u0001R\u001f\u0010\u009b\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010Y\"\u0005\b\u009d\u0001\u0010[R\u001f\u0010\u009e\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010Y\"\u0005\b \u0001\u0010[R\u001f\u0010¡\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010Y\"\u0005\b£\u0001\u0010[R\u001f\u0010¤\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010Y\"\u0005\b¦\u0001\u0010[R\u001f\u0010§\u0001\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010>\"\u0005\b©\u0001\u0010@R\u001f\u0010ª\u0001\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010>\"\u0005\b¬\u0001\u0010@R\u001f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010>\"\u0005\b¯\u0001\u0010@R\u001f\u0010°\u0001\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010>\"\u0005\b²\u0001\u0010@R\u001f\u0010³\u0001\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u00108\"\u0005\bµ\u0001\u0010:R\u001f\u0010¶\u0001\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u00108\"\u0005\b¸\u0001\u0010:R\u001f\u0010¹\u0001\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u00108\"\u0005\b»\u0001\u0010:R\u001f\u0010¼\u0001\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u00108\"\u0005\b¾\u0001\u0010:R\"\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R\"\u0010Å\u0001\u001a\u0005\u0018\u00010À\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Â\u0001\"\u0006\bÇ\u0001\u0010Ä\u0001R\"\u0010È\u0001\u001a\u0005\u0018\u00010À\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÉ\u0001\u0010Â\u0001\"\u0006\bÊ\u0001\u0010Ä\u0001R\u001f\u0010Ë\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010Y\"\u0005\bÍ\u0001\u0010[R\u001f\u0010Î\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010Y\"\u0005\bÐ\u0001\u0010[R\u001f\u0010Ñ\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010Y\"\u0005\bÓ\u0001\u0010[R\u001f\u0010Ô\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0001\u0010Y\"\u0005\bÖ\u0001\u0010[R\u001f\u0010×\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0001\u0010Y\"\u0005\bÙ\u0001\u0010[R\u001f\u0010Ú\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÛ\u0001\u0010Y\"\u0005\bÜ\u0001\u0010[R\"\u0010Ý\u0001\u001a\u0005\u0018\u00010Þ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R\u001f\u0010ã\u0001\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bä\u0001\u0010Y\"\u0005\bå\u0001\u0010[R\u001f\u0010æ\u0001\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bç\u0001\u0010e\"\u0005\bè\u0001\u0010gR\u001f\u0010é\u0001\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bê\u0001\u00108\"\u0005\bë\u0001\u0010:R\u001f\u0010ì\u0001\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bí\u0001\u0010S\"\u0005\bî\u0001\u0010UR\u001f\u0010ï\u0001\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bð\u0001\u0010S\"\u0005\bñ\u0001\u0010UR\u001f\u0010ò\u0001\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bó\u0001\u00108\"\u0005\bô\u0001\u0010:R\u001f\u0010õ\u0001\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bö\u0001\u0010e\"\u0005\b÷\u0001\u0010gR\u001f\u0010ø\u0001\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bù\u0001\u0010e\"\u0005\bú\u0001\u0010g¨\u0006µ\u0002"}, d2 = {"Lcom/appnew/android/player/LandscapePollDialog;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "activity", "Landroid/app/Activity;", "islive", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "getIslive", "()Ljava/lang/String;", "dialogAttempt", "Landroid/app/Dialog;", "getDialogAttempt", "()Landroid/app/Dialog;", "setDialogAttempt", "(Landroid/app/Dialog;)V", "dialogResult", "getDialogResult", "setDialogResult", "dialogLeaderboard", "getDialogLeaderboard", "setDialogLeaderboard", "dialogIndicator", "getDialogIndicator", "setDialogIndicator", "timer", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "setTimer", "(Landroid/os/CountDownTimer;)V", "mLastClickTime", "", "getMLastClickTime", "()J", "setMLastClickTime", "(J)V", "pollKey", "getPollKey", "setPollKey", "(Ljava/lang/String;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "select", "getSelect", "setSelect", "timerr", "getTimerr", "setTimerr", "outside", "Landroid/view/View;", "getOutside", "()Landroid/view/View;", "setOutside", "(Landroid/view/View;)V", "mainlayout", "Landroid/widget/RelativeLayout;", "getMainlayout", "()Landroid/widget/RelativeLayout;", "setMainlayout", "(Landroid/widget/RelativeLayout;)V", "pollRL", "getPollRL", "setPollRL", "leaderboardRL", "getLeaderboardRL", "setLeaderboardRL", "pollIndicatorRL", "getPollIndicatorRL", "setPollIndicatorRL", "pollDrag", "getPollDrag", "setPollDrag", "leaderboardDrag", "getLeaderboardDrag", "setLeaderboardDrag", "ivClose", "Landroid/widget/ImageView;", "getIvClose", "()Landroid/widget/ImageView;", "setIvClose", "(Landroid/widget/ImageView;)V", "pollTime", "Landroid/widget/TextView;", "getPollTime", "()Landroid/widget/TextView;", "setPollTime", "(Landroid/widget/TextView;)V", "txtQues", "getTxtQues", "setTxtQues", "pollTypeTxt", "getPollTypeTxt", "setPollTypeTxt", "submit", "Landroid/widget/Button;", "getSubmit", "()Landroid/widget/Button;", "setSubmit", "(Landroid/widget/Button;)V", "resultBtn", "getResultBtn", "setResultBtn", "leaderBoardBtn", "getLeaderBoardBtn", "setLeaderBoardBtn", "pollDataNew", "Lcom/appnew/android/Model/PlayerPojo/Polldata;", "getPollDataNew", "()Lcom/appnew/android/Model/PlayerPojo/Polldata;", "setPollDataNew", "(Lcom/appnew/android/Model/PlayerPojo/Polldata;)V", "radioButton1", "getRadioButton1", "setRadioButton1", "radioButton2", "getRadioButton2", "setRadioButton2", "radioButton3", "getRadioButton3", "setRadioButton3", "radioButton4", "getRadioButton4", "setRadioButton4", "option1", "getOption1", "setOption1", "option2", "getOption2", "setOption2", "option3", "getOption3", "setOption3", "option4", "getOption4", "setOption4", "progress1", "Landroid/widget/ProgressBar;", "getProgress1", "()Landroid/widget/ProgressBar;", "setProgress1", "(Landroid/widget/ProgressBar;)V", "progress2", "getProgress2", "setProgress2", "progress3", "getProgress3", "setProgress3", "progress4", "getProgress4", "setProgress4", "percentage1", "getPercentage1", "setPercentage1", "percentage2", "getPercentage2", "setPercentage2", "percentage3", "getPercentage3", "setPercentage3", "percentage4", "getPercentage4", "setPercentage4", "option1Layout", "getOption1Layout", "setOption1Layout", "option2Layout", "getOption2Layout", "setOption2Layout", "option3Layout", "getOption3Layout", "setOption3Layout", "option4Layout", "getOption4Layout", "setOption4Layout", "typeA", "getTypeA", "setTypeA", "typeB", "getTypeB", "setTypeB", "typeC", "getTypeC", "setTypeC", "typeD", "getTypeD", "setTypeD", "cardView2", "Landroidx/cardview/widget/CardView;", "getCardView2", "()Landroidx/cardview/widget/CardView;", "setCardView2", "(Landroidx/cardview/widget/CardView;)V", "cardView1", "getCardView1", "setCardView1", "cardView3", "getCardView3", "setCardView3", "student2", "getStudent2", "setStudent2", "student1", "getStudent1", "setStudent1", "student3", "getStudent3", "setStudent3", "studentTwo", "getStudentTwo", "setStudentTwo", "studentOne", "getStudentOne", "setStudentOne", "studentThree", "getStudentThree", "setStudentThree", "recyclerViewRank", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewRank", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewRank", "(Landroidx/recyclerview/widget/RecyclerView;)V", "time", "getTime", "setTime", "resultBtnTwo", "getResultBtnTwo", "setResultBtnTwo", "outsideIndicator", "getOutsideIndicator", "setOutsideIndicator", "iconIV", "getIconIV", "setIconIV", "ivCloseIndic", "getIvCloseIndic", "setIvCloseIndic", "redDot", "getRedDot", "setRedDot", "btnResult", "getBtnResult", "setBtnResult", "btnLeaderboard", "getBtnLeaderboard", "setBtnLeaderboard", "showPollAttempt", "", "polldata", "showPollResult", "servaydata", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "showPollLeaderboard", "pollLeaderboardList", "", "Lcom/appnew/android/Model/PollLeaderboard;", "isForAll", "", "showPollIndicator", "isShow", "initViews", "dialog", "hideDialogStatusBar", "pollAttempt", "SetServeyresult", "showForZeroResultsNextToppes", Const.ANSWER, "showpollresultForNextToppers", "notifyButton", "getdate", "timestamp", "concerter", "pollResultAPI", "pollLeaderboardAPI", "pollLeaderboard", "leaderboardList", "selectUserCard", "context", "Landroid/content/Context;", "cardView", "student", "studentText", "name", "unSelectUserCard", "pollIndicator", "dismissPreviousDialog", "dismissLandscapeDialog", "setupDraggableDialog", "dragSurfaceView", "viewToMove", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "isLiveClass", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapePollDialog implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private final Activity activity;
    private Button btnLeaderboard;
    private Button btnResult;
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private Dialog dialogAttempt;
    private Dialog dialogIndicator;
    private Dialog dialogLeaderboard;
    private Dialog dialogResult;
    private ImageView iconIV;
    private final String islive;
    private ImageView ivClose;
    private ImageView ivCloseIndic;
    private Button leaderBoardBtn;
    private RelativeLayout leaderboardDrag;
    private RelativeLayout leaderboardRL;
    private long mLastClickTime;
    private RelativeLayout mainlayout;
    private final NetworkCall networkCall;
    private TextView option1;
    private RelativeLayout option1Layout;
    private TextView option2;
    private RelativeLayout option2Layout;
    private TextView option3;
    private RelativeLayout option3Layout;
    private TextView option4;
    private RelativeLayout option4Layout;
    private View outside;
    private View outsideIndicator;
    private TextView percentage1;
    private TextView percentage2;
    private TextView percentage3;
    private TextView percentage4;
    private Polldata pollDataNew;
    private RelativeLayout pollDrag;
    private RelativeLayout pollIndicatorRL;
    private String pollKey;
    private RelativeLayout pollRL;
    private TextView pollTime;
    private TextView pollTypeTxt;
    private ProgressBar progress1;
    private ProgressBar progress2;
    private ProgressBar progress3;
    private ProgressBar progress4;
    private ImageView radioButton1;
    private ImageView radioButton2;
    private ImageView radioButton3;
    private ImageView radioButton4;
    private RecyclerView recyclerViewRank;
    private View redDot;
    private Button resultBtn;
    private Button resultBtnTwo;
    private String select;
    private TextView student1;
    private TextView student2;
    private TextView student3;
    private TextView studentOne;
    private TextView studentThree;
    private TextView studentTwo;
    private Button submit;
    private TextView time;
    private CountDownTimer timer;
    private long timerr;
    private TextView txtQues;
    private View typeA;
    private View typeB;
    private View typeC;
    private View typeD;

    public final boolean isLiveClass() {
        return true;
    }

    public LandscapePollDialog(Activity activity, String islive) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(islive, "islive");
        this.activity = activity;
        this.islive = islive;
        this.pollKey = "";
        this.select = "";
        this.pollDataNew = new Polldata();
        this.networkCall = new NetworkCall(this, activity);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final String getIslive() {
        return this.islive;
    }

    public final Dialog getDialogAttempt() {
        return this.dialogAttempt;
    }

    public final void setDialogAttempt(Dialog dialog) {
        this.dialogAttempt = dialog;
    }

    public final Dialog getDialogResult() {
        return this.dialogResult;
    }

    public final void setDialogResult(Dialog dialog) {
        this.dialogResult = dialog;
    }

    public final Dialog getDialogLeaderboard() {
        return this.dialogLeaderboard;
    }

    public final void setDialogLeaderboard(Dialog dialog) {
        this.dialogLeaderboard = dialog;
    }

    public final Dialog getDialogIndicator() {
        return this.dialogIndicator;
    }

    public final void setDialogIndicator(Dialog dialog) {
        this.dialogIndicator = dialog;
    }

    public final CountDownTimer getTimer() {
        return this.timer;
    }

    public final void setTimer(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    public final long getMLastClickTime() {
        return this.mLastClickTime;
    }

    public final void setMLastClickTime(long j) {
        this.mLastClickTime = j;
    }

    public final String getPollKey() {
        return this.pollKey;
    }

    public final void setPollKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pollKey = str;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final String getSelect() {
        return this.select;
    }

    public final void setSelect(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.select = str;
    }

    public final long getTimerr() {
        return this.timerr;
    }

    public final void setTimerr(long j) {
        this.timerr = j;
    }

    public final View getOutside() {
        return this.outside;
    }

    public final void setOutside(View view) {
        this.outside = view;
    }

    public final RelativeLayout getMainlayout() {
        return this.mainlayout;
    }

    public final void setMainlayout(RelativeLayout relativeLayout) {
        this.mainlayout = relativeLayout;
    }

    public final RelativeLayout getPollRL() {
        return this.pollRL;
    }

    public final void setPollRL(RelativeLayout relativeLayout) {
        this.pollRL = relativeLayout;
    }

    public final RelativeLayout getLeaderboardRL() {
        return this.leaderboardRL;
    }

    public final void setLeaderboardRL(RelativeLayout relativeLayout) {
        this.leaderboardRL = relativeLayout;
    }

    public final RelativeLayout getPollIndicatorRL() {
        return this.pollIndicatorRL;
    }

    public final void setPollIndicatorRL(RelativeLayout relativeLayout) {
        this.pollIndicatorRL = relativeLayout;
    }

    public final RelativeLayout getPollDrag() {
        return this.pollDrag;
    }

    public final void setPollDrag(RelativeLayout relativeLayout) {
        this.pollDrag = relativeLayout;
    }

    public final RelativeLayout getLeaderboardDrag() {
        return this.leaderboardDrag;
    }

    public final void setLeaderboardDrag(RelativeLayout relativeLayout) {
        this.leaderboardDrag = relativeLayout;
    }

    public final ImageView getIvClose() {
        return this.ivClose;
    }

    public final void setIvClose(ImageView imageView) {
        this.ivClose = imageView;
    }

    public final TextView getPollTime() {
        return this.pollTime;
    }

    public final void setPollTime(TextView textView) {
        this.pollTime = textView;
    }

    public final TextView getTxtQues() {
        return this.txtQues;
    }

    public final void setTxtQues(TextView textView) {
        this.txtQues = textView;
    }

    public final TextView getPollTypeTxt() {
        return this.pollTypeTxt;
    }

    public final void setPollTypeTxt(TextView textView) {
        this.pollTypeTxt = textView;
    }

    public final Button getSubmit() {
        return this.submit;
    }

    public final void setSubmit(Button button) {
        this.submit = button;
    }

    public final Button getResultBtn() {
        return this.resultBtn;
    }

    public final void setResultBtn(Button button) {
        this.resultBtn = button;
    }

    public final Button getLeaderBoardBtn() {
        return this.leaderBoardBtn;
    }

    public final void setLeaderBoardBtn(Button button) {
        this.leaderBoardBtn = button;
    }

    public final Polldata getPollDataNew() {
        return this.pollDataNew;
    }

    public final void setPollDataNew(Polldata polldata) {
        Intrinsics.checkNotNullParameter(polldata, "<set-?>");
        this.pollDataNew = polldata;
    }

    public final ImageView getRadioButton1() {
        return this.radioButton1;
    }

    public final void setRadioButton1(ImageView imageView) {
        this.radioButton1 = imageView;
    }

    public final ImageView getRadioButton2() {
        return this.radioButton2;
    }

    public final void setRadioButton2(ImageView imageView) {
        this.radioButton2 = imageView;
    }

    public final ImageView getRadioButton3() {
        return this.radioButton3;
    }

    public final void setRadioButton3(ImageView imageView) {
        this.radioButton3 = imageView;
    }

    public final ImageView getRadioButton4() {
        return this.radioButton4;
    }

    public final void setRadioButton4(ImageView imageView) {
        this.radioButton4 = imageView;
    }

    public final TextView getOption1() {
        return this.option1;
    }

    public final void setOption1(TextView textView) {
        this.option1 = textView;
    }

    public final TextView getOption2() {
        return this.option2;
    }

    public final void setOption2(TextView textView) {
        this.option2 = textView;
    }

    public final TextView getOption3() {
        return this.option3;
    }

    public final void setOption3(TextView textView) {
        this.option3 = textView;
    }

    public final TextView getOption4() {
        return this.option4;
    }

    public final void setOption4(TextView textView) {
        this.option4 = textView;
    }

    public final ProgressBar getProgress1() {
        return this.progress1;
    }

    public final void setProgress1(ProgressBar progressBar) {
        this.progress1 = progressBar;
    }

    public final ProgressBar getProgress2() {
        return this.progress2;
    }

    public final void setProgress2(ProgressBar progressBar) {
        this.progress2 = progressBar;
    }

    public final ProgressBar getProgress3() {
        return this.progress3;
    }

    public final void setProgress3(ProgressBar progressBar) {
        this.progress3 = progressBar;
    }

    public final ProgressBar getProgress4() {
        return this.progress4;
    }

    public final void setProgress4(ProgressBar progressBar) {
        this.progress4 = progressBar;
    }

    public final TextView getPercentage1() {
        return this.percentage1;
    }

    public final void setPercentage1(TextView textView) {
        this.percentage1 = textView;
    }

    public final TextView getPercentage2() {
        return this.percentage2;
    }

    public final void setPercentage2(TextView textView) {
        this.percentage2 = textView;
    }

    public final TextView getPercentage3() {
        return this.percentage3;
    }

    public final void setPercentage3(TextView textView) {
        this.percentage3 = textView;
    }

    public final TextView getPercentage4() {
        return this.percentage4;
    }

    public final void setPercentage4(TextView textView) {
        this.percentage4 = textView;
    }

    public final RelativeLayout getOption1Layout() {
        return this.option1Layout;
    }

    public final void setOption1Layout(RelativeLayout relativeLayout) {
        this.option1Layout = relativeLayout;
    }

    public final RelativeLayout getOption2Layout() {
        return this.option2Layout;
    }

    public final void setOption2Layout(RelativeLayout relativeLayout) {
        this.option2Layout = relativeLayout;
    }

    public final RelativeLayout getOption3Layout() {
        return this.option3Layout;
    }

    public final void setOption3Layout(RelativeLayout relativeLayout) {
        this.option3Layout = relativeLayout;
    }

    public final RelativeLayout getOption4Layout() {
        return this.option4Layout;
    }

    public final void setOption4Layout(RelativeLayout relativeLayout) {
        this.option4Layout = relativeLayout;
    }

    public final View getTypeA() {
        return this.typeA;
    }

    public final void setTypeA(View view) {
        this.typeA = view;
    }

    public final View getTypeB() {
        return this.typeB;
    }

    public final void setTypeB(View view) {
        this.typeB = view;
    }

    public final View getTypeC() {
        return this.typeC;
    }

    public final void setTypeC(View view) {
        this.typeC = view;
    }

    public final View getTypeD() {
        return this.typeD;
    }

    public final void setTypeD(View view) {
        this.typeD = view;
    }

    public final CardView getCardView2() {
        return this.cardView2;
    }

    public final void setCardView2(CardView cardView) {
        this.cardView2 = cardView;
    }

    public final CardView getCardView1() {
        return this.cardView1;
    }

    public final void setCardView1(CardView cardView) {
        this.cardView1 = cardView;
    }

    public final CardView getCardView3() {
        return this.cardView3;
    }

    public final void setCardView3(CardView cardView) {
        this.cardView3 = cardView;
    }

    public final TextView getStudent2() {
        return this.student2;
    }

    public final void setStudent2(TextView textView) {
        this.student2 = textView;
    }

    public final TextView getStudent1() {
        return this.student1;
    }

    public final void setStudent1(TextView textView) {
        this.student1 = textView;
    }

    public final TextView getStudent3() {
        return this.student3;
    }

    public final void setStudent3(TextView textView) {
        this.student3 = textView;
    }

    public final TextView getStudentTwo() {
        return this.studentTwo;
    }

    public final void setStudentTwo(TextView textView) {
        this.studentTwo = textView;
    }

    public final TextView getStudentOne() {
        return this.studentOne;
    }

    public final void setStudentOne(TextView textView) {
        this.studentOne = textView;
    }

    public final TextView getStudentThree() {
        return this.studentThree;
    }

    public final void setStudentThree(TextView textView) {
        this.studentThree = textView;
    }

    public final RecyclerView getRecyclerViewRank() {
        return this.recyclerViewRank;
    }

    public final void setRecyclerViewRank(RecyclerView recyclerView) {
        this.recyclerViewRank = recyclerView;
    }

    public final TextView getTime() {
        return this.time;
    }

    public final void setTime(TextView textView) {
        this.time = textView;
    }

    public final Button getResultBtnTwo() {
        return this.resultBtnTwo;
    }

    public final void setResultBtnTwo(Button button) {
        this.resultBtnTwo = button;
    }

    public final View getOutsideIndicator() {
        return this.outsideIndicator;
    }

    public final void setOutsideIndicator(View view) {
        this.outsideIndicator = view;
    }

    public final ImageView getIconIV() {
        return this.iconIV;
    }

    public final void setIconIV(ImageView imageView) {
        this.iconIV = imageView;
    }

    public final ImageView getIvCloseIndic() {
        return this.ivCloseIndic;
    }

    public final void setIvCloseIndic(ImageView imageView) {
        this.ivCloseIndic = imageView;
    }

    public final View getRedDot() {
        return this.redDot;
    }

    public final void setRedDot(View view) {
        this.redDot = view;
    }

    public final Button getBtnResult() {
        return this.btnResult;
    }

    public final void setBtnResult(Button button) {
        this.btnResult = button;
    }

    public final Button getBtnLeaderboard() {
        return this.btnLeaderboard;
    }

    public final void setBtnLeaderboard(Button button) {
        this.btnLeaderboard = button;
    }

    public final void showPollAttempt(Polldata polldata) {
        Window window;
        Window window2;
        Window window3;
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        try {
            if (isLiveClass() && Helper.isLandscapePoll()) {
                if (this.activity.getResources().getConfiguration().orientation == 2) {
                    this.pollDataNew = polldata;
                    dismissLandscapeDialog();
                    Dialog dialog = new Dialog(this.activity, R.style.Theme.Translucent.NoTitleBar);
                    this.dialogAttempt = dialog;
                    dialog.setContentView(com.eduteria.app.app.R.layout.dialog_poll_attempt);
                    Dialog dialog2 = this.dialogAttempt;
                    if (dialog2 != null && (window3 = dialog2.getWindow()) != null) {
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                    }
                    Dialog dialog3 = this.dialogAttempt;
                    if (dialog3 != null) {
                        dialog3.setCancelable(false);
                    }
                    Dialog dialog4 = this.dialogAttempt;
                    if (dialog4 != null) {
                        dialog4.setCanceledOnTouchOutside(false);
                    }
                    Dialog dialog5 = this.dialogAttempt;
                    WindowManager.LayoutParams attributes = (dialog5 == null || (window2 = dialog5.getWindow()) == null) ? null : window2.getAttributes();
                    if (attributes != null) {
                        attributes.width = -1;
                    }
                    if (attributes != null) {
                        attributes.height = -1;
                    }
                    if (attributes != null) {
                        attributes.gravity = 17;
                    }
                    Dialog dialog6 = this.dialogAttempt;
                    if (dialog6 != null && (window = dialog6.getWindow()) != null) {
                        window.setAttributes(attributes);
                    }
                    initViews(this.dialogAttempt);
                    ImageView imageView = this.ivClose;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.pollRL;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    RelativeLayout relativeLayout2 = this.leaderboardRL;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(8);
                    }
                    RelativeLayout relativeLayout3 = this.pollDrag;
                    Intrinsics.checkNotNull(relativeLayout3);
                    RelativeLayout relativeLayout4 = this.mainlayout;
                    Intrinsics.checkNotNull(relativeLayout4);
                    setupDraggableDialog(relativeLayout3, relativeLayout4);
                    pollAttempt(polldata);
                    ImageView imageView2 = this.ivClose;
                    if (imageView2 != null) {
                        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda11
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                LandscapePollDialog.showPollAttempt$lambda$1(this.f$0, view);
                            }
                        });
                    }
                    Dialog dialog7 = this.dialogAttempt;
                    if (dialog7 != null) {
                        dialog7.show();
                    }
                    Dialog dialog8 = this.dialogAttempt;
                    if (dialog8 != null) {
                        hideDialogStatusBar(dialog8);
                        return;
                    }
                    return;
                }
                dismissLandscapeDialog();
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "showPollAttempt: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPollAttempt$lambda$1(LandscapePollDialog landscapePollDialog, View view) {
        try {
            landscapePollDialog.dismissPreviousDialog();
            Polldata polldata = landscapePollDialog.pollDataNew;
            if (polldata != null) {
                landscapePollDialog.showPollIndicator(polldata, true);
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
    }

    public final void showPollResult(Polldata polldata, HashMap<String, Float> servaydata) {
        Window window;
        Window window2;
        Window window3;
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        Intrinsics.checkNotNullParameter(servaydata, "servaydata");
        try {
            if (isLiveClass() && Helper.isLandscapePoll()) {
                if (this.activity.getResources().getConfiguration().orientation == 2) {
                    this.pollDataNew = polldata;
                    dismissLandscapeDialog();
                    Dialog dialog = new Dialog(this.activity, R.style.Theme.Translucent.NoTitleBar);
                    this.dialogResult = dialog;
                    dialog.setContentView(com.eduteria.app.app.R.layout.dialog_poll_attempt);
                    Dialog dialog2 = this.dialogResult;
                    if (dialog2 != null && (window3 = dialog2.getWindow()) != null) {
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                    }
                    Dialog dialog3 = this.dialogResult;
                    if (dialog3 != null) {
                        dialog3.setCancelable(false);
                    }
                    Dialog dialog4 = this.dialogResult;
                    if (dialog4 != null) {
                        dialog4.setCanceledOnTouchOutside(false);
                    }
                    Dialog dialog5 = this.dialogResult;
                    WindowManager.LayoutParams attributes = (dialog5 == null || (window2 = dialog5.getWindow()) == null) ? null : window2.getAttributes();
                    if (attributes != null) {
                        attributes.width = -1;
                    }
                    if (attributes != null) {
                        attributes.height = -1;
                    }
                    if (attributes != null) {
                        attributes.gravity = 17;
                    }
                    Dialog dialog6 = this.dialogResult;
                    if (dialog6 != null && (window = dialog6.getWindow()) != null) {
                        window.setAttributes(attributes);
                    }
                    initViews(this.dialogResult);
                    ImageView imageView = this.ivClose;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.pollRL;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    RelativeLayout relativeLayout2 = this.leaderboardRL;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(8);
                    }
                    RelativeLayout relativeLayout3 = this.pollDrag;
                    Intrinsics.checkNotNull(relativeLayout3);
                    RelativeLayout relativeLayout4 = this.mainlayout;
                    Intrinsics.checkNotNull(relativeLayout4);
                    setupDraggableDialog(relativeLayout3, relativeLayout4);
                    SetServeyresult(polldata, servaydata);
                    ImageView imageView2 = this.ivClose;
                    if (imageView2 != null) {
                        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda8
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                LandscapePollDialog.showPollResult$lambda$4(this.f$0, view);
                            }
                        });
                    }
                    Dialog dialog7 = this.dialogResult;
                    if (dialog7 != null) {
                        dialog7.show();
                    }
                    Dialog dialog8 = this.dialogResult;
                    if (dialog8 != null) {
                        hideDialogStatusBar(dialog8);
                        return;
                    }
                    return;
                }
                dismissLandscapeDialog();
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "showPollResult: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPollResult$lambda$4(LandscapePollDialog landscapePollDialog, View view) {
        try {
            landscapePollDialog.dismissPreviousDialog();
            Polldata polldata = landscapePollDialog.pollDataNew;
            if (polldata != null) {
                landscapePollDialog.showPollIndicator(polldata, true);
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
    }

    public final void showPollLeaderboard(List<PollLeaderboard> pollLeaderboardList, boolean isForAll) {
        Window window;
        Window window2;
        Window window3;
        Intrinsics.checkNotNullParameter(pollLeaderboardList, "pollLeaderboardList");
        try {
            if (isLiveClass() && Helper.isLandscapePoll()) {
                if (this.activity.getResources().getConfiguration().orientation == 2) {
                    dismissLandscapeDialog();
                    Dialog dialog = new Dialog(this.activity, R.style.Theme.Translucent.NoTitleBar);
                    this.dialogLeaderboard = dialog;
                    dialog.setContentView(com.eduteria.app.app.R.layout.dialog_poll_attempt);
                    Dialog dialog2 = this.dialogLeaderboard;
                    if (dialog2 != null && (window3 = dialog2.getWindow()) != null) {
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                    }
                    Dialog dialog3 = this.dialogLeaderboard;
                    if (dialog3 != null) {
                        dialog3.setCancelable(false);
                    }
                    Dialog dialog4 = this.dialogLeaderboard;
                    if (dialog4 != null) {
                        dialog4.setCanceledOnTouchOutside(false);
                    }
                    Dialog dialog5 = this.dialogLeaderboard;
                    WindowManager.LayoutParams attributes = (dialog5 == null || (window2 = dialog5.getWindow()) == null) ? null : window2.getAttributes();
                    if (attributes != null) {
                        attributes.width = -1;
                    }
                    if (attributes != null) {
                        attributes.height = -1;
                    }
                    if (attributes != null) {
                        attributes.gravity = 17;
                    }
                    Dialog dialog6 = this.dialogLeaderboard;
                    if (dialog6 != null && (window = dialog6.getWindow()) != null) {
                        window.setAttributes(attributes);
                    }
                    initViews(this.dialogLeaderboard);
                    ImageView imageView = this.ivClose;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.pollRL;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                    RelativeLayout relativeLayout2 = this.leaderboardRL;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(0);
                    }
                    RelativeLayout relativeLayout3 = this.leaderboardDrag;
                    Intrinsics.checkNotNull(relativeLayout3);
                    RelativeLayout relativeLayout4 = this.mainlayout;
                    Intrinsics.checkNotNull(relativeLayout4);
                    setupDraggableDialog(relativeLayout3, relativeLayout4);
                    pollLeaderboard(pollLeaderboardList, isForAll);
                    ImageView imageView2 = this.ivClose;
                    if (imageView2 != null) {
                        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                LandscapePollDialog.showPollLeaderboard$lambda$7(this.f$0, view);
                            }
                        });
                    }
                    Dialog dialog7 = this.dialogLeaderboard;
                    if (dialog7 != null) {
                        dialog7.show();
                    }
                    Dialog dialog8 = this.dialogLeaderboard;
                    if (dialog8 != null) {
                        hideDialogStatusBar(dialog8);
                        return;
                    }
                    return;
                }
                dismissLandscapeDialog();
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "showPollLeaderboard: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPollLeaderboard$lambda$7(LandscapePollDialog landscapePollDialog, View view) {
        try {
            landscapePollDialog.dismissPreviousDialog();
            Polldata polldata = landscapePollDialog.pollDataNew;
            if (polldata != null) {
                landscapePollDialog.showPollIndicator(polldata, true);
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
    }

    public final void showPollIndicator(Polldata polldata, boolean isShow) {
        Dialog dialog;
        Dialog dialog2;
        Window window;
        Window window2;
        Window window3;
        Dialog dialog3;
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        try {
            if (isLiveClass() && Helper.isLandscapePoll()) {
                if (this.activity.getResources().getConfiguration().orientation != 2) {
                    dismissLandscapeDialog();
                    return;
                }
                if (isShow) {
                    Dialog dialog4 = this.dialogAttempt;
                    if ((dialog4 == null || dialog4 == null || !dialog4.isShowing()) && (((dialog = this.dialogResult) == null || dialog == null || !dialog.isShowing()) && ((dialog2 = this.dialogLeaderboard) == null || dialog2 == null || !dialog2.isShowing()))) {
                        Dialog dialog5 = this.dialogIndicator;
                        if (dialog5 != null && dialog5 != null && dialog5.isShowing() && (dialog3 = this.dialogIndicator) != null) {
                            dialog3.dismiss();
                        }
                        Dialog dialog6 = new Dialog(this.activity, R.style.Theme.Translucent.NoTitleBar);
                        this.dialogIndicator = dialog6;
                        dialog6.setContentView(com.eduteria.app.app.R.layout.dialog_poll_indicator);
                        Dialog dialog7 = this.dialogIndicator;
                        if (dialog7 != null && (window3 = dialog7.getWindow()) != null) {
                            window3.setBackgroundDrawable(new ColorDrawable(0));
                        }
                        Dialog dialog8 = this.dialogIndicator;
                        if (dialog8 != null) {
                            dialog8.setCancelable(true);
                        }
                        Dialog dialog9 = this.dialogIndicator;
                        if (dialog9 != null) {
                            dialog9.setCanceledOnTouchOutside(true);
                        }
                        Dialog dialog10 = this.dialogIndicator;
                        WindowManager.LayoutParams attributes = (dialog10 == null || (window2 = dialog10.getWindow()) == null) ? null : window2.getAttributes();
                        if (attributes != null) {
                            attributes.width = -1;
                        }
                        if (attributes != null) {
                            attributes.height = -1;
                        }
                        if (attributes != null) {
                            attributes.gravity = 17;
                        }
                        Dialog dialog11 = this.dialogIndicator;
                        if (dialog11 != null && (window = dialog11.getWindow()) != null) {
                            window.setAttributes(attributes);
                        }
                        Dialog dialog12 = this.dialogIndicator;
                        this.outsideIndicator = dialog12 != null ? dialog12.findViewById(com.eduteria.app.app.R.id.outer_touch_area) : null;
                        Dialog dialog13 = this.dialogIndicator;
                        this.pollIndicatorRL = dialog13 != null ? (RelativeLayout) dialog13.findViewById(com.eduteria.app.app.R.id.pollIndicatorRL) : null;
                        Dialog dialog14 = this.dialogIndicator;
                        this.iconIV = dialog14 != null ? (ImageView) dialog14.findViewById(com.eduteria.app.app.R.id.iconIV) : null;
                        RequestBuilder<GifDrawable> requestBuilderLoad = Glide.with(this.activity).asGif().load(Integer.valueOf(com.eduteria.app.app.R.drawable.poll_indicator_logo));
                        ImageView imageView = this.iconIV;
                        Intrinsics.checkNotNull(imageView);
                        requestBuilderLoad.into(imageView);
                        Dialog dialog15 = this.dialogIndicator;
                        this.redDot = dialog15 != null ? dialog15.findViewById(com.eduteria.app.app.R.id.redDot) : null;
                        Dialog dialog16 = this.dialogIndicator;
                        this.ivCloseIndic = dialog16 != null ? (ImageView) dialog16.findViewById(com.eduteria.app.app.R.id.ivCloseIndic) : null;
                        Dialog dialog17 = this.dialogIndicator;
                        this.btnResult = dialog17 != null ? (Button) dialog17.findViewById(com.eduteria.app.app.R.id.btnResult) : null;
                        Dialog dialog18 = this.dialogIndicator;
                        this.btnLeaderboard = dialog18 != null ? (Button) dialog18.findViewById(com.eduteria.app.app.R.id.btnLeaderboard) : null;
                        ImageView imageView2 = this.iconIV;
                        Intrinsics.checkNotNull(imageView2);
                        RelativeLayout relativeLayout = this.pollIndicatorRL;
                        Intrinsics.checkNotNull(relativeLayout);
                        setupDraggableDialog(imageView2, relativeLayout);
                        pollIndicator(polldata);
                        Dialog dialog19 = this.dialogIndicator;
                        if (dialog19 != null) {
                            dialog19.show();
                        }
                        Dialog dialog20 = this.dialogIndicator;
                        if (dialog20 != null) {
                            hideDialogStatusBar(dialog20);
                            return;
                        }
                        return;
                    }
                    this.pollDataNew = polldata;
                    return;
                }
                dismissLandscapeDialog();
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "showPollIndicator: " + e2.getMessage());
        }
    }

    public final void initViews(Dialog dialog) {
        if (dialog != null) {
            this.outside = dialog.findViewById(com.eduteria.app.app.R.id.outer_touch_area);
            this.mainlayout = (RelativeLayout) dialog.findViewById(com.eduteria.app.app.R.id.mainlayout);
            this.ivClose = (ImageView) dialog.findViewById(com.eduteria.app.app.R.id.ivClose);
            this.pollRL = (RelativeLayout) dialog.findViewById(com.eduteria.app.app.R.id.pollRL);
            this.leaderboardRL = (RelativeLayout) dialog.findViewById(com.eduteria.app.app.R.id.leaderboardRL);
            this.pollDrag = (RelativeLayout) dialog.findViewById(com.eduteria.app.app.R.id.pollDrag);
            this.leaderboardDrag = (RelativeLayout) dialog.findViewById(com.eduteria.app.app.R.id.leaderboardDrag);
            this.pollTime = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.pollTime);
            this.pollTypeTxt = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.pollTypeTxt);
            this.txtQues = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.txtQues);
            this.submit = (Button) dialog.findViewById(com.eduteria.app.app.R.id.submit);
            this.resultBtn = (Button) dialog.findViewById(com.eduteria.app.app.R.id.resultBtn);
            this.leaderBoardBtn = (Button) dialog.findViewById(com.eduteria.app.app.R.id.leaderBoardBtn);
            this.typeA = dialog.findViewById(com.eduteria.app.app.R.id.typeA);
            this.typeB = dialog.findViewById(com.eduteria.app.app.R.id.typeB);
            this.typeC = dialog.findViewById(com.eduteria.app.app.R.id.typeC);
            this.typeD = dialog.findViewById(com.eduteria.app.app.R.id.typeD);
            View view = this.typeA;
            this.radioButton1 = view != null ? (ImageView) view.findViewById(com.eduteria.app.app.R.id.radioButton1) : null;
            View view2 = this.typeA;
            this.option1 = view2 != null ? (TextView) view2.findViewById(com.eduteria.app.app.R.id.option1) : null;
            View view3 = this.typeA;
            this.progress1 = view3 != null ? (ProgressBar) view3.findViewById(com.eduteria.app.app.R.id.progress1) : null;
            View view4 = this.typeA;
            this.percentage1 = view4 != null ? (TextView) view4.findViewById(com.eduteria.app.app.R.id.percentage1) : null;
            View view5 = this.typeA;
            this.option1Layout = view5 != null ? (RelativeLayout) view5.findViewById(com.eduteria.app.app.R.id.option1Layout) : null;
            View view6 = this.typeB;
            this.radioButton2 = view6 != null ? (ImageView) view6.findViewById(com.eduteria.app.app.R.id.radioButton1) : null;
            View view7 = this.typeB;
            this.option2 = view7 != null ? (TextView) view7.findViewById(com.eduteria.app.app.R.id.option1) : null;
            View view8 = this.typeB;
            this.progress2 = view8 != null ? (ProgressBar) view8.findViewById(com.eduteria.app.app.R.id.progress1) : null;
            View view9 = this.typeB;
            this.percentage2 = view9 != null ? (TextView) view9.findViewById(com.eduteria.app.app.R.id.percentage1) : null;
            View view10 = this.typeB;
            this.option2Layout = view10 != null ? (RelativeLayout) view10.findViewById(com.eduteria.app.app.R.id.option1Layout) : null;
            View view11 = this.typeC;
            this.radioButton3 = view11 != null ? (ImageView) view11.findViewById(com.eduteria.app.app.R.id.radioButton1) : null;
            View view12 = this.typeC;
            this.option3 = view12 != null ? (TextView) view12.findViewById(com.eduteria.app.app.R.id.option1) : null;
            View view13 = this.typeC;
            this.progress3 = view13 != null ? (ProgressBar) view13.findViewById(com.eduteria.app.app.R.id.progress1) : null;
            View view14 = this.typeC;
            this.percentage3 = view14 != null ? (TextView) view14.findViewById(com.eduteria.app.app.R.id.percentage1) : null;
            View view15 = this.typeC;
            this.option3Layout = view15 != null ? (RelativeLayout) view15.findViewById(com.eduteria.app.app.R.id.option1Layout) : null;
            View view16 = this.typeD;
            this.radioButton4 = view16 != null ? (ImageView) view16.findViewById(com.eduteria.app.app.R.id.radioButton1) : null;
            View view17 = this.typeD;
            this.option4 = view17 != null ? (TextView) view17.findViewById(com.eduteria.app.app.R.id.option1) : null;
            View view18 = this.typeD;
            this.progress4 = view18 != null ? (ProgressBar) view18.findViewById(com.eduteria.app.app.R.id.progress1) : null;
            View view19 = this.typeD;
            this.percentage4 = view19 != null ? (TextView) view19.findViewById(com.eduteria.app.app.R.id.percentage1) : null;
            View view20 = this.typeD;
            this.option4Layout = view20 != null ? (RelativeLayout) view20.findViewById(com.eduteria.app.app.R.id.option1Layout) : null;
            this.resultBtnTwo = (Button) dialog.findViewById(com.eduteria.app.app.R.id.resultBtnTwo);
            this.time = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.time);
            this.cardView2 = (CardView) dialog.findViewById(com.eduteria.app.app.R.id.cardView2);
            this.cardView1 = (CardView) dialog.findViewById(com.eduteria.app.app.R.id.cardView1);
            this.cardView3 = (CardView) dialog.findViewById(com.eduteria.app.app.R.id.cardView3);
            this.student1 = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.student1);
            this.student2 = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.student2);
            this.student3 = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.student3);
            this.studentTwo = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.studentTwo);
            this.studentOne = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.studentOne);
            this.studentThree = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.studentThree);
            RecyclerView recyclerView = (RecyclerView) dialog.findViewById(com.eduteria.app.app.R.id.recyclerViewRank);
            this.recyclerViewRank = recyclerView;
            if (recyclerView != null) {
                recyclerView.setNestedScrollingEnabled(false);
            }
        }
    }

    public final void hideDialogStatusBar(Dialog dialog) {
        View decorView;
        WindowInsetsController insetsController;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.setDecorFitsSystemWindows(false);
                }
                Window window2 = dialog.getWindow();
                if (window2 == null || (insetsController = window2.getInsetsController()) == null) {
                    return;
                }
                insetsController.hide(WindowInsets.Type.statusBars());
                insetsController.setSystemBarsBehavior(2);
                return;
            }
            Window window3 = dialog.getWindow();
            if (window3 == null || (decorView = window3.getDecorView()) == null) {
                return;
            }
            decorView.setSystemUiVisibility(FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN);
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "hideDialogStatusBar: " + e2.getMessage());
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.appnew.android.player.LandscapePollDialog$pollAttempt$1] */
    public final void pollAttempt(final Polldata polldata) {
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        notifyButton(polldata);
        this.timerr = 0L;
        String validTill = polldata.getValidTill();
        Intrinsics.checkNotNullExpressionValue(validTill, "getValidTill(...)");
        long j = 1000;
        this.timerr = (Long.parseLong(validTill) - (System.currentTimeMillis() / j)) * j;
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = new CountDownTimer(this.timerr) { // from class: com.appnew.android.player.LandscapePollDialog.pollAttempt.1
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TextView pollTime = LandscapePollDialog.this.getPollTime();
                if (pollTime != null) {
                    pollTime.setText(LandscapePollDialog.this.concerter(millisUntilFinished));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                TextView pollTime = LandscapePollDialog.this.getPollTime();
                if (pollTime != null) {
                    pollTime.setText(LandscapePollDialog.this.getActivity().getResources().getString(com.eduteria.app.app.R.string.expired_));
                }
                Button submit = LandscapePollDialog.this.getSubmit();
                if (submit != null) {
                    submit.setVisibility(8);
                }
                LandscapePollDialog.this.dismissPreviousDialog();
                Polldata pollDataNew = LandscapePollDialog.this.getPollDataNew();
                if (pollDataNew != null) {
                    LandscapePollDialog.this.showPollIndicator(pollDataNew, true);
                }
            }
        }.start();
        RelativeLayout relativeLayout = this.option1Layout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LandscapePollDialog.pollAttempt$lambda$11(this.f$0, view);
                }
            });
        }
        RelativeLayout relativeLayout2 = this.option2Layout;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LandscapePollDialog.pollAttempt$lambda$12(this.f$0, view);
                }
            });
        }
        RelativeLayout relativeLayout3 = this.option3Layout;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LandscapePollDialog.pollAttempt$lambda$13(this.f$0, view);
                }
            });
        }
        RelativeLayout relativeLayout4 = this.option4Layout;
        if (relativeLayout4 != null) {
            relativeLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LandscapePollDialog.pollAttempt$lambda$14(this.f$0, view);
                }
            });
        }
        TextView textView = this.option1;
        if (textView != null) {
            textView.setText(polldata.getOption1());
        }
        TextView textView2 = this.option2;
        if (textView2 != null) {
            textView2.setText(polldata.getOption2());
        }
        TextView textView3 = this.option3;
        if (textView3 != null) {
            textView3.setText(polldata.getOption3());
        }
        TextView textView4 = this.option4;
        if (textView4 != null) {
            textView4.setText(polldata.getOption4());
        }
        if (StringsKt.equals(polldata.getOption1(), "", true)) {
            View view = this.typeA;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            View view2 = this.typeA;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        if (StringsKt.equals(polldata.getOption2(), "", true)) {
            View view3 = this.typeB;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        } else {
            View view4 = this.typeB;
            if (view4 != null) {
                view4.setVisibility(0);
            }
        }
        if (StringsKt.equals(polldata.getOption3(), "", true)) {
            View view5 = this.typeC;
            if (view5 != null) {
                view5.setVisibility(8);
            }
        } else {
            View view6 = this.typeC;
            if (view6 != null) {
                view6.setVisibility(0);
            }
        }
        if (StringsKt.equals(polldata.getOption4(), "", true)) {
            View view7 = this.typeD;
            if (view7 != null) {
                view7.setVisibility(8);
            }
        } else {
            View view8 = this.typeD;
            if (view8 != null) {
                view8.setVisibility(0);
            }
        }
        Button button = this.resultBtn;
        if (button != null) {
            button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LandscapePollDialog.pollAttempt$lambda$15(this.f$0, polldata);
                }
            }));
        }
        Button button2 = this.submit;
        if (button2 != null) {
            button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LandscapePollDialog.pollAttempt$lambda$17(this.f$0, polldata);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pollAttempt$lambda$11(LandscapePollDialog landscapePollDialog, View view) {
        try {
            landscapePollDialog.select = "1";
            ImageView imageView = landscapePollDialog.radioButton1;
            if (imageView != null) {
                imageView.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
            }
            ImageView imageView2 = landscapePollDialog.radioButton1;
            if (imageView2 != null) {
                imageView2.setColorFilter(ContextCompat.getColor(landscapePollDialog.activity, com.eduteria.app.app.R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
            }
            ImageView imageView3 = landscapePollDialog.radioButton2;
            if (imageView3 != null) {
                imageView3.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView4 = landscapePollDialog.radioButton2;
            if (imageView4 != null) {
                imageView4.clearColorFilter();
            }
            ImageView imageView5 = landscapePollDialog.radioButton3;
            if (imageView5 != null) {
                imageView5.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView6 = landscapePollDialog.radioButton3;
            if (imageView6 != null) {
                imageView6.clearColorFilter();
            }
            ImageView imageView7 = landscapePollDialog.radioButton4;
            if (imageView7 != null) {
                imageView7.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView8 = landscapePollDialog.radioButton4;
            if (imageView8 != null) {
                imageView8.clearColorFilter();
            }
            ProgressBar progressBar = landscapePollDialog.progress1;
            if (progressBar != null) {
                progressBar.setProgress(100);
            }
            ProgressBar progressBar2 = landscapePollDialog.progress2;
            if (progressBar2 != null) {
                progressBar2.setProgress(0);
            }
            ProgressBar progressBar3 = landscapePollDialog.progress3;
            if (progressBar3 != null) {
                progressBar3.setProgress(0);
            }
            ProgressBar progressBar4 = landscapePollDialog.progress4;
            if (progressBar4 != null) {
                progressBar4.setProgress(0);
            }
            ProgressBar progressBar5 = landscapePollDialog.progress1;
            if (progressBar5 != null) {
                progressBar5.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_app, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar6 = landscapePollDialog.progress2;
            if (progressBar6 != null) {
                progressBar6.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar7 = landscapePollDialog.progress3;
            if (progressBar7 != null) {
                progressBar7.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar8 = landscapePollDialog.progress4;
            if (progressBar8 != null) {
                progressBar8.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pollAttempt$lambda$12(LandscapePollDialog landscapePollDialog, View view) {
        try {
            landscapePollDialog.select = "2";
            ImageView imageView = landscapePollDialog.radioButton1;
            if (imageView != null) {
                imageView.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView2 = landscapePollDialog.radioButton1;
            if (imageView2 != null) {
                imageView2.clearColorFilter();
            }
            ImageView imageView3 = landscapePollDialog.radioButton2;
            if (imageView3 != null) {
                imageView3.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
            }
            ImageView imageView4 = landscapePollDialog.radioButton2;
            if (imageView4 != null) {
                imageView4.setColorFilter(ContextCompat.getColor(landscapePollDialog.activity, com.eduteria.app.app.R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
            }
            ImageView imageView5 = landscapePollDialog.radioButton3;
            if (imageView5 != null) {
                imageView5.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView6 = landscapePollDialog.radioButton3;
            if (imageView6 != null) {
                imageView6.clearColorFilter();
            }
            ImageView imageView7 = landscapePollDialog.radioButton4;
            if (imageView7 != null) {
                imageView7.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView8 = landscapePollDialog.radioButton4;
            if (imageView8 != null) {
                imageView8.clearColorFilter();
            }
            ProgressBar progressBar = landscapePollDialog.progress1;
            if (progressBar != null) {
                progressBar.setProgress(0);
            }
            ProgressBar progressBar2 = landscapePollDialog.progress2;
            if (progressBar2 != null) {
                progressBar2.setProgress(100);
            }
            ProgressBar progressBar3 = landscapePollDialog.progress3;
            if (progressBar3 != null) {
                progressBar3.setProgress(0);
            }
            ProgressBar progressBar4 = landscapePollDialog.progress4;
            if (progressBar4 != null) {
                progressBar4.setProgress(0);
            }
            ProgressBar progressBar5 = landscapePollDialog.progress1;
            if (progressBar5 != null) {
                progressBar5.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar6 = landscapePollDialog.progress2;
            if (progressBar6 != null) {
                progressBar6.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_app, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar7 = landscapePollDialog.progress3;
            if (progressBar7 != null) {
                progressBar7.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar8 = landscapePollDialog.progress4;
            if (progressBar8 != null) {
                progressBar8.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pollAttempt$lambda$13(LandscapePollDialog landscapePollDialog, View view) {
        try {
            landscapePollDialog.select = "3";
            ImageView imageView = landscapePollDialog.radioButton1;
            if (imageView != null) {
                imageView.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView2 = landscapePollDialog.radioButton1;
            if (imageView2 != null) {
                imageView2.clearColorFilter();
            }
            ImageView imageView3 = landscapePollDialog.radioButton2;
            if (imageView3 != null) {
                imageView3.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView4 = landscapePollDialog.radioButton2;
            if (imageView4 != null) {
                imageView4.clearColorFilter();
            }
            ImageView imageView5 = landscapePollDialog.radioButton3;
            if (imageView5 != null) {
                imageView5.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
            }
            ImageView imageView6 = landscapePollDialog.radioButton3;
            if (imageView6 != null) {
                imageView6.setColorFilter(ContextCompat.getColor(landscapePollDialog.activity, com.eduteria.app.app.R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
            }
            ImageView imageView7 = landscapePollDialog.radioButton4;
            if (imageView7 != null) {
                imageView7.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView8 = landscapePollDialog.radioButton4;
            if (imageView8 != null) {
                imageView8.clearColorFilter();
            }
            ProgressBar progressBar = landscapePollDialog.progress1;
            if (progressBar != null) {
                progressBar.setProgress(0);
            }
            ProgressBar progressBar2 = landscapePollDialog.progress2;
            if (progressBar2 != null) {
                progressBar2.setProgress(0);
            }
            ProgressBar progressBar3 = landscapePollDialog.progress3;
            if (progressBar3 != null) {
                progressBar3.setProgress(100);
            }
            ProgressBar progressBar4 = landscapePollDialog.progress4;
            if (progressBar4 != null) {
                progressBar4.setProgress(0);
            }
            ProgressBar progressBar5 = landscapePollDialog.progress1;
            if (progressBar5 != null) {
                progressBar5.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar6 = landscapePollDialog.progress2;
            if (progressBar6 != null) {
                progressBar6.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar7 = landscapePollDialog.progress3;
            if (progressBar7 != null) {
                progressBar7.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_app, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar8 = landscapePollDialog.progress4;
            if (progressBar8 != null) {
                progressBar8.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pollAttempt$lambda$14(LandscapePollDialog landscapePollDialog, View view) {
        try {
            landscapePollDialog.select = "4";
            ImageView imageView = landscapePollDialog.radioButton1;
            if (imageView != null) {
                imageView.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView2 = landscapePollDialog.radioButton1;
            if (imageView2 != null) {
                imageView2.clearColorFilter();
            }
            ImageView imageView3 = landscapePollDialog.radioButton2;
            if (imageView3 != null) {
                imageView3.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView4 = landscapePollDialog.radioButton2;
            if (imageView4 != null) {
                imageView4.clearColorFilter();
            }
            ImageView imageView5 = landscapePollDialog.radioButton3;
            if (imageView5 != null) {
                imageView5.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
            }
            ImageView imageView6 = landscapePollDialog.radioButton3;
            if (imageView6 != null) {
                imageView6.clearColorFilter();
            }
            ImageView imageView7 = landscapePollDialog.radioButton4;
            if (imageView7 != null) {
                imageView7.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
            }
            ImageView imageView8 = landscapePollDialog.radioButton4;
            if (imageView8 != null) {
                imageView8.setColorFilter(ContextCompat.getColor(landscapePollDialog.activity, com.eduteria.app.app.R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
            }
            ProgressBar progressBar = landscapePollDialog.progress1;
            if (progressBar != null) {
                progressBar.setProgress(0);
            }
            ProgressBar progressBar2 = landscapePollDialog.progress2;
            if (progressBar2 != null) {
                progressBar2.setProgress(0);
            }
            ProgressBar progressBar3 = landscapePollDialog.progress3;
            if (progressBar3 != null) {
                progressBar3.setProgress(0);
            }
            ProgressBar progressBar4 = landscapePollDialog.progress4;
            if (progressBar4 != null) {
                progressBar4.setProgress(100);
            }
            ProgressBar progressBar5 = landscapePollDialog.progress1;
            if (progressBar5 != null) {
                progressBar5.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar6 = landscapePollDialog.progress2;
            if (progressBar6 != null) {
                progressBar6.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar7 = landscapePollDialog.progress3;
            if (progressBar7 != null) {
                progressBar7.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar, landscapePollDialog.activity.getTheme()));
            }
            ProgressBar progressBar8 = landscapePollDialog.progress4;
            if (progressBar8 != null) {
                progressBar8.setProgressDrawable(ResourcesCompat.getDrawable(landscapePollDialog.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_app, landscapePollDialog.activity.getTheme()));
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pollAttempt$lambda$15(LandscapePollDialog landscapePollDialog, Polldata polldata) {
        if (SystemClock.elapsedRealtime() - landscapePollDialog.mLastClickTime < 1000) {
            return Unit.INSTANCE;
        }
        landscapePollDialog.mLastClickTime = SystemClock.elapsedRealtime();
        if (!Helper.isNetworkConnected(landscapePollDialog.activity)) {
            Helper.showInternetToast(landscapePollDialog.activity);
            return Unit.INSTANCE;
        }
        landscapePollDialog.pollResultAPI(polldata);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pollAttempt$lambda$17(LandscapePollDialog landscapePollDialog, Polldata polldata) {
        PollAdapter pollAdapter;
        try {
            if (StringsKt.equals(landscapePollDialog.select, "", true)) {
                Activity activity = landscapePollDialog.activity;
                Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.please_select_answer), 0).show();
            } else if (Helper.isNetworkConnected(landscapePollDialog.activity)) {
                String validTill = polldata.getValidTill();
                Intrinsics.checkNotNullExpressionValue(validTill, "getValidTill(...)");
                long j = 1000;
                if (Long.parseLong(validTill) > System.currentTimeMillis() / j) {
                    try {
                        if (SystemClock.elapsedRealtime() - landscapePollDialog.mLastClickTime < 1000) {
                            return Unit.INSTANCE;
                        }
                        landscapePollDialog.mLastClickTime = SystemClock.elapsedRealtime();
                        landscapePollDialog.dismissPreviousDialog();
                        Polldata polldata2 = landscapePollDialog.pollDataNew;
                        if (polldata2 != null) {
                            landscapePollDialog.showPollIndicator(polldata2, true);
                        }
                        Activity activity2 = landscapePollDialog.activity;
                        if (activity2 instanceof CustomMediaPlayer) {
                            ((CustomMediaPlayer) activity2).setpollcount(polldata.getRendomkey(), landscapePollDialog.select);
                        } else if (activity2 instanceof LiveStreamingYoutube) {
                            ((LiveStreamingYoutube) activity2).setLandscape(true);
                            if (StringsKt.equals(polldata.getAnswer(), "0", true) || !StringsKt.equals(polldata.getAnswer(), landscapePollDialog.select, true)) {
                                LiveStreamingYoutube liveStreamingYoutube = (LiveStreamingYoutube) landscapePollDialog.activity;
                                String rendomkey = polldata.getRendomkey();
                                Intrinsics.checkNotNullExpressionValue(rendomkey, "getRendomkey(...)");
                                liveStreamingYoutube.setpollcount(rendomkey, landscapePollDialog.select);
                            } else {
                                String validTill2 = polldata.getValidTill();
                                Intrinsics.checkNotNullExpressionValue(validTill2, "getValidTill(...)");
                                SendUserData sendUserData = new SendUserData(SharedPreference.getInstance().getLoggedInUser().getName(), MakeMyExam.getUserId(), new StringBuilder().append(Long.parseLong(validTill2) - (System.currentTimeMillis() / j)).toString(), landscapePollDialog.select);
                                LiveStreamingYoutube liveStreamingYoutube2 = (LiveStreamingYoutube) landscapePollDialog.activity;
                                String rendomkey2 = polldata.getRendomkey();
                                Intrinsics.checkNotNullExpressionValue(rendomkey2, "getRendomkey(...)");
                                liveStreamingYoutube2.setpollcount(rendomkey2, landscapePollDialog.select, sendUserData);
                            }
                            if (((LiveStreamingYoutube) landscapePollDialog.activity).getPollAdapter() != null && (pollAdapter = ((LiveStreamingYoutube) landscapePollDialog.activity).getPollAdapter()) != null) {
                                pollAdapter.notifyDataSetChanged();
                            }
                        } else if (activity2 instanceof VODPlayerActivity) {
                            ((VODPlayerActivity) activity2).isLandscape = true;
                            if (StringsKt.equals(polldata.getAnswer(), "0", true) || !StringsKt.equals(polldata.getAnswer(), landscapePollDialog.select, true)) {
                                ((VODPlayerActivity) landscapePollDialog.activity).setpollcount(polldata.getRendomkey(), landscapePollDialog.select);
                            } else {
                                String validTill3 = polldata.getValidTill();
                                Intrinsics.checkNotNullExpressionValue(validTill3, "getValidTill(...)");
                                ((VODPlayerActivity) landscapePollDialog.activity).setpollcount(polldata.getRendomkey(), landscapePollDialog.select, new SendUserData(SharedPreference.getInstance().getLoggedInUser().getName(), MakeMyExam.getUserId(), new StringBuilder().append(Long.parseLong(validTill3) - (System.currentTimeMillis() / j)).toString(), landscapePollDialog.select));
                            }
                            if (((VODPlayerActivity) landscapePollDialog.activity).pollAdapter != null) {
                                ((VODPlayerActivity) landscapePollDialog.activity).pollAdapter.notifyDataSetChanged();
                            }
                        } else if (activity2 instanceof Liveawsactivity) {
                            ((Liveawsactivity) activity2).isLandscape = true;
                            if (StringsKt.equals(polldata.getAnswer(), "0", true) || !StringsKt.equals(polldata.getAnswer(), landscapePollDialog.select, true)) {
                                ((Liveawsactivity) landscapePollDialog.activity).setpollcount(polldata.getRendomkey(), landscapePollDialog.select);
                            } else {
                                String validTill4 = polldata.getValidTill();
                                Intrinsics.checkNotNullExpressionValue(validTill4, "getValidTill(...)");
                                ((Liveawsactivity) landscapePollDialog.activity).setpollcount(polldata.getRendomkey(), landscapePollDialog.select, new SendUserData(SharedPreference.getInstance().getLoggedInUser().getName(), MakeMyExam.getUserId(), new StringBuilder().append(Long.parseLong(validTill4) - (System.currentTimeMillis() / j)).toString(), landscapePollDialog.select));
                            }
                            if (((Liveawsactivity) landscapePollDialog.activity).pollAdapter != null) {
                                ((Liveawsactivity) landscapePollDialog.activity).pollAdapter.notifyDataSetChanged();
                            }
                        }
                        polldata.setMyAnswer(landscapePollDialog.select);
                        landscapePollDialog.select = "";
                        Unit unit = Unit.INSTANCE;
                    } catch (Exception e2) {
                        Integer.valueOf(Log.d("TAGLandscapePollDialog", "pollAttempt: " + e2.getMessage()));
                    }
                } else {
                    Activity activity3 = landscapePollDialog.activity;
                    Toast.makeText(activity3, activity3.getResources().getString(com.eduteria.app.app.R.string.poll_is_expired), 0).show();
                }
            } else {
                Helper.showInternetToast(landscapePollDialog.activity);
            }
        } catch (Exception e3) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e3.getMessage());
        }
        return Unit.INSTANCE;
    }

    public final void SetServeyresult(final Polldata polldata, HashMap<String, Float> servaydata) {
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        Intrinsics.checkNotNullParameter(servaydata, "servaydata");
        notifyButton(polldata);
        TextView textView = this.option1;
        if (textView != null) {
            textView.setText(polldata.getOption1());
        }
        TextView textView2 = this.option2;
        if (textView2 != null) {
            textView2.setText(polldata.getOption2());
        }
        TextView textView3 = this.option3;
        if (textView3 != null) {
            textView3.setText(polldata.getOption3());
        }
        TextView textView4 = this.option4;
        if (textView4 != null) {
            textView4.setText(polldata.getOption4());
        }
        TextView textView5 = this.percentage1;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        TextView textView6 = this.percentage2;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        TextView textView7 = this.percentage3;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        TextView textView8 = this.percentage4;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        ProgressBar progressBar = this.progress1;
        if (progressBar != null) {
            progressBar.setProgress((int) Float.parseFloat(String.valueOf(servaydata.get("perA"))));
        }
        TextView textView9 = this.percentage1;
        if (textView9 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{servaydata.get("perA")}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            textView9.setText(str + "%");
        }
        ProgressBar progressBar2 = this.progress1;
        if (progressBar2 != null) {
            progressBar2.setMax(100);
        }
        if (StringsKt.equals(polldata.getOption1(), "", true)) {
            View view = this.typeA;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            View view2 = this.typeA;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        ProgressBar progressBar3 = this.progress2;
        if (progressBar3 != null) {
            progressBar3.setProgress((int) Float.parseFloat(String.valueOf(servaydata.get("perB"))));
        }
        ProgressBar progressBar4 = this.progress2;
        if (progressBar4 != null) {
            progressBar4.setMax(100);
        }
        TextView textView10 = this.percentage2;
        if (textView10 != null) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("%.2f", Arrays.copyOf(new Object[]{servaydata.get("perB")}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            textView10.setText(str2 + "%");
        }
        if (StringsKt.equals(polldata.getOption2(), "", true)) {
            View view3 = this.typeB;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        } else {
            View view4 = this.typeB;
            if (view4 != null) {
                view4.setVisibility(0);
            }
        }
        ProgressBar progressBar5 = this.progress3;
        if (progressBar5 != null) {
            progressBar5.setProgress((int) Float.parseFloat(String.valueOf(servaydata.get("perC"))));
        }
        ProgressBar progressBar6 = this.progress3;
        if (progressBar6 != null) {
            progressBar6.setMax(100);
        }
        TextView textView11 = this.percentage3;
        if (textView11 != null) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String str3 = String.format("%.2f", Arrays.copyOf(new Object[]{servaydata.get("perC")}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            textView11.setText(str3 + "%");
        }
        if (StringsKt.equals(polldata.getOption3(), "", true)) {
            View view5 = this.typeC;
            if (view5 != null) {
                view5.setVisibility(8);
            }
        } else {
            View view6 = this.typeC;
            if (view6 != null) {
                view6.setVisibility(0);
            }
        }
        ProgressBar progressBar7 = this.progress4;
        if (progressBar7 != null) {
            progressBar7.setProgress((int) Float.parseFloat(String.valueOf(servaydata.get("perD"))));
        }
        ProgressBar progressBar8 = this.progress4;
        if (progressBar8 != null) {
            progressBar8.setMax(100);
        }
        TextView textView12 = this.percentage4;
        if (textView12 != null) {
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String str4 = String.format("%.2f", Arrays.copyOf(new Object[]{servaydata.get("perD")}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            textView12.setText(str4 + "%");
        }
        if (StringsKt.equals(polldata.getOption4(), "", true)) {
            View view7 = this.typeD;
            if (view7 != null) {
                view7.setVisibility(8);
            }
        } else {
            View view8 = this.typeD;
            if (view8 != null) {
                view8.setVisibility(0);
            }
        }
        if (StringsKt.equals(polldata.getAnswer(), "0", true)) {
            String myAnswer = polldata.getMyAnswer();
            Intrinsics.checkNotNullExpressionValue(myAnswer, "getMyAnswer(...)");
            showForZeroResultsNextToppes(myAnswer);
        } else {
            showpollresultForNextToppers(polldata);
        }
        Button button = this.leaderBoardBtn;
        if (button != null) {
            button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LandscapePollDialog.SetServeyresult$lambda$18(this.f$0, polldata);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetServeyresult$lambda$18(LandscapePollDialog landscapePollDialog, Polldata polldata) {
        if (SystemClock.elapsedRealtime() - landscapePollDialog.mLastClickTime < 1000) {
            return Unit.INSTANCE;
        }
        landscapePollDialog.mLastClickTime = SystemClock.elapsedRealtime();
        if (!Helper.isNetworkConnected(landscapePollDialog.activity)) {
            Helper.showInternetToast(landscapePollDialog.activity);
            return Unit.INSTANCE;
        }
        landscapePollDialog.pollLeaderboardAPI(polldata);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void showForZeroResultsNextToppes(String answer) {
        switch (answer.hashCode()) {
            case 49:
                if (answer.equals("1")) {
                    ImageView imageView = this.radioButton1;
                    if (imageView != null) {
                        imageView.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
                    }
                    ProgressBar progressBar = this.progress1;
                    if (progressBar != null) {
                        progressBar.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                    }
                    break;
                }
                break;
            case 50:
                if (answer.equals("2")) {
                    ImageView imageView2 = this.radioButton2;
                    if (imageView2 != null) {
                        imageView2.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
                    }
                    ProgressBar progressBar2 = this.progress2;
                    if (progressBar2 != null) {
                        progressBar2.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                    }
                    break;
                }
                break;
            case 51:
                if (answer.equals("3")) {
                    ImageView imageView3 = this.radioButton3;
                    if (imageView3 != null) {
                        imageView3.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
                    }
                    ProgressBar progressBar3 = this.progress3;
                    if (progressBar3 != null) {
                        progressBar3.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                    }
                    break;
                }
                break;
            case 52:
                if (answer.equals("4")) {
                    ImageView imageView4 = this.radioButton4;
                    if (imageView4 != null) {
                        imageView4.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
                    }
                    ProgressBar progressBar4 = this.progress4;
                    if (progressBar4 != null) {
                        progressBar4.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                    }
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void showpollresultForNextToppers(Polldata polldata) {
        String myAnswer = polldata.getMyAnswer();
        String answer = polldata.getAnswer();
        if (StringsKt.equals(answer, myAnswer, true)) {
            if (myAnswer != null) {
                switch (myAnswer.hashCode()) {
                    case 49:
                        if (myAnswer.equals("1")) {
                            ImageView imageView = this.radioButton1;
                            if (imageView != null) {
                                imageView.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
                            }
                            ProgressBar progressBar = this.progress1;
                            if (progressBar != null) {
                                progressBar.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                            }
                            break;
                        }
                        break;
                    case 50:
                        if (myAnswer.equals("2")) {
                            ImageView imageView2 = this.radioButton2;
                            if (imageView2 != null) {
                                imageView2.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
                            }
                            ProgressBar progressBar2 = this.progress2;
                            if (progressBar2 != null) {
                                progressBar2.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                            }
                            break;
                        }
                        break;
                    case 51:
                        if (myAnswer.equals("3")) {
                            ImageView imageView3 = this.radioButton3;
                            if (imageView3 != null) {
                                imageView3.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
                            }
                            ProgressBar progressBar3 = this.progress3;
                            if (progressBar3 != null) {
                                progressBar3.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                            }
                            break;
                        }
                        break;
                    case 52:
                        if (myAnswer.equals("4")) {
                            ImageView imageView4 = this.radioButton4;
                            if (imageView4 != null) {
                                imageView4.setImageResource(com.eduteria.app.app.R.mipmap.correct_tick);
                            }
                            ProgressBar progressBar4 = this.progress4;
                            if (progressBar4 != null) {
                                progressBar4.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                            }
                            break;
                        }
                        break;
                }
            }
            return;
        }
        if (myAnswer != null) {
            switch (myAnswer.hashCode()) {
                case 49:
                    if (myAnswer.equals("1")) {
                        ImageView imageView5 = this.radioButton1;
                        if (imageView5 != null) {
                            imageView5.setImageResource(com.eduteria.app.app.R.mipmap.incorrect_tick);
                        }
                        ProgressBar progressBar5 = this.progress1;
                        if (progressBar5 != null) {
                            progressBar5.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_red, this.activity.getTheme()));
                        }
                    }
                    break;
                case 50:
                    if (myAnswer.equals("2")) {
                        ImageView imageView6 = this.radioButton2;
                        if (imageView6 != null) {
                            imageView6.setImageResource(com.eduteria.app.app.R.mipmap.incorrect_tick);
                        }
                        ProgressBar progressBar6 = this.progress2;
                        if (progressBar6 != null) {
                            progressBar6.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_red, this.activity.getTheme()));
                        }
                    }
                    break;
                case 51:
                    if (myAnswer.equals("3")) {
                        ImageView imageView7 = this.radioButton3;
                        if (imageView7 != null) {
                            imageView7.setImageResource(com.eduteria.app.app.R.mipmap.incorrect_tick);
                        }
                        ProgressBar progressBar7 = this.progress3;
                        if (progressBar7 != null) {
                            progressBar7.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_red, this.activity.getTheme()));
                        }
                    }
                    break;
                case 52:
                    if (myAnswer.equals("4")) {
                        ImageView imageView8 = this.radioButton4;
                        if (imageView8 != null) {
                            imageView8.setImageResource(com.eduteria.app.app.R.mipmap.incorrect_tick);
                        }
                        ProgressBar progressBar8 = this.progress4;
                        if (progressBar8 != null) {
                            progressBar8.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_red, this.activity.getTheme()));
                        }
                    }
                    break;
            }
        }
        if (answer != null) {
            switch (answer.hashCode()) {
                case 49:
                    if (answer.equals("1")) {
                        ImageView imageView9 = this.radioButton1;
                        if (imageView9 != null) {
                            imageView9.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
                        }
                        ProgressBar progressBar9 = this.progress1;
                        if (progressBar9 != null) {
                            progressBar9.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                        }
                        break;
                    }
                    break;
                case 50:
                    if (answer.equals("2")) {
                        ImageView imageView10 = this.radioButton2;
                        if (imageView10 != null) {
                            imageView10.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
                        }
                        ProgressBar progressBar10 = this.progress2;
                        if (progressBar10 != null) {
                            progressBar10.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                        }
                        break;
                    }
                    break;
                case 51:
                    if (answer.equals("3")) {
                        ImageView imageView11 = this.radioButton3;
                        if (imageView11 != null) {
                            imageView11.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
                        }
                        ProgressBar progressBar11 = this.progress3;
                        if (progressBar11 != null) {
                            progressBar11.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                        }
                        break;
                    }
                    break;
                case 52:
                    if (answer.equals("4")) {
                        ImageView imageView12 = this.radioButton4;
                        if (imageView12 != null) {
                            imageView12.setImageResource(com.eduteria.app.app.R.mipmap.not_attempted);
                        }
                        ProgressBar progressBar12 = this.progress4;
                        if (progressBar12 != null) {
                            progressBar12.setProgressDrawable(ResourcesCompat.getDrawable(this.activity.getResources(), com.eduteria.app.app.R.drawable.custom_progress_bar_green, this.activity.getTheme()));
                        }
                        break;
                    }
                    break;
            }
        }
    }

    public final void notifyButton(Polldata polldata) {
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        if (StringsKt.equals(polldata.getAnswer(), "0", true)) {
            TextView textView = this.pollTypeTxt;
            if (textView != null) {
                textView.setText(this.activity.getResources().getString(com.eduteria.app.app.R.string.survey));
            }
        } else {
            TextView textView2 = this.pollTypeTxt;
            if (textView2 != null) {
                textView2.setText(this.activity.getResources().getString(com.eduteria.app.app.R.string.quiz));
            }
        }
        if (polldata.getQuestion() != null && !TextUtils.isEmpty(polldata.getQuestion())) {
            TextView textView3 = this.txtQues;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.txtQues;
            if (textView4 != null) {
                textView4.setText(Html.fromHtml(polldata.getQuestion()));
            }
        } else {
            TextView textView5 = this.txtQues;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        String validTill = polldata.getValidTill();
        Intrinsics.checkNotNullExpressionValue(validTill, "getValidTill(...)");
        if (Long.parseLong(validTill) > System.currentTimeMillis() / ((long) 1000)) {
            TextView textView6 = this.pollTime;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            Button button = this.submit;
            if (button != null) {
                button.setVisibility(0);
            }
            Button button2 = this.resultBtn;
            if (button2 != null) {
                button2.setVisibility(8);
            }
            Button button3 = this.leaderBoardBtn;
            if (button3 != null) {
                button3.setVisibility(8);
                return;
            }
            return;
        }
        if (!StringsKt.equals(polldata.getAnswer(), "0", true)) {
            TextView textView7 = this.pollTime;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            Button button4 = this.submit;
            if (button4 != null) {
                button4.setVisibility(8);
            }
            Button button5 = this.resultBtn;
            if (button5 != null) {
                button5.setVisibility(8);
            }
            Activity activity = this.activity;
            if (activity instanceof Liveawsactivity) {
                Button button6 = this.leaderBoardBtn;
                if (button6 != null) {
                    button6.setVisibility(((Liveawsactivity) activity).isFirebaseChat ? 8 : 0);
                    return;
                }
                return;
            }
            if (activity instanceof LiveStreamingYoutube) {
                Button button7 = this.leaderBoardBtn;
                if (button7 != null) {
                    button7.setVisibility(((LiveStreamingYoutube) activity).getIsFirebaseChat() ? 8 : 0);
                    return;
                }
                return;
            }
            if (activity instanceof VODPlayerActivity) {
                Button button8 = this.leaderBoardBtn;
                if (button8 != null) {
                    button8.setVisibility(((VODPlayerActivity) activity).isFirebaseChat ? 8 : 0);
                    return;
                }
                return;
            }
            Button button9 = this.leaderBoardBtn;
            if (button9 != null) {
                button9.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView8 = this.pollTime;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        Button button10 = this.submit;
        if (button10 != null) {
            button10.setVisibility(8);
        }
        Button button11 = this.resultBtn;
        if (button11 != null) {
            button11.setVisibility(8);
        }
        Button button12 = this.leaderBoardBtn;
        if (button12 != null) {
            button12.setVisibility(8);
        }
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        String strChangeAMPM = Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
        Intrinsics.checkNotNullExpressionValue(strChangeAMPM, "changeAMPM(...)");
        return strChangeAMPM;
    }

    public final String concerter(long time) {
        TimeUnit.MILLISECONDS.toHours(time);
        TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(time));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final void pollResultAPI(Polldata polldata) {
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        try {
            Activity activity = this.activity;
            if (activity instanceof Liveawsactivity) {
                ((Liveawsactivity) activity).isLandscape = true;
                ((Liveawsactivity) this.activity).getServeyData(polldata);
            } else if (activity instanceof LiveStreamingYoutube) {
                ((LiveStreamingYoutube) activity).setLandscape(true);
                ((LiveStreamingYoutube) this.activity).getServeyData(polldata);
            } else if (activity instanceof VODPlayerActivity) {
                ((VODPlayerActivity) activity).isLandscape = true;
                ((VODPlayerActivity) this.activity).getServeyData(polldata);
            } else {
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.player.CustomMediaPlayer");
                ((CustomMediaPlayer) activity).getServeyData(polldata);
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
    }

    public final void pollLeaderboardAPI(Polldata polldata) {
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        try {
            this.pollKey = polldata.getRendomkey();
            Activity activity = this.activity;
            if (activity instanceof Liveawsactivity) {
                ((Liveawsactivity) activity).isLandscape = true;
                if (((Liveawsactivity) this.activity).isFirebaseChat) {
                    this.networkCall.NetworkAPICall(API.getLeaderBoardForPoll, "", true, false);
                    return;
                } else {
                    Activity activity2 = this.activity;
                    ((Liveawsactivity) activity2).sendWSMessage(((Liveawsactivity) activity2).leaderboardPollDataStr(this.pollKey), "GET_LEADERBOARD", this.pollKey);
                    return;
                }
            }
            if (activity instanceof LiveStreamingYoutube) {
                ((LiveStreamingYoutube) activity).setLandscape(true);
                if (((LiveStreamingYoutube) this.activity).getIsFirebaseChat()) {
                    this.networkCall.NetworkAPICall(API.getLeaderBoardForPoll, "", true, false);
                    return;
                } else {
                    Activity activity3 = this.activity;
                    ((LiveStreamingYoutube) activity3).sendWSMessage(((LiveStreamingYoutube) activity3).leaderboardPollDataStr(this.pollKey), "GET_LEADERBOARD", this.pollKey);
                    return;
                }
            }
            if (activity instanceof VODPlayerActivity) {
                ((VODPlayerActivity) activity).isLandscape = true;
                if (((VODPlayerActivity) this.activity).isFirebaseChat) {
                    this.networkCall.NetworkAPICall(API.getLeaderBoardForPoll, "", true, false);
                    return;
                } else {
                    Activity activity4 = this.activity;
                    ((VODPlayerActivity) activity4).sendWSMessage(((VODPlayerActivity) activity4).leaderboardPollDataStr(this.pollKey), "GET_LEADERBOARD", this.pollKey);
                    return;
                }
            }
            this.networkCall.NetworkAPICall(API.getLeaderBoardForPoll, "", true, false);
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
    }

    public final void pollLeaderboard(List<PollLeaderboard> leaderboardList, boolean isForAll) {
        Intrinsics.checkNotNullParameter(leaderboardList, "leaderboardList");
        TextView textView = this.time;
        if (textView != null) {
            textView.setText(isForAll ? "Answered" : "Time");
        }
        if (!TextUtils.isEmpty(leaderboardList.get(1).getUser_id()) && StringsKt.equals(leaderboardList.get(1).getUser_id(), MakeMyExam.getUserId(), true)) {
            Activity activity = this.activity;
            CardView cardView = this.cardView1;
            Intrinsics.checkNotNull(cardView);
            TextView textView2 = this.student1;
            Intrinsics.checkNotNull(textView2);
            TextView textView3 = this.studentOne;
            Intrinsics.checkNotNull(textView3);
            selectUserCard(activity, cardView, textView2, textView3, leaderboardList.get(1).getName());
        } else {
            Activity activity2 = this.activity;
            CardView cardView2 = this.cardView1;
            Intrinsics.checkNotNull(cardView2);
            TextView textView4 = this.student1;
            Intrinsics.checkNotNull(textView4);
            TextView textView5 = this.studentOne;
            Intrinsics.checkNotNull(textView5);
            unSelectUserCard(activity2, cardView2, textView4, textView5, leaderboardList.get(1).getName());
        }
        if (!TextUtils.isEmpty(leaderboardList.get(0).getUser_id()) && StringsKt.equals(leaderboardList.get(0).getUser_id(), MakeMyExam.getUserId(), true)) {
            Activity activity3 = this.activity;
            CardView cardView3 = this.cardView2;
            Intrinsics.checkNotNull(cardView3);
            TextView textView6 = this.student2;
            Intrinsics.checkNotNull(textView6);
            TextView textView7 = this.studentTwo;
            Intrinsics.checkNotNull(textView7);
            selectUserCard(activity3, cardView3, textView6, textView7, leaderboardList.get(0).getName());
        } else {
            Activity activity4 = this.activity;
            CardView cardView4 = this.cardView2;
            Intrinsics.checkNotNull(cardView4);
            TextView textView8 = this.student2;
            Intrinsics.checkNotNull(textView8);
            TextView textView9 = this.studentTwo;
            Intrinsics.checkNotNull(textView9);
            unSelectUserCard(activity4, cardView4, textView8, textView9, leaderboardList.get(0).getName());
        }
        if (!TextUtils.isEmpty(leaderboardList.get(2).getUser_id()) && StringsKt.equals(leaderboardList.get(2).getUser_id(), MakeMyExam.getUserId(), true)) {
            Activity activity5 = this.activity;
            CardView cardView5 = this.cardView3;
            Intrinsics.checkNotNull(cardView5);
            TextView textView10 = this.student3;
            Intrinsics.checkNotNull(textView10);
            TextView textView11 = this.studentThree;
            Intrinsics.checkNotNull(textView11);
            selectUserCard(activity5, cardView5, textView10, textView11, leaderboardList.get(2).getName());
        } else {
            Activity activity6 = this.activity;
            CardView cardView6 = this.cardView3;
            Intrinsics.checkNotNull(cardView6);
            TextView textView12 = this.student3;
            Intrinsics.checkNotNull(textView12);
            TextView textView13 = this.studentThree;
            Intrinsics.checkNotNull(textView13);
            unSelectUserCard(activity6, cardView6, textView12, textView13, leaderboardList.get(2).getName());
        }
        ArrayList arrayList = new ArrayList();
        int size = leaderboardList.size();
        int i = 3;
        while (i < size) {
            PollLeaderboard pollLeaderboard = leaderboardList.get(i);
            i++;
            pollLeaderboard.setRank(new StringBuilder().append(i).toString());
            arrayList.add(pollLeaderboard);
        }
        RecyclerView recyclerView = this.recyclerViewRank;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this.activity));
        }
        RecyclerView recyclerView2 = this.recyclerViewRank;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(new RankAdapter(this.activity, arrayList, isForAll));
        }
        Button button = this.resultBtnTwo;
        if (button != null) {
            button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LandscapePollDialog.pollLeaderboard$lambda$19(this.f$0);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pollLeaderboard$lambda$19(LandscapePollDialog landscapePollDialog) {
        if (SystemClock.elapsedRealtime() - landscapePollDialog.mLastClickTime < 1000) {
            return Unit.INSTANCE;
        }
        landscapePollDialog.mLastClickTime = SystemClock.elapsedRealtime();
        if (!Helper.isNetworkConnected(landscapePollDialog.activity)) {
            Helper.showInternetToast(landscapePollDialog.activity);
            return Unit.INSTANCE;
        }
        landscapePollDialog.pollResultAPI(landscapePollDialog.pollDataNew);
        return Unit.INSTANCE;
    }

    public final void selectUserCard(Context context, CardView cardView, TextView student, TextView studentText, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardView, "cardView");
        Intrinsics.checkNotNullParameter(student, "student");
        Intrinsics.checkNotNullParameter(studentText, "studentText");
        cardView.setRadius(TypedValue.applyDimension(1, 7.0f, Resources.getSystem().getDisplayMetrics()));
        cardView.setCardElevation(TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics()));
        cardView.setCardBackgroundColor(ResourcesCompat.getColor(context.getResources(), com.eduteria.app.app.R.color.colorPrimary, context.getTheme()));
        student.setTextColor(ResourcesCompat.getColor(context.getResources(), com.eduteria.app.app.R.color.white, context.getTheme()));
        student.setText(name);
        studentText.setTextColor(ResourcesCompat.getColor(context.getResources(), com.eduteria.app.app.R.color.white, context.getTheme()));
    }

    public final void unSelectUserCard(Context context, CardView cardView, TextView student, TextView studentText, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardView, "cardView");
        Intrinsics.checkNotNullParameter(student, "student");
        Intrinsics.checkNotNullParameter(studentText, "studentText");
        cardView.setRadius(TypedValue.applyDimension(1, 7.0f, Resources.getSystem().getDisplayMetrics()));
        cardView.setCardElevation(TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics()));
        cardView.setCardBackgroundColor(ResourcesCompat.getColor(context.getResources(), com.eduteria.app.app.R.color.white, context.getTheme()));
        student.setTextColor(ResourcesCompat.getColor(context.getResources(), com.eduteria.app.app.R.color.colorPrimary, context.getTheme()));
        student.setText(name);
        studentText.setTextColor(ResourcesCompat.getColor(context.getResources(), com.eduteria.app.app.R.color.colorPrimary, context.getTheme()));
    }

    public final void pollIndicator(final Polldata polldata) {
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        RelativeLayout relativeLayout = this.pollIndicatorRL;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        Button button = this.btnResult;
        if (button != null) {
            button.setVisibility(4);
        }
        Button button2 = this.btnLeaderboard;
        if (button2 != null) {
            button2.setVisibility(4);
        }
        View view = this.redDot;
        if (view != null) {
            view.setVisibility(4);
        }
        ImageView imageView = this.ivCloseIndic;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        ImageView imageView2 = this.ivCloseIndic;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LandscapePollDialog.pollIndicator$lambda$20(this.f$0);
                }
            }));
        }
        ImageView imageView3 = this.iconIV;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LandscapePollDialog.pollIndicator$lambda$21(this.f$0, polldata);
                }
            }));
        }
        Button button3 = this.btnResult;
        if (button3 != null) {
            button3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LandscapePollDialog.pollIndicator$lambda$22(this.f$0, polldata);
                }
            }));
        }
        Button button4 = this.btnLeaderboard;
        if (button4 != null) {
            button4.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LandscapePollDialog.pollIndicator$lambda$23(this.f$0, polldata);
                }
            }));
        }
        final long[] jArr = {0};
        View view2 = this.outsideIndicator;
        if (view2 != null) {
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda16
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    return LandscapePollDialog.pollIndicator$lambda$24(jArr, this, view3, motionEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pollIndicator$lambda$20(LandscapePollDialog landscapePollDialog) {
        Button button = landscapePollDialog.btnResult;
        if (button != null) {
            button.setVisibility(4);
        }
        Button button2 = landscapePollDialog.btnLeaderboard;
        if (button2 != null) {
            button2.setVisibility(4);
        }
        View view = landscapePollDialog.redDot;
        if (view != null) {
            view.setVisibility(4);
        }
        ImageView imageView = landscapePollDialog.ivCloseIndic;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pollIndicator$lambda$21(LandscapePollDialog landscapePollDialog, Polldata polldata) {
        if (SystemClock.elapsedRealtime() - landscapePollDialog.mLastClickTime < 1000) {
            return Unit.INSTANCE;
        }
        landscapePollDialog.mLastClickTime = SystemClock.elapsedRealtime();
        if (!Helper.isNetworkConnected(landscapePollDialog.activity)) {
            Helper.showInternetToast(landscapePollDialog.activity);
            return Unit.INSTANCE;
        }
        try {
            String validTill = polldata.getValidTill();
            Intrinsics.checkNotNullExpressionValue(validTill, "getValidTill(...)");
            long j = 1000;
            if (Long.parseLong(validTill) > System.currentTimeMillis() / j) {
                if (StringsKt.equals(polldata.getMyAnswer(), "0", true)) {
                    Button button = landscapePollDialog.btnResult;
                    if (button != null) {
                        button.setVisibility(4);
                    }
                    Button button2 = landscapePollDialog.btnLeaderboard;
                    if (button2 != null) {
                        button2.setVisibility(4);
                    }
                    View view = landscapePollDialog.redDot;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                    ImageView imageView = landscapePollDialog.ivCloseIndic;
                    if (imageView != null) {
                        imageView.setVisibility(4);
                    }
                    landscapePollDialog.showPollAttempt(polldata);
                } else {
                    String validTill2 = polldata.getValidTill();
                    Intrinsics.checkNotNullExpressionValue(validTill2, "getValidTill(...)");
                    long j2 = Long.parseLong(validTill2) - (System.currentTimeMillis() / j);
                    long j3 = 60;
                    long j4 = j2 / j3;
                    long j5 = j2 % j3;
                    Toast.makeText(landscapePollDialog.activity, "Poll result will be display in " + ((j4 <= 0 || j5 <= 0) ? j4 > 0 ? j4 + " minute" : j5 + " second" : j4 + " minute and " + j5 + " second") + InstructionFileId.DOT, 1).show();
                }
            } else if (StringsKt.equals("0", polldata.getAnswer(), true)) {
                landscapePollDialog.pollResultAPI(polldata);
            } else {
                Button button3 = landscapePollDialog.btnResult;
                if (button3 != null) {
                    button3.setVisibility(0);
                }
                Activity activity = landscapePollDialog.activity;
                if (activity instanceof Liveawsactivity) {
                    Button button4 = landscapePollDialog.btnLeaderboard;
                    if (button4 != null) {
                        button4.setVisibility(((Liveawsactivity) activity).isFirebaseChat ? 4 : 0);
                    }
                } else if (activity instanceof LiveStreamingYoutube) {
                    Button button5 = landscapePollDialog.btnLeaderboard;
                    if (button5 != null) {
                        button5.setVisibility(((LiveStreamingYoutube) activity).getIsFirebaseChat() ? 4 : 0);
                    }
                } else if (activity instanceof VODPlayerActivity) {
                    Button button6 = landscapePollDialog.btnLeaderboard;
                    if (button6 != null) {
                        button6.setVisibility(((VODPlayerActivity) activity).isFirebaseChat ? 4 : 0);
                    }
                } else {
                    Button button7 = landscapePollDialog.btnLeaderboard;
                    if (button7 != null) {
                        button7.setVisibility(4);
                    }
                }
                View view2 = landscapePollDialog.redDot;
                if (view2 != null) {
                    view2.setVisibility(4);
                }
                ImageView imageView2 = landscapePollDialog.ivCloseIndic;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
            }
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "onClick: " + e2.getMessage());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pollIndicator$lambda$22(LandscapePollDialog landscapePollDialog, Polldata polldata) {
        if (SystemClock.elapsedRealtime() - landscapePollDialog.mLastClickTime < 1000) {
            return Unit.INSTANCE;
        }
        landscapePollDialog.mLastClickTime = SystemClock.elapsedRealtime();
        if (!Helper.isNetworkConnected(landscapePollDialog.activity)) {
            Helper.showInternetToast(landscapePollDialog.activity);
            return Unit.INSTANCE;
        }
        ImageView imageView = landscapePollDialog.ivCloseIndic;
        if (imageView != null) {
            imageView.performClick();
        }
        landscapePollDialog.pollResultAPI(polldata);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pollIndicator$lambda$23(LandscapePollDialog landscapePollDialog, Polldata polldata) {
        if (SystemClock.elapsedRealtime() - landscapePollDialog.mLastClickTime < 1000) {
            return Unit.INSTANCE;
        }
        landscapePollDialog.mLastClickTime = SystemClock.elapsedRealtime();
        if (!Helper.isNetworkConnected(landscapePollDialog.activity)) {
            Helper.showInternetToast(landscapePollDialog.activity);
            return Unit.INSTANCE;
        }
        ImageView imageView = landscapePollDialog.ivCloseIndic;
        if (imageView != null) {
            imageView.performClick();
        }
        landscapePollDialog.pollLeaderboardAPI(polldata);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pollIndicator$lambda$24(long[] jArr, LandscapePollDialog landscapePollDialog, View view, MotionEvent motionEvent) {
        Dialog dialog;
        if (motionEvent != null && motionEvent.getAction() == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jArr[0] < 300) {
                Dialog dialog2 = landscapePollDialog.dialogIndicator;
                if (dialog2 != null && dialog2 != null && dialog2.isShowing() && (dialog = landscapePollDialog.dialogIndicator) != null) {
                    dialog.dismiss();
                }
            } else {
                ImageView imageView = landscapePollDialog.ivCloseIndic;
                if (imageView != null && imageView != null && imageView.getVisibility() == 0) {
                    ImageView imageView2 = landscapePollDialog.ivCloseIndic;
                    if (imageView2 != null) {
                        imageView2.performClick();
                    }
                } else {
                    Toast.makeText(landscapePollDialog.activity, "Double tap to close", 0).show();
                }
            }
            jArr[0] = jCurrentTimeMillis;
        }
        return true;
    }

    public final void dismissPreviousDialog() {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        try {
            Dialog dialog4 = this.dialogAttempt;
            if (dialog4 != null && dialog4 != null && dialog4.isShowing() && (dialog3 = this.dialogAttempt) != null) {
                dialog3.dismiss();
            }
            Dialog dialog5 = this.dialogResult;
            if (dialog5 != null && dialog5 != null && dialog5.isShowing() && (dialog2 = this.dialogResult) != null) {
                dialog2.dismiss();
            }
            Dialog dialog6 = this.dialogLeaderboard;
            if (dialog6 == null || dialog6 == null || !dialog6.isShowing() || (dialog = this.dialogLeaderboard) == null) {
                return;
            }
            dialog.dismiss();
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "dismissPreviousDialog: " + e2.getMessage());
        }
    }

    public final void dismissLandscapeDialog() {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        Dialog dialog4;
        try {
            Dialog dialog5 = this.dialogAttempt;
            if (dialog5 != null && dialog5 != null && dialog5.isShowing() && (dialog4 = this.dialogAttempt) != null) {
                dialog4.dismiss();
            }
            Dialog dialog6 = this.dialogResult;
            if (dialog6 != null && dialog6 != null && dialog6.isShowing() && (dialog3 = this.dialogResult) != null) {
                dialog3.dismiss();
            }
            Dialog dialog7 = this.dialogLeaderboard;
            if (dialog7 != null && dialog7 != null && dialog7.isShowing() && (dialog2 = this.dialogLeaderboard) != null) {
                dialog2.dismiss();
            }
            Dialog dialog8 = this.dialogIndicator;
            if (dialog8 == null || dialog8 == null || !dialog8.isShowing() || (dialog = this.dialogIndicator) == null) {
                return;
            }
            dialog.dismiss();
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "dismissLandscapeDialog: " + e2.getMessage());
        }
    }

    public final void setupDraggableDialog(final View dragSurfaceView, final View viewToMove) {
        Intrinsics.checkNotNullParameter(dragSurfaceView, "dragSurfaceView");
        Intrinsics.checkNotNullParameter(viewToMove, "viewToMove");
        try {
            final float[] fArr = new float[1];
            final float[] fArr2 = new float[1];
            final float[] fArr3 = new float[1];
            final float[] fArr4 = new float[1];
            final long[] jArr = new long[1];
            final boolean[] zArr = new boolean[1];
            dragSurfaceView.setOnTouchListener(new View.OnTouchListener() { // from class: com.appnew.android.player.LandscapePollDialog$$ExternalSyntheticLambda9
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return LandscapePollDialog.setupDraggableDialog$lambda$25(fArr3, fArr4, fArr, viewToMove, fArr2, jArr, zArr, dragSurfaceView, view, motionEvent);
                }
            });
        } catch (Exception e2) {
            Log.d("TAGLandscapePollDialog", "setupDraggableDialog: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupDraggableDialog$lambda$25(float[] fArr, float[] fArr2, float[] fArr3, View view, float[] fArr4, long[] jArr, boolean[] zArr, View view2, View view3, MotionEvent motionEvent) {
        Resources resources;
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            fArr[0] = motionEvent.getRawX();
            fArr2[0] = motionEvent.getRawY();
            fArr3[0] = view.getX() - fArr[0];
            fArr4[0] = view.getY() - fArr2[0];
            jArr[0] = System.currentTimeMillis();
            zArr[0] = false;
            view2.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f2 = rawX - fArr[0];
            float f3 = rawY - fArr2[0];
            if (!zArr[0]) {
                double d2 = f2;
                if (Math.abs(f3) > Math.abs(d2)) {
                    view2.getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                if (Math.abs(d2) > 10.0d) {
                    zArr[0] = true;
                    view2.getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            if (!zArr[0]) {
                return false;
            }
            float f4 = rawX + fArr3[0];
            float f5 = rawY + fArr4[0];
            DisplayMetrics displayMetrics = (view3 == null || (resources = view3.getResources()) == null) ? null : resources.getDisplayMetrics();
            Integer numValueOf2 = displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null;
            Integer numValueOf3 = displayMetrics != null ? Integer.valueOf(displayMetrics.heightPixels) : null;
            Intrinsics.checkNotNull(numValueOf2);
            float fMax = (float) Math.max(0.0d, Math.min(f4, numValueOf2.intValue() - view.getWidth()));
            Intrinsics.checkNotNull(numValueOf3);
            float fMax2 = (float) Math.max(0.0d, Math.min(f5, numValueOf3.intValue() - view.getHeight()));
            view.setX(fMax);
            view.setY(fMax2);
            return true;
        }
        if ((numValueOf == null || numValueOf.intValue() != 1) && (numValueOf == null || numValueOf.intValue() != 3)) {
            return false;
        }
        view2.getParent().requestDisallowInterceptTouchEvent(false);
        if (!zArr[0] && System.currentTimeMillis() - jArr[0] < 200 && view3 != null) {
            view3.performClick();
        }
        zArr[0] = false;
        return true;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.getLeaderBoardForPoll)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setPoll_key(this.pollKey);
            return service.getLeaderBoardForPoll(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.submitpoll)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setAnswer(this.select);
        encryptionData2.setPoll_id(this.pollDataNew.getId());
        return service.sendpoll(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        PollAdapter pollAdapter;
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        if (Intrinsics.areEqual(apitype, API.getLeaderBoardForPoll)) {
            if (jsonstring.optBoolean("status")) {
                try {
                    if (jsonstring.has("data")) {
                        JSONArray jSONArrayOptJSONArray = jsonstring.optJSONArray("data");
                        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                            Toast.makeText(this.activity, "No Leaderboard found", 0).show();
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                PollLeaderboard pollLeaderboard = (PollLeaderboard) new Gson().fromJson(jSONArrayOptJSONArray.opt(i).toString(), PollLeaderboard.class);
                                Intrinsics.checkNotNull(pollLeaderboard);
                                arrayList.add(pollLeaderboard);
                            }
                            if (arrayList.size() <= 3) {
                                Toast.makeText(this.activity, "No Leaderboard found", 0).show();
                            } else {
                                showPollLeaderboard(arrayList, false);
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                } catch (Exception e2) {
                    Integer.valueOf(Log.d("TAGLandscapePollDialog", "SuccessCallBack: " + e2.getMessage()));
                    return;
                }
            }
            ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
            return;
        }
        if (Intrinsics.areEqual(apitype, API.submitpoll)) {
            if (StringsKt.equals(jsonstring.getString("status"), "true", true)) {
                try {
                    Activity activity = this.activity;
                    if (activity instanceof CustomMediaPlayer) {
                        ((CustomMediaPlayer) activity).setpollcount(this.pollDataNew.getRendomkey(), this.select);
                        if (((CustomMediaPlayer) this.activity).pollAdapter != null) {
                            ((CustomMediaPlayer) this.activity).pollAdapter.notifyDataSetChanged();
                        }
                    } else if (activity instanceof LiveStreamingYoutube) {
                        ((LiveStreamingYoutube) activity).setLandscape(true);
                        LiveStreamingYoutube liveStreamingYoutube = (LiveStreamingYoutube) this.activity;
                        String rendomkey = this.pollDataNew.getRendomkey();
                        Intrinsics.checkNotNullExpressionValue(rendomkey, "getRendomkey(...)");
                        liveStreamingYoutube.setpollcount(rendomkey, this.select);
                        if (((LiveStreamingYoutube) this.activity).getPollAdapter() != null && (pollAdapter = ((LiveStreamingYoutube) this.activity).getPollAdapter()) != null) {
                            pollAdapter.notifyDataSetChanged();
                        }
                    } else if (activity instanceof VODPlayerActivity) {
                        ((VODPlayerActivity) activity).isLandscape = true;
                        ((VODPlayerActivity) this.activity).setpollcount(this.pollDataNew.getRendomkey(), this.select);
                        if (((VODPlayerActivity) this.activity).pollAdapter != null) {
                            ((VODPlayerActivity) this.activity).pollAdapter.notifyDataSetChanged();
                        }
                    } else if (activity instanceof Liveawsactivity) {
                        ((Liveawsactivity) activity).isLandscape = true;
                        ((Liveawsactivity) this.activity).setpollcount(this.pollDataNew.getRendomkey(), this.select);
                        if (((Liveawsactivity) this.activity).pollAdapter != null) {
                            ((Liveawsactivity) this.activity).pollAdapter.notifyDataSetChanged();
                        }
                    }
                    this.pollDataNew.setMyAnswer(this.select);
                    this.select = "";
                    Unit unit2 = Unit.INSTANCE;
                    return;
                } catch (Exception e3) {
                    Integer.valueOf(Log.d("TAGLandscapePollDialog", "SuccessCallBack: " + e3.getMessage()));
                    return;
                }
            }
            ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        if (Intrinsics.areEqual(apitype, API.getLeaderBoardForPoll)) {
            Toast.makeText(this.activity, "No Leaderboard found", 0).show();
        } else if (Intrinsics.areEqual(apitype, API.submitpoll)) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(com.eduteria.app.app.R.string.error_in_submit_poll), 0).show();
        }
    }
}
