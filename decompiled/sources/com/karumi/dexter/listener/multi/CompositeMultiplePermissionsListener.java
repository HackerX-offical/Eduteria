package com.karumi.dexter.listener.multi;

import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class CompositeMultiplePermissionsListener implements MultiplePermissionsListener {

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final Collection<MultiplePermissionsListener> f654listeners;

    public CompositeMultiplePermissionsListener(Collection<MultiplePermissionsListener> collection) {
        this.f654listeners = collection;
    }

    public CompositeMultiplePermissionsListener(MultiplePermissionsListener... multiplePermissionsListenerArr) {
        this(Arrays.asList(multiplePermissionsListenerArr));
    }

    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
        Iterator<MultiplePermissionsListener> it = this.f654listeners.iterator();
        while (it.hasNext()) {
            it.next().onPermissionRationaleShouldBeShown(list, permissionToken);
        }
    }

    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
        Iterator<MultiplePermissionsListener> it = this.f654listeners.iterator();
        while (it.hasNext()) {
            it.next().onPermissionsChecked(multiplePermissionsReport);
        }
    }
}
