package com.appnew.android.home.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.Cards;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.Adapter.DashboardTabAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.GridSpacingItemDecoration;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.home.adapters.CourseTypeSmallTileAdapter;
import com.appnew.android.home.adapters.TileDataAdapter;
import com.appnew.android.home.adapters.TileItemsAdapter;
import com.appnew.android.home.interfaces.onButtonClicked;
import com.appnew.android.home.model.CourseResponse;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.AudioTable;
import com.appnew.android.table.CourseDataTable;
import com.appnew.android.table.CourseTypeMasterTable;
import com.appnew.android.table.HomeApiStatusTable;
import com.appnew.android.table.LanguagesTable;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.razorpay.PaymentResultListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: CourseTypeActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0089\u0002\u001a\u00030\u008a\u00022\n\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u008c\u0002H\u0015J\n\u0010\u008d\u0002\u001a\u00030\u008a\u0002H\u0002J\n\u0010\u008e\u0002\u001a\u00030\u008a\u0002H\u0002J\n\u0010\u008f\u0002\u001a\u00030\u008a\u0002H\u0002J\"\u0010\u0090\u0002\u001a\u00030\u008a\u00022\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u001bH\u0002J\u001b\u0010\u0091\u0002\u001a\u00030\u008a\u00022\u0007\u0010\u0092\u0002\u001a\u0002052\u0006\u0010M\u001a\u00020\u0016H\u0016J\u0013\u0010\u0093\u0002\u001a\u00030\u008a\u00022\u0007\u0010\u0094\u0002\u001a\u00020\u0016H\u0002J\n\u0010\u0095\u0002\u001a\u00030\u008a\u0002H\u0016J\u0018\u0010\u0096\u0002\u001a\b\u0012\u0004\u0012\u00020\f0%2\u0007\u0010\u0097\u0002\u001a\u00020\u0016H\u0002J'\u0010\u0098\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u000b2\r\u0010\u0099\u0002\u001a\b\u0012\u0004\u0012\u00020&0\u000b2\t\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u0016J\u001e\u0010\u0098\u0002\u001a\t\u0012\u0005\u0012\u00030è\u00010\u000b2\u000e\u0010\u0099\u0002\u001a\t\u0012\u0005\u0012\u00030è\u00010\u000bJ\u0016\u0010\u009b\u0002\u001a\u00030»\u00012\n\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009d\u0002H\u0016J\u0014\u0010\u009e\u0002\u001a\u00030\u008a\u00022\b\u0010\u009c\u0002\u001a\u00030\u009f\u0002H\u0002J!\u0010 \u0002\u001a\u00030\u008a\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u000b2\u0007\u0010¡\u0002\u001a\u000205H\u0002J\u0011\u0010¢\u0002\u001a\u00030\u008a\u00022\u0007\u0010£\u0002\u001a\u00020-J\u0014\u0010¤\u0002\u001a\u00030\u008a\u00022\b\u0010¥\u0002\u001a\u00030»\u0001H\u0002J6\u0010¦\u0002\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010§\u00022\t\u0010¨\u0002\u001a\u0004\u0018\u00010\u00162\t\u0010©\u0002\u001a\u0004\u0018\u00010\u00162\n\u0010ª\u0002\u001a\u0005\u0018\u00010«\u0002H\u0016J4\u0010¬\u0002\u001a\u00030\u008a\u00022\b\u0010\u00ad\u0002\u001a\u00030®\u00022\t\u0010¨\u0002\u001a\u0004\u0018\u00010\u00162\t\u0010©\u0002\u001a\u0004\u0018\u00010\u00162\b\u0010¯\u0002\u001a\u00030»\u0001H\u0016J+\u0010°\u0002\u001a\u00030\u008a\u00022\t\u0010±\u0002\u001a\u0004\u0018\u00010\u00162\t\u0010¨\u0002\u001a\u0004\u0018\u00010\u00162\t\u0010©\u0002\u001a\u0004\u0018\u00010\u0016H\u0016J:\u0010²\u0002\u001a\u00030\u008a\u00022\t\u0010£\u0002\u001a\u0004\u0018\u00010-2\u000f\u0010³\u0002\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u000b2\t\u0010÷\u0001\u001a\u0004\u0018\u00010\u00162\u0007\u0010´\u0002\u001a\u000205H\u0016J\u0012\u0010µ\u0002\u001a\u00030\u008a\u00022\u0006\u00104\u001a\u00020\u0016H\u0002J\u0015\u0010¶\u0002\u001a\u00030\u008a\u00022\t\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u0016H\u0016J\u001e\u0010·\u0002\u001a\u00030\u008a\u00022\u0007\u0010¸\u0002\u001a\u0002052\t\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u0016H\u0016J\u0015\u0010¹\u0002\u001a\u00030\u008a\u00022\t\u0010º\u0002\u001a\u0004\u0018\u00010\u0016H\u0016J.\u0010»\u0002\u001a\u00030\u008a\u00022\u0007\u0010¼\u0002\u001a\u00020\u00162\u0007\u0010½\u0002\u001a\u00020\u00162\u0007\u0010¾\u0002\u001a\u00020\u00162\u0007\u0010¿\u0002\u001a\u00020\u0016H\u0016J\u0014\u0010À\u0002\u001a\u00030\u008a\u00022\b\u0010Á\u0002\u001a\u00030»\u0001H\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u000bj\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u0012\u0012\u0004\u0012\u00020+0\u000bj\b\u0012\u0004\u0012\u00020+`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020-0\u000bj\b\u0012\u0004\u0012\u00020-`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020/X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0018\"\u0004\b@\u0010=R\u001c\u0010A\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0018\"\u0004\bC\u0010=R\u001c\u0010D\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010=R\u001c\u0010G\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0018\"\u0004\bI\u0010=R\u001c\u0010J\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010=R\u001c\u0010M\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0018\"\u0004\bO\u0010=R\u001c\u0010P\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0018\"\u0004\bR\u0010=R\u001a\u0010S\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0018\"\u0004\b[\u0010=R\u001c\u0010\\\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0018\"\u0004\b^\u0010=R\u001c\u0010_\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0018\"\u0004\ba\u0010=R\u001c\u0010b\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0018\"\u0004\bd\u0010=R\u001c\u0010e\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0018\"\u0004\bg\u0010=R\u001c\u0010h\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0018\"\u0004\bj\u0010=R\u001c\u0010k\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0018\"\u0004\bm\u0010=R\u0010\u0010n\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010p\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0018\"\u0004\br\u0010=R\u001c\u0010s\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0018\"\u0004\bu\u0010=R\u001c\u0010v\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0018\"\u0004\bx\u0010=R\u001c\u0010y\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0018\"\u0004\b{\u0010=R\u001c\u0010|\u001a\u00020}X\u0086.¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\"\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R \u0010\u0088\u0001\u001a\u00030\u0089\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R \u0010\u008e\u0001\u001a\u00030\u0089\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u008b\u0001\"\u0006\b\u0090\u0001\u0010\u008d\u0001R \u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R \u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R \u0010\u009d\u0001\u001a\u00030\u009e\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R \u0010£\u0001\u001a\u00030\u009e\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010 \u0001\"\u0006\b¥\u0001\u0010¢\u0001R \u0010¦\u0001\u001a\u00030\u009e\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010 \u0001\"\u0006\b¨\u0001\u0010¢\u0001R\u001d\u0010©\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010\u0018\"\u0005\bª\u0001\u0010=R\u000f\u0010«\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¬\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u00ad\u0001\u001a\u00030®\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010±\u0001\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010²\u0001\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010³\u0001\u001a\u00030®\u0001X\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010´\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010\u0018\"\u0005\b¶\u0001\u0010=R\u001d\u0010·\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010\u0018\"\u0005\b¹\u0001\u0010=R \u0010º\u0001\u001a\u00030»\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R \u0010À\u0001\u001a\u00030»\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0001\u0010½\u0001\"\u0006\bÁ\u0001\u0010¿\u0001R\u001d\u0010Â\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010\u0018\"\u0005\bÄ\u0001\u0010=R\u001d\u0010Å\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010\u0018\"\u0005\bÇ\u0001\u0010=R \u0010È\u0001\u001a\u00030»\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÉ\u0001\u0010½\u0001\"\u0006\bÊ\u0001\u0010¿\u0001R\u001d\u0010Ë\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010\u0018\"\u0005\bÍ\u0001\u0010=R\u000f\u0010Î\u0001\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010Ï\u0001\u001a\u00030»\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÏ\u0001\u0010½\u0001\"\u0006\bÐ\u0001\u0010¿\u0001R\u000f\u0010Ñ\u0001\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000f\u0010Ò\u0001\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010Ó\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0001\u0010\u0018\"\u0005\bÕ\u0001\u0010=R\u001f\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0001\u0010\u0018\"\u0005\bØ\u0001\u0010=R\u001d\u0010Ù\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u0010\u0018\"\u0005\bÛ\u0001\u0010=R\u001d\u0010Ü\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÝ\u0001\u0010\u0018\"\u0005\bÞ\u0001\u0010=R\u001d\u0010ß\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bà\u0001\u0010\u0018\"\u0005\bá\u0001\u0010=R\u001d\u0010â\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0001\u0010\u0018\"\u0005\bä\u0001\u0010=R\u001d\u0010å\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bå\u0001\u0010\u0018\"\u0005\bæ\u0001\u0010=R/\u0010ç\u0001\u001a\u0014\u0012\u0005\u0012\u00030è\u00010\u000bj\t\u0012\u0005\u0012\u00030è\u0001`\u001bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bé\u0001\u0010\u001e\"\u0005\bê\u0001\u0010 R\u001f\u0010ë\u0001\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0001\u00101\"\u0005\bí\u0001\u00103R\"\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bð\u0001\u0010ñ\u0001\"\u0006\bò\u0001\u0010ó\u0001R\u001d\u0010ô\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bõ\u0001\u0010\u0018\"\u0005\bö\u0001\u0010=R\u001f\u0010÷\u0001\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bø\u0001\u0010\u0018\"\u0005\bù\u0001\u0010=R\u001f\u0010ú\u0001\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bû\u0001\u00101\"\u0005\bü\u0001\u00103R \u0010ý\u0001\u001a\u00030»\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bþ\u0001\u0010½\u0001\"\u0006\bÿ\u0001\u0010¿\u0001R \u0010\u0080\u0002\u001a\u00030\u009e\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0002\u0010 \u0001\"\u0006\b\u0082\u0002\u0010¢\u0001R \u0010\u0083\u0002\u001a\u00030\u0084\u0002X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002\"\u0006\b\u0087\u0002\u0010\u0088\u0002¨\u0006Â\u0002"}, d2 = {"Lcom/appnew/android/home/Activity/CourseTypeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/appnew/android/home/interfaces/onButtonClicked;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "Lcom/appnew/android/Payment/PaymentGatewayListener;", "Lcom/razorpay/PaymentResultListener;", "<init>", "()V", "masterAllCatTablesAllTable", "Ljava/util/ArrayList;", "Lcom/appnew/android/table/MasteAllCatTable;", "courseTypeSmallTileAdapter", "Lcom/appnew/android/home/adapters/CourseTypeSmallTileAdapter;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "themeKey", "", "getThemeKey", "()Ljava/lang/String;", "courseTypeMasterTables", "Lcom/appnew/android/table/CourseTypeMasterTable;", "Lkotlin/collections/ArrayList;", "selectedsub_all_cat", "getSelectedsub_all_cat", "()Ljava/util/ArrayList;", "setSelectedsub_all_cat", "(Ljava/util/ArrayList;)V", "selected_master_cat", "getSelected_master_cat", "setSelected_master_cat", "mastercatlist", "", "Lcom/appnew/android/table/MasterCat;", "masterCat", "masterAllCatTables", "masterAllCatTables2", "LanguagesTable", "Lcom/appnew/android/table/LanguagesTable;", "cardsArrayList", "Lcom/appnew/android/Model/Courses/Cards;", "courseTypeRV", "Landroidx/recyclerview/widget/RecyclerView;", "getCourseTypeRV", "()Landroidx/recyclerview/widget/RecyclerView;", "setCourseTypeRV", "(Landroidx/recyclerview/widget/RecyclerView;)V", Const.NOTIFICATION_CODE, "", "getNotification_code", "()I", "setNotification_code", "(I)V", "time", "getTime", "setTime", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "title", "getTitle", "setTitle", "url", "getUrl", "setUrl", Const.MESSAGE_TARGET, "getMessage_target", "setMessage_target", "type", "getType", "setType", "course_id", "getCourse_id", "setCourse_id", "fieldid", "getFieldid", "setFieldid", CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, "", "getTs", "()J", "setTs", "(J)V", "coupon_for", "getCoupon_for", "setCoupon_for", "topicid", "getTopicid", "setTopicid", "testname", "getTestname", "setTestname", "testquestion", "getTestquestion", "setTestquestion", "tiletype", "getTiletype", "setTiletype", "tileid", "getTileid", "setTileid", "revertapi", "getRevertapi", "setRevertapi", "audioTable", "Lcom/appnew/android/table/AudioTable;", Const.VIDEO_TYPE, "getVideo_type", "setVideo_type", Const.shareparentid, "getParentid", "setParentid", "contentType_id", "getContentType_id", "setContentType_id", "tabName", "getTabName", "setTabName", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "toolbarTitleTV", "Landroid/widget/TextView;", "getToolbarTitleTV", "()Landroid/widget/TextView;", "setToolbarTitleTV", "(Landroid/widget/TextView;)V", "Course_Title", "getCourse_Title", "setCourse_Title", "courseTitleWeb", "Lcom/ahmadnemati/clickablewebview/ClickableWebView;", "getCourseTitleWeb", "()Lcom/ahmadnemati/clickablewebview/ClickableWebView;", "setCourseTitleWeb", "(Lcom/ahmadnemati/clickablewebview/ClickableWebView;)V", "course_banner", "Landroidx/cardview/widget/CardView;", "getCourse_banner", "()Landroidx/cardview/widget/CardView;", "setCourse_banner", "(Landroidx/cardview/widget/CardView;)V", "course_bg_layout", "Landroid/widget/RelativeLayout;", "getCourse_bg_layout", "()Landroid/widget/RelativeLayout;", "setCourse_bg_layout", "(Landroid/widget/RelativeLayout;)V", "no_data_found_RL", "getNo_data_found_RL", "setNo_data_found_RL", "rl_title_main", "getRl_title_main", "setRl_title_main", "isBook", "setBook", "homeScreen_ourCourses", "masterCategoryId", "imageBack", "Landroid/widget/ImageView;", "searchenable", "cart_text_color", "cart_bg_color", "description", "downarrowIV", "clicktype", "getClicktype", "setClicktype", "allsubcatindex", "getAllsubcatindex", "setAllsubcatindex", "isfilterchanged", "", "getIsfilterchanged", "()Z", "setIsfilterchanged", "(Z)V", "isFromDashBoard", "setFromDashBoard", "SelectedLaunguageid", "getSelectedLaunguageid", "setSelectedLaunguageid", "SelectedSubjectid", "getSelectedSubjectid", "setSelectedSubjectid", "isfilterapply", "getIsfilterapply", "setIsfilterapply", "selectedpositionid", "getSelectedpositionid", "setSelectedpositionid", "pagecount", "isFromTileActivity", "setFromTileActivity", "fromWhere", "issearchnable", "allsubcatindex_id", "getAllsubcatindex_id", "setAllsubcatindex_id", "subTitle", "getSubTitle", "setSubTitle", "mastercatname", "getMastercatname", "setMastercatname", "mastercatid", "getMastercatid", "setMastercatid", "allcatindex", "getAllcatindex", "setAllcatindex", "allcatindex_id", "getAllcatindex_id", "setAllcatindex_id", "is_paid", "set_paid", "courselists", "Lcom/appnew/android/Model/Courselist;", "getCourselists", "setCourselists", "courseListRV", "getCourseListRV", "setCourseListRV", "tileDataAdapter", "Lcom/appnew/android/home/adapters/TileDataAdapter;", "getTileDataAdapter", "()Lcom/appnew/android/home/adapters/TileDataAdapter;", "setTileDataAdapter", "(Lcom/appnew/android/home/adapters/TileDataAdapter;)V", "launguageindex", "getLaunguageindex", "setLaunguageindex", "contentType", "getContentType", "setContentType", "tileRv", "getTileRv", "setTileRv", "ispaginationavailable", "getIspaginationavailable", "setIspaginationavailable", "root_view", "getRoot_view", "setRoot_view", "main_toolbar", "Landroidx/appcompat/widget/Toolbar;", "getMain_toolbar", "()Landroidx/appcompat/widget/Toolbar;", "setMain_toolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updatePreference", "selectDropDown", "selectData", "setDataAdapter", "onDashboardItemClicked", Const.POSITION, "setThemeColor", "color", "onBackPressed", "parseJSON", "jsonString", "removeDuplicates", "list", CmcdData.Factory.STREAMING_FORMAT_SS, "onMenuItemClick", "item", "Landroid/view/MenuItem;", "updateMasterCat", "", "getTileItems", Constants.INAPP_POSITION, "getTileData", "cards", "getCourseData", "showProgress", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "onTitleClicked", "tiles", "tilePos", "pushEventForPushNotification", "onPaymentSuccess", "onPaymentError", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "onSuccess", "posTxnId", "onSuccessEsewa", "productId", "totalAmount", "referenceId", "scdId", "onFailed", "isFailure", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CourseTypeActivity extends AppCompatActivity implements DashboardTabAdapter.addDashboardItemClicked, NetworkCall.MyNetworkCallBack, onButtonClicked, PopupMenu.OnMenuItemClickListener, PaymentGatewayListener, PaymentResultListener {
    public static final int $stable = 8;
    public TextView Course_Title;
    private AudioTable audioTable;
    private String cart_bg_color;
    private String cart_text_color;
    private String contentType;
    private String contentType_id;
    private String coupon_for;
    private RecyclerView courseListRV;
    public ClickableWebView courseTitleWeb;
    public RecyclerView courseTypeRV;
    private CourseTypeSmallTileAdapter courseTypeSmallTileAdapter;
    public CardView course_banner;
    public RelativeLayout course_bg_layout;
    private String course_id;
    private String description;
    private ImageView downarrowIV;
    private String fieldid;
    private ImageView imageBack;
    private boolean isFromDashBoard;
    private boolean isFromTileActivity;
    private boolean isfilterapply;
    private boolean isfilterchanged;
    private boolean ispaginationavailable;
    public Toolbar main_toolbar;
    private ArrayList<MasteAllCatTable> masterAllCatTablesAllTable;
    private String message;
    private String message_target;
    private NetworkCall networkCall;
    public RelativeLayout no_data_found_RL;
    private int notification_code;
    private String parentid;
    private String revertapi;
    public RelativeLayout rl_title_main;
    public RelativeLayout root_view;
    public SharedPreferences sharedPreferences;
    private String subTitle;
    private String tabName;
    private String testname;
    private String testquestion;
    private TileDataAdapter tileDataAdapter;
    private RecyclerView tileRv;
    private String tileid;
    private String tiletype;
    private String time;
    private String title;
    public TextView toolbarTitleTV;
    private String topicid;
    private long ts;
    private String type;
    private String url;
    public UtkashRoom utkashRoom;
    private String video_type;
    private final String themeKey = "currentTheme";
    private ArrayList<CourseTypeMasterTable> courseTypeMasterTables = new ArrayList<>();
    private ArrayList<MasteAllCatTable> selectedsub_all_cat = new ArrayList<>();
    private ArrayList<MasteAllCatTable> selected_master_cat = new ArrayList<>();
    private List<? extends MasterCat> mastercatlist = new ArrayList();
    private List<? extends MasterCat> masterCat = new ArrayList();
    private ArrayList<MasteAllCatTable> masterAllCatTables = new ArrayList<>();
    private ArrayList<MasteAllCatTable> masterAllCatTables2 = new ArrayList<>();
    private ArrayList<LanguagesTable> LanguagesTable = new ArrayList<>();
    private ArrayList<Cards> cardsArrayList = new ArrayList<>();
    private String isBook = "0";
    private String homeScreen_ourCourses = "";
    private String masterCategoryId = "";
    private String searchenable = "";
    private String clicktype = "";
    private String allsubcatindex = "";
    private String SelectedLaunguageid = "";
    private String SelectedSubjectid = "";
    private String selectedpositionid = "0";
    private int pagecount = 1;
    private final String fromWhere = "";
    private final String issearchnable = "";
    private String allsubcatindex_id = "";
    private String mastercatname = "";
    private String mastercatid = "";
    private String allcatindex = "";
    private String allcatindex_id = "";
    private String is_paid = "";
    private ArrayList<Courselist> courselists = new ArrayList<>();
    private String launguageindex = "";

    private final void getCourseData(boolean showProgress) {
    }

    public final void getTileData(Cards cards) {
        Intrinsics.checkNotNullParameter(cards, "cards");
    }

    public final SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        return null;
    }

    public final void setSharedPreferences(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<set-?>");
        this.sharedPreferences = sharedPreferences;
    }

    public final String getThemeKey() {
        return this.themeKey;
    }

    public final ArrayList<MasteAllCatTable> getSelectedsub_all_cat() {
        return this.selectedsub_all_cat;
    }

    public final void setSelectedsub_all_cat(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selectedsub_all_cat = arrayList;
    }

    public final ArrayList<MasteAllCatTable> getSelected_master_cat() {
        return this.selected_master_cat;
    }

    public final void setSelected_master_cat(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selected_master_cat = arrayList;
    }

    public final RecyclerView getCourseTypeRV() {
        RecyclerView recyclerView = this.courseTypeRV;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("courseTypeRV");
        return null;
    }

    public final void setCourseTypeRV(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.courseTypeRV = recyclerView;
    }

    public final int getNotification_code() {
        return this.notification_code;
    }

    public final void setNotification_code(int i) {
        this.notification_code = i;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    @Override // android.app.Activity
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getMessage_target() {
        return this.message_target;
    }

    public final void setMessage_target(String str) {
        this.message_target = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getCourse_id() {
        return this.course_id;
    }

    public final void setCourse_id(String str) {
        this.course_id = str;
    }

    public final String getFieldid() {
        return this.fieldid;
    }

    public final void setFieldid(String str) {
        this.fieldid = str;
    }

    public final long getTs() {
        return this.ts;
    }

    public final void setTs(long j) {
        this.ts = j;
    }

    public final String getCoupon_for() {
        return this.coupon_for;
    }

    public final void setCoupon_for(String str) {
        this.coupon_for = str;
    }

    public final String getTopicid() {
        return this.topicid;
    }

    public final void setTopicid(String str) {
        this.topicid = str;
    }

    public final String getTestname() {
        return this.testname;
    }

    public final void setTestname(String str) {
        this.testname = str;
    }

    public final String getTestquestion() {
        return this.testquestion;
    }

    public final void setTestquestion(String str) {
        this.testquestion = str;
    }

    public final String getTiletype() {
        return this.tiletype;
    }

    public final void setTiletype(String str) {
        this.tiletype = str;
    }

    public final String getTileid() {
        return this.tileid;
    }

    public final void setTileid(String str) {
        this.tileid = str;
    }

    public final String getRevertapi() {
        return this.revertapi;
    }

    public final void setRevertapi(String str) {
        this.revertapi = str;
    }

    public final String getVideo_type() {
        return this.video_type;
    }

    public final void setVideo_type(String str) {
        this.video_type = str;
    }

    public final String getParentid() {
        return this.parentid;
    }

    public final void setParentid(String str) {
        this.parentid = str;
    }

    public final String getContentType_id() {
        return this.contentType_id;
    }

    public final void setContentType_id(String str) {
        this.contentType_id = str;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final void setTabName(String str) {
        this.tabName = str;
    }

    public final UtkashRoom getUtkashRoom() {
        UtkashRoom utkashRoom = this.utkashRoom;
        if (utkashRoom != null) {
            return utkashRoom;
        }
        Intrinsics.throwUninitializedPropertyAccessException("utkashRoom");
        return null;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final TextView getToolbarTitleTV() {
        TextView textView = this.toolbarTitleTV;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("toolbarTitleTV");
        return null;
    }

    public final void setToolbarTitleTV(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.toolbarTitleTV = textView;
    }

    public final TextView getCourse_Title() {
        TextView textView = this.Course_Title;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("Course_Title");
        return null;
    }

    public final void setCourse_Title(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.Course_Title = textView;
    }

    public final ClickableWebView getCourseTitleWeb() {
        ClickableWebView clickableWebView = this.courseTitleWeb;
        if (clickableWebView != null) {
            return clickableWebView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("courseTitleWeb");
        return null;
    }

    public final void setCourseTitleWeb(ClickableWebView clickableWebView) {
        Intrinsics.checkNotNullParameter(clickableWebView, "<set-?>");
        this.courseTitleWeb = clickableWebView;
    }

    public final CardView getCourse_banner() {
        CardView cardView = this.course_banner;
        if (cardView != null) {
            return cardView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("course_banner");
        return null;
    }

    public final void setCourse_banner(CardView cardView) {
        Intrinsics.checkNotNullParameter(cardView, "<set-?>");
        this.course_banner = cardView;
    }

    public final RelativeLayout getCourse_bg_layout() {
        RelativeLayout relativeLayout = this.course_bg_layout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("course_bg_layout");
        return null;
    }

    public final void setCourse_bg_layout(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.course_bg_layout = relativeLayout;
    }

    public final RelativeLayout getNo_data_found_RL() {
        RelativeLayout relativeLayout = this.no_data_found_RL;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("no_data_found_RL");
        return null;
    }

    public final void setNo_data_found_RL(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.no_data_found_RL = relativeLayout;
    }

    public final RelativeLayout getRl_title_main() {
        RelativeLayout relativeLayout = this.rl_title_main;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rl_title_main");
        return null;
    }

    public final void setRl_title_main(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.rl_title_main = relativeLayout;
    }

    /* JADX INFO: renamed from: isBook, reason: from getter */
    public final String getIsBook() {
        return this.isBook;
    }

    public final void setBook(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isBook = str;
    }

    public final String getClicktype() {
        return this.clicktype;
    }

    public final void setClicktype(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clicktype = str;
    }

    public final String getAllsubcatindex() {
        return this.allsubcatindex;
    }

    public final void setAllsubcatindex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.allsubcatindex = str;
    }

    public final boolean getIsfilterchanged() {
        return this.isfilterchanged;
    }

    public final void setIsfilterchanged(boolean z) {
        this.isfilterchanged = z;
    }

    /* JADX INFO: renamed from: isFromDashBoard, reason: from getter */
    public final boolean getIsFromDashBoard() {
        return this.isFromDashBoard;
    }

    public final void setFromDashBoard(boolean z) {
        this.isFromDashBoard = z;
    }

    public final String getSelectedLaunguageid() {
        return this.SelectedLaunguageid;
    }

    public final void setSelectedLaunguageid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.SelectedLaunguageid = str;
    }

    public final String getSelectedSubjectid() {
        return this.SelectedSubjectid;
    }

    public final void setSelectedSubjectid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.SelectedSubjectid = str;
    }

    public final boolean getIsfilterapply() {
        return this.isfilterapply;
    }

    public final void setIsfilterapply(boolean z) {
        this.isfilterapply = z;
    }

    public final String getSelectedpositionid() {
        return this.selectedpositionid;
    }

    public final void setSelectedpositionid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedpositionid = str;
    }

    /* JADX INFO: renamed from: isFromTileActivity, reason: from getter */
    public final boolean getIsFromTileActivity() {
        return this.isFromTileActivity;
    }

    public final void setFromTileActivity(boolean z) {
        this.isFromTileActivity = z;
    }

    public final String getAllsubcatindex_id() {
        return this.allsubcatindex_id;
    }

    public final void setAllsubcatindex_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.allsubcatindex_id = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final String getMastercatname() {
        return this.mastercatname;
    }

    public final void setMastercatname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mastercatname = str;
    }

    public final String getMastercatid() {
        return this.mastercatid;
    }

    public final void setMastercatid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mastercatid = str;
    }

    public final String getAllcatindex() {
        return this.allcatindex;
    }

    public final void setAllcatindex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.allcatindex = str;
    }

    public final String getAllcatindex_id() {
        return this.allcatindex_id;
    }

    public final void setAllcatindex_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.allcatindex_id = str;
    }

    /* JADX INFO: renamed from: is_paid, reason: from getter */
    public final String getIs_paid() {
        return this.is_paid;
    }

    public final void set_paid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.is_paid = str;
    }

    public final ArrayList<Courselist> getCourselists() {
        return this.courselists;
    }

    public final void setCourselists(ArrayList<Courselist> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.courselists = arrayList;
    }

    public final RecyclerView getCourseListRV() {
        return this.courseListRV;
    }

    public final void setCourseListRV(RecyclerView recyclerView) {
        this.courseListRV = recyclerView;
    }

    public final TileDataAdapter getTileDataAdapter() {
        return this.tileDataAdapter;
    }

    public final void setTileDataAdapter(TileDataAdapter tileDataAdapter) {
        this.tileDataAdapter = tileDataAdapter;
    }

    public final String getLaunguageindex() {
        return this.launguageindex;
    }

    public final void setLaunguageindex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.launguageindex = str;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final void setContentType(String str) {
        this.contentType = str;
    }

    public final RecyclerView getTileRv() {
        return this.tileRv;
    }

    public final void setTileRv(RecyclerView recyclerView) {
        this.tileRv = recyclerView;
    }

    public final boolean getIspaginationavailable() {
        return this.ispaginationavailable;
    }

    public final void setIspaginationavailable(boolean z) {
        this.ispaginationavailable = z;
    }

    public final RelativeLayout getRoot_view() {
        RelativeLayout relativeLayout = this.root_view;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root_view");
        return null;
    }

    public final void setRoot_view(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.root_view = relativeLayout;
    }

    public final Toolbar getMain_toolbar() {
        Toolbar toolbar = this.main_toolbar;
        if (toolbar != null) {
            return toolbar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("main_toolbar");
        return null;
    }

    public final void setMain_toolbar(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "<set-?>");
        this.main_toolbar = toolbar;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        int color;
        String stringExtra;
        super.onCreate(savedInstanceState);
        CourseTypeActivity courseTypeActivity = this;
        Helper.setSystemBarLight(courseTypeActivity);
        Helper.enableScreenShot(courseTypeActivity);
        CourseTypeActivity courseTypeActivity2 = this;
        setUtkashRoom(UtkashRoom.getAppDatabase(courseTypeActivity2));
        setContentView(R.layout.activity_course_type);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra(Const.NOTIFICATION_CODE, 0);
            this.notification_code = intExtra;
            if (intExtra != 0) {
                pushEventForPushNotification(new StringBuilder().append(intExtra).toString());
            }
            this.course_id = getIntent().getStringExtra("course_id");
            this.fieldid = getIntent().getStringExtra("file_id");
            this.coupon_for = getIntent().getStringExtra("coupon_for");
            this.ts = getIntent().getLongExtra(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, 0L);
            this.audioTable = (AudioTable) getIntent().getSerializableExtra("audiotable");
            this.topicid = getIntent().getStringExtra(Const.TOPIC_ID);
            this.video_type = getIntent().getStringExtra("type");
            this.tiletype = getIntent().getStringExtra(Const.TILE_TYPE);
            this.tileid = getIntent().getStringExtra("tile_id");
            this.revertapi = getIntent().getStringExtra(Const.REVERT_API);
            this.type = getIntent().getStringExtra("type");
            this.title = getIntent().getStringExtra("title");
            this.message_target = getIntent().getStringExtra(TypedValues.AttributesType.S_TARGET);
            this.url = getIntent().getStringExtra("url");
            this.message = getIntent().getStringExtra("description");
            this.searchenable = String.valueOf(getIntent().getStringExtra("searchenable"));
            this.description = String.valueOf(getIntent().getStringExtra("course_description"));
            this.cart_text_color = String.valueOf(getIntent().getStringExtra("cart_text_color"));
            this.cart_bg_color = String.valueOf(getIntent().getStringExtra("cart_bg_color"));
            this.parentid = getIntent().getStringExtra(Const.shareparentid);
            this.contentType_id = getIntent().getStringExtra(Const.TAB_ID);
            this.tabName = getIntent().getStringExtra(Const.TAB_NAME);
            if (MakeMyExam.getTileData() != null) {
                String tileData = MakeMyExam.getTileData();
                Intrinsics.checkNotNullExpressionValue(tileData, "getTileData(...)");
                List<MasteAllCatTable> json = parseJSON(tileData);
                Intrinsics.checkNotNull(json, "null cannot be cast to non-null type java.util.ArrayList<com.appnew.android.table.MasteAllCatTable>");
                this.masterAllCatTables = (ArrayList) json;
            }
            if (MakeMyExam.getTileData2() != null) {
                String tileData2 = MakeMyExam.getTileData2();
                Intrinsics.checkNotNullExpressionValue(tileData2, "getTileData2(...)");
                List<MasteAllCatTable> json2 = parseJSON(tileData2);
                Intrinsics.checkNotNull(json2, "null cannot be cast to non-null type java.util.ArrayList<com.appnew.android.table.MasteAllCatTable>");
                this.masterAllCatTables2 = (ArrayList) json2;
            }
            if (getIntent().getStringExtra(Const.IS_BOOK) != null) {
                String stringExtra2 = getIntent().getStringExtra(Const.IS_BOOK);
                Intrinsics.checkNotNull(stringExtra2);
                this.isBook = stringExtra2;
            } else {
                this.isBook = "0";
            }
            if (getIntent().getStringExtra(Const.FLAG) != null) {
                String stringExtra3 = getIntent().getStringExtra(Const.FLAG);
                Intrinsics.checkNotNull(stringExtra3);
                this.homeScreen_ourCourses = stringExtra3;
            } else {
                this.homeScreen_ourCourses = "0";
            }
            if (getIntent().getStringExtra(Const.MASTER_CATEGORY_ID) != null) {
                stringExtra = getIntent().getStringExtra(Const.MASTER_CATEGORY_ID);
                Intrinsics.checkNotNull(stringExtra);
            } else {
                stringExtra = "1";
            }
            this.masterCategoryId = stringExtra;
        }
        setToolbarTitleTV((TextView) findViewById(R.id.toolbarTitleTV));
        setCourse_banner((CardView) findViewById(R.id.course_banner));
        setCourse_bg_layout((RelativeLayout) findViewById(R.id.course_bg_layout));
        setCourse_Title((TextView) findViewById(R.id.courseTitle));
        setCourseTitleWeb((ClickableWebView) findViewById(R.id.courseTitleWeb));
        setRl_title_main((RelativeLayout) findViewById(R.id.rl_title_main));
        getToolbarTitleTV().setText(this.title);
        setCourseTypeRV((RecyclerView) findViewById(R.id.courseTypeRV));
        setNo_data_found_RL((RelativeLayout) findViewById(R.id.no_data_found_RL));
        this.imageBack = (ImageView) findViewById(R.id.image_back);
        setRoot_view((RelativeLayout) findViewById(R.id.root_view));
        setMain_toolbar((Toolbar) findViewById(R.id.main_toolbar));
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(courseTypeActivity2, window, getRoot_view(), getMain_toolbar());
        }
        ImageView imageView = this.imageBack;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageBack");
            imageView = null;
        }
        imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.CourseTypeActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CourseTypeActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        try {
            String str = this.description;
            if (str != null && str.length() != 0 && !Intrinsics.areEqual(this.description, com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID)) {
                getCourse_banner().setVisibility(0);
                String str2 = this.cart_bg_color;
                if (str2 != null && str2.length() != 0) {
                    try {
                        getCourse_bg_layout().setBackgroundColor(Color.parseColor(this.cart_bg_color));
                    } catch (Exception unused) {
                    }
                }
                String str3 = this.description;
                Intrinsics.checkNotNull(str3);
                if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "<", false, 2, (Object) null)) {
                    getCourse_Title().setVisibility(8);
                    getCourseTitleWeb().setVisibility(0);
                    Helper.TestWebHTMLLoad(getCourseTitleWeb(), this.description);
                } else {
                    String str4 = this.description;
                    Intrinsics.checkNotNull(str4);
                    if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "math-tex", false, 2, (Object) null)) {
                        getCourse_Title().setVisibility(8);
                        getCourseTitleWeb().setVisibility(0);
                        Helper.TestWebHTMLLoad(getCourseTitleWeb(), this.description);
                    } else {
                        getCourse_Title().setVisibility(0);
                        getCourseTitleWeb().setVisibility(8);
                        getCourse_Title().setText(Html.fromHtml(this.description));
                        try {
                            String str5 = this.cart_text_color;
                            if (str5 != null && str5.length() != 0) {
                                color = Color.parseColor(this.cart_text_color);
                            } else {
                                color = ContextCompat.getColor(this, R.color.colorPrimary);
                            }
                        } catch (Exception unused2) {
                            color = ContextCompat.getColor(this, R.color.colorPrimary);
                        }
                        if (Helper.isColorTooLight(color)) {
                            color = ContextCompat.getColor(this, R.color.colorPrimary);
                        }
                        getCourse_Title().setTextColor(color);
                    }
                }
            } else {
                getCourse_banner().setVisibility(8);
            }
        } catch (Exception unused3) {
        }
        getCourseTypeRV().setLayoutManager(new GridLayoutManager(courseTypeActivity2, Intrinsics.areEqual(this.searchenable, "2") ? 3 : 2));
        getCourseTypeRV().setNestedScrollingEnabled(false);
        setDataAdapter(this.masterAllCatTables);
        if (!getUtkashRoom().getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
            List<MasteAllCatTable> list = getUtkashRoom().getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.appnew.android.table.MasteAllCatTable>");
            this.masterAllCatTables = (ArrayList) list;
            this.mastercatlist = getUtkashRoom().getMastercatDao().getmastercat(MakeMyExam.userId);
        }
        this.downarrowIV = (ImageView) findViewById(R.id.downarrowIV);
        getToolbarTitleTV().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.CourseTypeActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.selectDropDown();
            }
        });
        ImageView imageView3 = this.downarrowIV;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downarrowIV");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.CourseTypeActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CourseTypeActivity.onCreate$lambda$2(this.f$0);
            }
        }));
        updatePreference();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(CourseTypeActivity courseTypeActivity) {
        courseTypeActivity.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(CourseTypeActivity courseTypeActivity) {
        courseTypeActivity.selectDropDown();
        return Unit.INSTANCE;
    }

    private final void updatePreference() {
        if (SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE) != null && StringsKt.equals(SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE), "1", true)) {
            ArrayList<Data.Preferences> preferences = SharedPreference.getInstance().getLoggedInUser().getPreferences();
            Intrinsics.checkNotNullExpressionValue(preferences, "getPreferences(...)");
            ArrayList<Data.Preferences> arrayList = preferences;
            new ArrayList();
            ArrayList<MasterCat> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            Iterator<MasteAllCatTable> it = this.masterAllCatTables.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                MasteAllCatTable next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MasteAllCatTable masteAllCatTable = next;
                Iterator<Data.Preferences> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (StringsKt.equals(it2.next().getSub_cat(), masteAllCatTable.getId(), true)) {
                        arrayList3.add(masteAllCatTable);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                for (Object obj : arrayList3) {
                    Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                    MasteAllCatTable masteAllCatTable2 = (MasteAllCatTable) obj;
                    for (MasterCat masterCat : this.mastercatlist) {
                        if (StringsKt.equals(masteAllCatTable2.getMaster_type(), masterCat.getId(), true)) {
                            arrayList2.add(masterCat);
                        }
                    }
                }
                ArrayList<MasterCat> arrayListRemoveDuplicates = removeDuplicates(arrayList2, "");
                if (!arrayListRemoveDuplicates.isEmpty()) {
                    ArrayList<MasterCat> arrayList4 = arrayListRemoveDuplicates;
                    getToolbarTitleTV().setText(arrayList4.get(0).getCat());
                    this.mastercatname = arrayList4.get(0).getCat();
                    String cat = arrayList4.get(0).getCat();
                    Intrinsics.checkNotNullExpressionValue(cat, "getCat(...)");
                    updateMasterCat(cat);
                    this.mastercatid = arrayList4.get(0).getId();
                } else if (!this.mastercatlist.isEmpty()) {
                    getToolbarTitleTV().setText(this.mastercatlist.get(0).getCat());
                    this.mastercatname = this.mastercatlist.get(0).getCat();
                    String cat2 = this.mastercatlist.get(0).getCat();
                    Intrinsics.checkNotNullExpressionValue(cat2, "getCat(...)");
                    updateMasterCat(cat2);
                    this.mastercatid = this.mastercatlist.get(0).getId();
                } else {
                    getToolbarTitleTV().setText(getString(R.string.courses));
                }
            } else {
                getToolbarTitleTV().setText(this.mastercatlist.get(0).getCat());
                this.mastercatname = this.mastercatlist.get(0).getCat();
                String cat3 = this.mastercatlist.get(0).getCat();
                Intrinsics.checkNotNullExpressionValue(cat3, "getCat(...)");
                updateMasterCat(cat3);
                this.mastercatid = this.mastercatlist.get(0).getId();
            }
        }
        selectData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectDropDown() {
        if (StringsKt.equals("1", "7", true)) {
            return;
        }
        CourseTypeActivity courseTypeActivity = this;
        if (!Helper.isNetworkConnected(courseTypeActivity)) {
            Helper.showInternetToast(courseTypeActivity);
            return;
        }
        int i = 0;
        if (SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE) != null && StringsKt.equals(SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE), "1", true)) {
            ArrayList<Data.Preferences> preferences = SharedPreference.getInstance().getLoggedInUser().getPreferences();
            Intrinsics.checkNotNullExpressionValue(preferences, "getPreferences(...)");
            ArrayList<Data.Preferences> arrayList = preferences;
            new ArrayList();
            ArrayList<MasterCat> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            Iterator<MasteAllCatTable> it = this.masterAllCatTables2.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                MasteAllCatTable next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MasteAllCatTable masteAllCatTable = next;
                Iterator<Data.Preferences> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (StringsKt.equals(it2.next().getSub_cat(), masteAllCatTable.getId(), true)) {
                        arrayList3.add(masteAllCatTable);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                for (Object obj : arrayList3) {
                    Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                    MasteAllCatTable masteAllCatTable2 = (MasteAllCatTable) obj;
                    for (MasterCat masterCat : this.mastercatlist) {
                        if (StringsKt.equals(masteAllCatTable2.getMaster_type(), masterCat.getId(), true)) {
                            arrayList2.add(masterCat);
                        }
                    }
                }
            }
            ArrayList<MasterCat> arrayListRemoveDuplicates = removeDuplicates(arrayList2, "");
            PopupMenu popupMenu = new PopupMenu(courseTypeActivity, getToolbarTitleTV(), 3);
            while (i < arrayListRemoveDuplicates.size()) {
                popupMenu.getMenu().add(arrayListRemoveDuplicates.get(i).getCat());
                i++;
            }
            this.clicktype = "1";
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
            return;
        }
        PopupMenu popupMenu2 = new PopupMenu(courseTypeActivity, getToolbarTitleTV(), 3);
        while (i < this.mastercatlist.size()) {
            popupMenu2.getMenu().add(this.mastercatlist.get(i).getCat());
            i++;
        }
        this.clicktype = "1";
        popupMenu2.setOnMenuItemClickListener(this);
        popupMenu2.show();
    }

    private final void selectData() {
        List<? extends MasterCat> list = this.mastercatlist;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<? extends MasterCat> it = this.mastercatlist.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), this.masterCategoryId)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            String cat = this.mastercatlist.get(i).getCat();
            Intrinsics.checkNotNullExpressionValue(cat, "getCat(...)");
            updateMasterCat(cat);
        }
    }

    private final void setDataAdapter(ArrayList<MasteAllCatTable> masterAllCatTables) {
        this.masterAllCatTablesAllTable = masterAllCatTables;
        if (Intrinsics.areEqual(this.searchenable, "2")) {
            getCourseTypeRV().addItemDecoration(new GridSpacingItemDecoration(3, 15, false));
        } else {
            getCourseTypeRV().addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
        }
        this.courseTypeSmallTileAdapter = new CourseTypeSmallTileAdapter(this, masterAllCatTables, this, this.searchenable);
        RecyclerView courseTypeRV = getCourseTypeRV();
        CourseTypeSmallTileAdapter courseTypeSmallTileAdapter = this.courseTypeSmallTileAdapter;
        if (courseTypeSmallTileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseTypeSmallTileAdapter");
            courseTypeSmallTileAdapter = null;
        }
        courseTypeRV.setAdapter(courseTypeSmallTileAdapter);
    }

    @Override // com.appnew.android.Theme.Adapter.DashboardTabAdapter.addDashboardItemClicked
    public void onDashboardItemClicked(int position, String course_id) {
        Intrinsics.checkNotNullParameter(course_id, "course_id");
        Bundle bundle = new Bundle();
        bundle.putInt(Const.NOTIFICATION_CODE, this.notification_code);
        bundle.putString("course_id", course_id);
        bundle.putString("file_id", this.fieldid);
        bundle.putString(Const.TOPIC_ID, this.topicid);
        bundle.putString("tile_id", this.tileid);
        bundle.putString(Const.TILE_TYPE, this.tiletype);
        bundle.putString(Const.REVERT_API, this.revertapi);
        ArrayList<MasteAllCatTable> arrayList = this.masterAllCatTablesAllTable;
        ArrayList<MasteAllCatTable> arrayList2 = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("masterAllCatTablesAllTable");
            arrayList = null;
        }
        bundle.putString("title", arrayList.get(position).getName());
        bundle.putString(TypedValues.AttributesType.S_TARGET, this.message_target);
        bundle.putString("url", this.url);
        bundle.putString("message", this.message);
        bundle.putString("searchenable", this.searchenable);
        bundle.putSerializable("master_cat", (Serializable) this.masterCat);
        bundle.putString(Const.IS_BOOK, this.isBook);
        bundle.putString(Const.TAB_ID, this.contentType_id);
        bundle.putString(Const.TAB_NAME, this.tabName);
        bundle.putString(Const.MASTER_CATEGORY_ID, this.masterCategoryId);
        ArrayList<MasteAllCatTable> arrayList3 = this.masterAllCatTablesAllTable;
        if (arrayList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("masterAllCatTablesAllTable");
            arrayList3 = null;
        }
        bundle.putString(Const.S_ID, arrayList3.get(position).getId());
        this.selectedsub_all_cat.clear();
        Iterator<MasteAllCatTable> it = this.masterAllCatTables2.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            MasteAllCatTable next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            MasteAllCatTable masteAllCatTable = next;
            ArrayList<MasteAllCatTable> arrayList4 = this.masterAllCatTablesAllTable;
            if (arrayList4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("masterAllCatTablesAllTable");
                arrayList4 = null;
            }
            if (arrayList4.get(position).getId().equals(masteAllCatTable.getParent_id())) {
                this.selectedsub_all_cat.add(masteAllCatTable);
            }
        }
        setThemeColor(Const.RED);
        if (this.selectedsub_all_cat.size() > 0) {
            bundle.putString(Const.ALL_CAT_SUB_ID, this.selectedsub_all_cat.get(0).getId());
            ArrayList<MasteAllCatTable> arrayList5 = this.masterAllCatTablesAllTable;
            if (arrayList5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("masterAllCatTablesAllTable");
            } else {
                arrayList2 = arrayList5;
            }
            bundle.putString(Const.ALL_CAT_SUB_NAME, arrayList2.get(position).getName());
            startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle).putExtra("isFromTileActivity", true));
            return;
        }
        XtensionFunctionKt.showLongLengthToast(this, "No Data Found!!!");
    }

    private final void setThemeColor(String color) {
        setSharedPreferences(getSharedPreferences("ThemePref", 0));
        if (StringsKt.equals(color, "lime", true)) {
            getSharedPreferences().edit().putString(this.themeKey, "lime").apply();
            return;
        }
        if (StringsKt.equals(color, Const.RED, true)) {
            getSharedPreferences().edit().putString(this.themeKey, Const.RED).apply();
        } else if (StringsKt.equals(color, "green", true)) {
            getSharedPreferences().edit().putString(this.themeKey, "green").apply();
        } else if (StringsKt.equals(color, "blue", true)) {
            getSharedPreferences().edit().putString(this.themeKey, "blue").apply();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    private final List<MasteAllCatTable> parseJSON(String jsonString) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<? extends MasteAllCatTable>>() { // from class: com.appnew.android.home.Activity.CourseTypeActivity$parseJSON$type$1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        Object objFromJson = gson.fromJson(jsonString, type);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (List) objFromJson;
    }

    public final ArrayList<MasterCat> removeDuplicates(ArrayList<MasterCat> list, String s) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList<MasterCat> arrayList = new ArrayList<>();
        Iterator<MasterCat> it = list.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            MasterCat next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            MasterCat masterCat = next;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        if (StringsKt.equals(arrayList.get(i).getId(), masterCat.getId(), true)) {
                            break;
                        }
                        i++;
                    } else {
                        arrayList.add(masterCat);
                        break;
                    }
                }
            } else {
                arrayList.add(masterCat);
            }
        }
        return arrayList;
    }

    public final ArrayList<Courselist> removeDuplicates(ArrayList<Courselist> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList<Courselist> arrayList = new ArrayList<>();
        Iterator<Courselist> it = list.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Courselist next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Courselist courselist = next;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        if (StringsKt.equals(arrayList.get(i).getId(), courselist.getId(), true)) {
                            break;
                        }
                        i++;
                    } else {
                        arrayList.add(courselist);
                        break;
                    }
                }
            } else {
                arrayList.add(courselist);
            }
        }
        return arrayList;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        CharSequence title;
        List<CourseDataTable> list;
        List<CourseDataTable> list2;
        if (StringsKt.equals(this.clicktype, "3", true)) {
            Intrinsics.checkNotNull(item);
            if (!Intrinsics.areEqual(item.getTitle(), this.allsubcatindex)) {
                Iterator<MasteAllCatTable> it = this.selectedsub_all_cat.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MasteAllCatTable next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    MasteAllCatTable masteAllCatTable = next;
                    if (Intrinsics.areEqual(masteAllCatTable.getName(), item.getTitle())) {
                        this.isfilterchanged = true;
                        this.isfilterapply = false;
                        this.SelectedLaunguageid = "";
                        this.SelectedSubjectid = "";
                        this.is_paid = "";
                        this.pagecount = 1;
                        this.allsubcatindex = masteAllCatTable.getName();
                        if (!this.isFromTileActivity) {
                            this.allsubcatindex_id = masteAllCatTable.getId();
                        }
                        if (this.cardsArrayList.size() > 0) {
                            getTileItems(this.cardsArrayList, 0);
                        }
                        if (getUtkashRoom().getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                            if (StringsKt.equals(getUtkashRoom().getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus(), "true", true)) {
                                getCourseData(true);
                            } else {
                                this.courselists.clear();
                                if (StringsKt.equals(this.contentType_id, "0", true)) {
                                    list2 = getUtkashRoom().getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                                } else {
                                    list2 = getUtkashRoom().getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                                }
                                for (CourseDataTable courseDataTable : list2) {
                                    Courselist courselist = new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getSubject_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode());
                                    if (StringsKt.equals("1", "5", true)) {
                                        if (courselist.getExtra_json().getHome_screen() == null) {
                                            this.courselists.add(courselist);
                                        } else if (StringsKt.equals(this.fromWhere, "ourcourse", true)) {
                                            if (StringsKt.equals(courselist.getExtra_json().getHome_screen(), "1", true)) {
                                                this.courselists.add(courselist);
                                            }
                                        } else {
                                            this.courselists.add(courselist);
                                        }
                                    } else {
                                        this.courselists.add(courselist);
                                    }
                                }
                                if (this.courselists.size() > 0) {
                                    RecyclerView recyclerView = this.courseListRV;
                                    if (recyclerView != null) {
                                        recyclerView.setVisibility(0);
                                    }
                                } else {
                                    RecyclerView recyclerView2 = this.courseListRV;
                                    if (recyclerView2 != null) {
                                        recyclerView2.setVisibility(8);
                                    }
                                }
                                TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                                this.tileDataAdapter = tileDataAdapter;
                                RecyclerView recyclerView3 = this.courseListRV;
                                if (recyclerView3 != null) {
                                    recyclerView3.setAdapter(tileDataAdapter);
                                }
                                RecyclerView recyclerView4 = this.courseListRV;
                                if (recyclerView4 != null) {
                                    recyclerView4.setNestedScrollingEnabled(false);
                                }
                            }
                        } else {
                            getCourseData(true);
                        }
                    }
                }
            }
        } else if (StringsKt.equals(this.clicktype, "2", true)) {
            Intrinsics.checkNotNull(item);
            if (!Intrinsics.areEqual(item.getTitle(), this.allcatindex)) {
                Iterator<MasteAllCatTable> it2 = this.selected_master_cat.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    MasteAllCatTable next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    MasteAllCatTable masteAllCatTable2 = next2;
                    if (Intrinsics.areEqual(masteAllCatTable2.getName(), item.getTitle())) {
                        this.isfilterchanged = true;
                        this.SelectedLaunguageid = "";
                        this.SelectedSubjectid = "";
                        this.is_paid = "";
                        this.isfilterapply = false;
                        this.pagecount = 1;
                        this.allcatindex = String.valueOf(item.getTitle());
                        this.allcatindex_id = masteAllCatTable2.getId();
                        this.selectedsub_all_cat.clear();
                        if (this.cardsArrayList.size() > 0) {
                            getTileItems(this.cardsArrayList, 0);
                        }
                        Iterator<MasteAllCatTable> it3 = this.masterAllCatTables.iterator();
                        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                        while (it3.hasNext()) {
                            MasteAllCatTable next3 = it3.next();
                            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                            MasteAllCatTable masteAllCatTable3 = next3;
                            if (StringsKt.equals(this.allcatindex_id, masteAllCatTable3.getParent_id(), true)) {
                                this.selectedsub_all_cat.add(masteAllCatTable3);
                            }
                        }
                        if (this.selectedsub_all_cat.size() > 0) {
                            this.allsubcatindex = this.selectedsub_all_cat.get(0).getName();
                            if (!this.isFromTileActivity) {
                                this.allsubcatindex_id = this.selectedsub_all_cat.get(0).getId();
                            }
                            RecyclerView recyclerView5 = this.courseListRV;
                            if (recyclerView5 != null) {
                                recyclerView5.setVisibility(0);
                            }
                            if (getUtkashRoom().getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                                if (StringsKt.equals(getUtkashRoom().getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus(), "true", true)) {
                                    getCourseData(true);
                                } else {
                                    this.courselists.clear();
                                    if (StringsKt.equals(this.contentType_id, "0", true)) {
                                        list = getUtkashRoom().getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                                    } else {
                                        list = getUtkashRoom().getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                                    }
                                    for (CourseDataTable courseDataTable2 : list) {
                                        Courselist courselist2 = new Courselist(courseDataTable2.getCourse_id(), courseDataTable2.getTitle(), courseDataTable2.getCover_image(), courseDataTable2.getMrp(), courseDataTable2.getCourse_sp(), courseDataTable2.getValidity(), courseDataTable2.getSubject_id(), courseDataTable2.getLang_id(), courseDataTable2.getDesc_header_image(), courseDataTable2.getExtra_json(), courseDataTable2.getAvg_rating(), courseDataTable2.getUser_rated(), courseDataTable2.getIs_purchased(), courseDataTable2.getCombo_course_ids(), courseDataTable2.getCat_type(), courseDataTable2.getHide_validity(), courseDataTable2.getPayment_mode(), courseDataTable2.getIs_purchased());
                                        if (StringsKt.equals("1", "5", true)) {
                                            if (courselist2.getExtra_json().getHome_screen() == null) {
                                                this.courselists.add(courselist2);
                                            } else if (StringsKt.equals(this.fromWhere, "ourcourse", true)) {
                                                if (StringsKt.equals(courselist2.getExtra_json().getHome_screen(), "1", true)) {
                                                    this.courselists.add(courselist2);
                                                }
                                            } else {
                                                this.courselists.add(courselist2);
                                            }
                                        } else {
                                            this.courselists.add(courselist2);
                                        }
                                    }
                                    if (this.courselists.size() > 0) {
                                        RecyclerView recyclerView6 = this.courseListRV;
                                        if (recyclerView6 != null) {
                                            recyclerView6.setVisibility(0);
                                        }
                                    } else {
                                        RecyclerView recyclerView7 = this.courseListRV;
                                        if (recyclerView7 != null) {
                                            recyclerView7.setVisibility(8);
                                        }
                                    }
                                    TileDataAdapter tileDataAdapter2 = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                                    this.tileDataAdapter = tileDataAdapter2;
                                    RecyclerView recyclerView8 = this.courseListRV;
                                    if (recyclerView8 != null) {
                                        recyclerView8.setAdapter(tileDataAdapter2);
                                    }
                                    RecyclerView recyclerView9 = this.courseListRV;
                                    if (recyclerView9 != null) {
                                        recyclerView9.setNestedScrollingEnabled(false);
                                    }
                                }
                            } else {
                                getCourseData(true);
                            }
                        } else {
                            RecyclerView recyclerView10 = this.courseListRV;
                            if (recyclerView10 != null) {
                                recyclerView10.setVisibility(8);
                            }
                            this.allsubcatindex = "";
                            if (!this.isFromTileActivity) {
                                this.allsubcatindex_id = "";
                            }
                        }
                    }
                }
            }
        } else {
            Intrinsics.checkNotNull(item);
            if (!Intrinsics.areEqual(item.getTitle(), this.mastercatname) && (title = item.getTitle()) != null) {
                updateMasterCat(title);
            }
        }
        return false;
    }

    private final void updateMasterCat(CharSequence item) {
        for (MasterCat masterCat : this.mastercatlist) {
            if (Intrinsics.areEqual(masterCat.getCat(), item)) {
                this.mastercatname = ((String) item).toString();
                this.mastercatid = masterCat.getId();
                getToolbarTitleTV().setText(item);
                this.isfilterchanged = true;
                this.SelectedLaunguageid = "";
                this.SelectedSubjectid = "";
                this.is_paid = "";
                this.isfilterapply = false;
                this.allcatindex = "";
                this.allcatindex_id = "";
                this.clicktype = "";
                this.allsubcatindex = "";
                if (!this.isFromTileActivity) {
                    this.allsubcatindex_id = "";
                }
                this.pagecount = 1;
                this.selectedsub_all_cat.clear();
                this.selected_master_cat.clear();
                Iterator<MasteAllCatTable> it = this.masterAllCatTables.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    MasteAllCatTable next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    MasteAllCatTable masteAllCatTable = next;
                    if (Intrinsics.areEqual(masteAllCatTable.getMaster_type(), this.mastercatid) && StringsKt.equals(masteAllCatTable.getParent_id(), "0", true)) {
                        this.selected_master_cat.add(masteAllCatTable);
                    }
                }
                if (this.selected_master_cat.size() > 0) {
                    ImageView imageView = null;
                    if (this.isFromTileActivity) {
                        ImageView imageView2 = this.downarrowIV;
                        if (imageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("downarrowIV");
                        } else {
                            imageView = imageView2;
                        }
                        imageView.setVisibility(8);
                        getRl_title_main().setBackgroundColor(getColor(R.color.colorPrimary));
                        getToolbarTitleTV().setClickable(false);
                    } else if (this.mastercatlist.get(0).getApp_hide() != null && Intrinsics.areEqual(this.mastercatlist.get(0).getApp_hide(), "1")) {
                        getRl_title_main().setBackgroundColor(getColor(R.color.colorPrimary));
                        ImageView imageView3 = this.downarrowIV;
                        if (imageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("downarrowIV");
                        } else {
                            imageView = imageView3;
                        }
                        imageView.setVisibility(8);
                        TextView toolbarTitleTV = getToolbarTitleTV();
                        toolbarTitleTV.setClickable(false);
                        toolbarTitleTV.setText(this.tabName);
                    } else if (StringsKt.equals("1", "7", true)) {
                        getRl_title_main().setBackgroundColor(getColor(R.color.colorPrimary));
                        ImageView imageView4 = this.downarrowIV;
                        if (imageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("downarrowIV");
                        } else {
                            imageView = imageView4;
                        }
                        imageView.setVisibility(8);
                        getToolbarTitleTV().setClickable(false);
                    } else {
                        ImageView imageView5 = this.downarrowIV;
                        if (imageView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("downarrowIV");
                        } else {
                            imageView = imageView5;
                        }
                        imageView.setVisibility(0);
                        if (StringsKt.equals(BuildConfig.FLAVOR, "Narayana", true)) {
                            getRl_title_main().setBackgroundResource(R.drawable.title_round_bg);
                        }
                        getToolbarTitleTV().setClickable(true);
                    }
                    this.allcatindex = this.selected_master_cat.get(0).getName();
                    this.allcatindex_id = this.selected_master_cat.get(0).getId();
                    RecyclerView courseTypeRV = getCourseTypeRV();
                    Intrinsics.checkNotNull(courseTypeRV);
                    courseTypeRV.setVisibility(0);
                    getNo_data_found_RL().setVisibility(8);
                    setDataAdapter(this.selected_master_cat);
                    Iterator<MasteAllCatTable> it2 = this.masterAllCatTables.iterator();
                    Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        MasteAllCatTable next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                        MasteAllCatTable masteAllCatTable2 = next2;
                        if (StringsKt.equals(this.allcatindex_id, masteAllCatTable2.getParent_id(), true)) {
                            this.selectedsub_all_cat.add(masteAllCatTable2);
                        }
                    }
                    return;
                }
                this.allcatindex = "";
                this.allcatindex_id = "";
                RecyclerView courseTypeRV2 = getCourseTypeRV();
                Intrinsics.checkNotNull(courseTypeRV2);
                courseTypeRV2.setVisibility(8);
                getNo_data_found_RL().setVisibility(0);
                return;
            }
        }
    }

    private final void getTileItems(ArrayList<Cards> cardsArrayList, int pos) {
        this.contentType = cardsArrayList.get(pos).getType() + cardsArrayList.get(pos).getId();
        CourseTypeActivity courseTypeActivity = this;
        TileItemsAdapter tileItemsAdapter = new TileItemsAdapter(courseTypeActivity, this.contentType, cardsArrayList, this);
        RecyclerView recyclerView = this.tileRv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(courseTypeActivity, 0, false));
        }
        RecyclerView recyclerView2 = this.tileRv;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(tileItemsAdapter);
        }
        RecyclerView recyclerView3 = this.tileRv;
        if (recyclerView3 != null) {
            recyclerView3.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView4 = this.tileRv;
        if (recyclerView4 != null) {
            recyclerView4.scrollToPosition(pos);
        }
        Cards cards = cardsArrayList.get(pos);
        Intrinsics.checkNotNullExpressionValue(cards, "get(...)");
        getTileData(cards);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (!Intrinsics.areEqual(apitype, API.get_courses)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_type(this.contentType_id);
        encryptionData.setSub_cat(this.allsubcatindex_id);
        encryptionData.setLang(this.SelectedLaunguageid);
        encryptionData.setPage(new StringBuilder().append(this.pagecount).toString());
        encryptionData.setIs_paid(this.is_paid);
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        Intrinsics.checkNotNull(service);
        return service.get_courses(strEncrypt);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) {
        int size;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        if (Intrinsics.areEqual(apitype, API.get_courses)) {
            try {
                if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                    if (getUtkashRoom().getapidao().is_api_code_exits(MakeMyExam.userId, "ut_010")) {
                        getUtkashRoom().getapidao().update_api_version("ut_010", MakeMyExam.userId, String.valueOf(jsonObject.optLong("time")), String.valueOf(jsonObject.optLong("interval")), String.valueOf(jsonObject.optLong("cd_time")));
                    } else {
                        APITABLE apitable = new APITABLE();
                        apitable.setApicode("ut_010");
                        apitable.setApiname("get_courses");
                        apitable.setInterval(String.valueOf(jsonObject.optLong("interval")));
                        apitable.setUser_id(MakeMyExam.userId);
                        apitable.setTimestamp(String.valueOf(jsonObject.optLong("time")));
                        apitable.setCdtimestamp(String.valueOf(jsonObject.optLong("cd_time")));
                        apitable.setVersion("0.000");
                        getUtkashRoom().getapidao().addUser(apitable);
                    }
                    this.ispaginationavailable = true;
                    Object objFromJson = new Gson().fromJson(jsonObject.toString(), (Class<Object>) CourseResponse.class);
                    Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                    CourseResponse courseResponse = (CourseResponse) objFromJson;
                    if (courseResponse.getData().size() > 0) {
                        new ArrayList().clear();
                        RecyclerView recyclerView = this.courseListRV;
                        Intrinsics.checkNotNull(recyclerView);
                        recyclerView.setVisibility(0);
                        if (courseResponse.getData().size() > 0) {
                            if (!this.isfilterapply) {
                                if (courseResponse.getData().size() < courseResponse.getLimit()) {
                                    if (getUtkashRoom().getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                                        this.ispaginationavailable = false;
                                        getUtkashRoom().getHomeApiStatusdata().updaterecord(String.valueOf(this.pagecount), "false", this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.userId);
                                    } else {
                                        this.ispaginationavailable = false;
                                        HomeApiStatusTable homeApiStatusTable = new HomeApiStatusTable();
                                        homeApiStatusTable.setStatus("false");
                                        homeApiStatusTable.setMain_id(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id);
                                        homeApiStatusTable.setUser_id(MakeMyExam.getUserId());
                                        homeApiStatusTable.setPage(String.valueOf(this.pagecount));
                                        getUtkashRoom().getHomeApiStatusdata().addCoursedata(homeApiStatusTable);
                                    }
                                } else {
                                    if (getUtkashRoom().getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                                        this.ispaginationavailable = true;
                                        getUtkashRoom().getHomeApiStatusdata().updaterecord(String.valueOf(this.pagecount), "true", this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.userId);
                                    } else {
                                        this.ispaginationavailable = true;
                                        HomeApiStatusTable homeApiStatusTable2 = new HomeApiStatusTable();
                                        homeApiStatusTable2.setStatus("true");
                                        homeApiStatusTable2.setMain_id(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id);
                                        homeApiStatusTable2.setUser_id(MakeMyExam.getUserId());
                                        homeApiStatusTable2.setPage(String.valueOf(this.pagecount));
                                        getUtkashRoom().getHomeApiStatusdata().addCoursedata(homeApiStatusTable2);
                                    }
                                }
                            } else if (courseResponse.getData().size() < courseResponse.getLimit()) {
                                this.SelectedLaunguageid = "";
                                this.SelectedSubjectid = "";
                                this.is_paid = "";
                                this.ispaginationavailable = false;
                            } else {
                                this.ispaginationavailable = true;
                            }
                            if (this.pagecount == 1) {
                                this.courselists.clear();
                                if (!this.isfilterapply) {
                                    Iterator<Courselist> it = courseResponse.getData().iterator();
                                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                                    while (it.hasNext()) {
                                        Courselist next = it.next();
                                        if (!getUtkashRoom().getCoursedata().isRecordExistsUserId(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, next.getId(), next.getType_id())) {
                                            CourseDataTable courseDataTable = new CourseDataTable();
                                            courseDataTable.setCourse_id(next.getId());
                                            courseDataTable.setMrp(next.getMrp());
                                            courseDataTable.setCover_image(next.getCover_image());
                                            courseDataTable.setDesc_header_image(next.getDescHeaderImage());
                                            courseDataTable.setTitle(next.getTitle());
                                            courseDataTable.setSubject_id(next.getSubject_id());
                                            courseDataTable.setContent_type(next.getContent_type());
                                            courseDataTable.setLang_id(next.getLang_id());
                                            courseDataTable.setValidity(next.getValidity());
                                            courseDataTable.setUser_id(MakeMyExam.getUserId());
                                            courseDataTable.setCategory(this.contentType_id);
                                            courseDataTable.setCourse_sp(next.getCourseSp());
                                            courseDataTable.setType_id(next.getType_id());
                                            courseDataTable.setCat_type(next.getCat_type());
                                            courseDataTable.setHide_validity(next.getHide_validity());
                                            courseDataTable.setIs_purchased(next.getIs_purchased());
                                            courseDataTable.setDiscount(next.getDiscount());
                                            courseDataTable.setCombo_course_ids(next.getCombo_course_ids());
                                            if (StringsKt.equals("1", "5", true)) {
                                                courseDataTable.setExtra_json(next.getExtra_json());
                                            } else {
                                                courseDataTable.setExtra_json(next.getExtra_json());
                                            }
                                            courseDataTable.setMain_id(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id);
                                            getUtkashRoom().getCoursedata().addCoursedata(courseDataTable);
                                        }
                                    }
                                }
                                size = 0;
                            } else {
                                size = this.courselists.size();
                                if (!this.isfilterapply) {
                                    Iterator<Courselist> it2 = courseResponse.getData().iterator();
                                    Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                                    while (it2.hasNext()) {
                                        Courselist next2 = it2.next();
                                        if (!getUtkashRoom().getCoursedata().isRecordExistsUserId(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, next2.getId(), next2.getType_id())) {
                                            CourseDataTable courseDataTable2 = new CourseDataTable();
                                            courseDataTable2.setCourse_id(next2.getId());
                                            courseDataTable2.setMrp(next2.getMrp());
                                            courseDataTable2.setCover_image(next2.getCover_image());
                                            courseDataTable2.setDesc_header_image(next2.getDescHeaderImage());
                                            courseDataTable2.setTitle(next2.getTitle());
                                            courseDataTable2.setValidity(next2.getValidity());
                                            courseDataTable2.setContent_type(next2.getContent_type());
                                            courseDataTable2.setUser_id(MakeMyExam.getUserId());
                                            courseDataTable2.setSubject_id(next2.getSubject_id());
                                            courseDataTable2.setLang_id(next2.getLang_id());
                                            courseDataTable2.setCategory(this.contentType_id);
                                            courseDataTable2.setCourse_sp(next2.getCourseSp());
                                            courseDataTable2.setCat_type(next2.getCat_type());
                                            courseDataTable2.setHide_validity(next2.getHide_validity());
                                            courseDataTable2.setIs_purchased(next2.getIs_purchased());
                                            courseDataTable2.setDiscount(next2.getDiscount());
                                            courseDataTable2.setType_id(next2.getType_id());
                                            courseDataTable2.setCombo_course_ids(next2.getCombo_course_ids());
                                            if (StringsKt.equals("1", "5", true)) {
                                                courseDataTable2.setExtra_json(next2.getExtra_json());
                                            } else {
                                                courseDataTable2.setExtra_json(next2.getExtra_json());
                                            }
                                            courseDataTable2.setMain_id(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id);
                                            getUtkashRoom().getCoursedata().addCoursedata(courseDataTable2);
                                        }
                                    }
                                }
                            }
                            if (!this.isfilterapply) {
                                Iterator<Courselist> it3 = courseResponse.getData().iterator();
                                Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                                while (it3.hasNext()) {
                                    Courselist next3 = it3.next();
                                    Courselist courselist = new Courselist(next3.getId(), next3.getTitle(), next3.getCover_image(), next3.getMrp(), next3.getCourseSp(), next3.getValidity(), next3.getSubject_id(), next3.getLang_id(), next3.getDescHeaderImage(), next3.getExtra_json(), next3.getAvg_rating(), next3.getUser_rated(), next3.getIs_purchased(), next3.getCombo_course_ids(), next3.getContent_type(), next3.getCat_type(), next3.getHide_validity(), next3.getDescription(), next3.getDiscount(), next3.getDelivery_charge(), next3.getBook_redirection_link(), next3.getPayment_mode());
                                    if (StringsKt.equals("1", "5", true)) {
                                        if (courselist.getExtra_json().getHome_screen() == null) {
                                            this.courselists.add(courselist);
                                        } else if (StringsKt.equals(this.fromWhere, "ourcourse", true)) {
                                            if (StringsKt.equals(courselist.getExtra_json().getHome_screen(), "1", true)) {
                                                this.courselists.add(courselist);
                                            }
                                        } else {
                                            this.courselists.add(courselist);
                                        }
                                    } else {
                                        this.courselists.add(courselist);
                                    }
                                }
                                new ArrayList();
                                ArrayList<Courselist> arrayListRemoveDuplicates = removeDuplicates(this.courselists);
                                this.courselists.clear();
                                this.courselists.addAll(arrayListRemoveDuplicates);
                            } else {
                                Iterator<Courselist> it4 = courseResponse.getData().iterator();
                                Intrinsics.checkNotNullExpressionValue(it4, "iterator(...)");
                                while (it4.hasNext()) {
                                    Courselist next4 = it4.next();
                                    Courselist courselist2 = new Courselist(next4.getId(), next4.getTitle(), next4.getCover_image(), next4.getMrp(), next4.getCourseSp(), next4.getValidity(), next4.getSubject_id(), next4.getLang_id(), next4.getDescHeaderImage(), next4.getExtra_json(), next4.getAvg_rating(), next4.getUser_rated(), next4.getIs_purchased(), next4.getCombo_course_ids(), "", next4.getCat_type(), next4.getHide_validity(), next4.getDescription(), next4.getDiscount(), next4.getDelivery_charge(), next4.getBook_redirection_link(), next4.getPayment_mode());
                                    if (StringsKt.equals("1", "5", true)) {
                                        if (courselist2.getExtra_json().getHome_screen() == null) {
                                            this.courselists.add(courselist2);
                                        } else if (StringsKt.equals(this.fromWhere, "ourcourse", true)) {
                                            if (StringsKt.equals(courselist2.getExtra_json().getHome_screen(), "1", true)) {
                                                this.courselists.add(courselist2);
                                            }
                                        } else {
                                            this.courselists.add(courselist2);
                                        }
                                    } else {
                                        this.courselists.add(courselist2);
                                    }
                                }
                                new ArrayList();
                                ArrayList<Courselist> arrayListRemoveDuplicates2 = removeDuplicates(this.courselists);
                                this.courselists.clear();
                                this.courselists.addAll(arrayListRemoveDuplicates2);
                            }
                            if (this.pagecount == 1) {
                                this.tileDataAdapter = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                                RecyclerView recyclerView2 = this.courseListRV;
                                Intrinsics.checkNotNull(recyclerView2);
                                recyclerView2.setAdapter(this.tileDataAdapter);
                                RecyclerView recyclerView3 = this.courseListRV;
                                Intrinsics.checkNotNull(recyclerView3);
                                recyclerView3.setNestedScrollingEnabled(false);
                                return;
                            }
                            TileDataAdapter tileDataAdapter = this.tileDataAdapter;
                            Intrinsics.checkNotNull(tileDataAdapter);
                            tileDataAdapter.notifyItemRangeInserted(size, this.courselists.size() - size);
                            return;
                        }
                        return;
                    }
                    if (this.courselists == null || this.pagecount != 1) {
                        return;
                    }
                    if (!this.isfilterapply) {
                        HomeApiStatusTable homeApiStatusTable3 = new HomeApiStatusTable();
                        homeApiStatusTable3.setStatus("false");
                        homeApiStatusTable3.setMain_id(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id);
                        homeApiStatusTable3.setUser_id(MakeMyExam.getUserId());
                        homeApiStatusTable3.setPage(String.valueOf(this.pagecount));
                        getUtkashRoom().getHomeApiStatusdata().addCoursedata(homeApiStatusTable3);
                        this.courselists.clear();
                        RecyclerView recyclerView4 = this.courseListRV;
                        Intrinsics.checkNotNull(recyclerView4);
                        recyclerView4.setVisibility(8);
                        return;
                    }
                    if (courseResponse.getData().size() < courseResponse.getLimit()) {
                        this.isfilterapply = false;
                        RecyclerView recyclerView5 = this.courseListRV;
                        Intrinsics.checkNotNull(recyclerView5);
                        recyclerView5.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (!this.isfilterapply) {
                    if (getUtkashRoom().getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                        getUtkashRoom().getHomeApiStatusdata().updaterecord(String.valueOf(this.pagecount), "false", this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.userId);
                    } else {
                        HomeApiStatusTable homeApiStatusTable4 = new HomeApiStatusTable();
                        homeApiStatusTable4.setStatus("false");
                        homeApiStatusTable4.setMain_id(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id);
                        homeApiStatusTable4.setUser_id(MakeMyExam.getUserId());
                        homeApiStatusTable4.setPage(String.valueOf(this.pagecount));
                        getUtkashRoom().getHomeApiStatusdata().addCoursedata(homeApiStatusTable4);
                    }
                }
                this.isfilterapply = false;
                this.ispaginationavailable = false;
                ArrayList<Courselist> arrayList = this.courselists;
                if (arrayList != null && this.pagecount == 1) {
                    arrayList.clear();
                    RecyclerView recyclerView6 = this.courseListRV;
                    Intrinsics.checkNotNull(recyclerView6);
                    recyclerView6.setVisibility(8);
                }
                if (jsonObject.has("auth_code")) {
                    RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.appnew.android.home.interfaces.onButtonClicked
    public void onTitleClicked(Cards cards, ArrayList<Cards> tiles, String contentType, int tilePos) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
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

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String s) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            Intrinsics.checkNotNull(tileDataAdapter);
            tileDataAdapter.onPaymentSuccess(s);
        }
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            Intrinsics.checkNotNull(tileDataAdapter);
            tileDataAdapter.onPaymentError(i, s);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onSuccess(String posTxnId) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            Intrinsics.checkNotNull(tileDataAdapter);
            tileDataAdapter.onSuccess(posTxnId);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(totalAmount, "totalAmount");
        Intrinsics.checkNotNullParameter(referenceId, "referenceId");
        Intrinsics.checkNotNullParameter(scdId, "scdId");
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            Intrinsics.checkNotNull(tileDataAdapter);
            tileDataAdapter.onSuccessEsewa(productId, totalAmount, referenceId, scdId);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onFailed(boolean isFailure) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            Intrinsics.checkNotNull(tileDataAdapter);
            tileDataAdapter.onFailed(isFailure);
        }
    }
}
