package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzeg extends com.google.android.gms.internal.firebase_auth.zza implements zzed {
    public zzeg() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    @Override // com.google.android.gms.internal.firebase_auth.zza
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzec zzeeVar = null;
        switch (i) {
            case 1:
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface;
                    } else {
                        zzeeVar = new zzee(strongBinder);
                    }
                }
                zza(string, zzeeVar);
                break;
            case 2:
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface2 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface2;
                    } else {
                        zzeeVar = new zzee(strongBinder2);
                    }
                }
                zzb(string2, zzeeVar);
                break;
            case 3:
                zzfy zzfyVar = (zzfy) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, zzfy.CREATOR);
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface3 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface3;
                    } else {
                        zzeeVar = new zzee(strongBinder3);
                    }
                }
                zza(zzfyVar, zzeeVar);
                break;
            case 4:
                String string3 = parcel.readString();
                UserProfileChangeRequest userProfileChangeRequest = (UserProfileChangeRequest) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, UserProfileChangeRequest.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface4 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface4;
                    } else {
                        zzeeVar = new zzee(strongBinder4);
                    }
                }
                zza(string3, userProfileChangeRequest, zzeeVar);
                break;
            case 5:
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface5 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface5;
                    } else {
                        zzeeVar = new zzee(strongBinder5);
                    }
                }
                zza(string4, string5, zzeeVar);
                break;
            case 6:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface6 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface6;
                    } else {
                        zzeeVar = new zzee(strongBinder6);
                    }
                }
                zzb(string6, string7, zzeeVar);
                break;
            case 7:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface7 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface7;
                    } else {
                        zzeeVar = new zzee(strongBinder7);
                    }
                }
                zzc(string8, string9, zzeeVar);
                break;
            case 8:
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface8 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface8;
                    } else {
                        zzeeVar = new zzee(strongBinder8);
                    }
                }
                zzd(string10, string11, zzeeVar);
                break;
            case 9:
                String string12 = parcel.readString();
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface9 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface9;
                    } else {
                        zzeeVar = new zzee(strongBinder9);
                    }
                }
                zzc(string12, zzeeVar);
                break;
            case 10:
                String string13 = parcel.readString();
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface10 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface10;
                    } else {
                        zzeeVar = new zzee(strongBinder10);
                    }
                }
                zzd(string13, zzeeVar);
                break;
            case 11:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface11 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface11;
                    } else {
                        zzeeVar = new zzee(strongBinder11);
                    }
                }
                zza(string14, string15, string16, zzeeVar);
                break;
            case 12:
                String string17 = parcel.readString();
                zzfy zzfyVar2 = (zzfy) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, zzfy.CREATOR);
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface12 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface12;
                    } else {
                        zzeeVar = new zzee(strongBinder12);
                    }
                }
                zza(string17, zzfyVar2, zzeeVar);
                break;
            case 13:
                String string18 = parcel.readString();
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface13 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface13;
                    } else {
                        zzeeVar = new zzee(strongBinder13);
                    }
                }
                zze(string18, zzeeVar);
                break;
            case 14:
                String string19 = parcel.readString();
                String string20 = parcel.readString();
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface14 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface14;
                    } else {
                        zzeeVar = new zzee(strongBinder14);
                    }
                }
                zze(string19, string20, zzeeVar);
                break;
            case 15:
                String string21 = parcel.readString();
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface15 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface15;
                    } else {
                        zzeeVar = new zzee(strongBinder15);
                    }
                }
                zzf(string21, zzeeVar);
                break;
            case 16:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface16 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface16;
                    } else {
                        zzeeVar = new zzee(strongBinder16);
                    }
                }
                zza(zzeeVar);
                break;
            case 17:
                String string22 = parcel.readString();
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface17 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface17;
                    } else {
                        zzeeVar = new zzee(strongBinder17);
                    }
                }
                zzg(string22, zzeeVar);
                break;
            case 18:
                String string23 = parcel.readString();
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface18 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface18;
                    } else {
                        zzeeVar = new zzee(strongBinder18);
                    }
                }
                zzh(string23, zzeeVar);
                break;
            case 19:
                String string24 = parcel.readString();
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface19 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface19;
                    } else {
                        zzeeVar = new zzee(strongBinder19);
                    }
                }
                zzi(string24, zzeeVar);
                break;
            case 20:
                String string25 = parcel.readString();
                IBinder strongBinder20 = parcel.readStrongBinder();
                if (strongBinder20 != null) {
                    IInterface iInterfaceQueryLocalInterface20 = strongBinder20.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface20 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface20;
                    } else {
                        zzeeVar = new zzee(strongBinder20);
                    }
                }
                zzj(string25, zzeeVar);
                break;
            case 21:
                String string26 = parcel.readString();
                String string27 = parcel.readString();
                IBinder strongBinder21 = parcel.readStrongBinder();
                if (strongBinder21 != null) {
                    IInterface iInterfaceQueryLocalInterface21 = strongBinder21.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface21 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface21;
                    } else {
                        zzeeVar = new zzee(strongBinder21);
                    }
                }
                zzf(string26, string27, zzeeVar);
                break;
            case 22:
                zzfr zzfrVar = (zzfr) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, zzfr.CREATOR);
                IBinder strongBinder22 = parcel.readStrongBinder();
                if (strongBinder22 != null) {
                    IInterface iInterfaceQueryLocalInterface22 = strongBinder22.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface22 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface22;
                    } else {
                        zzeeVar = new zzee(strongBinder22);
                    }
                }
                zza(zzfrVar, zzeeVar);
                break;
            case 23:
                PhoneAuthCredential phoneAuthCredential = (PhoneAuthCredential) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, PhoneAuthCredential.CREATOR);
                IBinder strongBinder23 = parcel.readStrongBinder();
                if (strongBinder23 != null) {
                    IInterface iInterfaceQueryLocalInterface23 = strongBinder23.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface23 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface23;
                    } else {
                        zzeeVar = new zzee(strongBinder23);
                    }
                }
                zza(phoneAuthCredential, zzeeVar);
                break;
            case 24:
                String string28 = parcel.readString();
                PhoneAuthCredential phoneAuthCredential2 = (PhoneAuthCredential) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, PhoneAuthCredential.CREATOR);
                IBinder strongBinder24 = parcel.readStrongBinder();
                if (strongBinder24 != null) {
                    IInterface iInterfaceQueryLocalInterface24 = strongBinder24.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface24 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface24;
                    } else {
                        zzeeVar = new zzee(strongBinder24);
                    }
                }
                zza(string28, phoneAuthCredential2, zzeeVar);
                break;
            case 25:
                String string29 = parcel.readString();
                ActionCodeSettings actionCodeSettings = (ActionCodeSettings) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder strongBinder25 = parcel.readStrongBinder();
                if (strongBinder25 != null) {
                    IInterface iInterfaceQueryLocalInterface25 = strongBinder25.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface25 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface25;
                    } else {
                        zzeeVar = new zzee(strongBinder25);
                    }
                }
                zza(string29, actionCodeSettings, zzeeVar);
                break;
            case 26:
                String string30 = parcel.readString();
                ActionCodeSettings actionCodeSettings2 = (ActionCodeSettings) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder strongBinder26 = parcel.readStrongBinder();
                if (strongBinder26 != null) {
                    IInterface iInterfaceQueryLocalInterface26 = strongBinder26.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface26 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface26;
                    } else {
                        zzeeVar = new zzee(strongBinder26);
                    }
                }
                zzb(string30, actionCodeSettings2, zzeeVar);
                break;
            case 27:
                String string31 = parcel.readString();
                IBinder strongBinder27 = parcel.readStrongBinder();
                if (strongBinder27 != null) {
                    IInterface iInterfaceQueryLocalInterface27 = strongBinder27.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface27 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface27;
                    } else {
                        zzeeVar = new zzee(strongBinder27);
                    }
                }
                zzk(string31, zzeeVar);
                break;
            case 28:
                String string32 = parcel.readString();
                ActionCodeSettings actionCodeSettings3 = (ActionCodeSettings) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder strongBinder28 = parcel.readStrongBinder();
                if (strongBinder28 != null) {
                    IInterface iInterfaceQueryLocalInterface28 = strongBinder28.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface28 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface28;
                    } else {
                        zzeeVar = new zzee(strongBinder28);
                    }
                }
                zzc(string32, actionCodeSettings3, zzeeVar);
                break;
            case 29:
                EmailAuthCredential emailAuthCredential = (EmailAuthCredential) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, EmailAuthCredential.CREATOR);
                IBinder strongBinder29 = parcel.readStrongBinder();
                if (strongBinder29 != null) {
                    IInterface iInterfaceQueryLocalInterface29 = strongBinder29.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (iInterfaceQueryLocalInterface29 instanceof zzec) {
                        zzeeVar = (zzec) iInterfaceQueryLocalInterface29;
                    } else {
                        zzeeVar = new zzee(strongBinder29);
                    }
                }
                zza(emailAuthCredential, zzeeVar);
                break;
            default:
                switch (i) {
                    case 101:
                        com.google.android.gms.internal.firebase_auth.zzcn zzcnVar = (com.google.android.gms.internal.firebase_auth.zzcn) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcn.CREATOR);
                        IBinder strongBinder30 = parcel.readStrongBinder();
                        if (strongBinder30 != null) {
                            IInterface iInterfaceQueryLocalInterface30 = strongBinder30.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (iInterfaceQueryLocalInterface30 instanceof zzec) {
                                zzeeVar = (zzec) iInterfaceQueryLocalInterface30;
                            } else {
                                zzeeVar = new zzee(strongBinder30);
                            }
                        }
                        zza(zzcnVar, zzeeVar);
                        break;
                    case 102:
                        com.google.android.gms.internal.firebase_auth.zzdl zzdlVar = (com.google.android.gms.internal.firebase_auth.zzdl) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdl.CREATOR);
                        IBinder strongBinder31 = parcel.readStrongBinder();
                        if (strongBinder31 != null) {
                            IInterface iInterfaceQueryLocalInterface31 = strongBinder31.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (iInterfaceQueryLocalInterface31 instanceof zzec) {
                                zzeeVar = (zzec) iInterfaceQueryLocalInterface31;
                            } else {
                                zzeeVar = new zzee(strongBinder31);
                            }
                        }
                        zza(zzdlVar, zzeeVar);
                        break;
                    case 103:
                        com.google.android.gms.internal.firebase_auth.zzdj zzdjVar = (com.google.android.gms.internal.firebase_auth.zzdj) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdj.CREATOR);
                        IBinder strongBinder32 = parcel.readStrongBinder();
                        if (strongBinder32 != null) {
                            IInterface iInterfaceQueryLocalInterface32 = strongBinder32.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (iInterfaceQueryLocalInterface32 instanceof zzec) {
                                zzeeVar = (zzec) iInterfaceQueryLocalInterface32;
                            } else {
                                zzeeVar = new zzee(strongBinder32);
                            }
                        }
                        zza(zzdjVar, zzeeVar);
                        break;
                    case 104:
                        com.google.android.gms.internal.firebase_auth.zzed zzedVar = (com.google.android.gms.internal.firebase_auth.zzed) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzed.CREATOR);
                        IBinder strongBinder33 = parcel.readStrongBinder();
                        if (strongBinder33 != null) {
                            IInterface iInterfaceQueryLocalInterface33 = strongBinder33.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (iInterfaceQueryLocalInterface33 instanceof zzec) {
                                zzeeVar = (zzec) iInterfaceQueryLocalInterface33;
                            } else {
                                zzeeVar = new zzee(strongBinder33);
                            }
                        }
                        zza(zzedVar, zzeeVar);
                        break;
                    case 105:
                        com.google.android.gms.internal.firebase_auth.zzbx zzbxVar = (com.google.android.gms.internal.firebase_auth.zzbx) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzbx.CREATOR);
                        IBinder strongBinder34 = parcel.readStrongBinder();
                        if (strongBinder34 != null) {
                            IInterface iInterfaceQueryLocalInterface34 = strongBinder34.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (iInterfaceQueryLocalInterface34 instanceof zzec) {
                                zzeeVar = (zzec) iInterfaceQueryLocalInterface34;
                            } else {
                                zzeeVar = new zzee(strongBinder34);
                            }
                        }
                        zza(zzbxVar, zzeeVar);
                        break;
                    case 106:
                        com.google.android.gms.internal.firebase_auth.zzbz zzbzVar = (com.google.android.gms.internal.firebase_auth.zzbz) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzbz.CREATOR);
                        IBinder strongBinder35 = parcel.readStrongBinder();
                        if (strongBinder35 != null) {
                            IInterface iInterfaceQueryLocalInterface35 = strongBinder35.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (iInterfaceQueryLocalInterface35 instanceof zzec) {
                                zzeeVar = (zzec) iInterfaceQueryLocalInterface35;
                            } else {
                                zzeeVar = new zzee(strongBinder35);
                            }
                        }
                        zza(zzbzVar, zzeeVar);
                        break;
                    case 107:
                        com.google.android.gms.internal.firebase_auth.zzcf zzcfVar = (com.google.android.gms.internal.firebase_auth.zzcf) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcf.CREATOR);
                        IBinder strongBinder36 = parcel.readStrongBinder();
                        if (strongBinder36 != null) {
                            IInterface iInterfaceQueryLocalInterface36 = strongBinder36.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (iInterfaceQueryLocalInterface36 instanceof zzec) {
                                zzeeVar = (zzec) iInterfaceQueryLocalInterface36;
                            } else {
                                zzeeVar = new zzee(strongBinder36);
                            }
                        }
                        zza(zzcfVar, zzeeVar);
                        break;
                    case 108:
                        com.google.android.gms.internal.firebase_auth.zzdn zzdnVar = (com.google.android.gms.internal.firebase_auth.zzdn) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdn.CREATOR);
                        IBinder strongBinder37 = parcel.readStrongBinder();
                        if (strongBinder37 != null) {
                            IInterface iInterfaceQueryLocalInterface37 = strongBinder37.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (iInterfaceQueryLocalInterface37 instanceof zzec) {
                                zzeeVar = (zzec) iInterfaceQueryLocalInterface37;
                            } else {
                                zzeeVar = new zzee(strongBinder37);
                            }
                        }
                        zza(zzdnVar, zzeeVar);
                        break;
                    case 109:
                        com.google.android.gms.internal.firebase_auth.zzcp zzcpVar = (com.google.android.gms.internal.firebase_auth.zzcp) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcp.CREATOR);
                        IBinder strongBinder38 = parcel.readStrongBinder();
                        if (strongBinder38 != null) {
                            IInterface iInterfaceQueryLocalInterface38 = strongBinder38.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (iInterfaceQueryLocalInterface38 instanceof zzec) {
                                zzeeVar = (zzec) iInterfaceQueryLocalInterface38;
                            } else {
                                zzeeVar = new zzee(strongBinder38);
                            }
                        }
                        zza(zzcpVar, zzeeVar);
                        break;
                    default:
                        switch (i) {
                            case 111:
                                com.google.android.gms.internal.firebase_auth.zzcr zzcrVar = (com.google.android.gms.internal.firebase_auth.zzcr) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcr.CREATOR);
                                IBinder strongBinder39 = parcel.readStrongBinder();
                                if (strongBinder39 != null) {
                                    IInterface iInterfaceQueryLocalInterface39 = strongBinder39.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (iInterfaceQueryLocalInterface39 instanceof zzec) {
                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface39;
                                    } else {
                                        zzeeVar = new zzee(strongBinder39);
                                    }
                                }
                                zza(zzcrVar, zzeeVar);
                                break;
                            case 112:
                                com.google.android.gms.internal.firebase_auth.zzct zzctVar = (com.google.android.gms.internal.firebase_auth.zzct) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzct.CREATOR);
                                IBinder strongBinder40 = parcel.readStrongBinder();
                                if (strongBinder40 != null) {
                                    IInterface iInterfaceQueryLocalInterface40 = strongBinder40.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (iInterfaceQueryLocalInterface40 instanceof zzec) {
                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface40;
                                    } else {
                                        zzeeVar = new zzee(strongBinder40);
                                    }
                                }
                                zza(zzctVar, zzeeVar);
                                break;
                            case 113:
                                com.google.android.gms.internal.firebase_auth.zzdz zzdzVar = (com.google.android.gms.internal.firebase_auth.zzdz) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdz.CREATOR);
                                IBinder strongBinder41 = parcel.readStrongBinder();
                                if (strongBinder41 != null) {
                                    IInterface iInterfaceQueryLocalInterface41 = strongBinder41.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (iInterfaceQueryLocalInterface41 instanceof zzec) {
                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface41;
                                    } else {
                                        zzeeVar = new zzee(strongBinder41);
                                    }
                                }
                                zza(zzdzVar, zzeeVar);
                                break;
                            case 114:
                                com.google.android.gms.internal.firebase_auth.zzeb zzebVar = (com.google.android.gms.internal.firebase_auth.zzeb) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzeb.CREATOR);
                                IBinder strongBinder42 = parcel.readStrongBinder();
                                if (strongBinder42 != null) {
                                    IInterface iInterfaceQueryLocalInterface42 = strongBinder42.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (iInterfaceQueryLocalInterface42 instanceof zzec) {
                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface42;
                                    } else {
                                        zzeeVar = new zzee(strongBinder42);
                                    }
                                }
                                zza(zzebVar, zzeeVar);
                                break;
                            case 115:
                                com.google.android.gms.internal.firebase_auth.zzcx zzcxVar = (com.google.android.gms.internal.firebase_auth.zzcx) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcx.CREATOR);
                                IBinder strongBinder43 = parcel.readStrongBinder();
                                if (strongBinder43 != null) {
                                    IInterface iInterfaceQueryLocalInterface43 = strongBinder43.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (iInterfaceQueryLocalInterface43 instanceof zzec) {
                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface43;
                                    } else {
                                        zzeeVar = new zzee(strongBinder43);
                                    }
                                }
                                zza(zzcxVar, zzeeVar);
                                break;
                            case 116:
                                com.google.android.gms.internal.firebase_auth.zzdh zzdhVar = (com.google.android.gms.internal.firebase_auth.zzdh) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdh.CREATOR);
                                IBinder strongBinder44 = parcel.readStrongBinder();
                                if (strongBinder44 != null) {
                                    IInterface iInterfaceQueryLocalInterface44 = strongBinder44.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (iInterfaceQueryLocalInterface44 instanceof zzec) {
                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface44;
                                    } else {
                                        zzeeVar = new zzee(strongBinder44);
                                    }
                                }
                                zza(zzdhVar, zzeeVar);
                                break;
                            case 117:
                                com.google.android.gms.internal.firebase_auth.zzch zzchVar = (com.google.android.gms.internal.firebase_auth.zzch) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzch.CREATOR);
                                IBinder strongBinder45 = parcel.readStrongBinder();
                                if (strongBinder45 != null) {
                                    IInterface iInterfaceQueryLocalInterface45 = strongBinder45.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (iInterfaceQueryLocalInterface45 instanceof zzec) {
                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface45;
                                    } else {
                                        zzeeVar = new zzee(strongBinder45);
                                    }
                                }
                                zza(zzchVar, zzeeVar);
                                break;
                            default:
                                switch (i) {
                                    case 119:
                                        com.google.android.gms.internal.firebase_auth.zzcb zzcbVar = (com.google.android.gms.internal.firebase_auth.zzcb) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcb.CREATOR);
                                        IBinder strongBinder46 = parcel.readStrongBinder();
                                        if (strongBinder46 != null) {
                                            IInterface iInterfaceQueryLocalInterface46 = strongBinder46.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (iInterfaceQueryLocalInterface46 instanceof zzec) {
                                                zzeeVar = (zzec) iInterfaceQueryLocalInterface46;
                                            } else {
                                                zzeeVar = new zzee(strongBinder46);
                                            }
                                        }
                                        zza(zzcbVar, zzeeVar);
                                        break;
                                    case 120:
                                        com.google.android.gms.internal.firebase_auth.zzbw zzbwVar = (com.google.android.gms.internal.firebase_auth.zzbw) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzbw.CREATOR);
                                        IBinder strongBinder47 = parcel.readStrongBinder();
                                        if (strongBinder47 != null) {
                                            IInterface iInterfaceQueryLocalInterface47 = strongBinder47.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (iInterfaceQueryLocalInterface47 instanceof zzec) {
                                                zzeeVar = (zzec) iInterfaceQueryLocalInterface47;
                                            } else {
                                                zzeeVar = new zzee(strongBinder47);
                                            }
                                        }
                                        zza(zzbwVar, zzeeVar);
                                        break;
                                    case 121:
                                        com.google.android.gms.internal.firebase_auth.zzcd zzcdVar = (com.google.android.gms.internal.firebase_auth.zzcd) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcd.CREATOR);
                                        IBinder strongBinder48 = parcel.readStrongBinder();
                                        if (strongBinder48 != null) {
                                            IInterface iInterfaceQueryLocalInterface48 = strongBinder48.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (iInterfaceQueryLocalInterface48 instanceof zzec) {
                                                zzeeVar = (zzec) iInterfaceQueryLocalInterface48;
                                            } else {
                                                zzeeVar = new zzee(strongBinder48);
                                            }
                                        }
                                        zza(zzcdVar, zzeeVar);
                                        break;
                                    case 122:
                                        com.google.android.gms.internal.firebase_auth.zzdd zzddVar = (com.google.android.gms.internal.firebase_auth.zzdd) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdd.CREATOR);
                                        IBinder strongBinder49 = parcel.readStrongBinder();
                                        if (strongBinder49 != null) {
                                            IInterface iInterfaceQueryLocalInterface49 = strongBinder49.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (iInterfaceQueryLocalInterface49 instanceof zzec) {
                                                zzeeVar = (zzec) iInterfaceQueryLocalInterface49;
                                            } else {
                                                zzeeVar = new zzee(strongBinder49);
                                            }
                                        }
                                        zza(zzddVar, zzeeVar);
                                        break;
                                    case 123:
                                        com.google.android.gms.internal.firebase_auth.zzdr zzdrVar = (com.google.android.gms.internal.firebase_auth.zzdr) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdr.CREATOR);
                                        IBinder strongBinder50 = parcel.readStrongBinder();
                                        if (strongBinder50 != null) {
                                            IInterface iInterfaceQueryLocalInterface50 = strongBinder50.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (iInterfaceQueryLocalInterface50 instanceof zzec) {
                                                zzeeVar = (zzec) iInterfaceQueryLocalInterface50;
                                            } else {
                                                zzeeVar = new zzee(strongBinder50);
                                            }
                                        }
                                        zza(zzdrVar, zzeeVar);
                                        break;
                                    case 124:
                                        com.google.android.gms.internal.firebase_auth.zzcv zzcvVar = (com.google.android.gms.internal.firebase_auth.zzcv) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcv.CREATOR);
                                        IBinder strongBinder51 = parcel.readStrongBinder();
                                        if (strongBinder51 != null) {
                                            IInterface iInterfaceQueryLocalInterface51 = strongBinder51.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (iInterfaceQueryLocalInterface51 instanceof zzec) {
                                                zzeeVar = (zzec) iInterfaceQueryLocalInterface51;
                                            } else {
                                                zzeeVar = new zzee(strongBinder51);
                                            }
                                        }
                                        zza(zzcvVar, zzeeVar);
                                        break;
                                    default:
                                        switch (i) {
                                            case 126:
                                                com.google.android.gms.internal.firebase_auth.zzcz zzczVar = (com.google.android.gms.internal.firebase_auth.zzcz) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcz.CREATOR);
                                                IBinder strongBinder52 = parcel.readStrongBinder();
                                                if (strongBinder52 != null) {
                                                    IInterface iInterfaceQueryLocalInterface52 = strongBinder52.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface52 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface52;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder52);
                                                    }
                                                }
                                                zza(zzczVar, zzeeVar);
                                                break;
                                            case 127:
                                                com.google.android.gms.internal.firebase_auth.zzdf zzdfVar = (com.google.android.gms.internal.firebase_auth.zzdf) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdf.CREATOR);
                                                IBinder strongBinder53 = parcel.readStrongBinder();
                                                if (strongBinder53 != null) {
                                                    IInterface iInterfaceQueryLocalInterface53 = strongBinder53.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface53 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface53;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder53);
                                                    }
                                                }
                                                zza(zzdfVar, zzeeVar);
                                                break;
                                            case 128:
                                                com.google.android.gms.internal.firebase_auth.zzdb zzdbVar = (com.google.android.gms.internal.firebase_auth.zzdb) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdb.CREATOR);
                                                IBinder strongBinder54 = parcel.readStrongBinder();
                                                if (strongBinder54 != null) {
                                                    IInterface iInterfaceQueryLocalInterface54 = strongBinder54.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface54 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface54;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder54);
                                                    }
                                                }
                                                zza(zzdbVar, zzeeVar);
                                                break;
                                            case 129:
                                                com.google.android.gms.internal.firebase_auth.zzdp zzdpVar = (com.google.android.gms.internal.firebase_auth.zzdp) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdp.CREATOR);
                                                IBinder strongBinder55 = parcel.readStrongBinder();
                                                if (strongBinder55 != null) {
                                                    IInterface iInterfaceQueryLocalInterface55 = strongBinder55.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface55 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface55;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder55);
                                                    }
                                                }
                                                zza(zzdpVar, zzeeVar);
                                                break;
                                            case 130:
                                                com.google.android.gms.internal.firebase_auth.zzdt zzdtVar = (com.google.android.gms.internal.firebase_auth.zzdt) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdt.CREATOR);
                                                IBinder strongBinder56 = parcel.readStrongBinder();
                                                if (strongBinder56 != null) {
                                                    IInterface iInterfaceQueryLocalInterface56 = strongBinder56.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface56 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface56;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder56);
                                                    }
                                                }
                                                zza(zzdtVar, zzeeVar);
                                                break;
                                            case 131:
                                                com.google.android.gms.internal.firebase_auth.zzdx zzdxVar = (com.google.android.gms.internal.firebase_auth.zzdx) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdx.CREATOR);
                                                IBinder strongBinder57 = parcel.readStrongBinder();
                                                if (strongBinder57 != null) {
                                                    IInterface iInterfaceQueryLocalInterface57 = strongBinder57.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface57 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface57;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder57);
                                                    }
                                                }
                                                zza(zzdxVar, zzeeVar);
                                                break;
                                            case 132:
                                                com.google.android.gms.internal.firebase_auth.zzcj zzcjVar = (com.google.android.gms.internal.firebase_auth.zzcj) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcj.CREATOR);
                                                IBinder strongBinder58 = parcel.readStrongBinder();
                                                if (strongBinder58 != null) {
                                                    IInterface iInterfaceQueryLocalInterface58 = strongBinder58.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface58 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface58;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder58);
                                                    }
                                                }
                                                zza(zzcjVar, zzeeVar);
                                                break;
                                            case 133:
                                                com.google.android.gms.internal.firebase_auth.zzdv zzdvVar = (com.google.android.gms.internal.firebase_auth.zzdv) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdv.CREATOR);
                                                IBinder strongBinder59 = parcel.readStrongBinder();
                                                if (strongBinder59 != null) {
                                                    IInterface iInterfaceQueryLocalInterface59 = strongBinder59.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface59 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface59;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder59);
                                                    }
                                                }
                                                zza(zzdvVar, zzeeVar);
                                                break;
                                            case 134:
                                                com.google.android.gms.internal.firebase_auth.zzcl zzclVar = (com.google.android.gms.internal.firebase_auth.zzcl) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzcl.CREATOR);
                                                IBinder strongBinder60 = parcel.readStrongBinder();
                                                if (strongBinder60 != null) {
                                                    IInterface iInterfaceQueryLocalInterface60 = strongBinder60.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface60 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface60;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder60);
                                                    }
                                                }
                                                zza(zzclVar, zzeeVar);
                                                break;
                                            case 135:
                                                com.google.android.gms.internal.firebase_auth.zzef zzefVar = (com.google.android.gms.internal.firebase_auth.zzef) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzef.CREATOR);
                                                IBinder strongBinder61 = parcel.readStrongBinder();
                                                if (strongBinder61 != null) {
                                                    IInterface iInterfaceQueryLocalInterface61 = strongBinder61.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (iInterfaceQueryLocalInterface61 instanceof zzec) {
                                                        zzeeVar = (zzec) iInterfaceQueryLocalInterface61;
                                                    } else {
                                                        zzeeVar = new zzee(strongBinder61);
                                                    }
                                                }
                                                zza(zzefVar, zzeeVar);
                                                break;
                                            default:
                                                return false;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
