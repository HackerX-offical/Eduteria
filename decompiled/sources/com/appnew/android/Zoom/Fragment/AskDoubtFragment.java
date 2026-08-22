package com.appnew.android.Zoom.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.ExoPlayer;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.ZoomModel.DoubtSubject;
import com.appnew.android.Model.ZoomModel.DoubtSubjectDetail;
import com.appnew.android.Model.ZoomModel.Topics;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.ProgressCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.RealPathUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Zoom.Activity.AllDoubtsFragmentKt;
import com.appnew.android.Zoom.Fragment.AskDoubtFragment;
import com.appnew.android.Zoom.ScannerActivity;
import com.appnew.android.databinding.FragmentAskDoubtBinding;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageView;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: AskDoubtFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u008f\u0001\u001a\u00030\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J \u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u0090\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J\n\u0010\u009a\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010\u009b\u0001\u001a\u00030\u0098\u0001H\u0002J\u0016\u0010\u009c\u0001\u001a\u00030\u0098\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0002J\n\u0010\u009d\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010\u009e\u0001\u001a\u00030\u0098\u0001H\u0002J\u0013\u0010\u009f\u0001\u001a\u00030\u0098\u00012\u0007\u0010 \u0001\u001a\u00020\u0011H\u0002J\n\u0010¡\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010\u009f\u0001\u001a\u00030\u0098\u0001H\u0002J\u0013\u0010¢\u0001\u001a\u00030\u0098\u00012\u0007\u0010£\u0001\u001a\u00020kH\u0002J\n\u0010®\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010¯\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010°\u0001\u001a\u00030\u0098\u0001H\u0002J\u001d\u0010±\u0001\u001a\u00020\u000b2\t\u0010²\u0001\u001a\u0004\u0018\u00010\\2\u0007\u0010³\u0001\u001a\u00020\u000bH\u0002J\u0011\u0010´\u0001\u001a\u00030\u0098\u00012\u0007\u0010µ\u0001\u001a\u00020\u000bJ4\u0010¶\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010·\u00012\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010º\u0001\u001a\u00030»\u0001H\u0016J3\u0010¼\u0001\u001a\u00030\u0098\u00012\b\u0010½\u0001\u001a\u00030¾\u00012\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010¿\u0001\u001a\u00020kH\u0016J+\u0010À\u0001\u001a\u00030\u0098\u00012\t\u0010½\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J\u0015\u0010Á\u0001\u001a\u00020k2\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016J\u0016\u0010Ä\u0001\u001a\u00030\u0098\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0002J\n\u0010Å\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010Æ\u0001\u001a\u00030\u0098\u0001H\u0002J\u0012\u0010Ç\u0001\u001a\u00030\u0098\u00012\b\u0010È\u0001\u001a\u00030\u0087\u0001J\b\u0010É\u0001\u001a\u00030\u0098\u0001J\n\u0010Ê\u0001\u001a\u00030\u0098\u0001H\u0002J\u001c\u0010Ë\u0001\u001a\u00030\u0098\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010È\u0001\u001a\u00030\u0087\u0001J\b\u0010Ì\u0001\u001a\u00030\u0098\u0001J\b\u0010Í\u0001\u001a\u00030\u0098\u0001J\u001c\u0010Î\u0001\u001a\u00030\u0098\u00012\u0010\u0010Ï\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ð\u0001\u0018\u00010\u0016H\u0016J\u001b\u0010Ñ\u0001\u001a\u00030\u0098\u00012\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0003\u0010Ó\u0001J\b\u0010Ô\u0001\u001a\u00030\u0098\u0001R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR\u001c\u0010-\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0019\"\u0004\b9\u0010\u001bR\u001a\u0010:\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\r\"\u0004\b;\u0010\u000fR\u0014\u0010<\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0014R\u0014\u0010>\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0014R\u0014\u0010@\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0014R\u0014\u0010B\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0014R\u0014\u0010D\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0014R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR \u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020QX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001c\u0010a\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\r\"\u0004\bc\u0010\u000fR\u001c\u0010d\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\r\"\u0004\bf\u0010\u000fR\u001c\u0010g\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\r\"\u0004\bi\u0010\u000fR\u000e\u0010j\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010w\u001a\u0004\u0018\u00010xX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0010\u0010}\u001a\u0004\u0018\u00010~X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0083\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\r\"\u0005\b\u0085\u0001\u0010\u000fR\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001d\u0010\u008c\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\r\"\u0005\b\u008e\u0001\u0010\u000fR!\u0010¤\u0001\u001a\u0014\u0012\u000f\u0012\r §\u0001*\u0005\u0018\u00010¦\u00010¦\u00010¥\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010¨\u0001\u001a\u0014\u0012\u000f\u0012\r §\u0001*\u0005\u0018\u00010©\u00010©\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001¨\u0006Õ\u0001"}, d2 = {"Lcom/appnew/android/Zoom/Fragment/AskDoubtFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/appnew/android/Utils/AmazonUpload/AmazonCallBack;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "Lcom/appnew/android/Utils/AmazonUpload/ProgressCallBack;", "<init>", "()V", "s3IU", "Lcom/appnew/android/Utils/AmazonUpload/s3ImageUploading;", "str_imgTypeClick", "", "getStr_imgTypeClick", "()Ljava/lang/String;", "setStr_imgTypeClick", "(Ljava/lang/String;)V", "requestCode", "", "REQUEST_CODE_PERMISSION_MULTIPLE", "getREQUEST_CODE_PERMISSION_MULTIPLE", "()I", "myPermissionConstantsArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Utils/AppPermissionsRunTime$MyPermissionConstants;", "getMyPermissionConstantsArrayList", "()Ljava/util/ArrayList;", "setMyPermissionConstantsArrayList", "(Ljava/util/ArrayList;)V", "binding", "Lcom/appnew/android/databinding/FragmentAskDoubtBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentAskDoubtBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentAskDoubtBinding;)V", "no_data_found_RL", "Landroid/widget/RelativeLayout;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "doubttext", "getDoubttext", "setDoubttext", "doubtposition", "getDoubtposition", "setDoubtposition", "doubtSubjectDetail", "Lcom/appnew/android/Model/ZoomModel/DoubtSubjectDetail;", "getDoubtSubjectDetail", "()Lcom/appnew/android/Model/ZoomModel/DoubtSubjectDetail;", "setDoubtSubjectDetail", "(Lcom/appnew/android/Model/ZoomModel/DoubtSubjectDetail;)V", "doubtSubjectArray", "Lcom/appnew/android/Model/ZoomModel/DoubtSubject;", "getDoubtSubjectArray", "setDoubtSubjectArray", "isSubjectClicked", "setSubjectClicked", "REQUEST_CODE_CAMERA_Profile", "getREQUEST_CODE_CAMERA_Profile", "REQUEST_CODE_CAMERA_ADHAR", "getREQUEST_CODE_CAMERA_ADHAR", "REQUEST_CODE_Profile_Gallery", "getREQUEST_CODE_Profile_Gallery", "REQUEST_CODE_Aadhar_Gallery", "getREQUEST_CODE_Aadhar_Gallery", "REQUEST_CODE_PDF", "getREQUEST_CODE_PDF", "profileIV", "Landroid/widget/ImageView;", "getProfileIV", "()Landroid/widget/ImageView;", "setProfileIV", "(Landroid/widget/ImageView;)V", "adharIV", "getAdharIV", "setAdharIV", "topicList", "", "Lcom/appnew/android/Model/ZoomModel/Topics;", "getTopicList", "()Ljava/util/List;", "setTopicList", "(Ljava/util/List;)V", "topic", "getTopic", "()Lcom/appnew/android/Model/ZoomModel/Topics;", "setTopic", "(Lcom/appnew/android/Model/ZoomModel/Topics;)V", "selectedImage", "Landroid/net/Uri;", "getSelectedImage", "()Landroid/net/Uri;", "setSelectedImage", "(Landroid/net/Uri;)V", "profilepic", "getProfilepic", "setProfilepic", Const.PDF, "getPdf", "setPdf", "doubt_audio", "getDoubt_audio", "setDoubt_audio", "tickValue", "", "seconds", "running", "wasRunning", "recordtime", "Landroid/widget/TextView;", "getRecordtime", "()Landroid/widget/TextView;", "setRecordtime", "(Landroid/widget/TextView;)V", "recorder", "Landroid/media/MediaRecorder;", "mediaPlayer", "Landroid/media/MediaPlayer;", "getMediaPlayer", "()Landroid/media/MediaPlayer;", "setMediaPlayer", "(Landroid/media/MediaPlayer;)V", "timer", "Ljava/util/Timer;", "fileName", "PERMISSION_TYPE", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "Chat_node", "getChat_node", "setChat_node", "play", "Landroid/widget/Button;", "getPlay", "()Landroid/widget/Button;", "setPlay", "(Landroid/widget/Button;)V", "filetype", "getFiletype", "setFiletype", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "hit_api_for_isbn_check", "handleOnCheck", "setClicks", "checkStoragePermissionPdf", "openChooser", "imgClick", "status", "checkStoragePermission", "post_doubt", "showProgress", "cropImage", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/canhub/cropper/CropImageContractOptions;", "kotlin.jvm.PlatformType", "someActivityResultLauncher", "Landroid/content/Intent;", "getSomeActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setSomeActivityResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "visibleAudioProgress", "visiblePdfProgress", "visibleImageProgress", "copyFileToInternalStorage", "uri", "newDirName", "setupDoc", "selectedURI", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "stopWatch", "runTimer", "stopRecording", "onRecordBtnClicked", "record", "pausePlayer", "startRecording", "starttimer", "stoptimer", "sendaudio", "onS3UploadData", Const.IMAGES, "Lcom/appnew/android/Model/MediaFile;", "onProgress", "value", "(Ljava/lang/Integer;)V", "refreshData", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AskDoubtFragment extends Fragment implements AmazonCallBack, NetworkCall.MyNetworkCallBack, PopupMenu.OnMenuItemClickListener, ProgressCallBack {
    public static final int $stable = 8;
    private int PERMISSION_TYPE;
    private ImageView adharIV;
    public FragmentAskDoubtBinding binding;
    private final ActivityResultLauncher<CropImageContractOptions> cropImage;
    private ArrayList<DoubtSubject> doubtSubjectArray;
    private DoubtSubjectDetail doubtSubjectDetail;
    private String doubt_audio;
    private String doubtposition;
    private String doubttext;
    private String fileName;
    private MediaPlayer mediaPlayer;
    private ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    private NetworkCall networkCall;
    private RelativeLayout no_data_found_RL;
    private String pdf;
    private Button play;
    private final ExoPlayer player;
    private ImageView profileIV;
    private String profilepic;
    private MediaRecorder recorder;
    private TextView recordtime;
    private boolean running;
    private s3ImageUploading s3IU;
    private int seconds;
    private Uri selectedImage;
    private ActivityResultLauncher<Intent> someActivityResultLauncher;
    private boolean tickValue;
    private Timer timer;
    public Topics topic;
    public List<Topics> topicList;
    private boolean wasRunning;
    private String str_imgTypeClick = "";
    private int requestCode = -1;
    private final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    private String isSubjectClicked = "0";
    private final int REQUEST_CODE_CAMERA_Profile = 200;
    private final int REQUEST_CODE_CAMERA_ADHAR = 201;
    private final int REQUEST_CODE_Profile_Gallery = 100;
    private final int REQUEST_CODE_Aadhar_Gallery = 101;
    private final int REQUEST_CODE_PDF = 10001;
    private String Chat_node = "";
    private String filetype = "";

    public final void refreshData() {
    }

    public AskDoubtFragment() {
        ActivityResultLauncher<CropImageContractOptions> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda20
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AskDoubtFragment.cropImage$lambda$17(this.f$0, (CropImageView.CropResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.cropImage = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda21
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AskDoubtFragment.someActivityResultLauncher$lambda$18(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.someActivityResultLauncher = activityResultLauncherRegisterForActivityResult2;
    }

    public final String getStr_imgTypeClick() {
        return this.str_imgTypeClick;
    }

    public final void setStr_imgTypeClick(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.str_imgTypeClick = str;
    }

    public final int getREQUEST_CODE_PERMISSION_MULTIPLE() {
        return this.REQUEST_CODE_PERMISSION_MULTIPLE;
    }

    public final ArrayList<AppPermissionsRunTime.MyPermissionConstants> getMyPermissionConstantsArrayList() {
        return this.myPermissionConstantsArrayList;
    }

    public final void setMyPermissionConstantsArrayList(ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList) {
        this.myPermissionConstantsArrayList = arrayList;
    }

    public final FragmentAskDoubtBinding getBinding() {
        FragmentAskDoubtBinding fragmentAskDoubtBinding = this.binding;
        if (fragmentAskDoubtBinding != null) {
            return fragmentAskDoubtBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentAskDoubtBinding fragmentAskDoubtBinding) {
        Intrinsics.checkNotNullParameter(fragmentAskDoubtBinding, "<set-?>");
        this.binding = fragmentAskDoubtBinding;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final String getDoubttext() {
        return this.doubttext;
    }

    public final void setDoubttext(String str) {
        this.doubttext = str;
    }

    public final String getDoubtposition() {
        return this.doubtposition;
    }

    public final void setDoubtposition(String str) {
        this.doubtposition = str;
    }

    public final DoubtSubjectDetail getDoubtSubjectDetail() {
        return this.doubtSubjectDetail;
    }

    public final void setDoubtSubjectDetail(DoubtSubjectDetail doubtSubjectDetail) {
        this.doubtSubjectDetail = doubtSubjectDetail;
    }

    public final ArrayList<DoubtSubject> getDoubtSubjectArray() {
        return this.doubtSubjectArray;
    }

    public final void setDoubtSubjectArray(ArrayList<DoubtSubject> arrayList) {
        this.doubtSubjectArray = arrayList;
    }

    /* JADX INFO: renamed from: isSubjectClicked, reason: from getter */
    public final String getIsSubjectClicked() {
        return this.isSubjectClicked;
    }

    public final void setSubjectClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isSubjectClicked = str;
    }

    public final int getREQUEST_CODE_CAMERA_Profile() {
        return this.REQUEST_CODE_CAMERA_Profile;
    }

    public final int getREQUEST_CODE_CAMERA_ADHAR() {
        return this.REQUEST_CODE_CAMERA_ADHAR;
    }

    public final int getREQUEST_CODE_Profile_Gallery() {
        return this.REQUEST_CODE_Profile_Gallery;
    }

    public final int getREQUEST_CODE_Aadhar_Gallery() {
        return this.REQUEST_CODE_Aadhar_Gallery;
    }

    public final int getREQUEST_CODE_PDF() {
        return this.REQUEST_CODE_PDF;
    }

    public final ImageView getProfileIV() {
        return this.profileIV;
    }

    public final void setProfileIV(ImageView imageView) {
        this.profileIV = imageView;
    }

    public final ImageView getAdharIV() {
        return this.adharIV;
    }

    public final void setAdharIV(ImageView imageView) {
        this.adharIV = imageView;
    }

    public final List<Topics> getTopicList() {
        List<Topics> list = this.topicList;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topicList");
        return null;
    }

    public final void setTopicList(List<Topics> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.topicList = list;
    }

    public final Topics getTopic() {
        Topics topics = this.topic;
        if (topics != null) {
            return topics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topic");
        return null;
    }

    public final void setTopic(Topics topics) {
        Intrinsics.checkNotNullParameter(topics, "<set-?>");
        this.topic = topics;
    }

    public final Uri getSelectedImage() {
        return this.selectedImage;
    }

    public final void setSelectedImage(Uri uri) {
        this.selectedImage = uri;
    }

    public final String getProfilepic() {
        return this.profilepic;
    }

    public final void setProfilepic(String str) {
        this.profilepic = str;
    }

    public final String getPdf() {
        return this.pdf;
    }

    public final void setPdf(String str) {
        this.pdf = str;
    }

    public final String getDoubt_audio() {
        return this.doubt_audio;
    }

    public final void setDoubt_audio(String str) {
        this.doubt_audio = str;
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

    public final String getChat_node() {
        return this.Chat_node;
    }

    public final void setChat_node(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Chat_node = str;
    }

    public final Button getPlay() {
        return this.play;
    }

    public final void setPlay(Button button) {
        this.play = button;
    }

    public final String getFiletype() {
        return this.filetype;
    }

    public final void setFiletype(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filetype = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentAskDoubtBinding.inflate(inflater, container, false));
        ScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.networkCall = new NetworkCall(this, getContext());
        this.doubtSubjectArray = new ArrayList<>();
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        if (Helper.isConnected(getContext())) {
            NetworkCall networkCall = this.networkCall;
            if (networkCall != null) {
                networkCall.NetworkAPICall(API.API_GET_DOUBT_SUBJECT_LIST, "", false, false);
            }
        } else {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            ExtensionFucationKt.showToast(contextRequireContext, "No Internet Connection!!");
        }
        getBinding().progressBarPdf.setIndeterminate(false);
        getBinding().progressBarPdf.setProgress(0);
        getBinding().progressBarPdf.setMax(100);
        getBinding().progressBarPdf.setMin(0);
        getBinding().progressBarAudio.setIndeterminate(false);
        getBinding().progressBarImage.setProgress(0);
        getBinding().progressBarAudio.setMax(100);
        getBinding().progressBarAudio.setMin(0);
        getBinding().progressBarImage.setIndeterminate(false);
        getBinding().progressBarImage.setMax(100);
        getBinding().progressBarImage.setProgress(0);
        getBinding().progressBarAudio.setMin(0);
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.DOUBT_TOPIC), "1", true)) {
            getBinding().topic.setVisibility(0);
        }
        getBinding().checkBoxDoubt.setChecked(this.tickValue);
        getBinding().errorReportIcon.setTooltipText(getString(R.string.doubt_report_error_message));
        getBinding().errorReportIcon.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AskDoubtFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        handleOnCheck();
        setClicks(savedInstanceState);
        getBinding().isbnTV.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment.onViewCreated.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "editable");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Intrinsics.checkNotNullParameter(charSequence, "charSequence");
                TextView textView = AskDoubtFragment.this.getBinding().bookNoTV;
                Intrinsics.checkNotNull(textView);
                textView.setText("");
                if (AskDoubtFragment.this.getBinding().isbnTV.getText().toString().length() == 13) {
                    if (new Regex("[0-9]+").matches(AskDoubtFragment.this.getBinding().isbnTV.getText().toString())) {
                        AskDoubtFragment.this.hit_api_for_isbn_check();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(AskDoubtFragment askDoubtFragment, View view) {
        askDoubtFragment.getBinding().errorReportIcon.performLongClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hit_api_for_isbn_check() {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_CHECK_ISBN, "", true, false);
        }
    }

    private final void handleOnCheck() {
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.DOUBT_ISBN_BASED), "1", true)) {
            getBinding().ISBNRL.setVisibility(0);
            RelativeLayout relativeLayout = getBinding().bookNoRelative;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(0);
            getBinding().pageNoRelative.setVisibility(0);
            getBinding().questionNoRL.setVisibility(0);
            getBinding().checkbox.setVisibility(0);
            return;
        }
        getBinding().ISBNRL.setVisibility(8);
        RelativeLayout relativeLayout2 = getBinding().bookNoRelative;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setVisibility(8);
        getBinding().pageNoRelative.setVisibility(8);
        getBinding().questionNoRL.setVisibility(8);
        getBinding().checkbox.setVisibility(8);
    }

    private final void setClicks(final Bundle savedInstanceState) {
        getBinding().topicspinner.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$1(this.f$0);
            }
        }));
        getBinding().camScannerIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AskDoubtFragment.setClicks$lambda$2(this.f$0, view);
            }
        });
        getBinding().submitDoubt.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$3(this.f$0);
            }
        }));
        getBinding().subjectTV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$4(this.f$0);
            }
        }));
        getBinding().addPdf.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$5(this.f$0);
            }
        }));
        getBinding().doubtImage.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$6(this.f$0);
            }
        }));
        getBinding().uploadAudio.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$7(this.f$0, savedInstanceState);
            }
        }));
        getBinding().checkBoxDoubt.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$8(this.f$0);
            }
        }));
        getBinding().crossPdf.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$9(this.f$0);
            }
        }));
        getBinding().crossImage.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$10(this.f$0);
            }
        }));
        getBinding().crossAudio.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$11(this.f$0);
            }
        }));
        getBinding().deletePdf.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$12(this.f$0);
            }
        }));
        getBinding().deleteImage.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$13(this.f$0);
            }
        }));
        getBinding().deleteAudio.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AskDoubtFragment.setClicks$lambda$14(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$1(AskDoubtFragment askDoubtFragment) {
        if (askDoubtFragment.topicList != null && askDoubtFragment.getTopicList().size() > 0) {
            askDoubtFragment.isSubjectClicked = "2";
            FragmentActivity fragmentActivityRequireActivity = askDoubtFragment.requireActivity();
            TextView textView = askDoubtFragment.getBinding().topicspinner;
            Intrinsics.checkNotNull(textView);
            PopupMenu popupMenu = new PopupMenu(fragmentActivityRequireActivity, textView, 17);
            int size = askDoubtFragment.getTopicList().size();
            for (int i = 0; i < size; i++) {
                popupMenu.getMenu().add(askDoubtFragment.getTopicList().get(i).getName());
            }
            popupMenu.setOnMenuItemClickListener(askDoubtFragment);
            popupMenu.show();
        } else {
            Context contextRequireContext = askDoubtFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            ExtensionFucationKt.showToast(contextRequireContext, "Please Select Subject First");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$2(AskDoubtFragment askDoubtFragment, View view) {
        askDoubtFragment.startActivityForResult(new Intent(askDoubtFragment.getActivity(), (Class<?>) ScannerActivity.class).putExtra("isIsbn", true), 1212);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
    
        if (new kotlin.text.Regex("[0-9]+").matches(r8.getBinding().isbnTV.getText().toString()) == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit setClicks$lambda$3(com.appnew.android.Zoom.Fragment.AskDoubtFragment r8) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Zoom.Fragment.AskDoubtFragment.setClicks$lambda$3(com.appnew.android.Zoom.Fragment.AskDoubtFragment):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$4(AskDoubtFragment askDoubtFragment) {
        askDoubtFragment.isSubjectClicked = "1";
        PopupMenu popupMenu = new PopupMenu(askDoubtFragment.requireActivity(), askDoubtFragment.getBinding().subjectTV, 17);
        ArrayList<DoubtSubject> arrayList = askDoubtFragment.doubtSubjectArray;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Menu menu = popupMenu.getMenu();
            ArrayList<DoubtSubject> arrayList2 = askDoubtFragment.doubtSubjectArray;
            Intrinsics.checkNotNull(arrayList2);
            menu.add(arrayList2.get(i).getName());
        }
        popupMenu.setOnMenuItemClickListener(askDoubtFragment);
        popupMenu.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$5(AskDoubtFragment askDoubtFragment) {
        askDoubtFragment.checkStoragePermissionPdf();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$6(AskDoubtFragment askDoubtFragment) {
        askDoubtFragment.checkStoragePermission();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$7(AskDoubtFragment askDoubtFragment, Bundle bundle) {
        askDoubtFragment.stopWatch(bundle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$8(AskDoubtFragment askDoubtFragment) {
        if (askDoubtFragment.tickValue) {
            askDoubtFragment.getBinding().checkBoxDoubt.setChecked(false);
            askDoubtFragment.tickValue = false;
        } else {
            askDoubtFragment.getBinding().checkBoxDoubt.setChecked(true);
            askDoubtFragment.tickValue = true;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$9(AskDoubtFragment askDoubtFragment) {
        askDoubtFragment.pdf = "";
        askDoubtFragment.getBinding().uploadPdfTV.setText("Uploading Pdf");
        askDoubtFragment.getBinding().addPdf.setVisibility(0);
        askDoubtFragment.getBinding().doubtSetPdf.setVisibility(8);
        askDoubtFragment.getBinding().progressBarPdf.setVisibility(8);
        askDoubtFragment.getBinding().crossPdf.setVisibility(8);
        askDoubtFragment.getBinding().deletePdf.setVisibility(8);
        askDoubtFragment.getBinding().uploadPdfTV.setVisibility(8);
        s3ImageUploading s3imageuploading = askDoubtFragment.s3IU;
        Intrinsics.checkNotNull(s3imageuploading);
        s3imageuploading.cancel(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$10(AskDoubtFragment askDoubtFragment) {
        askDoubtFragment.profilepic = "";
        askDoubtFragment.getBinding().uploadImageTv.setText("Uploading Image");
        askDoubtFragment.getBinding().doubtImage.setVisibility(0);
        askDoubtFragment.getBinding().doubtSetImage.setVisibility(8);
        askDoubtFragment.getBinding().progressBarImage.setVisibility(8);
        askDoubtFragment.getBinding().crossImage.setVisibility(8);
        askDoubtFragment.getBinding().deleteImage.setVisibility(8);
        askDoubtFragment.getBinding().uploadImageTv.setVisibility(8);
        s3ImageUploading s3imageuploading = askDoubtFragment.s3IU;
        if (s3imageuploading != null) {
            Intrinsics.checkNotNull(s3imageuploading);
            s3imageuploading.cancel(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$11(AskDoubtFragment askDoubtFragment) {
        askDoubtFragment.doubt_audio = "";
        askDoubtFragment.getBinding().uploadAudioTV.setText("Uploading Audio");
        askDoubtFragment.getBinding().uploadAudio.setVisibility(0);
        askDoubtFragment.getBinding().doubtSetAudio.setVisibility(8);
        askDoubtFragment.getBinding().progressBarAudio.setVisibility(8);
        askDoubtFragment.getBinding().crossAudio.setVisibility(8);
        askDoubtFragment.getBinding().deleteAudio.setVisibility(8);
        askDoubtFragment.getBinding().uploadAudioTV.setVisibility(8);
        s3ImageUploading s3imageuploading = askDoubtFragment.s3IU;
        if (s3imageuploading != null) {
            Intrinsics.checkNotNull(s3imageuploading);
            s3imageuploading.cancel(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$12(AskDoubtFragment askDoubtFragment) {
        askDoubtFragment.pdf = "";
        askDoubtFragment.getBinding().uploadPdfTV.setText("Uploading Pdf");
        askDoubtFragment.getBinding().addPdf.setVisibility(0);
        askDoubtFragment.getBinding().doubtSetPdf.setVisibility(8);
        askDoubtFragment.getBinding().progressBarPdf.setVisibility(8);
        askDoubtFragment.getBinding().crossPdf.setVisibility(8);
        askDoubtFragment.getBinding().deletePdf.setVisibility(8);
        askDoubtFragment.getBinding().uploadPdfTV.setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$13(AskDoubtFragment askDoubtFragment) {
        askDoubtFragment.profilepic = "";
        askDoubtFragment.getBinding().uploadImageTv.setText("Uploading Image");
        askDoubtFragment.getBinding().doubtImage.setVisibility(0);
        askDoubtFragment.getBinding().doubtSetImage.setVisibility(8);
        askDoubtFragment.getBinding().progressBarImage.setVisibility(8);
        askDoubtFragment.getBinding().crossImage.setVisibility(8);
        askDoubtFragment.getBinding().deleteImage.setVisibility(8);
        askDoubtFragment.getBinding().uploadImageTv.setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$14(AskDoubtFragment askDoubtFragment) {
        askDoubtFragment.doubt_audio = "";
        askDoubtFragment.getBinding().uploadAudioTV.setText("Uploading Audio");
        askDoubtFragment.getBinding().uploadAudio.setVisibility(0);
        askDoubtFragment.getBinding().doubtSetAudio.setVisibility(8);
        askDoubtFragment.getBinding().progressBarAudio.setVisibility(8);
        askDoubtFragment.getBinding().crossAudio.setVisibility(8);
        askDoubtFragment.getBinding().deleteAudio.setVisibility(8);
        askDoubtFragment.getBinding().uploadAudioTV.setVisibility(8);
        return Unit.INSTANCE;
    }

    private final void checkStoragePermissionPdf() {
        Dexter.withContext(getActivity()).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment.checkStoragePermissionPdf.1
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Intrinsics.checkNotNullParameter(report, "report");
                if (Helper.isConnected(AskDoubtFragment.this.getContext())) {
                    AskDoubtFragment.this.openChooser();
                    return;
                }
                Context context = AskDoubtFragment.this.getContext();
                if (context != null) {
                    String string = AskDoubtFragment.this.requireContext().getResources().getString(R.string.no_internet_connection);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    XtensionFunctionKt.showSmallLengthToast(context, string);
                }
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
    public final void openChooser() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/pdf");
            this.someActivityResultLauncher.launch(intent);
            this.requestCode = this.REQUEST_CODE_PDF;
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private final void imgClick(final int status) {
        if (Integer.valueOf(status).equals(1)) {
            this.someActivityResultLauncher.launch(new Intent("android.media.action.IMAGE_CAPTURE"));
            this.requestCode = this.REQUEST_CODE_CAMERA_Profile;
            return;
        }
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda19
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AskDoubtFragment.imgClick$lambda$15(charSequenceArr, status, this, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imgClick$lambda$15(CharSequence[] charSequenceArr, int i, AskDoubtFragment askDoubtFragment, DialogInterface dialogInterface, int i2) {
        try {
            if (Intrinsics.areEqual(charSequenceArr[i2], "Take Photo")) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                if (Integer.valueOf(i).equals(1)) {
                    askDoubtFragment.requestCode = askDoubtFragment.REQUEST_CODE_CAMERA_Profile;
                } else {
                    askDoubtFragment.requestCode = askDoubtFragment.REQUEST_CODE_CAMERA_ADHAR;
                }
                askDoubtFragment.someActivityResultLauncher.launch(intent);
                askDoubtFragment.str_imgTypeClick = "PhotoCameraRequest";
                return;
            }
            if (Intrinsics.areEqual(charSequenceArr[i2], "Choose from Gallery")) {
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                if (Integer.valueOf(i).equals(1)) {
                    askDoubtFragment.requestCode = askDoubtFragment.REQUEST_CODE_Profile_Gallery;
                } else {
                    askDoubtFragment.requestCode = askDoubtFragment.REQUEST_CODE_Aadhar_Gallery;
                }
                askDoubtFragment.someActivityResultLauncher.launch(intent2);
                askDoubtFragment.str_imgTypeClick = "PhotoGalleryRequest";
                return;
            }
            if (Intrinsics.areEqual(charSequenceArr[i2], "Cancel")) {
                dialogInterface.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    private final void checkStoragePermission() {
        Dexter.withContext(getActivity()).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment.checkStoragePermission.1
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Intrinsics.checkNotNullParameter(report, "report");
                if (Helper.isConnected(AskDoubtFragment.this.getContext())) {
                    AskDoubtFragment.this.imgClick();
                    return;
                }
                Context context = AskDoubtFragment.this.getContext();
                if (context != null) {
                    String string = AskDoubtFragment.this.requireContext().getResources().getString(R.string.no_internet_connection);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    XtensionFunctionKt.showSmallLengthToast(context, string);
                }
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
    public final void imgClick() {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AskDoubtFragment.imgClick$lambda$16(charSequenceArr, this, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imgClick$lambda$16(CharSequence[] charSequenceArr, AskDoubtFragment askDoubtFragment, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (Intrinsics.areEqual(charSequenceArr[i], "Take Photo")) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Context context = askDoubtFragment.getContext();
                Uri uriForFile = FileProvider.getUriForFile(askDoubtFragment.requireActivity(), "com.eduteria.app.app.provider", new File(context != null ? context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : null, "temp_image.jpg"));
                askDoubtFragment.str_imgTypeClick = "PhotoCameraRequest";
                intent.putExtra("output", uriForFile);
                askDoubtFragment.someActivityResultLauncher.launch(intent);
                askDoubtFragment.requestCode = 10000;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(charSequenceArr[i], "Choose from Gallery")) {
            Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Context context2 = askDoubtFragment.getContext();
            Uri uriForFile2 = FileProvider.getUriForFile(askDoubtFragment.requireActivity(), "com.eduteria.app.app.provider", new File(context2 != null ? context2.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : null, "temp_gallery.jpg"));
            askDoubtFragment.str_imgTypeClick = "PhotoGalleryRequest";
            intent2.putExtra("output", uriForFile2);
            askDoubtFragment.someActivityResultLauncher.launch(intent2);
            askDoubtFragment.requestCode = 20000;
            return;
        }
        if (Intrinsics.areEqual(charSequenceArr[i], "Cancel")) {
            dialog.dismiss();
        }
    }

    private final void post_doubt(boolean showProgress) {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_POST_DOUBT, "", showProgress, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cropImage$lambda$17(AskDoubtFragment askDoubtFragment, CropImageView.CropResult result) {
        Uri uriContent;
        Intrinsics.checkNotNullParameter(result, "result");
        if (!result.isSuccessful()) {
            Log.d("TAGCropImage", "CropImage: " + result.getError());
            return;
        }
        if (StringsKt.equals(askDoubtFragment.str_imgTypeClick, "PhotoCameraRequest", true)) {
            Uri uriContent2 = result.getUriContent();
            if (uriContent2 != null) {
                try {
                    Context context = askDoubtFragment.getContext();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(context != null ? context.getContentResolver() : null, uriContent2);
                    Context context2 = askDoubtFragment.getContext();
                    new File((context2 != null ? context2.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : null) + "/EDUTERIA/DoubtImage/").mkdirs();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    askDoubtFragment.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", askDoubtFragment.getContext(), askDoubtFragment, null, true, askDoubtFragment);
                    ArrayList arrayList = new ArrayList();
                    MediaFile mediaFile = new MediaFile();
                    mediaFile.setFile_type("image");
                    mediaFile.setImage(bitmapDecodeStream);
                    arrayList.add(mediaFile);
                    s3ImageUploading s3imageuploading = askDoubtFragment.s3IU;
                    Intrinsics.checkNotNull(s3imageuploading);
                    s3imageuploading.execute(arrayList);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (!StringsKt.equals(askDoubtFragment.str_imgTypeClick, "PhotoGalleryRequest", true) || (uriContent = result.getUriContent()) == null) {
            return;
        }
        try {
            Context context3 = askDoubtFragment.getContext();
            Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(context3 != null ? context3.getContentResolver() : null, uriContent);
            Context context4 = askDoubtFragment.getContext();
            new File((context4 != null ? context4.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : null) + "/EDUTERIA/DoubtImage/").mkdirs();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream2);
            Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream2.toByteArray()));
            byteArrayOutputStream2.flush();
            byteArrayOutputStream2.close();
            askDoubtFragment.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", askDoubtFragment.getContext(), askDoubtFragment, null, true, askDoubtFragment);
            ArrayList arrayList2 = new ArrayList();
            MediaFile mediaFile2 = new MediaFile();
            mediaFile2.setFile_type("image");
            mediaFile2.setImage(bitmapDecodeStream2);
            arrayList2.add(mediaFile2);
            s3ImageUploading s3imageuploading2 = askDoubtFragment.s3IU;
            Intrinsics.checkNotNull(s3imageuploading2);
            s3imageuploading2.execute(arrayList2);
        } catch (IOException e3) {
            e3.printStackTrace();
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
    public static final void someActivityResultLauncher$lambda$18(AskDoubtFragment askDoubtFragment, ActivityResult result) {
        Intent data;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            if (askDoubtFragment.requestCode == askDoubtFragment.REQUEST_CODE_Profile_Gallery) {
                ImageView imageView = askDoubtFragment.profileIV;
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(0);
                ImageView imageView2 = askDoubtFragment.profileIV;
                Intrinsics.checkNotNull(imageView2);
                Intent data2 = result.getData();
                imageView2.setImageURI(data2 != null ? data2.getData() : null);
            }
            if (askDoubtFragment.requestCode == askDoubtFragment.REQUEST_CODE_CAMERA_Profile && result.getData() != null) {
                ImageView imageView3 = askDoubtFragment.profileIV;
                Intrinsics.checkNotNull(imageView3);
                imageView3.setVisibility(0);
                ImageView imageView4 = askDoubtFragment.profileIV;
                Intrinsics.checkNotNull(imageView4);
                Intent data3 = result.getData();
                Bundle extras = data3 != null ? data3.getExtras() : null;
                Intrinsics.checkNotNull(extras);
                Object obj = extras.get("data");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Bitmap");
                imageView4.setImageBitmap((Bitmap) obj);
            }
            if (askDoubtFragment.requestCode == askDoubtFragment.REQUEST_CODE_CAMERA_ADHAR && result.getData() != null) {
                ImageView imageView5 = askDoubtFragment.adharIV;
                Intrinsics.checkNotNull(imageView5);
                imageView5.setVisibility(0);
                ImageView imageView6 = askDoubtFragment.adharIV;
                Intrinsics.checkNotNull(imageView6);
                Intent data4 = result.getData();
                Bundle extras2 = data4 != null ? data4.getExtras() : null;
                Intrinsics.checkNotNull(extras2);
                Object obj2 = extras2.get("data");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.graphics.Bitmap");
                imageView6.setImageBitmap((Bitmap) obj2);
            }
            int i = askDoubtFragment.requestCode;
            if (i == 10000) {
                try {
                    FragmentActivity activity = askDoubtFragment.getActivity();
                    File file = new File(String.valueOf(activity != null ? activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : null));
                    Iterator it = ArrayIteratorKt.iterator(file.listFiles());
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        File file2 = (File) it.next();
                        if (Intrinsics.areEqual(file2.getName(), "temp_image.jpg")) {
                            file = file2;
                            break;
                        }
                    }
                    Uri uriForFile = FileProvider.getUriForFile(askDoubtFragment.requireActivity(), "com.eduteria.app.app.provider", file);
                    ActivityResultLauncher<CropImageContractOptions> activityResultLauncher = askDoubtFragment.cropImage;
                    CropImageOptions cropImageOptions = Helper.cropImageOptions(askDoubtFragment.requireActivity());
                    Intrinsics.checkNotNullExpressionValue(cropImageOptions, "cropImageOptions(...)");
                    activityResultLauncher.launch(new CropImageContractOptions(uriForFile, cropImageOptions));
                    askDoubtFragment.visibleImageProgress();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (i == 20000) {
                try {
                    Intent data5 = result.getData();
                    Intrinsics.checkNotNull(data5);
                    Uri data6 = data5.getData();
                    ActivityResultLauncher<CropImageContractOptions> activityResultLauncher2 = askDoubtFragment.cropImage;
                    CropImageOptions cropImageOptions2 = Helper.cropImageOptions(askDoubtFragment.requireActivity());
                    Intrinsics.checkNotNullExpressionValue(cropImageOptions2, "cropImageOptions(...)");
                    activityResultLauncher2.launch(new CropImageContractOptions(data6, cropImageOptions2));
                    askDoubtFragment.visibleImageProgress();
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (i == askDoubtFragment.REQUEST_CODE_PDF && result.getData() != null) {
                if (Build.VERSION.SDK_INT >= 30) {
                    Intent data7 = result.getData();
                    Uri data8 = data7 != null ? data7.getData() : null;
                    String string = askDoubtFragment.getResources().getString(R.string.pdf_path_last_segment);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    askDoubtFragment.setupDoc(askDoubtFragment.copyFileToInternalStorage(data8, string));
                } else {
                    Context contextRequireContext = askDoubtFragment.requireContext();
                    Intent data9 = result.getData();
                    String path = RealPathUtil.getPath(contextRequireContext, data9 != null ? data9.getData() : null);
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    askDoubtFragment.setupDoc(path);
                }
                askDoubtFragment.visiblePdfProgress();
                return;
            }
            if (askDoubtFragment.requestCode != 1212 || result.getData() == null || (data = result.getData()) == null || !data.hasExtra("code")) {
                return;
            }
            Intent data10 = result.getData();
            String stringExtra = data10 != null ? data10.getStringExtra("code") : null;
            Intrinsics.checkNotNull(stringExtra);
            Boolean boolValueOf = stringExtra != null ? Boolean.valueOf(new Regex("[0-9]+").matches(stringExtra)) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (!boolValueOf.booleanValue()) {
                Toast.makeText(askDoubtFragment.getContext(), "Scan valid QR code", 0).show();
            } else if (stringExtra.length() == 13) {
                askDoubtFragment.getBinding().isbnTV.setText(stringExtra);
            } else {
                Toast.makeText(askDoubtFragment.getContext(), "Scan valid QR code", 0).show();
            }
        }
    }

    private final void visibleAudioProgress() {
        getBinding().uploadAudioProgress.setVisibility(0);
        getBinding().crossAudio.setVisibility(0);
        getBinding().uploadAudioTV.setVisibility(0);
        getBinding().deleteAudio.setVisibility(8);
        getBinding().progressBarAudio.setVisibility(0);
        this.filetype = "audio";
    }

    private final void visiblePdfProgress() {
        getBinding().uploadPdf.setVisibility(0);
        getBinding().crossPdf.setVisibility(0);
        getBinding().uploadPdfTV.setVisibility(0);
        getBinding().deletePdf.setVisibility(8);
        getBinding().progressBarPdf.setVisibility(0);
        this.filetype = Const.PDF;
    }

    private final void visibleImageProgress() {
        getBinding().uploadImage.setVisibility(0);
        getBinding().crossImage.setVisibility(0);
        getBinding().uploadImageTv.setVisibility(0);
        getBinding().deleteImage.setVisibility(8);
        getBinding().progressBarImage.setVisibility(0);
        this.filetype = "image";
    }

    private final String copyFileToInternalStorage(Uri uri, String newDirName) {
        File file;
        Intrinsics.checkNotNull(uri);
        Cursor cursorQuery = requireActivity().getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        Intrinsics.checkNotNull(cursorQuery);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        if (!Intrinsics.areEqual(newDirName, "")) {
            FragmentActivity activity = getActivity();
            File file2 = new File((activity != null ? activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : null) + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName);
            if (!file2.exists()) {
                file2.mkdir();
            }
            FragmentActivity activity2 = getActivity();
            file = new File((activity2 != null ? activity2.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : null) + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        } else {
            FragmentActivity activity3 = getActivity();
            file = new File((activity3 != null ? activity3.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : null) + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        }
        try {
            if (!file.exists()) {
                InputStream inputStreamOpenInputStream = requireActivity().getContentResolver().openInputStream(uri);
                Intrinsics.checkNotNull(inputStreamOpenInputStream);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                inputStreamOpenInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return path;
    }

    public final void setupDoc(String selectedURI) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(selectedURI, "selectedURI");
        MediaFile mediaFile = new MediaFile();
        ArrayList arrayList = new ArrayList();
        String str = selectedURI;
        if (!TextUtils.isEmpty(str)) {
            String string = getResources().getString(R.string.pdf_extension);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) string, false, 2, (Object) null)) {
                String string2 = getResources().getString(R.string.doc_extension);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                if (!StringsKt.contains$default((CharSequence) str, (CharSequence) string2, false, 2, (Object) null)) {
                    String string3 = getResources().getString(R.string.xls_extension);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    if (!StringsKt.contains$default((CharSequence) str, (CharSequence) string3, false, 2, (Object) null)) {
                        Toast.makeText(requireContext(), getResources().getString(R.string.file_format_error), 0).show();
                        return;
                    }
                }
            }
        }
        String string4 = getResources().getString(R.string.pdf_extension);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) string4, false, 2, (Object) null)) {
            mediaFile.setImage(BitmapFactory.decodeResource(getResources(), R.mipmap.pdf));
            mediaFile.setFile_type(Const.PDF);
        }
        String str2 = this.Chat_node;
        this.s3IU = new s3ImageUploading(str2, "vc-10000386-38616500102/application/chat_system/" + str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, requireContext(), this, null, true, this);
        List<String> listSplit = new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(str, 0);
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
        mediaFile.setFile_name(strArr[strArr.length - 1]);
        mediaFile.setFile(selectedURI);
        mediaFile.setFile_type(Const.PDF);
        arrayList.add(mediaFile);
        s3ImageUploading s3imageuploading = this.s3IU;
        Intrinsics.checkNotNull(s3imageuploading);
        s3imageuploading.execute(arrayList);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (apitype == null) {
            return null;
        }
        int iHashCode = apitype.hashCode();
        if (iHashCode == -777181156) {
            if (!apitype.equals(API.API_GET_CHECK_ISBN)) {
                return null;
            }
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setIsbn_number(getBinding().isbnTV.getText().toString());
            return service.postcheckIsbn(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (iHashCode != 184494493) {
            if (iHashCode == 1834484300 && apitype.equals(API.API_GET_DOUBT_SUBJECT_LIST)) {
                return service.postSubjectList(AES.encrypt(new Gson().toJson(new EncryptionData())));
            }
            return null;
        }
        if (!apitype.equals(API.API_GET_POST_DOUBT)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        if (this.topic != null) {
            encryptionData2.setSubject_id(getTopic().getSubject_id());
            encryptionData2.setTopic_id(getTopic().getId());
        } else {
            encryptionData2.setSubject_id(this.doubtposition);
        }
        encryptionData2.setMessage(this.doubttext);
        String str = this.profilepic;
        if (str != null && str != null && str.length() > 0) {
            String str2 = this.pdf;
            if (str2 != null && str2 != null && str2.length() > 0) {
                encryptionData2.setDoubt_image(this.profilepic + Constants.SEPARATOR_COMMA + this.pdf);
            } else {
                encryptionData2.setDoubt_image(this.profilepic);
            }
        } else {
            String str3 = this.pdf;
            if (str3 != null && str3 != null && str3.length() > 0) {
                encryptionData2.setDoubt_image(this.pdf);
            } else {
                encryptionData2.setDoubt_image(this.profilepic + Constants.SEPARATOR_COMMA + this.pdf);
            }
        }
        encryptionData2.setDoubt_audio(this.doubt_audio);
        encryptionData2.setDoubt_page_no(getBinding().pageNoTV.getText().toString());
        encryptionData2.setDoubt_question_no(getBinding().questionNoTV.getText().toString());
        encryptionData2.setDoubt_isbn(getBinding().isbnTV.getText().toString());
        encryptionData2.setDoubt_isbn_error_report(this.tickValue ? "1" : "0");
        getBinding().checkBoxDoubt.setChecked(false);
        this.tickValue = false;
        return service.postUserDoubt(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        ArrayList<DoubtSubject> arrayList;
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (apitype != null) {
            int iHashCode = apitype.hashCode();
            if (iHashCode == -777181156) {
                if (apitype.equals(API.API_GET_CHECK_ISBN)) {
                    try {
                        Helper.dismissProgressDialog();
                        if (StringsKt.equals(jsonstring.getString("status"), "true", true)) {
                            JSONObject jSONObject = jsonstring.getJSONObject("data");
                            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                            String strOptString = jSONObject.optString("book_name");
                            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                            TextView textView = getBinding().bookNoTV;
                            Intrinsics.checkNotNull(textView);
                            textView.setText(strOptString);
                            return;
                        }
                        if (jsonstring.has("auth_code") && StringsKt.equals(jsonstring.getString("auth_code"), Const.EXPIRY_AUTH_CODE, true)) {
                            return;
                        }
                        FragmentActivity fragmentActivityRequireActivity = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                        String string = jsonstring.getString("message");
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        XtensionFunctionKt.showSmallLengthToast(fragmentActivityRequireActivity, string);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            }
            if (iHashCode != 184494493) {
                if (iHashCode == 1834484300 && apitype.equals(API.API_GET_DOUBT_SUBJECT_LIST)) {
                    try {
                        Helper.dismissProgressDialog();
                        if (StringsKt.equals(jsonstring.getString("status"), "true", true)) {
                            DoubtSubjectDetail doubtSubjectDetail = (DoubtSubjectDetail) new Gson().fromJson(jsonstring.toString(), DoubtSubjectDetail.class);
                            this.doubtSubjectDetail = doubtSubjectDetail;
                            Intrinsics.checkNotNull(doubtSubjectDetail);
                            if (doubtSubjectDetail.getData() != null) {
                                DoubtSubjectDetail doubtSubjectDetail2 = this.doubtSubjectDetail;
                                Intrinsics.checkNotNull(doubtSubjectDetail2);
                                if (doubtSubjectDetail2.getData().size() <= 0 || (arrayList = this.doubtSubjectArray) == null) {
                                    return;
                                }
                                DoubtSubjectDetail doubtSubjectDetail3 = this.doubtSubjectDetail;
                                Intrinsics.checkNotNull(doubtSubjectDetail3);
                                arrayList.addAll(doubtSubjectDetail3.getData());
                                return;
                            }
                            return;
                        }
                        if (jsonstring.has("auth_code") && StringsKt.equals(jsonstring.getString("auth_code"), Const.EXPIRY_AUTH_CODE, true)) {
                            return;
                        }
                        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
                        String string2 = jsonstring.getString("message");
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        XtensionFunctionKt.showSmallLengthToast(fragmentActivityRequireActivity2, string2);
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            }
            if (apitype.equals(API.API_GET_POST_DOUBT)) {
                try {
                    Helper.dismissProgressDialog();
                    this.profilepic = "";
                    this.doubt_audio = "";
                    this.pdf = "";
                    getBinding().questionNoTV.setText("");
                    getBinding().pageNoTV.setText("");
                    getBinding().comment.setText("");
                    getBinding().isbnTV.setText("");
                    getBinding().doubtSetPdf.setVisibility(8);
                    getBinding().addPdf.setVisibility(0);
                    getBinding().doubtSetImage.setVisibility(8);
                    getBinding().doubtImage.setVisibility(0);
                    getBinding().doubtSetAudio.setVisibility(8);
                    getBinding().uploadAudio.setVisibility(0);
                    getBinding().progressBarPdf.setVisibility(8);
                    getBinding().progressBarImage.setVisibility(8);
                    getBinding().progressBarAudio.setVisibility(8);
                    getBinding().uploadPdfTV.setVisibility(8);
                    getBinding().uploadImageTv.setVisibility(8);
                    getBinding().uploadAudioTV.setVisibility(8);
                    getBinding().deletePdf.setVisibility(8);
                    getBinding().deleteAudio.setVisibility(8);
                    getBinding().deleteImage.setVisibility(8);
                    getBinding().crossPdf.setVisibility(8);
                    getBinding().crossAudio.setVisibility(8);
                    getBinding().crossImage.setVisibility(8);
                    FragmentActivity fragmentActivityRequireActivity3 = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity3, "requireActivity(...)");
                    String string3 = jsonstring.getString("message");
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    XtensionFunctionKt.showSmallLengthToast(fragmentActivityRequireActivity3, string3);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_SUBJECT_LIST)) {
            if (AllDoubtsFragmentKt.getPaginationLoader() != null) {
                ProgressBar paginationLoader = AllDoubtsFragmentKt.getPaginationLoader();
                Intrinsics.checkNotNull(paginationLoader);
                if (paginationLoader.isShown()) {
                    ProgressBar paginationLoader2 = AllDoubtsFragmentKt.getPaginationLoader();
                    Intrinsics.checkNotNull(paginationLoader2);
                    paginationLoader2.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(apitype, API.API_GET_POST_DOUBT) || AllDoubtsFragmentKt.getPaginationLoader() == null) {
            return;
        }
        ProgressBar paginationLoader3 = AllDoubtsFragmentKt.getPaginationLoader();
        Intrinsics.checkNotNull(paginationLoader3);
        if (paginationLoader3.isShown()) {
            ProgressBar paginationLoader4 = AllDoubtsFragmentKt.getPaginationLoader();
            Intrinsics.checkNotNull(paginationLoader4);
            paginationLoader4.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        DoubtSubject doubtSubject;
        DoubtSubject doubtSubject2;
        if (StringsKt.equals(this.isSubjectClicked, "1", true)) {
            TextView textView = getBinding().subjectTV;
            Intrinsics.checkNotNull(item);
            textView.setText(item.getTitle());
            ArrayList<DoubtSubject> arrayList = this.doubtSubjectArray;
            Intrinsics.checkNotNull(arrayList);
            int size = arrayList.size();
            if (size >= 0) {
                int i = 0;
                while (true) {
                    ArrayList<DoubtSubject> arrayList2 = this.doubtSubjectArray;
                    Intrinsics.checkNotNull(arrayList2);
                    if (i < arrayList2.size()) {
                        String strValueOf = String.valueOf(item.getTitle());
                        ArrayList<DoubtSubject> arrayList3 = this.doubtSubjectArray;
                        String id = null;
                        if (StringsKt.equals(strValueOf, (arrayList3 == null || (doubtSubject2 = arrayList3.get(i)) == null) ? null : doubtSubject2.getName(), true)) {
                            ArrayList<DoubtSubject> arrayList4 = this.doubtSubjectArray;
                            if (arrayList4 != null && (doubtSubject = arrayList4.get(i)) != null) {
                                id = doubtSubject.getId();
                            }
                            this.doubtposition = id;
                            ArrayList<DoubtSubject> arrayList5 = this.doubtSubjectArray;
                            Intrinsics.checkNotNull(arrayList5);
                            setTopicList(arrayList5.get(i).getTopics());
                        }
                    }
                    if (i == size) {
                        break;
                    }
                    i++;
                }
            }
        } else if (StringsKt.equals(this.isSubjectClicked, "2", true)) {
            TextView textView2 = getBinding().topicspinner;
            Intrinsics.checkNotNull(item);
            textView2.setText(item.getTitle());
            Iterator<Topics> it = getTopicList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Topics next = it.next();
                if (next.getName().equals(item.getTitle())) {
                    setTopic(next);
                    break;
                }
            }
        }
        return false;
    }

    private final void stopWatch(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.seconds = savedInstanceState.getInt("seconds");
            this.running = savedInstanceState.getBoolean("running");
            this.wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    private final void runTimer() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        final Dialog dialog = new Dialog(requireActivity());
        dialog.setContentView(R.layout.custom_dialog_new);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();
        final Button button = (Button) dialog.findViewById(R.id.record);
        this.recordtime = (TextView) dialog.findViewById(R.id.timerno);
        final Button button2 = (Button) dialog.findViewById(R.id.play);
        Button button3 = (Button) dialog.findViewById(R.id.send);
        Button button4 = (Button) dialog.findViewById(R.id.cancel);
        final Handler handler = new Handler();
        handler.post(new Runnable() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment.runTimer.1
            @Override // java.lang.Runnable
            public void run() {
                int i = AskDoubtFragment.this.seconds / 3600;
                int i2 = (AskDoubtFragment.this.seconds % 3600) / 60;
                int i3 = AskDoubtFragment.this.seconds % 60;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.getDefault(), "%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                TextView recordtime = AskDoubtFragment.this.getRecordtime();
                Intrinsics.checkNotNull(recordtime);
                recordtime.setText(str);
                if (AskDoubtFragment.this.running) {
                    AskDoubtFragment.this.seconds++;
                }
                handler.postDelayed(this, 1000L);
            }
        });
        button2.setVisibility(8);
        button.setText(requireContext().getResources().getString(R.string.record));
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AskDoubtFragment.runTimer$lambda$21(this.f$0, handler, dialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AskDoubtFragment.runTimer$lambda$22(booleanRef2, button, this, booleanRef, button2, view);
            }
        });
        button2.setText(requireContext().getResources().getString(R.string.play));
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AskDoubtFragment.runTimer$lambda$23(booleanRef, button, this, button2, booleanRef2, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AskDoubtFragment.runTimer$lambda$24(this.f$0, dialog, handler, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runTimer$lambda$21(AskDoubtFragment askDoubtFragment, Handler handler, Dialog dialog, View view) {
        if (Helper.isNetworkConnected(askDoubtFragment.getContext())) {
            String str = askDoubtFragment.fileName;
            if (str == "" || str == null) {
                Toast.makeText(askDoubtFragment.getContext(), askDoubtFragment.requireContext().getResources().getString(R.string.please_record_audio), 0).show();
                return;
            }
            MediaPlayer mediaPlayer = askDoubtFragment.mediaPlayer;
            if (mediaPlayer != null) {
                Intrinsics.checkNotNull(mediaPlayer);
                if (mediaPlayer.isPlaying()) {
                    MediaPlayer mediaPlayer2 = askDoubtFragment.mediaPlayer;
                    Intrinsics.checkNotNull(mediaPlayer2);
                    mediaPlayer2.pause();
                }
            }
            askDoubtFragment.seconds = 0;
            askDoubtFragment.running = false;
            askDoubtFragment.sendaudio();
            handler.removeCallbacksAndMessages(null);
            dialog.dismiss();
            return;
        }
        Toast.makeText(askDoubtFragment.getContext(), askDoubtFragment.requireContext().getResources().getString(R.string.no_internet_connection), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runTimer$lambda$22(Ref.BooleanRef booleanRef, Button button, AskDoubtFragment askDoubtFragment, Ref.BooleanRef booleanRef2, Button button2, View view) {
        try {
            if (!booleanRef.element) {
                if (Intrinsics.areEqual(button.getText(), askDoubtFragment.requireContext().getResources().getString(R.string.record))) {
                    booleanRef2.element = true;
                    Intrinsics.checkNotNull(button);
                    askDoubtFragment.onRecordBtnClicked(button);
                    button2.setEnabled(false);
                    button2.setClickable(false);
                    button2.setVisibility(8);
                    return;
                }
                if (Intrinsics.areEqual(button.getText(), askDoubtFragment.requireContext().getResources().getString(R.string.stop))) {
                    button2.setEnabled(true);
                    button2.setClickable(true);
                    booleanRef2.element = false;
                    button.setText(askDoubtFragment.requireContext().getResources().getString(R.string.record));
                    askDoubtFragment.running = false;
                    if (button2 != null) {
                        button2.setVisibility(0);
                    }
                    askDoubtFragment.stopRecording();
                    button2.setVisibility(0);
                    return;
                }
                return;
            }
            Context contextRequireContext = askDoubtFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            ExtensionFucationKt.showToast(contextRequireContext, "Please Pause first");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runTimer$lambda$23(Ref.BooleanRef booleanRef, Button button, AskDoubtFragment askDoubtFragment, Button button2, Ref.BooleanRef booleanRef2, View view) {
        try {
            if (!booleanRef.element) {
                if (!Intrinsics.areEqual(button.getText(), askDoubtFragment.requireContext().getResources().getText(R.string.stop))) {
                    if (Intrinsics.areEqual(button2.getText(), askDoubtFragment.requireContext().getResources().getString(R.string.play))) {
                        if (askDoubtFragment.seconds == 0) {
                            Toast.makeText(askDoubtFragment.getContext(), askDoubtFragment.requireContext().getResources().getString(R.string.please_record_audio), 0).show();
                            return;
                        }
                        booleanRef2.element = true;
                        MediaPlayer mediaPlayerCreate = MediaPlayer.create(askDoubtFragment.getContext(), Uri.parse(askDoubtFragment.fileName));
                        askDoubtFragment.mediaPlayer = mediaPlayerCreate;
                        if (mediaPlayerCreate != null) {
                            Intrinsics.checkNotNull(mediaPlayerCreate);
                            mediaPlayerCreate.start();
                        }
                        button2.setText(askDoubtFragment.requireContext().getResources().getString(R.string.pause));
                        Intrinsics.checkNotNull(button2);
                        Intrinsics.checkNotNull(button);
                        askDoubtFragment.starttimer(button2, button);
                        button.setVisibility(8);
                        return;
                    }
                    if (Intrinsics.areEqual(button2.getText(), askDoubtFragment.requireContext().getResources().getString(R.string.pause))) {
                        booleanRef2.element = false;
                        askDoubtFragment.stoptimer();
                        button2.setText(askDoubtFragment.requireContext().getResources().getString(R.string.play));
                        MediaPlayer mediaPlayer = askDoubtFragment.mediaPlayer;
                        Intrinsics.checkNotNull(mediaPlayer);
                        mediaPlayer.pause();
                        button.setVisibility(0);
                        return;
                    }
                    return;
                }
                Context contextRequireContext = askDoubtFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                ExtensionFucationKt.showToast(contextRequireContext, "You can't play while Recording");
                return;
            }
            Context contextRequireContext2 = askDoubtFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            ExtensionFucationKt.showToast(contextRequireContext2, "You can't play while Recording");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runTimer$lambda$24(AskDoubtFragment askDoubtFragment, Dialog dialog, Handler handler, View view) {
        askDoubtFragment.stopRecording();
        MediaPlayer mediaPlayer = askDoubtFragment.mediaPlayer;
        if (mediaPlayer != null) {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = askDoubtFragment.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.pause();
            }
        }
        askDoubtFragment.seconds = 0;
        askDoubtFragment.running = false;
        askDoubtFragment.fileName = "";
        dialog.dismiss();
        handler.removeCallbacksAndMessages(null);
    }

    private final void stopRecording() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            try {
                Intrinsics.checkNotNull(mediaRecorder);
                mediaRecorder.stop();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
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
        if (ActivityCompat.checkSelfPermission(requireActivity(), "android.permission.RECORD_AUDIO") != 0) {
            pausePlayer();
            this.PERMISSION_TYPE = 3;
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.RECORD_AUDIO"}, 10);
            return;
        }
        Button button = this.play;
        if (button != null) {
            button.setVisibility(4);
        }
        pausePlayer();
        this.seconds = 0;
        this.running = true;
        record.setText(requireContext().getResources().getString(R.string.stop));
        startRecording();
    }

    public final void pausePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.player.getPlaybackState();
        }
    }

    private final void startRecording() {
        Object systemService = requireActivity().getApplicationContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        audioManager.setMode(-1);
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
        File externalCacheDir = requireActivity().getExternalCacheDir();
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

    /* JADX INFO: renamed from: com.appnew.android.Zoom.Fragment.AskDoubtFragment$starttimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AskDoubtFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/Zoom/Fragment/AskDoubtFragment$starttimer$1", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C05641 extends TimerTask {
        final /* synthetic */ Button $play;
        final /* synthetic */ Button $record;

        C05641(Button button, Button button2) {
            this.$play = button;
            this.$record = button2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (AskDoubtFragment.this.getMediaPlayer() != null) {
                MediaPlayer mediaPlayer = AskDoubtFragment.this.getMediaPlayer();
                Intrinsics.checkNotNull(mediaPlayer);
                if (mediaPlayer.isPlaying()) {
                    return;
                }
            }
            AskDoubtFragment.this.stoptimer();
            FragmentActivity fragmentActivityRequireActivity = AskDoubtFragment.this.requireActivity();
            final Button button = this.$play;
            final AskDoubtFragment askDoubtFragment = AskDoubtFragment.this;
            final Button button2 = this.$record;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.Fragment.AskDoubtFragment$starttimer$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AskDoubtFragment.C05641.run$lambda$0(button, askDoubtFragment, button2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(Button button, AskDoubtFragment askDoubtFragment, Button button2) {
            button.setText(askDoubtFragment.requireContext().getResources().getString(R.string.play));
            button2.setVisibility(0);
        }
    }

    public final void starttimer(Button play, Button record) {
        Intrinsics.checkNotNullParameter(play, "play");
        Intrinsics.checkNotNullParameter(record, "record");
        Timer timer = new Timer();
        this.timer = timer;
        Intrinsics.checkNotNull(timer);
        timer.schedule(new C05641(play, record), 0L, 1000L);
    }

    public final void stoptimer() {
        Timer timer = this.timer;
        if (timer != null) {
            Intrinsics.checkNotNull(timer);
            timer.cancel();
            this.timer = null;
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
        this.s3IU = new s3ImageUploading(str, "vc-10000386-38616500102/application/chat_system/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, getContext(), this, null, true, this);
        ArrayList arrayList = new ArrayList();
        MediaFile mediaFile = new MediaFile();
        mediaFile.setFile_type("audio");
        mediaFile.setFile(this.fileName);
        arrayList.add(mediaFile);
        s3ImageUploading s3imageuploading = this.s3IU;
        Intrinsics.checkNotNull(s3imageuploading);
        s3imageuploading.execute(arrayList);
        visibleAudioProgress();
        this.fileName = "";
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        String str;
        if (images == null || images.isEmpty()) {
            return;
        }
        this.filetype = "";
        String file = images.get(0).getFile();
        Intrinsics.checkNotNullExpressionValue(file, "getFile(...)");
        if (StringsKt.contains$default((CharSequence) file, (CharSequence) ".pdf", false, 2, (Object) null)) {
            this.pdf = images.get(0).getFile();
            Glide.with(this).load(Integer.valueOf(com.appnew.android.R.drawable.ic_pdf)).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(com.appnew.android.R.drawable.ic_pdf)).into(getBinding().doubtSetPdf);
            getBinding().doubtSetPdf.setVisibility(8);
            getBinding().addPdf.setVisibility(0);
            TextView textView = getBinding().uploadPdfTV;
            String str2 = this.pdf;
            textView.setText(str2 != null ? StringsKt.substringAfterLast$default(str2, MqttTopic.TOPIC_LEVEL_SEPARATOR, (String) null, 2, (Object) null) : null);
            getBinding().deletePdf.setVisibility(0);
            getBinding().crossPdf.setVisibility(8);
            getBinding().progressBarPdf.setVisibility(8);
            str = Const.PDF;
        } else {
            String file2 = images.get(0).getFile();
            Intrinsics.checkNotNullExpressionValue(file2, "getFile(...)");
            if (StringsKt.contains$default((CharSequence) file2, (CharSequence) ".mp3", false, 2, (Object) null)) {
                this.doubt_audio = images.get(0).getFile();
                Glide.with(this).load(Integer.valueOf(R.drawable.audio_file)).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.audio_file)).into(getBinding().doubtSetAudio);
                getBinding().doubtSetAudio.setVisibility(8);
                getBinding().uploadAudio.setVisibility(0);
                TextView textView2 = getBinding().uploadAudioTV;
                String str3 = this.doubt_audio;
                textView2.setText(str3 != null ? StringsKt.substringAfterLast$default(str3, MqttTopic.TOPIC_LEVEL_SEPARATOR, (String) null, 2, (Object) null) : null);
                getBinding().deleteAudio.setVisibility(0);
                getBinding().crossAudio.setVisibility(8);
                getBinding().progressBarAudio.setVisibility(8);
                str = "audio";
            } else {
                this.profilepic = images.get(0).getFile();
                Glide.with(this).load(images.get(0).getFile()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.loading)).into(getBinding().doubtSetImage);
                getBinding().doubtImage.setVisibility(0);
                getBinding().doubtSetImage.setVisibility(8);
                TextView textView3 = getBinding().uploadImageTv;
                String str4 = this.profilepic;
                textView3.setText(str4 != null ? StringsKt.substringAfterLast$default(str4, MqttTopic.TOPIC_LEVEL_SEPARATOR, (String) null, 2, (Object) null) : null);
                getBinding().deleteImage.setVisibility(0);
                getBinding().crossImage.setVisibility(8);
                getBinding().progressBarImage.setVisibility(8);
                str = "image";
            }
        }
        this.filetype = str;
    }

    @Override // com.appnew.android.Utils.AmazonUpload.ProgressCallBack
    public void onProgress(Integer value) {
        if (StringsKt.equals(this.filetype, Const.PDF, true)) {
            ProgressBar progressBar = getBinding().progressBarPdf;
            Intrinsics.checkNotNull(value);
            progressBar.setProgress(value.intValue());
        } else if (StringsKt.equals(this.filetype, "audio", true)) {
            ProgressBar progressBar2 = getBinding().progressBarAudio;
            Intrinsics.checkNotNull(value);
            progressBar2.setProgress(value.intValue());
        } else if (StringsKt.equals(this.filetype, "image", true)) {
            ProgressBar progressBar3 = getBinding().progressBarImage;
            Intrinsics.checkNotNull(value);
            progressBar3.setProgress(value.intValue());
        }
    }
}
