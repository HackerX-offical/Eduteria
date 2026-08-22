package org.jivesoftware.smackx.muclight;

import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightRoomConfiguration {
    private final HashMap<String, String> customConfigs;
    private final String roomName;
    private final String subject;

    public MUCLightRoomConfiguration(String str, String str2, HashMap<String, String> map) {
        this.roomName = str;
        this.subject = str2;
        this.customConfigs = map;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getSubject() {
        return this.subject;
    }

    public HashMap<String, String> getCustomConfigs() {
        return this.customConfigs;
    }
}
