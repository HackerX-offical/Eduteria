package org.jivesoftware.smack.roster.rosterstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.provider.RosterPacketProvider;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.stringencoder.Base32;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class DirectoryRosterStore implements RosterStore {
    private static final String ENTRY_PREFIX = "entry-";
    private static final Logger LOGGER = Logger.getLogger(DirectoryRosterStore.class.getName());
    private static final String STORE_ID = "DEFAULT_ROSTER_STORE";
    private static final String VERSION_FILE_NAME = "__version__";
    private final File fileDir;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean rosterDirFilter(File file) {
        return file.getName().startsWith(ENTRY_PREFIX);
    }

    private DirectoryRosterStore(File file) {
        this.fileDir = file;
    }

    public static DirectoryRosterStore init(File file) {
        DirectoryRosterStore directoryRosterStore = new DirectoryRosterStore(file);
        if (directoryRosterStore.setRosterVersion("")) {
            return directoryRosterStore;
        }
        return null;
    }

    public static DirectoryRosterStore open(File file) {
        DirectoryRosterStore directoryRosterStore = new DirectoryRosterStore(file);
        String file2 = FileUtils.readFile(directoryRosterStore.getVersionFile());
        if (file2 == null || !file2.startsWith("DEFAULT_ROSTER_STORE\n")) {
            return null;
        }
        return directoryRosterStore;
    }

    private File getVersionFile() {
        return new File(this.fileDir, VERSION_FILE_NAME);
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public List<RosterPacket.Item> getEntries() {
        ArrayList arrayList = new ArrayList();
        for (File file : this.fileDir.listFiles(new DirectoryRosterStore$$ExternalSyntheticLambda0())) {
            RosterPacket.Item entry = readEntry(file);
            if (entry == null) {
                return null;
            }
            arrayList.add(entry);
        }
        return arrayList;
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public RosterPacket.Item getEntry(Jid jid) {
        return readEntry(getBareJidFile(jid));
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public String getRosterVersion() {
        String file = FileUtils.readFile(getVersionFile());
        if (file == null) {
            return null;
        }
        String[] strArrSplit = file.split("\n", 2);
        if (strArrSplit.length < 2) {
            return null;
        }
        return strArrSplit[1];
    }

    private boolean setRosterVersion(String str) {
        return FileUtils.writeFile(getVersionFile(), "DEFAULT_ROSTER_STORE\n" + str);
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public boolean addEntry(RosterPacket.Item item, String str) {
        return addEntryRaw(item) && setRosterVersion(str);
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public boolean removeEntry(Jid jid, String str) {
        return getBareJidFile(jid).delete() && setRosterVersion(str);
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public boolean resetEntries(Collection<RosterPacket.Item> collection, String str) {
        for (File file : this.fileDir.listFiles(new DirectoryRosterStore$$ExternalSyntheticLambda0())) {
            file.delete();
        }
        Iterator<RosterPacket.Item> it = collection.iterator();
        while (it.hasNext()) {
            if (!addEntryRaw(it.next())) {
                return false;
            }
        }
        return setRosterVersion(str);
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public void resetStore() {
        resetEntries(Collections.emptyList(), "");
    }

    private static RosterPacket.Item readEntry(File file) {
        String str;
        try {
            FileReader fileReader = new FileReader(file);
            try {
                RosterPacket.Item item = RosterPacketProvider.parseItem(PacketParserUtils.getParserFor(fileReader));
                fileReader.close();
                return item;
            } catch (IOException | IllegalArgumentException | XmlPullParserException e2) {
                if (!file.delete()) {
                    str = "Exception while parsing roster entry.";
                } else {
                    str = "Exception while parsing roster entry. File was deleted.";
                }
                LOGGER.log(Level.SEVERE, str, e2);
                return null;
            }
        } catch (FileNotFoundException e3) {
            LOGGER.log(Level.FINE, "Roster entry file not found", (Throwable) e3);
            return null;
        }
    }

    private boolean addEntryRaw(RosterPacket.Item item) {
        return FileUtils.writeFile(getBareJidFile(item.getJid()), item.toXML());
    }

    private File getBareJidFile(Jid jid) {
        return new File(this.fileDir, ENTRY_PREFIX + Base32.encode(jid.toString()));
    }
}
