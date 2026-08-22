package com.github.mikephil.charting.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes7.dex */
public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    public static List<Entry> loadEntriesFromFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return arrayList;
                }
                String[] strArrSplit = line.split(MqttTopic.MULTI_LEVEL_WILDCARD);
                if (strArrSplit.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(strArrSplit[0]), Integer.parseInt(strArrSplit[1])));
                } else {
                    int length = strArrSplit.length - 1;
                    float[] fArr = new float[length];
                    for (int i = 0; i < length; i++) {
                        fArr[i] = Float.parseFloat(strArrSplit[i]);
                    }
                    arrayList.add(new BarEntry(Integer.parseInt(strArrSplit[strArrSplit.length - 1]), fArr));
                }
            }
        } catch (IOException e2) {
            Log.e(LOG, e2.toString());
            return arrayList;
        }
    }

    public static List<Entry> loadEntriesFromAssets(AssetManager assetManager, String str) throws Throwable {
        BufferedReader bufferedReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            Log.e(LOG, e3.toString());
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] strArrSplit = line.split(MqttTopic.MULTI_LEVEL_WILDCARD);
                if (strArrSplit.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[0])));
                } else {
                    int length = strArrSplit.length - 1;
                    float[] fArr = new float[length];
                    for (int i = 0; i < length; i++) {
                        fArr[i] = Float.parseFloat(strArrSplit[i]);
                    }
                    arrayList.add(new BarEntry(Integer.parseInt(strArrSplit[strArrSplit.length - 1]), fArr));
                }
            }
            bufferedReader.close();
            return arrayList;
        } catch (IOException e4) {
            e = e4;
            bufferedReader2 = bufferedReader;
            Log.e(LOG, e.toString());
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    Log.e(LOG, e5.toString());
                }
            }
            throw th;
        }
    }

    public static void saveToSdCard(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                Log.e(LOG, e2.toString());
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry entry : list) {
                bufferedWriter.append((CharSequence) (entry.getY() + MqttTopic.MULTI_LEVEL_WILDCARD + entry.getX()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e3) {
            Log.e(LOG, e3.toString());
        }
    }

    public static List<BarEntry> loadBarEntriesFromAssets(AssetManager assetManager, String str) throws Throwable {
        BufferedReader bufferedReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                } catch (IOException e2) {
                    Log.e(LOG, e2.toString());
                    return arrayList;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] strArrSplit = line.split(MqttTopic.MULTI_LEVEL_WILDCARD);
                arrayList.add(new BarEntry(Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[0])));
            }
            bufferedReader.close();
            return arrayList;
        } catch (IOException e4) {
            e = e4;
            bufferedReader2 = bufferedReader;
            Log.e(LOG, e.toString());
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    Log.e(LOG, e5.toString());
                }
            }
            throw th;
        }
    }
}
