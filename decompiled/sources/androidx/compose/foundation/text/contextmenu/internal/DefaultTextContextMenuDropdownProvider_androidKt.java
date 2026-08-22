package androidx.compose.foundation.text.contextmenu.internal;

import android.content.Context;
import androidx.compose.foundation.contextmenu.ContextMenuPopupPositionProvider;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smack.packet.Session;

/* JADX INFO: compiled from: DefaultTextContextMenuDropdownProvider.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000b\u001a+\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010\u0019\u001a!\u0010\u001a\u001a\u00020\u00012\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0003¢\u0006\u0004\b\u001f\u0010 \"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"ProvideDefaultTextContextMenuDropdown", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "defaultTextContextMenuDropdown", "Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "OpenContextMenu", Session.ELEMENT, "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "dataProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DefaultTextContextMenuDropdown", "data", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;Landroidx/compose/runtime/Composer;I)V", "IconBox", "resId", "", "tint", "Landroidx/compose/ui/graphics/Color;", "IconBox-RPmYEkk", "(IJLandroidx/compose/runtime/Composer;I)V", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DefaultTextContextMenuDropdownProvider_androidKt {
    private static final PopupProperties DefaultPopupProperties = new PopupProperties(true, false, false, false, false, 30, (DefaultConstructorMarker) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultTextContextMenuDropdown$lambda$1(TextContextMenuSession textContextMenuSession, TextContextMenuData textContextMenuData, int i, Composer composer, int i2) {
        DefaultTextContextMenuDropdown(textContextMenuSession, textContextMenuData, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconBox_RPmYEkk$lambda$1(int i, long j, int i2, Composer composer, int i3) {
        m1886IconBoxRPmYEkk(i, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconBox_RPmYEkk$lambda$3(int i, long j, int i2, Composer composer, int i3) {
        m1886IconBoxRPmYEkk(i, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OpenContextMenu$lambda$3(TextContextMenuSession textContextMenuSession, TextContextMenuDataProvider textContextMenuDataProvider, Function0 function0, int i, Composer composer, int i2) {
        OpenContextMenu(textContextMenuSession, textContextMenuDataProvider, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideDefaultTextContextMenuDropdown$lambda$0(Function2 function2, int i, Composer composer, int i2) {
        ProvideDefaultTextContextMenuDropdown(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideDefaultTextContextMenuDropdown$lambda$1(Modifier modifier, Function2 function2, int i, Composer composer, int i2) {
        ProvideDefaultTextContextMenuDropdown(modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ProvideDefaultTextContextMenuDropdown(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(422095256);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideDefaultTextContextMenuDropdown)N(content)72@3752L297:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(422095256, i2, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideDefaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:71)");
            }
            BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu(TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider(), ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE.getLambda$129995601$foundation(), function2, composerStartRestartGroup, ((i2 << 6) & 896) | 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown$lambda$0(function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ProvideDefaultTextContextMenuDropdown(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composerStartRestartGroup = composer.startRestartGroup(1392105195);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideDefaultTextContextMenuDropdown)N(modifier,content)86@4186L326:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            modifier2 = modifier;
            function22 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1392105195, i2, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideDefaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:85)");
            }
            modifier2 = modifier;
            function22 = function2;
            BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu(modifier2, TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider(), ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE.getLambda$636288403$foundation(), function22, composerStartRestartGroup, (i2 & 14) | 432 | ((i2 << 6) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown$lambda$1(modifier2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final BasicTextContextMenuProvider defaultTextContextMenuDropdown(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1197778906, "C(defaultTextContextMenuDropdown)98@4610L158:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1197778906, i, -1, "androidx.compose.foundation.text.contextmenu.internal.defaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:98)");
        }
        BasicTextContextMenuProvider basicTextContextMenuProvider = BasicTextContextMenuProviderKt.basicTextContextMenuProvider(ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE.m1880getLambda$1357803046$foundation(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return basicTextContextMenuProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OpenContextMenu(final TextContextMenuSession textContextMenuSession, final TextContextMenuDataProvider textContextMenuDataProvider, final Function0<? extends LayoutCoordinates> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2040393164);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OpenContextMenu)N(session,dataProvider,anchorLayoutCoordinates)111@5065L252,121@5412L19,123@5484L143,119@5323L304:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(textContextMenuSession) : composerStartRestartGroup.changedInstance(textContextMenuSession) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(textContextMenuDataProvider) : composerStartRestartGroup.changedInstance(textContextMenuDataProvider) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        boolean z = false;
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2040393164, i2, -1, "androidx.compose.foundation.text.contextmenu.internal.OpenContextMenu (DefaultTextContextMenuDropdownProvider.android.kt:109)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1982230416, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            boolean z2 = (i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changed(textContextMenuDataProvider));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MaintainWindowPositionPopupPositionProvider(new ContextMenuPopupPositionProvider(new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu$lambda$0$0(textContextMenuDataProvider, function0);
                    }
                }, (Function2) null, 2, (DefaultConstructorMarker) null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            MaintainWindowPositionPopupPositionProvider maintainWindowPositionPopupPositionProvider = (MaintainWindowPositionPopupPositionProvider) objRememberedValue;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1982241287, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(textContextMenuSession))) {
                z = true;
            }
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu$lambda$1$0(textContextMenuSession);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidPopup_androidKt.Popup(maintainWindowPositionPopupPositionProvider, (Function0) objRememberedValue2, DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(1315155414, true, new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu$lambda$2(textContextMenuDataProvider, textContextMenuSession, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu$lambda$3(textContextMenuSession, textContextMenuDataProvider, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset OpenContextMenu$lambda$0$0(TextContextMenuDataProvider textContextMenuDataProvider, Function0 function0) {
        return IntOffset.m8949boximpl(IntOffsetKt.m8975roundk4lQ0M(textContextMenuDataProvider.mo1906positiontuRUvjQ((LayoutCoordinates) function0.invoke())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OpenContextMenu$lambda$1$0(TextContextMenuSession textContextMenuSession) {
        textContextMenuSession.close();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OpenContextMenu$lambda$2(TextContextMenuDataProvider textContextMenuDataProvider, TextContextMenuSession textContextMenuSession, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C124@5506L61,125@5576L45:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1315155414, i, -1, "androidx.compose.foundation.text.contextmenu.internal.OpenContextMenu.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:124)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1143968595, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            boolean zChanged = composer.changed(textContextMenuDataProvider);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new DefaultTextContextMenuDropdownProvider_androidKt$OpenContextMenu$2$data$2$1(textContextMenuDataProvider));
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DefaultTextContextMenuDropdown(textContextMenuSession, OpenContextMenu$lambda$2$1((State) objRememberedValue), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void DefaultTextContextMenuDropdown(final TextContextMenuSession textContextMenuSession, final TextContextMenuData textContextMenuData, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1904307118);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DefaultTextContextMenuDropdown)N(session,data)140@5937L900,140@5912L925:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(textContextMenuSession) : composerStartRestartGroup.changedInstance(textContextMenuSession) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(textContextMenuData) ? 32 : 16;
        }
        boolean z = false;
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1904307118, i2, -1, "androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:133)");
            }
            composerStartRestartGroup.startReplaceGroup(-1009482584);
            ComposerKt.sourceInformation(composerStartRestartGroup, "136@5856L7");
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 383082354, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(textContextMenuData);
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(textContextMenuSession))) {
                z = true;
            }
            boolean zChangedInstance2 = zChangedInstance | z | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown$lambda$0$0(textContextMenuData, context, textContextMenuSession, (ContextMenuScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ContextMenuUiKt.ContextMenuColumnBuilder(null, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown$lambda$1(textContextMenuSession, textContextMenuData, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultTextContextMenuDropdown$lambda$0$0(TextContextMenuData textContextMenuData, Context context, final TextContextMenuSession textContextMenuSession, ContextMenuScope contextMenuScope) {
        ContextMenuScope contextMenuScope2;
        List<TextContextMenuComponent> components = textContextMenuData.getComponents();
        int size = components.size();
        int i = 0;
        while (i < size) {
            final TextContextMenuComponent textContextMenuComponent = components.get(i);
            if (textContextMenuComponent instanceof TextContextMenuItem) {
                contextMenuScope2 = contextMenuScope;
                ContextMenuScope.item$default(contextMenuScope2, new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown$lambda$0$0$0$0(textContextMenuComponent, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, null, false, ((TextContextMenuItem) textContextMenuComponent).getLeadingIcon() == 0 ? null : ComposableLambdaKt.composableLambdaInstance(-1930700965, true, new Function3<Color, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$DefaultTextContextMenuDropdown$1$1$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Color color, Composer composer, Integer num) {
                        m1888invokeek8zF_U(color.m5978unboximpl(), composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                    public final void m1888invokeek8zF_U(long j, Composer composer, int i2) {
                        ComposerKt.sourceInformation(composer, "CN(color:c#ui.graphics.Color)150@6375L37:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
                        if ((i2 & 6) == 0) {
                            i2 |= composer.changed(j) ? 4 : 2;
                        }
                        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1930700965, i2, -1, "androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdown.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:150)");
                        }
                        DefaultTextContextMenuDropdownProvider_androidKt.m1886IconBoxRPmYEkk(((TextContextMenuItem) textContextMenuComponent).getLeadingIcon(), j, composer, (i2 << 3) & 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown$lambda$0$0$0$1(textContextMenuComponent, textContextMenuSession);
                    }
                }, 6, null);
            } else {
                contextMenuScope2 = contextMenuScope;
                if (textContextMenuComponent instanceof TextContextMenuTextClassificationItem) {
                    TextContextMenuHelperApi28.INSTANCE.textClassificationItem(contextMenuScope2, context, (TextContextMenuTextClassificationItem) textContextMenuComponent);
                } else if (textContextMenuComponent instanceof TextContextMenuSeparator) {
                    contextMenuScope2.separator();
                }
            }
            i++;
            contextMenuScope = contextMenuScope2;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DefaultTextContextMenuDropdown$lambda$0$0$0$0(TextContextMenuComponent textContextMenuComponent, Composer composer, int i) {
        composer.startReplaceGroup(666084174);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(666084174, i, -1, "androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdown.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:145)");
        }
        String label = ((TextContextMenuItem) textContextMenuComponent).getLabel();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DefaultTextContextMenuDropdown$lambda$0$0$0$1(TextContextMenuComponent textContextMenuComponent, TextContextMenuSession textContextMenuSession) {
        ((TextContextMenuItem) textContextMenuComponent).getOnClick().invoke(textContextMenuSession);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: IconBox-RPmYEkk, reason: not valid java name */
    public static final void m1886IconBoxRPmYEkk(final int i, final long j, Composer composer, final int i2) {
        int i3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1240244237);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconBox)N(resId,tint:c#ui.graphics.Color)167@6979L7,169@7024L182,176@7267L35,177@7325L75,178@7405L146:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1240244237, i3, -1, "androidx.compose.foundation.text.contextmenu.internal.IconBox (DefaultTextContextMenuDropdownProvider.android.kt:166)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2126200809, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            boolean zChanged = ((i3 & 14) == 4) | composerStartRestartGroup.changed(context);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = Integer.valueOf(context.obtainStyledAttributes(new int[]{i}).getResourceId(0, -1));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            int iIntValue = ((Number) objRememberedValue).intValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (iIntValue == -1) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    function2 = new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DefaultTextContextMenuDropdownProvider_androidKt.IconBox_RPmYEkk$lambda$1(i, j, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeEndRestartGroup.updateScope(function2);
                }
                return;
            }
            Painter painterPainterResource = PainterResources_androidKt.painterResource(iIntValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2126210334, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            boolean z = (i3 & 112) == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = j == 16 ? null : ColorFilter.Companion.m6009tintxETnrds$default(ColorFilter.INSTANCE, j, 0, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxKt.Box(PainterModifierKt.paint$default(SizeKt.m1221size3ABfNKs(Modifier.INSTANCE, ContextMenuSpec.INSTANCE.m458getIconSizeD9Ej5fM()), painterPainterResource, false, null, ContentScale.INSTANCE.getFit(), 0.0f, (ColorFilter) objRememberedValue2, 22, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultTextContextMenuDropdownProvider_androidKt.IconBox_RPmYEkk$lambda$3(i, j, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final TextContextMenuData OpenContextMenu$lambda$2$1(State<TextContextMenuData> state) {
        return state.getValue();
    }
}
