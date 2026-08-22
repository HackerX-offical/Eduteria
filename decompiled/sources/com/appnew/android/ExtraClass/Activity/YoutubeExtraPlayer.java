package com.appnew.android.ExtraClass.Activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.player.YTubePlayerView;
import com.eduteria.app.app.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes6.dex */
public class YoutubeExtraPlayer extends AppCompatActivity {
    TextView floatingText;
    ProgressBar progressBar;
    private String videoId;
    TextView video_name_text;
    WebView webView;
    YTubePlayerView yTubePlayerView;
    YouTubePlayerView youTubePlayerView;
    private YTubePlayerView youTubeView;
    private WebView youtubePlayerView;
    long currentTime = 0;
    String url = "";
    String type = "";
    String name = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        setContentView(R.layout.activity_youtube_extra_player);
        if (getIntent() != null) {
            this.url = getIntent().getStringExtra("videourl");
            this.type = getIntent().getStringExtra("type");
            this.name = getIntent().getStringExtra("videoname");
        }
        this.youTubePlayerView = (YouTubePlayerView) findViewById(R.id.player_view_new);
        this.floatingText = (TextView) findViewById(R.id.floatingText_new);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        TextView textView = (TextView) findViewById(R.id.video_name);
        this.video_name_text = textView;
        textView.setSelected(true);
        this.video_name_text.setText(this.name);
        this.floatingText.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
        initUI(this.url);
    }

    private void initUI(String url) {
        this.youtubePlayerView = (WebView) findViewById(R.id.youtube_player_view);
        this.videoId = url;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.currentTime = System.currentTimeMillis();
        try {
            if (MakeMyExam.userId.equalsIgnoreCase("") || MakeMyExam.userId.equalsIgnoreCase("0")) {
                MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
                MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
            }
            initPlayer();
        } catch (Exception unused) {
        }
    }

    private void initPlayer() {
        YTubePlayerView yTubePlayerView = new YTubePlayerView(this);
        this.yTubePlayerView = yTubePlayerView;
        this.youTubeView = yTubePlayerView;
        yTubePlayerView.setInstanseOfActivity(this);
        WebView webView = this.youtubePlayerView;
        this.webView = webView;
        webView.setWebViewClient(new PlayerWebViewClient());
        this.webView.loadUrl("https://www.youtube.com/embed/" + this.videoId);
    }

    private class PlayerWebViewClient extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }

        private PlayerWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            YoutubeExtraPlayer.this.progressBar.setVisibility(8);
            YoutubeExtraPlayer.this.webView.loadUrl("javascript:(function() { document.getElementsByClassName('ytp-play-button ytp-button')[0].click(); })()");
            YoutubeExtraPlayer.this.yTubePlayerView.hideSomeSectionOfBlog(YoutubeExtraPlayer.this.webView);
            YoutubeExtraPlayer.this.yTubePlayerView.scheduleHideContent(YoutubeExtraPlayer.this.webView);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            YoutubeExtraPlayer.this.progressBar.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            webView.getSettings();
            webView.loadData("Please try after some time.", Mimetypes.MIMETYPE_HTML, "UTF-8");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        YTubePlayerView yTubePlayerView = this.yTubePlayerView;
        if (yTubePlayerView != null) {
            yTubePlayerView.loadUrl("about:blank");
            this.yTubePlayerView.clearHistory();
            this.yTubePlayerView.stopLoading();
            this.yTubePlayerView.clearCache(true);
            this.yTubePlayerView.clearView();
            this.yTubePlayerView.freeMemory();
            this.yTubePlayerView.destroy();
            try {
                Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(this.yTubePlayerView, null);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
            } catch (SecurityException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.webView != null) {
            this.yTubePlayerView.loadUrl("about:blank");
            this.yTubePlayerView.clearHistory();
            this.yTubePlayerView.stopLoading();
            this.yTubePlayerView.clearCache(true);
            this.yTubePlayerView.clearView();
            this.yTubePlayerView.freeMemory();
            this.yTubePlayerView.destroy();
            try {
                Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(this.yTubePlayerView, null);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
            } catch (SecurityException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        WebView webView = this.webView;
        if (webView != null) {
            webView.loadUrl("");
        }
    }
}
