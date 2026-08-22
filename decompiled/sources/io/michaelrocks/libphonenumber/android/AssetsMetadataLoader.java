package io.michaelrocks.libphonenumber.android;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes9.dex */
public class AssetsMetadataLoader implements MetadataLoader {
    private final AssetManager assetManager;

    public AssetsMetadataLoader(final AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataLoader
    public InputStream loadMetadata(final String metadataFileName) {
        try {
            return this.assetManager.open(metadataFileName.substring(1));
        } catch (IOException unused) {
            return null;
        }
    }
}
