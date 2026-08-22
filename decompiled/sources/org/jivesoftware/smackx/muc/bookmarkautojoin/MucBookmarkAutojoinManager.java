package org.jivesoftware.smackx.muc.bookmarkautojoin;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.bookmarks.BookmarkManager;
import org.jivesoftware.smackx.bookmarks.BookmarkedConference;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jivesoftware.smackx.muc.MultiUserChatManager;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public final class MucBookmarkAutojoinManager extends Manager {
    private boolean autojoinEnabled;
    private final BookmarkManager bookmarkManager;
    private final MultiUserChatManager multiUserChatManager;
    private static final Logger LOGGER = Logger.getLogger(MucBookmarkAutojoinManager.class.getName());
    private static final Map<XMPPConnection, MucBookmarkAutojoinManager> INSTANCES = new WeakHashMap();
    private static boolean autojoinEnabledDefault = false;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.muc.bookmarkautojoin.MucBookmarkAutojoinManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                MucBookmarkAutojoinManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    public static void setAutojoinPerDefault(boolean z) {
        autojoinEnabledDefault = z;
    }

    public static synchronized MucBookmarkAutojoinManager getInstanceFor(XMPPConnection xMPPConnection) {
        MucBookmarkAutojoinManager mucBookmarkAutojoinManager;
        Map<XMPPConnection, MucBookmarkAutojoinManager> map = INSTANCES;
        mucBookmarkAutojoinManager = map.get(xMPPConnection);
        if (mucBookmarkAutojoinManager == null) {
            mucBookmarkAutojoinManager = new MucBookmarkAutojoinManager(xMPPConnection);
            map.put(xMPPConnection, mucBookmarkAutojoinManager);
        }
        return mucBookmarkAutojoinManager;
    }

    private MucBookmarkAutojoinManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.autojoinEnabled = autojoinEnabledDefault;
        this.multiUserChatManager = MultiUserChatManager.getInstanceFor(xMPPConnection);
        this.bookmarkManager = BookmarkManager.getBookmarkManager(xMPPConnection);
        xMPPConnection.addConnectionListener(new ConnectionListener() { // from class: org.jivesoftware.smackx.muc.bookmarkautojoin.MucBookmarkAutojoinManager.2
            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                if (MucBookmarkAutojoinManager.this.autojoinEnabled) {
                    MucBookmarkAutojoinManager.this.autojoinBookmarkedConferences();
                }
            }
        });
    }

    public void setAutojoinEnabled(boolean z) {
        this.autojoinEnabled = z;
    }

    public void autojoinBookmarkedConferences() {
        try {
            List<BookmarkedConference> bookmarkedConferences = this.bookmarkManager.getBookmarkedConferences();
            Resourcepart resourcepart = connection().getUser().getResourcepart();
            for (BookmarkedConference bookmarkedConference : bookmarkedConferences) {
                if (bookmarkedConference.isAutoJoin()) {
                    Resourcepart nickname = bookmarkedConference.getNickname();
                    if (nickname == null) {
                        nickname = resourcepart;
                    }
                    try {
                        MultiUserChat.MucCreateConfigFormHandle mucCreateConfigFormHandleCreateOrJoinIfNecessary = this.multiUserChatManager.getMultiUserChat(bookmarkedConference.getJid()).createOrJoinIfNecessary(nickname, bookmarkedConference.getPassword());
                        if (mucCreateConfigFormHandleCreateOrJoinIfNecessary != null) {
                            mucCreateConfigFormHandleCreateOrJoinIfNecessary.makeInstant();
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                        LOGGER.log(Level.FINER, "Could not autojoin bookmarked MUC", e);
                        return;
                    } catch (SmackException.NoResponseException e3) {
                        e = e3;
                        LOGGER.log(Level.WARNING, "Could not autojoin bookmarked MUC", e);
                    } catch (SmackException.NotConnectedException e4) {
                        e = e4;
                        LOGGER.log(Level.FINER, "Could not autojoin bookmarked MUC", e);
                        return;
                    } catch (XMPPException.XMPPErrorException e5) {
                        e = e5;
                        LOGGER.log(Level.WARNING, "Could not autojoin bookmarked MUC", e);
                    } catch (MultiUserChatException.NotAMucServiceException e6) {
                        e = e6;
                        LOGGER.log(Level.WARNING, "Could not autojoin bookmarked MUC", e);
                    }
                }
            }
        } catch (InterruptedException e7) {
            e = e7;
            LOGGER.log(Level.FINER, "Could not get MUC bookmarks", e);
        } catch (SmackException.NoResponseException e8) {
            e = e8;
            LOGGER.log(Level.WARNING, "Could not get MUC bookmarks", e);
        } catch (SmackException.NotConnectedException e9) {
            e = e9;
            LOGGER.log(Level.FINER, "Could not get MUC bookmarks", e);
        } catch (XMPPException.XMPPErrorException e10) {
            e = e10;
            LOGGER.log(Level.WARNING, "Could not get MUC bookmarks", e);
        }
    }
}
