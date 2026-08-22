package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class RecyclerChatLayoutBinding implements ViewBinding {
    public final CircleImageView audioImageUser;
    public final CircleImageView audioImageUserLeft;
    public final TextView audioTextUsername;
    public final TextView audioTextUsernameLeft;
    public final TextView audioTimeLeftAudio;
    public final Button audiopause;
    public final Button audiopauseLeft;
    public final Button audioplay;
    public final Button audioplayLeft;
    public final RelativeLayout cvrDownLoadLeft;
    public final RelativeLayout cvrDownLoadRight;
    public final RelativeLayout cvrLeft;
    public final RelativeLayout cvrLeftAudio;
    public final RelativeLayout cvrLeftimage;
    public final RelativeLayout cvrLeftpdf;
    public final RelativeLayout cvrRight;
    public final RelativeLayout cvrRightAudio;
    public final RelativeLayout cvrRightimage;
    public final RelativeLayout cvrRightpdf;
    public final RelativeLayout cvrUrlLeft;
    public final RelativeLayout cvrUrlRight;
    public final ConstraintLayout imageLeftParentCL;
    public final ConstraintLayout imageRightParentCL;
    public final ImageView imageThumbnail;
    public final ImageView imageThumbnailLeft;
    public final LinearLayout ivImgClickRight;
    public final LinearLayout ivImgLeftClick;
    public final ImageView ivPinAudio;
    public final ImageView ivPinImage;
    public final ImageView ivPinMsg;
    public final ImageView ivPinMsgLeft;
    public final ImageView ivPinMsgLeftAudio;
    public final ImageView ivPinMsgLeftImage;
    public final ImageView ivPinMsgLeftPdf;
    public final ImageView ivPinMsgLeftUrl;
    public final ImageView ivPinPdf;
    public final ImageView ivPinUrl;
    public final TextView leftimagetime;
    public final TextView lefttexttime;
    public final TextView lefttexttimeUrl;
    public final TextView letfmessageTv;
    public final TextView letfmessageTvUrl;
    public final ImageView letfmessageTvimage;
    public final LinearLayout navHeaderLL;
    public final LinearLayout navHeaderLLPdf;
    public final LinearLayout navHeaderLeftAudio;
    public final TextView pdfFileName;
    public final TextView pdfFileNameLeft;
    public final CircleImageView pdfImageUser;
    public final CircleImageView pdfImageUserLeft;
    public final LinearLayout pdfRightClick;
    public final TextView pdfTextUsername;
    public final TextView pdfTextUsernameLeft;
    public final TextView pdfTimeLeftPdf;
    public final LinearLayout pdfViewLeft;
    public final LinearLayout pdfViewRight;
    public final LinearLayout pdflayout;
    public final LinearLayout pdflayoutLeft;
    public final CircleImageView profileImage;
    public final CircleImageView profileImage2;
    public final CircleImageView profileImage2Url;
    public final CircleImageView profileImage2image;
    public final ImageView profileImageText;
    public final ImageView profileImageTextAudio;
    public final ImageView profileImageTextPdf;
    public final CircleImageView profileImageUrlLeft;
    public final ImageView profileImageUrlLeftImage;
    public final CircleImageView profileImageimage;
    public final ImageView replyFileImg;
    public final LinearLayout replyFileLl;
    public final TextView replyFileName;
    public final LinearLayout rightContainerLL;
    public final LinearLayout rightSideAudioLL;
    public final LinearLayout rightSidePdfLL;
    public final LinearLayout rightSideTextLL;
    public final LinearLayout rightSideUrlLL;
    public final TextView rightimagettime;
    public final TextView rightmessage;
    public final TextView rightmessageUrl;
    public final ImageView rightmessageimage;
    public final TextView righttexttime;
    public final TextView righttexttimeAudio;
    public final TextView righttexttimePdf;
    public final TextView righttexttimeUrl;
    public final RelativeLayout rlAudioRight;
    public final RelativeLayout rlTextClick;
    public final RelativeLayout rlUrlClick;
    private final RelativeLayout rootView;
    public final LinearLayout studentCotLinear;
    public final TextView studentMessageTv;
    public final TextView studentName;
    public final TextView textaudio;
    public final TextView textaudioLeft;
    public final LinearLayout timeRl1;
    public final LinearLayout timeRl10;
    public final LinearLayout timeRl2;
    public final LinearLayout timeRl3;
    public final LinearLayout timeRl4;
    public final LinearLayout timeRl5;
    public final LinearLayout timeRl6;
    public final LinearLayout timeRl7;
    public final LinearLayout timeRl8;
    public final LinearLayout timeRl9;
    public final TextView userName;
    public final TextView userNameUrlLeft;
    public final TextView userNameimage;
    public final TextView userNameright;
    public final TextView userNamerightUrl;
    public final TextView userNamerightimage;
    public final ImageView userimage;
    public final ImageView userimageLeft;

    private RecyclerChatLayoutBinding(RelativeLayout rootView, CircleImageView audioImageUser, CircleImageView audioImageUserLeft, TextView audioTextUsername, TextView audioTextUsernameLeft, TextView audioTimeLeftAudio, Button audiopause, Button audiopauseLeft, Button audioplay, Button audioplayLeft, RelativeLayout cvrDownLoadLeft, RelativeLayout cvrDownLoadRight, RelativeLayout cvrLeft, RelativeLayout cvrLeftAudio, RelativeLayout cvrLeftimage, RelativeLayout cvrLeftpdf, RelativeLayout cvrRight, RelativeLayout cvrRightAudio, RelativeLayout cvrRightimage, RelativeLayout cvrRightpdf, RelativeLayout cvrUrlLeft, RelativeLayout cvrUrlRight, ConstraintLayout imageLeftParentCL, ConstraintLayout imageRightParentCL, ImageView imageThumbnail, ImageView imageThumbnailLeft, LinearLayout ivImgClickRight, LinearLayout ivImgLeftClick, ImageView ivPinAudio, ImageView ivPinImage, ImageView ivPinMsg, ImageView ivPinMsgLeft, ImageView ivPinMsgLeftAudio, ImageView ivPinMsgLeftImage, ImageView ivPinMsgLeftPdf, ImageView ivPinMsgLeftUrl, ImageView ivPinPdf, ImageView ivPinUrl, TextView leftimagetime, TextView lefttexttime, TextView lefttexttimeUrl, TextView letfmessageTv, TextView letfmessageTvUrl, ImageView letfmessageTvimage, LinearLayout navHeaderLL, LinearLayout navHeaderLLPdf, LinearLayout navHeaderLeftAudio, TextView pdfFileName, TextView pdfFileNameLeft, CircleImageView pdfImageUser, CircleImageView pdfImageUserLeft, LinearLayout pdfRightClick, TextView pdfTextUsername, TextView pdfTextUsernameLeft, TextView pdfTimeLeftPdf, LinearLayout pdfViewLeft, LinearLayout pdfViewRight, LinearLayout pdflayout, LinearLayout pdflayoutLeft, CircleImageView profileImage, CircleImageView profileImage2, CircleImageView profileImage2Url, CircleImageView profileImage2image, ImageView profileImageText, ImageView profileImageTextAudio, ImageView profileImageTextPdf, CircleImageView profileImageUrlLeft, ImageView profileImageUrlLeftImage, CircleImageView profileImageimage, ImageView replyFileImg, LinearLayout replyFileLl, TextView replyFileName, LinearLayout rightContainerLL, LinearLayout rightSideAudioLL, LinearLayout rightSidePdfLL, LinearLayout rightSideTextLL, LinearLayout rightSideUrlLL, TextView rightimagettime, TextView rightmessage, TextView rightmessageUrl, ImageView rightmessageimage, TextView righttexttime, TextView righttexttimeAudio, TextView righttexttimePdf, TextView righttexttimeUrl, RelativeLayout rlAudioRight, RelativeLayout rlTextClick, RelativeLayout rlUrlClick, LinearLayout studentCotLinear, TextView studentMessageTv, TextView studentName, TextView textaudio, TextView textaudioLeft, LinearLayout timeRl1, LinearLayout timeRl10, LinearLayout timeRl2, LinearLayout timeRl3, LinearLayout timeRl4, LinearLayout timeRl5, LinearLayout timeRl6, LinearLayout timeRl7, LinearLayout timeRl8, LinearLayout timeRl9, TextView userName, TextView userNameUrlLeft, TextView userNameimage, TextView userNameright, TextView userNamerightUrl, TextView userNamerightimage, ImageView userimage, ImageView userimageLeft) {
        this.rootView = rootView;
        this.audioImageUser = audioImageUser;
        this.audioImageUserLeft = audioImageUserLeft;
        this.audioTextUsername = audioTextUsername;
        this.audioTextUsernameLeft = audioTextUsernameLeft;
        this.audioTimeLeftAudio = audioTimeLeftAudio;
        this.audiopause = audiopause;
        this.audiopauseLeft = audiopauseLeft;
        this.audioplay = audioplay;
        this.audioplayLeft = audioplayLeft;
        this.cvrDownLoadLeft = cvrDownLoadLeft;
        this.cvrDownLoadRight = cvrDownLoadRight;
        this.cvrLeft = cvrLeft;
        this.cvrLeftAudio = cvrLeftAudio;
        this.cvrLeftimage = cvrLeftimage;
        this.cvrLeftpdf = cvrLeftpdf;
        this.cvrRight = cvrRight;
        this.cvrRightAudio = cvrRightAudio;
        this.cvrRightimage = cvrRightimage;
        this.cvrRightpdf = cvrRightpdf;
        this.cvrUrlLeft = cvrUrlLeft;
        this.cvrUrlRight = cvrUrlRight;
        this.imageLeftParentCL = imageLeftParentCL;
        this.imageRightParentCL = imageRightParentCL;
        this.imageThumbnail = imageThumbnail;
        this.imageThumbnailLeft = imageThumbnailLeft;
        this.ivImgClickRight = ivImgClickRight;
        this.ivImgLeftClick = ivImgLeftClick;
        this.ivPinAudio = ivPinAudio;
        this.ivPinImage = ivPinImage;
        this.ivPinMsg = ivPinMsg;
        this.ivPinMsgLeft = ivPinMsgLeft;
        this.ivPinMsgLeftAudio = ivPinMsgLeftAudio;
        this.ivPinMsgLeftImage = ivPinMsgLeftImage;
        this.ivPinMsgLeftPdf = ivPinMsgLeftPdf;
        this.ivPinMsgLeftUrl = ivPinMsgLeftUrl;
        this.ivPinPdf = ivPinPdf;
        this.ivPinUrl = ivPinUrl;
        this.leftimagetime = leftimagetime;
        this.lefttexttime = lefttexttime;
        this.lefttexttimeUrl = lefttexttimeUrl;
        this.letfmessageTv = letfmessageTv;
        this.letfmessageTvUrl = letfmessageTvUrl;
        this.letfmessageTvimage = letfmessageTvimage;
        this.navHeaderLL = navHeaderLL;
        this.navHeaderLLPdf = navHeaderLLPdf;
        this.navHeaderLeftAudio = navHeaderLeftAudio;
        this.pdfFileName = pdfFileName;
        this.pdfFileNameLeft = pdfFileNameLeft;
        this.pdfImageUser = pdfImageUser;
        this.pdfImageUserLeft = pdfImageUserLeft;
        this.pdfRightClick = pdfRightClick;
        this.pdfTextUsername = pdfTextUsername;
        this.pdfTextUsernameLeft = pdfTextUsernameLeft;
        this.pdfTimeLeftPdf = pdfTimeLeftPdf;
        this.pdfViewLeft = pdfViewLeft;
        this.pdfViewRight = pdfViewRight;
        this.pdflayout = pdflayout;
        this.pdflayoutLeft = pdflayoutLeft;
        this.profileImage = profileImage;
        this.profileImage2 = profileImage2;
        this.profileImage2Url = profileImage2Url;
        this.profileImage2image = profileImage2image;
        this.profileImageText = profileImageText;
        this.profileImageTextAudio = profileImageTextAudio;
        this.profileImageTextPdf = profileImageTextPdf;
        this.profileImageUrlLeft = profileImageUrlLeft;
        this.profileImageUrlLeftImage = profileImageUrlLeftImage;
        this.profileImageimage = profileImageimage;
        this.replyFileImg = replyFileImg;
        this.replyFileLl = replyFileLl;
        this.replyFileName = replyFileName;
        this.rightContainerLL = rightContainerLL;
        this.rightSideAudioLL = rightSideAudioLL;
        this.rightSidePdfLL = rightSidePdfLL;
        this.rightSideTextLL = rightSideTextLL;
        this.rightSideUrlLL = rightSideUrlLL;
        this.rightimagettime = rightimagettime;
        this.rightmessage = rightmessage;
        this.rightmessageUrl = rightmessageUrl;
        this.rightmessageimage = rightmessageimage;
        this.righttexttime = righttexttime;
        this.righttexttimeAudio = righttexttimeAudio;
        this.righttexttimePdf = righttexttimePdf;
        this.righttexttimeUrl = righttexttimeUrl;
        this.rlAudioRight = rlAudioRight;
        this.rlTextClick = rlTextClick;
        this.rlUrlClick = rlUrlClick;
        this.studentCotLinear = studentCotLinear;
        this.studentMessageTv = studentMessageTv;
        this.studentName = studentName;
        this.textaudio = textaudio;
        this.textaudioLeft = textaudioLeft;
        this.timeRl1 = timeRl1;
        this.timeRl10 = timeRl10;
        this.timeRl2 = timeRl2;
        this.timeRl3 = timeRl3;
        this.timeRl4 = timeRl4;
        this.timeRl5 = timeRl5;
        this.timeRl6 = timeRl6;
        this.timeRl7 = timeRl7;
        this.timeRl8 = timeRl8;
        this.timeRl9 = timeRl9;
        this.userName = userName;
        this.userNameUrlLeft = userNameUrlLeft;
        this.userNameimage = userNameimage;
        this.userNameright = userNameright;
        this.userNamerightUrl = userNamerightUrl;
        this.userNamerightimage = userNamerightimage;
        this.userimage = userimage;
        this.userimageLeft = userimageLeft;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RecyclerChatLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RecyclerChatLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.recycler_chat_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RecyclerChatLayoutBinding bind(View rootView) {
        int i = R.id.audioImage_user;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.audioImage_user);
        if (circleImageView != null) {
            i = R.id.audioImage_userLeft;
            CircleImageView circleImageView2 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.audioImage_userLeft);
            if (circleImageView2 != null) {
                i = R.id.audioText_username;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.audioText_username);
                if (textView != null) {
                    i = R.id.audioText_usernameLeft;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.audioText_usernameLeft);
                    if (textView2 != null) {
                        i = R.id.audio_timeLeftAudio;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.audio_timeLeftAudio);
                        if (textView3 != null) {
                            i = R.id.audiopause;
                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.audiopause);
                            if (button != null) {
                                i = R.id.audiopauseLeft;
                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.audiopauseLeft);
                                if (button2 != null) {
                                    i = R.id.audioplay;
                                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.audioplay);
                                    if (button3 != null) {
                                        i = R.id.audioplayLeft;
                                        Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.audioplayLeft);
                                        if (button4 != null) {
                                            i = R.id.cvrDownLoadLeft;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrDownLoadLeft);
                                            if (relativeLayout != null) {
                                                i = R.id.cvrDownLoadRight;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrDownLoadRight);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.cvrLeft;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeft);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.cvrLeftAudio;
                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeftAudio);
                                                        if (relativeLayout4 != null) {
                                                            i = R.id.cvrLeftimage;
                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeftimage);
                                                            if (relativeLayout5 != null) {
                                                                i = R.id.cvrLeftpdf;
                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeftpdf);
                                                                if (relativeLayout6 != null) {
                                                                    i = R.id.cvrRight;
                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRight);
                                                                    if (relativeLayout7 != null) {
                                                                        i = R.id.cvrRightAudio;
                                                                        RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRightAudio);
                                                                        if (relativeLayout8 != null) {
                                                                            i = R.id.cvrRightimage;
                                                                            RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRightimage);
                                                                            if (relativeLayout9 != null) {
                                                                                i = R.id.cvrRightpdf;
                                                                                RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRightpdf);
                                                                                if (relativeLayout10 != null) {
                                                                                    i = R.id.cvrUrlLeft;
                                                                                    RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrUrlLeft);
                                                                                    if (relativeLayout11 != null) {
                                                                                        i = R.id.cvrUrlRight;
                                                                                        RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrUrlRight);
                                                                                        if (relativeLayout12 != null) {
                                                                                            i = R.id.imageLeftParentCL;
                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.imageLeftParentCL);
                                                                                            if (constraintLayout != null) {
                                                                                                i = R.id.imageRightParentCL;
                                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.imageRightParentCL);
                                                                                                if (constraintLayout2 != null) {
                                                                                                    i = R.id.imageThumbnail;
                                                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageThumbnail);
                                                                                                    if (imageView != null) {
                                                                                                        i = R.id.imageThumbnailLeft;
                                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageThumbnailLeft);
                                                                                                        if (imageView2 != null) {
                                                                                                            i = R.id.iv_img_click_right;
                                                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.iv_img_click_right);
                                                                                                            if (linearLayout != null) {
                                                                                                                i = R.id.iv_img_left_click;
                                                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.iv_img_left_click);
                                                                                                                if (linearLayout2 != null) {
                                                                                                                    i = R.id.ivPinAudio;
                                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinAudio);
                                                                                                                    if (imageView3 != null) {
                                                                                                                        i = R.id.ivPinImage;
                                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinImage);
                                                                                                                        if (imageView4 != null) {
                                                                                                                            i = R.id.ivPinMsg;
                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsg);
                                                                                                                            if (imageView5 != null) {
                                                                                                                                i = R.id.ivPinMsgLeft;
                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeft);
                                                                                                                                if (imageView6 != null) {
                                                                                                                                    i = R.id.ivPinMsgLeftAudio;
                                                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeftAudio);
                                                                                                                                    if (imageView7 != null) {
                                                                                                                                        i = R.id.ivPinMsgLeftImage;
                                                                                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeftImage);
                                                                                                                                        if (imageView8 != null) {
                                                                                                                                            i = R.id.ivPinMsgLeftPdf;
                                                                                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeftPdf);
                                                                                                                                            if (imageView9 != null) {
                                                                                                                                                i = R.id.ivPinMsgLeftUrl;
                                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeftUrl);
                                                                                                                                                if (imageView10 != null) {
                                                                                                                                                    i = R.id.ivPinPdf;
                                                                                                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinPdf);
                                                                                                                                                    if (imageView11 != null) {
                                                                                                                                                        i = R.id.ivPinUrl;
                                                                                                                                                        ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinUrl);
                                                                                                                                                        if (imageView12 != null) {
                                                                                                                                                            i = R.id.leftimagetime;
                                                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.leftimagetime);
                                                                                                                                                            if (textView4 != null) {
                                                                                                                                                                i = R.id.lefttexttime;
                                                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lefttexttime);
                                                                                                                                                                if (textView5 != null) {
                                                                                                                                                                    i = R.id.lefttexttimeUrl;
                                                                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lefttexttimeUrl);
                                                                                                                                                                    if (textView6 != null) {
                                                                                                                                                                        i = R.id.letfmessageTv;
                                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.letfmessageTv);
                                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                                            i = R.id.letfmessageTvUrl;
                                                                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.letfmessageTvUrl);
                                                                                                                                                                            if (textView8 != null) {
                                                                                                                                                                                i = R.id.letfmessageTvimage;
                                                                                                                                                                                ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.letfmessageTvimage);
                                                                                                                                                                                if (imageView13 != null) {
                                                                                                                                                                                    i = R.id.nav_headerLL;
                                                                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nav_headerLL);
                                                                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                                                                        i = R.id.nav_headerLLPdf;
                                                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nav_headerLLPdf);
                                                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                                                            i = R.id.nav_headerLeftAudio;
                                                                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nav_headerLeftAudio);
                                                                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                                                                i = R.id.pdfFile_name;
                                                                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfFile_name);
                                                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                                                    i = R.id.pdfFile_nameLeft;
                                                                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfFile_nameLeft);
                                                                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                                                                        i = R.id.pdfImage_user;
                                                                                                                                                                                                        CircleImageView circleImageView3 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.pdfImage_user);
                                                                                                                                                                                                        if (circleImageView3 != null) {
                                                                                                                                                                                                            i = R.id.pdfImage_userLeft;
                                                                                                                                                                                                            CircleImageView circleImageView4 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.pdfImage_userLeft);
                                                                                                                                                                                                            if (circleImageView4 != null) {
                                                                                                                                                                                                                i = R.id.pdf_right_click;
                                                                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdf_right_click);
                                                                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                                                                    i = R.id.pdfText_username;
                                                                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfText_username);
                                                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                                                        i = R.id.pdfText_usernameLeft;
                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfText_usernameLeft);
                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                            i = R.id.pdf_timeLeftPdf;
                                                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdf_timeLeftPdf);
                                                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                                                i = R.id.pdfViewLeft;
                                                                                                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdfViewLeft);
                                                                                                                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                                                                                                                    i = R.id.pdfViewRight;
                                                                                                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdfViewRight);
                                                                                                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                                                                                                        i = R.id.pdflayout;
                                                                                                                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdflayout);
                                                                                                                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                                                                                                                            i = R.id.pdflayoutLeft;
                                                                                                                                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdflayoutLeft);
                                                                                                                                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                                                                                                                                i = R.id.profileImage;
                                                                                                                                                                                                                                                CircleImageView circleImageView5 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                                                                                                                                                                                                                if (circleImageView5 != null) {
                                                                                                                                                                                                                                                    i = R.id.profileImage2;
                                                                                                                                                                                                                                                    CircleImageView circleImageView6 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage2);
                                                                                                                                                                                                                                                    if (circleImageView6 != null) {
                                                                                                                                                                                                                                                        i = R.id.profileImage2Url;
                                                                                                                                                                                                                                                        CircleImageView circleImageView7 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage2Url);
                                                                                                                                                                                                                                                        if (circleImageView7 != null) {
                                                                                                                                                                                                                                                            i = R.id.profileImage2image;
                                                                                                                                                                                                                                                            CircleImageView circleImageView8 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage2image);
                                                                                                                                                                                                                                                            if (circleImageView8 != null) {
                                                                                                                                                                                                                                                                i = R.id.profileImageText;
                                                                                                                                                                                                                                                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImageText);
                                                                                                                                                                                                                                                                if (imageView14 != null) {
                                                                                                                                                                                                                                                                    i = R.id.profileImageTextAudio;
                                                                                                                                                                                                                                                                    ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImageTextAudio);
                                                                                                                                                                                                                                                                    if (imageView15 != null) {
                                                                                                                                                                                                                                                                        i = R.id.profileImageTextPdf;
                                                                                                                                                                                                                                                                        ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImageTextPdf);
                                                                                                                                                                                                                                                                        if (imageView16 != null) {
                                                                                                                                                                                                                                                                            i = R.id.profileImageUrlLeft;
                                                                                                                                                                                                                                                                            CircleImageView circleImageView9 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImageUrlLeft);
                                                                                                                                                                                                                                                                            if (circleImageView9 != null) {
                                                                                                                                                                                                                                                                                i = R.id.profileImageUrlLeftImage;
                                                                                                                                                                                                                                                                                ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImageUrlLeftImage);
                                                                                                                                                                                                                                                                                if (imageView17 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.profileImageimage;
                                                                                                                                                                                                                                                                                    CircleImageView circleImageView10 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImageimage);
                                                                                                                                                                                                                                                                                    if (circleImageView10 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.reply_file_img;
                                                                                                                                                                                                                                                                                        ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.reply_file_img);
                                                                                                                                                                                                                                                                                        if (imageView18 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.reply_file_ll;
                                                                                                                                                                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.reply_file_ll);
                                                                                                                                                                                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.reply_file_name;
                                                                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reply_file_name);
                                                                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.rightContainerLL;
                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rightContainerLL);
                                                                                                                                                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.rightSideAudioLL;
                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rightSideAudioLL);
                                                                                                                                                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.rightSidePdfLL;
                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rightSidePdfLL);
                                                                                                                                                                                                                                                                                                            if (linearLayout14 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.rightSideTextLL;
                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rightSideTextLL);
                                                                                                                                                                                                                                                                                                                if (linearLayout15 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.rightSideUrlLL;
                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rightSideUrlLL);
                                                                                                                                                                                                                                                                                                                    if (linearLayout16 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.rightimagettime;
                                                                                                                                                                                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rightimagettime);
                                                                                                                                                                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.rightmessage;
                                                                                                                                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rightmessage);
                                                                                                                                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.rightmessageUrl;
                                                                                                                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rightmessageUrl);
                                                                                                                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.rightmessageimage;
                                                                                                                                                                                                                                                                                                                                    ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.rightmessageimage);
                                                                                                                                                                                                                                                                                                                                    if (imageView19 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.righttexttime;
                                                                                                                                                                                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.righttexttime);
                                                                                                                                                                                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.righttexttimeAudio;
                                                                                                                                                                                                                                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.righttexttimeAudio);
                                                                                                                                                                                                                                                                                                                                            if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.righttexttimePdf;
                                                                                                                                                                                                                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.righttexttimePdf);
                                                                                                                                                                                                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.righttexttimeUrl;
                                                                                                                                                                                                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.righttexttimeUrl);
                                                                                                                                                                                                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.rl_audio_right;
                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_audio_right);
                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout13 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.rl_text_click;
                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_text_click);
                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.rl_url_click;
                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_url_click);
                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.studentCot_linear;
                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.studentCot_linear);
                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout17 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.studentMessageTv;
                                                                                                                                                                                                                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentMessageTv);
                                                                                                                                                                                                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.studentName;
                                                                                                                                                                                                                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentName);
                                                                                                                                                                                                                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.textaudio;
                                                                                                                                                                                                                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textaudio);
                                                                                                                                                                                                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.textaudioLeft;
                                                                                                                                                                                                                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textaudioLeft);
                                                                                                                                                                                                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.timeRl_1;
                                                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_1);
                                                                                                                                                                                                                                                                                                                                                                                        if (linearLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.timeRl_10;
                                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_10);
                                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.timeRl_2;
                                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_2);
                                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.timeRl_3;
                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_3);
                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.timeRl_4;
                                                                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_4);
                                                                                                                                                                                                                                                                                                                                                                                                        if (linearLayout22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.timeRl_5;
                                                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout23 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_5);
                                                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.timeRl_6;
                                                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout24 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_6);
                                                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.timeRl_7;
                                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout25 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_7);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.timeRl_8;
                                                                                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout26 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_8);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (linearLayout26 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.timeRl_9;
                                                                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout27 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_9);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout27 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.userName;
                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userName);
                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.userNameUrlLeft;
                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNameUrlLeft);
                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.userNameimage;
                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNameimage);
                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.userNameright;
                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNameright);
                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.userNamerightUrl;
                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNamerightUrl);
                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.userNamerightimage;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNamerightimage);
                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.userimage;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.userimage);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (imageView20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.userimageLeft;
                                                                                                                                                                                                                                                                                                                                                                                                                                                            ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.userimageLeft);
                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (imageView21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                return new RecyclerChatLayoutBinding((RelativeLayout) rootView, circleImageView, circleImageView2, textView, textView2, textView3, button, button2, button3, button4, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, relativeLayout11, relativeLayout12, constraintLayout, constraintLayout2, imageView, imageView2, linearLayout, linearLayout2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, textView4, textView5, textView6, textView7, textView8, imageView13, linearLayout3, linearLayout4, linearLayout5, textView9, textView10, circleImageView3, circleImageView4, linearLayout6, textView11, textView12, textView13, linearLayout7, linearLayout8, linearLayout9, linearLayout10, circleImageView5, circleImageView6, circleImageView7, circleImageView8, imageView14, imageView15, imageView16, circleImageView9, imageView17, circleImageView10, imageView18, linearLayout11, textView14, linearLayout12, linearLayout13, linearLayout14, linearLayout15, linearLayout16, textView15, textView16, textView17, imageView19, textView18, textView19, textView20, textView21, relativeLayout13, relativeLayout14, relativeLayout15, linearLayout17, textView22, textView23, textView24, textView25, linearLayout18, linearLayout19, linearLayout20, linearLayout21, linearLayout22, linearLayout23, linearLayout24, linearLayout25, linearLayout26, linearLayout27, textView26, textView27, textView28, textView29, textView30, textView31, imageView20, imageView21);
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
