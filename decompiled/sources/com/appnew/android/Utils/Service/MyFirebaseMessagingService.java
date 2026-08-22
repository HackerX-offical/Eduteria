package com.appnew.android.Utils.Service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Theme.DashboardActivityTheme4;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Notification.NotificationUtils;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.eduteria.app.app.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String CHANNEL_ID = "EDUTERIAEnglisApp";
    private static final String TAG = "MyFirebaseMessagingService";
    private NotificationUtils notificationUtils;

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String s) {
        super.onNewToken(s);
        AnalyticEvents.INSTANCE.uninstallTrackingUser(this, s);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getNotification() != null) {
            try {
                handleDataMessage(new JSONObject((String) Objects.requireNonNull(remoteMessage.getNotification().getBody())));
            } catch (JSONException unused) {
            }
        }
        if (remoteMessage.getData().size() > 0) {
            try {
                if (remoteMessage.getData().containsKey(Const.NOTIFICATION_CODE)) {
                    handleSNSData(remoteMessage);
                }
                if (!remoteMessage.getData().containsKey("message") || !remoteMessage.getData().containsKey("type")) {
                    if (remoteMessage.getData().containsKey("message") && remoteMessage.getData().size() == 1) {
                        handleDataMessage(new JSONObject(remoteMessage.getData().get("message").toString()));
                        return;
                    }
                    return;
                }
                JSONObject jSONObject = new JSONObject(remoteMessage.getData().get("message").toString());
                if (!SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) || SharedPreference.getInstance().getBoolean(Const.IS_NOTIFICATION_BLOCKED)) {
                    return;
                }
                handleDataMessage(jSONObject);
            } catch (Exception unused2) {
            }
        }
    }

    private void handleSNSData(RemoteMessage remoteMessage) {
        String string;
        String str;
        String str2;
        String str3;
        String str4;
        String strOptString;
        String strOptString2;
        String str5;
        String str6;
        String str7;
        String strOptString3;
        String str8;
        String str9;
        createNotificationChannel();
        try {
            if (remoteMessage.getData().containsKey(Const.LINK_TYPE)) {
                remoteMessage.getData().get(Const.LINK_TYPE).toString();
            }
            String string2 = remoteMessage.getData().containsKey(Const.NOTIFICATION_CODE) ? remoteMessage.getData().get(Const.NOTIFICATION_CODE).toString() : "";
            if (remoteMessage.getData().containsKey(Const.NOTIFICATION_ID)) {
                string = remoteMessage.getData().get(Const.NOTIFICATION_ID).toString();
                str = "";
            } else {
                string = "";
                str = string;
            }
            if (remoteMessage.getData().containsKey("image_type")) {
                remoteMessage.getData().get("image_type");
            }
            String str10 = remoteMessage.getData().containsKey("url") ? remoteMessage.getData().get("url") : str;
            if (remoteMessage.getData().containsKey("image")) {
                remoteMessage.getData().get("image");
            }
            String str11 = remoteMessage.getData().containsKey(Const.MESSAGE_TARGET) ? remoteMessage.getData().get(Const.MESSAGE_TARGET) : str;
            if (remoteMessage.getData().containsKey("course_id")) {
                remoteMessage.getData().get("course_id");
            }
            String str12 = remoteMessage.getData().containsKey("title") ? remoteMessage.getData().get("title") : str;
            String str13 = remoteMessage.getData().containsKey("message") ? remoteMessage.getData().get("message") : str;
            String str14 = str10;
            String str15 = str11;
            if (remoteMessage.getData().containsKey(Const.ADDITIONAL_JSON)) {
                str3 = "custom://";
                str2 = str13;
                JSONObject jSONObject = new JSONObject(remoteMessage.getData().get(Const.ADDITIONAL_JSON).toString());
                strOptString = jSONObject.optString("course_id");
                strOptString2 = jSONObject.optString("file_id");
                String strOptString4 = jSONObject.optString(Const.TOPIC_ID);
                String strOptString5 = jSONObject.optString(Const.TILE_TYPE);
                String strOptString6 = jSONObject.optString("tile_id");
                String strOptString7 = jSONObject.optString(Const.REVERT_API);
                strOptString3 = jSONObject.optString(Const.PARENT_ID);
                str5 = strOptString4;
                str7 = strOptString7;
                str8 = Const.PARENT_ID;
                str9 = strOptString5;
                str4 = Const.REVERT_API;
                str6 = strOptString6;
            } else {
                str2 = str13;
                str3 = "custom://";
                str4 = Const.REVERT_API;
                strOptString = str;
                strOptString2 = strOptString;
                str5 = strOptString2;
                str6 = str5;
                str7 = str6;
                strOptString3 = str7;
                str8 = Const.PARENT_ID;
                str9 = strOptString3;
            }
            if (!string2.equalsIgnoreCase("20009")) {
                if (!string2.equalsIgnoreCase("10009") || remoteMessage.getData().size() <= 0) {
                    return;
                }
                handleGeneralNotificationData(remoteMessage.getData());
                return;
            }
            Intent intent = "1".equalsIgnoreCase("1") ? new Intent(this, (Class<?>) DashboardActivityTheme1.class) : "1".equalsIgnoreCase("2") ? new Intent(this, (Class<?>) DashboardActivityTheme2.class) : "1".equalsIgnoreCase("3") ? new Intent(this, (Class<?>) DashboardActivityTheme3.class) : "1".equalsIgnoreCase("4") ? new Intent(this, (Class<?>) DashboardActivityTheme4.class) : "1".equalsIgnoreCase("5") ? new Intent(this, (Class<?>) DashboardActivityTheme5.class) : "1".equalsIgnoreCase("6") ? new Intent(this, (Class<?>) DashboardActivityTheme7.class) : "1".equalsIgnoreCase("7") ? new Intent(this, (Class<?>) DashboardActivityTheme8.class) : null;
            Bundle bundle = new Bundle();
            try {
                bundle.putInt(Const.SNS_NOTIFICATION_CODE, Integer.parseInt(string2));
                bundle.putString(Const.NOTIFICATION_ID, string);
                bundle.putString("course_id", strOptString);
                bundle.putString("file_id", strOptString2);
                bundle.putString(Const.SNS_TITLE, str12);
                String str16 = str2;
                bundle.putString(Const.SNS_MESSAGE, str16);
                bundle.putString(Const.TOPIC_ID, str5);
                bundle.putString(Const.TILE_TYPE, str9);
                bundle.putString("tile_id", str6);
                bundle.putString(str4, str7);
                bundle.putString(str8, strOptString3);
                intent.putExtras(bundle);
                intent.setData(Uri.parse(str3 + string));
                intent.setFlags(335544320);
                SharedPreference.getInstance().putInt(Const.NOTIFICATION_COUNT, SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) + 1);
                showNotification(10001, str16, str12, intent, str14, "", str15);
            } catch (JSONException e2) {
                e = e2;
                throw new RuntimeException(e);
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    private void createNotificationChannel() {
        String string = getString(R.string.channel_name);
        String string2 = getString(R.string.channel_description);
        NotificationChannel notificationChannel = new NotificationChannel("EDUTERIAEnglisApp", string, 4);
        notificationChannel.setDescription(string2);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        notificationChannel.setVibrationPattern(new long[]{0});
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void handleNotification(String message) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.putExtra("message", message);
        sendBroadcast(intent);
        if (NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            new NotificationUtils(getApplicationContext()).playNotificationSound();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:301:0x07da  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0857 A[Catch: JSONException | Exception -> 0x0ee0, JSONException | Exception -> 0x0ee0, TryCatch #0 {JSONException | Exception -> 0x0ee0, blocks: (B:3:0x000d, B:6:0x002a, B:6:0x002a, B:8:0x0061, B:8:0x0061, B:10:0x0076, B:10:0x0076, B:13:0x00aa, B:13:0x00aa, B:15:0x00b0, B:15:0x00b0, B:35:0x010d, B:35:0x010d, B:37:0x01b1, B:37:0x01b1, B:39:0x01b7, B:39:0x01b7, B:579:0x0ece, B:579:0x0ece, B:582:0x0ed5, B:582:0x0ed5, B:40:0x01c0, B:40:0x01c0, B:42:0x01c6, B:42:0x01c6, B:44:0x01cc, B:44:0x01cc, B:45:0x01d4, B:45:0x01d4, B:47:0x01dc, B:47:0x01dc, B:49:0x01e2, B:49:0x01e2, B:50:0x01ea, B:50:0x01ea, B:52:0x01f2, B:52:0x01f2, B:54:0x01f8, B:54:0x01f8, B:55:0x0200, B:55:0x0200, B:57:0x0208, B:57:0x0208, B:59:0x020e, B:59:0x020e, B:60:0x0216, B:60:0x0216, B:62:0x021e, B:62:0x021e, B:64:0x0224, B:64:0x0224, B:16:0x00b8, B:16:0x00b8, B:18:0x00be, B:18:0x00be, B:19:0x00c6, B:19:0x00c6, B:21:0x00cc, B:21:0x00cc, B:22:0x00d4, B:22:0x00d4, B:24:0x00da, B:24:0x00da, B:25:0x00e2, B:25:0x00e2, B:27:0x00e8, B:27:0x00e8, B:28:0x00f0, B:28:0x00f0, B:30:0x00f6, B:30:0x00f6, B:31:0x00fe, B:31:0x00fe, B:33:0x0104, B:33:0x0104, B:72:0x024d, B:72:0x024d, B:75:0x0260, B:75:0x0260, B:77:0x0268, B:77:0x0268, B:78:0x0270, B:78:0x0270, B:80:0x0276, B:80:0x0276, B:81:0x027e, B:81:0x027e, B:83:0x0284, B:83:0x0284, B:84:0x028c, B:84:0x028c, B:86:0x0292, B:86:0x0292, B:87:0x029a, B:87:0x029a, B:89:0x02a0, B:89:0x02a0, B:90:0x02a8, B:90:0x02a8, B:92:0x02ae, B:92:0x02ae, B:97:0x02ca, B:97:0x02ca, B:99:0x02f2, B:99:0x02f2, B:101:0x02fb, B:101:0x02fb, B:103:0x0317, B:103:0x0317, B:123:0x0374, B:123:0x0374, B:125:0x037a, B:125:0x037a, B:127:0x0380, B:127:0x0380, B:154:0x03f0, B:154:0x03f0, B:129:0x038c, B:129:0x038c, B:131:0x0392, B:131:0x0392, B:133:0x0398, B:133:0x0398, B:134:0x03a0, B:134:0x03a0, B:136:0x03a6, B:136:0x03a6, B:138:0x03ac, B:138:0x03ac, B:139:0x03b4, B:139:0x03b4, B:141:0x03ba, B:141:0x03ba, B:143:0x03c0, B:143:0x03c0, B:144:0x03c8, B:144:0x03c8, B:146:0x03ce, B:146:0x03ce, B:148:0x03d4, B:148:0x03d4, B:149:0x03dc, B:149:0x03dc, B:151:0x03e2, B:151:0x03e2, B:153:0x03e8, B:153:0x03e8, B:104:0x031f, B:104:0x031f, B:106:0x0325, B:106:0x0325, B:107:0x032d, B:107:0x032d, B:109:0x0333, B:109:0x0333, B:110:0x033b, B:110:0x033b, B:112:0x0341, B:112:0x0341, B:113:0x0349, B:113:0x0349, B:115:0x034f, B:115:0x034f, B:116:0x0357, B:116:0x0357, B:118:0x035d, B:118:0x035d, B:119:0x0365, B:119:0x0365, B:121:0x036b, B:121:0x036b, B:157:0x0472, B:157:0x0472, B:159:0x04b3, B:159:0x04b3, B:179:0x0510, B:179:0x0510, B:181:0x0516, B:181:0x0516, B:183:0x051c, B:183:0x051c, B:210:0x058a, B:210:0x058a, B:185:0x0526, B:185:0x0526, B:187:0x052c, B:187:0x052c, B:189:0x0532, B:189:0x0532, B:190:0x053a, B:190:0x053a, B:192:0x0540, B:192:0x0540, B:194:0x0546, B:194:0x0546, B:195:0x054e, B:195:0x054e, B:197:0x0554, B:197:0x0554, B:199:0x055a, B:199:0x055a, B:200:0x0562, B:200:0x0562, B:202:0x0568, B:202:0x0568, B:204:0x056e, B:204:0x056e, B:205:0x0576, B:205:0x0576, B:207:0x057c, B:207:0x057c, B:209:0x0582, B:209:0x0582, B:160:0x04bb, B:160:0x04bb, B:162:0x04c1, B:162:0x04c1, B:163:0x04c9, B:163:0x04c9, B:165:0x04cf, B:165:0x04cf, B:166:0x04d7, B:166:0x04d7, B:168:0x04dd, B:168:0x04dd, B:169:0x04e5, B:169:0x04e5, B:171:0x04eb, B:171:0x04eb, B:172:0x04f3, B:172:0x04f3, B:174:0x04f9, B:174:0x04f9, B:175:0x0501, B:175:0x0501, B:177:0x0507, B:177:0x0507, B:214:0x0602, B:214:0x0602, B:217:0x0614, B:217:0x0614, B:219:0x061a, B:219:0x061a, B:239:0x067c, B:239:0x067c, B:241:0x06c8, B:241:0x06c8, B:243:0x06ce, B:243:0x06ce, B:244:0x06d6, B:244:0x06d6, B:246:0x06dc, B:246:0x06dc, B:248:0x06e2, B:248:0x06e2, B:249:0x06ea, B:249:0x06ea, B:251:0x06f0, B:251:0x06f0, B:253:0x06f6, B:253:0x06f6, B:254:0x06fe, B:254:0x06fe, B:256:0x0704, B:256:0x0704, B:258:0x070a, B:258:0x070a, B:259:0x0712, B:259:0x0712, B:261:0x0718, B:261:0x0718, B:263:0x071e, B:263:0x071e, B:264:0x0726, B:264:0x0726, B:266:0x072c, B:266:0x072c, B:268:0x0732, B:268:0x0732, B:220:0x0625, B:220:0x0625, B:222:0x062d, B:222:0x062d, B:223:0x0635, B:223:0x0635, B:225:0x063b, B:225:0x063b, B:226:0x0643, B:226:0x0643, B:228:0x0649, B:228:0x0649, B:229:0x0651, B:229:0x0651, B:231:0x0657, B:231:0x0657, B:232:0x065f, B:232:0x065f, B:234:0x0665, B:234:0x0665, B:235:0x066d, B:235:0x066d, B:237:0x0673, B:237:0x0673, B:270:0x0740, B:270:0x0740, B:272:0x0754, B:272:0x0754, B:274:0x075a, B:274:0x075a, B:276:0x0760, B:276:0x0760, B:294:0x07b7, B:294:0x07b7, B:296:0x07c7, B:296:0x07c7, B:298:0x07cd, B:298:0x07cd, B:303:0x07e0, B:303:0x07e0, B:305:0x0857, B:305:0x0857, B:307:0x085d, B:307:0x085d, B:308:0x0866, B:308:0x0866, B:310:0x086e, B:310:0x086e, B:312:0x0874, B:312:0x0874, B:313:0x087c, B:313:0x087c, B:315:0x0884, B:315:0x0884, B:317:0x088a, B:317:0x088a, B:318:0x0892, B:318:0x0892, B:320:0x089a, B:320:0x089a, B:322:0x08a0, B:322:0x08a0, B:323:0x08a8, B:323:0x08a8, B:325:0x08b0, B:325:0x08b0, B:327:0x08b6, B:327:0x08b6, B:328:0x08be, B:328:0x08be, B:330:0x08c6, B:330:0x08c6, B:332:0x08cc, B:332:0x08cc, B:278:0x076c, B:278:0x076c, B:280:0x0772, B:280:0x0772, B:281:0x077a, B:281:0x077a, B:283:0x0780, B:283:0x0780, B:284:0x0788, B:284:0x0788, B:286:0x078e, B:286:0x078e, B:287:0x0796, B:287:0x0796, B:289:0x079c, B:289:0x079c, B:290:0x07a4, B:290:0x07a4, B:292:0x07aa, B:292:0x07aa, B:334:0x08dc, B:334:0x08dc, B:336:0x08e8, B:336:0x08e8, B:342:0x0903, B:342:0x0903, B:363:0x096f, B:363:0x096f, B:365:0x09ca, B:365:0x09ca, B:367:0x09d0, B:367:0x09d0, B:368:0x09d8, B:368:0x09d8, B:370:0x09de, B:370:0x09de, B:372:0x09e4, B:372:0x09e4, B:373:0x09ec, B:373:0x09ec, B:375:0x09f2, B:375:0x09f2, B:377:0x09f8, B:377:0x09f8, B:378:0x0a00, B:378:0x0a00, B:380:0x0a06, B:380:0x0a06, B:382:0x0a0c, B:382:0x0a0c, B:383:0x0a14, B:383:0x0a14, B:385:0x0a1a, B:385:0x0a1a, B:387:0x0a20, B:387:0x0a20, B:388:0x0a28, B:388:0x0a28, B:390:0x0a2e, B:390:0x0a2e, B:392:0x0a34, B:392:0x0a34, B:343:0x0908, B:343:0x0908, B:344:0x0914, B:344:0x0914, B:346:0x0920, B:346:0x0920, B:347:0x0928, B:347:0x0928, B:349:0x092e, B:349:0x092e, B:350:0x0936, B:350:0x0936, B:352:0x093c, B:352:0x093c, B:353:0x0944, B:353:0x0944, B:355:0x094a, B:355:0x094a, B:356:0x0952, B:356:0x0952, B:358:0x0958, B:358:0x0958, B:359:0x0960, B:359:0x0960, B:361:0x0966, B:361:0x0966, B:394:0x0a3e, B:394:0x0a3e, B:396:0x0a50, B:396:0x0a50, B:402:0x0a6b, B:402:0x0a6b, B:423:0x0ad7, B:423:0x0ad7, B:425:0x0b32, B:425:0x0b32, B:427:0x0b38, B:427:0x0b38, B:428:0x0b40, B:428:0x0b40, B:430:0x0b46, B:430:0x0b46, B:432:0x0b4c, B:432:0x0b4c, B:433:0x0b54, B:433:0x0b54, B:435:0x0b5a, B:435:0x0b5a, B:437:0x0b60, B:437:0x0b60, B:438:0x0b68, B:438:0x0b68, B:440:0x0b6e, B:440:0x0b6e, B:442:0x0b74, B:442:0x0b74, B:443:0x0b7c, B:443:0x0b7c, B:445:0x0b82, B:445:0x0b82, B:447:0x0b88, B:447:0x0b88, B:448:0x0b90, B:448:0x0b90, B:450:0x0b96, B:450:0x0b96, B:452:0x0b9c, B:452:0x0b9c, B:403:0x0a70, B:403:0x0a70, B:404:0x0a7c, B:404:0x0a7c, B:406:0x0a88, B:406:0x0a88, B:407:0x0a90, B:407:0x0a90, B:409:0x0a96, B:409:0x0a96, B:410:0x0a9e, B:410:0x0a9e, B:412:0x0aa4, B:412:0x0aa4, B:413:0x0aac, B:413:0x0aac, B:415:0x0ab2, B:415:0x0ab2, B:416:0x0aba, B:416:0x0aba, B:418:0x0ac0, B:418:0x0ac0, B:419:0x0ac8, B:419:0x0ac8, B:421:0x0ace, B:421:0x0ace, B:454:0x0ba8, B:454:0x0ba8, B:456:0x0bba, B:456:0x0bba, B:462:0x0bf7, B:462:0x0bf7, B:484:0x0c65, B:484:0x0c65, B:486:0x0cd0, B:486:0x0cd0, B:488:0x0cd6, B:488:0x0cd6, B:489:0x0cdf, B:489:0x0cdf, B:491:0x0ce5, B:491:0x0ce5, B:493:0x0ceb, B:493:0x0ceb, B:494:0x0cf4, B:494:0x0cf4, B:496:0x0cfa, B:496:0x0cfa, B:498:0x0d00, B:498:0x0d00, B:499:0x0d09, B:499:0x0d09, B:501:0x0d0f, B:501:0x0d0f, B:503:0x0d15, B:503:0x0d15, B:504:0x0d1e, B:504:0x0d1e, B:506:0x0d24, B:506:0x0d24, B:508:0x0d2a, B:508:0x0d2a, B:509:0x0d33, B:509:0x0d33, B:511:0x0d39, B:511:0x0d39, B:513:0x0d3f, B:513:0x0d3f, B:463:0x0bfc, B:463:0x0bfc, B:465:0x0c0c, B:465:0x0c0c, B:467:0x0c16, B:467:0x0c16, B:468:0x0c1e, B:468:0x0c1e, B:470:0x0c24, B:470:0x0c24, B:471:0x0c2c, B:471:0x0c2c, B:473:0x0c32, B:473:0x0c32, B:474:0x0c3a, B:474:0x0c3a, B:476:0x0c40, B:476:0x0c40, B:477:0x0c48, B:477:0x0c48, B:479:0x0c4e, B:479:0x0c4e, B:480:0x0c56, B:480:0x0c56, B:482:0x0c5c, B:482:0x0c5c, B:514:0x0d48, B:514:0x0d48, B:520:0x0d6d, B:520:0x0d6d, B:541:0x0dd9, B:541:0x0dd9, B:543:0x0e34, B:543:0x0e34, B:545:0x0e3a, B:545:0x0e3a, B:546:0x0e43, B:546:0x0e43, B:548:0x0e49, B:548:0x0e49, B:550:0x0e4f, B:550:0x0e4f, B:551:0x0e58, B:551:0x0e58, B:553:0x0e5e, B:553:0x0e5e, B:555:0x0e64, B:555:0x0e64, B:556:0x0e6d, B:556:0x0e6d, B:558:0x0e73, B:558:0x0e73, B:560:0x0e79, B:560:0x0e79, B:561:0x0e82, B:561:0x0e82, B:563:0x0e88, B:563:0x0e88, B:565:0x0e8e, B:565:0x0e8e, B:566:0x0e97, B:566:0x0e97, B:568:0x0e9d, B:568:0x0e9d, B:570:0x0ea3, B:570:0x0ea3, B:521:0x0d72, B:521:0x0d72, B:522:0x0d7e, B:522:0x0d7e, B:524:0x0d8a, B:524:0x0d8a, B:525:0x0d92, B:525:0x0d92, B:527:0x0d98, B:527:0x0d98, B:528:0x0da0, B:528:0x0da0, B:530:0x0da6, B:530:0x0da6, B:531:0x0dae, B:531:0x0dae, B:533:0x0db4, B:533:0x0db4, B:534:0x0dbc, B:534:0x0dbc, B:536:0x0dc2, B:536:0x0dc2, B:537:0x0dca, B:537:0x0dca, B:539:0x0dd0, B:539:0x0dd0, B:571:0x0eac, B:571:0x0eac, B:572:0x0eb4, B:572:0x0eb4), top: B:585:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0866 A[Catch: JSONException | Exception -> 0x0ee0, JSONException | Exception -> 0x0ee0, TryCatch #0 {JSONException | Exception -> 0x0ee0, blocks: (B:3:0x000d, B:6:0x002a, B:6:0x002a, B:8:0x0061, B:8:0x0061, B:10:0x0076, B:10:0x0076, B:13:0x00aa, B:13:0x00aa, B:15:0x00b0, B:15:0x00b0, B:35:0x010d, B:35:0x010d, B:37:0x01b1, B:37:0x01b1, B:39:0x01b7, B:39:0x01b7, B:579:0x0ece, B:579:0x0ece, B:582:0x0ed5, B:582:0x0ed5, B:40:0x01c0, B:40:0x01c0, B:42:0x01c6, B:42:0x01c6, B:44:0x01cc, B:44:0x01cc, B:45:0x01d4, B:45:0x01d4, B:47:0x01dc, B:47:0x01dc, B:49:0x01e2, B:49:0x01e2, B:50:0x01ea, B:50:0x01ea, B:52:0x01f2, B:52:0x01f2, B:54:0x01f8, B:54:0x01f8, B:55:0x0200, B:55:0x0200, B:57:0x0208, B:57:0x0208, B:59:0x020e, B:59:0x020e, B:60:0x0216, B:60:0x0216, B:62:0x021e, B:62:0x021e, B:64:0x0224, B:64:0x0224, B:16:0x00b8, B:16:0x00b8, B:18:0x00be, B:18:0x00be, B:19:0x00c6, B:19:0x00c6, B:21:0x00cc, B:21:0x00cc, B:22:0x00d4, B:22:0x00d4, B:24:0x00da, B:24:0x00da, B:25:0x00e2, B:25:0x00e2, B:27:0x00e8, B:27:0x00e8, B:28:0x00f0, B:28:0x00f0, B:30:0x00f6, B:30:0x00f6, B:31:0x00fe, B:31:0x00fe, B:33:0x0104, B:33:0x0104, B:72:0x024d, B:72:0x024d, B:75:0x0260, B:75:0x0260, B:77:0x0268, B:77:0x0268, B:78:0x0270, B:78:0x0270, B:80:0x0276, B:80:0x0276, B:81:0x027e, B:81:0x027e, B:83:0x0284, B:83:0x0284, B:84:0x028c, B:84:0x028c, B:86:0x0292, B:86:0x0292, B:87:0x029a, B:87:0x029a, B:89:0x02a0, B:89:0x02a0, B:90:0x02a8, B:90:0x02a8, B:92:0x02ae, B:92:0x02ae, B:97:0x02ca, B:97:0x02ca, B:99:0x02f2, B:99:0x02f2, B:101:0x02fb, B:101:0x02fb, B:103:0x0317, B:103:0x0317, B:123:0x0374, B:123:0x0374, B:125:0x037a, B:125:0x037a, B:127:0x0380, B:127:0x0380, B:154:0x03f0, B:154:0x03f0, B:129:0x038c, B:129:0x038c, B:131:0x0392, B:131:0x0392, B:133:0x0398, B:133:0x0398, B:134:0x03a0, B:134:0x03a0, B:136:0x03a6, B:136:0x03a6, B:138:0x03ac, B:138:0x03ac, B:139:0x03b4, B:139:0x03b4, B:141:0x03ba, B:141:0x03ba, B:143:0x03c0, B:143:0x03c0, B:144:0x03c8, B:144:0x03c8, B:146:0x03ce, B:146:0x03ce, B:148:0x03d4, B:148:0x03d4, B:149:0x03dc, B:149:0x03dc, B:151:0x03e2, B:151:0x03e2, B:153:0x03e8, B:153:0x03e8, B:104:0x031f, B:104:0x031f, B:106:0x0325, B:106:0x0325, B:107:0x032d, B:107:0x032d, B:109:0x0333, B:109:0x0333, B:110:0x033b, B:110:0x033b, B:112:0x0341, B:112:0x0341, B:113:0x0349, B:113:0x0349, B:115:0x034f, B:115:0x034f, B:116:0x0357, B:116:0x0357, B:118:0x035d, B:118:0x035d, B:119:0x0365, B:119:0x0365, B:121:0x036b, B:121:0x036b, B:157:0x0472, B:157:0x0472, B:159:0x04b3, B:159:0x04b3, B:179:0x0510, B:179:0x0510, B:181:0x0516, B:181:0x0516, B:183:0x051c, B:183:0x051c, B:210:0x058a, B:210:0x058a, B:185:0x0526, B:185:0x0526, B:187:0x052c, B:187:0x052c, B:189:0x0532, B:189:0x0532, B:190:0x053a, B:190:0x053a, B:192:0x0540, B:192:0x0540, B:194:0x0546, B:194:0x0546, B:195:0x054e, B:195:0x054e, B:197:0x0554, B:197:0x0554, B:199:0x055a, B:199:0x055a, B:200:0x0562, B:200:0x0562, B:202:0x0568, B:202:0x0568, B:204:0x056e, B:204:0x056e, B:205:0x0576, B:205:0x0576, B:207:0x057c, B:207:0x057c, B:209:0x0582, B:209:0x0582, B:160:0x04bb, B:160:0x04bb, B:162:0x04c1, B:162:0x04c1, B:163:0x04c9, B:163:0x04c9, B:165:0x04cf, B:165:0x04cf, B:166:0x04d7, B:166:0x04d7, B:168:0x04dd, B:168:0x04dd, B:169:0x04e5, B:169:0x04e5, B:171:0x04eb, B:171:0x04eb, B:172:0x04f3, B:172:0x04f3, B:174:0x04f9, B:174:0x04f9, B:175:0x0501, B:175:0x0501, B:177:0x0507, B:177:0x0507, B:214:0x0602, B:214:0x0602, B:217:0x0614, B:217:0x0614, B:219:0x061a, B:219:0x061a, B:239:0x067c, B:239:0x067c, B:241:0x06c8, B:241:0x06c8, B:243:0x06ce, B:243:0x06ce, B:244:0x06d6, B:244:0x06d6, B:246:0x06dc, B:246:0x06dc, B:248:0x06e2, B:248:0x06e2, B:249:0x06ea, B:249:0x06ea, B:251:0x06f0, B:251:0x06f0, B:253:0x06f6, B:253:0x06f6, B:254:0x06fe, B:254:0x06fe, B:256:0x0704, B:256:0x0704, B:258:0x070a, B:258:0x070a, B:259:0x0712, B:259:0x0712, B:261:0x0718, B:261:0x0718, B:263:0x071e, B:263:0x071e, B:264:0x0726, B:264:0x0726, B:266:0x072c, B:266:0x072c, B:268:0x0732, B:268:0x0732, B:220:0x0625, B:220:0x0625, B:222:0x062d, B:222:0x062d, B:223:0x0635, B:223:0x0635, B:225:0x063b, B:225:0x063b, B:226:0x0643, B:226:0x0643, B:228:0x0649, B:228:0x0649, B:229:0x0651, B:229:0x0651, B:231:0x0657, B:231:0x0657, B:232:0x065f, B:232:0x065f, B:234:0x0665, B:234:0x0665, B:235:0x066d, B:235:0x066d, B:237:0x0673, B:237:0x0673, B:270:0x0740, B:270:0x0740, B:272:0x0754, B:272:0x0754, B:274:0x075a, B:274:0x075a, B:276:0x0760, B:276:0x0760, B:294:0x07b7, B:294:0x07b7, B:296:0x07c7, B:296:0x07c7, B:298:0x07cd, B:298:0x07cd, B:303:0x07e0, B:303:0x07e0, B:305:0x0857, B:305:0x0857, B:307:0x085d, B:307:0x085d, B:308:0x0866, B:308:0x0866, B:310:0x086e, B:310:0x086e, B:312:0x0874, B:312:0x0874, B:313:0x087c, B:313:0x087c, B:315:0x0884, B:315:0x0884, B:317:0x088a, B:317:0x088a, B:318:0x0892, B:318:0x0892, B:320:0x089a, B:320:0x089a, B:322:0x08a0, B:322:0x08a0, B:323:0x08a8, B:323:0x08a8, B:325:0x08b0, B:325:0x08b0, B:327:0x08b6, B:327:0x08b6, B:328:0x08be, B:328:0x08be, B:330:0x08c6, B:330:0x08c6, B:332:0x08cc, B:332:0x08cc, B:278:0x076c, B:278:0x076c, B:280:0x0772, B:280:0x0772, B:281:0x077a, B:281:0x077a, B:283:0x0780, B:283:0x0780, B:284:0x0788, B:284:0x0788, B:286:0x078e, B:286:0x078e, B:287:0x0796, B:287:0x0796, B:289:0x079c, B:289:0x079c, B:290:0x07a4, B:290:0x07a4, B:292:0x07aa, B:292:0x07aa, B:334:0x08dc, B:334:0x08dc, B:336:0x08e8, B:336:0x08e8, B:342:0x0903, B:342:0x0903, B:363:0x096f, B:363:0x096f, B:365:0x09ca, B:365:0x09ca, B:367:0x09d0, B:367:0x09d0, B:368:0x09d8, B:368:0x09d8, B:370:0x09de, B:370:0x09de, B:372:0x09e4, B:372:0x09e4, B:373:0x09ec, B:373:0x09ec, B:375:0x09f2, B:375:0x09f2, B:377:0x09f8, B:377:0x09f8, B:378:0x0a00, B:378:0x0a00, B:380:0x0a06, B:380:0x0a06, B:382:0x0a0c, B:382:0x0a0c, B:383:0x0a14, B:383:0x0a14, B:385:0x0a1a, B:385:0x0a1a, B:387:0x0a20, B:387:0x0a20, B:388:0x0a28, B:388:0x0a28, B:390:0x0a2e, B:390:0x0a2e, B:392:0x0a34, B:392:0x0a34, B:343:0x0908, B:343:0x0908, B:344:0x0914, B:344:0x0914, B:346:0x0920, B:346:0x0920, B:347:0x0928, B:347:0x0928, B:349:0x092e, B:349:0x092e, B:350:0x0936, B:350:0x0936, B:352:0x093c, B:352:0x093c, B:353:0x0944, B:353:0x0944, B:355:0x094a, B:355:0x094a, B:356:0x0952, B:356:0x0952, B:358:0x0958, B:358:0x0958, B:359:0x0960, B:359:0x0960, B:361:0x0966, B:361:0x0966, B:394:0x0a3e, B:394:0x0a3e, B:396:0x0a50, B:396:0x0a50, B:402:0x0a6b, B:402:0x0a6b, B:423:0x0ad7, B:423:0x0ad7, B:425:0x0b32, B:425:0x0b32, B:427:0x0b38, B:427:0x0b38, B:428:0x0b40, B:428:0x0b40, B:430:0x0b46, B:430:0x0b46, B:432:0x0b4c, B:432:0x0b4c, B:433:0x0b54, B:433:0x0b54, B:435:0x0b5a, B:435:0x0b5a, B:437:0x0b60, B:437:0x0b60, B:438:0x0b68, B:438:0x0b68, B:440:0x0b6e, B:440:0x0b6e, B:442:0x0b74, B:442:0x0b74, B:443:0x0b7c, B:443:0x0b7c, B:445:0x0b82, B:445:0x0b82, B:447:0x0b88, B:447:0x0b88, B:448:0x0b90, B:448:0x0b90, B:450:0x0b96, B:450:0x0b96, B:452:0x0b9c, B:452:0x0b9c, B:403:0x0a70, B:403:0x0a70, B:404:0x0a7c, B:404:0x0a7c, B:406:0x0a88, B:406:0x0a88, B:407:0x0a90, B:407:0x0a90, B:409:0x0a96, B:409:0x0a96, B:410:0x0a9e, B:410:0x0a9e, B:412:0x0aa4, B:412:0x0aa4, B:413:0x0aac, B:413:0x0aac, B:415:0x0ab2, B:415:0x0ab2, B:416:0x0aba, B:416:0x0aba, B:418:0x0ac0, B:418:0x0ac0, B:419:0x0ac8, B:419:0x0ac8, B:421:0x0ace, B:421:0x0ace, B:454:0x0ba8, B:454:0x0ba8, B:456:0x0bba, B:456:0x0bba, B:462:0x0bf7, B:462:0x0bf7, B:484:0x0c65, B:484:0x0c65, B:486:0x0cd0, B:486:0x0cd0, B:488:0x0cd6, B:488:0x0cd6, B:489:0x0cdf, B:489:0x0cdf, B:491:0x0ce5, B:491:0x0ce5, B:493:0x0ceb, B:493:0x0ceb, B:494:0x0cf4, B:494:0x0cf4, B:496:0x0cfa, B:496:0x0cfa, B:498:0x0d00, B:498:0x0d00, B:499:0x0d09, B:499:0x0d09, B:501:0x0d0f, B:501:0x0d0f, B:503:0x0d15, B:503:0x0d15, B:504:0x0d1e, B:504:0x0d1e, B:506:0x0d24, B:506:0x0d24, B:508:0x0d2a, B:508:0x0d2a, B:509:0x0d33, B:509:0x0d33, B:511:0x0d39, B:511:0x0d39, B:513:0x0d3f, B:513:0x0d3f, B:463:0x0bfc, B:463:0x0bfc, B:465:0x0c0c, B:465:0x0c0c, B:467:0x0c16, B:467:0x0c16, B:468:0x0c1e, B:468:0x0c1e, B:470:0x0c24, B:470:0x0c24, B:471:0x0c2c, B:471:0x0c2c, B:473:0x0c32, B:473:0x0c32, B:474:0x0c3a, B:474:0x0c3a, B:476:0x0c40, B:476:0x0c40, B:477:0x0c48, B:477:0x0c48, B:479:0x0c4e, B:479:0x0c4e, B:480:0x0c56, B:480:0x0c56, B:482:0x0c5c, B:482:0x0c5c, B:514:0x0d48, B:514:0x0d48, B:520:0x0d6d, B:520:0x0d6d, B:541:0x0dd9, B:541:0x0dd9, B:543:0x0e34, B:543:0x0e34, B:545:0x0e3a, B:545:0x0e3a, B:546:0x0e43, B:546:0x0e43, B:548:0x0e49, B:548:0x0e49, B:550:0x0e4f, B:550:0x0e4f, B:551:0x0e58, B:551:0x0e58, B:553:0x0e5e, B:553:0x0e5e, B:555:0x0e64, B:555:0x0e64, B:556:0x0e6d, B:556:0x0e6d, B:558:0x0e73, B:558:0x0e73, B:560:0x0e79, B:560:0x0e79, B:561:0x0e82, B:561:0x0e82, B:563:0x0e88, B:563:0x0e88, B:565:0x0e8e, B:565:0x0e8e, B:566:0x0e97, B:566:0x0e97, B:568:0x0e9d, B:568:0x0e9d, B:570:0x0ea3, B:570:0x0ea3, B:521:0x0d72, B:521:0x0d72, B:522:0x0d7e, B:522:0x0d7e, B:524:0x0d8a, B:524:0x0d8a, B:525:0x0d92, B:525:0x0d92, B:527:0x0d98, B:527:0x0d98, B:528:0x0da0, B:528:0x0da0, B:530:0x0da6, B:530:0x0da6, B:531:0x0dae, B:531:0x0dae, B:533:0x0db4, B:533:0x0db4, B:534:0x0dbc, B:534:0x0dbc, B:536:0x0dc2, B:536:0x0dc2, B:537:0x0dca, B:537:0x0dca, B:539:0x0dd0, B:539:0x0dd0, B:571:0x0eac, B:571:0x0eac, B:572:0x0eb4, B:572:0x0eb4), top: B:585:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:577:0x0ec8 A[Catch: JSONException | Exception -> 0x0ed2, JSONException | Exception -> 0x0ed2, TRY_ENTER, TRY_LEAVE, TryCatch #1 {JSONException | Exception -> 0x0ed2, blocks: (B:577:0x0ec8, B:577:0x0ec8, B:338:0x08ee, B:340:0x08fb, B:398:0x0a56, B:398:0x0a56, B:400:0x0a63, B:400:0x0a63, B:516:0x0d58, B:516:0x0d58, B:518:0x0d65, B:518:0x0d65), top: B:586:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0ed5 A[Catch: JSONException | Exception -> 0x0ee0, JSONException | Exception -> 0x0ee0, TRY_LEAVE, TryCatch #0 {JSONException | Exception -> 0x0ee0, blocks: (B:3:0x000d, B:6:0x002a, B:6:0x002a, B:8:0x0061, B:8:0x0061, B:10:0x0076, B:10:0x0076, B:13:0x00aa, B:13:0x00aa, B:15:0x00b0, B:15:0x00b0, B:35:0x010d, B:35:0x010d, B:37:0x01b1, B:37:0x01b1, B:39:0x01b7, B:39:0x01b7, B:579:0x0ece, B:579:0x0ece, B:582:0x0ed5, B:582:0x0ed5, B:40:0x01c0, B:40:0x01c0, B:42:0x01c6, B:42:0x01c6, B:44:0x01cc, B:44:0x01cc, B:45:0x01d4, B:45:0x01d4, B:47:0x01dc, B:47:0x01dc, B:49:0x01e2, B:49:0x01e2, B:50:0x01ea, B:50:0x01ea, B:52:0x01f2, B:52:0x01f2, B:54:0x01f8, B:54:0x01f8, B:55:0x0200, B:55:0x0200, B:57:0x0208, B:57:0x0208, B:59:0x020e, B:59:0x020e, B:60:0x0216, B:60:0x0216, B:62:0x021e, B:62:0x021e, B:64:0x0224, B:64:0x0224, B:16:0x00b8, B:16:0x00b8, B:18:0x00be, B:18:0x00be, B:19:0x00c6, B:19:0x00c6, B:21:0x00cc, B:21:0x00cc, B:22:0x00d4, B:22:0x00d4, B:24:0x00da, B:24:0x00da, B:25:0x00e2, B:25:0x00e2, B:27:0x00e8, B:27:0x00e8, B:28:0x00f0, B:28:0x00f0, B:30:0x00f6, B:30:0x00f6, B:31:0x00fe, B:31:0x00fe, B:33:0x0104, B:33:0x0104, B:72:0x024d, B:72:0x024d, B:75:0x0260, B:75:0x0260, B:77:0x0268, B:77:0x0268, B:78:0x0270, B:78:0x0270, B:80:0x0276, B:80:0x0276, B:81:0x027e, B:81:0x027e, B:83:0x0284, B:83:0x0284, B:84:0x028c, B:84:0x028c, B:86:0x0292, B:86:0x0292, B:87:0x029a, B:87:0x029a, B:89:0x02a0, B:89:0x02a0, B:90:0x02a8, B:90:0x02a8, B:92:0x02ae, B:92:0x02ae, B:97:0x02ca, B:97:0x02ca, B:99:0x02f2, B:99:0x02f2, B:101:0x02fb, B:101:0x02fb, B:103:0x0317, B:103:0x0317, B:123:0x0374, B:123:0x0374, B:125:0x037a, B:125:0x037a, B:127:0x0380, B:127:0x0380, B:154:0x03f0, B:154:0x03f0, B:129:0x038c, B:129:0x038c, B:131:0x0392, B:131:0x0392, B:133:0x0398, B:133:0x0398, B:134:0x03a0, B:134:0x03a0, B:136:0x03a6, B:136:0x03a6, B:138:0x03ac, B:138:0x03ac, B:139:0x03b4, B:139:0x03b4, B:141:0x03ba, B:141:0x03ba, B:143:0x03c0, B:143:0x03c0, B:144:0x03c8, B:144:0x03c8, B:146:0x03ce, B:146:0x03ce, B:148:0x03d4, B:148:0x03d4, B:149:0x03dc, B:149:0x03dc, B:151:0x03e2, B:151:0x03e2, B:153:0x03e8, B:153:0x03e8, B:104:0x031f, B:104:0x031f, B:106:0x0325, B:106:0x0325, B:107:0x032d, B:107:0x032d, B:109:0x0333, B:109:0x0333, B:110:0x033b, B:110:0x033b, B:112:0x0341, B:112:0x0341, B:113:0x0349, B:113:0x0349, B:115:0x034f, B:115:0x034f, B:116:0x0357, B:116:0x0357, B:118:0x035d, B:118:0x035d, B:119:0x0365, B:119:0x0365, B:121:0x036b, B:121:0x036b, B:157:0x0472, B:157:0x0472, B:159:0x04b3, B:159:0x04b3, B:179:0x0510, B:179:0x0510, B:181:0x0516, B:181:0x0516, B:183:0x051c, B:183:0x051c, B:210:0x058a, B:210:0x058a, B:185:0x0526, B:185:0x0526, B:187:0x052c, B:187:0x052c, B:189:0x0532, B:189:0x0532, B:190:0x053a, B:190:0x053a, B:192:0x0540, B:192:0x0540, B:194:0x0546, B:194:0x0546, B:195:0x054e, B:195:0x054e, B:197:0x0554, B:197:0x0554, B:199:0x055a, B:199:0x055a, B:200:0x0562, B:200:0x0562, B:202:0x0568, B:202:0x0568, B:204:0x056e, B:204:0x056e, B:205:0x0576, B:205:0x0576, B:207:0x057c, B:207:0x057c, B:209:0x0582, B:209:0x0582, B:160:0x04bb, B:160:0x04bb, B:162:0x04c1, B:162:0x04c1, B:163:0x04c9, B:163:0x04c9, B:165:0x04cf, B:165:0x04cf, B:166:0x04d7, B:166:0x04d7, B:168:0x04dd, B:168:0x04dd, B:169:0x04e5, B:169:0x04e5, B:171:0x04eb, B:171:0x04eb, B:172:0x04f3, B:172:0x04f3, B:174:0x04f9, B:174:0x04f9, B:175:0x0501, B:175:0x0501, B:177:0x0507, B:177:0x0507, B:214:0x0602, B:214:0x0602, B:217:0x0614, B:217:0x0614, B:219:0x061a, B:219:0x061a, B:239:0x067c, B:239:0x067c, B:241:0x06c8, B:241:0x06c8, B:243:0x06ce, B:243:0x06ce, B:244:0x06d6, B:244:0x06d6, B:246:0x06dc, B:246:0x06dc, B:248:0x06e2, B:248:0x06e2, B:249:0x06ea, B:249:0x06ea, B:251:0x06f0, B:251:0x06f0, B:253:0x06f6, B:253:0x06f6, B:254:0x06fe, B:254:0x06fe, B:256:0x0704, B:256:0x0704, B:258:0x070a, B:258:0x070a, B:259:0x0712, B:259:0x0712, B:261:0x0718, B:261:0x0718, B:263:0x071e, B:263:0x071e, B:264:0x0726, B:264:0x0726, B:266:0x072c, B:266:0x072c, B:268:0x0732, B:268:0x0732, B:220:0x0625, B:220:0x0625, B:222:0x062d, B:222:0x062d, B:223:0x0635, B:223:0x0635, B:225:0x063b, B:225:0x063b, B:226:0x0643, B:226:0x0643, B:228:0x0649, B:228:0x0649, B:229:0x0651, B:229:0x0651, B:231:0x0657, B:231:0x0657, B:232:0x065f, B:232:0x065f, B:234:0x0665, B:234:0x0665, B:235:0x066d, B:235:0x066d, B:237:0x0673, B:237:0x0673, B:270:0x0740, B:270:0x0740, B:272:0x0754, B:272:0x0754, B:274:0x075a, B:274:0x075a, B:276:0x0760, B:276:0x0760, B:294:0x07b7, B:294:0x07b7, B:296:0x07c7, B:296:0x07c7, B:298:0x07cd, B:298:0x07cd, B:303:0x07e0, B:303:0x07e0, B:305:0x0857, B:305:0x0857, B:307:0x085d, B:307:0x085d, B:308:0x0866, B:308:0x0866, B:310:0x086e, B:310:0x086e, B:312:0x0874, B:312:0x0874, B:313:0x087c, B:313:0x087c, B:315:0x0884, B:315:0x0884, B:317:0x088a, B:317:0x088a, B:318:0x0892, B:318:0x0892, B:320:0x089a, B:320:0x089a, B:322:0x08a0, B:322:0x08a0, B:323:0x08a8, B:323:0x08a8, B:325:0x08b0, B:325:0x08b0, B:327:0x08b6, B:327:0x08b6, B:328:0x08be, B:328:0x08be, B:330:0x08c6, B:330:0x08c6, B:332:0x08cc, B:332:0x08cc, B:278:0x076c, B:278:0x076c, B:280:0x0772, B:280:0x0772, B:281:0x077a, B:281:0x077a, B:283:0x0780, B:283:0x0780, B:284:0x0788, B:284:0x0788, B:286:0x078e, B:286:0x078e, B:287:0x0796, B:287:0x0796, B:289:0x079c, B:289:0x079c, B:290:0x07a4, B:290:0x07a4, B:292:0x07aa, B:292:0x07aa, B:334:0x08dc, B:334:0x08dc, B:336:0x08e8, B:336:0x08e8, B:342:0x0903, B:342:0x0903, B:363:0x096f, B:363:0x096f, B:365:0x09ca, B:365:0x09ca, B:367:0x09d0, B:367:0x09d0, B:368:0x09d8, B:368:0x09d8, B:370:0x09de, B:370:0x09de, B:372:0x09e4, B:372:0x09e4, B:373:0x09ec, B:373:0x09ec, B:375:0x09f2, B:375:0x09f2, B:377:0x09f8, B:377:0x09f8, B:378:0x0a00, B:378:0x0a00, B:380:0x0a06, B:380:0x0a06, B:382:0x0a0c, B:382:0x0a0c, B:383:0x0a14, B:383:0x0a14, B:385:0x0a1a, B:385:0x0a1a, B:387:0x0a20, B:387:0x0a20, B:388:0x0a28, B:388:0x0a28, B:390:0x0a2e, B:390:0x0a2e, B:392:0x0a34, B:392:0x0a34, B:343:0x0908, B:343:0x0908, B:344:0x0914, B:344:0x0914, B:346:0x0920, B:346:0x0920, B:347:0x0928, B:347:0x0928, B:349:0x092e, B:349:0x092e, B:350:0x0936, B:350:0x0936, B:352:0x093c, B:352:0x093c, B:353:0x0944, B:353:0x0944, B:355:0x094a, B:355:0x094a, B:356:0x0952, B:356:0x0952, B:358:0x0958, B:358:0x0958, B:359:0x0960, B:359:0x0960, B:361:0x0966, B:361:0x0966, B:394:0x0a3e, B:394:0x0a3e, B:396:0x0a50, B:396:0x0a50, B:402:0x0a6b, B:402:0x0a6b, B:423:0x0ad7, B:423:0x0ad7, B:425:0x0b32, B:425:0x0b32, B:427:0x0b38, B:427:0x0b38, B:428:0x0b40, B:428:0x0b40, B:430:0x0b46, B:430:0x0b46, B:432:0x0b4c, B:432:0x0b4c, B:433:0x0b54, B:433:0x0b54, B:435:0x0b5a, B:435:0x0b5a, B:437:0x0b60, B:437:0x0b60, B:438:0x0b68, B:438:0x0b68, B:440:0x0b6e, B:440:0x0b6e, B:442:0x0b74, B:442:0x0b74, B:443:0x0b7c, B:443:0x0b7c, B:445:0x0b82, B:445:0x0b82, B:447:0x0b88, B:447:0x0b88, B:448:0x0b90, B:448:0x0b90, B:450:0x0b96, B:450:0x0b96, B:452:0x0b9c, B:452:0x0b9c, B:403:0x0a70, B:403:0x0a70, B:404:0x0a7c, B:404:0x0a7c, B:406:0x0a88, B:406:0x0a88, B:407:0x0a90, B:407:0x0a90, B:409:0x0a96, B:409:0x0a96, B:410:0x0a9e, B:410:0x0a9e, B:412:0x0aa4, B:412:0x0aa4, B:413:0x0aac, B:413:0x0aac, B:415:0x0ab2, B:415:0x0ab2, B:416:0x0aba, B:416:0x0aba, B:418:0x0ac0, B:418:0x0ac0, B:419:0x0ac8, B:419:0x0ac8, B:421:0x0ace, B:421:0x0ace, B:454:0x0ba8, B:454:0x0ba8, B:456:0x0bba, B:456:0x0bba, B:462:0x0bf7, B:462:0x0bf7, B:484:0x0c65, B:484:0x0c65, B:486:0x0cd0, B:486:0x0cd0, B:488:0x0cd6, B:488:0x0cd6, B:489:0x0cdf, B:489:0x0cdf, B:491:0x0ce5, B:491:0x0ce5, B:493:0x0ceb, B:493:0x0ceb, B:494:0x0cf4, B:494:0x0cf4, B:496:0x0cfa, B:496:0x0cfa, B:498:0x0d00, B:498:0x0d00, B:499:0x0d09, B:499:0x0d09, B:501:0x0d0f, B:501:0x0d0f, B:503:0x0d15, B:503:0x0d15, B:504:0x0d1e, B:504:0x0d1e, B:506:0x0d24, B:506:0x0d24, B:508:0x0d2a, B:508:0x0d2a, B:509:0x0d33, B:509:0x0d33, B:511:0x0d39, B:511:0x0d39, B:513:0x0d3f, B:513:0x0d3f, B:463:0x0bfc, B:463:0x0bfc, B:465:0x0c0c, B:465:0x0c0c, B:467:0x0c16, B:467:0x0c16, B:468:0x0c1e, B:468:0x0c1e, B:470:0x0c24, B:470:0x0c24, B:471:0x0c2c, B:471:0x0c2c, B:473:0x0c32, B:473:0x0c32, B:474:0x0c3a, B:474:0x0c3a, B:476:0x0c40, B:476:0x0c40, B:477:0x0c48, B:477:0x0c48, B:479:0x0c4e, B:479:0x0c4e, B:480:0x0c56, B:480:0x0c56, B:482:0x0c5c, B:482:0x0c5c, B:514:0x0d48, B:514:0x0d48, B:520:0x0d6d, B:520:0x0d6d, B:541:0x0dd9, B:541:0x0dd9, B:543:0x0e34, B:543:0x0e34, B:545:0x0e3a, B:545:0x0e3a, B:546:0x0e43, B:546:0x0e43, B:548:0x0e49, B:548:0x0e49, B:550:0x0e4f, B:550:0x0e4f, B:551:0x0e58, B:551:0x0e58, B:553:0x0e5e, B:553:0x0e5e, B:555:0x0e64, B:555:0x0e64, B:556:0x0e6d, B:556:0x0e6d, B:558:0x0e73, B:558:0x0e73, B:560:0x0e79, B:560:0x0e79, B:561:0x0e82, B:561:0x0e82, B:563:0x0e88, B:563:0x0e88, B:565:0x0e8e, B:565:0x0e8e, B:566:0x0e97, B:566:0x0e97, B:568:0x0e9d, B:568:0x0e9d, B:570:0x0ea3, B:570:0x0ea3, B:521:0x0d72, B:521:0x0d72, B:522:0x0d7e, B:522:0x0d7e, B:524:0x0d8a, B:524:0x0d8a, B:525:0x0d92, B:525:0x0d92, B:527:0x0d98, B:527:0x0d98, B:528:0x0da0, B:528:0x0da0, B:530:0x0da6, B:530:0x0da6, B:531:0x0dae, B:531:0x0dae, B:533:0x0db4, B:533:0x0db4, B:534:0x0dbc, B:534:0x0dbc, B:536:0x0dc2, B:536:0x0dc2, B:537:0x0dca, B:537:0x0dca, B:539:0x0dd0, B:539:0x0dd0, B:571:0x0eac, B:571:0x0eac, B:572:0x0eb4, B:572:0x0eb4), top: B:585:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleDataMessage(org.json.JSONObject r54) {
        /*
            Method dump skipped, instruction units count: 3809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.Service.MyFirebaseMessagingService.handleDataMessage(org.json.JSONObject):void");
    }

    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        this.notificationUtils = new NotificationUtils(context);
        intent.setFlags(268468224);
        this.notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
    }

    private void showNotificationMessageWithBigImage(Context context, String title, String message, String timeStamp, Intent intent, String imageUrl) {
        this.notificationUtils = new NotificationUtils(context);
        intent.setFlags(268468224);
        this.notificationUtils.showNotificationMessage(title, message, timeStamp, intent, imageUrl);
    }

    public void getLogoutDialog(final Context ctx, final String title, final String message) {
        Helper.SignOutUser(ctx);
    }

    private Spanned getSpannedText(String htmlText) {
        return TextUtils.isEmpty(htmlText) ? new SpannableString("") : Html.fromHtml(htmlText, 0);
    }

    public void showNotification(int requestCode, String pushMessage, String pushTitle, Intent intent, String url, String imageUrl, String message_target) {
        boolean z;
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            Log.d("NotificationSound", "CASE 2: Notifications are OFF in system settings — skipping notification.");
            return;
        }
        Spanned spannedText = getSpannedText(pushTitle);
        Spanned spannedText2 = getSpannedText(pushMessage);
        int iNextInt = new Random().nextInt(10000);
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this, requestCode, intent, 201326592);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("EDUTERIAEnglisApp");
        if (notificationChannel != null && (notificationChannel.getImportance() < 3 || notificationChannel.getSound() == null)) {
            Log.d("NotificationSound", "CASE 3: Channel is SILENT (via system settings). Will show notification without sound.(Pending)");
            z = true;
        } else {
            Log.d("NotificationSound", "CASE 1: Channel is ACTIVE with sound.");
            z = false;
        }
        NotificationCompat.Builder onlyAlertOnce = new NotificationCompat.Builder(this, "EDUTERIAEnglisApp").setAutoCancel(true).setColor(getApplicationContext().getResources().getColor(R.color.colorPrimaryDark)).setContentIntent(activity).setOnlyAlertOnce(true);
        if (Build.VERSION.SDK_INT >= 33) {
            onlyAlertOnce.setSmallIcon(R.drawable.notification_icon_primary);
        } else {
            onlyAlertOnce.setSmallIcon(R.mipmap.ic_launcher);
        }
        if (!z) {
            onlyAlertOnce.setSound(RingtoneManager.getDefaultUri(2));
            onlyAlertOnce.setPriority(1);
            onlyAlertOnce.setVibrate(new long[]{500, 500, 500, 500, 500});
        } else {
            onlyAlertOnce.setSound(null);
            onlyAlertOnce.setPriority(-1);
            onlyAlertOnce.setDefaults(0);
            onlyAlertOnce.setVibrate(new long[]{0});
            onlyAlertOnce.setOnlyAlertOnce(true);
            onlyAlertOnce.setCategory("msg");
        }
        if ((message_target.equals("1") || message_target.equals("2") || message_target.equals("5") || message_target.equals("6")) && !TextUtils.isEmpty(imageUrl)) {
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.small_custom_notification_layout);
            RemoteViews remoteViews2 = new RemoteViews(getPackageName(), R.layout.notification_custom_layout);
            remoteViews.setTextViewText(R.id.title, spannedText);
            remoteViews.setTextViewText(R.id.msg, spannedText2);
            remoteViews.setImageViewResource(R.id.notificationIV, R.mipmap.ic_launcher);
            remoteViews2.setTextViewText(R.id.title, spannedText);
            remoteViews2.setTextViewText(R.id.msg, spannedText2);
            remoteViews2.setImageViewResource(R.id.notificationIV, R.mipmap.ic_launcher);
            if (!TextUtils.isEmpty(imageUrl)) {
                Bitmap bitmapLoadBitmapFromUrl = loadBitmapFromUrl(imageUrl);
                remoteViews.setImageViewBitmap(R.id.notificationIV, bitmapLoadBitmapFromUrl);
                remoteViews2.setImageViewBitmap(R.id.notificationIV, bitmapLoadBitmapFromUrl);
            }
            onlyAlertOnce.setCustomContentView(remoteViews).setCustomBigContentView(remoteViews2).setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        } else {
            onlyAlertOnce.setContentTitle(spannedText).setContentText(spannedText2).setStyle(new NotificationCompat.BigTextStyle().bigText(spannedText2));
            if (!TextUtils.isEmpty(imageUrl)) {
                onlyAlertOnce.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(loadBitmapFromUrl(imageUrl)));
            }
        }
        notificationManager.notify(iNextInt, onlyAlertOnce.build());
        ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
    }

    private Bitmap loadBitmapFromUrl(String imageUrl) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(imageUrl).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            int i = getResources().getDisplayMetrics().widthPixels;
            return Bitmap.createScaledBitmap(bitmapDecodeStream, i, (bitmapDecodeStream.getHeight() * i) / bitmapDecodeStream.getWidth(), true);
        } catch (IOException unused) {
            return BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        }
    }

    private void pushEvent(String notification_code) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        if (TextUtils.isEmpty(notification_code)) {
            notification_code = "NA";
        }
        map.put(AnalyticsConstants.push_preview, notification_code);
        map.put("action_type", "notification_delivered");
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.PUSH_NOTIFICATION, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0315 A[Catch: JSONException -> 0x07ed, TryCatch #2 {JSONException -> 0x07ed, blocks: (B:16:0x00bd, B:19:0x0106, B:21:0x010c, B:41:0x016d, B:43:0x01ab, B:45:0x01b1, B:316:0x0792, B:46:0x01b9, B:48:0x01bf, B:50:0x01c5, B:51:0x01cd, B:53:0x01d3, B:55:0x01d9, B:56:0x01e1, B:58:0x01e7, B:60:0x01ed, B:61:0x01f5, B:63:0x01fb, B:65:0x0201, B:66:0x0209, B:68:0x020f, B:70:0x0215, B:22:0x0116, B:24:0x011e, B:25:0x0126, B:27:0x012c, B:28:0x0134, B:30:0x013a, B:31:0x0142, B:33:0x0148, B:34:0x0150, B:36:0x0156, B:37:0x015e, B:39:0x0164, B:72:0x022a, B:74:0x023c, B:76:0x0242, B:78:0x0248, B:95:0x0297, B:97:0x029d, B:99:0x02a3, B:104:0x02b8, B:106:0x0315, B:108:0x031b, B:109:0x0324, B:111:0x032a, B:113:0x0330, B:114:0x0338, B:116:0x033e, B:118:0x0344, B:119:0x034c, B:121:0x0354, B:123:0x035a, B:124:0x0362, B:126:0x036a, B:128:0x0370, B:129:0x0378, B:131:0x0380, B:133:0x0386, B:79:0x0250, B:81:0x0256, B:82:0x025e, B:84:0x0264, B:85:0x026c, B:87:0x0272, B:88:0x027a, B:90:0x0280, B:91:0x0288, B:93:0x028e, B:135:0x039e, B:144:0x03c8, B:168:0x0433, B:170:0x0481, B:172:0x0487, B:173:0x048f, B:175:0x0495, B:177:0x049b, B:178:0x04a3, B:180:0x04a9, B:182:0x04af, B:183:0x04b7, B:185:0x04bd, B:187:0x04c3, B:188:0x04cb, B:190:0x04d1, B:192:0x04d7, B:193:0x04df, B:195:0x04e5, B:197:0x04eb, B:145:0x03cc, B:149:0x03dc, B:151:0x03e4, B:152:0x03ec, B:154:0x03f2, B:155:0x03fa, B:157:0x0400, B:158:0x0408, B:160:0x040e, B:161:0x0416, B:163:0x041c, B:164:0x0424, B:166:0x042a, B:202:0x0500, B:204:0x051a, B:206:0x0520, B:208:0x0526, B:229:0x058b, B:231:0x05db, B:233:0x05e1, B:234:0x05e9, B:236:0x05ef, B:238:0x05f5, B:239:0x05fd, B:241:0x0603, B:243:0x0609, B:244:0x0611, B:246:0x0617, B:248:0x061d, B:249:0x0625, B:251:0x062b, B:253:0x0631, B:254:0x0639, B:256:0x063f, B:258:0x0645, B:209:0x052e, B:210:0x0536, B:212:0x053c, B:213:0x0544, B:215:0x054a, B:216:0x0552, B:218:0x0558, B:219:0x0560, B:221:0x0566, B:222:0x056e, B:224:0x0574, B:225:0x057c, B:227:0x0582, B:260:0x0651, B:262:0x0665, B:264:0x066b, B:285:0x06d0, B:287:0x0720, B:289:0x0726, B:290:0x072e, B:292:0x0734, B:294:0x073a, B:295:0x0742, B:297:0x0748, B:299:0x074e, B:300:0x0756, B:302:0x075c, B:304:0x0762, B:305:0x076a, B:307:0x0770, B:309:0x0776, B:310:0x077e, B:312:0x0784, B:314:0x078a, B:265:0x0673, B:266:0x067b, B:268:0x0681, B:269:0x0689, B:271:0x068f, B:272:0x0697, B:274:0x069d, B:275:0x06a5, B:277:0x06ab, B:278:0x06b3, B:280:0x06b9, B:281:0x06c1, B:283:0x06c7, B:318:0x07e4, B:319:0x07ec), top: B:327:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0324 A[Catch: JSONException -> 0x07ed, TryCatch #2 {JSONException -> 0x07ed, blocks: (B:16:0x00bd, B:19:0x0106, B:21:0x010c, B:41:0x016d, B:43:0x01ab, B:45:0x01b1, B:316:0x0792, B:46:0x01b9, B:48:0x01bf, B:50:0x01c5, B:51:0x01cd, B:53:0x01d3, B:55:0x01d9, B:56:0x01e1, B:58:0x01e7, B:60:0x01ed, B:61:0x01f5, B:63:0x01fb, B:65:0x0201, B:66:0x0209, B:68:0x020f, B:70:0x0215, B:22:0x0116, B:24:0x011e, B:25:0x0126, B:27:0x012c, B:28:0x0134, B:30:0x013a, B:31:0x0142, B:33:0x0148, B:34:0x0150, B:36:0x0156, B:37:0x015e, B:39:0x0164, B:72:0x022a, B:74:0x023c, B:76:0x0242, B:78:0x0248, B:95:0x0297, B:97:0x029d, B:99:0x02a3, B:104:0x02b8, B:106:0x0315, B:108:0x031b, B:109:0x0324, B:111:0x032a, B:113:0x0330, B:114:0x0338, B:116:0x033e, B:118:0x0344, B:119:0x034c, B:121:0x0354, B:123:0x035a, B:124:0x0362, B:126:0x036a, B:128:0x0370, B:129:0x0378, B:131:0x0380, B:133:0x0386, B:79:0x0250, B:81:0x0256, B:82:0x025e, B:84:0x0264, B:85:0x026c, B:87:0x0272, B:88:0x027a, B:90:0x0280, B:91:0x0288, B:93:0x028e, B:135:0x039e, B:144:0x03c8, B:168:0x0433, B:170:0x0481, B:172:0x0487, B:173:0x048f, B:175:0x0495, B:177:0x049b, B:178:0x04a3, B:180:0x04a9, B:182:0x04af, B:183:0x04b7, B:185:0x04bd, B:187:0x04c3, B:188:0x04cb, B:190:0x04d1, B:192:0x04d7, B:193:0x04df, B:195:0x04e5, B:197:0x04eb, B:145:0x03cc, B:149:0x03dc, B:151:0x03e4, B:152:0x03ec, B:154:0x03f2, B:155:0x03fa, B:157:0x0400, B:158:0x0408, B:160:0x040e, B:161:0x0416, B:163:0x041c, B:164:0x0424, B:166:0x042a, B:202:0x0500, B:204:0x051a, B:206:0x0520, B:208:0x0526, B:229:0x058b, B:231:0x05db, B:233:0x05e1, B:234:0x05e9, B:236:0x05ef, B:238:0x05f5, B:239:0x05fd, B:241:0x0603, B:243:0x0609, B:244:0x0611, B:246:0x0617, B:248:0x061d, B:249:0x0625, B:251:0x062b, B:253:0x0631, B:254:0x0639, B:256:0x063f, B:258:0x0645, B:209:0x052e, B:210:0x0536, B:212:0x053c, B:213:0x0544, B:215:0x054a, B:216:0x0552, B:218:0x0558, B:219:0x0560, B:221:0x0566, B:222:0x056e, B:224:0x0574, B:225:0x057c, B:227:0x0582, B:260:0x0651, B:262:0x0665, B:264:0x066b, B:285:0x06d0, B:287:0x0720, B:289:0x0726, B:290:0x072e, B:292:0x0734, B:294:0x073a, B:295:0x0742, B:297:0x0748, B:299:0x074e, B:300:0x0756, B:302:0x075c, B:304:0x0762, B:305:0x076a, B:307:0x0770, B:309:0x0776, B:310:0x077e, B:312:0x0784, B:314:0x078a, B:265:0x0673, B:266:0x067b, B:268:0x0681, B:269:0x0689, B:271:0x068f, B:272:0x0697, B:274:0x069d, B:275:0x06a5, B:277:0x06ab, B:278:0x06b3, B:280:0x06b9, B:281:0x06c1, B:283:0x06c7, B:318:0x07e4, B:319:0x07ec), top: B:327:0x00bd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleGeneralNotificationData(java.util.Map<java.lang.String, java.lang.String> r46) {
        /*
            Method dump skipped, instruction units count: 2055
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.Service.MyFirebaseMessagingService.handleGeneralNotificationData(java.util.Map):void");
    }

    private boolean logutuser() {
        return MakeMyExam.userId == null || MakeMyExam.userId.equalsIgnoreCase("") || SharedPreference.getInstance().getLoggedInUser() == null || SharedPreference.getInstance().getLoggedInUser().getId() == null;
    }
}
