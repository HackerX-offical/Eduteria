package com.appnew.android.Intro.Fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.LanguagesTable;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LanguageFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010*\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010+\u001a\u00020\u001fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lcom/appnew/android/Intro/Fragment/LanguageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "param1", "", "param2", "english_img", "Landroid/widget/ImageView;", "getEnglish_img", "()Landroid/widget/ImageView;", "setEnglish_img", "(Landroid/widget/ImageView;)V", "langlistdata", "Ljava/util/ArrayList;", "Lcom/appnew/android/table/LanguagesTable;", "Lkotlin/collections/ArrayList;", "getLanglistdata", "()Ljava/util/ArrayList;", "setLanglistdata", "(Ljava/util/ArrayList;)V", "hindi_img", "getHindi_img", "setHindi_img", "is_lang_select", "", "()Ljava/lang/Boolean;", "set_lang_select", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onActivityCreated", "checkLang", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LanguageFragment extends Fragment {
    private ImageView english_img;
    private ImageView hindi_img;
    private String param1;
    private String param2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private ArrayList<LanguagesTable> langlistdata = new ArrayList<>();
    private Boolean is_lang_select = false;

    @JvmStatic
    public static final LanguageFragment newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    public final ImageView getEnglish_img() {
        return this.english_img;
    }

    public final void setEnglish_img(ImageView imageView) {
        this.english_img = imageView;
    }

    public final ArrayList<LanguagesTable> getLanglistdata() {
        return this.langlistdata;
    }

    public final void setLanglistdata(ArrayList<LanguagesTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.langlistdata = arrayList;
    }

    public final ImageView getHindi_img() {
        return this.hindi_img;
    }

    public final void setHindi_img(ImageView imageView) {
        this.hindi_img = imageView;
    }

    /* JADX INFO: renamed from: is_lang_select, reason: from getter */
    public final Boolean getIs_lang_select() {
        return this.is_lang_select;
    }

    public final void set_lang_select(Boolean bool) {
        this.is_lang_select = bool;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.param1 = arguments.getString("param1");
            this.param2 = arguments.getString("param2");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_language, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.english_img = (ImageView) view.findViewById(R.id.english_img);
        this.hindi_img = (ImageView) view.findViewById(R.id.hindi_img);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        this.langlistdata = ((IntroActivity) activity).getLanglist();
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        if (!TextUtils.isEmpty(((IntroActivity) activity2).getPrefence())) {
            FragmentActivity activity3 = getActivity();
            Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            if (StringsKt.contains$default((CharSequence) ((IntroActivity) activity3).getPrefence(), (CharSequence) "#@", false, 2, (Object) null)) {
                FragmentActivity activity4 = getActivity();
                Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                List listSplit$default = StringsKt.split$default((CharSequence) ((IntroActivity) activity4).getPrefence(), new String[]{"#@"}, false, 0, 6, (Object) null);
                if (Intrinsics.areEqual(listSplit$default.get(6), "1")) {
                    this.is_lang_select = true;
                    FragmentActivity activity5 = getActivity();
                    Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                    ((IntroActivity) activity5).set_lang("1");
                    ImageView imageView = this.english_img;
                    Intrinsics.checkNotNull(imageView);
                    imageView.setImageResource(R.drawable.ic_eng_selected);
                    ImageView imageView2 = this.hindi_img;
                    Intrinsics.checkNotNull(imageView2);
                    imageView2.setImageResource(R.drawable.hindi_img);
                } else if (Intrinsics.areEqual(listSplit$default.get(6), "0")) {
                    this.is_lang_select = true;
                    FragmentActivity activity6 = getActivity();
                    Intrinsics.checkNotNull(activity6, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                    ((IntroActivity) activity6).set_lang("1,2");
                    ImageView imageView3 = this.english_img;
                    Intrinsics.checkNotNull(imageView3);
                    imageView3.setImageResource(R.drawable.ic_eng_selected);
                    ImageView imageView4 = this.hindi_img;
                    Intrinsics.checkNotNull(imageView4);
                    imageView4.setImageResource(R.drawable.ic_hin_selected);
                } else if (Intrinsics.areEqual(listSplit$default.get(6), "2")) {
                    this.is_lang_select = true;
                    FragmentActivity activity7 = getActivity();
                    Intrinsics.checkNotNull(activity7, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                    ((IntroActivity) activity7).set_lang("2");
                    this.is_lang_select = true;
                    ImageView imageView5 = this.english_img;
                    Intrinsics.checkNotNull(imageView5);
                    imageView5.setImageResource(R.drawable.english_intro);
                    ImageView imageView6 = this.hindi_img;
                    Intrinsics.checkNotNull(imageView6);
                    imageView6.setImageResource(R.drawable.ic_hin_selected);
                }
            } else {
                checkLang();
            }
        } else {
            checkLang();
        }
        ImageView imageView7 = this.english_img;
        Intrinsics.checkNotNull(imageView7);
        imageView7.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Fragment.LanguageFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageFragment.onActivityCreated$lambda$1(this.f$0, view);
            }
        });
        ImageView imageView8 = this.hindi_img;
        Intrinsics.checkNotNull(imageView8);
        imageView8.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Fragment.LanguageFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageFragment.onActivityCreated$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityCreated$lambda$1(LanguageFragment languageFragment, View view) {
        FragmentActivity activity = languageFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        if (((IntroActivity) activity).getIs_lang().equals("2")) {
            FragmentActivity activity2 = languageFragment.getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            ((IntroActivity) activity2).set_lang("1,2");
            languageFragment.is_lang_select = true;
            ImageView imageView = languageFragment.english_img;
            Intrinsics.checkNotNull(imageView);
            imageView.setImageResource(R.drawable.ic_eng_selected);
            return;
        }
        FragmentActivity activity3 = languageFragment.getActivity();
        Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        if (((IntroActivity) activity3).getIs_lang().equals("")) {
            FragmentActivity activity4 = languageFragment.getActivity();
            Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            ((IntroActivity) activity4).set_lang("1");
            languageFragment.is_lang_select = true;
            ImageView imageView2 = languageFragment.english_img;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setImageResource(R.drawable.ic_eng_selected);
            return;
        }
        FragmentActivity activity5 = languageFragment.getActivity();
        Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        if (((IntroActivity) activity5).getIs_lang().equals("1,2")) {
            FragmentActivity activity6 = languageFragment.getActivity();
            Intrinsics.checkNotNull(activity6, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            ((IntroActivity) activity6).set_lang("2");
            languageFragment.is_lang_select = true;
            ImageView imageView3 = languageFragment.english_img;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setImageResource(R.drawable.english_intro);
            ImageView imageView4 = languageFragment.hindi_img;
            Intrinsics.checkNotNull(imageView4);
            imageView4.setImageResource(R.drawable.ic_hin_selected);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityCreated$lambda$2(LanguageFragment languageFragment, View view) {
        FragmentActivity activity = languageFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        if (((IntroActivity) activity).getIs_lang().equals("1")) {
            FragmentActivity activity2 = languageFragment.getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            ((IntroActivity) activity2).set_lang("1,2");
            languageFragment.is_lang_select = true;
            ImageView imageView = languageFragment.hindi_img;
            Intrinsics.checkNotNull(imageView);
            imageView.setImageResource(R.drawable.ic_hin_selected);
            return;
        }
        FragmentActivity activity3 = languageFragment.getActivity();
        Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        if (((IntroActivity) activity3).getIs_lang().equals("")) {
            FragmentActivity activity4 = languageFragment.getActivity();
            Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            ((IntroActivity) activity4).set_lang("2");
            languageFragment.is_lang_select = true;
            ImageView imageView2 = languageFragment.hindi_img;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setImageResource(R.drawable.ic_hin_selected);
            return;
        }
        FragmentActivity activity5 = languageFragment.getActivity();
        Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        if (((IntroActivity) activity5).getIs_lang().equals("1,2")) {
            FragmentActivity activity6 = languageFragment.getActivity();
            Intrinsics.checkNotNull(activity6, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            ((IntroActivity) activity6).set_lang("1");
            languageFragment.is_lang_select = true;
            ImageView imageView3 = languageFragment.english_img;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setImageResource(R.drawable.ic_eng_selected);
            ImageView imageView4 = languageFragment.hindi_img;
            Intrinsics.checkNotNull(imageView4);
            imageView4.setImageResource(R.drawable.hindi_img);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void checkLang() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        Data data = ((IntroActivity) activity).getData();
        String lang = data != null ? data.getLang() : null;
        if (lang != null) {
            switch (lang.hashCode()) {
                case 48:
                    if (lang.equals("0")) {
                        this.is_lang_select = true;
                        FragmentActivity activity2 = getActivity();
                        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                        ((IntroActivity) activity2).set_lang("1,2");
                        ImageView imageView = this.english_img;
                        Intrinsics.checkNotNull(imageView);
                        imageView.setImageResource(R.drawable.ic_eng_selected);
                        ImageView imageView2 = this.hindi_img;
                        Intrinsics.checkNotNull(imageView2);
                        imageView2.setImageResource(R.drawable.ic_hin_selected);
                        return;
                    }
                    break;
                case 49:
                    if (lang.equals("1")) {
                        this.is_lang_select = true;
                        FragmentActivity activity3 = getActivity();
                        Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                        ((IntroActivity) activity3).set_lang("1");
                        ImageView imageView3 = this.english_img;
                        Intrinsics.checkNotNull(imageView3);
                        imageView3.setImageResource(R.drawable.ic_eng_selected);
                        ImageView imageView4 = this.hindi_img;
                        Intrinsics.checkNotNull(imageView4);
                        imageView4.setImageResource(R.drawable.hindi_img);
                        return;
                    }
                    break;
                case 50:
                    if (lang.equals("2")) {
                        this.is_lang_select = true;
                        FragmentActivity activity4 = getActivity();
                        Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                        ((IntroActivity) activity4).set_lang("2");
                        this.is_lang_select = true;
                        ImageView imageView5 = this.english_img;
                        Intrinsics.checkNotNull(imageView5);
                        imageView5.setImageResource(R.drawable.english_intro);
                        ImageView imageView6 = this.hindi_img;
                        Intrinsics.checkNotNull(imageView6);
                        imageView6.setImageResource(R.drawable.ic_hin_selected);
                        return;
                    }
                    break;
            }
        }
        this.is_lang_select = true;
        FragmentActivity activity5 = getActivity();
        Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        ((IntroActivity) activity5).set_lang("1,2");
        ImageView imageView7 = this.english_img;
        Intrinsics.checkNotNull(imageView7);
        imageView7.setImageResource(R.drawable.ic_eng_selected);
        ImageView imageView8 = this.hindi_img;
        Intrinsics.checkNotNull(imageView8);
        imageView8.setImageResource(R.drawable.ic_hin_selected);
    }

    /* JADX INFO: compiled from: LanguageFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/appnew/android/Intro/Fragment/LanguageFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/Intro/Fragment/LanguageFragment;", "param1", "", "param2", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LanguageFragment newInstance(String param1, String param2) {
            Intrinsics.checkNotNullParameter(param1, "param1");
            Intrinsics.checkNotNullParameter(param2, "param2");
            LanguageFragment languageFragment = new LanguageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param1", param1);
            bundle.putString("param2", param2);
            languageFragment.setArguments(bundle);
            return languageFragment;
        }
    }
}
