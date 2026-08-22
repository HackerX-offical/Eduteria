package com.appnew.android.Webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.Utils.Helper;
import com.appnew.android.testmodule.adapter.MyRecyclerAdapter;
import com.appnew.android.testmodule.adapter.TestViewPagerAdapter;
import com.appnew.android.testmodule.interfaces.NumberPadOnClick;
import com.appnew.android.testmodule.layoutmanager.LinearLayoutManagerWithSmoothScroller;
import com.appnew.android.testmodule.model.Answers;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class RevisionSolutionActivity extends AppCompatActivity implements NumberPadOnClick, View.OnClickListener {
    AppCompatImageView bookmark_icon_deselect;
    AppCompatImageView bookmark_icon_select;
    FrameLayout btnNext;
    FrameLayout btnPrev;
    TextView challenges_txt;
    public int currentPage;
    DrawerLayout drawerLayout;
    ImageView img_testback;
    public TestViewPagerAdapter pagerAdapter;
    ConstraintLayout rootConstraint;
    private MyRecyclerAdapter rvNumberPadAdapter;
    private RecyclerView rvNumberpad;
    TextView testSeriesName;
    private TestseriesBase testseriesBase;
    TextView tvQuestionnumber;
    private ViewPager viewPagerSolution;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    List<Answers> answersList = new ArrayList();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_revision_solution);
        initView();
    }

    private void initView() {
        this.rvNumberpad = (RecyclerView) findViewById(R.id.rvnumberpad);
        this.viewPagerSolution = (ViewPager) findViewById(R.id.view_pager_test);
        this.tvQuestionnumber = (TextView) findViewById(R.id.tv_questionnumber);
        this.challenges_txt = (TextView) findViewById(R.id.challenges_txt);
        this.img_testback = (ImageView) findViewById(R.id.img_testback);
        this.testSeriesName = (TextView) findViewById(R.id.testSeriesName);
        this.btnNext = (FrameLayout) findViewById(R.id.btn_next);
        this.btnPrev = (FrameLayout) findViewById(R.id.btn_prev);
        this.bookmark_icon_select = (AppCompatImageView) findViewById(R.id.bookmark_icon_select);
        this.bookmark_icon_deselect = (AppCompatImageView) findViewById(R.id.bookmark_icon_deselect);
        this.rootConstraint = (ConstraintLayout) findViewById(R.id.rootConstraint);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.btnNext.setOnClickListener(this);
        this.btnPrev.setOnClickListener(this);
        this.img_testback.setOnClickListener(this);
        this.answersList = (List) new Gson().fromJson(getIntent().getStringExtra("answerlist"), new TypeToken<ArrayList<Answers>>() { // from class: com.appnew.android.Webview.RevisionSolutionActivity.1
        }.getType());
        this.testseriesBase = (TestseriesBase) ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getSerializable("testseriesBase");
        this.testSeriesName.setText(getResources().getString(R.string.solution));
        this.tvQuestionnumber.setText(getResources().getString(R.string.question_) + this.testseriesBase.getData().getQuestions().size());
        getBundleData();
    }

    private void getBundleData() {
        List<Answers> list = this.answersList;
        if (list != null && list.size() > 0) {
            setViewSolutionData();
        }
        this.viewPagerSolution.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.Webview.RevisionSolutionActivity.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RevisionSolutionActivity.this.changeTextOnNextAndPrevButton();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(final int position) {
                RevisionSolutionActivity.this.currentPage = position;
                RevisionSolutionActivity.this.rvNumberpad.scrollToPosition(RevisionSolutionActivity.this.currentPage);
                RevisionSolutionActivity.this.rvNumberpad.getLayoutManager().smoothScrollToPosition(RevisionSolutionActivity.this.rvNumberpad, new RecyclerView.State(), RevisionSolutionActivity.this.currentPage);
                RevisionSolutionActivity.this.rvNumberPadAdapter.setSelectePosition(position);
                if (RevisionSolutionActivity.this.answersList == null || RevisionSolutionActivity.this.answersList.size() <= 0) {
                    return;
                }
                RevisionSolutionActivity.this.tvQuestionnumber.setText(RevisionSolutionActivity.this.getResources().getString(R.string.question) + (position + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + RevisionSolutionActivity.this.answersList.size());
            }
        });
    }

    private void setViewSolutionData() {
        for (int i = 0; i < this.testseriesBase.getData().getQuestions().size(); i++) {
            TestseriesBase testseriesBase = this.testseriesBase;
            addFragment(i, testseriesBase, testseriesBase.getData().getQuestions().get(i).getQuestionType(), this.answersList.get(i));
        }
        this.drawerLayout.setVisibility(0);
        TestViewPagerAdapter testViewPagerAdapter = new TestViewPagerAdapter(getSupportFragmentManager(), this, this.mFragmentList, this.testseriesBase.getData().getQuestions().size());
        this.pagerAdapter = testViewPagerAdapter;
        this.viewPagerSolution.setAdapter(testViewPagerAdapter);
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this.testseriesBase.getData().getQuestion_response(), (Activity) this, R.layout.single_row_testpad_no, (NumberPadOnClick) this, true);
        this.rvNumberPadAdapter = myRecyclerAdapter;
        this.rvNumberpad.setAdapter(myRecyclerAdapter);
        this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
    }

    @Override // com.appnew.android.testmodule.interfaces.NumberPadOnClick
    public void sendOnclickInd(int index) {
        this.viewPagerSolution.setCurrentItem(index);
    }

    private void addFragment(int i, TestseriesBase testseriesBase, String questionType, Answers answers) {
        this.mFragmentList.add(ViewSolutuionRevisionFragment.newInstance(i, testseriesBase, questionType, answers));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_next) {
            ViewPager viewPager = this.viewPagerSolution;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            changeTextOnNextAndPrevButton();
        } else if (id != R.id.btn_prev) {
            if (id != R.id.img_testback) {
                return;
            }
            onBackPressed();
        } else {
            ViewPager viewPager2 = this.viewPagerSolution;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1, true);
            changeTextOnNextAndPrevButton();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void changeTextOnNextAndPrevButton() {
        if (this.testseriesBase != null) {
            int currentItem = this.viewPagerSolution.getCurrentItem() + 1;
            if (currentItem == this.testseriesBase.getData().getQuestions().size()) {
                ((TextView) this.btnNext.getChildAt(0)).setTextColor(getResources().getColor(R.color.white));
                this.btnNext.setBackground(getResources().getDrawable(R.drawable.background_bg_prev));
                this.btnNext.setEnabled(false);
            } else {
                ((TextView) this.btnNext.getChildAt(0)).setTextColor(getResources().getColor(R.color.whiteApp));
                this.btnNext.setEnabled(true);
                this.btnNext.setBackground(getResources().getDrawable(R.drawable.background_bg_next));
            }
            if (currentItem == 1) {
                ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(R.color.white));
                this.btnPrev.setBackground(getResources().getDrawable(R.drawable.background_bg_prev));
                this.btnPrev.setEnabled(false);
            } else {
                ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(R.color.whiteApp));
                this.btnPrev.setBackground(getResources().getDrawable(R.drawable.background_bg_next));
                this.btnPrev.setEnabled(true);
            }
        }
    }
}
