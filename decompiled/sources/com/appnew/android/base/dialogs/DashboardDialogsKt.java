package com.appnew.android.base.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Model.Video;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: DashboardDialogs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"showSubjectiveTestPopUp", "", "activity", "Landroid/app/Activity;", "videoArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/Video;", "Lkotlin/collections/ArrayList;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "subjectiveTestListener", "Lcom/appnew/android/base/dialogs/SubjectiveTestListener;", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DashboardDialogsKt {
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v5, types: [T, java.lang.String] */
    public static final void showSubjectiveTestPopUp(final Activity activity, ArrayList<Video> videoArrayList, Intent intent, final SubjectiveTestListener subjectiveTestListener) {
        Ref.ObjectRef objectRef;
        Video video;
        Activity activity2;
        ImageView imageView;
        final Dialog dialog;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(videoArrayList, "videoArrayList");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(subjectiveTestListener, "subjectiveTestListener");
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = "";
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        objectRef4.element = "";
        objectRef2.element = String.valueOf(intent.getStringExtra("course_id"));
        objectRef3.element = String.valueOf(intent.getStringExtra(Const.shareparentid));
        objectRef4.element = String.valueOf(intent.getStringExtra(Const.TILE_TYPE));
        Video video2 = videoArrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(video2, "get(...)");
        Video video3 = video2;
        Object systemService = activity.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.subjectivepopup, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        Activity activity3 = activity;
        Dialog dialog2 = new Dialog(activity3, R.style.CustomAlertDialog);
        dialog2.requestWindowFeature(1);
        dialog2.setCanceledOnTouchOutside(true);
        dialog2.setContentView(viewInflate);
        Window window = dialog2.getWindow();
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -1);
        dialog2.show();
        Constants.SUB_TEST_ID = videoArrayList.get(0).getId();
        View viewFindViewById = viewInflate.findViewById(R.id.ibt_single_sub_vd_tv_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.durationTV);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.paper);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        Button button = (Button) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.ibt_single_sub_vd_iv);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.backimag);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ImageView imageView3 = (ImageView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.test_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        AppCompatTextView appCompatTextView = (AppCompatTextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.upload);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        Button button2 = (Button) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.booklet);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        Button button3 = (Button) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.marks);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        Button button4 = (Button) viewFindViewById9;
        if (!StringsKt.equals(video3.getEnd_date(), "0", true) && !StringsKt.equals(video3.getEnd_date(), "", true)) {
            textView2.setVisibility(0);
            objectRef = objectRef3;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US);
            video = video3;
            String start_date = video.getStart_date();
            imageView = imageView3;
            Intrinsics.checkNotNullExpressionValue(start_date, "getStart_date(...)");
            dialog = dialog2;
            activity2 = activity3;
            long j = 1000;
            String str = simpleDateFormat.format(new Date(Long.parseLong(start_date) * j));
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US);
            String end_date = video.getEnd_date();
            Intrinsics.checkNotNullExpressionValue(end_date, "getEnd_date(...)");
            String str2 = simpleDateFormat2.format(new Date(Long.parseLong(end_date) * j));
            textView2.setText(StringsKt.trimIndent("\n            Test Start: " + Helper.changeAMPM(str) + "\n            Test End: " + Helper.changeAMPM(str2) + "\n            "));
        } else {
            objectRef = objectRef3;
            video = video3;
            activity2 = activity3;
            imageView = imageView3;
            dialog = dialog2;
            textView2.setVisibility(8);
        }
        appCompatTextView.setText(video.getTest_series_name());
        textView.setText(video.getTest_series_name());
        if (video.getAttempt() != null) {
            if (StringsKt.equals(video.getAttempt(), "0", true)) {
                button2.setText("Upload");
            } else {
                button2.setText("View");
            }
        }
        if (video.getImage() == null || StringsKt.equals(video.getImage(), "", true)) {
            imageView2.setImageResource(R.mipmap.square_placeholder);
        } else {
            Helper.setThumbnailImage(activity2, video.getImage(), activity.getDrawable(R.mipmap.square_placeholder), imageView2);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.DashboardDialogsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardDialogsKt.showSubjectiveTestPopUp$lambda$0(dialog, subjectiveTestListener, view);
            }
        });
        final Video video4 = video;
        final Ref.ObjectRef objectRef5 = objectRef;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.DashboardDialogsKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardDialogsKt.showSubjectiveTestPopUp$lambda$3(video4, activity, objectRef5, objectRef2, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.DashboardDialogsKt$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardDialogsKt.showSubjectiveTestPopUp$lambda$4(video4, activity, objectRef5, subjectiveTestListener, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.DashboardDialogsKt$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardDialogsKt.showSubjectiveTestPopUp$lambda$7(video4, activity, objectRef5, objectRef2, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.dialogs.DashboardDialogsKt$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardDialogsKt.showSubjectiveTestPopUp$lambda$8(video4, activity, objectRef5, objectRef2, objectRef4, view);
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.base.dialogs.DashboardDialogsKt$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return DashboardDialogsKt.showSubjectiveTestPopUp$lambda$9(subjectiveTestListener, dialog, dialogInterface, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubjectiveTestPopUp$lambda$0(Dialog dialog, SubjectiveTestListener subjectiveTestListener, View view) {
        if (dialog.isShowing()) {
            dialog.dismiss();
            subjectiveTestListener.backClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSubjectiveTestPopUp$lambda$3(Video video, Activity activity, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, View view) {
        List listEmptyList;
        List listEmptyList2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String start_date = video.getStart_date();
        Intrinsics.checkNotNullExpressionValue(start_date, "getStart_date(...)");
        long j = 1000;
        if (jCurrentTimeMillis < Long.parseLong(start_date) * j) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH);
            String start_date2 = video.getStart_date();
            Intrinsics.checkNotNullExpressionValue(start_date2, "getStart_date(...)");
            Toast.makeText(activity, "Test will start on " + simpleDateFormat.format(new Date(Long.parseLong(start_date2) * j)), 0).show();
            return;
        }
        Activity activity2 = activity;
        if (!Helper.isConnected(activity2)) {
            Toast.makeText(activity2, "No Internet Connection", 0).show();
            return;
        }
        if (StringsKt.equals(video.getIs_locked(), "1", true)) {
            if (objectRef.element == 0 || StringsKt.equals((String) objectRef.element, "", true)) {
                Intent intent = new Intent(activity2, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                intent.putExtra(Const.COURSE_PARENT_ID, "");
                intent.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                activity.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(activity2, (Class<?>) CourseActivity.class);
            intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent2.putExtra(Const.COURSE_ID_MAIN, (String) objectRef.element);
            intent2.putExtra(Const.COURSE_PARENT_ID, "");
            intent2.putExtra(Const.IS_COMBO, false);
            SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
            activity.startActivity(intent2);
            return;
        }
        if (!StringsKt.equals(video.getQuestion(), "", true)) {
            Constants.SUB_TEST_ID = video.getId();
            String question = video.getQuestion();
            Intrinsics.checkNotNullExpressionValue(question, "getQuestion(...)");
            List<String> listSplit = new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(question, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            List<String> listSplit2 = new Regex("\\.").split(strArr[strArr.length - 1], 0);
            if (!listSplit2.isEmpty()) {
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() != 0) {
                        listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList2 = CollectionsKt.emptyList();
            } else {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            Helper.GoToWebViewPDFActivity(activity2, video.getId(), video.getQuestion(), true, ((String[]) listEmptyList2.toArray(new String[0]))[0], (String) objectRef2.element, video.getIs_share());
            return;
        }
        Toast.makeText(activity2, "File not found.", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSubjectiveTestPopUp$lambda$4(Video video, Activity activity, Ref.ObjectRef objectRef, SubjectiveTestListener subjectiveTestListener, View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String start_date = video.getStart_date();
        Intrinsics.checkNotNullExpressionValue(start_date, "getStart_date(...)");
        long j = 1000;
        if (jCurrentTimeMillis < Long.parseLong(start_date) * j) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH);
            String start_date2 = video.getStart_date();
            Intrinsics.checkNotNullExpressionValue(start_date2, "getStart_date(...)");
            Toast.makeText(activity, "Test will start on " + simpleDateFormat.format(new Date(Long.parseLong(start_date2) * j)), 0).show();
            return;
        }
        Activity activity2 = activity;
        if (!Helper.isConnected(activity2)) {
            Toast.makeText(activity2, "No Internet Connection", 0).show();
            return;
        }
        if (StringsKt.equals(video.getIs_locked(), "1", true)) {
            if (objectRef.element == 0 || StringsKt.equals((String) objectRef.element, "", true)) {
                Intent intent = new Intent(activity2, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                intent.putExtra(Const.COURSE_PARENT_ID, "");
                intent.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                activity.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(activity2, (Class<?>) CourseActivity.class);
            intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent2.putExtra(Const.COURSE_ID_MAIN, (String) objectRef.element);
            intent2.putExtra(Const.COURSE_PARENT_ID, "");
            intent2.putExtra(Const.IS_COMBO, false);
            SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
            activity.startActivity(intent2);
            return;
        }
        Constants.SUB_TEST_ID = video.getId();
        subjectiveTestListener.onUploadClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSubjectiveTestPopUp$lambda$7(Video video, Activity activity, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, View view) {
        List listEmptyList;
        List listEmptyList2;
        String result_date = video.getResult_date();
        Intrinsics.checkNotNullExpressionValue(result_date, "getResult_date(...)");
        long j = 1000;
        if (Long.parseLong(result_date) * j < System.currentTimeMillis()) {
            Activity activity2 = activity;
            if (!Helper.isConnected(activity2)) {
                Toast.makeText(activity2, "No Internet Connection", 0).show();
                return;
            }
            if (StringsKt.equals(video.getIs_locked(), "1", true)) {
                if (objectRef.element == 0 || StringsKt.equals((String) objectRef.element, "", true)) {
                    Intent intent = new Intent(activity2, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    activity.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(activity2, (Class<?>) CourseActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent2.putExtra(Const.COURSE_ID_MAIN, (String) objectRef.element);
                intent2.putExtra(Const.COURSE_PARENT_ID, "");
                intent2.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                activity.startActivity(intent2);
                return;
            }
            if (!StringsKt.equals(video.getAnswers(), "", true)) {
                Constants.SUB_TEST_ID = video.getId();
                String answers = video.getAnswers();
                Intrinsics.checkNotNullExpressionValue(answers, "getAnswers(...)");
                List<String> listSplit = new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(answers, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                List<String> listSplit2 = new Regex("\\.").split(strArr[strArr.length - 1], 0);
                if (!listSplit2.isEmpty()) {
                    ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                    while (listIterator2.hasPrevious()) {
                        if (listIterator2.previous().length() != 0) {
                            listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                            break;
                        }
                    }
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                Helper.GoToWebViewPDFActivity(activity2, video.getId(), video.getAnswers(), true, ((String[]) listEmptyList2.toArray(new String[0]))[0], (String) objectRef2.element, video.getIs_share());
                return;
            }
            Toast.makeText(activity2, "File Not found.", 0).show();
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH);
        String result_date2 = video.getResult_date();
        Intrinsics.checkNotNullExpressionValue(result_date2, "getResult_date(...)");
        Toast.makeText(activity, "Result will be available on " + simpleDateFormat.format(new Date(Long.parseLong(result_date2) * j)), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSubjectiveTestPopUp$lambda$8(Video video, Activity activity, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, View view) {
        String result_date = video.getResult_date();
        Intrinsics.checkNotNullExpressionValue(result_date, "getResult_date(...)");
        long j = 1000;
        if (Long.parseLong(result_date) * j < System.currentTimeMillis()) {
            Activity activity2 = activity;
            if (!Helper.isConnected(activity2)) {
                Toast.makeText(activity2, "No Internet Connection", 0).show();
                return;
            }
            if (StringsKt.equals(video.getIs_locked(), "1", true)) {
                if (objectRef.element == 0 || StringsKt.equals((String) objectRef.element, "", true)) {
                    Intent intent = new Intent(activity2, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    activity.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(activity2, (Class<?>) CourseActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent2.putExtra(Const.COURSE_ID_MAIN, (String) objectRef.element);
                intent2.putExtra(Const.COURSE_PARENT_ID, "");
                intent2.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                activity.startActivity(intent2);
                return;
            }
            Constants.SUB_TEST_ID = video.getId();
            Helper.GoToSubjectiveResultActivity(activity2, video.getSolutions(), video.getTest_series_name(), (String) objectRef2.element, video.getId(), (String) objectRef3.element);
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH);
        String result_date2 = video.getResult_date();
        Intrinsics.checkNotNullExpressionValue(result_date2, "getResult_date(...)");
        Toast.makeText(activity, "Result will be available on " + simpleDateFormat.format(new Date(Long.parseLong(result_date2) * j)), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showSubjectiveTestPopUp$lambda$9(SubjectiveTestListener subjectiveTestListener, Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return true;
        }
        subjectiveTestListener.backClick();
        dialog.dismiss();
        return true;
    }
}
