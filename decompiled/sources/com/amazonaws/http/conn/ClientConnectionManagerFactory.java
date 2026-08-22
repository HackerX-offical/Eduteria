package com.amazonaws.http.conn;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ClientConnectionManagerFactory {
    private static final Log log = LogFactory.getLog(ClientConnectionManagerFactory.class);

    public static ClientConnectionManager wrap(ClientConnectionManager clientConnectionManager) {
        if (clientConnectionManager instanceof Wrapped) {
            throw new IllegalArgumentException();
        }
        return (ClientConnectionManager) Proxy.newProxyInstance(ClientConnectionManagerFactory.class.getClassLoader(), new Class[]{ClientConnectionManager.class, Wrapped.class}, new Handler(clientConnectionManager));
    }

    private static class Handler implements InvocationHandler {
        private final ClientConnectionManager orig;

        Handler(ClientConnectionManager clientConnectionManager) {
            this.orig = clientConnectionManager;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                Object objInvoke = method.invoke(this.orig, objArr);
                return objInvoke instanceof ClientConnectionRequest ? ClientConnectionRequestFactory.wrap((ClientConnectionRequest) objInvoke) : objInvoke;
            } catch (InvocationTargetException e2) {
                ClientConnectionManagerFactory.log.debug("", e2);
                throw e2.getCause();
            }
        }
    }
}
