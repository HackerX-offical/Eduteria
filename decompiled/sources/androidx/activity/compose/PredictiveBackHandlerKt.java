package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: PredictiveBackHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032A\u0010\u0004\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005H\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006E\u0010\u0010\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u008a\u0084\u0002"}, d2 = {"PredictiveBackHandler", "", StreamManagement.Enabled.ELEMENT, "", "onBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release", "currentOnBack"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PredictiveBackHandlerKt {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void PredictiveBackHandler(final boolean z, final Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-642000585);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PredictiveBackHandler)77@3028L28,78@3079L24,81@3175L2013,128@5194L176,*136@5444L7,140@5632L7,142@5694L137,142@5645L186:PredictiveBackHandler.kt#q1dkbc");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                z = true;
            }
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 3) & 14);
            composerStartRestartGroup.startReplaceableGroup(-723524056);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            composerStartRestartGroup.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            composerStartRestartGroup.startReplaceableGroup(-1071578855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PredictiveBackHandler.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new OnBackPressedCallback(z) { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, androidx.activity.compose.OnBackInstance] */
                    @Override // androidx.activity.OnBackPressedCallback
                    public void handleOnBackStarted(BackEventCompat backEvent) {
                        super.handleOnBackStarted(backEvent);
                        OnBackInstance onBackInstance = objectRef.element;
                        if (onBackInstance != null) {
                            onBackInstance.cancel();
                        }
                        objectRef.element = new OnBackInstance(coroutineScope, true, PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(stateRememberUpdatedState));
                    }

                    @Override // androidx.activity.OnBackPressedCallback
                    public void handleOnBackProgressed(BackEventCompat backEvent) {
                        super.handleOnBackProgressed(backEvent);
                        OnBackInstance onBackInstance = objectRef.element;
                        if (onBackInstance != null) {
                            ChannelResult.m13910boximpl(onBackInstance.m8sendJP2dKIU(backEvent));
                        }
                    }

                    /* JADX WARN: Type inference failed for: r2v0, types: [T, androidx.activity.compose.OnBackInstance] */
                    @Override // androidx.activity.OnBackPressedCallback
                    public void handleOnBackPressed() {
                        OnBackInstance onBackInstance = objectRef.element;
                        if (onBackInstance != null) {
                            Ref.ObjectRef<OnBackInstance> objectRef2 = objectRef;
                            if (!onBackInstance.getIsPredictiveBack()) {
                                onBackInstance.cancel();
                                objectRef2.element = null;
                            }
                        }
                        if (objectRef.element == null) {
                            objectRef.element = new OnBackInstance(coroutineScope, false, PredictiveBackHandlerKt.PredictiveBackHandler$lambda$0(stateRememberUpdatedState));
                        }
                        OnBackInstance onBackInstance2 = objectRef.element;
                        if (onBackInstance2 != null) {
                            onBackInstance2.close();
                        }
                        OnBackInstance onBackInstance3 = objectRef.element;
                        if (onBackInstance3 == null) {
                            return;
                        }
                        onBackInstance3.setPredictiveBack(false);
                    }

                    @Override // androidx.activity.OnBackPressedCallback
                    public void handleOnBackCancelled() {
                        super.handleOnBackCancelled();
                        OnBackInstance onBackInstance = objectRef.element;
                        if (onBackInstance != null) {
                            onBackInstance.cancel();
                        }
                        OnBackInstance onBackInstance2 = objectRef.element;
                        if (onBackInstance2 == null) {
                            return;
                        }
                        onBackInstance2.setPredictiveBack(false);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 = (PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1) objRememberedValue2;
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(Boolean.valueOf(z), new AnonymousClass1(predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1, z, objectRef, null), composerStartRestartGroup, i3 & 14);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null) {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
            }
            final OnBackPressedDispatcher onBackPressedDispatcher = current.getOnBackPressedDispatcher();
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume;
            composerStartRestartGroup.startReplaceableGroup(-1071576336);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PredictiveBackHandler.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(onBackPressedDispatcher) | composerStartRestartGroup.changed(lifecycleOwner) | composerStartRestartGroup.changed(predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        onBackPressedDispatcher.addCallback(lifecycleOwner, predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1);
                        final PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$12 = predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1;
                        return new DisposableEffectResult() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$2$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                remove();
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(lifecycleOwner, onBackPressedDispatcher, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.activity.compose.PredictiveBackHandlerKt.PredictiveBackHandler.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    PredictiveBackHandlerKt.PredictiveBackHandler(z, function2, composer2, i | 1, i2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$1, reason: invalid class name */
    /* JADX INFO: compiled from: PredictiveBackHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$1", f = "PredictiveBackHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 $backCallBack;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Ref.ObjectRef<OnBackInstance> $onBackInstance;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1, boolean z, Ref.ObjectRef<OnBackInstance> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$backCallBack = predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1;
            this.$enabled = z;
            this.$onBackInstance = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$backCallBack, this.$enabled, this.$onBackInstance, continuation);
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
            setEnabled(this.$enabled);
            if (!this.$enabled) {
                OnBackInstance onBackInstance = this.$onBackInstance.element;
                if (onBackInstance != null) {
                    Boxing.boxBoolean(onBackInstance.close());
                }
                this.$onBackInstance.element = null;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Flow<BackEventCompat>, Continuation<Unit>, Object> PredictiveBackHandler$lambda$0(State<? extends Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object>> state) {
        return (Function2) state.getValue();
    }
}
