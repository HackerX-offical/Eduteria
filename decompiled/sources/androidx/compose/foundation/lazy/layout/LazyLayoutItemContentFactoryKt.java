package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LazyLayoutItemContentFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"SkippableItem", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "saveableStateHolder", "Landroidx/compose/foundation/lazy/layout/StableValue;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", FirebaseAnalytics.Param.INDEX, "", "key", "", "SkippableItem-JVlU9Rs", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Ljava/lang/Object;ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyLayoutItemContentFactoryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkippableItem_JVlU9Rs$lambda$1(LazyLayoutItemProvider lazyLayoutItemProvider, Object obj, int i, Object obj2, int i2, Composer composer, int i3) {
        m1376SkippableItemJVlU9Rs(lazyLayoutItemProvider, obj, i, obj2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SkippableItem-JVlU9Rs, reason: not valid java name */
    public static final void m1376SkippableItemJVlU9Rs(final LazyLayoutItemProvider lazyLayoutItemProvider, final Object obj, final int i, final Object obj2, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1439843069);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SkippableItem)N(itemProvider,saveableStateHolder:c#foundation.lazy.layout.StableValue,index,key:c#foundation.lazy.layout.StableValue)125@4709L51,125@4676L84:LazyLayoutItemContentFactory.kt#wow0x6");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(lazyLayoutItemProvider) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(obj) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(obj2) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1439843069, i3, -1, "androidx.compose.foundation.lazy.layout.SkippableItem (LazyLayoutItemContentFactory.kt:124)");
            }
            ((SaveableStateHolder) obj).SaveableStateProvider(obj2, ComposableLambdaKt.rememberComposableLambda(980966366, true, new Function2() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactoryKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return LazyLayoutItemContentFactoryKt.SkippableItem_JVlU9Rs$lambda$0(lazyLayoutItemProvider, i, obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactoryKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return LazyLayoutItemContentFactoryKt.SkippableItem_JVlU9Rs$lambda$1(lazyLayoutItemProvider, obj, i, obj2, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkippableItem_JVlU9Rs$lambda$0(LazyLayoutItemProvider lazyLayoutItemProvider, int i, Object obj, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C126@4732L22:LazyLayoutItemContentFactory.kt#wow0x6");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(980966366, i2, -1, "androidx.compose.foundation.lazy.layout.SkippableItem.<anonymous> (LazyLayoutItemContentFactory.kt:126)");
            }
            lazyLayoutItemProvider.Item(i, obj, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
