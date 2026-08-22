package org.minidns.dnslabel;

import org.minidns.idna.MiniDnsIdna;

/* JADX INFO: loaded from: classes10.dex */
public final class ALabel extends XnLabel {
    protected ALabel(String str) {
        super(str);
    }

    @Override // org.minidns.dnslabel.DnsLabel
    protected String getInternationalizedRepresentationInternal() {
        return MiniDnsIdna.toUnicode(this.label);
    }
}
