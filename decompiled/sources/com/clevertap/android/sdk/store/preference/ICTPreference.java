package com.clevertap.android.sdk.store.preference;

import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: ICTPreference.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\rH&J&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH&J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\tH&J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000bH&J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\rH&J\u001e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH&J\"\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0011H&J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\tH&J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000bH&J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\rH&J\u001e\u0010 \u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH&J\"\u0010!\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0011H&J\b\u0010\"\u001a\u00020\u0007H&J\b\u0010#\u001a\u00020\tH&J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0003H&¨\u0006("}, d2 = {"Lcom/clevertap/android/sdk/store/preference/ICTPreference;", "", "readString", "", "key", CookieSpecs.DEFAULT, "readBoolean", "", "readInt", "", "readLong", "", "readFloat", "", "readStringSet", "", "readAll", "", "writeString", "", "value", "writeBoolean", "writeInt", "writeLong", "writeFloat", "writeStringSet", "writeMap", "writeStringImmediate", "writeBooleanImmediate", "writeIntImmediate", "writeLongImmediate", "writeFloatImmediate", "writeStringSetImmediate", "writeMapImmediate", "isEmpty", "size", "remove", "removeImmediate", "changePreferenceName", "prefName", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ICTPreference {
    void changePreferenceName(String prefName);

    boolean isEmpty();

    Map<String, ?> readAll();

    boolean readBoolean(String key, boolean z);

    float readFloat(String key, float f2);

    int readInt(String key, int i);

    long readLong(String key, long j);

    String readString(String key, String str);

    Set<String> readStringSet(String key, Set<String> set);

    void remove(String key);

    void removeImmediate(String key);

    int size();

    void writeBoolean(String key, boolean value);

    void writeBooleanImmediate(String key, boolean value);

    void writeFloat(String key, float value);

    void writeFloatImmediate(String key, float value);

    void writeInt(String key, int value);

    void writeIntImmediate(String key, int value);

    void writeLong(String key, long value);

    void writeLongImmediate(String key, long value);

    void writeMap(String key, Map<String, ?> value);

    void writeMapImmediate(String key, Map<String, ?> value);

    void writeString(String key, String value);

    void writeStringImmediate(String key, String value);

    void writeStringSet(String key, Set<String> value);

    void writeStringSetImmediate(String key, Set<String> value);
}
