package org.pgpainless.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class AlgorithmSuite {
    private static AlgorithmSuite defaultAlgorithmSuite = new AlgorithmSuite(Arrays.asList(SymmetricKeyAlgorithm.AES_256, SymmetricKeyAlgorithm.AES_192, SymmetricKeyAlgorithm.AES_128), Arrays.asList(HashAlgorithm.SHA512, HashAlgorithm.SHA384, HashAlgorithm.SHA256, HashAlgorithm.SHA224), Arrays.asList(CompressionAlgorithm.ZLIB, CompressionAlgorithm.BZIP2, CompressionAlgorithm.ZIP, CompressionAlgorithm.UNCOMPRESSED));
    private List<CompressionAlgorithm> compressionAlgorithms;
    private List<HashAlgorithm> hashAlgorithms;
    private List<SymmetricKeyAlgorithm> symmetricKeyAlgorithms;

    public AlgorithmSuite(List<SymmetricKeyAlgorithm> list, List<HashAlgorithm> list2, List<CompressionAlgorithm> list3) {
        this.symmetricKeyAlgorithms = Collections.unmodifiableList(list);
        this.hashAlgorithms = Collections.unmodifiableList(list2);
        this.compressionAlgorithms = Collections.unmodifiableList(list3);
    }

    public void setSymmetricKeyAlgorithms(List<SymmetricKeyAlgorithm> list) {
        this.symmetricKeyAlgorithms = list;
    }

    public List<SymmetricKeyAlgorithm> getSymmetricKeyAlgorithms() {
        return new ArrayList(this.symmetricKeyAlgorithms);
    }

    public int[] getSymmetricKeyAlgorithmIds() {
        int size = this.symmetricKeyAlgorithms.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.symmetricKeyAlgorithms.get(i).getAlgorithmId();
        }
        return iArr;
    }

    public void setHashAlgorithms(List<HashAlgorithm> list) {
        this.hashAlgorithms = list;
    }

    public List<HashAlgorithm> getHashAlgorithms() {
        return this.hashAlgorithms;
    }

    public int[] getHashAlgorithmIds() {
        int size = this.hashAlgorithms.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.hashAlgorithms.get(i).getAlgorithmId();
        }
        return iArr;
    }

    public void setCompressionAlgorithms(List<CompressionAlgorithm> list) {
        this.compressionAlgorithms = list;
    }

    public List<CompressionAlgorithm> getCompressionAlgorithms() {
        return this.compressionAlgorithms;
    }

    public int[] getCompressionAlgorithmIds() {
        int size = this.compressionAlgorithms.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.compressionAlgorithms.get(i).getAlgorithmId();
        }
        return iArr;
    }

    public static AlgorithmSuite getDefaultAlgorithmSuite() {
        return defaultAlgorithmSuite;
    }
}
