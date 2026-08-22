package org.jivesoftware.smack.roster.rosterstore;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class DirectoryRosterStore$$ExternalSyntheticLambda0 implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return DirectoryRosterStore.rosterDirFilter(file);
    }
}
