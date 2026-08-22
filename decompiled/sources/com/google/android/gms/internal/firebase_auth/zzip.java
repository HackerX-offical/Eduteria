package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzip extends IOException {
    private zzjp zza;

    public zzip(String str) {
        super(str);
        this.zza = null;
    }

    public final zzip zza(zzjp zzjpVar) {
        this.zza = zzjpVar;
        return this;
    }

    static zzip zza() {
        return new zzip("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzip zzb() {
        return new zzip("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzip zzc() {
        return new zzip("CodedInputStream encountered a malformed varint.");
    }

    static zzip zzd() {
        return new zzip("Protocol message contained an invalid tag (zero).");
    }

    static zzip zze() {
        return new zzip("Protocol message end-group tag did not match expected tag.");
    }

    static zzio zzf() {
        return new zzio("Protocol message tag had invalid wire type.");
    }

    static zzip zzg() {
        return new zzip("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzip zzh() {
        return new zzip("Failed to parse the message.");
    }

    static zzip zzi() {
        return new zzip("Protocol message had invalid UTF-8.");
    }
}
