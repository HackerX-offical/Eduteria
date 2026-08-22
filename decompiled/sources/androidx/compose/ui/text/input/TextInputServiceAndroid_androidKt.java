package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import com.appnew.android.Utils.Const;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0000\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DEBUG_CLASS", "", "updateWithEmojiCompat", "", "Landroid/view/inputmethod/EditorInfo;", DiscoverItems.Item.UPDATE_ACTION, "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "hasFlag", "", "bits", "", Const.FLAG, "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        String privateImeOptions;
        int imeAction = imeOptions.getImeAction();
        int i = 6;
        if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8458getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8462getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8460getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8461getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8463getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8464getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8465getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m8445equalsimpl0(imeAction, ImeAction.INSTANCE.m8459getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        int keyboardType = imeOptions.getKeyboardType();
        if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8519getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8512getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8515getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8518getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8521getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8514getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8517getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8516getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m8498equalsimpl0(keyboardType, KeyboardType.INSTANCE.m8513getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m8445equalsimpl0(imeOptions.getImeAction(), ImeAction.INSTANCE.m8458getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int capitalization = imeOptions.getCapitalization();
            if (KeyboardCapitalization.m8481equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m8490getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m8481equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m8494getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m8481equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m8492getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m8273getStartimpl(textFieldValue.getSelection());
        editorInfo.initialSelEnd = TextRange.m8268getEndimpl(textFieldValue.getSelection());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= GroupFlagsKt.HasAuxSlotFlag;
    }

    public static final Executor asExecutor(final Choreographer choreographer) {
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$0(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$0(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }
}
