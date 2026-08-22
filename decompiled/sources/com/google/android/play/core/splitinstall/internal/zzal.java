package com.google.android.play.core.splitinstall.internal;

import android.content.res.AssetManager;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzal {
    private final com.google.android.play.core.splitcompat.zza zza;
    private XmlPullParser zzb;

    public zzal(com.google.android.play.core.splitcompat.zza zzaVar) {
        this.zza = zzaVar;
    }

    public final long zza() throws XmlPullParserException, IOException {
        if (this.zzb == null) {
            throw new XmlPullParserException("Manifest file needs to be loaded before parsing.");
        }
        while (true) {
            int next = this.zzb.next();
            if (next != 2) {
                if (next == 1) {
                    break;
                }
            } else if (this.zzb.getName().equals("manifest")) {
                String attributeValue = this.zzb.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCode");
                String attributeValue2 = this.zzb.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCodeMajor");
                if (attributeValue == null) {
                    throw new XmlPullParserException("Manifest entry doesn't contain 'versionCode' attribute.");
                }
                try {
                    int i = Integer.parseInt(attributeValue);
                    if (attributeValue2 == null) {
                        return i;
                    }
                    try {
                        return (((long) Integer.parseInt(attributeValue2)) << 32) | (((long) i) & 4294967295L);
                    } catch (NumberFormatException e2) {
                        throw new XmlPullParserException(String.format("Couldn't parse versionCodeMajor to int: %s", e2.getMessage()));
                    }
                } catch (NumberFormatException e3) {
                    throw new XmlPullParserException(String.format("Couldn't parse versionCode to int: %s", e3.getMessage()));
                }
            }
        }
        throw new XmlPullParserException("Couldn't find manifest entry at top-level.");
    }

    public final void zzb(AssetManager assetManager, File file) throws IOException {
        this.zzb = assetManager.openXmlResourceParser(com.google.android.play.core.splitcompat.zza.zzc(assetManager, file), "AndroidManifest.xml");
    }
}
