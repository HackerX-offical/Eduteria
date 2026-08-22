package org.jivesoftware.smackx.muclight;

import java.util.HashMap;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightRoomInfo {
    private final MUCLightRoomConfiguration configuration;
    private final HashMap<Jid, MUCLightAffiliation> occupants;
    private final Jid room;
    private final String version;

    public MUCLightRoomInfo(String str, Jid jid, MUCLightRoomConfiguration mUCLightRoomConfiguration, HashMap<Jid, MUCLightAffiliation> map) {
        this.version = str;
        this.room = jid;
        this.configuration = mUCLightRoomConfiguration;
        this.occupants = map;
    }

    public String getVersion() {
        return this.version;
    }

    public Jid getRoom() {
        return this.room;
    }

    public MUCLightRoomConfiguration getConfiguration() {
        return this.configuration;
    }

    public HashMap<Jid, MUCLightAffiliation> getOccupants() {
        return this.occupants;
    }
}
