package org.jivesoftware.smackx.time.provider;

import org.jivesoftware.smack.provider.IntrospectionProvider;
import org.jivesoftware.smackx.time.packet.Time;

/* JADX INFO: loaded from: classes10.dex */
public class TimeProvider extends IntrospectionProvider.IQIntrospectionProvider<Time> {
    public TimeProvider() {
        super(Time.class);
    }
}
