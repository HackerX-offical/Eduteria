package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseError;
import com.google.zxing.client.android.Intents;
import java.util.Arrays;
import java.util.List;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzy {
    public static Status zza(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new Status(FirebaseError.ERROR_INTERNAL_ERROR);
        }
        String[] strArrSplit = str.split(":", 2);
        strArrSplit[0] = strArrSplit[0].trim();
        if (strArrSplit.length > 1 && (str2 = strArrSplit[1]) != null) {
            strArrSplit[1] = str2.trim();
        }
        List listAsList = Arrays.asList(strArrSplit);
        return listAsList.size() > 1 ? zza((String) listAsList.get(0), (String) listAsList.get(1)) : zza((String) listAsList.get(0), null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Status zza(String str, String str2) {
        int i;
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -2130504259:
                if (str.equals("USER_CANCELLED")) {
                    b2 = 0;
                }
                break;
            case -2065866930:
                if (str.equals("INVALID_RECIPIENT_EMAIL")) {
                    b2 = 1;
                }
                break;
            case -2014808264:
                if (str.equals("WEB_CONTEXT_ALREADY_PRESENTED")) {
                    b2 = 2;
                }
                break;
            case -2005236790:
                if (str.equals("INTERNAL_SUCCESS_SIGN_OUT")) {
                    b2 = 3;
                }
                break;
            case -2001169389:
                if (str.equals("INVALID_IDP_RESPONSE")) {
                    b2 = 4;
                }
                break;
            case -1944433728:
                if (str.equals("DYNAMIC_LINK_NOT_ACTIVATED")) {
                    b2 = 5;
                }
                break;
            case -1800638118:
                if (str.equals("QUOTA_EXCEEDED")) {
                    b2 = 6;
                }
                break;
            case -1774756919:
                if (str.equals("WEB_NETWORK_REQUEST_FAILED")) {
                    b2 = 7;
                }
                break;
            case -1587614300:
                if (str.equals("EXPIRED_OOB_CODE")) {
                    b2 = 8;
                }
                break;
            case -1583894766:
                if (str.equals("INVALID_OOB_CODE")) {
                    b2 = 9;
                }
                break;
            case -1458751677:
                if (str.equals("MISSING_EMAIL")) {
                    b2 = 10;
                }
                break;
            case -1421414571:
                if (str.equals("INVALID_CODE")) {
                    b2 = 11;
                }
                break;
            case -1345867105:
                if (str.equals("TOKEN_EXPIRED")) {
                    b2 = 12;
                }
                break;
            case -1340100504:
                if (str.equals("INVALID_TENANT_ID")) {
                    b2 = 13;
                }
                break;
            case -1232010689:
                if (str.equals("INVALID_SESSION_INFO")) {
                    b2 = 14;
                }
                break;
            case -1202691903:
                if (str.equals("SECOND_FACTOR_EXISTS")) {
                    b2 = Ascii.SI;
                }
                break;
            case -1112393964:
                if (str.equals("INVALID_EMAIL")) {
                    b2 = 16;
                }
                break;
            case -1063710844:
                if (str.equals("ADMIN_ONLY_OPERATION")) {
                    b2 = 17;
                }
                break;
            case -974503964:
                if (str.equals("MISSING_OR_INVALID_NONCE")) {
                    b2 = Ascii.DC2;
                }
                break;
            case -863830559:
                if (str.equals("INVALID_CERT_HASH")) {
                    b2 = 19;
                }
                break;
            case -828507413:
                if (str.equals("NO_SUCH_PROVIDER")) {
                    b2 = Ascii.DC4;
                }
                break;
            case -749743758:
                if (str.equals("MFA_ENROLLMENT_NOT_FOUND")) {
                    b2 = Ascii.NAK;
                }
                break;
            case -736207500:
                if (str.equals("MISSING_PASSWORD")) {
                    b2 = Ascii.SYN;
                }
                break;
            case -646022241:
                if (str.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
                    b2 = Ascii.ETB;
                }
                break;
            case -595928767:
                if (str.equals(Intents.Scan.TIMEOUT)) {
                    b2 = Ascii.CAN;
                }
                break;
            case -333672188:
                if (str.equals("OPERATION_NOT_ALLOWED")) {
                    b2 = Ascii.EM;
                }
                break;
            case -294485423:
                if (str.equals("WEB_INTERNAL_ERROR")) {
                    b2 = Ascii.SUB;
                }
                break;
            case -217128228:
                if (str.equals("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                    b2 = Ascii.ESC;
                }
                break;
            case -122667194:
                if (str.equals("MISSING_MFA_ENROLLMENT_ID")) {
                    b2 = Ascii.FS;
                }
                break;
            case -75433118:
                if (str.equals("USER_NOT_FOUND")) {
                    b2 = Ascii.GS;
                }
                break;
            case -40686718:
                if (str.equals("WEAK_PASSWORD")) {
                    b2 = Ascii.RS;
                }
                break;
            case 15352275:
                if (str.equals("EMAIL_NOT_FOUND")) {
                    b2 = Ascii.US;
                }
                break;
            case 210308040:
                if (str.equals("UNSUPPORTED_FIRST_FACTOR")) {
                    b2 = 32;
                }
                break;
            case 269327773:
                if (str.equals("INVALID_SENDER")) {
                    b2 = 33;
                }
                break;
            case 278802867:
                if (str.equals("MISSING_PHONE_NUMBER")) {
                    b2 = 34;
                }
                break;
            case 408411681:
                if (str.equals("INVALID_DYNAMIC_LINK_DOMAIN")) {
                    b2 = 35;
                }
                break;
            case 423563023:
                if (str.equals("MISSING_MFA_PENDING_CREDENTIAL")) {
                    b2 = 36;
                }
                break;
            case 483847807:
                if (str.equals("EMAIL_EXISTS")) {
                    b2 = 37;
                }
                break;
            case 491979549:
                if (str.equals("INVALID_ID_TOKEN")) {
                    b2 = 38;
                }
                break;
            case 492072102:
                if (str.equals("WEB_STORAGE_UNSUPPORTED")) {
                    b2 = 39;
                }
                break;
            case 542728406:
                if (str.equals("PASSWORD_LOGIN_DISABLED")) {
                    b2 = 40;
                }
                break;
            case 582457886:
                if (str.equals("UNVERIFIED_EMAIL")) {
                    b2 = 41;
                }
                break;
            case 605031096:
                if (str.equals("REJECTED_CREDENTIAL")) {
                    b2 = 42;
                }
                break;
            case 745638750:
                if (str.equals("INVALID_MFA_PENDING_CREDENTIAL")) {
                    b2 = 43;
                }
                break;
            case 786916712:
                if (str.equals("INVALID_VERIFICATION_PROOF")) {
                    b2 = 44;
                }
                break;
            case 799258561:
                if (str.equals("INVALID_PROVIDER_ID")) {
                    b2 = 45;
                }
                break;
            case 819646646:
                if (str.equals("CREDENTIAL_MISMATCH")) {
                    b2 = 46;
                }
                break;
            case 844240628:
                if (str.equals("WEB_CONTEXT_CANCELED")) {
                    b2 = 47;
                }
                break;
            case 886186878:
                if (str.equals("REQUIRES_SECOND_FACTOR_AUTH")) {
                    b2 = 48;
                }
                break;
            case 895302372:
                if (str.equals("MISSING_CLIENT_IDENTIFIER")) {
                    b2 = 49;
                }
                break;
            case 922685102:
                if (str.equals("INVALID_MESSAGE_PAYLOAD")) {
                    b2 = 50;
                }
                break;
            case 989000548:
                if (str.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
                    b2 = 51;
                }
                break;
            case 1034932393:
                if (str.equals("INVALID_PENDING_TOKEN")) {
                    b2 = 52;
                }
                break;
            case 1072360691:
                if (str.equals("INVALID_CUSTOM_TOKEN")) {
                    b2 = 53;
                }
                break;
            case 1094975491:
                if (str.equals("INVALID_PASSWORD")) {
                    b2 = 54;
                }
                break;
            case 1107081238:
                if (str.equals("<<Network Error>>")) {
                    b2 = 55;
                }
                break;
            case 1141576252:
                if (str.equals("SESSION_EXPIRED")) {
                    b2 = 56;
                }
                break;
            case 1199811910:
                if (str.equals("MISSING_CODE")) {
                    b2 = 57;
                }
                break;
            case 1226505451:
                if (str.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
                    b2 = 58;
                }
                break;
            case 1388786705:
                if (str.equals("INVALID_IDENTIFIER")) {
                    b2 = 59;
                }
                break;
            case 1433767024:
                if (str.equals("USER_DISABLED")) {
                    b2 = 60;
                }
                break;
            case 1442968770:
                if (str.equals("INVALID_PHONE_NUMBER")) {
                    b2 = Base64.padSymbol;
                }
                break;
            case 1494923453:
                if (str.equals("INVALID_APP_CREDENTIAL")) {
                    b2 = 62;
                }
                break;
            case 1497901284:
                if (str.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
                    b2 = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 1803454477:
                if (str.equals("MISSING_CONTINUE_URI")) {
                    b2 = 64;
                }
                break;
            case 1898790704:
                if (str.equals("MISSING_SESSION_INFO")) {
                    b2 = 65;
                }
                break;
            case 2063209097:
                if (str.equals("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                    b2 = 66;
                }
                break;
            case 2082564316:
                if (str.equals("UNSUPPORTED_TENANT_OPERATION")) {
                    b2 = 67;
                }
                break;
        }
        switch (b2) {
            case 0:
                i = 18001;
                break;
            case 1:
                i = 17033;
                break;
            case 2:
                i = 17057;
                break;
            case 3:
                i = 17091;
                break;
            case 4:
            case 52:
                i = FirebaseError.ERROR_INVALID_CREDENTIAL;
                break;
            case 5:
                i = 17068;
                break;
            case 6:
                i = 17052;
                break;
            case 7:
                i = 17061;
                break;
            case 8:
                i = 17029;
                break;
            case 9:
                i = 17030;
                break;
            case 10:
                i = 17034;
                break;
            case 11:
                i = 17044;
                break;
            case 12:
                i = FirebaseError.ERROR_USER_TOKEN_EXPIRED;
                break;
            case 13:
                i = 17079;
                break;
            case 14:
                i = 17046;
                break;
            case 15:
                i = 17087;
                break;
            case 16:
            case 59:
                i = FirebaseError.ERROR_INVALID_EMAIL;
                break;
            case 17:
                i = 17085;
                break;
            case 18:
                i = 17094;
                break;
            case 19:
                i = 17064;
                break;
            case 20:
                i = FirebaseError.ERROR_NO_SUCH_PROVIDER;
                break;
            case 21:
                i = 17084;
                break;
            case 22:
                i = 17035;
                break;
            case 23:
                i = FirebaseError.ERROR_REQUIRES_RECENT_LOGIN;
                break;
            case 24:
            case 55:
                i = FirebaseError.ERROR_NETWORK_REQUEST_FAILED;
                break;
            case 25:
            case 40:
                i = FirebaseError.ERROR_OPERATION_NOT_ALLOWED;
                break;
            case 26:
                i = 17062;
                break;
            case 27:
                i = 17088;
                break;
            case 28:
                i = 17082;
                break;
            case 29:
            case 31:
                i = FirebaseError.ERROR_USER_NOT_FOUND;
                break;
            case 30:
                i = FirebaseError.ERROR_WEAK_PASSWORD;
                break;
            case 32:
                i = 17089;
                break;
            case 33:
                i = 17032;
                break;
            case 34:
                i = 17041;
                break;
            case 35:
                i = 17074;
                break;
            case 36:
                i = 17081;
                break;
            case 37:
                i = FirebaseError.ERROR_EMAIL_ALREADY_IN_USE;
                break;
            case 38:
                i = FirebaseError.ERROR_INVALID_USER_TOKEN;
                break;
            case 39:
                i = 17065;
                break;
            case 41:
                i = 17086;
                break;
            case 42:
                i = 17075;
                break;
            case 43:
                i = 17083;
                break;
            case 44:
                i = 17049;
                break;
            case 45:
                i = 17071;
                break;
            case 46:
                i = FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH;
                break;
            case 47:
                i = 17058;
                break;
            case 48:
                i = 17078;
                break;
            case 49:
                i = 17093;
                break;
            case 50:
                i = 17031;
                break;
            case 51:
            case 63:
                i = FirebaseError.ERROR_TOO_MANY_REQUESTS;
                break;
            case 53:
                i = FirebaseError.ERROR_INVALID_CUSTOM_TOKEN;
                break;
            case 54:
                i = FirebaseError.ERROR_WRONG_PASSWORD;
                break;
            case 56:
                i = 17051;
                break;
            case 57:
                i = 17043;
                break;
            case 58:
                i = FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE;
                break;
            case 60:
                i = FirebaseError.ERROR_USER_DISABLED;
                break;
            case 61:
                i = 17042;
                break;
            case 62:
                i = FirebaseError.ERROR_APP_NOT_AUTHORIZED;
                break;
            case 64:
                i = 17040;
                break;
            case 65:
                i = 17045;
                break;
            case 66:
                i = 17090;
                break;
            case 67:
                i = 17073;
                break;
            default:
                i = 17499;
                break;
        }
        if (i != 17499) {
            return new Status(i, str2);
        }
        if (str2 != null) {
            return new Status(i, new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()).append(str).append(":").append(str2).toString());
        }
        return new Status(i, str);
    }
}
