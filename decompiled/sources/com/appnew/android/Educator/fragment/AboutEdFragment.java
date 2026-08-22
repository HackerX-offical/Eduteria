package com.appnew.android.Educator.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class AboutEdFragment extends Fragment {
    String aboutUser;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_ed_about, container, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.educatorInfo);
        Bundle arguments = getArguments();
        if (arguments != null) {
            textView.setText(String.valueOf(Html.fromHtml(arguments.getString("educator_abouts"))));
        }
        return viewInflate;
    }

    public static Fragment newInstance(String aboutUser) {
        AboutEdFragment aboutEdFragment = new AboutEdFragment();
        Bundle bundle = new Bundle();
        bundle.putString("educator_abouts", aboutUser);
        aboutEdFragment.setArguments(bundle);
        return aboutEdFragment;
    }
}
