package com.appnew.android.Intro.Activity;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.appnew.android.Intro.Fragment.MainCategoryFragment;
import com.appnew.android.Intro.SubCat;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.pojo.Userinfo.Data;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: IntroActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.appnew.android.Intro.Activity.IntroActivity$setClicks$1$1", f = "IntroActivity.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
final class IntroActivity$setClicks$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IntroActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntroActivity$setClicks$1$1(IntroActivity introActivity, Continuation<? super IntroActivity$setClicks$1$1> continuation) {
        super(2, continuation);
        this.this$0 = introActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntroActivity$setClicks$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IntroActivity$setClicks$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IntroActivity introActivity = this.this$0;
                introActivity.setFragmentManager(introActivity.getSupportFragmentManager());
                IntroActivity introActivity2 = this.this$0;
                FragmentManager fragmentManager = introActivity2.getFragmentManager();
                Intrinsics.checkNotNull(fragmentManager);
                introActivity2.setFragment(fragmentManager.findFragmentById(R.id.container));
                if (this.this$0.getFragment() instanceof MainCategoryFragment) {
                    if (this.this$0.getMaincatlist().size() > 0) {
                        this.this$0.setSubids("");
                        Iterator<SubCat> it = this.this$0.getMaincatlist().iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            SubCat next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            SubCat subCat = next;
                            Data.Preferences preferences = new Data.Preferences();
                            IntroActivity introActivity3 = this.this$0;
                            introActivity3.setSubids(introActivity3.getSubids() + subCat.getId() + Constants.SEPARATOR_COMMA);
                            preferences.setMain_cat(subCat.getParenid());
                            preferences.setSub_cat(subCat.getId());
                            this.this$0.getPrefencelist().add(preferences);
                        }
                        if (this.this$0.getSubids().length() > 0 && !TextUtils.isEmpty(this.this$0.getSubids()) && StringsKt.endsWith$default(this.this$0.getSubids(), Constants.SEPARATOR_COMMA, false, 2, (Object) null)) {
                            IntroActivity introActivity4 = this.this$0;
                            String strSubstring = introActivity4.getSubids().substring(0, this.this$0.getSubids().length() - 1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            introActivity4.setSubids(strSubstring);
                            this.label = 1;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            Boxing.boxInt(Log.e("shantanu", "setClicks: " + this.this$0.getSubids()));
                        }
                    } else {
                        Toast.makeText(this.this$0, "Please select category", 0).show();
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.appnew.android.Intro.Activity.IntroActivity$setClicks$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntroActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Intro.Activity.IntroActivity$setClicks$1$1$1", f = "IntroActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IntroActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IntroActivity introActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = introActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NetworkCall networkCall = this.this$0.getNetworkCall();
            Intrinsics.checkNotNull(networkCall);
            networkCall.NetworkAPICall(API.update_preference, "", true, false);
            return Unit.INSTANCE;
        }
    }
}
