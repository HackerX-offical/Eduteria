package org.jivesoftware.smackx.httpfileupload;

import org.jivesoftware.smack.util.Objects;
import org.jxmpp.jid.DomainBareJid;

/* JADX INFO: loaded from: classes10.dex */
public class UploadService {
    private final DomainBareJid address;
    private final Long maxFileSize;
    private final Version version;

    public enum Version {
        v0_2,
        v0_3
    }

    UploadService(DomainBareJid domainBareJid, Version version) {
        this(domainBareJid, version, null);
    }

    UploadService(DomainBareJid domainBareJid, Version version, Long l) {
        this.address = (DomainBareJid) Objects.requireNonNull(domainBareJid);
        this.version = version;
        this.maxFileSize = l;
    }

    public DomainBareJid getAddress() {
        return this.address;
    }

    public Version getVersion() {
        return this.version;
    }

    public boolean hasMaxFileSizeLimit() {
        return this.maxFileSize != null;
    }

    public Long getMaxFileSize() {
        return this.maxFileSize;
    }

    public boolean acceptsFileOfSize(long j) {
        return !hasMaxFileSizeLimit() || j <= this.maxFileSize.longValue();
    }
}
