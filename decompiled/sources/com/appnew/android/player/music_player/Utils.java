package com.appnew.android.player.music_player;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.appnew.android.Theme.InfiniteBannerIndicator;
import com.appnew.android.databinding.RatingDialogBinding;
import com.appnew.android.databinding.SelectMediaFileBinding;
import com.appnew.android.databinding.ThankYouDialogBinding;
import com.appnew.android.socket.extension.SocketKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.eduteria.app.app.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003678B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\u00020\u0011*\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019J&\u0010\u001a\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0019\u0010 \u001a\u00020\u00112\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0002\u0010$JF\u0010%\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110'2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110'J\u0016\u0010,\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0007J \u0010,\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.J$\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000105¨\u00069"}, d2 = {"Lcom/appnew/android/player/music_player/Utils;", "", "<init>", "()V", "songArt", "Landroid/graphics/Bitmap;", "path", "", "context", "Landroid/content/Context;", "getLargeIcon", "formatDuration", TypedValues.TransitionType.S_DURATION, "", "formatTrack", "trackNumber", "delete", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "imageFile", "Ljava/io/File;", "setDynamicTint", "Landroid/widget/LinearLayout;", "opacityPercentage", "", "loadImageWithDynamicDimensions", "message", "imageCL", "Landroidx/constraintlayout/widget/ConstraintLayout;", "imageView", "Landroid/widget/ImageView;", "bottomSheet", "feedbackDialog", "", "Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog;", "([Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog;)V", "openChooseMediaBottomSheet", "isNetworkConnected", "Lkotlin/Function0;", "", "checkStoragePermission", "checkStoragePermission2", "showInternetToast", "showGreetingDialog", "callback", "Lcom/appnew/android/player/music_player/Utils$DialogDismissCallback;", "setUpViewPager", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "bannerIndicator", "Lcom/appnew/android/Theme/InfiniteBannerIndicator;", "bannerListTableForTopBanner", "", "FeedbackBottomSheetDialog", "ChooseMediaFileBottomSheetDialog", "DialogDismissCallback", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Utils {
    public static final int $stable = 0;
    public static final Utils INSTANCE = new Utils();

    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/appnew/android/player/music_player/Utils$DialogDismissCallback;", "", "onDismiss", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DialogDismissCallback {
        void onDismiss();
    }

    private Utils() {
    }

    public final Bitmap songArt(String path, Context context) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(context, "context");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(path);
        if (mediaMetadataRetriever.getEmbeddedPicture() != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(mediaMetadataRetriever.getEmbeddedPicture()));
            mediaMetadataRetriever.release();
            Intrinsics.checkNotNull(bitmapDecodeStream);
            return bitmapDecodeStream;
        }
        return getLargeIcon(context);
    }

    private final Bitmap getLargeIcon(Context context) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.headphones);
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(...)");
        return bitmapDecodeResource;
    }

    public final String formatDuration(int duration) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        long j = duration;
        String str = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final int formatTrack(int trackNumber) {
        return trackNumber >= 1000 ? trackNumber % 1000 : trackNumber;
    }

    public final void delete(final AppCompatActivity activity, final File imageFile) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.music_player.Utils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Utils.delete$lambda$0(imageFile, activity);
            }
        }, 70L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delete$lambda$0(File file, AppCompatActivity appCompatActivity) {
        String[] strArr = {file.getAbsolutePath()};
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = appCompatActivity.getContentResolver();
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id"}, "_data = ?", strArr, null);
        Intrinsics.checkNotNull(cursorQuery);
        if (cursorQuery.moveToFirst()) {
            Uri uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")));
            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
            contentResolver.delete(uriWithAppendedId, null, null);
        } else {
            Log.w("Media ", "Media not found!!");
        }
        cursorQuery.close();
    }

    public static /* synthetic */ void setDynamicTint$default(Utils utils, LinearLayout linearLayout, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.1f;
        }
        utils.setDynamicTint(linearLayout, f2);
    }

    public final void setDynamicTint(LinearLayout linearLayout, float f2) {
        Intrinsics.checkNotNullParameter(linearLayout, "<this>");
        int color = ContextCompat.getColor(linearLayout.getContext(), R.color.colorPrimary);
        linearLayout.setBackgroundTintList(ColorStateList.valueOf(Color.argb(RangesKt.coerceIn((int) (f2 * 255), 0, 255), Color.red(color), Color.green(color), Color.blue(color))));
    }

    public final void loadImageWithDynamicDimensions(final Context context, String message, final ConstraintLayout imageCL, final ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(imageCL, "imageCL");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        imageView.setLayerType(1, null);
        RequestBuilder<Bitmap> requestBuilderAsBitmap = Glide.with(context).asBitmap();
        String str = message;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
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
        requestBuilderAsBitmap.load(str.subSequence(i, length + 1).toString()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder).diskCacheStrategy(DiskCacheStrategy.ALL)).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.player.music_player.Utils.loadImageWithDynamicDimensions.2
            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                int width = resource.getWidth();
                int height = resource.getHeight();
                ViewGroup.LayoutParams layoutParams = imageCL.getLayoutParams();
                if (width > height) {
                    layoutParams.width = SocketKt.dpToPixels(context, ByteCode.MONITOREXIT);
                    layoutParams.height = SocketKt.dpToPixels(context, 150);
                    imageCL.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = SocketKt.dpToPixels(context, ByteCode.MONITOREXIT);
                    layoutParams.height = SocketKt.dpToPixels(context, 250);
                    imageCL.setLayoutParams(layoutParams);
                }
                imageView.setImageBitmap(resource);
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
                imageView.setImageDrawable(placeholder);
            }
        });
    }

    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog$Listener;", "<init>", "(Landroid/content/Context;Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog$Listener;)V", "binding", "Lcom/appnew/android/databinding/RatingDialogBinding;", "Listener", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FeedbackBottomSheetDialog extends BottomSheetDialog {
        public static final int $stable = 8;
        private final RatingDialogBinding binding;
        private Listener listener;

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog$Listener;", "", "onClose", "", "onSubmit", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public interface Listener {
            void onClose();

            void onSubmit();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedbackBottomSheetDialog(Context context, Listener listener) {
            super(context, R.style.BottomSheetDialogStyle);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(getLayoutInflater(), R.layout.rating_dialog, null, false);
            Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
            RatingDialogBinding ratingDialogBinding = (RatingDialogBinding) viewDataBindingInflate;
            this.binding = ratingDialogBinding;
            setContentView(ratingDialogBinding.getRoot());
            ratingDialogBinding.setListener(this.listener);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        }
    }

    public final void bottomSheet(final FeedbackBottomSheetDialog[] feedbackDialog) {
        Intrinsics.checkNotNullParameter(feedbackDialog, "feedbackDialog");
        Window window = feedbackDialog[0].getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        feedbackDialog[0].setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.appnew.android.player.music_player.Utils$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                Utils.bottomSheet$lambda$6(feedbackDialog, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bottomSheet$lambda$6(final FeedbackBottomSheetDialog[] feedbackBottomSheetDialogArr, DialogInterface dialogInterface) {
        new Handler().post(new Runnable() { // from class: com.appnew.android.player.music_player.Utils$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Utils.bottomSheet$lambda$6$lambda$5(feedbackBottomSheetDialogArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bottomSheet$lambda$6$lambda$5(FeedbackBottomSheetDialog[] feedbackBottomSheetDialogArr) {
        FrameLayout frameLayout;
        FeedbackBottomSheetDialog feedbackBottomSheetDialog = feedbackBottomSheetDialogArr[0];
        FeedbackBottomSheetDialog feedbackBottomSheetDialog2 = feedbackBottomSheetDialog instanceof BottomSheetDialog ? feedbackBottomSheetDialog : null;
        if (feedbackBottomSheetDialog2 == null || (frameLayout = (FrameLayout) feedbackBottomSheetDialog2.findViewById(R.id.design_bottom_sheet)) == null) {
            return;
        }
        FrameLayout frameLayout2 = frameLayout;
        BottomSheetBehavior.from(frameLayout2).setState(3);
        BottomSheetBehavior.from(frameLayout2).setDraggable(false);
    }

    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/appnew/android/player/music_player/Utils$ChooseMediaFileBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "mediaListener", "Lcom/appnew/android/player/music_player/Utils$ChooseMediaFileBottomSheetDialog$MediaListener;", "<init>", "(Landroid/content/Context;Lcom/appnew/android/player/music_player/Utils$ChooseMediaFileBottomSheetDialog$MediaListener;)V", "binding", "Lcom/appnew/android/databinding/SelectMediaFileBinding;", "MediaListener", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChooseMediaFileBottomSheetDialog extends BottomSheetDialog {
        public static final int $stable = 8;
        private final SelectMediaFileBinding binding;
        private MediaListener mediaListener;

        /* JADX INFO: compiled from: Utils.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/player/music_player/Utils$ChooseMediaFileBottomSheetDialog$MediaListener;", "", "onImageClick", "", "onFileClick", "onClose", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public interface MediaListener {
            void onClose();

            void onFileClick();

            void onImageClick();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChooseMediaFileBottomSheetDialog(Context context, MediaListener mediaListener) {
            super(context, R.style.BottomSheetDialogStyle);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mediaListener, "mediaListener");
            this.mediaListener = mediaListener;
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(getLayoutInflater(), R.layout.select_media_file, null, false);
            Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
            SelectMediaFileBinding selectMediaFileBinding = (SelectMediaFileBinding) viewDataBindingInflate;
            this.binding = selectMediaFileBinding;
            setContentView(selectMediaFileBinding.getRoot());
            selectMediaFileBinding.setMediaListener(this.mediaListener);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.appnew.android.player.music_player.Utils$ChooseMediaFileBottomSheetDialog] */
    public final void openChooseMediaBottomSheet(Context context, final Function0<Boolean> isNetworkConnected, final Function0<Unit> checkStoragePermission, final Function0<Unit> checkStoragePermission2, final Function0<Unit> showInternetToast) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(isNetworkConnected, "isNetworkConnected");
        Intrinsics.checkNotNullParameter(checkStoragePermission, "checkStoragePermission");
        Intrinsics.checkNotNullParameter(checkStoragePermission2, "checkStoragePermission2");
        Intrinsics.checkNotNullParameter(showInternetToast, "showInternetToast");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ChooseMediaFileBottomSheetDialog(context, new ChooseMediaFileBottomSheetDialog.MediaListener() { // from class: com.appnew.android.player.music_player.Utils.openChooseMediaBottomSheet.1
            @Override // com.appnew.android.player.music_player.Utils.ChooseMediaFileBottomSheetDialog.MediaListener
            public void onImageClick() {
                checkStoragePermission.invoke();
                ChooseMediaFileBottomSheetDialog chooseMediaFileBottomSheetDialog = objectRef.element;
                if (chooseMediaFileBottomSheetDialog != null) {
                    chooseMediaFileBottomSheetDialog.dismiss();
                }
            }

            @Override // com.appnew.android.player.music_player.Utils.ChooseMediaFileBottomSheetDialog.MediaListener
            public void onFileClick() {
                if (isNetworkConnected.invoke().booleanValue()) {
                    checkStoragePermission2.invoke();
                } else {
                    showInternetToast.invoke();
                }
                ChooseMediaFileBottomSheetDialog chooseMediaFileBottomSheetDialog = objectRef.element;
                if (chooseMediaFileBottomSheetDialog != null) {
                    chooseMediaFileBottomSheetDialog.dismiss();
                }
            }

            @Override // com.appnew.android.player.music_player.Utils.ChooseMediaFileBottomSheetDialog.MediaListener
            public void onClose() {
                ChooseMediaFileBottomSheetDialog chooseMediaFileBottomSheetDialog = objectRef.element;
                if (chooseMediaFileBottomSheetDialog != null) {
                    chooseMediaFileBottomSheetDialog.dismiss();
                }
            }
        });
        ((ChooseMediaFileBottomSheetDialog) objectRef.element).show();
    }

    public final void showGreetingDialog(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.thank_you_dialog, null, false);
            Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
            ThankYouDialogBinding thankYouDialogBinding = (ThankYouDialogBinding) viewDataBindingInflate;
            thankYouDialogBinding.setMessage(message);
            dialog.setContentView(thankYouDialogBinding.getRoot());
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(android.R.color.transparent);
            }
            if ((context instanceof AppCompatActivity) && !((AppCompatActivity) context).isFinishing() && !((AppCompatActivity) context).isDestroyed()) {
                dialog.show();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.player.music_player.Utils$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    Utils.showGreetingDialog$lambda$7(dialog);
                }
            }, 2000L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGreetingDialog$lambda$7(Dialog dialog) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public final void showGreetingDialog(Context context, String message, final DialogDismissCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.thank_you_dialog, null, false);
            Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
            ThankYouDialogBinding thankYouDialogBinding = (ThankYouDialogBinding) viewDataBindingInflate;
            thankYouDialogBinding.setMessage(message);
            dialog.setContentView(thankYouDialogBinding.getRoot());
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(android.R.color.transparent);
            }
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.player.music_player.Utils$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Utils.showGreetingDialog$lambda$8(callback, dialogInterface);
                }
            });
            if ((context instanceof AppCompatActivity) && !((AppCompatActivity) context).isFinishing() && !((AppCompatActivity) context).isDestroyed()) {
                dialog.show();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.player.music_player.Utils$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    Utils.showGreetingDialog$lambda$9(dialog);
                }
            }, 2000L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGreetingDialog$lambda$8(DialogDismissCallback dialogDismissCallback, DialogInterface dialogInterface) {
        if (dialogDismissCallback != null) {
            dialogDismissCallback.onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGreetingDialog$lambda$9(Dialog dialog) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public final void setUpViewPager(ViewPager2 viewPager2, final InfiniteBannerIndicator bannerIndicator, List<? extends Object> bannerListTableForTopBanner) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(bannerIndicator, "bannerIndicator");
        Intrinsics.checkNotNullParameter(bannerListTableForTopBanner, "bannerListTableForTopBanner");
        bannerIndicator.attachToViewPager2(viewPager2);
        bannerIndicator.setIndicatorCount(bannerListTableForTopBanner.size());
        bannerIndicator.setSelectedIndicatorColor(bannerIndicator.getResources().getColor(R.color.colorPrimary));
        bannerIndicator.setUnselectedIndicatorColor(bannerIndicator.getResources().getColor(R.color.gray_dark2));
        bannerIndicator.setAutoScrolling(true);
        bannerIndicator.setAutoScrollDelay(5000L);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.appnew.android.player.music_player.Utils.setUpViewPager.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bannerIndicator.setCurrentPage(position);
            }
        });
    }
}
