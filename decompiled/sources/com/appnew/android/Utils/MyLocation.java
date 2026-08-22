package com.appnew.android.Utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes6.dex */
public class MyLocation {
    Context ctx;
    LocationManager lm;
    LocationResult locationResult;
    Timer timer1;
    boolean gps_enabled = false;
    boolean network_enabled = false;
    LocationListener locationListenerGps = new LocationListener() { // from class: com.appnew.android.Utils.MyLocation.1
        @Override // android.location.LocationListener
        public void onProviderDisabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            MyLocation.this.timer1.cancel();
            MyLocation.this.locationResult.gotLocation(location);
            MyLocation.this.lm.removeUpdates(this);
            MyLocation.this.lm.removeUpdates(MyLocation.this.locationListenerNetwork);
        }
    };
    LocationListener locationListenerNetwork = new LocationListener() { // from class: com.appnew.android.Utils.MyLocation.2
        @Override // android.location.LocationListener
        public void onProviderDisabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            MyLocation.this.timer1.cancel();
            MyLocation.this.locationResult.gotLocation(location);
            MyLocation.this.lm.removeUpdates(this);
            MyLocation.this.lm.removeUpdates(MyLocation.this.locationListenerGps);
        }
    };

    public static abstract class LocationResult {
        public abstract void gotLocation(Location location);
    }

    public boolean getLocation(Context context, LocationResult result) {
        this.locationResult = result;
        this.ctx = context;
        if (this.lm == null) {
            this.lm = (LocationManager) context.getSystemService("location");
        }
        try {
            this.gps_enabled = this.lm.isProviderEnabled("gps");
        } catch (Exception unused) {
        }
        try {
            this.network_enabled = this.lm.isProviderEnabled("network");
        } catch (Exception unused2) {
        }
        if (!this.gps_enabled && !this.network_enabled) {
            return false;
        }
        if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return true;
        }
        if (this.gps_enabled) {
            this.lm.requestLocationUpdates("gps", 0L, 0.0f, this.locationListenerGps);
        }
        if (this.network_enabled) {
            this.lm.requestLocationUpdates("network", 0L, 0.0f, this.locationListenerNetwork);
        }
        Timer timer = new Timer();
        this.timer1 = timer;
        timer.schedule(new GetLastLocation(), 20000L);
        return true;
    }

    class GetLastLocation extends TimerTask {
        GetLastLocation() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MyLocation.this.lm.removeUpdates(MyLocation.this.locationListenerGps);
            MyLocation.this.lm.removeUpdates(MyLocation.this.locationListenerNetwork);
            if (!MyLocation.this.gps_enabled || ActivityCompat.checkSelfPermission(MyLocation.this.ctx, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(MyLocation.this.ctx, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Location lastKnownLocation = MyLocation.this.lm.getLastKnownLocation("gps");
                Location lastKnownLocation2 = MyLocation.this.network_enabled ? MyLocation.this.lm.getLastKnownLocation("network") : null;
                if (lastKnownLocation != null && lastKnownLocation2 != null) {
                    if (lastKnownLocation.getTime() > lastKnownLocation2.getTime()) {
                        MyLocation.this.locationResult.gotLocation(lastKnownLocation);
                        return;
                    } else {
                        MyLocation.this.locationResult.gotLocation(lastKnownLocation2);
                        return;
                    }
                }
                if (lastKnownLocation != null) {
                    MyLocation.this.locationResult.gotLocation(lastKnownLocation);
                } else if (lastKnownLocation2 != null) {
                    MyLocation.this.locationResult.gotLocation(lastKnownLocation2);
                } else {
                    MyLocation.this.locationResult.gotLocation(null);
                }
            }
        }
    }
}
