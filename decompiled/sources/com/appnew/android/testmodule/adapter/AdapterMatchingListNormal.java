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
import com.appnew.android.testmodule.model.Social;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class AdapterMatchingListNormal extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int[] androidColors;
    private Activity ctx;
    private List<Social> items;
    private OnItemClickListener mOnItemClickListener;
    MachingOnDrag machingOnDrag;
    int pagerposition;

    public interface MachingOnDrag {
        void sendOnclickInd(int position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Social obj, int bg, int circle, boolean select);
    }

    public interface OnStartDragListener {
        void onStartDrag(RecyclerView.ViewHolder viewHolder);
    }

    public AdapterMatchingListNormal(Activity context, List<Social> items, int[] androidColors, int position) {
        new ArrayList();
        this.items = items;
        this.androidColors = androidColors;
        this.pagerposition = position;
        this.ctx = context;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public void setMachingOnDrag(MachingOnDrag machingOnDrag) {
        this.machingOnDrag = machingOnDrag;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
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
            if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted2().size() != 0 && ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted2() != null) {
                int i = 0;
                while (true) {
                    if (i >= ((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted2().size()) {
                        break;
                    }
                    if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted2().get(i).getPosition() == position) {
                        if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted2().get(i).isSelect()) {
                            originalViewHolder.llmain.setSelected(true);
                            originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.white));
                            LinearLayout linearLayout = originalViewHolder.llmain;
                            Activity activity = this.ctx;
                            linearLayout.setBackground(ContextCompat.getDrawable(activity, ((TestBaseActivity) activity).questionBankList.get(this.pagerposition).getSelcted2().get(i).getBgcolor_code()));
                            TextView textView = originalViewHolder.optionIconTV;
                            Activity activity2 = this.ctx;
                            textView.setBackground(ContextCompat.getDrawable(activity2, ((TestBaseActivity) activity2).questionBankList.get(this.pagerposition).getSelcted2().get(i).getCirclecolor_code()));
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
            } else if (((TestBaseActivity) this.ctx).questionBankList.get(this.pagerposition).getSelcted2() != null) {
                originalViewHolder.llmain.setSelected(false);
                originalViewHolder.llmain.setBackground(this.ctx.getResources().getDrawable(R.drawable.bg_mcq_unselected));
                originalViewHolder.optionIconTV.setBackground(this.ctx.getResources().getDrawable(R.drawable.circle_unselect));
                originalViewHolder.optionIconTV.setTextColor(this.ctx.getResources().getColor(R.color.grey_80));
            }
            originalViewHolder.lyt_parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.adapter.AdapterMatchingListNormal.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdapterMatchingListNormal.this.mOnItemClickListener != null) {
                        int i2 = 0;
                        if (((OriginalViewHolder) holder).llmain.isSelected()) {
                            if (((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted2().size() != 0 && ((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted2() != null) {
                                for (int i3 = 0; i3 < ((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted2().size(); i3++) {
                                    if (((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted2().get(i3).getPosition() == position && ((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted2().get(i3).isSelect()) {
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= ((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted().size()) {
                                                break;
                                            }
                                            if (((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted().get(i4).getCirclecolor_code() == ((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted2().get(i3).getCirclecolor_code()) {
                                                AdapterMatchingListNormal.this.machingOnDrag.sendOnclickInd(i4);
                                                break;
                                            }
                                            i4++;
                                        }
                                    }
                                }
                            }
                            ((OriginalViewHolder) holder).llmain.setSelected(false);
                            ((OriginalViewHolder) holder).llmain.setBackground(AdapterMatchingListNormal.this.ctx.getResources().getDrawable(R.drawable.bg_mcq_unselected));
                            ((OriginalViewHolder) holder).optionIconTV.setBackground(AdapterMatchingListNormal.this.ctx.getResources().getDrawable(R.drawable.circle_unselect));
                            ((OriginalViewHolder) holder).optionIconTV.setTextColor(AdapterMatchingListNormal.this.ctx.getResources().getColor(R.color.grey_80));
                            AdapterMatchingListNormal.this.mOnItemClickListener.onItemClick(view, position, (Social) AdapterMatchingListNormal.this.items.get(position), TestBaseActivity.SAMPLE_BG[position], TestBaseActivity.SAMPLE_CIRCLE[position], false);
                            return;
                        }
                        if (!TestBaseActivity.nestselected) {
                            ((OriginalViewHolder) holder).llmain.setSelected(true);
                            ((OriginalViewHolder) holder).optionIconTV.setTextColor(AdapterMatchingListNormal.this.ctx.getResources().getColor(R.color.white));
                            ((OriginalViewHolder) holder).llmain.setBackground(ContextCompat.getDrawable(AdapterMatchingListNormal.this.ctx, TestBaseActivity.SAMPLE_BG[position]));
                            ((OriginalViewHolder) holder).optionIconTV.setBackground(ContextCompat.getDrawable(AdapterMatchingListNormal.this.ctx, TestBaseActivity.SAMPLE_CIRCLE[position]));
                            TestBaseActivity.nestcirclebg = TestBaseActivity.SAMPLE_CIRCLE[position];
                            TestBaseActivity.nestbg = TestBaseActivity.SAMPLE_BG[position];
                            TestBaseActivity.nestselected = true;
                            TestBaseActivity.matchingPosition = position;
                            AdapterMatchingListNormal.this.mOnItemClickListener.onItemClick(view, position, (Social) AdapterMatchingListNormal.this.items.get(position), TestBaseActivity.SAMPLE_BG[position], TestBaseActivity.SAMPLE_CIRCLE[position], true);
                            return;
                        }
                        if (TestBaseActivity.matchingPosition != -1) {
                            while (true) {
                                if (i2 >= ((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted2().size()) {
                                    break;
                                }
                                if (((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted2().get(i2).getPosition() == TestBaseActivity.matchingPosition) {
                                    ((TestBaseActivity) AdapterMatchingListNormal.this.ctx).questionBankList.get(AdapterMatchingListNormal.this.pagerposition).getSelcted2().remove(i2);
                                    break;
                                }
                                i2++;
                            }
                            ((OriginalViewHolder) holder).llmain.setSelected(true);
                            ((OriginalViewHolder) holder).optionIconTV.setTextColor(AdapterMatchingListNormal.this.ctx.getResources().getColor(R.color.white));
                            ((OriginalViewHolder) holder).llmain.setBackground(ContextCompat.getDrawable(AdapterMatchingListNormal.this.ctx, TestBaseActivity.SAMPLE_BG[position]));
                            ((OriginalViewHolder) holder).optionIconTV.setBackground(ContextCompat.getDrawable(AdapterMatchingListNormal.this.ctx, TestBaseActivity.SAMPLE_CIRCLE[position]));
                            TestBaseActivity.nestcirclebg = TestBaseActivity.SAMPLE_CIRCLE[position];
                            TestBaseActivity.nestbg = TestBaseActivity.SAMPLE_BG[position];
                            TestBaseActivity.nestselected = true;
                            TestBaseActivity.matchingPosition = position;
                            AdapterMatchingListNormal.this.mOnItemClickListener.onItemClick(view, position, (Social) AdapterMatchingListNormal.this.items.get(position), TestBaseActivity.SAMPLE_BG[position], TestBaseActivity.SAMPLE_CIRCLE[position], true);
                            AdapterMatchingListNormal.this.notifyDataSetChanged();
                            return;
                        }
                        ((OriginalViewHolder) holder).llmain.setSelected(true);
                        ((OriginalViewHolder) holder).optionIconTV.setTextColor(AdapterMatchingListNormal.this.ctx.getResources().getColor(R.color.white));
                        ((OriginalViewHolder) holder).llmain.setBackground(ContextCompat.getDrawable(AdapterMatchingListNormal.this.ctx, TestBaseActivity.SAMPLE_BG[position]));
                        ((OriginalViewHolder) holder).optionIconTV.setBackground(ContextCompat.getDrawable(AdapterMatchingListNormal.this.ctx, TestBaseActivity.SAMPLE_CIRCLE[position]));
                        TestBaseActivity.nestcirclebg = TestBaseActivity.SAMPLE_CIRCLE[position];
                        TestBaseActivity.nestbg = TestBaseActivity.SAMPLE_BG[position];
                        TestBaseActivity.nestselected = true;
                        TestBaseActivity.sameselected = true;
                        TestBaseActivity.matchingPosition = position;
                        AdapterMatchingListNormal.this.mOnItemClickListener.onItemClick(view, position, (Social) AdapterMatchingListNormal.this.items.get(position), TestBaseActivity.SAMPLE_BG[position], TestBaseActivity.SAMPLE_CIRCLE[position], true);
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
