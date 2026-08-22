package com.google.android.gms.appinvite;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
final class zzb implements View.OnClickListener {
    private final /* synthetic */ PreviewActivity zzi;

    zzb(PreviewActivity previewActivity) {
        this.zzi = previewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzi.finish();
    }
}
