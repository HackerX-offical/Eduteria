package com.appnew.android.Webview;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.appnew.android.Model.FlashData;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Banner_ViewPager extends PagerAdapter {
    public static boolean is_front = false;
    AnimatorSet animatorSet_back;
    AnimatorSet animatorSet_front;
    private final Context context;
    public ArrayList<FlashData> list_banners;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Banner_ViewPager(Context context, ArrayList<FlashData> list_banners) {
        this.context = context;
        this.list_banners = list_banners;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<FlashData> arrayList = this.list_banners;
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        return this.list_banners.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, final int position) {
        try {
            View viewInflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.flash_view_adapter, container, false);
            final RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.layout_front);
            TextView textView = (TextView) viewInflate.findViewById(R.id.text_front);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.text_back);
            final RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.layout_back);
            RelativeLayout relativeLayout3 = (RelativeLayout) viewInflate.findViewById(R.id.flashCover);
            final TextView textView3 = (TextView) viewInflate.findViewById(R.id.turn);
            this.animatorSet_front = (AnimatorSet) AnimatorInflater.loadAnimator(this.context, R.anim.front_animator);
            this.animatorSet_back = (AnimatorSet) AnimatorInflater.loadAnimator(this.context, R.anim.back_animator);
            float f2 = this.context.getResources().getDisplayMetrics().density * 8000.0f;
            relativeLayout.setCameraDistance(f2);
            textView.setCameraDistance(f2);
            relativeLayout2.setCameraDistance(f2);
            textView2.setCameraDistance(f2);
            textView.setText(this.list_banners.get(position).getTerms());
            textView2.setText(this.list_banners.get(position).getDescription());
            relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.Banner_ViewPager$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$instantiateItem$0(relativeLayout, relativeLayout2, position, textView3, view);
                }
            });
            container.addView(viewInflate);
            return viewInflate;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$instantiateItem$0(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, int i, TextView textView, View view) {
        if (is_front) {
            this.animatorSet_back.setTarget(relativeLayout);
            this.animatorSet_front.setTarget(relativeLayout2);
            this.animatorSet_front.start();
            this.animatorSet_back.start();
            is_front = false;
            this.list_banners.get(i).setIs_selectecd(false);
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rotate_right, 0, 0, 0);
            return;
        }
        this.animatorSet_front.setTarget(relativeLayout);
        this.animatorSet_back.setTarget(relativeLayout2);
        this.animatorSet_back.start();
        this.animatorSet_front.start();
        is_front = true;
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rotate_left, 0, 0, 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
