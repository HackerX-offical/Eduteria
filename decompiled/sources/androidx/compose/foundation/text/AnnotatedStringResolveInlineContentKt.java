package androidx.compose.foundation.text;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: AnnotatedStringResolveInlineContent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a_\u0010\b\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u000b0\n\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001j\u0002`\f0\n0\t*\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\rH\u0000\u001a>\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2'\u0010\u0015\u001a#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001j\u0002`\f0\nH\u0001¢\u0006\u0002\u0010\u0016\"K\u0010\u0017\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u000b0\n\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001j\u0002`\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001*:\b\u0000\u0010\u0003\"\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u00012\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001¨\u0006\u0018"}, d2 = {"PlaceholderRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "InlineContentRange", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "resolveInlineContent", "Lkotlin/Pair;", "", "Landroidx/compose/foundation/text/PlaceholderRange;", "Landroidx/compose/foundation/text/InlineContentRange;", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "hasInlineContent", "", "InlineChildren", "text", "inlineContents", "(Landroidx/compose/ui/text/AnnotatedString;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "EmptyInlineContent", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AnnotatedStringResolveInlineContentKt {
    private static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> EmptyInlineContent = new Pair<>(CollectionsKt.emptyList(), CollectionsKt.emptyList());

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InlineChildren$lambda$1(AnnotatedString annotatedString, List list, int i, Composer composer, int i2) {
        InlineChildren(annotatedString, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent(AnnotatedString annotatedString, Map<String, InlineTextContent> map) {
        if (map == null || map.isEmpty()) {
            return EmptyInlineContent;
        }
        List<AnnotatedString.Range<String>> stringAnnotations = annotatedString.getStringAnnotations(InlineTextContentKt.INLINE_CONTENT_TAG, 0, annotatedString.getText().length());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = stringAnnotations.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<String> range = stringAnnotations.get(i);
            InlineTextContent inlineTextContent = map.get(range.getItem());
            if (inlineTextContent != null) {
                arrayList.add(new AnnotatedString.Range(inlineTextContent.getPlaceholder(), range.getStart(), range.getEnd()));
                arrayList2.add(new AnnotatedString.Range(inlineTextContent.getChildren(), range.getStart(), range.getEnd()));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final boolean hasInlineContent(AnnotatedString annotatedString) {
        return annotatedString.hasStringAnnotations(InlineTextContentKt.INLINE_CONTENT_TAG, 0, annotatedString.getText().length());
    }

    public static final void InlineChildren(final AnnotatedString annotatedString, final List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1794596951);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InlineChildren)N(text,inlineContents)*69@2714L269,69@2649L334:AnnotatedStringResolveInlineContent.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 32 : 16;
        }
        int i3 = 0;
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1794596951, i2, -1, "androidx.compose.foundation.text.InlineChildren (AnnotatedStringResolveInlineContent.kt:67)");
            }
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                AnnotatedString.Range<Function3<String, Composer, Integer, Unit>> range = list.get(i4);
                Function3<String, Composer, Integer, Unit> function3Component1 = range.component1();
                int start = range.getStart();
                int end = range.getEnd();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -557969248, "CC(remember):AnnotatedStringResolveInlineContent.kt#9igjgp");
                AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1 annotatedStringResolveInlineContentKt$InlineChildren$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (annotatedStringResolveInlineContentKt$InlineChildren$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    annotatedStringResolveInlineContentKt$InlineChildren$1$2$1RememberedValue = AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(annotatedStringResolveInlineContentKt$InlineChildren$1$2$1RememberedValue);
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) annotatedStringResolveInlineContentKt$InlineChildren$1$2$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                Modifier.Companion companion = Modifier.INSTANCE;
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i3));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i5 = i3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
                Updater.m5077setimpl(composerM5069constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5077setimpl(composerM5069constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5075reconcileimpl(composerM5069constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 374106383, "C69@2668L42:AnnotatedStringResolveInlineContent.kt#423gt5");
                function3Component1.invoke(annotatedString.subSequence(start, end).getText(), composerStartRestartGroup, Integer.valueOf(i5));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i4++;
                i3 = i5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AnnotatedStringResolveInlineContentKt.InlineChildren$lambda$1(annotatedString, list, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
