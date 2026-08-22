package com.appnew.android.Utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.Thread;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class LocalFileUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final Context mContext;
    private final Thread.UncaughtExceptionHandler mDefaultHandler;

    public LocalFileUncaughtExceptionHandler(Context context, Thread.UncaughtExceptionHandler defaultHandler) {
        this.mDefaultHandler = defaultHandler;
        this.mContext = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable ex) {
        pushEventForAppCrash();
        writeFile(thread, ex);
        this.mDefaultHandler.uncaughtException(thread, ex);
    }

    private void writeFile(final Thread thread, final Throwable ex) {
        try {
            OutputStream logStream = getLogStream();
            logStream.write(getExceptionInformation(thread, ex).getBytes("utf-8"));
            logStream.flush();
            logStream.close();
            Process.killProcess(Process.myPid());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private OutputStream getLogStream() throws IOException {
        File file = new File(Environment.getExternalStorageDirectory(), "crash_multi_type_file_picker.log");
        if (!file.exists()) {
            file.createNewFile();
        }
        return new FileOutputStream(file, true);
    }

    private String getExceptionInformation(Thread thread, Throwable ex) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("\nTHREAD: ");
        sb.append(thread).append("\nBOARD: ");
        sb.append(Build.BOARD).append("\nBOOTLOADER: ");
        sb.append(Build.BOOTLOADER).append("\nBRAND: ");
        sb.append(Build.BRAND).append("\nCPU_ABI: ");
        sb.append(Build.CPU_ABI).append("\nCPU_ABI2: ");
        sb.append(Build.CPU_ABI2).append("\nDEVICE: ");
        sb.append(Build.DEVICE).append("\nDISPLAY: ");
        sb.append(Build.DISPLAY).append("\nFINGERPRINT: ");
        sb.append(Build.FINGERPRINT).append("\nHARDWARE: ");
        sb.append(Build.HARDWARE).append("\nHOST: ");
        sb.append(Build.HOST).append("\nID: ");
        sb.append(Build.ID).append("\nMANUFACTURER: ");
        sb.append(Build.MANUFACTURER).append("\nMODEL: ");
        sb.append(Build.MODEL).append("\nPRODUCT: ");
        sb.append(Build.PRODUCT).append("\nSERIAL: ");
        sb.append(Build.SERIAL).append("\nTAGS: ");
        sb.append(Build.TAGS).append("\nTIME: ");
        sb.append(Build.TIME).append(' ').append(toDateString(Build.TIME)).append("\nTYPE: ");
        sb.append(Build.TYPE).append("\nUSER: ");
        sb.append(Build.USER).append("\nVERSION.CODENAME: ");
        sb.append(Build.VERSION.CODENAME).append("\nVERSION.INCREMENTAL: ");
        sb.append(Build.VERSION.INCREMENTAL).append("\nVERSION.RELEASE: ");
        sb.append(Build.VERSION.RELEASE).append("\nVERSION.SDK_INT: ");
        sb.append(Build.VERSION.SDK_INT).append("\nLANG: ");
        sb.append(this.mContext.getResources().getConfiguration().locale.getLanguage()).append("\nAPP.VERSION.NAME: ");
        sb.append(getVersionName()).append("\nAPP.VERSION.CODE: ");
        sb.append(getVersionCode()).append("\nCURRENT: ");
        sb.append(jCurrentTimeMillis).append(' ').append(toDateString(jCurrentTimeMillis)).append('\n');
        sb.append(getErrorInformation(ex));
        return sb.toString();
    }

    private String getVersionName() {
        try {
            return this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private int getVersionCode() {
        try {
            return this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private String getErrorInformation(Throwable t) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
        t.printStackTrace(printWriter);
        printWriter.flush();
        String str = new String(byteArrayOutputStream.toByteArray());
        printWriter.close();
        return str;
    }

    private String toDateString(long timeMilli) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMilli);
        return String.format(Locale.CHINESE, "%04d.%02d.%02d %02d:%02d:%02d:%03d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)), Integer.valueOf(calendar.get(14)));
    }

    private void pushEventForAppCrash() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        map.put("os_version", AnalyticHelper.INSTANCE.getOSVersion());
        map.put(AnalyticsConstants.crash_time, AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        AnalyticEvents.INSTANCE.pushEvents(this.mContext, AnalyticsConstants.APP_CRASH, map);
    }
}
