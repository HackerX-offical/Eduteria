package com.razorpay;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class CheckoutCacheManager {
    private static CheckoutCacheManager instance;
    public String buildNumber;
    public String checkoutPublicUrl;
    private Context context;
    public String publicPageResponse;
    public boolean areAllFilesDownloaded = false;
    public boolean isCachingDisabled = false;
    private boolean shouldClearCache = false;
    public boolean isFetchedPublicPageUsed = false;
    public HashMap<String, String> files = new HashMap<>();
    private HashMap<String, String> fileLocations = new HashMap<>();
    Map<String, Object> props = new HashMap();

    private CheckoutCacheManager() {
    }

    public static CheckoutCacheManager getInstance() {
        if (instance == null) {
            instance = new CheckoutCacheManager();
        }
        return instance;
    }

    public void startPrefetchForPublicPage() {
        this.checkoutPublicUrl = "https://api.razorpay.com/v1/checkout/public?platform=android&version=1.7.14&library=checkoutjs";
        Owl.get("https://api.razorpay.com/v1/checkout/public?platform=android&version=1.7.14&library=checkoutjs", new Callback() { // from class: com.razorpay.CheckoutCacheManager$$ExternalSyntheticLambda3
            @Override // com.razorpay.Callback
            public final void run(ResponseObject responseObject) {
                this.f$0.m12321x161abd05(responseObject);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$startPrefetchForPublicPage$0$com-razorpay-CheckoutCacheManager, reason: not valid java name */
    /* synthetic */ void m12321x161abd05(ResponseObject responseObject) {
        if (responseObject.getResponseCode() > 400) {
            this.isCachingDisabled = true;
        } else {
            this.publicPageResponse = responseObject.getResponseResult();
        }
    }

    public void startPrefetch(final Context context) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.razorpay.CheckoutCacheManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12317lambda$startPrefetch$1$comrazorpayCheckoutCacheManager(context);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$startPrefetch$1$com-razorpay-CheckoutCacheManager, reason: not valid java name */
    /* synthetic */ void m12317lambda$startPrefetch$1$comrazorpayCheckoutCacheManager(Context context) {
        this.context = context;
        startPrefetch();
    }

    private void trackEvent(AnalyticsEvent analyticsEvent, String str, Object obj) {
        this.props.clear();
        this.props.put(str, obj);
        AnalyticsUtil.trackEvent(analyticsEvent, this.props);
    }

    public void startPrefetch() {
        Logger.d("LOAD_TIME Merchant initialized checkout: " + System.currentTimeMillis());
        trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_STARTED, "timestamp", Long.valueOf(System.currentTimeMillis()));
        Owl.get("https://checkout.razorpay.com/v1/prefetch.json", new Callback() { // from class: com.razorpay.CheckoutCacheManager$$ExternalSyntheticLambda0
            @Override // com.razorpay.Callback
            public final void run(ResponseObject responseObject) {
                this.f$0.m12320lambda$startPrefetch$4$comrazorpayCheckoutCacheManager(responseObject);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$startPrefetch$4$com-razorpay-CheckoutCacheManager, reason: not valid java name */
    /* synthetic */ void m12320lambda$startPrefetch$4$comrazorpayCheckoutCacheManager(ResponseObject responseObject) {
        trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_FILE_DOWNLOADED, "timestamp", Long.valueOf(System.currentTimeMillis()));
        if (isErrorOrIsCachingDisabled(responseObject)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(responseObject.getResponseResult());
            this.buildNumber = jSONObject.getString(InAppPurchaseConstants.METHOD_BUILD);
            final JSONArray jSONArray = jSONObject.getJSONArray("files");
            String strOptString = jSONObject.optString("traffic_env");
            this.checkoutPublicUrl = "https://api.razorpay.com/v1/checkout/public?platform=android&version=1.7.14&library=checkoutjs&build=" + this.buildNumber;
            if (!strOptString.isEmpty()) {
                this.checkoutPublicUrl += "&traffic_env=" + strOptString;
            }
            trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_PUBLIC_PAGE_DOWNLOAD_START, "timestamp", Long.valueOf(System.currentTimeMillis()));
            Owl.get(this.checkoutPublicUrl, new Callback() { // from class: com.razorpay.CheckoutCacheManager$$ExternalSyntheticLambda1
                @Override // com.razorpay.Callback
                public final void run(ResponseObject responseObject2) {
                    this.f$0.m12318lambda$startPrefetch$2$comrazorpayCheckoutCacheManager(responseObject2);
                }
            });
            if (doesBuildNumberExist(this.buildNumber)) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_BUILD_EXISTS);
                File file = new File(this.context.getFilesDir() + "/razorpay/" + this.buildNumber);
                for (int i = 0; i < jSONArray.length(); i++) {
                    Logger.d("build number exists");
                    String string = jSONArray.getString(i);
                    String strSubstring = string.substring(string.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
                    String fileIfBuildExists = getFileIfBuildExists(strSubstring);
                    if (fileIfBuildExists != null && !fileIfBuildExists.isEmpty()) {
                        this.files.put(strSubstring, fileIfBuildExists);
                        Logger.d(this.files.toString());
                    }
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_BUILD_EXISTS_FILE_ERROR);
                    deleteRecursive(file);
                    Logger.d("File data is empty or null for file " + strSubstring);
                    startPrefetch();
                }
                if (this.files != null) {
                    trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_BUILD_LOCAL_ASSETS_LOADED, "timestamp", Long.valueOf(System.currentTimeMillis()));
                    return;
                }
            }
            trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_ASSET_FILES_DOWNLOAD_START, "timestamp", Long.valueOf(System.currentTimeMillis()));
            for (final int i2 = 0; i2 < jSONArray.length(); i2++) {
                Logger.d("FileName: " + jSONArray.getString(i2));
                final String string2 = jSONArray.getString(i2);
                HashMap map = new HashMap();
                map.put("accept-encoding", "gzip");
                Owl.get(string2, map, new Callback() { // from class: com.razorpay.CheckoutCacheManager$$ExternalSyntheticLambda2
                    @Override // com.razorpay.Callback
                    public final void run(ResponseObject responseObject2) {
                        this.f$0.m12319lambda$startPrefetch$3$comrazorpayCheckoutCacheManager(string2, i2, jSONArray, responseObject2);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: lambda$startPrefetch$2$com-razorpay-CheckoutCacheManager, reason: not valid java name */
    /* synthetic */ void m12318lambda$startPrefetch$2$comrazorpayCheckoutCacheManager(ResponseObject responseObject) {
        trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_PUBLIC_PAGE_DOWNLOAD_COMPLETE, "timestamp", Long.valueOf(System.currentTimeMillis()));
        if (responseObject.getResponseCode() > 400) {
            trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_PUBLIC_PAGE_DOWNLOAD_FAILED, "timestamp", Long.valueOf(System.currentTimeMillis()));
            this.isCachingDisabled = true;
        } else {
            this.publicPageResponse = responseObject.getResponseResult();
        }
    }

    /* JADX INFO: renamed from: lambda$startPrefetch$3$com-razorpay-CheckoutCacheManager, reason: not valid java name */
    /* synthetic */ void m12319lambda$startPrefetch$3$comrazorpayCheckoutCacheManager(String str, int i, JSONArray jSONArray, ResponseObject responseObject) {
        if (responseObject.getResponseResult() == null) {
            trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_ASSET_FILES_DOWNLOAD_INTERRUPTED, "filename", str);
            return;
        }
        try {
            Logger.d(responseObject.getResponseResult());
            this.files.put(str.substring(str.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1), responseObject.getResponseResult());
            Logger.d(str);
            if (i == jSONArray.length() - 1) {
                Logger.d("LOAD_TIME all files are downloaded " + System.currentTimeMillis());
                trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_ASSET_FILES_DOWNLOAD_END, "timestamp", Long.valueOf(System.currentTimeMillis()));
                this.areAllFilesDownloaded = true;
                Context context = this.context;
                if (context != null) {
                    saveFilesToCache(context);
                }
            }
        } catch (Exception unused) {
            trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_DECOMPRESS_FAILED, "filename", str);
        }
    }

    private boolean doesBuildNumberExist(String str) {
        if (this.context != null) {
            return new File(this.context.getFilesDir() + "/razorpay/" + str).exists();
        }
        return false;
    }

    private boolean isErrorOrIsCachingDisabled(ResponseObject responseObject) {
        if (responseObject.getResponseCode() > 400) {
            if (responseObject.getResponseCode() == 404) {
                clearCacheFilesWhenActivityIsAvailable();
            }
            return true;
        }
        try {
            if (new JSONObject(responseObject.getResponseResult()).getBoolean(StreamManagement.Enabled.ELEMENT)) {
                return false;
            }
            clearCacheFilesWhenActivityIsAvailable();
            return true;
        } catch (Exception unused) {
            clearCacheFilesWhenActivityIsAvailable();
            return true;
        }
    }

    private void clearCacheFilesWhenActivityIsAvailable() {
        this.isCachingDisabled = true;
        this.shouldClearCache = true;
        if (this.context != null) {
            deleteRecursive(new File(this.context.getFilesDir() + "/razorpay"));
            reset();
        }
    }

    public void saveFilesToCache(Context context) {
        trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_ASSET_FILES_STORING_START, "timestamp", Long.valueOf(System.currentTimeMillis()));
        Logger.d("LOAD_TIME saveFilesToCache with context: " + System.currentTimeMillis());
        this.context = context;
        if (this.isCachingDisabled) {
            if (this.shouldClearCache) {
                deleteRecursive(new File(context.getFilesDir() + "/razorpay"));
                reset();
                return;
            }
            return;
        }
        String str = context.getFilesDir() + "/razorpay/";
        String str2 = context.getFilesDir() + "/razorpay/" + this.buildNumber;
        File file = new File(str2);
        if (!file.exists() && this.areAllFilesDownloaded) {
            File file2 = new File(str);
            File[] fileArrListFiles = file2.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length >= 3) {
                deleteRecursive(file2);
            }
            file.mkdirs();
            for (Map.Entry<String, String> entry : this.files.entrySet()) {
                if (entry.getValue() == null || entry.getValue().isEmpty()) {
                    deleteRecursive(file2);
                    return;
                }
                if (entry.getValue() == null) {
                    return;
                }
                this.fileLocations.put(entry.getKey(), str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + entry.getKey());
                try {
                    File file3 = new File(str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + entry.getKey());
                    file3.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    fileOutputStream.write(entry.getValue().getBytes());
                    fileOutputStream.close();
                } catch (Exception unused) {
                    HashMap map = new HashMap();
                    map.put("filename", entry.getKey());
                    map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_ASSET_FILES_STORING_FAILED, map);
                }
            }
            trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_ASSET_FILES_STORING_END, "timestamp", Long.valueOf(System.currentTimeMillis()));
        }
    }

    private void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteRecursive(file2);
            }
        }
        file.delete();
    }

    public String getFileIfBuildExists(String str) {
        if (this.isCachingDisabled) {
            return "";
        }
        if (this.files.get(str) != null) {
            HashMap map = new HashMap();
            map.put("filename", str);
            map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_LOCAL_ASSET_FILE_LOADED, map);
            Logger.d("file " + str + " found in fileSet: loading from cache");
            return this.files.get(str);
        }
        File file = new File(this.context.getFilesDir() + "/razorpay/");
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles.length > 0) {
                String str2 = fileArrListFiles[0].getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
                File file2 = new File(str2);
                if (file2.exists()) {
                    Logger.d("checkFileName:" + str2);
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                sb.append(line);
                            } else {
                                String string = sb.toString();
                                Logger.d("fileContents for " + str + ": \n" + string);
                                return string;
                            }
                        }
                    } catch (IOException e2) {
                        Logger.e("fileNotFoundException : " + e2.getLocalizedMessage());
                        Logger.d("fileContents for " + str + ": \n");
                        AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_LOCAL_ASSET_FILE_LOADED, this.props);
                        return "";
                    }
                } else {
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PREFETCH_LOCAL_ASSET_FILE_LOAD_FAILED, this.props);
                }
            }
        }
        return "";
    }

    public void reset() {
        this.areAllFilesDownloaded = false;
        this.shouldClearCache = false;
        this.buildNumber = null;
        this.publicPageResponse = null;
        this.files = new HashMap<>();
        this.checkoutPublicUrl = null;
        this.publicPageResponse = null;
        this.isFetchedPublicPageUsed = false;
    }
}
