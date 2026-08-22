package org.jivesoftware.smackx.muc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.util.JidUtil;

/* JADX INFO: loaded from: classes10.dex */
public class RoomInfo {
    private static final Logger LOGGER = Logger.getLogger(RoomInfo.class.getName());
    private final List<EntityBareJid> contactJid;
    private final String description;
    private final DataForm form;
    private final String lang;
    private final String ldapgroup;
    private final URL logs;
    private final int maxhistoryfetch;
    private final boolean membersOnly;
    private final boolean moderated;
    private final String name;
    private final boolean nonanonymous;
    private final int occupantsCount;
    private final boolean passwordProtected;
    private final boolean persistent;
    private final String pubsub;
    private final EntityBareJid room;
    private final String subject;
    private final Boolean subjectmod;

    RoomInfo(DiscoverInfo discoverInfo) {
        int i;
        String str;
        Boolean boolValueOf;
        String firstValue;
        String firstValue2;
        URL url;
        String str2;
        FormField field;
        List<EntityBareJid> list = null;
        firstValue = null;
        String firstValue3 = null;
        if (discoverInfo.getFrom() != null) {
            this.room = discoverInfo.getFrom().asEntityBareJidIfPossible();
        } else {
            this.room = null;
        }
        this.membersOnly = discoverInfo.containsFeature("muc_membersonly");
        this.moderated = discoverInfo.containsFeature("muc_moderated");
        this.nonanonymous = discoverInfo.containsFeature("muc_nonanonymous");
        this.passwordProtected = discoverInfo.containsFeature("muc_passwordprotected");
        this.persistent = discoverInfo.containsFeature("muc_persistent");
        List<DiscoverInfo.Identity> identities = discoverInfo.getIdentities();
        String firstValue4 = "";
        if (!identities.isEmpty()) {
            this.name = identities.get(0).getName();
        } else {
            LOGGER.warning("DiscoverInfo does not contain any Identity: " + ((Object) discoverInfo.toXML()));
            this.name = "";
        }
        DataForm dataFormFrom = DataForm.from(discoverInfo);
        this.form = dataFormFrom;
        int i2 = -1;
        if (dataFormFrom != null) {
            FormField field2 = dataFormFrom.getField("muc#roominfo_description");
            String firstValue5 = (field2 == null || field2.getValues().isEmpty()) ? "" : field2.getFirstValue();
            FormField field3 = dataFormFrom.getField("muc#roominfo_subject");
            if (field3 != null && !field3.getValues().isEmpty()) {
                firstValue4 = field3.getFirstValue();
            }
            FormField field4 = dataFormFrom.getField("muc#roominfo_occupants");
            int i3 = (field4 == null || field4.getValues().isEmpty()) ? -1 : Integer.parseInt(field4.getFirstValue());
            FormField field5 = dataFormFrom.getField("muc#maxhistoryfetch");
            if (field5 != null && !field5.getValues().isEmpty()) {
                i2 = Integer.parseInt(field5.getFirstValue());
            }
            FormField field6 = dataFormFrom.getField("muc#roominfo_contactjid");
            List<EntityBareJid> listFilterEntityBareJidList = (field6 == null || field6.getValues().isEmpty()) ? null : JidUtil.filterEntityBareJidList(JidUtil.jidSetFrom(field6.getValues()));
            FormField field7 = dataFormFrom.getField("muc#roominfo_lang");
            firstValue = (field7 == null || field7.getValues().isEmpty()) ? null : field7.getFirstValue();
            FormField field8 = dataFormFrom.getField("muc#roominfo_ldapgroup");
            firstValue2 = (field8 == null || field8.getValues().isEmpty()) ? null : field8.getFirstValue();
            FormField field9 = dataFormFrom.getField("muc#roominfo_subjectmod");
            if (field9 == null || field9.getValues().isEmpty()) {
                boolValueOf = null;
            } else {
                String firstValue6 = field9.getFirstValue();
                boolValueOf = Boolean.valueOf("true".equals(firstValue6) || "1".equals(firstValue6));
            }
            FormField field10 = dataFormFrom.getField("muc#roominfo_logs");
            if (field10 != null && !field10.getValues().isEmpty()) {
                try {
                    url = new URL(field10.getFirstValue());
                } catch (MalformedURLException e2) {
                    LOGGER.log(Level.SEVERE, "Could not parse URL", (Throwable) e2);
                    url = null;
                }
                field = this.form.getField("muc#roominfo_pubsub");
                if (field != null) {
                    firstValue3 = field.getFirstValue();
                }
                i = i2;
                i2 = i3;
                str2 = firstValue4;
                firstValue4 = firstValue5;
                str = firstValue3;
                list = listFilterEntityBareJidList;
            } else {
                url = null;
                field = this.form.getField("muc#roominfo_pubsub");
                if (field != null && !field.getValues().isEmpty()) {
                    firstValue3 = field.getFirstValue();
                }
                i = i2;
                i2 = i3;
                str2 = firstValue4;
                firstValue4 = firstValue5;
                str = firstValue3;
                list = listFilterEntityBareJidList;
            }
        } else {
            i = -1;
            str = null;
            boolValueOf = null;
            firstValue = null;
            firstValue2 = null;
            url = null;
            str2 = "";
        }
        this.description = firstValue4;
        this.subject = str2;
        this.occupantsCount = i2;
        this.maxhistoryfetch = i;
        this.contactJid = list;
        this.lang = firstValue;
        this.ldapgroup = firstValue2;
        this.subjectmod = boolValueOf;
        this.logs = url;
        this.pubsub = str;
    }

    public EntityBareJid getRoom() {
        return this.room;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getOccupantsCount() {
        return this.occupantsCount;
    }

    public boolean isMembersOnly() {
        return this.membersOnly;
    }

    public boolean isModerated() {
        return this.moderated;
    }

    public boolean isNonanonymous() {
        return this.nonanonymous;
    }

    public boolean isPasswordProtected() {
        return this.passwordProtected;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public int getMaxHistoryFetch() {
        return this.maxhistoryfetch;
    }

    public List<EntityBareJid> getContactJids() {
        return Collections.unmodifiableList(this.contactJid);
    }

    public String getLang() {
        return this.lang;
    }

    public String getLdapGroup() {
        return this.ldapgroup;
    }

    public Boolean isSubjectModifiable() {
        return this.subjectmod;
    }

    public String getPubSub() {
        return this.pubsub;
    }

    public URL getLogsUrl() {
        return this.logs;
    }

    public DataForm getForm() {
        return this.form;
    }
}
