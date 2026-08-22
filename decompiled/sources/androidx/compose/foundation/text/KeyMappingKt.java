package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyMapping.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"commonKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "systemShortcutModifiers", "Landroidx/compose/foundation/text/KeyModifiers;", "commonKeyMapping-VSD1kLU", "(I)Landroidx/compose/foundation/text/KeyMapping;", "defaultKeyMapping", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    /* JADX INFO: renamed from: commonKeyMapping-VSD1kLU, reason: not valid java name */
    public static final KeyMapping m1718commonKeyMappingVSD1kLU(final int i) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo1717mapZmokQxo(KeyEvent event) {
                int iM1762getModifiersZmokQxo = KeyModifiersKt.m1762getModifiersZmokQxo(event);
                if (KeyModifiers.m1724equalsimpl0(iM1762getModifiersZmokQxo, KeyModifiers.m1737plus1uj4btU(i, KeyModifiers.INSTANCE.m1760getShiftAuQ4EfA()))) {
                    if (Key.m6824equalsimpl0(KeyEvent_androidKt.m7144getKeyZmokQxo(event), Key.INSTANCE.m7122getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (KeyModifiers.m1724equalsimpl0(iM1762getModifiersZmokQxo, i)) {
                    long jM7144getKeyZmokQxo = KeyEvent_androidKt.m7144getKeyZmokQxo(event);
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6879getCEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6943getInsertEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7010getNumPadInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7111getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7119getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6829getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7120getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7122getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyModifiers.m1724equalsimpl0(iM1762getModifiersZmokQxo, KeyModifiers.INSTANCE.m1760getShiftAuQ4EfA())) {
                    long jM7144getKeyZmokQxo2 = KeyEvent_androidKt.m7144getKeyZmokQxo(event);
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6901getDirectionLeftEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7003getNumPadDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6902getDirectionRightEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7004getNumPadDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6903getDirectionUpEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7005getNumPadDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6898getDirectionDownEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7002getNumPadDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7024getPageUpEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7016getNumPadPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7023getPageDownEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7015getNumPadPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6977getMoveHomeEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7013getNumPadMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6976getMoveEndEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7012getNumPadMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6943getInsertEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7010getNumPadInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                if (!KeyModifiers.m1724equalsimpl0(iM1762getModifiersZmokQxo, KeyModifiers.INSTANCE.m1759getNoneAuQ4EfA())) {
                    return null;
                }
                long jM7144getKeyZmokQxo3 = KeyEvent_androidKt.m7144getKeyZmokQxo(event);
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6901getDirectionLeftEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7003getNumPadDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6902getDirectionRightEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7004getNumPadDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6903getDirectionUpEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7005getNumPadDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6898getDirectionDownEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7002getNumPadDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6897getDirectionCenterEK5gGoQ())) {
                    return KeyCommand.CENTER;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7024getPageUpEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7016getNumPadPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7023getPageDownEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7015getNumPadPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6977getMoveHomeEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7013getNumPadMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6976getMoveEndEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7012getNumPadMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6911getEnterEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7008getNumPadEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6842getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6896getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7026getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6894getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m6891getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo3, Key.INSTANCE.m7072getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping keyMappingM1718commonKeyMappingVSD1kLU = m1718commonKeyMappingVSD1kLU(KeyModifiers.INSTANCE.m1754getCtrlAuQ4EfA());
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1$1
            /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public androidx.compose.foundation.text.KeyCommand mo1717mapZmokQxo(android.view.KeyEvent r8) {
                /*
                    Method dump skipped, instruction units count: 592
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1$1.mo1717mapZmokQxo(android.view.KeyEvent):androidx.compose.foundation.text.KeyCommand");
            }
        };
    }
}
