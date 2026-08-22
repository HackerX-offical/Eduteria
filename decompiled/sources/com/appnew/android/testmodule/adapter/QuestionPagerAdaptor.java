package com.appnew.android.testmodule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.Utils.Helper;
import com.appnew.android.testmodule.mathview.MathView;
import com.appnew.android.testmodule.model.Question;
import com.clevertap.android.sdk.network.api.CtApi;
import com.eduteria.app.app.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionPagerAdaptor extends PagerAdapter implements View.OnClickListener {
    Context context;
    private List<Question> questionObjectArrayList;
    private int MAX_SIZE = 3;
    private ArrayList<SoftReference<View>> pageCache = new ArrayList<>(3);

    static /* synthetic */ boolean lambda$setHtmlinWebView$0(View view) {
        return true;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public QuestionPagerAdaptor(Context context, List<Question> questionObjectArrayList) {
        this.context = context;
        this.questionObjectArrayList = questionObjectArrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* JADX INFO: renamed from: getCount */
    public int getTotalTabs() {
        return this.questionObjectArrayList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        View viewFetchFromCache = fetchFromCache();
        if (viewFetchFromCache == null) {
            viewFetchFromCache = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.viewpager_items_qt7_new, container, false);
        }
        multipleChoice_7_View(viewFetchFromCache, container, position);
        return viewFetchFromCache;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup container) {
        try {
            super.finishUpdate(container);
        } catch (NullPointerException unused) {
            System.out.println("Catch the NullPointerException in FragmentPagerAdapter.finishUpdate");
        }
    }

    private View fetchFromCache() {
        for (int size = this.pageCache.size() - 1; size >= 0; size--) {
            View view = this.pageCache.remove(size).get();
            if (view != null) {
                return view;
            }
        }
        return null;
    }

    private View multipleChoice_7_View(View itemView, ViewGroup container, int position) {
        ClickableWebView clickableWebView = (ClickableWebView) itemView.findViewById(R.id.essaywebview);
        clickableWebView.getSettings().setJavaScriptEnabled(true);
        ClickableWebView clickableWebView2 = (ClickableWebView) itemView.findViewById(R.id.questionwebview);
        clickableWebView2.getSettings().setJavaScriptEnabled(true);
        RelativeLayout relativeLayout = (RelativeLayout) itemView.findViewById(R.id.ll_option1);
        relativeLayout.setVisibility(8);
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) itemView.findViewById(R.id.ll_option2);
        relativeLayout2.setVisibility(8);
        relativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) itemView.findViewById(R.id.ll_option3);
        relativeLayout3.setVisibility(8);
        relativeLayout3.setOnClickListener(this);
        RelativeLayout relativeLayout4 = (RelativeLayout) itemView.findViewById(R.id.ll_option4);
        relativeLayout4.setVisibility(8);
        relativeLayout4.setOnClickListener(this);
        RelativeLayout relativeLayout5 = (RelativeLayout) itemView.findViewById(R.id.ll_option5);
        relativeLayout5.setVisibility(8);
        relativeLayout5.setOnClickListener(this);
        RelativeLayout relativeLayout6 = (RelativeLayout) itemView.findViewById(R.id.ll_option6);
        relativeLayout6.setVisibility(8);
        relativeLayout6.setOnClickListener(this);
        RelativeLayout relativeLayout7 = (RelativeLayout) itemView.findViewById(R.id.ll_option7);
        relativeLayout7.setVisibility(8);
        relativeLayout7.setOnClickListener(this);
        RelativeLayout relativeLayout8 = (RelativeLayout) itemView.findViewById(R.id.ll_option8);
        relativeLayout8.setVisibility(8);
        relativeLayout8.setOnClickListener(this);
        View viewFindViewById = itemView.findViewById(R.id.view_divider1);
        viewFindViewById.setVisibility(8);
        View viewFindViewById2 = itemView.findViewById(R.id.view_divider2);
        viewFindViewById2.setVisibility(8);
        View viewFindViewById3 = itemView.findViewById(R.id.view_divider3);
        viewFindViewById3.setVisibility(8);
        View viewFindViewById4 = itemView.findViewById(R.id.view_divider4);
        viewFindViewById4.setVisibility(8);
        View viewFindViewById5 = itemView.findViewById(R.id.view_divider5);
        viewFindViewById5.setVisibility(8);
        View viewFindViewById6 = itemView.findViewById(R.id.view_divider6);
        viewFindViewById6.setVisibility(8);
        View viewFindViewById7 = itemView.findViewById(R.id.view_divider7);
        viewFindViewById7.setVisibility(8);
        View viewFindViewById8 = itemView.findViewById(R.id.view_divider8);
        viewFindViewById8.setVisibility(8);
        MathView mathView = (MathView) itemView.findViewById(R.id.option1_webview);
        mathView.getSettings().setJavaScriptEnabled(true);
        mathView.addJavascriptInterface(new WebAppInterface(this.context, mathView, relativeLayout), CtApi.DEFAULT_QUERY_PARAM_OS);
        MathView mathView2 = (MathView) itemView.findViewById(R.id.option2_webview);
        mathView2.getSettings().setJavaScriptEnabled(true);
        mathView2.addJavascriptInterface(new WebAppInterface(this.context, mathView2, relativeLayout2), CtApi.DEFAULT_QUERY_PARAM_OS);
        MathView mathView3 = (MathView) itemView.findViewById(R.id.option3_webview);
        mathView3.getSettings().setJavaScriptEnabled(true);
        mathView3.addJavascriptInterface(new WebAppInterface(this.context, mathView3, relativeLayout3), CtApi.DEFAULT_QUERY_PARAM_OS);
        MathView mathView4 = (MathView) itemView.findViewById(R.id.option4_webview);
        mathView4.getSettings().setJavaScriptEnabled(true);
        mathView4.addJavascriptInterface(new WebAppInterface(this.context, mathView4, relativeLayout4), CtApi.DEFAULT_QUERY_PARAM_OS);
        MathView mathView5 = (MathView) itemView.findViewById(R.id.option5_webview);
        mathView5.getSettings().setJavaScriptEnabled(true);
        mathView5.addJavascriptInterface(new WebAppInterface(this.context, mathView5, relativeLayout5), CtApi.DEFAULT_QUERY_PARAM_OS);
        MathView mathView6 = (MathView) itemView.findViewById(R.id.option6_webview);
        mathView6.getSettings().setJavaScriptEnabled(true);
        mathView6.addJavascriptInterface(new WebAppInterface(this.context, mathView6, relativeLayout6), CtApi.DEFAULT_QUERY_PARAM_OS);
        MathView mathView7 = (MathView) itemView.findViewById(R.id.option7_webview);
        mathView7.getSettings().setJavaScriptEnabled(true);
        mathView7.addJavascriptInterface(new WebAppInterface(this.context, mathView7, relativeLayout7), CtApi.DEFAULT_QUERY_PARAM_OS);
        MathView mathView8 = (MathView) itemView.findViewById(R.id.option8_webview);
        mathView8.getSettings().setJavaScriptEnabled(true);
        mathView8.addJavascriptInterface(new WebAppInterface(this.context, mathView8, relativeLayout8), CtApi.DEFAULT_QUERY_PARAM_OS);
        clickableWebView.setVisibility(8);
        setHtmlinWebView(clickableWebView2, this.questionObjectArrayList.get(position).getQuestion());
        ArrayList arrayList = new ArrayList();
        if (!this.questionObjectArrayList.get(position).getOption1().isEmpty()) {
            OptionObject optionObject = new OptionObject();
            optionObject.setOptionText(this.questionObjectArrayList.get(position).getOption1());
            optionObject.setOptionAlphabet("a");
            arrayList.add(optionObject);
        }
        if (!this.questionObjectArrayList.get(position).getOption2().isEmpty()) {
            OptionObject optionObject2 = new OptionObject();
            optionObject2.setOptionText(this.questionObjectArrayList.get(position).getOption2());
            optionObject2.setOptionAlphabet("b");
            arrayList.add(optionObject2);
        }
        if (!this.questionObjectArrayList.get(position).getOption3().isEmpty()) {
            OptionObject optionObject3 = new OptionObject();
            optionObject3.setOptionText(this.questionObjectArrayList.get(position).getOption3());
            optionObject3.setOptionAlphabet("c");
            arrayList.add(optionObject3);
        }
        if (!this.questionObjectArrayList.get(position).getOption4().isEmpty()) {
            OptionObject optionObject4 = new OptionObject();
            optionObject4.setOptionText(this.questionObjectArrayList.get(position).getOption4());
            optionObject4.setOptionAlphabet("d");
            arrayList.add(optionObject4);
        }
        if (this.questionObjectArrayList.get(position).getOption5() != null && !this.questionObjectArrayList.get(position).getOption5().isEmpty()) {
            OptionObject optionObject5 = new OptionObject();
            optionObject5.setOptionText(this.questionObjectArrayList.get(position).getOption5());
            optionObject5.setOptionAlphabet("e");
            arrayList.add(optionObject5);
        }
        if (this.questionObjectArrayList.get(position).getOption6() != null && !this.questionObjectArrayList.get(position).getOption6().isEmpty()) {
            OptionObject optionObject6 = new OptionObject();
            optionObject6.setOptionText(this.questionObjectArrayList.get(position).getOption6());
            optionObject6.setOptionAlphabet("f");
            arrayList.add(optionObject6);
        }
        if (this.questionObjectArrayList.get(position).getOption7() != null && !this.questionObjectArrayList.get(position).getOption7().isEmpty()) {
            OptionObject optionObject7 = new OptionObject();
            optionObject7.setOptionText(this.questionObjectArrayList.get(position).getOption7());
            optionObject7.setOptionAlphabet("g");
            arrayList.add(optionObject7);
        }
        if (this.questionObjectArrayList.get(position).getOption8() != null && !this.questionObjectArrayList.get(position).getOption8().isEmpty()) {
            OptionObject optionObject8 = new OptionObject();
            optionObject8.setOptionText(this.questionObjectArrayList.get(position).getOption8());
            optionObject8.setOptionAlphabet("h");
            arrayList.add(optionObject8);
        }
        if (!this.questionObjectArrayList.get(position).getOption1().isEmpty()) {
            setHtmlinWebView(mathView, ((OptionObject) arrayList.get(0)).getOptionText());
            relativeLayout.setTag((position + 1) + "9108" + gettagnumberfromalphabet(((OptionObject) arrayList.get(0)).getOptionAlphabet()));
            relativeLayout.setVisibility(0);
            viewFindViewById.setVisibility(0);
        }
        if (!this.questionObjectArrayList.get(position).getOption2().isEmpty()) {
            setHtmlinWebView(mathView2, ((OptionObject) arrayList.get(1)).getOptionText());
            relativeLayout2.setTag((position + 1) + "9108" + gettagnumberfromalphabet(((OptionObject) arrayList.get(1)).getOptionAlphabet()));
            relativeLayout2.setVisibility(0);
            viewFindViewById2.setVisibility(0);
        }
        if (!this.questionObjectArrayList.get(position).getOption3().isEmpty()) {
            setHtmlinWebView(mathView3, ((OptionObject) arrayList.get(2)).getOptionText());
            relativeLayout3.setTag((position + 1) + "9108" + gettagnumberfromalphabet(((OptionObject) arrayList.get(2)).getOptionAlphabet()));
            relativeLayout3.setVisibility(0);
            viewFindViewById3.setVisibility(0);
        }
        if (!this.questionObjectArrayList.get(position).getOption4().isEmpty()) {
            setHtmlinWebView(mathView4, ((OptionObject) arrayList.get(3)).getOptionText());
            relativeLayout4.setTag((position + 1) + "9108" + gettagnumberfromalphabet(((OptionObject) arrayList.get(3)).getOptionAlphabet()));
            relativeLayout4.setVisibility(0);
            viewFindViewById4.setVisibility(0);
        }
        if (this.questionObjectArrayList.get(position).getOption5() != null && !this.questionObjectArrayList.get(position).getOption5().isEmpty()) {
            Helper.load(mathView5, ((OptionObject) arrayList.get(4)).getOptionText());
            relativeLayout5.setTag((position + 1) + "9108" + gettagnumberfromalphabet(((OptionObject) arrayList.get(4)).getOptionAlphabet()));
            relativeLayout5.setVisibility(0);
            viewFindViewById5.setVisibility(0);
        }
        if (this.questionObjectArrayList.get(position).getOption6() != null && !this.questionObjectArrayList.get(position).getOption6().isEmpty()) {
            Helper.load(mathView6, ((OptionObject) arrayList.get(5)).getOptionText());
            relativeLayout6.setTag((position + 1) + "9108" + gettagnumberfromalphabet(((OptionObject) arrayList.get(5)).getOptionAlphabet()));
            relativeLayout6.setVisibility(0);
            viewFindViewById6.setVisibility(0);
        }
        if (this.questionObjectArrayList.get(position).getOption7() != null && !this.questionObjectArrayList.get(position).getOption7().isEmpty()) {
            Helper.load(mathView7, ((OptionObject) arrayList.get(6)).getOptionText());
            relativeLayout7.setTag((position + 1) + "9108" + gettagnumberfromalphabet(((OptionObject) arrayList.get(6)).getOptionAlphabet()));
            relativeLayout7.setVisibility(0);
            viewFindViewById7.setVisibility(0);
        }
        if (this.questionObjectArrayList.get(position).getOption8() != null && !this.questionObjectArrayList.get(position).getOption8().isEmpty()) {
            Helper.load(mathView8, ((OptionObject) arrayList.get(7)).getOptionText());
            relativeLayout8.setTag((position + 1) + "9108" + gettagnumberfromalphabet(((OptionObject) arrayList.get(7)).getOptionAlphabet()));
            relativeLayout8.setVisibility(0);
            viewFindViewById8.setVisibility(0);
        }
        container.addView(itemView);
        return itemView;
    }

    private int gettagnumberfromalphabet(String str) {
        if (str.trim().equalsIgnoreCase("a")) {
            return 1;
        }
        if (str.trim().equalsIgnoreCase("b")) {
            return 2;
        }
        if (str.trim().equalsIgnoreCase("c")) {
            return 3;
        }
        if (str.trim().equalsIgnoreCase("d")) {
            return 4;
        }
        if (str.trim().equalsIgnoreCase("e")) {
            return 5;
        }
        if (str.trim().equalsIgnoreCase("f")) {
            return 6;
        }
        if (str.trim().equalsIgnoreCase("g")) {
            return 7;
        }
        return str.trim().equalsIgnoreCase("h") ? 8 : 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ScrollView) object);
        addToCache((View) object);
    }

    private void addToCache(View view) {
        if (this.pageCache.size() < this.MAX_SIZE) {
            this.pageCache.add(new SoftReference<>(view));
            return;
        }
        for (int size = this.pageCache.size() - 1; size >= 0; size--) {
            if (this.pageCache.get(size).get() == null) {
                this.pageCache.set(size, new SoftReference<>(view));
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Question question = this.questionObjectArrayList.get(Integer.parseInt(v.getTag().toString().trim().split("9108")[0]) - 1);
        if (question.getQuestionType().equalsIgnoreCase("SC") || question.getQuestionType().equalsIgnoreCase("MC")) {
            multipleChoice_7_clicked(v);
        }
    }

    public void multipleChoice_7_clicked(View v) {
        String str;
        String str2;
        char c2;
        String strTrim = v.getTag().toString().trim();
        String str3 = "9108";
        String[] strArrSplit = strTrim.split("9108");
        char c3 = 0;
        char c4 = 1;
        this.questionObjectArrayList.get(Integer.parseInt(strArrSplit[0]) - 1);
        String str4 = "";
        int i = 1;
        while (i <= 8) {
            String str5 = strArrSplit[c3] + str3 + i;
            char c5 = c4;
            if (str5.equalsIgnoreCase(strTrim)) {
                if (strArrSplit[c5].equalsIgnoreCase("1")) {
                    str4 = "a";
                } else if (strArrSplit[c5].equalsIgnoreCase("2")) {
                    str4 = "b";
                } else if (strArrSplit[c5].equalsIgnoreCase("3")) {
                    str4 = "c";
                } else if (strArrSplit[c5].equalsIgnoreCase("4")) {
                    str4 = "d";
                } else if (strArrSplit[c5].equalsIgnoreCase("5")) {
                    str4 = "e";
                } else if (strArrSplit[c5].equalsIgnoreCase("6")) {
                    str4 = "f";
                } else if (strArrSplit[c5].equalsIgnoreCase("7")) {
                    str4 = "g";
                } else if (strArrSplit[c5].equalsIgnoreCase("8")) {
                    str4 = "h";
                }
                str = strTrim;
                TextView textView = (TextView) ((RelativeLayout) v.findViewWithTag(strTrim)).getChildAt(0);
                if (str4.equalsIgnoreCase("")) {
                    if (str5.equalsIgnoreCase(strArrSplit[0] + "91081") || str5.equalsIgnoreCase(strArrSplit[0] + "91082") || str5.equalsIgnoreCase(strArrSplit[0] + "91083") || str5.equalsIgnoreCase(strArrSplit[0] + "91084") || str5.equalsIgnoreCase(strArrSplit[0] + "91085") || str5.equalsIgnoreCase(strArrSplit[0] + "91086")) {
                        textView.setBackground(this.context.getResources().getDrawable(R.drawable.radio_deselct_plan));
                    }
                    str4 = "";
                } else {
                    textView.setBackground(this.context.getResources().getDrawable(R.drawable.radio_select_plan));
                }
            } else {
                str = strTrim;
                RelativeLayout relativeLayout = (RelativeLayout) ((LinearLayout) v.getParent()).findViewWithTag(str5);
                if (relativeLayout != null) {
                    TextView textView2 = (TextView) relativeLayout.getChildAt(0);
                    str2 = str3;
                    if (str5.equalsIgnoreCase(strArrSplit[0] + "91081") || str5.equalsIgnoreCase(strArrSplit[0] + "91082") || str5.equalsIgnoreCase(strArrSplit[0] + "91083") || str5.equalsIgnoreCase(strArrSplit[0] + "91084") || str5.equalsIgnoreCase(strArrSplit[0] + "91085")) {
                        textView2.setBackground(this.context.getResources().getDrawable(R.drawable.radio_deselct_plan));
                    } else {
                        c2 = 0;
                        if (str5.equalsIgnoreCase(strArrSplit[0] + "91086")) {
                            textView2.setBackground(this.context.getResources().getDrawable(R.drawable.radio_deselct_plan));
                        }
                        i++;
                        c4 = c5;
                        c3 = c2;
                        strTrim = str;
                        str3 = str2;
                    }
                }
                c2 = 0;
                i++;
                c4 = c5;
                c3 = c2;
                strTrim = str;
                str3 = str2;
            }
            str2 = str3;
            c2 = 0;
            i++;
            c4 = c5;
            c3 = c2;
            strTrim = str;
            str3 = str2;
        }
    }

    public class WebAppInterface {
        Context mContext;
        RelativeLayout vgg;
        WebView web;

        WebAppInterface(Context c2, WebView wv, RelativeLayout vg) {
            this.mContext = c2;
            this.web = wv;
            this.vgg = vg;
        }

        @JavascriptInterface
        public void showToast(String toast) {
            ((AppCompatActivity) QuestionPagerAdaptor.this.context).runOnUiThread(new Runnable() { // from class: com.appnew.android.testmodule.adapter.QuestionPagerAdaptor$WebAppInterface$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showToast$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showToast$0() {
            this.vgg.performClick();
        }
    }

    private void setHtmlinWebView(WebView webView, String html) {
        try {
            webView.loadDataWithBaseURL("", "<html><body>" + ("<div onClick=\"showAndroidToast('Hello Android!')\" >" + html + "</div>\n\n<script type=\"text/javascript\">\n    function showAndroidToast(toast) {\n        Android.showToast(toast);\n    }\n</script>") + "</body></html>", "text/html; charset=UTF-8", null, "");
            webView.setBackgroundColor(0);
            webView.setLayerType(2, null);
            webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.testmodule.adapter.QuestionPagerAdaptor$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return QuestionPagerAdaptor.lambda$setHtmlinWebView$0(view);
                }
            });
            webView.setLongClickable(false);
            webView.setHapticFeedbackEnabled(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
