package com.appnew.android.Courses.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class CourseDetailsFragmentTheme1 extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public static CourseDetailsFragmentTheme1 newInstance(String param1, String param2) {
        CourseDetailsFragmentTheme1 courseDetailsFragmentTheme1 = new CourseDetailsFragmentTheme1();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, param1);
        bundle.putString(ARG_PARAM2, param2);
        courseDetailsFragmentTheme1.setArguments(bundle);
        return courseDetailsFragmentTheme1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_course_details_theme1, container, false);
    }
}
