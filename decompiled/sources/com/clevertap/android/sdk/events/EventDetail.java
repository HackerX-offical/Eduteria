package com.clevertap.android.sdk.events;

/* JADX INFO: loaded from: classes7.dex */
public class EventDetail {
    private final int count;
    private final int firstTime;
    private final int lastTime;
    private final String name;

    public EventDetail(int i, int i2, int i3, String str) {
        this.count = i;
        this.firstTime = i2;
        this.lastTime = i3;
        this.name = str;
    }

    public int getCount() {
        return this.count;
    }

    public int getFirstTime() {
        return this.firstTime;
    }

    public int getLastTime() {
        return this.lastTime;
    }

    public String getName() {
        return this.name;
    }
}
