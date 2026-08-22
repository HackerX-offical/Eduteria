package com.appnew.android.player;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Size;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.autofill.HintConstants;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.text.Cue;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.core.layout.WindowSizeClass;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.Interfaces.AsyncTaskCompleteListener;
import com.appnew.android.Courses.Modal.OnlineUser;
import com.appnew.android.Courses.PdfUtils.PdfUtils;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.Model.AddOptionModel;
import com.appnew.android.Model.AttemptedUserPoll;
import com.appnew.android.Model.Bookmark;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.ChatUser;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.PlayerPojo.Addindex;
import com.appnew.android.Model.PlayerPojo.DoubtItemData;
import com.appnew.android.Model.PlayerPojo.DoubtResponse;
import com.appnew.android.Model.PlayerPojo.LeaderboardResponse;
import com.appnew.android.Model.PlayerPojo.LiveChat;
import com.appnew.android.Model.PlayerPojo.Metarespo;
import com.appnew.android.Model.PlayerPojo.Pdf;
import com.appnew.android.Model.PlayerPojo.PollResponse;
import com.appnew.android.Model.PlayerPojo.PollResponseData;
import com.appnew.android.Model.PlayerPojo.Polldata;
import com.appnew.android.Model.PlayerPojo.VideoTimeFramePojo;
import com.appnew.android.Model.PollLeaderboard;
import com.appnew.android.Model.PollLocalResult;
import com.appnew.android.Model.SendUserData;
import com.appnew.android.Model.Video;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.MakeMyExamForPoll;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.RealPathUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.SharedPreferencePoll;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.XmppManager;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.player.LiveStreamingYoutube;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionHelper;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.table.UserHistroyTable;
import com.appnew.android.table.YoutubePlayerTable;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageOptionsKt;
import com.canhub.cropper.CropImageView;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.network.connectionclass.ConnectionQuality;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.MuxedStream;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.reflect.TypeToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import info.mqtt.android.service.Ack;
import info.mqtt.android.service.MqttAndroidClient;
import info.mqtt.android.service.QoS;
import io.socket.engineio.client.transports.Polling;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smackx.iot.control.element.IoTSetResponse;
import org.jivesoftware.smackx.muc.MucMessageInterceptor;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jivesoftware.smackx.muc.MultiUserChatManager;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: LiveStreamingYoutube.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ä\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 é\b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\nå\bæ\bç\bè\bé\bB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u009b\u0005\u001a\u00030\u009c\u00052\n\u0010\u009d\u0005\u001a\u0005\u0018\u00010\u009e\u0005H\u0014J\b\u0010\u009f\u0005\u001a\u00030\u009c\u0005J\b\u0010 \u0005\u001a\u00030\u009c\u0005J\n\u0010¡\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010¢\u0005\u001a\u00030\u009c\u0005H\u0002J\u0013\u0010£\u0005\u001a\u00030\u009c\u00052\u0007\u0010¤\u0005\u001a\u00020'H\u0002J\n\u0010¥\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010¦\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010©\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010ª\u0005\u001a\u00030\u009c\u0005H\u0002J\u0012\u0010¬\u0005\u001a\u00020'2\u0007\u0010\u00ad\u0005\u001a\u000208H\u0002J\n\u0010®\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010\u009a\u0001\u001a\u00030\u009c\u0005H\u0002J\u0007\u0010±\u0005\u001a\u00020'J\n\u0010²\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010¶\u0005\u001a\u00030\u009c\u0005H\u0002J\u0016\u0010·\u0005\u001a\u00030\u009c\u00052\n\u0010\u0089\u0002\u001a\u0005\u0018\u00010´\u0001H\u0003J\u0016\u0010¸\u0005\u001a\u00030\u009c\u00052\n\u0010\u009d\u0005\u001a\u0005\u0018\u00010\u009e\u0005H\u0002JG\u0010¹\u0005\u001a\u00030\u009c\u00052\u0007\u0010º\u0005\u001a\u00020'2\u0007\u0010»\u0005\u001a\u00020'2\u0007\u0010¼\u0005\u001a\u00020'2\u0007\u0010½\u0005\u001a\u00020'2\u0007\u0010¾\u0005\u001a\u00020'2\u0007\u0010¿\u0005\u001a\u00020'2\u0007\u0010À\u0005\u001a\u00020'J\u0012\u0010Á\u0005\u001a\u0002082\u0007\u0010Â\u0005\u001a\u00020'H\u0002J\u0011\u0010Ã\u0005\u001a\u00030\u009c\u00052\u0007\u0010Ä\u0005\u001a\u000208J\u001d\u0010Å\u0005\u001a\u00030\u009c\u00052\n\u0010Æ\u0005\u001a\u0005\u0018\u00010\u008f\u00012\u0007\u0010Ä\u0005\u001a\u000208J \u0010Ç\u0005\u001a\u00030\u009c\u00052\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>00j\b\u0012\u0004\u0012\u00020>`2J \u0010È\u0005\u001a\u00030\u009c\u00052\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>00j\b\u0012\u0004\u0012\u00020>`2J\u0011\u0010É\u0005\u001a\u00030\u009c\u00052\u0007\u0010¥\u0003\u001a\u000208J\u0010\u0010Ê\u0005\u001a\u00020!2\u0007\u0010Ë\u0005\u001a\u000208J\n\u0010Ì\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010Î\u0005\u001a\u00030\u009c\u0005H\u0002J\u0013\u0010Ï\u0005\u001a\u00030\u009c\u00052\u0007\u0010¥\u0003\u001a\u000208H\u0002J\u0013\u0010Ð\u0005\u001a\u00030\u009c\u00052\u0007\u0010¥\u0003\u001a\u000208H\u0002J\n\u0010Ñ\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010Ò\u0005\u001a\u00030\u009c\u0005H\u0002J\u0016\u0010Ó\u0005\u001a\u00030\u009c\u00052\n\u0010\u009d\u0005\u001a\u0005\u0018\u00010\u009e\u0005H\u0002J\n\u0010Ô\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010Õ\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010Ö\u0005\u001a\u00030\u009c\u0005H\u0002J\u0012\u0010×\u0005\u001a\u00030\u009c\u00052\b\u0010Ø\u0005\u001a\u00030Æ\u0003J\n\u0010Ù\u0005\u001a\u00030\u009c\u0005H\u0002J\b\u0010Ú\u0005\u001a\u00030\u009c\u0005J\b\u0010Û\u0005\u001a\u00030\u009c\u0005J\b\u0010Ü\u0005\u001a\u00030\u009c\u0005J\n\u0010Ý\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010Þ\u0005\u001a\u00030\u009c\u0005H\u0002J\u0015\u0010ß\u0005\u001a\u00030\u009c\u00052\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010!H\u0002J\n\u0010à\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010á\u0005\u001a\u00030\u009c\u0005H\u0002J\u0014\u0010â\u0005\u001a\u00030\u009c\u00052\b\u0010ã\u0005\u001a\u00030ä\u0005H\u0016J\u0013\u0010å\u0005\u001a\u00030\u009c\u00052\u0007\u0010æ\u0005\u001a\u000208H\u0016J\u001d\u0010ç\u0005\u001a\u00030\u009c\u00052\u0007\u0010è\u0005\u001a\u00020!2\b\u0010é\u0005\u001a\u00030\u0090\u0005H\u0016J\u0014\u0010ê\u0005\u001a\u00030\u009c\u00052\b\u0010ë\u0005\u001a\u00030ì\u0005H\u0016J\n\u0010í\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010À\u0004\u001a\u00030\u009c\u0005H\u0002J\n\u0010ð\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010ñ\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010ò\u0005\u001a\u00030\u009c\u0005H\u0002J\b\u0010ó\u0005\u001a\u00030\u009c\u0005J\b\u0010ô\u0005\u001a\u00030\u009c\u0005J\b\u0010õ\u0005\u001a\u00030\u009c\u0005J\n\u0010ö\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010÷\u0005\u001a\u00030\u009c\u0005H\u0002J\b\u0010Ò\u0001\u001a\u00030\u009c\u0005J\n\u0010þ\u0005\u001a\u00030\u009c\u0005H\u0002J\n\u0010ÿ\u0005\u001a\u00030\u009c\u0005H\u0002J\u0011\u0010\u008e\u0006\u001a\u00030\u009c\u00052\u0007\u0010\u008f\u0006\u001a\u00020\u0015J\u0014\u0010\u0090\u0006\u001a\u00030\u009c\u00052\b\u0010\u0091\u0006\u001a\u00030ÿ\u0001H\u0002J\u0011\u0010\u009b\u0006\u001a\u00030\u009c\u00052\u0007\u0010\u008f\u0006\u001a\u00020\u0015J\n\u0010\u009c\u0006\u001a\u00030\u009c\u0005H\u0002J\u0013\u0010\u009d\u0006\u001a\u00030\u009c\u00052\t\u0010\u009e\u0006\u001a\u0004\u0018\u00010!J&\u0010\u009f\u0006\u001a\u00030\u009c\u00052\t\u0010\u009e\u0006\u001a\u0004\u0018\u00010!2\u0007\u0010Á\u0001\u001a\u00020!2\b\u0010 \u0006\u001a\u00030¡\u0006J\u0014\u0010¢\u0006\u001a\u00030\u009c\u00052\n\u0010\u0097\u0004\u001a\u0005\u0018\u00010¨\u0002J.\u0010£\u0006\u001a\u00030\u009c\u00052\u0007\u0010¤\u0006\u001a\u00020!2\u0007\u0010ê\u0002\u001a\u00020!2\u0007\u0010ë\u0002\u001a\u00020!2\u0007\u0010ì\u0002\u001a\u00020!H\u0002J\u0012\u0010¥\u0006\u001a\u00020!2\u0007\u0010¦\u0006\u001a\u00020\u0015H\u0002J\u0012\u0010§\u0006\u001a\u00030\u009c\u00052\b\u0010¨\u0006\u001a\u00030©\u0006J\n\u0010ª\u0006\u001a\u00030\u009c\u0005H\u0014J\n\u0010±\u0006\u001a\u00030\u009c\u0005H\u0014J\u0011\u0010²\u0006\u001a\u00030\u009c\u00052\u0007\u0010ì\u0002\u001a\u000208J\u0011\u0010³\u0006\u001a\u00030\u009c\u00052\u0007\u0010´\u0006\u001a\u00020'J\n\u0010µ\u0006\u001a\u00030\u009c\u0005H\u0002J\n\u0010¶\u0006\u001a\u00030\u009c\u0005H\u0002J\n\u0010·\u0006\u001a\u00030\u009c\u0005H\u0002J\u0013\u0010¸\u0006\u001a\u00030\u009c\u00052\u0007\u0010\u0089\u0001\u001a\u00020!H\u0002J\n\u0010¿\u0006\u001a\u00030\u009c\u0005H\u0002J\n\u0010À\u0006\u001a\u00030\u009c\u0005H\u0002J\n\u0010Á\u0006\u001a\u00030\u009c\u0005H\u0014J\b\u0010Â\u0006\u001a\u00030\u009c\u0005J\n\u0010Æ\u0006\u001a\u00030\u009c\u0005H\u0014J\n\u0010Ç\u0006\u001a\u00030\u009c\u0005H\u0002J\n\u0010È\u0006\u001a\u00030\u009c\u0005H\u0002J\n\u0010É\u0006\u001a\u00030\u009c\u0005H\u0014J%\u0010Ê\u0006\u001a\u00030\u009c\u00052\u0019\u0010Ë\u0006\u001a\u0014\u0012\u0005\u0012\u00030Ì\u000600j\t\u0012\u0005\u0012\u00030Ì\u0006`2H\u0016J\u0013\u0010Í\u0006\u001a\u00030\u009c\u00052\u0007\u0010Î\u0006\u001a\u00020'H\u0016J\u0013\u0010Ï\u0006\u001a\u00030\u009c\u00052\u0007\u0010Ð\u0006\u001a\u00020!H\u0016J\n\u0010Ñ\u0006\u001a\u00030\u009c\u0005H\u0002J\u001e\u0010Ò\u0006\u001a\u00020!2\n\u0010Ó\u0006\u001a\u0005\u0018\u00010Ô\u00062\u0007\u0010Õ\u0006\u001a\u00020!H\u0002J\u0011\u0010Ö\u0006\u001a\u00030\u009c\u00052\u0007\u0010×\u0006\u001a\u00020!J2\u0010Ø\u0006\u001a\u00030\u009c\u00052\u0006\u0010E\u001a\u0002082\u000e\u0010Ù\u0006\u001a\t\u0012\u0004\u0012\u00020!0Ú\u00062\b\u0010Û\u0006\u001a\u00030Ü\u0006H\u0016¢\u0006\u0003\u0010Ý\u0006J\u0012\u0010Þ\u0006\u001a\u00030\u009c\u00052\b\u0010¨\u0006\u001a\u00030©\u0006J0\u0010ß\u0006\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010à\u00062\u0007\u0010á\u0006\u001a\u00020!2\u0007\u0010â\u0006\u001a\u00020!2\b\u0010ã\u0006\u001a\u00030ä\u0006H\u0016J/\u0010ë\u0006\u001a\u00030\u009c\u00052\b\u0010 \u0006\u001a\u00030¡\u00062\u0007\u0010á\u0006\u001a\u00020!2\u0007\u0010â\u0006\u001a\u00020!2\u0007\u0010ì\u0006\u001a\u00020'H\u0016J%\u0010í\u0006\u001a\u00030\u009c\u00052\u0007\u0010 \u0006\u001a\u00020!2\u0007\u0010á\u0006\u001a\u00020!2\u0007\u0010â\u0006\u001a\u00020!H\u0016J\b\u0010ô\u0006\u001a\u00030\u009c\u0005J\b\u0010õ\u0006\u001a\u00030\u009c\u0005J\n\u0010ö\u0006\u001a\u00030\u009c\u0005H\u0002J\u0011\u0010÷\u0006\u001a\u00030\u009c\u00052\u0007\u0010ø\u0006\u001a\u000208J\b\u0010ù\u0006\u001a\u00030\u009c\u0005J\n\u0010ú\u0006\u001a\u00030\u009c\u0005H\u0002J\n\u0010û\u0006\u001a\u00030\u009c\u0005H\u0002J\n\u0010ü\u0006\u001a\u00030\u009c\u0005H\u0002J\n\u0010ý\u0006\u001a\u00030\u009c\u0005H\u0002JG\u0010þ\u0006\u001a\u00030\u009c\u00052\u0007\u0010ÿ\u0006\u001a\u0002082\u0007\u0010\u0080\u0007\u001a\u0002082\u0007\u0010\u0081\u0007\u001a\u0002082\u0007\u0010\u0082\u0007\u001a\u0002082\u0007\u0010\u0083\u0007\u001a\u0002082\u0007\u0010\u0084\u0007\u001a\u0002082\u0007\u0010\u0085\u0007\u001a\u000208J\u001a\u0010\u0086\u0007\u001a\u00030\u009c\u00052\u0007\u0010\u0087\u0007\u001a\u00020!2\u0007\u0010\u0088\u0007\u001a\u00020!J\u001c\u0010\u0089\u0007\u001a\u00030\u009c\u00052\u0007\u0010·\u0004\u001a\u00020\u00152\t\u0010\u008a\u0007\u001a\u0004\u0018\u00010!J%\u0010\u0089\u0007\u001a\u00030\u009c\u00052\u0007\u0010·\u0004\u001a\u00020\u00152\t\u0010\u008a\u0007\u001a\u0004\u0018\u00010!2\u0007\u0010\u0088\u0007\u001a\u00020!J$\u0010\u0086\u0007\u001a\u00030\u009c\u00052\u0007\u0010\u0087\u0007\u001a\u00020!2\u0007\u0010\u0088\u0007\u001a\u00020!2\b\u0010\u008b\u0007\u001a\u00030\u008c\u0007J&\u0010\u0089\u0007\u001a\u00030\u009c\u00052\u0007\u0010·\u0004\u001a\u00020\u00152\t\u0010\u008a\u0007\u001a\u0004\u0018\u00010!2\b\u0010\u008b\u0007\u001a\u00030\u008c\u0007J\u0010\u0010\u008d\u0007\u001a\u00020!2\u0007\u0010\u008e\u0007\u001a\u00020!J\u001b\u0010§\u0006\u001a\u00030\u009c\u00052\b\u0010¨\u0006\u001a\u00030Ì\u00022\u0007\u0010¥\u0003\u001a\u000208J.\u0010\u0092\u0007\u001a\u00030\u009c\u00052\u0007\u0010¤\u0006\u001a\u00020!2\u0007\u0010\u0093\u0007\u001a\u00020!2\u0007\u0010\u0094\u0007\u001a\u00020!2\u0007\u0010\u0095\u0007\u001a\u00020!H\u0002J\b\u0010\u0096\u0007\u001a\u00030\u009c\u0005J\b\u0010\u0097\u0007\u001a\u00030\u009c\u0005J\u0012\u0010ª\u0007\u001a\u00030\u009c\u00052\b\u0010«\u0007\u001a\u00030\u0086\u0002J\u0012\u0010¬\u0007\u001a\u0002082\u0007\u0010Ë\u0005\u001a\u000208H\u0002J\u001b\u0010\u00ad\u0007\u001a\u00030\u009c\u00052\b\u0010®\u0007\u001a\u00030ÿ\u00012\u0007\u0010\u008f\u0007\u001a\u000208J\u001b\u0010¯\u0007\u001a\u00030\u009c\u00052\b\u0010®\u0007\u001a\u00030ÿ\u00012\u0007\u0010\u008f\u0007\u001a\u000208J\n\u0010°\u0007\u001a\u00030\u009c\u0005H\u0002J\u0011\u0010±\u0007\u001a\u00030\u009c\u00052\u0007\u0010¥\u0003\u001a\u000208J\n\u0010»\u0007\u001a\u00030\u009c\u0005H\u0002J\u0013\u0010¼\u0007\u001a\u00030\u009c\u00052\u0007\u0010½\u0007\u001a\u00020'H\u0016J\n\u0010¾\u0007\u001a\u00030\u009c\u0005H\u0002J\b\u0010¿\u0007\u001a\u00030\u009c\u0005JF\u0010À\u0007\u001a\u00030\u009c\u00052\t\u0010¤\u0006\u001a\u0004\u0018\u00010!2\u0007\u0010Á\u0007\u001a\u00020!2\u0007\u0010Â\u0007\u001a\u00020'2\t\u0010Ã\u0007\u001a\u0004\u0018\u00010!2\t\u0010ü\u0002\u001a\u0004\u0018\u00010!2\t\u0010Ä\u0007\u001a\u0004\u0018\u00010!J\u0013\u0010Å\u0007\u001a\u00030\u009c\u00052\u0007\u0010\u0089\u0001\u001a\u00020!H\u0002J\u0012\u0010Ì\u0007\u001a\u00030\u009c\u00052\b\u0010Í\u0007\u001a\u00030Î\u0007J\b\u0010ô\u0007\u001a\u00030\u009c\u0005J\n\u0010õ\u0007\u001a\u00030\u009c\u0005H\u0002J\n\u0010ö\u0007\u001a\u00030\u009c\u0005H\u0002J\n\u0010÷\u0007\u001a\u00030\u009c\u0005H\u0002J\u0013\u0010ø\u0007\u001a\u00030\u009c\u00052\u0007\u0010ù\u0007\u001a\u00020!H\u0002J\u001a\u0010ú\u0007\u001a\u00030\u009c\u00052\u0007\u0010ù\u0007\u001a\u00020!2\u0007\u0010û\u0007\u001a\u00020'J'\u0010ü\u0007\u001a\u00030\u009c\u00052\b\u0010ý\u0007\u001a\u00030Ý\u00072\u0007\u0010þ\u0007\u001a\u00020!2\b\u0010ÿ\u0007\u001a\u00030\u0080\bH\u0002J\u001c\u0010\u0081\b\u001a\u00030\u009c\u00052\u0007\u0010\u0082\b\u001a\u00020!2\u0007\u0010\u0083\b\u001a\u00020'H\u0002J\n\u0010\u0084\b\u001a\u00030\u009c\u0005H\u0002J\u0012\u0010\u0085\b\u001a\u00030\u009c\u00052\b\u0010ý\u0007\u001a\u00030Ý\u0007J\b\u0010\u008b\b\u001a\u00030\u009c\u0005J)\u0010\u008c\b\u001a\u00030\u009c\u00052\u0007\u0010\u008d\b\u001a\u00020!2\b\u0010\u008e\b\u001a\u00030ú\u00042\n\u0010\u008f\b\u001a\u0005\u0018\u00010\u0087\bH\u0002J)\u0010\u0090\b\u001a\u00030\u009c\u00052\u0007\u0010\u0091\b\u001a\u00020!2\n\u0010\u008e\b\u001a\u0005\u0018\u00010ú\u00042\n\u0010\u008f\b\u001a\u0005\u0018\u00010\u0087\bJ \u0010\u0092\b\u001a\u00030\u009c\u00052\n\u0010\u008e\b\u001a\u0005\u0018\u00010ú\u00042\n\u0010\u008f\b\u001a\u0005\u0018\u00010\u0087\bJ\u0011\u0010\u0093\b\u001a\u00030\u009c\u00052\u0007\u0010\u0094\b\u001a\u00020'J\u0011\u0010\u0095\b\u001a\u00030\u009c\u00052\u0007\u0010\u0096\b\u001a\u00020'J\u0013\u0010\u0097\b\u001a\u00030\u009c\u00052\u0007\u0010\u0082\b\u001a\u00020!H\u0002J\u0013\u0010\u0098\b\u001a\u00030\u009c\u00052\u0007\u0010\u0099\b\u001a\u00020!H\u0002J\u0013\u0010\u009a\b\u001a\u00020'2\b\u0010«\u0007\u001a\u00030\u0086\u0002H\u0002J\u0014\u0010\u009b\b\u001a\u00030\u009c\u00052\b\u0010«\u0007\u001a\u00030\u0086\u0002H\u0002J\u0013\u0010\u009c\b\u001a\u00030\u009c\u00052\u0007\u0010\u0099\b\u001a\u00020!H\u0002J\u0013\u0010\u009d\b\u001a\u00030\u009c\u00052\u0007\u0010\u0099\b\u001a\u00020!H\u0002J\u001c\u0010\u009e\b\u001a\u00030\u009c\u00052\u0007\u0010\u0099\b\u001a\u00020!2\u0007\u0010\u009f\b\u001a\u00020'H\u0002J\t\u0010 \b\u001a\u00020!H\u0002J&\u0010¡\b\u001a\u00020!2\u0007\u0010\u0087\u0007\u001a\u00020!2\u0007\u0010\u0088\u0007\u001a\u00020!2\t\u0010¢\b\u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010£\b\u001a\u00020!2\u0007\u0010\u0087\u0007\u001a\u00020!H\u0002J\u0010\u0010¤\b\u001a\u00020!2\u0007\u0010\u0087\u0007\u001a\u00020!J\u0007\u0010¥\b\u001a\u00020!J\u0007\u0010¦\b\u001a\u00020!J\u0010\u0010§\b\u001a\u00020!2\u0007\u0010¨\b\u001a\u00020!J#\u0010©\b\u001a\u00030\u009c\u00052\u0007\u0010ª\b\u001a\u00020!2\u0007\u0010\u008d\b\u001a\u00020!2\u0007\u0010Á\u0001\u001a\u00020!J#\u0010«\b\u001a\u00030\u009c\u00052\u0007\u0010\u0091\b\u001a\u00020!2\u0007\u0010\u008d\b\u001a\u00020!2\u0007\u0010Á\u0001\u001a\u00020!J,\u0010¬\b\u001a\u00030\u009c\u00052\u0007\u0010\u0099\b\u001a\u00020!2\u0007\u0010\u00ad\b\u001a\u00020!2\u0007\u0010Á\u0001\u001a\u00020!2\u0007\u0010®\b\u001a\u00020!J\u001a\u0010¯\b\u001a\u00030\u009c\u00052\u0007\u0010\u0091\b\u001a\u00020!2\u0007\u0010\u008d\b\u001a\u00020!J\u001c\u0010°\b\u001a\u00030\u009c\u00052\u0007\u0010\u0099\b\u001a\u00020!2\u0007\u0010\u008d\b\u001a\u00020!H\u0002J\u001b\u0010±\b\u001a\u00030\u009c\u00052\u000f\u0010²\b\u001a\n\u0012\u0005\u0012\u00030³\b0\u008d\u0001H\u0002J\b\u0010´\b\u001a\u00030\u009c\u0005J\b\u0010µ\b\u001a\u00030\u009c\u0005J\n\u0010¶\b\u001a\u00030\u009c\u0005H\u0002J\u001c\u0010·\b\u001a\u00030\u009c\u00052\u0007\u0010ª\b\u001a\u00020!2\u0007\u0010\u008d\b\u001a\u00020!H\u0002J\b\u0010¸\b\u001a\u00030\u009c\u0005J\u001e\u0010¹\b\u001a\u00030\u009c\u00052\b\u0010\u0097\u0004\u001a\u00030¥\u00012\b\u0010º\b\u001a\u00030»\bH\u0002J\u0013\u0010¼\b\u001a\u00030\u009c\u00052\u0007\u0010½\b\u001a\u00020!H\u0002J\u0013\u0010¾\b\u001a\u00030¿\b2\t\u0010½\b\u001a\u0004\u0018\u00010!J\u0011\u0010À\b\u001a\u00030\u009c\u00052\u0007\u0010\u0094\b\u001a\u00020'J\n\u0010Á\b\u001a\u00030\u009c\u0005H\u0002J\u0012\u0010Â\b\u001a\u00030\u009c\u00052\b\u0010Ã\b\u001a\u00030¿\bJ\n\u0010Ä\b\u001a\u00030\u009c\u0005H\u0002J\u0010\u0010Å\b\u001a\u0002082\u0007\u0010Æ\b\u001a\u000208J\n\u0010Ç\b\u001a\u00030\u009c\u0005H\u0002J\n\u0010È\b\u001a\u00030\u009c\u0005H\u0002J\t\u0010É\b\u001a\u00020'H\u0002J\n\u0010Ý\b\u001a\u00030\u009c\u0005H\u0002J\n\u0010Þ\b\u001a\u00030\u009c\u0005H\u0002J\n\u0010ß\b\u001a\u00030\u009c\u0005H\u0002J\n\u0010à\b\u001a\u00030\u009c\u0005H\u0002J\n\u0010á\b\u001a\u00030\u009c\u0005H\u0002J\u0011\u0010â\b\u001a\u00030\u009c\u00052\u0007\u0010ã\b\u001a\u00020'J\t\u0010ä\b\u001a\u00020'H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R.\u0010/\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u000100j\n\u0012\u0004\u0012\u000201\u0018\u0001`2X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u00107\u001a\u000208X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>00j\b\u0012\u0004\u0012\u00020>`2X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00104\"\u0004\b@\u00106R\u001a\u0010A\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R\u0012\u0010C\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010:\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\u001a\u0010R\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010#\"\u0004\bT\u0010%R\u001c\u0010U\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010#\"\u0004\bW\u0010%R\u0010\u0010X\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Y\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010#\"\u0004\b[\u0010%R\u001a\u0010\\\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010(\"\u0004\b^\u0010*R\u001a\u0010_\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010:\"\u0004\ba\u0010HR\u0010\u0010b\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010l\u001a\u0004\u0018\u00010jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001c\u0010q\u001a\u0004\u0018\u00010dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u000e\u0010v\u001a\u00020wX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010x\u001a\u0004\u0018\u00010yX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R \u0010~\u001a\u0004\u0018\u00010\u007fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u000f\u0010\u0084\u0001\u001a\u00020'X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0089\u0001\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010#\"\u0005\b\u008b\u0001\u0010%R\u0018\u0010\u008c\u0001\u001a\u000b\u0012\u0004\u0012\u00020!\u0018\u00010\u008d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0011\u0010\u0094\u0001\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u0012\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010©\u0001\u001a\u0005\u0018\u00010¨\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ª\u0001\u001a\u0005\u0018\u00010¨\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010«\u0001\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010®\u0001\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¯\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010°\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010±\u0001\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010²\u0001\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010µ\u0001\u001a\u0005\u0018\u00010´\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¶\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010·\u0001\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R\u0012\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¾\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010¿\u0001\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u0010(\"\u0005\bÀ\u0001\u0010*R\u000f\u0010Á\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Â\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ã\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ä\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Å\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Æ\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ç\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010È\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010É\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ê\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ë\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ì\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Í\u0001\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010Ð\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0001\u0010\u0091\u0001\"\u0006\bÒ\u0001\u0010\u0093\u0001R\u001d\u0010Ó\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0001\u0010#\"\u0005\bÕ\u0001\u0010%R!\u0010Ö\u0001\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b×\u0001\u0010¹\u0001\"\u0006\bØ\u0001\u0010»\u0001R!\u0010Ù\u0001\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÚ\u0001\u0010¹\u0001\"\u0006\bÛ\u0001\u0010»\u0001R!\u0010Ü\u0001\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÝ\u0001\u0010¹\u0001\"\u0006\bÞ\u0001\u0010»\u0001R!\u0010ß\u0001\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bà\u0001\u0010¹\u0001\"\u0006\bá\u0001\u0010»\u0001R\"\u0010â\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bã\u0001\u0010\u0091\u0001\"\u0006\bä\u0001\u0010\u0093\u0001R\"\u0010å\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bæ\u0001\u0010\u0091\u0001\"\u0006\bç\u0001\u0010\u0093\u0001R\"\u0010è\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bé\u0001\u0010\u0091\u0001\"\u0006\bê\u0001\u0010\u0093\u0001R\"\u0010ë\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bì\u0001\u0010í\u0001\"\u0006\bî\u0001\u0010ï\u0001R!\u0010ð\u0001\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bñ\u0001\u0010¹\u0001\"\u0006\bò\u0001\u0010»\u0001R!\u0010ó\u0001\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bô\u0001\u0010¹\u0001\"\u0006\bõ\u0001\u0010»\u0001R\u000f\u0010ö\u0001\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010÷\u0001\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b÷\u0001\u0010(\"\u0005\bø\u0001\u0010*R\u001d\u0010ù\u0001\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bù\u0001\u0010(\"\u0005\bú\u0001\u0010*R\"\u0010û\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bü\u0001\u0010í\u0001\"\u0006\bý\u0001\u0010ï\u0001R3\u0010þ\u0001\u001a\u0018\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u000100j\u000b\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u0001`2X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0002\u00104\"\u0005\b\u0081\u0002\u00106R3\u0010\u0082\u0002\u001a\u0018\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u000100j\u000b\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u0001`2X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0002\u00104\"\u0005\b\u0084\u0002\u00106R3\u0010\u0085\u0002\u001a\u0018\u0012\u0007\u0012\u0005\u0018\u00010\u0086\u000200j\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0086\u0002`2X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0002\u00104\"\u0005\b\u0088\u0002\u00106R\"\u0010\u0089\u0002\u001a\u0005\u0018\u00010´\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002\"\u0006\b\u008c\u0002\u0010\u008d\u0002R\u0012\u0010\u008e\u0002\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0093\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002\"\u0006\b\u0096\u0002\u0010\u0097\u0002R\"\u0010\u0098\u0002\u001a\u0005\u0018\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0002\u0010í\u0001\"\u0006\b\u009a\u0002\u0010ï\u0001R\"\u0010\u009b\u0002\u001a\u0005\u0018\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0002\u0010í\u0001\"\u0006\b\u009d\u0002\u0010ï\u0001R\u001d\u0010\u009e\u0002\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0002\u0010#\"\u0005\b \u0002\u0010%R\u0012\u0010¡\u0002\u001a\u0005\u0018\u00010¢\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010£\u0002\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0002\u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010§\u0002\u001a\u0005\u0018\u00010¨\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0002\u0010ª\u0002\"\u0006\b«\u0002\u0010¬\u0002R\u001f\u0010\u00ad\u0002\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0002\u0010#\"\u0005\b¯\u0002\u0010%R\u001f\u0010°\u0002\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0002\u0010#\"\u0005\b²\u0002\u0010%R\u001f\u0010³\u0002\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0002\u0010#\"\u0005\bµ\u0002\u0010%R\"\u0010¶\u0002\u001a\u0005\u0018\u00010·\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0002\u0010¹\u0002\"\u0006\bº\u0002\u0010»\u0002R\u001d\u0010¼\u0002\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0002\u0010(\"\u0005\b½\u0002\u0010*R\u0012\u0010¾\u0002\u001a\u0005\u0018\u00010¿\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010À\u0002\u001a\u0005\u0018\u00010Á\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Â\u0002\u001a\u0005\u0018\u00010Ã\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010Ä\u0002\u001a\u0005\u0018\u00010Å\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0002\u0010Ç\u0002\"\u0006\bÈ\u0002\u0010É\u0002R\u0017\u0010Ê\u0002\u001a\n\u0012\u0005\u0012\u00030Ì\u00020Ë\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010Í\u0002\u001a\u0018\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u000100j\u000b\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u0001`2X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0002\u00104\"\u0005\bÏ\u0002\u00106R\u0017\u0010Ð\u0002\u001a\n\u0012\u0005\u0012\u00030Ì\u00020Ë\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Ñ\u0002\u001a\n\u0012\u0005\u0012\u00030Ò\u00020Ë\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Ó\u0002\u001a\u0005\u0018\u00010Ô\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Õ\u0002\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ö\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010×\u0002\u001a\u0005\u0018\u00010Ô\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ø\u0002\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ù\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ú\u0002\u001a\u0005\u0018\u00010Ô\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Û\u0002\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ü\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ý\u0002\u001a\u0005\u0018\u00010Ô\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Þ\u0002\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ß\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010à\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010á\u0002\u001a\u0005\u0018\u00010Ô\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010â\u0002\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ã\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ä\u0002\u001a\u0005\u0018\u00010Ô\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010å\u0002\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010æ\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ç\u0002\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010è\u0002\u001a\u0005\u0018\u00010é\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ê\u0002\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ë\u0002\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ì\u0002\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010í\u0002\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010î\u0002\u001a\u0005\u0018\u00010ï\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010ð\u0002\u001a\u0005\u0018\u00010ñ\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bò\u0002\u0010ó\u0002\"\u0006\bô\u0002\u0010õ\u0002R\"\u0010ö\u0002\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b÷\u0002\u0010\u0091\u0001\"\u0006\bø\u0002\u0010\u0093\u0001R\u001f\u0010ù\u0002\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bú\u0002\u0010#\"\u0005\bû\u0002\u0010%R\u001f\u0010ü\u0002\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bý\u0002\u0010#\"\u0005\bþ\u0002\u0010%R\u001f\u0010ÿ\u0002\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0003\u0010#\"\u0005\b\u0081\u0003\u0010%R\u001f\u0010\u0082\u0003\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0003\u0010#\"\u0005\b\u0084\u0003\u0010%R\u001f\u0010\u0085\u0003\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0003\u0010#\"\u0005\b\u0087\u0003\u0010%R\"\u0010\u0088\u0003\u001a\u0005\u0018\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0003\u0010í\u0001\"\u0006\b\u008a\u0003\u0010ï\u0001R\"\u0010\u008b\u0003\u001a\u0005\u0018\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0003\u0010í\u0001\"\u0006\b\u008d\u0003\u0010ï\u0001R\"\u0010\u008e\u0003\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008f\u0003\u0010\u0091\u0001\"\u0006\b\u0090\u0003\u0010\u0093\u0001R\u0012\u0010\u0091\u0003\u001a\u0005\u0018\u00010é\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0092\u0003\u001a\u0005\u0018\u00010é\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0093\u0003\u001a\u0005\u0018\u00010é\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0094\u0003\u001a\u0005\u0018\u00010é\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0095\u0003\u001a\u0005\u0018\u00010é\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0096\u0003\u001a\u0005\u0018\u00010\u0097\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0003\u0010\u0099\u0003\"\u0006\b\u009a\u0003\u0010\u009b\u0003R\"\u0010\u009c\u0003\u001a\u0005\u0018\u00010\u0097\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0003\u0010\u0099\u0003\"\u0006\b\u009e\u0003\u0010\u009b\u0003R\"\u0010\u009f\u0003\u001a\u0005\u0018\u00010\u0097\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0003\u0010\u0099\u0003\"\u0006\b¡\u0003\u0010\u009b\u0003R\"\u0010¢\u0003\u001a\u0005\u0018\u00010\u0097\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0003\u0010\u0099\u0003\"\u0006\b¤\u0003\u0010\u009b\u0003R\u001f\u0010¥\u0003\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0003\u0010#\"\u0005\b§\u0003\u0010%R\u001f\u0010¨\u0003\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0003\u0010#\"\u0005\bª\u0003\u0010%R\u000f\u0010«\u0003\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010¬\u0003\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0003\u0010#\"\u0005\b®\u0003\u0010%R\u0018\u0010¯\u0003\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010!0Ë\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010°\u0003\u001a\u0018\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u000100j\u000b\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u0001`2X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0003\u00104\"\u0005\b²\u0003\u00106R\"\u0010³\u0003\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0003\u0010\u0091\u0001\"\u0006\bµ\u0003\u0010\u0093\u0001R\u000f\u0010¶\u0003\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010·\u0003\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¸\u0003\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010¹\u0003\u001a\u0005\u0018\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0003\u0010í\u0001\"\u0006\b»\u0003\u0010ï\u0001R\"\u0010¼\u0003\u001a\u0005\u0018\u00010½\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¾\u0003\u0010¿\u0003\"\u0006\bÀ\u0003\u0010Á\u0003R\u0011\u0010Â\u0003\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ã\u0003\u001a\u0005\u0018\u00010Ä\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010Å\u0003\u001a\u0005\u0018\u00010Æ\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0003\u0010È\u0003\"\u0006\bÉ\u0003\u0010Ê\u0003R\u0012\u0010Ë\u0003\u001a\u0005\u0018\u00010Ì\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Í\u0003\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Î\u0003\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ï\u0003\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ð\u0003\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ñ\u0003\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ò\u0003\u001a\u0005\u0018\u00010Ó\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010Ô\u0003\u001a\u0005\u0018\u00010Õ\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÖ\u0003\u0010×\u0003\"\u0006\bØ\u0003\u0010Ù\u0003R\"\u0010Ú\u0003\u001a\u0005\u0018\u00010Û\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÜ\u0003\u0010Ý\u0003\"\u0006\bÞ\u0003\u0010ß\u0003R\u001d\u0010à\u0003\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bá\u0003\u0010#\"\u0005\bâ\u0003\u0010%R\u001f\u0010ã\u0003\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bä\u0003\u0010#\"\u0005\bå\u0003\u0010%R\u001d\u0010æ\u0003\u001a\u000208X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bç\u0003\u0010:\"\u0005\bè\u0003\u0010HR\"\u0010é\u0003\u001a\u0005\u0018\u00010ê\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bë\u0003\u0010ì\u0003\"\u0006\bí\u0003\u0010î\u0003R)\u0010ï\u0003\u001a\f\u0012\u0005\u0012\u00030ð\u0003\u0018\u00010Ë\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bñ\u0003\u0010ò\u0003\"\u0006\bó\u0003\u0010ô\u0003R\u0012\u0010õ\u0003\u001a\u0005\u0018\u00010¦\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ö\u0003\u001a\u0005\u0018\u00010÷\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010ø\u0003\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ù\u0003\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010ú\u0003\u001a\u0005\u0018\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bû\u0003\u0010í\u0001\"\u0006\bü\u0003\u0010ï\u0001R%\u0010ý\u0003\u001a\u0018\u0012\u0005\u0012\u00030þ\u0003\u0018\u000100j\u000b\u0012\u0005\u0012\u00030þ\u0003\u0018\u0001`2X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ÿ\u0003\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0004\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0081\u0004\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0004\u001a\u0005\u0018\u00010¢\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0083\u0004\u001a\u0005\u0018\u00010¢\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0004\u001a\u0005\u0018\u00010¢\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0085\u0004\u001a\u0005\u0018\u00010¢\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0086\u0004\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0087\u0004\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0088\u0004\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0089\u0004\u001a\u0005\u0018\u00010¢\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u008a\u0004\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u008b\u0004\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008c\u0004\u001a\u0005\u0018\u00010\u008f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0004\u0010\u0091\u0001\"\u0006\b\u008e\u0004\u0010\u0093\u0001R\"\u0010\u008f\u0004\u001a\u0005\u0018\u00010\u0090\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0004\u0010\u0092\u0004\"\u0006\b\u0093\u0004\u0010\u0094\u0004R\u001d\u0010\u0095\u0004\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0004\u0010(\"\u0005\b\u0096\u0004\u0010*R\"\u0010\u0097\u0004\u001a\u0005\u0018\u00010¨\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0004\u0010ª\u0002\"\u0006\b\u0099\u0004\u0010¬\u0002R\u001d\u0010\u009a\u0004\u001a\u000208X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0004\u0010:\"\u0005\b\u009c\u0004\u0010HR\"\u0010\u009d\u0004\u001a\u0005\u0018\u00010\u009e\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0004\u0010 \u0004\"\u0006\b¡\u0004\u0010¢\u0004R\"\u0010£\u0004\u001a\u0005\u0018\u00010¤\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0004\u0010¦\u0004\"\u0006\b§\u0004\u0010¨\u0004R\"\u0010©\u0004\u001a\u0005\u0018\u00010ª\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0004\u0010¬\u0004\"\u0006\b\u00ad\u0004\u0010®\u0004R\"\u0010¯\u0004\u001a\u0005\u0018\u00010°\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b±\u0004\u0010²\u0004\"\u0006\b³\u0004\u0010´\u0004R\u000f\u0010µ\u0004\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¶\u0004\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010·\u0004\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010¸\u0004\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0004\u0010(\"\u0005\b¹\u0004\u0010*R\u001d\u0010º\u0004\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0004\u0010(\"\u0005\b»\u0004\u0010*R\"\u0010¼\u0004\u001a\u0005\u0018\u00010½\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¾\u0004\u0010¿\u0004\"\u0006\bÀ\u0004\u0010Á\u0004R\"\u0010Â\u0004\u001a\u0005\u0018\u00010Ã\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0004\u0010Å\u0004\"\u0006\bÆ\u0004\u0010Ç\u0004R\u001d\u0010È\u0004\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0004\u0010#\"\u0005\bÊ\u0004\u0010%R\u001d\u0010Ë\u0004\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0004\u0010\u0017\"\u0005\bÍ\u0004\u0010\u0019R\u0012\u0010Î\u0004\u001a\u0005\u0018\u00010Ï\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ð\u0004\u001a\u0005\u0018\u00010Ô\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ñ\u0004\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ò\u0004\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ó\u0004\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ô\u0004\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Õ\u0004\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ö\u0004\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010×\u0004\u001a\u0005\u0018\u00010¥\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ø\u0004\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ù\u0004\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010Ú\u0004\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÛ\u0004\u0010#\"\u0005\bÜ\u0004\u0010%R\u001d\u0010Ý\u0004\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÝ\u0004\u0010(\"\u0005\bÞ\u0004\u0010*R\u001d\u0010ß\u0004\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bß\u0004\u0010(\"\u0005\bà\u0004\u0010*R\u001d\u0010á\u0004\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bá\u0004\u0010(\"\u0005\bâ\u0004\u0010*R\u001d\u0010ã\u0004\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bä\u0004\u0010#\"\u0005\bå\u0004\u0010%R\u001d\u0010æ\u0004\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bç\u0004\u0010#\"\u0005\bè\u0004\u0010%R\u001f\u0010é\u0004\u001a\u00020hX\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\bê\u0004\u0010ë\u0004\"\u0006\bì\u0004\u0010í\u0004R \u0010î\u0004\u001a\u00030¥\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\bï\u0004\u0010í\u0001\"\u0006\bð\u0004\u0010ï\u0001R3\u0010ñ\u0004\u001a\u0018\u0012\u0005\u0012\u00030ò\u0004\u0018\u000100j\u000b\u0012\u0005\u0012\u00030ò\u0004\u0018\u0001`2X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bó\u0004\u00104\"\u0005\bô\u0004\u00106R\u000f\u0010õ\u0004\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ö\u0004\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010÷\u0004\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010ø\u0004\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ù\u0004\u001a\u0005\u0018\u00010ú\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010û\u0004\u001a\u0005\u0018\u00010ú\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ü\u0004\u001a\u0005\u0018\u00010ú\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ý\u0004\u001a\u0005\u0018\u00010ú\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010þ\u0004\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bþ\u0004\u0010(\"\u0005\bÿ\u0004\u0010*R\"\u0010\u0080\u0005\u001a\u0005\u0018\u00010\u0081\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0005\u0010\u0083\u0005\"\u0006\b\u0084\u0005\u0010\u0085\u0005R\u001f\u0010\u0086\u0005\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0005\u0010#\"\u0005\b\u0088\u0005\u0010%R\u001f\u0010\u0089\u0005\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0005\u0010#\"\u0005\b\u008b\u0005\u0010%R\u001f\u0010\u008c\u0005\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0005\u0010#\"\u0005\b\u008e\u0005\u0010%R\"\u0010\u008f\u0005\u001a\u0005\u0018\u00010\u0090\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0005\u0010\u0092\u0005\"\u0006\b\u0093\u0005\u0010\u0094\u0005R\u0015\u0010\u0095\u0005\u001a\u00030\u0096\u0005¢\u0006\n\n\u0000\u001a\u0006\b\u0097\u0005\u0010\u0098\u0005R\u000f\u0010\u0099\u0005\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009a\u0005\u001a\u0005\u0018\u00010¨\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010§\u0005\u001a\u0005\u0018\u00010¨\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010«\u0005\u001a\u0005\u0018\u00010¨\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010¯\u0005\u001a\u0005\u0018\u00010°\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010³\u0005\u001a\u00030\u009c\u00058BX\u0082\u0004¢\u0006\b\u001a\u0006\b´\u0005\u0010µ\u0005R\u0016\u0010Í\u0005\u001a\u00020'8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÍ\u0005\u0010(R\u001d\u0010î\u0005\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bî\u0005\u0010(\"\u0005\bï\u0005\u0010*R\u001d\u0010ø\u0005\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bù\u0005\u0010#\"\u0005\bú\u0005\u0010%R\u001d\u0010û\u0005\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bü\u0005\u0010#\"\u0005\bý\u0005\u0010%R\"\u0010\u0080\u0006\u001a\u0005\u0018\u00010é\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0006\u0010\u0082\u0006\"\u0006\b\u0083\u0006\u0010\u0084\u0006R\"\u0010\u0085\u0006\u001a\u0005\u0018\u00010\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0006\u0010¡\u0001\"\u0006\b\u0087\u0006\u0010£\u0001R\"\u0010\u0088\u0006\u001a\u0005\u0018\u00010\u0089\u0006X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0006\u0010\u008b\u0006\"\u0006\b\u008c\u0006\u0010\u008d\u0006R\"\u0010\u0092\u0006\u001a\u0005\u0018\u00010é\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0006\u0010\u0082\u0006\"\u0006\b\u0094\u0006\u0010\u0084\u0006R\"\u0010\u0095\u0006\u001a\u0005\u0018\u00010\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0006\u0010¡\u0001\"\u0006\b\u0097\u0006\u0010£\u0001R\"\u0010\u0098\u0006\u001a\u0005\u0018\u00010\u0089\u0006X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0006\u0010\u008b\u0006\"\u0006\b\u009a\u0006\u0010\u008d\u0006R\u0012\u0010«\u0006\u001a\u0005\u0018\u00010¬\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u00ad\u0006\u001a\t\u0018\u00010®\u0006R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010¯\u0006\u001a\t\u0018\u00010°\u0006R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010¹\u0006\u001a\u00030º\u0006X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0006\u0010¼\u0006\"\u0006\b½\u0006\u0010¾\u0006R\u001d\u0010Ã\u0006\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0006\u0010\u0017\"\u0005\bÅ\u0006\u0010\u0019R \u0010å\u0006\u001a\u00030æ\u0006X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\bç\u0006\u0010è\u0006\"\u0006\bé\u0006\u0010ê\u0006R\"\u0010î\u0006\u001a\u0005\u0018\u00010é\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bï\u0006\u0010\u0082\u0006\"\u0006\bð\u0006\u0010\u0084\u0006R\"\u0010ñ\u0006\u001a\u0005\u0018\u00010\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bò\u0006\u0010¡\u0001\"\u0006\bó\u0006\u0010£\u0001R\u001d\u0010\u008f\u0007\u001a\u000208X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0007\u0010:\"\u0005\b\u0091\u0007\u0010HR \u0010\u0098\u0007\u001a\u00030\u0099\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0007\u0010\u009b\u0007\"\u0006\b\u009c\u0007\u0010\u009d\u0007R \u0010\u009e\u0007\u001a\u00030\u0099\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0007\u0010\u009b\u0007\"\u0006\b \u0007\u0010\u009d\u0007R \u0010¡\u0007\u001a\u00030\u0099\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¢\u0007\u0010\u009b\u0007\"\u0006\b£\u0007\u0010\u009d\u0007R \u0010¤\u0007\u001a\u00030\u0099\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0007\u0010\u009b\u0007\"\u0006\b¦\u0007\u0010\u009d\u0007R \u0010§\u0007\u001a\u00030\u0099\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0007\u0010\u009b\u0007\"\u0006\b©\u0007\u0010\u009d\u0007R\u0017\u0010²\u0007\u001a\n\u0012\u0005\u0012\u00030´\u00070³\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010µ\u0007\u001a\n\u0012\u0005\u0012\u00030¶\u00070³\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0007\u0010¸\u0007\"\u0006\b¹\u0007\u0010º\u0007R \u0010Æ\u0007\u001a\u00030Ç\u0007X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0007\u0010É\u0007\"\u0006\bÊ\u0007\u0010Ë\u0007R\u0015\u0010Ï\u0007\u001a\u00030Ð\u0007¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0007\u0010Ò\u0007R\u0015\u0010Ó\u0007\u001a\u00030Ô\u0007¢\u0006\n\n\u0000\u001a\u0006\bÕ\u0007\u0010Ö\u0007R\u001b\u0010×\u0007\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u0001\u0018\u00010Ø\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Ù\u0007\u001a\u0005\u0018\u00010÷\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010Ú\u0007\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010ÿ\u0001\u0018\u00010Ø\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Û\u0007\u001a\u0005\u0018\u00010÷\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010Ü\u0007\u001a\u00030Ý\u0007X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\bÞ\u0007\u0010ß\u0007\"\u0006\bà\u0007\u0010á\u0007R \u0010â\u0007\u001a\u00030Ý\u0007X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\bã\u0007\u0010ß\u0007\"\u0006\bä\u0007\u0010á\u0007R\u001f\u0010å\u0007\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bæ\u0007\u0010#\"\u0005\bç\u0007\u0010%R\u001f\u0010è\u0007\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bé\u0007\u0010#\"\u0005\bê\u0007\u0010%R\u001f\u0010ë\u0007\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0007\u0010#\"\u0005\bí\u0007\u0010%R\u001f\u0010î\u0007\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bï\u0007\u0010#\"\u0005\bð\u0007\u0010%R\u001f\u0010ñ\u0007\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bò\u0007\u0010#\"\u0005\bó\u0007\u0010%R\u0012\u0010\u0086\b\u001a\u0005\u0018\u00010\u0087\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0088\b\u001a\u0005\u0018\u00010\u0087\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0089\b\u001a\u0005\u0018\u00010\u0087\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008a\b\u001a\u0005\u0018\u00010\u0087\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ê\b\u001a\t\u0012\u0004\u0012\u00020!0³\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Ë\b\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ì\b\u001a\u000208X\u0082D¢\u0006\u0002\n\u0000R\u000f\u0010Í\b\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010Î\b\u001a\u00020'X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\b\u0010(\"\u0005\bÏ\b\u0010*R\u000f\u0010Ð\b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ñ\b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ò\b\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ó\b\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ô\b\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Õ\b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ö\b\u001a\u0005\u0018\u00010÷\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010×\b\u001a\u0005\u0018\u00010¨\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010Ø\b\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ù\b0Ú\u0006¢\u0006\r\n\u0003\u0010Ü\b\u001a\u0006\bÚ\b\u0010Û\b¨\u0006ê\b"}, d2 = {"Lcom/appnew/android/player/LiveStreamingYoutube;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Courses/Interfaces/AsyncTaskCompleteListener;", "Lcom/appnew/android/Utils/AmazonUpload/AmazonCallBack;", "Lcom/github/barteksc/pdfviewer/listener/OnLoadCompleteListener;", "Lcom/github/barteksc/pdfviewer/listener/OnErrorListener;", "Lcom/appnew/android/Utils/imagecropper/TakeImageClass$imagefromcropper;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "autoplayRow", "Landroid/widget/LinearLayout;", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "youTubePlayerNew", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "currentTime", "", "getCurrentTime", "()J", "setCurrentTime", "(J)V", "youTubePlayerListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "getYouTubePlayerListener", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "setYouTubePlayerListener", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;)V", "isclicked", "", "getIsclicked", "()Ljava/lang/String;", "setIsclicked", "(Ljava/lang/String;)V", "isUserCopied", "", "()Z", "setUserCopied", "(Z)V", "deletedindex", "str_imgTypeClick", "getStr_imgTypeClick", "setStr_imgTypeClick", "myPermissionConstantsArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Utils/AppPermissionsRunTime$MyPermissionConstants;", "Lkotlin/collections/ArrayList;", "getMyPermissionConstantsArrayList", "()Ljava/util/ArrayList;", "setMyPermissionConstantsArrayList", "(Ljava/util/ArrayList;)V", "REQUEST_CODE_PERMISSION_MULTIPLE", "", "getREQUEST_CODE_PERMISSION_MULTIPLE", "()I", "s3IU", "Lcom/appnew/android/Utils/AmazonUpload/s3ImageUploading;", "optionList", "Lcom/appnew/android/Model/AddOptionModel;", "getOptionList", "setOptionList", "isUserOnPoll", "setUserOnPoll", "ischatload", "inErrorState", "requestCode", "getRequestCode", "setRequestCode", "(I)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "progress_bar_pdf", "getProgress_bar_pdf", "setProgress_bar_pdf", "audio_url", "getAudio_url", "setAudio_url", "islockedback", "getIslockedback", "setIslockedback", "userAgent", "playerSpeed", "getPlayerSpeed", "setPlayerSpeed", "bitrateapply", "getBitrateapply", "setBitrateapply", "lastseleted", "getLastseleted", "setLastseleted", "videoId", "youTubeView", "Lcom/appnew/android/player/YTubePlayerView;", "playerView", "Landroidx/media3/ui/PlayerView;", "youtubeShareDisableRL", "Landroid/widget/RelativeLayout;", "youtubePlayerView", "Landroid/webkit/WebView;", "savedOrientation", "webView", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "yTubePlayerView", "getYTubePlayerView", "()Lcom/appnew/android/player/YTubePlayerView;", "setYTubePlayerView", "(Lcom/appnew/android/player/YTubePlayerView;)V", "trackSelectorParameters", "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;", "mediaSource", "Landroidx/media3/exoplayer/source/MediaSource;", "getMediaSource", "()Landroidx/media3/exoplayer/source/MediaSource;", "setMediaSource", "(Landroidx/media3/exoplayer/source/MediaSource;)V", "trackSelector", "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;", "getTrackSelector", "()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;", "setTrackSelector", "(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;)V", "isShowingTrackSelectionDialog", "trackSelectionHelper", "Lcom/appnew/android/player/customview/ExoSpeedDemo/TrackSelectionHelper;", "mConnectionClass", "Lcom/facebook/network/connectionclass/ConnectionQuality;", "url", "getUrl", "setUrl", "sparseOPUSAudioUrl", "", "quality", "Landroid/widget/ImageView;", "getQuality", "()Landroid/widget/ImageView;", "setQuality", "(Landroid/widget/ImageView;)V", "islive", "is_ved_live", "chatAdapter", "Lcom/appnew/android/player/ChatAdapter;", "getChatAdapter", "()Lcom/appnew/android/player/ChatAdapter;", "setChatAdapter", "(Lcom/appnew/android/player/ChatAdapter;)V", "isaudio", "mFullScreenIcon", "getchatdata", "Lcom/google/firebase/database/ChildEventListener;", "getGetchatdata", "()Lcom/google/firebase/database/ChildEventListener;", "setGetchatdata", "(Lcom/google/firebase/database/ChildEventListener;)V", "tvGoLive", "Landroid/widget/TextView;", "pollType", "recyclerChat", "Landroidx/recyclerview/widget/RecyclerView;", "addOptionRecycler", "recylerViewPollOperator", "goToCurrentRl", "chatMainRl", "submitPoll", "createPoll", "generateLeaderboard", "viewLeaderboard", "selectMode", "addOptionRl", "enterQuestionET", "Landroid/widget/EditText;", "enterDelayET", "enterTimeET", "llEnableMarkAsRead", "getLlEnableMarkAsRead", "()Landroid/widget/LinearLayout;", "setLlEnableMarkAsRead", "(Landroid/widget/LinearLayout;)V", "checkMark", "Landroid/widget/CheckBox;", "tvMark", "isVideoReadMarked", "setVideoReadMarked", "pollId", "pollKey", "pollDelay", "pollValidity", "pollQuestion", "pollAnswer", "pollOption1", "pollOption2", "pollOption3", "pollOption4", "pollOption5", "pollOption6", "addPoll", "createPollNestedScrollView", "Landroidx/core/widget/NestedScrollView;", "ivSend", "getIvSend", "setIvSend", "modeOfPoll", "getModeOfPoll", "setModeOfPoll", "linearLayout", "getLinearLayout", "setLinearLayout", "textLayout", "getTextLayout", "setTextLayout", "endLayout", "getEndLayout", "setEndLayout", "audioMainLL", "getAudioMainLL", "setAudioMainLL", "pauseAudio", "getPauseAudio", "setPauseAudio", "cancelRecording", "getCancelRecording", "setCancelRecording", "sendRecording", "getSendRecording", "setSendRecording", "audioRecordTime", "getAudioRecordTime", "()Landroid/widget/TextView;", "setAudioRecordTime", "(Landroid/widget/TextView;)V", "llll", "getLlll", "setLlll", "chatlayout", "getChatlayout", "setChatlayout", "isPublicChatEnabled", "isShowViewAllLeaderBoard", "setShowViewAllLeaderBoard", "isOperator", "setOperator", "addBookmark", "getAddBookmark", "setAddBookmark", "arrChat", "Lcom/appnew/android/Model/chatPojo;", "getArrChat", "setArrChat", "pollarr", "getPollarr", "setPollarr", "pollarraylist", "Lcom/appnew/android/Model/PlayerPojo/Polldata;", "getPollarraylist", "setPollarraylist", "etMessage", "getEtMessage", "()Landroid/widget/EditText;", "setEtMessage", "(Landroid/widget/EditText;)V", "speedTV", "fullscreen", "ic_back_pdf", "ic_full_pdf", "defaultTimeBar", "Landroidx/media3/ui/DefaultTimeBar;", "getDefaultTimeBar", "()Landroidx/media3/ui/DefaultTimeBar;", "setDefaultTimeBar", "(Landroidx/media3/ui/DefaultTimeBar;)V", "exo_duration", "getExo_duration", "setExo_duration", "exo_position", "getExo_position", "setExo_position", "speedx", "getSpeedx", "setSpeedx", "mFullScreenButton", "Landroid/widget/FrameLayout;", "mExoPlayerFullscreen", "STATE_PLAYER_FULLSCREEN", "mFullScreenDialog", "Landroid/app/Dialog;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "thumbnailurl", "getThumbnailurl", "setThumbnailurl", Const.VIDEO_ID, "getVideo_id", "setVideo_id", "video_name", "getVideo_name", "setVideo_name", "image", "Landroid/graphics/Bitmap;", "getImage", "()Landroid/graphics/Bitmap;", "setImage", "(Landroid/graphics/Bitmap;)V", "isActivityLive", "setActivityLive", "leftMenu", "Lcom/appnew/android/Model/LeftMenu;", "bookmarkAdapter", "Lcom/appnew/android/player/BookmarkAdapter;", "adapter", "Lcom/appnew/android/player/Adapter_recycleveiw_vedio;", "pollAdapter", "Lcom/appnew/android/player/PollAdapter;", "getPollAdapter", "()Lcom/appnew/android/player/PollAdapter;", "setPollAdapter", "(Lcom/appnew/android/player/PollAdapter;)V", "indexdata", "", "Lcom/appnew/android/Model/PlayerPojo/VideoTimeFramePojo;", "lockarr", "getLockarr", "setLockarr", "bookmarkdata", Const.PDF, "Lcom/appnew/android/Model/PlayerPojo/Pdf;", "bookmark_btn", "Landroidx/cardview/widget/CardView;", "bookmarkLinear", "bookmarkIcon", "index_btn", "indexLinear", "indexIcon", "vodchat_btn", "vodchatLinear", "vodChatIcon", "chat_btn", "chatLinear", "liveChatIcon", "liveDot", Polling.EVENT_POLL, "pollMain", "pollIcon", "pdf_btn", "pdfLinear", "pdfIcon", "pdfText", "mFirebaseDatabaseReference1", "Lcom/google/firebase/database/DatabaseReference;", "time", "info", "state", "pinChat", "notesAdapter", "Lcom/appnew/android/player/NotesAdapter;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "audiocaetimage", "getAudiocaetimage", "setAudiocaetimage", "Chat_node", "getChat_node", "setChat_node", "course_id", "getCourse_id", "setCourse_id", "tileid", "getTileid", "setTileid", "tiletype", "getTiletype", "setTiletype", "add_bookmark", "getAdd_bookmark", "setAdd_bookmark", "floatingText", "getFloatingText", "setFloatingText", "video_name_text", "getVideo_name_text", "setVideo_name_text", "video_feedback", "getVideo_feedback", "setVideo_feedback", "mFirebaseDatabaseReferenceone2one", "mFirebaseDatabaseReferenceone2many", "mFirebaseDatabaseReferencePollAdded", "mFirebaseDatabaseReferenceChatLocked", "mFirebaseDatabaseReferencepolldata", "onetomanyvalueEventListener", "Lcom/google/firebase/database/ValueEventListener;", "getOnetomanyvalueEventListener", "()Lcom/google/firebase/database/ValueEventListener;", "setOnetomanyvalueEventListener", "(Lcom/google/firebase/database/ValueEventListener;)V", "chatLockedValueEventListener", "getChatLockedValueEventListener", "setChatLockedValueEventListener", "pollAddedEventListener", "getPollAddedEventListener", "setPollAddedEventListener", "valueEventListener", "getValueEventListener", "setValueEventListener", Const.POSITION, "getPosition", "setPosition", Const.shareparentid, "getParentid", "setParentid", "isintractavailable", "link", "getLink", "setLink", "keyset", "pinchatList", "getPinchatList", "setPinchatList", "startaudio", "getStartaudio", "setStartaudio", "seconds", "running", "wasRunning", "recordtime", "getRecordtime", "setRecordtime", "mediaPlayer", "Landroid/media/MediaPlayer;", "getMediaPlayer", "()Landroid/media/MediaPlayer;", "setMediaPlayer", "(Landroid/media/MediaPlayer;)V", "fileName", "recorder", "Landroid/media/MediaRecorder;", "play", "Landroid/widget/Button;", "getPlay", "()Landroid/widget/Button;", "setPlay", "(Landroid/widget/Button;)V", "timer", "Ljava/util/Timer;", "PERMISSION_TYPE", "file_upload", "video_bookmark", "STORAGE_PERMISSION_TYPE", "pinll", "bottomSetting", "Lcom/appnew/android/Model/BottomSetting;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "bookmarkState", "getBookmarkState", "setBookmarkState", "videoId_value", "getVideoId_value", "setVideoId_value", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "getI", "setI", "chatUser", "Lcom/appnew/android/Model/ChatUser;", "getChatUser", "()Lcom/appnew/android/Model/ChatUser;", "setChatUser", "(Lcom/appnew/android/Model/ChatUser;)V", "listVideosYoutube", "Lcom/github/kotvertolet/youtubejextractor/models/youtube/playerResponse/MuxedStream;", "getListVideosYoutube", "()Ljava/util/List;", "setListVideosYoutube", "(Ljava/util/List;)V", "dialog", "handler", "Landroid/os/Handler;", "isChatPin", "isLoadvedio", "nextVideo", "getNextVideo", "setNextVideo", "allVideosList", "Lcom/appnew/android/Model/Video;", "starttime", "totaltime", "newYoutubePlayer", "relativeLYoutubeLogo", "relativeLYoutubeLogoTab", "suggestedVideoTab", "fullScreenContainer", "relativeLayout1", "relativeLayout", "relativeLayoutTab", "youtubePlayerViewLay", "youtubePlayerViewLay1", "rl_pdf_data", "refreshUrl", "getRefreshUrl", "setRefreshUrl", "youtube_player_view", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "getYoutube_player_view", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "setYoutube_player_view", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;)V", "isFullscreen", "setFullscreen", ViewHierarchyConstants.VIEW_KEY, "getView", "setView", "savedOrientation1", "getSavedOrientation1", "setSavedOrientation1", "pdfViewPager", "Lcom/github/barteksc/pdfviewer/PDFView;", "getPdfViewPager", "()Lcom/github/barteksc/pdfviewer/PDFView;", "setPdfViewPager", "(Lcom/github/barteksc/pdfviewer/PDFView;)V", "input", "Ljava/io/InputStream;", "getInput", "()Ljava/io/InputStream;", "setInput", "(Ljava/io/InputStream;)V", "urlConnection", "Ljava/net/HttpURLConnection;", "getUrlConnection", "()Ljava/net/HttpURLConnection;", "setUrlConnection", "(Ljava/net/HttpURLConnection;)V", "output", "Ljava/io/OutputStream;", "getOutput", "()Ljava/io/OutputStream;", "setOutput", "(Ljava/io/OutputStream;)V", "retry", "finalPdfUrl", "count", "isUserScrolled", "setUserScrolled", "isFirebaseChat", "setFirebaseChat", "liveChat", "Lcom/appnew/android/Model/PlayerPojo/LiveChat;", "getLiveChat", "()Lcom/appnew/android/Model/PlayerPojo/LiveChat;", "setLiveChat", "(Lcom/appnew/android/Model/PlayerPojo/LiveChat;)V", "extraParam", "Lcom/appnew/android/Model/PlayerPojo/Metarespo;", "getExtraParam", "()Lcom/appnew/android/Model/PlayerPojo/Metarespo;", "setExtraParam", "(Lcom/appnew/android/Model/PlayerPojo/Metarespo;)V", "videoAdmin", "getVideoAdmin", "setVideoAdmin", "mLastClickTime", "getMLastClickTime", "setMLastClickTime", "doubtVideoAdapter", "Lcom/appnew/android/player/DoubtVideoAdapter;", "doubt_btn", "doubtLinear", "doubtIcon", "doubtText", "forDoubtll", "publishDoubts", "unpublishtxt", "publishTxt", "submitDoubts", "refressDoubtRl", "doubtPublishStatus", "getDoubtPublishStatus", "setDoubtPublishStatus", "isShowSubmit", "setShowSubmit", "isUserOnDoubt", "setUserOnDoubt", "isTextChanging", "setTextChanging", "defaultTimeDuration", "getDefaultTimeDuration", "setDefaultTimeDuration", "defaultDelayDuration", "getDefaultDelayDuration", "setDefaultDelayDuration", "topImage", "getTopImage", "()Landroid/widget/RelativeLayout;", "setTopImage", "(Landroid/widget/RelativeLayout;)V", "loveImage", "getLoveImage", "setLoveImage", "userList", "Lcom/appnew/android/Model/AttemptedUserPoll;", "getUserList", "setUserList", "isAudioRecording", "isAudioPlaying", "isUserActive", "llChatSetting", "switchChat", "Landroidx/appcompat/widget/SwitchCompat;", "switchEmoticons", "switchPublic", "switchFeedback", "isLandscape", "setLandscape", "landscapePollDialog", "Lcom/appnew/android/player/LandscapePollDialog;", "getLandscapePollDialog", "()Lcom/appnew/android/player/LandscapePollDialog;", "setLandscapePollDialog", "(Lcom/appnew/android/player/LandscapePollDialog;)V", "selectedStream", "getSelectedStream", "setSelectedStream", "customPlayer", "getCustomPlayer", "setCustomPlayer", "controlYT", "getControlYT", "setControlYT", "tempFile", "Ljava/io/File;", "getTempFile", "()Ljava/io/File;", "setTempFile", "(Ljava/io/File;)V", "downloadPdfReceiver", "Landroid/content/BroadcastReceiver;", "getDownloadPdfReceiver", "()Landroid/content/BroadcastReceiver;", "isOriginUrlOld", "root_view", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showWebViewPlayer", "showYoutubePlayer", "markAsReadVideoType1_7", "checkMarkUnmark", "markCheckAlertDialog", "isChecked", "startMessageProcessor", "stopMessageProcessor", "processQueueRunnable", "Ljava/lang/Runnable;", "startMessageProcessorEmoji", "stopMessageProcessorEmoji", "processQueueRunnableEmoji", "isPortrait", Constants.KEY_ORIENTATION, "handleBottomSettings", "llm", "Landroidx/recyclerview/widget/LinearLayoutManager;", "isLastVisible", "handleIsLive", "dataFromIntent", "getDataFromIntent", "()Lkotlin/Unit;", "setIds", "handleChatCopyPaste", "setClicks", "manageButtonUI", "forBookmark", "forIndex", "forVODchat", "forChat", "forPoll", "forPDF", "forDoubt", "getSelectedDrawable", "isSelected", "showTileIcon", "visibleGone", "setTintWithAppColor", "imageView", "updateList", "updateListAfterText", "removeOption", "getPollOptionQues", FirebaseAnalytics.Param.INDEX, "showSpeedOptions", "isPlaying", "showAlertDialog", "showHigherQualityAlert", "changeQuality", "checkStoragePermission2", "OpenChooser", "stopWatch", "recordingActivities", "runTimer", "stopRecording", "onRecordBtnClicked", "record", "startRecording", "starttimer", "stoptimer", "sendaudio", "setvodchat", "handleVisibilityChatMessageLayout", "initUI", "initPlayerWebView", "handleIsAudio", "onError", "t", "", "loadComplete", "nbPages", "onTaskComplete", "inputStream", VideoDownloadService.FILEPATH, "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "checkStoragePermission", "isFirstTimeCome", "setFirstTimeCome", "setNotes", "setPoll", "setpollAdapter", "pausePlayer", "pausePlayerFromAdapter", "resumePlayer", "setUserOnline", "setUserOffline", "checkstatus", "getCheckstatus", "setCheckstatus", "islocked", "getIslocked", "setIslocked", "fireBaseOperation", "setSendListener", "onetomanyrootRef", "getOnetomanyrootRef", "()Lcom/google/firebase/database/DatabaseReference;", "setOnetomanyrootRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "onetomanychildEventListener", "getOnetomanychildEventListener", "setOnetomanychildEventListener", "onetomantquery", "Lcom/google/firebase/database/Query;", "getOnetomantquery", "()Lcom/google/firebase/database/Query;", "setOnetomantquery", "(Lcom/google/firebase/database/Query;)V", "onetomanygetupdatedchatdata", "actualdate", "addOrUpdateItem", "newItem", "rootRef", "getRootRef", "setRootRef", "childEventListener", "getChildEventListener", "setChildEventListener", "query", "getQuery", "setQuery", "getupdatedchatdata", "checkintract", "getpolldatawithid", "randomid", "createPollDataWithId", "jsonstring", "Lorg/json/JSONObject;", "showDialog", "BookMarkApi", "id", "formattedTime", "millis", "onDelete", "data", "Lcom/appnew/android/Model/Bookmark;", "onResume", "telephonyManager", "Landroid/telephony/TelephonyManager;", "oldListener", "Lcom/appnew/android/player/LiveStreamingYoutube$MyPhoneStateListener;", "newCallback", "Lcom/appnew/android/player/LiveStreamingYoutube$MyTelephonyCallback;", "onStart", "handleCallStateChange", "oncall", "b", "initYoutubePlayer", "initializePlayer", "iframe", "playVideo", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/media3/common/Player$Listener;", "getListener", "()Landroidx/media3/common/Player$Listener;", InAppPurchaseConstants.METHOD_SET_LISTENER, "(Landroidx/media3/common/Player$Listener;)V", "closeFullScreenDialogNew", "openFullScreenDialogNew", "onStop", "handleOnBackPress", "endtime", "getEndtime", "setEndtime", "onPause", "initFullscreenDialog", "closeFullscreenDialog", "onDestroy", "onS3UploadData", Const.IMAGES, "Lcom/appnew/android/Model/MediaFile;", "onPointerCaptureChanged", "hasCapture", "imagePath", "str", "imgClick", "copyFileToInternalStorage", "uri", "Landroid/net/Uri;", "newDirName", "setupDoc", "selectedURI", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSeek", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "xmppManager", "Lcom/appnew/android/XmppManager;", "getXmppManager", "()Lcom/appnew/android/XmppManager;", "setXmppManager", "(Lcom/appnew/android/XmppManager;)V", "SuccessCallBack", "showprogress", "ErrorCallBack", "rootRefcompleteclass", "getRootRefcompleteclass", "setRootRefcompleteclass", "childEventListenercompleteclass", "getChildEventListenercompleteclass", "setChildEventListenercompleteclass", "completeclass", "callPauseWebview", "setIndex", "setVideoTimeMS", "timeMS", "disableAll", "setAdapter", "setbookmarkadapter", "setBookMark", "setNotesAdapter", "isvisiblelayouts", "ispoll", "isindex", "isbookmark", "islivechat", "ispdf", "isvod", "isDoubt", "setpollcount", "pollkey", Const.ANSWER, "setcountincrement", "child", "userData", "Lcom/appnew/android/Model/SendUserData;", "getdate", "timestamp", Constants.INAPP_POSITION, "getPos", "setPos", "BookMarkDeleteApi", CmcdData.Factory.STREAMING_FORMAT_SS, "s1", "s2", "showchat", "hidechat", "total", "", "getTotal", "()F", "setTotal", "(F)V", "attempt_1_count", "getAttempt_1_count", "setAttempt_1_count", "attempt_2_count", "getAttempt_2_count", "setAttempt_2_count", "attempt_3_count", "getAttempt_3_count", "setAttempt_3_count", "attempt_4_count", "getAttempt_4_count", "setAttempt_4_count", "getServeyData", "polldata", "getLiveIndexResolution", "setpin", "chatPojo", "setunPin", "setUpPinChat", "deleteChat", "cropImage", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/canhub/cropper/CropImageContractOptions;", "someActivityResultLauncher", "Landroid/content/Intent;", "getSomeActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setSomeActivityResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "autoplayNextVideo", "onWindowFocusChanged", "hasFocus", "clearClipBoard", "clipBoardBubbleHandle", "CallPDFOnSameScreen", "pdfUrl", "isDownload", "pdfTitle", "isShare", "showPDF", "chatManager", "Lorg/jivesoftware/smackx/muc/MultiUserChat;", "getChatManager", "()Lorg/jivesoftware/smackx/muc/MultiUserChat;", "setChatManager", "(Lorg/jivesoftware/smackx/muc/MultiUserChat;)V", "loadOrSendChat", "connection", "Lorg/jivesoftware/smack/XMPPConnection;", "messageInterceptor", "Lorg/jivesoftware/smackx/muc/MucMessageInterceptor;", "getMessageInterceptor", "()Lorg/jivesoftware/smackx/muc/MucMessageInterceptor;", "ejabberedMessageListener", "Lorg/jivesoftware/smack/MessageListener;", "getEjabberedMessageListener", "()Lorg/jivesoftware/smack/MessageListener;", "incomingQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "uiHandler", "incomingQueueEmoji", "uiHandlerEmoji", "mqttClientListen", "Linfo/mqtt/android/service/MqttAndroidClient;", "getMqttClientListen", "()Linfo/mqtt/android/service/MqttAndroidClient;", "setMqttClientListen", "(Linfo/mqtt/android/service/MqttAndroidClient;)V", "mqttClientPublish", "getMqttClientPublish", "setMqttClientPublish", "listenUrl", "getListenUrl", "setListenUrl", "publishUrl", "getPublishUrl", "setPublishUrl", "chatNode", "getChatNode", "setChatNode", "settingNode", "getSettingNode", "setSettingNode", "privateNode", "getPrivateNode", "setPrivateNode", "connectToServer", "handleChatSettingNode", "handleChatNode", "handleSettingNode", "handleChatPojoMessage", "msgData", "saveLeaderboardByMQTT", "isVideoWise", "subscribeToTopic", "mqttAndroidClient", "topic", "qos", "Linfo/mqtt/android/service/QoS;", "sendMessage", "message", "isEmoji", "enableDisableMsgET", "mqttDisconnect", "switchChatChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "switchEmoticonsChangeListener", "switchPublicChangeListener", "switchFeedbackChangeListener", "handleChatSettingButton", "switchSettingClick", "type", "switchButton", "switchChangeListener", "handleChatLockUnlock", "postData", "disableSwitchOnError", "setChatSettingUi", "isShow", "setVisibleUi", "status", "showMessage", "handlePollData", "messages", "checkPollAlreadyAdded", "handleCreatePoll", "handlePollResult", "handleSubmitPoll", "handleLeaderBoardResult", "isForAll", "createPollDataStr", "updatePollDataStr", "timeleft", "resultPollDataStr", "leaderboardPollDataStr", "leaderboardVideoWiseDataStr", "generateLeaderboardVideoWiseDataStr", "getAttemptedAnswer", "ansValue", "sendWSMessage", "msg", "managePollAPI", "savePollResultInLocal", "typeLocal", "statusCode", "manageDoubtAPI", "handleDoubtData", "setDoubtsData", "doubtItemList", "Lcom/appnew/android/Model/PlayerPojo/DoubtItemData;", "handlePublishSubmitButton", "handlePublishUnPublishButton", "getAndUpdateDoubtList", "showConfirmationDialog", "openEmojiPopup", "onReactClick", "popUp", "Landroid/widget/PopupWindow;", "reactClick", "emoji", "emojiToDrawable", "Landroid/graphics/drawable/Drawable;", "showReactButton", "timerForEmojiClick", "makeFlyAnimation", "drawable", "addRecordTime", "getRandomstartX", "bound", "pushEvent", "openChooseMediaBottomSheet", "isActivityVisible", "requestPermissionLauncher1", Const.RATINGS, "ratingType", "ratingMessage", "isReviewSubmitted", "setReviewSubmitted", "FEEDBACK_MIN_WATCH_TIME", "FEEDBACK_AUTO_TRIGGER_TIME", "isFeedbackShown", "isFeedbackOpen", "isFeedbackOpenByBack", "activityStartTime", "feedbackHandler", "autoFeedbackRunnable", "feedbackDialog", "Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog;", "getFeedbackDialog", "()[Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog;", "[Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog;", "startAutoFeedbackTimer", "showAutoFeedback", "showFeedbackOnBack", "manageFeedbackButton", "openFeedbackBottomSheet", "feedbackDialogDismiss", "isOnSubmit", "isShowFeedback", "PlayerWebViewClient", "MyPhoneStateListener", "MyTelephonyCallback", "LOADURL_new", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveStreamingYoutube extends AppCompatActivity implements AsyncTaskCompleteListener, AmazonCallBack, OnLoadCompleteListener, OnErrorListener, TakeImageClass.imagefromcropper, NetworkCall.MyNetworkCallBack {
    private static DefaultBandwidthMeter BANDWIDTH_METER;
    private static OnDataSendListener dataSendListener;
    private static final int newOrientation = 0;
    private static long playPosition;
    private static String youtubeUri;
    private String Chat_node;
    private long FEEDBACK_AUTO_TRIGGER_TIME;
    private long FEEDBACK_MIN_WATCH_TIME;
    private int PERMISSION_TYPE;
    private final String STATE_PLAYER_FULLSCREEN;
    private int STORAGE_PERMISSION_TYPE;
    private long activityStartTime;
    private Adapter_recycleveiw_vedio adapter;
    private TextView addBookmark;
    private RecyclerView addOptionRecycler;
    private RelativeLayout addOptionRl;
    private RelativeLayout addPoll;
    private String add_bookmark;
    private ArrayList<Video> allVideosList;
    private ArrayList<chatPojo> arrChat;
    private float attempt_1_count;
    private float attempt_2_count;
    private float attempt_3_count;
    private float attempt_4_count;
    private LinearLayout audioMainLL;
    private TextView audioRecordTime;
    private ImageView audiocaetimage;
    private Runnable autoFeedbackRunnable;
    private LinearLayout autoplayRow;
    private boolean bitrateapply;
    private BookmarkAdapter bookmarkAdapter;
    private ImageView bookmarkIcon;
    private LinearLayout bookmarkLinear;
    private String bookmarkState;
    private CardView bookmark_btn;
    private final List<VideoTimeFramePojo> bookmarkdata;
    private BottomSetting bottomSetting;
    private ImageView cancelRecording;
    private ChatAdapter chatAdapter;
    private LinearLayout chatLinear;
    private ValueEventListener chatLockedValueEventListener;
    private RelativeLayout chatMainRl;
    public MultiUserChat chatManager;
    private String chatNode;
    private ChatUser chatUser;
    private CardView chat_btn;
    private LinearLayout chatlayout;
    private CheckBox checkMark;
    private String checkstatus;
    private ChildEventListener childEventListener;
    private ChildEventListener childEventListenercompleteclass;
    private String controlYT;
    private int count;
    private String course_id;
    private RelativeLayout createPoll;
    private NestedScrollView createPollNestedScrollView;
    private final ActivityResultLauncher<CropImageContractOptions> cropImage;
    private long currentTime;
    private String customPlayer;
    private String defaultDelayDuration;
    private DefaultTimeBar defaultTimeBar;
    private String defaultTimeDuration;
    private Dialog dialog;
    private ImageView doubtIcon;
    private LinearLayout doubtLinear;
    private String doubtPublishStatus;
    private TextView doubtText;
    private DoubtVideoAdapter doubtVideoAdapter;
    private CardView doubt_btn;
    private final BroadcastReceiver downloadPdfReceiver;
    private SharedPreferences.Editor editor;
    private final MessageListener ejabberedMessageListener;
    private LinearLayout endLayout;
    private long endtime;
    private EditText enterDelayET;
    private EditText enterQuestionET;
    private TextView enterTimeET;
    private EditText etMessage;
    private TextView exo_duration;
    private TextView exo_position;
    private Metarespo extraParam;
    private final Utils.FeedbackBottomSheetDialog[] feedbackDialog;
    private Handler feedbackHandler;
    private String fileName;
    private ImageView file_upload;
    private String finalPdfUrl;
    private TextView floatingText;
    private LinearLayout forDoubtll;
    private FrameLayout fullScreenContainer;
    private ImageView fullscreen;
    private TextView generateLeaderboard;
    private ChildEventListener getchatdata;
    private RelativeLayout goToCurrentRl;
    private Handler handler;
    private int i;
    private ImageView ic_back_pdf;
    private ImageView ic_full_pdf;
    private Bitmap image;
    private boolean inErrorState;
    private final ConcurrentLinkedQueue<chatPojo> incomingQueue;
    private final ConcurrentLinkedQueue<chatPojo> incomingQueueEmoji;
    private ImageView indexIcon;
    private LinearLayout indexLinear;
    private CardView index_btn;
    private final List<VideoTimeFramePojo> indexdata;
    private String info;
    private InputStream input;
    private boolean isActivityLive;
    private boolean isAudioPlaying;
    private boolean isAudioRecording;
    public boolean isChatPin;
    private boolean isFeedbackOpen;
    private boolean isFeedbackOpenByBack;
    private boolean isFeedbackShown;
    private boolean isFirebaseChat;
    private boolean isFirstTimeCome;
    private boolean isFullscreen;
    private boolean isLandscape;
    private boolean isLoadvedio;
    private boolean isOperator;
    private boolean isOriginUrlOld;
    private boolean isPublicChatEnabled;
    private boolean isReviewSubmitted;
    private boolean isShowSubmit;
    private boolean isShowViewAllLeaderBoard;
    private final boolean isShowingTrackSelectionDialog;
    private boolean isTextChanging;
    private boolean isUserActive;
    private boolean isUserCopied;
    private boolean isUserOnDoubt;
    private boolean isUserOnPoll;
    private boolean isUserScrolled;
    private boolean isVideoReadMarked;
    private String is_ved_live;
    private String isaudio;
    public boolean ischatload;
    private boolean isintractavailable;
    private String islive;
    private String islocked;
    private String islockedback;
    private ImageView ivSend;
    private final List<String> keyset;
    private LandscapePollDialog landscapePollDialog;
    private LeftMenu leftMenu;
    private LinearLayout linearLayout;
    private String link;
    private List<MuxedStream> listVideosYoutube;
    private String listenUrl;
    private Player.Listener listener;
    private LiveChat liveChat;
    private ImageView liveChatIcon;
    private ImageView liveDot;
    private LinearLayout llChatSetting;
    private LinearLayout llEnableMarkAsRead;
    private LinearLayout llll;
    private LinearLayoutManager llm;
    private ArrayList<chatPojo> lockarr;
    public TextView loveImage;
    private final ConnectionQuality mConnectionClass;
    private boolean mExoPlayerFullscreen;
    private DatabaseReference mFirebaseDatabaseReference1;
    private DatabaseReference mFirebaseDatabaseReferenceChatLocked;
    private DatabaseReference mFirebaseDatabaseReferencePollAdded;
    private DatabaseReference mFirebaseDatabaseReferenceone2many;
    private DatabaseReference mFirebaseDatabaseReferenceone2one;
    private DatabaseReference mFirebaseDatabaseReferencepolldata;
    private final FrameLayout mFullScreenButton;
    private Dialog mFullScreenDialog;
    private final ImageView mFullScreenIcon;
    private long mLastClickTime;
    private MediaPlayer mediaPlayer;
    private MediaSource mediaSource;
    private final MucMessageInterceptor messageInterceptor;
    private String modeOfPoll;
    public MqttAndroidClient mqttClientListen;
    public MqttAndroidClient mqttClientPublish;
    private ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    private NetworkCall networkCall;
    private MyTelephonyCallback newCallback;
    private RelativeLayout newYoutubePlayer;
    private TextView nextVideo;
    private NotesAdapter notesAdapter;
    private MyPhoneStateListener oldListener;
    private Query onetomantquery;
    private ChildEventListener onetomanychildEventListener;
    private DatabaseReference onetomanyrootRef;
    private ValueEventListener onetomanyvalueEventListener;
    private OutputStream output;
    private String parentid;
    private ImageView pauseAudio;
    private final List<Pdf> pdf;
    private ImageView pdfIcon;
    private LinearLayout pdfLinear;
    private TextView pdfText;
    private PDFView pdfViewPager;
    private CardView pdf_btn;
    private TextView pinChat;
    private ArrayList<chatPojo> pinchatList;
    private LinearLayout pinll;
    private Button play;
    private String playerSpeed;
    private PlayerView playerView;
    private CardView poll;
    private PollAdapter pollAdapter;
    private ValueEventListener pollAddedEventListener;
    private String pollAnswer;
    private String pollDelay;
    private ImageView pollIcon;
    private String pollId;
    private String pollKey;
    private LinearLayout pollMain;
    private String pollOption1;
    private String pollOption2;
    private String pollOption3;
    private String pollOption4;
    private String pollOption5;
    private String pollOption6;
    private String pollQuestion;
    private TextView pollType;
    private String pollValidity;
    private ArrayList<chatPojo> pollarr;
    private ArrayList<Polldata> pollarraylist;
    private int pos;
    private String position;
    private String privateNode;
    private final Runnable processQueueRunnable;
    private final Runnable processQueueRunnableEmoji;
    private ProgressBar progressBar;
    private ProgressBar progress_bar_pdf;
    private RelativeLayout publishDoubts;
    private TextView publishTxt;
    private String publishUrl;
    private ImageView quality;
    private Query query;
    private String rating;
    private String ratingMessage;
    private final int ratingType;
    private MediaRecorder recorder;
    private TextView recordtime;
    private RecyclerView recyclerChat;
    private RecyclerView recylerViewPollOperator;
    private ImageView refreshUrl;
    private RelativeLayout refressDoubtRl;
    private FrameLayout relativeLYoutubeLogo;
    private FrameLayout relativeLYoutubeLogoTab;
    private RelativeLayout relativeLayout;
    private RelativeLayout relativeLayout1;
    private RelativeLayout relativeLayoutTab;
    private final ActivityResultLauncher<String> requestPermissionLauncher1;
    private boolean retry;
    private RelativeLayout rl_pdf_data;
    private DatabaseReference rootRef;
    private DatabaseReference rootRefcompleteclass;
    private View rootView;
    private View root_view;
    private boolean running;
    private s3ImageUploading s3IU;
    private int savedOrientation;
    private int savedOrientation1;
    private int seconds;
    private RelativeLayout selectMode;
    private String selectedStream;
    private ImageView sendRecording;
    private String settingNode;
    private SharedPreferences sharedPreferences;
    private ActivityResultLauncher<Intent> someActivityResultLauncher;
    private final List<String> sparseOPUSAudioUrl;
    private TextView speedTV;
    private String speedx;
    private ImageView startaudio;
    private String starttime;
    private String state;
    private RelativeLayout submitDoubts;
    private RelativeLayout submitPoll;
    private FrameLayout suggestedVideoTab;
    private SwitchCompat switchChat;
    private CompoundButton.OnCheckedChangeListener switchChatChangeListener;
    private SwitchCompat switchEmoticons;
    private CompoundButton.OnCheckedChangeListener switchEmoticonsChangeListener;
    private SwitchCompat switchFeedback;
    private CompoundButton.OnCheckedChangeListener switchFeedbackChangeListener;
    private SwitchCompat switchPublic;
    private CompoundButton.OnCheckedChangeListener switchPublicChangeListener;
    private TelephonyManager telephonyManager;
    private File tempFile;
    private LinearLayout textLayout;
    private String thumbnailurl;
    private String tileid;
    private String tiletype;
    private String time;
    private Timer timer;
    public RelativeLayout topImage;
    private float total;
    private long totaltime;
    private final TrackSelectionHelper trackSelectionHelper;
    private DefaultTrackSelector trackSelector;
    private final DefaultTrackSelector.Parameters trackSelectorParameters;
    private final TextView tvGoLive;
    private TextView tvMark;
    private final Handler uiHandler;
    private final Handler uiHandlerEmoji;
    private TextView unpublishtxt;
    private String url;
    private HttpURLConnection urlConnection;
    private String userAgent;
    private ArrayList<AttemptedUserPoll> userList;
    private UtkashRoom utkashRoom;
    private ValueEventListener valueEventListener;
    private String videoAdmin;
    private String videoId;
    private String videoId_value;
    private ImageView video_bookmark;
    private ImageView video_feedback;
    private String video_id;
    private String video_name;
    private TextView video_name_text;
    private View view;
    private TextView viewLeaderboard;
    private ImageView vodChatIcon;
    private LinearLayout vodchatLinear;
    private CardView vodchat_btn;
    private boolean wasRunning;
    private WebView webView;
    public XmppManager xmppManager;
    private YTubePlayerView yTubePlayerView;
    private AbstractYouTubePlayerListener youTubePlayerListener;
    private YouTubePlayer youTubePlayerNew;
    private YTubePlayerView youTubeView;
    private WebView youtubePlayerView;
    private FrameLayout youtubePlayerViewLay;
    private RelativeLayout youtubePlayerViewLay1;
    private RelativeLayout youtubeShareDisableRL;
    private YouTubePlayerView youtube_player_view;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String isclicked = "";
    private String deletedindex = "";
    private String str_imgTypeClick = "";
    private final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    private ArrayList<AddOptionModel> optionList = new ArrayList<>();
    private int requestCode = -1;
    private String audio_url = "";
    private int lastseleted = -1;

    private final int getLiveIndexResolution(int index) {
        switch (index) {
            case 1:
                return 240;
            case 2:
                return CropImageOptionsKt.DEGREES_360;
            case 3:
                return WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND;
            case 4:
                return 720;
            case 5:
                return 1080;
            case 6:
                return DateTimeConstants.MINUTES_PER_DAY;
            default:
                return 144;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleChatCopyPaste$lambda$12(View view) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPlayerWebView$lambda$62(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPortrait(int orientation) {
        return orientation < 85 || orientation > 100;
    }

    @JvmStatic
    public static final void setOnDataSendListener(OnDataSendListener onDataSendListener) {
        INSTANCE.setOnDataSendListener(onDataSendListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmationDialog$lambda$117() {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
    }

    public final String getAttemptedAnswer(String ansValue) {
        Intrinsics.checkNotNullParameter(ansValue, "ansValue");
        return ansValue;
    }

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    public static final /* synthetic */ void access$showMessage(LiveStreamingYoutube liveStreamingYoutube, String str) {
        liveStreamingYoutube.showMessage(str);
    }

    public LiveStreamingYoutube() {
        DefaultTrackSelector.Parameters parametersBuild = new DefaultTrackSelector.ParametersBuilder().build();
        Intrinsics.checkNotNullExpressionValue(parametersBuild, "build(...)");
        this.trackSelectorParameters = parametersBuild;
        this.mConnectionClass = ConnectionQuality.UNKNOWN;
        this.url = "";
        this.pollId = "";
        this.pollKey = "";
        this.pollDelay = "";
        this.pollValidity = "";
        this.pollQuestion = "";
        this.pollAnswer = "";
        this.pollOption1 = "";
        this.pollOption2 = "";
        this.pollOption3 = "";
        this.pollOption4 = "";
        this.pollOption5 = "";
        this.pollOption6 = "";
        this.modeOfPoll = "2";
        this.isPublicChatEnabled = true;
        this.arrChat = new ArrayList<>();
        this.pollarr = new ArrayList<>();
        this.pollarraylist = new ArrayList<>();
        this.speedx = "";
        this.STATE_PLAYER_FULLSCREEN = "playerFullscreen";
        this.indexdata = new ArrayList();
        this.lockarr = new ArrayList<>();
        this.bookmarkdata = new ArrayList();
        this.pdf = new ArrayList();
        this.time = "";
        this.info = "";
        this.state = "";
        this.Chat_node = "";
        this.course_id = "";
        this.tileid = "";
        this.tiletype = "";
        this.add_bookmark = "";
        this.position = "";
        this.parentid = "";
        this.link = "";
        this.keyset = new ArrayList();
        this.pinchatList = new ArrayList<>();
        this.bookmarkState = "";
        this.videoId_value = "";
        this.listVideosYoutube = new ArrayList();
        this.isLoadvedio = true;
        this.allVideosList = new ArrayList<>();
        this.starttime = "0";
        this.savedOrientation1 = -1;
        this.retry = true;
        this.finalPdfUrl = "";
        this.isFirebaseChat = true;
        this.videoAdmin = "";
        this.doubtPublishStatus = "unPublishDoubt";
        this.isShowSubmit = true;
        this.defaultTimeDuration = "30 sec";
        this.defaultDelayDuration = "20";
        this.userList = new ArrayList<>();
        this.isAudioRecording = true;
        this.downloadPdfReceiver = new LiveStreamingYoutube$downloadPdfReceiver$1(this);
        this.processQueueRunnable = new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$processQueueRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.this$0.isDestroyed()) {
                        return;
                    }
                    ConcurrentLinkedQueue concurrentLinkedQueue = this.this$0.incomingQueue;
                    Intrinsics.checkNotNull(concurrentLinkedQueue);
                    if (concurrentLinkedQueue.size() > 500) {
                        int i = 0;
                        while (this.this$0.incomingQueue.size() > 50) {
                            this.this$0.incomingQueue.poll();
                            i++;
                        }
                        Log.w("MQTT", "Queue trimmed, removed: " + i);
                    }
                    chatPojo chatpojo = (chatPojo) this.this$0.incomingQueue.poll();
                    if (chatpojo != null) {
                        if (this.this$0.getArrChat().size() >= 100) {
                            this.this$0.getArrChat().remove(0);
                            if (!this.this$0.getIsUserScrolled()) {
                                ChatAdapter chatAdapter = this.this$0.getChatAdapter();
                                Intrinsics.checkNotNull(chatAdapter);
                                chatAdapter.notifyItemRemoved(0);
                            }
                        }
                        this.this$0.getArrChat().add(chatpojo);
                        if (!this.this$0.getIsUserScrolled()) {
                            ChatAdapter chatAdapter2 = this.this$0.getChatAdapter();
                            Intrinsics.checkNotNull(chatAdapter2);
                            chatAdapter2.notifyItemInserted(this.this$0.getArrChat().size() - 1);
                        }
                        if (!this.this$0.getIsUserScrolled() && !this.this$0.getIsUserOnPoll() && !this.this$0.getIsUserOnDoubt()) {
                            RecyclerView recyclerView = this.this$0.recyclerChat;
                            Intrinsics.checkNotNull(recyclerView);
                            recyclerView.smoothScrollToPosition(this.this$0.getArrChat().size() - 1);
                        }
                    }
                    Handler handler = this.this$0.uiHandler;
                    Intrinsics.checkNotNull(handler);
                    handler.postDelayed(this, 100L);
                } catch (Exception e2) {
                    Log.d("MQTT", "processQueueRunnable: " + e2.getMessage());
                }
            }
        };
        this.processQueueRunnableEmoji = new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$processQueueRunnableEmoji$1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.this$0.isDestroyed()) {
                        return;
                    }
                    ConcurrentLinkedQueue concurrentLinkedQueue = this.this$0.incomingQueueEmoji;
                    Intrinsics.checkNotNull(concurrentLinkedQueue);
                    if (concurrentLinkedQueue.size() > 500) {
                        int i = 0;
                        while (this.this$0.incomingQueueEmoji.size() > 50) {
                            this.this$0.incomingQueueEmoji.poll();
                            i++;
                        }
                        Log.w("MQTT", "Emoji Queue trimmed, removed: " + i);
                    }
                    chatPojo chatpojo = (chatPojo) this.this$0.incomingQueueEmoji.poll();
                    if (chatpojo != null) {
                        LiveStreamingYoutube liveStreamingYoutube = this.this$0;
                        liveStreamingYoutube.makeFlyAnimation(liveStreamingYoutube.emojiToDrawable(chatpojo.getMessage()));
                    }
                    Handler handler = this.this$0.uiHandlerEmoji;
                    Intrinsics.checkNotNull(handler);
                    handler.postDelayed(this, 50L);
                } catch (Exception e2) {
                    Log.d("MQTT", "processQueueRunnableEmoji: " + e2.getMessage());
                }
            }
        };
        this.isFirstTimeCome = true;
        this.checkstatus = "";
        this.islocked = "0";
        this.listener = new Player.Listener() { // from class: com.appnew.android.player.LiveStreamingYoutube$listener$1
            @Override // androidx.media3.common.Player.Listener
            public void onEvents(Player player, Player.Events events) {
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(events, "events");
                super.onEvents(player, events);
                if (!player.isPlaying() || this.this$0.getChatAdapter() == null) {
                    return;
                }
                ChatAdapter chatAdapter = this.this$0.getChatAdapter();
                Intrinsics.checkNotNull(chatAdapter);
                chatAdapter.pauseAudio();
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                super.onPlayerStateChanged(playWhenReady, playbackState);
                if (playbackState == 1) {
                    ProgressBar progressBar = this.this$0.getProgressBar();
                    Intrinsics.checkNotNull(progressBar);
                    progressBar.setVisibility(0);
                    return;
                }
                if (playbackState == 2) {
                    ProgressBar progressBar2 = this.this$0.getProgressBar();
                    Intrinsics.checkNotNull(progressBar2);
                    progressBar2.setVisibility(0);
                    return;
                }
                if (playbackState == 3) {
                    ProgressBar progressBar3 = this.this$0.getProgressBar();
                    Intrinsics.checkNotNull(progressBar3);
                    progressBar3.setVisibility(8);
                    if (this.this$0.isPlaying()) {
                        this.this$0.setActivityLive(true);
                        return;
                    }
                    return;
                }
                if (playbackState != 4) {
                    return;
                }
                this.this$0.setActivityLive(false);
                if (StringsKt.equals(this.this$0.islive, "1", true)) {
                    LiveStreamingYoutube.Companion companion = LiveStreamingYoutube.INSTANCE;
                    LiveStreamingYoutube.playPosition = 0L;
                    try {
                        UtkashRoom utkashRoom = this.this$0.getUtkashRoom();
                        Intrinsics.checkNotNull(utkashRoom);
                        if (utkashRoom.getyoutubedata().isUserExist(this.this$0.getVideo_id(), MakeMyExam.userId, this.this$0.isaudio)) {
                            UtkashRoom utkashRoom2 = this.this$0.getUtkashRoom();
                            Intrinsics.checkNotNull(utkashRoom2);
                            utkashRoom2.getyoutubedata().updateTime(Long.valueOf(LiveStreamingYoutube.playPosition), this.this$0.getVideo_id(), MakeMyExam.userId, this.this$0.isaudio);
                        } else {
                            YoutubePlayerTable youtubePlayerTable = new YoutubePlayerTable();
                            youtubePlayerTable.setYoutubeid(this.this$0.getUrl());
                            youtubePlayerTable.setYoutubetime(LiveStreamingYoutube.playPosition);
                            youtubePlayerTable.setIsaudio(this.this$0.isaudio);
                            youtubePlayerTable.setVideoid(this.this$0.getVideo_id());
                            youtubePlayerTable.setVideoname(this.this$0.getVideo_name());
                            youtubePlayerTable.setUserid(MakeMyExam.userId);
                            UtkashRoom utkashRoom3 = this.this$0.getUtkashRoom();
                            Intrinsics.checkNotNull(utkashRoom3);
                            utkashRoom3.getyoutubedata().addVideo(youtubePlayerTable);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                PlayerView playerView = this.this$0.playerView;
                Intrinsics.checkNotNull(playerView);
                if (playerView.getPlayer() != null) {
                    PlayerView playerView2 = this.this$0.playerView;
                    Intrinsics.checkNotNull(playerView2);
                    Player player = playerView2.getPlayer();
                    Intrinsics.checkNotNull(player);
                    player.seekTo(0L);
                    PlayerView playerView3 = this.this$0.playerView;
                    Intrinsics.checkNotNull(playerView3);
                    Player player2 = playerView3.getPlayer();
                    Intrinsics.checkNotNull(player2);
                    player2.setPlayWhenReady(false);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public void onIsPlayingChanged(boolean isPlaying) {
                super.onIsPlayingChanged(isPlaying);
                if (isPlaying && StringsKt.equals(this.this$0.islive, "5", true)) {
                    PlayerView playerView = this.this$0.playerView;
                    Intrinsics.checkNotNull(playerView);
                    Player player = playerView.getPlayer();
                    Intrinsics.checkNotNull(player);
                    long duration = player.getDuration();
                    PlayerView playerView2 = this.this$0.playerView;
                    Intrinsics.checkNotNull(playerView2);
                    Player player2 = playerView2.getPlayer();
                    Intrinsics.checkNotNull(player2);
                    if (duration <= player2.getContentPosition() + ((long) 30000)) {
                        TextView textView = this.this$0.speedTV;
                        Intrinsics.checkNotNull(textView);
                        if (textView.getVisibility() == 0) {
                            if (this.this$0.getPlayerSpeed() != null && !StringsKt.equals(this.this$0.getPlayerSpeed(), Const.Normal, true)) {
                                this.this$0.setPlayerSpeed(Const.Normal);
                                PlayerView playerView3 = this.this$0.playerView;
                                Intrinsics.checkNotNull(playerView3);
                                Player player3 = playerView3.getPlayer();
                                Intrinsics.checkNotNull(player3);
                                Float fValueOf = Float.valueOf("1");
                                Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(...)");
                                player3.setPlaybackParameters(new PlaybackParameters(fValueOf.floatValue(), 1.0f));
                            }
                            TextView textView2 = this.this$0.speedTV;
                            Intrinsics.checkNotNull(textView2);
                            textView2.setVisibility(8);
                            TextView textView3 = this.this$0.speedTV;
                            Intrinsics.checkNotNull(textView3);
                            textView3.setText(Const.Normal);
                            return;
                        }
                        return;
                    }
                    TextView textView4 = this.this$0.speedTV;
                    Intrinsics.checkNotNull(textView4);
                    textView4.setVisibility(0);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayerError(PlaybackException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                super.onPlayerError(error);
                this.this$0.inErrorState = true;
            }

            @Override // androidx.media3.common.Player.Listener
            public void onCues(List<Cue> cues) {
                Intrinsics.checkNotNullParameter(cues, "cues");
                super.onCues(cues);
            }
        };
        this.cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda68
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LiveStreamingYoutube.cropImage$lambda$88(this.f$0, (CropImageView.CropResult) obj);
            }
        });
        this.someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda69
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LiveStreamingYoutube.someActivityResultLauncher$lambda$89(this.f$0, (ActivityResult) obj);
            }
        });
        this.messageInterceptor = new MucMessageInterceptor() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda70
            @Override // org.jivesoftware.smackx.muc.MucMessageInterceptor
            public final void intercept(MessageBuilder messageBuilder, MultiUserChat multiUserChat) {
                LiveStreamingYoutube.messageInterceptor$lambda$92(messageBuilder, multiUserChat);
            }
        };
        this.ejabberedMessageListener = new MessageListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda71
            @Override // org.jivesoftware.smack.MessageListener
            public final void processMessage(Message message) {
                LiveStreamingYoutube.ejabberedMessageListener$lambda$94(this.f$0, message);
            }
        };
        this.incomingQueue = new ConcurrentLinkedQueue<>();
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.incomingQueueEmoji = new ConcurrentLinkedQueue<>();
        this.uiHandlerEmoji = new Handler(Looper.getMainLooper());
        this.requestPermissionLauncher1 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda72
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LiveStreamingYoutube.requestPermissionLauncher1$lambda$128(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        this.rating = "";
        this.ratingType = 3;
        this.ratingMessage = "";
        this.feedbackDialog = new Utils.FeedbackBottomSheetDialog[1];
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        this.utkashRoom = utkashRoom;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public final AbstractYouTubePlayerListener getYouTubePlayerListener() {
        return this.youTubePlayerListener;
    }

    public final void setYouTubePlayerListener(AbstractYouTubePlayerListener abstractYouTubePlayerListener) {
        this.youTubePlayerListener = abstractYouTubePlayerListener;
    }

    public final String getIsclicked() {
        return this.isclicked;
    }

    public final void setIsclicked(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isclicked = str;
    }

    /* JADX INFO: renamed from: isUserCopied, reason: from getter */
    public final boolean getIsUserCopied() {
        return this.isUserCopied;
    }

    public final void setUserCopied(boolean z) {
        this.isUserCopied = z;
    }

    public final String getStr_imgTypeClick() {
        return this.str_imgTypeClick;
    }

    public final void setStr_imgTypeClick(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.str_imgTypeClick = str;
    }

    public final ArrayList<AppPermissionsRunTime.MyPermissionConstants> getMyPermissionConstantsArrayList() {
        return this.myPermissionConstantsArrayList;
    }

    public final void setMyPermissionConstantsArrayList(ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList) {
        this.myPermissionConstantsArrayList = arrayList;
    }

    public final int getREQUEST_CODE_PERMISSION_MULTIPLE() {
        return this.REQUEST_CODE_PERMISSION_MULTIPLE;
    }

    public final ArrayList<AddOptionModel> getOptionList() {
        return this.optionList;
    }

    public final void setOptionList(ArrayList<AddOptionModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.optionList = arrayList;
    }

    /* JADX INFO: renamed from: isUserOnPoll, reason: from getter */
    public final boolean getIsUserOnPoll() {
        return this.isUserOnPoll;
    }

    public final void setUserOnPoll(boolean z) {
        this.isUserOnPoll = z;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(int i) {
        this.requestCode = i;
    }

    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    public final void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public final ProgressBar getProgress_bar_pdf() {
        return this.progress_bar_pdf;
    }

    public final void setProgress_bar_pdf(ProgressBar progressBar) {
        this.progress_bar_pdf = progressBar;
    }

    public final String getAudio_url() {
        return this.audio_url;
    }

    public final void setAudio_url(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.audio_url = str;
    }

    public final String getIslockedback() {
        return this.islockedback;
    }

    public final void setIslockedback(String str) {
        this.islockedback = str;
    }

    public final String getPlayerSpeed() {
        return this.playerSpeed;
    }

    public final void setPlayerSpeed(String str) {
        this.playerSpeed = str;
    }

    public final boolean getBitrateapply() {
        return this.bitrateapply;
    }

    public final void setBitrateapply(boolean z) {
        this.bitrateapply = z;
    }

    public final int getLastseleted() {
        return this.lastseleted;
    }

    public final void setLastseleted(int i) {
        this.lastseleted = i;
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public final void setWebView(WebView webView) {
        this.webView = webView;
    }

    public final YTubePlayerView getYTubePlayerView() {
        return this.yTubePlayerView;
    }

    public final void setYTubePlayerView(YTubePlayerView yTubePlayerView) {
        this.yTubePlayerView = yTubePlayerView;
    }

    public final MediaSource getMediaSource() {
        return this.mediaSource;
    }

    public final void setMediaSource(MediaSource mediaSource) {
        this.mediaSource = mediaSource;
    }

    public final DefaultTrackSelector getTrackSelector() {
        return this.trackSelector;
    }

    public final void setTrackSelector(DefaultTrackSelector defaultTrackSelector) {
        this.trackSelector = defaultTrackSelector;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final ImageView getQuality() {
        return this.quality;
    }

    public final void setQuality(ImageView imageView) {
        this.quality = imageView;
    }

    public final ChatAdapter getChatAdapter() {
        return this.chatAdapter;
    }

    public final void setChatAdapter(ChatAdapter chatAdapter) {
        this.chatAdapter = chatAdapter;
    }

    public final ChildEventListener getGetchatdata() {
        return this.getchatdata;
    }

    public final void setGetchatdata(ChildEventListener childEventListener) {
        this.getchatdata = childEventListener;
    }

    public final LinearLayout getLlEnableMarkAsRead() {
        return this.llEnableMarkAsRead;
    }

    public final void setLlEnableMarkAsRead(LinearLayout linearLayout) {
        this.llEnableMarkAsRead = linearLayout;
    }

    /* JADX INFO: renamed from: isVideoReadMarked, reason: from getter */
    public final boolean getIsVideoReadMarked() {
        return this.isVideoReadMarked;
    }

    public final void setVideoReadMarked(boolean z) {
        this.isVideoReadMarked = z;
    }

    public final ImageView getIvSend() {
        return this.ivSend;
    }

    public final void setIvSend(ImageView imageView) {
        this.ivSend = imageView;
    }

    public final String getModeOfPoll() {
        return this.modeOfPoll;
    }

    public final void setModeOfPoll(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modeOfPoll = str;
    }

    public final LinearLayout getLinearLayout() {
        return this.linearLayout;
    }

    public final void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }

    public final LinearLayout getTextLayout() {
        return this.textLayout;
    }

    public final void setTextLayout(LinearLayout linearLayout) {
        this.textLayout = linearLayout;
    }

    public final LinearLayout getEndLayout() {
        return this.endLayout;
    }

    public final void setEndLayout(LinearLayout linearLayout) {
        this.endLayout = linearLayout;
    }

    public final LinearLayout getAudioMainLL() {
        return this.audioMainLL;
    }

    public final void setAudioMainLL(LinearLayout linearLayout) {
        this.audioMainLL = linearLayout;
    }

    public final ImageView getPauseAudio() {
        return this.pauseAudio;
    }

    public final void setPauseAudio(ImageView imageView) {
        this.pauseAudio = imageView;
    }

    public final ImageView getCancelRecording() {
        return this.cancelRecording;
    }

    public final void setCancelRecording(ImageView imageView) {
        this.cancelRecording = imageView;
    }

    public final ImageView getSendRecording() {
        return this.sendRecording;
    }

    public final void setSendRecording(ImageView imageView) {
        this.sendRecording = imageView;
    }

    public final TextView getAudioRecordTime() {
        return this.audioRecordTime;
    }

    public final void setAudioRecordTime(TextView textView) {
        this.audioRecordTime = textView;
    }

    public final LinearLayout getLlll() {
        return this.llll;
    }

    public final void setLlll(LinearLayout linearLayout) {
        this.llll = linearLayout;
    }

    public final LinearLayout getChatlayout() {
        return this.chatlayout;
    }

    public final void setChatlayout(LinearLayout linearLayout) {
        this.chatlayout = linearLayout;
    }

    /* JADX INFO: renamed from: isShowViewAllLeaderBoard, reason: from getter */
    public final boolean getIsShowViewAllLeaderBoard() {
        return this.isShowViewAllLeaderBoard;
    }

    public final void setShowViewAllLeaderBoard(boolean z) {
        this.isShowViewAllLeaderBoard = z;
    }

    /* JADX INFO: renamed from: isOperator, reason: from getter */
    public final boolean getIsOperator() {
        return this.isOperator;
    }

    public final void setOperator(boolean z) {
        this.isOperator = z;
    }

    public final TextView getAddBookmark() {
        return this.addBookmark;
    }

    public final void setAddBookmark(TextView textView) {
        this.addBookmark = textView;
    }

    public final ArrayList<chatPojo> getArrChat() {
        return this.arrChat;
    }

    public final void setArrChat(ArrayList<chatPojo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.arrChat = arrayList;
    }

    public final ArrayList<chatPojo> getPollarr() {
        return this.pollarr;
    }

    public final void setPollarr(ArrayList<chatPojo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.pollarr = arrayList;
    }

    public final ArrayList<Polldata> getPollarraylist() {
        return this.pollarraylist;
    }

    public final void setPollarraylist(ArrayList<Polldata> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.pollarraylist = arrayList;
    }

    public final EditText getEtMessage() {
        return this.etMessage;
    }

    public final void setEtMessage(EditText editText) {
        this.etMessage = editText;
    }

    public final DefaultTimeBar getDefaultTimeBar() {
        return this.defaultTimeBar;
    }

    public final void setDefaultTimeBar(DefaultTimeBar defaultTimeBar) {
        this.defaultTimeBar = defaultTimeBar;
    }

    public final TextView getExo_duration() {
        return this.exo_duration;
    }

    public final void setExo_duration(TextView textView) {
        this.exo_duration = textView;
    }

    public final TextView getExo_position() {
        return this.exo_position;
    }

    public final void setExo_position(TextView textView) {
        this.exo_position = textView;
    }

    public final String getSpeedx() {
        return this.speedx;
    }

    public final void setSpeedx(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.speedx = str;
    }

    public final View getRootView() {
        return this.rootView;
    }

    public final void setRootView(View view) {
        this.rootView = view;
    }

    public final String getThumbnailurl() {
        return this.thumbnailurl;
    }

    public final void setThumbnailurl(String str) {
        this.thumbnailurl = str;
    }

    public final String getVideo_id() {
        return this.video_id;
    }

    public final void setVideo_id(String str) {
        this.video_id = str;
    }

    public final String getVideo_name() {
        return this.video_name;
    }

    public final void setVideo_name(String str) {
        this.video_name = str;
    }

    public final Bitmap getImage() {
        return this.image;
    }

    public final void setImage(Bitmap bitmap) {
        this.image = bitmap;
    }

    /* JADX INFO: renamed from: isActivityLive, reason: from getter */
    public final boolean getIsActivityLive() {
        return this.isActivityLive;
    }

    public final void setActivityLive(boolean z) {
        this.isActivityLive = z;
    }

    public final PollAdapter getPollAdapter() {
        return this.pollAdapter;
    }

    public final void setPollAdapter(PollAdapter pollAdapter) {
        this.pollAdapter = pollAdapter;
    }

    public final ArrayList<chatPojo> getLockarr() {
        return this.lockarr;
    }

    public final void setLockarr(ArrayList<chatPojo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.lockarr = arrayList;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final ImageView getAudiocaetimage() {
        return this.audiocaetimage;
    }

    public final void setAudiocaetimage(ImageView imageView) {
        this.audiocaetimage = imageView;
    }

    public final String getChat_node() {
        return this.Chat_node;
    }

    public final void setChat_node(String str) {
        this.Chat_node = str;
    }

    public final String getCourse_id() {
        return this.course_id;
    }

    public final void setCourse_id(String str) {
        this.course_id = str;
    }

    public final String getTileid() {
        return this.tileid;
    }

    public final void setTileid(String str) {
        this.tileid = str;
    }

    public final String getTiletype() {
        return this.tiletype;
    }

    public final void setTiletype(String str) {
        this.tiletype = str;
    }

    public final String getAdd_bookmark() {
        return this.add_bookmark;
    }

    public final void setAdd_bookmark(String str) {
        this.add_bookmark = str;
    }

    public final TextView getFloatingText() {
        return this.floatingText;
    }

    public final void setFloatingText(TextView textView) {
        this.floatingText = textView;
    }

    public final TextView getVideo_name_text() {
        return this.video_name_text;
    }

    public final void setVideo_name_text(TextView textView) {
        this.video_name_text = textView;
    }

    public final ImageView getVideo_feedback() {
        return this.video_feedback;
    }

    public final void setVideo_feedback(ImageView imageView) {
        this.video_feedback = imageView;
    }

    public final ValueEventListener getOnetomanyvalueEventListener() {
        return this.onetomanyvalueEventListener;
    }

    public final void setOnetomanyvalueEventListener(ValueEventListener valueEventListener) {
        this.onetomanyvalueEventListener = valueEventListener;
    }

    public final ValueEventListener getChatLockedValueEventListener() {
        return this.chatLockedValueEventListener;
    }

    public final void setChatLockedValueEventListener(ValueEventListener valueEventListener) {
        this.chatLockedValueEventListener = valueEventListener;
    }

    public final ValueEventListener getPollAddedEventListener() {
        return this.pollAddedEventListener;
    }

    public final void setPollAddedEventListener(ValueEventListener valueEventListener) {
        this.pollAddedEventListener = valueEventListener;
    }

    public final ValueEventListener getValueEventListener() {
        return this.valueEventListener;
    }

    public final void setValueEventListener(ValueEventListener valueEventListener) {
        this.valueEventListener = valueEventListener;
    }

    public final String getPosition() {
        return this.position;
    }

    public final void setPosition(String str) {
        this.position = str;
    }

    public final String getParentid() {
        return this.parentid;
    }

    public final void setParentid(String str) {
        this.parentid = str;
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }

    public final ArrayList<chatPojo> getPinchatList() {
        return this.pinchatList;
    }

    public final void setPinchatList(ArrayList<chatPojo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.pinchatList = arrayList;
    }

    public final ImageView getStartaudio() {
        return this.startaudio;
    }

    public final void setStartaudio(ImageView imageView) {
        this.startaudio = imageView;
    }

    public final TextView getRecordtime() {
        return this.recordtime;
    }

    public final void setRecordtime(TextView textView) {
        this.recordtime = textView;
    }

    public final MediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }

    public final void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public final Button getPlay() {
        return this.play;
    }

    public final void setPlay(Button button) {
        this.play = button;
    }

    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    public final void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public final SharedPreferences.Editor getEditor() {
        return this.editor;
    }

    public final void setEditor(SharedPreferences.Editor editor) {
        this.editor = editor;
    }

    public final String getBookmarkState() {
        return this.bookmarkState;
    }

    public final void setBookmarkState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bookmarkState = str;
    }

    public final String getVideoId_value() {
        return this.videoId_value;
    }

    public final void setVideoId_value(String str) {
        this.videoId_value = str;
    }

    public final int getI() {
        return this.i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    public final ChatUser getChatUser() {
        return this.chatUser;
    }

    public final void setChatUser(ChatUser chatUser) {
        this.chatUser = chatUser;
    }

    public final List<MuxedStream> getListVideosYoutube() {
        return this.listVideosYoutube;
    }

    public final void setListVideosYoutube(List<MuxedStream> list) {
        this.listVideosYoutube = list;
    }

    public final TextView getNextVideo() {
        return this.nextVideo;
    }

    public final void setNextVideo(TextView textView) {
        this.nextVideo = textView;
    }

    public final ImageView getRefreshUrl() {
        return this.refreshUrl;
    }

    public final void setRefreshUrl(ImageView imageView) {
        this.refreshUrl = imageView;
    }

    public final YouTubePlayerView getYoutube_player_view() {
        return this.youtube_player_view;
    }

    public final void setYoutube_player_view(YouTubePlayerView youTubePlayerView) {
        this.youtube_player_view = youTubePlayerView;
    }

    /* JADX INFO: renamed from: isFullscreen, reason: from getter */
    public final boolean getIsFullscreen() {
        return this.isFullscreen;
    }

    public final void setFullscreen(boolean z) {
        this.isFullscreen = z;
    }

    public final View getView() {
        return this.view;
    }

    public final void setView(View view) {
        this.view = view;
    }

    public final int getSavedOrientation1() {
        return this.savedOrientation1;
    }

    public final void setSavedOrientation1(int i) {
        this.savedOrientation1 = i;
    }

    public final PDFView getPdfViewPager() {
        return this.pdfViewPager;
    }

    public final void setPdfViewPager(PDFView pDFView) {
        this.pdfViewPager = pDFView;
    }

    public final InputStream getInput() {
        return this.input;
    }

    public final void setInput(InputStream inputStream) {
        this.input = inputStream;
    }

    public final HttpURLConnection getUrlConnection() {
        return this.urlConnection;
    }

    public final void setUrlConnection(HttpURLConnection httpURLConnection) {
        this.urlConnection = httpURLConnection;
    }

    public final OutputStream getOutput() {
        return this.output;
    }

    public final void setOutput(OutputStream outputStream) {
        this.output = outputStream;
    }

    /* JADX INFO: renamed from: isUserScrolled, reason: from getter */
    public final boolean getIsUserScrolled() {
        return this.isUserScrolled;
    }

    public final void setUserScrolled(boolean z) {
        this.isUserScrolled = z;
    }

    /* JADX INFO: renamed from: isFirebaseChat, reason: from getter */
    public final boolean getIsFirebaseChat() {
        return this.isFirebaseChat;
    }

    public final void setFirebaseChat(boolean z) {
        this.isFirebaseChat = z;
    }

    public final LiveChat getLiveChat() {
        return this.liveChat;
    }

    public final void setLiveChat(LiveChat liveChat) {
        this.liveChat = liveChat;
    }

    public final Metarespo getExtraParam() {
        return this.extraParam;
    }

    public final void setExtraParam(Metarespo metarespo) {
        this.extraParam = metarespo;
    }

    public final String getVideoAdmin() {
        return this.videoAdmin;
    }

    public final void setVideoAdmin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoAdmin = str;
    }

    public final long getMLastClickTime() {
        return this.mLastClickTime;
    }

    public final void setMLastClickTime(long j) {
        this.mLastClickTime = j;
    }

    public final String getDoubtPublishStatus() {
        return this.doubtPublishStatus;
    }

    public final void setDoubtPublishStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.doubtPublishStatus = str;
    }

    /* JADX INFO: renamed from: isShowSubmit, reason: from getter */
    public final boolean getIsShowSubmit() {
        return this.isShowSubmit;
    }

    public final void setShowSubmit(boolean z) {
        this.isShowSubmit = z;
    }

    /* JADX INFO: renamed from: isUserOnDoubt, reason: from getter */
    public final boolean getIsUserOnDoubt() {
        return this.isUserOnDoubt;
    }

    public final void setUserOnDoubt(boolean z) {
        this.isUserOnDoubt = z;
    }

    /* JADX INFO: renamed from: isTextChanging, reason: from getter */
    public final boolean getIsTextChanging() {
        return this.isTextChanging;
    }

    public final void setTextChanging(boolean z) {
        this.isTextChanging = z;
    }

    public final String getDefaultTimeDuration() {
        return this.defaultTimeDuration;
    }

    public final void setDefaultTimeDuration(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultTimeDuration = str;
    }

    public final String getDefaultDelayDuration() {
        return this.defaultDelayDuration;
    }

    public final void setDefaultDelayDuration(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultDelayDuration = str;
    }

    public final RelativeLayout getTopImage() {
        RelativeLayout relativeLayout = this.topImage;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topImage");
        return null;
    }

    public final void setTopImage(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.topImage = relativeLayout;
    }

    public final TextView getLoveImage() {
        TextView textView = this.loveImage;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loveImage");
        return null;
    }

    public final void setLoveImage(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.loveImage = textView;
    }

    public final ArrayList<AttemptedUserPoll> getUserList() {
        return this.userList;
    }

    public final void setUserList(ArrayList<AttemptedUserPoll> arrayList) {
        this.userList = arrayList;
    }

    /* JADX INFO: renamed from: isLandscape, reason: from getter */
    public final boolean getIsLandscape() {
        return this.isLandscape;
    }

    public final void setLandscape(boolean z) {
        this.isLandscape = z;
    }

    public final LandscapePollDialog getLandscapePollDialog() {
        return this.landscapePollDialog;
    }

    public final void setLandscapePollDialog(LandscapePollDialog landscapePollDialog) {
        this.landscapePollDialog = landscapePollDialog;
    }

    public final String getSelectedStream() {
        return this.selectedStream;
    }

    public final void setSelectedStream(String str) {
        this.selectedStream = str;
    }

    public final String getCustomPlayer() {
        return this.customPlayer;
    }

    public final void setCustomPlayer(String str) {
        this.customPlayer = str;
    }

    public final String getControlYT() {
        return this.controlYT;
    }

    public final void setControlYT(String str) {
        this.controlYT = str;
    }

    public final File getTempFile() {
        return this.tempFile;
    }

    public final void setTempFile(File file) {
        this.tempFile = file;
    }

    public final BroadcastReceiver getDownloadPdfReceiver() {
        return this.downloadPdfReceiver;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0353  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r11) {
        /*
            Method dump skipped, instruction units count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(final LiveStreamingYoutube liveStreamingYoutube) {
        try {
            final Context applicationContext = liveStreamingYoutube.getApplicationContext();
            new OrientationEventListener(applicationContext) { // from class: com.appnew.android.player.LiveStreamingYoutube$onCreate$1$orientationEventListener$1
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    try {
                        if (Settings.System.getInt(this.this$0.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                            boolean zIsPortrait = this.this$0.isPortrait(orientation);
                            if (zIsPortrait || this.this$0.savedOrientation != 1) {
                                if (zIsPortrait && this.this$0.savedOrientation == 0) {
                                    this.this$0.savedOrientation = 1;
                                    this.this$0.setRequestedOrientation(2);
                                    return;
                                }
                                return;
                            }
                            this.this$0.savedOrientation = 0;
                            this.this$0.setRequestedOrientation(2);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }.enable();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(LiveStreamingYoutube liveStreamingYoutube, View view) {
        if (Helper.isNetworkConnected(liveStreamingYoutube)) {
            int i = liveStreamingYoutube.i;
            if (i < 3) {
                liveStreamingYoutube.i = i + 1;
                if (Intrinsics.areEqual(liveStreamingYoutube.bookmarkState, "0")) {
                    liveStreamingYoutube.bookmarkState = "1";
                    SharedPreferences.Editor editor = liveStreamingYoutube.editor;
                    if (editor != null) {
                        editor.remove(liveStreamingYoutube.video_id);
                    }
                    SharedPreferences.Editor editor2 = liveStreamingYoutube.editor;
                    if (editor2 != null) {
                        editor2.apply();
                    }
                    ImageView imageView = liveStreamingYoutube.video_bookmark;
                    Intrinsics.checkNotNull(imageView);
                    imageView.setImageResource(R.mipmap.bookmark_unselected);
                    NetworkCall networkCall = liveStreamingYoutube.networkCall;
                    Intrinsics.checkNotNull(networkCall);
                    networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
                    return;
                }
                liveStreamingYoutube.bookmarkState = "0";
                SharedPreferences.Editor editor3 = liveStreamingYoutube.editor;
                if (editor3 != null) {
                    editor3.putString(liveStreamingYoutube.video_id, "0");
                }
                SharedPreferences.Editor editor4 = liveStreamingYoutube.editor;
                if (editor4 != null) {
                    editor4.apply();
                }
                ImageView imageView2 = liveStreamingYoutube.video_bookmark;
                Intrinsics.checkNotNull(imageView2);
                imageView2.setImageResource(R.mipmap.bookmark_selected);
                NetworkCall networkCall2 = liveStreamingYoutube.networkCall;
                Intrinsics.checkNotNull(networkCall2);
                networkCall2.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
                return;
            }
            return;
        }
        String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        liveStreamingYoutube.showMessage(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(final LiveStreamingYoutube liveStreamingYoutube, View view) {
        liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda80
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.onCreate$lambda$3$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$2(LiveStreamingYoutube liveStreamingYoutube) {
        liveStreamingYoutube.isUserScrolled = false;
        RelativeLayout relativeLayout = liveStreamingYoutube.goToCurrentRl;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
        RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.smoothScrollToPosition(liveStreamingYoutube.arrChat.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(LiveStreamingYoutube liveStreamingYoutube, View view) {
        if (StringsKt.equals(liveStreamingYoutube.doubtPublishStatus, "publishCompletedDoubt", true)) {
            Helper.showSnackBar(liveStreamingYoutube.submitDoubts, "Doubts already submitted");
            return;
        }
        DoubtVideoAdapter doubtVideoAdapter = liveStreamingYoutube.doubtVideoAdapter;
        if (doubtVideoAdapter != null) {
            Intrinsics.checkNotNull(doubtVideoAdapter);
            if (!TextUtils.isEmpty(doubtVideoAdapter.getSelectedDoubts())) {
                liveStreamingYoutube.showConfirmationDialog("Are you sure want to continue!", "submit");
                return;
            }
        }
        Helper.showSnackBar(liveStreamingYoutube.submitDoubts, "Please select atleast one doubt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(LiveStreamingYoutube liveStreamingYoutube, View view) {
        if (liveStreamingYoutube.isOperator) {
            if (liveStreamingYoutube.doubtPublishStatus.equals("publishCompletedDoubt")) {
                Helper.showSnackBar(liveStreamingYoutube.publishDoubts, "Doubt submission completed");
                return;
            } else {
                liveStreamingYoutube.showConfirmationDialog("Are you sure want to continue!", "manage");
                return;
            }
        }
        Helper.showSnackBar(liveStreamingYoutube.publishDoubts, "You don't have access for this");
    }

    public final void showWebViewPlayer() {
        WebView webView = this.youtubePlayerView;
        if (webView != null) {
            webView.setVisibility(0);
        }
        PlayerView playerView = this.playerView;
        if (playerView != null) {
            playerView.setVisibility(8);
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        initPlayerWebView();
    }

    public final void showYoutubePlayer() {
        RelativeLayout relativeLayout = this.newYoutubePlayer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        WebView webView = this.youtubePlayerView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        FrameLayout frameLayout = this.youtubePlayerViewLay;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.youtubePlayerViewLay1;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        PlayerView playerView = this.playerView;
        if (playerView != null) {
            playerView.setVisibility(8);
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        initYoutubePlayer();
        clipBoardBubbleHandle();
    }

    private final void markAsReadVideoType1_7() {
        Video video;
        Object next;
        ArrayList<Video> arrayList = this.allVideosList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((Video) next).getId(), this.video_id)) {
                        break;
                    }
                }
            }
            video = (Video) next;
        } else {
            video = null;
        }
        String video_type = video != null ? video.getVideo_type() : null;
        if (video_type == null) {
            video_type = "";
        }
        boolean z = false;
        if (Helper.isShowMarkAsDone(video_type)) {
            LinearLayout linearLayout = this.llEnableMarkAsRead;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout2 = this.llEnableMarkAsRead;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        if (StringsKt.equals(video != null ? video.getId() : null, this.video_id, true)) {
            String mark_as_complete = video != null ? video.getMark_as_complete() : null;
            if (mark_as_complete != null && mark_as_complete.length() != 0) {
                if (StringsKt.equals(video != null ? video.getMark_as_complete() : null, "1", true)) {
                    z = true;
                }
            }
        }
        this.isVideoReadMarked = z;
        checkMarkUnmark();
        CheckBox checkBox = this.checkMark;
        if (checkBox != null) {
            checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda91
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveStreamingYoutube.markAsReadVideoType1_7$lambda$8(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void markAsReadVideoType1_7$lambda$8(LiveStreamingYoutube liveStreamingYoutube, View view) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.CheckBox");
        boolean zIsChecked = ((CheckBox) view).isChecked();
        if (zIsChecked) {
            liveStreamingYoutube.markCheckAlertDialog(zIsChecked);
        }
    }

    private final void checkMarkUnmark() {
        LinearLayout linearLayout = this.llEnableMarkAsRead;
        if (linearLayout != null && linearLayout.getVisibility() == 0 && this.isVideoReadMarked) {
            CheckBox checkBox = this.checkMark;
            if (checkBox != null) {
                checkBox.setChecked(true);
            }
            TextView textView = this.tvMark;
            if (textView != null) {
                textView.setText(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED);
            }
            CheckBox checkBox2 = this.checkMark;
            if (checkBox2 != null) {
                checkBox2.setEnabled(false);
                return;
            }
            return;
        }
        CheckBox checkBox3 = this.checkMark;
        if (checkBox3 != null) {
            checkBox3.setChecked(false);
        }
        TextView textView2 = this.tvMark;
        if (textView2 != null) {
            textView2.setText("Mark Complete");
        }
        CheckBox checkBox4 = this.checkMark;
        if (checkBox4 != null) {
            checkBox4.setEnabled(true);
        }
    }

    private final void markCheckAlertDialog(final boolean isChecked) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.mark_read));
        builder.setCancelable(false);
        builder.setMessage(getString(R.string.are_you_sure_you_want_to_mark_video_completed));
        builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveStreamingYoutube.markCheckAlertDialog$lambda$9(this.f$0, dialogInterface, i);
            }
        });
        builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveStreamingYoutube.markCheckAlertDialog$lambda$10(this.f$0, isChecked, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void markCheckAlertDialog$lambda$9(LiveStreamingYoutube liveStreamingYoutube, DialogInterface dialogInterface, int i) {
        CheckBox checkBox = liveStreamingYoutube.checkMark;
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void markCheckAlertDialog$lambda$10(LiveStreamingYoutube liveStreamingYoutube, boolean z, DialogInterface dialogInterface, int i) {
        if (Helper.isNetworkConnected(liveStreamingYoutube) && z) {
            NetworkCall networkCall = liveStreamingYoutube.networkCall;
            if (networkCall != null) {
                networkCall.NetworkAPICall(API.MARK_READ_VIDEO_TYPE_1_7, "", true, false);
            }
        } else {
            CheckBox checkBox = liveStreamingYoutube.checkMark;
            if (checkBox != null) {
                checkBox.setChecked(false);
            }
            liveStreamingYoutube.showMessage("No internet connection");
        }
        dialogInterface.dismiss();
    }

    private final void startMessageProcessor() {
        Handler handler;
        Runnable runnable;
        try {
            if (isDestroyed() || (handler = this.uiHandler) == null || (runnable = this.processQueueRunnable) == null) {
                return;
            }
            handler.post(runnable);
            ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue = this.incomingQueue;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
            }
        } catch (Exception e2) {
            Log.d("MQTT", "startMessageProcessor: " + e2.getMessage());
        }
    }

    private final void stopMessageProcessor() {
        Runnable runnable;
        try {
            Handler handler = this.uiHandler;
            if (handler == null || (runnable = this.processQueueRunnable) == null || this.incomingQueue == null) {
                return;
            }
            handler.removeCallbacks(runnable);
            this.incomingQueue.clear();
        } catch (Exception e2) {
            Log.d("MQTT", "stopMessageProcessor: " + e2.getMessage());
        }
    }

    private final void startMessageProcessorEmoji() {
        Handler handler;
        Runnable runnable;
        try {
            if (isDestroyed() || (handler = this.uiHandlerEmoji) == null || (runnable = this.processQueueRunnableEmoji) == null) {
                return;
            }
            handler.post(runnable);
            ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue = this.incomingQueueEmoji;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
            }
        } catch (Exception e2) {
            Log.d("MQTT", "startMessageProcessorEmoji: " + e2.getMessage());
        }
    }

    private final void stopMessageProcessorEmoji() {
        Runnable runnable;
        try {
            Handler handler = this.uiHandlerEmoji;
            if (handler == null || (runnable = this.processQueueRunnableEmoji) == null || this.incomingQueueEmoji == null) {
                return;
            }
            handler.removeCallbacks(runnable);
            this.incomingQueueEmoji.clear();
        } catch (Exception e2) {
            Log.d("MQTT", "stopMessageProcessorEmoji: " + e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleBottomSettings() {
        /*
            r5 = this;
            com.appnew.android.Room.UtkashRoom r0 = r5.utkashRoom
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.appnew.android.Dao.ThemeSettingDao r0 = r0.getthemeSettingdao()
            boolean r0 = r0.is_setting_exit()
            if (r0 == 0) goto L42
            com.appnew.android.Room.UtkashRoom r0 = r5.utkashRoom
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.appnew.android.Dao.ThemeSettingDao r0 = r0.getthemeSettingdao()
            com.appnew.android.table.ThemeSettings r0 = r0.data()
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.String r2 = r0.getBottom()
            java.lang.Class<com.appnew.android.Model.BottomSetting> r3 = com.appnew.android.Model.BottomSetting.class
            java.lang.Object r1 = r1.fromJson(r2, r3)
            com.appnew.android.Model.BottomSetting r1 = (com.appnew.android.Model.BottomSetting) r1
            r5.bottomSetting = r1
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.String r0 = r0.getLeft_menu()
            java.lang.Class<com.appnew.android.Model.LeftMenu> r2 = com.appnew.android.Model.LeftMenu.class
            java.lang.Object r0 = r1.fromJson(r0, r2)
            com.appnew.android.Model.LeftMenu r0 = (com.appnew.android.Model.LeftMenu) r0
            r5.leftMenu = r0
        L42:
            com.appnew.android.Model.BottomSetting r0 = r5.bottomSetting
            if (r0 == 0) goto Lb2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getAttachment()
            r1 = 1
            java.lang.String r2 = "1"
            r3 = 0
            r4 = 8
            if (r0 == 0) goto L6d
            com.appnew.android.Model.BottomSetting r0 = r5.bottomSetting
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getAttachment()
            boolean r0 = kotlin.text.StringsKt.equals(r0, r2, r1)
            if (r0 == 0) goto L6d
            android.widget.ImageView r0 = r5.file_upload
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r3)
            goto L75
        L6d:
            android.widget.ImageView r0 = r5.file_upload
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r4)
        L75:
            com.appnew.android.Model.BottomSetting r0 = r5.bottomSetting
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getAudio()
            if (r0 == 0) goto La1
            com.appnew.android.Model.BottomSetting r0 = r5.bottomSetting
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getAudio()
            boolean r0 = kotlin.text.StringsKt.equals(r0, r2, r1)
            if (r0 == 0) goto La1
            android.widget.ImageView r0 = r5.startaudio
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r3)
            android.widget.ImageView r0 = r5.ivSend
            if (r0 == 0) goto Lb2
            android.view.View r0 = (android.view.View) r0
            r0.setVisibility(r4)
            return
        La1:
            android.widget.ImageView r0 = r5.startaudio
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r4)
            android.widget.ImageView r0 = r5.ivSend
            if (r0 == 0) goto Lb2
            android.view.View r0 = (android.view.View) r0
            r0.setVisibility(r3)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.handleBottomSettings():void");
    }

    private final void setChatAdapter() {
        if (this.leftMenu == null) {
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.utkashRoom = appDatabase;
            Intrinsics.checkNotNull(appDatabase);
            if (appDatabase.getthemeSettingdao().is_setting_exit()) {
                UtkashRoom utkashRoom = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom);
                this.leftMenu = (LeftMenu) new Gson().fromJson(utkashRoom.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
            }
        }
        LiveStreamingYoutube liveStreamingYoutube = this;
        this.chatAdapter = new ChatAdapter(liveStreamingYoutube, Const.SHOW_PIN, this.pinchatList, this.leftMenu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(liveStreamingYoutube);
        this.llm = linearLayoutManager;
        Intrinsics.checkNotNull(linearLayoutManager);
        linearLayoutManager.setAutoMeasureEnabled(false);
        LinearLayoutManager linearLayoutManager2 = this.llm;
        Intrinsics.checkNotNull(linearLayoutManager2);
        linearLayoutManager2.setStackFromEnd(true);
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(this.llm);
        RecyclerView recyclerView2 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setAdapter(this.chatAdapter);
    }

    public final boolean isLastVisible() {
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        RecyclerView recyclerView2 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView2);
        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
        Intrinsics.checkNotNull(adapter);
        return iFindLastCompletelyVisibleItemPosition >= adapter.getItemCount() - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleIsLive() {
        /*
            r4 = this;
            java.lang.String r0 = r4.islive
            java.lang.String r1 = "5"
            r2 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r2)
            r1 = 0
            if (r0 == 0) goto L82
            android.widget.TextView r0 = r4.speedTV
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r3 = 8
            r0.setVisibility(r3)
            com.appnew.android.Model.BottomSetting r0 = r4.bottomSetting
            if (r0 == 0) goto L66
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getSeek_bar()
            if (r0 == 0) goto L4d
            com.appnew.android.Model.BottomSetting r0 = r4.bottomSetting
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getSeek_bar()
            java.lang.String r3 = "1"
            boolean r0 = kotlin.text.StringsKt.equals(r0, r3, r2)
            if (r0 == 0) goto L4d
            androidx.media3.ui.DefaultTimeBar r0 = r4.defaultTimeBar
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r1)
            android.widget.TextView r0 = r4.exo_position
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r1)
            android.widget.TextView r0 = r4.exo_duration
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r1)
            goto L66
        L4d:
            androidx.media3.ui.DefaultTimeBar r0 = r4.defaultTimeBar
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r2 = 4
            r0.setVisibility(r2)
            android.widget.TextView r0 = r4.exo_position
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r2)
            android.widget.TextView r0 = r4.exo_duration
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r2)
        L66:
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r0.<init>(r1, r1)
            r1 = 2131363218(0x7f0a0592, float:1.8346239E38)
            android.view.View r1 = r4.findViewById(r1)
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r1.setLayoutParams(r0)
            r1 = 2131363242(0x7f0a05aa, float:1.8346287E38)
            android.view.View r1 = r4.findViewById(r1)
            r1.setLayoutParams(r0)
            return
        L82:
            android.widget.TextView r0 = r4.speedTV
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.handleIsLive():void");
    }

    private final Unit getDataFromIntent() {
        if (getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            this.url = extras.getString(Const.VIDEO_LINK);
            Bundle extras2 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras2);
            youtubeUri = extras2.getString(Const.VIDEO_LINK);
            Bundle extras3 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras3);
            this.islive = extras3.getString("live");
            Bundle extras4 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras4);
            this.is_ved_live = extras4.getString("is_ved_live");
            Bundle extras5 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras5);
            this.isaudio = extras5.getString("isaudio");
            this.thumbnailurl = "http://img.youtube.com/vi/" + this.url + "/0.jpg";
            this.video_id = getIntent().getStringExtra(Const.VIDEO_ID);
            this.video_name = getIntent().getStringExtra("video_name");
            this.Chat_node = getIntent().getStringExtra("Chat_node");
            this.islockedback = getIntent().getStringExtra("islocked");
            this.course_id = getIntent().getStringExtra("courseid");
            this.parentid = getIntent().getStringExtra(Const.shareparentid);
            this.tileid = getIntent().getStringExtra("tileid");
            this.tiletype = getIntent().getStringExtra("tiletype");
            this.add_bookmark = getIntent().getStringExtra("bookmark");
            this.position = getIntent().getStringExtra(Constants.INAPP_POSITION);
            String string = SharedPreference.getInstance().getString(Const.SELECTED_STREAM_YT);
            if (string == null || string.length() == 0) {
                if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.CUSTOM_YOUTUBE_PLAYER)) && SharedPreference.getInstance().getString(Const.CUSTOM_YOUTUBE_PLAYER).equals("1")) {
                    this.selectedStream = "stream2";
                } else {
                    this.selectedStream = "stream1";
                }
            }
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.ALL_VIDEOS_LIST))) {
                this.allVideosList = (ArrayList) new Gson().fromJson(SharedPreference.getInstance().getString(Const.ALL_VIDEOS_LIST), new TypeToken<List<? extends Video>>() { // from class: com.appnew.android.player.LiveStreamingYoutube$dataFromIntent$1
                }.getType());
            }
        }
        return Unit.INSTANCE;
    }

    private final void setIds() {
        this.rl_pdf_data = (RelativeLayout) findViewById(R.id.rl_pdf_data);
        this.ic_full_pdf = (ImageView) findViewById(R.id.ic_full_pdf);
        this.ic_back_pdf = (ImageView) findViewById(R.id.ic_back_pdf);
        this.progress_bar_pdf = (ProgressBar) findViewById(R.id.progress_bar_pdf);
        this.pdfViewPager = (PDFView) findViewById(R.id.pdfView);
        this.newYoutubePlayer = (RelativeLayout) findViewById(R.id.newYoutubePlayer);
        this.youtube_player_view = (YouTubePlayerView) findViewById(R.id.youtube_player2);
        this.relativeLayout1 = (RelativeLayout) findViewById(R.id.relativeLayout1);
        this.relativeLYoutubeLogo = (FrameLayout) findViewById(R.id.relativeLYoutubeLogo);
        this.relativeLYoutubeLogoTab = (FrameLayout) findViewById(R.id.relativeLYoutubeLogoTab);
        this.suggestedVideoTab = (FrameLayout) findViewById(R.id.suggestedVideoTab);
        this.fullScreenContainer = (FrameLayout) findViewById(R.id.full_screen_view_container);
        this.refreshUrl = (ImageView) findViewById(R.id.refreshUrl);
        this.relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        this.relativeLayoutTab = (RelativeLayout) findViewById(R.id.relativeLayoutTab);
        View viewFindViewById = findViewById(R.id.progress_bar);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ProgressBar");
        this.progressBar = (ProgressBar) viewFindViewById;
        this.autoplayRow = (LinearLayout) findViewById(R.id.autoplayRow);
        this.nextVideo = (TextView) findViewById(R.id.nextVideo);
        this.quality = (ImageView) findViewById(R.id.quality);
        this.ivSend = (ImageView) findViewById(R.id.iv_send);
        this.llll = (LinearLayout) findViewById(R.id.llll);
        this.etMessage = (EditText) findViewById(R.id.et_message);
        View viewFindViewById2 = findViewById(R.id.recycler_view);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.recyclerChat = (RecyclerView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.goToCurrentRl);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.goToCurrentRl = (RelativeLayout) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.forDoubtll);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.forDoubtll = (LinearLayout) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.publishDoubts);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.publishDoubts = (RelativeLayout) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.unpublishtxt);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.unpublishtxt = (TextView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.publishTxt);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.publishTxt = (TextView) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.submitDoubts);
        Intrinsics.checkNotNull(viewFindViewById8, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.submitDoubts = (RelativeLayout) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.refressDoubtRl);
        Intrinsics.checkNotNull(viewFindViewById9, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.refressDoubtRl = (RelativeLayout) viewFindViewById9;
        View viewFindViewById10 = findViewById(R.id.topImage);
        Intrinsics.checkNotNull(viewFindViewById10, "null cannot be cast to non-null type android.widget.RelativeLayout");
        setTopImage((RelativeLayout) viewFindViewById10);
        View viewFindViewById11 = findViewById(R.id.loveImage);
        Intrinsics.checkNotNull(viewFindViewById11, "null cannot be cast to non-null type android.widget.TextView");
        setLoveImage((TextView) viewFindViewById11);
        View viewFindViewById12 = findViewById(R.id.llChatSetting);
        Intrinsics.checkNotNull(viewFindViewById12, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.llChatSetting = (LinearLayout) viewFindViewById12;
        View viewFindViewById13 = findViewById(R.id.switchChat);
        Intrinsics.checkNotNull(viewFindViewById13, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        this.switchChat = (SwitchCompat) viewFindViewById13;
        View viewFindViewById14 = findViewById(R.id.switchEmoticons);
        Intrinsics.checkNotNull(viewFindViewById14, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        this.switchEmoticons = (SwitchCompat) viewFindViewById14;
        View viewFindViewById15 = findViewById(R.id.switchPublic);
        Intrinsics.checkNotNull(viewFindViewById15, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        this.switchPublic = (SwitchCompat) viewFindViewById15;
        View viewFindViewById16 = findViewById(R.id.switchFeedback);
        Intrinsics.checkNotNull(viewFindViewById16, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        this.switchFeedback = (SwitchCompat) viewFindViewById16;
        this.linearLayout = (LinearLayout) findViewById(R.id.bottomlayout);
        this.endLayout = (LinearLayout) findViewById(R.id.endLayout);
        this.textLayout = (LinearLayout) findViewById(R.id.textLayout);
        this.audioMainLL = (LinearLayout) findViewById(R.id.audioMainLL);
        this.pauseAudio = (ImageView) findViewById(R.id.pauseAudio);
        this.cancelRecording = (ImageView) findViewById(R.id.cancelRecording);
        this.sendRecording = (ImageView) findViewById(R.id.sendRecording);
        this.audioRecordTime = (TextView) findViewById(R.id.audioRecordTime);
        View viewFindViewById17 = findViewById(R.id.linearLayout);
        Intrinsics.checkNotNull(viewFindViewById17, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.chatlayout = (LinearLayout) viewFindViewById17;
        this.addBookmark = (TextView) findViewById(R.id.add_bookmark);
        this.chatMainRl = (RelativeLayout) findViewById(R.id.chatMainRl);
        this.submitPoll = (RelativeLayout) findViewById(R.id.submitPoll);
        this.pollType = (TextView) findViewById(R.id.pollType);
        this.createPollNestedScrollView = (NestedScrollView) findViewById(R.id.createPollNestedScrollView);
        this.createPoll = (RelativeLayout) findViewById(R.id.createPoll);
        this.generateLeaderboard = (TextView) findViewById(R.id.generateLeaderboard);
        this.viewLeaderboard = (TextView) findViewById(R.id.viewLeaderboard);
        this.addPoll = (RelativeLayout) findViewById(R.id.addPoll);
        this.selectMode = (RelativeLayout) findViewById(R.id.selectMode);
        this.enterQuestionET = (EditText) findViewById(R.id.enterQuestionET);
        this.enterDelayET = (EditText) findViewById(R.id.enterDelayET);
        this.addOptionRecycler = (RecyclerView) findViewById(R.id.addOptionRecycler);
        this.recylerViewPollOperator = (RecyclerView) findViewById(R.id.recylerViewPollOperator);
        this.addOptionRl = (RelativeLayout) findViewById(R.id.addOptionRl);
        this.enterTimeET = (TextView) findViewById(R.id.enterTimeET);
        this.bookmark_btn = (CardView) findViewById(R.id.bookmark_btn);
        this.bookmarkLinear = (LinearLayout) findViewById(R.id.bookmarkLinear);
        this.bookmarkIcon = (ImageView) findViewById(R.id.bookmarkIcon);
        this.index_btn = (CardView) findViewById(R.id.index_btn);
        this.indexLinear = (LinearLayout) findViewById(R.id.indexLinear);
        this.indexIcon = (ImageView) findViewById(R.id.indexIcon);
        this.vodchat_btn = (CardView) findViewById(R.id.vodchat_btn);
        this.vodchatLinear = (LinearLayout) findViewById(R.id.vodchatLinear);
        this.vodChatIcon = (ImageView) findViewById(R.id.vodChatIcon);
        this.chat_btn = (CardView) findViewById(R.id.chat_btn);
        this.chatLinear = (LinearLayout) findViewById(R.id.chatLinear);
        this.liveChatIcon = (ImageView) findViewById(R.id.liveChatIcon);
        this.liveDot = (ImageView) findViewById(R.id.liveDot);
        this.poll = (CardView) findViewById(R.id.poll);
        this.pollMain = (LinearLayout) findViewById(R.id.pollMain);
        this.pollIcon = (ImageView) findViewById(R.id.pollIcon);
        this.pdf_btn = (CardView) findViewById(R.id.pdf_btn);
        this.pdfLinear = (LinearLayout) findViewById(R.id.pdfLinear);
        this.pdfIcon = (ImageView) findViewById(R.id.pdfIcon);
        this.pdfText = (TextView) findViewById(R.id.pdfText);
        this.doubt_btn = (CardView) findViewById(R.id.doubt_btn);
        this.doubtLinear = (LinearLayout) findViewById(R.id.doubtLinear);
        this.doubtIcon = (ImageView) findViewById(R.id.doubtIcon);
        this.doubtText = (TextView) findViewById(R.id.doubtText);
        isvisiblelayouts(0, 0, 0, 0, 0, 0, 0);
        manageButtonUI(false, false, false, false, false, false, false);
        this.llEnableMarkAsRead = (LinearLayout) findViewById(R.id.llMarkRead);
        this.checkMark = (CheckBox) findViewById(R.id.checkMark);
        this.tvMark = (TextView) findViewById(R.id.tvMark);
        View viewFindViewById18 = findViewById(R.id.floatingText_new);
        Intrinsics.checkNotNull(viewFindViewById18, "null cannot be cast to non-null type android.widget.TextView");
        this.floatingText = (TextView) viewFindViewById18;
        this.video_name_text = (TextView) findViewById(R.id.video_name);
        this.video_feedback = (ImageView) findViewById(R.id.video_feedback);
        this.rootView = findViewById(R.id.root_new);
        this.startaudio = (ImageView) findViewById(R.id.startaudio);
        this.file_upload = (ImageView) findViewById(R.id.file_upload);
        this.pinll = (LinearLayout) findViewById(R.id.pinll);
        this.pinChat = (TextView) findViewById(R.id.pinChat);
        this.video_bookmark = (ImageView) findViewById(R.id.video_bookmark);
        this.speedTV = (TextView) findViewById(R.id.exo_playback_speed);
        this.defaultTimeBar = (DefaultTimeBar) findViewById(R.id.exo_progress);
        this.exo_position = (TextView) findViewById(R.id.exo_position);
        this.exo_duration = (TextView) findViewById(R.id.exo_duration);
        this.fullscreen = (ImageView) findViewById(R.id.exo_fullscreen_icon);
        getWindow().clearFlags(1024);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((((getResources().getConfiguration().screenLayout & 15) == 3 ? 350 : (getResources().getConfiguration().screenLayout & 15) == 4 ? 450 : 250) * getResources().getDisplayMetrics().density) + 0.5f));
        View view = this.rootView;
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.root_view = findViewById(R.id.root_view);
        if (Build.VERSION.SDK_INT != 36 || this.root_view == null) {
            return;
        }
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        View view2 = this.root_view;
        Intrinsics.checkNotNull(view2);
        EdgeToEdgeHelperOld.applyInsets(this, window, view2, false, null);
    }

    private final void handleChatCopyPaste(final EditText etMessage) {
        try {
            if (Const.IS_CHAT_COPY_PASTE_ENABLE) {
                if (etMessage != null) {
                    etMessage.setInputType(524288);
                }
                if (etMessage != null) {
                    etMessage.setLongClickable(false);
                }
                if (etMessage != null) {
                    etMessage.setTextIsSelectable(false);
                }
                if (etMessage != null) {
                    etMessage.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnCreateContextMenuListener
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                            LiveStreamingYoutube.handleChatCopyPaste$lambda$11(contextMenu, view, contextMenuInfo);
                        }
                    });
                }
                if (etMessage != null) {
                    etMessage.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda7
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view) {
                            return LiveStreamingYoutube.handleChatCopyPaste$lambda$12(view);
                        }
                    });
                }
                if (etMessage != null) {
                    etMessage.setCustomInsertionActionModeCallback(new ActionMode.Callback() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleChatCopyPaste.3
                        @Override // android.view.ActionMode.Callback
                        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                            return false;
                        }

                        @Override // android.view.ActionMode.Callback
                        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                            return false;
                        }

                        @Override // android.view.ActionMode.Callback
                        public void onDestroyActionMode(ActionMode mode) {
                        }

                        @Override // android.view.ActionMode.Callback
                        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                            return false;
                        }
                    });
                }
                if (etMessage != null) {
                    etMessage.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleChatCopyPaste.4
                        @Override // android.view.ActionMode.Callback
                        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                            return false;
                        }

                        @Override // android.view.ActionMode.Callback
                        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                            return false;
                        }

                        @Override // android.view.ActionMode.Callback
                        public void onDestroyActionMode(ActionMode mode) {
                        }

                        @Override // android.view.ActionMode.Callback
                        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                            return false;
                        }
                    });
                }
                if (etMessage != null) {
                    etMessage.setOnTouchListener(new View.OnTouchListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda8
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return LiveStreamingYoutube.handleChatCopyPaste$lambda$13(etMessage, view, motionEvent);
                        }
                    });
                }
            }
            if (etMessage != null) {
                etMessage.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleChatCopyPaste.6
                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        Intrinsics.checkNotNullParameter(s, "s");
                        if (LiveStreamingYoutube.this.bottomSetting != null) {
                            BottomSetting bottomSetting = LiveStreamingYoutube.this.bottomSetting;
                            Intrinsics.checkNotNull(bottomSetting);
                            if (StringsKt.equals("1", bottomSetting.getAudio(), true)) {
                                if (LiveStreamingYoutube.this.getIvSend() != null) {
                                    ImageView ivSend = LiveStreamingYoutube.this.getIvSend();
                                    Intrinsics.checkNotNull(ivSend);
                                    ivSend.setVisibility(s.toString().length() == 0 ? 8 : 0);
                                }
                                if (LiveStreamingYoutube.this.getStartaudio() != null) {
                                    ImageView startaudio = LiveStreamingYoutube.this.getStartaudio();
                                    Intrinsics.checkNotNull(startaudio);
                                    startaudio.setVisibility(s.toString().length() == 0 ? 0 : 8);
                                }
                            }
                        }
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        Intrinsics.checkNotNullParameter(s, "s");
                        if (!Const.IS_CHAT_COPY_PASTE_ENABLE || LiveStreamingYoutube.this.getIsTextChanging()) {
                            return;
                        }
                        LiveStreamingYoutube.this.setTextChanging(true);
                        try {
                            if (after - count > 1) {
                                try {
                                    etMessage.setText(s);
                                    etMessage.setSelection(s.length());
                                } catch (StackOverflowError e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } finally {
                            LiveStreamingYoutube.this.setTextChanging(false);
                        }
                    }
                });
            }
        } catch (Exception e2) {
            Log.d("TAGCopyPaste", "handleChatCopyPaste: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleChatCopyPaste$lambda$11(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Intrinsics.checkNotNull(contextMenu);
        contextMenu.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleChatCopyPaste$lambda$13(EditText editText, View view, MotionEvent motionEvent) {
        Context context;
        try {
            Intrinsics.checkNotNull(motionEvent);
            if (motionEvent.getAction() != 0) {
                return false;
            }
            ClipboardManager clipboardManager = (ClipboardManager) ((editText == null || (context = editText.getContext()) == null) ? null : context.getSystemService("clipboard"));
            if (clipboardManager == null || !clipboardManager.hasPrimaryClip()) {
                return false;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private final void setClicks(final Bundle savedInstanceState) {
        TextView textView = this.nextVideo;
        Intrinsics.checkNotNull(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.autoplayNextVideo();
            }
        });
        TextView textView2 = this.pinChat;
        Intrinsics.checkNotNull(textView2);
        textView2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$15(this.f$0);
            }
        }));
        ImageView imageView = this.startaudio;
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$16(this.f$0, savedInstanceState);
            }
        }));
        ImageView imageView2 = this.file_upload;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.openChooseMediaBottomSheet();
            }
        });
        CardView cardView = this.bookmark_btn;
        Intrinsics.checkNotNull(cardView);
        cardView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$18(this.f$0);
            }
        }));
        CardView cardView2 = this.index_btn;
        Intrinsics.checkNotNull(cardView2);
        cardView2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$19(this.f$0);
            }
        }));
        CardView cardView3 = this.vodchat_btn;
        Intrinsics.checkNotNull(cardView3);
        cardView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveStreamingYoutube.setClicks$lambda$20(this.f$0, view);
            }
        });
        CardView cardView4 = this.chat_btn;
        Intrinsics.checkNotNull(cardView4);
        cardView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveStreamingYoutube.setClicks$lambda$21(this.f$0, view);
            }
        });
        CardView cardView5 = this.poll;
        Intrinsics.checkNotNull(cardView5);
        cardView5.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$22(this.f$0);
            }
        }));
        CardView cardView6 = this.pdf_btn;
        Intrinsics.checkNotNull(cardView6);
        cardView6.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$23(this.f$0);
            }
        }));
        CardView cardView7 = this.doubt_btn;
        Intrinsics.checkNotNull(cardView7);
        cardView7.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$24(this.f$0);
            }
        }));
        RelativeLayout relativeLayout = this.addOptionRl;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$29(this.f$0);
            }
        }));
        TextView textView3 = this.viewLeaderboard;
        Intrinsics.checkNotNull(textView3);
        textView3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$30(this.f$0);
            }
        }));
        TextView textView4 = this.generateLeaderboard;
        Intrinsics.checkNotNull(textView4);
        textView4.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$31(this.f$0);
            }
        }));
        RelativeLayout relativeLayout2 = this.createPoll;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$34(this.f$0);
            }
        }));
        RelativeLayout relativeLayout3 = this.submitPoll;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$35(this.f$0);
            }
        }));
        ImageView imageView3 = this.quality;
        Intrinsics.checkNotNull(imageView3);
        imageView3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$36(this.f$0);
            }
        }));
        RelativeLayout relativeLayout4 = this.selectMode;
        Intrinsics.checkNotNull(relativeLayout4);
        relativeLayout4.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$41(this.f$0);
            }
        }));
        TextView textView5 = this.enterTimeET;
        Intrinsics.checkNotNull(textView5);
        textView5.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.setClicks$lambda$43(this.f$0);
            }
        }));
        TextView textView6 = this.speedTV;
        if (textView6 != null) {
            Intrinsics.checkNotNull(textView6);
            textView6.setText(getResources().getString(R.string.normal));
            TextView textView7 = this.speedTV;
            Intrinsics.checkNotNull(textView7);
            textView7.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda35
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.showSpeedOptions();
                }
            });
        }
        ImageView imageView4 = this.fullscreen;
        Intrinsics.checkNotNull(imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveStreamingYoutube.setClicks$lambda$46(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$15(LiveStreamingYoutube liveStreamingYoutube) {
        if (Helper.isConnected(liveStreamingYoutube)) {
            liveStreamingYoutube.isChatPin = true;
            liveStreamingYoutube.setUpPinChat();
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$16(LiveStreamingYoutube liveStreamingYoutube, Bundle bundle) {
        if (Helper.isNetworkConnected(liveStreamingYoutube)) {
            Object systemService = liveStreamingYoutube.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(VibrationEffect.createOneShot(100L, -1));
            liveStreamingYoutube.stopWatch(bundle);
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$18(LiveStreamingYoutube liveStreamingYoutube) {
        liveStreamingYoutube.manageButtonUI(true, false, false, false, false, false, false);
        liveStreamingYoutube.setBookMark();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$19(LiveStreamingYoutube liveStreamingYoutube) {
        liveStreamingYoutube.manageButtonUI(false, true, false, false, false, false, false);
        liveStreamingYoutube.setIndex();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$20(LiveStreamingYoutube liveStreamingYoutube, View view) {
        liveStreamingYoutube.manageButtonUI(false, false, true, false, false, false, false);
        liveStreamingYoutube.setvodchat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$21(LiveStreamingYoutube liveStreamingYoutube, View view) {
        liveStreamingYoutube.manageButtonUI(false, false, false, true, false, false, false);
        liveStreamingYoutube.isChatPin = false;
        liveStreamingYoutube.setLiveChat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$22(LiveStreamingYoutube liveStreamingYoutube) {
        if (Helper.isConnected(liveStreamingYoutube)) {
            liveStreamingYoutube.manageButtonUI(false, false, false, false, true, false, false);
            liveStreamingYoutube.setPoll();
            Helper.closeKeyboard(liveStreamingYoutube);
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$23(LiveStreamingYoutube liveStreamingYoutube) {
        liveStreamingYoutube.manageButtonUI(false, false, false, false, false, true, false);
        liveStreamingYoutube.setNotes();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$24(LiveStreamingYoutube liveStreamingYoutube) {
        if (!liveStreamingYoutube.isUserOnDoubt) {
            liveStreamingYoutube.getAndUpdateDoubtList();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$29(LiveStreamingYoutube liveStreamingYoutube) {
        LiveStreamingYoutube liveStreamingYoutube2 = liveStreamingYoutube;
        if (Helper.isConnected(liveStreamingYoutube2)) {
            if (liveStreamingYoutube.optionList.size() > 0) {
                int size = liveStreamingYoutube.optionList.size();
                if (size == 1) {
                    liveStreamingYoutube.optionList.add(new AddOptionModel("Option 2", "B", false));
                } else if (size == 2) {
                    liveStreamingYoutube.optionList.add(new AddOptionModel("Option 3", "C", false));
                } else if (size == 3) {
                    liveStreamingYoutube.optionList.add(new AddOptionModel("Option 4", "D", false));
                } else {
                    liveStreamingYoutube.showMessage("You can add up to 4 option only");
                }
                RecyclerView recyclerView = liveStreamingYoutube.addOptionRecycler;
                Intrinsics.checkNotNull(recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(liveStreamingYoutube2));
                if (StringsKt.equals(liveStreamingYoutube.modeOfPoll, "1", true)) {
                    recyclerView.setAdapter(new AddOptionAdapter(liveStreamingYoutube2, liveStreamingYoutube.optionList, liveStreamingYoutube.addOptionRl));
                } else {
                    recyclerView.setAdapter(new AddOptionAdapter(liveStreamingYoutube2, liveStreamingYoutube.optionList, true, liveStreamingYoutube.addOptionRl));
                }
            }
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$30(LiveStreamingYoutube liveStreamingYoutube) {
        if (Helper.isConnected(liveStreamingYoutube)) {
            String strLeaderboardVideoWiseDataStr = liveStreamingYoutube.leaderboardVideoWiseDataStr();
            String str = liveStreamingYoutube.video_id;
            Intrinsics.checkNotNull(str);
            liveStreamingYoutube.sendWSMessage(strLeaderboardVideoWiseDataStr, "GET_LEADERBOARD_VIDEOWISE", str);
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$31(LiveStreamingYoutube liveStreamingYoutube) {
        if (Helper.isConnected(liveStreamingYoutube)) {
            liveStreamingYoutube.sendWSMessage(liveStreamingYoutube.generateLeaderboardVideoWiseDataStr(), "GENERATE_LEADERBOARD_VIDEOWISE", "");
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$34(LiveStreamingYoutube liveStreamingYoutube) {
        LiveStreamingYoutube liveStreamingYoutube2 = liveStreamingYoutube;
        if (Helper.isConnected(liveStreamingYoutube2)) {
            RelativeLayout relativeLayout = liveStreamingYoutube.createPoll;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(8);
            TextView textView = liveStreamingYoutube.generateLeaderboard;
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(8);
            TextView textView2 = liveStreamingYoutube.viewLeaderboard;
            Intrinsics.checkNotNull(textView2);
            textView2.setVisibility(8);
            RelativeLayout relativeLayout2 = liveStreamingYoutube.addPoll;
            Intrinsics.checkNotNull(relativeLayout2);
            relativeLayout2.setVisibility(0);
            RecyclerView recyclerView = liveStreamingYoutube.recylerViewPollOperator;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(8);
            liveStreamingYoutube.modeOfPoll = "2";
            TextView textView3 = liveStreamingYoutube.pollType;
            Intrinsics.checkNotNull(textView3);
            textView3.setText("Quiz");
            EditText editText = liveStreamingYoutube.enterQuestionET;
            Intrinsics.checkNotNull(editText);
            editText.getText().clear();
            TextView textView4 = liveStreamingYoutube.enterTimeET;
            Intrinsics.checkNotNull(textView4);
            textView4.setText(liveStreamingYoutube.defaultTimeDuration);
            EditText editText2 = liveStreamingYoutube.enterDelayET;
            Intrinsics.checkNotNull(editText2);
            editText2.setText(liveStreamingYoutube.defaultDelayDuration);
            liveStreamingYoutube.optionList.clear();
            ArrayList<AddOptionModel> arrayList = liveStreamingYoutube.optionList;
            arrayList.add(new AddOptionModel("Option 1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false));
            arrayList.add(new AddOptionModel("Option 2", "B", false));
            arrayList.add(new AddOptionModel("Option 3", "C", false));
            arrayList.add(new AddOptionModel("Option 4", "D", false));
            RecyclerView recyclerView2 = liveStreamingYoutube.addOptionRecycler;
            Intrinsics.checkNotNull(recyclerView2);
            recyclerView2.setLayoutManager(new LinearLayoutManager(liveStreamingYoutube2));
            recyclerView2.setAdapter(new AddOptionAdapter(liveStreamingYoutube2, liveStreamingYoutube.optionList, true, liveStreamingYoutube.addOptionRl));
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$35(LiveStreamingYoutube liveStreamingYoutube) {
        boolean z;
        boolean z2;
        if (SystemClock.elapsedRealtime() - liveStreamingYoutube.mLastClickTime < 1000) {
            return Unit.INSTANCE;
        }
        liveStreamingYoutube.mLastClickTime = SystemClock.elapsedRealtime();
        if (Helper.isConnected(liveStreamingYoutube)) {
            if (StringsKt.equals(liveStreamingYoutube.modeOfPoll, "2", true)) {
                Iterator<AddOptionModel> it = liveStreamingYoutube.optionList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        z2 = false;
                        break;
                    }
                    AddOptionModel next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    AddOptionModel addOptionModel = next;
                    if (TextUtils.isEmpty(addOptionModel.getAnswer())) {
                        z2 = false;
                        z = true;
                        break;
                    }
                    if (addOptionModel.isThisAnswerRight()) {
                        z = false;
                        z2 = true;
                        break;
                    }
                }
                if (z) {
                    liveStreamingYoutube.showMessage("Option can't be blank");
                    return Unit.INSTANCE;
                }
                if (!z2) {
                    liveStreamingYoutube.showMessage("Please select any answer");
                    return Unit.INSTANCE;
                }
            }
            TextView textView = liveStreamingYoutube.enterTimeET;
            Intrinsics.checkNotNull(textView);
            CharSequence text = textView.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (text.length() == 0) {
                TextView textView2 = liveStreamingYoutube.enterTimeET;
                Intrinsics.checkNotNull(textView2);
                if (TextUtils.isEmpty(textView2.getText().toString())) {
                    liveStreamingYoutube.showMessage("Please enter time duration");
                    return Unit.INSTANCE;
                }
            }
            EditText editText = liveStreamingYoutube.enterDelayET;
            Intrinsics.checkNotNull(editText);
            Editable text2 = editText.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            if (text2.length() == 0) {
                EditText editText2 = liveStreamingYoutube.enterDelayET;
                Intrinsics.checkNotNull(editText2);
                if (TextUtils.isEmpty(editText2.getText().toString())) {
                    liveStreamingYoutube.showMessage("Please enter delay time");
                    return Unit.INSTANCE;
                }
            }
            EditText editText3 = liveStreamingYoutube.enterDelayET;
            Intrinsics.checkNotNull(editText3);
            if (!TextUtils.isDigitsOnly(editText3.getText().toString())) {
                liveStreamingYoutube.showMessage("Please enter valid delay time");
                return Unit.INSTANCE;
            }
            if (liveStreamingYoutube.isFirebaseChat) {
                NetworkCall networkCall = liveStreamingYoutube.networkCall;
                Intrinsics.checkNotNull(networkCall);
                networkCall.NetworkAPICall(API.createPoll, "", true, false);
            } else {
                liveStreamingYoutube.sendWSMessage(liveStreamingYoutube.createPollDataStr(), "CREATE_POLL", "");
            }
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$36(LiveStreamingYoutube liveStreamingYoutube) {
        if (liveStreamingYoutube.listVideosYoutube == null) {
            String string = liveStreamingYoutube.getResources().getString(R.string.no_quality_found_till_yet);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        } else {
            PlayerView playerView = liveStreamingYoutube.playerView;
            Intrinsics.checkNotNull(playerView);
            if (playerView.getPlayer() != null) {
                liveStreamingYoutube.showAlertDialog();
            } else {
                String string2 = liveStreamingYoutube.getResources().getString(R.string.no_quality_found_till_yet);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                liveStreamingYoutube.showMessage(string2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$41(final LiveStreamingYoutube liveStreamingYoutube) {
        LiveStreamingYoutube liveStreamingYoutube2 = liveStreamingYoutube;
        if (Helper.isConnected(liveStreamingYoutube2)) {
            PopupMenu popupMenu = new PopupMenu(liveStreamingYoutube2, liveStreamingYoutube.selectMode, GravityCompat.START);
            popupMenu.getMenu().add("Survey");
            popupMenu.getMenu().add("Quiz");
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda90
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return LiveStreamingYoutube.setClicks$lambda$41$lambda$40(this.f$0, menuItem);
                }
            });
            popupMenu.show();
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setClicks$lambda$41$lambda$40(LiveStreamingYoutube liveStreamingYoutube, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        liveStreamingYoutube.optionList.clear();
        ArrayList<AddOptionModel> arrayList = liveStreamingYoutube.optionList;
        arrayList.add(new AddOptionModel("Option 1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false));
        arrayList.add(new AddOptionModel("Option 2", "B", false));
        arrayList.add(new AddOptionModel("Option 3", "C", false));
        arrayList.add(new AddOptionModel("Option 4", "D", false));
        CharSequence title = item.getTitle();
        Intrinsics.checkNotNull(title);
        if (StringsKt.equals(title.toString(), "Survey", true)) {
            liveStreamingYoutube.modeOfPoll = "1";
            TextView textView = liveStreamingYoutube.pollType;
            Intrinsics.checkNotNull(textView);
            textView.setText("Survey");
            EditText editText = liveStreamingYoutube.enterQuestionET;
            Intrinsics.checkNotNull(editText);
            editText.getText().clear();
            TextView textView2 = liveStreamingYoutube.enterTimeET;
            Intrinsics.checkNotNull(textView2);
            textView2.setText(liveStreamingYoutube.defaultTimeDuration);
            EditText editText2 = liveStreamingYoutube.enterDelayET;
            Intrinsics.checkNotNull(editText2);
            editText2.setText(liveStreamingYoutube.defaultDelayDuration);
            RecyclerView recyclerView = liveStreamingYoutube.addOptionRecycler;
            Intrinsics.checkNotNull(recyclerView);
            LiveStreamingYoutube liveStreamingYoutube2 = liveStreamingYoutube;
            recyclerView.setLayoutManager(new LinearLayoutManager(liveStreamingYoutube2));
            recyclerView.setAdapter(new AddOptionAdapter(liveStreamingYoutube2, liveStreamingYoutube.optionList, liveStreamingYoutube.addOptionRl));
        } else {
            CharSequence title2 = item.getTitle();
            Intrinsics.checkNotNull(title2);
            if (StringsKt.equals(title2.toString(), "Quiz", true)) {
                liveStreamingYoutube.modeOfPoll = "2";
                TextView textView3 = liveStreamingYoutube.pollType;
                Intrinsics.checkNotNull(textView3);
                textView3.setText("Quiz");
                EditText editText3 = liveStreamingYoutube.enterQuestionET;
                Intrinsics.checkNotNull(editText3);
                editText3.getText().clear();
                TextView textView4 = liveStreamingYoutube.enterTimeET;
                Intrinsics.checkNotNull(textView4);
                textView4.setText(liveStreamingYoutube.defaultTimeDuration);
                EditText editText4 = liveStreamingYoutube.enterDelayET;
                Intrinsics.checkNotNull(editText4);
                editText4.setText(liveStreamingYoutube.defaultDelayDuration);
                RecyclerView recyclerView2 = liveStreamingYoutube.addOptionRecycler;
                Intrinsics.checkNotNull(recyclerView2);
                LiveStreamingYoutube liveStreamingYoutube3 = liveStreamingYoutube;
                recyclerView2.setLayoutManager(new LinearLayoutManager(liveStreamingYoutube3));
                recyclerView2.setAdapter(new AddOptionAdapter(liveStreamingYoutube3, liveStreamingYoutube.optionList, true, liveStreamingYoutube.addOptionRl));
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$43(final LiveStreamingYoutube liveStreamingYoutube) {
        LiveStreamingYoutube liveStreamingYoutube2 = liveStreamingYoutube;
        if (Helper.isConnected(liveStreamingYoutube2)) {
            PopupMenu popupMenu = new PopupMenu(liveStreamingYoutube2, liveStreamingYoutube.enterTimeET, GravityCompat.START);
            popupMenu.getMenu().add("15 sec");
            popupMenu.getMenu().add("30 sec");
            popupMenu.getMenu().add("45 sec");
            popupMenu.getMenu().add("60 sec");
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda74
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return LiveStreamingYoutube.setClicks$lambda$43$lambda$42(this.f$0, menuItem);
                }
            });
            popupMenu.show();
        } else {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setClicks$lambda$43$lambda$42(LiveStreamingYoutube liveStreamingYoutube, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = liveStreamingYoutube.enterTimeET;
        Intrinsics.checkNotNull(textView);
        CharSequence title = item.getTitle();
        Intrinsics.checkNotNull(title);
        textView.setText(title.toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$46(LiveStreamingYoutube liveStreamingYoutube, View view) {
        Video video;
        Object next;
        LiveStreamingYoutube liveStreamingYoutube2 = liveStreamingYoutube;
        Helper.hideSoftKeyboard(liveStreamingYoutube2);
        Helper.closeKeyboard(liveStreamingYoutube2);
        if (liveStreamingYoutube.mExoPlayerFullscreen) {
            LinearLayout linearLayout = liveStreamingYoutube.llEnableMarkAsRead;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            liveStreamingYoutube.closeFullScreenDialogNew();
            return;
        }
        ArrayList<Video> arrayList = liveStreamingYoutube.allVideosList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((Video) next).getId(), liveStreamingYoutube.video_id)) {
                        break;
                    }
                }
            }
            video = (Video) next;
        } else {
            video = null;
        }
        String video_type = video != null ? video.getVideo_type() : null;
        if (video_type == null) {
            video_type = "";
        }
        if (Helper.isShowMarkAsDone(video_type) && Intrinsics.areEqual(liveStreamingYoutube.isclicked, "2")) {
            LinearLayout linearLayout2 = liveStreamingYoutube.llEnableMarkAsRead;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout3 = liveStreamingYoutube.llEnableMarkAsRead;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
        }
        liveStreamingYoutube.openFullScreenDialogNew();
    }

    public final void manageButtonUI(boolean forBookmark, boolean forIndex, boolean forVODchat, boolean forChat, boolean forPoll, boolean forPDF, boolean forDoubt) {
        LinearLayout linearLayout = this.bookmarkLinear;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forBookmark), getTheme()));
        LinearLayout linearLayout2 = this.indexLinear;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forIndex), getTheme()));
        LinearLayout linearLayout3 = this.vodchatLinear;
        Intrinsics.checkNotNull(linearLayout3);
        linearLayout3.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forVODchat), getTheme()));
        LinearLayout linearLayout4 = this.chatLinear;
        Intrinsics.checkNotNull(linearLayout4);
        linearLayout4.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forChat), getTheme()));
        LinearLayout linearLayout5 = this.pollMain;
        Intrinsics.checkNotNull(linearLayout5);
        linearLayout5.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forPoll), getTheme()));
        LinearLayout linearLayout6 = this.pdfLinear;
        Intrinsics.checkNotNull(linearLayout6);
        linearLayout6.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forPDF), getTheme()));
        LinearLayout linearLayout7 = this.doubtLinear;
        Intrinsics.checkNotNull(linearLayout7);
        linearLayout7.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forDoubt), getTheme()));
    }

    private final int getSelectedDrawable(boolean isSelected) {
        showTileIcon(0);
        return isSelected ? R.drawable.border_green_without_icon : R.drawable.grey_border_without_icon;
    }

    public final void showTileIcon(int visibleGone) {
        setTintWithAppColor(this.indexIcon, visibleGone);
        setTintWithAppColor(this.bookmarkIcon, visibleGone);
        setTintWithAppColor(this.vodChatIcon, visibleGone);
        setTintWithAppColor(this.liveChatIcon, visibleGone);
        setTintWithAppColor(this.pollIcon, visibleGone);
        setTintWithAppColor(this.pdfIcon, visibleGone);
        setTintWithAppColor(this.doubtIcon, visibleGone);
    }

    public final void setTintWithAppColor(ImageView imageView, int visibleGone) {
        if (imageView != null) {
            imageView.setVisibility(visibleGone);
        }
        if (imageView != null) {
            imageView.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
        }
    }

    public final void updateList(ArrayList<AddOptionModel> optionList) {
        Intrinsics.checkNotNullParameter(optionList, "optionList");
        this.optionList = optionList;
    }

    public final void updateListAfterText(ArrayList<AddOptionModel> optionList) {
        Intrinsics.checkNotNullParameter(optionList, "optionList");
        this.optionList = optionList;
    }

    public final void removeOption(int position) {
        AddOptionAdapter addOptionAdapter;
        this.optionList.remove(position);
        int size = this.optionList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            this.optionList.get(i).setOption("Option " + i2);
            this.optionList.get(i).setAnswer(getPollOptionQues(i));
            i = i2;
        }
        RecyclerView recyclerView = this.addOptionRecycler;
        Intrinsics.checkNotNull(recyclerView);
        LiveStreamingYoutube liveStreamingYoutube = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(liveStreamingYoutube));
        if (StringsKt.equals(this.modeOfPoll, "1", true)) {
            addOptionAdapter = new AddOptionAdapter(liveStreamingYoutube, this.optionList, this.addOptionRl);
        } else {
            addOptionAdapter = new AddOptionAdapter(liveStreamingYoutube, this.optionList, true, this.addOptionRl);
        }
        recyclerView.setAdapter(addOptionAdapter);
    }

    public final String getPollOptionQues(int index) {
        if (index == 0) {
            return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        }
        if (index == 1) {
            return "B";
        }
        if (index == 2) {
            return "C";
        }
        if (index == 3) {
            return "D";
        }
        if (index == 4) {
            return ExifInterface.LONGITUDE_EAST;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSpeedOptions() {
        String[] stringArray;
        PopupMenu popupMenu = new PopupMenu(this, this.speedTV, R.style.MyPopupMenu);
        Menu menu = popupMenu.getMenu();
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.MAX_SPEED), "1", true)) {
            stringArray = getResources().getStringArray(R.array.speed_values_max);
            Intrinsics.checkNotNull(stringArray);
        } else {
            stringArray = getResources().getStringArray(R.array.speed_values);
            Intrinsics.checkNotNull(stringArray);
        }
        if (stringArray.length != 0) {
            for (String str : stringArray) {
                if (StringsKt.equals(str, "1", true)) {
                    menu.add(Const.Normal);
                } else {
                    menu.add(str + "x");
                }
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda78
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return LiveStreamingYoutube.showSpeedOptions$lambda$48(this.f$0, menuItem);
                }
            });
            popupMenu.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showSpeedOptions$lambda$48(LiveStreamingYoutube liveStreamingYoutube, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        liveStreamingYoutube.playerSpeed = String.valueOf(item.getTitle());
        PlayerView playerView = liveStreamingYoutube.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() == null) {
            return false;
        }
        TextView textView = liveStreamingYoutube.speedTV;
        Intrinsics.checkNotNull(textView);
        textView.setText(liveStreamingYoutube.playerSpeed);
        if (StringsKt.equals(liveStreamingYoutube.playerSpeed, Const.Normal, true)) {
            PlayerView playerView2 = liveStreamingYoutube.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            Float fValueOf = Float.valueOf("1");
            Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(...)");
            player.setPlaybackParameters(new PlaybackParameters(fValueOf.floatValue(), 1.0f));
            liveStreamingYoutube.isPlaying();
            return false;
        }
        String str = liveStreamingYoutube.playerSpeed;
        Intrinsics.checkNotNull(str);
        Float fValueOf2 = Float.valueOf(StringsKt.replace$default(str, "x", "", false, 4, (Object) null));
        Intrinsics.checkNotNullExpressionValue(fValueOf2, "valueOf(...)");
        PlaybackParameters playbackParameters = new PlaybackParameters(fValueOf2.floatValue());
        PlayerView playerView3 = liveStreamingYoutube.playerView;
        Intrinsics.checkNotNull(playerView3);
        Player player2 = playerView3.getPlayer();
        Intrinsics.checkNotNull(player2);
        player2.setPlaybackParameters(playbackParameters);
        liveStreamingYoutube.isPlaying();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPlaying() {
        PlayerView playerView = this.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() != null) {
            PlayerView playerView2 = this.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            if (player.getPlaybackState() == 3) {
                PlayerView playerView3 = this.playerView;
                Intrinsics.checkNotNull(playerView3);
                Player player2 = playerView3.getPlayer();
                Intrinsics.checkNotNull(player2);
                if (player2.getPlayWhenReady()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void showAlertDialog() {
        final int[] iArr = {-1};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.select_track));
        List<MuxedStream> list = this.listVideosYoutube;
        Intrinsics.checkNotNull(list);
        String[] strArr = new String[list.size()];
        List<MuxedStream> list2 = this.listVideosYoutube;
        Intrinsics.checkNotNull(list2);
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            List<MuxedStream> list3 = this.listVideosYoutube;
            Intrinsics.checkNotNull(list3);
            strArr[i] = list3.get(i).getQualityLabel();
        }
        int i2 = this.lastseleted;
        if (i2 == -1) {
            i2 = 0;
        }
        builder.setSingleChoiceItems(strArr, i2, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda81
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LiveStreamingYoutube.showAlertDialog$lambda$49(iArr, dialogInterface, i3);
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda82
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LiveStreamingYoutube.showAlertDialog$lambda$50(this.f$0, iArr, dialogInterface, i3);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda83
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LiveStreamingYoutube.showAlertDialog$lambda$51(this.f$0, dialogInterface, i3);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlertDialog$lambda$49(int[] iArr, DialogInterface dialogInterface, int i) {
        iArr[0] = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlertDialog$lambda$50(LiveStreamingYoutube liveStreamingYoutube, int[] iArr, DialogInterface dialogInterface, int i) {
        PlayerView playerView = liveStreamingYoutube.playerView;
        Intrinsics.checkNotNull(playerView);
        Player player = playerView.getPlayer();
        Intrinsics.checkNotNull(player);
        playPosition = player.getCurrentPosition();
        liveStreamingYoutube.bitrateapply = true;
        int i2 = iArr[0];
        if (i2 == -1) {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_change_quality_first);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        } else if (i2 > liveStreamingYoutube.lastseleted) {
            liveStreamingYoutube.showHigherQualityAlert(i2);
        } else {
            liveStreamingYoutube.lastseleted = i2;
            liveStreamingYoutube.changeQuality(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void showAlertDialog$lambda$51(com.appnew.android.player.LiveStreamingYoutube r0, android.content.DialogInterface r1, int r2) {
        /*
            java.lang.String r2 = "dialog"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            androidx.media3.ui.PlayerView r2 = r0.playerView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.media3.common.Player r2 = r2.getPlayer()
            if (r2 == 0) goto L26
            androidx.media3.ui.PlayerView r2 = r0.playerView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.media3.common.Player r2 = r2.getPlayer()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r2 = r2.getPlayWhenReady()
            if (r2 == 0) goto L26
            r0.resumePlayer()
            goto L29
        L26:
            r0.pausePlayer()
        L29:
            r1.cancel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.showAlertDialog$lambda$51(com.appnew.android.player.LiveStreamingYoutube, android.content.DialogInterface, int):void");
    }

    private final void showHigherQualityAlert(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.select_higher_track));
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda63
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveStreamingYoutube.showHigherQualityAlert$lambda$52(this.f$0, position, dialogInterface, i);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda64
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveStreamingYoutube.showHigherQualityAlert$lambda$53(dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHigherQualityAlert$lambda$52(LiveStreamingYoutube liveStreamingYoutube, int i, DialogInterface dialog, int i2) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        liveStreamingYoutube.lastseleted = i;
        liveStreamingYoutube.changeQuality(i);
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHigherQualityAlert$lambda$53(DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.cancel();
    }

    private final void changeQuality(int position) {
        PlayerView playerView = this.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() != null) {
            PlayerView playerView2 = this.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            playPosition = player.getCurrentPosition();
            PlayerView playerView3 = this.playerView;
            Intrinsics.checkNotNull(playerView3);
            Player player2 = playerView3.getPlayer();
            Intrinsics.checkNotNull(player2);
            player2.stop();
        }
        TextView textView = this.speedTV;
        if (textView != null) {
            this.playerSpeed = Const.Normal;
            Intrinsics.checkNotNull(textView);
            textView.setText(getResources().getString(R.string.normal));
        }
        List<MuxedStream> list = this.listVideosYoutube;
        Intrinsics.checkNotNull(list);
        String url = list.get(position).getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
        playVideo(url);
    }

    private final void checkStoragePermission2() {
        this.PERMISSION_TYPE = 2;
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.checkStoragePermission2.1
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Intrinsics.checkNotNullParameter(report, "report");
                LiveStreamingYoutube.this.OpenChooser();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(token, "token");
                token.continuePermissionRequest();
            }
        }).check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void OpenChooser() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/pdf");
            this.someActivityResultLauncher.launch(intent);
            this.requestCode = 101;
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private final void stopWatch(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.seconds = savedInstanceState.getInt("seconds");
            this.running = savedInstanceState.getBoolean("running");
            this.wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        LinearLayout linearLayout = this.textLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.audioMainLL;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        Handler handler = new Handler();
        this.handler = handler;
        Intrinsics.checkNotNull(handler);
        handler.post(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube.stopWatch.1
            @Override // java.lang.Runnable
            public void run() {
                int i = LiveStreamingYoutube.this.seconds / 3600;
                int i2 = (LiveStreamingYoutube.this.seconds % 3600) / 60;
                int i3 = LiveStreamingYoutube.this.seconds % 60;
                LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.getDefault(), "%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                liveStreamingYoutube.time = str;
                TextView audioRecordTime = LiveStreamingYoutube.this.getAudioRecordTime();
                if (audioRecordTime != null) {
                    audioRecordTime.setText(LiveStreamingYoutube.this.time);
                }
                if (LiveStreamingYoutube.this.running) {
                    LiveStreamingYoutube.this.seconds++;
                }
                Handler handler2 = LiveStreamingYoutube.this.handler;
                Intrinsics.checkNotNull(handler2);
                handler2.postDelayed(this, 1000L);
            }
        });
        if (ActivityCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 10);
        } else {
            this.seconds = 0;
            this.running = true;
            startRecording();
        }
        ImageView imageView = this.pauseAudio;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ic_baseline_pause_24);
        }
        this.isAudioRecording = true;
        this.isAudioPlaying = false;
    }

    private final void recordingActivities() {
        ImageView imageView = this.pauseAudio;
        if (imageView != null) {
            imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LiveStreamingYoutube.recordingActivities$lambda$54(this.f$0);
                }
            }));
        }
        ImageView imageView2 = this.cancelRecording;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LiveStreamingYoutube.recordingActivities$lambda$55(this.f$0);
                }
            }));
        }
        ImageView imageView3 = this.sendRecording;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LiveStreamingYoutube.recordingActivities$lambda$57(this.f$0);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit recordingActivities$lambda$54(LiveStreamingYoutube liveStreamingYoutube) {
        try {
            if (liveStreamingYoutube.isAudioRecording) {
                liveStreamingYoutube.isAudioRecording = false;
                liveStreamingYoutube.running = false;
                liveStreamingYoutube.stopRecording();
                ImageView imageView = liveStreamingYoutube.pauseAudio;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                }
            } else if (!liveStreamingYoutube.isAudioPlaying) {
                if (liveStreamingYoutube.seconds == 0) {
                    String string = liveStreamingYoutube.getResources().getString(R.string.please_record_audio);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    liveStreamingYoutube.showMessage(string);
                } else {
                    if (liveStreamingYoutube.mediaPlayer == null) {
                        liveStreamingYoutube.mediaPlayer = MediaPlayer.create(liveStreamingYoutube, Uri.parse(liveStreamingYoutube.fileName));
                    }
                    MediaPlayer mediaPlayer = liveStreamingYoutube.mediaPlayer;
                    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                        MediaPlayer mediaPlayer2 = liveStreamingYoutube.mediaPlayer;
                        if (mediaPlayer2 != null) {
                            mediaPlayer2.start();
                        }
                        Button button = liveStreamingYoutube.play;
                        if (button != null) {
                            button.setText(liveStreamingYoutube.getResources().getString(R.string.pause));
                        }
                        liveStreamingYoutube.starttimer();
                        ImageView imageView2 = liveStreamingYoutube.pauseAudio;
                        if (imageView2 != null) {
                            imageView2.setImageResource(R.drawable.ic_baseline_pause_24);
                        }
                        liveStreamingYoutube.isAudioPlaying = true;
                    }
                }
            } else {
                MediaPlayer mediaPlayer3 = liveStreamingYoutube.mediaPlayer;
                if (mediaPlayer3 != null && mediaPlayer3 != null && mediaPlayer3.isPlaying()) {
                    MediaPlayer mediaPlayer4 = liveStreamingYoutube.mediaPlayer;
                    if (mediaPlayer4 != null) {
                        mediaPlayer4.pause();
                    }
                    liveStreamingYoutube.stoptimer();
                    Button button2 = liveStreamingYoutube.play;
                    if (button2 != null) {
                        button2.setText(liveStreamingYoutube.getResources().getString(R.string.play));
                    }
                    ImageView imageView3 = liveStreamingYoutube.pauseAudio;
                    if (imageView3 != null) {
                        imageView3.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    }
                    liveStreamingYoutube.isAudioPlaying = false;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            liveStreamingYoutube.showMessage("Error: " + e2.getMessage());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit recordingActivities$lambda$55(LiveStreamingYoutube liveStreamingYoutube) {
        liveStreamingYoutube.stopRecording();
        MediaPlayer mediaPlayer = liveStreamingYoutube.mediaPlayer;
        if (mediaPlayer != null) {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = liveStreamingYoutube.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.pause();
            }
        }
        liveStreamingYoutube.seconds = 0;
        liveStreamingYoutube.running = false;
        liveStreamingYoutube.fileName = "";
        Handler handler = liveStreamingYoutube.handler;
        Intrinsics.checkNotNull(handler);
        handler.removeCallbacksAndMessages(null);
        LinearLayout linearLayout = liveStreamingYoutube.audioMainLL;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = liveStreamingYoutube.textLayout;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit recordingActivities$lambda$57(LiveStreamingYoutube liveStreamingYoutube) {
        try {
            if (Helper.isNetworkConnected(liveStreamingYoutube)) {
                String str = liveStreamingYoutube.fileName;
                if (str == null || str.length() == 0) {
                    String string = liveStreamingYoutube.getResources().getString(R.string.please_record_audio);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    liveStreamingYoutube.showMessage(string);
                } else {
                    MediaPlayer mediaPlayer = liveStreamingYoutube.mediaPlayer;
                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    }
                    liveStreamingYoutube.seconds = 0;
                    liveStreamingYoutube.running = false;
                    liveStreamingYoutube.sendaudio();
                    Handler handler = liveStreamingYoutube.handler;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                }
                LinearLayout linearLayout = liveStreamingYoutube.audioMainLL;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                LinearLayout linearLayout2 = liveStreamingYoutube.textLayout;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            } else {
                String string2 = liveStreamingYoutube.getResources().getString(R.string.no_internet_connection);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                liveStreamingYoutube.showMessage(string2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            liveStreamingYoutube.showMessage("Error: " + e2.getMessage());
        }
        return Unit.INSTANCE;
    }

    private final void runTimer() {
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        Dialog dialog = new Dialog(this);
        this.dialog = dialog;
        Intrinsics.checkNotNull(dialog);
        dialog.setContentView(R.layout.custom_dialog_new);
        Dialog dialog2 = this.dialog;
        Intrinsics.checkNotNull(dialog2);
        dialog2.setCanceledOnTouchOutside(false);
        Dialog dialog3 = this.dialog;
        Intrinsics.checkNotNull(dialog3);
        dialog3.setCancelable(false);
        Dialog dialog4 = this.dialog;
        Intrinsics.checkNotNull(dialog4);
        dialog4.show();
        Dialog dialog5 = this.dialog;
        Intrinsics.checkNotNull(dialog5);
        final Button button = (Button) dialog5.findViewById(R.id.record);
        Dialog dialog6 = this.dialog;
        Intrinsics.checkNotNull(dialog6);
        this.recordtime = (TextView) dialog6.findViewById(R.id.timerno);
        Dialog dialog7 = this.dialog;
        Intrinsics.checkNotNull(dialog7);
        this.play = (Button) dialog7.findViewById(R.id.play);
        Dialog dialog8 = this.dialog;
        Intrinsics.checkNotNull(dialog8);
        Button button2 = (Button) dialog8.findViewById(R.id.send);
        Dialog dialog9 = this.dialog;
        Intrinsics.checkNotNull(dialog9);
        Button button3 = (Button) dialog9.findViewById(R.id.cancel);
        Handler handler = new Handler();
        this.handler = handler;
        Intrinsics.checkNotNull(handler);
        handler.post(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube.runTimer.1
            @Override // java.lang.Runnable
            public void run() {
                int i = LiveStreamingYoutube.this.seconds / 3600;
                int i2 = (LiveStreamingYoutube.this.seconds % 3600) / 60;
                int i3 = LiveStreamingYoutube.this.seconds % 60;
                LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.getDefault(), "%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                liveStreamingYoutube.time = str;
                TextView recordtime = LiveStreamingYoutube.this.getRecordtime();
                if (recordtime != null) {
                    recordtime.setText(LiveStreamingYoutube.this.time);
                }
                if (LiveStreamingYoutube.this.running) {
                    LiveStreamingYoutube.this.seconds++;
                }
                Handler handler2 = LiveStreamingYoutube.this.handler;
                Intrinsics.checkNotNull(handler2);
                handler2.postDelayed(this, 1000L);
            }
        });
        button.setText(getResources().getString(R.string.record));
        button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.runTimer$lambda$58(this.f$0);
            }
        }));
        button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.runTimer$lambda$59(button, this);
            }
        }));
        Button button4 = this.play;
        if (button4 != null) {
            button4.setText(getResources().getString(R.string.play));
        }
        Button button5 = this.play;
        if (button5 != null) {
            button5.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LiveStreamingYoutube.runTimer$lambda$60(button, this);
                }
            }));
        }
        button3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.runTimer$lambda$61(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$58(LiveStreamingYoutube liveStreamingYoutube) {
        if (Helper.isNetworkConnected(liveStreamingYoutube)) {
            String str = liveStreamingYoutube.fileName;
            if (str == "" || str == null) {
                String string = liveStreamingYoutube.getResources().getString(R.string.please_record_audio);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                liveStreamingYoutube.showMessage(string);
            } else {
                MediaPlayer mediaPlayer = liveStreamingYoutube.mediaPlayer;
                if (mediaPlayer != null) {
                    Intrinsics.checkNotNull(mediaPlayer);
                    if (mediaPlayer.isPlaying()) {
                        MediaPlayer mediaPlayer2 = liveStreamingYoutube.mediaPlayer;
                        Intrinsics.checkNotNull(mediaPlayer2);
                        mediaPlayer2.pause();
                    }
                }
                liveStreamingYoutube.seconds = 0;
                liveStreamingYoutube.running = false;
                liveStreamingYoutube.sendaudio();
                Handler handler = liveStreamingYoutube.handler;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacksAndMessages(null);
                Dialog dialog = liveStreamingYoutube.dialog;
                Intrinsics.checkNotNull(dialog);
                dialog.dismiss();
            }
        } else {
            String string2 = liveStreamingYoutube.getResources().getString(R.string.no_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            liveStreamingYoutube.showMessage(string2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$59(Button button, LiveStreamingYoutube liveStreamingYoutube) {
        if (Intrinsics.areEqual(button.getText(), "Record")) {
            Intrinsics.checkNotNull(button);
            liveStreamingYoutube.onRecordBtnClicked(button);
        } else if (Intrinsics.areEqual(button.getText(), "Stop")) {
            button.setText(liveStreamingYoutube.getResources().getString(R.string.record));
            liveStreamingYoutube.running = false;
            liveStreamingYoutube.stopRecording();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$60(Button button, LiveStreamingYoutube liveStreamingYoutube) {
        if (!Intrinsics.areEqual(button.getText(), "Stop")) {
            Button button2 = liveStreamingYoutube.play;
            if (Intrinsics.areEqual(button2 != null ? button2.getText() : null, "Play")) {
                if (liveStreamingYoutube.seconds == 0) {
                    String string = liveStreamingYoutube.getResources().getString(R.string.please_record_audio);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    liveStreamingYoutube.showMessage(string);
                } else {
                    MediaPlayer mediaPlayerCreate = MediaPlayer.create(liveStreamingYoutube, Uri.parse(liveStreamingYoutube.fileName));
                    liveStreamingYoutube.mediaPlayer = mediaPlayerCreate;
                    if (mediaPlayerCreate != null) {
                        mediaPlayerCreate.start();
                    }
                    Button button3 = liveStreamingYoutube.play;
                    if (button3 != null) {
                        button3.setText(liveStreamingYoutube.getResources().getString(R.string.pause));
                    }
                    liveStreamingYoutube.starttimer();
                }
            } else {
                Button button4 = liveStreamingYoutube.play;
                if (Intrinsics.areEqual(button4 != null ? button4.getText() : null, "Pause")) {
                    liveStreamingYoutube.stoptimer();
                    Button button5 = liveStreamingYoutube.play;
                    if (button5 != null) {
                        button5.setText(liveStreamingYoutube.getResources().getString(R.string.play));
                    }
                    MediaPlayer mediaPlayer = liveStreamingYoutube.mediaPlayer;
                    Intrinsics.checkNotNull(mediaPlayer);
                    mediaPlayer.pause();
                }
            }
        } else {
            String string2 = liveStreamingYoutube.getResources().getString(R.string.you_can_not_play_the_audio_while_record);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            liveStreamingYoutube.showMessage(string2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$61(LiveStreamingYoutube liveStreamingYoutube) {
        liveStreamingYoutube.stopRecording();
        MediaPlayer mediaPlayer = liveStreamingYoutube.mediaPlayer;
        if (mediaPlayer != null) {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = liveStreamingYoutube.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.pause();
            }
        }
        liveStreamingYoutube.seconds = 0;
        liveStreamingYoutube.running = false;
        liveStreamingYoutube.fileName = "";
        Dialog dialog = liveStreamingYoutube.dialog;
        Intrinsics.checkNotNull(dialog);
        dialog.dismiss();
        Handler handler = liveStreamingYoutube.handler;
        Intrinsics.checkNotNull(handler);
        handler.removeCallbacksAndMessages(null);
        return Unit.INSTANCE;
    }

    private final void stopRecording() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            Intrinsics.checkNotNull(mediaRecorder);
            mediaRecorder.stop();
            MediaRecorder mediaRecorder2 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.reset();
            MediaRecorder mediaRecorder3 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder3);
            mediaRecorder3.release();
            this.recorder = null;
        }
    }

    public final void onRecordBtnClicked(Button record) {
        Intrinsics.checkNotNullParameter(record, "record");
        if (ActivityCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            pausePlayer();
            this.PERMISSION_TYPE = 3;
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 10);
        } else {
            pausePlayer();
            this.seconds = 0;
            this.running = true;
            record.setText(getResources().getString(R.string.stop));
            startRecording();
        }
    }

    private final void startRecording() {
        Object systemService = getApplicationContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        audioManager.setMode(0);
        audioManager.setMicrophoneMute(false);
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            Intrinsics.checkNotNull(mediaRecorder);
            mediaRecorder.stop();
            MediaRecorder mediaRecorder2 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.reset();
            MediaRecorder mediaRecorder3 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder3);
            mediaRecorder3.release();
            this.recorder = null;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        File externalCacheDir = getExternalCacheDir();
        Intrinsics.checkNotNull(externalCacheDir);
        this.fileName = externalCacheDir.getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + string + ".mp3";
        MediaRecorder mediaRecorder4 = new MediaRecorder();
        this.recorder = mediaRecorder4;
        Intrinsics.checkNotNull(mediaRecorder4);
        mediaRecorder4.setAudioSource(1);
        MediaRecorder mediaRecorder5 = this.recorder;
        Intrinsics.checkNotNull(mediaRecorder5);
        mediaRecorder5.setOutputFormat(6);
        MediaRecorder mediaRecorder6 = this.recorder;
        Intrinsics.checkNotNull(mediaRecorder6);
        mediaRecorder6.setOutputFile(this.fileName);
        MediaRecorder mediaRecorder7 = this.recorder;
        Intrinsics.checkNotNull(mediaRecorder7);
        mediaRecorder7.setAudioEncoder(3);
        try {
            MediaRecorder mediaRecorder8 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder8);
            mediaRecorder8.prepare();
        } catch (IOException unused) {
        }
        MediaRecorder mediaRecorder9 = this.recorder;
        Intrinsics.checkNotNull(mediaRecorder9);
        mediaRecorder9.start();
    }

    public final void starttimer() {
        if (this.timer == null) {
            Timer timer = new Timer();
            this.timer = timer;
            Intrinsics.checkNotNull(timer);
            timer.schedule(new C06401(), 0L, 1000L);
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$starttimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$starttimer$1", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06401 extends TimerTask {
        C06401() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (LiveStreamingYoutube.this.getMediaPlayer() != null) {
                    MediaPlayer mediaPlayer = LiveStreamingYoutube.this.getMediaPlayer();
                    Intrinsics.checkNotNull(mediaPlayer);
                    if (mediaPlayer.isPlaying()) {
                        return;
                    }
                }
                LiveStreamingYoutube.this.stoptimer();
                final LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$starttimer$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveStreamingYoutube.C06401.run$lambda$0(liveStreamingYoutube);
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
                LiveStreamingYoutube.this.stoptimer();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(LiveStreamingYoutube liveStreamingYoutube) {
            Button play = liveStreamingYoutube.getPlay();
            if (play != null) {
                play.setText(liveStreamingYoutube.getResources().getString(R.string.play));
            }
        }
    }

    public final void stoptimer() {
        try {
            Timer timer = this.timer;
            if (timer != null) {
                if (timer != null) {
                    timer.cancel();
                }
                this.timer = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void sendaudio() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            Intrinsics.checkNotNull(mediaRecorder);
            mediaRecorder.stop();
            MediaRecorder mediaRecorder2 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.reset();
            MediaRecorder mediaRecorder3 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder3);
            mediaRecorder3.release();
            this.recorder = null;
        }
        String str = this.Chat_node;
        this.s3IU = new s3ImageUploading(str, "vc-10000386-38616500102/application/chat_system/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
        ArrayList arrayList = new ArrayList();
        MediaFile mediaFile = new MediaFile();
        mediaFile.setFile_type("audio");
        mediaFile.setFile(this.fileName);
        arrayList.add(mediaFile);
        s3ImageUploading s3imageuploading = this.s3IU;
        Intrinsics.checkNotNull(s3imageuploading);
        s3imageuploading.execute(arrayList);
        this.fileName = "";
    }

    private final void setvodchat() {
        CardView cardView = this.poll;
        Intrinsics.checkNotNull(cardView);
        cardView.setVisibility(8);
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        setChatSettingUi(true);
        LinearLayout linearLayout = this.forDoubtll;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        TextView textView = this.unpublishtxt;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(8);
        RelativeLayout relativeLayout = this.refressDoubtRl;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
        this.isclicked = "6";
        TextView textView2 = this.addBookmark;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(8);
        RelativeLayout relativeLayout2 = this.rl_pdf_data;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setVisibility(8);
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(0);
        if (this.leftMenu == null) {
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.utkashRoom = appDatabase;
            Intrinsics.checkNotNull(appDatabase);
            if (appDatabase.getthemeSettingdao().is_setting_exit()) {
                UtkashRoom utkashRoom = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom);
                this.leftMenu = (LeftMenu) new Gson().fromJson(utkashRoom.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
            }
        }
        LiveStreamingYoutube liveStreamingYoutube = this;
        this.chatAdapter = new ChatAdapter(liveStreamingYoutube, "", this.arrChat, this.leftMenu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(liveStreamingYoutube);
        this.llm = linearLayoutManager;
        Intrinsics.checkNotNull(linearLayoutManager);
        linearLayoutManager.setAutoMeasureEnabled(false);
        LinearLayoutManager linearLayoutManager2 = this.llm;
        Intrinsics.checkNotNull(linearLayoutManager2);
        linearLayoutManager2.setStackFromEnd(true);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        RecyclerView recyclerView2 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setLayoutManager(this.llm);
        RecyclerView recyclerView3 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView3);
        recyclerView3.setAdapter(this.chatAdapter);
        disableAll();
        handleVisibilityChatMessageLayout();
        LinearLayout linearLayout2 = this.chatlayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(0);
        RelativeLayout relativeLayout3 = this.goToCurrentRl;
        if (relativeLayout3 != null) {
            Intrinsics.checkNotNull(relativeLayout3);
            relativeLayout3.performClick();
        }
        LinearLayout linearLayout3 = this.llEnableMarkAsRead;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    private final void handleVisibilityChatMessageLayout() {
        if (StringsKt.equals(this.islocked, "1", true)) {
            LinearLayout linearLayout = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setVisibility(0);
            return;
        }
        if (StringsKt.equals(this.islocked, "0", true)) {
            if (StringsKt.equals(this.islockedback, "1", true)) {
                LinearLayout linearLayout2 = this.linearLayout;
                Intrinsics.checkNotNull(linearLayout2);
                linearLayout2.setVisibility(8);
                LinearLayout linearLayout3 = this.chatlayout;
                Intrinsics.checkNotNull(linearLayout3);
                linearLayout3.setVisibility(8);
                return;
            }
            LinearLayout linearLayout4 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout4);
            linearLayout4.setVisibility(0);
            LinearLayout linearLayout5 = this.chatlayout;
            Intrinsics.checkNotNull(linearLayout5);
            linearLayout5.setVisibility(0);
            return;
        }
        LinearLayout linearLayout6 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout6);
        linearLayout6.setVisibility(8);
    }

    private final void initUI(String url) {
        View viewFindViewById = findViewById(R.id.youtube_player_view);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.webkit.WebView");
        this.youtubePlayerView = (WebView) viewFindViewById;
        this.playerView = (PlayerView) findViewById(R.id.youtube_player_view_exo);
        this.videoId = url;
    }

    private final void initPlayerWebView() {
        YTubePlayerView yTubePlayerView = new YTubePlayerView(this);
        this.yTubePlayerView = yTubePlayerView;
        this.youTubeView = yTubePlayerView;
        Intrinsics.checkNotNull(yTubePlayerView);
        yTubePlayerView.setInstanseOfActivity(this);
        WebView webView = this.youtubePlayerView;
        this.webView = webView;
        WebSettings settings = webView != null ? webView.getSettings() : null;
        String userAgentString = settings != null ? settings.getUserAgentString() : null;
        if (settings != null) {
            settings.setUserAgentString(userAgentString + " MY_ANDROID_WEBVIEW");
        }
        WebView webView2 = this.webView;
        Intrinsics.checkNotNull(webView2);
        webView2.setLayerType(2, null);
        WebView webView3 = this.webView;
        Intrinsics.checkNotNull(webView3);
        webView3.setWebViewClient(new PlayerWebViewClient());
        String str = "https://admin.videocrypt.in/youtube/" + this.videoId;
        WebView webView4 = this.webView;
        Intrinsics.checkNotNull(webView4);
        webView4.loadUrl(str);
        View viewFindViewById = findViewById(R.id.youtubePlayerViewLay);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        View viewFindViewById2 = findViewById(R.id.youtubePlayerViewLay1);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(0);
        }
        View viewFindViewById3 = findViewById(R.id.youtubePlayerViewLay);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda79
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveStreamingYoutube.initPlayerWebView$lambda$62(view);
                }
            });
        }
    }

    private final void handleIsAudio() {
        if (StringsKt.equals(this.isaudio, "1", true)) {
            if (StringsKt.equals(this.islive, "1", true)) {
                try {
                    UserHistroyTable userHistroyTable = new UserHistroyTable();
                    userHistroyTable.setVideo_id(this.video_id);
                    userHistroyTable.setVideo_name(this.video_name);
                    userHistroyTable.setType("Youtube Audio");
                    userHistroyTable.setYoutube_url(this.url);
                    userHistroyTable.setTileid(this.tileid);
                    userHistroyTable.setUser_id(MakeMyExam.userId);
                    if (StringsKt.equals(this.parentid, "", true)) {
                        userHistroyTable.setCourse_id(this.course_id + MqttTopic.MULTI_LEVEL_WILDCARD);
                    } else {
                        userHistroyTable.setCourse_id(this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + this.course_id);
                    }
                    userHistroyTable.setCurrent_time(new StringBuilder().append(MakeMyExam.getTime_server()).toString());
                    UtkashRoom utkashRoom = this.utkashRoom;
                    Intrinsics.checkNotNull(utkashRoom);
                    utkashRoom.getuserhistorydao().addUser(userHistroyTable);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (StringsKt.equals(this.islive, "1", true)) {
            try {
                UserHistroyTable userHistroyTable2 = new UserHistroyTable();
                userHistroyTable2.setVideo_id(this.video_id);
                userHistroyTable2.setVideo_name(this.video_name);
                userHistroyTable2.setType("Youtube Video");
                userHistroyTable2.setTileid(this.tileid);
                userHistroyTable2.setYoutube_url(this.url);
                userHistroyTable2.setUser_id(MakeMyExam.userId);
                if (StringsKt.equals(this.parentid, "", true)) {
                    userHistroyTable2.setCourse_id(this.course_id + MqttTopic.MULTI_LEVEL_WILDCARD);
                } else {
                    userHistroyTable2.setCourse_id(this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + this.course_id);
                }
                userHistroyTable2.setCurrent_time(new StringBuilder().append(MakeMyExam.getTime_server()).toString());
                UtkashRoom utkashRoom2 = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom2);
                utkashRoom2.getuserhistorydao().addUser(userHistroyTable2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnErrorListener
    public void onError(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        Helper.dismissProgressDialog();
        try {
            InputStream inputStream = this.input;
            if (inputStream != null) {
                Intrinsics.checkNotNull(inputStream);
                inputStream.close();
            }
            HttpURLConnection httpURLConnection = this.urlConnection;
            if (httpURLConnection != null) {
                Intrinsics.checkNotNull(httpURLConnection);
                httpURLConnection.disconnect();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        ProgressBar progressBar = this.progress_bar_pdf;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setVisibility(8);
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
    public void loadComplete(int nbPages) {
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube.loadComplete.1
            @Override // java.lang.Runnable
            public void run() {
                ProgressBar progress_bar_pdf = LiveStreamingYoutube.this.getProgress_bar_pdf();
                Intrinsics.checkNotNull(progress_bar_pdf);
                progress_bar_pdf.setVisibility(8);
            }
        }, 750L);
        PDFView pDFView = this.pdfViewPager;
        Intrinsics.checkNotNull(pDFView);
        pDFView.setVisibility(0);
        try {
            InputStream inputStream = this.input;
            if (inputStream != null) {
                Intrinsics.checkNotNull(inputStream);
                inputStream.close();
            }
            HttpURLConnection httpURLConnection = this.urlConnection;
            if (httpURLConnection != null) {
                Intrinsics.checkNotNull(httpURLConnection);
                httpURLConnection.disconnect();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (this.retry) {
            new LOADURL_new(this, this).execute(this.finalPdfUrl);
            this.retry = false;
        }
    }

    @Override // com.appnew.android.Courses.Interfaces.AsyncTaskCompleteListener
    public void onTaskComplete(String inputStream, File filepath) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(filepath, "filepath");
        try {
            PDFView pDFView = this.pdfViewPager;
            Intrinsics.checkNotNull(pDFView);
            pDFView.setVisibility(0);
            ProgressBar progressBar = this.progress_bar_pdf;
            Intrinsics.checkNotNull(progressBar);
            progressBar.setVisibility(8);
            if (StringsKt.equals(inputStream, "success", true)) {
                String absolutePath = filepath.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                showPDF(absolutePath);
            } else {
                String string = getResources().getString(R.string.pdf_loading_error_please_wait);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                showMessage(string);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J(\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016¨\u0006\u0016"}, d2 = {"Lcom/appnew/android/player/LiveStreamingYoutube$PlayerWebViewClient;", "Landroid/webkit/WebViewClient;", "<init>", "(Lcom/appnew/android/player/LiveStreamingYoutube;)V", "shouldOverrideUrlLoading", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "url", "", "onPageFinished", "", "tryAutoPlay", "webView", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "", "str", "str2", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class PlayerWebViewClient extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            return true;
        }

        public PlayerWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            tryAutoPlay(LiveStreamingYoutube.this.getWebView());
            YTubePlayerView yTubePlayerView = LiveStreamingYoutube.this.getYTubePlayerView();
            Intrinsics.checkNotNull(yTubePlayerView);
            yTubePlayerView.hideSomeSectionOfBlog(LiveStreamingYoutube.this.getWebView());
            YTubePlayerView yTubePlayerView2 = LiveStreamingYoutube.this.getYTubePlayerView();
            Intrinsics.checkNotNull(yTubePlayerView2);
            yTubePlayerView2.scheduleHideContent(LiveStreamingYoutube.this.getWebView());
        }

        private final void tryAutoPlay(WebView webView) {
            if (webView != null) {
                webView.loadUrl("javascript:(function() {  var btn = document.getElementsByClassName('ytp-play-button ytp-button')[0];  if(btn && btn.getAttribute('aria-label').indexOf('Play') !== -1) {    btn.click();  } else {    setTimeout(arguments.callee, 500);  }})();");
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(str, "str");
            Intrinsics.checkNotNullParameter(str2, "str2");
            webView.getSettings();
            webView.loadData("Please try after some time.", Mimetypes.MIMETYPE_HTML, "UTF-8");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        LandscapePollDialog landscapePollDialog;
        LandscapePollDialog landscapePollDialog2;
        Video video;
        LandscapePollDialog landscapePollDialog3;
        LandscapePollDialog landscapePollDialog4;
        Object next;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT == 36 && this.root_view != null) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            View view = this.root_view;
            Intrinsics.checkNotNull(view);
            EdgeToEdgeHelperOld.applyInsetsNew(this, window, view, false, null);
        }
        LiveStreamingYoutube liveStreamingYoutube = this;
        Helper.hideSoftKeyboard(liveStreamingYoutube);
        Helper.closeKeyboard(liveStreamingYoutube);
        try {
            boolean z = true;
            if (configuration.orientation == 1) {
                this.mExoPlayerFullscreen = false;
                ArrayList<Video> arrayList = this.allVideosList;
                if (arrayList != null) {
                    Iterator<T> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (Intrinsics.areEqual(((Video) next).getId(), this.video_id)) {
                                break;
                            }
                        }
                    }
                    video = (Video) next;
                } else {
                    video = null;
                }
                String video_type = video != null ? video.getVideo_type() : null;
                if (video_type == null) {
                    video_type = "";
                }
                if (Helper.isShowMarkAsDone(video_type) && Intrinsics.areEqual(this.isclicked, "2")) {
                    LinearLayout linearLayout = this.llEnableMarkAsRead;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                } else {
                    LinearLayout linearLayout2 = this.llEnableMarkAsRead;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                }
                ImageView imageView = this.fullscreen;
                Intrinsics.checkNotNull(imageView);
                imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
                LinearLayout linearLayout3 = this.llll;
                Intrinsics.checkNotNull(linearLayout3);
                linearLayout3.setVisibility(0);
                TextView textView = this.video_name_text;
                Intrinsics.checkNotNull(textView);
                textView.setVisibility(0);
                if (StringsKt.equals(this.isclicked, "1", true)) {
                    if (this.lockarr.size() > 0) {
                        if (StringsKt.equals(this.islocked, "1", true)) {
                            if (!this.isChatPin) {
                                LinearLayout linearLayout4 = this.linearLayout;
                                Intrinsics.checkNotNull(linearLayout4);
                                linearLayout4.setVisibility(0);
                            }
                            LinearLayout linearLayout5 = this.chatlayout;
                            Intrinsics.checkNotNull(linearLayout5);
                            linearLayout5.setVisibility(0);
                        } else {
                            LinearLayout linearLayout6 = this.linearLayout;
                            Intrinsics.checkNotNull(linearLayout6);
                            linearLayout6.setVisibility(8);
                            LinearLayout linearLayout7 = this.chatlayout;
                            Intrinsics.checkNotNull(linearLayout7);
                            linearLayout7.setVisibility(8);
                        }
                    } else if (StringsKt.equals(this.islockedback, "1", true)) {
                        LinearLayout linearLayout8 = this.linearLayout;
                        Intrinsics.checkNotNull(linearLayout8);
                        linearLayout8.setVisibility(8);
                        LinearLayout linearLayout9 = this.chatlayout;
                        Intrinsics.checkNotNull(linearLayout9);
                        linearLayout9.setVisibility(8);
                    } else {
                        if (!this.isChatPin && (StringsKt.equals(this.islocked, "1", true) || StringsKt.equals(this.islocked, "0", true))) {
                            LinearLayout linearLayout10 = this.linearLayout;
                            Intrinsics.checkNotNull(linearLayout10);
                            linearLayout10.setVisibility(0);
                        }
                        LinearLayout linearLayout11 = this.chatlayout;
                        Intrinsics.checkNotNull(linearLayout11);
                        linearLayout11.setVisibility(0);
                    }
                }
                if (StringsKt.equals(this.isclicked, "2", true)) {
                    if (!this.isChatPin) {
                        LinearLayout linearLayout12 = this.linearLayout;
                        Intrinsics.checkNotNull(linearLayout12);
                        linearLayout12.setVisibility(0);
                    }
                    TextView textView2 = this.addBookmark;
                    Intrinsics.checkNotNull(textView2);
                    textView2.setVisibility(0);
                }
                getWindow().clearFlags(1024);
                float f2 = getResources().getDisplayMetrics().density;
                if ((getResources().getConfiguration().screenLayout & 15) != 4) {
                    z = false;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((((getResources().getConfiguration().screenLayout & 15) == 3 ? 350 : z ? 450 : 250) * f2) + 0.5f));
                View view2 = this.rootView;
                Intrinsics.checkNotNull(view2);
                view2.setLayoutParams(layoutParams);
                Dialog dialog = this.dialog;
                if (dialog != null) {
                    Intrinsics.checkNotNull(dialog);
                    if (dialog.isShowing()) {
                        if (this.recorder != null) {
                            stopRecording();
                        }
                        MediaPlayer mediaPlayer = this.mediaPlayer;
                        if (mediaPlayer != null) {
                            Intrinsics.checkNotNull(mediaPlayer);
                            if (mediaPlayer.isPlaying()) {
                                MediaPlayer mediaPlayer2 = this.mediaPlayer;
                                Intrinsics.checkNotNull(mediaPlayer2);
                                mediaPlayer2.pause();
                            }
                        }
                        this.seconds = 0;
                        this.running = false;
                        this.fileName = "";
                        Handler handler = this.handler;
                        Intrinsics.checkNotNull(handler);
                        handler.removeCallbacksAndMessages(null);
                        Dialog dialog2 = this.dialog;
                        Intrinsics.checkNotNull(dialog2);
                        dialog2.dismiss();
                    }
                }
                if (this.yTubePlayerView != null) {
                    getWindow().getDecorView().setSystemUiVisibility(256);
                    YTubePlayerView yTubePlayerView = this.yTubePlayerView;
                    Intrinsics.checkNotNull(yTubePlayerView);
                    yTubePlayerView.hideFullScreen();
                    LinearLayout linearLayout13 = this.llll;
                    Intrinsics.checkNotNull(linearLayout13);
                    linearLayout13.setVisibility(0);
                    if (!this.isChatPin) {
                        LinearLayout linearLayout14 = this.linearLayout;
                        Intrinsics.checkNotNull(linearLayout14);
                        linearLayout14.setVisibility(0);
                    }
                    TextView textView3 = this.video_name_text;
                    Intrinsics.checkNotNull(textView3);
                    textView3.setVisibility(0);
                }
                ArrayList<Polldata> arrayList2 = this.pollarraylist;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    Polldata polldata = this.pollarraylist.get(0);
                    if (polldata == null || (landscapePollDialog4 = this.landscapePollDialog) == null) {
                        return;
                    }
                    landscapePollDialog4.showPollIndicator(polldata, false);
                    return;
                }
                Polldata polldata2 = this.pollarraylist.get(0);
                if (polldata2 == null || (landscapePollDialog3 = this.landscapePollDialog) == null) {
                    return;
                }
                landscapePollDialog3.showPollIndicator(polldata2, false);
                return;
            }
            LinearLayout linearLayout15 = this.llEnableMarkAsRead;
            if (linearLayout15 != null) {
                linearLayout15.setVisibility(8);
            }
            LinearLayout linearLayout16 = this.llll;
            Intrinsics.checkNotNull(linearLayout16);
            linearLayout16.setVisibility(8);
            LinearLayout linearLayout17 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout17);
            linearLayout17.setVisibility(8);
            this.mExoPlayerFullscreen = true;
            ImageView imageView2 = this.fullscreen;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
            TextView textView4 = this.video_name_text;
            Intrinsics.checkNotNull(textView4);
            textView4.setVisibility(8);
            LinearLayout linearLayout18 = this.chatlayout;
            Intrinsics.checkNotNull(linearLayout18);
            linearLayout18.setVisibility(8);
            TextView textView5 = this.addBookmark;
            Intrinsics.checkNotNull(textView5);
            textView5.setVisibility(8);
            LinearLayout linearLayout19 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout19);
            linearLayout19.setVisibility(8);
            getWindow().setFlags(1024, 1024);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            View view3 = this.rootView;
            Intrinsics.checkNotNull(view3);
            view3.setLayoutParams(layoutParams2);
            Dialog dialog3 = this.dialog;
            if (dialog3 != null) {
                Intrinsics.checkNotNull(dialog3);
                if (dialog3.isShowing()) {
                    if (this.recorder != null) {
                        stopRecording();
                    }
                    MediaPlayer mediaPlayer3 = this.mediaPlayer;
                    if (mediaPlayer3 != null) {
                        Intrinsics.checkNotNull(mediaPlayer3);
                        if (mediaPlayer3.isPlaying()) {
                            MediaPlayer mediaPlayer4 = this.mediaPlayer;
                            Intrinsics.checkNotNull(mediaPlayer4);
                            mediaPlayer4.pause();
                        }
                    }
                    this.seconds = 0;
                    this.running = false;
                    this.fileName = "";
                    Handler handler2 = this.handler;
                    Intrinsics.checkNotNull(handler2);
                    handler2.removeCallbacksAndMessages(null);
                    Dialog dialog4 = this.dialog;
                    Intrinsics.checkNotNull(dialog4);
                    dialog4.dismiss();
                }
            }
            if (this.yTubePlayerView != null) {
                getWindow().getDecorView().setSystemUiVisibility(2822);
                YTubePlayerView yTubePlayerView2 = this.yTubePlayerView;
                Intrinsics.checkNotNull(yTubePlayerView2);
                yTubePlayerView2.goFullScreenVideo();
            }
            ArrayList<Polldata> arrayList3 = this.pollarraylist;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                Polldata polldata3 = this.pollarraylist.get(0);
                if (polldata3 != null && (landscapePollDialog2 = this.landscapePollDialog) != null) {
                    landscapePollDialog2.showPollIndicator(polldata3, true);
                }
            } else {
                Polldata polldata4 = this.pollarraylist.get(0);
                if (polldata4 != null && (landscapePollDialog = this.landscapePollDialog) != null) {
                    landscapePollDialog.showPollIndicator(polldata4, false);
                }
            }
            PollAdapter pollAdapter = this.pollAdapter;
            if (pollAdapter != null) {
                Intrinsics.checkNotNull(pollAdapter);
                if (pollAdapter.watchlist != null) {
                    PollAdapter pollAdapter2 = this.pollAdapter;
                    Intrinsics.checkNotNull(pollAdapter2);
                    if (pollAdapter2.watchlist.isShowing()) {
                        PollAdapter pollAdapter3 = this.pollAdapter;
                        Intrinsics.checkNotNull(pollAdapter3);
                        pollAdapter3.watchlist.dismiss();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Helper.hideSoftKeyboard(liveStreamingYoutube);
        }
    }

    private final void checkStoragePermission() {
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.checkStoragePermission.1
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Intrinsics.checkNotNullParameter(report, "report");
                LiveStreamingYoutube.this.imgClick();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(token, "token");
                token.continuePermissionRequest();
            }
        }).check();
    }

    private final void setLiveChat() {
        RelativeLayout relativeLayout;
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        setChatSettingUi(true);
        LinearLayout linearLayout = this.forDoubtll;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        TextView textView = this.unpublishtxt;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(8);
        RelativeLayout relativeLayout2 = this.refressDoubtRl;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setVisibility(8);
        this.isclicked = "1";
        TextView textView2 = this.addBookmark;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(8);
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(0);
        RelativeLayout relativeLayout3 = this.chatMainRl;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.setVisibility(0);
        NestedScrollView nestedScrollView = this.createPollNestedScrollView;
        Intrinsics.checkNotNull(nestedScrollView);
        nestedScrollView.setVisibility(8);
        RelativeLayout relativeLayout4 = this.rl_pdf_data;
        Intrinsics.checkNotNull(relativeLayout4);
        relativeLayout4.setVisibility(8);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        RecyclerView recyclerView2 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView2);
        if (recyclerView2.getAdapter() instanceof ChatAdapter) {
            ChatAdapter chatAdapter2 = this.chatAdapter;
            Intrinsics.checkNotNull(chatAdapter2);
            chatAdapter2.upDateData(this.arrChat);
        } else {
            if (this.leftMenu == null) {
                UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
                this.utkashRoom = appDatabase;
                Intrinsics.checkNotNull(appDatabase);
                if (appDatabase.getthemeSettingdao().is_setting_exit()) {
                    UtkashRoom utkashRoom = this.utkashRoom;
                    Intrinsics.checkNotNull(utkashRoom);
                    this.leftMenu = (LeftMenu) new Gson().fromJson(utkashRoom.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
                }
            }
            RecyclerView recyclerView3 = this.recyclerChat;
            Intrinsics.checkNotNull(recyclerView3);
            recyclerView3.setAdapter(new ChatAdapter(this, "", this.arrChat, this.leftMenu));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.llm = linearLayoutManager;
        Intrinsics.checkNotNull(linearLayoutManager);
        linearLayoutManager.setAutoMeasureEnabled(false);
        LinearLayoutManager linearLayoutManager2 = this.llm;
        Intrinsics.checkNotNull(linearLayoutManager2);
        linearLayoutManager2.setStackFromEnd(true);
        RecyclerView recyclerView4 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView4);
        recyclerView4.setLayoutManager(this.llm);
        disableAll();
        handleVisibilityChatMessageLayout();
        LinearLayout linearLayout2 = this.chatlayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(0);
        if (!this.isFirstTimeCome && (relativeLayout = this.goToCurrentRl) != null) {
            this.isFirstTimeCome = false;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.performClick();
        }
        LinearLayout linearLayout3 = this.llEnableMarkAsRead;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: isFirstTimeCome, reason: from getter */
    public final boolean getIsFirstTimeCome() {
        return this.isFirstTimeCome;
    }

    public final void setFirstTimeCome(boolean z) {
        this.isFirstTimeCome = z;
    }

    private final void setNotes() {
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        RelativeLayout relativeLayout = this.goToCurrentRl;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
        RelativeLayout relativeLayout2 = this.refressDoubtRl;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setVisibility(8);
        setChatSettingUi(false);
        LinearLayout linearLayout = this.forDoubtll;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        TextView textView = this.unpublishtxt;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(8);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        this.isclicked = "4";
        LinearLayout linearLayout2 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(8);
        TextView textView2 = this.addBookmark;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(8);
        disableAll();
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(0);
        RelativeLayout relativeLayout3 = this.rl_pdf_data;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.setVisibility(8);
        RecyclerView recyclerView2 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        setNotesAdapter();
        LinearLayout linearLayout3 = this.llEnableMarkAsRead;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    private final void setPoll() {
        this.isUserOnPoll = true;
        this.isUserOnDoubt = false;
        setChatSettingUi(false);
        LinearLayout linearLayout = this.forDoubtll;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        TextView textView = this.unpublishtxt;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(8);
        RelativeLayout relativeLayout = this.goToCurrentRl;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
        RelativeLayout relativeLayout2 = this.refressDoubtRl;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setVisibility(8);
        this.isclicked = "5";
        LinearLayout linearLayout2 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(8);
        TextView textView2 = this.addBookmark;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(8);
        RelativeLayout relativeLayout3 = this.rl_pdf_data;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.setVisibility(8);
        disableAll();
        if (this.isOperator) {
            RelativeLayout relativeLayout4 = this.addPoll;
            Intrinsics.checkNotNull(relativeLayout4);
            relativeLayout4.setVisibility(8);
            RelativeLayout relativeLayout5 = this.createPoll;
            Intrinsics.checkNotNull(relativeLayout5);
            relativeLayout5.setVisibility(0);
            TextView textView3 = this.generateLeaderboard;
            Intrinsics.checkNotNull(textView3);
            textView3.setVisibility((this.isFirebaseChat || !Helper.isGenerateLeaderboardEnabled()) ? 8 : 0);
        } else {
            RelativeLayout relativeLayout6 = this.addPoll;
            Intrinsics.checkNotNull(relativeLayout6);
            relativeLayout6.setVisibility(8);
            RelativeLayout relativeLayout7 = this.createPoll;
            Intrinsics.checkNotNull(relativeLayout7);
            relativeLayout7.setVisibility(8);
            TextView textView4 = this.generateLeaderboard;
            Intrinsics.checkNotNull(textView4);
            textView4.setVisibility(8);
        }
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(8);
        RelativeLayout relativeLayout8 = this.chatMainRl;
        Intrinsics.checkNotNull(relativeLayout8);
        relativeLayout8.setVisibility(8);
        NestedScrollView nestedScrollView = this.createPollNestedScrollView;
        Intrinsics.checkNotNull(nestedScrollView);
        nestedScrollView.setVisibility(0);
        RecyclerView recyclerView2 = this.recylerViewPollOperator;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setVisibility(0);
        TextView textView5 = this.viewLeaderboard;
        Intrinsics.checkNotNull(textView5);
        textView5.setVisibility((this.isFirebaseChat || this.pollarraylist.isEmpty() || !this.isShowViewAllLeaderBoard) ? 8 : 0);
        setpollAdapter();
        LinearLayout linearLayout3 = this.llEnableMarkAsRead;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    private final void setpollAdapter() {
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        if (recyclerView.getAdapter() != null) {
            RecyclerView recyclerView2 = this.recyclerChat;
            Intrinsics.checkNotNull(recyclerView2);
            if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                ChatAdapter chatAdapter2 = this.chatAdapter;
                Intrinsics.checkNotNull(chatAdapter2);
                chatAdapter2.stopMusic();
            }
        }
        this.pollAdapter = new PollAdapter(this, this.pollarraylist);
        RecyclerView recyclerView3 = this.recylerViewPollOperator;
        Intrinsics.checkNotNull(recyclerView3);
        recyclerView3.setAdapter(this.pollAdapter);
    }

    public final void pausePlayer() {
        PlayerView playerView = this.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() != null) {
            PlayerView playerView2 = this.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            player.setPlayWhenReady(false);
            PlayerView playerView3 = this.playerView;
            Intrinsics.checkNotNull(playerView3);
            Player player2 = playerView3.getPlayer();
            Intrinsics.checkNotNull(player2);
            player2.getPlaybackState();
        }
    }

    public final void pausePlayerFromAdapter() {
        String str = this.islive;
        if (str != null && !TextUtils.isEmpty(str) && StringsKt.equals(this.islive, "4", true)) {
            callPauseWebview();
        } else if (StringsKt.equals(SharedPreference.getInstance().getString(Const.IS_EXOPLAYER), "1", true)) {
            pausePlayer();
        } else {
            callPauseWebview();
        }
    }

    public final void resumePlayer() {
        PlayerView playerView = this.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() != null) {
            PlayerView playerView2 = this.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            player.setPlayWhenReady(true);
            PlayerView playerView3 = this.playerView;
            Intrinsics.checkNotNull(playerView3);
            Player player2 = playerView3.getPlayer();
            Intrinsics.checkNotNull(player2);
            player2.getPlaybackState();
        }
    }

    private final void setUserOnline() {
        this.mFirebaseDatabaseReference1 = null;
        try {
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/");
            String str = this.Chat_node;
            Intrinsics.checkNotNull(str);
            DatabaseReference databaseReferenceChild2 = databaseReferenceChild.child(str).child("User").child(MakeMyExam.userId);
            this.mFirebaseDatabaseReference1 = databaseReferenceChild2;
            Intrinsics.checkNotNull(databaseReferenceChild2);
            databaseReferenceChild2.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.setUserOnline.1
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                    Intrinsics.checkNotNullParameter(databaseError, "databaseError");
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                    if (dataSnapshot.getValue() != null) {
                        DatabaseReference databaseReference = LiveStreamingYoutube.this.mFirebaseDatabaseReference1;
                        Intrinsics.checkNotNull(databaseReference);
                        databaseReference.child("online").setValue("true");
                        LiveStreamingYoutube.this.setChatUser((ChatUser) dataSnapshot.getValue(ChatUser.class));
                    } else {
                        OnlineUser onlineUser = new OnlineUser(SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "true", MakeMyExam.userId, SharedPreference.getInstance().getLoggedInUser().getMobile(), "0", System.currentTimeMillis());
                        DatabaseReference databaseReference2 = LiveStreamingYoutube.this.mFirebaseDatabaseReference1;
                        Intrinsics.checkNotNull(databaseReference2);
                        Intrinsics.checkNotNull(databaseReference2.setValue(onlineUser));
                    }
                    Helper.removeConnection(LiveStreamingYoutube.this.mFirebaseDatabaseReference1);
                }
            });
        } catch (Exception unused) {
        }
    }

    private final void setUserOffline() {
        if (this.mFirebaseDatabaseReference1 == null || ServerValue.TIMESTAMP == null) {
            return;
        }
        try {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReference1;
            Intrinsics.checkNotNull(databaseReference);
            Intrinsics.checkNotNull(databaseReference.child("online").setValue(ServerValue.TIMESTAMP));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String getCheckstatus() {
        return this.checkstatus;
    }

    public final void setCheckstatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.checkstatus = str;
    }

    public final String getIslocked() {
        return this.islocked;
    }

    public final void setIslocked(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.islocked = str;
    }

    public final void setIvSend() {
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda60
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.setIvSend$lambda$68(this.f$0);
            }
        }, 30001L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setIvSend$lambda$68(LiveStreamingYoutube liveStreamingYoutube) {
        ImageView imageView = liveStreamingYoutube.ivSend;
        Intrinsics.checkNotNull(imageView);
        imageView.setClickable(true);
    }

    private final void fireBaseOperation() {
        this.mFirebaseDatabaseReferenceone2many = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TOM/");
        this.mFirebaseDatabaseReferenceChatLocked = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/User/" + MakeMyExam.userId);
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
        this.mFirebaseDatabaseReferenceone2one = databaseReferenceChild;
        Intrinsics.checkNotNull(databaseReferenceChild);
        databaseReferenceChild.push().getKey();
        this.mFirebaseDatabaseReferencePollAdded = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll");
        this.chatLockedValueEventListener = new ValueEventListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.fireBaseOperation.1
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                try {
                    if (dataSnapshot.getValue() != null) {
                        OnlineUser onlineUser = (OnlineUser) dataSnapshot.getValue(OnlineUser.class);
                        if (!TextUtils.isEmpty(onlineUser != null ? onlineUser.getIs_chat_locked() : null)) {
                            if (StringsKt.equals(onlineUser != null ? onlineUser.getIs_chat_locked() : null, "1", true)) {
                                LiveStreamingYoutube.this.setIslocked("2");
                                LiveStreamingYoutube.this.hidechat();
                                return;
                            }
                        }
                        LiveStreamingYoutube.this.setIslocked("1");
                        LiveStreamingYoutube.this.showchat();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceChatLocked;
        Intrinsics.checkNotNull(databaseReference);
        ValueEventListener valueEventListener = this.chatLockedValueEventListener;
        Intrinsics.checkNotNull(valueEventListener);
        databaseReference.addValueEventListener(valueEventListener);
        this.pollAddedEventListener = new C06002();
        DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferencePollAdded;
        Intrinsics.checkNotNull(databaseReference2);
        ValueEventListener valueEventListener2 = this.pollAddedEventListener;
        Intrinsics.checkNotNull(valueEventListener2);
        databaseReference2.addValueEventListener(valueEventListener2);
        if (this.isPublicChatEnabled) {
            this.onetomanyvalueEventListener = new C06013();
            DatabaseReference databaseReference3 = this.mFirebaseDatabaseReferenceone2many;
            Intrinsics.checkNotNull(databaseReference3);
            ValueEventListener valueEventListener3 = this.onetomanyvalueEventListener;
            Intrinsics.checkNotNull(valueEventListener3);
            databaseReference3.addListenerForSingleValueEvent(valueEventListener3);
            DatabaseReference databaseReference4 = this.mFirebaseDatabaseReferenceone2many;
            Intrinsics.checkNotNull(databaseReference4);
            databaseReference4.limitToLast(100);
        } else {
            this.valueEventListener = new AnonymousClass4();
            DatabaseReference databaseReference5 = this.mFirebaseDatabaseReferenceone2one;
            Intrinsics.checkNotNull(databaseReference5);
            ValueEventListener valueEventListener4 = this.valueEventListener;
            Intrinsics.checkNotNull(valueEventListener4);
            databaseReference5.addListenerForSingleValueEvent(valueEventListener4);
            DatabaseReference databaseReference6 = this.mFirebaseDatabaseReferenceone2one;
            Intrinsics.checkNotNull(databaseReference6);
            databaseReference6.limitToLast(100);
        }
        setSendListener();
        this.arrChat.clear();
        if (this.leftMenu == null) {
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.utkashRoom = appDatabase;
            Intrinsics.checkNotNull(appDatabase);
            if (appDatabase.getthemeSettingdao().is_setting_exit()) {
                UtkashRoom utkashRoom = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom);
                this.leftMenu = (LeftMenu) new Gson().fromJson(utkashRoom.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
            }
        }
        LiveStreamingYoutube liveStreamingYoutube = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(liveStreamingYoutube);
        this.llm = linearLayoutManager;
        Intrinsics.checkNotNull(linearLayoutManager);
        linearLayoutManager.setAutoMeasureEnabled(false);
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(this.llm);
        this.chatAdapter = new ChatAdapter(liveStreamingYoutube, "", this.arrChat, this.leftMenu);
        RecyclerView recyclerView2 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setAdapter(this.chatAdapter);
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$fireBaseOperation$2", "Lcom/google/firebase/database/ValueEventListener;", "onDataChange", "", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", "onCancelled", "p0", "Lcom/google/firebase/database/DatabaseError;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06002 implements ValueEventListener {
        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        C06002() {
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(DataSnapshot dataSnapshot) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
            Object value = dataSnapshot.getValue();
            if (value == null) {
                value = com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID;
            }
            Log.e("TAG_APP", "onDataChange: pollAdded " + value + " \n children " + dataSnapshot.getChildren());
            if (dataSnapshot.getValue() != null) {
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    Intrinsics.checkNotNullExpressionValue(dataSnapshot2, "next(...)");
                    chatPojo chatpojo = (chatPojo) dataSnapshot2.getValue(chatPojo.class);
                    Intrinsics.checkNotNull(chatpojo);
                    if (StringsKt.equals(chatpojo.getType(), Polling.EVENT_POLL, true)) {
                        Log.e("TAG_APP", "onDataChange: is_active " + chatpojo.getIs_active());
                        if (StringsKt.equals(chatpojo.getIs_active(), "2", true)) {
                            Log.e("TAG_APP", "onDataChange: pollarraylist.indices " + CollectionsKt.getIndices(LiveStreamingYoutube.this.getPollarraylist()));
                            int size = LiveStreamingYoutube.this.getPollarraylist().size();
                            for (int i = 0; i < size; i++) {
                                Polldata polldata = LiveStreamingYoutube.this.getPollarraylist().get(i);
                                Intrinsics.checkNotNull(polldata);
                                if (StringsKt.equals(polldata.getRendomkey(), chatpojo.getFirebase_id(), true)) {
                                    Polldata polldata2 = LiveStreamingYoutube.this.getPollarraylist().get(i);
                                    Intrinsics.checkNotNull(polldata2);
                                    polldata2.setStatus("2");
                                    final LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                                    liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$2$$ExternalSyntheticLambda0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            LiveStreamingYoutube.C06002.onDataChange$lambda$0(liveStreamingYoutube);
                                        }
                                    });
                                }
                            }
                        } else {
                            Log.e("TAG_APP", "onChildAdded: 2564");
                            LiveStreamingYoutube.this.getpolldatawithid(chatpojo.getFirebase_id());
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$0(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.recylerViewPollOperator != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recylerViewPollOperator;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recylerViewPollOperator;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof PollAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recylerViewPollOperator;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$fireBaseOperation$3", "Lcom/google/firebase/database/ValueEventListener;", "onDataChange", "", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", "onCancelled", "databaseError", "Lcom/google/firebase/database/DatabaseError;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06013 implements ValueEventListener {
        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
            Intrinsics.checkNotNullParameter(databaseError, "databaseError");
        }

        C06013() {
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(final DataSnapshot dataSnapshot) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
            if (dataSnapshot.getValue() == null) {
                LiveStreamingYoutube.this.setCheckstatus("1");
                LiveStreamingYoutube.this.onetomanygetupdatedchatdata(MakeMyExam.getTime_server());
                return;
            }
            dataSnapshot.getValue();
            try {
                final LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveStreamingYoutube.C06013.onDataChange$lambda$2(dataSnapshot, liveStreamingYoutube);
                    }
                });
            } catch (Exception unused) {
                LiveStreamingYoutube.this.showMessage("null pointer exception");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$2(DataSnapshot dataSnapshot, final LiveStreamingYoutube liveStreamingYoutube) {
            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                Intrinsics.checkNotNullExpressionValue(dataSnapshot2, "next(...)");
                DataSnapshot dataSnapshot3 = dataSnapshot2;
                chatPojo chatpojo = (chatPojo) dataSnapshot3.getValue(chatPojo.class);
                Intrinsics.checkNotNull(chatpojo);
                if (!StringsKt.equals(chatpojo.getType(), Polling.EVENT_POLL, true) && !StringsKt.equals(chatpojo.getType(), "is_chat_locked", true)) {
                    Log.e("TAG_APP", "onDataChange: DATA UPDTED " + chatpojo);
                    liveStreamingYoutube.addOrUpdateItem(chatpojo);
                    liveStreamingYoutube.getPollarr().add(chatpojo);
                    liveStreamingYoutube.keyset.add(dataSnapshot3.getKey());
                } else {
                    if (StringsKt.equals(chatpojo.getType(), "is_chat_locked", true)) {
                        liveStreamingYoutube.getLockarr().add(chatpojo);
                    }
                    liveStreamingYoutube.getPollarr().add(chatpojo);
                    Log.e("TAG_APP", "onDataChange: DATA UPDTED pollarr " + chatpojo);
                }
                liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveStreamingYoutube.C06013.onDataChange$lambda$2$lambda$0(liveStreamingYoutube);
                    }
                });
            }
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$3$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06013.onDataChange$lambda$2$lambda$1(liveStreamingYoutube);
                }
            });
            liveStreamingYoutube.setCheckstatus("1");
            chatPojo chatpojo2 = liveStreamingYoutube.getPollarr().get(liveStreamingYoutube.getPollarr().size() - 1);
            Intrinsics.checkNotNull(chatpojo2);
            liveStreamingYoutube.onetomanygetupdatedchatdata(chatpojo2.getDate());
            if (liveStreamingYoutube.getLockarr().size() > 0) {
                chatPojo chatpojo3 = liveStreamingYoutube.getLockarr().get(liveStreamingYoutube.getLockarr().size() - 1);
                Intrinsics.checkNotNull(chatpojo3);
                chatpojo3.getMessage();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$2$lambda$0(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.getIsUserScrolled() || liveStreamingYoutube.recyclerChat == null) {
                return;
            }
            RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView2);
                if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                    RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView3);
                    RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$2$lambda$1(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.getIsUserScrolled()) {
                return;
            }
            RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.smoothScrollToPosition(liveStreamingYoutube.getArrChat().size());
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$4, reason: invalid class name */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$fireBaseOperation$4", "Lcom/google/firebase/database/ValueEventListener;", "onDataChange", "", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", "onCancelled", "databaseError", "Lcom/google/firebase/database/DatabaseError;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass4 implements ValueEventListener {
        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
            Intrinsics.checkNotNullParameter(databaseError, "databaseError");
        }

        AnonymousClass4() {
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(final DataSnapshot dataSnapshot) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
            if (dataSnapshot.getValue() == null) {
                LiveStreamingYoutube.this.setCheckstatus("1");
                LiveStreamingYoutube.this.getupdatedchatdata(System.currentTimeMillis());
                return;
            }
            try {
                final LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$4$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveStreamingYoutube.AnonymousClass4.onDataChange$lambda$2(dataSnapshot, liveStreamingYoutube);
                    }
                });
            } catch (Exception unused) {
                LiveStreamingYoutube liveStreamingYoutube2 = LiveStreamingYoutube.this;
                String string = liveStreamingYoutube2.getResources().getString(R.string.null_pointer_exception);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                liveStreamingYoutube2.showMessage(string);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$2(DataSnapshot dataSnapshot, final LiveStreamingYoutube liveStreamingYoutube) {
            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                Intrinsics.checkNotNullExpressionValue(dataSnapshot2, "next(...)");
                DataSnapshot dataSnapshot3 = dataSnapshot2;
                chatPojo chatpojo = (chatPojo) dataSnapshot3.getValue(chatPojo.class);
                Intrinsics.checkNotNull(chatpojo);
                if (!StringsKt.equals(chatpojo.getType(), Polling.EVENT_POLL, true) && !StringsKt.equals(chatpojo.getType(), "is_chat_locked", true)) {
                    liveStreamingYoutube.addOrUpdateItem(chatpojo);
                    liveStreamingYoutube.getPollarr().add(chatpojo);
                    liveStreamingYoutube.keyset.add(dataSnapshot3.getKey());
                } else {
                    if (StringsKt.equals(chatpojo.getType(), "is_chat_locked", true)) {
                        liveStreamingYoutube.getLockarr().add(chatpojo);
                    }
                    liveStreamingYoutube.getPollarr().add(chatpojo);
                }
                liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$4$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveStreamingYoutube.AnonymousClass4.onDataChange$lambda$2$lambda$0(liveStreamingYoutube);
                    }
                });
            }
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$fireBaseOperation$4$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.AnonymousClass4.onDataChange$lambda$2$lambda$1(liveStreamingYoutube);
                }
            });
            liveStreamingYoutube.setCheckstatus("1");
            chatPojo chatpojo2 = liveStreamingYoutube.getPollarr().get(liveStreamingYoutube.getPollarr().size() - 1);
            Intrinsics.checkNotNull(chatpojo2);
            liveStreamingYoutube.getupdatedchatdata(chatpojo2.getDate());
            if (liveStreamingYoutube.getLockarr().size() > 0) {
                chatPojo chatpojo3 = liveStreamingYoutube.getLockarr().get(liveStreamingYoutube.getLockarr().size() - 1);
                Intrinsics.checkNotNull(chatpojo3);
                chatpojo3.getMessage();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$2$lambda$0(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.getIsUserScrolled() || liveStreamingYoutube.recyclerChat == null) {
                return;
            }
            RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView2);
                if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                    RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView3);
                    RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$2$lambda$1(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.getIsUserScrolled()) {
                return;
            }
            RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.smoothScrollToPosition(liveStreamingYoutube.getArrChat().size());
        }
    }

    private final void setSendListener() {
        getLoveImage().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda61
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.openEmojiPopup();
            }
        });
        ImageView imageView = this.ivSend;
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveStreamingYoutube.setSendListener$lambda$72(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSendListener$lambda$72(LiveStreamingYoutube liveStreamingYoutube, View view) {
        try {
            if (Helper.isConnected(liveStreamingYoutube)) {
                EditText editText = liveStreamingYoutube.etMessage;
                Intrinsics.checkNotNull(editText);
                String string = editText.getText().toString();
                int length = string.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                if (!Intrinsics.areEqual(string.subSequence(i, length + 1).toString(), "")) {
                    if (!liveStreamingYoutube.isintractavailable) {
                        liveStreamingYoutube.checkintract();
                    }
                    EditText editText2 = liveStreamingYoutube.etMessage;
                    Intrinsics.checkNotNull(editText2);
                    String string2 = editText2.getText().toString();
                    int length2 = string2.length() - 1;
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 <= length2) {
                        boolean z4 = Intrinsics.compare((int) string2.charAt(!z3 ? i2 : length2), 32) <= 0;
                        if (z3) {
                            if (!z4) {
                                break;
                            } else {
                                length2--;
                            }
                        } else if (z4) {
                            i2++;
                        } else {
                            z3 = true;
                        }
                    }
                    if (Helper.IsValidUrl(string2.subSequence(i2, length2 + 1).toString())) {
                        if (liveStreamingYoutube.isFirebaseChat) {
                            String str = MakeMyExam.userId;
                            EditText editText3 = liveStreamingYoutube.etMessage;
                            Intrinsics.checkNotNull(editText3);
                            chatPojo chatpojo = new chatPojo(str, editText3.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "url", liveStreamingYoutube.course_id);
                            DatabaseReference databaseReference = liveStreamingYoutube.mFirebaseDatabaseReferenceone2one;
                            Intrinsics.checkNotNull(databaseReference);
                            databaseReference.push().setValue(chatpojo);
                            DatabaseReference databaseReference2 = liveStreamingYoutube.mFirebaseDatabaseReferenceone2many;
                            Intrinsics.checkNotNull(databaseReference2);
                            databaseReference2.push().setValue(chatpojo);
                            Log.e("TAG_APP", "setSendListener: 2767");
                        } else {
                            String str2 = MakeMyExam.userId;
                            EditText editText4 = liveStreamingYoutube.etMessage;
                            Intrinsics.checkNotNull(editText4);
                            String json = new Gson().toJson(new chatPojo(str2, editText4.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", "url", liveStreamingYoutube.course_id));
                            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                            liveStreamingYoutube.sendMessage(json, false);
                        }
                    } else if (liveStreamingYoutube.isFirebaseChat) {
                        String str3 = MakeMyExam.userId;
                        EditText editText5 = liveStreamingYoutube.etMessage;
                        Intrinsics.checkNotNull(editText5);
                        chatPojo chatpojo2 = new chatPojo(str3, editText5.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "text", liveStreamingYoutube.course_id);
                        DatabaseReference databaseReference3 = liveStreamingYoutube.mFirebaseDatabaseReferenceone2one;
                        Intrinsics.checkNotNull(databaseReference3);
                        databaseReference3.push().setValue(chatpojo2);
                        DatabaseReference databaseReference4 = liveStreamingYoutube.mFirebaseDatabaseReferenceone2many;
                        Intrinsics.checkNotNull(databaseReference4);
                        databaseReference4.push().setValue(chatpojo2);
                        EditText editText6 = liveStreamingYoutube.etMessage;
                        Intrinsics.checkNotNull(editText6);
                        editText6.getText().clear();
                        Log.e("TAG_APP", "setSendListener: 2777");
                    } else {
                        String str4 = MakeMyExam.userId;
                        EditText editText7 = liveStreamingYoutube.etMessage;
                        Intrinsics.checkNotNull(editText7);
                        String json2 = new Gson().toJson(new chatPojo(str4, editText7.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", "text", liveStreamingYoutube.course_id));
                        Intrinsics.checkNotNullExpressionValue(json2, "toJson(...)");
                        liveStreamingYoutube.sendMessage(json2, false);
                    }
                    Helper.closeHideKeyboard(liveStreamingYoutube);
                    liveStreamingYoutube.enableDisableMsgET();
                    return;
                }
                Helper.showSnackBar(liveStreamingYoutube.ivSend, "Please enter your query first.");
                return;
            }
            Helper.showSnackBar(liveStreamingYoutube.ivSend, "Please connect internet first.");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final DatabaseReference getOnetomanyrootRef() {
        return this.onetomanyrootRef;
    }

    public final void setOnetomanyrootRef(DatabaseReference databaseReference) {
        this.onetomanyrootRef = databaseReference;
    }

    public final ChildEventListener getOnetomanychildEventListener() {
        return this.onetomanychildEventListener;
    }

    public final void setOnetomanychildEventListener(ChildEventListener childEventListener) {
        this.onetomanychildEventListener = childEventListener;
    }

    public final Query getOnetomantquery() {
        return this.onetomantquery;
    }

    public final void setOnetomantquery(Query query) {
        this.onetomantquery = query;
    }

    public final void onetomanygetupdatedchatdata(long actualdate) {
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TOM/");
        this.onetomanyrootRef = databaseReferenceChild;
        Intrinsics.checkNotNull(databaseReferenceChild);
        this.onetomantquery = databaseReferenceChild.orderByChild("date").startAt(actualdate);
        this.onetomanychildEventListener = new C06331();
        Query query = this.onetomantquery;
        Intrinsics.checkNotNull(query);
        ChildEventListener childEventListener = this.onetomanychildEventListener;
        Intrinsics.checkNotNull(childEventListener);
        query.addChildEventListener(childEventListener);
        Query query2 = this.onetomantquery;
        Intrinsics.checkNotNull(query2);
        query2.limitToLast(100);
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$onetomanygetupdatedchatdata$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$onetomanygetupdatedchatdata$1", "Lcom/google/firebase/database/ChildEventListener;", "onChildAdded", "", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", CmcdData.Factory.STREAMING_FORMAT_SS, "", "onChildChanged", "onChildRemoved", "onChildMoved", "onCancelled", "databaseError", "Lcom/google/firebase/database/DatabaseError;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06331 implements ChildEventListener {
        @Override // com.google.firebase.database.ChildEventListener
        public void onCancelled(DatabaseError databaseError) {
            Intrinsics.checkNotNullParameter(databaseError, "databaseError");
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildRemoved(DataSnapshot dataSnapshot) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
        }

        C06331() {
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildAdded(final DataSnapshot dataSnapshot, String s) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
            if (!StringsKt.equals(LiveStreamingYoutube.this.getCheckstatus(), "1", true)) {
                try {
                    final LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                    AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$onetomanygetupdatedchatdata$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveStreamingYoutube.C06331.onChildAdded$lambda$2(dataSnapshot, liveStreamingYoutube);
                        }
                    });
                    return;
                } catch (Exception unused) {
                    LiveStreamingYoutube.this.showMessage("null pointer exception");
                    return;
                }
            }
            final LiveStreamingYoutube liveStreamingYoutube2 = LiveStreamingYoutube.this;
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$onetomanygetupdatedchatdata$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06331.onChildAdded$lambda$5(liveStreamingYoutube2, dataSnapshot);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$2(DataSnapshot dataSnapshot, final LiveStreamingYoutube liveStreamingYoutube) {
            chatPojo chatpojo = (chatPojo) dataSnapshot.getValue(chatPojo.class);
            Intrinsics.checkNotNull(chatpojo);
            chatpojo.setDate(System.currentTimeMillis());
            if (StringsKt.equals(chatpojo.getType(), Polling.EVENT_POLL, true)) {
                if (!StringsKt.equals(BuildConfig.FLAVOR, "NextToppers", true)) {
                    if (StringsKt.equals(chatpojo.getIs_active(), "2", true)) {
                        int size = liveStreamingYoutube.getPollarraylist().size();
                        for (int i = 0; i < size; i++) {
                            Polldata polldata = liveStreamingYoutube.getPollarraylist().get(i);
                            Intrinsics.checkNotNull(polldata);
                            if (StringsKt.equals(polldata.getRendomkey(), chatpojo.getFirebase_id(), true)) {
                                Polldata polldata2 = liveStreamingYoutube.getPollarraylist().get(i);
                                Intrinsics.checkNotNull(polldata2);
                                polldata2.setStatus("2");
                                liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$onetomanygetupdatedchatdata$1$$ExternalSyntheticLambda4
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        LiveStreamingYoutube.C06331.onChildAdded$lambda$2$lambda$0(liveStreamingYoutube);
                                    }
                                });
                            }
                        }
                    } else {
                        Log.e("TAG_APP", "onChildAdded: 2853");
                        liveStreamingYoutube.getpolldatawithid(chatpojo.getFirebase_id());
                    }
                }
            } else if (!StringsKt.equals(chatpojo.getType(), Polling.EVENT_POLL, true) && !StringsKt.equals(chatpojo.getType(), "is_chat_locked", true)) {
                liveStreamingYoutube.addOrUpdateItem(chatpojo);
                liveStreamingYoutube.keyset.add(dataSnapshot.getKey());
            }
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$onetomanygetupdatedchatdata$1$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06331.onChildAdded$lambda$2$lambda$1(liveStreamingYoutube);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$2$lambda$0(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.getPollAdapter() == null || liveStreamingYoutube.recylerViewPollOperator == null) {
                return;
            }
            RecyclerView recyclerView = liveStreamingYoutube.recylerViewPollOperator;
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = liveStreamingYoutube.recylerViewPollOperator;
                Intrinsics.checkNotNull(recyclerView2);
                RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$2$lambda$1(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.getIsUserScrolled()) {
                return;
            }
            if (liveStreamingYoutube.recyclerChat != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
            RecyclerView recyclerView4 = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView4);
            recyclerView4.smoothScrollToPosition(liveStreamingYoutube.getArrChat().size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$5(final LiveStreamingYoutube liveStreamingYoutube, DataSnapshot dataSnapshot) {
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$onetomanygetupdatedchatdata$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06331.onChildAdded$lambda$5$lambda$3(liveStreamingYoutube);
                }
            });
            try {
                chatPojo chatpojo = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                Intrinsics.checkNotNull(chatpojo);
                if (StringsKt.equals(chatpojo.getType(), Polling.EVENT_POLL, true)) {
                    if (liveStreamingYoutube.getPollarraylist().size() == 0) {
                        Log.e("TAG_APP", "onChildAdded: 2915");
                        liveStreamingYoutube.getpolldatawithid(chatpojo.getFirebase_id());
                    }
                } else if (StringsKt.equals(chatpojo.getType(), "is_chat_locked", true)) {
                    liveStreamingYoutube.getLockarr().size();
                } else if (liveStreamingYoutube.getArrChat().size() == 0) {
                    liveStreamingYoutube.addOrUpdateItem(chatpojo);
                    liveStreamingYoutube.keyset.add(dataSnapshot.getKey());
                    liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$onetomanygetupdatedchatdata$1$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveStreamingYoutube.C06331.onChildAdded$lambda$5$lambda$4(liveStreamingYoutube);
                        }
                    });
                }
            } catch (Exception unused) {
            }
            liveStreamingYoutube.setCheckstatus("0");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$5$lambda$3(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.recyclerChat != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
            RecyclerView recyclerView4 = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView4);
            recyclerView4.smoothScrollToPosition(liveStreamingYoutube.getArrChat().size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$5$lambda$4(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.getIsUserScrolled()) {
                return;
            }
            if (liveStreamingYoutube.recyclerChat != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
            RecyclerView recyclerView4 = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView4);
            recyclerView4.smoothScrollToPosition(liveStreamingYoutube.getArrChat().size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addOrUpdateItem(final chatPojo newItem) {
        try {
            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda86
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.addOrUpdateItem$lambda$73(this.f$0, newItem);
                }
            });
        } catch (Exception e2) {
            Log.d("MQTT", "addOrUpdateItem: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addOrUpdateItem$lambda$73(LiveStreamingYoutube liveStreamingYoutube, chatPojo chatpojo) {
        boolean z = liveStreamingYoutube.isFirebaseChat;
        ArrayList<chatPojo> arrayList = liveStreamingYoutube.arrChat;
        if (arrayList != null && !arrayList.isEmpty() && liveStreamingYoutube.arrChat.size() >= 100) {
            liveStreamingYoutube.arrChat.remove(0);
        }
        ArrayList<chatPojo> arrayList2 = liveStreamingYoutube.arrChat;
        if (arrayList2 != null) {
            arrayList2.add(chatpojo);
        }
    }

    public final DatabaseReference getRootRef() {
        return this.rootRef;
    }

    public final void setRootRef(DatabaseReference databaseReference) {
        this.rootRef = databaseReference;
    }

    public final ChildEventListener getChildEventListener() {
        return this.childEventListener;
    }

    public final void setChildEventListener(ChildEventListener childEventListener) {
        this.childEventListener = childEventListener;
    }

    public final Query getQuery() {
        return this.query;
    }

    public final void setQuery(Query query) {
        this.query = query;
    }

    public final void getupdatedchatdata(long actualdate) {
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
        this.rootRef = databaseReferenceChild;
        Intrinsics.checkNotNull(databaseReferenceChild);
        this.query = databaseReferenceChild.orderByChild("date").startAt(actualdate);
        this.childEventListener = new C06041();
        Query query = this.query;
        Intrinsics.checkNotNull(query);
        ChildEventListener childEventListener = this.childEventListener;
        Intrinsics.checkNotNull(childEventListener);
        query.addChildEventListener(childEventListener);
        Query query2 = this.query;
        Intrinsics.checkNotNull(query2);
        query2.limitToLast(100);
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$getupdatedchatdata$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$getupdatedchatdata$1", "Lcom/google/firebase/database/ChildEventListener;", "onChildAdded", "", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", CmcdData.Factory.STREAMING_FORMAT_SS, "", "onChildChanged", "onChildRemoved", "onChildMoved", "onCancelled", "databaseError", "Lcom/google/firebase/database/DatabaseError;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06041 implements ChildEventListener {
        @Override // com.google.firebase.database.ChildEventListener
        public void onCancelled(DatabaseError databaseError) {
            Intrinsics.checkNotNullParameter(databaseError, "databaseError");
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildRemoved(DataSnapshot dataSnapshot) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
        }

        C06041() {
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildAdded(final DataSnapshot dataSnapshot, String s) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
            if (!StringsKt.equals(LiveStreamingYoutube.this.getCheckstatus(), "1", true)) {
                try {
                    final LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                    AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getupdatedchatdata$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveStreamingYoutube.C06041.onChildAdded$lambda$2(dataSnapshot, liveStreamingYoutube);
                        }
                    });
                    return;
                } catch (Exception unused) {
                    LiveStreamingYoutube liveStreamingYoutube2 = LiveStreamingYoutube.this;
                    String string = liveStreamingYoutube2.getResources().getString(R.string.null_pointer_exception);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    liveStreamingYoutube2.showMessage(string);
                    return;
                }
            }
            final LiveStreamingYoutube liveStreamingYoutube3 = LiveStreamingYoutube.this;
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getupdatedchatdata$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06041.onChildAdded$lambda$5(liveStreamingYoutube3, dataSnapshot);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$2(DataSnapshot dataSnapshot, final LiveStreamingYoutube liveStreamingYoutube) {
            chatPojo chatpojo = (chatPojo) dataSnapshot.getValue(chatPojo.class);
            Intrinsics.checkNotNull(chatpojo);
            if (StringsKt.equals(chatpojo.getType(), Polling.EVENT_POLL, true)) {
                if (!StringsKt.equals(BuildConfig.FLAVOR, "NextToppers", true)) {
                    if (StringsKt.equals(chatpojo.getIs_active(), "2", true)) {
                        int size = liveStreamingYoutube.getPollarraylist().size();
                        for (int i = 0; i < size; i++) {
                            Polldata polldata = liveStreamingYoutube.getPollarraylist().get(i);
                            Intrinsics.checkNotNull(polldata);
                            if (StringsKt.equals(polldata.getRendomkey(), chatpojo.getFirebase_id(), true)) {
                                Polldata polldata2 = liveStreamingYoutube.getPollarraylist().get(i);
                                Intrinsics.checkNotNull(polldata2);
                                polldata2.setStatus("2");
                                liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getupdatedchatdata$1$$ExternalSyntheticLambda4
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        LiveStreamingYoutube.C06041.onChildAdded$lambda$2$lambda$0(liveStreamingYoutube);
                                    }
                                });
                            }
                        }
                    } else {
                        Log.e("TAG_APP", "onChildAdded: 3024");
                        liveStreamingYoutube.getpolldatawithid(chatpojo.getFirebase_id());
                    }
                }
            } else if (!StringsKt.equals(chatpojo.getType(), Polling.EVENT_POLL, true) && !StringsKt.equals(chatpojo.getType(), "is_chat_locked", true)) {
                liveStreamingYoutube.addOrUpdateItem(chatpojo);
                liveStreamingYoutube.keyset.add(dataSnapshot.getKey());
            }
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getupdatedchatdata$1$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06041.onChildAdded$lambda$2$lambda$1(liveStreamingYoutube);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$2$lambda$0(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.recylerViewPollOperator != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recylerViewPollOperator;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recylerViewPollOperator;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof PollAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recylerViewPollOperator;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$2$lambda$1(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.getIsUserScrolled()) {
                return;
            }
            if (liveStreamingYoutube.recyclerChat != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
            RecyclerView recyclerView4 = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView4);
            recyclerView4.smoothScrollToPosition(liveStreamingYoutube.getArrChat().size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$5(final LiveStreamingYoutube liveStreamingYoutube, DataSnapshot dataSnapshot) {
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getupdatedchatdata$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06041.onChildAdded$lambda$5$lambda$3(liveStreamingYoutube);
                }
            });
            try {
                chatPojo chatpojo = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                Intrinsics.checkNotNull(chatpojo);
                if (StringsKt.equals(chatpojo.getType(), Polling.EVENT_POLL, true)) {
                    if (liveStreamingYoutube.getPollarraylist().size() == 0) {
                        Log.e("TAG_APP", "onChildAdded: 3084");
                        liveStreamingYoutube.getpolldatawithid(chatpojo.getFirebase_id());
                    }
                } else if (StringsKt.equals(chatpojo.getType(), "is_chat_locked", true)) {
                    liveStreamingYoutube.getLockarr().size();
                } else if (liveStreamingYoutube.getArrChat().size() == 0) {
                    liveStreamingYoutube.addOrUpdateItem(chatpojo);
                    liveStreamingYoutube.keyset.add(dataSnapshot.getKey());
                    liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getupdatedchatdata$1$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveStreamingYoutube.C06041.onChildAdded$lambda$5$lambda$4(liveStreamingYoutube);
                        }
                    });
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            liveStreamingYoutube.setCheckstatus("0");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$5$lambda$3(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.recyclerChat != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
            RecyclerView recyclerView4 = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView4);
            recyclerView4.smoothScrollToPosition(liveStreamingYoutube.getArrChat().size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onChildAdded$lambda$5$lambda$4(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.getIsUserScrolled()) {
                return;
            }
            if (liveStreamingYoutube.recyclerChat != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
            RecyclerView recyclerView4 = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView4);
            recyclerView4.smoothScrollToPosition(liveStreamingYoutube.getArrChat().size());
        }
    }

    private final void checkintract() {
        DatabaseReference databaseReference = this.mFirebaseDatabaseReference1;
        if (databaseReference != null) {
            try {
                Intrinsics.checkNotNull(databaseReference);
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.checkintract.1
                    @Override // com.google.firebase.database.ValueEventListener
                    public void onCancelled(DatabaseError databaseError) {
                        Intrinsics.checkNotNullParameter(databaseError, "databaseError");
                    }

                    @Override // com.google.firebase.database.ValueEventListener
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                        try {
                            if (dataSnapshot.getValue() != null) {
                                OnlineUser onlineUser = (OnlineUser) dataSnapshot.getValue(OnlineUser.class);
                                LiveStreamingYoutube.this.isintractavailable = true;
                                if (onlineUser == null || onlineUser.getInteract() == null || !StringsKt.equals(onlineUser.getInteract(), "0", true)) {
                                    return;
                                }
                                DatabaseReference databaseReference2 = LiveStreamingYoutube.this.mFirebaseDatabaseReference1;
                                Intrinsics.checkNotNull(databaseReference2);
                                databaseReference2.child("interact").setValue("1");
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void getpolldatawithid(String randomid) {
        this.mFirebaseDatabaseReferencepolldata = null;
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + randomid);
        this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
        Intrinsics.checkNotNull(databaseReferenceChild);
        databaseReferenceChild.addListenerForSingleValueEvent(new C06031(randomid));
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$getpolldatawithid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$getpolldatawithid$1", "Lcom/google/firebase/database/ValueEventListener;", "onDataChange", "", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", "onCancelled", "databaseError", "Lcom/google/firebase/database/DatabaseError;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06031 implements ValueEventListener {
        final /* synthetic */ String $randomid;

        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
            Intrinsics.checkNotNullParameter(databaseError, "databaseError");
        }

        C06031(String str) {
            this.$randomid = str;
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(final DataSnapshot dataSnapshot) {
            Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
            final LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
            final String str = this.$randomid;
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getpolldatawithid$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06031.onDataChange$lambda$4(dataSnapshot, liveStreamingYoutube, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$4(DataSnapshot dataSnapshot, final LiveStreamingYoutube liveStreamingYoutube, final String str) {
            final Polldata polldata = (Polldata) new Gson().fromJson(new Gson().toJson(dataSnapshot.getValue()), Polldata.class);
            int size = liveStreamingYoutube.getPollarraylist().size();
            for (int i = 0; i < size; i++) {
                Polldata polldata2 = liveStreamingYoutube.getPollarraylist().get(i);
                Intrinsics.checkNotNull(polldata2);
                if (StringsKt.equals(polldata2.getRendomkey(), str, true)) {
                    Polldata polldata3 = liveStreamingYoutube.getPollarraylist().get(i);
                    Intrinsics.checkNotNull(polldata3);
                    polldata3.setStatus("1");
                    liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getpolldatawithid$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveStreamingYoutube.C06031.onDataChange$lambda$4$lambda$0(liveStreamingYoutube);
                        }
                    });
                    return;
                }
            }
            try {
                String delay = polldata.getDelay();
                Intrinsics.checkNotNullExpressionValue(delay, "getDelay(...)");
                if (Long.parseLong(delay) > 0) {
                    String delay2 = polldata.getDelay();
                    Intrinsics.checkNotNullExpressionValue(delay2, "getDelay(...)");
                    long j = 1000;
                    if (Long.parseLong(delay2) - (System.currentTimeMillis() / j) > 0) {
                        String delay3 = polldata.getDelay();
                        Intrinsics.checkNotNullExpressionValue(delay3, "getDelay(...)");
                        final long j2 = Long.parseLong(delay3) - (System.currentTimeMillis() / j);
                        liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getpolldatawithid$1$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                LiveStreamingYoutube.C06031.onDataChange$lambda$4$lambda$1(j2, str, polldata, liveStreamingYoutube);
                            }
                        });
                        return;
                    }
                }
                if (str != null) {
                    polldata.setRendomkey(str);
                    polldata.setStatus("1");
                    Log.e("TAG_APP", "onDataChange: 3245");
                    liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getpolldatawithid$1$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveStreamingYoutube.C06031.onDataChange$lambda$4$lambda$2(liveStreamingYoutube);
                        }
                    });
                    ((Polldata) Objects.requireNonNull(polldata)).setMyAnswer("0");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(0, polldata);
                    arrayList.addAll(liveStreamingYoutube.getPollarraylist());
                    liveStreamingYoutube.getPollarraylist().clear();
                    liveStreamingYoutube.getPollarraylist().addAll(arrayList);
                    liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getpolldatawithid$1$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveStreamingYoutube.C06031.onDataChange$lambda$4$lambda$3(liveStreamingYoutube);
                        }
                    });
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$4$lambda$0(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.recylerViewPollOperator != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recylerViewPollOperator;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recylerViewPollOperator;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof PollAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recylerViewPollOperator;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$4$lambda$1(long j, String str, Polldata polldata, LiveStreamingYoutube liveStreamingYoutube) {
            new LiveStreamingYoutube$getpolldatawithid$1$onDataChange$1$2$1(str, polldata, liveStreamingYoutube, j * ((long) 1000)).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$4$lambda$2(LiveStreamingYoutube liveStreamingYoutube) {
            View rootView = liveStreamingYoutube.getRootView();
            View rootView2 = rootView != null ? rootView.getRootView() : null;
            Intrinsics.checkNotNull(rootView2);
            Snackbar.make(rootView2, "New Poll Added", -1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDataChange$lambda$4$lambda$3(LiveStreamingYoutube liveStreamingYoutube) {
            if (liveStreamingYoutube.recylerViewPollOperator != null) {
                RecyclerView recyclerView = liveStreamingYoutube.recylerViewPollOperator;
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = liveStreamingYoutube.recylerViewPollOperator;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof PollAdapter) {
                        RecyclerView recyclerView3 = liveStreamingYoutube.recylerViewPollOperator;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }

    public final void createPollDataWithId(String randomid, String pollId, JSONObject jsonstring) {
        Intrinsics.checkNotNullParameter(pollId, "pollId");
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        this.mFirebaseDatabaseReferencepolldata = null;
        this.mFirebaseDatabaseReferencepolldata = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + randomid);
        this.mFirebaseDatabaseReferenceone2many = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TOM/");
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
        this.mFirebaseDatabaseReferenceone2one = databaseReferenceChild;
        Intrinsics.checkNotNull(databaseReferenceChild);
        databaseReferenceChild.push().getKey();
        if (this.mFirebaseDatabaseReferencePollAdded == null) {
            this.mFirebaseDatabaseReferencePollAdded = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll");
        }
        if (StringsKt.equals(this.modeOfPoll, "1", true)) {
            this.pollAnswer = "0";
        }
        chatPojo chatpojo = new chatPojo(MakeMyExam.userId, "", SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", Polling.EVENT_POLL, this.course_id);
        chatpojo.setFirebase_id(randomid);
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferencePollAdded;
        if (databaseReference != null) {
            Intrinsics.checkNotNull(databaseReference);
            databaseReference.push().setValue(chatpojo);
        }
    }

    public final void showDialog(View view) {
        LiveStreamingYoutube liveStreamingYoutube = this;
        if (Helper.isNetworkConnected(liveStreamingYoutube)) {
            PlayerView playerView = this.playerView;
            Intrinsics.checkNotNull(playerView);
            if (playerView.getPlayer() != null) {
                pausePlayer();
                this.isActivityLive = false;
                PlayerView playerView2 = this.playerView;
                Intrinsics.checkNotNull(playerView2);
                Player player = playerView2.getPlayer();
                Intrinsics.checkNotNull(player);
                final String str = formattedTime(player.getCurrentPosition());
                final Dialog dialog = new Dialog(liveStreamingYoutube, R.style.CustomAlertDialog);
                dialog.requestWindowFeature(1);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.add_book_dialog);
                ((TextView) dialog.findViewById(R.id.text_dialog_time)).setText(getResources().getString(R.string.time_) + str);
                final EditText editText = (EditText) dialog.findViewById(R.id.nameTV);
                dialog.findViewById(R.id.btn_dialog_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda21
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        LiveStreamingYoutube.showDialog$lambda$74(dialog, this, view2);
                    }
                });
                dialog.findViewById(R.id.btn_dialog_submit).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda23
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        LiveStreamingYoutube.showDialog$lambda$75(editText, dialog, this, str, view2);
                    }
                });
                dialog.show();
                return;
            }
            String string = getResources().getString(R.string.player_is_not_initialized_yet);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showMessage(string);
            return;
        }
        String string2 = getResources().getString(R.string.please_connect_internet_connection);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        showMessage(string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$74(Dialog dialog, LiveStreamingYoutube liveStreamingYoutube, View view) {
        dialog.dismiss();
        PlayerView playerView = liveStreamingYoutube.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() != null) {
            PlayerView playerView2 = liveStreamingYoutube.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            if (player.getPlaybackState() == 3) {
                PlayerView playerView3 = liveStreamingYoutube.playerView;
                Intrinsics.checkNotNull(playerView3);
                Player player2 = playerView3.getPlayer();
                Intrinsics.checkNotNull(player2);
                player2.setPlayWhenReady(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$75(EditText editText, Dialog dialog, LiveStreamingYoutube liveStreamingYoutube, String str, View view) {
        String string = editText.getText().toString();
        if (string.length() > 0) {
            dialog.dismiss();
            Helper.hideSoftKeyboard(liveStreamingYoutube);
            liveStreamingYoutube.BookMarkApi("", str, string, "1");
        } else {
            String string2 = liveStreamingYoutube.getResources().getString(R.string.add_title);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            liveStreamingYoutube.showMessage(string2);
        }
    }

    private final void BookMarkApi(String id, String time, String info2, String state) {
        this.time = time;
        this.info = info2;
        this.state = state;
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.add_video_index, "", false, false);
    }

    private final String formattedTime(long millis) {
        if (millis < 1) {
            return "00:00:00";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.getDefault(), "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours(millis)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)))}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final void onDelete(Bookmark data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String id = data.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        BookMarkApi(id, "", "", "2");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        LandscapePollDialog landscapePollDialog;
        super.onResume();
        try {
            if (getResources().getConfiguration().orientation == 1 && (landscapePollDialog = this.landscapePollDialog) != null) {
                landscapePollDialog.dismissLandscapeDialog();
            }
        } catch (Exception e2) {
            Log.d("TAGlandscapePollDialog", "onResume: " + e2.getMessage());
        }
        try {
            this.isUserActive = true;
            RecyclerView recyclerView = this.recyclerChat;
            if (recyclerView != null) {
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getAdapter() != null) {
                    RecyclerView recyclerView2 = this.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView2);
                    if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                        RecyclerView recyclerView3 = this.recyclerChat;
                        Intrinsics.checkNotNull(recyclerView3);
                        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.currentTime = System.currentTimeMillis();
            this.starttime = String.valueOf(System.currentTimeMillis());
            if (StringsKt.equals(MakeMyExam.userId, "", true) || StringsKt.equals(MakeMyExam.userId, "0", true)) {
                MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
                MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
            }
            Object systemService = getApplicationContext().getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            if (!audioManager.isMicrophoneMute()) {
                audioManager.setMicrophoneMute(true);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                audioManager.setAllowedCapturePolicy(3);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        handleIsAudio();
        if (this.isLoadvedio) {
            this.isLoadvedio = false;
            String str = this.islive;
            boolean z = (str == null || str.length() == 0 || !StringsKt.equals(this.islive, "4", true)) ? false : true;
            if (StringsKt.equals(this.controlYT, "2", true) || StringsKt.equals(this.controlYT, "3", true)) {
                if (StringsKt.equals(this.selectedStream, "stream1", true)) {
                    showWebViewPlayer();
                    return;
                }
                if (StringsKt.equals(this.selectedStream, "stream2", true)) {
                    this.isOriginUrlOld = false;
                    showYoutubePlayer();
                    return;
                } else {
                    if (StringsKt.equals(this.selectedStream, "stream3", true)) {
                        this.isOriginUrlOld = true;
                        showYoutubePlayer();
                        return;
                    }
                    return;
                }
            }
            if (StringsKt.equals(this.customPlayer, "0", true) || (StringsKt.equals(this.customPlayer, "0", true) && z)) {
                showWebViewPlayer();
            } else if (StringsKt.equals(this.customPlayer, "1", true)) {
                showYoutubePlayer();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            this.telephonyManager = (TelephonyManager) getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 31) {
                this.newCallback = new MyTelephonyCallback();
                TelephonyManager telephonyManager = this.telephonyManager;
                Intrinsics.checkNotNull(telephonyManager);
                Executor mainExecutor = getMainExecutor();
                MyTelephonyCallback myTelephonyCallback = this.newCallback;
                Intrinsics.checkNotNull(myTelephonyCallback);
                telephonyManager.registerTelephonyCallback(mainExecutor, myTelephonyCallback);
                return;
            }
            this.oldListener = new MyPhoneStateListener();
            TelephonyManager telephonyManager2 = this.telephonyManager;
            Intrinsics.checkNotNull(telephonyManager2);
            telephonyManager2.listen(this.oldListener, 32);
        } catch (Exception e2) {
            Log.d("CALL_STATE", "handleCallStateChange: " + e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/appnew/android/player/LiveStreamingYoutube$MyPhoneStateListener;", "Landroid/telephony/PhoneStateListener;", "<init>", "(Lcom/appnew/android/player/LiveStreamingYoutube;)V", "onCallStateChanged", "", "state", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class MyPhoneStateListener extends PhoneStateListener {
        public MyPhoneStateListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int state, String phoneNumber) {
            LiveStreamingYoutube.this.handleCallStateChange(state);
        }
    }

    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0083\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/appnew/android/player/LiveStreamingYoutube$MyTelephonyCallback;", "Landroid/telephony/TelephonyCallback;", "Landroid/telephony/TelephonyCallback$CallStateListener;", "<init>", "(Lcom/appnew/android/player/LiveStreamingYoutube;)V", "onCallStateChanged", "", "state", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class MyTelephonyCallback extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        public MyTelephonyCallback() {
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public void onCallStateChanged(int state) {
            LiveStreamingYoutube.this.handleCallStateChange(state);
        }
    }

    public final void handleCallStateChange(int state) {
        try {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (state == 0) {
                if (audioManager != null && !audioManager.isMicrophoneMute()) {
                    audioManager.setMicrophoneMute(true);
                }
                if (audioManager != null) {
                    audioManager.setMode(0);
                }
                oncall(false);
                return;
            }
            if (state == 1 || state == 2) {
                Log.d("CALL_STATE", "Incoming call");
                if (audioManager != null && audioManager.isMicrophoneMute()) {
                    audioManager.setMicrophoneMute(false);
                }
                oncall(true);
            }
        } catch (Exception e2) {
            Log.d("CALL_STATE", "handleCallStateChange: " + e2.getMessage());
        }
    }

    public final void oncall(final boolean b2) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.oncall$lambda$76(b2, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oncall$lambda$76(boolean z, LiveStreamingYoutube liveStreamingYoutube) {
        if (z) {
            Log.d("CALL_STATE", "Video pause");
            liveStreamingYoutube.pausePlayer();
        }
    }

    private final void initYoutubePlayer() {
        if (StringsKt.equals(this.controlYT, "0", true)) {
            FrameLayout frameLayout = this.fullScreenContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        } else {
            FrameLayout frameLayout2 = this.fullScreenContainer;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        FrameLayout frameLayout3 = this.relativeLYoutubeLogo;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        FrameLayout frameLayout4 = this.relativeLYoutubeLogoTab;
        if (frameLayout4 != null) {
            frameLayout4.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.relativeLayoutTab;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        FrameLayout frameLayout5 = this.suggestedVideoTab;
        if (frameLayout5 != null) {
            frameLayout5.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.relativeLayout;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.initYoutubePlayer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        });
        FrameLayout frameLayout6 = this.relativeLYoutubeLogo;
        Intrinsics.checkNotNull(frameLayout6);
        frameLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.initYoutubePlayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        });
        RelativeLayout relativeLayout4 = this.relativeLayoutTab;
        Intrinsics.checkNotNull(relativeLayout4);
        relativeLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.initYoutubePlayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        });
        FrameLayout frameLayout7 = this.relativeLYoutubeLogoTab;
        Intrinsics.checkNotNull(frameLayout7);
        frameLayout7.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.initYoutubePlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        });
        FrameLayout frameLayout8 = this.fullScreenContainer;
        Intrinsics.checkNotNull(frameLayout8);
        frameLayout8.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.initYoutubePlayer.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        });
        FrameLayout frameLayout9 = this.suggestedVideoTab;
        Intrinsics.checkNotNull(frameLayout9);
        frameLayout9.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.initYoutubePlayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        });
        RelativeLayout relativeLayout5 = this.relativeLayout1;
        Intrinsics.checkNotNull(relativeLayout5);
        relativeLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.initYoutubePlayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        });
        ImageView imageView = this.refreshUrl;
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.initYoutubePlayer.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (LiveStreamingYoutube.this.youTubePlayerNew != null) {
                    YouTubePlayer youTubePlayer = LiveStreamingYoutube.this.youTubePlayerNew;
                    Intrinsics.checkNotNull(youTubePlayer);
                    youTubePlayer.seekTo(0.0f);
                    YouTubePlayer youTubePlayer2 = LiveStreamingYoutube.this.youTubePlayerNew;
                    Intrinsics.checkNotNull(youTubePlayer2);
                    youTubePlayer2.play();
                }
            }
        });
        initializePlayer();
    }

    private final void initializePlayer() {
        this.youtube_player_view = (YouTubePlayerView) findViewById(R.id.youtube_player2);
        Lifecycle lifecycle = getLifecycle();
        YouTubePlayerView youTubePlayerView = this.youtube_player_view;
        Intrinsics.checkNotNull(youTubePlayerView);
        lifecycle.addObserver(youTubePlayerView);
        ProgressBar progressBar = this.progressBar;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setVisibility(0);
        this.youTubePlayerListener = new AbstractYouTubePlayerListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.initializePlayer.1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
            public void onReady(YouTubePlayer youTubePlayer) {
                Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
                super.onReady(youTubePlayer);
                String str = LiveStreamingYoutube.this.videoId;
                Intrinsics.checkNotNull(str);
                youTubePlayer.loadVideo(str, 0.0f);
                LiveStreamingYoutube.this.youTubePlayerNew = youTubePlayer;
                YouTubePlayerView youtube_player_view = LiveStreamingYoutube.this.getYoutube_player_view();
                if (youtube_player_view != null) {
                    youtube_player_view.setVisibility(0);
                }
                ProgressBar progressBar2 = LiveStreamingYoutube.this.getProgressBar();
                Intrinsics.checkNotNull(progressBar2);
                progressBar2.setVisibility(8);
            }

            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
            public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
                Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
                Intrinsics.checkNotNullParameter(state, "state");
                super.onStateChange(youTubePlayer, state);
                if (state.name() == "ENDED") {
                    RelativeLayout relativeLayout = LiveStreamingYoutube.this.relativeLayout1;
                    Intrinsics.checkNotNull(relativeLayout);
                    relativeLayout.setVisibility(0);
                    ImageView refreshUrl = LiveStreamingYoutube.this.getRefreshUrl();
                    Intrinsics.checkNotNull(refreshUrl);
                    refreshUrl.setVisibility(0);
                    return;
                }
                ImageView refreshUrl2 = LiveStreamingYoutube.this.getRefreshUrl();
                Intrinsics.checkNotNull(refreshUrl2);
                refreshUrl2.setVisibility(8);
                RelativeLayout relativeLayout2 = LiveStreamingYoutube.this.relativeLayout1;
                Intrinsics.checkNotNull(relativeLayout2);
                relativeLayout2.setVisibility(8);
            }

            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
            public void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError error) {
                Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
                Intrinsics.checkNotNullParameter(error, "error");
                super.onError(youTubePlayer, error);
                ProgressBar progressBar2 = LiveStreamingYoutube.this.getProgressBar();
                Intrinsics.checkNotNull(progressBar2);
                progressBar2.setVisibility(8);
            }
        };
        iframe();
    }

    private final void iframe() {
        String str;
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.YOUTUBE_AUDIO_TRACK), "1", true)) {
            Locale locale = new Locale(Const.HINDI);
            Locale.setDefault(locale);
            Configuration configuration = getResources().getConfiguration();
            configuration.setLocale(locale);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }
        if (StringsKt.equals(this.customPlayer, "1", true) && StringsKt.equals(this.controlYT, "1", true)) {
            this.isOriginUrlOld = true;
        }
        if (this.isOriginUrlOld) {
            str = "https://admin.videocrypt.in/youtube";
        } else {
            str = "https://youtu.be";
        }
        IFramePlayerOptions iFramePlayerOptionsBuild = new IFramePlayerOptions.Builder().controls(1).rel(0).list("").origin(str).fullscreen(1).build();
        YouTubePlayerView youTubePlayerView = this.youtube_player_view;
        Intrinsics.checkNotNull(youTubePlayerView);
        youTubePlayerView.addFullscreenListener(new FullscreenListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.iframe.1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
            public void onEnterFullscreen(View fullscreenView, Function0<Unit> exitFullscreen) {
                Intrinsics.checkNotNullParameter(fullscreenView, "fullscreenView");
                Intrinsics.checkNotNullParameter(exitFullscreen, "exitFullscreen");
                try {
                    ViewParent parent = fullscreenView.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(fullscreenView);
                    }
                    YouTubePlayerView youtube_player_view = LiveStreamingYoutube.this.getYoutube_player_view();
                    if (youtube_player_view != null) {
                        youtube_player_view.setVisibility(8);
                    }
                    FrameLayout frameLayout = LiveStreamingYoutube.this.fullScreenContainer;
                    if (frameLayout != null) {
                        frameLayout.addView(fullscreenView, new FrameLayout.LayoutParams(-1, -1));
                    }
                    FrameLayout frameLayout2 = LiveStreamingYoutube.this.fullScreenContainer;
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(0);
                    }
                    LiveStreamingYoutube.this.setRequestedOrientation(6);
                    LiveStreamingYoutube.this.setFullscreen(true);
                    enableImmersiveMode();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
            public void onExitFullscreen() {
                try {
                    FrameLayout frameLayout = LiveStreamingYoutube.this.fullScreenContainer;
                    if (frameLayout != null) {
                        frameLayout.removeAllViews();
                    }
                    FrameLayout frameLayout2 = LiveStreamingYoutube.this.fullScreenContainer;
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(8);
                    }
                    YouTubePlayerView youtube_player_view = LiveStreamingYoutube.this.getYoutube_player_view();
                    if (youtube_player_view != null) {
                        youtube_player_view.setVisibility(0);
                    }
                    LiveStreamingYoutube.this.setRequestedOrientation(7);
                    LiveStreamingYoutube.this.setFullscreen(false);
                    disableImmersiveMode();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            private final void enableImmersiveMode() {
                LiveStreamingYoutube.this.getWindow().getDecorView().setSystemUiVisibility(5894);
            }

            private final void disableImmersiveMode() {
                LiveStreamingYoutube.this.getWindow().getDecorView().setSystemUiVisibility(256);
            }
        });
        YouTubePlayerView youTubePlayerView2 = this.youtube_player_view;
        Intrinsics.checkNotNull(youTubePlayerView2);
        youTubePlayerView2.setEnableAutomaticInitialization(false);
        YouTubePlayerView youTubePlayerView3 = this.youtube_player_view;
        Intrinsics.checkNotNull(youTubePlayerView3);
        AbstractYouTubePlayerListener abstractYouTubePlayerListener = this.youTubePlayerListener;
        Intrinsics.checkNotNull(abstractYouTubePlayerListener);
        youTubePlayerView3.initialize(abstractYouTubePlayerListener, false, iFramePlayerOptionsBuild);
    }

    private final void playVideo(String url) {
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this).setSeekForwardIncrementMs(10000L).setSeekBackIncrementMs(10000L).build();
        Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "build(...)");
        exoPlayerBuild.setPlayWhenReady(true);
        exoPlayerBuild.setMediaItem(MediaItem.fromUri(url));
        exoPlayerBuild.prepare();
        exoPlayerBuild.seekTo(playPosition);
        exoPlayerBuild.addListener(this.listener);
        PlayerView playerView = this.playerView;
        Intrinsics.checkNotNull(playerView);
        playerView.setPlayer(exoPlayerBuild);
        PlayerView playerView2 = this.playerView;
        Intrinsics.checkNotNull(playerView2);
        playerView2.setKeepScreenOn(true);
    }

    public final Player.Listener getListener() {
        return this.listener;
    }

    public final void setListener(Player.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "<set-?>");
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeFullScreenDialogNew() {
        setRequestedOrientation(1);
        LinearLayout linearLayout = this.llll;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(0);
        if (getResources().getConfiguration().orientation == 2) {
            LinearLayout linearLayout2 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout2);
            linearLayout2.setVisibility(8);
        } else {
            LinearLayout linearLayout3 = this.linearLayout;
            Intrinsics.checkNotNull(linearLayout3);
            linearLayout3.setVisibility(0);
        }
    }

    private final void openFullScreenDialogNew() {
        LinearLayout linearLayout = this.llll;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(8);
        setRequestedOrientation(0);
        this.mExoPlayerFullscreen = true;
        ImageView imageView = this.fullscreen;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
        TextView textView = this.video_name_text;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(8);
        LinearLayout linearLayout3 = this.chatlayout;
        Intrinsics.checkNotNull(linearLayout3);
        linearLayout3.setVisibility(8);
        TextView textView2 = this.addBookmark;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(8);
        LinearLayout linearLayout4 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout4);
        linearLayout4.setVisibility(8);
        getWindow().setFlags(1024, 1024);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View view = this.rootView;
        Intrinsics.checkNotNull(view);
        view.setLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        clearClipBoard();
        PlayerView playerView = this.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() != null) {
            PlayerView playerView2 = this.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            player.release();
            this.isLoadvedio = true;
        }
        WebView webView = this.webView;
        if (webView != null) {
            Intrinsics.checkNotNull(webView);
            webView.loadUrl("");
            this.isLoadvedio = true;
        }
        if (StringsKt.equals(this.islive, "1", true)) {
            try {
                UtkashRoom utkashRoom = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom);
                if (utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, this.isaudio)) {
                    UtkashRoom utkashRoom2 = this.utkashRoom;
                    Intrinsics.checkNotNull(utkashRoom2);
                    utkashRoom2.getyoutubedata().updateTime(Long.valueOf(playPosition), this.video_id, MakeMyExam.userId, this.isaudio);
                } else {
                    YoutubePlayerTable youtubePlayerTable = new YoutubePlayerTable();
                    youtubePlayerTable.setYoutubeid(this.url);
                    youtubePlayerTable.setYoutubetime(playPosition);
                    youtubePlayerTable.setIsaudio(this.isaudio);
                    youtubePlayerTable.setVideoid(this.video_id);
                    youtubePlayerTable.setVideoname(this.video_name);
                    youtubePlayerTable.setUserid(MakeMyExam.userId);
                    UtkashRoom utkashRoom3 = this.utkashRoom;
                    Intrinsics.checkNotNull(utkashRoom3);
                    utkashRoom3.getyoutubedata().addVideo(youtubePlayerTable);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (this.telephonyManager != null) {
                if (Build.VERSION.SDK_INT >= 31 && this.newCallback != null) {
                    Log.d("CALL_STATE", "12+ unregister");
                    TelephonyManager telephonyManager = this.telephonyManager;
                    Intrinsics.checkNotNull(telephonyManager);
                    MyTelephonyCallback myTelephonyCallback = this.newCallback;
                    Intrinsics.checkNotNull(myTelephonyCallback);
                    telephonyManager.unregisterTelephonyCallback(myTelephonyCallback);
                } else if (this.oldListener != null) {
                    Log.d("CALL_STATE", "< 12 unregister");
                    TelephonyManager telephonyManager2 = this.telephonyManager;
                    Intrinsics.checkNotNull(telephonyManager2);
                    telephonyManager2.listen(this.oldListener, 0);
                }
            }
        } catch (Exception e3) {
            Log.d("CALL_STATE", "handleCallStateChange: " + e3.getMessage());
        }
        super.onStop();
    }

    public final void handleOnBackPress() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleOnBackPress.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                MediaPlayer mediaPlayer;
                LiveStreamingYoutube.this.setUserCopied(false);
                if (LiveStreamingYoutube.this.getResources().getConfiguration().orientation == 2) {
                    LiveStreamingYoutube.this.closeFullScreenDialogNew();
                } else {
                    try {
                        YTubePlayerView yTubePlayerView = LiveStreamingYoutube.this.getYTubePlayerView();
                        if (yTubePlayerView != null) {
                            yTubePlayerView.loadUrl("about:blank");
                            yTubePlayerView.clearHistory();
                            yTubePlayerView.stopLoading();
                            yTubePlayerView.clearCache(true);
                            yTubePlayerView.clearView();
                            yTubePlayerView.freeMemory();
                            yTubePlayerView.destroy();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    LiveStreamingYoutube.this.showFeedbackOnBack();
                }
                ChatAdapter chatAdapter = LiveStreamingYoutube.this.getChatAdapter();
                if (chatAdapter == null || (mediaPlayer = chatAdapter.mediaPlayer) == null || !mediaPlayer.isPlaying()) {
                    return;
                }
                mediaPlayer.pause();
            }
        });
    }

    public final long getEndtime() {
        return this.endtime;
    }

    public final void setEndtime(long j) {
        this.endtime = j;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isUserActive = false;
        clearClipBoard();
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        YTubePlayerView yTubePlayerView = this.yTubePlayerView;
        if (yTubePlayerView != null) {
            try {
                Intrinsics.checkNotNull(yTubePlayerView);
                yTubePlayerView.loadUrl("about:blank");
                YTubePlayerView yTubePlayerView2 = this.yTubePlayerView;
                Intrinsics.checkNotNull(yTubePlayerView2);
                yTubePlayerView2.clearHistory();
                YTubePlayerView yTubePlayerView3 = this.yTubePlayerView;
                Intrinsics.checkNotNull(yTubePlayerView3);
                yTubePlayerView3.stopLoading();
                YTubePlayerView yTubePlayerView4 = this.yTubePlayerView;
                Intrinsics.checkNotNull(yTubePlayerView4);
                yTubePlayerView4.clearCache(true);
                YTubePlayerView yTubePlayerView5 = this.yTubePlayerView;
                Intrinsics.checkNotNull(yTubePlayerView5);
                yTubePlayerView5.clearView();
                YTubePlayerView yTubePlayerView6 = this.yTubePlayerView;
                Intrinsics.checkNotNull(yTubePlayerView6);
                yTubePlayerView6.freeMemory();
                YTubePlayerView yTubePlayerView7 = this.yTubePlayerView;
                Intrinsics.checkNotNull(yTubePlayerView7);
                yTubePlayerView7.destroy();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
            } catch (SecurityException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }
        PlayerView playerView = this.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() != null) {
            PlayerView playerView2 = this.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            playPosition = player.getCurrentPosition();
            pausePlayer();
        }
        if (!StringsKt.equals(this.starttime, "0", true)) {
            NetworkCall networkCall = this.networkCall;
            Intrinsics.checkNotNull(networkCall);
            networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
        }
        try {
            OutputStream outputStream = this.output;
            if (outputStream != null) {
                Intrinsics.checkNotNull(outputStream);
                outputStream.close();
            }
            InputStream inputStream = this.input;
            if (inputStream != null) {
                Intrinsics.checkNotNull(inputStream);
                inputStream.close();
            }
        } catch (Exception unused) {
        }
        ProgressBar progressBar = this.progress_bar_pdf;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setVisibility(8);
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            Intrinsics.checkNotNull(httpURLConnection);
            httpURLConnection.disconnect();
        }
        if (StringsKt.equals("1", "1", true)) {
            addRecordTime();
        }
    }

    private final void initFullscreenDialog() {
        this.mFullScreenDialog = new Dialog() { // from class: com.appnew.android.player.LiveStreamingYoutube.initFullscreenDialog.1
            {
                super(LiveStreamingYoutube.this, android.R.style.Theme.Black.NoTitleBar.Fullscreen);
            }

            @Override // android.app.Dialog
            public void onBackPressed() {
                if (LiveStreamingYoutube.this.mExoPlayerFullscreen) {
                    LiveStreamingYoutube.this.closeFullScreenDialogNew();
                }
                super.onBackPressed();
            }
        };
    }

    private final void closeFullscreenDialog() {
        this.mExoPlayerFullscreen = false;
        setRequestedOrientation(1);
        ImageView imageView = this.mFullScreenIcon;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Handler handler;
        super.onDestroy();
        Runnable runnable = this.autoFeedbackRunnable;
        if (runnable != null && (handler = this.feedbackHandler) != null) {
            handler.removeCallbacks(runnable);
        }
        this.feedbackHandler = null;
        this.autoFeedbackRunnable = null;
        SharedPreference.getInstance().putString(Const.SELECTED_STREAM_YT, "");
        try {
            PDFView pDFView = this.pdfViewPager;
            if (pDFView != null) {
                Intrinsics.checkNotNull(pDFView);
                pDFView.recycle();
            }
        } catch (Exception e2) {
            Log.d("TAGPDFVIEW", "onDestroy: " + e2.getMessage());
        }
        clearClipBoard();
        this.arrChat = new ArrayList<>();
        if (this.chatAdapter != null) {
            this.chatAdapter = null;
        }
        stopMessageProcessor();
        stopMessageProcessorEmoji();
        if (this.mqttClientListen != null) {
            mqttDisconnect(getMqttClientListen());
        }
        if (this.mqttClientPublish != null) {
            mqttDisconnect(getMqttClientPublish());
        }
        if (this.xmppManager != null) {
            getXmppManager().disconnect();
        }
        YouTubePlayerView youTubePlayerView = this.youtube_player_view;
        if (youTubePlayerView != null) {
            Intrinsics.checkNotNull(youTubePlayerView);
            youTubePlayerView.release();
        }
        if (!StringsKt.equals(this.starttime, "0", true)) {
            NetworkCall networkCall = this.networkCall;
            Intrinsics.checkNotNull(networkCall);
            networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
        }
        SharedPreference.getInstance().putString(Const.IS_RECENT_REFRESH, "1");
        if (this.isPublicChatEnabled) {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2many;
            if (databaseReference != null) {
                Intrinsics.checkNotNull(databaseReference);
                ValueEventListener valueEventListener = this.onetomanyvalueEventListener;
                Intrinsics.checkNotNull(valueEventListener);
                databaseReference.removeEventListener(valueEventListener);
                Query query = this.onetomantquery;
                if (query != null) {
                    Intrinsics.checkNotNull(query);
                    ChildEventListener childEventListener = this.onetomanychildEventListener;
                    Intrinsics.checkNotNull(childEventListener);
                    query.removeEventListener(childEventListener);
                }
            }
        } else {
            DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferenceone2one;
            if (databaseReference2 != null) {
                Intrinsics.checkNotNull(databaseReference2);
                ValueEventListener valueEventListener2 = this.valueEventListener;
                Intrinsics.checkNotNull(valueEventListener2);
                databaseReference2.removeEventListener(valueEventListener2);
                Query query2 = this.query;
                if (query2 != null) {
                    Intrinsics.checkNotNull(query2);
                    ChildEventListener childEventListener2 = this.childEventListener;
                    Intrinsics.checkNotNull(childEventListener2);
                    query2.removeEventListener(childEventListener2);
                }
            }
        }
        DatabaseReference databaseReference3 = this.mFirebaseDatabaseReferenceChatLocked;
        if (databaseReference3 != null) {
            Intrinsics.checkNotNull(databaseReference3);
            ValueEventListener valueEventListener3 = this.chatLockedValueEventListener;
            Intrinsics.checkNotNull(valueEventListener3);
            databaseReference3.removeEventListener(valueEventListener3);
        }
        DatabaseReference databaseReference4 = this.mFirebaseDatabaseReferencePollAdded;
        if (databaseReference4 != null) {
            Intrinsics.checkNotNull(databaseReference4);
            ValueEventListener valueEventListener4 = this.pollAddedEventListener;
            Intrinsics.checkNotNull(valueEventListener4);
            databaseReference4.removeEventListener(valueEventListener4);
        }
        if (StringsKt.equals(this.islive, "4", true)) {
            setUserOffline();
        }
        youtubeUri = "";
        PlayerView playerView = this.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() != null) {
            PlayerView playerView2 = this.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            playPosition = player.getCurrentPosition();
            PlayerView playerView3 = this.playerView;
            Intrinsics.checkNotNull(playerView3);
            Player player2 = playerView3.getPlayer();
            Intrinsics.checkNotNull(player2);
            player2.release();
        }
        if (this.webView != null) {
            YTubePlayerView yTubePlayerView = this.yTubePlayerView;
            Intrinsics.checkNotNull(yTubePlayerView);
            yTubePlayerView.loadUrl("about:blank");
            YTubePlayerView yTubePlayerView2 = this.yTubePlayerView;
            Intrinsics.checkNotNull(yTubePlayerView2);
            yTubePlayerView2.clearHistory();
            YTubePlayerView yTubePlayerView3 = this.yTubePlayerView;
            Intrinsics.checkNotNull(yTubePlayerView3);
            yTubePlayerView3.stopLoading();
            YTubePlayerView yTubePlayerView4 = this.yTubePlayerView;
            Intrinsics.checkNotNull(yTubePlayerView4);
            yTubePlayerView4.clearCache(true);
            YTubePlayerView yTubePlayerView5 = this.yTubePlayerView;
            Intrinsics.checkNotNull(yTubePlayerView5);
            yTubePlayerView5.clearView();
            YTubePlayerView yTubePlayerView6 = this.yTubePlayerView;
            Intrinsics.checkNotNull(yTubePlayerView6);
            yTubePlayerView6.freeMemory();
            YTubePlayerView yTubePlayerView7 = this.yTubePlayerView;
            Intrinsics.checkNotNull(yTubePlayerView7);
            yTubePlayerView7.destroy();
        }
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        String str;
        DatabaseReference databaseReferencePush;
        DatabaseReference databaseReferencePush2;
        Intrinsics.checkNotNullParameter(images, "images");
        if (images.isEmpty()) {
            return;
        }
        String file = images.get(0).getFile();
        if (file == null || !StringsKt.contains$default((CharSequence) file, (CharSequence) ".pdf", false, 2, (Object) null)) {
            str = (file == null || !StringsKt.contains$default((CharSequence) file, (CharSequence) ".mp3", false, 2, (Object) null)) ? "image" : "audio";
        } else {
            str = Const.PDF;
        }
        String str2 = str;
        try {
            Helper.closeHideKeyboard(this);
            String str3 = file;
            if (str3 != null && !StringsKt.isBlank(str3)) {
                if (!this.isintractavailable) {
                    checkintract();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.isFirebaseChat) {
                    chatPojo chatpojo = new chatPojo(MakeMyExam.userId, file, SharedPreference.getInstance().getLoggedInUser().getName(), jCurrentTimeMillis, "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", str2, this.course_id);
                    DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2one;
                    if (databaseReference != null && (databaseReferencePush2 = databaseReference.push()) != null) {
                        databaseReferencePush2.setValue(chatpojo);
                    }
                    DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferenceone2many;
                    if (databaseReference2 == null || (databaseReferencePush = databaseReference2.push()) == null) {
                        return;
                    }
                    databaseReferencePush.setValue(chatpojo);
                    return;
                }
                chatPojo chatpojo2 = new chatPojo(MakeMyExam.userId, file, SharedPreference.getInstance().getLoggedInUser().getName(), jCurrentTimeMillis, "1", str2, this.course_id);
                String json = new Gson().toJson(chatpojo2);
                Intrinsics.checkNotNull(json);
                sendMessage(json, false);
                this.arrChat.add(chatpojo2);
                ChatAdapter chatAdapter = this.chatAdapter;
                if (chatAdapter != null) {
                    chatAdapter.notifyItemInserted(this.arrChat.size() - 1);
                }
                RecyclerView recyclerView = this.recyclerChat;
                if (recyclerView != null) {
                    recyclerView.smoothScrollToPosition(this.arrChat.size() - 1);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void imgClick() {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda47
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveStreamingYoutube.imgClick$lambda$78(charSequenceArr, this, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imgClick$lambda$78(CharSequence[] charSequenceArr, LiveStreamingYoutube liveStreamingYoutube, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (Intrinsics.areEqual(charSequenceArr[i], "Take Photo")) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(liveStreamingYoutube, "com.eduteria.app.app.provider", new File(liveStreamingYoutube.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_image.jpg"));
                liveStreamingYoutube.str_imgTypeClick = "PhotoCameraRequest";
                intent.putExtra("output", uriForFile);
                liveStreamingYoutube.someActivityResultLauncher.launch(intent);
                liveStreamingYoutube.requestCode = 10000;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (Intrinsics.areEqual(charSequenceArr[i], "Choose from Gallery")) {
            Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Uri uriForFile2 = FileProvider.getUriForFile(liveStreamingYoutube, "com.eduteria.app.app.provider", new File(liveStreamingYoutube.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_gallery.jpg"));
            liveStreamingYoutube.str_imgTypeClick = "PhotoGalleryRequest";
            intent2.putExtra("output", uriForFile2);
            liveStreamingYoutube.someActivityResultLauncher.launch(intent2);
            liveStreamingYoutube.requestCode = 20000;
            return;
        }
        if (Intrinsics.areEqual(charSequenceArr[i], "Cancel")) {
            dialog.dismiss();
        }
    }

    private final String copyFileToInternalStorage(Uri uri, String newDirName) {
        File file;
        ContentResolver contentResolver = getContentResolver();
        Intrinsics.checkNotNull(uri);
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        Intrinsics.checkNotNull(cursorQuery);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        if (!Intrinsics.areEqual(newDirName, "")) {
            File file2 = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        } else {
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        }
        try {
            if (!file.exists()) {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    Intrinsics.checkNotNull(inputStreamOpenInputStream);
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                inputStreamOpenInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception unused) {
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return path;
    }

    public final void setupDoc(String selectedURI) {
        String str;
        Intrinsics.checkNotNullParameter(selectedURI, "selectedURI");
        MediaFile mediaFile = new MediaFile();
        ArrayList arrayList = new ArrayList();
        String str2 = selectedURI;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String string = getResources().getString(R.string.pdf_extension);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) string, false, 2, (Object) null)) {
            String string2 = getResources().getString(R.string.doc_extension);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) string2, false, 2, (Object) null)) {
                String string3 = getResources().getString(R.string.xls_extension);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) string3, false, 2, (Object) null)) {
                    String string4 = getResources().getString(R.string.file_format_error);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    showMessage(string4);
                    return;
                }
            }
        }
        try {
            String string5 = getResources().getString(R.string.pdf_extension);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            if (StringsKt.contains$default((CharSequence) selectedURI, (CharSequence) string5, false, 2, (Object) null)) {
                mediaFile.setImage(BitmapFactory.decodeResource(getResources(), R.mipmap.pdf));
                mediaFile.setFile_type(Const.PDF);
            }
            try {
                str = (String) CollectionsKt.last(StringsKt.split$default((CharSequence) selectedURI, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null));
            } catch (Exception unused) {
                str = "document.pdf";
            }
            mediaFile.setFile_name(Helper.sanitizeFilenameForS3(str));
            mediaFile.setFile(selectedURI);
            mediaFile.setFile_type(Const.PDF);
            arrayList.add(mediaFile);
            String str3 = this.Chat_node;
            s3ImageUploading s3imageuploading = new s3ImageUploading(str3, "vc-10000386-38616500102/application/chat_system/" + str3 + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
            this.s3IU = s3imageuploading;
            Intrinsics.checkNotNull(s3imageuploading);
            s3imageuploading.execute(arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        int i = this.REQUEST_CODE_PERMISSION_MULTIPLE;
        if (requestCode == i) {
            if (grantResults.length <= 0) {
                AppPermissionsRunTime.checkPermission(this, this.myPermissionConstantsArrayList, i);
                return;
            } else {
                int i2 = grantResults[0];
                return;
            }
        }
        if (requestCode == 10) {
            if (!(grantResults.length == 0) && grantResults[0] == 0) {
                this.seconds = 0;
                this.running = true;
                startRecording();
                return;
            }
            LinearLayout linearLayout = this.textLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            LinearLayout linearLayout2 = this.audioMainLL;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            this.isAudioRecording = false;
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6 A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:3:0x0005, B:5:0x000b, B:7:0x0029, B:8:0x0031, B:10:0x0037, B:13:0x0046, B:15:0x0056, B:17:0x0065, B:21:0x0090, B:26:0x00a2, B:28:0x00a6, B:30:0x00ba, B:18:0x007d, B:20:0x0080, B:22:0x0093, B:24:0x0096, B:14:0x0052), top: B:35:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[Catch: Exception -> 0x00ce, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ce, blocks: (B:3:0x0005, B:5:0x000b, B:7:0x0029, B:8:0x0031, B:10:0x0037, B:13:0x0046, B:15:0x0056, B:17:0x0065, B:21:0x0090, B:26:0x00a2, B:28:0x00a6, B:30:0x00ba, B:18:0x007d, B:20:0x0080, B:22:0x0093, B:24:0x0096, B:14:0x0052), top: B:35:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSeek(com.appnew.android.Model.Bookmark r6) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.onSeek(com.appnew.android.Model.Bookmark):void");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        switch (apitype.hashCode()) {
            case -2088930306:
                if (!apitype.equals(API.POST_COURSE_REVIEW)) {
                    return null;
                }
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setCourse_id(this.video_id);
                encryptionData.setRating(this.rating);
                encryptionData.setMessage(this.ratingMessage);
                encryptionData.setRating_type(Integer.valueOf(this.ratingType));
                return service.postCourseReview(AES.encrypt(new Gson().toJson(encryptionData)));
            case -1548568073:
                if (!apitype.equals(API.delete_video_index)) {
                    return null;
                }
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setIndex_id(this.deletedindex);
                return service.deletevideoindex(AES.encrypt(new Gson().toJson(encryptionData2)));
            case -1466062523:
                if (!apitype.equals(API.createPoll)) {
                    return null;
                }
                EncryptionData encryptionData3 = new EncryptionData();
                int i = 0;
                encryptionData3.setOption_1(this.optionList.get(0).getAnswer());
                encryptionData3.setOption_2(this.optionList.get(1).getAnswer());
                this.pollOption1 = this.optionList.get(0).getAnswer();
                this.pollOption2 = this.optionList.get(1).getAnswer();
                int size = this.optionList.size();
                if (size == 3) {
                    encryptionData3.setOption_3(this.optionList.get(2).getAnswer());
                    this.pollOption3 = this.optionList.get(2).getAnswer();
                } else if (size == 4) {
                    encryptionData3.setOption_3(this.optionList.get(2).getAnswer());
                    encryptionData3.setOption_4(this.optionList.get(3).getAnswer());
                    this.pollOption3 = this.optionList.get(2).getAnswer();
                    this.pollOption4 = this.optionList.get(3).getAnswer();
                } else if (size == 5) {
                    encryptionData3.setOption_3(this.optionList.get(2).getAnswer());
                    encryptionData3.setOption_4(this.optionList.get(3).getAnswer());
                    encryptionData3.setOption_5(this.optionList.get(4).getAnswer());
                    this.pollOption3 = this.optionList.get(2).getAnswer();
                    this.pollOption4 = this.optionList.get(3).getAnswer();
                    this.pollOption5 = this.optionList.get(4).getAnswer();
                } else if (size == 6) {
                    encryptionData3.setOption_3(this.optionList.get(2).getAnswer());
                    encryptionData3.setOption_4(this.optionList.get(3).getAnswer());
                    encryptionData3.setOption_5(this.optionList.get(4).getAnswer());
                    encryptionData3.setOption_6(this.optionList.get(5).getAnswer());
                    this.pollOption3 = this.optionList.get(2).getAnswer();
                    this.pollOption4 = this.optionList.get(3).getAnswer();
                    this.pollOption5 = this.optionList.get(4).getAnswer();
                    this.pollOption6 = this.optionList.get(5).getAnswer();
                }
                EditText editText = this.enterQuestionET;
                Intrinsics.checkNotNull(editText);
                encryptionData3.setQuestion(editText.getText().toString());
                EditText editText2 = this.enterDelayET;
                Intrinsics.checkNotNull(editText2);
                encryptionData3.setDelay(editText2.getText().toString());
                TextView textView = this.enterTimeET;
                Intrinsics.checkNotNull(textView);
                if (!TextUtils.isEmpty(textView.getText().toString())) {
                    TextView textView2 = this.enterTimeET;
                    Intrinsics.checkNotNull(textView2);
                    encryptionData3.setValidity(String.valueOf(Integer.parseInt((String) StringsKt.split$default((CharSequence) textView2.getText().toString(), new String[]{" "}, false, 0, 6, (Object) null).get(0))));
                }
                TextView textView3 = this.enterTimeET;
                Intrinsics.checkNotNull(textView3);
                this.pollValidity = String.valueOf(Integer.parseInt((String) StringsKt.split$default((CharSequence) textView3.getText().toString(), new String[]{" "}, false, 0, 6, (Object) null).get(0)));
                encryptionData3.setVideo_id(this.video_id);
                int size2 = this.optionList.size();
                while (true) {
                    if (i < size2) {
                        if (this.optionList.get(i).isThisAnswerRight()) {
                            int i2 = i + 1;
                            encryptionData3.setAnswer(String.valueOf(i2));
                            this.pollAnswer = String.valueOf(i2);
                        } else {
                            i++;
                        }
                    }
                }
                return service.createPoll(AES.encrypt(new Gson().toJson(encryptionData3)));
            case -1423837165:
                if (!apitype.equals(API.add_video_index)) {
                    return null;
                }
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setVideo_id(this.video_id);
                encryptionData4.setTime(this.time);
                encryptionData4.setInfo(this.info);
                return service.addvideoindex(AES.encrypt(new Gson().toJson(encryptionData4)));
            case -1175877907:
                if (!apitype.equals(API.user_video_view_data)) {
                    return null;
                }
                this.endtime = System.currentTimeMillis();
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setUser_id(MakeMyExam.getUserId());
                encryptionData5.setVideo_id(this.video_id);
                encryptionData5.setCourse_id(this.course_id);
                encryptionData5.setTile_id(TextUtils.isEmpty(this.tileid) ? "0" : this.tileid);
                encryptionData5.setType(this.islive);
                encryptionData5.setTotal_time(String.valueOf(this.totaltime));
                encryptionData5.setPlatform("android");
                encryptionData5.setRemaining_time("0");
                encryptionData5.setEnd_time(String.valueOf(this.endtime));
                encryptionData5.setStart_time(this.starttime.toString());
                encryptionData5.setView_time(String.valueOf((this.endtime - Long.parseLong(this.starttime)) / ((long) 1000)));
                String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData5));
                this.starttime = "0";
                return service.user_video_view_data(strEncrypt);
            case -1124739567:
                if (!apitype.equals(API.get_meta)) {
                    return null;
                }
                EncryptionData encryptionData6 = new EncryptionData();
                encryptionData6.setUser_id(MakeMyExam.getUserId());
                encryptionData6.setToken(this.video_id);
                encryptionData6.setCourse_id(this.course_id);
                return service.getmetaData(AES.encrypt(new Gson().toJson(encryptionData6)));
            case 396963597:
                if (!apitype.equals(API.MARK_READ_VIDEO_TYPE_1_7)) {
                    return null;
                }
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setVideo_id(this.video_id);
                encryptionData7.setCourse_id(this.course_id);
                return service.markReadVideoType1_7(AES.encrypt(new Gson().toJson(encryptionData7)));
            case 551901514:
                if (!apitype.equals("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source")) {
                    return null;
                }
                EncryptionData encryptionData8 = new EncryptionData();
                encryptionData8.setName(this.video_id + "_0_0");
                encryptionData8.setCourse_id(this.course_id);
                encryptionData8.setTile_id(this.tileid);
                encryptionData8.setType(this.tiletype);
                return service.getVideoLink(AES.encrypt(new Gson().toJson(encryptionData8)));
            case 689906520:
                if (!apitype.equals(API.API_ADD_TO_BOOKMARK)) {
                    return null;
                }
                EncryptionData encryptionData9 = new EncryptionData();
                encryptionData9.setContent_id(this.video_id);
                encryptionData9.setIs_unbookmarked(this.bookmarkState);
                encryptionData9.setContent_type("3");
                return service.addPdfBookMark(AES.encrypt(new Gson().toJson(encryptionData9)));
            case 2035937690:
                if (!apitype.equals(API.get_video_logging)) {
                    return null;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.endtime = jCurrentTimeMillis;
                long j = (jCurrentTimeMillis - this.currentTime) / ((long) 1000);
                EncryptionData encryptionData10 = new EncryptionData();
                encryptionData10.setVideo_id(this.video_id);
                encryptionData10.setEnd_time(String.valueOf(j));
                return service.get_video_logging(AES.encrypt(new Gson().toJson(encryptionData10)));
            default:
                return null;
        }
    }

    public final XmppManager getXmppManager() {
        XmppManager xmppManager = this.xmppManager;
        if (xmppManager != null) {
            return xmppManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("xmppManager");
        return null;
    }

    public final void setXmppManager(XmppManager xmppManager) {
        Intrinsics.checkNotNullParameter(xmppManager, "<set-?>");
        this.xmppManager = xmppManager;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.appnew.android.player.LiveStreamingYoutube] */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43, types: [int] */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [int] */
    /* JADX WARN: Type inference failed for: r6v13 */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        ImageView imageView;
        int i;
        NestedScrollView nestedScrollView;
        ?? r11;
        boolean z;
        ArrayList<AttemptedUserPoll> arrayList;
        ArrayList<Polldata> arrayList2;
        ArrayList<AttemptedUserPoll> arrayList3;
        String answer;
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        try {
            switch (apitype.hashCode()) {
                case -2088930306:
                    if (apitype.equals(API.POST_COURSE_REVIEW)) {
                        if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                            this.isReviewSubmitted = true;
                            ImageView imageView2 = this.video_feedback;
                            if (imageView2 != null && imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.video_feedback) != null) {
                                imageView.setImageResource(this.isReviewSubmitted ? R.drawable.review_fill : R.drawable.review_unfill);
                                Unit unit = Unit.INSTANCE;
                            }
                            feedbackDialogDismiss(true);
                        } else {
                            feedbackDialogDismiss(false);
                            showMessage((jsonstring.has("message") ? jsonstring.getString("message") : getResources().getString(R.string.something_went_wrong)));
                            RetrofitResponse.GetApiData((Context) this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
                        }
                        break;
                    }
                    break;
                case -1548568073:
                    if (apitype.equals(API.delete_video_index)) {
                        if (StringsKt.equals(jsonstring.getString("status"), "true", true)) {
                            this.bookmarkdata.remove(this.pos);
                            BookmarkAdapter bookmarkAdapter = this.bookmarkAdapter;
                            Intrinsics.checkNotNull(bookmarkAdapter);
                            bookmarkAdapter.notifyDataSetChanged();
                        } else {
                            String string = jsonstring.getString("message");
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            ErrorCallBack(string, apitype, typeApi);
                            RetrofitResponse.GetApiData((Context) this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
                        }
                        break;
                    }
                    break;
                case -1466062523:
                    if (apitype.equals(API.createPoll)) {
                        try {
                            if (jsonstring.optBoolean("status")) {
                                if (this.isOperator) {
                                    RelativeLayout relativeLayout = this.addPoll;
                                    Intrinsics.checkNotNull(relativeLayout);
                                    relativeLayout.setVisibility(8);
                                    RelativeLayout relativeLayout2 = this.createPoll;
                                    Intrinsics.checkNotNull(relativeLayout2);
                                    relativeLayout2.setVisibility(0);
                                    TextView textView = this.generateLeaderboard;
                                    Intrinsics.checkNotNull(textView);
                                    textView.setVisibility((this.isFirebaseChat || !Helper.isGenerateLeaderboardEnabled()) ? 8 : 0);
                                    i = 8;
                                } else {
                                    RelativeLayout relativeLayout3 = this.addPoll;
                                    Intrinsics.checkNotNull(relativeLayout3);
                                    i = 8;
                                    relativeLayout3.setVisibility(8);
                                    RelativeLayout relativeLayout4 = this.createPoll;
                                    Intrinsics.checkNotNull(relativeLayout4);
                                    relativeLayout4.setVisibility(8);
                                    TextView textView2 = this.generateLeaderboard;
                                    Intrinsics.checkNotNull(textView2);
                                    textView2.setVisibility(8);
                                }
                                TextView textView3 = this.viewLeaderboard;
                                Intrinsics.checkNotNull(textView3);
                                textView3.setVisibility((this.isFirebaseChat || this.pollarraylist.isEmpty() || !this.isShowViewAllLeaderBoard) ? i : 0);
                                TextView textView4 = this.enterTimeET;
                                Intrinsics.checkNotNull(textView4);
                                textView4.setText(this.defaultTimeDuration);
                                RecyclerView recyclerView = this.recylerViewPollOperator;
                                Intrinsics.checkNotNull(recyclerView);
                                recyclerView.setVisibility(0);
                                if (this.isUserOnPoll && (nestedScrollView = this.createPollNestedScrollView) != null) {
                                    Intrinsics.checkNotNull(nestedScrollView);
                                    nestedScrollView.post(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda65
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            LiveStreamingYoutube.SuccessCallBack$lambda$81(this.f$0);
                                        }
                                    });
                                }
                                if (jsonstring.has("data")) {
                                    JSONObject jSONObjectOptJSONObject = jsonstring.optJSONObject("data");
                                    Intrinsics.checkNotNull(jSONObjectOptJSONObject);
                                    if (jSONObjectOptJSONObject.has("poll_id")) {
                                        this.pollId = jSONObjectOptJSONObject.optString("poll_id");
                                    }
                                    if (jSONObjectOptJSONObject.has("poll_key")) {
                                        this.pollKey = jSONObjectOptJSONObject.optString("poll_key");
                                    }
                                    if (jSONObjectOptJSONObject.has("delay")) {
                                        this.pollDelay = jSONObjectOptJSONObject.optString("delay");
                                    }
                                    createPollDataWithId(this.pollKey, this.pollId, jsonstring);
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                        break;
                    }
                    break;
                case -1423837165:
                    if (apitype.equals(API.add_video_index)) {
                        try {
                            if (StringsKt.equals(jsonstring.getString("status"), "true", true)) {
                                Addindex addindex = (Addindex) new Gson().fromJson(jsonstring.toString(), Addindex.class);
                                List<VideoTimeFramePojo> list = this.bookmarkdata;
                                VideoTimeFramePojo data = addindex.getData();
                                Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                                list.add(data);
                                BookmarkAdapter bookmarkAdapter2 = this.bookmarkAdapter;
                                Intrinsics.checkNotNull(bookmarkAdapter2);
                                bookmarkAdapter2.notifyItemChanged(this.bookmarkdata.size());
                                PlayerView playerView = this.playerView;
                                Intrinsics.checkNotNull(playerView);
                                if (playerView.getPlayer() != null) {
                                    PlayerView playerView2 = this.playerView;
                                    Intrinsics.checkNotNull(playerView2);
                                    Player player = playerView2.getPlayer();
                                    Intrinsics.checkNotNull(player);
                                    if (player.getPlaybackState() == 3) {
                                        PlayerView playerView3 = this.playerView;
                                        Intrinsics.checkNotNull(playerView3);
                                        Player player2 = playerView3.getPlayer();
                                        Intrinsics.checkNotNull(player2);
                                        player2.setPlayWhenReady(true);
                                    }
                                }
                            } else {
                                RetrofitResponse.GetApiData((Context) this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                        break;
                    }
                    break;
                case -1175877907:
                    apitype.equals(API.user_video_view_data);
                    break;
                case -1124739567:
                    if (apitype.equals(API.get_meta)) {
                        try {
                            if (StringsKt.equals(jsonstring.getString("status"), "true", true)) {
                                com.appnew.android.Model.PlayerPojo.Metadata metadata = (com.appnew.android.Model.PlayerPojo.Metadata) new Gson().fromJson(jsonstring.toString(), com.appnew.android.Model.PlayerPojo.Metadata.class);
                                List<VideoTimeFramePojo> list2 = this.indexdata;
                                List<VideoTimeFramePojo> index = metadata.getData().getIndex();
                                Intrinsics.checkNotNullExpressionValue(index, "getIndex(...)");
                                list2.addAll(index);
                                List<VideoTimeFramePojo> list3 = this.bookmarkdata;
                                List<VideoTimeFramePojo> bookmark = metadata.getData().getBookmark();
                                Intrinsics.checkNotNullExpressionValue(bookmark, "getBookmark(...)");
                                list3.addAll(bookmark);
                                List<Pdf> list4 = this.pdf;
                                List<Pdf> pdf = metadata.getData().getPdf();
                                Intrinsics.checkNotNullExpressionValue(pdf, "getPdf(...)");
                                list4.addAll(pdf);
                                this.pollarraylist.addAll(metadata.getData().getPoll());
                                Collections.reverse(this.pollarraylist);
                                long j = 1000;
                                long jCurrentTimeMillis = System.currentTimeMillis() / j;
                                if (metadata != null && metadata.getData() != null) {
                                    this.isReviewSubmitted = metadata.getData().getReview_sumbitted() != null && StringsKt.equals(metadata.getData().getReview_sumbitted(), "1", true);
                                    if (metadata.getData().getFeedback_min_watch_time() != null && !TextUtils.isEmpty(metadata.getData().getFeedback_min_watch_time()) && !metadata.getData().getFeedback_min_watch_time().equals(com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID)) {
                                        String feedback_min_watch_time = metadata.getData().getFeedback_min_watch_time();
                                        Intrinsics.checkNotNullExpressionValue(feedback_min_watch_time, "getFeedback_min_watch_time(...)");
                                        this.FEEDBACK_MIN_WATCH_TIME = Long.parseLong(feedback_min_watch_time) * j;
                                    }
                                    if (metadata.getData().getFeedback_auto_trigger_time() != null && !TextUtils.isEmpty(metadata.getData().getFeedback_auto_trigger_time()) && !metadata.getData().getFeedback_auto_trigger_time().equals(com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID)) {
                                        String feedback_auto_trigger_time = metadata.getData().getFeedback_auto_trigger_time();
                                        Intrinsics.checkNotNullExpressionValue(feedback_auto_trigger_time, "getFeedback_auto_trigger_time(...)");
                                        this.FEEDBACK_AUTO_TRIGGER_TIME = Long.parseLong(feedback_auto_trigger_time) * j;
                                    }
                                }
                                this.activityStartTime = System.currentTimeMillis();
                                if (this.FEEDBACK_AUTO_TRIGGER_TIME > 0) {
                                    startAutoFeedbackTimer();
                                }
                                manageFeedbackButton();
                                if (metadata != null && metadata.getData() != null) {
                                    this.extraParam = metadata.getData();
                                }
                                if (metadata != null && metadata.getData() != null && metadata.getData().getLive_chat() != null) {
                                    this.liveChat = metadata.getData().getLive_chat();
                                    this.isFirebaseChat = metadata.getData().getLive_chat().getIs_firebase() != null && StringsKt.equals(metadata.getData().getLive_chat().getIs_firebase(), "1", true);
                                    this.isShowViewAllLeaderBoard = metadata.getData().getLive_chat().getVideo_wise_leaderboard() != null && StringsKt.equals(metadata.getData().getLive_chat().getVideo_wise_leaderboard(), "1", true);
                                }
                                if (this.isFirebaseChat && (arrayList = this.userList) != null && (!arrayList.isEmpty()) && (arrayList2 = this.pollarraylist) != null && !arrayList2.isEmpty() && (arrayList3 = this.userList) != null && !arrayList3.isEmpty()) {
                                    ArrayList<AttemptedUserPoll> arrayList4 = this.userList;
                                    Intrinsics.checkNotNull(arrayList4);
                                    ArrayList<AttemptedUserPoll> arrayList5 = arrayList4;
                                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                                    Iterator it = arrayList5.iterator();
                                    while (it.hasNext()) {
                                        arrayList6.add(((AttemptedUserPoll) it.next()).getPollkey());
                                    }
                                    Set set = CollectionsKt.toSet(arrayList6);
                                    ArrayList<AttemptedUserPoll> arrayList7 = this.userList;
                                    Intrinsics.checkNotNull(arrayList7);
                                    ArrayList<AttemptedUserPoll> arrayList8 = arrayList7;
                                    ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
                                    Iterator it2 = arrayList8.iterator();
                                    while (it2.hasNext()) {
                                        arrayList9.add(((AttemptedUserPoll) it2.next()).getCurrentUserID());
                                    }
                                    Set set2 = CollectionsKt.toSet(arrayList9);
                                    for (Polldata polldata : this.pollarraylist) {
                                        if (polldata != null) {
                                            if (set.contains(polldata.getRendomkey()) && set2.contains(MakeMyExam.userId)) {
                                                polldata.setMyAnswer("1");
                                            }
                                            String validTill = polldata.getValidTill();
                                            Intrinsics.checkNotNullExpressionValue(validTill, "getValidTill(...)");
                                            if (Long.parseLong(validTill) < jCurrentTimeMillis && (answer = polldata.getAnswer()) != null && answer.length() != 0 && !polldata.getAnswer().equals("0") && set.contains(polldata.getRendomkey())) {
                                                SharedPreferencePoll.getInstance((Context) this).removeItemByRandomKey(polldata.getRendomkey());
                                            }
                                            Unit unit2 = Unit.INSTANCE;
                                            Unit unit3 = Unit.INSTANCE;
                                        }
                                    }
                                }
                                showReactButton(!this.isFirebaseChat);
                                if (!TextUtils.isEmpty(metadata.getData().getVideo().getP_chat_user())) {
                                    this.videoAdmin = metadata.getData().getVideo().getP_chat_user();
                                    String p_chat_user = metadata.getData().getVideo().getP_chat_user();
                                    Intrinsics.checkNotNullExpressionValue(p_chat_user, "getP_chat_user(...)");
                                    this.isOperator = ArraysKt.contains((String[]) StringsKt.split$default((CharSequence) p_chat_user, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null).toArray(new String[0]), MakeMyExam.getUserId());
                                }
                                if (this.isOperator) {
                                    if (this.isFirebaseChat) {
                                        this.islocked = "1";
                                    }
                                    this.isPublicChatEnabled = true;
                                } else {
                                    if (this.isFirebaseChat) {
                                        this.islocked = metadata.getData().getVideo().getData().getPublic_chat().toString();
                                    }
                                    this.isPublicChatEnabled = metadata.getData().getVideo().getData().getPublic_chat() != null && StringsKt.equals(metadata.getData().getVideo().getData().getPublic_chat(), "1", true);
                                }
                                if (StringsKt.equals(this.islive, "4", true) && StringsKt.equals(this.isaudio, "0", true)) {
                                    setpollAdapter();
                                    completeclass();
                                    if (this.isFirebaseChat) {
                                        fireBaseOperation();
                                    } else {
                                        connectToServer();
                                    }
                                    int i2 = this.pdf.size() == 0 ? 0 : 1;
                                    setLiveChat();
                                    z = true;
                                    r11 = false;
                                    isvisiblelayouts(1, 0, 0, 1, i2, 0, !this.isFirebaseChat ? 1 : 0);
                                } else {
                                    r11 = false;
                                    z = true;
                                }
                                if (metadata.getData().getVideo().getVideo_length() != null && !TextUtils.isEmpty(metadata.getData().getVideo().getVideo_length())) {
                                    String video_length = metadata.getData().getVideo().getVideo_length();
                                    Intrinsics.checkNotNullExpressionValue(video_length, "getVideo_length(...)");
                                    this.totaltime = Long.parseLong(video_length);
                                }
                                if ((StringsKt.equals(this.islive, "1", z) || StringsKt.equals(this.islive, "5", z)) && StringsKt.equals(this.isaudio, "0", z)) {
                                    ?? r6 = this.pdf.size() == 0 ? r11 : z;
                                    ?? r3 = this.indexdata.size() == 0 ? r11 : z;
                                    if (metadata.getData().getVideo().getData().getVod_chat() == null || !StringsKt.equals(metadata.getData().getVideo().getData().getVod_chat(), "1", z)) {
                                        LinearLayout linearLayout = this.linearLayout;
                                        Intrinsics.checkNotNull(linearLayout);
                                        linearLayout.setVisibility(8);
                                        isvisiblelayouts(0, r3, 0, 0, r6, 0, 0);
                                        if (r6 == z) {
                                            setNotes();
                                        }
                                    } else {
                                        setpollAdapter();
                                        if (this.isFirebaseChat) {
                                            fireBaseOperation();
                                        } else {
                                            connectToServer();
                                        }
                                        setvodchat();
                                        isvisiblelayouts(0, r3, 0, 0, r6, 1, 0);
                                    }
                                }
                                if (StringsKt.equals(this.isaudio, "1", z)) {
                                    LinearLayout linearLayout2 = this.linearLayout;
                                    Intrinsics.checkNotNull(linearLayout2);
                                    linearLayout2.setVisibility(8);
                                    isvisiblelayouts(0, 0, 0, 0, 0, 0, 0);
                                }
                            } else {
                                RetrofitResponse.GetApiData((Context) this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            isvisiblelayouts(0, 0, 0, 0, 0, 0, 0);
                            return;
                        }
                        break;
                    }
                    break;
                case 396963597:
                    if (apitype.equals(API.MARK_READ_VIDEO_TYPE_1_7)) {
                        if (jsonstring.optString("status").equals("true")) {
                            this.isVideoReadMarked = true;
                            checkMarkUnmark();
                            SharedPreference.getInstance().putBoolean(Const.MARK_AS_READ, true);
                        } else {
                            this.isVideoReadMarked = false;
                            checkMarkUnmark();
                            showMessage(jsonstring.getString("message"));
                        }
                        break;
                    }
                    break;
                case 551901514:
                    if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source")) {
                        if (StringsKt.equals(jsonstring.getString("status"), "true", true)) {
                            JSONObject jSONObject = new JSONObject(jsonstring.toString());
                            if (jSONObject.has("data")) {
                                String string2 = jSONObject.getJSONObject("data").getString("link");
                                this.link = string2;
                                this.thumbnailurl = "http://img.youtube.com/vi/" + string2 + "/0.jpg";
                                if (StringsKt.equals(this.isaudio, "1", true)) {
                                    new Thread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda67
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            LiveStreamingYoutube.SuccessCallBack$lambda$86(this.f$0);
                                        }
                                    }).start();
                                }
                            } else {
                                String string3 = getResources().getString(R.string.url_is_not_found);
                                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                showMessage(string3);
                            }
                        } else {
                            String string4 = jsonstring.getString("message");
                            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                            ErrorCallBack(string4, apitype, typeApi);
                            RetrofitResponse.GetApiData((Context) this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
                        }
                        break;
                    }
                    break;
                case 689906520:
                    if (apitype.equals(API.API_ADD_TO_BOOKMARK)) {
                        if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                            String strOptString = jsonstring.optString("message");
                            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                            showMessage(strOptString);
                        } else {
                            String string5 = jsonstring.getString("message");
                            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                            ErrorCallBack(string5, apitype, typeApi);
                            RetrofitResponse.GetApiData((Context) this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
                        }
                        break;
                    }
                    break;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$81(LiveStreamingYoutube liveStreamingYoutube) {
        NestedScrollView nestedScrollView = liveStreamingYoutube.createPollNestedScrollView;
        Intrinsics.checkNotNull(nestedScrollView);
        nestedScrollView.smoothScrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$86(LiveStreamingYoutube liveStreamingYoutube) {
        try {
            liveStreamingYoutube.image = BitmapFactory.decodeStream(new URL(liveStreamingYoutube.thumbnailurl).openConnection().getInputStream());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final DatabaseReference getRootRefcompleteclass() {
        return this.rootRefcompleteclass;
    }

    public final void setRootRefcompleteclass(DatabaseReference databaseReference) {
        this.rootRefcompleteclass = databaseReference;
    }

    public final ChildEventListener getChildEventListenercompleteclass() {
        return this.childEventListenercompleteclass;
    }

    public final void setChildEventListenercompleteclass(ChildEventListener childEventListener) {
        this.childEventListenercompleteclass = childEventListener;
    }

    public final void completeclass() {
        this.rootRefcompleteclass = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/completevideo/");
        this.childEventListenercompleteclass = new ChildEventListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.completeclass.1
            @Override // com.google.firebase.database.ChildEventListener
            public void onCancelled(DatabaseError databaseError) {
                Intrinsics.checkNotNullParameter(databaseError, "databaseError");
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Long l;
                OnDataSendListener onDataSendListener;
                Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                try {
                    if (StringsKt.equals(dataSnapshot.getKey(), "offline_status", true) && (l = (Long) dataSnapshot.getValue()) != null && l.longValue() == 0) {
                        com.appnew.android.home.Constants.REFRESHPAGE = "true";
                        com.appnew.android.home.Constants.REFRESHPAGENEW = "true";
                        com.appnew.android.home.Constants.revison_set = true;
                        if (LiveStreamingYoutube.this.getIsUserActive() && LiveStreamingYoutube.dataSendListener != null && !LiveStreamingYoutube.this.getIsOperator() && !LiveStreamingYoutube.this.getIsReviewSubmitted() && LiveStreamingYoutube.this.isShowFeedback() && (onDataSendListener = LiveStreamingYoutube.dataSendListener) != null) {
                            onDataSendListener.onDataSent(l.longValue(), String.valueOf(LiveStreamingYoutube.this.getVideo_id()), null, 3);
                        }
                        Log.e("TAG_APP", "autoplayNextVideo: 3 " + LiveStreamingYoutube.this.getVideo_id());
                        LiveStreamingYoutube.this.finish();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                OnDataSendListener onDataSendListener;
                Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                try {
                    if (StringsKt.equals(dataSnapshot.getKey(), "offline_status", true)) {
                        Long l = (Long) dataSnapshot.getValue();
                        Log.e("TAG_APP", "autoplayNextVideo: 4");
                        if (l != null && l.longValue() == 0) {
                            com.appnew.android.home.Constants.REFRESHPAGE = "true";
                            com.appnew.android.home.Constants.REFRESHPAGENEW = "true";
                            com.appnew.android.home.Constants.revison_set = true;
                            if (LiveStreamingYoutube.this.getIsUserActive() && LiveStreamingYoutube.dataSendListener != null && !LiveStreamingYoutube.this.getIsOperator() && !LiveStreamingYoutube.this.getIsReviewSubmitted() && LiveStreamingYoutube.this.isShowFeedback() && (onDataSendListener = LiveStreamingYoutube.dataSendListener) != null) {
                                onDataSendListener.onDataSent(l.longValue(), String.valueOf(LiveStreamingYoutube.this.getVideo_id()), null, 3);
                            }
                            Log.e("TAG_APP", "autoplayNextVideo: 5");
                            LiveStreamingYoutube.this.finish();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        DatabaseReference databaseReference = this.rootRefcompleteclass;
        Intrinsics.checkNotNull(databaseReference);
        ChildEventListener childEventListener = this.childEventListenercompleteclass;
        Intrinsics.checkNotNull(childEventListener);
        databaseReference.addChildEventListener(childEventListener);
    }

    public final void callPauseWebview() {
        String str = this.islive;
        if (str == null || TextUtils.isEmpty(str) || !StringsKt.equals(this.islive, "4", true)) {
            StringsKt.equals(SharedPreference.getInstance().getString(Const.IS_EXOPLAYER), "1", true);
        }
    }

    private final void setIndex() {
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        RelativeLayout relativeLayout = this.goToCurrentRl;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
        RelativeLayout relativeLayout2 = this.refressDoubtRl;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setVisibility(8);
        setChatSettingUi(false);
        LinearLayout linearLayout = this.forDoubtll;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        TextView textView = this.unpublishtxt;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(8);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        this.isclicked = "3";
        TextView textView2 = this.addBookmark;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(8);
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(0);
        RelativeLayout relativeLayout3 = this.rl_pdf_data;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.setVisibility(8);
        LinearLayout linearLayout2 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(8);
        RecyclerView recyclerView2 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        setAdapter();
        LinearLayout linearLayout3 = this.llEnableMarkAsRead;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    public final void setVideoTimeMS(int timeMS) {
        PlayerView playerView = this.playerView;
        Intrinsics.checkNotNull(playerView);
        if (playerView.getPlayer() != null) {
            PlayerView playerView2 = this.playerView;
            Intrinsics.checkNotNull(playerView2);
            Player player = playerView2.getPlayer();
            Intrinsics.checkNotNull(player);
            player.seekTo(timeMS);
            return;
        }
        String string = getResources().getString(R.string.please_wait_player_is_not_ready);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        showMessage(string);
    }

    public final void disableAll() {
        TextView textView = this.pinChat;
        Intrinsics.checkNotNull(textView);
        textView.setBackgroundColor(getResources().getColor(R.color.off_white));
        if (StringsKt.equals(this.isclicked, "1", true) || StringsKt.equals(this.isclicked, "6", true)) {
            String str = this.is_ved_live;
            if (str != null && !TextUtils.isEmpty(str) && StringsKt.equals(this.is_ved_live, "1", true)) {
                LeftMenu leftMenu = this.leftMenu;
                if (leftMenu != null) {
                    Intrinsics.checkNotNull(leftMenu);
                    if (leftMenu.getChatPinUnPin() != null) {
                        LeftMenu leftMenu2 = this.leftMenu;
                        Intrinsics.checkNotNull(leftMenu2);
                        if (StringsKt.equals(leftMenu2.getChatPinUnPin(), "1", true)) {
                            TextView textView2 = this.pinChat;
                            Intrinsics.checkNotNull(textView2);
                            textView2.setVisibility(0);
                            LinearLayout linearLayout = this.pinll;
                            Intrinsics.checkNotNull(linearLayout);
                            linearLayout.setVisibility(0);
                            return;
                        }
                    }
                    TextView textView3 = this.pinChat;
                    Intrinsics.checkNotNull(textView3);
                    textView3.setVisibility(8);
                    LinearLayout linearLayout2 = this.pinll;
                    Intrinsics.checkNotNull(linearLayout2);
                    linearLayout2.setVisibility(8);
                    return;
                }
                return;
            }
            TextView textView4 = this.pinChat;
            Intrinsics.checkNotNull(textView4);
            textView4.setVisibility(8);
            LinearLayout linearLayout3 = this.pinll;
            Intrinsics.checkNotNull(linearLayout3);
            linearLayout3.setVisibility(8);
            return;
        }
        LinearLayout linearLayout4 = this.pinll;
        Intrinsics.checkNotNull(linearLayout4);
        linearLayout4.setVisibility(8);
        TextView textView5 = this.pinChat;
        Intrinsics.checkNotNull(textView5);
        textView5.setVisibility(8);
    }

    private final void setAdapter() {
        this.adapter = new Adapter_recycleveiw_vedio(this, this.indexdata, "custom");
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setAdapter(this.adapter);
    }

    private final void setbookmarkadapter() {
        this.bookmarkAdapter = new BookmarkAdapter(this, this.bookmarkdata, "customplayer");
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setAdapter(this.bookmarkAdapter);
    }

    private final void setBookMark() {
        Video video;
        Object next;
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        RelativeLayout relativeLayout = this.goToCurrentRl;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
        RelativeLayout relativeLayout2 = this.refressDoubtRl;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setVisibility(8);
        setChatSettingUi(false);
        LinearLayout linearLayout = this.forDoubtll;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        TextView textView = this.unpublishtxt;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(8);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.pauseAudio();
        }
        this.isclicked = "2";
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(0);
        RelativeLayout relativeLayout3 = this.rl_pdf_data;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.setVisibility(8);
        RecyclerView recyclerView2 = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        LinearLayout linearLayout2 = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(0);
        disableAll();
        TextView textView2 = this.addBookmark;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(8);
        LinearLayout linearLayout3 = this.chatlayout;
        Intrinsics.checkNotNull(linearLayout3);
        linearLayout3.setVisibility(8);
        setbookmarkadapter();
        ArrayList<Video> arrayList = this.allVideosList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((Video) next).getId(), this.video_id)) {
                        break;
                    }
                }
            }
            video = (Video) next;
        } else {
            video = null;
        }
        String video_type = video != null ? video.getVideo_type() : null;
        if (video_type == null) {
            video_type = "";
        }
        if (Helper.isShowMarkAsDone(video_type) && Intrinsics.areEqual(this.isclicked, "2")) {
            LinearLayout linearLayout4 = this.llEnableMarkAsRead;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout5 = this.llEnableMarkAsRead;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
    }

    private final void setNotesAdapter() {
        this.notesAdapter = new NotesAdapter(this, this.pdf, this.course_id);
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setAdapter(this.notesAdapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void isvisiblelayouts(int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.isvisiblelayouts(int, int, int, int, int, int, int):void");
    }

    public final void setpollcount(final String pollkey, final String answer) {
        Intrinsics.checkNotNullParameter(pollkey, "pollkey");
        Intrinsics.checkNotNullParameter(answer, "answer");
        if (this.isFirebaseChat) {
            this.mFirebaseDatabaseReferencepolldata = null;
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + pollkey);
            this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
            Intrinsics.checkNotNull(databaseReferenceChild);
            databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.setpollcount.1
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                    Intrinsics.checkNotNullParameter(databaseError, "databaseError");
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                    try {
                        if (dataSnapshot.getValue() != null) {
                            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                                Intrinsics.checkNotNullExpressionValue(dataSnapshot2, "next(...)");
                                DataSnapshot dataSnapshot3 = dataSnapshot2;
                                String key = dataSnapshot3.getKey();
                                if (StringsKt.equals(answer, "1", true)) {
                                    if (StringsKt.equals(key, "attempt_1", true)) {
                                        Object value = dataSnapshot3.getValue();
                                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
                                        this.setcountincrement(((Long) value).longValue() + 1, "attempt_1");
                                    }
                                } else if (StringsKt.equals(answer, "2", true)) {
                                    if (StringsKt.equals(key, "attempt_2", true)) {
                                        Object value2 = dataSnapshot3.getValue();
                                        Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.Long");
                                        this.setcountincrement(((Long) value2).longValue() + 1, "attempt_2");
                                    }
                                } else if (StringsKt.equals(answer, "3", true)) {
                                    if (StringsKt.equals(key, "attempt_3", true)) {
                                        Object value3 = dataSnapshot3.getValue();
                                        Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Long");
                                        this.setcountincrement(((Long) value3).longValue() + 1, "attempt_3");
                                    }
                                } else if (StringsKt.equals(answer, "4", true) && StringsKt.equals(key, "attempt_4", true)) {
                                    Object value4 = dataSnapshot3.getValue();
                                    Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type kotlin.Long");
                                    this.setcountincrement(((Long) value4).longValue() + 1, "attempt_4");
                                }
                            }
                            Log.e("TAG_APP", "onDataChange: Not Attempted");
                            ArrayList<AttemptedUserPoll> userList = this.getUserList();
                            if (userList != null) {
                                userList.add(new AttemptedUserPoll(answer, pollkey, null, MakeMyExam.userId));
                            }
                            SharedPreferencePoll.getInstance(this).saveAttemptedUserPollList(this.getUserList());
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return;
        }
        sendWSMessage(updatePollDataStr(pollkey, answer, "0"), "UPDATE_POLL", "");
    }

    public final void setcountincrement(long count, String child) {
        try {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferencepolldata;
            if (databaseReference != null) {
                Intrinsics.checkNotNull(databaseReference);
                Intrinsics.checkNotNull(child);
                Intrinsics.checkNotNull(databaseReference.child(child).setValue(Long.valueOf(count)));
            } else {
                String string = getResources().getString(R.string.key_is_empty);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                showMessage(string);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void setcountincrement(long count, String child, String answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        try {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferencepolldata;
            if (databaseReference != null) {
                Intrinsics.checkNotNull(databaseReference);
                Intrinsics.checkNotNull(child);
                databaseReference.child(child).setValue(Long.valueOf(count));
                DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferencepolldata;
                Intrinsics.checkNotNull(databaseReference2);
                Intrinsics.checkNotNull(databaseReference2.child("my_answer").setValue(answer));
                return;
            }
            String string = getResources().getString(R.string.key_is_empty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showMessage(string);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void setpollcount(final String pollkey, final String answer, final SendUserData userData) {
        Intrinsics.checkNotNullParameter(pollkey, "pollkey");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(userData, "userData");
        if (this.isFirebaseChat) {
            this.mFirebaseDatabaseReferencepolldata = null;
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + pollkey);
            this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
            Intrinsics.checkNotNull(databaseReferenceChild);
            databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.setpollcount.2
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                    Intrinsics.checkNotNullParameter(databaseError, "databaseError");
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                    try {
                        if (dataSnapshot.getValue() != null) {
                            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                                Intrinsics.checkNotNullExpressionValue(dataSnapshot2, "next(...)");
                                DataSnapshot dataSnapshot3 = dataSnapshot2;
                                String key = dataSnapshot3.getKey();
                                if (StringsKt.equals(answer, "1", true)) {
                                    if (StringsKt.equals(key, "attempt_1", true)) {
                                        Object value = dataSnapshot3.getValue();
                                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
                                        this.setcountincrement(((Long) value).longValue() + 1, "attempt_1", userData);
                                    }
                                } else if (StringsKt.equals(answer, "2", true)) {
                                    if (StringsKt.equals(key, "attempt_2", true)) {
                                        Object value2 = dataSnapshot3.getValue();
                                        Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.Long");
                                        this.setcountincrement(((Long) value2).longValue() + 1, "attempt_2", userData);
                                    }
                                } else if (StringsKt.equals(answer, "3", true)) {
                                    if (StringsKt.equals(key, "attempt_3", true)) {
                                        Object value3 = dataSnapshot3.getValue();
                                        Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Long");
                                        this.setcountincrement(((Long) value3).longValue() + 1, "attempt_3", userData);
                                    }
                                } else if (StringsKt.equals(answer, "4", true) && StringsKt.equals(key, "attempt_4", true)) {
                                    Object value4 = dataSnapshot3.getValue();
                                    Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type kotlin.Long");
                                    this.setcountincrement(((Long) value4).longValue() + 1, "attempt_4", userData);
                                }
                            }
                        }
                        Log.e("TAG_APP", "onDataChange Key: " + answer + ", " + pollkey);
                        Log.e("TAG_APP", "onDataChange: re Not Attempted " + MakeMyExam.userId);
                        ArrayList<AttemptedUserPoll> userList = this.getUserList();
                        if (userList != null) {
                            userList.add(new AttemptedUserPoll(answer, pollkey, userData, MakeMyExam.userId));
                        }
                        SharedPreferencePoll.getInstance(this).saveAttemptedUserPollList(this.getUserList());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return;
        }
        sendWSMessage(updatePollDataStr(pollkey, answer, userData.getTimeleft()), "UPDATE_POLL", "");
    }

    public final void setcountincrement(long count, String child, SendUserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        try {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferencepolldata;
            if (databaseReference != null) {
                Intrinsics.checkNotNull(databaseReference);
                Intrinsics.checkNotNull(child);
                databaseReference.child(child).setValue(Long.valueOf(count));
                DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferencepolldata;
                Intrinsics.checkNotNull(databaseReference2);
                Intrinsics.checkNotNull(databaseReference2.child("users").child(MakeMyExam.userId).setValue(userData));
                return;
            }
            String string = getResources().getString(R.string.key_is_empty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showMessage(string);
        } catch (Exception e2) {
            e2.printStackTrace();
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

    public final int getPos() {
        return this.pos;
    }

    public final void setPos(int i) {
        this.pos = i;
    }

    public final void onDelete(VideoTimeFramePojo data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        String id = data.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        BookMarkDeleteApi(id, "", "", "2");
        this.pos = position;
    }

    private final void BookMarkDeleteApi(String id, String s, String s1, String s2) {
        this.deletedindex = id;
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.delete_video_index, "", false, false);
    }

    public final void showchat() {
        if (!StringsKt.equals(this.isclicked, "1", true) || getResources().getConfiguration().orientation == 2) {
            return;
        }
        LinearLayout linearLayout = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = this.chatlayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(0);
    }

    public final void hidechat() {
        if (!StringsKt.equals(this.isclicked, "1", true) || getResources().getConfiguration().orientation == 2) {
            return;
        }
        LinearLayout linearLayout = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.chatlayout;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(8);
    }

    public final float getTotal() {
        return this.total;
    }

    public final void setTotal(float f2) {
        this.total = f2;
    }

    public final float getAttempt_1_count() {
        return this.attempt_1_count;
    }

    public final void setAttempt_1_count(float f2) {
        this.attempt_1_count = f2;
    }

    public final float getAttempt_2_count() {
        return this.attempt_2_count;
    }

    public final void setAttempt_2_count(float f2) {
        this.attempt_2_count = f2;
    }

    public final float getAttempt_3_count() {
        return this.attempt_3_count;
    }

    public final void setAttempt_3_count(float f2) {
        this.attempt_3_count = f2;
    }

    public final float getAttempt_4_count() {
        return this.attempt_4_count;
    }

    public final void setAttempt_4_count(float f2) {
        this.attempt_4_count = f2;
    }

    public final void getServeyData(final Polldata polldata) {
        Intrinsics.checkNotNullParameter(polldata, "polldata");
        final HashMap map = new HashMap();
        if (this.isFirebaseChat) {
            this.mFirebaseDatabaseReferencepolldata = null;
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + polldata.getRendomkey());
            this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
            Intrinsics.checkNotNull(databaseReferenceChild);
            databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.getServeyData.1
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                    Intrinsics.checkNotNullParameter(databaseError, "databaseError");
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                    try {
                        if (dataSnapshot.getValue() != null) {
                            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                                Intrinsics.checkNotNullExpressionValue(dataSnapshot2, "next(...)");
                                DataSnapshot dataSnapshot3 = dataSnapshot2;
                                String key = dataSnapshot3.getKey();
                                if (StringsKt.equals(key, "attempt_1", true)) {
                                    LiveStreamingYoutube.this.setAttempt_1_count(Float.parseFloat(String.valueOf(dataSnapshot3.getValue())));
                                }
                                if (StringsKt.equals(key, "attempt_2", true)) {
                                    LiveStreamingYoutube.this.setAttempt_2_count(Float.parseFloat(String.valueOf(dataSnapshot3.getValue())));
                                }
                                if (StringsKt.equals(key, "attempt_3", true)) {
                                    LiveStreamingYoutube.this.setAttempt_3_count(Float.parseFloat(String.valueOf(dataSnapshot3.getValue())));
                                }
                                if (StringsKt.equals(key, "attempt_4", true)) {
                                    LiveStreamingYoutube.this.setAttempt_4_count(Float.parseFloat(String.valueOf(dataSnapshot3.getValue())));
                                }
                            }
                            LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                            liveStreamingYoutube.setTotal(liveStreamingYoutube.getAttempt_1_count() + LiveStreamingYoutube.this.getAttempt_2_count() + LiveStreamingYoutube.this.getAttempt_3_count() + LiveStreamingYoutube.this.getAttempt_4_count());
                            map.put("total", Float.valueOf(LiveStreamingYoutube.this.getTotal()));
                            if (LiveStreamingYoutube.this.getAttempt_1_count() != 0.0f) {
                                map.put("perA", Float.valueOf((LiveStreamingYoutube.this.getAttempt_1_count() / LiveStreamingYoutube.this.getTotal()) * 100));
                            } else {
                                map.put("perA", Float.valueOf(0.0f));
                            }
                            if (LiveStreamingYoutube.this.getAttempt_2_count() != 0.0f) {
                                map.put("perB", Float.valueOf((LiveStreamingYoutube.this.getAttempt_2_count() / LiveStreamingYoutube.this.getTotal()) * 100));
                            } else {
                                map.put("perB", Float.valueOf(0.0f));
                            }
                            if (LiveStreamingYoutube.this.getAttempt_3_count() != 0.0f) {
                                map.put("perC", Float.valueOf((LiveStreamingYoutube.this.getAttempt_3_count() / LiveStreamingYoutube.this.getTotal()) * 100));
                            } else {
                                map.put("perC", Float.valueOf(0.0f));
                            }
                            if (LiveStreamingYoutube.this.getAttempt_4_count() != 0.0f) {
                                map.put("perD", Float.valueOf((LiveStreamingYoutube.this.getAttempt_4_count() / LiveStreamingYoutube.this.getTotal()) * 100));
                            } else {
                                map.put("perD", Float.valueOf(0.0f));
                            }
                            if (LiveStreamingYoutube.this.getIsLandscape()) {
                                LandscapePollDialog landscapePollDialog = LiveStreamingYoutube.this.getLandscapePollDialog();
                                if (landscapePollDialog != null) {
                                    landscapePollDialog.showPollResult(polldata, map);
                                    return;
                                }
                                return;
                            }
                            if (LiveStreamingYoutube.this.getPollAdapter() != null) {
                                PollAdapter pollAdapter = LiveStreamingYoutube.this.getPollAdapter();
                                Intrinsics.checkNotNull(pollAdapter);
                                pollAdapter.SetServeyresult(polldata, map);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return;
        }
        String rendomkey = polldata.getRendomkey();
        Intrinsics.checkNotNullExpressionValue(rendomkey, "getRendomkey(...)");
        String strResultPollDataStr = resultPollDataStr(rendomkey);
        String rendomkey2 = polldata.getRendomkey();
        Intrinsics.checkNotNullExpressionValue(rendomkey2, "getRendomkey(...)");
        sendWSMessage(strResultPollDataStr, "GET_POLL", rendomkey2);
    }

    public final void setpin(chatPojo chatPojo, int pos) {
        Intrinsics.checkNotNullParameter(chatPojo, "chatPojo");
        if (this.isPublicChatEnabled) {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2many;
            if (databaseReference != null) {
                try {
                    Intrinsics.checkNotNull(databaseReference);
                    String str = this.keyset.get(pos);
                    Intrinsics.checkNotNull(str);
                    databaseReference.child(str).child("pin").setValue("1");
                    chatPojo.setPin("1");
                    ChatAdapter chatAdapter = this.chatAdapter;
                    if (chatAdapter != null) {
                        Intrinsics.checkNotNull(chatAdapter);
                        chatAdapter.notifyItemChanged(pos);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference2 != null) {
            try {
                Intrinsics.checkNotNull(databaseReference2);
                String str2 = this.keyset.get(pos);
                Intrinsics.checkNotNull(str2);
                databaseReference2.child(str2).child("pin").setValue("1");
                chatPojo.setPin("1");
                ChatAdapter chatAdapter2 = this.chatAdapter;
                if (chatAdapter2 != null) {
                    Intrinsics.checkNotNull(chatAdapter2);
                    chatAdapter2.notifyItemChanged(pos);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void setunPin(chatPojo chatPojo, int pos) {
        Intrinsics.checkNotNullParameter(chatPojo, "chatPojo");
        if (this.isPublicChatEnabled) {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2many;
            if (databaseReference != null) {
                try {
                    Intrinsics.checkNotNull(databaseReference);
                    String str = this.keyset.get(pos);
                    Intrinsics.checkNotNull(str);
                    databaseReference.child(str).child("pin").setValue("0");
                    chatPojo.setPin("0");
                    ChatAdapter chatAdapter = this.chatAdapter;
                    if (chatAdapter != null) {
                        Intrinsics.checkNotNull(chatAdapter);
                        chatAdapter.notifyItemChanged(pos);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference2 != null) {
            try {
                Intrinsics.checkNotNull(databaseReference2);
                String str2 = this.keyset.get(pos);
                Intrinsics.checkNotNull(str2);
                databaseReference2.child(str2).child("pin").setValue("0");
                chatPojo.setPin("0");
                ChatAdapter chatAdapter2 = this.chatAdapter;
                if (chatAdapter2 != null) {
                    Intrinsics.checkNotNull(chatAdapter2);
                    chatAdapter2.notifyItemChanged(pos);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private final void setUpPinChat() {
        this.pinchatList.clear();
        int size = this.arrChat.size();
        for (int i = 0; i < size; i++) {
            chatPojo chatpojo = this.arrChat.get(i);
            Intrinsics.checkNotNull(chatpojo);
            if (chatpojo.getPin() != null) {
                chatPojo chatpojo2 = this.arrChat.get(i);
                Intrinsics.checkNotNull(chatpojo2);
                if (StringsKt.equals(chatpojo2.getPin(), "1", true)) {
                    chatPojo chatpojo3 = this.arrChat.get(i);
                    Intrinsics.checkNotNull(chatpojo3);
                    if (chatpojo3.getId() != null) {
                        chatPojo chatpojo4 = this.arrChat.get(i);
                        Intrinsics.checkNotNull(chatpojo4);
                        if (StringsKt.equals(chatpojo4.getId(), MakeMyExam.userId, true)) {
                            this.pinchatList.add(this.arrChat.get(i));
                        }
                    }
                }
            }
        }
        LinearLayout linearLayout = this.linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            Intrinsics.checkNotNull(chatAdapter);
            chatAdapter.upDateData(this.pinchatList);
        }
        disableAll();
        TextView textView = this.pinChat;
        Intrinsics.checkNotNull(textView);
        textView.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        TextView textView2 = this.pinChat;
        Intrinsics.checkNotNull(textView2);
        textView2.setTextColor(getResources().getColor(android.R.color.black));
    }

    public final void deleteChat(int position) {
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference != null) {
            try {
                Intrinsics.checkNotNull(databaseReference);
                String str = this.keyset.get(position);
                Intrinsics.checkNotNull(str);
                databaseReference.child(str).removeValue();
                this.keyset.remove(position);
                this.arrChat.remove(position);
                RecyclerView recyclerView = this.recyclerChat;
                if (recyclerView != null) {
                    Intrinsics.checkNotNull(recyclerView);
                    if (recyclerView.getAdapter() != null) {
                        RecyclerView recyclerView2 = this.recyclerChat;
                        Intrinsics.checkNotNull(recyclerView2);
                        if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                            RecyclerView recyclerView3 = this.recyclerChat;
                            Intrinsics.checkNotNull(recyclerView3);
                            RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                            if (adapter != null) {
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cropImage$lambda$88(LiveStreamingYoutube liveStreamingYoutube, CropImageView.CropResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!result.isSuccessful()) {
            Log.d("TAGCropImage", "CropImage: " + result.getError());
            return;
        }
        if (StringsKt.equals(liveStreamingYoutube.str_imgTypeClick, "PhotoCameraRequest", true)) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(liveStreamingYoutube.getContentResolver(), result.getUriContent());
                String str = liveStreamingYoutube.getFilesDir() + "/Utkarsh/Profile/";
                new File(str).mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str + File.separator + (MakeMyExam.userId + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                String str2 = liveStreamingYoutube.Chat_node;
                liveStreamingYoutube.s3IU = new s3ImageUploading(str2, "vc-10000386-38616500102/application/chat_system/" + str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, liveStreamingYoutube, liveStreamingYoutube, null);
                ArrayList arrayList = new ArrayList();
                MediaFile mediaFile = new MediaFile();
                mediaFile.setFile_type("image");
                mediaFile.setImage(bitmap);
                arrayList.add(mediaFile);
                s3ImageUploading s3imageuploading = liveStreamingYoutube.s3IU;
                Intrinsics.checkNotNull(s3imageuploading);
                s3imageuploading.execute(arrayList);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                Unit unit = Unit.INSTANCE;
                return;
            }
        }
        if (StringsKt.equals(liveStreamingYoutube.str_imgTypeClick, "PhotoGalleryRequest", true)) {
            try {
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(liveStreamingYoutube.getContentResolver(), result.getUriContent());
                String str3 = liveStreamingYoutube.getFilesDir() + "/utkarsh/ProfileImage/";
                new File(str3).mkdirs();
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str3 + File.separator + (MakeMyExam.userId + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream2);
                fileOutputStream2.flush();
                fileOutputStream2.close();
                String str4 = liveStreamingYoutube.Chat_node;
                liveStreamingYoutube.s3IU = new s3ImageUploading(str4, "vc-10000386-38616500102/application/chat_system/" + str4 + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, liveStreamingYoutube, liveStreamingYoutube, null);
                ArrayList arrayList2 = new ArrayList();
                MediaFile mediaFile2 = new MediaFile();
                mediaFile2.setFile_type("image");
                mediaFile2.setImage(bitmap2);
                arrayList2.add(mediaFile2);
                s3ImageUploading s3imageuploading2 = liveStreamingYoutube.s3IU;
                Intrinsics.checkNotNull(s3imageuploading2);
                s3imageuploading2.execute(arrayList2);
            } catch (IOException e3) {
                e3.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final ActivityResultLauncher<Intent> getSomeActivityResultLauncher() {
        return this.someActivityResultLauncher;
    }

    public final void setSomeActivityResultLauncher(ActivityResultLauncher<Intent> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "<set-?>");
        this.someActivityResultLauncher = activityResultLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void someActivityResultLauncher$lambda$89(LiveStreamingYoutube liveStreamingYoutube, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            if (liveStreamingYoutube.requestCode == 10000 && result.getResultCode() == -1) {
                try {
                    File file = new File(String.valueOf(liveStreamingYoutube.getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
                    Iterator it = ArrayIteratorKt.iterator(file.listFiles());
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        File file2 = (File) next;
                        if (Intrinsics.areEqual(file2.getName(), "temp_image.jpg")) {
                            file = file2;
                            break;
                        }
                    }
                    Uri uriForFile = FileProvider.getUriForFile(liveStreamingYoutube, "com.eduteria.app.app.provider", file);
                    ActivityResultLauncher<CropImageContractOptions> activityResultLauncher = liveStreamingYoutube.cropImage;
                    CropImageOptions cropImageOptions = Helper.cropImageOptions(liveStreamingYoutube);
                    Intrinsics.checkNotNullExpressionValue(cropImageOptions, "cropImageOptions(...)");
                    activityResultLauncher.launch(new CropImageContractOptions(uriForFile, cropImageOptions));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (liveStreamingYoutube.requestCode == 20000 && result.getResultCode() == -1) {
                try {
                    Intent data = result.getData();
                    Intrinsics.checkNotNull(data);
                    Uri data2 = data.getData();
                    ActivityResultLauncher<CropImageContractOptions> activityResultLauncher2 = liveStreamingYoutube.cropImage;
                    CropImageOptions cropImageOptions2 = Helper.cropImageOptions(liveStreamingYoutube);
                    Intrinsics.checkNotNullExpressionValue(cropImageOptions2, "cropImageOptions(...)");
                    activityResultLauncher2.launch(new CropImageContractOptions(data2, cropImageOptions2));
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (liveStreamingYoutube.requestCode == 101 && result.getResultCode() == -1 && result.getData() != null) {
                if (Build.VERSION.SDK_INT >= 30) {
                    Intent data3 = result.getData();
                    Intrinsics.checkNotNull(data3);
                    Uri data4 = data3.getData();
                    String string = liveStreamingYoutube.getString(R.string.pdf_path_last_segment);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    liveStreamingYoutube.setupDoc(liveStreamingYoutube.copyFileToInternalStorage(data4, string));
                    return;
                }
                Intent data5 = result.getData();
                Intrinsics.checkNotNull(data5);
                String path = RealPathUtil.getPath(liveStreamingYoutube, data5.getData());
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                liveStreamingYoutube.setupDoc(path);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void autoplayNextVideo() {
        boolean z;
        Video video;
        Log.e("TAG_APP", "autoplayNextVideo: 1");
        ArrayList<Video> arrayList = this.allVideosList;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (arrayList.size() > 0) {
                String str = this.position;
                Intrinsics.checkNotNull(str);
                int i = Integer.parseInt(str) + 1;
                ArrayList<Video> arrayList2 = this.allVideosList;
                Intrinsics.checkNotNull(arrayList2);
                if (i == arrayList2.size()) {
                    return;
                }
                String str2 = this.position;
                Intrinsics.checkNotNull(str2);
                int i2 = Integer.parseInt(str2) + 1;
                ArrayList<Video> arrayList3 = this.allVideosList;
                Intrinsics.checkNotNull(arrayList3);
                int size = arrayList3.size();
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    ArrayList<Video> arrayList4 = this.allVideosList;
                    Intrinsics.checkNotNull(arrayList4);
                    if (StringsKt.equals(arrayList4.get(i2).getFile_type(), "3", true)) {
                        i = i2;
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    ArrayList<Video> arrayList5 = this.allVideosList;
                    Intrinsics.checkNotNull(arrayList5);
                    Video video2 = arrayList5.get(i);
                    Intrinsics.checkNotNullExpressionValue(video2, "get(...)");
                    Video video3 = video2;
                    String video_type = video3.getVideo_type();
                    if (video_type != null) {
                        switch (video_type.hashCode()) {
                            case 48:
                                video = video3;
                                if (!video_type.equals("0")) {
                                    return;
                                }
                                break;
                            case 49:
                                if (video_type.equals("1")) {
                                    Helper.GoToLiveVideoActivity(video3.getChat_node(), this, video3.getFile_url(), video3.getVideo_type(), video3.getId(), video3.getTitle(), "0", video3.getThumbnail_url(), video3.getIs_chat_lock(), video3.getPayloadData().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, video3.getPayloadData().getTile_id(), video3.getPayloadData().getTile_type(), video3.getIs_bookmarked(), video3.getIs_live(), this.allVideosList);
                                    Log.e("TAG_APP", "autoplayNextVideo: 5563");
                                    finish();
                                    return;
                                }
                                return;
                            case 50:
                                video_type.equals("2");
                                return;
                            case 51:
                                video_type.equals("3");
                                return;
                            case 52:
                                if (video_type.equals("4")) {
                                    if (StringsKt.equals(video3.getLive_status(), "1", true)) {
                                        Helper.GoToLiveVideoActivity(video3.getChat_node(), this, video3.getFile_url(), video3.getVideo_type(), video3.getId(), video3.getTitle(), "0", video3.getThumbnail_url(), video3.getIs_chat_lock(), video3.getPayloadData().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, video3.getPayloadData().getTile_id(), video3.getPayloadData().getTile_type(), video3.getIs_bookmarked(), video3.getIs_live(), this.allVideosList);
                                        Log.e("TAG_APP", "autoplayNextVideo: 5582");
                                        finish();
                                        return;
                                    } else if (StringsKt.equals(video3.getLive_status(), "2", true)) {
                                        String string = getResources().getString(R.string.live_class_is_ended);
                                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                        showMessage(string);
                                        return;
                                    } else {
                                        if (StringsKt.equals(video3.getLive_status(), "3", true)) {
                                            String string2 = getResources().getString(R.string.live_class_is_cancelled);
                                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                            showMessage(string2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            case 53:
                                video = video3;
                                if (!video_type.equals("5")) {
                                    return;
                                }
                                break;
                            case 54:
                                video_type.equals("6");
                                return;
                            case 55:
                                if (video_type.equals("7")) {
                                    if (StringsKt.equals(video3.getIs_drm(), "1", true)) {
                                        Helper.GoToVideoCryptActivity(this, video3.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video3.getVideo_type(), video3.getChat_node(), video3.getId(), video3.getVideo_type(), video3.getId(), video3.getTitle(), "0", video3.getThumbnail_url(), video3.getPayloadData().getCourse_id(), video3.getPayloadData().getTile_id(), video3.getPayloadData().getTile_type(), video3.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video3.getStart_date(), "0", this.allVideosList);
                                        Log.e("TAG_APP", "autoplayNextVideo: 5636");
                                        finish();
                                        return;
                                    } else {
                                        Helper.GoToLiveAwsVideoActivity1(video3.getVideo_type(), video3.getChat_node(), this, video3.getId(), video3.getVideo_type(), video3.getId(), video3.getTitle(), "0", video3.getThumbnail_url(), video3.getPayloadData().getCourse_id(), video3.getPayloadData().getTile_id(), video3.getPayloadData().getTile_type(), video3.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video3.getStart_date(), this.allVideosList);
                                        Log.e("TAG_APP", "autoplayNextVideo: 5654");
                                        finish();
                                        return;
                                    }
                                }
                                return;
                            case 56:
                                if (video_type.equals("8")) {
                                    if (StringsKt.equals(video3.getIs_drm(), "1", true)) {
                                        Helper.GoToVideoCryptActivity(this, video3.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video3.getVideo_type(), video3.getChat_node(), video3.getId(), video3.getVideo_type(), video3.getId(), video3.getTitle(), "0", video3.getThumbnail_url(), video3.getPayloadData().getCourse_id(), video3.getPayloadData().getTile_id(), video3.getPayloadData().getTile_type(), video3.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video3.getStart_date(), "0", this.allVideosList);
                                        Log.e("TAG_APP", "autoplayNextVideo: 5675");
                                        finish();
                                        return;
                                    } else {
                                        Helper.GoToLiveAwsVideoActivity(video3.getVideo_type(), video3.getChat_node(), this, video3.getId(), video3.getVideo_type(), video3.getId(), video3.getTitle(), "0", video3.getThumbnail_url(), video3.getPayloadData().getCourse_id(), video3.getPayloadData().getTile_id(), video3.getPayloadData().getTile_type(), video3.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video3.getStart_date(), this.allVideosList);
                                        Log.e("TAG_APP", "autoplayNextVideo: 5694");
                                        finish();
                                        return;
                                    }
                                }
                                return;
                            default:
                                return;
                        }
                        Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), this.allVideosList);
                        Log.e("TAG_APP", "autoplayNextVideo: 5616");
                        finish();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            return;
        }
        clearClipBoard();
    }

    private final void clearClipBoard() {
        Object systemService = getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (this.isUserCopied) {
            clipboardManager.clearPrimaryClip();
            for (int i = 0; i < 51; i++) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("label" + i, getString(R.string.app_name) + i));
            }
        }
    }

    public final void clipBoardBubbleHandle() {
        Object systemService = getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        final ClipboardManager clipboardManager = (ClipboardManager) systemService;
        clipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda9
            @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
            public final void onPrimaryClipChanged() {
                LiveStreamingYoutube.clipBoardBubbleHandle$lambda$90(this.f$0, clipboardManager);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clipBoardBubbleHandle$lambda$90(LiveStreamingYoutube liveStreamingYoutube, ClipboardManager clipboardManager) {
        liveStreamingYoutube.isUserCopied = true;
        int i = liveStreamingYoutube.count;
        if (i < 1) {
            liveStreamingYoutube.count = i + 1;
            clipboardManager.setText("You Have Try To Copy Secure Content.");
            liveStreamingYoutube.showMessage("You Have Try To Copy Secure Content.");
            liveStreamingYoutube.finish();
        }
    }

    public final void CallPDFOnSameScreen(final String id, String pdfUrl, final boolean isDownload, final String pdfTitle, final String course_id, final String isShare) {
        Intrinsics.checkNotNullParameter(pdfUrl, "pdfUrl");
        PDFView pDFView = this.pdfViewPager;
        Intrinsics.checkNotNull(pDFView);
        pDFView.setVisibility(0);
        RecyclerView recyclerView = this.recyclerChat;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(8);
        RelativeLayout relativeLayout = this.rl_pdf_data;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(0);
        ProgressBar progressBar = this.progress_bar_pdf;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setVisibility(8);
        this.finalPdfUrl = pdfUrl;
        PDFView pDFView2 = this.pdfViewPager;
        Intrinsics.checkNotNull(pDFView2);
        ProgressBar progressBar2 = this.progress_bar_pdf;
        Intrinsics.checkNotNull(progressBar2);
        PdfUtils.INSTANCE.checkPermissionsAndDownload(this, pdfUrl, pDFView2, progressBar2, this.requestPermissionLauncher1);
        ImageView imageView = this.ic_back_pdf;
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.CallPDFOnSameScreen.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                RecyclerView recyclerView2 = LiveStreamingYoutube.this.recyclerChat;
                Intrinsics.checkNotNull(recyclerView2);
                recyclerView2.setVisibility(0);
                RelativeLayout relativeLayout2 = LiveStreamingYoutube.this.rl_pdf_data;
                Intrinsics.checkNotNull(relativeLayout2);
                relativeLayout2.setVisibility(8);
                try {
                    if (LiveStreamingYoutube.this.getOutput() != null) {
                        OutputStream output = LiveStreamingYoutube.this.getOutput();
                        Intrinsics.checkNotNull(output);
                        output.close();
                    }
                    if (LiveStreamingYoutube.this.getInput() != null) {
                        InputStream input = LiveStreamingYoutube.this.getInput();
                        Intrinsics.checkNotNull(input);
                        input.close();
                    }
                } catch (Exception unused) {
                }
                ProgressBar progress_bar_pdf = LiveStreamingYoutube.this.getProgress_bar_pdf();
                Intrinsics.checkNotNull(progress_bar_pdf);
                progress_bar_pdf.setVisibility(8);
                if (LiveStreamingYoutube.this.getUrlConnection() != null) {
                    HttpURLConnection urlConnection = LiveStreamingYoutube.this.getUrlConnection();
                    Intrinsics.checkNotNull(urlConnection);
                    urlConnection.disconnect();
                }
            }
        });
        ImageView imageView2 = this.ic_full_pdf;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.CallPDFOnSameScreen.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                RecyclerView recyclerView2 = LiveStreamingYoutube.this.recyclerChat;
                Intrinsics.checkNotNull(recyclerView2);
                recyclerView2.setVisibility(0);
                RelativeLayout relativeLayout2 = LiveStreamingYoutube.this.rl_pdf_data;
                Intrinsics.checkNotNull(relativeLayout2);
                relativeLayout2.setVisibility(8);
                ProgressBar progress_bar_pdf = LiveStreamingYoutube.this.getProgress_bar_pdf();
                Intrinsics.checkNotNull(progress_bar_pdf);
                progress_bar_pdf.setVisibility(8);
                LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                Helper.GoToWebViewPDFActivity(liveStreamingYoutube, id, liveStreamingYoutube.finalPdfUrl, isDownload, pdfTitle, course_id, isShare);
            }
        });
    }

    private final void showPDF(final String url) {
        PDFView pDFView;
        try {
            PDFView pDFView2 = this.pdfViewPager;
            if (pDFView2 != null) {
                Intrinsics.checkNotNull(pDFView2);
                pDFView2.recycle();
            }
            if (isDestroyed() || (pDFView = this.pdfViewPager) == null) {
                return;
            }
            pDFView.post(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.showPDF$lambda$91(this.f$0, url);
                }
            });
        } catch (Exception e2) {
            Log.d("showPDF", "showPDF: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPDF$lambda$91(LiveStreamingYoutube liveStreamingYoutube, String str) {
        PDFView pDFView = liveStreamingYoutube.pdfViewPager;
        Intrinsics.checkNotNull(pDFView);
        pDFView.fromFile(new File(str)).onLoad(liveStreamingYoutube).onError(liveStreamingYoutube).load();
    }

    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0087\u0004\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0013\u001a\u00020\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0015\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0015\"\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/appnew/android/player/LiveStreamingYoutube$LOADURL_new;", "Landroid/os/AsyncTask;", "", "", "callback", "Lcom/appnew/android/Courses/Interfaces/AsyncTaskCompleteListener;", "<init>", "(Lcom/appnew/android/player/LiveStreamingYoutube;Lcom/appnew/android/Courses/Interfaces/AsyncTaskCompleteListener;)V", VideoDownloadService.FILEPATH, "Ljava/io/File;", "getFilepath", "()Ljava/io/File;", "setFilepath", "(Ljava/io/File;)V", SaslNonza.Response.ELEMENT, "getResponse", "()Ljava/lang/String;", IoTSetResponse.ELEMENT, "(Ljava/lang/String;)V", "doInBackground", "strings", "", "([Ljava/lang/String;)Ljava/lang/String;", "onProgressUpdate", "", "values", "([Ljava/lang/Integer;)V", "onPostExecute", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class LOADURL_new extends AsyncTask<String, Integer, String> {
        private final AsyncTaskCompleteListener callback;
        private File filepath;
        private String response;
        final /* synthetic */ LiveStreamingYoutube this$0;

        public LOADURL_new(LiveStreamingYoutube liveStreamingYoutube, AsyncTaskCompleteListener callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.this$0 = liveStreamingYoutube;
            this.callback = callback;
            this.response = "";
        }

        public final File getFilepath() {
            return this.filepath;
        }

        public final void setFilepath(File file) {
            this.filepath = file;
        }

        public final String getResponse() {
            return this.response;
        }

        public final void setResponse(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.response = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Finally extract failed */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strings) {
            OutputStream output;
            HttpURLConnection urlConnection;
            Intrinsics.checkNotNullParameter(strings, "strings");
            try {
                try {
                    try {
                        URL url = new URL(strings[0]);
                        LiveStreamingYoutube liveStreamingYoutube = this.this$0;
                        URLConnection uRLConnectionOpenConnection = url.openConnection();
                        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        liveStreamingYoutube.setUrlConnection((HttpURLConnection) uRLConnectionOpenConnection);
                        urlConnection = this.this$0.getUrlConnection();
                        Intrinsics.checkNotNull(urlConnection);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    this.response = "error";
                    if (this.this$0.getOutput() != null) {
                        output = this.this$0.getOutput();
                    }
                }
                if (urlConnection.getResponseCode() != 200) {
                    this.response = "error";
                    HttpURLConnection urlConnection2 = this.this$0.getUrlConnection();
                    Intrinsics.checkNotNull(urlConnection2);
                    int responseCode = urlConnection2.getResponseCode();
                    HttpURLConnection urlConnection3 = this.this$0.getUrlConnection();
                    Intrinsics.checkNotNull(urlConnection3);
                    String str = "Server returned HTTP " + responseCode + " " + urlConnection3.getResponseMessage();
                    try {
                        if (this.this$0.getOutput() != null) {
                            OutputStream output2 = this.this$0.getOutput();
                            Intrinsics.checkNotNull(output2);
                            output2.close();
                        }
                    } catch (Exception unused3) {
                    }
                    return str;
                }
                HttpURLConnection urlConnection4 = this.this$0.getUrlConnection();
                Intrinsics.checkNotNull(urlConnection4);
                if (urlConnection4.getResponseCode() == 200) {
                    HttpURLConnection urlConnection5 = this.this$0.getUrlConnection();
                    Intrinsics.checkNotNull(urlConnection5);
                    urlConnection5.getContentLength();
                    LiveStreamingYoutube liveStreamingYoutube2 = this.this$0;
                    HttpURLConnection urlConnection6 = this.this$0.getUrlConnection();
                    Intrinsics.checkNotNull(urlConnection6);
                    liveStreamingYoutube2.setInput(new BufferedInputStream(urlConnection6.getInputStream()));
                    this.response = "success";
                }
                if (this.this$0.getOutput() != null) {
                    output = this.this$0.getOutput();
                    Intrinsics.checkNotNull(output);
                    output.close();
                }
                return this.response;
            } catch (Throwable th) {
                try {
                    if (this.this$0.getOutput() != null) {
                        OutputStream output3 = this.this$0.getOutput();
                        Intrinsics.checkNotNull(output3);
                        output3.close();
                    }
                } catch (Exception unused4) {
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... values) {
            Intrinsics.checkNotNullParameter(values, "values");
            super.onProgressUpdate(Arrays.copyOf(values, values.length));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String response) {
            if (response == null || !StringsKt.equals(response, "success", true)) {
                return;
            }
            PDFView pdfViewPager = this.this$0.getPdfViewPager();
            Intrinsics.checkNotNull(pdfViewPager);
            pdfViewPager.fromStream(this.this$0.getInput()).onLoad(this.this$0).onError(this.this$0).load();
        }
    }

    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/appnew/android/player/LiveStreamingYoutube$Companion;", "", "<init>", "()V", "newOrientation", "", "BANDWIDTH_METER", "Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "playPosition", "", "youtubeUri", "", "youtubevalidation", "des", "dataSendListener", "Lcom/appnew/android/LiveClass/interface_/OnDataSendListener;", "setOnDataSendListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void setOnDataSendListener(OnDataSendListener listener) {
            LiveStreamingYoutube.dataSendListener = listener;
        }

        public final String youtubevalidation(String des) {
            List listEmptyList;
            Intrinsics.checkNotNullParameter(des, "des");
            String str = des;
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            List<String> listSplit = new Regex("\\s+").split(str.subSequence(i, length + 1).toString(), 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            Pattern patternCompile = Pattern.compile("(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|watch\\?v%3D|\u200c\u200b%2Fvideos%2F|embed%2\u200c\u200bF|youtu.be%2F|%2Fv%2\u200c\u200bF)[^#\\&\\?\\n]*", 8);
            for (String str2 : strArr) {
                Matcher matcher = patternCompile.matcher(str2);
                if (matcher.find()) {
                    return matcher.group();
                }
            }
            return null;
        }
    }

    public final MultiUserChat getChatManager() {
        MultiUserChat multiUserChat = this.chatManager;
        if (multiUserChat != null) {
            return multiUserChat;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chatManager");
        return null;
    }

    public final void setChatManager(MultiUserChat multiUserChat) {
        Intrinsics.checkNotNullParameter(multiUserChat, "<set-?>");
        this.chatManager = multiUserChat;
    }

    public final void loadOrSendChat(XMPPConnection connection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, XmppStringprepException, XMPPException.XMPPErrorException {
        Intrinsics.checkNotNullParameter(connection, "connection");
        setChatManager(MultiUserChatManager.getInstanceFor(connection).getMultiUserChat(JidCreate.entityBareFrom("1711709551398@conference.chat-new.educrypt.ai")));
        getChatManager().join(Resourcepart.from("shivangi(8630226531)"));
        getChatManager().addMessageListener(this.ejabberedMessageListener);
        getChatManager().addMessageInterceptor(this.messageInterceptor);
    }

    public final MucMessageInterceptor getMessageInterceptor() {
        return this.messageInterceptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void messageInterceptor$lambda$92(MessageBuilder messageBuilder, MultiUserChat multiUserChat) {
        Intrinsics.checkNotNull(messageBuilder);
        Log.d("shantanu", "MessageBuilder: " + messageBuilder.getBody());
        Log.d("shantanu", "MessageBuilder: " + ((Object) messageBuilder.getFrom()));
        Log.d("shantanu", "MessageBuilder: " + ((Object) messageBuilder.getTo()));
        Log.d("shantanu", "MultiUserChat: " + multiUserChat.getOccupantsCount());
        Log.d("shantanu", "MultiUserChat: " + ((Object) multiUserChat.getNickname()));
        Log.d("shantanu", "MultiUserChat: " + ((Object) multiUserChat.getRoom()));
    }

    public final MessageListener getEjabberedMessageListener() {
        return this.ejabberedMessageListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ejabberedMessageListener$lambda$94(final LiveStreamingYoutube liveStreamingYoutube, Message message) {
        try {
            String body = message.getBody();
            Intrinsics.checkNotNullExpressionValue(body, "getBody(...)");
            if (body.length() == 0 && message.getBody().equals(Const.HINDI)) {
                String body2 = message.getBody();
                Intrinsics.checkNotNullExpressionValue(body2, "getBody(...)");
                if (StringsKt.contains$default((CharSequence) body2, (CharSequence) "hi jaanu", false, 2, (Object) null)) {
                    return;
                }
            }
            Intrinsics.checkNotNull(message);
            Log.d("shantanu", message.getBody());
            Log.d("shantanu", String.valueOf(message.getFrom()));
            Log.d("shantanu", String.valueOf(message.getTo()));
            chatPojo chatpojo = (chatPojo) new Gson().fromJson(message.getBody(), chatPojo.class);
            if (chatpojo != null) {
                liveStreamingYoutube.arrChat.add(chatpojo);
                liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveStreamingYoutube.ejabberedMessageListener$lambda$94$lambda$93(this.f$0);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ejabberedMessageListener$lambda$94$lambda$93(LiveStreamingYoutube liveStreamingYoutube) {
        if (liveStreamingYoutube.isUserScrolled) {
            return;
        }
        RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
        if (recyclerView != null) {
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView2);
                if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                    RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView3);
                    RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }
        RecyclerView recyclerView4 = liveStreamingYoutube.recyclerChat;
        Intrinsics.checkNotNull(recyclerView4);
        recyclerView4.smoothScrollToPosition(liveStreamingYoutube.arrChat.size());
    }

    public final MqttAndroidClient getMqttClientListen() {
        MqttAndroidClient mqttAndroidClient = this.mqttClientListen;
        if (mqttAndroidClient != null) {
            return mqttAndroidClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mqttClientListen");
        return null;
    }

    public final void setMqttClientListen(MqttAndroidClient mqttAndroidClient) {
        Intrinsics.checkNotNullParameter(mqttAndroidClient, "<set-?>");
        this.mqttClientListen = mqttAndroidClient;
    }

    public final MqttAndroidClient getMqttClientPublish() {
        MqttAndroidClient mqttAndroidClient = this.mqttClientPublish;
        if (mqttAndroidClient != null) {
            return mqttAndroidClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mqttClientPublish");
        return null;
    }

    public final void setMqttClientPublish(MqttAndroidClient mqttAndroidClient) {
        Intrinsics.checkNotNullParameter(mqttAndroidClient, "<set-?>");
        this.mqttClientPublish = mqttAndroidClient;
    }

    public final String getListenUrl() {
        return this.listenUrl;
    }

    public final void setListenUrl(String str) {
        this.listenUrl = str;
    }

    public final String getPublishUrl() {
        return this.publishUrl;
    }

    public final void setPublishUrl(String str) {
        this.publishUrl = str;
    }

    public final String getChatNode() {
        return this.chatNode;
    }

    public final void setChatNode(String str) {
        this.chatNode = str;
    }

    public final String getSettingNode() {
        return this.settingNode;
    }

    public final void setSettingNode(String str) {
        this.settingNode = str;
    }

    public final String getPrivateNode() {
        return this.privateNode;
    }

    public final void setPrivateNode(String str) {
        this.privateNode = str;
    }

    public final void connectToServer() {
        setVisibleUi(false);
        LiveChat liveChat = this.liveChat;
        if (liveChat == null) {
            showMessage("Server url not found");
            return;
        }
        if (TextUtils.isEmpty(liveChat != null ? liveChat.getListenUrl() : null)) {
            showMessage("Server url not found(listenUrl)");
            return;
        }
        LiveChat liveChat2 = this.liveChat;
        if (TextUtils.isEmpty(liveChat2 != null ? liveChat2.getPort() : null)) {
            showMessage("Server url not found(port)");
            return;
        }
        LiveChat liveChat3 = this.liveChat;
        if (TextUtils.isEmpty(liveChat3 != null ? liveChat3.getChat_node() : null)) {
            showMessage("Server url not found(chat_node)");
            return;
        }
        LiveChat liveChat4 = this.liveChat;
        if (TextUtils.isEmpty(liveChat4 != null ? liveChat4.getSetting_node() : null)) {
            showMessage("Server url not found(setting_node)");
            return;
        }
        LiveChat liveChat5 = this.liveChat;
        if (TextUtils.isEmpty(liveChat5 != null ? liveChat5.getPrivate_chat_node() : null)) {
            showMessage("Server url not found(private_chat_node)");
            return;
        }
        LiveChat liveChat6 = this.liveChat;
        String listenUrl = liveChat6 != null ? liveChat6.getListenUrl() : null;
        LiveChat liveChat7 = this.liveChat;
        this.listenUrl = "tcp://" + listenUrl + ":" + (liveChat7 != null ? liveChat7.getPort() : null);
        LiveChat liveChat8 = this.liveChat;
        String publishUrl = liveChat8 != null ? liveChat8.getPublishUrl() : null;
        LiveChat liveChat9 = this.liveChat;
        this.publishUrl = "tcp://" + publishUrl + ":" + (liveChat9 != null ? liveChat9.getPort() : null);
        LiveChat liveChat10 = this.liveChat;
        this.chatNode = liveChat10 != null ? liveChat10.getChat_node() : null;
        LiveChat liveChat11 = this.liveChat;
        this.settingNode = liveChat11 != null ? liveChat11.getSetting_node() : null;
        LiveChat liveChat12 = this.liveChat;
        this.privateNode = liveChat12 != null ? liveChat12.getPrivate_chat_node() : null;
        LiveChat liveChat13 = this.liveChat;
        setVisibleUi(String.valueOf(liveChat13 != null ? liveChat13.getType() : null).equals("room_unlock"));
        LiveChat liveChat14 = this.liveChat;
        showReactButton(String.valueOf(liveChat14 != null ? liveChat14.getEmoji_type() : null).equals("emoji_unlock"));
        handleChatSettingButton();
        String id = SharedPreference.getInstance().getLoggedInUser().getId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strSubstring = string.substring(0, 8);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String str = id + "_" + strSubstring;
        if (StringsKt.equals$default(this.listenUrl, this.publishUrl, false, 2, null)) {
            String str2 = this.listenUrl;
            Intrinsics.checkNotNull(str2);
            setMqttClientListen(new MqttAndroidClient(this, str2, str, Ack.AUTO_ACK, null, false, 0, 112, null));
            handleChatSettingNode();
            return;
        }
        LiveStreamingYoutube liveStreamingYoutube = this;
        String str3 = this.listenUrl;
        Intrinsics.checkNotNull(str3);
        setMqttClientListen(new MqttAndroidClient(liveStreamingYoutube, str3, str, Ack.AUTO_ACK, null, false, 0, 112, null));
        handleChatNode();
        String str4 = this.publishUrl;
        Intrinsics.checkNotNull(str4);
        setMqttClientPublish(new MqttAndroidClient(liveStreamingYoutube, str4, str, Ack.AUTO_ACK, null, false, 0, 112, null));
        handleSettingNode();
    }

    private final void handleChatSettingNode() {
        try {
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setUserName(SharedPreference.getInstance().getLoggedInUser().getName());
            String userJWT = Helper.getUserJWT();
            Intrinsics.checkNotNullExpressionValue(userJWT, "getUserJWT(...)");
            char[] charArray = userJWT.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            mqttConnectOptions.setPassword(charArray);
            mqttConnectOptions.setKeepAliveInterval(60);
            mqttConnectOptions.setCleanSession(true);
            mqttConnectOptions.setAutomaticReconnect(true);
            getMqttClientListen().connect(mqttConnectOptions).setActionCallback(new IMqttActionListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleChatSettingNode.1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    String privateNode;
                    String chatNode = LiveStreamingYoutube.this.getChatNode();
                    if (chatNode != null) {
                        LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                        liveStreamingYoutube.subscribeToTopic(liveStreamingYoutube.getMqttClientListen(), chatNode, QoS.AtMostOnce);
                    }
                    String settingNode = LiveStreamingYoutube.this.getSettingNode();
                    if (settingNode != null) {
                        LiveStreamingYoutube liveStreamingYoutube2 = LiveStreamingYoutube.this;
                        liveStreamingYoutube2.subscribeToTopic(liveStreamingYoutube2.getMqttClientListen(), settingNode, QoS.ExactlyOnce);
                    }
                    if (!LiveStreamingYoutube.this.getIsOperator() || (privateNode = LiveStreamingYoutube.this.getPrivateNode()) == null) {
                        return;
                    }
                    LiveStreamingYoutube liveStreamingYoutube3 = LiveStreamingYoutube.this;
                    liveStreamingYoutube3.subscribeToTopic(liveStreamingYoutube3.getMqttClientListen(), privateNode, QoS.AtMostOnce);
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d("MQTT", "onFailure: " + (exception != null ? exception.getMessage() : null));
                }
            });
            getMqttClientListen().setCallback(new MqttCallbackExtended() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleChatSettingNode.2
                @Override // org.eclipse.paho.client.mqttv3.MqttCallbackExtended
                public void connectComplete(boolean reconnect, String serverURI) {
                    String privateNode;
                    Intrinsics.checkNotNullParameter(serverURI, "serverURI");
                    if (reconnect) {
                        Log.d("MQTT", "connection reconnect");
                        String chatNode = LiveStreamingYoutube.this.getChatNode();
                        if (chatNode != null) {
                            LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                            liveStreamingYoutube.subscribeToTopic(liveStreamingYoutube.getMqttClientListen(), chatNode, QoS.AtMostOnce);
                        }
                        String settingNode = LiveStreamingYoutube.this.getSettingNode();
                        if (settingNode != null) {
                            LiveStreamingYoutube liveStreamingYoutube2 = LiveStreamingYoutube.this;
                            liveStreamingYoutube2.subscribeToTopic(liveStreamingYoutube2.getMqttClientListen(), settingNode, QoS.ExactlyOnce);
                        }
                        if (!LiveStreamingYoutube.this.getIsOperator() || (privateNode = LiveStreamingYoutube.this.getPrivateNode()) == null) {
                            return;
                        }
                        LiveStreamingYoutube liveStreamingYoutube3 = LiveStreamingYoutube.this;
                        liveStreamingYoutube3.subscribeToTopic(liveStreamingYoutube3.getMqttClientListen(), privateNode, QoS.AtMostOnce);
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void connectionLost(Throwable cause) {
                    Log.d("MQTT", "connection lost");
                    try {
                        LiveStreamingYoutube.this.getMqttClientListen().reconnect();
                    } catch (MqttException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void messageArrived(String topic, MqttMessage messages) {
                    try {
                        if (LiveStreamingYoutube.this.isDestroyed() || messages == null) {
                            return;
                        }
                        byte[] payload = messages.getPayload();
                        Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
                        String str = new String(payload, Charsets.UTF_8);
                        LiveStreamingYoutube.this.handleChatPojoMessage(str);
                        Log.d("MQTTchatsettingNode", str);
                    } catch (Exception e2) {
                        String message = e2.getMessage();
                        if (message != null) {
                            Log.e("MQTT", message);
                        }
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void deliveryComplete(IMqttDeliveryToken token) {
                    Log.d("MQTT", "deliveryComplete");
                }
            });
        } catch (MqttException e2) {
            showMessage("connectError: " + e2.getMessage());
        }
    }

    private final void handleChatNode() {
        try {
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setUserName(SharedPreference.getInstance().getLoggedInUser().getName());
            String userJWT = Helper.getUserJWT();
            Intrinsics.checkNotNullExpressionValue(userJWT, "getUserJWT(...)");
            char[] charArray = userJWT.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            mqttConnectOptions.setPassword(charArray);
            mqttConnectOptions.setKeepAliveInterval(60);
            mqttConnectOptions.setCleanSession(true);
            mqttConnectOptions.setAutomaticReconnect(true);
            getMqttClientListen().connect(mqttConnectOptions).setActionCallback(new IMqttActionListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleChatNode.1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    String privateNode;
                    String chatNode = LiveStreamingYoutube.this.getChatNode();
                    if (chatNode != null) {
                        LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                        liveStreamingYoutube.subscribeToTopic(liveStreamingYoutube.getMqttClientListen(), chatNode, QoS.AtMostOnce);
                    }
                    if (!LiveStreamingYoutube.this.getIsOperator() || (privateNode = LiveStreamingYoutube.this.getPrivateNode()) == null) {
                        return;
                    }
                    LiveStreamingYoutube liveStreamingYoutube2 = LiveStreamingYoutube.this;
                    liveStreamingYoutube2.subscribeToTopic(liveStreamingYoutube2.getMqttClientListen(), privateNode, QoS.AtMostOnce);
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d("MQTT", "onFailure: " + (exception != null ? exception.getMessage() : null));
                }
            });
            getMqttClientListen().setCallback(new MqttCallbackExtended() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleChatNode.2
                @Override // org.eclipse.paho.client.mqttv3.MqttCallbackExtended
                public void connectComplete(boolean reconnect, String serverURI) {
                    String privateNode;
                    Intrinsics.checkNotNullParameter(serverURI, "serverURI");
                    if (reconnect) {
                        Log.d("MQTT", "connection reconnect");
                        String chatNode = LiveStreamingYoutube.this.getChatNode();
                        if (chatNode != null) {
                            LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                            liveStreamingYoutube.subscribeToTopic(liveStreamingYoutube.getMqttClientListen(), chatNode, QoS.AtMostOnce);
                        }
                        if (!LiveStreamingYoutube.this.getIsOperator() || (privateNode = LiveStreamingYoutube.this.getPrivateNode()) == null) {
                            return;
                        }
                        LiveStreamingYoutube liveStreamingYoutube2 = LiveStreamingYoutube.this;
                        liveStreamingYoutube2.subscribeToTopic(liveStreamingYoutube2.getMqttClientListen(), privateNode, QoS.AtMostOnce);
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void connectionLost(Throwable cause) {
                    Log.d("MQTT", "connection lost");
                    try {
                        LiveStreamingYoutube.this.getMqttClientListen().reconnect();
                    } catch (MqttException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void messageArrived(String topic, MqttMessage messages) {
                    try {
                        if (LiveStreamingYoutube.this.isDestroyed() || messages == null) {
                            return;
                        }
                        byte[] payload = messages.getPayload();
                        Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
                        String str = new String(payload, Charsets.UTF_8);
                        LiveStreamingYoutube.this.handleChatPojoMessage(str);
                        Log.d("MQTTchatNode", str);
                    } catch (Exception e2) {
                        String message = e2.getMessage();
                        if (message != null) {
                            Log.e("MQTT", message);
                        }
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void deliveryComplete(IMqttDeliveryToken token) {
                    Log.d("MQTT", "deliveryComplete");
                }
            });
        } catch (MqttException e2) {
            showMessage("connectError: " + e2.getMessage());
        }
    }

    private final void handleSettingNode() {
        try {
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setUserName(SharedPreference.getInstance().getLoggedInUser().getName());
            String userJWT = Helper.getUserJWT();
            Intrinsics.checkNotNullExpressionValue(userJWT, "getUserJWT(...)");
            char[] charArray = userJWT.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            mqttConnectOptions.setPassword(charArray);
            mqttConnectOptions.setKeepAliveInterval(60);
            mqttConnectOptions.setCleanSession(true);
            mqttConnectOptions.setAutomaticReconnect(true);
            getMqttClientPublish().connect(mqttConnectOptions).setActionCallback(new IMqttActionListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleSettingNode.1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    String settingNode = LiveStreamingYoutube.this.getSettingNode();
                    if (settingNode != null) {
                        LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                        liveStreamingYoutube.subscribeToTopic(liveStreamingYoutube.getMqttClientPublish(), settingNode, QoS.ExactlyOnce);
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d("MQTT", "onFailure: " + (exception != null ? exception.getMessage() : null));
                }
            });
            getMqttClientPublish().setCallback(new MqttCallbackExtended() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleSettingNode.2
                @Override // org.eclipse.paho.client.mqttv3.MqttCallbackExtended
                public void connectComplete(boolean reconnect, String serverURI) {
                    Intrinsics.checkNotNullParameter(serverURI, "serverURI");
                    if (reconnect) {
                        Log.d("MQTT", "connection reconnect");
                        String settingNode = LiveStreamingYoutube.this.getSettingNode();
                        if (settingNode != null) {
                            LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                            liveStreamingYoutube.subscribeToTopic(liveStreamingYoutube.getMqttClientPublish(), settingNode, QoS.ExactlyOnce);
                        }
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void connectionLost(Throwable cause) {
                    Log.d("MQTT", "connection lost");
                    try {
                        LiveStreamingYoutube.this.getMqttClientPublish().reconnect();
                    } catch (MqttException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void messageArrived(String topic, MqttMessage messages) {
                    try {
                        if (LiveStreamingYoutube.this.isDestroyed() || messages == null) {
                            return;
                        }
                        byte[] payload = messages.getPayload();
                        Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
                        String str = new String(payload, Charsets.UTF_8);
                        LiveStreamingYoutube.this.handleChatPojoMessage(str);
                        Log.d("MQTTsettingNode", str);
                    } catch (Exception e2) {
                        String message = e2.getMessage();
                        if (message != null) {
                            Log.e("MQTT", message);
                        }
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void deliveryComplete(IMqttDeliveryToken token) {
                    Log.d("MQTT", "deliveryComplete");
                }
            });
        } catch (MqttException e2) {
            showMessage("connectError: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void handleChatPojoMessage(String msgData) {
        chatPojo chatpojo;
        ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue;
        Polldata message;
        ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue2;
        ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue3;
        chatPojo chatpojo2;
        try {
            JSONObject jSONObject = new JSONObject(msgData);
            if (!jSONObject.has("type") || TextUtils.isEmpty(jSONObject.optString("type"))) {
                Log.d("MQTT", "handleChatPojoMessage: invalid response type");
                return;
            }
            String strOptString = jSONObject.optString("type");
            if (strOptString != null) {
                switch (strOptString.hashCode()) {
                    case -2129810220:
                        if (strOptString.equals("GET_LEADERBOARD_VIDEOWISE")) {
                            runOnUiThread(new Thread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    LiveStreamingYoutube.handleChatPojoMessage$lambda$97(this.f$0);
                                }
                            }));
                            saveLeaderboardByMQTT(msgData, true);
                        }
                        break;
                    case -1888703667:
                        if (strOptString.equals("publishDoubt")) {
                            this.doubtPublishStatus = "publishDoubt";
                            String string = getString(R.string.publishDoubtMsg);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            if (jSONObject.has("message") && !TextUtils.isEmpty(jSONObject.optString("message"))) {
                                string = jSONObject.optString("message");
                            }
                            View view = this.rootView;
                            Intrinsics.checkNotNull(view);
                            Snackbar.make(view.getRootView(), string, -1).show();
                            if (this.isUserOnDoubt) {
                                getAndUpdateDoubtList();
                            }
                        }
                        break;
                    case -1239541617:
                        if (strOptString.equals("emojiReaction") && jSONObject.has("message") && !TextUtils.isEmpty(jSONObject.optString("message")) && (chatpojo = (chatPojo) new Gson().fromJson(msgData, chatPojo.class)) != null && (concurrentLinkedQueue = this.incomingQueueEmoji) != null) {
                            concurrentLinkedQueue.offer(chatpojo);
                        }
                        break;
                    case -1234464002:
                        if (strOptString.equals("feedback_trigger")) {
                            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    LiveStreamingYoutube.handleChatPojoMessage$lambda$98(this.f$0);
                                }
                            });
                        }
                        break;
                    case -1086137328:
                        if (strOptString.equals("videoCompleted")) {
                            com.appnew.android.home.Constants.REFRESHPAGE = "true";
                            com.appnew.android.home.Constants.REFRESHPAGENEW = "true";
                            com.appnew.android.home.Constants.revison_set = true;
                            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    LiveStreamingYoutube.handleChatPojoMessage$lambda$96(this.f$0);
                                }
                            });
                        }
                        break;
                    case -1080577170:
                        if (strOptString.equals("public_chat")) {
                            this.isPublicChatEnabled = true;
                        }
                        break;
                    case -1067626993:
                        if (!strOptString.equals("room_lock")) {
                        }
                        setVisibleUi(((chatPojo) new Gson().fromJson(msgData, chatPojo.class)).getType().equals("room_unlock"));
                        break;
                    case -917003939:
                        if (!strOptString.equals("emoji_unlock")) {
                        }
                        showReactButton(((chatPojo) new Gson().fromJson(msgData, chatPojo.class)).getType().equals("emoji_unlock"));
                        break;
                    case -98490824:
                        if (!strOptString.equals("user_unlock")) {
                        }
                        chatpojo2 = (chatPojo) new Gson().fromJson(msgData, chatPojo.class);
                        if (chatpojo2.getLocked_user_id() == null && chatpojo2.getLocked_user_id().equals(MakeMyExam.userId) && chatpojo2.getType().equals("user_lock")) {
                            setVisibleUi(false);
                        } else {
                            setVisibleUi(true);
                        }
                        break;
                    case 3446719:
                        if (strOptString.equals(Polling.EVENT_POLL)) {
                            PollResponseData pollResponseData = (PollResponseData) new Gson().fromJson(msgData, PollResponseData.class);
                            if ((!this.isOperator || !Intrinsics.areEqual(pollResponseData.getUser_id(), MakeMyExam.userId)) && (message = pollResponseData.getMessage()) != null) {
                                handleCreatePoll(message);
                            }
                        }
                        break;
                    case 3556653:
                        if (strOptString.equals("text")) {
                            chatPojo chatpojo3 = (chatPojo) new Gson().fromJson(msgData, chatPojo.class);
                            boolean zContains = TextUtils.isEmpty(this.videoAdmin) ? false : ArraysKt.contains((String[]) StringsKt.split$default((CharSequence) this.videoAdmin, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null).toArray(new String[0]), chatpojo3.getId());
                            if (!this.isPublicChatEnabled && (concurrentLinkedQueue3 = this.incomingQueue) != null) {
                                concurrentLinkedQueue3.clear();
                            }
                            if ((this.isPublicChatEnabled || zContains || Intrinsics.areEqual(chatpojo3.getId(), MakeMyExam.userId) || Intrinsics.areEqual("0", chatpojo3.getPlatform())) && chatpojo3 != null && (concurrentLinkedQueue2 = this.incomingQueue) != null) {
                                concurrentLinkedQueue2.offer(chatpojo3);
                            }
                        }
                        break;
                    case 86985684:
                        if (strOptString.equals("GET_LEADERBOARD")) {
                            saveLeaderboardByMQTT(msgData, false);
                        }
                        break;
                    case 335190656:
                        if (strOptString.equals("publishCompletedDoubt")) {
                            this.doubtPublishStatus = "publishCompletedDoubt";
                            String string2 = getString(R.string.publishCompletedDoubtMsg);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            if (jSONObject.has("message") && !TextUtils.isEmpty(jSONObject.optString("message"))) {
                                string2 = jSONObject.optString("message");
                            }
                            View view2 = this.rootView;
                            Intrinsics.checkNotNull(view2);
                            Snackbar.make(view2.getRootView(), string2, -1).show();
                            if (this.isUserOnDoubt) {
                                getAndUpdateDoubtList();
                            }
                        }
                        break;
                    case 339294495:
                        if (!strOptString.equals("user_lock")) {
                        }
                        chatpojo2 = (chatPojo) new Gson().fromJson(msgData, chatPojo.class);
                        if (chatpojo2.getLocked_user_id() == null) {
                        }
                        setVisibleUi(true);
                        break;
                    case 749615492:
                        if (!strOptString.equals("emoji_lock")) {
                        }
                        showReactButton(((chatPojo) new Gson().fromJson(msgData, chatPojo.class)).getType().equals("emoji_unlock"));
                        break;
                    case 764657448:
                        if (!strOptString.equals("room_unlock")) {
                        }
                        setVisibleUi(((chatPojo) new Gson().fromJson(msgData, chatPojo.class)).getType().equals("room_unlock"));
                        break;
                    case 1000480916:
                        if (strOptString.equals("private_chat")) {
                            if (!this.isOperator) {
                                this.isPublicChatEnabled = false;
                            } else {
                                this.isPublicChatEnabled = true;
                            }
                        }
                        break;
                    case 1340207238:
                        if (strOptString.equals("unPublishDoubt")) {
                            this.doubtPublishStatus = "unPublishDoubt";
                            if (this.isUserOnDoubt) {
                                getAndUpdateDoubtList();
                            }
                        }
                        break;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleChatPojoMessage$lambda$96(LiveStreamingYoutube liveStreamingYoutube) {
        Long longOrNull;
        try {
            if (liveStreamingYoutube.mExoPlayerFullscreen) {
                liveStreamingYoutube.closeFullScreenDialogNew();
            }
            if (liveStreamingYoutube.getIsUserActive() && dataSendListener != null && !liveStreamingYoutube.isOperator && !liveStreamingYoutube.isReviewSubmitted && liveStreamingYoutube.isShowFeedback()) {
                String str = liveStreamingYoutube.islive;
                long jLongValue = (str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue();
                String str2 = liveStreamingYoutube.video_id;
                String string = str2 != null ? str2.toString() : null;
                if (string == null) {
                    string = "";
                }
                String str3 = string;
                OnDataSendListener onDataSendListener = dataSendListener;
                if (onDataSendListener != null) {
                    onDataSendListener.onDataSent(jLongValue, str3, null, 3);
                }
            }
            liveStreamingYoutube.finish();
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e(com.paytm.pgsdk.Constants.EVENT_ACTION_ERROR, "Exception in UI thread: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleChatPojoMessage$lambda$97(LiveStreamingYoutube liveStreamingYoutube) {
        liveStreamingYoutube.isShowViewAllLeaderBoard = true;
        TextView textView = liveStreamingYoutube.viewLeaderboard;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility((liveStreamingYoutube.isFirebaseChat || liveStreamingYoutube.pollarraylist.isEmpty() || !liveStreamingYoutube.isShowViewAllLeaderBoard) ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleChatPojoMessage$lambda$98(LiveStreamingYoutube liveStreamingYoutube) {
        if (liveStreamingYoutube.isOperator) {
            return;
        }
        liveStreamingYoutube.showAutoFeedback();
    }

    public final void saveLeaderboardByMQTT(String msgData, boolean isVideoWise) {
        Intrinsics.checkNotNullParameter(msgData, "msgData");
        try {
            JSONObject jSONObject = new JSONObject(msgData.toString());
            String strOptString = jSONObject.has("type") ? jSONObject.optString("type") : "";
            String strOptString2 = jSONObject.has("status_code") ? jSONObject.optString("status_code") : "";
            String strOptString3 = jSONObject.has("poll_id") ? jSONObject.optString("poll_id") : "";
            String string = msgData.toString();
            if (isVideoWise) {
                strOptString3 = String.valueOf(this.video_id);
            }
            savePollResultInLocal(string, strOptString, strOptString3, strOptString2);
        } catch (Exception unused) {
            Log.d("MQTT", "mqtt_leaderboard: Error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void subscribeToTopic(MqttAndroidClient mqttAndroidClient, final String topic, QoS qos) {
        try {
            mqttAndroidClient.subscribe(topic, qos.getValue(), (Object) null, new IMqttActionListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.subscribeToTopic.1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    Intrinsics.checkNotNullParameter(asyncActionToken, "asyncActionToken");
                    Log.d("MQTT", "Subscribed to: " + topic);
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Intrinsics.checkNotNullParameter(asyncActionToken, "asyncActionToken");
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    Log.d("MQTT", "Failed to Subscribed: " + topic);
                }
            });
        } catch (MqttException e2) {
            Log.d("MQTT", "subscribeToTopicError: " + e2.getMessage());
        }
    }

    private final void sendMessage(String message, boolean isEmoji) {
        try {
            String str = (this.isPublicChatEnabled || this.isOperator) ? this.chatNode : this.privateNode;
            if (!TextUtils.isEmpty(str)) {
                MqttMessage mqttMessage = new MqttMessage();
                byte[] bytes = message.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                mqttMessage.setPayload(bytes);
                MqttAndroidClient mqttClientListen = getMqttClientListen();
                Intrinsics.checkNotNull(str);
                mqttClientListen.publish(str, mqttMessage, (Object) null, new C06361(message, isEmoji));
                return;
            }
            Integer.valueOf(Log.d("MQTT", "Empty listen url"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$sendMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$sendMessage$1", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "onSuccess", "", "asyncActionToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "onFailure", "exception", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06361 implements IMqttActionListener {
        final /* synthetic */ boolean $isEmoji;
        final /* synthetic */ String $message;

        C06361(String str, boolean z) {
            this.$message = str;
            this.$isEmoji = z;
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onSuccess(IMqttToken asyncActionToken) {
            String str;
            if (!LiveStreamingYoutube.this.isDestroyed() && !LiveStreamingYoutube.this.isPublicChatEnabled && !LiveStreamingYoutube.this.getIsOperator() && (str = this.$message) != null) {
                LiveStreamingYoutube.this.handleChatPojoMessage(str);
                Log.d("MQTTchatsettingNodePri", this.$message);
            }
            final LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
            final boolean z = this.$isEmoji;
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$sendMessage$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06361.onSuccess$lambda$0(z, liveStreamingYoutube);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$0(boolean z, LiveStreamingYoutube liveStreamingYoutube) {
            if (z) {
                liveStreamingYoutube.timerForEmojiClick();
            } else {
                liveStreamingYoutube.enableDisableMsgET();
            }
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            final LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$sendMessage$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.access$showMessage(liveStreamingYoutube, "Reconnecting, please try again");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableDisableMsgET() {
        try {
            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda88
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.enableDisableMsgET$lambda$99(this.f$0);
                }
            });
            if (!com.appnew.android.home.Constants.chatMsgTimerEnabled || this.isOperator) {
                return;
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda93
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.enableDisableMsgET$lambda$100(this.f$0);
                }
            });
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 30;
            Timer timer = new Timer();
            timer.schedule(new AnonymousClass3(intRef, this, timer), 1000L, 1000L);
        } catch (Exception e2) {
            Log.d("enableDisableMsgET", "enableDisableMsgET: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableDisableMsgET$lambda$99(LiveStreamingYoutube liveStreamingYoutube) {
        EditText editText = liveStreamingYoutube.etMessage;
        Intrinsics.checkNotNull(editText);
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableDisableMsgET$lambda$100(LiveStreamingYoutube liveStreamingYoutube) {
        ImageView imageView = liveStreamingYoutube.ivSend;
        Intrinsics.checkNotNull(imageView);
        imageView.setClickable(false);
        ImageView imageView2 = liveStreamingYoutube.ivSend;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setEnabled(false);
        EditText editText = liveStreamingYoutube.etMessage;
        Intrinsics.checkNotNull(editText);
        editText.setClickable(false);
        EditText editText2 = liveStreamingYoutube.etMessage;
        Intrinsics.checkNotNull(editText2);
        editText2.setEnabled(false);
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$enableDisableMsgET$3, reason: invalid class name */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$enableDisableMsgET$3", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass3 extends TimerTask {
        final /* synthetic */ Ref.IntRef $count;
        final /* synthetic */ Timer $timer;
        final /* synthetic */ LiveStreamingYoutube this$0;

        AnonymousClass3(Ref.IntRef intRef, LiveStreamingYoutube liveStreamingYoutube, Timer timer) {
            this.$count = intRef;
            this.this$0 = liveStreamingYoutube;
            this.$timer = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.$count.element--;
            final LiveStreamingYoutube liveStreamingYoutube = this.this$0;
            final Ref.IntRef intRef = this.$count;
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$enableDisableMsgET$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.AnonymousClass3.run$lambda$0(liveStreamingYoutube, intRef);
                }
            });
            if (this.$count.element == 0) {
                this.$timer.cancel();
                final LiveStreamingYoutube liveStreamingYoutube2 = this.this$0;
                liveStreamingYoutube2.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$enableDisableMsgET$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveStreamingYoutube.AnonymousClass3.run$lambda$1(liveStreamingYoutube2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(LiveStreamingYoutube liveStreamingYoutube, Ref.IntRef intRef) {
            ImageView ivSend = liveStreamingYoutube.getIvSend();
            Intrinsics.checkNotNull(ivSend);
            ivSend.setClickable(false);
            ImageView ivSend2 = liveStreamingYoutube.getIvSend();
            Intrinsics.checkNotNull(ivSend2);
            ivSend2.setEnabled(false);
            EditText etMessage = liveStreamingYoutube.getEtMessage();
            Intrinsics.checkNotNull(etMessage);
            etMessage.setClickable(false);
            EditText etMessage2 = liveStreamingYoutube.getEtMessage();
            Intrinsics.checkNotNull(etMessage2);
            etMessage2.setEnabled(false);
            if (intRef.element >= 10) {
                EditText etMessage3 = liveStreamingYoutube.getEtMessage();
                Intrinsics.checkNotNull(etMessage3);
                etMessage3.setHint("Wait for 00:" + intRef.element);
                return;
            }
            EditText etMessage4 = liveStreamingYoutube.getEtMessage();
            Intrinsics.checkNotNull(etMessage4);
            etMessage4.setHint("Wait for 00:0" + intRef.element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$1(LiveStreamingYoutube liveStreamingYoutube) {
            ImageView ivSend = liveStreamingYoutube.getIvSend();
            Intrinsics.checkNotNull(ivSend);
            ivSend.setClickable(true);
            ImageView ivSend2 = liveStreamingYoutube.getIvSend();
            Intrinsics.checkNotNull(ivSend2);
            ivSend2.setEnabled(true);
            EditText etMessage = liveStreamingYoutube.getEtMessage();
            Intrinsics.checkNotNull(etMessage);
            etMessage.setEnabled(true);
            EditText etMessage2 = liveStreamingYoutube.getEtMessage();
            Intrinsics.checkNotNull(etMessage2);
            etMessage2.setClickable(true);
            EditText etMessage3 = liveStreamingYoutube.getEtMessage();
            Intrinsics.checkNotNull(etMessage3);
            etMessage3.setHint("Type something...");
        }
    }

    public final void mqttDisconnect(MqttAndroidClient mqttAndroidClient) {
        Intrinsics.checkNotNullParameter(mqttAndroidClient, "mqttAndroidClient");
        try {
            mqttAndroidClient.disconnect().setActionCallback(new IMqttActionListener() { // from class: com.appnew.android.player.LiveStreamingYoutube.mqttDisconnect.1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    Intrinsics.checkNotNullParameter(asyncActionToken, "asyncActionToken");
                    Log.d("MQTT", "Successfully disconnected");
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Intrinsics.checkNotNullParameter(asyncActionToken, "asyncActionToken");
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    Log.d("MQTT", "Failed to disconnect");
                }
            });
        } catch (MqttException e2) {
            Log.d("MQTT", "mqttDisconnectError: " + e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleChatSettingButton() {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.handleChatSettingButton():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchSettingClick(String type, SwitchCompat switchButton, CompoundButton.OnCheckedChangeListener switchChangeListener) {
        String setting_node;
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setVideo_id(this.video_id);
        encryptionData.setType(type);
        encryptionData.setPlatform("1");
        LiveChat liveChat = this.liveChat;
        String publishUrl = null;
        if (TextUtils.isEmpty(liveChat != null ? liveChat.getSetting_node() : null)) {
            setting_node = "";
        } else {
            LiveChat liveChat2 = this.liveChat;
            setting_node = liveChat2 != null ? liveChat2.getSetting_node() : null;
        }
        encryptionData.setTopic(setting_node);
        LiveChat liveChat3 = this.liveChat;
        if (TextUtils.isEmpty(liveChat3 != null ? liveChat3.getPublishUrl() : null)) {
            publishUrl = "";
        } else {
            LiveChat liveChat4 = this.liveChat;
            if (liveChat4 != null) {
                publishUrl = liveChat4.getPublishUrl();
            }
        }
        encryptionData.setHost(publishUrl);
        String json = new Gson().toJson(encryptionData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        handleChatLockUnlock(json, switchButton, switchChangeListener);
    }

    public final void handleChatLockUnlock(String postData, final SwitchCompat switchButton, final CompoundButton.OnCheckedChangeListener switchChangeListener) {
        Intrinsics.checkNotNullParameter(postData, "postData");
        LiveChat liveChat = this.liveChat;
        if (TextUtils.isEmpty(liveChat != null ? liveChat.getPollSocketUrl() : null)) {
            showMessage("Base URL not found");
            disableSwitchOnError(switchButton, switchChangeListener);
            return;
        }
        if (!Helper.isNetworkConnected(this)) {
            String string = getResources().getString(R.string.Retry_with_Internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showMessage(string);
            disableSwitchOnError(switchButton, switchChangeListener);
            return;
        }
        try {
            Helper.showProgressDialog(this);
            LiveChat liveChat2 = this.liveChat;
            ((APIInterface) MakeMyExamForPoll.getRetrofitInstance(liveChat2 != null ? liveChat2.getPollSocketUrl() : null).create(APIInterface.class)).manageMqttPublish(postData).enqueue(new Callback<String>() { // from class: com.appnew.android.player.LiveStreamingYoutube.handleChatLockUnlock.1
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    Helper.dismissProgressDialog();
                    try {
                        if (response.body() != null && !TextUtils.isEmpty(String.valueOf(response.body()))) {
                            JSONObject jSONObject = new JSONObject(String.valueOf(response.body()));
                            if (jSONObject.has("message")) {
                                LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                                String strOptString = jSONObject.optString("message");
                                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                                liveStreamingYoutube.showMessage(strOptString);
                                return;
                            }
                            return;
                        }
                        LiveStreamingYoutube.this.disableSwitchOnError(switchButton, switchChangeListener);
                        LiveStreamingYoutube liveStreamingYoutube2 = LiveStreamingYoutube.this;
                        String string2 = liveStreamingYoutube2.getString(R.string.no_data_found);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        liveStreamingYoutube2.showMessage(string2);
                    } catch (Exception e2) {
                        LiveStreamingYoutube.this.disableSwitchOnError(switchButton, switchChangeListener);
                        LiveStreamingYoutube.this.showMessage(String.valueOf(e2.getMessage()));
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Helper.dismissProgressDialog();
                    LiveStreamingYoutube.this.disableSwitchOnError(switchButton, switchChangeListener);
                    LiveStreamingYoutube.this.showMessage(String.valueOf(t.getMessage()));
                }
            });
        } catch (Exception e2) {
            Helper.dismissProgressDialog();
            disableSwitchOnError(switchButton, switchChangeListener);
            showMessage(String.valueOf(e2.getMessage()));
        }
    }

    public final void disableSwitchOnError(final SwitchCompat switchButton, final CompoundButton.OnCheckedChangeListener switchChangeListener) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda75
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.disableSwitchOnError$lambda$101(switchButton, switchChangeListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void disableSwitchOnError$lambda$101(SwitchCompat switchCompat, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (switchCompat == null || onCheckedChangeListener == null) {
            return;
        }
        switchCompat.setOnCheckedChangeListener(null);
        switchCompat.setChecked(!switchCompat.isChecked());
        switchCompat.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public final void setChatSettingUi(final boolean isShow) {
        runOnUiThread(new Thread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.setChatSettingUi$lambda$102(this.f$0, isShow);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setChatSettingUi$lambda$102(LiveStreamingYoutube liveStreamingYoutube, boolean z) {
        if (!liveStreamingYoutube.isFirebaseChat && Helper.isChatSettingEnabled() && liveStreamingYoutube.isOperator && z) {
            LinearLayout linearLayout = liveStreamingYoutube.llChatSetting;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = liveStreamingYoutube.llChatSetting;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    public final void setVisibleUi(boolean status) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (this.isOperator) {
            booleanRef.element = true;
        } else {
            booleanRef.element = status;
        }
        runOnUiThread(new Thread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.setVisibleUi$lambda$103(booleanRef, this);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVisibleUi$lambda$103(Ref.BooleanRef booleanRef, LiveStreamingYoutube liveStreamingYoutube) {
        if (booleanRef.element) {
            liveStreamingYoutube.setSendListener();
            if (liveStreamingYoutube.isUserOnPoll) {
                LinearLayout linearLayout = liveStreamingYoutube.linearLayout;
                Intrinsics.checkNotNull(linearLayout);
                linearLayout.setVisibility(8);
                LinearLayout linearLayout2 = liveStreamingYoutube.chatlayout;
                Intrinsics.checkNotNull(linearLayout2);
                linearLayout2.setVisibility(8);
            } else if (liveStreamingYoutube.isUserOnDoubt) {
                LinearLayout linearLayout3 = liveStreamingYoutube.linearLayout;
                Intrinsics.checkNotNull(linearLayout3);
                linearLayout3.setVisibility(8);
                LinearLayout linearLayout4 = liveStreamingYoutube.chatlayout;
                Intrinsics.checkNotNull(linearLayout4);
                linearLayout4.setVisibility(8);
            } else {
                LinearLayout linearLayout5 = liveStreamingYoutube.linearLayout;
                Intrinsics.checkNotNull(linearLayout5);
                linearLayout5.setVisibility(0);
                LinearLayout linearLayout6 = liveStreamingYoutube.chatlayout;
                Intrinsics.checkNotNull(linearLayout6);
                linearLayout6.setVisibility(0);
            }
            liveStreamingYoutube.islockedback = "0";
            return;
        }
        LinearLayout linearLayout7 = liveStreamingYoutube.linearLayout;
        Intrinsics.checkNotNull(linearLayout7);
        linearLayout7.setVisibility(8);
        LinearLayout linearLayout8 = liveStreamingYoutube.chatlayout;
        Intrinsics.checkNotNull(linearLayout8);
        linearLayout8.setVisibility(8);
        liveStreamingYoutube.islockedback = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMessage(final String message) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.showMessage$lambda$104(message, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMessage$lambda$104(String str, LiveStreamingYoutube liveStreamingYoutube) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "failed to connect", false, 2, (Object) null)) {
            str = "Failed to connect with server";
        }
        Toast.makeText(liveStreamingYoutube, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePollData(final String messages) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.handlePollData$lambda$106(messages, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        if (r1.equals("POLL_ADDED") == false) goto L45;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void handlePollData$lambda$106(java.lang.String r5, com.appnew.android.player.LiveStreamingYoutube r6) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.handlePollData$lambda$106(java.lang.String, com.appnew.android.player.LiveStreamingYoutube):void");
    }

    private final boolean checkPollAlreadyAdded(Polldata polldata) {
        ArrayList<Polldata> arrayList = this.pollarraylist;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<Polldata> it = this.pollarraylist.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Polldata next = it.next();
            if (StringsKt.equals(polldata.getRendomkey(), next != null ? next.getRendomkey() : null, true)) {
                return true;
            }
        }
        return false;
    }

    private final void handleCreatePoll(final Polldata polldata) {
        long j;
        try {
            Helper.closeKeyboard(this);
            if (polldata == null || !polldata.getVideoId().equals(this.video_id)) {
                return;
            }
            if (this.isOperator) {
                j = 0;
            } else {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                String validTill = polldata.getValidTill();
                Intrinsics.checkNotNullExpressionValue(validTill, "getValidTill(...)");
                long j2 = 1000;
                long seconds = timeUnit.toSeconds((Long.parseLong(validTill) - (System.currentTimeMillis() / j2)) * j2);
                String validity = polldata.getValidity();
                Intrinsics.checkNotNullExpressionValue(validity, "getValidity(...)");
                j = (seconds - Long.parseLong(validity)) * j2;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda84
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.handleCreatePoll$lambda$109(this.f$0, polldata);
                }
            }, j);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCreatePoll$lambda$109(final LiveStreamingYoutube liveStreamingYoutube, final Polldata polldata) {
        if (liveStreamingYoutube.checkPollAlreadyAdded(polldata)) {
            return;
        }
        polldata.setMyAnswer("0");
        liveStreamingYoutube.pollarraylist.add(0, polldata);
        liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda87
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.handleCreatePoll$lambda$109$lambda$108(this.f$0, polldata);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCreatePoll$lambda$109$lambda$108(final LiveStreamingYoutube liveStreamingYoutube, Polldata polldata) {
        NestedScrollView nestedScrollView;
        RecyclerView recyclerView = liveStreamingYoutube.recylerViewPollOperator;
        if (recyclerView != null) {
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = liveStreamingYoutube.recylerViewPollOperator;
                Intrinsics.checkNotNull(recyclerView2);
                if (recyclerView2.getAdapter() instanceof PollAdapter) {
                    RecyclerView recyclerView3 = liveStreamingYoutube.recylerViewPollOperator;
                    Intrinsics.checkNotNull(recyclerView3);
                    RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }
        int i = 8;
        if (liveStreamingYoutube.isOperator) {
            RelativeLayout relativeLayout = liveStreamingYoutube.addPoll;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(8);
            RelativeLayout relativeLayout2 = liveStreamingYoutube.createPoll;
            Intrinsics.checkNotNull(relativeLayout2);
            relativeLayout2.setVisibility(0);
            TextView textView = liveStreamingYoutube.generateLeaderboard;
            Intrinsics.checkNotNull(textView);
            textView.setVisibility((liveStreamingYoutube.isFirebaseChat || !Helper.isGenerateLeaderboardEnabled()) ? 8 : 0);
        } else {
            RelativeLayout relativeLayout3 = liveStreamingYoutube.addPoll;
            Intrinsics.checkNotNull(relativeLayout3);
            relativeLayout3.setVisibility(8);
            RelativeLayout relativeLayout4 = liveStreamingYoutube.createPoll;
            Intrinsics.checkNotNull(relativeLayout4);
            relativeLayout4.setVisibility(8);
            TextView textView2 = liveStreamingYoutube.generateLeaderboard;
            Intrinsics.checkNotNull(textView2);
            textView2.setVisibility(8);
        }
        TextView textView3 = liveStreamingYoutube.viewLeaderboard;
        Intrinsics.checkNotNull(textView3);
        if (!liveStreamingYoutube.isFirebaseChat && !liveStreamingYoutube.pollarraylist.isEmpty() && liveStreamingYoutube.isShowViewAllLeaderBoard) {
            i = 0;
        }
        textView3.setVisibility(i);
        TextView textView4 = liveStreamingYoutube.enterTimeET;
        Intrinsics.checkNotNull(textView4);
        textView4.setText(liveStreamingYoutube.defaultTimeDuration);
        RecyclerView recyclerView4 = liveStreamingYoutube.recylerViewPollOperator;
        Intrinsics.checkNotNull(recyclerView4);
        recyclerView4.setVisibility(0);
        if (liveStreamingYoutube.isUserOnPoll && (nestedScrollView = liveStreamingYoutube.createPollNestedScrollView) != null) {
            Intrinsics.checkNotNull(nestedScrollView);
            nestedScrollView.post(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.handleCreatePoll$lambda$109$lambda$108$lambda$107(this.f$0);
                }
            });
        }
        if (liveStreamingYoutube.getResources().getConfiguration().orientation == 2) {
            LandscapePollDialog landscapePollDialog = liveStreamingYoutube.landscapePollDialog;
            if (landscapePollDialog != null) {
                landscapePollDialog.showPollIndicator(polldata, true);
            }
            LandscapePollDialog landscapePollDialog2 = liveStreamingYoutube.landscapePollDialog;
            if (landscapePollDialog2 != null) {
                landscapePollDialog2.showPollAttempt(polldata);
            }
        }
        View view = liveStreamingYoutube.rootView;
        Intrinsics.checkNotNull(view);
        Snackbar.make(view.getRootView(), "New poll added", -1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCreatePoll$lambda$109$lambda$108$lambda$107(LiveStreamingYoutube liveStreamingYoutube) {
        NestedScrollView nestedScrollView = liveStreamingYoutube.createPollNestedScrollView;
        Intrinsics.checkNotNull(nestedScrollView);
        nestedScrollView.smoothScrollTo(0, 0);
    }

    private final void handlePollResult(String messages) {
        LandscapePollDialog landscapePollDialog;
        try {
            PollResponse pollResponse = (PollResponse) new Gson().fromJson(messages, PollResponse.class);
            Polldata message = pollResponse.getData().getMessage();
            HashMap<String, Float> map = new HashMap<>();
            this.attempt_1_count = pollResponse.getData().getMessage().getAttempt1().longValue();
            this.attempt_2_count = pollResponse.getData().getMessage().getAttempt2().longValue();
            this.attempt_3_count = pollResponse.getData().getMessage().getAttempt3().longValue();
            float fLongValue = pollResponse.getData().getMessage().getAttempt4().longValue();
            this.attempt_4_count = fLongValue;
            float f2 = this.attempt_1_count + this.attempt_2_count + this.attempt_3_count + fLongValue;
            this.total = f2;
            map.put("total", Float.valueOf(f2));
            float f3 = this.attempt_1_count;
            if (f3 != 0.0f) {
                map.put("perA", Float.valueOf((f3 / this.total) * 100));
            } else {
                map.put("perA", Float.valueOf(0.0f));
            }
            float f4 = this.attempt_2_count;
            if (f4 != 0.0f) {
                map.put("perB", Float.valueOf((f4 / this.total) * 100));
            } else {
                map.put("perB", Float.valueOf(0.0f));
            }
            float f5 = this.attempt_3_count;
            if (f5 != 0.0f) {
                map.put("perC", Float.valueOf((f5 / this.total) * 100));
            } else {
                map.put("perC", Float.valueOf(0.0f));
            }
            float f6 = this.attempt_4_count;
            if (f6 != 0.0f) {
                map.put("perD", Float.valueOf((f6 / this.total) * 100));
            } else {
                map.put("perD", Float.valueOf(0.0f));
            }
            if (this.isLandscape) {
                if (message == null || (landscapePollDialog = this.landscapePollDialog) == null) {
                    return;
                }
                landscapePollDialog.showPollResult(message, map);
                return;
            }
            PollAdapter pollAdapter = this.pollAdapter;
            if (pollAdapter != null) {
                Intrinsics.checkNotNull(pollAdapter);
                pollAdapter.SetServeyresult(message, map);
            }
        } catch (Exception unused) {
            String string = getResources().getString(R.string.no_data_found);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showMessage(string);
        }
    }

    private final void handleSubmitPoll(String messages) {
        showMessage(messages);
    }

    private final void handleLeaderBoardResult(String messages, boolean isForAll) {
        try {
            LeaderboardResponse leaderboardResponse = (LeaderboardResponse) new Gson().fromJson(messages, LeaderboardResponse.class);
            if (this.isLandscape) {
                if (leaderboardResponse != null && leaderboardResponse.getData() != null && leaderboardResponse.getData().size() > 3) {
                    LandscapePollDialog landscapePollDialog = this.landscapePollDialog;
                    if (landscapePollDialog != null) {
                        List<PollLeaderboard> data = leaderboardResponse.getData();
                        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                        landscapePollDialog.showPollLeaderboard(data, isForAll);
                        return;
                    }
                    return;
                }
                showMessage("No Leaderboard found");
                return;
            }
            PollAdapter pollAdapter = this.pollAdapter;
            if (pollAdapter != null) {
                Intrinsics.checkNotNull(pollAdapter);
                pollAdapter.showLeaderboard(leaderboardResponse, isForAll);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final String createPollDataStr() {
        EncryptionData encryptionData = new EncryptionData();
        int i = 0;
        encryptionData.setOption_1(this.optionList.get(0).getAnswer());
        encryptionData.setOption_2(this.optionList.get(1).getAnswer());
        this.pollOption1 = this.optionList.get(0).getAnswer();
        this.pollOption2 = this.optionList.get(1).getAnswer();
        int size = this.optionList.size();
        if (size == 3) {
            encryptionData.setOption_3(this.optionList.get(2).getAnswer());
            this.pollOption3 = this.optionList.get(2).getAnswer();
        } else if (size == 4) {
            encryptionData.setOption_3(this.optionList.get(2).getAnswer());
            encryptionData.setOption_4(this.optionList.get(3).getAnswer());
            this.pollOption3 = this.optionList.get(2).getAnswer();
            this.pollOption4 = this.optionList.get(3).getAnswer();
        } else if (size == 5) {
            encryptionData.setOption_3(this.optionList.get(2).getAnswer());
            encryptionData.setOption_4(this.optionList.get(3).getAnswer());
            encryptionData.setOption_5(this.optionList.get(4).getAnswer());
            this.pollOption3 = this.optionList.get(2).getAnswer();
            this.pollOption4 = this.optionList.get(3).getAnswer();
            this.pollOption5 = this.optionList.get(4).getAnswer();
        } else if (size == 6) {
            encryptionData.setOption_3(this.optionList.get(2).getAnswer());
            encryptionData.setOption_4(this.optionList.get(3).getAnswer());
            encryptionData.setOption_5(this.optionList.get(4).getAnswer());
            encryptionData.setOption_6(this.optionList.get(5).getAnswer());
            this.pollOption3 = this.optionList.get(2).getAnswer();
            this.pollOption4 = this.optionList.get(3).getAnswer();
            this.pollOption5 = this.optionList.get(4).getAnswer();
            this.pollOption6 = this.optionList.get(5).getAnswer();
        }
        EditText editText = this.enterQuestionET;
        Intrinsics.checkNotNull(editText);
        encryptionData.setQuestion(editText.getText().toString());
        EditText editText2 = this.enterDelayET;
        Intrinsics.checkNotNull(editText2);
        encryptionData.setDelay(editText2.getText().toString());
        encryptionData.setMy_answer("0");
        TextView textView = this.enterTimeET;
        Intrinsics.checkNotNull(textView);
        if (!TextUtils.isEmpty(textView.getText().toString())) {
            TextView textView2 = this.enterTimeET;
            Intrinsics.checkNotNull(textView2);
            encryptionData.setValidity(String.valueOf(Integer.parseInt((String) StringsKt.split$default((CharSequence) textView2.getText().toString(), new String[]{" "}, false, 0, 6, (Object) null).get(0))));
        }
        TextView textView3 = this.enterTimeET;
        Intrinsics.checkNotNull(textView3);
        this.pollValidity = String.valueOf(Integer.parseInt((String) StringsKt.split$default((CharSequence) textView3.getText().toString(), new String[]{" "}, false, 0, 6, (Object) null).get(0)));
        int size2 = this.optionList.size();
        while (true) {
            if (i >= size2) {
                break;
            }
            if (this.optionList.get(i).isThisAnswerRight()) {
                int i2 = i + 1;
                encryptionData.setAnswer(String.valueOf(i2));
                this.pollAnswer = String.valueOf(i2);
                break;
            }
            i++;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        LiveChat liveChat = this.liveChat;
        String setting_node = null;
        if (TextUtils.isEmpty(liveChat != null ? liveChat.getSetting_node() : null)) {
            setting_node = "";
        } else {
            LiveChat liveChat2 = this.liveChat;
            if (liveChat2 != null) {
                setting_node = liveChat2.getSetting_node();
            }
        }
        encryptionData2.setSetting_node(setting_node);
        encryptionData2.setType("CREATE_POLL");
        encryptionData2.setId(MakeMyExam.getUserId());
        encryptionData2.setName(SharedPreference.getInstance().getLoggedInUser().getName());
        encryptionData2.setVideo_id(this.video_id);
        encryptionData2.setCourse_id(this.course_id);
        encryptionData2.setPlateform("1");
        encryptionData2.setData(encryptionData);
        String json = new Gson().toJson(encryptionData2);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    private final String updatePollDataStr(String pollkey, String answer, String timeleft) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("UPDATE_POLL");
        encryptionData.setPoll_id(pollkey);
        encryptionData.setAttempted(getAttemptedAnswer(answer));
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setTimeleft(timeleft);
        encryptionData.setName(SharedPreference.getInstance().getLoggedInUser().getName());
        encryptionData.setVideo_id(this.video_id);
        String json = new Gson().toJson(encryptionData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    private final String resultPollDataStr(String pollkey) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("GET_POLL");
        encryptionData.setPoll_id(pollkey);
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setVideo_id(this.video_id);
        String json = new Gson().toJson(encryptionData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final String leaderboardPollDataStr(String pollkey) {
        Intrinsics.checkNotNullParameter(pollkey, "pollkey");
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("GET_LEADERBOARD");
        encryptionData.setPoll_id(pollkey);
        encryptionData.setVideo_id(this.video_id);
        String json = new Gson().toJson(encryptionData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final String leaderboardVideoWiseDataStr() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("GET_LEADERBOARD_VIDEOWISE");
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setVideo_id(this.video_id);
        String json = new Gson().toJson(encryptionData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final String generateLeaderboardVideoWiseDataStr() {
        EncryptionData encryptionData = new EncryptionData();
        LiveChat liveChat = this.liveChat;
        String setting_node = null;
        if (TextUtils.isEmpty(liveChat != null ? liveChat.getSetting_node() : null)) {
            setting_node = "";
        } else {
            LiveChat liveChat2 = this.liveChat;
            if (liveChat2 != null) {
                setting_node = liveChat2.getSetting_node();
            }
        }
        encryptionData.setSetting_node(setting_node);
        encryptionData.setType("GENERATE_LEADERBOARD_VIDEOWISE");
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setVideo_id(this.video_id);
        String json = new Gson().toJson(encryptionData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final void sendWSMessage(String msg, String type, String pollId) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(pollId, "pollId");
        try {
            Log.i("pollData", msg);
            if (TextUtils.isEmpty(msg)) {
                return;
            }
            managePollAPI(msg, type, pollId);
        } catch (Exception e2) {
            showMessage(String.valueOf(e2.getMessage()));
        }
    }

    public final void managePollAPI(String postData, String type, final String pollId) {
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(pollId, "pollId");
        LiveChat liveChat = this.liveChat;
        if (TextUtils.isEmpty(liveChat != null ? liveChat.getPollSocketUrl() : null)) {
            showMessage("Base URL not found");
            return;
        }
        if (!Helper.isNetworkConnected(this)) {
            String string = getResources().getString(R.string.Retry_with_Internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showMessage(string);
            return;
        }
        try {
            ArrayList<PollLocalResult> filteredPollLocalResults = Helper.getFilteredPollLocalResults(this.video_id, pollId, MakeMyExam.getUserId(), type);
            Intrinsics.checkNotNullExpressionValue(filteredPollLocalResults, "getFilteredPollLocalResults(...)");
            if (!filteredPollLocalResults.isEmpty()) {
                handlePollData(filteredPollLocalResults.get(0).getMsgData().toString());
                return;
            }
            Helper.showProgressDialog(this);
            LiveChat liveChat2 = this.liveChat;
            ((APIInterface) MakeMyExamForPoll.getRetrofitInstance(liveChat2 != null ? liveChat2.getPollSocketUrl() : null).create(APIInterface.class)).managePollNew(postData).enqueue(new Callback<String>() { // from class: com.appnew.android.player.LiveStreamingYoutube.managePollAPI.1
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    Helper.dismissProgressDialog();
                    try {
                        if (response.body() != null && !TextUtils.isEmpty(String.valueOf(response.body()))) {
                            JSONObject jSONObject = new JSONObject(String.valueOf(response.body()));
                            String strOptString = jSONObject.has("type") ? jSONObject.optString("type") : "";
                            String strOptString2 = jSONObject.has("status_code") ? jSONObject.optString("status_code") : "";
                            if (LiveStreamingYoutube.this.getIsOperator()) {
                                if (!StringsKt.equals(strOptString, "CREATE_POLL", true) && !StringsKt.equals(strOptString, "POLL_ADDED", true)) {
                                    LiveStreamingYoutube.this.savePollResultInLocal(String.valueOf(response.body()), strOptString, pollId, strOptString2);
                                }
                                LiveStreamingYoutube.this.handlePollData(String.valueOf(response.body()));
                                return;
                            }
                            if (StringsKt.equals(strOptString, "CREATE_POLL", true) || StringsKt.equals(strOptString, "POLL_ADDED", true)) {
                                return;
                            }
                            LiveStreamingYoutube.this.savePollResultInLocal(String.valueOf(response.body()), strOptString, pollId, strOptString2);
                            LiveStreamingYoutube.this.handlePollData(String.valueOf(response.body()));
                            return;
                        }
                        LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                        String string2 = liveStreamingYoutube.getString(R.string.no_data_found);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        liveStreamingYoutube.showMessage(string2);
                    } catch (Exception e2) {
                        LiveStreamingYoutube.this.showMessage(String.valueOf(e2.getMessage()));
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    Helper.dismissProgressDialog();
                    LiveStreamingYoutube.this.showMessage(String.valueOf(t.getMessage()));
                }
            });
        } catch (Exception e2) {
            Helper.dismissProgressDialog();
            showMessage(String.valueOf(e2.getMessage()));
        }
    }

    public final void savePollResultInLocal(String messages, String typeLocal, String pollId, String statusCode) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(typeLocal, "typeLocal");
        Intrinsics.checkNotNullParameter(pollId, "pollId");
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        try {
            if (TextUtils.isEmpty(statusCode) || !statusCode.equals("10011") || TextUtils.isEmpty(pollId) || TextUtils.isEmpty(messages) || TextUtils.isEmpty(typeLocal)) {
                return;
            }
            if (typeLocal.equals("GET_POLL") || typeLocal.equals("GET_LEADERBOARD") || typeLocal.equals("GET_LEADERBOARD_VIDEOWISE")) {
                ArrayList<PollLocalResult> pollLoacalResultData = Helper.getPollLoacalResultData();
                String strValueOf = String.valueOf(this.video_id);
                String userId = MakeMyExam.getUserId();
                Intrinsics.checkNotNullExpressionValue(userId, "getUserId(...)");
                PollLocalResult pollLocalResult = new PollLocalResult(strValueOf, userId, pollId, typeLocal, messages);
                int size = pollLoacalResultData.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    PollLocalResult pollLocalResult2 = pollLoacalResultData.get(i);
                    if (Intrinsics.areEqual(String.valueOf(this.video_id), pollLocalResult2.getVideoId()) && Intrinsics.areEqual(MakeMyExam.getUserId(), pollLocalResult2.getUserId()) && Intrinsics.areEqual(pollId, pollLocalResult2.getPollId()) && Intrinsics.areEqual(typeLocal, pollLocalResult2.getType())) {
                        pollLoacalResultData.remove(i);
                        break;
                    }
                    i++;
                }
                pollLoacalResultData.add(pollLocalResult);
                Helper.setPollLoacalResultData(pollLoacalResultData);
            }
        } catch (Exception e2) {
            Log.d("MQTT", "savePollResultInLocal: " + e2.getMessage());
        }
    }

    public final void manageDoubtAPI(String postData, final String type) {
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(type, "type");
        LiveChat liveChat = this.liveChat;
        if (TextUtils.isEmpty(liveChat != null ? liveChat.getPollSocketUrl() : null)) {
            showMessage("Base URL not found");
            return;
        }
        if (!Helper.isNetworkConnected(this)) {
            String string = getResources().getString(R.string.Retry_with_Internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showMessage(string);
            return;
        }
        try {
            Helper.showProgressDialog(this);
            LiveChat liveChat2 = this.liveChat;
            APIInterface aPIInterface = (APIInterface) MakeMyExamForPoll.getRetrofitInstance(liveChat2 != null ? liveChat2.getPollSocketUrl() : null).create(APIInterface.class);
            Call<String> doubts = aPIInterface.getDoubts(postData);
            int iHashCode = type.hashCode();
            if (iHashCode != -373161054) {
                if (iHashCode != 540484787) {
                    if (iHashCode == 583898133 && type.equals("SUBMIT_DOUBT")) {
                        doubts = aPIInterface.submitDoubts(postData);
                    }
                } else if (type.equals("GET_DOUBT")) {
                    doubts = aPIInterface.getDoubts(postData);
                }
            } else if (type.equals("MANAGE_DOUBT")) {
                doubts = aPIInterface.publishDoubts(postData);
            }
            if (doubts != null) {
                doubts.enqueue(new Callback<String>() { // from class: com.appnew.android.player.LiveStreamingYoutube.manageDoubtAPI.1
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        Helper.dismissProgressDialog();
                        try {
                            if (response.body() != null && !TextUtils.isEmpty(String.valueOf(response.body()))) {
                                LiveStreamingYoutube.this.handleDoubtData(String.valueOf(response.body()), type);
                                return;
                            }
                            LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                            String string2 = liveStreamingYoutube.getString(R.string.no_data_found);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            liveStreamingYoutube.showMessage(string2);
                        } catch (Exception e2) {
                            LiveStreamingYoutube.this.showMessage(String.valueOf(e2.getMessage()));
                        }
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Helper.dismissProgressDialog();
                        LiveStreamingYoutube.this.showMessage(String.valueOf(t.getMessage()));
                    }
                });
            }
        } catch (Exception e2) {
            Helper.dismissProgressDialog();
            showMessage(String.valueOf(e2.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDoubtData(final String messages, final String type) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.handleDoubtData$lambda$112(messages, this, type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDoubtData$lambda$112(String str, LiveStreamingYoutube liveStreamingYoutube, String str2) {
        Log.i("Doubt", "onMessage " + str);
        String strOptString = liveStreamingYoutube.doubtPublishStatus;
        String strOptString2 = "Something went wrong,Try again";
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("message") && !TextUtils.isEmpty(jSONObject.optString("message"))) {
                    strOptString2 = jSONObject.optString("message");
                }
                if (jSONObject.has("type") && !TextUtils.isEmpty(jSONObject.optString("type"))) {
                    strOptString = jSONObject.optString("type");
                }
                if (!TextUtils.isEmpty(str2)) {
                    int iHashCode = str2.hashCode();
                    if (iHashCode != -373161054) {
                        if (iHashCode != 540484787) {
                            if (iHashCode == 583898133 && str2.equals("SUBMIT_DOUBT")) {
                                try {
                                    liveStreamingYoutube.isShowSubmit = false;
                                    liveStreamingYoutube.handlePublishSubmitButton();
                                    liveStreamingYoutube.showMessage(strOptString2);
                                } catch (Exception e2) {
                                    liveStreamingYoutube.showMessage(String.valueOf(e2.getMessage()));
                                }
                                Unit unit = Unit.INSTANCE;
                                return;
                            }
                        } else if (str2.equals("GET_DOUBT")) {
                            try {
                                DoubtResponse doubtResponse = (DoubtResponse) new Gson().fromJson(str, DoubtResponse.class);
                                List<DoubtItemData> data = doubtResponse.getData();
                                if (!TextUtils.isEmpty(doubtResponse.getState())) {
                                    liveStreamingYoutube.doubtPublishStatus = doubtResponse.getState();
                                }
                                if (data != null) {
                                    liveStreamingYoutube.setDoubtsData(data);
                                    Unit unit2 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            } catch (Exception e3) {
                                liveStreamingYoutube.showMessage(String.valueOf(e3.getMessage()));
                                Unit unit3 = Unit.INSTANCE;
                                return;
                            }
                        }
                    } else if (str2.equals("MANAGE_DOUBT")) {
                        try {
                            if (strOptString.equals("publishDoubt") || strOptString.equals("unPublishDoubt") || strOptString.equals("publishCompletedDoubt")) {
                                liveStreamingYoutube.doubtPublishStatus = strOptString;
                            }
                            liveStreamingYoutube.handlePublishSubmitButton();
                        } catch (Exception e4) {
                            liveStreamingYoutube.showMessage(String.valueOf(e4.getMessage()));
                        }
                        Unit unit4 = Unit.INSTANCE;
                        return;
                    }
                    liveStreamingYoutube.showMessage(strOptString2);
                    Unit unit5 = Unit.INSTANCE;
                    return;
                }
                liveStreamingYoutube.showMessage(strOptString2);
                Unit unit6 = Unit.INSTANCE;
                return;
            } catch (Exception e5) {
                liveStreamingYoutube.showMessage(String.valueOf(e5.getMessage()));
                Unit unit7 = Unit.INSTANCE;
                return;
            }
        }
        liveStreamingYoutube.showMessage("Something went wrong,Try again");
    }

    private final void setDoubtsData(List<? extends DoubtItemData> doubtItemList) {
        LiveStreamingYoutube liveStreamingYoutube;
        if (doubtItemList.isEmpty()) {
            liveStreamingYoutube = this;
            showMessage("No doubt found");
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : doubtItemList) {
                DoubtItemData doubtItemData = (DoubtItemData) obj;
                if (!TextUtils.isEmpty(doubtItemData.getIs_upVoted()) && doubtItemData.getIs_upVoted().equals("1")) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                this.isShowSubmit = false;
            }
            liveStreamingYoutube = this;
            liveStreamingYoutube.manageButtonUI(false, false, false, false, false, false, true);
            handlePublishSubmitButton();
            liveStreamingYoutube.isUserOnPoll = false;
            liveStreamingYoutube.isUserOnDoubt = true;
            liveStreamingYoutube.isclicked = "7";
            disableAll();
            ChatAdapter chatAdapter = liveStreamingYoutube.chatAdapter;
            if (chatAdapter != null) {
                Intrinsics.checkNotNull(chatAdapter);
                chatAdapter.pauseAudio();
            }
            RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView2);
                if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                    ChatAdapter chatAdapter2 = liveStreamingYoutube.chatAdapter;
                    Intrinsics.checkNotNull(chatAdapter2);
                    chatAdapter2.stopMusic();
                }
            }
            if (liveStreamingYoutube.doubtPublishStatus.equals("publishDoubt") || liveStreamingYoutube.doubtPublishStatus.equals("publishCompletedDoubt") || liveStreamingYoutube.isOperator) {
                RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView3);
                recyclerView3.setVisibility(0);
                RelativeLayout relativeLayout = liveStreamingYoutube.goToCurrentRl;
                Intrinsics.checkNotNull(relativeLayout);
                relativeLayout.setVisibility(8);
                LinearLayout linearLayout = liveStreamingYoutube.linearLayout;
                Intrinsics.checkNotNull(linearLayout);
                linearLayout.setVisibility(8);
                TextView textView = liveStreamingYoutube.addBookmark;
                Intrinsics.checkNotNull(textView);
                textView.setVisibility(8);
                RelativeLayout relativeLayout2 = liveStreamingYoutube.rl_pdf_data;
                Intrinsics.checkNotNull(relativeLayout2);
                relativeLayout2.setVisibility(8);
                RelativeLayout relativeLayout3 = liveStreamingYoutube.chatMainRl;
                Intrinsics.checkNotNull(relativeLayout3);
                relativeLayout3.setVisibility(0);
                NestedScrollView nestedScrollView = liveStreamingYoutube.createPollNestedScrollView;
                Intrinsics.checkNotNull(nestedScrollView);
                nestedScrollView.setVisibility(8);
                RecyclerView recyclerView4 = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView4);
                recyclerView4.setLayoutManager(new LinearLayoutManager(liveStreamingYoutube));
                liveStreamingYoutube.doubtVideoAdapter = new DoubtVideoAdapter(liveStreamingYoutube, doubtItemList, liveStreamingYoutube.doubtPublishStatus, liveStreamingYoutube.isOperator, liveStreamingYoutube.isShowSubmit);
                RecyclerView recyclerView5 = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView5);
                recyclerView5.setAdapter(liveStreamingYoutube.doubtVideoAdapter);
            } else {
                RecyclerView recyclerView6 = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView6);
                recyclerView6.setVisibility(8);
                RelativeLayout relativeLayout4 = liveStreamingYoutube.goToCurrentRl;
                Intrinsics.checkNotNull(relativeLayout4);
                relativeLayout4.setVisibility(8);
                LinearLayout linearLayout2 = liveStreamingYoutube.linearLayout;
                Intrinsics.checkNotNull(linearLayout2);
                linearLayout2.setVisibility(8);
                TextView textView2 = liveStreamingYoutube.addBookmark;
                Intrinsics.checkNotNull(textView2);
                textView2.setVisibility(8);
                RelativeLayout relativeLayout5 = liveStreamingYoutube.rl_pdf_data;
                Intrinsics.checkNotNull(relativeLayout5);
                relativeLayout5.setVisibility(8);
                RelativeLayout relativeLayout6 = liveStreamingYoutube.chatMainRl;
                Intrinsics.checkNotNull(relativeLayout6);
                relativeLayout6.setVisibility(0);
                NestedScrollView nestedScrollView2 = liveStreamingYoutube.createPollNestedScrollView;
                Intrinsics.checkNotNull(nestedScrollView2);
                nestedScrollView2.setVisibility(8);
            }
        }
        LinearLayout linearLayout3 = liveStreamingYoutube.llEnableMarkAsRead;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    public final void handlePublishSubmitButton() {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda89
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.handlePublishSubmitButton$lambda$114(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void handlePublishSubmitButton$lambda$114(com.appnew.android.player.LiveStreamingYoutube r5) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.handlePublishSubmitButton$lambda$114(com.appnew.android.player.LiveStreamingYoutube):void");
    }

    public final void handlePublishUnPublishButton() {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.handlePublishUnPublishButton$lambda$115(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handlePublishUnPublishButton$lambda$115(LiveStreamingYoutube liveStreamingYoutube) {
        if (liveStreamingYoutube.doubtPublishStatus.equals("publishDoubt")) {
            TextView textView = liveStreamingYoutube.publishTxt;
            if (textView != null) {
                Intrinsics.checkNotNull(textView);
                textView.setText(liveStreamingYoutube.getString(R.string.unPublishDoubt));
                return;
            }
            return;
        }
        if (liveStreamingYoutube.doubtPublishStatus.equals("publishCompletedDoubt")) {
            TextView textView2 = liveStreamingYoutube.publishTxt;
            if (textView2 != null) {
                Intrinsics.checkNotNull(textView2);
                textView2.setText(liveStreamingYoutube.getString(R.string.completed));
                return;
            }
            return;
        }
        TextView textView3 = liveStreamingYoutube.publishTxt;
        if (textView3 != null) {
            Intrinsics.checkNotNull(textView3);
            textView3.setText(liveStreamingYoutube.getString(R.string.publishDoubt));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAndUpdateDoubtList() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setVideo_id(this.video_id);
        String json = new Gson().toJson(encryptionData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        manageDoubtAPI(json, "GET_DOUBT");
    }

    private final void showConfirmationDialog(String msg, final String type) {
        DialogUtils.makeDialog(this, "", msg, getResources().getString(R.string.confirm), getResources().getString(R.string.cancel), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda66
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                LiveStreamingYoutube.showConfirmationDialog$lambda$116(type, this);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda77
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                LiveStreamingYoutube.showConfirmationDialog$lambda$117();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmationDialog$lambda$116(String str, LiveStreamingYoutube liveStreamingYoutube) {
        if (Intrinsics.areEqual(str, "submit")) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(MakeMyExam.getUserId());
            encryptionData.setVideo_id(liveStreamingYoutube.video_id);
            DoubtVideoAdapter doubtVideoAdapter = liveStreamingYoutube.doubtVideoAdapter;
            Intrinsics.checkNotNull(doubtVideoAdapter);
            encryptionData.setUpvoted_key(doubtVideoAdapter.getSelectedDoubts());
            String json = new Gson().toJson(encryptionData);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            liveStreamingYoutube.manageDoubtAPI(json, "SUBMIT_DOUBT");
            return;
        }
        if (Intrinsics.areEqual(str, "manage")) {
            String str2 = "publishDoubt";
            if (liveStreamingYoutube.doubtPublishStatus.equals("publishDoubt")) {
                str2 = "unPublishDoubt";
            } else {
                liveStreamingYoutube.doubtPublishStatus.equals("unPublishDoubt");
            }
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setType(str2);
            encryptionData2.setId(MakeMyExam.getUserId());
            encryptionData2.setName(SharedPreference.getInstance().getLoggedInUser().getName());
            encryptionData2.setVideo_id(liveStreamingYoutube.video_id);
            LiveChat liveChat = liveStreamingYoutube.liveChat;
            String setting_node = null;
            if (TextUtils.isEmpty(liveChat != null ? liveChat.getSetting_node() : null)) {
                setting_node = "";
            } else {
                LiveChat liveChat2 = liveStreamingYoutube.liveChat;
                if (liveChat2 != null) {
                    setting_node = liveChat2.getSetting_node();
                }
            }
            encryptionData2.setSetting_node(setting_node);
            String json2 = new Gson().toJson(encryptionData2);
            Intrinsics.checkNotNullExpressionValue(json2, "toJson(...)");
            liveStreamingYoutube.manageDoubtAPI(json2, "MANAGE_DOUBT");
        }
    }

    public final void openEmojiPopup() {
        PopupWindow popupWindow = new PopupWindow(getLoveImage().getContext());
        popupWindow.setFocusable(true);
        View viewInflate = LayoutInflater.from(getLoveImage().getContext()).inflate(R.layout.emoji_reaction_layout, (ViewGroup) null);
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        popupWindow.setContentView(viewInflate);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        int[] iArr = new int[2];
        getLoveImage().getLocationOnScreen(iArr);
        Size size = new Size(popupWindow.getContentView().getMeasuredWidth(), popupWindow.getContentView().getMeasuredHeight());
        popupWindow.showAtLocation(getLoveImage(), 8388659, iArr[0] - ((size.getWidth() - getLoveImage().getWidth()) / 2), iArr[1] - size.getHeight());
        TextView textView = (TextView) popupWindow.getContentView().findViewById(R.id.like_text);
        TextView textView2 = (TextView) popupWindow.getContentView().findViewById(R.id.laugh_text);
        TextView textView3 = (TextView) popupWindow.getContentView().findViewById(R.id.angry_text);
        TextView textView4 = (TextView) popupWindow.getContentView().findViewById(R.id.love_text);
        TextView textView5 = (TextView) popupWindow.getContentView().findViewById(R.id.sad_text);
        TextView textView6 = (TextView) popupWindow.getContentView().findViewById(R.id.wow_text);
        Intrinsics.checkNotNull(textView);
        onReactClick(textView, popupWindow);
        Intrinsics.checkNotNull(textView2);
        onReactClick(textView2, popupWindow);
        Intrinsics.checkNotNull(textView3);
        onReactClick(textView3, popupWindow);
        Intrinsics.checkNotNull(textView4);
        onReactClick(textView4, popupWindow);
        Intrinsics.checkNotNull(textView5);
        onReactClick(textView5, popupWindow);
        Intrinsics.checkNotNull(textView6);
        onReactClick(textView6, popupWindow);
    }

    private final void onReactClick(final TextView view, final PopupWindow popUp) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda92
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveStreamingYoutube.onReactClick$lambda$122(this.f$0, view, popUp, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReactClick$lambda$122(LiveStreamingYoutube liveStreamingYoutube, TextView textView, PopupWindow popupWindow, View view) {
        if (!Helper.isConnected(liveStreamingYoutube)) {
            String string = liveStreamingYoutube.getResources().getString(R.string.no_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        } else {
            liveStreamingYoutube.reactClick(textView.getText().toString());
            liveStreamingYoutube.timerForEmojiClick();
        }
        popupWindow.dismiss();
    }

    private final void reactClick(String emoji) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("emojiReaction");
        encryptionData.setMessage(emoji);
        String json = new Gson().toJson(encryptionData);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        sendMessage(json, true);
    }

    public final Drawable emojiToDrawable(String emoji) {
        TextView textView = new TextView(this);
        textView.setTextSize(18.0f);
        textView.setText(emoji);
        textView.setTextColor(-16777216);
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(textView.getMeasuredWidth(), textView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        textView.draw(new Canvas(bitmapCreateBitmap));
        return new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showReactButton(final boolean r4) {
        /*
            r3 = this;
            com.appnew.android.Model.BottomSetting r0 = r3.bottomSetting
            if (r0 == 0) goto L2b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getChat_reaction()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2b
            com.appnew.android.Model.BottomSetting r0 = r3.bottomSetting
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getChat_reaction()
            java.lang.String r1 = "1"
            r2 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r2)
            if (r0 == 0) goto L2b
            boolean r0 = r3.isOperator
            if (r0 == 0) goto L2c
            r4 = r2
            goto L2c
        L2b:
            r4 = 0
        L2c:
            com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda76 r0 = new com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda76
            r0.<init>()
            r3.runOnUiThread(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.LiveStreamingYoutube.showReactButton(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showReactButton$lambda$123(boolean z, LiveStreamingYoutube liveStreamingYoutube) {
        if (z) {
            LinearLayout linearLayout = liveStreamingYoutube.endLayout;
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setVisibility(0);
            liveStreamingYoutube.getTopImage().setVisibility(0);
            liveStreamingYoutube.getLoveImage().setVisibility(0);
            return;
        }
        liveStreamingYoutube.getTopImage().setVisibility(0);
        liveStreamingYoutube.getLoveImage().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void timerForEmojiClick() {
        if (!com.appnew.android.home.Constants.chatMsgTimerEnabled || this.isOperator) {
            return;
        }
        getLoveImage().setClickable(false);
        getLoveImage().setEnabled(false);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 30;
        Timer timer = new Timer();
        timer.schedule(new C06431(intRef, this, timer), 1000L, 1000L);
    }

    /* JADX INFO: renamed from: com.appnew.android.player.LiveStreamingYoutube$timerForEmojiClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LiveStreamingYoutube.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$timerForEmojiClick$1", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06431 extends TimerTask {
        final /* synthetic */ Ref.IntRef $count;
        final /* synthetic */ Timer $timer;
        final /* synthetic */ LiveStreamingYoutube this$0;

        C06431(Ref.IntRef intRef, LiveStreamingYoutube liveStreamingYoutube, Timer timer) {
            this.$count = intRef;
            this.this$0 = liveStreamingYoutube;
            this.$timer = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.$count.element--;
            final LiveStreamingYoutube liveStreamingYoutube = this.this$0;
            final Ref.IntRef intRef = this.$count;
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$timerForEmojiClick$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube.C06431.run$lambda$0(liveStreamingYoutube, intRef);
                }
            });
            if (this.$count.element == 0) {
                this.$timer.cancel();
                final LiveStreamingYoutube liveStreamingYoutube2 = this.this$0;
                liveStreamingYoutube2.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$timerForEmojiClick$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveStreamingYoutube.C06431.run$lambda$1(liveStreamingYoutube2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(LiveStreamingYoutube liveStreamingYoutube, Ref.IntRef intRef) {
            liveStreamingYoutube.getLoveImage().setClickable(false);
            liveStreamingYoutube.getLoveImage().setEnabled(false);
            liveStreamingYoutube.getLoveImage().setTextSize(0, liveStreamingYoutube.getResources().getDimension(R.dimen.text_reaction_small));
            if (intRef.element >= 10) {
                liveStreamingYoutube.getLoveImage().setText(new StringBuilder().append(intRef.element).toString());
            } else {
                liveStreamingYoutube.getLoveImage().setText("0" + intRef.element);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$1(LiveStreamingYoutube liveStreamingYoutube) {
            liveStreamingYoutube.getLoveImage().setEnabled(true);
            liveStreamingYoutube.getLoveImage().setClickable(true);
            liveStreamingYoutube.getLoveImage().setTextSize(0, liveStreamingYoutube.getResources().getDimension(R.dimen.text_reaction_large));
            liveStreamingYoutube.getLoveImage().setText("❤️");
        }
    }

    public final void makeFlyAnimation(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        try {
            final ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(drawable);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(15);
            getTopImage().addView(imageView, layoutParams);
            int randomstartX = getRandomstartX(getTopImage().getWidth() > 80 ? getTopImage().getWidth() - 80 : getTopImage().getWidth());
            int height = getTopImage().getHeight();
            imageView.setX(randomstartX);
            float f2 = height - 80;
            imageView.setY(f2);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "y", f2, height - 880);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(2000L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.5f);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.5f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setDuration(2000L);
            objectAnimatorOfFloat3.setDuration(2000L);
            objectAnimatorOfFloat4.setDuration(1000L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            animatorSet.start();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.player.LiveStreamingYoutube.makeFlyAnimation.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    LiveStreamingYoutube.this.getTopImage().removeView(imageView);
                }
            });
        } catch (Exception e2) {
            Log.d("MQTT", "makeFlyAnimation: " + e2.getMessage());
        }
    }

    private final void addRecordTime() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.get_video_logging, "", false, false);
    }

    public final int getRandomstartX(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : bound;
    }

    private final void pushEvent() {
        String str;
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = map;
        map2.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map2.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map2.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        if (TextUtils.isEmpty(this.video_name)) {
            str = "NA";
        } else {
            str = this.video_name;
            Intrinsics.checkNotNull(str);
        }
        map2.put(AnalyticsConstants.course_content_name, str);
        map2.put("action_type", "joined_live_class");
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.CLASS_PARTICIPATION, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openChooseMediaBottomSheet() {
        Utils.INSTANCE.openChooseMediaBottomSheet(this, new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(LiveStreamingYoutube.openChooseMediaBottomSheet$lambda$124(this.f$0));
            }
        }, new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.openChooseMediaBottomSheet$lambda$125(this.f$0);
            }
        }, new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.openChooseMediaBottomSheet$lambda$126(this.f$0);
            }
        }, new Function0() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda52
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LiveStreamingYoutube.openChooseMediaBottomSheet$lambda$127(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean openChooseMediaBottomSheet$lambda$124(LiveStreamingYoutube liveStreamingYoutube) {
        return Helper.isNetworkConnected(liveStreamingYoutube);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openChooseMediaBottomSheet$lambda$125(LiveStreamingYoutube liveStreamingYoutube) {
        liveStreamingYoutube.checkStoragePermission();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openChooseMediaBottomSheet$lambda$126(LiveStreamingYoutube liveStreamingYoutube) {
        liveStreamingYoutube.STORAGE_PERMISSION_TYPE = 3;
        liveStreamingYoutube.checkStoragePermission2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openChooseMediaBottomSheet$lambda$127(LiveStreamingYoutube liveStreamingYoutube) {
        String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        liveStreamingYoutube.showMessage(string);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isActivityVisible, reason: from getter */
    public final boolean getIsUserActive() {
        return this.isUserActive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher1$lambda$128(LiveStreamingYoutube liveStreamingYoutube, boolean z) {
        if (z) {
            PdfUtils pdfUtils = PdfUtils.INSTANCE;
            LiveStreamingYoutube liveStreamingYoutube2 = liveStreamingYoutube;
            String strValueOf = String.valueOf(liveStreamingYoutube.url);
            PDFView pDFView = liveStreamingYoutube.pdfViewPager;
            Intrinsics.checkNotNull(pDFView);
            ProgressBar progressBar = liveStreamingYoutube.progress_bar_pdf;
            Intrinsics.checkNotNull(progressBar);
            pdfUtils.downloadAndSavePdf(liveStreamingYoutube2, strValueOf, pDFView, progressBar);
            return;
        }
        liveStreamingYoutube.showMessage("Permission denied!");
    }

    /* JADX INFO: renamed from: isReviewSubmitted, reason: from getter */
    public final boolean getIsReviewSubmitted() {
        return this.isReviewSubmitted;
    }

    public final void setReviewSubmitted(boolean z) {
        this.isReviewSubmitted = z;
    }

    public final Utils.FeedbackBottomSheetDialog[] getFeedbackDialog() {
        return this.feedbackDialog;
    }

    private final void startAutoFeedbackTimer() {
        this.feedbackHandler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda85
            @Override // java.lang.Runnable
            public final void run() {
                LiveStreamingYoutube.startAutoFeedbackTimer$lambda$130(this.f$0);
            }
        };
        this.autoFeedbackRunnable = runnable;
        Handler handler = this.feedbackHandler;
        if (handler != null) {
            handler.postDelayed(runnable, this.FEEDBACK_AUTO_TRIGGER_TIME);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAutoFeedbackTimer$lambda$130(LiveStreamingYoutube liveStreamingYoutube) {
        Handler handler;
        liveStreamingYoutube.showAutoFeedback();
        Runnable runnable = liveStreamingYoutube.autoFeedbackRunnable;
        if (runnable != null && (handler = liveStreamingYoutube.feedbackHandler) != null) {
            handler.removeCallbacks(runnable);
        }
        liveStreamingYoutube.feedbackHandler = null;
        liveStreamingYoutube.autoFeedbackRunnable = null;
    }

    private final void showAutoFeedback() {
        if (this.isOperator || this.isReviewSubmitted || !isShowFeedback()) {
            return;
        }
        this.isFeedbackShown = true;
        openFeedbackBottomSheet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFeedbackOnBack() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.activityStartTime;
        if (!this.isOperator && !this.isReviewSubmitted && isShowFeedback() && !this.isFeedbackShown) {
            long j = this.FEEDBACK_MIN_WATCH_TIME;
            if (j > 0 && jCurrentTimeMillis >= j) {
                this.isFeedbackOpenByBack = true;
                openFeedbackBottomSheet();
                return;
            }
        }
        finish();
    }

    private final void manageFeedbackButton() {
        ImageView imageView;
        ImageView imageView2 = this.video_feedback;
        if (imageView2 != null) {
            imageView2.setVisibility(isShowFeedback() ? 0 : 8);
        }
        ImageView imageView3 = this.video_feedback;
        if (imageView3 != null && imageView3 != null && imageView3.getVisibility() == 0 && (imageView = this.video_feedback) != null) {
            imageView.setImageResource(this.isReviewSubmitted ? R.drawable.review_fill : R.drawable.review_unfill);
        }
        ImageView imageView4 = this.video_feedback;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.LiveStreamingYoutube$$ExternalSyntheticLambda73
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveStreamingYoutube.manageFeedbackButton$lambda$132(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void manageFeedbackButton$lambda$132(LiveStreamingYoutube liveStreamingYoutube, View view) {
        if (!Helper.isConnected(liveStreamingYoutube)) {
            String string = liveStreamingYoutube.getResources().getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            liveStreamingYoutube.showMessage(string);
        } else if (liveStreamingYoutube.isOperator) {
            liveStreamingYoutube.showMessage("Operator can not submit feedback.");
        } else {
            if (liveStreamingYoutube.isReviewSubmitted) {
                String string2 = liveStreamingYoutube.getResources().getString(R.string.feedback_already_submitted);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                liveStreamingYoutube.showMessage(string2);
                return;
            }
            liveStreamingYoutube.openFeedbackBottomSheet();
        }
    }

    private final void openFeedbackBottomSheet() {
        try {
            if (!isFinishing() && !isDestroyed() && !this.isFeedbackOpen && SystemClock.elapsedRealtime() - this.mLastClickTime >= 1000) {
                this.mLastClickTime = SystemClock.elapsedRealtime();
                this.isFeedbackOpen = true;
                this.feedbackDialog[0] = new Utils.FeedbackBottomSheetDialog(this, new Utils.FeedbackBottomSheetDialog.Listener() { // from class: com.appnew.android.player.LiveStreamingYoutube.openFeedbackBottomSheet.1
                    @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
                    public void onClose() {
                        LiveStreamingYoutube.this.feedbackDialogDismiss(false);
                    }

                    @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
                    public void onSubmit() {
                        String string;
                        Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = LiveStreamingYoutube.this.getFeedbackDialog()[0];
                        Intrinsics.checkNotNull(feedbackBottomSheetDialog);
                        RatingBar ratingBar = (RatingBar) feedbackBottomSheetDialog.findViewById(R.id.ratingBar);
                        Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog2 = LiveStreamingYoutube.this.getFeedbackDialog()[0];
                        EditText editText = feedbackBottomSheetDialog2 != null ? (EditText) feedbackBottomSheetDialog2.findViewById(R.id.ratingComment) : null;
                        LiveStreamingYoutube.this.rating = String.valueOf(ratingBar != null ? ratingBar.getRating() : 0.0f);
                        LiveStreamingYoutube liveStreamingYoutube = LiveStreamingYoutube.this;
                        if (editText != null) {
                            String string2 = editText.getText().toString();
                            int length = string2.length() - 1;
                            int i = 0;
                            boolean z = false;
                            while (i <= length) {
                                boolean z2 = Intrinsics.compare((int) string2.charAt(!z ? i : length), 32) <= 0;
                                if (z) {
                                    if (!z2) {
                                        break;
                                    } else {
                                        length--;
                                    }
                                } else if (z2) {
                                    i++;
                                } else {
                                    z = true;
                                }
                            }
                            string = string2.subSequence(i, length + 1).toString();
                        } else {
                            string = "";
                        }
                        liveStreamingYoutube.ratingMessage = string;
                        if ((ratingBar != null ? ratingBar.getRating() : 0.0f) <= 0.0f) {
                            LiveStreamingYoutube.this.showMessage("Please select rating!");
                        } else {
                            if (LiveStreamingYoutube.this.ratingMessage.length() == 0) {
                                LiveStreamingYoutube.this.showMessage("Please write feedback!");
                                return;
                            }
                            NetworkCall networkCall = LiveStreamingYoutube.this.getNetworkCall();
                            Intrinsics.checkNotNull(networkCall);
                            networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", true, false);
                        }
                    }
                });
                Utils utils = Utils.INSTANCE;
                Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = this.feedbackDialog[0];
                Intrinsics.checkNotNull(feedbackBottomSheetDialog);
                utils.bottomSheet(new Utils.FeedbackBottomSheetDialog[]{feedbackBottomSheetDialog});
                Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog2 = this.feedbackDialog[0];
                if (feedbackBottomSheetDialog2 != null) {
                    feedbackBottomSheetDialog2.show();
                }
            }
        } catch (Exception e2) {
            Log.d("TAG", "openFeedbackBottomSheet: " + e2.getMessage());
        }
    }

    public final void feedbackDialogDismiss(boolean isOnSubmit) {
        try {
            this.isFeedbackOpen = false;
            Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = this.feedbackDialog[0];
            if (feedbackBottomSheetDialog != null && feedbackBottomSheetDialog.isShowing()) {
                feedbackBottomSheetDialog.dismiss();
            }
            if (isOnSubmit) {
                Utils.INSTANCE.showGreetingDialog(this, "Thank’s for your valuable feedback !", this.isFeedbackOpenByBack ? new Utils.DialogDismissCallback() { // from class: com.appnew.android.player.LiveStreamingYoutube.feedbackDialogDismiss.2
                    @Override // com.appnew.android.player.music_player.Utils.DialogDismissCallback
                    public void onDismiss() {
                        LiveStreamingYoutube.this.finish();
                    }
                } : null);
            } else if (this.isFeedbackOpenByBack) {
                finish();
            }
            this.isFeedbackOpenByBack = false;
        } catch (Exception e2) {
            Log.d("TAG", "feedbackDialogDismiss: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isShowFeedback() {
        String string = SharedPreference.getInstance().getString(Const.LIVE_CLASS_FEEDBACK);
        return !TextUtils.isEmpty(string) && StringsKt.equals(string, "1", true);
    }
}
