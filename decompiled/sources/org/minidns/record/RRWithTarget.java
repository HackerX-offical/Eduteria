package org.minidns.record;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;

/* JADX INFO: loaded from: classes10.dex */
public abstract class RRWithTarget extends Data {

    @Deprecated
    public final DnsName name;
    public final DnsName target;

    @Override // org.minidns.record.Data
    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        this.target.writeToStream(dataOutputStream);
    }

    protected RRWithTarget(DnsName dnsName) {
        this.target = dnsName;
        this.name = dnsName;
    }

    public String toString() {
        return ((Object) this.target) + InstructionFileId.DOT;
    }

    public final DnsName getTarget() {
        return this.target;
    }
}
