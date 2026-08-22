package androidx.compose.foundation.text.contextmenu.internal;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.view.textclassifier.TextClassification;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: DefaultTextContextMenuDropdownProvider.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/TextContextMenuHelperApi28;", "", "<init>", "()V", "textClassificationItem", "", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "context", "Landroid/content/Context;", "component", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuTextClassificationItem;", "IconBox", "icon", "Landroid/graphics/drawable/Icon;", "(Landroid/graphics/drawable/Icon;Landroidx/compose/runtime/Composer;I)V", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class TextContextMenuHelperApi28 {
    public static final TextContextMenuHelperApi28 INSTANCE = new TextContextMenuHelperApi28();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconBox$lambda$1(TextContextMenuHelperApi28 textContextMenuHelperApi28, Icon icon, int i, Composer composer, int i2) {
        textContextMenuHelperApi28.IconBox(icon, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconBox$lambda$2(TextContextMenuHelperApi28 textContextMenuHelperApi28, Icon icon, int i, Composer composer, int i2) {
        textContextMenuHelperApi28.IconBox(icon, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconBox$lambda$4(TextContextMenuHelperApi28 textContextMenuHelperApi28, Drawable drawable, int i, Composer composer, int i2) {
        textContextMenuHelperApi28.IconBox(drawable, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private TextContextMenuHelperApi28() {
    }

    public final void textClassificationItem(ContextMenuScope contextMenuScope, final Context context, TextContextMenuTextClassificationItem textContextMenuTextClassificationItem) {
        if (context == null) {
            return;
        }
        int index = textContextMenuTextClassificationItem.getIndex();
        final TextClassification textClassification = textContextMenuTextClassificationItem.getTextClassification();
        if (index < 0) {
            Function2 function2 = new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextContextMenuHelperApi28.textClassificationItem$lambda$0(textClassification, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            final Drawable icon = textClassification.getIcon();
            ContextMenuScope.item$default(contextMenuScope, function2, null, false, icon != null ? ComposableLambdaKt.composableLambdaInstance(-1123224187, true, new Function3<Color, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$textClassificationItem$2$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Color color, Composer composer, Integer num) {
                    m1900invokeek8zF_U(color.m5978unboximpl(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                public final void m1900invokeek8zF_U(long j, Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "CN(color:c#ui.graphics.Color)247@9913L13:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
                    if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1123224187, i, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.textClassificationItem.<anonymous>.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:247)");
                    }
                    TextContextMenuHelperApi28.INSTANCE.IconBox(icon, composer, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }) : null, new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextContextMenuHelperApi28.textClassificationItem$lambda$2(context, textClassification);
                }
            }, 6, null);
        } else {
            final RemoteAction remoteAction = textClassification.getActions().get(index);
            ContextMenuScope.item$default(contextMenuScope, new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextContextMenuHelperApi28.textClassificationItem$lambda$3(remoteAction, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, null, false, ((index == 0) || remoteAction.shouldShowIcon()) ? ComposableLambdaKt.composableLambdaInstance(-1261173016, true, new Function3<Color, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.textClassificationItem.5
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Color color, Composer composer, Integer num) {
                    m1901invokeek8zF_U(color.m5978unboximpl(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                public final void m1901invokeek8zF_U(long j, Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "CN(it:c#ui.graphics.Color)257@10329L20:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
                    if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1261173016, i, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.textClassificationItem.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:257)");
                    }
                    TextContextMenuHelperApi28.INSTANCE.IconBox(remoteAction.getIcon(), composer, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }) : null, new Function0() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextContextMenuHelperApi28.textClassificationItem$lambda$4(remoteAction);
                }
            }, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String textClassificationItem$lambda$0(TextClassification textClassification, Composer composer, int i) {
        composer.startReplaceGroup(950061013);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(950061013, i, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.textClassificationItem.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:246)");
        }
        String strValueOf = String.valueOf(textClassification.getLabel());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return strValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textClassificationItem$lambda$2(Context context, TextClassification textClassification) throws PendingIntent.CanceledException {
        TextClassificationHelperApi28.INSTANCE.sendLegacyIntent(context, textClassification);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String textClassificationItem$lambda$3(RemoteAction remoteAction, Composer composer, int i) {
        composer.startReplaceGroup(-1376593684);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1376593684, i, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.textClassificationItem.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:254)");
        }
        String string = remoteAction.getTitle().toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textClassificationItem$lambda$4(RemoteAction remoteAction) throws PendingIntent.CanceledException {
        TextClassificationHelperApi28.INSTANCE.sendPendingIntent(remoteAction.getActionIntent());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void IconBox(final Icon icon, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2116504409);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconBox)N(icon)268@10623L7,269@10654L54,270@10727L17:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(icon) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2116504409, i2, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.IconBox (DefaultTextContextMenuDropdownProvider.android.kt:267)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1853758257, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(icon) | composerStartRestartGroup.changed(context);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = icon.loadDrawable(context);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Drawable drawable = (Drawable) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (drawable != null) {
                IconBox(drawable, composerStartRestartGroup, i2 & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    function2 = new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextContextMenuHelperApi28.IconBox$lambda$1(this.f$0, icon, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeEndRestartGroup.updateScope(function2);
                }
                return;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextContextMenuHelperApi28.IconBox$lambda$2(this.f$0, icon, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void IconBox(final Drawable drawable, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(257732500);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconBox)N(drawable)276@10890L217,275@10822L295:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(drawable) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(257732500, i2, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.IconBox (DefaultTextContextMenuDropdownProvider.android.kt:274)");
            }
            Modifier modifierM1221size3ABfNKs = SizeKt.m1221size3ABfNKs(Modifier.INSTANCE, ContextMenuSpec.INSTANCE.m458getIconSizeD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1427166931, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(drawable);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextContextMenuHelperApi28.IconBox$lambda$3$0(drawable, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxKt.Box(DrawModifierKt.drawBehind(modifierM1221size3ABfNKs, (Function1) objRememberedValue), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextContextMenuHelperApi28.IconBox$lambda$4(this.f$0, drawable, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconBox$lambda$3$0(Drawable drawable, DrawScope drawScope) {
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        drawable.setBounds(0, 0, (int) Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32)), (int) Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L)));
        drawable.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        return Unit.INSTANCE;
    }
}
