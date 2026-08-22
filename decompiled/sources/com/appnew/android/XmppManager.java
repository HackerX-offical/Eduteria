package com.appnew.android;

import android.app.Activity;
import android.os.StrictMode;
import android.util.Log;
import com.appnew.android.player.LiveStreamingYoutube;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.debugger.android.AndroidDebugger;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: compiled from: XmppManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\fH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/appnew/android/XmppManager;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "connection", "Lorg/jivesoftware/smack/AbstractXMPPConnection;", "userName", "", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "password", "getPassword", "setPassword", "connect", "", "serverUrl", "getConnection", "disconnect", "connectionListener", "Lorg/jivesoftware/smack/ConnectionListener;", "showToast", "message", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XmppManager {
    public static final int $stable = 8;
    private Activity activity;
    private AbstractXMPPConnection connection;
    private final ConnectionListener connectionListener;
    private String password;
    private String userName;

    public XmppManager(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.connectionListener = new ConnectionListener() { // from class: com.appnew.android.XmppManager$connectionListener$1
            @Override // org.jivesoftware.smack.ConnectionListener
            public void connecting(XMPPConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                super.connecting(connection);
                this.this$0.showToast("Connecting");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connected(XMPPConnection conn) {
                Intrinsics.checkNotNullParameter(conn, "conn");
                super.connected(conn);
                this.this$0.showToast("Connected");
                try {
                    AbstractXMPPConnection abstractXMPPConnection = this.this$0.connection;
                    Intrinsics.checkNotNull(abstractXMPPConnection);
                    abstractXMPPConnection.login();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                } catch (SmackException e4) {
                    e4.printStackTrace();
                } catch (XMPPException e5) {
                    e5.printStackTrace();
                }
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection connection, boolean resumed) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, XmppStringprepException, XMPPException.XMPPErrorException {
                Intrinsics.checkNotNullParameter(connection, "connection");
                super.authenticated(connection, resumed);
                this.this$0.showToast("Connection Authenticated");
                if (this.this$0.getActivity() instanceof LiveStreamingYoutube) {
                    Activity activity2 = this.this$0.getActivity();
                    Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.player.LiveStreamingYoutube");
                    ((LiveStreamingYoutube) activity2).loadOrSendChat(connection);
                }
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosed() {
                super.connectionClosed();
                this.this$0.showToast("Connected Closed");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosedOnError(Exception e2) {
                Intrinsics.checkNotNullParameter(e2, "e");
                super.connectionClosedOnError(e2);
                this.this$0.showToast("Connected Closed On Error");
            }
        };
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.activity = activity;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final void connect(String serverUrl, String userName, String password) {
        XMPPTCPConnectionConfiguration xMPPTCPConnectionConfigurationBuild;
        this.userName = userName;
        this.password = password;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        try {
            xMPPTCPConnectionConfigurationBuild = XMPPTCPConnectionConfiguration.builder().setXmppDomain("chat-new.educrypt.ai").setHost("chat-new.educrypt.ai").enableDefaultDebugger().setAuthzid(JidCreate.entityBareFrom(userName)).setSecurityMode(ConnectionConfiguration.SecurityMode.required).setUsernameAndPassword(password, password).build();
        } catch (Exception e2) {
            e2.printStackTrace();
            xMPPTCPConnectionConfigurationBuild = null;
        }
        this.connection = new XMPPTCPConnection(xMPPTCPConnectionConfigurationBuild);
        try {
            AndroidDebugger androidDebugger = new AndroidDebugger(this.connection);
            androidDebugger.onIncomingElementCompleted();
            androidDebugger.onOutgoingElementCompleted();
            AbstractXMPPConnection abstractXMPPConnection = this.connection;
            Intrinsics.checkNotNull(abstractXMPPConnection);
            abstractXMPPConnection.addConnectionListener(this.connectionListener);
            AbstractXMPPConnection abstractXMPPConnection2 = this.connection;
            Intrinsics.checkNotNull(abstractXMPPConnection2);
            abstractXMPPConnection2.connect();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        } catch (SmackException e5) {
            e5.printStackTrace();
        } catch (XMPPException e6) {
            e6.printStackTrace();
        }
    }

    public final AbstractXMPPConnection getConnection() {
        AbstractXMPPConnection abstractXMPPConnection = this.connection;
        if (abstractXMPPConnection != null) {
            return abstractXMPPConnection;
        }
        return null;
    }

    public final void disconnect() {
        AbstractXMPPConnection abstractXMPPConnection = this.connection;
        if (abstractXMPPConnection != null) {
            Intrinsics.checkNotNull(abstractXMPPConnection);
            if (abstractXMPPConnection.isConnected()) {
                AbstractXMPPConnection abstractXMPPConnection2 = this.connection;
                Intrinsics.checkNotNull(abstractXMPPConnection2);
                abstractXMPPConnection2.disconnect();
                AbstractXMPPConnection abstractXMPPConnection3 = this.connection;
                Intrinsics.checkNotNull(abstractXMPPConnection3);
                abstractXMPPConnection3.removeConnectionListener(this.connectionListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String message) {
        Log.d("shantanu", message);
    }
}
