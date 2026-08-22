package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zad extends zac {
    protected final TaskCompletionSource zaa;

    public zad(int i, TaskCompletionSource taskCompletionSource) {
        super(i);
        this.zaa = taskCompletionSource;
    }

    protected abstract void zac(zabq zabqVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(Status status) {
        this.zaa.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(Exception exc) {
        this.zaa.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        try {
            zac(zabqVar);
        } catch (DeadObjectException e2) {
            zad(zai.zah(e2));
            throw e2;
        } catch (RemoteException e3) {
            zad(zai.zah(e3));
        } catch (RuntimeException e4) {
            this.zaa.trySetException(e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public void zag(zaad zaadVar, boolean z) {
    }
}
