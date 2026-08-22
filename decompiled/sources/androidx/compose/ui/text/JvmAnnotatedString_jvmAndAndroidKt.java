package androidx.compose.ui.text;

import androidx.collection.IntIntMapKt;
import androidx.collection.MutableIntIntMap;
import androidx.compose.ui.text.AnnotatedString;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: JvmAnnotatedString.jvmAndAndroid.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u001e\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a*\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¨\u0006\f"}, d2 = {"transform", "Landroidx/compose/ui/text/AnnotatedString;", "Lkotlin/Function3;", "", "", "collectRangeTransitions", "", "ranges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", TypedValues.AttributesType.S_TARGET, "Ljava/util/SortedSet;", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class JvmAnnotatedString_jvmAndAndroidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final AnnotatedString transform(final AnnotatedString annotatedString, final Function3<? super String, ? super Integer, ? super Integer, String> function3) {
        ArrayList arrayList;
        TreeSet treeSetSortedSetOf = SetsKt.sortedSetOf(0, Integer.valueOf(annotatedString.getText().length()));
        collectRangeTransitions(annotatedString.getAnnotations$ui_text(), treeSetSortedSetOf);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final MutableIntIntMap mutableIntIntMapMutableIntIntMapOf = IntIntMapKt.mutableIntIntMapOf();
        mutableIntIntMapMutableIntIntMapOf.set(0, 0);
        CollectionsKt.windowed$default(treeSetSortedSetOf, 2, 0, false, new Function1() { // from class: androidx.compose.ui.text.JvmAnnotatedString_jvmAndAndroidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JvmAnnotatedString_jvmAndAndroidKt.transform$lambda$0(objectRef, function3, annotatedString, mutableIntIntMapMutableIntIntMapOf, (List) obj);
            }
        }, 6, null);
        List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> annotations$ui_text = annotatedString.getAnnotations$ui_text();
        if (annotations$ui_text != null) {
            ArrayList arrayList2 = new ArrayList(annotations$ui_text.size());
            int size = annotations$ui_text.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<? extends AnnotatedString.Annotation> range = annotations$ui_text.get(i);
                arrayList2.add(new AnnotatedString.Range(range.getItem(), mutableIntIntMapMutableIntIntMapOf.get(range.getStart()), mutableIntIntMapMutableIntIntMapOf.get(range.getEnd())));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new AnnotatedString(arrayList, (String) objectRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.String] */
    public static final Unit transform$lambda$0(Ref.ObjectRef objectRef, Function3 function3, AnnotatedString annotatedString, MutableIntIntMap mutableIntIntMap, List list) {
        int iIntValue = ((Number) list.get(0)).intValue();
        int iIntValue2 = ((Number) list.get(1)).intValue();
        objectRef.element = ((String) objectRef.element) + ((String) function3.invoke(annotatedString.getText(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2)));
        mutableIntIntMap.put(iIntValue2, ((String) objectRef.element).length());
        return Unit.INSTANCE;
    }

    private static final void collectRangeTransitions(List<? extends AnnotatedString.Range<?>> list, SortedSet<Integer> sortedSet) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<?> range = list.get(i);
                sortedSet.add(Integer.valueOf(range.getStart()));
                sortedSet.add(Integer.valueOf(range.getEnd()));
            }
        }
    }
}
