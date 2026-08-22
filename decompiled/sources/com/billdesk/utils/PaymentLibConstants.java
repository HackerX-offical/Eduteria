package com.billdesk.utils;

import androidx.fragment.app.FragmentManager;
import com.billdesk.sdk.BaseClass;
import com.billdesk.sdk.LibraryPaymentStatusProtocol;
import easypay.appinvoke.manager.Constants;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class PaymentLibConstants {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f511b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f512c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f513d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f514e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f515f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f516g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static BaseClass f517h = null;
    public static BaseClass i = null;
    public static BaseClass j = null;
    public static JSONObject k = null;
    public static boolean l = false;
    public static String m = "";
    public static HashMap<String, String> n = null;
    public static HashMap<String, String> o = null;
    public static HashMap<String, Object> p = null;
    public static LibraryPaymentStatusProtocol u = null;
    public static FragmentManager v = null;
    public static boolean w = false;
    public static boolean x = false;
    public static boolean y = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f510a = {"No internet. Check your connection.", "We are currently unable to process your request. Please try again later."};
    public static final String[] q = {"Expiry Month", "Jan (01)", "Feb (02)", "Mar (03)", " Apr (04)", " May (05)", "Jun (06)", "Jul (07)", "Aug (08)", "Sep (09)", "Oct (10)", "Nov (11)", "Dec (12)"};
    public static final String[] r = {"Select Country", "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos Islands", "Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Côte d'Ivoire", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands", "Faroe Islands", "Fiji", "Finland", "France", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard Island And McDonald Islands", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macao", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia", "Rwanda", "Saint Helena", "Saint Kitts And Nevis", "Saint Lucia", "Saint Pierre And Miquelon", "Saint Vincent And The Grenadines", "Samoa", "San Marino", "Sao Tome And Principe", "Saudi Arabia", "Senegal", "Serbia and Montenegro", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia And The South Sandwich Islands", "South Korea", "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard And Jan Mayen", "Swazil8446846854and", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Democratic Republic Of Congo", "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks And Caicos Islands", "Tuvalu", "U.S. Virgin Islands", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican", "Venezuela", "Vietnam", "Wallis And Futuna", "Western Sahara", "Yemen", "Zambia", "Zimbabwe", "Aland Islands"};
    public static final String[] s = {"", "AF", "AL", "DZ", "AS", "AD", "AO ", "AI ", "AQ ", "AG ", "AR ", "AM ", "AW ", "AU ", "AT ", "AZ ", "BS ", "BH ", "BD ", "BB ", "BY ", "BE ", "BZ ", "BJ ", "BM ", "BT ", "BO ", "BA ", "BW ", "BV ", "BR ", "IO ", "VG ", "BN ", "BG ", "BF ", "BI ", "KH ", "CM ", "CA ", "CV ", "KY ", "CF ", "TD ", "CL ", "CN ", "CX ", "CC ", "CO ", "KM ", "CG ", "CK ", "CR ", "HR ", "CU ", "CY ", "CZ ", "CI ", "DK ", "DJ ", "DM ", "DO ", "EC ", "EG ", "SV ", "GQ ", "ER ", "EE ", "ET ", "FK ", "FO ", "FJ ", "FI ", "FR ", "GF ", "PF ", "TF ", "GA ", "GM ", "GE ", "DE ", "GH ", "GI ", "GR ", "GL ", "GD ", "GP ", "GU ", "GT ", "GN ", "GW ", "GY ", "HT ", "HM ", "HN ", "HK ", "HU ", "IS ", "IN ", "ID ", "IR ", "IQ ", "IE ", "IL ", "IT ", "JM ", "JP ", "JO ", "KZ ", "KE ", "KI ", "KW ", "KG ", "LA ", "LV ", "LB ", "LS ", "LR ", "LY ", "LI ", "LT ", "LU ", "MO ", "MK ", "MG ", "MW ", "MY ", "MV ", "ML ", "MT ", "MH ", "MQ ", "MR ", "MU ", "YT ", "MX ", "FM ", "MD ", "MC ", "MN ", "MS ", "MA ", "MZ ", "MM ", "NA ", "NR ", "NP ", "NL ", "AN ", "NC ", "NZ ", "NI ", "NE ", "NG ", "NU ", "NF ", "KP ", "MP ", "NO ", "OM ", "PK ", "PW ", "PS ", "PA ", "PG ", "PY ", "PE ", "PH ", "PN ", "PL ", "PT ", "PR ", "QA ", "RE ", "RO ", "RU ", "RW ", "SH ", "KN ", "LC ", "PM ", "VC ", "WS ", "SM ", "ST ", "SA ", "SN ", "CS ", "SC ", "SL ", "SG ", "SK ", "SI ", "SB ", "SO ", "ZA ", "GS ", "KR ", "ES ", "LK ", "SD ", "SR ", "SJ ", "SZ ", "SE ", "CH ", "SY ", "TW ", "TJ ", "TZ ", "TH ", "CD ", "TL ", "TG ", "TK ", "TO ", "TT ", "TN ", "TR ", "TM ", "TC ", "TV ", "VI ", "UG ", "UA ", "AE ", "GB ", "US", "UM ", "UY", "UZ", "VU", "VA", "VE", "VN", "WF", "EH", "YE", "ZM", "ZW", "AX"};
    public static final String[] t = {"QP", Constants.EASYPAY_PAYTYPE_CREDIT_CARD, Constants.EASYPAY_PAYTYPE_DEBIT_CARD, Constants.EASYPAY_PAYTYPE_NETBANKING};
}
