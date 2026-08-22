package com.appnew.android.Download.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.Interface.onItemClick;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.PDFViewerJS.PDFViewerJS;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.table.PDFDataTable;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadPDFAdapter extends RecyclerView.Adapter<StreamHolder> {
    BottomSetting bottomSetting;
    Context context;
    private boolean delete_check = false;
    private List<PDFDataTable> download_pdfs;
    private onItemClick onclick;
    ThemeSettings themeSettings;
    public UtkashRoom utkashRoom;

    public DownloadPDFAdapter(Context context, ArrayList<PDFDataTable> download_pdfs, onItemClick onclick) {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.context = context;
        this.download_pdfs = download_pdfs;
        this.onclick = onclick;
        if (this.themeSettings != null) {
            this.themeSettings = appDatabase.getthemeSettingdao().data();
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StreamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StreamHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.download_adpter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final StreamHolder holder, final int position) {
        int absoluteAdapterPosition = holder.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition == -1 || absoluteAdapterPosition >= this.download_pdfs.size()) {
            return;
        }
        holder.cancel_progress_layout.setVisibility(8);
        setThumbRatio(holder.rlThumb);
        holder.video_name.setText(this.download_pdfs.get(holder.getAbsoluteAdapterPosition()).getPdfName());
        String pdfImage = this.download_pdfs.get(holder.getAbsoluteAdapterPosition()).getPdfImage();
        int i = R.mipmap.square_placeholder;
        if (pdfImage != null && !this.download_pdfs.get(holder.getAbsoluteAdapterPosition()).getPdfImage().equalsIgnoreCase("")) {
            RequestBuilder<Drawable> requestBuilderLoad = Glide.with(holder.courseImage).load(this.download_pdfs.get(position).getPdfImage());
            if (!setThumbAccordingRatio()) {
                i = R.mipmap.square_placeholder_new;
            }
            requestBuilderLoad.placeholder(i).into(holder.courseImage);
        } else {
            ImageView imageView = holder.courseImage;
            if (!setThumbAccordingRatio()) {
                i = R.mipmap.square_placeholder_new;
            }
            imageView.setImageResource(i);
        }
        holder.study_single_itemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.Adapter.DownloadPDFAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int absoluteAdapterPosition2 = holder.getAbsoluteAdapterPosition();
                if (absoluteAdapterPosition2 == -1 || absoluteAdapterPosition2 >= DownloadPDFAdapter.this.download_pdfs.size()) {
                    return;
                }
                if (BuildConfig.FLAVOR.equalsIgnoreCase("labaa")) {
                    Intent intent = new Intent(DownloadPDFAdapter.this.context, (Class<?>) PDFViewerJS.class);
                    intent.putExtra("mode", OfflineMessageRequest.ELEMENT);
                    intent.putExtra("pdf_name", ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).getPdfName());
                    intent.putExtra("title", ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).getPdfFile());
                    intent.putExtra("url", ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).getPdfPath());
                    DownloadPDFAdapter.this.context.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(DownloadPDFAdapter.this.context, (Class<?>) PdfDetailScreen.class);
                intent2.putExtra("url", ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).getPdfPath());
                intent2.putExtra("title", ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).getPdfFile());
                intent2.putExtra("pdf_name", ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).getPdfName());
                intent2.putExtra("course_id", ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).getPdfId());
                intent2.putExtra("is_share", ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).getIsShare());
                intent2.putExtra("save", true);
                intent2.putExtra("download_file", true);
                intent2.putExtra(Const.IS_DOWNLOAD, true);
                DownloadPDFAdapter downloadPDFAdapter = DownloadPDFAdapter.this;
                if (downloadPDFAdapter.getFileExist(((PDFDataTable) downloadPDFAdapter.download_pdfs.get(holder.getAbsoluteAdapterPosition())).getPdfPath()).exists()) {
                    DownloadPDFAdapter.this.context.startActivity(intent2);
                } else {
                    Toast.makeText(DownloadPDFAdapter.this.context, "File is not exist", 0).show();
                }
            }
        });
        holder.selected_video.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.Download.Adapter.DownloadPDFAdapter.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int absoluteAdapterPosition2 = holder.getAbsoluteAdapterPosition();
                if (absoluteAdapterPosition2 == -1 || absoluteAdapterPosition2 >= DownloadPDFAdapter.this.download_pdfs.size()) {
                    return;
                }
                if (isChecked) {
                    ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).setIs_selected("1");
                } else {
                    ((PDFDataTable) DownloadPDFAdapter.this.download_pdfs.get(holder.getAbsoluteAdapterPosition())).setIs_selected("0");
                }
                ((DownloadActivity) DownloadPDFAdapter.this.context).visibleSelectButtonPdf(DownloadPDFAdapter.this.download_pdfs);
            }
        });
        if (this.delete_check) {
            holder.file_mb.setText("Select");
            if (this.download_pdfs.get(holder.getAbsoluteAdapterPosition()).getIs_selected() != null && this.download_pdfs.get(holder.getAbsoluteAdapterPosition()).getIs_selected().equalsIgnoreCase("1")) {
                holder.selected_video.setChecked(true);
            } else {
                holder.selected_video.setChecked(false);
            }
            holder.delete_layout.setVisibility(0);
            return;
        }
        holder.delete_layout.setVisibility(8);
    }

    public File getFileExist(String fileName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
            return new File(fileName);
        }
        return new File(fileName);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.download_pdfs.size();
    }

    private void setThumbRatio(RelativeLayout rlThum) {
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        ViewGroup.LayoutParams layoutParams = rlThum.getLayoutParams();
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) {
            return;
        }
        layoutParams.height = (int) (Helper.grideHeight * displayMetrics.scaledDensity);
        layoutParams.width = (int) (Helper.grideWidth * displayMetrics.scaledDensity);
        rlThum.setLayoutParams(layoutParams);
    }

    private boolean setThumbAccordingRatio() {
        BottomSetting bottomSetting = this.bottomSetting;
        return (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) ? false : true;
    }

    public void visible_layout(boolean delete_check, ArrayList<PDFDataTable> download_pdfs) {
        try {
            this.delete_check = delete_check;
            notifyDataSetChanged();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public void notifydata(List<PDFDataTable> download_pdfs) {
        try {
            this.download_pdfs = download_pdfs;
            this.delete_check = false;
            notifyDataSetChanged();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public class StreamHolder extends RecyclerView.ViewHolder {
        RelativeLayout cancel_progress_layout;
        ImageView courseImage;
        RelativeLayout delete_layout;
        ImageView download_icon;
        TextView file_mb;
        ProgressBar loadingProgress;
        ImageView optionPauseImgView;
        RelativeLayout pauseLayout;
        TextView pauseTextView;
        TextView percentageTxt;
        RelativeLayout rlThumb;
        CheckBox selected_video;
        LinearLayout study_single_itemLL;
        TextView video_name;
        TextView video_time;

        public StreamHolder(View itemView) {
            super(itemView);
            this.rlThumb = (RelativeLayout) itemView.findViewById(R.id.rlThumb);
            this.video_time = (TextView) itemView.findViewById(R.id.video_time);
            this.file_mb = (TextView) itemView.findViewById(R.id.file_mb);
            this.selected_video = (CheckBox) itemView.findViewById(R.id.check_box);
            this.delete_layout = (RelativeLayout) itemView.findViewById(R.id.delete_layout);
            this.loadingProgress = (ProgressBar) itemView.findViewById(R.id.loadingProgress);
            this.percentageTxt = (TextView) itemView.findViewById(R.id.percentageTxt);
            this.download_icon = (ImageView) itemView.findViewById(R.id.download_icon);
            this.cancel_progress_layout = (RelativeLayout) itemView.findViewById(R.id.cancel_progress_layout);
            this.video_name = (TextView) itemView.findViewById(R.id.video_name);
            this.courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            this.pauseLayout = (RelativeLayout) itemView.findViewById(R.id.pauseLayout);
            this.pauseTextView = (TextView) itemView.findViewById(R.id.pauseTextView);
            this.optionPauseImgView = (ImageView) itemView.findViewById(R.id.optionPauseImgView);
            this.study_single_itemLL = (LinearLayout) itemView.findViewById(R.id.study_single_itemLL);
        }
    }
}
