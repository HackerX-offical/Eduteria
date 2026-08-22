package com.razorpay;

import android.content.Context;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amazonaws.services.s3.internal.Constants;

/* JADX INFO: loaded from: classes9.dex */
class GpuInfoUtil {
    private static final String KEY_GPU_RENDERER = "gpu_renderer";
    private static final String KEY_GPU_VENDOR = "gpu_vendor";
    private static boolean gpuInfoFetched = false;
    private static String gpuRenderer = "unknown";
    private static String gpuVendor = "unknown";

    GpuInfoUtil() {
    }

    static void loadFromCache(Context context) {
        try {
            String value = SharedPreferenceUtil.getValue(context, KEY_GPU_RENDERER);
            String value2 = SharedPreferenceUtil.getValue(context, KEY_GPU_VENDOR);
            if (value == null || value2 == null) {
                return;
            }
            gpuRenderer = value;
            gpuVendor = value2;
            gpuInfoFetched = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveToCache(Context context) {
        try {
            SharedPreferenceUtil.setValue(context, KEY_GPU_RENDERER, gpuRenderer);
            SharedPreferenceUtil.setValue(context, KEY_GPU_VENDOR, gpuVendor);
        } catch (Exception unused) {
        }
    }

    static void extractGpuInfo(WebView webView, final Context context) {
        if (gpuInfoFetched || webView == null) {
            return;
        }
        try {
            webView.evaluateJavascript("(function() {   try {     var canvas = document.createElement('canvas');     var gl = canvas.getContext('webgl') || canvas.getContext('experimental-webgl');     if (gl) {       var debugInfo = gl.getExtension('WEBGL_debug_renderer_info');       if (debugInfo) {         return gl.getParameter(debugInfo.UNMASKED_RENDERER_WEBGL);       }     }   } catch(e) { }   return 'unknown'; })()", new ValueCallback<String>() { // from class: com.razorpay.GpuInfoUtil.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                    if (str == null || str.equals(Constants.NULL_VERSION_ID) || str.equals("\"unknown\"")) {
                        return;
                    }
                    String unused = GpuInfoUtil.gpuRenderer = str.replace("\"", "");
                    String unused2 = GpuInfoUtil.gpuRenderer;
                }
            });
            webView.evaluateJavascript("(function() {   try {     var canvas = document.createElement('canvas');     var gl = canvas.getContext('webgl') || canvas.getContext('experimental-webgl');     if (gl) {       var debugInfo = gl.getExtension('WEBGL_debug_renderer_info');       if (debugInfo) {         return gl.getParameter(debugInfo.UNMASKED_VENDOR_WEBGL);       }     }   } catch(e) { }   return 'unknown'; })()", new ValueCallback<String>() { // from class: com.razorpay.GpuInfoUtil.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                    if (str == null || str.equals(Constants.NULL_VERSION_ID) || str.equals("\"unknown\"")) {
                        return;
                    }
                    String unused = GpuInfoUtil.gpuVendor = str.replace("\"", "");
                    String unused2 = GpuInfoUtil.gpuVendor;
                    boolean unused3 = GpuInfoUtil.gpuInfoFetched = true;
                    GpuInfoUtil.saveToCache(context);
                    Lumberjack.updateGpuInfo();
                }
            });
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "error:exception", "Error extracting GPU info");
        }
    }

    static String getGpuRenderer() {
        return gpuRenderer;
    }

    static String getGpuVendor() {
        return gpuVendor;
    }

    static boolean isGpuInfoAvailable() {
        return gpuInfoFetched;
    }

    static void reset() {
        gpuRenderer = "unknown";
        gpuVendor = "unknown";
        gpuInfoFetched = false;
    }
}
