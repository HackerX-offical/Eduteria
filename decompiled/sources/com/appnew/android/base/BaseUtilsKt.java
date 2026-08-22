package com.appnew.android.base;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.appnew.android.Model.LeftMenu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: BaseUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"copyFileToInternalStorage", "", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "newDirName", "openWhatsapp", "", "leftMenu", "Lcom/appnew/android/Model/LeftMenu;", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BaseUtilsKt {
    public static final String copyFileToInternalStorage(Context context, Uri uri, String newDirName) {
        File file;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(newDirName, "newDirName");
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
            Intrinsics.checkNotNull(cursorQuery);
            int columnIndex = cursorQuery.getColumnIndex("_display_name");
            int columnIndex2 = cursorQuery.getColumnIndex("_size");
            cursorQuery.moveToFirst();
            String string = cursorQuery.getString(columnIndex);
            String.valueOf(cursorQuery.getLong(columnIndex2));
            if (!Intrinsics.areEqual(newDirName, "")) {
                File file2 = new File(context.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                file = new File(context.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
            } else {
                file = new File(context.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
            }
            if (!file.exists()) {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    Intrinsics.checkNotNull(inputStreamOpenInputStream);
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                inputStreamOpenInputStream.close();
                fileOutputStream.close();
            }
            cursorQuery.close();
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            return path;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final void openWhatsapp(Context context, LeftMenu leftMenu) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(leftMenu, "leftMenu");
        String mobile_number = leftMenu.getMobile_number();
        Intrinsics.checkNotNull(mobile_number);
        if (mobile_number.length() == 0 || StringsKt.equals(mobile_number, "0", true)) {
            Toast.makeText(context, "Mobile Number is Empty or 0.", 0).show();
        } else {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wa.me/" + mobile_number)));
        }
    }
}
