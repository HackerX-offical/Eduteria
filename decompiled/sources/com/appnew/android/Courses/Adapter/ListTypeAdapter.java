package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.amulyakhare.textdrawable.TextDrawable;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.SingleStudyAdapter4;
import com.appnew.android.Courses.Modal.UnitData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.Course_subject_master;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.FileMeta;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.NonScrollRecyclerView;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ListTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "SingleStudyAdapter";
    Activity activity;
    SingleStudyAdapter4.onButtonClicked4 buttonClicked;
    int currentPosition;
    ArrayList<Lists> examPrepItem;
    ArrayList<Course_subject_master> examPrepItem1;
    ArrayList<FileMeta> fileMetaArrayList;
    int mainposition;
    ExamPrepItem prepItem;
    CourseDetail singleStudy;
    ArrayList<UnitData> unitData;
    int DEFAULT_SPAN_COUNT = 2;
    ArrayList<View> viewArrayList = new ArrayList<>();
    boolean videoType = false;

    public ListTypeAdapter(Activity activity, CourseDetail singlestudyModel, ArrayList<Lists> examPrepItem, SingleStudyAdapter4.onButtonClicked4 buttonClicked, ExamPrepItem prepItem, int i) {
        this.examPrepItem = new ArrayList<>();
        this.singleStudy = singlestudyModel;
        this.activity = activity;
        this.prepItem = prepItem;
        this.mainposition = i;
        this.examPrepItem = examPrepItem;
        this.buttonClicked = buttonClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SingleStudyListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SingleStudyListHolder singleStudyListHolder = (SingleStudyListHolder) holder;
        singleStudyListHolder.liveImageView.setVisibility(8);
        singleStudyListHolder.subItemRV.setVisibility(8);
        singleStudyListHolder.setTestData(this.examPrepItem.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.examPrepItem.size();
    }

    public class SingleStudyListHolder extends RecyclerView.ViewHolder {
        ImageView imageIcon;
        RelativeLayout imageRl;
        CircleImageView iv_color;
        ImageView liveImageView;
        RelativeLayout parentLL;
        RelativeLayout studyitemLL;
        NonScrollRecyclerView subItemRV;
        TextView titleCategory;
        TextView totalTests;

        public SingleStudyListHolder(View itemView) {
            super(itemView);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.liveImageView = (ImageView) itemView.findViewById(R.id.liveIV);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.subItemRV = (NonScrollRecyclerView) itemView.findViewById(R.id.subItemRV);
        }

        public void setTestData(final Lists list, int position) {
            this.imageIcon.setVisibility(0);
            this.imageIcon.setImageDrawable(TextDrawable.builder().beginConfig().textColor(ListTypeAdapter.this.activity.getResources().getColor(R.color.white)).endConfig().buildRound(String.valueOf(position + 1), Const.studyColor[position % 5]));
            this.titleCategory.setText(list.getText());
            this.totalTests.setVisibility(0);
            this.totalTests.setText(list.getCount() + " Tests");
            this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ListTypeAdapter.SingleStudyListHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(ListTypeAdapter.this.activity, (Class<?>) CourseActivity.class);
                    SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(ListTypeAdapter.this.singleStudy != null ? ListTypeAdapter.this.singleStudy : new CourseDetail()));
                    SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(ListTypeAdapter.this.prepItem != null ? ListTypeAdapter.this.prepItem : new ExamPrepItem()));
                    SharedPreference.getInstance().putString("list", new Gson().toJson(ListTypeAdapter.this.prepItem.getList().get(ListTypeAdapter.this.mainposition) != null ? ListTypeAdapter.this.prepItem.getList().get(ListTypeAdapter.this.mainposition) : new Lists()));
                    intent.putExtra(Const.TEST_TYPE_ID, list.getId());
                    intent.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                    intent.putExtra("title", list.getText());
                    intent.putExtra("content_type", Const.TEST);
                    SharedPreference.getInstance().putString(Const.MAIN_ID, ListTypeAdapter.this.prepItem.getList().get(ListTypeAdapter.this.mainposition).getMain_id());
                    ListTypeAdapter.this.activity.startActivity(intent);
                }
            });
        }
    }
}
