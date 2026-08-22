package com.razorpay;

/* JADX INFO: loaded from: classes9.dex */
class CoreConfig extends BaseConfig {
    private static BaseConfig config;

    private CoreConfig() {
    }

    public static BaseConfig getInstance() {
        if (config == null) {
            config = new CoreConfig();
        }
        return config;
    }

    public static void setInstance(BaseConfig baseConfig) {
        config = baseConfig;
    }
}
