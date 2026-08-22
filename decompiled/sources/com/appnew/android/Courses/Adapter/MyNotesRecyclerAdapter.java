package com.appnew.android.Courses.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Interfaces.OnMyNotesItemListener;
import com.appnew.android.Courses.Modal.NotesPDF.NoteData;
import com.appnew.android.Utils.Const;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class MyNotesRecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    private ArrayList<NoteData> filteredList;
    private OnMyNotesItemListener mListener;

    public MyNotesRecyclerAdapter(Context context, ArrayList<NoteData> filteredList) {
        this.context = context;
        this.filteredList = filteredList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_notes_item_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final NoteData noteData = this.filteredList.get(position);
        if (noteData.getType().equalsIgnoreCase(Const.NOTE)) {
            holder.edit_btn.setVisibility(8);
            holder.delete_btn.setVisibility(8);
        } else {
            holder.edit_btn.setVisibility(8);
            holder.delete_btn.setVisibility(8);
        }
        if (!TextUtils.isEmpty(noteData.getTitle())) {
            holder.notes_title.setVisibility(0);
            holder.notes_title.setText(noteData.getTitle());
        } else {
            holder.notes_title.setVisibility(8);
        }
        holder.notes_desc.setText(noteData.getQueryData());
        holder.edit_btn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.MyNotesRecyclerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MyNotesRecyclerAdapter myNotesRecyclerAdapter = MyNotesRecyclerAdapter.this;
                myNotesRecyclerAdapter.mListener = (OnMyNotesItemListener) myNotesRecyclerAdapter.context;
                if (MyNotesRecyclerAdapter.this.mListener != null) {
                    MyNotesRecyclerAdapter.this.mListener.onMyNotesEditClick(noteData, position);
                }
            }
        });
        holder.delete_btn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.MyNotesRecyclerAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MyNotesRecyclerAdapter myNotesRecyclerAdapter = MyNotesRecyclerAdapter.this;
                myNotesRecyclerAdapter.mListener = (OnMyNotesItemListener) myNotesRecyclerAdapter.context;
                if (MyNotesRecyclerAdapter.this.mListener != null) {
                    MyNotesRecyclerAdapter.this.mListener.onMyNotesDeleteClick(noteData, position);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.filteredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView delete_btn;
        CardView edit_btn;
        public final View mView;
        TextView notes_desc;
        TextView notes_title;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.edit_btn = (CardView) this.itemView.findViewById(R.id.edit_btn);
            this.delete_btn = (CardView) this.itemView.findViewById(R.id.delete_btn);
            this.notes_title = (TextView) this.itemView.findViewById(R.id.notes_title);
            this.notes_desc = (TextView) this.itemView.findViewById(R.id.notes_desc);
        }
    }
}
