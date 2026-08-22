package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzip {
    static String zza(zzfs zzfsVar) {
        StringBuilder sb = new StringBuilder(zzfsVar.zzd());
        for (int i = 0; i < zzfsVar.zzd(); i++) {
            byte bZza = zzfsVar.zza(i);
            if (bZza == 34) {
                sb.append("\\\"");
            } else if (bZza == 39) {
                sb.append("\\'");
            } else if (bZza != 92) {
                switch (bZza) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bZza < 32 || bZza > 126) {
                            sb.append('\\');
                            sb.append((char) (((bZza >>> 6) & 3) + 48));
                            sb.append((char) (((bZza >>> 3) & 7) + 48));
                            sb.append((char) ((bZza & 7) + 48));
                        } else {
                            sb.append((char) bZza);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
