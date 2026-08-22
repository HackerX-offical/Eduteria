package androidx.compose.foundation.text.contextmenu.internal;

import android.R;
import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.exifinterface.media.ExifInterface;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: compiled from: AndroidTextContextMenuToolbarProvider.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0002-.B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0012J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002JK\u0010&\u001a\u0002H'\"\b\b\u0000\u0010'*\u00020\u0011\"\b\b\u0001\u0010(*\u00020\u00112\u0006\u0010)\u001a\u0002H(2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u00020\u00120\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H'0\bH\u0002¢\u0006\u0002\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "callbackInjector", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "coordinatesProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "onDataChange", "", "", "onPositionChange", "actionMode", "Landroid/view/ActionMode;", "startActionModeRunnable", "Ljava/lang/Runnable;", "finishActionModeRunnable", "showTextContextMenu", "dataProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "(Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "dispose", "createActionModeCallback", Session.ELEMENT, "Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider$TextContextMenuSessionImpl;", "observeAndGetData", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "observeAndGetBounds", "Landroidx/compose/ui/geometry/Rect;", "observeReadsAndGet", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "scope", "onValueChanged", BlockContactsIQ.ELEMENT, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "TextActionModeCallbackImpl", "TextContextMenuSessionImpl", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidTextContextMenuToolbarProvider implements TextContextMenuProvider {
    public static final int $stable = 8;
    private ActionMode actionMode;
    private final Function1<TextActionModeCallback, TextActionModeCallback> callbackInjector;
    private final Function0<LayoutCoordinates> coordinatesProvider;
    private Runnable finishActionModeRunnable;
    private Runnable startActionModeRunnable;
    private final View view;
    private final MutatorMutex mutatorMutex = new MutatorMutex();
    private final SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new Function1() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AndroidTextContextMenuToolbarProvider.snapshotStateObserver$lambda$0(this.f$0, (Function0) obj);
        }
    });
    private final Function1<Object, Unit> onDataChange = new Function1() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AndroidTextContextMenuToolbarProvider.onDataChange$lambda$0(this.f$0, obj);
        }
    };
    private final Function1<Object, Unit> onPositionChange = new Function1() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AndroidTextContextMenuToolbarProvider.onPositionChange$lambda$0(this.f$0, obj);
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidTextContextMenuToolbarProvider(View view, Function1<? super TextActionModeCallback, ? extends TextActionModeCallback> function1, Function0<? extends LayoutCoordinates> function0) {
        this.view = view;
        this.callbackInjector = function1;
        this.coordinatesProvider = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit snapshotStateObserver$lambda$0(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, final Function0 function0) {
        Handler handler = androidTextContextMenuToolbarProvider.view.getHandler();
        if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
            function0.invoke();
        } else {
            Handler handler2 = androidTextContextMenuToolbarProvider.view.getHandler();
            if (handler2 != null) {
                handler2.post(new Runnable() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        function0.invoke();
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDataChange$lambda$0(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, Object obj) {
        ActionMode actionMode = androidTextContextMenuToolbarProvider.actionMode;
        if (actionMode != null) {
            actionMode.invalidate();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPositionChange$lambda$0(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, Object obj) {
        ActionMode actionMode = androidTextContextMenuToolbarProvider.actionMode;
        if (actionMode != null) {
            TextToolbarHelper.INSTANCE.invalidateContentRect(actionMode);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidTextContextMenuToolbarProvider.android.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2", f = "AndroidTextContextMenuToolbarProvider.android.kt", i = {}, l = {ByteCode.INVOKEVIRTUAL}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TextContextMenuDataProvider $dataProvider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TextContextMenuDataProvider textContextMenuDataProvider, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$dataProvider = textContextMenuDataProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AndroidTextContextMenuToolbarProvider.this.new AnonymousClass2(this.$dataProvider, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Handler handler;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final TextContextMenuSessionImpl textContextMenuSessionImpl = new TextContextMenuSessionImpl();
                    final TextActionModeCallback textActionModeCallbackCreateActionModeCallback = AndroidTextContextMenuToolbarProvider.this.createActionModeCallback(textContextMenuSessionImpl, this.$dataProvider);
                    Looper looperMyLooper = Looper.myLooper();
                    Handler handler2 = AndroidTextContextMenuToolbarProvider.this.view.getHandler();
                    if (looperMyLooper != (handler2 != null ? handler2.getLooper() : null)) {
                        Runnable runnable = AndroidTextContextMenuToolbarProvider.this.startActionModeRunnable;
                        if (runnable == null) {
                            final AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = AndroidTextContextMenuToolbarProvider.this;
                            Runnable runnable2 = new Runnable() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AndroidTextContextMenuToolbarProvider.AnonymousClass2.invokeSuspend$lambda$0(androidTextContextMenuToolbarProvider, textActionModeCallbackCreateActionModeCallback, textContextMenuSessionImpl);
                                }
                            };
                            AndroidTextContextMenuToolbarProvider.this.startActionModeRunnable = runnable2;
                            runnable = runnable2;
                        }
                        Boxing.boxBoolean(AndroidTextContextMenuToolbarProvider.this.view.post(runnable));
                    } else {
                        AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider2 = AndroidTextContextMenuToolbarProvider.this;
                        ActionMode actionModeStartActionMode = TextToolbarHelper.INSTANCE.startActionMode(AndroidTextContextMenuToolbarProvider.this.view, textActionModeCallbackCreateActionModeCallback);
                        if (actionModeStartActionMode == null) {
                            return Unit.INSTANCE;
                        }
                        androidTextContextMenuToolbarProvider2.actionMode = actionModeStartActionMode;
                    }
                    this.label = 1;
                    if (textContextMenuSessionImpl.awaitClose(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (Looper.myLooper() != (handler != null ? handler.getLooper() : null)) {
                    Runnable runnable3 = AndroidTextContextMenuToolbarProvider.this.finishActionModeRunnable;
                    if (runnable3 == null) {
                        final AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider3 = AndroidTextContextMenuToolbarProvider.this;
                        Runnable runnable4 = new Runnable() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AndroidTextContextMenuToolbarProvider.AnonymousClass2.invokeSuspend$lambda$2(androidTextContextMenuToolbarProvider3);
                            }
                        };
                        AndroidTextContextMenuToolbarProvider.this.finishActionModeRunnable = runnable4;
                        runnable3 = runnable4;
                    }
                    Boxing.boxBoolean(AndroidTextContextMenuToolbarProvider.this.view.post(runnable3));
                } else {
                    ActionMode actionMode = AndroidTextContextMenuToolbarProvider.this.actionMode;
                    if (actionMode != null) {
                        actionMode.finish();
                    }
                }
                Runnable runnable5 = AndroidTextContextMenuToolbarProvider.this.startActionModeRunnable;
                if (runnable5 != null) {
                    Boxing.boxBoolean(AndroidTextContextMenuToolbarProvider.this.view.removeCallbacks(runnable5));
                }
                AndroidTextContextMenuToolbarProvider.this.actionMode = null;
                return Unit.INSTANCE;
            } finally {
                AndroidTextContextMenuToolbarProvider.this.snapshotStateObserver.clear();
                Looper looperMyLooper2 = Looper.myLooper();
                handler = AndroidTextContextMenuToolbarProvider.this.view.getHandler();
                if (looperMyLooper2 != (handler != null ? handler.getLooper() : null)) {
                    Runnable runnable6 = AndroidTextContextMenuToolbarProvider.this.finishActionModeRunnable;
                    if (runnable6 == null) {
                        final AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider4 = AndroidTextContextMenuToolbarProvider.this;
                        Runnable runnable7 = new Runnable() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$showTextContextMenu$2$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AndroidTextContextMenuToolbarProvider.AnonymousClass2.invokeSuspend$lambda$2(androidTextContextMenuToolbarProvider4);
                            }
                        };
                        AndroidTextContextMenuToolbarProvider.this.finishActionModeRunnable = runnable7;
                        runnable6 = runnable7;
                    }
                    Boxing.boxBoolean(AndroidTextContextMenuToolbarProvider.this.view.post(runnable6));
                } else {
                    ActionMode actionMode2 = AndroidTextContextMenuToolbarProvider.this.actionMode;
                    if (actionMode2 != null) {
                        actionMode2.finish();
                    }
                }
                Runnable runnable8 = AndroidTextContextMenuToolbarProvider.this.startActionModeRunnable;
                if (runnable8 != null) {
                    Boxing.boxBoolean(AndroidTextContextMenuToolbarProvider.this.view.removeCallbacks(runnable8));
                }
                AndroidTextContextMenuToolbarProvider.this.actionMode = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, TextActionModeCallback textActionModeCallback, TextContextMenuSessionImpl textContextMenuSessionImpl) {
            ActionMode actionModeStartActionMode = TextToolbarHelper.INSTANCE.startActionMode(androidTextContextMenuToolbarProvider.view, textActionModeCallback);
            Intrinsics.areEqual(androidTextContextMenuToolbarProvider.actionMode, actionModeStartActionMode);
            if (actionModeStartActionMode == null) {
                textContextMenuSessionImpl.close();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$2(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider) {
            ActionMode actionMode = androidTextContextMenuToolbarProvider.actionMode;
            if (actionMode != null) {
                actionMode.finish();
            }
        }
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider
    public Object showTextContextMenu(TextContextMenuDataProvider textContextMenuDataProvider, Continuation<? super Unit> continuation) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(textContextMenuDataProvider, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    public final void start() {
        this.snapshotStateObserver.start();
    }

    public final void dispose() {
        this.snapshotStateObserver.stop();
        this.snapshotStateObserver.clear();
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.actionMode = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextActionModeCallback createActionModeCallback(TextContextMenuSessionImpl session, final TextContextMenuDataProvider dataProvider) {
        TextActionModeCallback textActionModeCallbackInvoke;
        TextActionModeCallbackImpl textActionModeCallbackImpl = new TextActionModeCallbackImpl(session, new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.observeAndGetData(dataProvider);
            }
        }, new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.observeAndGetBounds(dataProvider);
            }
        }, this.view);
        Function1<TextActionModeCallback, TextActionModeCallback> function1 = this.callbackInjector;
        return (function1 == null || (textActionModeCallbackInvoke = function1.invoke(textActionModeCallbackImpl)) == null) ? textActionModeCallbackImpl : textActionModeCallbackInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextContextMenuData observeAndGetData(final TextContextMenuDataProvider dataProvider) {
        return (TextContextMenuData) observeReadsAndGet("dataBuilder", this.onDataChange, new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return dataProvider.data();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect observeAndGetBounds(final TextContextMenuDataProvider dataProvider) {
        return (Rect) observeReadsAndGet("positioner", this.onPositionChange, new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AndroidTextContextMenuToolbarProvider.observeAndGetBounds$lambda$0(this.f$0, dataProvider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect observeAndGetBounds$lambda$0(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, TextContextMenuDataProvider textContextMenuDataProvider) {
        LayoutCoordinates layoutCoordinatesInvoke = androidTextContextMenuToolbarProvider.coordinatesProvider.invoke();
        if (!layoutCoordinatesInvoke.isAttached()) {
            layoutCoordinatesInvoke = null;
        }
        LayoutCoordinates layoutCoordinates = layoutCoordinatesInvoke;
        if (layoutCoordinates == null) {
            return Rect.INSTANCE.getZero();
        }
        return textContextMenuDataProvider.contentBounds(layoutCoordinates).m5760translatek4lQ0M(LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
    }

    private final <T, S> T observeReadsAndGet(S scope, Function1<? super S, Unit> onValueChanged, final Function0<? extends T> block) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        this.snapshotStateObserver.observeReads(scope, onValueChanged, new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AndroidTextContextMenuToolbarProvider.observeReadsAndGet$lambda$0(objectRef, block);
            }
        });
        if (objectRef.element != null) {
            return objectRef.element;
        }
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return (T) Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public static final Unit observeReadsAndGet$lambda$0(Ref.ObjectRef objectRef, Function0 function0) {
        objectRef.element = function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AndroidTextContextMenuToolbarProvider.android.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider$TextActionModeCallbackImpl;", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", Session.ELEMENT, "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "dataBuilder", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "positioner", "Landroidx/compose/ui/geometry/Rect;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroid/view/View;)V", "previousData", "onGetContentRect", "mode", "Landroid/view/ActionMode;", "onCreateActionMode", "", Const.MENU, "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "updateMenuItems", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class TextActionModeCallbackImpl implements TextActionModeCallback {
        private final Function0<TextContextMenuData> dataBuilder;
        private Function0<Rect> positioner;
        private TextContextMenuData previousData;
        private final TextContextMenuSession session;
        private final View view;

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        public TextActionModeCallbackImpl(TextContextMenuSession textContextMenuSession, Function0<TextContextMenuData> function0, Function0<Rect> function02, View view) {
            this.session = textContextMenuSession;
            this.dataBuilder = function0;
            this.positioner = function02;
            this.view = view;
        }

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public Rect onGetContentRect(ActionMode mode, View view) {
            return this.positioner.invoke();
        }

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            updateMenuItems(menu);
            return menu.size() > 0;
        }

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return updateMenuItems(menu);
        }

        @Override // androidx.compose.foundation.text.contextmenu.internal.TextActionModeCallback
        public void onDestroyActionMode(ActionMode mode) {
            this.session.close();
        }

        private final boolean updateMenuItems(Menu menu) {
            int i;
            TextContextMenuData textContextMenuDataInvoke = this.dataBuilder.invoke();
            if (Intrinsics.areEqual(textContextMenuDataInvoke, this.previousData)) {
                return false;
            }
            menu.clear();
            List<TextContextMenuComponent> components = textContextMenuDataInvoke.getComponents();
            int size = components.size();
            int i2 = 1;
            int i3 = 1;
            for (int i4 = 0; i4 < size; i4++) {
                final TextContextMenuComponent textContextMenuComponent = components.get(i4);
                if (textContextMenuComponent instanceof TextContextMenuItem) {
                    int i5 = i2 + 1;
                    Object key = textContextMenuComponent.getKey();
                    if (Intrinsics.areEqual(key, TextContextMenuKeys.INSTANCE.getCutKey())) {
                        i = R.id.cut;
                    } else if (Intrinsics.areEqual(key, TextContextMenuKeys.INSTANCE.getCopyKey())) {
                        i = R.id.copy;
                    } else if (Intrinsics.areEqual(key, TextContextMenuKeys.INSTANCE.getPasteKey())) {
                        i = R.id.paste;
                    } else if (Intrinsics.areEqual(key, TextContextMenuKeys.INSTANCE.getSelectAllKey())) {
                        i = R.id.selectAll;
                    } else {
                        i = Intrinsics.areEqual(key, TextContextMenuKeys.INSTANCE.getAutofillKey()) ? R.id.autofill : i2;
                    }
                    MenuItem menuItemAdd = menu.add(i3, i, i2, ((TextContextMenuItem) textContextMenuComponent).getLabel());
                    menuItemAdd.setShowAsAction(2);
                    menuItemAdd.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider$TextActionModeCallbackImpl$$ExternalSyntheticLambda0
                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            return AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl.updateMenuItems$lambda$0$0(textContextMenuComponent, this, menuItem);
                        }
                    });
                    i2 = i5;
                } else if (textContextMenuComponent instanceof TextContextMenuTextClassificationItem) {
                    TextContextMenuTextClassificationItem textContextMenuTextClassificationItem = (TextContextMenuTextClassificationItem) textContextMenuComponent;
                    TextToolbarHelperApi28.INSTANCE.addMenuItem(menu, i2, this.view.getContext(), textContextMenuTextClassificationItem.getTextClassification(), textContextMenuTextClassificationItem.getIndex());
                    i2++;
                } else if (textContextMenuComponent instanceof TextContextMenuSeparator) {
                    i3++;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean updateMenuItems$lambda$0$0(TextContextMenuComponent textContextMenuComponent, TextActionModeCallbackImpl textActionModeCallbackImpl, MenuItem menuItem) {
            ((TextContextMenuItem) textContextMenuComponent).getOnClick().invoke(textActionModeCallbackImpl.session);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AndroidTextContextMenuToolbarProvider.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\b\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/AndroidTextContextMenuToolbarProvider$TextContextMenuSessionImpl;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "<init>", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "close", "awaitClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class TextContextMenuSessionImpl implements TextContextMenuSession {
        private final Channel<Unit> channel = ChannelKt.Channel$default(0, null, null, 7, null);

        @Override // androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession
        public void close() {
            this.channel.mo13895trySendJP2dKIU(Unit.INSTANCE);
        }

        public final Object awaitClose(Continuation<? super Unit> continuation) {
            Object objReceive = this.channel.receive(continuation);
            return objReceive == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objReceive : Unit.INSTANCE;
        }
    }
}
