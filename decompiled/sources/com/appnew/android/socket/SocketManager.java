package com.appnew.android.socket;

import android.widget.TextView;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.databinding.ActivityGroupChat2Binding;
import com.appnew.android.socket.activity.GroupChatActivity;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.CertificateException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SocketManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rJ\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rJ\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rJ\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rJ\u001a\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\rJ\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0018\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rJ$\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001eJ$\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000b0\u001eJ$\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001eJ$\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u001eJ$\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001eJ$\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u001eJ$\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001eJ\u0014\u0010-\u001a\u00020\u000b*\u00020.2\b\u0010/\u001a\u0004\u0018\u000100R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/appnew/android/socket/SocketManager;", "", "<init>", "()V", "socket", "Lio/socket/client/Socket;", "getSocket", "()Lio/socket/client/Socket;", "setSocket", "(Lio/socket/client/Socket;)V", "connect", "", "url", "", "joinRoom", "roomId", "leaveRoom", "setPinUnPin", "chatId", "message", "deleteChat", "editChat", "fetchMessageHistory", "connectionListeners", "isConnected", "", "disconnect", "sendMessage", "onMessageReceived", "callback", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "listenOnce", "Lorg/json/JSONArray;", "listenForPinUnpin", "listenForChatDelete", "listenForEditChat", "listenForBlockEvent", "listenForRoomEvents", "trustAllCerts", "", "Ljavax/net/ssl/TrustManager;", "[Ljavax/net/ssl/TrustManager;", "myHostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "setPinnedMessage", "Lcom/appnew/android/socket/activity/GroupChatActivity;", "pinnedMessage", "Lcom/appnew/android/Model/chatPojo;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocketManager {
    public static final int $stable = 8;
    public Socket socket;
    private TrustManager[] trustAllCerts = {new X509TrustManager() { // from class: com.appnew.android.socket.SocketManager$trustAllCerts$1
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }};
    private HostnameVerifier myHostnameVerifier = new HostnameVerifier() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda5
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return SocketManager.myHostnameVerifier$lambda$9(str, sSLSession);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean myHostnameVerifier$lambda$9(String str, SSLSession sSLSession) {
        return true;
    }

    public final Socket getSocket() {
        Socket socket = this.socket;
        if (socket != null) {
            return socket;
        }
        Intrinsics.throwUninitializedPropertyAccessException("socket");
        return null;
    }

    public final void setSocket(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<set-?>");
        this.socket = socket;
    }

    public static /* synthetic */ void connect$default(SocketManager socketManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "https://developmentadmin.videocrypt.in:8080";
        }
        socketManager.connect(str);
    }

    public final void connect(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, this.trustAllCerts, new SecureRandom());
            OkHttpClient.Builder builderHostnameVerifier = new OkHttpClient.Builder().hostnameVerifier(this.myHostnameVerifier);
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getSocketFactory(...)");
            TrustManager trustManager = this.trustAllCerts[0];
            Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            OkHttpClient okHttpClientBuild = builderHostnameVerifier.sslSocketFactory(socketFactory, (X509TrustManager) trustManager).build();
            IO.setDefaultOkHttpWebSocketFactory(okHttpClientBuild);
            IO.setDefaultOkHttpCallFactory(okHttpClientBuild);
            IO.Options options = new IO.Options();
            options.forceNew = true;
            options.reconnection = true;
            options.reconnectionDelay = 1000L;
            options.reconnectionDelayMax = 5000L;
            options.reconnectionAttempts = 10;
            options.callFactory = okHttpClientBuild;
            options.webSocketFactory = okHttpClientBuild;
            setSocket(IO.socket(url));
            System.out.println((Object) ("success, " + getSocket().id()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        getSocket().connect();
        connectionListeners();
    }

    public final void joinRoom(String roomId) throws JSONException {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomId", roomId);
        jSONObject.put("userId", MakeMyExam.userId);
        getSocket().emit("joinRoom", jSONObject);
    }

    public final void leaveRoom(String roomId) throws JSONException {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomId", roomId);
        jSONObject.put("userId", MakeMyExam.userId);
        getSocket().emit("leaveRoom", jSONObject);
    }

    public final void setPinUnPin(String roomId, String chatId, String message) throws JSONException {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomId", roomId);
        jSONObject.put("chatId", chatId);
        jSONObject.put("message", message);
        getSocket().emit("setPinUnpin", jSONObject);
    }

    public final void deleteChat(String roomId, String chatId) throws JSONException {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomId", roomId);
        jSONObject.put("chatId", chatId);
        getSocket().emit("deleteChat", jSONObject);
    }

    public final void editChat(String roomId, String chatId, String message) throws JSONException {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomId", roomId);
        jSONObject.put("chatId", chatId);
        jSONObject.put("message", message);
        getSocket().emit("editChat", jSONObject);
    }

    public static /* synthetic */ void fetchMessageHistory$default(SocketManager socketManager, String str, String str2, int i, Object obj) throws JSONException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        socketManager.fetchMessageHistory(str, str2);
    }

    public final void fetchMessageHistory(String roomId, String chatId) throws JSONException {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomId", roomId);
        jSONObject.put("userId", MakeMyExam.userId);
        if (chatId != null) {
            jSONObject.put("chatId", chatId);
        }
        getSocket().emit("fetchMessageHistory", jSONObject);
    }

    private final void connectionListeners() {
        getSocket().on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda8
            @Override // io.socket.emitter.Emitter.Listener
            public final void call(Object[] objArr) {
                SocketManager.connectionListeners$lambda$0(objArr);
            }
        });
        getSocket().on("connect", new Emitter.Listener() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda9
            @Override // io.socket.emitter.Emitter.Listener
            public final void call(Object[] objArr) {
                SocketManager.connectionListeners$lambda$1(objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectionListeners$lambda$0(Object[] objArr) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SocketManager$connectionListeners$1$1(objArr, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectionListeners$lambda$1(Object[] objArr) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SocketManager$connectionListeners$2$1(null), 3, null);
    }

    public final boolean isConnected() {
        return getSocket().connected();
    }

    public final void disconnect() {
        getSocket().disconnect();
        getSocket().off();
    }

    public static /* synthetic */ void sendMessage$default(SocketManager socketManager, String str, String str2, int i, Object obj) throws JSONException {
        if ((i & 1) != 0) {
            str = "message";
        }
        socketManager.sendMessage(str, str2);
    }

    public final void sendMessage(String roomId, String message) throws JSONException {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomId", roomId);
        jSONObject.put("message", message);
        getSocket().emit("message", jSONObject);
    }

    public static /* synthetic */ void onMessageReceived$default(SocketManager socketManager, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "message";
        }
        socketManager.onMessageReceived(str, function1);
    }

    public final void onMessageReceived(String roomId, final Function1<? super JSONObject, Unit> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getSocket().on(roomId, new Emitter.Listener() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda2
            @Override // io.socket.emitter.Emitter.Listener
            public final void call(Object[] objArr) {
                SocketManager.onMessageReceived$lambda$2(callback, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageReceived$lambda$2(Function1 function1, Object[] objArr) {
        Object obj = objArr[0];
        if (obj != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject = (JSONObject) obj;
            System.out.println((Object) ("Upcoming Messages: " + jSONObject));
            function1.invoke(jSONObject);
        }
    }

    public static /* synthetic */ void listenOnce$default(SocketManager socketManager, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "fetchMessageHistory";
        }
        socketManager.listenOnce(str, function1);
    }

    public final void listenOnce(String roomId, final Function1<? super JSONArray, Unit> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getSocket().on(roomId, new Emitter.Listener() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda4
            @Override // io.socket.emitter.Emitter.Listener
            public final void call(Object[] objArr) {
                SocketManager.listenOnce$lambda$3(callback, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenOnce$lambda$3(Function1 function1, Object[] objArr) {
        Object obj = objArr[0];
        if (obj != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            function1.invoke((JSONArray) obj);
        }
    }

    public static /* synthetic */ void listenForPinUnpin$default(SocketManager socketManager, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "setPinUnpin";
        }
        socketManager.listenForPinUnpin(str, function1);
    }

    public final void listenForPinUnpin(String roomId, final Function1<? super JSONObject, Unit> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getSocket().on(roomId, new Emitter.Listener() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda6
            @Override // io.socket.emitter.Emitter.Listener
            public final void call(Object[] objArr) {
                SocketManager.listenForPinUnpin$lambda$4(callback, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenForPinUnpin$lambda$4(Function1 function1, Object[] objArr) {
        String string;
        Object obj = objArr[0];
        if (obj != null) {
            try {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                string = (String) obj;
            } catch (Exception unused) {
                string = objArr[0].toString();
            }
            function1.invoke(new JSONObject(string));
        }
    }

    public static /* synthetic */ void listenForChatDelete$default(SocketManager socketManager, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "deleteChat";
        }
        socketManager.listenForChatDelete(str, function1);
    }

    public final void listenForChatDelete(String roomId, final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getSocket().on(roomId, new Emitter.Listener() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda7
            @Override // io.socket.emitter.Emitter.Listener
            public final void call(Object[] objArr) {
                SocketManager.listenForChatDelete$lambda$5(callback, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenForChatDelete$lambda$5(Function1 function1, Object[] objArr) {
        Object obj = objArr[0];
        if (obj != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            function1.invoke((String) obj);
        }
    }

    public static /* synthetic */ void listenForEditChat$default(SocketManager socketManager, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "editChat";
        }
        socketManager.listenForEditChat(str, function1);
    }

    public final void listenForEditChat(String roomId, final Function1<? super JSONObject, Unit> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getSocket().on(roomId, new Emitter.Listener() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda1
            @Override // io.socket.emitter.Emitter.Listener
            public final void call(Object[] objArr) {
                SocketManager.listenForEditChat$lambda$6(callback, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenForEditChat$lambda$6(Function1 function1, Object[] objArr) {
        String string;
        Object obj = objArr[0];
        if (obj != null) {
            try {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                string = (String) obj;
            } catch (Exception unused) {
                string = objArr[0].toString();
            }
            function1.invoke(new JSONObject(string));
            System.out.println((Object) ("Edited Messages: " + string));
        }
    }

    public static /* synthetic */ void listenForBlockEvent$default(SocketManager socketManager, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "blockUser";
        }
        socketManager.listenForBlockEvent(str, function1);
    }

    public final void listenForBlockEvent(String roomId, final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getSocket().on(roomId, new Emitter.Listener() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda0
            @Override // io.socket.emitter.Emitter.Listener
            public final void call(Object[] objArr) {
                SocketManager.listenForBlockEvent$lambda$7(callback, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenForBlockEvent$lambda$7(Function1 function1, Object[] objArr) {
        Object obj = objArr[0];
        if (obj != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            function1.invoke((String) obj);
        }
    }

    public static /* synthetic */ void listenForRoomEvents$default(SocketManager socketManager, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "joinRoom";
        }
        socketManager.listenForRoomEvents(str, function1);
    }

    public final void listenForRoomEvents(String roomId, final Function1<? super JSONObject, Unit> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getSocket().once(roomId, new Emitter.Listener() { // from class: com.appnew.android.socket.SocketManager$$ExternalSyntheticLambda3
            @Override // io.socket.emitter.Emitter.Listener
            public final void call(Object[] objArr) {
                SocketManager.listenForRoomEvents$lambda$8(callback, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenForRoomEvents$lambda$8(Function1 function1, Object[] objArr) {
        Object obj = objArr[0];
        if (obj != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            function1.invoke((JSONObject) obj);
        }
    }

    public final void setPinnedMessage(GroupChatActivity groupChatActivity, chatPojo chatpojo) {
        int iHashCode;
        Intrinsics.checkNotNullParameter(groupChatActivity, "<this>");
        ActivityGroupChat2Binding binding = groupChatActivity.getBinding();
        if (chatpojo != null) {
            String type = chatpojo.getType();
            if (type != null && ((iHashCode = type.hashCode()) == 110834 ? type.equals(Const.PDF) : iHashCode == 93166550 ? type.equals("audio") : !(iHashCode != 100313435 || !type.equals("image")))) {
                String message = chatpojo.getMessage();
                Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
                if (message.length() > 0) {
                    String message2 = chatpojo.getMessage();
                    Intrinsics.checkNotNullExpressionValue(message2, "getMessage(...)");
                    if (StringsKt.contains$default((CharSequence) message2, (CharSequence) MqttTopic.TOPIC_LEVEL_SEPARATOR, false, 2, (Object) null)) {
                        TextView textView = binding.pinChatMessage;
                        String message3 = chatpojo.getMessage();
                        Intrinsics.checkNotNullExpressionValue(message3, "getMessage(...)");
                        List listSplit$default = StringsKt.split$default((CharSequence) message3, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null);
                        String message4 = chatpojo.getMessage();
                        Intrinsics.checkNotNullExpressionValue(message4, "getMessage(...)");
                        textView.setText((CharSequence) listSplit$default.get(StringsKt.split$default((CharSequence) message4, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null).size() - 1));
                        return;
                    }
                    return;
                }
                return;
            }
            TextView textView2 = binding.pinChatMessage;
            String message5 = chatpojo.getMessage();
            Intrinsics.checkNotNullExpressionValue(message5, "getMessage(...)");
            String str = message5;
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            textView2.setText(str.subSequence(i, length + 1).toString());
        }
    }
}
