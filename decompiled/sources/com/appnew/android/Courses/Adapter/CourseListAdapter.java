package com.appnew.android.Courses.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Model.Courses.Course;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CourseListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Course> coursesArrayList;
    View.OnClickListener itemclickListener = new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.CourseListAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Course course = (Course) v.getTag();
            Intent intent = new Intent(CourseListAdapter.this.context, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_COURSE);
            intent.putExtra(Const.COURSES, course);
            CourseListAdapter.this.context.startActivity(intent);
        }
    };
    String type;

    public CourseListAdapter(Context context, ArrayList<Course> coursesDataArrayList, String type) {
        this.context = context;
        this.coursesArrayList = coursesDataArrayList;
        this.type = type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new CourseHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_course_ver, parent, false));
        }
        if (viewType == 2) {
            return new CourseHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_course_hor, parent, false));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.type.equals(Const.COURSE_CATEGORY)) {
            return 1;
        }
        return (this.type.equals(Const.MYCOURSES) || this.type.equals(Const.SEEALL_COURSE)) ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        CourseHolder courseHolder = (CourseHolder) holder;
        courseHolder.courseTV.setText(this.coursesArrayList.get(position).getTitle());
        if (this.coursesArrayList.get(position).getMrp().equals("0")) {
            courseHolder.priceTV.setText(this.context.getResources().getString(R.string.freee));
        } else if (!TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getId())) {
            if (this.coursesArrayList.get(position).getFor_dams().equals(this.coursesArrayList.get(position).getMrp())) {
                courseHolder.priceTV.setText(this.context.getResources().getString(R.string.rs) + " " + this.coursesArrayList.get(position).getMrp());
            } else {
                StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                courseHolder.priceTV.setText(this.context.getResources().getString(R.string.rs) + " " + this.coursesArrayList.get(position).getMrp() + " " + this.coursesArrayList.get(position).getFor_dams(), TextView.BufferType.SPANNABLE);
                ((Spannable) courseHolder.priceTV.getText()).setSpan(strikethroughSpan, 2, new String(this.coursesArrayList.get(position).getMrp()).length() + 2, 33);
            }
        } else if (this.coursesArrayList.get(position).getNon_dams().equals(this.coursesArrayList.get(position).getMrp())) {
            courseHolder.priceTV.setText(this.context.getResources().getString(R.string.rs) + " " + this.coursesArrayList.get(position).getMrp());
        } else {
            StrikethroughSpan strikethroughSpan2 = new StrikethroughSpan();
            courseHolder.priceTV.setText(this.context.getResources().getString(R.string.rs) + " " + this.coursesArrayList.get(position).getMrp() + " " + this.coursesArrayList.get(position).getNon_dams(), TextView.BufferType.SPANNABLE);
            ((Spannable) courseHolder.priceTV.getText()).setSpan(strikethroughSpan2, 2, new String(this.coursesArrayList.get(position).getMrp()).length() + 2, 33);
        }
        courseHolder.learnerTV.setText(this.coursesArrayList.get(position).getLearner() + (this.coursesArrayList.get(position).getLearner().equals(this.context.getResources().getString(R.string.one)) ? Const.LEARNER : Const.LEARNERS));
        courseHolder.ratingTV.setText(this.coursesArrayList.get(position).getRating());
        courseHolder.ratingRB.setRating(Float.parseFloat(this.coursesArrayList.get(position).getRating()));
        Helper.setThumbnailImage(this.context, this.coursesArrayList.get(position).getCover_image(), this.context.getResources().getDrawable(R.mipmap.camera_blue), courseHolder.imageIV);
        courseHolder.parentLL.setTag(this.coursesArrayList.get(position));
        courseHolder.parentLL.setOnClickListener(this.itemclickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.coursesArrayList.size();
    }

    public class CourseHolder extends RecyclerView.ViewHolder {
        TextView courseTV;
        ImageView imageIV;
        TextView learnerTV;
        LinearLayout parentLL;
        TextView priceTV;
        RatingBar ratingRB;
        TextView ratingTV;

        public CourseHolder(View itemView) {
            super(itemView);
            this.courseTV = (TextView) itemView.findViewById(R.id.nameTV);
            this.priceTV = (TextView) itemView.findViewById(R.id.priceTV);
            this.learnerTV = (TextView) itemView.findViewById(R.id.learnerTV);
            this.ratingTV = (TextView) itemView.findViewById(R.id.ratingTV);
            this.ratingRB = (RatingBar) itemView.findViewById(R.id.ratingRB);
            this.imageIV = (ImageView) itemView.findViewById(R.id.imageIV);
            this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
        }
    }
}
