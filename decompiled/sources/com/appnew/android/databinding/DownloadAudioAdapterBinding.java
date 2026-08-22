package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DownloadAudioAdapterBinding implements ViewBinding {
    public final RelativeLayout cancelProgressLayout;
    public final CheckBox checkBox;
    public final ImageView courseImage;
    public final RelativeLayout deleteLayout;
    public final ImageView downloadIcon;
    public final TextView fileMb;
    public final TextView percentageTxt;
    public final RelativeLayout rlThumb;
    private final RelativeLayout rootView;
    public final LinearLayout studySingleItemLL;
    public final TextView videoName;

    private DownloadAudioAdapterBinding(RelativeLayout rootView, RelativeLayout cancelProgressLayout, CheckBox checkBox, ImageView courseImage, RelativeLayout deleteLayout, ImageView downloadIcon, TextView fileMb, TextView percentageTxt, RelativeLayout rlThumb, LinearLayout studySingleItemLL, TextView videoName) {
        this.rootView = rootView;
        this.cancelProgressLayout = cancelProgressLayout;
        this.checkBox = checkBox;
        this.courseImage = courseImage;
        this.deleteLayout = deleteLayout;
        this.downloadIcon = downloadIcon;
        this.fileMb = fileMb;
        this.percentageTxt = percentageTxt;
        this.rlThumb = rlThumb;
        this.studySingleItemLL = studySingleItemLL;
        this.videoName = videoName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DownloadAudioAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DownloadAudioAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.download_audio_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DownloadAudioAdapterBinding bind(View rootView) {
        int i = R.id.cancel_progress_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cancel_progress_layout);
        if (relativeLayout != null) {
            i = R.id.check_box;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.check_box);
            if (checkBox != null) {
                i = R.id.courseImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImage);
                if (imageView != null) {
                    i = R.id.delete_layout;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.delete_layout);
                    if (relativeLayout2 != null) {
                        i = R.id.download_icon;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.download_icon);
                        if (imageView2 != null) {
                            i = R.id.file_mb;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.file_mb);
                            if (textView != null) {
                                i = R.id.percentageTxt;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.percentageTxt);
                                if (textView2 != null) {
                                    i = R.id.rlThumb;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rlThumb);
                                    if (relativeLayout3 != null) {
                                        i = R.id.study_single_itemLL;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                        if (linearLayout != null) {
                                            i = R.id.video_name;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.video_name);
                                            if (textView3 != null) {
                                                return new DownloadAudioAdapterBinding((RelativeLayout) rootView, relativeLayout, checkBox, imageView, relativeLayout2, imageView2, textView, textView2, relativeLayout3, linearLayout, textView3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
