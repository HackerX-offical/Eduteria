package org.minidns.dnsserverlookup.android21;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.minidns.DnsClient;
import org.minidns.dnsserverlookup.AbstractDnsServerLookupMechanism;

/* JADX INFO: loaded from: classes10.dex */
public class AndroidUsingLinkProperties extends AbstractDnsServerLookupMechanism {
    private final ConnectivityManager connectivityManager;

    @Override // org.minidns.dnsserverlookup.DnsServerLookupMechanism
    public boolean isAvailable() {
        return true;
    }

    public static AndroidUsingLinkProperties setup(Context context) {
        AndroidUsingLinkProperties androidUsingLinkProperties = new AndroidUsingLinkProperties(context);
        DnsClient.addDnsServerLookupMechanism(androidUsingLinkProperties);
        return androidUsingLinkProperties;
    }

    public AndroidUsingLinkProperties(Context context) {
        super("AndroidUsingLinkProperties", 998);
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    private List<String> getDnsServerAddressesOfActiveNetwork() {
        LinkProperties linkProperties;
        Network activeNetwork = this.connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (linkProperties = this.connectivityManager.getLinkProperties(activeNetwork)) == null) {
            return null;
        }
        return toListOfStrings(linkProperties.getDnsServers());
    }

    @Override // org.minidns.dnsserverlookup.AbstractDnsServerLookupMechanism, org.minidns.dnsserverlookup.DnsServerLookupMechanism
    public List<String> getDnsServerAddresses() {
        List<String> dnsServerAddressesOfActiveNetwork = getDnsServerAddressesOfActiveNetwork();
        if (dnsServerAddressesOfActiveNetwork != null) {
            return dnsServerAddressesOfActiveNetwork;
        }
        Network[] allNetworks = this.connectivityManager.getAllNetworks();
        if (allNetworks == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allNetworks.length * 2);
        for (Network network : allNetworks) {
            LinkProperties linkProperties = this.connectivityManager.getLinkProperties(network);
            if (linkProperties != null) {
                if (hasDefaultRoute(linkProperties)) {
                    arrayList.addAll(0, toListOfStrings(linkProperties.getDnsServers()));
                } else {
                    arrayList.addAll(toListOfStrings(linkProperties.getDnsServers()));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static boolean hasDefaultRoute(LinkProperties linkProperties) {
        Iterator<RouteInfo> it = linkProperties.getRoutes().iterator();
        while (it.hasNext()) {
            if (it.next().isDefaultRoute()) {
                return true;
            }
        }
        return false;
    }
}
