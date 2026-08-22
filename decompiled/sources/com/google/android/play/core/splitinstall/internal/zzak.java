package com.google.android.play.core.splitinstall.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzak implements com.google.android.play.core.splitinstall.zzh {
    private final Context zza;
    private final com.google.android.play.core.splitcompat.zze zzb;
    private final zzam zzc;
    private final Executor zzd;
    private final com.google.android.play.core.splitcompat.zzs zze;

    public zzak(Context context, Executor executor, zzam zzamVar, com.google.android.play.core.splitcompat.zze zzeVar, com.google.android.play.core.splitcompat.zzs zzsVar) {
        this.zza = context;
        this.zzb = zzeVar;
        this.zzc = zzamVar;
        this.zzd = executor;
        this.zze = zzsVar;
    }

    static /* bridge */ /* synthetic */ void zzb(zzak zzakVar, List list, com.google.android.play.core.splitinstall.zzf zzfVar) {
        Integer numZze = zzakVar.zze(list);
        if (numZze == null) {
            return;
        }
        if (numZze.intValue() == 0) {
            zzfVar.zzc();
        } else {
            zzfVar.zzb(numZze.intValue());
        }
    }

    static /* bridge */ /* synthetic */ void zzc(zzak zzakVar, com.google.android.play.core.splitinstall.zzf zzfVar) {
        try {
            if (SplitCompat.zzd(zzbr.zza(zzakVar.zza))) {
                Log.i("SplitCompat", "Splits installed.");
                zzfVar.zza();
            } else {
                Log.e("SplitCompat", "Emulating splits failed.");
                zzfVar.zzb(-12);
            }
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error emulating splits.", e2);
            zzfVar.zzb(-12);
        }
    }

    private final Integer zze(List list) {
        FileChannel channel;
        Integer numValueOf;
        FileLock fileLockTryLock;
        int i;
        File[] fileArrListFiles;
        try {
            channel = new RandomAccessFile(this.zzb.zzd(), "rw").getChannel();
            numValueOf = null;
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error locking files.", e2);
            return -13;
        }
        try {
            try {
                fileLockTryLock = channel.tryLock();
            } catch (OverlappingFileLockException unused) {
                fileLockTryLock = null;
            }
            if (fileLockTryLock != null) {
                try {
                    Log.i("SplitCompat", "Copying splits.");
                    Iterator it = list.iterator();
                    while (true) {
                        i = 0;
                        if (!it.hasNext()) {
                            break;
                        }
                        Intent intent = (Intent) it.next();
                        String stringExtra = intent.getStringExtra("split_id");
                        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.zza.getContentResolver().openAssetFileDescriptor(intent.getData(), StreamManagement.AckRequest.ELEMENT);
                        try {
                            File fileZze = this.zzb.zze(stringExtra);
                            if ((fileZze.exists() && fileZze.length() != assetFileDescriptorOpenAssetFileDescriptor.getLength()) || !fileZze.exists()) {
                                if (!this.zzb.zzg(stringExtra).exists()) {
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(assetFileDescriptorOpenAssetFileDescriptor.createInputStream());
                                    try {
                                        FileOutputStream fileOutputStream = new FileOutputStream(fileZze);
                                        try {
                                            byte[] bArr = new byte[4096];
                                            while (true) {
                                                int i2 = bufferedInputStream.read(bArr);
                                                if (i2 <= 0) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, i2);
                                            }
                                            fileOutputStream.close();
                                            bufferedInputStream.close();
                                        } finally {
                                        }
                                    } finally {
                                    }
                                }
                            }
                            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                                assetFileDescriptorOpenAssetFileDescriptor.close();
                            }
                        } catch (Throwable th) {
                            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                                try {
                                    assetFileDescriptorOpenAssetFileDescriptor.close();
                                } catch (Throwable th2) {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                }
                            }
                            throw th;
                        }
                        Log.e("SplitCompat", "Error locking files.", e2);
                        return -13;
                    }
                    Log.i("SplitCompat", "Splits copied.");
                    try {
                        fileArrListFiles = this.zzb.zzb().listFiles();
                        try {
                        } catch (Exception e3) {
                            Log.e("SplitCompat", "Error verifying splits.", e3);
                        }
                    } catch (IOException e4) {
                        Log.e("SplitCompat", "Cannot access directory for unverified splits.", e4);
                    }
                } catch (Exception e5) {
                    Log.e("SplitCompat", "Error copying splits.", e5);
                }
                if (this.zzc.zzc(fileArrListFiles)) {
                    if (this.zzc.zza(fileArrListFiles)) {
                        try {
                            File[] fileArrListFiles2 = this.zzb.zzb().listFiles();
                            Arrays.sort(fileArrListFiles2);
                            int length = fileArrListFiles2.length;
                            while (true) {
                                length--;
                                if (length < 0) {
                                    break;
                                }
                                com.google.android.play.core.splitcompat.zze.zzm(fileArrListFiles2[length]);
                                File file = fileArrListFiles2[length];
                                file.renameTo(this.zzb.zzf(file));
                            }
                            Log.i("SplitCompat", "Splits verified.");
                        } catch (IOException e6) {
                            Log.e("SplitCompat", "Cannot write verified split.", e6);
                            i = -13;
                        }
                        numValueOf = Integer.valueOf(i);
                        fileLockTryLock.release();
                    }
                }
                Log.e("SplitCompat", "Split verification failed.");
                i = -11;
                numValueOf = Integer.valueOf(i);
                fileLockTryLock.release();
            }
            if (channel != null) {
                channel.close();
            }
            return numValueOf;
        } finally {
        }
    }

    @Override // com.google.android.play.core.splitinstall.zzh
    public final void zzd(List list, com.google.android.play.core.splitinstall.zzf zzfVar) {
        if (!SplitCompat.zze()) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        this.zzd.execute(new zzaj(this, list, zzfVar));
    }
}
