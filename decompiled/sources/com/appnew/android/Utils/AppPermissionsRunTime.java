package com.appnew.android.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.appnew.android.Utils.DialogUtils;
import com.eduteria.app.app.R;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class AppPermissionsRunTime {
    private static ArrayList<String> requiredPermissionMsgs;
    private static ArrayList<String> requiredPermissionsList;

    public enum MyPermissionConstants {
        PERMISSION_CALL,
        PERMISSION_ACCESS_FINE_LOCATION,
        PERMISSION_ACCESS_COARSE_LOCATION,
        PERMISSION_CAMERA,
        PERMISSION_WRITE_EXTERNAL_STORAGE,
        PERMISSION_READ_EXTERNAL_STORAGE,
        PERMISSION_READ_MEDIA_AUDIO,
        PERMISSSION_READ_CALENDAR,
        PERMISSION_WRITE_CALENDAR,
        PERMISSSION_READ_CONTACTS,
        PERMISSION_WRITE_CONTACTS
    }

    public static boolean checkPermission(final Activity mActivity, ArrayList<MyPermissionConstants> rqstedPermissionsList, final int PERMISSION_REQUEST_CODE) {
        ArrayList<String> arrayList = requiredPermissionsList;
        if (arrayList == null) {
            requiredPermissionsList = new ArrayList<>();
            requiredPermissionMsgs = new ArrayList<>();
        } else {
            arrayList.clear();
            requiredPermissionMsgs.clear();
        }
        if (rqstedPermissionsList != null && rqstedPermissionsList.size() > 0) {
            Iterator<MyPermissionConstants> it = rqstedPermissionsList.iterator();
            while (it.hasNext()) {
                switch (it.next()) {
                    case PERMISSION_CALL:
                        addPermission("android.permission.CALL_PHONE", mActivity);
                        break;
                    case PERMISSION_ACCESS_FINE_LOCATION:
                        addPermission("android.permission.ACCESS_FINE_LOCATION", mActivity);
                        break;
                    case PERMISSION_ACCESS_COARSE_LOCATION:
                        addPermission("android.permission.ACCESS_COARSE_LOCATION", mActivity);
                        break;
                    case PERMISSION_CAMERA:
                        addPermission("android.permission.CAMERA", mActivity);
                        break;
                    case PERMISSION_WRITE_EXTERNAL_STORAGE:
                        addPermission("android.permission.READ_EXTERNAL_STORAGE", mActivity);
                        break;
                    case PERMISSION_READ_EXTERNAL_STORAGE:
                        addPermission("android.permission.WRITE_EXTERNAL_STORAGE", mActivity);
                        break;
                    case PERMISSION_READ_MEDIA_AUDIO:
                        if (Build.VERSION.SDK_INT >= 33) {
                            addPermission("android.permission.READ_MEDIA_AUDIO", mActivity);
                        }
                        break;
                    case PERMISSSION_READ_CALENDAR:
                        addPermission("android.permission.READ_CALENDAR", mActivity);
                        break;
                    case PERMISSION_WRITE_CALENDAR:
                        addPermission("android.permission.WRITE_CALENDAR", mActivity);
                        break;
                    case PERMISSSION_READ_CONTACTS:
                        addPermission("android.permission.READ_CONTACTS", mActivity);
                        break;
                    case PERMISSION_WRITE_CONTACTS:
                        addPermission("android.permission.WRITE_CONTACTS", mActivity);
                        break;
                }
            }
        }
        if (requiredPermissionsList.size() <= 0) {
            return true;
        }
        ArrayList<String> arrayList2 = requiredPermissionsList;
        mActivity.requestPermissions((String[]) arrayList2.toArray(new String[arrayList2.size()]), PERMISSION_REQUEST_CODE);
        return false;
    }

    private static void addPermission(final String permission, final Activity mActivity) {
        if (ContextCompat.checkSelfPermission(mActivity, permission) != 0) {
            requiredPermissionsList.add(permission);
        }
    }

    public static void aDialogOnPermissionDenied(final Context mContext) {
        DialogUtils.makeDialog(mContext, mContext.getResources().getString(R.string.alert), mContext.getResources().getString(R.string.reGrantPermissionMsg), mContext.getResources().getString(R.string.action_settings), mContext.getResources().getString(android.R.string.no), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.AppPermissionsRunTime.1
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts(AnalyticsConstants.PACKAGE, mContext.getPackageName(), null));
                intent.addFlags(268435456);
                mContext.startActivity(intent);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Utils.AppPermissionsRunTime.2
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public void onCancelClick() {
            }
        });
    }
}
