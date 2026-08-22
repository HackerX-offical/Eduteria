package com.appnew.android.Courses.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Fragment.CommonFragForList;
import com.appnew.android.Model.Courses.Course;
import com.appnew.android.Model.Courses.CoursesData;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class AllCoursesAdapater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ViewHolder TagHolder1;
    CommonFragForList commonFragForList;
    Context context;
    CourseListAdapter courseListAdapter;
    ArrayList<CoursesData> coursesDatasArrayList;
    LayoutInflater layoutInflater;
    int width = 0;
    View.OnClickListener onCourseClickListener = new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.AllCoursesAdapater.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Course course = (Course) v.getTag();
            Intent intent = new Intent(AllCoursesAdapater.this.context, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_COURSE);
            intent.putExtra(Const.COURSES, course);
            AllCoursesAdapater.this.context.startActivity(intent);
        }
    };
    View.OnClickListener onseeAllClickListener = new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.AllCoursesAdapater.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            CoursesData coursesData = (CoursesData) v.getTag();
            Intent intent = new Intent(AllCoursesAdapater.this.context, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SEEALL_COURSE);
            intent.putExtra(Const.COURSE_CATEGORY, coursesData.getCategory_info());
            AllCoursesAdapater.this.context.startActivity(intent);
        }
    };

    public AllCoursesAdapater(Context activity, ArrayList<CoursesData> coursesDataArrayList, CommonFragForList commonFragForList) {
        this.context = activity;
        this.coursesDatasArrayList = coursesDataArrayList;
        this.commonFragForList = commonFragForList;
        this.layoutInflater = (LayoutInflater) activity.getApplicationContext().getSystemService("layout_inflater");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.coursesDatasArrayList.get(position).getCategory_info().getApp_view_type().equals("1") ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.singlecourse_category_row, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder sholder, int position) {
        ViewHolder viewHolder = (ViewHolder) sholder;
        CoursesData coursesData = this.coursesDatasArrayList.get(position);
        if (coursesData.getCourse_list().size() > 0) {
            viewHolder.seeAll.setVisibility(0);
            viewHolder.courseCategoryTitle.setText(coursesData.getCategory_info().getName());
            viewHolder.courseLL.removeAllViews();
            if (getItemViewType(position) == 0) {
                int i = 0;
                for (Course course : coursesData.getCourse_list()) {
                    if (i == 3) {
                        break;
                    }
                    viewHolder.courseLL.setVisibility(0);
                    viewHolder.courseVerticalRV.setVisibility(8);
                    viewHolder.courseLL.setOrientation(1);
                    viewHolder.courseLL.addView(initCourseHorView(course, getItemViewType(position)));
                    i++;
                }
            } else {
                this.courseListAdapter = new CourseListAdapter(this.context, coursesData.getCourse_list(), Const.COURSE_CATEGORY);
                viewHolder.courseLL.setVisibility(8);
                viewHolder.courseVerticalRV.setVisibility(0);
                viewHolder.courseVerticalRV.setAdapter(this.courseListAdapter);
            }
            viewHolder.seeAll.setTag(coursesData);
            viewHolder.seeAll.setOnClickListener(this.onseeAllClickListener);
            return;
        }
        viewHolder.topViewItem.setVisibility(8);
    }

    public LinearLayout initCourseHorView(Course course, int itemViewType) {
        String str = Const.LEARNER;
        if (itemViewType == 0) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(this.context, R.layout.single_row_course_hor, null);
            new LinearLayout.LayoutParams(-1, -2);
            TextView textView = (TextView) linearLayout.findViewById(R.id.nameTV);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.priceTV);
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.learnerTV);
            TextView textView4 = (TextView) linearLayout.findViewById(R.id.ratingTV);
            RatingBar ratingBar = (RatingBar) linearLayout.findViewById(R.id.ratingRB);
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.imageIV);
            textView.setText(course.getTitle());
            if (course.getMrp().equals("0")) {
                textView2.setText(this.context.getResources().getString(R.string.freee));
            } else if (!TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getId())) {
                if (course.getFor_dams().equals(course.getMrp())) {
                    textView2.setText(this.context.getResources().getString(R.string.rs) + " " + course.getMrp());
                } else {
                    StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                    textView2.setText(this.context.getResources().getString(R.string.rs) + " " + course.getMrp() + " " + course.getFor_dams(), TextView.BufferType.SPANNABLE);
                    ((Spannable) textView2.getText()).setSpan(strikethroughSpan, 2, new String(course.getMrp()).length() + 2, 33);
                }
            } else if (course.getNon_dams().equals(course.getMrp())) {
                textView2.setText(this.context.getResources().getString(R.string.rs) + " " + course.getMrp());
            } else {
                StrikethroughSpan strikethroughSpan2 = new StrikethroughSpan();
                textView2.setText(this.context.getResources().getString(R.string.rs) + " " + course.getMrp() + " " + course.getNon_dams(), TextView.BufferType.SPANNABLE);
                ((Spannable) textView2.getText()).setSpan(strikethroughSpan2, 2, new String(course.getMrp()).length() + 2, 33);
            }
            StringBuilder sbAppend = new StringBuilder().append(course.getLearner());
            if (!course.getLearner().equals("1")) {
                str = Const.LEARNERS;
            }
            textView3.setText(sbAppend.append(str).toString());
            textView4.setText(course.getRating());
            ratingBar.setRating(Float.parseFloat(course.getRating()));
            Helper.setThumbnailImage(this.context, course.getCover_image(), this.context.getResources().getDrawable(R.mipmap.course_placeholder), imageView);
            linearLayout.setTag(course);
            linearLayout.setOnClickListener(this.onCourseClickListener);
            return linearLayout;
        }
        if (itemViewType != 1) {
            return null;
        }
        LinearLayout linearLayout2 = (LinearLayout) View.inflate(this.context, R.layout.single_row_course_ver, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.width / 3, -2, 1.0f);
        TextView textView5 = (TextView) linearLayout2.findViewById(R.id.nameTV);
        TextView textView6 = (TextView) linearLayout2.findViewById(R.id.priceTV);
        TextView textView7 = (TextView) linearLayout2.findViewById(R.id.learnerTV);
        TextView textView8 = (TextView) linearLayout2.findViewById(R.id.ratingTV);
        RatingBar ratingBar2 = (RatingBar) linearLayout2.findViewById(R.id.ratingRB);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(R.id.imageIV);
        textView5.setText(course.getTitle());
        if (course.getMrp().equals("0")) {
            textView6.setText(this.context.getResources().getString(R.string.freee));
        } else if (!TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getId())) {
            if (course.getFor_dams().equals(course.getMrp())) {
                textView6.setText(this.context.getResources().getString(R.string.rs) + " " + course.getMrp());
            } else {
                StrikethroughSpan strikethroughSpan3 = new StrikethroughSpan();
                textView6.setText(this.context.getResources().getString(R.string.rs) + " " + course.getMrp() + " " + course.getFor_dams(), TextView.BufferType.SPANNABLE);
                ((Spannable) textView6.getText()).setSpan(strikethroughSpan3, 2, new String(course.getMrp()).length() + 2, 33);
            }
        } else if (course.getNon_dams().equals(course.getMrp())) {
            textView6.setText(this.context.getResources().getString(R.string.rs) + " " + course.getMrp());
        } else {
            StrikethroughSpan strikethroughSpan4 = new StrikethroughSpan();
            textView6.setText(this.context.getResources().getString(R.string.rs) + " " + course.getMrp() + " " + course.getNon_dams(), TextView.BufferType.SPANNABLE);
            ((Spannable) textView6.getText()).setSpan(strikethroughSpan4, 2, new String(course.getMrp()).length() + 2, 33);
        }
        StringBuilder sbAppend2 = new StringBuilder().append(course.getLearner());
        if (!course.getLearner().equals(this.context.getResources().getString(R.string.one))) {
            str = Const.LEARNERS;
        }
        textView7.setText(sbAppend2.append(str).toString());
        textView8.setText(course.getRating());
        ratingBar2.setRating(Float.parseFloat(course.getRating()));
        Helper.setThumbnailImage(this.context, course.getCover_image(), this.context.getResources().getDrawable(R.mipmap.course_placeholder), imageView2);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setTag(course);
        linearLayout2.setOnClickListener(this.onCourseClickListener);
        return linearLayout2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.coursesDatasArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView courseCategoryTitle;
        private LinearLayout courseLL;
        RecyclerView courseVerticalRV;
        private Button seeAll;
        private RelativeLayout topViewItem;

        public ViewHolder(View itemView) {
            super(itemView);
            this.courseCategoryTitle = (TextView) itemView.findViewById(R.id.tv1);
            this.seeAll = (Button) itemView.findViewById(R.id.courseCatseeAllBtn);
            this.topViewItem = (RelativeLayout) itemView.findViewById(R.id.topViewItem);
            this.courseLL = (LinearLayout) itemView.findViewById(R.id.coursesoptionLL);
            RecyclerView recyclerView = (RecyclerView) itemView.findViewById(R.id.categoryRV);
            this.courseVerticalRV = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(AllCoursesAdapater.this.context, 0, false));
            if (this.courseCategoryTitle.getVisibility() == 8) {
                this.courseCategoryTitle.setVisibility(0);
            }
        }
    }
}
