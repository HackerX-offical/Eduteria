package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.style.StyleModifierKt;
import androidx.compose.foundation.style.StyleOuterNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;

/* JADX INFO: compiled from: TextStyleProviderNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"inheritedTextStyle", "Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/ui/node/DelegatableNode;", TypedValues.CycleType.S_WAVE_PHASE, "Landroidx/compose/foundation/text/modifiers/StylePhase;", FallbackIndicationElement.ELEMENT, "inheritedTextStyle-Bh5OqGs", "(Landroidx/compose/ui/node/DelegatableNode;ILandroidx/compose/ui/text/TextStyle;)Landroidx/compose/ui/text/TextStyle;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextStyleProviderNodeKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: inheritedTextStyle-Bh5OqGs, reason: not valid java name */
    public static final TextStyle m2269inheritedTextStyleBh5OqGs(DelegatableNode delegatableNode, final int i, final TextStyle textStyle) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = textStyle;
        TraversableNodeKt.traverseAncestors(delegatableNode, StyleModifierKt.OuterNodeKey, new Function1() { // from class: androidx.compose.foundation.text.modifiers.TextStyleProviderNodeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TextStyleProviderNodeKt.inheritedTextStyle_Bh5OqGs$lambda$0(objectRef, i, textStyle, (TraversableNode) obj));
            }
        });
        return (TextStyle) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.compose.ui.text.TextStyle] */
    public static final boolean inheritedTextStyle_Bh5OqGs$lambda$0(Ref.ObjectRef objectRef, int i, TextStyle textStyle, TraversableNode traversableNode) {
        if (!(traversableNode instanceof StyleOuterNode)) {
            return true;
        }
        objectRef.element = ((StyleOuterNode) traversableNode).mo1626computeInheritedTextStyleBLjeIk(i, textStyle);
        return false;
    }
}
