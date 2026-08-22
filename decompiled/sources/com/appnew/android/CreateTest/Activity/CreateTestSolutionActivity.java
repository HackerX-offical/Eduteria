package com.appnew.android.CreateTest.Activity;

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
import com.appnew.android.CreateTest.Fragment.ViewSolutuionCreateTestFragment;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
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
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class CreateTestSolutionActivity extends AppCompatActivity implements NumberPadOnClick, View.OnClickListener {
    AppCompatImageView bookmark_icon_deselect;
    AppCompatImageView bookmark_icon_select;
    FrameLayout btnNext;
    FrameLayout btnPrev;
    TextView challenges_txt;
    public TextView changelang;
    public int currentPage;
    DrawerLayout drawerLayout;
    ImageView img_testback;
    ImageView langimage;
    public TestViewPagerAdapter pagerAdapter;
    ConstraintLayout rootConstraint;
    private MyRecyclerAdapter rvNumberPadAdapter;
    private RecyclerView rvNumberpad;
    TextView testSeriesName;
    private TestseriesBase testseriesBase;
    TextView tvQuestionnumber;
    private ViewPager viewPagerSolution;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    String frag_typetestbase = "";
    List<Answers> answersList = new ArrayList();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_create_test_solution);
        initView();
    }

    private void initView() {
        CreateTestSolutionActivity createTestSolutionActivity;
        this.rvNumberpad = (RecyclerView) findViewById(R.id.rvnumberpad);
        this.viewPagerSolution = (ViewPager) findViewById(R.id.view_pager_test);
        this.tvQuestionnumber = (TextView) findViewById(R.id.tv_questionnumber);
        this.challenges_txt = (TextView) findViewById(R.id.challenges_txt);
        this.img_testback = (ImageView) findViewById(R.id.img_testback);
        this.testSeriesName = (TextView) findViewById(R.id.testSeriesName);
        this.btnNext = (FrameLayout) findViewById(R.id.btn_next);
        this.btnPrev = (FrameLayout) findViewById(R.id.btn_prev);
        this.changelang = (TextView) findViewById(R.id.changelang);
        this.langimage = (ImageView) findViewById(R.id.langimage);
        this.bookmark_icon_select = (AppCompatImageView) findViewById(R.id.bookmark_icon_select);
        this.bookmark_icon_deselect = (AppCompatImageView) findViewById(R.id.bookmark_icon_deselect);
        this.rootConstraint = (ConstraintLayout) findViewById(R.id.rootConstraint);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.btnNext.setOnClickListener(this);
        this.btnPrev.setOnClickListener(this);
        this.img_testback.setOnClickListener(this);
        String stringExtra = getIntent().getStringExtra("answerlist");
        if (!SharedPreference.getInstance().getString("testseriesBase").equalsIgnoreCase("")) {
            this.frag_typetestbase = SharedPreference.getInstance().getString("testseriesBase");
        }
        this.testseriesBase = (TestseriesBase) new Gson().fromJson(this.frag_typetestbase, new TypeToken<TestseriesBase>() { // from class: com.appnew.android.CreateTest.Activity.CreateTestSolutionActivity.1
        }.getType());
        this.answersList = (List) new Gson().fromJson(stringExtra, new TypeToken<ArrayList<Answers>>() { // from class: com.appnew.android.CreateTest.Activity.CreateTestSolutionActivity.2
        }.getType());
        if (this.testseriesBase.getData().getQuestions() != null && this.testseriesBase.getData().getQuestionsHindi() != null && this.testseriesBase.getData().getQuestions().size() > 0 && this.testseriesBase.getData().getQuestionsHindi().size() > 0) {
            if (this.testseriesBase.getData().getTestBasic().getLangId().size() == 2) {
                if (this.testseriesBase.getData().getTestBasic().getLangId().get(0).equalsIgnoreCase("1")) {
                    this.changelang.setText(getResources().getString(R.string.h_e));
                    List<Answers> list = this.answersList;
                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < this.testseriesBase.getData().getQuestions().size(); i++) {
                            ArrayList<Fragment> arrayList = this.mFragmentList;
                            TestseriesBase testseriesBase = this.testseriesBase;
                            arrayList.add(ViewSolutuionCreateTestFragment.newInstance(i, testseriesBase, testseriesBase.getData().getQuestions().get(i).getQuestionType(), this.answersList.get(i), "H/E"));
                        }
                    }
                } else if (this.testseriesBase.getData().getTestBasic().getLangId().get(0).equalsIgnoreCase("2")) {
                    List<Answers> list2 = this.answersList;
                    if (list2 != null && list2.size() > 0) {
                        for (int i2 = 0; i2 < this.testseriesBase.getData().getQuestionsHindi().size(); i2++) {
                            ArrayList<Fragment> arrayList2 = this.mFragmentList;
                            TestseriesBase testseriesBase2 = this.testseriesBase;
                            arrayList2.add(ViewSolutuionCreateTestFragment.newInstance(i2, testseriesBase2, testseriesBase2.getData().getQuestionsHindi().get(i2).getQuestionType(), this.answersList.get(i2), "E/H"));
                        }
                    }
                    this.changelang.setText(getResources().getString(R.string.e_h));
                }
                this.drawerLayout.setVisibility(0);
                TestViewPagerAdapter testViewPagerAdapter = new TestViewPagerAdapter(getSupportFragmentManager(), this, this.mFragmentList, this.testseriesBase.getData().getQuestions().size());
                this.pagerAdapter = testViewPagerAdapter;
                this.viewPagerSolution.setAdapter(testViewPagerAdapter);
                createTestSolutionActivity = this;
                MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this.testseriesBase.getData().getQuestion_response(), (Activity) createTestSolutionActivity, R.layout.single_row_testpad_no, (NumberPadOnClick) this, true);
                createTestSolutionActivity.rvNumberPadAdapter = myRecyclerAdapter;
                createTestSolutionActivity.rvNumberpad.setAdapter(myRecyclerAdapter);
                createTestSolutionActivity.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
                createTestSolutionActivity.viewPagerSolution.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.CreateTest.Activity.CreateTestSolutionActivity.3
                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int state) {
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        CreateTestSolutionActivity.this.changeTextOnNextAndPrevButton();
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(final int position) {
                        CreateTestSolutionActivity.this.currentPage = position;
                        CreateTestSolutionActivity.this.rvNumberpad.scrollToPosition(CreateTestSolutionActivity.this.currentPage);
                        CreateTestSolutionActivity.this.rvNumberpad.getLayoutManager().smoothScrollToPosition(CreateTestSolutionActivity.this.rvNumberpad, new RecyclerView.State(), CreateTestSolutionActivity.this.currentPage);
                        CreateTestSolutionActivity.this.rvNumberPadAdapter.setSelectePosition(position);
                        if (CreateTestSolutionActivity.this.answersList == null || CreateTestSolutionActivity.this.answersList.size() <= 0) {
                            return;
                        }
                        CreateTestSolutionActivity.this.tvQuestionnumber.setText(CreateTestSolutionActivity.this.getResources().getString(R.string.question) + (position + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + CreateTestSolutionActivity.this.answersList.size());
                    }
                });
            } else {
                createTestSolutionActivity = this;
            }
            createTestSolutionActivity.changelang.setVisibility(8);
            createTestSolutionActivity.langimage.setVisibility(0);
        } else {
            createTestSolutionActivity = this;
            createTestSolutionActivity.changelang.setVisibility(8);
            createTestSolutionActivity.langimage.setVisibility(8);
            getBundleData();
        }
        createTestSolutionActivity.testSeriesName.setText(getResources().getString(R.string.solution));
        createTestSolutionActivity.tvQuestionnumber.setText(getResources().getString(R.string.fetch_user) + createTestSolutionActivity.testseriesBase.getData().getQuestions().size());
        createTestSolutionActivity.langimage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Activity.CreateTestSolutionActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int currentItem = CreateTestSolutionActivity.this.viewPagerSolution.getCurrentItem();
                int i3 = 0;
                if (CreateTestSolutionActivity.this.changelang.getText().equals("H/E")) {
                    if (CreateTestSolutionActivity.this.testseriesBase.getData().getQuestionsHindi() != null && CreateTestSolutionActivity.this.testseriesBase.getData().getQuestionsHindi().size() > 0) {
                        while (i3 < CreateTestSolutionActivity.this.testseriesBase.getData().getQuestionsHindi().size()) {
                            CreateTestSolutionActivity.this.mFragmentList.set(i3, ViewSolutuionCreateTestFragment.newInstance(i3, CreateTestSolutionActivity.this.testseriesBase, CreateTestSolutionActivity.this.testseriesBase.getData().getQuestionsHindi().get(i3).getQuestionType(), CreateTestSolutionActivity.this.answersList.get(i3), "E/H"));
                            i3++;
                        }
                        CreateTestSolutionActivity.this.pagerAdapter.notifyDataSetChanged();
                        CreateTestSolutionActivity.this.viewPagerSolution.setCurrentItem(currentItem);
                    }
                    CreateTestSolutionActivity.this.changelang.setText(CreateTestSolutionActivity.this.getResources().getString(R.string.e_h));
                    return;
                }
                if (CreateTestSolutionActivity.this.changelang.getText().equals(CreateTestSolutionActivity.this.getResources().getString(R.string.e_h))) {
                    if (CreateTestSolutionActivity.this.testseriesBase.getData().getQuestions() != null && CreateTestSolutionActivity.this.testseriesBase.getData().getQuestions().size() > 0) {
                        while (i3 < CreateTestSolutionActivity.this.testseriesBase.getData().getQuestions().size()) {
                            CreateTestSolutionActivity.this.mFragmentList.set(i3, ViewSolutuionCreateTestFragment.newInstance(i3, CreateTestSolutionActivity.this.testseriesBase, CreateTestSolutionActivity.this.testseriesBase.getData().getQuestions().get(i3).getQuestionType(), CreateTestSolutionActivity.this.answersList.get(i3), "H/E"));
                            i3++;
                        }
                        CreateTestSolutionActivity.this.pagerAdapter.notifyDataSetChanged();
                        CreateTestSolutionActivity.this.viewPagerSolution.setCurrentItem(currentItem);
                    }
                    CreateTestSolutionActivity.this.changelang.setText(CreateTestSolutionActivity.this.getResources().getString(R.string.h_e));
                }
            }
        });
    }

    private void getBundleData() {
        List<Answers> list = this.answersList;
        if (list != null && list.size() > 0) {
            setViewSolutionData();
        }
        this.viewPagerSolution.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.CreateTest.Activity.CreateTestSolutionActivity.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                CreateTestSolutionActivity.this.changeTextOnNextAndPrevButton();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(final int position) {
                CreateTestSolutionActivity.this.currentPage = position;
                CreateTestSolutionActivity.this.rvNumberpad.scrollToPosition(CreateTestSolutionActivity.this.currentPage);
                CreateTestSolutionActivity.this.rvNumberpad.getLayoutManager().smoothScrollToPosition(CreateTestSolutionActivity.this.rvNumberpad, new RecyclerView.State(), CreateTestSolutionActivity.this.currentPage);
                CreateTestSolutionActivity.this.rvNumberPadAdapter.setSelectePosition(position);
                if (CreateTestSolutionActivity.this.answersList == null || CreateTestSolutionActivity.this.answersList.size() <= 0) {
                    return;
                }
                CreateTestSolutionActivity.this.tvQuestionnumber.setText(CreateTestSolutionActivity.this.getResources().getString(R.string.question) + (position + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + CreateTestSolutionActivity.this.answersList.size());
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
        this.mFragmentList.add(ViewSolutuionCreateTestFragment.newInstance(i, testseriesBase, questionType, answers, ""));
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
            } else {
                ((TextView) this.btnNext.getChildAt(0)).setTextColor(getResources().getColor(R.color.white));
                this.btnNext.setBackground(getResources().getDrawable(R.drawable.background_bg_next));
            }
            if (currentItem == 1) {
                ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(R.color.white));
                this.btnPrev.setBackground(getResources().getDrawable(R.drawable.background_bg_prev));
            } else {
                ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(R.color.white));
                this.btnPrev.setBackground(getResources().getDrawable(R.drawable.background_bg_next));
            }
        }
    }
}
