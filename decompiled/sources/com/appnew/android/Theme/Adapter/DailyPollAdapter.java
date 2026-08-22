package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.DailyPoll;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.MakeMyExam;
import com.devzone.fillprogresslayout.FillProgressLayout;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class DailyPollAdapter extends RecyclerView.Adapter<SliderAdapterViewHolder> {
    Context context;
    private DailyPoll dailyPoll;
    DailyPollSubmitCallBack onPollSubmitCall;
    private ArrayList<DailyPoll.OptionsValue> optionsValues;
    public UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());

    public interface DailyPollSubmitCallBack {
        void onSubmitCall(String id, String optionIndex);
    }

    public DailyPollAdapter(Context context, DailyPoll dailyPoll, DailyPollSubmitCallBack onPollSubmitCall) {
        this.optionsValues = new ArrayList<>();
        this.dailyPoll = dailyPoll;
        this.context = context;
        this.onPollSubmitCall = onPollSubmitCall;
        this.optionsValues = dailyPoll.getJson().getOptions();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SliderAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.child_daily_poll_option, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final SliderAdapterViewHolder viewHolder, final int position) {
        viewHolder.tv_option.setText(this.optionsValues.get(position).getOption());
        int i = position + 1;
        viewHolder.tv_option_serial.setText(String.format("%d.", Integer.valueOf(i)));
        if (this.dailyPoll.getJson().getAttempt_index() == null || TextUtils.isEmpty(this.dailyPoll.getJson().getAttempt_index()) || this.dailyPoll.getJson().getAttempt_index().equalsIgnoreCase("0")) {
            viewHolder.tv_option.setTextColor(this.context.getResources().getColor(R.color.black_text_color_dim));
            viewHolder.ll_end.setVisibility(8);
            viewHolder.tv_answer_per.setVisibility(8);
            viewHolder.fill_progress.setVisibility(8);
            viewHolder.rl_poll_child_main.setBackground(ContextCompat.getDrawable(this.context, R.drawable.black_stroke_round_bg));
            viewHolder.rl_poll_child_main.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.DailyPollAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (DailyPollAdapter.this.dailyPoll.getJson().getAttempt_index() == null || TextUtils.isEmpty(DailyPollAdapter.this.dailyPoll.getJson().getAttempt_index()) || DailyPollAdapter.this.dailyPoll.getJson().getAttempt_index().equalsIgnoreCase("0")) {
                        DailyPollAdapter.this.onPollSubmitCall.onSubmitCall(DailyPollAdapter.this.dailyPoll.getId(), String.valueOf(position + 1));
                    }
                }
            });
            return;
        }
        viewHolder.ll_end.setVisibility(0);
        viewHolder.tv_answer_per.setVisibility(0);
        viewHolder.fill_progress.setVisibility(0);
        try {
            if (this.dailyPoll.getJson().getRight_ans() == i) {
                viewHolder.iv_rightOrWrong.setImageResource(R.drawable.correct);
            } else {
                viewHolder.iv_rightOrWrong.setImageResource(R.drawable.wrong);
            }
            if (Integer.parseInt(this.dailyPoll.getJson().getAttempt_index()) == i) {
                viewHolder.tv_option.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                viewHolder.tv_option_serial.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                viewHolder.tv_answer_per.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                viewHolder.rl_poll_child_main.setBackground(ContextCompat.getDrawable(this.context, R.drawable.primary_stroke_round_bg));
                viewHolder.fill_progress.setProgressColor(Color.parseColor(String.format("#%08X", Integer.valueOf(ContextCompat.getColor(this.context, R.color.colorPrimary))).replaceFirst("^#FF", "#23")));
            } else {
                viewHolder.rl_poll_child_main.setBackground(ContextCompat.getDrawable(this.context, R.drawable.black_stroke_round_bg));
                viewHolder.tv_option.setTextColor(this.context.getResources().getColor(R.color.black_text_color_dim));
                viewHolder.tv_option_serial.setTextColor(this.context.getResources().getColor(R.color.black_text_color_dim));
                viewHolder.tv_answer_per.setTextColor(this.context.getResources().getColor(R.color.black_text_color_dim));
                viewHolder.fill_progress.setProgressColor(Color.parseColor(String.format("#%08X", Integer.valueOf(ContextCompat.getColor(this.context, R.color.black_text_color_dim))).replaceFirst("^#FF", "#23")));
            }
            viewHolder.fill_progress.setProgress((int) Float.parseFloat(this.optionsValues.get(position).getAttempt_percentage()), false);
            viewHolder.tv_answer_per.setText(Math.round(Float.parseFloat(this.optionsValues.get(position).getAttempt_percentage())) + "%");
            viewHolder.tv_option.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appnew.android.Theme.Adapter.DailyPollAdapter.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    viewHolder.tv_option.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = viewHolder.fill_progress.getLayoutParams();
                    layoutParams.height = viewHolder.tv_option.getHeight() - 2;
                    viewHolder.fill_progress.setLayoutParams(layoutParams);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dailyPoll.getJson().getOptions().size();
    }

    static class SliderAdapterViewHolder extends RecyclerView.ViewHolder {
        FillProgressLayout fill_progress;
        ImageView iv_rightOrWrong;
        LinearLayout ll_end;
        RelativeLayout rl_poll_child_main;
        TextView tv_answer_per;
        TextView tv_option;
        TextView tv_option_serial;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            this.tv_answer_per = (TextView) itemView.findViewById(R.id.tv_answer_per);
            this.tv_option = (TextView) itemView.findViewById(R.id.tv_option);
            this.fill_progress = (FillProgressLayout) itemView.findViewById(R.id.fill_progress);
            this.rl_poll_child_main = (RelativeLayout) itemView.findViewById(R.id.rl_poll_child_main);
            this.tv_option_serial = (TextView) itemView.findViewById(R.id.tv_option_serial);
            this.iv_rightOrWrong = (ImageView) itemView.findViewById(R.id.iv_rightOrWrong);
            this.ll_end = (LinearLayout) itemView.findViewById(R.id.ll_end);
        }
    }
}
