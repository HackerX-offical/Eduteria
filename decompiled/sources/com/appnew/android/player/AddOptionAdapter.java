package com.appnew.android.player;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.AddOptionModel;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class AddOptionAdapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<AddOptionModel> addOptionModels;
    RelativeLayout addOptionRl;
    Context context;
    boolean wantToHaveUserInput;

    public AddOptionAdapter(Context context, ArrayList<AddOptionModel> addOptionModels, RelativeLayout addOptionRl) {
        this.context = context;
        this.addOptionModels = addOptionModels;
        this.addOptionRl = addOptionRl;
        this.wantToHaveUserInput = false;
        if (addOptionRl != null && addOptionModels.size() >= 4) {
            addOptionRl.setVisibility(8);
        } else {
            addOptionRl.setVisibility(0);
        }
    }

    public AddOptionAdapter(Context context, ArrayList<AddOptionModel> addOptionModels, boolean wantToHaveUserInput, RelativeLayout addOptionRl) {
        this.context = context;
        this.addOptionModels = addOptionModels;
        this.wantToHaveUserInput = wantToHaveUserInput;
        this.addOptionRl = addOptionRl;
        if (addOptionRl != null && addOptionModels.size() >= 4) {
            addOptionRl.setVisibility(8);
        } else {
            addOptionRl.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_option, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        AddOptionModel addOptionModel = this.addOptionModels.get(position);
        holder.optionNumber.setText(addOptionModel.getOption());
        if (addOptionModel.isThisAnswerRight()) {
            holder.correctAnswer.setImageResource(R.drawable.right_tick);
        }
        if (!addOptionModel.isThisAnswerRight()) {
            holder.correctAnswer.setImageResource(R.drawable.check_option);
        }
        if (position > 1) {
            holder.remove.setVisibility(0);
        }
        if (position <= 1) {
            holder.remove.setVisibility(8);
        }
        if (this.wantToHaveUserInput) {
            holder.correctAnswer.setVisibility(0);
        }
        if (!this.wantToHaveUserInput) {
            holder.correctAnswer.setVisibility(8);
        }
        holder.correctAnswer.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.AddOptionAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(position, view);
            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.AddOptionAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$1(position, view);
            }
        });
        holder.enterOptionEt.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.player.AddOptionAdapter.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                AddOptionAdapter.this.addOptionModels.get(holder.getAbsoluteAdapterPosition()).setAnswer(s.toString());
                if (AddOptionAdapter.this.context instanceof LiveStreamingYoutube) {
                    ((LiveStreamingYoutube) AddOptionAdapter.this.context).updateListAfterText(AddOptionAdapter.this.addOptionModels);
                } else if (AddOptionAdapter.this.context instanceof Liveawsactivity) {
                    ((Liveawsactivity) AddOptionAdapter.this.context).updateListAfterText(AddOptionAdapter.this.addOptionModels);
                } else if (AddOptionAdapter.this.context instanceof VODPlayerActivity) {
                    ((VODPlayerActivity) AddOptionAdapter.this.context).updateListAfterText(AddOptionAdapter.this.addOptionModels);
                }
            }
        });
        holder.enterOptionEt.setText(addOptionModel.getAnswer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
        int i2 = 0;
        while (i2 < this.addOptionModels.size()) {
            this.addOptionModels.get(i2).setThisAnswerRight(i2 == i);
            i2++;
        }
        Context context = this.context;
        if (context instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) context).updateList(this.addOptionModels);
        } else if (context instanceof Liveawsactivity) {
            ((Liveawsactivity) context).updateList(this.addOptionModels);
        } else if (context instanceof VODPlayerActivity) {
            ((VODPlayerActivity) context).updateList(this.addOptionModels);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(int i, View view) {
        Context context = this.context;
        if (context instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) context).removeOption(i);
        } else if (context instanceof Liveawsactivity) {
            ((Liveawsactivity) context).removeOption(i);
        } else if (context instanceof VODPlayerActivity) {
            ((VODPlayerActivity) context).removeOption(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.addOptionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView correctAnswer;
        EditText enterOptionEt;
        RelativeLayout optionLayout;
        TextView optionNumber;
        TextView remove;

        public ViewHolder(View itemView) {
            super(itemView);
            this.enterOptionEt = (EditText) itemView.findViewById(R.id.enterOptionEt);
            this.optionNumber = (TextView) itemView.findViewById(R.id.optionNumber);
            this.remove = (TextView) itemView.findViewById(R.id.remove);
            this.optionLayout = (RelativeLayout) itemView.findViewById(R.id.optionLayout);
            this.correctAnswer = (ImageView) itemView.findViewById(R.id.correctAnswer);
        }
    }
}
