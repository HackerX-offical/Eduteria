package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemTextChatLeftBinding implements ViewBinding {
    public final RelativeLayout cvrLeft;
    public final LinearLayout editedLayoutLeft;
    public final LinearLayout editedLayoutLeft1;
    public final ImageView ivPinMsgLeft;
    public final ImageView leftEditImg;
    public final TextView leftEdited;
    public final TextView lefttexttime;
    public final TextView letfmessageTv;
    public final LinearLayout navHeaderLL;
    public final ImageView replyFileImg;
    public final LinearLayout replyFileLl;
    public final TextView replyFileName;
    private final RelativeLayout rootView;
    public final LinearLayout studentCotLinear;
    public final TextView studentMessageTv;
    public final TextView studentName;
    public final LinearLayout timeRl1;
    public final TextView userName;

    private ItemTextChatLeftBinding(RelativeLayout rootView, RelativeLayout cvrLeft, LinearLayout editedLayoutLeft, LinearLayout editedLayoutLeft1, ImageView ivPinMsgLeft, ImageView leftEditImg, TextView leftEdited, TextView lefttexttime, TextView letfmessageTv, LinearLayout navHeaderLL, ImageView replyFileImg, LinearLayout replyFileLl, TextView replyFileName, LinearLayout studentCotLinear, TextView studentMessageTv, TextView studentName, LinearLayout timeRl1, TextView userName) {
        this.rootView = rootView;
        this.cvrLeft = cvrLeft;
        this.editedLayoutLeft = editedLayoutLeft;
        this.editedLayoutLeft1 = editedLayoutLeft1;
        this.ivPinMsgLeft = ivPinMsgLeft;
        this.leftEditImg = leftEditImg;
        this.leftEdited = leftEdited;
        this.lefttexttime = lefttexttime;
        this.letfmessageTv = letfmessageTv;
        this.navHeaderLL = navHeaderLL;
        this.replyFileImg = replyFileImg;
        this.replyFileLl = replyFileLl;
        this.replyFileName = replyFileName;
        this.studentCotLinear = studentCotLinear;
        this.studentMessageTv = studentMessageTv;
        this.studentName = studentName;
        this.timeRl1 = timeRl1;
        this.userName = userName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemTextChatLeftBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTextChatLeftBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_text_chat_left, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemTextChatLeftBinding bind(View rootView) {
        int i = R.id.cvrLeft;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeft);
        if (relativeLayout != null) {
            i = R.id.editedLayoutLeft;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.editedLayoutLeft);
            if (linearLayout != null) {
                i = R.id.editedLayoutLeft1;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.editedLayoutLeft1);
                if (linearLayout2 != null) {
                    i = R.id.ivPinMsgLeft;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeft);
                    if (imageView != null) {
                        i = R.id.leftEditImg;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.leftEditImg);
                        if (imageView2 != null) {
                            i = R.id.leftEdited;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.leftEdited);
                            if (textView != null) {
                                i = R.id.lefttexttime;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lefttexttime);
                                if (textView2 != null) {
                                    i = R.id.letfmessageTv;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.letfmessageTv);
                                    if (textView3 != null) {
                                        i = R.id.nav_headerLL;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nav_headerLL);
                                        if (linearLayout3 != null) {
                                            i = R.id.reply_file_img;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.reply_file_img);
                                            if (imageView3 != null) {
                                                i = R.id.reply_file_ll;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.reply_file_ll);
                                                if (linearLayout4 != null) {
                                                    i = R.id.reply_file_name;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reply_file_name);
                                                    if (textView4 != null) {
                                                        i = R.id.studentCot_linear;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.studentCot_linear);
                                                        if (linearLayout5 != null) {
                                                            i = R.id.studentMessageTv;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentMessageTv);
                                                            if (textView5 != null) {
                                                                i = R.id.studentName;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentName);
                                                                if (textView6 != null) {
                                                                    i = R.id.timeRl_1;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_1);
                                                                    if (linearLayout6 != null) {
                                                                        i = R.id.userName;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userName);
                                                                        if (textView7 != null) {
                                                                            return new ItemTextChatLeftBinding((RelativeLayout) rootView, relativeLayout, linearLayout, linearLayout2, imageView, imageView2, textView, textView2, textView3, linearLayout3, imageView3, linearLayout4, textView4, linearLayout5, textView5, textView6, linearLayout6, textView7);
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
