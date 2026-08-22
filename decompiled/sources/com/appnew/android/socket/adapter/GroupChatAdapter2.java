package com.appnew.android.socket.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ItemAudioChatLeftBinding;
import com.appnew.android.databinding.ItemAudioChatRightBinding;
import com.appnew.android.databinding.ItemDateTypeChatBinding;
import com.appnew.android.databinding.ItemGroupChatBinding;
import com.appnew.android.databinding.ItemImageChatLeftBinding;
import com.appnew.android.databinding.ItemImageChatRightBinding;
import com.appnew.android.databinding.ItemLoaderBinding;
import com.appnew.android.databinding.ItemPdfChatLeftNewBinding;
import com.appnew.android.databinding.ItemPdfChatRightNewBinding;
import com.appnew.android.databinding.ItemTextChatLeftBinding;
import com.appnew.android.databinding.ItemTextChatRightBinding;
import com.appnew.android.databinding.ItemUrlChatLeftBinding;
import com.appnew.android.databinding.ItemUrlChatRightBinding;
import com.appnew.android.socket.activity.ChatImageViewActivity;
import com.appnew.android.socket.activity.GroupChatActivity;
import com.appnew.android.socket.adapter.GroupChatAdapter2;
import com.appnew.android.socket.diffUtil.MyDiffCallback;
import com.appnew.android.socket.extension.SocketKt;
import com.appnew.android.socket.models.ChatModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.eduteria.app.app.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.reference.element.ReferenceElement;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/* JADX INFO: compiled from: GroupChatAdapter2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ß\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f*\u0001%\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\rpqrstuvwxyz{|BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010*\u001a\u00020+2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012H\u0016J\b\u00101\u001a\u00020\u0012H\u0016J\u0010\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0012H\u0016J\u0018\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0012H\u0016J\u0018\u00106\u001a\u00020+*\u000607R\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u00108\u001a\u00020+*\u000609R\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u0010:\u001a\u00020+*\u00060;R\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u0010<\u001a\u00020+*\u00060=R\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u0010>\u001a\u00020+*\u00060?R\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u0010@\u001a\u00020+*\u00060AR\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u0010B\u001a\u00020+*\u00060\u0015R\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u0010C\u001a\u00020+*\u00060\u0017R\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u0010D\u001a\u00020+*\u00060ER\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u0010F\u001a\u00020+*\u00060GR\u00020\u00002\u0006\u00103\u001a\u00020\u0012H\u0002J\u0006\u0010H\u001a\u00020+J\u0010\u0010I\u001a\u00020+2\u0006\u0010J\u001a\u00020\u0004H\u0002J\u0010\u0010K\u001a\u00020+2\u0006\u0010J\u001a\u00020\u0004H\u0002J\u0018\u0010L\u001a\u00020+2\u0006\u0010J\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0012H\u0002J\u0018\u0010M\u001a\u00020+2\u0006\u0010J\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0012H\u0002J\b\u0010W\u001a\u00020\u001dH\u0002J*\u0010X\u001a\u00020+2\u0006\u00103\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u00122\b\b\u0002\u0010\\\u001a\u00020\u001dH\u0002J*\u0010]\u001a\u00020+2\u0006\u00103\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u00122\b\b\u0002\u0010\\\u001a\u00020\u001dH\u0002J \u0010^\u001a\u00020+2\u0006\u0010_\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00122\u0006\u0010`\u001a\u00020aH\u0002J\u0010\u0010b\u001a\u00020+2\u0006\u0010_\u001a\u00020\u0006H\u0002J\u000e\u0010c\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u0006J*\u0010e\u001a\u00020+2\u0006\u00105\u001a\u00020\u00022\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010g2\u0006\u0010i\u001a\u00020\u0012J\u0006\u0010j\u001a\u00020+J\u0016\u0010k\u001a\u00020+*\u00020l2\b\b\u0002\u0010m\u001a\u00020nH\u0002J\u0006\u0010o\u001a\u00020+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0018\u00010\u0017R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u001c\u0010'\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u000b0\u000b0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010!\"\u0004\bP\u0010#R\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006}"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "type", "", "chat_Model", "Lcom/appnew/android/socket/models/ChatModel;", "dataSet", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/chatPojo;", "Lkotlin/collections/ArrayList;", "leftMenu", "Lcom/appnew/android/Model/LeftMenu;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/appnew/android/socket/models/ChatModel;Ljava/util/ArrayList;Lcom/appnew/android/Model/LeftMenu;)V", "lastselected", "", "templistPosition", "tempHolderLeft", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderAudioLeft;", "tempHolderRight", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderAudioRight;", "mediaPlayer", "Landroid/media/MediaPlayer;", "timer", "Ljava/util/Timer;", "in_app_download", "", "chatModel", "currentlyPlayingId", "getCurrentlyPlayingId", "()Ljava/lang/String;", "setCurrentlyPlayingId", "(Ljava/lang/String;)V", "diffUtil", "com/appnew/android/socket/adapter/GroupChatAdapter2$diffUtil$1", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$diffUtil$1;", "asyncListDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "submitList", "", "dataSetNew", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", Const.POSITION, "onBindViewHolder", "holder", "bindLeftTextData", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderTextLeft;", "bindRightTextData", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderTextRight;", "bindLeftImageData", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderImageLeft;", "bindRightImageData", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderImageRight;", "bindLeftPdfData", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderPdfLeft;", "bindRightPdfData", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderPdfRight;", "bindLeftAudioData", "bindRightAudioData", "bindLeftUrlData", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderUrlLeft;", "bindRightUrlData", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderUrlRight;", "pauseAudio", "playVideoPlayer", "mContext", "pauseVideoPlayer", "setPinChat", "setUnPin", "clicktype", "getClicktype", "setClicktype", "popupMenu", "Landroidx/appcompat/widget/PopupMenu;", "getPopupMenu", "()Landroidx/appcompat/widget/PopupMenu;", "setPopupMenu", "(Landroidx/appcompat/widget/PopupMenu;)V", "isUserAdmin", "showListPopupWindow", ReferenceElement.ATTR_ANCHOR, "Landroid/view/View;", "gravity", "isText", "showListPopupWindow1", "downloadFile", "data", "cvrDownLoad", "Landroid/widget/RelativeLayout;", "getFile", "getdate", "timestamp", "starttimer", "pauser", "Landroid/widget/Button;", "play", "listPosition", "stoptimer", "setDynamicTint", "Landroid/widget/LinearLayout;", "opacityPercentage", "", "releaseMediaPlayer", "ViewHolder", "ViewHolderTextLeft", "ViewHolderTextRight", "ViewHolderImageLeft", "ViewHolderImageRight", "ViewHolderPdfLeft", "ViewHolderPdfRight", "ViewHolderAudioLeft", "ViewHolderAudioRight", "ViewHolderUrlLeft", "ViewHolderUrlRight", "ViewHolderDate", "ViewHolderLoader", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupChatAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private final AsyncListDiffer<chatPojo> asyncListDiffer;
    private ChatModel chatModel;
    private final ChatModel chat_Model;
    private String clicktype;
    private final Context context;
    private String currentlyPlayingId;
    private ArrayList<chatPojo> dataSet;
    private final GroupChatAdapter2$diffUtil$1 diffUtil;
    private boolean in_app_download;
    private int lastselected;
    private final LeftMenu leftMenu;
    private MediaPlayer mediaPlayer;
    private PopupMenu popupMenu;
    private ViewHolderAudioLeft tempHolderLeft;
    private ViewHolderAudioRight tempHolderRight;
    private int templistPosition;
    private Timer timer;
    private final String type;

    private final void pauseVideoPlayer(Context mContext) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playVideoPlayer(Context mContext) {
    }

    public /* synthetic */ GroupChatAdapter2(Context context, String str, ChatModel chatModel, ArrayList arrayList, LeftMenu leftMenu, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, chatModel, arrayList, (i & 16) != 0 ? null : leftMenu);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.appnew.android.socket.adapter.GroupChatAdapter2$diffUtil$1] */
    public GroupChatAdapter2(Context context, String type, ChatModel chat_Model, ArrayList<chatPojo> dataSet, LeftMenu leftMenu) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(chat_Model, "chat_Model");
        Intrinsics.checkNotNullParameter(dataSet, "dataSet");
        this.context = context;
        this.type = type;
        this.chat_Model = chat_Model;
        this.dataSet = dataSet;
        this.leftMenu = leftMenu;
        this.lastselected = -1;
        this.templistPosition = -1;
        ?? r2 = new DiffUtil.ItemCallback<chatPojo>() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$diffUtil$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(chatPojo oldItem, chatPojo newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(chatPojo oldItem, chatPojo newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
            }
        };
        this.diffUtil = r2;
        this.asyncListDiffer = new AsyncListDiffer<>(this, (DiffUtil.ItemCallback) r2);
        this.clicktype = "";
    }

    public final String getCurrentlyPlayingId() {
        return this.currentlyPlayingId;
    }

    public final void setCurrentlyPlayingId(String str) {
        this.currentlyPlayingId = str;
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemGroupChatBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemGroupChatBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemGroupChatBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemGroupChatBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(GroupChatAdapter2 groupChatAdapter2, ItemGroupChatBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemGroupChatBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderTextLeft;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemTextChatLeftBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemTextChatLeftBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemTextChatLeftBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderTextLeft extends RecyclerView.ViewHolder {
        private final ItemTextChatLeftBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderTextLeft(GroupChatAdapter2 groupChatAdapter2, ItemTextChatLeftBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemTextChatLeftBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderTextRight;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemTextChatRightBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemTextChatRightBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemTextChatRightBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderTextRight extends RecyclerView.ViewHolder {
        private final ItemTextChatRightBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderTextRight(GroupChatAdapter2 groupChatAdapter2, ItemTextChatRightBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemTextChatRightBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderImageLeft;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemImageChatLeftBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemImageChatLeftBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemImageChatLeftBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderImageLeft extends RecyclerView.ViewHolder {
        private final ItemImageChatLeftBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderImageLeft(GroupChatAdapter2 groupChatAdapter2, ItemImageChatLeftBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemImageChatLeftBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderImageRight;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemImageChatRightBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemImageChatRightBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemImageChatRightBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderImageRight extends RecyclerView.ViewHolder {
        private final ItemImageChatRightBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderImageRight(GroupChatAdapter2 groupChatAdapter2, ItemImageChatRightBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemImageChatRightBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderPdfLeft;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemPdfChatLeftNewBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemPdfChatLeftNewBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemPdfChatLeftNewBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderPdfLeft extends RecyclerView.ViewHolder {
        private final ItemPdfChatLeftNewBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderPdfLeft(GroupChatAdapter2 groupChatAdapter2, ItemPdfChatLeftNewBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemPdfChatLeftNewBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderPdfRight;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemPdfChatRightNewBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemPdfChatRightNewBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemPdfChatRightNewBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderPdfRight extends RecyclerView.ViewHolder {
        private final ItemPdfChatRightNewBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderPdfRight(GroupChatAdapter2 groupChatAdapter2, ItemPdfChatRightNewBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemPdfChatRightNewBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderAudioLeft;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemAudioChatLeftBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemAudioChatLeftBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemAudioChatLeftBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderAudioLeft extends RecyclerView.ViewHolder {
        private final ItemAudioChatLeftBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderAudioLeft(GroupChatAdapter2 groupChatAdapter2, ItemAudioChatLeftBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemAudioChatLeftBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderAudioRight;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemAudioChatRightBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemAudioChatRightBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemAudioChatRightBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderAudioRight extends RecyclerView.ViewHolder {
        private final ItemAudioChatRightBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderAudioRight(GroupChatAdapter2 groupChatAdapter2, ItemAudioChatRightBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemAudioChatRightBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderUrlLeft;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemUrlChatLeftBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemUrlChatLeftBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemUrlChatLeftBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderUrlLeft extends RecyclerView.ViewHolder {
        private final ItemUrlChatLeftBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderUrlLeft(GroupChatAdapter2 groupChatAdapter2, ItemUrlChatLeftBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemUrlChatLeftBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderUrlRight;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemUrlChatRightBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemUrlChatRightBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemUrlChatRightBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderUrlRight extends RecyclerView.ViewHolder {
        private final ItemUrlChatRightBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderUrlRight(GroupChatAdapter2 groupChatAdapter2, ItemUrlChatRightBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemUrlChatRightBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderDate;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemDateTypeChatBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemDateTypeChatBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemDateTypeChatBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderDate extends RecyclerView.ViewHolder {
        private final ItemDateTypeChatBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderDate(GroupChatAdapter2 groupChatAdapter2, ItemDateTypeChatBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemDateTypeChatBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/GroupChatAdapter2$ViewHolderLoader;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemLoaderBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/GroupChatAdapter2;Lcom/appnew/android/databinding/ItemLoaderBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemLoaderBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolderLoader extends RecyclerView.ViewHolder {
        private final ItemLoaderBinding binding;
        final /* synthetic */ GroupChatAdapter2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderLoader(GroupChatAdapter2 groupChatAdapter2, ItemLoaderBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = groupChatAdapter2;
            this.binding = binding;
        }

        public final ItemLoaderBinding getBinding() {
            return this.binding;
        }
    }

    public final void submitList(ArrayList<chatPojo> dataSetNew) {
        Intrinsics.checkNotNullParameter(dataSetNew, "dataSetNew");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new MyDiffCallback(this.dataSet, dataSetNew));
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        String str = this.type;
        if (str != null && str.equals("0")) {
            this.in_app_download = true;
        }
        this.chatModel = this.chat_Model;
        this.dataSet = dataSetNew;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            ItemDateTypeChatBinding itemDateTypeChatBindingInflate = ItemDateTypeChatBinding.inflate(LayoutInflater.from(this.context), parent, false);
            Intrinsics.checkNotNullExpressionValue(itemDateTypeChatBindingInflate, "inflate(...)");
            return new ViewHolderDate(this, itemDateTypeChatBindingInflate);
        }
        if (viewType != 3) {
            switch (viewType) {
                case 11:
                    ItemPdfChatLeftNewBinding itemPdfChatLeftNewBindingInflate = ItemPdfChatLeftNewBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemPdfChatLeftNewBindingInflate, "inflate(...)");
                    return new ViewHolderPdfLeft(this, itemPdfChatLeftNewBindingInflate);
                case 12:
                    ItemPdfChatRightNewBinding itemPdfChatRightNewBindingInflate = ItemPdfChatRightNewBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemPdfChatRightNewBindingInflate, "inflate(...)");
                    return new ViewHolderPdfRight(this, itemPdfChatRightNewBindingInflate);
                case 13:
                    ItemImageChatLeftBinding itemImageChatLeftBindingInflate = ItemImageChatLeftBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemImageChatLeftBindingInflate, "inflate(...)");
                    return new ViewHolderImageLeft(this, itemImageChatLeftBindingInflate);
                case 14:
                    ItemImageChatRightBinding itemImageChatRightBindingInflate = ItemImageChatRightBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemImageChatRightBindingInflate, "inflate(...)");
                    return new ViewHolderImageRight(this, itemImageChatRightBindingInflate);
                case 15:
                    ItemTextChatLeftBinding itemTextChatLeftBindingInflate = ItemTextChatLeftBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemTextChatLeftBindingInflate, "inflate(...)");
                    return new ViewHolderTextLeft(this, itemTextChatLeftBindingInflate);
                case 16:
                    ItemTextChatRightBinding itemTextChatRightBindingInflate = ItemTextChatRightBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemTextChatRightBindingInflate, "inflate(...)");
                    return new ViewHolderTextRight(this, itemTextChatRightBindingInflate);
                case 17:
                    ItemUrlChatLeftBinding itemUrlChatLeftBindingInflate = ItemUrlChatLeftBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemUrlChatLeftBindingInflate, "inflate(...)");
                    return new ViewHolderUrlLeft(this, itemUrlChatLeftBindingInflate);
                case 18:
                    ItemUrlChatRightBinding itemUrlChatRightBindingInflate = ItemUrlChatRightBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemUrlChatRightBindingInflate, "inflate(...)");
                    return new ViewHolderUrlRight(this, itemUrlChatRightBindingInflate);
                case 19:
                    ItemAudioChatLeftBinding itemAudioChatLeftBindingInflate = ItemAudioChatLeftBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemAudioChatLeftBindingInflate, "inflate(...)");
                    return new ViewHolderAudioLeft(this, itemAudioChatLeftBindingInflate);
                case 20:
                    ItemAudioChatRightBinding itemAudioChatRightBindingInflate = ItemAudioChatRightBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemAudioChatRightBindingInflate, "inflate(...)");
                    return new ViewHolderAudioRight(this, itemAudioChatRightBindingInflate);
                default:
                    ItemGroupChatBinding itemGroupChatBindingInflate = ItemGroupChatBinding.inflate(LayoutInflater.from(this.context), parent, false);
                    Intrinsics.checkNotNullExpressionValue(itemGroupChatBindingInflate, "inflate(...)");
                    return new ViewHolder(this, itemGroupChatBindingInflate);
            }
        }
        ItemLoaderBinding itemLoaderBindingInflate = ItemLoaderBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemLoaderBindingInflate, "inflate(...)");
        return new ViewHolderLoader(this, itemLoaderBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataSet.size();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        String viewType = this.dataSet.get(position).getViewType();
        if (viewType != null) {
            int iHashCode = viewType.hashCode();
            if (iHashCode != -1097519085) {
                if (iHashCode != 3052376) {
                    if (iHashCode == 3076014 && viewType.equals("date")) {
                        return 2;
                    }
                } else if (viewType.equals(Const.CHAT)) {
                    String type = this.dataSet.get(position).getType();
                    if (type == null) {
                        return 1;
                    }
                    switch (type.hashCode()) {
                        case 110834:
                            if (type.equals(Const.PDF)) {
                                return Intrinsics.areEqual(this.dataSet.get(position).getUserId(), SharedPreference.getInstance().getLoggedInUser().getId()) ? 12 : 11;
                            }
                            return 1;
                        case 116079:
                            if (type.equals("url")) {
                                return Intrinsics.areEqual(this.dataSet.get(position).getUserId(), SharedPreference.getInstance().getLoggedInUser().getId()) ? 18 : 17;
                            }
                            return 1;
                        case 3556653:
                            if (type.equals("text")) {
                                return Intrinsics.areEqual(this.dataSet.get(position).getUserId(), SharedPreference.getInstance().getLoggedInUser().getId()) ? 16 : 15;
                            }
                            return 1;
                        case 93166550:
                            if (type.equals("audio")) {
                                return Intrinsics.areEqual(this.dataSet.get(position).getUserId(), SharedPreference.getInstance().getLoggedInUser().getId()) ? 20 : 19;
                            }
                            return 1;
                        case 100313435:
                            if (type.equals("image")) {
                                return Intrinsics.areEqual(this.dataSet.get(position).getUserId(), SharedPreference.getInstance().getLoggedInUser().getId()) ? 14 : 13;
                            }
                            return 1;
                        default:
                            return 1;
                    }
                }
            } else if (viewType.equals("loader")) {
                return 3;
            }
        }
        return super.getItemViewType(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (getItemViewType(position) == 11) {
            if (holder instanceof ViewHolderPdfLeft) {
                bindLeftPdfData((ViewHolderPdfLeft) holder, position);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 12) {
            if (holder instanceof ViewHolderPdfRight) {
                bindRightPdfData((ViewHolderPdfRight) holder, position);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 13) {
            if (holder instanceof ViewHolderImageLeft) {
                bindLeftImageData((ViewHolderImageLeft) holder, position);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 14) {
            if (holder instanceof ViewHolderImageRight) {
                bindRightImageData((ViewHolderImageRight) holder, position);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 15) {
            if (holder instanceof ViewHolderTextLeft) {
                bindLeftTextData((ViewHolderTextLeft) holder, position);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 16) {
            if (holder instanceof ViewHolderTextRight) {
                bindRightTextData((ViewHolderTextRight) holder, position);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 17) {
            if (holder instanceof ViewHolderUrlLeft) {
                bindLeftUrlData((ViewHolderUrlLeft) holder, position);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 18) {
            if (holder instanceof ViewHolderUrlRight) {
                bindRightUrlData((ViewHolderUrlRight) holder, position);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 19) {
            if (holder instanceof ViewHolderAudioLeft) {
                bindLeftAudioData((ViewHolderAudioLeft) holder, position);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 20) {
            if (holder instanceof ViewHolderAudioRight) {
                bindRightAudioData((ViewHolderAudioRight) holder, position);
            }
        } else {
            if (getItemViewType(position) == 2) {
                if (holder instanceof ViewHolderDate) {
                    ItemDateTypeChatBinding binding = ((ViewHolderDate) holder).getBinding();
                    chatPojo chatpojo = this.dataSet.get(position);
                    binding.dateText.setText(new DateTime(chatpojo.getDate()).toString(DateTimeFormat.forPattern("dd MMMM yyyy")));
                    return;
                }
                return;
            }
            if (getItemViewType(position) == 3 && (holder instanceof ViewHolderLoader)) {
                ((ViewHolderLoader) holder).getBinding();
                this.dataSet.get(position);
            }
        }
    }

    private final void bindLeftTextData(ViewHolderTextLeft viewHolderTextLeft, final int i) {
        LinearLayout linearLayout;
        final ItemTextChatLeftBinding binding = viewHolderTextLeft.getBinding();
        chatPojo chatpojo = this.dataSet.get(i);
        binding.timeRl1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatAdapter2.bindLeftTextData$lambda$8$lambda$7$lambda$4(this.f$0, i, binding);
            }
        }));
        if (chatpojo.getIs_edited() != null) {
            String is_edited = chatpojo.getIs_edited();
            Intrinsics.checkNotNullExpressionValue(is_edited, "getIs_edited(...)");
            if (is_edited.length() > 0 && (linearLayout = binding.editedLayoutLeft1) != null) {
                linearLayout.setVisibility(Intrinsics.areEqual(chatpojo.getIs_edited(), "1") ? 0 : 8);
            }
        }
        binding.cvrLeft.setVisibility(0);
        TextView textView = binding.letfmessageTv;
        String message = chatpojo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        String str = message;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        textView.setText(str.subSequence(i2, length + 1).toString());
        TextView textView2 = binding.userName;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str2 = name;
        int length2 = str2.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length2) {
            boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i3 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                } else {
                    length2--;
                }
            } else if (z4) {
                i3++;
            } else {
                z3 = true;
            }
        }
        textView2.setText(str2.subSequence(i3, length2 + 1).toString());
        binding.lefttexttime.setText(getdate(String.valueOf(chatpojo.getDate())));
        if (!TextUtils.isEmpty(chatpojo.getPin()) && Intrinsics.areEqual(chatpojo.getPin(), "1")) {
            binding.ivPinMsgLeft.setVisibility(0);
        } else {
            binding.ivPinMsgLeft.setVisibility(8);
        }
        Linkify.addLinks(binding.letfmessageTv, 15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLeftTextData$lambda$8$lambda$7$lambda$4(GroupChatAdapter2 groupChatAdapter2, int i, ItemTextChatLeftBinding itemTextChatLeftBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout timeRl1 = itemTextChatLeftBinding.timeRl1;
            Intrinsics.checkNotNullExpressionValue(timeRl1, "timeRl1");
            showListPopupWindow1$default(groupChatAdapter2, i, timeRl1, GravityCompat.END, false, 8, null);
        }
        return Unit.INSTANCE;
    }

    private final void bindRightTextData(ViewHolderTextRight viewHolderTextRight, final int i) {
        final ItemTextChatRightBinding binding = viewHolderTextRight.getBinding();
        LinearLayout mainContainerLL = binding.mainContainerLL;
        Intrinsics.checkNotNullExpressionValue(mainContainerLL, "mainContainerLL");
        setDynamicTint$default(this, mainContainerLL, 0.0f, 1, null);
        chatPojo chatpojo = this.dataSet.get(i);
        binding.timeRl2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatAdapter2.bindRightTextData$lambda$13$lambda$12$lambda$9(this.f$0, i, binding);
            }
        }));
        if (!TextUtils.isEmpty(chatpojo.getPin()) && Intrinsics.areEqual(chatpojo.getPin(), "1")) {
            binding.ivPinMsg.setVisibility(0);
        } else {
            binding.ivPinMsg.setVisibility(8);
        }
        if (chatpojo.getIs_edited() != null) {
            String is_edited = chatpojo.getIs_edited();
            Intrinsics.checkNotNullExpressionValue(is_edited, "getIs_edited(...)");
            if (is_edited.length() > 0) {
                LinearLayout editedLayoutRight = binding.editedLayoutRight;
                Intrinsics.checkNotNullExpressionValue(editedLayoutRight, "editedLayoutRight");
                editedLayoutRight.setVisibility(Intrinsics.areEqual(chatpojo.getIs_edited(), "1") ? 0 : 8);
            }
        }
        binding.cvrRight.setVisibility(0);
        TextView textView = binding.rightmessage;
        String message = chatpojo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        String str = message;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        textView.setText(str.subSequence(i2, length + 1).toString());
        TextView textView2 = binding.userNameright;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str2 = name;
        int length2 = str2.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length2) {
            boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i3 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                } else {
                    length2--;
                }
            } else if (z4) {
                i3++;
            } else {
                z3 = true;
            }
        }
        textView2.setText(str2.subSequence(i3, length2 + 1).toString());
        binding.righttexttime.setText(getdate(String.valueOf(chatpojo.getDate())));
        Linkify.addLinks(binding.rightmessage, 15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindRightTextData$lambda$13$lambda$12$lambda$9(GroupChatAdapter2 groupChatAdapter2, int i, ItemTextChatRightBinding itemTextChatRightBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout timeRl2 = itemTextChatRightBinding.timeRl2;
            Intrinsics.checkNotNullExpressionValue(timeRl2, "timeRl2");
            showListPopupWindow$default(groupChatAdapter2, i, timeRl2, GravityCompat.START, false, 8, null);
        }
        return Unit.INSTANCE;
    }

    private final void bindLeftImageData(ViewHolderImageLeft viewHolderImageLeft, final int i) {
        LinearLayout linearLayout;
        final ItemImageChatLeftBinding binding = viewHolderImageLeft.getBinding();
        chatPojo chatpojo = this.dataSet.get(i);
        binding.ivImgLeftClick.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindLeftImageData$lambda$19$lambda$18$lambda$14(this.f$0, i, view);
            }
        });
        binding.timeRl3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatAdapter2.bindLeftImageData$lambda$19$lambda$18$lambda$15(this.f$0, i, binding);
            }
        }));
        ChatModel chatModel = this.chatModel;
        if ((chatModel != null ? chatModel.is_teacher() : null) != null) {
            ChatModel chatModel2 = this.chatModel;
            if (StringsKt.equals$default(chatModel2 != null ? chatModel2.is_teacher() : null, "1", false, 2, null) && (linearLayout = binding.timeRl3) != null) {
                linearLayout.setVisibility(0);
            }
        }
        if (TextUtils.isEmpty(chatpojo.getPin()) || !Intrinsics.areEqual(chatpojo.getPin(), "1")) {
            binding.ivPinMsgLeftImage.setVisibility(8);
        } else {
            binding.ivPinMsgLeftImage.setVisibility(0);
        }
        binding.cvrLeftimage.setVisibility(0);
        binding.letfmessageTvimage.setLayerType(1, null);
        RequestBuilder<Bitmap> requestBuilderAsBitmap = Glide.with(this.context).asBitmap();
        String message = chatpojo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        String str = message;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        requestBuilderAsBitmap.load(str.subSequence(i2, length + 1).toString()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder).diskCacheStrategy(DiskCacheStrategy.ALL)).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$bindLeftImageData$1$1$4
            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                int width = resource.getWidth();
                int height = resource.getHeight();
                ViewGroup.LayoutParams layoutParams = binding.imageCardViewLeft.getLayoutParams();
                if (width > height) {
                    layoutParams.width = SocketKt.dpToPixels(this.context, 250);
                    layoutParams.height = SocketKt.dpToPixels(this.context, 150);
                    binding.imageCardViewLeft.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = SocketKt.dpToPixels(this.context, 200);
                    layoutParams.height = SocketKt.dpToPixels(this.context, 250);
                    binding.imageCardViewLeft.setLayoutParams(layoutParams);
                }
                binding.letfmessageTvimage.setImageBitmap(resource);
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
                binding.letfmessageTvimage.setImageDrawable(placeholder);
            }
        });
        TextView textView = binding.userNameimage;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str2 = name;
        int length2 = str2.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length2) {
            boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i3 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                } else {
                    length2--;
                }
            } else if (z4) {
                i3++;
            } else {
                z3 = true;
            }
        }
        textView.setText(str2.subSequence(i3, length2 + 1).toString());
        binding.leftimagetime.setText(getdate(String.valueOf(chatpojo.getDate())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindLeftImageData$lambda$19$lambda$18$lambda$14(GroupChatAdapter2 groupChatAdapter2, int i, View view) {
        Intent intent = new Intent(groupChatAdapter2.context, (Class<?>) ChatImageViewActivity.class);
        intent.putExtra("url", groupChatAdapter2.dataSet.get(i).getMessage());
        groupChatAdapter2.context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLeftImageData$lambda$19$lambda$18$lambda$15(GroupChatAdapter2 groupChatAdapter2, int i, ItemImageChatLeftBinding itemImageChatLeftBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout timeRl3 = itemImageChatLeftBinding.timeRl3;
            Intrinsics.checkNotNullExpressionValue(timeRl3, "timeRl3");
            groupChatAdapter2.showListPopupWindow1(i, timeRl3, GravityCompat.END, false);
        }
        return Unit.INSTANCE;
    }

    private final void bindRightImageData(ViewHolderImageRight viewHolderImageRight, final int i) {
        final ItemImageChatRightBinding binding = viewHolderImageRight.getBinding();
        LinearLayout ivImgClickRight = binding.ivImgClickRight;
        Intrinsics.checkNotNullExpressionValue(ivImgClickRight, "ivImgClickRight");
        setDynamicTint$default(this, ivImgClickRight, 0.0f, 1, null);
        chatPojo chatpojo = this.dataSet.get(i);
        binding.ivImgClickRight.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindRightImageData$lambda$25$lambda$24$lambda$20(this.f$0, i, view);
            }
        });
        if (TextUtils.isEmpty(chatpojo.getPin()) || !Intrinsics.areEqual(chatpojo.getPin(), "1")) {
            binding.ivPinImage.setVisibility(8);
        } else {
            binding.ivPinImage.setVisibility(0);
        }
        binding.rightmessageimage.setLayerType(1, null);
        RequestBuilder<Bitmap> requestBuilderAsBitmap = Glide.with(this.context).asBitmap();
        String message = chatpojo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        String str = message;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        requestBuilderAsBitmap.load(str.subSequence(i2, length + 1).toString()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder).diskCacheStrategy(DiskCacheStrategy.ALL)).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$bindRightImageData$1$1$3
            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                int width = resource.getWidth();
                int height = resource.getHeight();
                ViewGroup.LayoutParams layoutParams = binding.rightImageCardView.getLayoutParams();
                if (width > height) {
                    layoutParams.width = SocketKt.dpToPixels(this.context, 250);
                    layoutParams.height = SocketKt.dpToPixels(this.context, 150);
                    binding.rightImageCardView.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = SocketKt.dpToPixels(this.context, 200);
                    layoutParams.height = SocketKt.dpToPixels(this.context, 250);
                    binding.rightImageCardView.setLayoutParams(layoutParams);
                }
                binding.rightmessageimage.setImageBitmap(resource);
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
                binding.rightmessageimage.setImageDrawable(placeholder);
            }
        });
        binding.timeRl4.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatAdapter2.bindRightImageData$lambda$25$lambda$24$lambda$22(this.f$0, i, binding);
            }
        }));
        TextView textView = binding.userNamerightimage;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str2 = name;
        int length2 = str2.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length2) {
            boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i3 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                } else {
                    length2--;
                }
            } else if (z4) {
                i3++;
            } else {
                z3 = true;
            }
        }
        textView.setText(str2.subSequence(i3, length2 + 1).toString());
        binding.rightimagettime.setText(getdate(String.valueOf(chatpojo.getDate())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindRightImageData$lambda$25$lambda$24$lambda$20(GroupChatAdapter2 groupChatAdapter2, int i, View view) {
        Intent intent = new Intent(groupChatAdapter2.context, (Class<?>) ChatImageViewActivity.class);
        intent.putExtra("url", groupChatAdapter2.dataSet.get(i).getMessage());
        groupChatAdapter2.context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindRightImageData$lambda$25$lambda$24$lambda$22(GroupChatAdapter2 groupChatAdapter2, int i, ItemImageChatRightBinding itemImageChatRightBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout timeRl4 = itemImageChatRightBinding.timeRl4;
            Intrinsics.checkNotNullExpressionValue(timeRl4, "timeRl4");
            groupChatAdapter2.showListPopupWindow(i, timeRl4, GravityCompat.START, false);
        }
        return Unit.INSTANCE;
    }

    private final void bindLeftPdfData(ViewHolderPdfLeft viewHolderPdfLeft, final int i) {
        LinearLayout linearLayout;
        final ItemPdfChatLeftNewBinding binding = viewHolderPdfLeft.getBinding();
        final chatPojo chatpojo = this.dataSet.get(i);
        binding.imageThumbnail.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindLeftPdfData$lambda$31$lambda$30$lambda$26(this.f$0, chatpojo, view);
            }
        });
        binding.timeRl6.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatAdapter2.bindLeftPdfData$lambda$31$lambda$30$lambda$27(this.f$0, i, binding);
            }
        }));
        ChatModel chatModel = this.chatModel;
        if ((chatModel != null ? chatModel.is_teacher() : null) != null) {
            ChatModel chatModel2 = this.chatModel;
            if (StringsKt.equals$default(chatModel2 != null ? chatModel2.is_teacher() : null, "1", false, 2, null) && (linearLayout = binding.pdfLl) != null) {
                linearLayout.setVisibility(0);
            }
        }
        binding.cvrLeftpdf.setVisibility(0);
        TextView textView = binding.pdfTextUsernameLeft;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str = name;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        textView.setText(str.subSequence(i2, length + 1).toString());
        binding.pdfTimeLeftPdf.setText(getdate(String.valueOf(chatpojo.getDate())));
        String message = chatpojo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        if (message.length() > 0) {
            String message2 = chatpojo.getMessage();
            Intrinsics.checkNotNullExpressionValue(message2, "getMessage(...)");
            if (StringsKt.contains$default((CharSequence) message2, (CharSequence) MqttTopic.TOPIC_LEVEL_SEPARATOR, false, 2, (Object) null)) {
                TextView textView2 = binding.pdfNameLeft;
                String message3 = chatpojo.getMessage();
                Intrinsics.checkNotNullExpressionValue(message3, "getMessage(...)");
                List listSplit$default = StringsKt.split$default((CharSequence) message3, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null);
                String message4 = chatpojo.getMessage();
                Intrinsics.checkNotNullExpressionValue(message4, "getMessage(...)");
                textView2.setText((CharSequence) listSplit$default.get(StringsKt.split$default((CharSequence) message4, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null).size() - 1));
                Context context = this.context;
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.socket.activity.GroupChatActivity");
                Pair<Boolean, File> pairIsFileExist = SocketKt.isFileExist((GroupChatActivity) context, binding.pdfNameLeft.getText().toString(), true, this.in_app_download);
                RelativeLayout cvrDownLoadLeft = binding.cvrDownLoadLeft;
                Intrinsics.checkNotNullExpressionValue(cvrDownLoadLeft, "cvrDownLoadLeft");
                cvrDownLoadLeft.setVisibility(!pairIsFileExist.getFirst().booleanValue() ? 0 : 8);
                if (pairIsFileExist.getFirst().booleanValue()) {
                    try {
                        Context context2 = this.context;
                        Uri uriForFile = FileProvider.getUriForFile(context2, ((GroupChatActivity) context2).getApplicationContext().getPackageName() + ".provider", pairIsFileExist.getSecond());
                        Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
                        binding.imageThumbnail.setImageBitmap(SocketKt.generateImageFromPdf(context2, uriForFile));
                    } catch (Exception unused) {
                    }
                } else {
                    binding.imageThumbnail.setImageResource(R.mipmap.placeholder_course);
                }
            }
        }
        binding.cvrDownLoadLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindLeftPdfData$lambda$31$lambda$30$lambda$29(this.f$0, chatpojo, i, binding, view);
            }
        });
        if (!TextUtils.isEmpty(chatpojo.getPin())) {
            if (Intrinsics.areEqual(chatpojo.getPin(), "1")) {
                binding.ivPinMsgLeftPdf.setVisibility(0);
                return;
            } else {
                binding.ivPinMsgLeftPdf.setVisibility(8);
                return;
            }
        }
        binding.ivPinMsgLeftPdf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindLeftPdfData$lambda$31$lambda$30$lambda$26(GroupChatAdapter2 groupChatAdapter2, chatPojo chatpojo, View view) {
        groupChatAdapter2.pauseAudio();
        if (Helper.isNetworkConnected(groupChatAdapter2.context)) {
            Intent intent = new Intent(groupChatAdapter2.context, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("url", chatpojo.getMessage());
            intent.putExtra(Const.IS_DOWNLOAD, true);
            intent.putExtra("from", "ChatAdapter");
            intent.putExtra("save", true);
            String message = chatpojo.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
            List listSplit$default = StringsKt.split$default((CharSequence) message, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null);
            String message2 = chatpojo.getMessage();
            Intrinsics.checkNotNullExpressionValue(message2, "getMessage(...)");
            intent.putExtra("title", (String) listSplit$default.get(StringsKt.split$default((CharSequence) message2, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null).size() - 1));
            groupChatAdapter2.context.startActivity(intent);
            return;
        }
        Helper.showInternetToast(groupChatAdapter2.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLeftPdfData$lambda$31$lambda$30$lambda$27(GroupChatAdapter2 groupChatAdapter2, int i, ItemPdfChatLeftNewBinding itemPdfChatLeftNewBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout timeRl6 = itemPdfChatLeftNewBinding.timeRl6;
            Intrinsics.checkNotNullExpressionValue(timeRl6, "timeRl6");
            groupChatAdapter2.showListPopupWindow1(i, timeRl6, GravityCompat.END, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindLeftPdfData$lambda$31$lambda$30$lambda$29(GroupChatAdapter2 groupChatAdapter2, chatPojo chatpojo, int i, ItemPdfChatLeftNewBinding itemPdfChatLeftNewBinding, View view) {
        if (Helper.isNetworkConnected(groupChatAdapter2.context)) {
            String message = chatpojo.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
            RelativeLayout cvrDownLoadLeft = itemPdfChatLeftNewBinding.cvrDownLoadLeft;
            Intrinsics.checkNotNullExpressionValue(cvrDownLoadLeft, "cvrDownLoadLeft");
            groupChatAdapter2.downloadFile(message, i, cvrDownLoadLeft);
            return;
        }
        Helper.showInternetToast(groupChatAdapter2.context);
    }

    private final void bindRightPdfData(ViewHolderPdfRight viewHolderPdfRight, final int i) {
        final ItemPdfChatRightNewBinding binding = viewHolderPdfRight.getBinding();
        LinearLayout mainContainerLL = binding.mainContainerLL;
        Intrinsics.checkNotNullExpressionValue(mainContainerLL, "mainContainerLL");
        setDynamicTint$default(this, mainContainerLL, 0.0f, 1, null);
        final chatPojo chatpojo = this.dataSet.get(i);
        binding.imageThumbnail.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindRightPdfData$lambda$37$lambda$36$lambda$32(this.f$0, chatpojo, view);
            }
        });
        if (!TextUtils.isEmpty(chatpojo.getPin()) && Intrinsics.areEqual(chatpojo.getPin(), "1")) {
            binding.ivPinPdf.setVisibility(0);
        } else {
            binding.ivPinPdf.setVisibility(8);
        }
        LinearLayout linearLayout = binding.rightPdfLl;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GroupChatAdapter2.bindRightPdfData$lambda$37$lambda$36$lambda$33(this.f$0, i, binding);
                }
            }));
        }
        binding.cvrRightpdf.setVisibility(0);
        TextView textView = binding.pdfTextUsername;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str = name;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        textView.setText(str.subSequence(i2, length + 1).toString());
        TextView textView2 = binding.pdfTimeLeftPdf;
        if (textView2 != null) {
            textView2.setText(getdate(String.valueOf(chatpojo.getDate())));
        }
        String message = chatpojo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        if (message.length() > 0) {
            String message2 = chatpojo.getMessage();
            Intrinsics.checkNotNullExpressionValue(message2, "getMessage(...)");
            if (StringsKt.contains$default((CharSequence) message2, (CharSequence) MqttTopic.TOPIC_LEVEL_SEPARATOR, false, 2, (Object) null)) {
                TextView textView3 = binding.pdfNameRight;
                String message3 = chatpojo.getMessage();
                Intrinsics.checkNotNullExpressionValue(message3, "getMessage(...)");
                List listSplit$default = StringsKt.split$default((CharSequence) message3, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null);
                String message4 = chatpojo.getMessage();
                Intrinsics.checkNotNullExpressionValue(message4, "getMessage(...)");
                textView3.setText((CharSequence) listSplit$default.get(StringsKt.split$default((CharSequence) message4, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null).size() - 1));
                Context context = this.context;
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.socket.activity.GroupChatActivity");
                Pair<Boolean, File> pairIsFileExist = SocketKt.isFileExist((GroupChatActivity) context, binding.pdfNameRight.getText().toString(), false, this.in_app_download);
                RelativeLayout cvrDownLoadRight = binding.cvrDownLoadRight;
                Intrinsics.checkNotNullExpressionValue(cvrDownLoadRight, "cvrDownLoadRight");
                cvrDownLoadRight.setVisibility(pairIsFileExist.getFirst().booleanValue() ? 8 : 0);
                if (pairIsFileExist.getFirst().booleanValue() && pairIsFileExist.getSecond().exists()) {
                    try {
                        Context context2 = this.context;
                        Uri uriForFile = FileProvider.getUriForFile(context2, ((GroupChatActivity) context2).getPackageName() + ".provider", pairIsFileExist.getSecond());
                        Context context3 = this.context;
                        Intrinsics.checkNotNull(uriForFile);
                        binding.imageThumbnail.setImageBitmap(SocketKt.generateImageFromPdf(context3, uriForFile));
                    } catch (IllegalArgumentException unused) {
                    }
                }
            }
        }
        binding.cvrDownLoadRight.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindRightPdfData$lambda$37$lambda$36$lambda$35(this.f$0, chatpojo, i, binding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindRightPdfData$lambda$37$lambda$36$lambda$32(GroupChatAdapter2 groupChatAdapter2, chatPojo chatpojo, View view) {
        groupChatAdapter2.pauseAudio();
        if (Helper.isNetworkConnected(groupChatAdapter2.context)) {
            Intent intent = new Intent(groupChatAdapter2.context, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("url", chatpojo.getMessage());
            intent.putExtra("from", "ChatAdapter");
            intent.putExtra("save", true);
            String message = chatpojo.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
            List listSplit$default = StringsKt.split$default((CharSequence) message, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null);
            String message2 = chatpojo.getMessage();
            Intrinsics.checkNotNullExpressionValue(message2, "getMessage(...)");
            intent.putExtra("title", (String) listSplit$default.get(StringsKt.split$default((CharSequence) message2, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null).size() - 1));
            groupChatAdapter2.context.startActivity(intent);
            return;
        }
        Helper.showInternetToast(groupChatAdapter2.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindRightPdfData$lambda$37$lambda$36$lambda$33(GroupChatAdapter2 groupChatAdapter2, int i, ItemPdfChatRightNewBinding itemPdfChatRightNewBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout rightPdfLl = itemPdfChatRightNewBinding.rightPdfLl;
            Intrinsics.checkNotNullExpressionValue(rightPdfLl, "rightPdfLl");
            groupChatAdapter2.showListPopupWindow(i, rightPdfLl, GravityCompat.START, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindRightPdfData$lambda$37$lambda$36$lambda$35(GroupChatAdapter2 groupChatAdapter2, chatPojo chatpojo, int i, ItemPdfChatRightNewBinding itemPdfChatRightNewBinding, View view) {
        if (Helper.isNetworkConnected(groupChatAdapter2.context)) {
            String message = chatpojo.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
            RelativeLayout cvrDownLoadRight = itemPdfChatRightNewBinding.cvrDownLoadRight;
            Intrinsics.checkNotNullExpressionValue(cvrDownLoadRight, "cvrDownLoadRight");
            groupChatAdapter2.downloadFile(message, i, cvrDownLoadRight);
            return;
        }
        Helper.showInternetToast(groupChatAdapter2.context);
    }

    private final void bindLeftAudioData(final ViewHolderAudioLeft viewHolderAudioLeft, final int i) {
        LinearLayout linearLayout;
        final ItemAudioChatLeftBinding binding = viewHolderAudioLeft.getBinding();
        final chatPojo chatpojo = this.dataSet.get(i);
        binding.timeRl8.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatAdapter2.bindLeftAudioData$lambda$45$lambda$44$lambda$38(this.f$0, i, binding);
            }
        }));
        ChatModel chatModel = this.chatModel;
        if ((chatModel != null ? chatModel.is_teacher() : null) != null) {
            ChatModel chatModel2 = this.chatModel;
            if (StringsKt.equals$default(chatModel2 != null ? chatModel2.is_teacher() : null, "1", false, 2, null) && (linearLayout = binding.timeRl8) != null) {
                linearLayout.setVisibility(0);
            }
        }
        binding.cvrLeftAudio.setVisibility(0);
        TextView textView = binding.audioTextUsernameLeft;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str = name;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        textView.setText(str.subSequence(i2, length + 1).toString());
        binding.audioTimeLeftAudio.setText(getdate(String.valueOf(chatpojo.getDate())));
        if (!TextUtils.isEmpty(chatpojo.getPin()) && Intrinsics.areEqual(chatpojo.getPin(), "1")) {
            binding.ivPinMsgLeftAudio.setVisibility(0);
        } else {
            binding.ivPinMsgLeftAudio.setVisibility(8);
        }
        binding.audioplayLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindLeftAudioData$lambda$45$lambda$44$lambda$42(this.f$0, i, chatpojo, viewHolderAudioLeft, binding, view);
            }
        });
        binding.audiopauseLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindLeftAudioData$lambda$45$lambda$44$lambda$43(this.f$0, i, view);
            }
        });
        if (chatpojo.isIsplaying()) {
            binding.audiopauseLeft.setVisibility(0);
            binding.audioplayLeft.setVisibility(8);
        } else {
            binding.audiopauseLeft.setVisibility(8);
            binding.audioplayLeft.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLeftAudioData$lambda$45$lambda$44$lambda$38(GroupChatAdapter2 groupChatAdapter2, int i, ItemAudioChatLeftBinding itemAudioChatLeftBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout timeRl8 = itemAudioChatLeftBinding.timeRl8;
            Intrinsics.checkNotNullExpressionValue(timeRl8, "timeRl8");
            groupChatAdapter2.showListPopupWindow1(i, timeRl8, GravityCompat.END, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindLeftAudioData$lambda$45$lambda$44$lambda$42(final GroupChatAdapter2 groupChatAdapter2, int i, chatPojo chatpojo, ViewHolderAudioLeft viewHolderAudioLeft, ItemAudioChatLeftBinding itemAudioChatLeftBinding, View view) {
        if (Helper.isNetworkConnected(groupChatAdapter2.context)) {
            groupChatAdapter2.pauseAudio();
            groupChatAdapter2.pauseVideoPlayer(groupChatAdapter2.context);
            MediaPlayer mediaPlayer = groupChatAdapter2.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            groupChatAdapter2.mediaPlayer = null;
            chatPojo chatpojo2 = (chatPojo) CollectionsKt.getOrNull(groupChatAdapter2.dataSet, i);
            if (chatpojo2 == null) {
                return;
            }
            chatpojo2.setIsplaying(true);
            groupChatAdapter2.dataSet.set(i, chatpojo2);
            groupChatAdapter2.lastselected = i;
            groupChatAdapter2.currentlyPlayingId = chatpojo2.getId();
            groupChatAdapter2.notifyItemChanged(groupChatAdapter2.lastselected);
            try {
                MediaPlayer mediaPlayerCreate = MediaPlayer.create(groupChatAdapter2.context, Uri.parse(chatpojo.getMessage()));
                groupChatAdapter2.mediaPlayer = mediaPlayerCreate;
                if (mediaPlayerCreate != null) {
                    mediaPlayerCreate.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public final void onCompletion(MediaPlayer mediaPlayer2) {
                            GroupChatAdapter2.bindLeftAudioData$lambda$45$lambda$44$lambda$42$lambda$41(this.f$0, mediaPlayer2);
                        }
                    });
                }
                MediaPlayer mediaPlayer2 = groupChatAdapter2.mediaPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.start();
                }
                groupChatAdapter2.starttimer(viewHolderAudioLeft, itemAudioChatLeftBinding.audiopauseLeft, itemAudioChatLeftBinding.audioplayLeft, i);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                Toast.makeText(groupChatAdapter2.context, "Audio playback failed", 0).show();
                return;
            }
        }
        Helper.showInternetToast(groupChatAdapter2.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindLeftAudioData$lambda$45$lambda$44$lambda$42$lambda$41(GroupChatAdapter2 groupChatAdapter2, MediaPlayer mediaPlayer) {
        Iterator<chatPojo> it = groupChatAdapter2.dataSet.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), groupChatAdapter2.currentlyPlayingId)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            groupChatAdapter2.dataSet.get(i).setIsplaying(false);
            groupChatAdapter2.notifyItemChanged(i);
        }
        MediaPlayer mediaPlayer2 = groupChatAdapter2.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }
        groupChatAdapter2.mediaPlayer = null;
        groupChatAdapter2.currentlyPlayingId = null;
        groupChatAdapter2.stoptimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindLeftAudioData$lambda$45$lambda$44$lambda$43(GroupChatAdapter2 groupChatAdapter2, int i, View view) {
        groupChatAdapter2.stoptimer();
        chatPojo chatpojo = groupChatAdapter2.dataSet.get(i);
        Intrinsics.checkNotNullExpressionValue(chatpojo, "get(...)");
        chatPojo chatpojo2 = chatpojo;
        chatpojo2.setIsplaying(false);
        groupChatAdapter2.dataSet.set(i, chatpojo2);
        groupChatAdapter2.notifyItemChanged(i);
        MediaPlayer mediaPlayer = groupChatAdapter2.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        groupChatAdapter2.playVideoPlayer(groupChatAdapter2.context);
    }

    private final void bindRightAudioData(final ViewHolderAudioRight viewHolderAudioRight, final int i) {
        final ItemAudioChatRightBinding binding = viewHolderAudioRight.getBinding();
        LinearLayout mainContainerLL = binding.mainContainerLL;
        Intrinsics.checkNotNullExpressionValue(mainContainerLL, "mainContainerLL");
        setDynamicTint$default(this, mainContainerLL, 0.0f, 1, null);
        final chatPojo chatpojo = this.dataSet.get(i);
        binding.timeRl7.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatAdapter2.bindRightAudioData$lambda$51$lambda$50$lambda$46(this.f$0, i, binding);
            }
        }));
        if (!TextUtils.isEmpty(chatpojo.getPin()) && Intrinsics.areEqual(chatpojo.getPin(), "1")) {
            binding.ivPinAudio.setVisibility(0);
        } else {
            binding.ivPinAudio.setVisibility(8);
        }
        binding.cvrRightAudio.setVisibility(0);
        TextView textView = binding.audioTextUsername;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str = name;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        textView.setText(str.subSequence(i2, length + 1).toString());
        binding.righttexttimeAudio.setText(getdate(String.valueOf(chatpojo.getDate())));
        binding.audioplay.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindRightAudioData$lambda$51$lambda$50$lambda$48(this.f$0, i, chatpojo, viewHolderAudioRight, binding, view);
            }
        });
        binding.audiopause.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupChatAdapter2.bindRightAudioData$lambda$51$lambda$50$lambda$49(this.f$0, i, view);
            }
        });
        if (chatpojo.isIsplaying()) {
            binding.audiopause.setVisibility(0);
            binding.audioplay.setVisibility(8);
        } else {
            binding.audiopause.setVisibility(8);
            binding.audioplay.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindRightAudioData$lambda$51$lambda$50$lambda$46(GroupChatAdapter2 groupChatAdapter2, int i, ItemAudioChatRightBinding itemAudioChatRightBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout timeRl7 = itemAudioChatRightBinding.timeRl7;
            Intrinsics.checkNotNullExpressionValue(timeRl7, "timeRl7");
            groupChatAdapter2.showListPopupWindow(i, timeRl7, GravityCompat.START, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindRightAudioData$lambda$51$lambda$50$lambda$48(GroupChatAdapter2 groupChatAdapter2, int i, chatPojo chatpojo, ViewHolderAudioRight viewHolderAudioRight, ItemAudioChatRightBinding itemAudioChatRightBinding, View view) {
        if (Helper.isNetworkConnected(groupChatAdapter2.context)) {
            groupChatAdapter2.pauseVideoPlayer(groupChatAdapter2.context);
            groupChatAdapter2.pauseAudio();
            MediaPlayer mediaPlayer = groupChatAdapter2.mediaPlayer;
            if (mediaPlayer == null) {
                chatPojo chatpojo2 = groupChatAdapter2.dataSet.get(i);
                Intrinsics.checkNotNullExpressionValue(chatpojo2, "get(...)");
                chatPojo chatpojo3 = chatpojo2;
                chatpojo3.setIsplaying(true);
                groupChatAdapter2.dataSet.set(i, chatpojo3);
                groupChatAdapter2.lastselected = i;
                groupChatAdapter2.notifyItemChanged(i);
                MediaPlayer mediaPlayerCreate = MediaPlayer.create(groupChatAdapter2.context, Uri.parse(chatpojo.getMessage()));
                groupChatAdapter2.mediaPlayer = mediaPlayerCreate;
                Intrinsics.checkNotNull(mediaPlayerCreate);
                mediaPlayerCreate.start();
                groupChatAdapter2.starttimer(viewHolderAudioRight, itemAudioChatRightBinding.audiopause, itemAudioChatRightBinding.audioplay, i);
                return;
            }
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = groupChatAdapter2.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.pause();
                groupChatAdapter2.stoptimer();
                chatPojo chatpojo4 = groupChatAdapter2.dataSet.get(groupChatAdapter2.lastselected);
                Intrinsics.checkNotNullExpressionValue(chatpojo4, "get(...)");
                chatPojo chatpojo5 = chatpojo4;
                chatpojo5.setIsplaying(false);
                groupChatAdapter2.dataSet.set(groupChatAdapter2.lastselected, chatpojo5);
                chatPojo chatpojo6 = groupChatAdapter2.dataSet.get(i);
                Intrinsics.checkNotNullExpressionValue(chatpojo6, "get(...)");
                chatPojo chatpojo7 = chatpojo6;
                chatpojo7.setIsplaying(true);
                groupChatAdapter2.dataSet.set(i, chatpojo7);
                groupChatAdapter2.lastselected = i;
                groupChatAdapter2.notifyItemChanged(i);
                MediaPlayer mediaPlayerCreate2 = MediaPlayer.create(groupChatAdapter2.context, Uri.parse(chatpojo.getMessage()));
                groupChatAdapter2.mediaPlayer = mediaPlayerCreate2;
                Intrinsics.checkNotNull(mediaPlayerCreate2);
                mediaPlayerCreate2.start();
                groupChatAdapter2.starttimer(viewHolderAudioRight, itemAudioChatRightBinding.audiopause, itemAudioChatRightBinding.audioplay, i);
                return;
            }
            chatPojo chatpojo8 = groupChatAdapter2.dataSet.get(i);
            Intrinsics.checkNotNullExpressionValue(chatpojo8, "get(...)");
            chatPojo chatpojo9 = chatpojo8;
            chatpojo9.setIsplaying(true);
            groupChatAdapter2.dataSet.set(i, chatpojo9);
            groupChatAdapter2.lastselected = i;
            groupChatAdapter2.notifyItemChanged(i);
            MediaPlayer mediaPlayerCreate3 = MediaPlayer.create(groupChatAdapter2.context, Uri.parse(chatpojo.getMessage()));
            groupChatAdapter2.mediaPlayer = mediaPlayerCreate3;
            Intrinsics.checkNotNull(mediaPlayerCreate3);
            mediaPlayerCreate3.start();
            groupChatAdapter2.starttimer(viewHolderAudioRight, itemAudioChatRightBinding.audiopause, itemAudioChatRightBinding.audioplay, i);
            return;
        }
        Helper.showInternetToast(groupChatAdapter2.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindRightAudioData$lambda$51$lambda$50$lambda$49(GroupChatAdapter2 groupChatAdapter2, int i, View view) {
        groupChatAdapter2.stoptimer();
        chatPojo chatpojo = groupChatAdapter2.dataSet.get(i);
        Intrinsics.checkNotNullExpressionValue(chatpojo, "get(...)");
        chatPojo chatpojo2 = chatpojo;
        chatpojo2.setIsplaying(false);
        groupChatAdapter2.dataSet.set(i, chatpojo2);
        MediaPlayer mediaPlayer = groupChatAdapter2.mediaPlayer;
        if (mediaPlayer != null) {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = groupChatAdapter2.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.pause();
            }
        }
        groupChatAdapter2.notifyItemChanged(i);
        groupChatAdapter2.playVideoPlayer(groupChatAdapter2.context);
    }

    private final void bindLeftUrlData(ViewHolderUrlLeft viewHolderUrlLeft, final int i) {
        final ItemUrlChatLeftBinding binding = viewHolderUrlLeft.getBinding();
        chatPojo chatpojo = this.dataSet.get(i);
        binding.timeRl9.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatAdapter2.bindLeftUrlData$lambda$56$lambda$55$lambda$52(this.f$0, i, binding);
            }
        }));
        binding.cvrUrlLeft.setVisibility(0);
        TextView textView = binding.letfmessageTvUrl;
        String message = chatpojo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        String str = message;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        textView.setText(str.subSequence(i2, length + 1).toString());
        Linkify.addLinks(binding.letfmessageTvUrl, 1);
        TextView textView2 = binding.userNameUrlLeft;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str2 = name;
        int length2 = str2.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length2) {
            boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i3 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                } else {
                    length2--;
                }
            } else if (z4) {
                i3++;
            } else {
                z3 = true;
            }
        }
        textView2.setText(str2.subSequence(i3, length2 + 1).toString());
        binding.lefttexttimeUrl.setText(getdate(String.valueOf(chatpojo.getDate())));
        if (!TextUtils.isEmpty(chatpojo.getPin())) {
            if (Intrinsics.areEqual(chatpojo.getPin(), "1")) {
                binding.ivPinMsgLeftUrl.setVisibility(0);
                return;
            } else {
                binding.ivPinMsgLeftUrl.setVisibility(8);
                return;
            }
        }
        binding.ivPinMsgLeftUrl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindLeftUrlData$lambda$56$lambda$55$lambda$52(GroupChatAdapter2 groupChatAdapter2, int i, ItemUrlChatLeftBinding itemUrlChatLeftBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout timeRl9 = itemUrlChatLeftBinding.timeRl9;
            Intrinsics.checkNotNullExpressionValue(timeRl9, "timeRl9");
            showListPopupWindow$default(groupChatAdapter2, i, timeRl9, GravityCompat.END, false, 8, null);
        }
        return Unit.INSTANCE;
    }

    private final void bindRightUrlData(ViewHolderUrlRight viewHolderUrlRight, final int i) {
        final ItemUrlChatRightBinding binding = viewHolderUrlRight.getBinding();
        LinearLayout mainContainerLL = binding.mainContainerLL;
        Intrinsics.checkNotNullExpressionValue(mainContainerLL, "mainContainerLL");
        setDynamicTint$default(this, mainContainerLL, 0.0f, 1, null);
        chatPojo chatpojo = this.dataSet.get(i);
        binding.timeRl10.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatAdapter2.bindRightUrlData$lambda$62$lambda$61$lambda$57(this.f$0, i, binding);
            }
        }));
        if (!TextUtils.isEmpty(chatpojo.getPin()) && Intrinsics.areEqual(chatpojo.getPin(), "1")) {
            binding.ivPinUrl.setVisibility(0);
        } else {
            binding.ivPinUrl.setVisibility(8);
        }
        binding.cvrUrlRight.setVisibility(0);
        TextView textView = binding.rightmessageUrl;
        String message = chatpojo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        String str = message;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        textView.setText(str.subSequence(i2, length + 1).toString());
        TextView textView2 = binding.rightmessageUrl;
        String message2 = chatpojo.getMessage();
        Intrinsics.checkNotNullExpressionValue(message2, "getMessage(...)");
        String str2 = message2;
        int length2 = str2.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length2) {
            boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i3 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                } else {
                    length2--;
                }
            } else if (z4) {
                i3++;
            } else {
                z3 = true;
            }
        }
        textView2.setText(str2.subSequence(i3, length2 + 1).toString());
        Linkify.addLinks(binding.rightmessageUrl, 1);
        TextView textView3 = binding.userNamerightUrl;
        String name = chatpojo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String str3 = name;
        int length3 = str3.length() - 1;
        int i4 = 0;
        boolean z5 = false;
        while (i4 <= length3) {
            boolean z6 = Intrinsics.compare((int) str3.charAt(!z5 ? i4 : length3), 32) <= 0;
            if (z5) {
                if (!z6) {
                    break;
                } else {
                    length3--;
                }
            } else if (z6) {
                i4++;
            } else {
                z5 = true;
            }
        }
        textView3.setText(str3.subSequence(i4, length3 + 1).toString());
        binding.righttexttimeUrl.setText(getdate(String.valueOf(chatpojo.getDate())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindRightUrlData$lambda$62$lambda$61$lambda$57(GroupChatAdapter2 groupChatAdapter2, int i, ItemUrlChatRightBinding itemUrlChatRightBinding) {
        if (!Intrinsics.areEqual(Const.SHOW_PIN, groupChatAdapter2.type)) {
            LinearLayout timeRl10 = itemUrlChatRightBinding.timeRl10;
            Intrinsics.checkNotNullExpressionValue(timeRl10, "timeRl10");
            groupChatAdapter2.showListPopupWindow(i, timeRl10, GravityCompat.START, false);
        }
        return Unit.INSTANCE;
    }

    public final void pauseAudio() {
        if (this.tempHolderLeft == null && this.tempHolderRight == null) {
            return;
        }
        stoptimer();
        chatPojo chatpojo = (chatPojo) CollectionsKt.getOrNull(this.dataSet, this.templistPosition);
        if (chatpojo == null) {
            return;
        }
        chatpojo.setIsplaying(false);
        this.dataSet.set(this.templistPosition, chatpojo);
        ViewHolderAudioLeft viewHolderAudioLeft = this.tempHolderLeft;
        if (viewHolderAudioLeft != null) {
            Intrinsics.checkNotNull(viewHolderAudioLeft);
            viewHolderAudioLeft.getBinding().audiopauseLeft.setVisibility(8);
            ViewHolderAudioLeft viewHolderAudioLeft2 = this.tempHolderLeft;
            Intrinsics.checkNotNull(viewHolderAudioLeft2);
            viewHolderAudioLeft2.getBinding().audioplayLeft.setVisibility(0);
        } else {
            ViewHolderAudioRight viewHolderAudioRight = this.tempHolderRight;
            if (viewHolderAudioRight != null) {
                Intrinsics.checkNotNull(viewHolderAudioRight);
                viewHolderAudioRight.getBinding().audiopause.setVisibility(8);
                ViewHolderAudioRight viewHolderAudioRight2 = this.tempHolderRight;
                Intrinsics.checkNotNull(viewHolderAudioRight2);
                viewHolderAudioRight2.getBinding().audioplay.setVisibility(0);
            }
        }
        notifyItemChanged(this.templistPosition);
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = this.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.pause();
            }
        }
        if (this.tempHolderLeft != null) {
            this.tempHolderLeft = null;
        } else if (this.tempHolderRight != null) {
            this.tempHolderRight = null;
        }
    }

    private final void setPinChat(Context mContext, int position) {
        if (mContext instanceof GroupChatActivity) {
            chatPojo chatpojo = this.dataSet.get(position);
            Intrinsics.checkNotNullExpressionValue(chatpojo, "get(...)");
            ((GroupChatActivity) mContext).setPin(chatpojo);
        }
    }

    private final void setUnPin(Context mContext, int position) {
        if (mContext instanceof GroupChatActivity) {
            chatPojo chatpojo = this.dataSet.get(position);
            Intrinsics.checkNotNullExpressionValue(chatpojo, "get(...)");
            ((GroupChatActivity) mContext).setUnPin(chatpojo);
        }
    }

    public final String getClicktype() {
        return this.clicktype;
    }

    public final void setClicktype(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clicktype = str;
    }

    public final PopupMenu getPopupMenu() {
        return this.popupMenu;
    }

    public final void setPopupMenu(PopupMenu popupMenu) {
        this.popupMenu = popupMenu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isUserAdmin() {
        return SharedPreference.getInstance().getLoggedInUser() != null && StringsKt.equals$default(this.chat_Model.is_teacher(), "1", false, 2, null);
    }

    static /* synthetic */ void showListPopupWindow$default(GroupChatAdapter2 groupChatAdapter2, int i, View view, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = true;
        }
        groupChatAdapter2.showListPopupWindow(i, view, i2, z);
    }

    private final void showListPopupWindow(final int position, View anchor, int gravity, final boolean isText) {
        final List listListOf;
        final ListPopupWindow listPopupWindow = new ListPopupWindow(this.context);
        if (gravity == 8388611) {
            if (isUserAdmin()) {
                if (Intrinsics.areEqual(this.dataSet.get(position).getPin(), "0")) {
                    listListOf = CollectionsKt.listOf((Object[]) new String[]{"Pin", "Edit", "Delete"});
                } else {
                    listListOf = CollectionsKt.listOf((Object[]) new String[]{"UnPin", "Edit", "Delete"});
                }
            } else if (isText) {
                listListOf = CollectionsKt.listOf((Object[]) new String[]{"Edit", "Delete", "Copy"});
            } else {
                listListOf = CollectionsKt.listOf("Delete");
            }
            final Context context = this.context;
            listPopupWindow.setAdapter(new ArrayAdapter<String>(listListOf, context) { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$showListPopupWindow$adapter$1
                @Override // android.widget.ArrayAdapter, android.widget.Adapter
                public View getView(int position2, View convertView, ViewGroup parent) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    if (convertView == null) {
                        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_chat_popup_menu, parent, false);
                    }
                    TextView textView = (TextView) convertView.findViewById(R.id.popupText);
                    ImageView imageView = (ImageView) convertView.findViewById(R.id.popupImage);
                    textView.setText(getItem(position2));
                    if (this.isUserAdmin()) {
                        if (position2 == 0) {
                            imageView.setImageResource(R.mipmap.red_pin);
                        } else if (position2 == 1) {
                            imageView.setImageResource(R.drawable.edit);
                        } else if (position2 == 2) {
                            imageView.setImageResource(R.mipmap.delete_icon);
                        }
                    } else if (!isText) {
                        imageView.setImageResource(R.mipmap.delete_icon);
                    } else if (position2 == 0) {
                        imageView.setImageResource(R.drawable.edit);
                    } else if (position2 == 1) {
                        imageView.setImageResource(R.mipmap.delete_icon);
                    } else if (position2 == 2) {
                        imageView.setImageResource(R.drawable.copy_icon);
                    }
                    Intrinsics.checkNotNull(convertView);
                    return convertView;
                }
            });
            listPopupWindow.setAnchorView(anchor);
            listPopupWindow.setDropDownGravity(gravity);
            listPopupWindow.setWidth(300);
            listPopupWindow.setHeight(-2);
            listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$$ExternalSyntheticLambda14
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    GroupChatAdapter2.showListPopupWindow$lambda$63(this.f$0, position, listPopupWindow, isText, adapterView, view, i, j);
                }
            });
            listPopupWindow.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showListPopupWindow$lambda$63(GroupChatAdapter2 groupChatAdapter2, int i, ListPopupWindow listPopupWindow, boolean z, AdapterView adapterView, View view, int i2, long j) {
        if (groupChatAdapter2.isUserAdmin()) {
            if (i2 == 0) {
                if (Intrinsics.areEqual(groupChatAdapter2.dataSet.get(i).getPin(), "1")) {
                    groupChatAdapter2.setUnPin(groupChatAdapter2.context, i);
                } else {
                    groupChatAdapter2.setPinChat(groupChatAdapter2.context, i);
                }
                listPopupWindow.dismiss();
                return;
            }
            if (i2 == 1) {
                Context context = groupChatAdapter2.context;
                if (context instanceof GroupChatActivity) {
                    chatPojo chatpojo = groupChatAdapter2.dataSet.get(i);
                    Intrinsics.checkNotNullExpressionValue(chatpojo, "get(...)");
                    ((GroupChatActivity) context).editChat(chatpojo);
                }
                listPopupWindow.dismiss();
                return;
            }
            if (i2 != 2) {
                return;
            }
            Context context2 = groupChatAdapter2.context;
            if (context2 instanceof GroupChatActivity) {
                chatPojo chatpojo2 = groupChatAdapter2.dataSet.get(i);
                Intrinsics.checkNotNullExpressionValue(chatpojo2, "get(...)");
                ((GroupChatActivity) context2).deleteChat(chatpojo2);
            }
            listPopupWindow.dismiss();
            return;
        }
        if (!z) {
            if (i2 == 0) {
                Context context3 = groupChatAdapter2.context;
                if (context3 instanceof GroupChatActivity) {
                    chatPojo chatpojo3 = groupChatAdapter2.dataSet.get(i);
                    Intrinsics.checkNotNullExpressionValue(chatpojo3, "get(...)");
                    ((GroupChatActivity) context3).deleteChat(chatpojo3);
                }
                listPopupWindow.dismiss();
                return;
            }
            return;
        }
        if (i2 == 0) {
            Context context4 = groupChatAdapter2.context;
            if (context4 instanceof GroupChatActivity) {
                chatPojo chatpojo4 = groupChatAdapter2.dataSet.get(i);
                Intrinsics.checkNotNullExpressionValue(chatpojo4, "get(...)");
                ((GroupChatActivity) context4).editChat(chatpojo4);
            }
            listPopupWindow.dismiss();
            return;
        }
        if (i2 == 1) {
            Context context5 = groupChatAdapter2.context;
            if (context5 instanceof GroupChatActivity) {
                chatPojo chatpojo5 = groupChatAdapter2.dataSet.get(i);
                Intrinsics.checkNotNullExpressionValue(chatpojo5, "get(...)");
                ((GroupChatActivity) context5).deleteChat(chatpojo5);
            }
            listPopupWindow.dismiss();
            return;
        }
        if (i2 != 2) {
            return;
        }
        Context context6 = groupChatAdapter2.context;
        if (context6 instanceof GroupChatActivity) {
            chatPojo chatpojo6 = groupChatAdapter2.dataSet.get(i);
            Intrinsics.checkNotNullExpressionValue(chatpojo6, "get(...)");
            ((GroupChatActivity) context6).copyChat(chatpojo6);
        }
        listPopupWindow.dismiss();
    }

    static /* synthetic */ void showListPopupWindow1$default(GroupChatAdapter2 groupChatAdapter2, int i, View view, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = true;
        }
        groupChatAdapter2.showListPopupWindow1(i, view, i2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void showListPopupWindow1(final int r18, android.view.View r19, int r20, final boolean r21) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.socket.adapter.GroupChatAdapter2.showListPopupWindow1(int, android.view.View, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showListPopupWindow1$lambda$64(GroupChatAdapter2 groupChatAdapter2, int i, ListPopupWindow listPopupWindow, boolean z, AdapterView adapterView, View view, int i2, long j) {
        ChatModel chatModel = groupChatAdapter2.chatModel;
        if ((chatModel != null ? chatModel.is_teacher() : null) != null) {
            ChatModel chatModel2 = groupChatAdapter2.chatModel;
            if (StringsKt.equals$default(chatModel2 != null ? chatModel2.is_teacher() : null, "1", false, 2, null)) {
                if (i2 == 0) {
                    if (Intrinsics.areEqual(groupChatAdapter2.dataSet.get(i).getPin(), "1")) {
                        groupChatAdapter2.setUnPin(groupChatAdapter2.context, i);
                    } else {
                        groupChatAdapter2.setPinChat(groupChatAdapter2.context, i);
                    }
                    listPopupWindow.dismiss();
                    return;
                }
                if (i2 == 1) {
                    Context context = groupChatAdapter2.context;
                    if (context instanceof GroupChatActivity) {
                        chatPojo chatpojo = groupChatAdapter2.dataSet.get(i);
                        Intrinsics.checkNotNullExpressionValue(chatpojo, "get(...)");
                        ((GroupChatActivity) context).deleteChat(chatpojo);
                    }
                    listPopupWindow.dismiss();
                    return;
                }
                if (i2 != 2) {
                    return;
                }
                Context context2 = groupChatAdapter2.context;
                if (context2 instanceof GroupChatActivity) {
                    chatPojo chatpojo2 = groupChatAdapter2.dataSet.get(i);
                    Intrinsics.checkNotNullExpressionValue(chatpojo2, "get(...)");
                    ((GroupChatActivity) context2).copyChat(chatpojo2);
                }
                listPopupWindow.dismiss();
                return;
            }
        }
        if (!groupChatAdapter2.isUserAdmin()) {
            if (z && i2 == 0) {
                Context context3 = groupChatAdapter2.context;
                if (context3 instanceof GroupChatActivity) {
                    chatPojo chatpojo3 = groupChatAdapter2.dataSet.get(i);
                    Intrinsics.checkNotNullExpressionValue(chatpojo3, "get(...)");
                    ((GroupChatActivity) context3).copyChat(chatpojo3);
                }
                listPopupWindow.dismiss();
                return;
            }
            return;
        }
        if (i2 == 0) {
            if (Intrinsics.areEqual(groupChatAdapter2.dataSet.get(i).getPin(), "1")) {
                groupChatAdapter2.setUnPin(groupChatAdapter2.context, i);
            } else {
                groupChatAdapter2.setPinChat(groupChatAdapter2.context, i);
            }
            listPopupWindow.dismiss();
            return;
        }
        if (i2 == 1) {
            Context context4 = groupChatAdapter2.context;
            if (context4 instanceof GroupChatActivity) {
                chatPojo chatpojo4 = groupChatAdapter2.dataSet.get(i);
                Intrinsics.checkNotNullExpressionValue(chatpojo4, "get(...)");
                ((GroupChatActivity) context4).editChat(chatpojo4);
            }
            listPopupWindow.dismiss();
            return;
        }
        if (i2 != 2) {
            return;
        }
        Context context5 = groupChatAdapter2.context;
        if (context5 instanceof GroupChatActivity) {
            chatPojo chatpojo5 = groupChatAdapter2.dataSet.get(i);
            Intrinsics.checkNotNullExpressionValue(chatpojo5, "get(...)");
            ((GroupChatActivity) context5).deleteChat(chatpojo5);
        }
        listPopupWindow.dismiss();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void downloadFile(java.lang.String r9, final int r10, final android.widget.RelativeLayout r11) {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.socket.adapter.GroupChatAdapter2.downloadFile(java.lang.String, int, android.widget.RelativeLayout):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void getFile(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.socket.adapter.GroupChatAdapter2.getFile(java.lang.String):void");
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        String strChangeAMPM = Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp))));
        Intrinsics.checkNotNullExpressionValue(strChangeAMPM, "changeAMPM(...)");
        return strChangeAMPM;
    }

    public final void starttimer(RecyclerView.ViewHolder holder, Button pauser, Button play, int listPosition) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ViewHolderAudioLeft) {
            this.tempHolderLeft = (ViewHolderAudioLeft) holder;
        } else if (holder instanceof ViewHolderAudioRight) {
            this.tempHolderRight = (ViewHolderAudioRight) holder;
        }
        this.templistPosition = listPosition;
        Timer timer = new Timer();
        this.timer = timer;
        Intrinsics.checkNotNull(timer);
        timer.schedule(new AnonymousClass1(listPosition), 0L, 1000L);
    }

    /* JADX INFO: renamed from: com.appnew.android.socket.adapter.GroupChatAdapter2$starttimer$1, reason: invalid class name */
    /* JADX INFO: compiled from: GroupChatAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/socket/adapter/GroupChatAdapter2$starttimer$1", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ int $listPosition;

        AnonymousClass1(int i) {
            this.$listPosition = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Context context = GroupChatAdapter2.this.context;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            final GroupChatAdapter2 groupChatAdapter2 = GroupChatAdapter2.this;
            final int i = this.$listPosition;
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.adapter.GroupChatAdapter2$starttimer$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GroupChatAdapter2.AnonymousClass1.run$lambda$0(groupChatAdapter2, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(GroupChatAdapter2 groupChatAdapter2, int i) {
            if (groupChatAdapter2.timer == null || groupChatAdapter2.mediaPlayer == null) {
                return;
            }
            MediaPlayer mediaPlayer = groupChatAdapter2.mediaPlayer;
            Boolean boolValueOf = mediaPlayer != null ? Boolean.valueOf(mediaPlayer.isPlaying()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (boolValueOf.booleanValue()) {
                return;
            }
            groupChatAdapter2.stoptimer();
            Object obj = groupChatAdapter2.dataSet.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            chatPojo chatpojo = (chatPojo) obj;
            chatpojo.setIsplaying(false);
            groupChatAdapter2.dataSet.set(i, chatpojo);
            groupChatAdapter2.notifyItemChanged(groupChatAdapter2.lastselected);
            groupChatAdapter2.playVideoPlayer(groupChatAdapter2.context);
        }
    }

    public final void stoptimer() {
        Timer timer = this.timer;
        if (timer != null) {
            Intrinsics.checkNotNull(timer);
            timer.cancel();
            this.timer = null;
        }
    }

    static /* synthetic */ void setDynamicTint$default(GroupChatAdapter2 groupChatAdapter2, LinearLayout linearLayout, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.1f;
        }
        groupChatAdapter2.setDynamicTint(linearLayout, f2);
    }

    private final void setDynamicTint(LinearLayout linearLayout, float f2) {
        int color = ContextCompat.getColor(linearLayout.getContext(), R.color.colorPrimary);
        linearLayout.setBackgroundTintList(ColorStateList.valueOf(Color.argb(RangesKt.coerceIn((int) (f2 * 255), 0, 255), Color.red(color), Color.green(color), Color.blue(color))));
    }

    public final void releaseMediaPlayer() {
        Object obj = null;
        try {
            try {
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.release();
                }
                this.mediaPlayer = null;
                this.currentlyPlayingId = null;
                Iterator<T> it = this.dataSet.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((chatPojo) next).isIsplaying()) {
                        obj = next;
                        break;
                    }
                }
                chatPojo chatpojo = (chatPojo) obj;
                if (chatpojo != null) {
                    chatpojo.setIsplaying(false);
                    notifyDataSetChanged();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.mediaPlayer = null;
                this.currentlyPlayingId = null;
                Iterator<T> it2 = this.dataSet.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (((chatPojo) next2).isIsplaying()) {
                        obj = next2;
                        break;
                    }
                }
                chatPojo chatpojo2 = (chatPojo) obj;
                if (chatpojo2 != null) {
                    chatpojo2.setIsplaying(false);
                    notifyDataSetChanged();
                }
            }
        } catch (Throwable th) {
            this.mediaPlayer = null;
            this.currentlyPlayingId = null;
            Iterator<T> it3 = this.dataSet.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next3 = it3.next();
                if (((chatPojo) next3).isIsplaying()) {
                    obj = next3;
                    break;
                }
            }
            chatPojo chatpojo3 = (chatPojo) obj;
            if (chatpojo3 != null) {
                chatpojo3.setIsplaying(false);
                notifyDataSetChanged();
            }
            throw th;
        }
    }
}
