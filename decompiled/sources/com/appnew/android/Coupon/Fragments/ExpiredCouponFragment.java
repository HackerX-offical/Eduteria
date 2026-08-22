package com.appnew.android.Coupon.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.Coupon.Activity.CouponActivity;
import com.appnew.android.Coupon.Adapter.CouponTypeAdapter;
import com.appnew.android.Coupon.Models.Available;
import com.appnew.android.Coupon.Models.CouponPojo;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ExpiredCouponFragment extends Fragment {
    List<Available> availables;
    Button backBtn;
    CouponPojo couponPojo;
    CouponTypeAdapter couponTypeAdapter;
    RelativeLayout no_data_found_RL;
    SwipeRefreshLayout pullto_referesh;
    private RecyclerView upcomingrecycler;

    public static ExpiredCouponFragment newInstance(String param1, String param2) {
        return new ExpiredCouponFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void getBundleData() {
        if (getArguments() != null) {
            this.couponPojo = ((CouponActivity) getContext()).couponPojo;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expired_coupon, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getBundleData();
        intiViews(view);
        setData();
    }

    private void setData() {
        this.availables = new ArrayList();
        CouponPojo couponPojo = this.couponPojo;
        if (couponPojo != null && couponPojo.getExpired() != null && this.couponPojo.getExpired().size() > 0) {
            this.availables.addAll(this.couponPojo.getExpired());
        } else {
            this.no_data_found_RL.setVisibility(0);
            this.upcomingrecycler.setVisibility(8);
        }
        CouponTypeAdapter couponTypeAdapter = new CouponTypeAdapter(getContext(), this.availables, 3);
        this.couponTypeAdapter = couponTypeAdapter;
        this.upcomingrecycler.setAdapter(couponTypeAdapter);
    }

    private void intiViews(View view) {
        this.upcomingrecycler = (RecyclerView) view.findViewById(R.id.Liveclassesrecycler);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.pullto_referesh);
        this.pullto_referesh = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Coupon.Fragments.ExpiredCouponFragment.1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                ((CouponActivity) ExpiredCouponFragment.this.getActivity()).fetchData();
                ((CouponActivity) ExpiredCouponFragment.this.getContext()).stackPlace = 2;
            }
        });
        this.upcomingrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        Button button = (Button) view.findViewById(R.id.backBtn);
        this.backBtn = button;
        button.setVisibility(8);
    }
}
