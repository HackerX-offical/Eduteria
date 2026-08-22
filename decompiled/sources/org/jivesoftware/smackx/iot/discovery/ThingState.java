package org.jivesoftware.smackx.iot.discovery;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public class ThingState {

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final List<ThingStateChangeListener> f1497listeners = new CopyOnWriteArrayList();
    private final NodeInfo nodeInfo;
    private BareJid owner;
    private BareJid registry;
    private boolean removed;

    ThingState(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    void setRegistry(BareJid bareJid) {
        this.registry = bareJid;
    }

    void setUnregistered() {
        this.registry = null;
    }

    void setOwner(final BareJid bareJid) {
        this.owner = bareJid;
        Async.go(new Runnable() { // from class: org.jivesoftware.smackx.iot.discovery.ThingState.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ThingState.this.f1497listeners.iterator();
                while (it.hasNext()) {
                    ((ThingStateChangeListener) it.next()).owned(bareJid);
                }
            }
        });
    }

    void setUnowned() {
        this.owner = null;
    }

    void setRemoved() {
        this.removed = true;
    }

    public NodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    public BareJid getRegistry() {
        return this.registry;
    }

    public BareJid getOwner() {
        return this.owner;
    }

    public boolean isOwned() {
        return this.owner != null;
    }

    public boolean isRemoved() {
        return this.removed;
    }

    public boolean setThingStateChangeListener(ThingStateChangeListener thingStateChangeListener) {
        return this.f1497listeners.add(thingStateChangeListener);
    }

    public boolean removeThingStateChangeListener(ThingStateChangeListener thingStateChangeListener) {
        return this.f1497listeners.remove(thingStateChangeListener);
    }
}
