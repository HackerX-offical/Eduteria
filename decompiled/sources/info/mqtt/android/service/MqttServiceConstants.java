package info.mqtt.android.service;

import kotlin.Metadata;

/* JADX INFO: compiled from: MqttServiceConstants.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b`\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Linfo/mqtt/android/service/MqttServiceConstants;", "", "Companion", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MqttServiceConstants {
    public static final String CALLBACK_ACTION = ".callbackAction";
    public static final String CALLBACK_ACTIVITY_TOKEN = ".activityToken";
    public static final String CALLBACK_CLIENT_HANDLE = ".clientHandle";
    public static final String CALLBACK_DESTINATION_NAME = "destinationName";
    public static final String CALLBACK_ERROR_MESSAGE = ".errorMessage";
    public static final String CALLBACK_ERROR_NUMBER = ".ERROR_NUMBER";
    public static final String CALLBACK_EXCEPTION = ".exception";
    public static final String CALLBACK_EXCEPTION_STACK = ".exceptionStack";
    public static final String CALLBACK_INVOCATION_CONTEXT = ".invocationContext";
    public static final String CALLBACK_MESSAGE_ID = "messageId";
    public static final String CALLBACK_MESSAGE_PARCEL = ".PARCEL";
    public static final String CALLBACK_RECONNECT = ".reconnect";
    public static final String CALLBACK_SERVER_URI = ".serverURI";
    public static final String CALLBACK_STATUS = ".callbackStatus";
    public static final String CALLBACK_TO_ACTIVITY = ".callbackToActivity.v0";
    public static final String CALLBACK_TRACE_SEVERITY = ".traceSeverity";
    public static final String CLIENT_HANDLE = "clientHandle";
    public static final String CONNECT_ACTION = "connect";
    public static final String CONNECT_EXTENDED_ACTION = "connectExtended";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DESTINATION_NAME = "destinationName";
    public static final String DISCONNECT_ACTION = "disconnect";
    public static final String DUPLICATE = "duplicate";
    public static final String MESSAGE_ARRIVED_ACTION = "messageArrived";
    public static final String MESSAGE_DELIVERED_ACTION = "messageDelivered";
    public static final String MESSAGE_ID = "messageId";
    public static final String ON_CONNECTION_LOST_ACTION = "onConnectionLost";
    public static final String PAYLOAD = "payload";
    public static final String PING_SENDER = ".pingSender.";
    public static final String PING_WAKELOCK = ".client.";
    public static final String QOS = "qos";
    public static final String RETAINED = "retained";
    public static final String SEND_ACTION = "send";
    public static final String SESSION_PRESENT = "sessionPresent";
    public static final String SUBSCRIBE_ACTION = "subscribe";
    public static final String TRACE_ACTION = "trace";
    public static final String TRACE_DEBUG = "debug";
    public static final String TRACE_ERROR = "error";
    public static final String TRACE_EXCEPTION = "exception";
    public static final String UNSUBSCRIBE_ACTION = "unsubscribe";

    /* JADX INFO: compiled from: MqttServiceConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b(\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Linfo/mqtt/android/service/MqttServiceConstants$Companion;", "", "<init>", "()V", "VERSION", "", "DUPLICATE", "RETAINED", "QOS", "PAYLOAD", "DESTINATION_NAME", "CLIENT_HANDLE", "MESSAGE_ID", "SESSION_PRESENT", "SEND_ACTION", "UNSUBSCRIBE_ACTION", "SUBSCRIBE_ACTION", "DISCONNECT_ACTION", "CONNECT_ACTION", "CONNECT_EXTENDED_ACTION", "MESSAGE_ARRIVED_ACTION", "MESSAGE_DELIVERED_ACTION", "ON_CONNECTION_LOST_ACTION", "TRACE_ACTION", "CALLBACK_TO_ACTIVITY", "CALLBACK_ACTION", "CALLBACK_STATUS", "CALLBACK_CLIENT_HANDLE", "CALLBACK_ERROR_MESSAGE", "CALLBACK_EXCEPTION_STACK", "CALLBACK_INVOCATION_CONTEXT", "CALLBACK_ACTIVITY_TOKEN", "CALLBACK_DESTINATION_NAME", "CALLBACK_MESSAGE_ID", "CALLBACK_RECONNECT", "CALLBACK_SERVER_URI", "CALLBACK_MESSAGE_PARCEL", "CALLBACK_TRACE_SEVERITY", "CALLBACK_ERROR_NUMBER", "CALLBACK_EXCEPTION", "PING_SENDER", "PING_WAKELOCK", "TRACE_ERROR", "TRACE_DEBUG", "TRACE_EXCEPTION", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CALLBACK_ACTION = ".callbackAction";
        public static final String CALLBACK_ACTIVITY_TOKEN = ".activityToken";
        public static final String CALLBACK_CLIENT_HANDLE = ".clientHandle";
        public static final String CALLBACK_DESTINATION_NAME = "destinationName";
        public static final String CALLBACK_ERROR_MESSAGE = ".errorMessage";
        public static final String CALLBACK_ERROR_NUMBER = ".ERROR_NUMBER";
        public static final String CALLBACK_EXCEPTION = ".exception";
        public static final String CALLBACK_EXCEPTION_STACK = ".exceptionStack";
        public static final String CALLBACK_INVOCATION_CONTEXT = ".invocationContext";
        public static final String CALLBACK_MESSAGE_ID = "messageId";
        public static final String CALLBACK_MESSAGE_PARCEL = ".PARCEL";
        public static final String CALLBACK_RECONNECT = ".reconnect";
        public static final String CALLBACK_SERVER_URI = ".serverURI";
        public static final String CALLBACK_STATUS = ".callbackStatus";
        public static final String CALLBACK_TO_ACTIVITY = ".callbackToActivity.v0";
        public static final String CALLBACK_TRACE_SEVERITY = ".traceSeverity";
        public static final String CLIENT_HANDLE = "clientHandle";
        public static final String CONNECT_ACTION = "connect";
        public static final String CONNECT_EXTENDED_ACTION = "connectExtended";
        public static final String DESTINATION_NAME = "destinationName";
        public static final String DISCONNECT_ACTION = "disconnect";
        public static final String DUPLICATE = "duplicate";
        public static final String MESSAGE_ARRIVED_ACTION = "messageArrived";
        public static final String MESSAGE_DELIVERED_ACTION = "messageDelivered";
        public static final String MESSAGE_ID = "messageId";
        public static final String ON_CONNECTION_LOST_ACTION = "onConnectionLost";
        public static final String PAYLOAD = "payload";
        public static final String PING_SENDER = ".pingSender.";
        public static final String PING_WAKELOCK = ".client.";
        public static final String QOS = "qos";
        public static final String RETAINED = "retained";
        public static final String SEND_ACTION = "send";
        public static final String SESSION_PRESENT = "sessionPresent";
        public static final String SUBSCRIBE_ACTION = "subscribe";
        public static final String TRACE_ACTION = "trace";
        public static final String TRACE_DEBUG = "debug";
        public static final String TRACE_ERROR = "error";
        public static final String TRACE_EXCEPTION = "exception";
        public static final String UNSUBSCRIBE_ACTION = "unsubscribe";
        private static final String VERSION = "v0";

        private Companion() {
        }
    }
}
