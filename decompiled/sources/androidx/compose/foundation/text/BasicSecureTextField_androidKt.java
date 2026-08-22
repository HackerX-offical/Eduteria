package androidx.compose.foundation.text;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BasicSecureTextField.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\b\u0010\u0010\u001a\u00020\u0011H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"0\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"TAG", "", "platformAllowsRevealLastTyped", "", "(Landroidx/compose/runtime/Composer;I)Z", "DefaultContentResolverForSecureTextField", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroidx/compose/foundation/text/ContentResolverForSecureTextField;", "contentResolverForSecureTextField", "getContentResolverForSecureTextField$annotations", "()V", "getContentResolverForSecureTextField", "()Lkotlin/jvm/functions/Function1;", "setContentResolverForSecureTextField", "(Lkotlin/jvm/functions/Function1;)V", "resetContentResolverForSecureTextField", "", "foundation", "state"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BasicSecureTextField_androidKt {
    private static final Function1<Context, ContentResolverForSecureTextField> DefaultContentResolverForSecureTextField;
    private static final String TAG = "BasicSecureTextField";
    private static Function1<? super Context, ? extends ContentResolverForSecureTextField> contentResolverForSecureTextField;

    public static /* synthetic */ void getContentResolverForSecureTextField$annotations() {
    }

    public static final boolean platformAllowsRevealLastTyped(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1015272320, "C(platformAllowsRevealLastTyped)39@1443L7,41@1478L119,44@1615L60,46@1711L263,53@2024L242,53@1979L287:BasicSecureTextField.android.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1015272320, i, -1, "androidx.compose.foundation.text.platformAllowsRevealLastTyped (BasicSecureTextField.android.kt:38)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object obj = (Context) objConsume;
        Object obj2 = contentResolverForSecureTextField;
        ComposerKt.sourceInformationMarkerStart(composer, -719119593, "CC(remember):BasicSecureTextField.android.kt#9igjgp");
        boolean zChanged = composer.changed(obj2) | composer.changed(obj);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (ContentResolverForSecureTextField) contentResolverForSecureTextField.invoke(obj);
            composer.updateRememberedValue(objRememberedValue);
        }
        final ContentResolverForSecureTextField contentResolverForSecureTextField2 = (ContentResolverForSecureTextField) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -719115268, "CC(remember):BasicSecureTextField.android.kt#9igjgp");
        boolean zChanged2 = composer.changed(contentResolverForSecureTextField2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(contentResolverForSecureTextField2.getShowPassword()), null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        final MutableState mutableState = (MutableState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -719111993, "CC(remember):BasicSecureTextField.android.kt#9igjgp");
        boolean zChanged3 = composer.changed(contentResolverForSecureTextField2);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            final Handler handlerCreateAsync = HandlerCompat.createAsync(Looper.getMainLooper());
            objRememberedValue3 = new ContentObserver(handlerCreateAsync) { // from class: androidx.compose.foundation.text.BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1
                @Override // android.database.ContentObserver
                public void onChange(boolean selfChange) {
                    BasicSecureTextField_androidKt.platformAllowsRevealLastTyped$lambda$3(mutableState, contentResolverForSecureTextField2.getShowPassword());
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        final BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1 basicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1 = (BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -719101998, "CC(remember):BasicSecureTextField.android.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(contentResolverForSecureTextField2) | composer.changedInstance(basicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.BasicSecureTextField_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return BasicSecureTextField_androidKt.platformAllowsRevealLastTyped$lambda$5$0(contentResolverForSecureTextField2, basicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1, (DisposableEffectScope) obj3);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(contentResolverForSecureTextField2, basicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1, (Function1) objRememberedValue4, composer, 0);
        boolean zPlatformAllowsRevealLastTyped$lambda$2 = platformAllowsRevealLastTyped$lambda$2(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zPlatformAllowsRevealLastTyped$lambda$2;
    }

    private static final boolean platformAllowsRevealLastTyped$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void platformAllowsRevealLastTyped$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult platformAllowsRevealLastTyped$lambda$5$0(final ContentResolverForSecureTextField contentResolverForSecureTextField2, final BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1 basicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1, DisposableEffectScope disposableEffectScope) {
        contentResolverForSecureTextField2.registerContentObserver(Settings.System.getUriFor("show_password"), false, basicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1);
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$lambda$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                contentResolverForSecureTextField2.unregisterContentObserver(basicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1);
            }
        };
    }

    static {
        Function1<Context, ContentResolverForSecureTextField> function1 = new Function1() { // from class: androidx.compose.foundation.text.BasicSecureTextField_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BasicSecureTextField_androidKt.DefaultContentResolverForSecureTextField$lambda$0((Context) obj);
            }
        };
        DefaultContentResolverForSecureTextField = function1;
        contentResolverForSecureTextField = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.text.BasicSecureTextField_androidKt$DefaultContentResolverForSecureTextField$1$1] */
    public static final BasicSecureTextField_androidKt$DefaultContentResolverForSecureTextField$1$1 DefaultContentResolverForSecureTextField$lambda$0(Context context) {
        final ContentResolver contentResolver = context.getContentResolver();
        return new ContentResolverForSecureTextField() { // from class: androidx.compose.foundation.text.BasicSecureTextField_androidKt$DefaultContentResolverForSecureTextField$1$1
            @Override // androidx.compose.foundation.text.ContentResolverForSecureTextField
            public void registerContentObserver(Uri uri, boolean notifyForDescendants, ContentObserver observer) {
                contentResolver.registerContentObserver(uri, notifyForDescendants, observer);
            }

            @Override // androidx.compose.foundation.text.ContentResolverForSecureTextField
            public void unregisterContentObserver(ContentObserver observer) {
                contentResolver.unregisterContentObserver(observer);
            }

            @Override // androidx.compose.foundation.text.ContentResolverForSecureTextField
            public boolean getShowPassword() {
                try {
                    return Settings.System.getInt(contentResolver, "show_password") > 0;
                } catch (Exception e2) {
                    Log.w("BasicSecureTextField", "Failed to fetch show password setting, using value: true", e2);
                    return true;
                }
            }
        };
    }

    public static final Function1<Context, ContentResolverForSecureTextField> getContentResolverForSecureTextField() {
        return contentResolverForSecureTextField;
    }

    public static final void setContentResolverForSecureTextField(Function1<? super Context, ? extends ContentResolverForSecureTextField> function1) {
        contentResolverForSecureTextField = function1;
    }

    public static final void resetContentResolverForSecureTextField() {
        contentResolverForSecureTextField = DefaultContentResolverForSecureTextField;
    }
}
