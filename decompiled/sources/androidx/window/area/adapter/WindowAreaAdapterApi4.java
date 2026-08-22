package androidx.window.area.adapter;

import androidx.window.area.WindowAreaCapability;
import kotlin.Metadata;

/* JADX INFO: compiled from: WindowAreaAdapterApi4.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/window/area/adapter/WindowAreaAdapterApi4;", "", "<init>", "()V", "translate", "Landroidx/window/area/WindowAreaCapability$Status;", "status", "", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WindowAreaAdapterApi4 {
    public static final WindowAreaAdapterApi4 INSTANCE = new WindowAreaAdapterApi4();

    private WindowAreaAdapterApi4() {
    }

    public final WindowAreaCapability.Status translate(int status) {
        if (status == 0) {
            return WindowAreaCapability.Status.WINDOW_AREA_STATUS_UNSUPPORTED;
        }
        if (status == 1) {
            return WindowAreaCapability.Status.WINDOW_AREA_STATUS_UNAVAILABLE;
        }
        if (status == 2) {
            return WindowAreaCapability.Status.WINDOW_AREA_STATUS_AVAILABLE;
        }
        if (status == 3) {
            return WindowAreaCapability.Status.WINDOW_AREA_STATUS_ACTIVE;
        }
        return WindowAreaCapability.Status.WINDOW_AREA_STATUS_UNSUPPORTED;
    }
}
