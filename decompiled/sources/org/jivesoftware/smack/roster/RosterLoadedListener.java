package org.jivesoftware.smack.roster;

/* JADX INFO: loaded from: classes10.dex */
public interface RosterLoadedListener {
    void onRosterLoaded(Roster roster);

    void onRosterLoadingFailed(Exception exc);
}
