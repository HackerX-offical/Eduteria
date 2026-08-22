package androidx.compose.ui.adaptive;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.input.InputManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.UiMediaScope;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;

/* JADX INFO: compiled from: MediaQuery.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00178F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u001e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR+\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0016\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010(\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0016\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R+\u0010+\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0016\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R\u0014\u0010/\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010$R\u0014\u00101\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010$R\u0014\u00103\u001a\u0002048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u0002048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u001aR\u0014\u0010;\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u001aR\u0014\u0010=\u001a\u00020>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u001aR\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u001a¨\u0006C"}, d2 = {"Landroidx/compose/ui/adaptive/UiMediaScopeImpl;", "Landroidx/compose/ui/UiMediaScope;", "context", "Landroid/content/Context;", "inputManager", "Landroid/hardware/input/InputManager;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "imeVisibility", "", "<init>", "(Landroid/content/Context;Landroid/hardware/input/InputManager;Landroidx/compose/ui/platform/WindowInfo;Z)V", "packageManager", "Landroid/content/pm/PackageManager;", "kotlin.jvm.PlatformType", "<set-?>", "_windowInfo", "get_windowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "set_windowInfo", "(Landroidx/compose/ui/platform/WindowInfo;)V", "_windowInfo$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/UiMediaScope$Posture;", "_windowPosture", "get_windowPosture-m18o9QQ", "()Ljava/lang/String;", "set_windowPosture-InyEWag", "(Ljava/lang/String;)V", "_windowPosture$delegate", "Landroidx/compose/ui/UiMediaScope$PointerPrecision;", "_anyPointer", "get_anyPointer-fpxItnM", "set_anyPointer-ZYK4Wgo", "_anyPointer$delegate", "isDocked", "()Z", "setDocked", "(Z)V", "isDocked$delegate", "isImeVisible", "setImeVisible", "isImeVisible$delegate", "hasPhysicalKeyboard", "getHasPhysicalKeyboard", "setHasPhysicalKeyboard", "hasPhysicalKeyboard$delegate", "hasMicrophone", "getHasMicrophone", "hasCamera", "getHasCamera", "windowWidth", "Landroidx/compose/ui/unit/Dp;", "getWindowWidth-D9Ej5fM", "()F", "windowHeight", "getWindowHeight-D9Ej5fM", "windowPosture", "getWindowPosture-m18o9QQ", "pointerPrecision", "getPointerPrecision-fpxItnM", "keyboardKind", "Landroidx/compose/ui/UiMediaScope$KeyboardKind;", "getKeyboardKind-J9_QTjY", "viewingDistance", "Landroidx/compose/ui/UiMediaScope$ViewingDistance;", "getViewingDistance-tKro-MQ", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UiMediaScopeImpl implements UiMediaScope {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: _anyPointer$delegate, reason: from kotlin metadata */
    private final MutableState _anyPointer;

    /* JADX INFO: renamed from: _windowInfo$delegate, reason: from kotlin metadata */
    private final MutableState _windowInfo;

    /* JADX INFO: renamed from: hasPhysicalKeyboard$delegate, reason: from kotlin metadata */
    private final MutableState hasPhysicalKeyboard;

    /* JADX INFO: renamed from: isImeVisible$delegate, reason: from kotlin metadata */
    private final MutableState isImeVisible;
    private final PackageManager packageManager;

    /* JADX INFO: renamed from: _windowPosture$delegate, reason: from kotlin metadata */
    private final MutableState _windowPosture = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(UiMediaScope.Posture.m5441boximpl(UiMediaScope.Posture.INSTANCE.m5449getFlatm18o9QQ()), null, 2, null);

    /* JADX INFO: renamed from: isDocked$delegate, reason: from kotlin metadata */
    private final MutableState isDocked = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    public UiMediaScopeImpl(Context context, InputManager inputManager, WindowInfo windowInfo, boolean z) {
        this.packageManager = context.getPackageManager();
        this._windowInfo = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(windowInfo, null, 2, null);
        this._anyPointer = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(UiMediaScope.PointerPrecision.m5430boximpl(MediaQuery_androidKt.resolvePointerPrecision(inputManager)), null, 2, null);
        this.isImeVisible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.hasPhysicalKeyboard = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(MediaQuery_androidKt.hasPhysicalKeyboard(inputManager)), null, 2, null);
    }

    public final WindowInfo get_windowInfo() {
        return (WindowInfo) this._windowInfo.getValue();
    }

    public final void set_windowInfo(WindowInfo windowInfo) {
        this._windowInfo.setValue(windowInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: get_windowPosture-m18o9QQ, reason: not valid java name */
    public final String m5462get_windowPosturem18o9QQ() {
        return ((UiMediaScope.Posture) this._windowPosture.getValue()).getDescription();
    }

    /* JADX INFO: renamed from: set_windowPosture-InyEWag, reason: not valid java name */
    public final void m5464set_windowPostureInyEWag(String str) {
        this._windowPosture.setValue(UiMediaScope.Posture.m5441boximpl(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: get_anyPointer-fpxItnM, reason: not valid java name */
    public final String m5461get_anyPointerfpxItnM() {
        return ((UiMediaScope.PointerPrecision) this._anyPointer.getValue()).getDescription();
    }

    /* JADX INFO: renamed from: set_anyPointer-ZYK4Wgo, reason: not valid java name */
    public final void m5463set_anyPointerZYK4Wgo(String str) {
        this._anyPointer.setValue(UiMediaScope.PointerPrecision.m5430boximpl(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDocked() {
        return ((Boolean) this.isDocked.getValue()).booleanValue();
    }

    public final void setDocked(boolean z) {
        this.isDocked.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isImeVisible() {
        return ((Boolean) this.isImeVisible.getValue()).booleanValue();
    }

    public final void setImeVisible(boolean z) {
        this.isImeVisible.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasPhysicalKeyboard() {
        return ((Boolean) this.hasPhysicalKeyboard.getValue()).booleanValue();
    }

    public final void setHasPhysicalKeyboard(boolean z) {
        this.hasPhysicalKeyboard.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.ui.UiMediaScope
    public boolean getHasMicrophone() {
        return MediaQuery_androidKt.isMicAvailable(this.packageManager);
    }

    @Override // androidx.compose.ui.UiMediaScope
    public boolean getHasCamera() {
        return MediaQuery_androidKt.isCameraAvailable(this.packageManager);
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* JADX INFO: renamed from: getWindowWidth-D9Ej5fM */
    public float mo5419getWindowWidthD9Ej5fM() {
        return DpSize.m8928getWidthD9Ej5fM(get_windowInfo().mo7957getContainerDpSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* JADX INFO: renamed from: getWindowHeight-D9Ej5fM */
    public float mo5417getWindowHeightD9Ej5fM() {
        return DpSize.m8926getHeightD9Ej5fM(get_windowInfo().mo7957getContainerDpSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* JADX INFO: renamed from: getWindowPosture-m18o9QQ */
    public String mo5418getWindowPosturem18o9QQ() {
        return m5462get_windowPosturem18o9QQ();
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* JADX INFO: renamed from: getPointerPrecision-fpxItnM */
    public String mo5415getPointerPrecisionfpxItnM() {
        return m5461get_anyPointerfpxItnM();
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* JADX INFO: renamed from: getKeyboardKind-J9_QTjY */
    public String mo5414getKeyboardKindJ9_QTjY() {
        return getHasPhysicalKeyboard() ? UiMediaScope.KeyboardKind.INSTANCE.m5428getPhysicalJ9_QTjY() : isImeVisible() ? UiMediaScope.KeyboardKind.INSTANCE.m5429getVirtualJ9_QTjY() : UiMediaScope.KeyboardKind.INSTANCE.m5427getNoneJ9_QTjY();
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* JADX INFO: renamed from: getViewingDistance-tKro-MQ */
    public String mo5416getViewingDistancetKroMQ() {
        if (MediaQuery_androidKt.isTvDevice(this.packageManager)) {
            return UiMediaScope.ViewingDistance.INSTANCE.m5458getFartKroMQ();
        }
        if (MediaQuery_androidKt.isAutomotiveDevice(this.packageManager) || isDocked()) {
            return UiMediaScope.ViewingDistance.INSTANCE.m5459getMediumtKroMQ();
        }
        return UiMediaScope.ViewingDistance.INSTANCE.m5460getNeartKroMQ();
    }
}
