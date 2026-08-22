package com.appnew.android.LiveTest.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.home.Constants;
import com.appnew.android.home.livetest.LiveTestData;
import com.appnew.android.table.TestTable;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.testmodule.activity.ViewSolutionActivity;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class Testclassadapter extends RecyclerView.Adapter<Livetestviewholder> implements NetworkCall.MyNetworkCallBack {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Activity activity;
    private String attemptOrReAttempt;
    BottomSetting bottomSetting;
    private String course_id;
    private boolean isSSCpattern;
    int lang;
    String[] langIds;
    LeftMenu leftMenu;
    private String quiz_id;
    private String quiz_name;
    private OnTestEndedListener testEndedListener;
    ThemeSettings themeSettings;
    Long time;
    Long time2;
    private OnTestTimerExpiredListener timerExpiredListener;
    private String totalQuestion;
    UtkashRoom utkashRoom;
    boolean visibilty_status;
    List<LiveTestData> data = new ArrayList();
    boolean isReAttemptOrPractice = false;
    private String first_attempt = "1";
    private String result_date = "";
    private String test_submission = "";
    LiveTestData liveTestData = new LiveTestData();
    private int STORAGE_PERMISSION_TYPE = 3;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;

    public interface OnTestEndedListener {
        void onTestEnded();
    }

    public interface OnTestTimerExpiredListener {
        void onTimerExpired();
    }

    private void setScholarshipTest() {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public void setOnTestTimerExpiredListener(OnTestTimerExpiredListener listener) {
        this.timerExpiredListener = listener;
    }

    public void setOnTestEndedListener(OnTestEndedListener listener) {
        this.testEndedListener = listener;
    }

    public Testclassadapter(Activity activity, List<LiveTestData> data, boolean visibilty_status, Long time2) {
        this.visibilty_status = true;
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.isSSCpattern = false;
        this.langIds = new String[]{"1"};
        this.activity = activity;
        this.visibilty_status = visibilty_status;
        this.time = Long.valueOf(MakeMyExam.getTime_server());
        this.time2 = time2;
        for (LiveTestData liveTestData : data) {
            if (liveTestData.getCat_type() != null && liveTestData.getCat_type().equalsIgnoreCase("3")) {
                if (liveTestData.getIs_test_purchased().equalsIgnoreCase("1")) {
                    this.data.add(liveTestData);
                }
            } else {
                this.data.add(liveTestData);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Livetestviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (this.themeSettings != null) {
            this.themeSettings = this.utkashRoom.getthemeSettingdao().data();
            this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
        return new Livetestviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_class_adapter, parent, false));
    }

    /* JADX WARN: Type inference failed for: r0v183, types: [com.appnew.android.LiveTest.Adapter.Testclassadapter$1] */
    /* JADX WARN: Type inference failed for: r0v90, types: [com.appnew.android.LiveTest.Adapter.Testclassadapter$2] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final Livetestviewholder holder, final int position) {
        long j;
        long j2;
        long j3;
        int i;
        long j4;
        int i2;
        int i3;
        if (BuildConfig.FLAVOR.equalsIgnoreCase("mittalCommerceClasses")) {
            holder.marks.setBackground(this.activity.getResources().getDrawable(R.drawable.primary_bg_round));
        }
        holder.title.setText(this.data.get(position).getTestSeriesName());
        holder.c_name.setText(this.data.get(position).getCourse_name());
        holder.liveIV.setVisibility(8);
        if (this.data.get(position).getCat_type() != null && this.data.get(position).getCat_type().equalsIgnoreCase("3")) {
            holder.test_mode_tv.setVisibility(0);
            if (this.data.get(position).getMode() != null && this.data.get(position).getMode().equalsIgnoreCase("1")) {
                holder.test_mode_tv.setText("Offline");
            } else {
                holder.test_mode_tv.setText("Online");
            }
        } else {
            holder.test_mode_tv.setVisibility(8);
        }
        if (Helper.isShowShareButton(this.leftMenu)) {
            holder.share.setVisibility(0);
        } else {
            holder.share.setVisibility(8);
        }
        if (!this.data.get(position).getStartDate().equalsIgnoreCase("0")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US);
            j = 1000;
            j3 = Long.parseLong(this.data.get(position).getStartDate()) * 1000;
            String str = simpleDateFormat.format(new Date(j3));
            holder.date_tv.setVisibility(0);
            j2 = 0;
            holder.date_tv.setText(this.activity.getResources().getString(R.string.start) + "" + Helper.changeAMPM(str));
        } else {
            j = 1000;
            j2 = 0;
            holder.date_tv.setVisibility(8);
            j3 = 0;
        }
        if (!this.data.get(position).getEndDate().equalsIgnoreCase("0")) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US);
            j4 = Long.parseLong(this.data.get(position).getEndDate()) * j;
            String str2 = simpleDateFormat2.format(new Date(j4));
            holder.endDate_tv.setVisibility(0);
            holder.endDate_tv.setText(this.activity.getResources().getString(R.string.end) + Helper.changeAMPM(str2));
            i = 8;
        } else {
            i = 8;
            holder.endDate_tv.setVisibility(8);
            j4 = j2;
        }
        holder.forward.setVisibility(i);
        if (this.data.get(position).getSetType().equalsIgnoreCase("1")) {
            holder.share.setVisibility(0);
        } else if (this.data.get(position).getSetType().equalsIgnoreCase("3")) {
            holder.share.setVisibility(8);
        }
        if (this.data.get(position).getSetType().equalsIgnoreCase("1") && this.visibilty_status) {
            setResetLayerVisibility(holder, position);
            holder.subjectBTNLL.setVisibility(8);
        } else if (this.data.get(position).getSetType().equalsIgnoreCase("3") && this.visibilty_status) {
            holder.layout_test.setVisibility(8);
            holder.subjectBTNLL.setVisibility(0);
            if (this.data.get(position).getAttempt() == null || this.data.get(position).getAttempt().equalsIgnoreCase("0")) {
                holder.upload.setText("Upload");
            } else {
                holder.upload.setText("View");
            }
        } else if (this.data.get(position).getSetType().equalsIgnoreCase("0") && this.visibilty_status) {
            setResetLayerVisibility(holder, position);
            holder.subjectBTNLL.setVisibility(8);
        } else if (this.data.get(position).getSetType().equalsIgnoreCase("8") && this.visibilty_status) {
            setResetLayerVisibility(holder, position);
            holder.subjectBTNLL.setVisibility(8);
        }
        holder.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, view);
            }
        });
        if (this.visibilty_status) {
            if (this.data.get(position).getState().equals("1")) {
                UtkashRoom.getAppDatabase(this.activity).getTestDao().delete_test_data(MakeMyExam.userId, this.data.get(position).getId());
                if (LivetestActivity.view_pager.getCurrentItem() == 2) {
                    if (this.data.get(position).getResultDate().equalsIgnoreCase("1") || this.data.get(position).getResultDate().equalsIgnoreCase("0") || this.data.get(position).getResultDate().equalsIgnoreCase("")) {
                        if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result1));
                        } else {
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                        }
                        holder.show_rank.setVisibility(0);
                    } else if (MakeMyExam.getTime_server() >= Long.parseLong(this.data.get(position).getResultDate()) * j) {
                        if (!this.data.get(position).getEndDate().equalsIgnoreCase("0") && Long.parseLong(this.data.get(position).getEndDate()) < 1640066737) {
                            holder.show_rank.setVisibility(8);
                            if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result1));
                            } else {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                            }
                        } else {
                            holder.show_rank.setVisibility(0);
                            if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result1));
                            } else {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                            }
                        }
                    } else {
                        if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result1));
                        } else {
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                        }
                        holder.show_rank.setVisibility(0);
                    }
                } else if (Helper.isTestResume(this.data.get(position).getSetType())) {
                    if (this.data.get(position).getAttempt().equalsIgnoreCase("0")) {
                        if (this.data.get(position).getState() != null && this.data.get(position).getState().equalsIgnoreCase("0")) {
                            holder.testResume.setVisibility(0);
                            holder.attemp.setVisibility(8);
                            if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                            } else {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                            }
                            holder.show_rank.setVisibility(0);
                        } else if (this.data.get(position).getResultDate().equalsIgnoreCase("1") || this.data.get(position).getResultDate().equalsIgnoreCase("0") || this.data.get(position).getResultDate().equalsIgnoreCase("")) {
                            if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                            } else {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                            }
                            holder.show_rank.setVisibility(0);
                        } else if (MakeMyExam.getTime_server() >= Long.parseLong(this.data.get(position).getResultDate()) * j) {
                            holder.show_rank.setVisibility(0);
                            if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                            } else {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                            }
                        } else {
                            holder.show_rank.setVisibility(0);
                            if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                            } else {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                            }
                        }
                    } else if (this.data.get(position).getResultDate().equalsIgnoreCase("1") || this.data.get(position).getResultDate().equalsIgnoreCase("0") || this.data.get(position).getResultDate().equalsIgnoreCase("")) {
                        holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                        holder.show_rank.setVisibility(0);
                    } else if (MakeMyExam.getTime_server() >= Long.parseLong(this.data.get(position).getResultDate()) * j) {
                        holder.show_rank.setVisibility(0);
                        if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                        } else {
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                        }
                    } else {
                        holder.show_rank.setVisibility(0);
                        if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                        } else {
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                        }
                    }
                } else if (this.data.get(position).getResultDate().equalsIgnoreCase("1") || this.data.get(position).getResultDate().equalsIgnoreCase("0") || this.data.get(position).getResultDate().equalsIgnoreCase("")) {
                    if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                        holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                    } else {
                        holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                    }
                    holder.show_rank.setVisibility(0);
                } else if (MakeMyExam.getTime_server() >= Long.parseLong(this.data.get(position).getResultDate()) * j) {
                    holder.show_rank.setVisibility(0);
                    if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                        holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                    } else {
                        holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                    }
                } else {
                    holder.show_rank.setVisibility(0);
                    if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                        holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                    } else {
                        holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                    }
                }
                if (!this.data.get(holder.getAbsoluteAdapterPosition()).getIs_reattempt().equalsIgnoreCase("0")) {
                    if (Helper.isTestResume(this.data.get(position).getSetType())) {
                        if (this.data.get(position).getAttempt().equalsIgnoreCase("0")) {
                            if (this.data.get(position).getState() != null && this.data.get(position).getState().equalsIgnoreCase("0")) {
                                holder.testResume.setVisibility(0);
                                i2 = 8;
                                holder.attemp.setVisibility(8);
                                holder.show_rank.setVisibility(8);
                            } else if (LivetestActivity.view_pager.getCurrentItem() > 0) {
                                holder.attemp.setVisibility(8);
                                holder.practice.setVisibility(0);
                                i2 = 8;
                            } else {
                                holder.attemp.setVisibility(0);
                                holder.attemp.setText(this.activity.getResources().getString(R.string.re_attempt));
                                i2 = 8;
                                holder.practice.setVisibility(8);
                            }
                        } else if (LivetestActivity.view_pager.getCurrentItem() > 0) {
                            holder.attemp.setVisibility(8);
                            holder.practice.setVisibility(0);
                            i2 = 8;
                        } else {
                            holder.attemp.setVisibility(0);
                            holder.attemp.setText(this.activity.getResources().getString(R.string.re_attempt));
                            i2 = 8;
                            holder.practice.setVisibility(8);
                        }
                    } else if (LivetestActivity.view_pager.getCurrentItem() > 0) {
                        holder.attemp.setVisibility(8);
                        holder.practice.setVisibility(0);
                        i2 = 8;
                    } else {
                        holder.attemp.setVisibility(0);
                        holder.attemp.setText(this.activity.getResources().getString(R.string.re_attempt));
                        i2 = 8;
                        holder.practice.setVisibility(8);
                    }
                } else if (LivetestActivity.view_pager.getCurrentItem() == 0) {
                    if (Helper.isTestResume(this.data.get(position).getSetType()) && this.data.get(position).getAttempt().equalsIgnoreCase("0")) {
                        if (this.data.get(position).getState() != null && this.data.get(position).getState().equalsIgnoreCase("0")) {
                            holder.testResume.setVisibility(0);
                            i2 = 8;
                            holder.attemp.setVisibility(8);
                            holder.practice.setVisibility(8);
                        } else {
                            holder.attemp.setVisibility(0);
                            holder.attemp.setText(this.activity.getResources().getString(R.string.attempted_));
                            i2 = 8;
                            holder.practice.setVisibility(8);
                        }
                    } else {
                        i2 = 8;
                        holder.attemp.setVisibility(0);
                        holder.attemp.setText(this.activity.getResources().getString(R.string.attempted_));
                        holder.practice.setVisibility(8);
                    }
                } else {
                    i2 = 8;
                    holder.attemp.setVisibility(8);
                }
                if (LivetestActivity.view_pager.getCurrentItem() > 0) {
                    holder.attemp.setVisibility(i2);
                    i3 = 0;
                    holder.practice.setVisibility(0);
                } else {
                    i3 = 0;
                    holder.practice.setVisibility(i2);
                }
                if (j4 < MakeMyExam.getTime_server()) {
                    holder.learn.setVisibility(i3);
                } else {
                    holder.learn.setVisibility(i2);
                }
            } else if (!this.data.get(position).getState().equalsIgnoreCase("") && !this.data.get(position).getState().equalsIgnoreCase("0")) {
                i2 = 8;
            } else if (MakeMyExam.getTime_server() > j4) {
                holder.learn.setVisibility(0);
                if (LivetestActivity.view_pager.getCurrentItem() > 0) {
                    holder.practice.setVisibility(0);
                } else {
                    holder.practice.setVisibility(8);
                }
                if (LivetestActivity.view_pager.getCurrentItem() == 2) {
                    if (this.data.get(position).getResultDate().equalsIgnoreCase("1") || this.data.get(position).getResultDate().equalsIgnoreCase("0") || this.data.get(position).getResultDate().equalsIgnoreCase("")) {
                        if (!this.data.get(position).getSetType().equalsIgnoreCase("8") || this.data.get(position).getState().equalsIgnoreCase("1")) {
                            holder.show_rank.setVisibility(0);
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                        } else {
                            holder.show_rank.setVisibility(8);
                        }
                    } else if (MakeMyExam.getTime_server() > Long.parseLong(this.data.get(position).getResultDate()) * j) {
                        if (!this.data.get(position).getEndDate().equalsIgnoreCase("0") && Long.parseLong(this.data.get(position).getEndDate()) < 1640066737) {
                            holder.show_rank.setVisibility(8);
                            holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                        } else if (this.data.get(position).getSetType().equalsIgnoreCase("8")) {
                            if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                                holder.show_rank.setVisibility(0);
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                            } else {
                                holder.show_rank.setVisibility(8);
                            }
                        } else {
                            holder.show_rank.setVisibility(0);
                            if (this.data.get(position).getState().equalsIgnoreCase("1")) {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result1));
                            } else {
                                holder.show_rank.setText(this.activity.getResources().getString(R.string.view_rank));
                            }
                        }
                    } else {
                        holder.show_rank.setVisibility(8);
                    }
                } else if (this.data.get(position).getSetType().equalsIgnoreCase("8")) {
                    if (this.data.get(position).getState() != null && this.data.get(position).getState().equalsIgnoreCase("1")) {
                        holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                        holder.show_rank.setVisibility(0);
                    } else {
                        holder.show_rank.setVisibility(8);
                    }
                } else if (this.data.get(position).getResultDate().equalsIgnoreCase("1") || this.data.get(position).getResultDate().equalsIgnoreCase("0") || this.data.get(position).getResultDate().equalsIgnoreCase("") || MakeMyExam.getTime_server() > Long.parseLong(this.data.get(position).getResultDate()) * j) {
                    holder.show_rank.setText(this.activity.getResources().getString(R.string.view_result));
                    holder.show_rank.setVisibility(0);
                } else {
                    holder.show_rank.setVisibility(8);
                }
                if (LivetestActivity.view_pager.getCurrentItem() <= 0 && !this.data.get(holder.getAbsoluteAdapterPosition()).getIs_reattempt().equalsIgnoreCase("0")) {
                    holder.attemp.setVisibility(0);
                    holder.attemp.setText(this.activity.getResources().getString(R.string.re_attempt_));
                    i2 = 8;
                } else {
                    i2 = 8;
                    holder.attemp.setVisibility(8);
                }
            } else if (MakeMyExam.getTime_server() > j3 && MakeMyExam.getTime_server() < j4) {
                holder.show_rank.setVisibility(8);
                holder.learn.setVisibility(8);
                if (LivetestActivity.view_pager.getCurrentItem() == 2) {
                    holder.practice.setVisibility(0);
                } else {
                    holder.practice.setVisibility(8);
                }
                TestTable testTableTest_data = UtkashRoom.getAppDatabase(this.activity).getTestDao().test_data(this.data.get(holder.getAbsoluteAdapterPosition()).getId(), MakeMyExam.userId);
                if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                    holder.attemp.setVisibility(0);
                    holder.attemp.setText(testTableTest_data.getStatus());
                } else if (Helper.isTestResume(this.data.get(position).getSetType()) && this.data.get(position).getAttempt().equalsIgnoreCase("0") && this.data.get(position).getState() != null && this.data.get(position).getState().equalsIgnoreCase("0")) {
                    holder.testResume.setVisibility(0);
                    holder.attemp.setVisibility(8);
                    holder.attemp.setText(this.activity.getResources().getString(R.string.attempt));
                } else {
                    holder.attemp.setVisibility(0);
                    holder.attemp.setText(this.activity.getResources().getString(R.string.attempt));
                    holder.testResume.setVisibility(8);
                }
                if (holder.timer != null) {
                    holder.timer.cancel();
                }
                long time_server = j4 - MakeMyExam.getTime_server();
                if (time_server > j2) {
                    holder.timer = new CountDownTimer(time_server, 1000L) { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            if (Testclassadapter.this.testEndedListener != null) {
                                Testclassadapter.this.testEndedListener.onTestEnded();
                                Testclassadapter.this.testEndedListener = null;
                            }
                        }
                    }.start();
                }
                i2 = 8;
            } else {
                i2 = 8;
                holder.attemp.setVisibility(8);
                holder.learn.setVisibility(8);
                holder.show_rank.setVisibility(8);
                holder.practice.setVisibility(8);
            }
            holder.forward.setVisibility(i2);
            holder.startedin.setVisibility(i2);
            holder.time.setVisibility(i2);
        } else {
            holder.layout_test.setVisibility(0);
            holder.startedin.setVisibility(0);
            holder.time.setVisibility(0);
            holder.forward.setVisibility(8);
            holder.show_rank.setVisibility(8);
            holder.learn.setVisibility(8);
            holder.practice.setVisibility(8);
            holder.attemp.setVisibility(8);
            holder.timerr = j2;
            holder.timerr = Long.parseLong(this.data.get(position).getStartDate()) - this.time2.longValue();
            holder.timerr *= holder.timecount;
            holder.timer = new CountDownTimer(holder.timerr, holder.timecount) { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.2
                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    holder.time.setText(Testclassadapter.this.concerter(millisUntilFinished));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    holder.time.setText("00:00:00");
                    Testclassadapter.this.notifyadap(holder, position);
                    if (Testclassadapter.this.timerExpiredListener != null) {
                        Testclassadapter.this.timerExpiredListener.onTimerExpired();
                    }
                }
            }.start();
        }
        if (!TextUtils.isEmpty(this.data.get(position).getImage())) {
            setThumbAccordingRatio(this.data.get(position).getImage(), holder.courseImage);
        } else {
            holder.courseImage.setImageResource(R.mipmap.square_placeholder_new);
        }
        holder.practice.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$3(position, view);
            }
        });
        holder.paper.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (System.currentTimeMillis() < Long.parseLong(Testclassadapter.this.data.get(position).getStartDate()) * 1000) {
                    Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(Testclassadapter.this.data.get(position).getStartDate()) * 1000)), 0).show();
                    return;
                }
                if (!Helper.isConnected(Testclassadapter.this.activity)) {
                    Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                    return;
                }
                if (!Testclassadapter.this.data.get(position).getQuestion().equalsIgnoreCase("")) {
                    Constants.SUB_TEST_ID = Testclassadapter.this.data.get(position).getId();
                    Constants.Live_TEST_COURSEID = Testclassadapter.this.data.get(position).getCourseId();
                    Helper.GoToWebViewPDFActivity(Testclassadapter.this.activity, Testclassadapter.this.data.get(position).getId(), Testclassadapter.this.data.get(position).getQuestion(), true, Testclassadapter.this.data.get(position).getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r13.length - 1].split("\\.")[0], Testclassadapter.this.data.get(position).getCourseId(), Testclassadapter.this.data.get(position).getIs_bookmarked(), Testclassadapter.this.data.get(position).getFile_type(), "", Const.QUESTION);
                    return;
                }
                Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.file_not_found), 0).show();
            }
        });
        holder.upload.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (holder.upload.getText().toString().equalsIgnoreCase("View")) {
                    Intent intent = new Intent(Testclassadapter.this.activity, (Class<?>) PdfDetailScreen.class);
                    intent.putExtra("url", Testclassadapter.this.data.get(position).getAnswersByStudent());
                    intent.putExtra("file_type", Testclassadapter.this.data.get(position).getFile_type());
                    Testclassadapter.this.activity.startActivity(intent);
                    return;
                }
                if (System.currentTimeMillis() < Long.parseLong(Testclassadapter.this.data.get(position).getStartDate()) * 1000) {
                    Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(Testclassadapter.this.data.get(position).getStartDate()) * 1000)), 0).show();
                    return;
                }
                if (!Helper.isConnected(Testclassadapter.this.activity)) {
                    Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                    return;
                }
                if (System.currentTimeMillis() < Long.parseLong(Testclassadapter.this.data.get(position).getEndDate()) * 1000) {
                    if (Testclassadapter.this.data.get(position).getUpload_allowed() != null && Testclassadapter.this.data.get(position).getUpload_allowed().equalsIgnoreCase("1")) {
                        Constants.SUB_TEST_ID = Testclassadapter.this.data.get(position).getId();
                        Constants.Live_TEST_COURSEID = Testclassadapter.this.data.get(position).getCourseId();
                        Testclassadapter.this.checkStoragePermission();
                        return;
                    }
                    Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
                    return;
                }
                Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.you_cant_upload_message), 0).show();
            }
        });
        holder.booklet.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(Testclassadapter.this.data.get(position).getResultDate()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(Testclassadapter.this.activity)) {
                        Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                        return;
                    }
                    if (!Testclassadapter.this.data.get(position).getAnswers().equalsIgnoreCase("")) {
                        Constants.SUB_TEST_ID = Testclassadapter.this.data.get(position).getId();
                        Constants.Live_TEST_COURSEID = Testclassadapter.this.data.get(position).getCourseId();
                        Helper.GoToWebViewPDFActivity(Testclassadapter.this.activity, Testclassadapter.this.data.get(position).getId(), Testclassadapter.this.data.get(position).getAnswers(), true, Testclassadapter.this.data.get(position).getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r13.length - 1].split("\\.")[0], Testclassadapter.this.data.get(position).getCourseId(), Testclassadapter.this.data.get(position).getIs_bookmarked(), Testclassadapter.this.data.get(position).getFile_type(), "", Const.ANSWER);
                        return;
                    }
                    Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.file_not_found), 0).show();
                    return;
                }
                Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(Testclassadapter.this.data.get(position).getResultDate()) * 1000)), 0).show();
            }
        });
        holder.marks.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(Testclassadapter.this.data.get(position).getResultDate()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(Testclassadapter.this.activity)) {
                        Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                        return;
                    }
                    Constants.SUB_TEST_ID = Testclassadapter.this.data.get(position).getId();
                    Constants.Live_TEST_COURSEID = Testclassadapter.this.data.get(position).getCourseId();
                    Helper.GoToSubjectiveResultActivity(Testclassadapter.this.activity, Testclassadapter.this.data.get(position).getSolutions(), Testclassadapter.this.data.get(position).getTestSeriesName(), Testclassadapter.this.data.get(position).getCourseId(), Testclassadapter.this.data.get(position).getId(), Const.SUBJECTIVE_TEST);
                    return;
                }
                Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(Testclassadapter.this.data.get(position).getResultDate()) * 1000)), 0).show();
            }
        });
        holder.attemp.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$8(position, holder, view);
            }
        });
        holder.testResume.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$9(position, holder, view);
            }
        });
        holder.learn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$10(holder, position, view);
            }
        });
        holder.show_rank.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$11(holder, position, view);
            }
        });
        if (this.data.get(position).getSetType() == null || !this.data.get(position).getSetType().equalsIgnoreCase("8")) {
            return;
        }
        holder.learn.setVisibility(8);
        holder.attemp.setVisibility(8);
        holder.practice.setVisibility(8);
        holder.share.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(Livetestviewholder livetestviewholder, View view) {
        sharelivetestolink(livetestviewholder.getAbsoluteAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$3(int i, View view) {
        this.course_id = this.data.get(i).getCourseId();
        SharedPreference.getInstance().putString("id", this.course_id);
        this.quiz_id = this.data.get(i).getId();
        this.quiz_name = this.data.get(i).getTestSeriesName();
        this.totalQuestion = this.data.get(i).getTotalQuestions();
        this.test_submission = "1";
        this.result_date = this.data.get(i).getResultDate();
        this.first_attempt = "0";
        LiveTestData liveTestData = this.data.get(i);
        this.liveTestData = liveTestData;
        Helper.resolveTestPattern(this.activity, liveTestData.getTest_pattern(), new Runnable() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onBindViewHolder$1();
            }
        }, new Runnable() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onBindViewHolder$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1() {
        this.isSSCpattern = false;
        startTestAPI("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$2() {
        this.isSSCpattern = true;
        startTestAPI("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$8(int i, Livetestviewholder livetestviewholder, final View view) {
        view.setClickable(false);
        this.course_id = this.data.get(i).getCourseId();
        SharedPreference.getInstance().putString("id", this.course_id);
        if (livetestviewholder.attemp.getText().toString().equalsIgnoreCase(Const.ATTEMPT)) {
            this.attemptOrReAttempt = Const.ATTEMPT;
            this.quiz_id = this.data.get(i).getId();
            this.quiz_name = this.data.get(i).getTestSeriesName();
            this.totalQuestion = this.data.get(i).getTotalQuestions();
            this.result_date = this.data.get(i).getResultDate();
            this.first_attempt = "1";
            this.test_submission = this.data.get(i).getSubmission_type();
            LiveTestData liveTestData = this.data.get(i);
            this.liveTestData = liveTestData;
            Helper.resolveTestPattern(this.activity, liveTestData.getTest_pattern(), new Runnable() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onBindViewHolder$4();
                }
            }, new Runnable() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onBindViewHolder$5();
                }
            });
        } else if (livetestviewholder.attemp.getText().toString().equalsIgnoreCase("Re-attempt")) {
            String is_reattempt = this.data.get(i).getIs_reattempt();
            if (is_reattempt != null && !is_reattempt.isEmpty() && !is_reattempt.equalsIgnoreCase("0") && !is_reattempt.equalsIgnoreCase("1")) {
                try {
                    if (System.currentTimeMillis() > Long.parseLong(is_reattempt) * 1000) {
                        Snackbar.make(livetestviewholder.itemView, "Re-attempt time expired", -1).show();
                        view.setClickable(true);
                        return;
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            this.attemptOrReAttempt = "Re-attempt";
            this.quiz_id = this.data.get(i).getId();
            this.quiz_name = this.data.get(i).getTestSeriesName();
            this.totalQuestion = this.data.get(i).getTotalQuestions();
            this.result_date = this.data.get(i).getResultDate();
            this.test_submission = "1";
            this.first_attempt = "0";
            LiveTestData liveTestData2 = this.data.get(i);
            this.liveTestData = liveTestData2;
            Helper.resolveTestPattern(this.activity, liveTestData2.getTest_pattern(), new Runnable() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onBindViewHolder$6();
                }
            }, new Runnable() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onBindViewHolder$7();
                }
            });
        } else if (livetestviewholder.attemp.getText().toString().equalsIgnoreCase("Attempted")) {
            if (this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate() != null && !this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate().equalsIgnoreCase("0") && !this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate().equalsIgnoreCase("1") && !this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate().equalsIgnoreCase("")) {
                Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate()) * 1000)), -1).show();
            } else if (UtkashRoom.getAppDatabase(this.activity).getTestDao().is_test_exit(this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getId(), MakeMyExam.userId)) {
                Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
            } else {
                Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.test_is_already_submitted), -1).show();
            }
        }
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.7
            @Override // java.lang.Runnable
            public void run() {
                view.setClickable(true);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$4() {
        this.isSSCpattern = false;
        startTestAPI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$5() {
        this.isSSCpattern = true;
        startTestAPI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$6() {
        this.isSSCpattern = false;
        startTestAPI("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$7() {
        this.isSSCpattern = true;
        startTestAPI("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$9(int i, Livetestviewholder livetestviewholder, View view) {
        this.course_id = this.data.get(i).getCourseId();
        SharedPreference.getInstance().putString("id", this.course_id);
        if (livetestviewholder.testResume.getText().toString().equalsIgnoreCase("Resume")) {
            this.quiz_id = this.data.get(i).getId();
            if (this.data.get(i).getLangUsed().equalsIgnoreCase("")) {
                this.lang = Integer.parseInt("1");
            } else {
                this.lang = Integer.parseInt(this.data.get(i).getLangUsed());
            }
            this.quiz_name = this.data.get(i).getTestSeriesName();
            this.totalQuestion = this.data.get(i).getTotalQuestions();
            this.result_date = this.data.get(i).getResultDate();
            this.first_attempt = "0";
            this.test_submission = this.data.get(i).getSubmission_type();
            this.liveTestData = this.data.get(i);
            startResumeTestAPI();
            return;
        }
        if (livetestviewholder.attemp.getText().toString().equalsIgnoreCase("Attempted")) {
            if (this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate() != null && !this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate().equalsIgnoreCase("0") && !this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate().equalsIgnoreCase("1") && !this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate().equalsIgnoreCase("")) {
                Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate()) * 1000)), -1).show();
            } else if (UtkashRoom.getAppDatabase(this.activity).getTestDao().is_test_exit(this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getId(), MakeMyExam.userId)) {
                Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
            } else {
                Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.test_is_already_submitted), -1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$10(Livetestviewholder livetestviewholder, int i, View view) {
        if (this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getState().equalsIgnoreCase("1")) {
            this.course_id = this.data.get(i).getCourseId();
            SharedPreference.getInstance().putString("id", this.course_id);
            this.quiz_id = this.data.get(i).getId();
            this.quiz_name = this.data.get(i).getTestSeriesName();
            this.totalQuestion = this.data.get(i).getTotalQuestions();
            result_without_submit(this.quiz_id, this.course_id, "1", this.quiz_name);
            return;
        }
        this.course_id = this.data.get(i).getCourseId();
        SharedPreference.getInstance().putString("id", this.course_id);
        this.quiz_id = this.data.get(i).getId();
        this.quiz_name = this.data.get(i).getTestSeriesName();
        this.totalQuestion = this.data.get(i).getTotalQuestions();
        result_without_submit(this.quiz_id, this.course_id, "0", this.quiz_name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$11(Livetestviewholder livetestviewholder, int i, View view) {
        if (this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getState().equalsIgnoreCase("1")) {
            this.course_id = this.data.get(i).getCourseId();
            SharedPreference.getInstance().putString("id", this.course_id);
            this.quiz_id = this.data.get(i).getId();
            this.quiz_name = this.data.get(i).getTestSeriesName();
            this.totalQuestion = this.data.get(i).getTotalQuestions();
            if (this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate().equalsIgnoreCase("0") || this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate().equalsIgnoreCase("") || this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate().equalsIgnoreCase("1")) {
                if (LivetestActivity.view_pager.getCurrentItem() == 2) {
                    Intent intent = new Intent(this.activity, (Class<?>) QuizActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent.putExtra("status", this.quiz_id);
                    intent.putExtra("name", this.quiz_name);
                    intent.putExtra("mode", this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getMode());
                    intent.putExtra("first_attempt", "1");
                    Helper.gotoActivity(intent, this.activity);
                    return;
                }
                Intent intent2 = new Intent(this.activity, (Class<?>) QuizActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                intent2.putExtra("status", this.quiz_id);
                intent2.putExtra("name", this.quiz_name);
                intent2.putExtra("mode", this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getMode());
                intent2.putExtra("first_attempt", "1");
                Helper.gotoActivity(intent2, this.activity);
                return;
            }
            if (LivetestActivity.view_pager.getCurrentItem() == 2) {
                if (MakeMyExam.getTime_server() >= Long.parseLong(this.data.get(i).getResultDate()) * 1000) {
                    Intent intent3 = new Intent(this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent3.putExtra("status", this.quiz_id);
                    intent3.putExtra("name", this.quiz_name);
                    intent3.putExtra("mode", this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getMode());
                    intent3.putExtra("first_attempt", "1");
                    this.activity.startActivity(intent3);
                    return;
                }
                Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate()) * 1000)), -1).show();
                return;
            }
            if (MakeMyExam.getTime_server() >= Long.parseLong(this.data.get(i).getResultDate()) * 1000) {
                Intent intent4 = new Intent(this.activity, (Class<?>) QuizActivity.class);
                intent4.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                intent4.putExtra("status", this.quiz_id);
                intent4.putExtra("name", this.quiz_name);
                intent4.putExtra("mode", this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getMode());
                intent4.putExtra("first_attempt", "1");
                this.activity.startActivity(intent4);
                return;
            }
            Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate()) * 1000)), -1).show();
            return;
        }
        this.course_id = this.data.get(i).getCourseId();
        SharedPreference.getInstance().putString("id", this.course_id);
        this.quiz_id = this.data.get(i).getId();
        this.quiz_name = this.data.get(i).getTestSeriesName();
        this.totalQuestion = this.data.get(i).getTotalQuestions();
        if (LivetestActivity.view_pager.getCurrentItem() == 2) {
            if (MakeMyExam.getTime_server() >= Long.parseLong(this.data.get(i).getResultDate()) * 1000) {
                Intent intent5 = new Intent(this.activity, (Class<?>) QuizActivity.class);
                intent5.putExtra(Const.FRAG_TYPE, "leader_board");
                intent5.putExtra("status", this.quiz_id);
                intent5.putExtra("name", this.quiz_name);
                this.activity.startActivity(intent5);
                return;
            }
            Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.you_have_miss_the_test_and_rank_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate()) * 1000)), -1).show();
            return;
        }
        if (!this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getSetType().equalsIgnoreCase("8")) {
            if (MakeMyExam.getTime_server() >= Long.parseLong(this.data.get(i).getResultDate()) * 1000) {
                Intent intent6 = new Intent(this.activity, (Class<?>) QuizActivity.class);
                intent6.putExtra(Const.FRAG_TYPE, "leader_board");
                intent6.putExtra("status", this.quiz_id);
                intent6.putExtra("name", this.quiz_name);
                this.activity.startActivity(intent6);
                return;
            }
            Snackbar.make(livetestviewholder.itemView, this.activity.getResources().getString(R.string.you_have_miss_the_test_and_rank_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getResultDate()) * 1000)), -1).show();
            return;
        }
        if (MakeMyExam.getTime_server() >= Long.parseLong(this.data.get(i).getResultDate()) * 1000) {
            Intent intent7 = new Intent(this.activity, (Class<?>) QuizActivity.class);
            intent7.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
            intent7.putExtra("status", this.quiz_id);
            intent7.putExtra("name", this.quiz_name);
            intent7.putExtra("mode", this.data.get(livetestviewholder.getAbsoluteAdapterPosition()).getMode());
            intent7.putExtra("first_attempt", "1");
            this.activity.startActivity(intent7);
        }
    }

    private void setResetLayerVisibility(Livetestviewholder holder, int position) {
        if (this.data.get(position).getCat_type() != null && this.data.get(position).getCat_type().equalsIgnoreCase("3")) {
            if (this.data.get(position).getIs_test_purchased() != null && this.data.get(position).getIs_test_purchased().equalsIgnoreCase("1")) {
                if (this.data.get(position).getMode() != null && this.data.get(position).getMode().equalsIgnoreCase("1")) {
                    holder.layout_test.setVisibility(8);
                    return;
                } else {
                    holder.layout_test.setVisibility(0);
                    return;
                }
            }
            holder.layout_test.setVisibility(8);
            return;
        }
        holder.layout_test.setVisibility(0);
    }

    private void setThumbRatio(RelativeLayout rlThum) {
        Display defaultDisplay = ((WindowManager) this.activity.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        ViewGroup.LayoutParams layoutParams = rlThum.getLayoutParams();
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) {
            return;
        }
        layoutParams.height = (int) (Helper.grideHeight * displayMetrics.scaledDensity);
        layoutParams.width = (int) (Helper.grideWidth * displayMetrics.scaledDensity);
        rlThum.setLayoutParams(layoutParams);
    }

    private void sharelivetestolink(int adapterPosition) {
        Helper.shareTestg(this.activity, this.data.get(adapterPosition).getPayload().getCourse_id(), this.data.get(adapterPosition).getId(), this.data.get(adapterPosition).getPayload().getTopic_id(), this.data.get(adapterPosition).getPayload().getTile_type(), this.data.get(adapterPosition).getPayload().getTile_id(), this.data.get(adapterPosition).getPayload().getRevert_api(), "Test", this.data.get(adapterPosition).getImage(), this.data.get(adapterPosition).getTestSeriesName(), "");
    }

    public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
        if (Helper.isNetworkConnected(this.activity)) {
            Helper.showProgressDialog(this.activity);
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setTest_id(quiz_id);
            encryptionData.setCourse_id(course_id);
            encryptionData.setFirst_attempt(s);
            aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.8
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    JSONObject jSONObject;
                    Helper.dismissProgressDialog();
                    if (response.body() != null) {
                        ResultTestSeries_Report resultTestSeries_Report = null;
                        try {
                            jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                            try {
                                resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(jSONObject.toString(), ResultTestSeries_Report.class);
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            jSONObject = null;
                        }
                        if (resultTestSeries_Report == null) {
                            Helper.showToastSecurity(Testclassadapter.this.activity);
                            return;
                        }
                        try {
                            MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                            if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                Intent intent = new Intent(Testclassadapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                intent.putExtra("name", quiz_name);
                                intent.putExtra("type", "learn");
                                if (!resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                    if (resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                        Testclassadapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                    }
                                } else {
                                    Testclassadapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                }
                                intent.putExtra(Const.LANG, Testclassadapter.this.lang);
                                Helper.gotoActivity(intent, Testclassadapter.this.activity);
                                return;
                            }
                            RetrofitResponse.GetApiData(Testclassadapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Helper.dismissProgressDialog();
                }
            });
            return;
        }
        Activity activity = this.activity;
        Toast.makeText(activity, activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    private void setThumbAccordingRatio(String url, ImageView thumb) {
        Activity activity = this.activity;
        Helper.setThumbnailImage(activity, url, activity.getDrawable(R.mipmap.square_placeholder_new), thumb);
    }

    public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
        if (Helper.isNetworkConnected(this.activity)) {
            Helper.showProgressDialog(this.activity);
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setTest_id(quiz_id);
            encryptionData.setCourse_id(course_id);
            encryptionData.setFirst_attempt(s);
            aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.9
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    JSONObject jSONObject;
                    Helper.dismissProgressDialog();
                    if (response.body() != null) {
                        ResultTestSeries_Report resultTestSeries_Report = null;
                        try {
                            jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                            try {
                                resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(jSONObject.toString(), ResultTestSeries_Report.class);
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            jSONObject = null;
                        }
                        if (resultTestSeries_Report == null) {
                            Helper.showToastSecurity(Testclassadapter.this.activity);
                            return;
                        }
                        try {
                            MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                            if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                if (resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(Testclassadapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            Testclassadapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        Testclassadapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, Testclassadapter.this.lang);
                                    Helper.gotoActivity(intent, Testclassadapter.this.activity);
                                    return;
                                }
                                Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                return;
                            }
                            Helper.dismissProgressDialog();
                            RetrofitResponse.GetApiData(Testclassadapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Helper.dismissProgressDialog();
                }
            });
            return;
        }
        Activity activity = this.activity;
        Toast.makeText(activity, activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.API_GET_TEST_INSTRUCTION_DATA)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setTest_id(this.quiz_id);
            encryptionData.setCourse_id(this.course_id);
            return service.API_GET_TEST_INSTRUCTION_DATA(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.API_GET_INFO_TEST_SERIES)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setTest_id(this.quiz_id);
        encryptionData2.setCourse_id(this.course_id);
        return service.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x025b A[Catch: Exception -> 0x0282, TryCatch #0 {Exception -> 0x0282, blocks: (B:10:0x003f, B:12:0x004f, B:14:0x0052, B:16:0x0058, B:18:0x0062, B:29:0x00a2, B:31:0x00a7, B:33:0x00b1, B:38:0x00c3, B:40:0x00cd, B:47:0x00e3, B:49:0x00ef, B:52:0x0119, B:54:0x0127, B:56:0x0130, B:58:0x0134, B:60:0x014b, B:62:0x0168, B:63:0x016b, B:81:0x0270, B:59:0x0140, B:66:0x01b3, B:68:0x01bd, B:70:0x01cb, B:72:0x01d4, B:74:0x01e7, B:76:0x01fe, B:78:0x021b, B:79:0x021e, B:75:0x01f3, B:80:0x025b, B:20:0x0070, B:23:0x007e, B:25:0x0088, B:27:0x0096, B:82:0x0275), top: B:101:0x003f }] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r22, java.lang.String r23, java.lang.String r24, boolean r25) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.LiveTest.Adapter.Testclassadapter.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    private void pushEvent() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        map.put(AnalyticsConstants.test_name, this.quiz_name);
        map.put("test_id", this.quiz_id);
        map.put(AnalyticsConstants.content_flag, getContentAccess());
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.TEST_ATTEMPT, map);
    }

    private String getContentAccess() {
        LiveTestData liveTestData;
        LiveTestData liveTestData2 = this.liveTestData;
        return ((liveTestData2 == null || TextUtils.isEmpty(liveTestData2.getIs_test_purchased()) || !this.liveTestData.getIs_test_purchased().equals("1")) && (liveTestData = this.liveTestData) != null && !TextUtils.isEmpty(liveTestData.getIsLocked()) && this.liveTestData.getIsLocked().equals("1")) ? "Paid" : "Free";
    }

    public void addItems(List<LiveTestData> newItems) {
        if (newItems == null || newItems.isEmpty()) {
            return;
        }
        int size = this.data.size();
        int i = 0;
        for (LiveTestData liveTestData : newItems) {
            if (liveTestData != null) {
                if (liveTestData.getCat_type() != null && liveTestData.getCat_type().equalsIgnoreCase("3")) {
                    if (liveTestData.getIs_test_purchased() != null && liveTestData.getIs_test_purchased().equalsIgnoreCase("1")) {
                        this.data.add(liveTestData);
                        i++;
                    }
                } else {
                    this.data.add(liveTestData);
                    i++;
                }
            }
        }
        if (i > 0) {
            notifyItemRangeInserted(size, i);
        }
    }

    public class Livetestviewholder extends RecyclerView.ViewHolder {
        TextView attemp;
        Button booklet;
        TextView c_name;
        ImageView courseImage;
        TextView date_tv;
        TextView endDate_tv;
        ImageView forward;
        public LinearLayout layout_test;
        TextView learn;
        ImageView liveIV;
        Button marks;
        Button paper;
        TextView practice;
        ImageView share;
        TextView show_rank;
        TextView startedin;
        public RelativeLayout study_single_itemLL;
        public LinearLayout subjectBTNLL;
        TextView testResume;
        TextView test_mode_tv;
        public RelativeLayout thumbRl;
        TextView time;
        long timecount;
        CountDownTimer timer;
        long timerr;
        TextView title;
        Button upload;

        public Livetestviewholder(View itemView) {
            super(itemView);
            this.timecount = 1000L;
            this.courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            this.thumbRl = (RelativeLayout) itemView.findViewById(R.id.thumbRl);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.forward = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.title = (TextView) itemView.findViewById(R.id.study_item_titleTV);
            this.learn = (TextView) itemView.findViewById(R.id.learn);
            this.c_name = (TextView) itemView.findViewById(R.id.c_name);
            this.time = (TextView) itemView.findViewById(R.id.time);
            this.startedin = (TextView) itemView.findViewById(R.id.startedin);
            this.marks = (Button) itemView.findViewById(R.id.marks);
            this.upload = (Button) itemView.findViewById(R.id.upload);
            this.booklet = (Button) itemView.findViewById(R.id.booklet);
            this.show_rank = (TextView) itemView.findViewById(R.id.show_rank);
            this.attemp = (TextView) itemView.findViewById(R.id.attemp);
            this.testResume = (TextView) itemView.findViewById(R.id.testResume);
            this.practice = (TextView) itemView.findViewById(R.id.practice);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.layout_test = (LinearLayout) itemView.findViewById(R.id.layout_test);
            this.subjectBTNLL = (LinearLayout) itemView.findViewById(R.id.subjectBTNLL);
            this.date_tv = (TextView) itemView.findViewById(R.id.date_tv);
            this.paper = (Button) itemView.findViewById(R.id.paper);
            this.test_mode_tv = (TextView) itemView.findViewById(R.id.test_mode_tv);
            if (!Testclassadapter.this.visibilty_status) {
                this.forward.setVisibility(8);
                this.show_rank.setVisibility(8);
                this.learn.setVisibility(8);
                this.practice.setVisibility(8);
                this.attemp.setVisibility(8);
            }
            this.endDate_tv = (TextView) itemView.findViewById(R.id.endDate_tv);
            this.study_single_itemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
        }
    }

    private void showPopUp(final InstructionData instructionData) {
        Dialog dialog;
        CheckBox checkBox;
        int i;
        View viewInflate = ((LayoutInflater) this.activity.getSystemService("layout_inflater")).inflate(R.layout.popup_basicinfo_quiz_career, (ViewGroup) null, false);
        Dialog dialog2 = new Dialog(this.activity, R.style.CustomAlertDialog);
        dialog2.requestWindowFeature(1);
        dialog2.setCanceledOnTouchOutside(true);
        dialog2.setContentView(viewInflate);
        dialog2.getWindow().setLayout(-1, -1);
        dialog2.show();
        final TestBasicInst testBasic = instructionData.getTestBasic();
        TextView textView = (TextView) viewInflate.findViewById(R.id.quizTitleTV);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.marksTextValueTV);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.section_time);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.numQuesValueTV);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.sectionValueTV);
        final TextView textView5 = (TextView) viewInflate.findViewById(R.id.languageSpinnerTV);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.quizTimeValueTV);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.remarksTV);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.check_box);
        final TextView textView8 = (TextView) viewInflate.findViewById(R.id.generalInstrValueTV);
        Button button = (Button) viewInflate.findViewById(R.id.startQuizBtn);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.sectionListLL);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.general_layout);
        if (TextUtils.isEmpty(testBasic.getLang_id())) {
            dialog = dialog2;
        } else {
            dialog = dialog2;
            this.langIds = testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA);
        }
        if (testBasic.getTest_assets() != null) {
            checkBox = checkBox2;
            if (testBasic.getTest_assets().getHide_inst_time().equalsIgnoreCase("0")) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(4);
            }
        } else {
            checkBox = checkBox2;
        }
        addSectionView(linearLayout2, instructionData);
        if (SharedPreference.getInstance().getBoolean(Const.RE_ATTEMPT)) {
            textView7.setVisibility(8);
        } else {
            textView7.setVisibility(8);
        }
        if (testBasic.getMulti_description().size() > 0) {
            linearLayout3.setVisibility(0);
            if (testBasic.getMulti_description() != null && testBasic.getMulti_description().size() > 0) {
                textView8.setText(Html.fromHtml(testBasic.getMulti_description().get(0).getDescription()));
            }
        } else if (testBasic.getDescription().isEmpty()) {
            linearLayout3.setVisibility(8);
        } else {
            linearLayout3.setVisibility(0);
            textView8.setVisibility(0);
            textView8.setText(Html.fromHtml(testBasic.getDescription()));
        }
        if (!BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
            if (testBasic.getLang_id().length() > 1) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Testclassadapter testclassadapter = Testclassadapter.this;
                        TextView textView9 = textView5;
                        TestBasicInst testBasicInst = testBasic;
                        TextView textView10 = textView8;
                        testclassadapter.showPopMenuForLangauge1(textView9, testBasicInst, textView10, textView10);
                    }
                });
            }
            i = 0;
            if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else {
                if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                }
                i = 0;
            }
        } else {
            if (testBasic.getLang_id().length() > 2) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Testclassadapter.this.showPopMenuForLangauge(textView8, textView5, testBasic);
                    }
                });
            }
            i = 0;
            if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("3")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[2]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("9")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[3]);
                i = 0;
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else {
                i = 0;
                if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("6")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[4]);
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("10")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[5]);
                    i = 0;
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("11")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[6]);
                    i = 0;
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("12")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[7]);
                    i = 0;
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                } else {
                    i = 0;
                    if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("5")) {
                        textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[8]);
                        this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                    }
                }
            }
        }
        textView.setText(testBasic.getTestSeriesName());
        textView3.setText(testBasic.getTotalQuestions());
        textView6.setText(testBasic.getTimeInMins());
        textView2.setText(testBasic.getTotalMarks());
        button.setTag(testBasic);
        final Dialog dialog3 = dialog;
        final CheckBox checkBox3 = checkBox;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.please_add_question), 0).show();
                    return;
                }
                if (checkBox3.isChecked()) {
                    dialog3.dismiss();
                    Testclassadapter.this.quiz_id = testBasic.getId();
                    Testclassadapter testclassadapter = Testclassadapter.this;
                    new NetworkCall(testclassadapter, testclassadapter.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                    return;
                }
                Toast.makeText(Testclassadapter.this.activity, Testclassadapter.this.activity.getResources().getString(R.string.please_check_following_instructions), 0).show();
            }
        });
        ArrayList arrayList = new ArrayList();
        int i2 = i;
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            if (!arrayList.isEmpty() && ((TestSectionInst) arrayList.get(i - 1)).getSectionId().equalsIgnoreCase(testSectionInst.getSectionId())) {
                arrayList.add(testSectionInst);
            } else {
                i2++;
                arrayList.add(testSectionInst);
            }
            i++;
        }
        textView4.setText("" + i2);
    }

    private void addSectionView(LinearLayout sectionListLL, InstructionData instructionData) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            String sectionId = testSectionInst.getSectionId();
            float floatSafe = Helper.parseFloatSafe(testSectionInst.getSectionTiming());
            if (map.containsKey(sectionId)) {
                map.merge(sectionId, Float.valueOf(floatSafe), new BiFunction() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter$$ExternalSyntheticLambda1
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return Float.valueOf(Float.sum(((Float) obj).floatValue(), ((Float) obj2).floatValue()));
                    }
                });
            } else {
                map.put(sectionId, Float.valueOf(floatSafe));
            }
        }
        int i = 0;
        for (TestSectionInst testSectionInst2 : instructionData.getTestSections()) {
            String hide_inst_time = "";
            if (!arrayList.isEmpty() && ((TestSectionInst) arrayList.get(i - 1)).getSectionId().equalsIgnoreCase(testSectionInst2.getSectionId())) {
                testSectionInst2.setName("");
                testSectionInst2.setSectionTiming("");
                arrayList.add(testSectionInst2);
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    float fFloatValue = ((Float) entry.getValue()).floatValue();
                    if (str.equalsIgnoreCase(testSectionInst2.getSectionId())) {
                        testSectionInst2.setSectionTiming(String.valueOf(fFloatValue));
                    }
                }
                arrayList.add(testSectionInst2);
            }
            if (instructionData.getTestBasic().getTest_assets() != null) {
                hide_inst_time = instructionData.getTestBasic().getTest_assets().getHide_inst_time();
            }
            sectionListLL.addView(initSectionListView(testSectionInst2, i, hide_inst_time));
            i++;
        }
    }

    public LinearLayout initSectionListView(TestSectionInst testSectionInst, int tag, String hide_inst_time) {
        String name;
        int intSafe;
        ArrayList arrayList = new ArrayList();
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.layout_option_section_list_view, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.secNameTV);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.totQuesTV);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.totNoAttmtsTV);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.totTimeTV);
        TextView textView5 = (TextView) linearLayout.findViewById(R.id.maxMarksTV);
        TextView textView6 = (TextView) linearLayout.findViewById(R.id.markPerQuesTV);
        TextView textView7 = (TextView) linearLayout.findViewById(R.id.negMarkPerQuesTV);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        if (!hide_inst_time.equalsIgnoreCase("")) {
            if (hide_inst_time.equalsIgnoreCase("0")) {
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(4);
            }
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("resodigital") && !TextUtils.isEmpty(testSectionInst.getSection_aliase())) {
            name = testSectionInst.getSection_aliase().toString();
        } else if (!TextUtils.isEmpty(testSectionInst.getSectionPart())) {
            name = testSectionInst.getName() + "\n(" + testSectionInst.getSectionPart() + ")";
        } else {
            name = testSectionInst.getName();
        }
        textView.setText(name);
        textView2.setText(testSectionInst.getTotalQuestions());
        textView3.setText(TextUtils.isEmpty(testSectionInst.getTotalNumOfAttempts()) ? "" : testSectionInst.getTotalNumOfAttempts());
        textView4.setText(testSectionInst.getSectionTiming());
        float floatSafe = Helper.parseFloatSafe(testSectionInst.getMarksPerQuestion());
        if (!TextUtils.isEmpty(testSectionInst.getTotalNumOfAttempts())) {
            intSafe = Helper.parseIntSafe(testSectionInst.getTotalNumOfAttempts());
        } else {
            intSafe = Helper.parseIntSafe(testSectionInst.getTotalQuestions());
        }
        textView5.setText(String.valueOf(floatSafe * intSafe));
        textView6.setText(testSectionInst.getMarksPerQuestion());
        textView7.setText(String.valueOf(Helper.parseFloatSafe(testSectionInst.getNegativeMarks())));
        linearLayout.setTag(Integer.valueOf(tag));
        arrayList.add(linearLayout);
        return linearLayout;
    }

    public void showPopMenuForLangauge(final TextView textView, final View v, final TestBasicInst testBasicInst) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.13
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.english))) {
                    Testclassadapter.this.lang = 1;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.hindi))) {
                    Testclassadapter.this.lang = 2;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.kannada))) {
                    Testclassadapter.this.lang = 3;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(2).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.malayalam))) {
                    Testclassadapter.this.lang = 4;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(3).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.marathi))) {
                    Testclassadapter.this.lang = 5;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(4).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.odia))) {
                    Testclassadapter.this.lang = 6;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(5).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.sanskrit))) {
                    Testclassadapter.this.lang = 7;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(6).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.tamil))) {
                    Testclassadapter.this.lang = 8;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(7).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.urdu))) {
                    Testclassadapter.this.lang = 9;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(8).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.bangauli))) {
                    Testclassadapter.this.lang = 10;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(9).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.assami))) {
                    Testclassadapter.this.lang = 11;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(10).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.gujrati))) {
                    Testclassadapter.this.lang = 12;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(11).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.oriya))) {
                    Testclassadapter.this.lang = 13;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(12).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                }
                return false;
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("3")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[2]);
            }
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("4")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[3]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("5")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[4]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("6")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[5]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("7")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[6]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("8")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[7]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("9")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[8]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("10")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[9]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("11")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[10]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("12")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[11]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("13")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[12]);
            }
        }
        popupMenu.show();
    }

    public void showPopMenuForLangauge1(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vv) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.LiveTest.Adapter.Testclassadapter.14
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.hindi))) {
                    Testclassadapter.this.lang = 2;
                    if (testBasicInst.getMulti_description().size() > 0 && testBasicInst.getMulti_description().get(1).getDescription() != null) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    }
                } else if (item.getTitle().toString().equals(Testclassadapter.this.activity.getResources().getString(R.string.english))) {
                    Testclassadapter.this.lang = 1;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
                    }
                }
                return false;
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            }
        }
        popupMenu.show();
    }

    private void startTestAPI() {
        this.isReAttemptOrPractice = false;
        new NetworkCall(this, this.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
    }

    private void startTestAPI(String s) {
        this.isReAttemptOrPractice = true;
        new NetworkCall(this, this.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
    }

    private void startResumeTestAPI() {
        this.first_attempt = "1";
        this.isSSCpattern = false;
        new NetworkCall(this, this.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
    }

    public String concerter(long time) {
        return String.format("%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(time)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))));
    }

    public void notifyadap(Livetestviewholder holder, int position) {
        if (this.data.size() > 0) {
            if (this.data.get(position).getSetType().equalsIgnoreCase("1")) {
                setResetLayerVisibility(holder, position);
                holder.subjectBTNLL.setVisibility(8);
                holder.forward.setVisibility(8);
                holder.share.setVisibility(0);
            } else if (this.data.get(position).getSetType().equalsIgnoreCase("3")) {
                holder.layout_test.setVisibility(8);
                holder.subjectBTNLL.setVisibility(0);
                holder.forward.setVisibility(8);
                holder.share.setVisibility(8);
            }
        }
        holder.attemp.setVisibility(0);
        holder.attemp.setText(this.activity.getResources().getString(R.string.attempt));
        holder.startedin.setVisibility(8);
        holder.time.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(Livetestviewholder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder.timer != null) {
            holder.timer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkStoragePermission() {
        OpenChooser();
    }

    private void OpenChooser() {
        if (this.STORAGE_PERMISSION_TYPE == 3) {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/pdf");
            intent.putExtra("download_file", true);
            intent.putExtra(Const.IS_DOWNLOAD, true);
            intent.putExtra("android.provider.extra.INITIAL_URI", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
            ((LivetestActivity) this.activity).requestCode = 1203;
            ((LivetestActivity) this.activity).someActivityResultLauncher.launch(Intent.createChooser(intent, "Select PDF file"));
        }
    }
}
