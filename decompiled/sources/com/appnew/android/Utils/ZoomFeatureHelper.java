package com.appnew.android.Utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;

/* JADX INFO: loaded from: classes6.dex */
public class ZoomFeatureHelper {
    public static void launchZoomFeature(final Context context, final String mid, final String pwd, final String token, final String userId, final String name, final String email, final String mobile) {
        SplitInstallManager splitInstallManagerCreate = SplitInstallManagerFactory.create(context);
        if (splitInstallManagerCreate.getInstalledModules().contains("zoom_feature")) {
            startZoomActivity(context, mid, pwd, token, userId, name, email, mobile);
            return;
        }
        SplitInstallRequest splitInstallRequestBuild = SplitInstallRequest.newBuilder().addModule("zoom_feature").build();
        Toast.makeText(context, "Loading Zoom module...", 0).show();
        splitInstallManagerCreate.startInstall(splitInstallRequestBuild).addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Utils.ZoomFeatureHelper$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ZoomFeatureHelper.startZoomActivity(context, mid, pwd, token, userId, name, email, mobile);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.appnew.android.Utils.ZoomFeatureHelper$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Toast.makeText(context, "Failed to load Zoom: " + exc.getMessage(), 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startZoomActivity(Context context, String mid, String pwd, String token, String userId, String name, String email, String mobile) {
        try {
            Intent intent = new Intent(context, Class.forName("com.appnew.android.zoom_feature.InitializeSdkActivity"));
            intent.putExtra("mid", mid);
            intent.putExtra("pwd", pwd);
            intent.putExtra("classid", "1234");
            intent.putExtra("userid", userId);
            intent.putExtra("displayname", name);
            intent.putExtra("displayemail", email);
            intent.putExtra("displaymobile", mobile);
            intent.putExtra("token", token);
            context.startActivity(intent);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            Toast.makeText(context, "Zoom SDK Error", 0).show();
        }
    }
}
