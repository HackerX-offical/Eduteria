package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyModifiers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"modifiers", "Landroidx/compose/foundation/text/KeyModifiers;", "Landroidx/compose/ui/input/key/KeyEvent;", "getModifiers-ZmokQxo", "(Landroid/view/KeyEvent;)I", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KeyModifiersKt {
    /* JADX INFO: renamed from: getModifiers-ZmokQxo, reason: not valid java name */
    public static final int m1762getModifiersZmokQxo(KeyEvent keyEvent) {
        return KeyModifiers.m1721constructorimpl(KeyEvent_androidKt.m7147isAltPressedZmokQxo(keyEvent), KeyEvent_androidKt.m7148isCtrlPressedZmokQxo(keyEvent), KeyEvent_androidKt.m7149isMetaPressedZmokQxo(keyEvent), KeyEvent_androidKt.m7150isShiftPressedZmokQxo(keyEvent));
    }
}
