package com.appnew.android.player;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Model.DataList;
import com.appnew.android.Model.PlayerPojo.Pdf;
import com.appnew.android.PDFViewerJS.PDFViewerJS;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class NotesAdapter extends RecyclerView.Adapter<Viewholder> {
    private Activity con;
    String course_id;
    public File filepath;
    boolean is_download;
    String name;
    private List<Pdf> pdf;
    List<DataList> pdfLists;
    Progress progress;

    public NotesAdapter(Activity con, List<Pdf> pdf, String course_id) {
        this.name = "";
        this.is_download = false;
        this.con = con;
        this.pdf = pdf;
        this.course_id = course_id;
    }

    public NotesAdapter(Activity con, List<DataList> pdfLists) {
        this.course_id = "";
        this.name = "";
        this.is_download = false;
        this.con = con;
        this.pdfLists = pdfLists;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(this.con).inflate(R.layout.activity_cardview_notes, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Viewholder holder, final int position) {
        List<DataList> list = this.pdfLists;
        if (list != null && list.size() > 0) {
            final DataList dataList = this.pdfLists.get(position);
            holder.pdftext.setText(dataList.getPdfTitle());
            if (!TextUtils.isEmpty(dataList.getPdfThumbnail())) {
                Helper.setThumbnailImage(this.con, dataList.getPdfThumbnail(), this.con.getResources().getDrawable(R.mipmap.square_placeholder), holder.iv_pdf);
            } else {
                holder.iv_pdf.setImageResource(R.mipmap.square_placeholder);
            }
            holder.rl3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.NotesAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("labaa")) {
                        Intent intent = new Intent(NotesAdapter.this.con, (Class<?>) PDFViewerJS.class);
                        intent.putExtra("type", dataList.getPdfTitle());
                        intent.putExtra("url", dataList.getPdfUrl());
                        intent.putExtra(Const.VIDEO_ID, dataList.getId());
                        intent.putExtra("pdf_name", dataList.getPdfTitle());
                        Helper.gotoActivity(intent, NotesAdapter.this.con);
                        return;
                    }
                    Helper.GoToWebViewPDFActivity(NotesAdapter.this.con, dataList.getId(), dataList.getPdfUrl(), !TextUtils.isEmpty(dataList.getIsDownloadable()) && dataList.getIsDownloadable().equalsIgnoreCase("1"), dataList.getPdfTitle(), NotesAdapter.this.course_id, dataList.getIs_share());
                }
            });
            return;
        }
        holder.pdftext.setText(this.pdf.get(position).getPdfTitle());
        if (!TextUtils.isEmpty(this.pdf.get(position).getPdfThumbnail())) {
            Helper.setThumbnailImage(this.con, this.pdf.get(position).getPdfThumbnail(), this.con.getResources().getDrawable(R.mipmap.square_placeholder), holder.iv_pdf);
        } else {
            holder.iv_pdf.setImageResource(R.mipmap.square_placeholder);
        }
        holder.rl3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.NotesAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (BuildConfig.FLAVOR.equalsIgnoreCase("labaa")) {
                    Intent intent = new Intent(NotesAdapter.this.con, (Class<?>) PDFViewerJS.class);
                    intent.putExtra("type", ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfTitle());
                    intent.putExtra("url", ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfUrl());
                    intent.putExtra(Const.VIDEO_ID, ((Pdf) NotesAdapter.this.pdf.get(position)).getId());
                    intent.putExtra("pdf_name", ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfTitle());
                    Helper.gotoActivity(intent, NotesAdapter.this.con);
                    return;
                }
                boolean z = !TextUtils.isEmpty(((Pdf) NotesAdapter.this.pdf.get(position)).getIsDownloadable()) && ((Pdf) NotesAdapter.this.pdf.get(position)).getIsDownloadable().equalsIgnoreCase("1");
                if (SharedPreference.getInstance().getString(Const.IS_LIVE_CLASS_PDF_SHOW) != null && SharedPreference.getInstance().getString(Const.IS_LIVE_CLASS_PDF_SHOW).equalsIgnoreCase("1")) {
                    if (NotesAdapter.this.con instanceof LiveStreamingYoutube) {
                        ((LiveStreamingYoutube) NotesAdapter.this.con).CallPDFOnSameScreen(((Pdf) NotesAdapter.this.pdf.get(position)).getId(), ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfUrl(), z, ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfTitle(), NotesAdapter.this.course_id, ((Pdf) NotesAdapter.this.pdf.get(position)).getIs_share());
                        return;
                    } else if (NotesAdapter.this.con instanceof Liveawsactivity) {
                        ((Liveawsactivity) NotesAdapter.this.con).CallPDFOnSameScreen(((Pdf) NotesAdapter.this.pdf.get(position)).getId(), ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfUrl(), z, ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfTitle(), NotesAdapter.this.course_id, ((Pdf) NotesAdapter.this.pdf.get(position)).getIs_share());
                        return;
                    } else {
                        if (NotesAdapter.this.con instanceof VODPlayerActivity) {
                            ((VODPlayerActivity) NotesAdapter.this.con).CallPDFOnSameScreen(((Pdf) NotesAdapter.this.pdf.get(position)).getId(), ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfUrl(), z, ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfTitle(), NotesAdapter.this.course_id, ((Pdf) NotesAdapter.this.pdf.get(position)).getIs_share());
                            return;
                        }
                        return;
                    }
                }
                Helper.GoToWebViewPDFActivity(NotesAdapter.this.con, ((Pdf) NotesAdapter.this.pdf.get(position)).getId(), ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfUrl(), z, ((Pdf) NotesAdapter.this.pdf.get(position)).getPdfTitle(), NotesAdapter.this.course_id, ((Pdf) NotesAdapter.this.pdf.get(position)).getIs_share());
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Pdf> list = this.pdf;
        if (list != null && list.size() > 0) {
            return this.pdf.size();
        }
        List<DataList> list2 = this.pdfLists;
        if (list2 == null || list2.size() <= 0) {
            return 0;
        }
        return this.pdfLists.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView iv_pdf;
        TextView pdftext;
        RelativeLayout rl3;
        ImageView textpdf;

        public Viewholder(View itemView) {
            super(itemView);
            this.textpdf = (ImageView) itemView.findViewById(R.id.textpdf);
            this.pdftext = (TextView) itemView.findViewById(R.id.pdftext);
            this.iv_pdf = (ImageView) itemView.findViewById(R.id.iv_pdf);
            this.rl3 = (RelativeLayout) itemView.findViewById(R.id.rl3);
        }
    }

    public void openwatchlist_dailog_resource(Context context, final Pdf course) {
        try {
            if (!this.con.isFinishing() && !this.con.isDestroyed()) {
                ((Liveawsactivity) this.con).pdf_view_layout.setVisibility(0);
                ((Liveawsactivity) this.con).recyclerChat.setVisibility(8);
                Progress progress = new Progress(context);
                this.progress = progress;
                progress.setCancelable(true);
                if (!this.progress.isShowing()) {
                    this.progress.show();
                }
                new LOADURL(this.con).execute(course.getPdfUrl());
                ((Liveawsactivity) this.con).cross.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.NotesAdapter$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$openwatchlist_dailog_resource$0(view);
                    }
                });
                ((Liveawsactivity) this.con).expand.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.NotesAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$openwatchlist_dailog_resource$1(course, view);
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$0(View view) {
        ((Liveawsactivity) this.con).showPDF(this.filepath.getPath());
        ((Liveawsactivity) this.con).pdf_view_layout.setVisibility(8);
        ((Liveawsactivity) this.con).recyclerChat.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$1(Pdf pdf, View view) {
        ((Liveawsactivity) this.con).showPDF(this.filepath.getPath());
        ((Liveawsactivity) this.con).pdf_view_layout.setVisibility(8);
        boolean z = false;
        ((Liveawsactivity) this.con).recyclerChat.setVisibility(0);
        if (!TextUtils.isEmpty(pdf.getIsDownloadable()) && pdf.getIsDownloadable().equalsIgnoreCase("1")) {
            z = true;
        }
        Helper.GoToWebViewPDFActivity(this.con, pdf.getId(), pdf.getPdfUrl(), z, pdf.getPdfTitle(), this.course_id, pdf.getIs_share());
    }

    public void openPDF(Context context, final File localUri, final Progress progreebar) {
        ((Liveawsactivity) this.con).showPDF(localUri.getPath());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.player.NotesAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NotesAdapter.lambda$openPDF$2(localUri, progreebar);
            }
        }, 2000L);
    }

    static /* synthetic */ void lambda$openPDF$2(File file, Progress progress) {
        if (file.exists()) {
            file.delete();
        }
        progress.dismiss();
    }

    public class LOADURL extends AsyncTask<String, Integer, String> {
        String response = "";
        HttpURLConnection urlConnection = null;
        InputStream input = null;
        OutputStream output = null;

        public LOADURL(Activity con) {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            NotesAdapter.this.progress.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.player.NotesAdapter.LOADURL.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialog) {
                    LOADURL.this.cancel(true);
                    Toast.makeText(NotesAdapter.this.con, NotesAdapter.this.con.getResources().getString(R.string.pdf_loading_error_please_wait), 0).show();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(String s) {
            super.onCancelled(s);
            this.response = "error";
            if (isCancelled()) {
                try {
                    this.output.flush();
                    this.output.close();
                    this.input.close();
                    HttpURLConnection httpURLConnection = this.urlConnection;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (NotesAdapter.this.filepath.exists()) {
                        NotesAdapter.this.filepath.delete();
                    }
                    onPostExecute(this.response);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0152 A[PHI: r8
          0x0152: PHI (r8v5 java.net.HttpURLConnection) = (r8v1 java.net.HttpURLConnection), (r8v13 java.net.HttpURLConnection) binds: [B:63:0x0150, B:51:0x0139] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String doInBackground(java.lang.String... r8) {
            /*
                Method dump skipped, instruction units count: 366
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.NotesAdapter.LOADURL.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... values) {
            super.onProgressUpdate((Object[]) values);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String response) {
            if (response != null && response.equalsIgnoreCase("success")) {
                NotesAdapter notesAdapter = NotesAdapter.this;
                notesAdapter.openPDF(notesAdapter.con, NotesAdapter.this.filepath, NotesAdapter.this.progress);
                return;
            }
            NotesAdapter.this.progress.dismiss();
            if (NotesAdapter.this.con instanceof Liveawsactivity) {
                ((Liveawsactivity) NotesAdapter.this.con).pdf_view_layout.setVisibility(8);
                ((Liveawsactivity) NotesAdapter.this.con).recyclerChat.setVisibility(0);
            } else {
                ((Liveawsactivity) NotesAdapter.this.con).pdf_view_layout.setVisibility(8);
                ((Liveawsactivity) NotesAdapter.this.con).recyclerChat.setVisibility(0);
            }
        }
    }
}
