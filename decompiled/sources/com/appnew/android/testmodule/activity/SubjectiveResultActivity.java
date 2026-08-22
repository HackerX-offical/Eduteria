package com.appnew.android.testmodule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.testmodule.model.SubjectiveResultData;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class SubjectiveResultActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    Button checkcopy;
    Button discussion;
    ImageView img_testback;
    NetworkCall networkCall;
    TextView obtained_marks;
    TextView rank;
    LinearLayout remarksLinearLayout;
    TextView remarks_description;
    SubjectiveResultData resultTestSeries2;
    TextView testSeriesName;
    TextView title1;
    TextView total_marks;
    String url = "";
    String title = "";
    String id = "";
    String v_id = "";
    String contenttype = "";

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        setContentView(R.layout.activity_subjective_result);
        Helper.enableScreenShot(this);
        this.title = getIntent().getStringExtra("title");
        this.id = getIntent().getStringExtra("id");
        this.v_id = getIntent().getStringExtra(Const.VIDEO_ID);
        this.checkcopy = (Button) findViewById(R.id.checkcopy);
        this.img_testback = (ImageView) findViewById(R.id.img_testback);
        this.rank = (TextView) findViewById(R.id.rank);
        this.remarks_description = (TextView) findViewById(R.id.remarks_description);
        this.remarksLinearLayout = (LinearLayout) findViewById(R.id.remarksLinearLayout);
        this.total_marks = (TextView) findViewById(R.id.total_marks);
        this.obtained_marks = (TextView) findViewById(R.id.obtained_marks);
        this.title1 = (TextView) findViewById(R.id.title);
        this.discussion = (Button) findViewById(R.id.discussion);
        this.testSeriesName = (TextView) findViewById(R.id.testSeriesName);
        this.title1.setText(this.title);
        this.networkCall = new NetworkCall(this, this);
        String stringExtra = getIntent().getStringExtra("content");
        this.contenttype = stringExtra;
        if (stringExtra.contains(Const.SUBJECTIVE_TEST)) {
            this.discussion.setVisibility(0);
            this.testSeriesName.setText(getResources().getString(R.string.subjective_test_result));
        } else {
            this.rank.setVisibility(8);
            this.discussion.setVisibility(8);
            this.testSeriesName.setText(getResources().getString(R.string.daily_assignment_result));
        }
        this.rank.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.SubjectiveResultActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SubjectiveResultActivity.this.resultTestSeries2.getTopRankers() != null && SubjectiveResultActivity.this.resultTestSeries2.getTopRankers().size() > 0) {
                    Intent intent = new Intent(SubjectiveResultActivity.this, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.RANK);
                    intent.putExtra(Const.RANK, SubjectiveResultActivity.this.resultTestSeries2);
                    SubjectiveResultActivity.this.startActivity(intent);
                    return;
                }
                SubjectiveResultActivity subjectiveResultActivity = SubjectiveResultActivity.this;
                Toast.makeText(subjectiveResultActivity, subjectiveResultActivity.getResources().getString(R.string.rank_not_found), 0).show();
            }
        });
        this.discussion.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.SubjectiveResultActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SubjectiveResultActivity.this.resultTestSeries2 != null && SubjectiveResultActivity.this.resultTestSeries2.getVideo() != null) {
                    if (SubjectiveResultActivity.this.resultTestSeries2 != null && SubjectiveResultActivity.this.resultTestSeries2.getVideo().getVideo_type().equalsIgnoreCase("1")) {
                        if (SubjectiveResultActivity.this.resultTestSeries2.getVideo() != null) {
                            String str = "http://img.youtube.com/vi/" + SubjectiveResultActivity.this.resultTestSeries2.getVideo().getFile_url() + "/0.jpg";
                            SubjectiveResultActivity subjectiveResultActivity = SubjectiveResultActivity.this;
                            Helper.GoToLiveVideoActivity("", subjectiveResultActivity, subjectiveResultActivity.resultTestSeries2.getVideo().getFile_url(), "1", SubjectiveResultActivity.this.resultTestSeries2.getVideo().getId(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getTitle(), "0", str, "1", SubjectiveResultActivity.this.id, String.valueOf(1), "", "", "Video", new ArrayList());
                            return;
                        }
                        return;
                    }
                    if (SubjectiveResultActivity.this.resultTestSeries2 != null && SubjectiveResultActivity.this.resultTestSeries2.getVideo().getVideo_type().equalsIgnoreCase("7")) {
                        if (SubjectiveResultActivity.this.resultTestSeries2.getVideo().getVideo_type().equalsIgnoreCase("7")) {
                            if (SubjectiveResultActivity.this.resultTestSeries2.getVideo().getIs_drm_protected().equalsIgnoreCase("1")) {
                                SubjectiveResultActivity subjectiveResultActivity2 = SubjectiveResultActivity.this;
                                Helper.GoToVideoCryptActivity(subjectiveResultActivity2, subjectiveResultActivity2.resultTestSeries2.getVideo().getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getVideo_type(), "", SubjectiveResultActivity.this.resultTestSeries2.getVideo().getId(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getVideo_type(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getId(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getTitle(), "0", SubjectiveResultActivity.this.resultTestSeries2.getVideo().getThumbnail_url(), "0", "", "", "0", "", SingleStudy.parentCourseId, "", "0", new ArrayList());
                                return;
                            } else {
                                String video_type = SubjectiveResultActivity.this.resultTestSeries2.getVideo().getVideo_type();
                                SubjectiveResultActivity subjectiveResultActivity3 = SubjectiveResultActivity.this;
                                Helper.GoToLiveAwsVideoActivity(video_type, "", subjectiveResultActivity3, subjectiveResultActivity3.resultTestSeries2.getVideo().getId(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getVideo_type(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getId(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getTitle(), "0", SubjectiveResultActivity.this.resultTestSeries2.getVideo().getThumbnail_url(), "0", "", "", "0", "", SingleStudy.parentCourseId, "", new ArrayList());
                                return;
                            }
                        }
                        String video_type2 = SubjectiveResultActivity.this.resultTestSeries2.getVideo().getVideo_type();
                        SubjectiveResultActivity subjectiveResultActivity4 = SubjectiveResultActivity.this;
                        Helper.GoToLiveAwsVideoActivity(video_type2, "", subjectiveResultActivity4, subjectiveResultActivity4.resultTestSeries2.getVideo().getId(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getVideo_type(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getId(), SubjectiveResultActivity.this.resultTestSeries2.getVideo().getTitle(), "0", SubjectiveResultActivity.this.resultTestSeries2.getVideo().getThumbnail_url(), "0", "", "", "0", "", SingleStudy.parentCourseId, "", new ArrayList());
                        return;
                    }
                    SubjectiveResultActivity subjectiveResultActivity5 = SubjectiveResultActivity.this;
                    Toast.makeText(subjectiveResultActivity5, subjectiveResultActivity5.getResources().getString(R.string.file_not_found), 0).show();
                    return;
                }
                SubjectiveResultActivity subjectiveResultActivity6 = SubjectiveResultActivity.this;
                Toast.makeText(subjectiveResultActivity6, subjectiveResultActivity6.getResources().getString(R.string.file_not_found), 0).show();
            }
        });
        this.checkcopy.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.SubjectiveResultActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SubjectiveResultActivity.this.url == null || SubjectiveResultActivity.this.url.equalsIgnoreCase("")) {
                    Toast.makeText(SubjectiveResultActivity.this, R.string.checked_copy_na, 0).show();
                    return;
                }
                String[] strArrSplit = SubjectiveResultActivity.this.url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                SubjectiveResultActivity subjectiveResultActivity = SubjectiveResultActivity.this;
                Helper.GoToWebViewPDFActivity1(subjectiveResultActivity, subjectiveResultActivity.v_id, SubjectiveResultActivity.this.url, true, strArrSplit[strArrSplit.length - 1], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SubjectiveResultActivity.this.id, "result");
            }
        });
        this.img_testback.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.SubjectiveResultActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SubjectiveResultActivity.this.finish();
            }
        });
        this.networkCall.NetworkAPICall(API.API_subjective_result, "", true, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_subjective_result)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setTest_id((getIntent() == null || !getIntent().hasExtra("test_id")) ? Constants.SUB_TEST_ID : getIntent().getStringExtra("test_id"));
        encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
        return service.API_subjective_result(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonResponse, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_subjective_result)) {
            if (jsonResponse.optString("status").equals("true")) {
                this.resultTestSeries2 = (SubjectiveResultData) new Gson().fromJson(((JSONObject) Objects.requireNonNull(jsonResponse.optJSONObject("data"))).toString(), SubjectiveResultData.class);
                setData();
            } else {
                Toast.makeText(this, jsonResponse.optString("message"), 0).show();
            }
        }
    }

    private void setData() {
        this.url = this.resultTestSeries2.getSolutions();
        this.title1.setText(this.resultTestSeries2.getTestSeriesName());
        this.rank.setText(getResources().getString(R.string.rank) + this.resultTestSeries2.getRank());
        this.obtained_marks.setText(this.resultTestSeries2.getMarks());
        this.total_marks.setText(this.resultTestSeries2.getTotalMarks());
        if (this.resultTestSeries2.getRemarks() != null && !this.resultTestSeries2.getRemarks().equalsIgnoreCase("")) {
            this.remarksLinearLayout.setVisibility(0);
            this.remarks_description.setText(this.resultTestSeries2.getRemarks());
        }
        if (this.contenttype.contains(Const.SUBJECTIVE_TEST)) {
            if (this.resultTestSeries2.getRank() != null && this.resultTestSeries2.getRank().equalsIgnoreCase("")) {
                this.rank.setVisibility(8);
            } else {
                this.rank.setVisibility(0);
            }
        }
    }
}
