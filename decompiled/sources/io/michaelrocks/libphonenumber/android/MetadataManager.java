package io.michaelrocks.libphonenumber.android;

import io.michaelrocks.libphonenumber.android.Phonemetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes9.dex */
final class MetadataManager {
    static final String ALTERNATE_FORMATS_FILE_PREFIX = "/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto";
    static final String MULTI_FILE_PHONE_NUMBER_METADATA_FILE_PREFIX = "/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProto";
    static final String SHORT_NUMBER_METADATA_FILE_PREFIX = "/io/michaelrocks/libphonenumber/android/data/ShortNumberMetadataProto";
    private static final Logger logger = Logger.getLogger(MetadataManager.class.getName());
    private final MetadataLoader metadataLoader;
    private final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> alternateFormatsMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> shortNumberMetadataMap = new ConcurrentHashMap<>();
    private final Set<Integer> alternateFormatsCountryCodes = AlternateFormatsCountryCodeSet.getCountryCodeSet();
    private final Set<String> shortNumberMetadataRegionCodes = ShortNumbersRegionCodeSet.getRegionCodeSet();

    MetadataManager(MetadataLoader metadataLoader) {
        this.metadataLoader = metadataLoader;
    }

    Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int countryCallingCode, String filePrefix) {
        if (this.alternateFormatsCountryCodes.contains(Integer.valueOf(countryCallingCode))) {
            return getMetadataFromMultiFilePrefix(Integer.valueOf(countryCallingCode), this.alternateFormatsMap, filePrefix);
        }
        return null;
    }

    Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String regionCode, String filePrefix) {
        if (this.shortNumberMetadataRegionCodes.contains(regionCode)) {
            return getMetadataFromMultiFilePrefix(regionCode, this.shortNumberMetadataMap, filePrefix);
        }
        return null;
    }

    Set<String> getSupportedShortNumberRegions() {
        return Collections.unmodifiableSet(this.shortNumberMetadataRegionCodes);
    }

    <T> Phonemetadata.PhoneMetadata getMetadataFromMultiFilePrefix(T key, ConcurrentHashMap<T, Phonemetadata.PhoneMetadata> map, String filePrefix) {
        Phonemetadata.PhoneMetadata phoneMetadata = map.get(key);
        if (phoneMetadata != null) {
            return phoneMetadata;
        }
        String str = filePrefix + "_" + key;
        List<Phonemetadata.PhoneMetadata> metadataFromSingleFileName = getMetadataFromSingleFileName(str, this.metadataLoader);
        if (metadataFromSingleFileName.size() > 1) {
            logger.log(Level.WARNING, "more than one metadata in file " + str);
        }
        Phonemetadata.PhoneMetadata phoneMetadata2 = metadataFromSingleFileName.get(0);
        Phonemetadata.PhoneMetadata phoneMetadataPutIfAbsent = map.putIfAbsent(key, phoneMetadata2);
        return phoneMetadataPutIfAbsent != null ? phoneMetadataPutIfAbsent : phoneMetadata2;
    }

    private static List<Phonemetadata.PhoneMetadata> getMetadataFromSingleFileName(String fileName, MetadataLoader metadataLoader) {
        InputStream inputStreamLoadMetadata = metadataLoader.loadMetadata(fileName);
        if (inputStreamLoadMetadata == null) {
            throw new IllegalStateException("missing metadata: " + fileName);
        }
        List<Phonemetadata.PhoneMetadata> metadataList = loadMetadataAndCloseInput(inputStreamLoadMetadata).getMetadataList();
        if (metadataList.size() != 0) {
            return metadataList;
        }
        throw new IllegalStateException("empty metadata: " + fileName);
    }

    private static Phonemetadata.PhoneMetadataCollection loadMetadataAndCloseInput(InputStream source) throws Throwable {
        ObjectInputStream objectInputStream = null;
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(source);
                try {
                    Phonemetadata.PhoneMetadataCollection phoneMetadataCollection = new Phonemetadata.PhoneMetadataCollection();
                    try {
                        phoneMetadataCollection.readExternal(objectInputStream2);
                        try {
                            objectInputStream2.close();
                            return phoneMetadataCollection;
                        } catch (IOException e2) {
                            logger.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e2);
                            return phoneMetadataCollection;
                        }
                    } catch (IOException e3) {
                        throw new RuntimeException("cannot load/parse metadata", e3);
                    }
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = objectInputStream2;
                    try {
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        } else {
                            source.close();
                        }
                    } catch (IOException e4) {
                        logger.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e4);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            throw new RuntimeException("cannot load/parse metadata", e5);
        }
    }
}
