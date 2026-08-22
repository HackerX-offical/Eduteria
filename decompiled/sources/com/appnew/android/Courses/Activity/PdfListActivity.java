package com.appnew.android.Courses.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.DataList;
import com.appnew.android.Model.PdfList;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.player.NotesAdapter;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class PdfListActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    String course_id;
    List<DataList> dataLists = new ArrayList();
    ImageView image_back;
    NetworkCall networkCall;
    RelativeLayout no_data_foundRL;
    private NotesAdapter notesAdapter;
    RecyclerView pdf_ListRV;
    String video_id;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_list);
        this.pdf_ListRV = (RecyclerView) findViewById(R.id.pdf_ListRV);
        this.no_data_foundRL = (RelativeLayout) findViewById(R.id.no_data_foundRL);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        if (getIntent().getExtras() != null) {
            this.video_id = getIntent().getStringExtra(Const.VIDEO_ID);
            this.course_id = getIntent().getStringExtra("course_id");
        }
        new NetworkCall(this, this).NetworkAPICall(API.get_pdf_list, "", false, false);
        this.image_back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PdfListActivity.this.onBackPressed();
            }
        });
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_pdf_list)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setVideo_id(this.video_id);
        encryptionData.setCourse_id(this.course_id);
        return service.getpdf(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonResponse, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.get_pdf_list)) {
            if (jsonResponse.optString("status").equals("true")) {
                this.pdf_ListRV.setVisibility(0);
                this.no_data_foundRL.setVisibility(8);
                this.dataLists.addAll(((PdfList) new Gson().fromJson(jsonResponse.toString(), PdfList.class)).getData());
                this.pdf_ListRV.setLayoutManager(new LinearLayoutManager(this, 1, false));
                NotesAdapter notesAdapter = new NotesAdapter(this, this.dataLists);
                this.notesAdapter = notesAdapter;
                this.pdf_ListRV.setAdapter(notesAdapter);
                return;
            }
            this.pdf_ListRV.setVisibility(8);
            this.no_data_foundRL.setVisibility(0);
        }
    }
}
