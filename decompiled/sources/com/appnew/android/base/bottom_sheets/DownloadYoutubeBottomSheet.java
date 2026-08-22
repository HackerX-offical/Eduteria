package com.appnew.android.base.bottom_sheets;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.appnew.android.Model.Video;
import com.appnew.android.Model.YoutubeVideo;
import com.appnew.android.Model.YoutubeVideoData;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.base.DownloadBitrateAdapter;
import com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet;
import com.appnew.android.databinding.DownloadYoutubeBottomSheetBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: compiled from: DownloadYoutubeBottomSheet.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001#B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/appnew/android/base/bottom_sheets/DownloadYoutubeBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "video", "Lcom/appnew/android/Model/Video;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lcom/appnew/android/Model/YoutubeVideoData;", "", "<init>", "(Lcom/appnew/android/Model/Video;Lkotlin/jvm/functions/Function1;)V", "getVideo", "()Lcom/appnew/android/Model/Video;", "getListener", "()Lkotlin/jvm/functions/Function1;", "youtubeVideo", "Lcom/appnew/android/Model/YoutubeVideo;", "binding", "Lcom/appnew/android/databinding/DownloadYoutubeBottomSheetBinding;", "retrofit", "Lretrofit2/Retrofit;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "showMessage", "message", "", "getRetrofitInstance", "ApiInterface", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownloadYoutubeBottomSheet extends BottomSheetDialogFragment {
    public static final int $stable = 8;
    private DownloadYoutubeBottomSheetBinding binding;
    private final Function1<YoutubeVideoData, Unit> listener;
    private Retrofit retrofit;
    private final Video video;
    private YoutubeVideo youtubeVideo;

    /* JADX INFO: compiled from: DownloadYoutubeBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/base/bottom_sheets/DownloadYoutubeBottomSheet$ApiInterface;", "", "getYoutubeVideos", "Lretrofit2/Call;", "", "videoId", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ApiInterface {
        @GET("dev/download?t=2s")
        Call<String> getYoutubeVideos(@Query("video") String videoId);
    }

    public final Function1<YoutubeVideoData, Unit> getListener() {
        return this.listener;
    }

    public final Video getVideo() {
        return this.video;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadYoutubeBottomSheet(Video video, Function1<? super YoutubeVideoData, Unit> listener) {
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.video = video;
        this.listener = listener;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DownloadYoutubeBottomSheetBinding downloadYoutubeBottomSheetBindingInflate = DownloadYoutubeBottomSheetBinding.inflate(inflater);
        this.binding = downloadYoutubeBottomSheetBindingInflate;
        if (downloadYoutubeBottomSheetBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            downloadYoutubeBottomSheetBindingInflate = null;
        }
        View root = downloadYoutubeBottomSheetBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DownloadYoutubeBottomSheetBinding downloadYoutubeBottomSheetBinding = this.binding;
        if (downloadYoutubeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            downloadYoutubeBottomSheetBinding = null;
        }
        downloadYoutubeBottomSheetBinding.lnPreparing.setVisibility(0);
        DownloadYoutubeBottomSheetBinding downloadYoutubeBottomSheetBinding2 = this.binding;
        if (downloadYoutubeBottomSheetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            downloadYoutubeBottomSheetBinding2 = null;
        }
        downloadYoutubeBottomSheetBinding2.tvResName.setText(this.video.getTitle());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadYoutubeBottomSheet.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet$onViewCreated$1", f = "DownloadYoutubeBottomSheet.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadYoutubeBottomSheet.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Call<String> youtubeVideos;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    Retrofit retrofitInstance = DownloadYoutubeBottomSheet.this.getRetrofitInstance();
                    ApiInterface apiInterface = retrofitInstance != null ? (ApiInterface) retrofitInstance.create(ApiInterface.class) : null;
                    if (apiInterface != null && (youtubeVideos = apiInterface.getYoutubeVideos(DownloadYoutubeBottomSheet.this.getVideo().getFile_url())) != null) {
                        youtubeVideos.enqueue(new C01081(DownloadYoutubeBottomSheet.this));
                    }
                } catch (Exception e2) {
                    Log.e("Ex: ", "onViewCreated: " + e2.getLocalizedMessage());
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(DownloadYoutubeBottomSheet.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    DownloadYoutubeBottomSheet.this.dismiss();
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DownloadYoutubeBottomSheet.this.dismiss();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DownloadYoutubeBottomSheet.kt */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J(\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0016J \u0010\t\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/appnew/android/base/bottom_sheets/DownloadYoutubeBottomSheet$onViewCreated$1$1", "Lretrofit2/Callback;", "", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", SaslNonza.Response.ELEMENT, "Lretrofit2/Response;", "onFailure", "t", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C01081 implements Callback<String> {
            final /* synthetic */ DownloadYoutubeBottomSheet this$0;

            C01081(DownloadYoutubeBottomSheet downloadYoutubeBottomSheet) {
                this.this$0 = downloadYoutubeBottomSheet;
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    JSONObject jSONObject = new JSONObject(response.body());
                    if (!jSONObject.has("data")) {
                        this.this$0.showMessage("Download url not available");
                        this.this$0.dismiss();
                        return;
                    }
                    if (jSONObject.getString("data").equals("{}")) {
                        this.this$0.showMessage(jSONObject.getString("message").toString());
                        this.this$0.dismiss();
                        return;
                    }
                    if (!response.isSuccessful() || response.body() == null) {
                        return;
                    }
                    this.this$0.youtubeVideo = (YoutubeVideo) new Gson().fromJson(response.body(), YoutubeVideo.class);
                    DownloadYoutubeBottomSheetBinding downloadYoutubeBottomSheetBinding = this.this$0.binding;
                    DownloadYoutubeBottomSheetBinding downloadYoutubeBottomSheetBinding2 = null;
                    if (downloadYoutubeBottomSheetBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        downloadYoutubeBottomSheetBinding = null;
                    }
                    downloadYoutubeBottomSheetBinding.lnPreparing.setVisibility(8);
                    YoutubeVideo youtubeVideo = this.this$0.youtubeVideo;
                    List<YoutubeVideoData> data = youtubeVideo != null ? youtubeVideo.getData() : null;
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type java.util.ArrayList<com.appnew.android.Model.YoutubeVideoData>");
                    final DownloadYoutubeBottomSheet downloadYoutubeBottomSheet = this.this$0;
                    DownloadBitrateAdapter downloadBitrateAdapter = new DownloadBitrateAdapter((ArrayList) data, new Function1() { // from class: com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet$onViewCreated$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DownloadYoutubeBottomSheet.AnonymousClass1.C01081.onResponse$lambda$0(downloadYoutubeBottomSheet, (YoutubeVideoData) obj);
                        }
                    });
                    DownloadYoutubeBottomSheetBinding downloadYoutubeBottomSheetBinding3 = this.this$0.binding;
                    if (downloadYoutubeBottomSheetBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        downloadYoutubeBottomSheetBinding2 = downloadYoutubeBottomSheetBinding3;
                    }
                    downloadYoutubeBottomSheetBinding2.recyclerView.setAdapter(downloadBitrateAdapter);
                } catch (Exception unused) {
                    this.this$0.showMessage("Download url not available");
                    this.this$0.dismiss();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit onResponse$lambda$0(DownloadYoutubeBottomSheet downloadYoutubeBottomSheet, YoutubeVideoData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                downloadYoutubeBottomSheet.getListener().invoke(it);
                downloadYoutubeBottomSheet.dismiss();
                return Unit.INSTANCE;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                DownloadYoutubeBottomSheetBinding downloadYoutubeBottomSheetBinding = this.this$0.binding;
                if (downloadYoutubeBottomSheetBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    downloadYoutubeBottomSheetBinding = null;
                }
                downloadYoutubeBottomSheetBinding.lnPreparing.setVisibility(8);
                Log.e("Error:: ", "onFailure: " + t.getLocalizedMessage());
                this.this$0.dismiss();
            }
        }

        /* JADX INFO: renamed from: com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet$onViewCreated$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DownloadYoutubeBottomSheet.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet$onViewCreated$1$2", f = "DownloadYoutubeBottomSheet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DownloadYoutubeBottomSheet this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DownloadYoutubeBottomSheet downloadYoutubeBottomSheet, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = downloadYoutubeBottomSheet;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    DownloadYoutubeBottomSheetBinding downloadYoutubeBottomSheetBinding = this.this$0.binding;
                    if (downloadYoutubeBottomSheetBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        downloadYoutubeBottomSheetBinding = null;
                    }
                    downloadYoutubeBottomSheetBinding.lnPreparing.setVisibility(8);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMessage(final String message) {
        try {
            requireActivity().runOnUiThread(new Runnable() { // from class: com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadYoutubeBottomSheet.showMessage$lambda$0(message, this);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMessage$lambda$0(String str, DownloadYoutubeBottomSheet downloadYoutubeBottomSheet) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Toast.makeText(downloadYoutubeBottomSheet.requireActivity(), str2, 0).show();
    }

    public final Retrofit getRetrofitInstance() {
        if (SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getId() != null) {
            MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
        } else {
            MakeMyExam.userId = "0";
        }
        Retrofit retrofit = this.retrofit;
        if (retrofit != null) {
            return retrofit;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() { // from class: com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet$$ExternalSyntheticLambda1
            @Override // okhttp3.Interceptor
            public final okhttp3.Response intercept(Interceptor.Chain chain) {
                return DownloadYoutubeBottomSheet.getRetrofitInstance$lambda$1(chain);
            }
        }).connectTimeout(1L, TimeUnit.MINUTES).readTimeout(1L, TimeUnit.MINUTES).writeTimeout(1L, TimeUnit.MINUTES).build();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(httpLoggingInterceptor);
        Retrofit retrofitBuild = new Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).baseUrl("https://h9pa429enc.execute-api.ap-south-1.amazonaws.com/").client(builder.build()).build();
        this.retrofit = retrofitBuild;
        return retrofitBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final okhttp3.Response getRetrofitInstance$lambda$1(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        String divisionID = Helper.getDivisionID() != null ? Helper.getDivisionID() : "0";
        Intrinsics.checkNotNull(divisionID);
        Request.Builder builderHeader = builderNewBuilder.header(Const.GET_DIVISION, divisionID);
        String subDivisionID = Helper.getSubDivisionID() != null ? Helper.getSubDivisionID() : "0";
        Intrinsics.checkNotNull(subDivisionID);
        Request.Builder builderHeader2 = builderHeader.header(Const.GET_SUB_DIVISION, subDivisionID);
        String userMobile = Helper.getUserMobile() != null ? Helper.getUserMobile() : "";
        Intrinsics.checkNotNull(userMobile);
        Request.Builder builderHeader3 = builderHeader2.header(Const.MOBILE, userMobile);
        String userId = MakeMyExam.getUserId() != null ? MakeMyExam.getUserId() : "0";
        Intrinsics.checkNotNull(userId);
        Request.Builder builderHeader4 = builderHeader3.header(Const.USERID, userId).header(Const.DEVICE_TYPE, "1");
        String string = !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.JWT)) ? SharedPreference.getInstance().getString(Const.JWT) : "";
        Intrinsics.checkNotNull(string);
        Request.Builder builderHeader5 = builderHeader4.header(Const.Jwt, string).removeHeader("User-Agent").addHeader("User-Agent", "okhttp/4.9.1").header(Const.LANG, String.valueOf(SharedPreference.getInstance().getInt(Const.LANGUAGE)));
        String string2 = TextUtils.isEmpty(SharedPreference.getInstance().getString("Version")) ? "" : SharedPreference.getInstance().getString("Version");
        Intrinsics.checkNotNull(string2);
        Request.Builder builderAddHeader = builderHeader5.header("Version", string2).addHeader("Authorization", API.Bearer);
        String string3 = SharedPreference.getInstance().getString(Const.APP_ID);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return chain.proceed(builderAddHeader.addHeader(Const.APP_ID, string3).build());
    }
}
