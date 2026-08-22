package io.michaelrocks.libphonenumber.android;

import java.io.InputStream;

/* JADX INFO: loaded from: classes9.dex */
class ResourceMetadataLoader implements MetadataLoader {
    private final Class<?> loaderClass;

    public ResourceMetadataLoader() {
        this(ResourceMetadataLoader.class);
    }

    public ResourceMetadataLoader(Class<?> loaderClass) {
        this.loaderClass = loaderClass;
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataLoader
    public InputStream loadMetadata(String metadataFileName) {
        return this.loaderClass.getResourceAsStream(metadataFileName);
    }
}
