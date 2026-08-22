package com.appnew.android.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.JWextractor.JWVideoPlayer;
import com.appnew.android.Model.PlayerPojo.VideoTimeFramePojo;
import com.eduteria.app.app.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class BookmarkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;
    List<VideoTimeFramePojo> data;
    String fromwhere;
    public int position;

    public BookmarkAdapter(Activity activity, List<VideoTimeFramePojo> data, String fromwhere) {
        this.data = data;
        this.activity = activity;
        this.fromwhere = fromwhere;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.bookmark_index_row, (ViewGroup) null));
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView deleteIV;
        TextView timeTV;
        TextView tittleTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.deleteIV = (ImageView) itemView.findViewById(R.id.del_iv);
            this.timeTV = (TextView) itemView.findViewById(R.id.vediotime);
            TextView textView = (TextView) itemView.findViewById(R.id.vediotitle);
            this.tittleTV = textView;
            textView.setSelected(true);
            this.deleteIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.BookmarkAdapter.MyViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BookmarkAdapter.this.alert_dialog(MyViewHolder.this.getAbsoluteAdapterPosition());
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.BookmarkAdapter.MyViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Date date;
                    if (BookmarkAdapter.this.data == null || BookmarkAdapter.this.data.get(MyViewHolder.this.getAbsoluteAdapterPosition()) == null || TextUtils.isEmpty(BookmarkAdapter.this.data.get(MyViewHolder.this.getAbsoluteAdapterPosition()).getTime())) {
                        return;
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    try {
                        date = simpleDateFormat.parse("1970-01-01 " + BookmarkAdapter.this.data.get(MyViewHolder.this.getAbsoluteAdapterPosition()).getTime());
                    } catch (ParseException e2) {
                        e2.printStackTrace();
                        date = null;
                    }
                    if (date != null) {
                        if (BookmarkAdapter.this.fromwhere.equalsIgnoreCase("jwplayer")) {
                            ((JWVideoPlayer) BookmarkAdapter.this.activity).setVideoTimeMS((int) date.getTime());
                            return;
                        }
                        if (BookmarkAdapter.this.fromwhere.equalsIgnoreCase("Liveaws")) {
                            ((Liveawsactivity) BookmarkAdapter.this.activity).setVideoTimeMS((int) date.getTime());
                            return;
                        } else if (BookmarkAdapter.this.fromwhere.equalsIgnoreCase("voddrm")) {
                            ((VODPlayerActivity) BookmarkAdapter.this.activity).setVideoTimeMS((int) date.getTime());
                            return;
                        } else {
                            ((CustomMediaPlayer) BookmarkAdapter.this.activity).setVideoTimeMS((int) date.getTime());
                            return;
                        }
                    }
                    Toast.makeText(BookmarkAdapter.this.activity, "Invalid time", 0).show();
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder sholder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) sholder;
        List<VideoTimeFramePojo> list = this.data;
        if (list != null && list.get(position) != null && !TextUtils.isEmpty(this.data.get(position).getTime())) {
            myViewHolder.timeTV.setText(this.data.get(position).getTime());
        } else {
            myViewHolder.timeTV.setText("N/A");
        }
        List<VideoTimeFramePojo> list2 = this.data;
        if (list2 != null && list2.get(position) != null && !TextUtils.isEmpty(this.data.get(position).getInfo())) {
            myViewHolder.tittleTV.setText(this.data.get(position).getInfo());
        } else {
            myViewHolder.tittleTV.setText("N/A");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alert_dialog(final int adapterPosition) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setTitle(this.activity.getResources().getString(R.string.delete_bookmark));
        builder.setMessage(this.activity.getResources().getString(R.string.are_you_sure_you_want_to_delete_the_bookmark));
        builder.setNegativeButton(this.activity.getResources().getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.BookmarkAdapter$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.BookmarkAdapter$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$alert_dialog$1(adapterPosition, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$1(int i, DialogInterface dialogInterface, int i2) {
        if (i >= 0 && i < this.data.size()) {
            VideoTimeFramePojo videoTimeFramePojo = this.data.get(i);
            if (this.fromwhere.equalsIgnoreCase("jwplayer")) {
                ((JWVideoPlayer) this.activity).onDelete(videoTimeFramePojo, i);
            } else if (this.fromwhere.equalsIgnoreCase("Liveaws")) {
                ((Liveawsactivity) this.activity).onDelete(videoTimeFramePojo, i);
            } else if (this.fromwhere.equalsIgnoreCase("voddrm")) {
                ((VODPlayerActivity) this.activity).onDelete(videoTimeFramePojo, i);
            } else {
                ((CustomMediaPlayer) this.activity).onDelete(videoTimeFramePojo, i);
            }
        } else {
            Toast.makeText(this.activity, "Item already removed", 0).show();
        }
        dialogInterface.dismiss();
    }
}
