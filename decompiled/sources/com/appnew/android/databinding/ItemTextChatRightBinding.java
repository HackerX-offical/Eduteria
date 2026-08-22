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
public final class ItemTextChatRightBinding implements ViewBinding {
    public final RelativeLayout cvrRight;
    public final LinearLayout editedLayoutRight;
    public final ImageView ivPinMsg;
    public final TextView leftEdited;
    public final LinearLayout mainContainerLL;
    public final LinearLayout mainLL1;
    public final TextView rightmessage;
    public final TextView righttexttime;
    public final RelativeLayout rlTextClick;
    private final RelativeLayout rootView;
    public final LinearLayout timeRl2;
    public final TextView userNameright;

    private ItemTextChatRightBinding(RelativeLayout rootView, RelativeLayout cvrRight, LinearLayout editedLayoutRight, ImageView ivPinMsg, TextView leftEdited, LinearLayout mainContainerLL, LinearLayout mainLL1, TextView rightmessage, TextView righttexttime, RelativeLayout rlTextClick, LinearLayout timeRl2, TextView userNameright) {
        this.rootView = rootView;
        this.cvrRight = cvrRight;
        this.editedLayoutRight = editedLayoutRight;
        this.ivPinMsg = ivPinMsg;
        this.leftEdited = leftEdited;
        this.mainContainerLL = mainContainerLL;
        this.mainLL1 = mainLL1;
        this.rightmessage = rightmessage;
        this.righttexttime = righttexttime;
        this.rlTextClick = rlTextClick;
        this.timeRl2 = timeRl2;
        this.userNameright = userNameright;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemTextChatRightBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTextChatRightBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_text_chat_right, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemTextChatRightBinding bind(View rootView) {
        int i = R.id.cvrRight;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRight);
        if (relativeLayout != null) {
            i = R.id.editedLayoutRight;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.editedLayoutRight);
            if (linearLayout != null) {
                i = R.id.ivPinMsg;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsg);
                if (imageView != null) {
                    i = R.id.leftEdited;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.leftEdited);
                    if (textView != null) {
                        i = R.id.mainContainerLL;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainContainerLL);
                        if (linearLayout2 != null) {
                            i = R.id.mainLL1;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainLL1);
                            if (linearLayout3 != null) {
                                i = R.id.rightmessage;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rightmessage);
                                if (textView2 != null) {
                                    i = R.id.righttexttime;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.righttexttime);
                                    if (textView3 != null) {
                                        i = R.id.rl_text_click;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_text_click);
                                        if (relativeLayout2 != null) {
                                            i = R.id.timeRl_2;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_2);
                                            if (linearLayout4 != null) {
                                                i = R.id.userNameright;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNameright);
                                                if (textView4 != null) {
                                                    return new ItemTextChatRightBinding((RelativeLayout) rootView, relativeLayout, linearLayout, imageView, textView, linearLayout2, linearLayout3, textView2, textView3, relativeLayout2, linearLayout4, textView4);
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
