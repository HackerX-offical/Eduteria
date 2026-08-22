package info.mqtt.android.service.ping;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import info.mqtt.android.service.room.MqMessageDatabase;
import info.mqtt.android.service.room.PingDao;
import info.mqtt.android.service.room.entity.PingEntity;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import timber.log.Timber;

/* JADX INFO: compiled from: PingWorker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Linfo/mqtt/android/service/ping/PingWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PingWorker extends CoroutineWorker {
    public static final String KEEP_RECORDS_COUNT = "keepCount";
    public static final String LOGGING = "logging";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PingWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
    }

    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final boolean z = getInputData().getBoolean(LOGGING, false);
        final int i = getInputData().getInt(KEEP_RECORDS_COUNT, 1000);
        final String string = getInputData().getString("id");
        Timber.INSTANCE.d(string + " Sending Ping at: " + AlarmPingSender.INSTANCE.getSdf$serviceLibrary_release().format(new Date(System.currentTimeMillis())), new Object[0]);
        if (string == null) {
            Timber.INSTANCE.e("connection id in ping worker is null!", new Object[0]);
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m12393constructorimpl(ListenableWorker.Result.failure()));
        } else if (!AlarmPingSender.INSTANCE.getClientCommsMap$serviceLibrary_release().containsKey(string)) {
            Timber.INSTANCE.e("client comm doesn't exist anymore: " + string, new Object[0]);
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m12393constructorimpl(ListenableWorker.Result.failure()));
        } else {
            ClientComms clientComms = AlarmPingSender.INSTANCE.getClientCommsMap$serviceLibrary_release().get(string);
            if (clientComms == null || clientComms.checkForActivity(new IMqttActionListener() { // from class: info.mqtt.android.service.ping.PingWorker$doWork$2$1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    PingDao pingDao;
                    PingDao pingDao2;
                    IMqttAsyncClient client;
                    IMqttAsyncClient client2;
                    IMqttAsyncClient client3;
                    String serverURI = null;
                    Timber.INSTANCE.d(string + " Ping Success " + ((asyncActionToken == null || (client3 = asyncActionToken.getClient()) == null) ? null : client3.getClientId()), new Object[0]);
                    if (z) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        String clientId = (asyncActionToken == null || (client2 = asyncActionToken.getClient()) == null) ? null : client2.getClientId();
                        if (asyncActionToken != null && (client = asyncActionToken.getClient()) != null) {
                            serverURI = client.getServerURI();
                        }
                        PingEntity pingEntity = new PingEntity(jCurrentTimeMillis, clientId, serverURI, true, null, 16, null);
                        MqMessageDatabase messageDatabase$serviceLibrary_release = AlarmPingSender.INSTANCE.getMessageDatabase$serviceLibrary_release();
                        if (messageDatabase$serviceLibrary_release != null && (pingDao2 = messageDatabase$serviceLibrary_release.pingDao()) != null) {
                            pingDao2.insert(pingEntity);
                        }
                        MqMessageDatabase messageDatabase$serviceLibrary_release2 = AlarmPingSender.INSTANCE.getMessageDatabase$serviceLibrary_release();
                        if (messageDatabase$serviceLibrary_release2 != null && (pingDao = messageDatabase$serviceLibrary_release2.pingDao()) != null) {
                            pingDao.removeOldData(i);
                        }
                    }
                    CancellableContinuation<ListenableWorker.Result> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m12393constructorimpl(ListenableWorker.Result.success()));
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    PingDao pingDao;
                    PingDao pingDao2;
                    IMqttAsyncClient client;
                    IMqttAsyncClient client2;
                    IMqttAsyncClient client3;
                    Timber.INSTANCE.e(string + " Ping Failure " + exception + " " + ((asyncActionToken == null || (client3 = asyncActionToken.getClient()) == null) ? null : client3.getClientId()), new Object[0]);
                    if (z) {
                        PingEntity pingEntity = new PingEntity(System.currentTimeMillis(), (asyncActionToken == null || (client2 = asyncActionToken.getClient()) == null) ? null : client2.getClientId(), (asyncActionToken == null || (client = asyncActionToken.getClient()) == null) ? null : client.getServerURI(), false, exception != null ? exception.getMessage() : null);
                        MqMessageDatabase messageDatabase$serviceLibrary_release = AlarmPingSender.INSTANCE.getMessageDatabase$serviceLibrary_release();
                        if (messageDatabase$serviceLibrary_release != null && (pingDao2 = messageDatabase$serviceLibrary_release.pingDao()) != null) {
                            pingDao2.insert(pingEntity);
                        }
                        MqMessageDatabase messageDatabase$serviceLibrary_release2 = AlarmPingSender.INSTANCE.getMessageDatabase$serviceLibrary_release();
                        if (messageDatabase$serviceLibrary_release2 != null && (pingDao = messageDatabase$serviceLibrary_release2.pingDao()) != null) {
                            pingDao.removeOldData(i);
                        }
                    }
                    CancellableContinuation<ListenableWorker.Result> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m12393constructorimpl(ListenableWorker.Result.failure()));
                }
            }) == null) {
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m12393constructorimpl(ListenableWorker.Result.success()));
                Unit unit = Unit.INSTANCE;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
