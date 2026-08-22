package org.jivesoftware.smackx.bookmarks;

import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public class BookmarkedConference implements SharedBookmark {
    private boolean autoJoin;
    private boolean isShared;
    private final EntityBareJid jid;
    private String name;
    private Resourcepart nickname;
    private String password;

    protected BookmarkedConference(EntityBareJid entityBareJid) {
        this.jid = entityBareJid;
    }

    protected BookmarkedConference(String str, EntityBareJid entityBareJid, boolean z, Resourcepart resourcepart, String str2) {
        this.name = str;
        this.jid = entityBareJid;
        this.autoJoin = z;
        this.nickname = resourcepart;
        this.password = str2;
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String str) {
        this.name = str;
    }

    public boolean isAutoJoin() {
        return this.autoJoin;
    }

    protected void setAutoJoin(boolean z) {
        this.autoJoin = z;
    }

    public EntityBareJid getJid() {
        return this.jid;
    }

    public Resourcepart getNickname() {
        return this.nickname;
    }

    protected void setNickname(Resourcepart resourcepart) {
        this.nickname = resourcepart;
    }

    public String getPassword() {
        return this.password;
    }

    protected void setPassword(String str) {
        this.password = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BookmarkedConference)) {
            return false;
        }
        return ((BookmarkedConference) obj).getJid().equals((CharSequence) this.jid);
    }

    public int hashCode() {
        return getJid().hashCode();
    }

    protected void setShared(boolean z) {
        this.isShared = z;
    }

    @Override // org.jivesoftware.smackx.bookmarks.SharedBookmark
    public boolean isShared() {
        return this.isShared;
    }
}
