package com.appnew.android.Utils;

import android.app.Activity;
import android.os.Build;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes6.dex */
public class BackHandlerHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Object backInvokedCallbackProxy;
    private OnBackPressedCallback backPressedCallback;

    public void setup(final ComponentActivity activity, final Runnable onCustomBackPress) {
        this.backPressedCallback = new OnBackPressedCallback(true) { // from class: com.appnew.android.Utils.BackHandlerHelper.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                onCustomBackPress.run();
            }
        };
        activity.getOnBackPressedDispatcher().addCallback(activity, this.backPressedCallback);
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                Class<?> cls = Class.forName("android.window.OnBackInvokedCallback");
                this.backInvokedCallbackProxy = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.appnew.android.Utils.BackHandlerHelper.2
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        if ("onBackInvoked".equals(name)) {
                            try {
                                onCustomBackPress.run();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            return null;
                        }
                        if ("equals".equals(name) && args != null) {
                            if (args.length == 1) {
                                return Boolean.valueOf(proxy == args[0]);
                            }
                        }
                        if ("hashCode".equals(name)) {
                            return Integer.valueOf(System.identityHashCode(proxy));
                        }
                        if (InAppPurchaseConstants.METHOD_TO_STRING.equals(name)) {
                            return proxy.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(proxy));
                        }
                        return null;
                    }
                });
                Object objInvoke = Activity.class.getMethod("getOnBackInvokedDispatcher", new Class[0]).invoke(activity, new Object[0]);
                objInvoke.getClass().getMethod("registerOnBackInvokedCallback", Integer.TYPE, cls).invoke(objInvoke, 0, this.backInvokedCallbackProxy);
            } catch (Throwable th) {
                th.printStackTrace();
                this.backInvokedCallbackProxy = null;
            }
        }
    }

    public void cleanup(ComponentActivity activity) {
        OnBackPressedCallback onBackPressedCallback = this.backPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.remove();
            this.backPressedCallback = null;
        }
        if (Build.VERSION.SDK_INT < 33 || this.backInvokedCallbackProxy == null) {
            return;
        }
        try {
            Object objInvoke = Activity.class.getMethod("getOnBackInvokedDispatcher", new Class[0]).invoke(activity, new Object[0]);
            objInvoke.getClass().getMethod("unregisterOnBackInvokedCallback", Class.forName("android.window.OnBackInvokedCallback")).invoke(objInvoke, this.backInvokedCallbackProxy);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                this.backInvokedCallbackProxy = null;
            }
        }
    }
}
