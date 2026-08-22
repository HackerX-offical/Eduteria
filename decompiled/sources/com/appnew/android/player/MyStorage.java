package com.appnew.android.player;

import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class MyStorage {
    private static final MyStorage ourInstance = new MyStorage();
    public HashMap<String, Object> storage = new HashMap<>();

    public static MyStorage getInstance() {
        return ourInstance;
    }

    private MyStorage() {
    }
}
