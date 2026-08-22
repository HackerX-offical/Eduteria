package listeners;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes10.dex */
public class ConnectionDetector {
    private Context _context;

    public ConnectionDetector(Context context) {
        this._context = context;
    }

    public boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this._context.getSystemService("connectivity");
        for (Network network : connectivityManager.getAllNetworks()) {
            if (connectivityManager.getNetworkInfo(network).getState().equals(NetworkInfo.State.CONNECTED)) {
                return true;
            }
        }
        return false;
    }
}
