package info.mqtt.android.service;

import android.os.Binder;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MqttServiceBinder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Linfo/mqtt/android/service/MqttServiceBinder;", "Landroid/os/Binder;", NotificationCompat.CATEGORY_SERVICE, "Linfo/mqtt/android/service/MqttService;", "<init>", "(Linfo/mqtt/android/service/MqttService;)V", "getService", "()Linfo/mqtt/android/service/MqttService;", "activityToken", "", "getActivityToken", "()Ljava/lang/String;", "setActivityToken", "(Ljava/lang/String;)V", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MqttServiceBinder extends Binder {
    private String activityToken;
    private final MqttService service;

    public MqttServiceBinder(MqttService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
    }

    public final MqttService getService() {
        return this.service;
    }

    public final String getActivityToken() {
        return this.activityToken;
    }

    public final void setActivityToken(String str) {
        this.activityToken = str;
    }
}
