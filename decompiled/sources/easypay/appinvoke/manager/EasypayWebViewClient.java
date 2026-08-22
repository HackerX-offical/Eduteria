package easypay.appinvoke.manager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import easypay.appinvoke.actions.EasypayBrowserFragment;
import easypay.appinvoke.listeners.WebClientListener;
import easypay.appinvoke.utils.AssistInvokeException;
import easypay.appinvoke.utils.AssistLogs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public class EasypayWebViewClient extends WebViewClient implements Serializable {
    public static long smsTrackingTime;
    private EasypayBrowserFragment fragment;
    private Activity mActivity;
    private ArrayList<WebClientListener> mWcListListener;

    public EasypayWebViewClient() {
    }

    public EasypayWebViewClient(Activity activity) {
        AssistLogs.printLog("EasypayWebViewClient" + toString(), this);
        this.mActivity = activity;
        this.mWcListListener = PaytmAssist.getAssistInstance().getmWcListListener();
        smsTrackingTime = System.currentTimeMillis();
        this.fragment = PaytmAssist.getAssistInstance().getFragment();
    }

    public void addAssistWebClientListener(WebClientListener webClientListener) {
        ArrayList<WebClientListener> arrayList = this.mWcListListener;
        if (arrayList != null) {
            try {
                arrayList.listIterator().add(webClientListener);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            throw new AssistInvokeException(Constants.Assist_Invoke_Exception_Message);
        } catch (AssistInvokeException e3) {
            e3.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e3);
        }
    }

    public synchronized void removeAssistWebClientListener(WebClientListener webClientListener) {
        ArrayList<WebClientListener> arrayList = this.mWcListListener;
        if (arrayList != null) {
            try {
                Iterator<WebClientListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(webClientListener)) {
                        it.remove();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                throw new AssistInvokeException(Constants.Assist_Invoke_Exception_Message);
            } catch (AssistInvokeException e3) {
                e3.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e3);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        AssistLogs.printLog("" + str, this);
        try {
            ArrayList<WebClientListener> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<WebClientListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().OnWcPageFinish(webView, str);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
        try {
            if (this.fragment == null) {
                this.fragment = PaytmAssist.getAssistInstance().getFragment();
            }
            fireActions(webView, str);
            PaytmAssist.getAssistInstance().setLastLoadedUrl(str);
        } catch (Exception e3) {
            e3.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e3);
        }
    }

    private void fireActions(final WebView webView, final String str) {
        if (this.fragment == null || PaytmAssist.getAssistInstance().getAssistEngineTerminatedStatus()) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.manager.EasypayWebViewClient.1
            @Override // java.lang.Runnable
            public void run() {
                if (EasypayWebViewClient.this.fragment != null) {
                    AssistLogs.printLog("page finish: fire action:checkAssistFlow", this);
                    EasypayWebViewClient.this.fragment.checkAssistFlow(webView, str);
                }
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public synchronized void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            ArrayList<WebClientListener> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<WebClientListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().OnWcSslError(webView, sslErrorHandler, sslError);
                }
            }
        } catch (AbstractMethodError unused) {
        }
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        AssistLogs.printLog("onpage started-" + str, this);
        try {
            if (this.mWcListListener != null) {
                for (int i = 0; i < this.mWcListListener.size(); i++) {
                    this.mWcListListener.get(i).OnWcPageStart(webView, str, bitmap);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
        EasypayBrowserFragment easypayBrowserFragment = this.fragment;
        if (easypayBrowserFragment != null) {
            easypayBrowserFragment.resetActions();
            try {
                this.fragment.getActivity().runOnUiThread(new Runnable() { // from class: easypay.appinvoke.manager.EasypayWebViewClient.2
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            ArrayList<WebClientListener> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<WebClientListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().WcshouldOverrideUrlLoading(webView, str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            ArrayList<WebClientListener> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<WebClientListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().WcshouldOverrideUrlLoading(webView, webResourceRequest);
                }
            }
        } catch (Exception unused) {
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            ArrayList<WebClientListener> arrayList = this.mWcListListener;
            if (arrayList != null) {
                Iterator<WebClientListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().WcshouldInterceptRequest(webView, str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
