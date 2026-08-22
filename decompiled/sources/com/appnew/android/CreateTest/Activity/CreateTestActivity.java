package com.appnew.android.CreateTest.Activity;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.appnew.android.CreateTest.Fragment.CreateTestFragmentOne;
import com.appnew.android.CreateTest.Fragment.CreateTestFragmentThree;
import com.appnew.android.CreateTest.Fragment.CreateTestFragmentTwo;
import com.appnew.android.CreateTest.Model.CreateTestSubject;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Utils.Const;
import com.appnew.android.home.Activity.BaseABNoNavActivity;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CreateTestActivity extends BaseABNoNavActivity {
    String LANG;
    ArrayList<Courselist> courselists;
    ArrayList<CreateTestSubject> createTestSubjects;
    String frag_type;

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected boolean addBackButton() {
        return true;
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected void initViews() {
        if (getIntent().getExtras() != null) {
            this.frag_type = getIntent().getExtras().getString(Const.FRAG_TYPE);
            String string = getIntent().getExtras().getString(Const.LANG);
            this.LANG = string;
            if (string == null) {
                this.LANG = "1";
            }
            this.courselists = (ArrayList) getIntent().getExtras().getSerializable(Const.CREATE_COURSE_DATA);
            this.createTestSubjects = (ArrayList) getIntent().getExtras().getSerializable(Const.CREATE_COURSE_SUBJECT_DATA);
        }
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected Fragment getFragment() {
        String str = this.frag_type;
        str.hashCode();
        switch (str) {
            case "create_test_three":
                setToolbarTitle(getResources().getString(R.string.create_test));
                return CreateTestFragmentThree.newInstance(this.frag_type, this.createTestSubjects, this.LANG);
            case "create_test_one":
                setToolbarTitle(getResources().getString(R.string.create_test));
                return CreateTestFragmentOne.newInstance(this.frag_type);
            case "create_test_two":
                setToolbarTitle(getResources().getString(R.string.create_test));
                return CreateTestFragmentTwo.newInstance(this.frag_type, this.courselists, this.LANG);
            default:
                return null;
        }
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
