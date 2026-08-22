package com.appnew.android.feeds;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class FeeedActivity extends AppCompatActivity {
    ImageView backPress;
    List<model> data = new ArrayList();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feeds_activity);
        this.backPress = (ImageView) findViewById(R.id.image_back);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<model> list = this.data;
        Integer numValueOf = Integer.valueOf(R.drawable.placeholder);
        list.add(new model(numValueOf, "Previous Year Question Bank"));
        this.data.add(new model(numValueOf, "Class 12th History ( कक्षा-12 इतिहास दीर्घ उत्तरीय प्रश्न ) PART- 6"));
        this.data.add(new model(numValueOf, "Bihar Board Hindi 100 Marks ( पाठ -9. प्रगीत और समाज ) objective question answer 2023 PDF Download"));
        this.data.add(new model(numValueOf, "खाद्य उत्पादन में वृद्धि की कार्यनीति"));
        this.data.add(new model(numValueOf, "Previous Year Question Bank"));
        this.data.add(new model(numValueOf, "Class 12th History ( कक्षा-12 इतिहास दीर्घ उत्तरीय प्रश्न ) PART- 6"));
        this.data.add(new model(numValueOf, "Bihar Board Hindi 100 Marks ( पाठ -9. प्रगीत और समाज ) objective question answer 2023 PDF Download"));
        this.data.add(new model(numValueOf, "खाद्य उत्पादन में वृद्धि की कार्यनीति"));
        recyclerView.setAdapter(new Adapter(this.data, this));
        this.backPress.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.FeeedActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
