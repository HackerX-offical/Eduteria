package com.google.android.gms.internal.firebase_auth;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzi' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzlo {
    public static final zzlo zza;
    public static final zzlo zzb;
    public static final zzlo zzc;
    public static final zzlo zzd;
    public static final zzlo zze;
    public static final zzlo zzf;
    public static final zzlo zzg;
    public static final zzlo zzh;
    public static final zzlo zzi;
    public static final zzlo zzj;
    public static final zzlo zzk;
    public static final zzlo zzl;
    public static final zzlo zzm;
    public static final zzlo zzn;
    public static final zzlo zzo;
    public static final zzlo zzp;
    public static final zzlo zzq;
    public static final zzlo zzr;
    private static final /* synthetic */ zzlo[] zzu;
    private final zzlr zzs;
    private final int zzt;

    public static zzlo[] values() {
        return (zzlo[]) zzu.clone();
    }

    private zzlo(String str, int i, zzlr zzlrVar, int i2) {
        this.zzs = zzlrVar;
        this.zzt = i2;
    }

    public final zzlr zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzlo(String str, int i, zzlr zzlrVar, int i2, zzll zzllVar) {
        this(str, i, zzlrVar, i2);
    }

    static {
        zzlo zzloVar = new zzlo("DOUBLE", 0, zzlr.DOUBLE, 1);
        zza = zzloVar;
        zzlo zzloVar2 = new zzlo("FLOAT", 1, zzlr.FLOAT, 5);
        zzb = zzloVar2;
        final int i = 2;
        zzlo zzloVar3 = new zzlo("INT64", 2, zzlr.LONG, 0);
        zzc = zzloVar3;
        final int i2 = 3;
        zzlo zzloVar4 = new zzlo("UINT64", 3, zzlr.LONG, 0);
        zzd = zzloVar4;
        zzlo zzloVar5 = new zzlo("INT32", 4, zzlr.INT, 0);
        zze = zzloVar5;
        zzlo zzloVar6 = new zzlo("FIXED64", 5, zzlr.LONG, 1);
        zzf = zzloVar6;
        zzlo zzloVar7 = new zzlo("FIXED32", 6, zzlr.INT, 5);
        zzg = zzloVar7;
        zzlo zzloVar8 = new zzlo("BOOL", 7, zzlr.BOOLEAN, 0);
        zzh = zzloVar8;
        final zzlr zzlrVar = zzlr.STRING;
        final String str = "STRING";
        final int i3 = 8;
        zzlo zzloVar9 = new zzlo(str, i3, zzlrVar, i) { // from class: com.google.android.gms.internal.firebase_auth.zzln
            {
                int i4 = 2;
                zzll zzllVar = null;
                int i5 = 8;
            }
        };
        zzi = zzloVar9;
        final zzlr zzlrVar2 = zzlr.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        zzlo zzloVar10 = new zzlo(str2, i4, zzlrVar2, i2) { // from class: com.google.android.gms.internal.firebase_auth.zzlq
            {
                int i5 = 3;
                zzll zzllVar = null;
                int i6 = 9;
            }
        };
        zzj = zzloVar10;
        final zzlr zzlrVar3 = zzlr.MESSAGE;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        zzlo zzloVar11 = new zzlo(str3, i5, zzlrVar3, i) { // from class: com.google.android.gms.internal.firebase_auth.zzlp
            {
                int i6 = 2;
                zzll zzllVar = null;
                int i7 = 10;
            }
        };
        zzk = zzloVar11;
        final zzlr zzlrVar4 = zzlr.BYTE_STRING;
        final String str4 = "BYTES";
        final int i6 = 11;
        zzlo zzloVar12 = new zzlo(str4, i6, zzlrVar4, i) { // from class: com.google.android.gms.internal.firebase_auth.zzls
            {
                int i7 = 2;
                zzll zzllVar = null;
                int i8 = 11;
            }
        };
        zzl = zzloVar12;
        zzlo zzloVar13 = new zzlo("UINT32", 12, zzlr.INT, 0);
        zzm = zzloVar13;
        zzlo zzloVar14 = new zzlo("ENUM", 13, zzlr.ENUM, 0);
        zzn = zzloVar14;
        zzlo zzloVar15 = new zzlo("SFIXED32", 14, zzlr.INT, 5);
        zzo = zzloVar15;
        zzlo zzloVar16 = new zzlo("SFIXED64", 15, zzlr.LONG, 1);
        zzp = zzloVar16;
        zzlo zzloVar17 = new zzlo("SINT32", 16, zzlr.INT, 0);
        zzq = zzloVar17;
        zzlo zzloVar18 = new zzlo("SINT64", 17, zzlr.LONG, 0);
        zzr = zzloVar18;
        zzu = new zzlo[]{zzloVar, zzloVar2, zzloVar3, zzloVar4, zzloVar5, zzloVar6, zzloVar7, zzloVar8, zzloVar9, zzloVar10, zzloVar11, zzloVar12, zzloVar13, zzloVar14, zzloVar15, zzloVar16, zzloVar17, zzloVar18};
    }
}
