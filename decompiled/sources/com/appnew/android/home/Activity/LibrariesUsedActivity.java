package com.appnew.android.home.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Helper;
import com.appnew.android.home.adapters.LibUsedAdapter;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class LibrariesUsedActivity extends AppCompatActivity {
    private static RecyclerView.LayoutManager mLayoutManager;
    ImageView iv_back;
    private RecyclerView libUsedList;
    private LibUsedAdapter mAdapter;
    private Toolbar mLibUsedToolbar;
    TextView toolbarTitle;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.opensourcelibrarylayout);
        init();
    }

    private void init() {
        this.mLibUsedToolbar = (Toolbar) findViewById(R.id.oslibactionbar);
        this.libUsedList = (RecyclerView) findViewById(R.id.libusedlist);
        this.iv_back = (ImageView) findViewById(R.id.iv_back);
        TextView textView = (TextView) findViewById(R.id.toolbartitleTV);
        this.toolbarTitle = textView;
        textView.setText(R.string.open_source_library_activity);
        this.iv_back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.LibrariesUsedActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LibrariesUsedActivity.this.onBackPressed();
            }
        });
        if (getSupportActionBar() == null) {
            setSupportActionBar(this.mLibUsedToolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("");
            }
        }
        mLayoutManager = new LinearLayoutManager(this) { // from class: com.appnew.android.home.Activity.LibrariesUsedActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean isAutoMeasureEnabled() {
                return true;
            }
        };
        this.libUsedList.setHasFixedSize(true);
        this.libUsedList.setLayoutManager(mLayoutManager);
        LibUsedAdapter libUsedAdapter = new LibUsedAdapter(this);
        this.mAdapter = libUsedAdapter;
        this.libUsedList.setAdapter(libUsedAdapter);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }
}
