package com.amazonaws.services.s3.model;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface EncryptionMaterialsProvider extends EncryptionMaterialsAccessor {
    EncryptionMaterials getEncryptionMaterials();

    void refresh();
}
