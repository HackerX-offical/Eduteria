package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityUserAttendanceBinding implements ViewBinding {
    public final LinearLayout attendanceHeaderLL;
    public final RecyclerView attendanceRecyclerView;
    public final LinearLayout attendanceSheetHead;
    public final RelativeLayout backBtn;
    public final ImageView dateRange;
    public final ImageView image;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    private final RelativeLayout rootView;
    public final LinearLayout titleLL;
    public final RelativeLayout toolbar;

    private ActivityUserAttendanceBinding(RelativeLayout rootView, LinearLayout attendanceHeaderLL, RecyclerView attendanceRecyclerView, LinearLayout attendanceSheetHead, RelativeLayout backBtn, ImageView dateRange, ImageView image, TextView noData, RelativeLayout noDataFoundRL, LinearLayout titleLL, RelativeLayout toolbar) {
        this.rootView = rootView;
        this.attendanceHeaderLL = attendanceHeaderLL;
        this.attendanceRecyclerView = attendanceRecyclerView;
        this.attendanceSheetHead = attendanceSheetHead;
        this.backBtn = backBtn;
        this.dateRange = dateRange;
        this.image = image;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.titleLL = titleLL;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUserAttendanceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityUserAttendanceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_user_attendance, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUserAttendanceBinding bind(View rootView) {
        int i = R.id.attendanceHeaderLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.attendanceHeaderLL);
        if (linearLayout != null) {
            i = R.id.attendanceRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.attendanceRecyclerView);
            if (recyclerView != null) {
                i = R.id.attendanceSheetHead;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.attendanceSheetHead);
                if (linearLayout2 != null) {
                    i = R.id.backBtn;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.backBtn);
                    if (relativeLayout != null) {
                        i = R.id.dateRange;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dateRange);
                        if (imageView != null) {
                            i = R.id.image;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                            if (imageView2 != null) {
                                i = R.id.no_data;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                if (textView != null) {
                                    i = R.id.no_data_found_RL;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                                    if (relativeLayout2 != null) {
                                        i = R.id.titleLL;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.titleLL);
                                        if (linearLayout3 != null) {
                                            i = R.id.toolbar;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                            if (relativeLayout3 != null) {
                                                return new ActivityUserAttendanceBinding((RelativeLayout) rootView, linearLayout, recyclerView, linearLayout2, relativeLayout, imageView, imageView2, textView, relativeLayout2, linearLayout3, relativeLayout3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
