package com.appnew.android.Download;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Model.Video;
import com.appnew.android.Utils.Helper;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class AudioPlayerActivty extends AppCompatActivity {
    Video videodata;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_custom_audio_player);
        this.videodata = (Video) getIntent().getSerializableExtra("video");
    }
}
