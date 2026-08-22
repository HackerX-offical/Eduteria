package com.karumi.dexter.listener.single;

import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;

/* JADX INFO: loaded from: classes9.dex */
public class BasePermissionListener implements PermissionListener {
    @Override // com.karumi.dexter.listener.single.PermissionListener
    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
    }

    @Override // com.karumi.dexter.listener.single.PermissionListener
    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
    }

    @Override // com.karumi.dexter.listener.single.PermissionListener
    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
        permissionToken.continuePermissionRequest();
    }
}
