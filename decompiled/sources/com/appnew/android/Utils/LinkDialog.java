package com.appnew.android.Utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class LinkDialog extends Dialog {
    private Context context;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private List<OnVerifyListener> f323listeners;

    public interface OnVerifyListener {
        void onVerify(String verifier);
    }

    public LinkDialog(Context context) {
        super(context);
        this.f323listeners = new ArrayList();
        this.context = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ln_dialog);
        setCanceledOnTouchOutside(false);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.appnew.android.Utils.LinkDialog.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialog) {
                LinkDialog.this.new LoadToken().execute(new Void[0]);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWebView() {
        WebView webView = (WebView) findViewById(R.id.webkitWebView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new HelloWebViewClient());
    }

    class LoadToken extends AsyncTask<Void, Void, Object> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Object doInBackground(Void... params) {
            return null;
        }

        LoadToken() {
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Object result) {
            super.onPostExecute(result);
            if (result == null) {
                LinkDialog.this.setWebView();
            } else {
                Toast.makeText(LinkDialog.this.context, R.string.connection_error_please_try_again, 0).show();
                LinkDialog.this.dismiss();
            }
        }
    }

    class HelloWebViewClient extends WebViewClient {
        HelloWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            LinkDialog.this.findViewById(R.id.progress_bar).setVisibility(8);
            super.onPageFinished(view, url);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains(Const.OAUTH_CALLBACK_URL)) {
                LinkDialog.this.findViewById(R.id.progress_bar).setVisibility(0);
                String queryParameter = Uri.parse(url).getQueryParameter("oauth_verifier");
                LinkDialog.this.cancel();
                Iterator it = LinkDialog.this.f323listeners.iterator();
                while (it.hasNext()) {
                    ((OnVerifyListener) it.next()).onVerify(queryParameter);
                }
                return true;
            }
            if (url.contains("https://linkapp.com/auth/callback/cancel")) {
                LinkDialog.this.findViewById(R.id.progress_bar).setVisibility(8);
                LinkDialog.this.cancel();
                return true;
            }
            view.loadUrl(url);
            return true;
        }
    }

    public void setVerifierListener(OnVerifyListener data) {
        this.f323listeners.add(data);
    }
}
