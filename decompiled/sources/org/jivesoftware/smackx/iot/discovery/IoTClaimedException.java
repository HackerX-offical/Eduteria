package org.jivesoftware.smackx.iot.discovery;

import org.jivesoftware.smackx.iot.IoTException;
import org.jivesoftware.smackx.iot.discovery.element.IoTClaimed;

/* JADX INFO: loaded from: classes10.dex */
public class IoTClaimedException extends IoTException {
    private static final long serialVersionUID = 1;
    private final IoTClaimed iotClaimed;

    public IoTClaimedException(IoTClaimed ioTClaimed) {
        this.iotClaimed = ioTClaimed;
    }

    public IoTClaimed getIoTClaimed() {
        return this.iotClaimed;
    }
}
