package com.appnew.android.testmodule.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.adapter.DragItemTouchHelper;
import com.appnew.android.testmodule.model.Social;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class AdapterMatchingListDrag extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements DragItemTouchHelper.MoveHelperAdapter, DragItemTouchHelper.SwipedHelperAdapter, com.appnew.android.testmodule.interfaces.MachingOnDrag {
    private Activity ctx;
    private List<Social> items;
    private OnStartDragListener mDragStartListener;
    private OnItemClickListener mOnItemClickListener;
    MachingOnDrag machingOnDrag;
    int pagerposition;

    public interface MachingOnDrag {
        void sendOnclickInd(int position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Social obj, int position, int bg, int circle, boolean select);
    }

    public interface OnStartDragListener {
        void onStartDrag(RecyclerView.ViewHolder viewHolder);
    }

    @Override // com.appnew.android.testmodule.adapter.DragItemTouchHelper.SwipedHelperAdapter
    public boolean onItemSwiped(int toPosition) {
        return true;
    }

    @Override // com.appnew.android.testmodule.interfaces.MachingOnDrag
    public void sendOnclickInd(int position) {
    }

    public AdapterMatchingListDrag(Activity context, List<Social> items, int position) {
        new ArrayList();
        this.mDragStartListener = null;
        this.items = items;
        this.pagerposition = position;
        this.ctx = context;
    }

    public void setMachingOnDrag(MachingOnDrag machingOnDrag) {
        this.machingOnDrag = machingOnDrag;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public void setDragListener(OnStartDragListener dragStartListener) {
        this.mDragStartListener = dragStartListener;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder implements DragItemTouchHelper.TouchViewHolder {
        public ImageButton bt_move;
        public ImageView image;
        public LinearLayout llmain;
        public View lyt_parent;
        public TextView name;
        public TextView optionIconTV;

        public OriginalViewHolder(View v) {
            super(v);
            this.image = (ImageView) v.findViewById(R.id.image);
            this.name = (TextView) v.findViewById(R.id.name);
            this.llmain = (LinearLayout) v.findViewById(R.id.llmain);
            this.optionIconTV = (TextView) v.findViewById(R.id.optionIconTV);
            this.lyt_parent = v.findViewById(R.id.lyt_parent);
        }

        @Override // com.appnew.android.testmodule.adapter.DragItemTouchHelper.TouchViewHolder
        public void onItemSelected() {
            this.itemView.setBackgroundColor(AdapterMatchingListDrag.this.ctx.getResources().getColor(R.color.light_quiz_grey));
        }

        @Override // com.appnew.android.testmodule.adapter.DragItemTouchHelper.TouchViewHolder
        public void onItemClear(int toPosition) {
            this.itemView.setBackgroundColor(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OriginalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drag, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder originalViewHolder = (OriginalViewHolder) holder;
            Social social = this.items.get(position);
            originalViewHolder.name.setText(social.name);
            originalViewHolder.optionIconTV.setText(social.option);
            if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().size() != 0 && ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted() != null) {
                int i = 0;
                while (true) {
                    if (i >= ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().size()) {
                        break;
                    }
                    if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().get(i).getPosition() == position) {
                        if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().get(i).isSelect()) {
                            originalViewHolder.llmain.setSelected(true);
                            originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.white));
                            LinearLayout linearLayout = originalViewHolder.llmain;
                            Activity activity = this.ctx;
                            linearLayout.setBackground(ContextCompat.getDrawable(activity, ((TestBaseActivity) activity).questionBankList.get(this.pagerposition).getSelcted().get(i).getBgcolor_code()));
                            TextView textView = originalViewHolder.optionIconTV;
                            Activity activity2 = this.ctx;
                            textView.setBackground(ContextCompat.getDrawable(activity2, ((TestBaseActivity) activity2).questionBankList.get(this.pagerposition).getSelcted().get(i).getCirclecolor_code()));
                        } else {
                            originalViewHolder.llmain.setSelected(false);
                            originalViewHolder.llmain.setBackground(this.ctx.getResources().getDrawable(R.drawable.bg_mcq_unselected));
                            originalViewHolder.optionIconTV.setBackground(this.ctx.getResources().getDrawable(R.drawable.circle_unselect));
                            originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.grey_80));
                        }
                    } else {
                        originalViewHolder.llmain.setSelected(false);
                        originalViewHolder.llmain.setBackground(this.ctx.getResources().getDrawable(R.drawable.bg_mcq_unselected));
                        originalViewHolder.optionIconTV.setBackground(this.ctx.getResources().getDrawable(R.drawable.circle_unselect));
                        originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.grey_80));
                        i++;
                    }
                }
            } else if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted() != null) {
                originalViewHolder.llmain.setSelected(false);
                originalViewHolder.llmain.setBackground(this.ctx.getResources().getDrawable(R.drawable.bg_mcq_unselected));
                originalViewHolder.optionIconTV.setBackground(this.ctx.getResources().getDrawable(R.drawable.circle_unselect));
                originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.grey_80));
            }
            originalViewHolder.lyt_parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.adapter.AdapterMatchingListDrag$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(holder, position, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(RecyclerView.ViewHolder viewHolder, int i, View view) {
        if (this.mOnItemClickListener != null) {
            OriginalViewHolder originalViewHolder = (OriginalViewHolder) viewHolder;
            if (originalViewHolder.llmain.isSelected()) {
                if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().size() != 0 && ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted() != null) {
                    for (int i2 = 0; i2 < ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().size(); i2++) {
                        if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().get(i2).getPosition() == i && ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().get(i2).isSelect()) {
                            int i3 = 0;
                            while (true) {
                                if (i3 < TestBaseActivity.SAMPLE_CIRCLE.length) {
                                    int circlecolor_code = ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().get(i2).getCirclecolor_code();
                                    if (circlecolor_code == TestBaseActivity.SAMPLE_CIRCLE[i3]) {
                                        this.machingOnDrag.sendOnclickInd(i3);
                                        break;
                                    }
                                    i3++;
                                }
                            }
                        }
                    }
                }
                originalViewHolder.llmain.setSelected(false);
                originalViewHolder.llmain.setBackground(this.ctx.getResources().getDrawable(R.drawable.bg_mcq_unselected));
                originalViewHolder.optionIconTV.setBackground(this.ctx.getResources().getDrawable(R.drawable.circle_unselect));
                originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.grey_80));
                this.mOnItemClickListener.onItemClick(view, this.items.get(i), i, TestBaseActivity.nestbg, TestBaseActivity.nestcirclebg, false);
            } else if (TestBaseActivity.nestselected) {
                originalViewHolder.llmain.setSelected(true);
                originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.white));
                originalViewHolder.llmain.setBackground(ContextCompat.getDrawable(this.ctx, TestBaseActivity.nestbg));
                originalViewHolder.optionIconTV.setBackground(ContextCompat.getDrawable(this.ctx, TestBaseActivity.nestcirclebg));
                TestBaseActivity.nestselected = false;
                TestBaseActivity.matchingPositiondrag = i;
                this.mOnItemClickListener.onItemClick(view, this.items.get(i), i, TestBaseActivity.nestbg, TestBaseActivity.nestcirclebg, true);
            } else if (TestBaseActivity.matchingPositiondrag != -1) {
                int i4 = 0;
                while (true) {
                    if (i4 >= ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().size()) {
                        break;
                    }
                    if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().get(i4).getPosition() == TestBaseActivity.matchingPositiondrag) {
                        ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted().remove(i4);
                        break;
                    }
                    i4++;
                }
                originalViewHolder.llmain.setSelected(true);
                originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.white));
                originalViewHolder.llmain.setBackground(ContextCompat.getDrawable(this.ctx, TestBaseActivity.nestbg));
                originalViewHolder.optionIconTV.setBackground(ContextCompat.getDrawable(this.ctx, TestBaseActivity.nestcirclebg));
                TestBaseActivity.nestselected = false;
                TestBaseActivity.matchingPositiondrag = i;
                this.mOnItemClickListener.onItemClick(view, this.items.get(i), i, TestBaseActivity.nestbg, TestBaseActivity.nestcirclebg, true);
                notifyDataSetChanged();
            } else if (TestBaseActivity.sameselected) {
                originalViewHolder.llmain.setSelected(true);
                originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.white));
                originalViewHolder.llmain.setBackground(ContextCompat.getDrawable(this.ctx, TestBaseActivity.nestbg));
                originalViewHolder.optionIconTV.setBackground(ContextCompat.getDrawable(this.ctx, TestBaseActivity.nestcirclebg));
                TestBaseActivity.nestselected = false;
                TestBaseActivity.matchingPositiondrag = i;
                this.mOnItemClickListener.onItemClick(view, this.items.get(i), i, TestBaseActivity.nestbg, TestBaseActivity.nestcirclebg, true);
            }
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // com.appnew.android.testmodule.adapter.DragItemTouchHelper.MoveHelperAdapter
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(this.items, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }
}
