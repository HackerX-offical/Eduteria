package org.jivesoftware.smack.roster;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.SubscribeListener;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class RosterUtil {
    public static void waitUntilOtherEntityIsSubscribed(Roster roster, BareJid bareJid, long j) throws InterruptedException, TimeoutException {
        waitUntilOtherEntityIsSubscribed(roster, bareJid, new Date(System.currentTimeMillis() + j));
    }

    public static void waitUntilOtherEntityIsSubscribed(Roster roster, BareJid bareJid, Date date) throws InterruptedException, TimeoutException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition conditionNewCondition = reentrantLock.newCondition();
        AbstractRosterListener abstractRosterListener = new AbstractRosterListener() { // from class: org.jivesoftware.smack.roster.RosterUtil.1
            private void signal() {
                reentrantLock.lock();
                try {
                    conditionNewCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }

            @Override // org.jivesoftware.smack.roster.AbstractRosterListener, org.jivesoftware.smack.roster.RosterListener
            public void entriesAdded(Collection<Jid> collection) {
                signal();
            }

            @Override // org.jivesoftware.smack.roster.AbstractRosterListener, org.jivesoftware.smack.roster.RosterListener
            public void entriesUpdated(Collection<Jid> collection) {
                signal();
            }
        };
        roster.addRosterListener(abstractRosterListener);
        reentrantLock.lock();
        boolean zAwaitUntil = true;
        while (!roster.isSubscribedToMyPresence(bareJid)) {
            try {
                if (!zAwaitUntil) {
                    throw new TimeoutException();
                }
                zAwaitUntil = conditionNewCondition.awaitUntil(date);
            } finally {
                reentrantLock.unlock();
                roster.removeRosterListener(abstractRosterListener);
            }
        }
    }

    public static void preApproveSubscriptionIfRequiredAndPossible(Roster roster, BareJid bareJid) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        if (roster.isSubscriptionPreApprovalSupported()) {
            RosterEntry entry = roster.getEntry(bareJid);
            if (entry == null || !(entry.canSeeMyPresence() || entry.isApproved())) {
                try {
                    roster.preApprove(bareJid);
                } catch (SmackException.FeatureNotSupportedException e2) {
                    throw new AssertionError(e2);
                }
            }
        }
    }

    public static void askForSubscriptionIfRequired(Roster roster, BareJid bareJid) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        RosterEntry entry = roster.getEntry(bareJid);
        if (entry == null || !(entry.canSeeHisPresence() || entry.isSubscriptionPending())) {
            roster.sendSubscriptionRequest(bareJid);
        }
    }

    public static void ensureNotSubscribedToEachOther(XMPPConnection xMPPConnection, XMPPConnection xMPPConnection2) throws SmackException.NotConnectedException, InterruptedException {
        Roster instanceFor = Roster.getInstanceFor(xMPPConnection);
        BareJid bareJidAsBareJid = xMPPConnection.getUser().asBareJid();
        Roster instanceFor2 = Roster.getInstanceFor(xMPPConnection2);
        ensureNotSubscribed(instanceFor, xMPPConnection2.getUser().asBareJid());
        ensureNotSubscribed(instanceFor2, bareJidAsBareJid);
    }

    public static void ensureNotSubscribed(Roster roster, BareJid bareJid) throws SmackException.NotConnectedException, InterruptedException {
        RosterEntry entry = roster.getEntry(bareJid);
        if (entry == null || !entry.canSeeMyPresence()) {
            return;
        }
        entry.cancelSubscription();
    }

    public static void ensureSubscribed(XMPPConnection xMPPConnection, XMPPConnection xMPPConnection2, long j) throws SmackException.NotConnectedException, InterruptedException, TimeoutException, SmackException.NotLoggedInException {
        ensureSubscribedTo(xMPPConnection, xMPPConnection2, j);
        ensureSubscribedTo(xMPPConnection2, xMPPConnection, j);
    }

    public static void ensureSubscribedTo(XMPPConnection xMPPConnection, XMPPConnection xMPPConnection2, long j) throws SmackException.NotConnectedException, InterruptedException, TimeoutException, SmackException.NotLoggedInException {
        ensureSubscribedTo(xMPPConnection, xMPPConnection2, new Date(System.currentTimeMillis() + j));
    }

    public static void ensureSubscribedTo(XMPPConnection xMPPConnection, XMPPConnection xMPPConnection2, Date date) throws SmackException.NotConnectedException, InterruptedException, TimeoutException, SmackException.NotLoggedInException {
        Roster instanceFor = Roster.getInstanceFor(xMPPConnection);
        BareJid bareJidAsBareJid = xMPPConnection2.getUser().asBareJid();
        if (instanceFor.iAmSubscribedTo(bareJidAsBareJid)) {
            return;
        }
        final BareJid bareJidAsBareJid2 = xMPPConnection.getUser().asBareJid();
        SubscribeListener subscribeListener = new SubscribeListener() { // from class: org.jivesoftware.smack.roster.RosterUtil.2
            @Override // org.jivesoftware.smack.roster.SubscribeListener
            public SubscribeListener.SubscribeAnswer processSubscribe(Jid jid, Presence presence) {
                if (jid.equals((CharSequence) bareJidAsBareJid2)) {
                    return SubscribeListener.SubscribeAnswer.Approve;
                }
                return null;
            }
        };
        Roster instanceFor2 = Roster.getInstanceFor(xMPPConnection2);
        instanceFor2.addSubscribeListener(subscribeListener);
        try {
            instanceFor.sendSubscriptionRequest(bareJidAsBareJid);
            waitUntilOtherEntityIsSubscribed(instanceFor2, bareJidAsBareJid2, date);
        } finally {
            instanceFor2.removeSubscribeListener(subscribeListener);
        }
    }
}
