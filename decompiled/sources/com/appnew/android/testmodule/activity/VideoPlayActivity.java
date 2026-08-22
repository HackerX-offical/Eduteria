package com.appnew.android.testmodule.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.testmodule.model.TestReportVideos;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class VideoPlayActivity extends AppCompatActivity {
    ImageView backimag;
    TestReportVideos testReportVideos;
    Toolbar toolbar;
    VideoView videoView;
    AppCompatTextView video_title;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_video_play);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.videoView = (VideoView) findViewById(R.id.video_play);
        this.video_title = (AppCompatTextView) this.toolbar.findViewById(R.id.video_title);
        this.backimag = (ImageView) this.toolbar.findViewById(R.id.backimag);
        TestReportVideos testReportVideos = (TestReportVideos) getIntent().getSerializableExtra(Const.VIDEODATA);
        this.testReportVideos = testReportVideos;
        if (testReportVideos != null) {
            this.video_title.setText(testReportVideos.getVideo_title().toString());
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(this.videoView);
            this.videoView.setMediaController(mediaController);
            this.videoView.setVideoPath(this.testReportVideos.getVideo_url());
            this.videoView.requestFocus();
            this.videoView.start();
        }
        this.backimag.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.VideoPlayActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayActivity.this.finish();
            }
        });
    }
}
