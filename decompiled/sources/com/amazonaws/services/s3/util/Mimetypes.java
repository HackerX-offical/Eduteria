package com.amazonaws.services.s3.util;

import androidx.media3.common.MimeTypes;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.util.StringUtils;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;

/* JADX INFO: loaded from: classes4.dex */
public final class Mimetypes {
    public static final String MIMETYPE_GZIP = "application/x-gzip";
    public static final String MIMETYPE_HTML = "text/html";
    public static final String MIMETYPE_OCTET_STREAM = "application/octet-stream";
    public static final String MIMETYPE_XML = "application/xml";
    private static final Log log = LogFactory.getLog(Mimetypes.class);
    private static Mimetypes mimetypes = null;
    private final HashMap<String, String> extensionToMimetypeMap;

    Mimetypes() {
        HashMap<String, String> map = new HashMap<>();
        this.extensionToMimetypeMap = map;
        map.put("3gp", "video/3gpp");
        map.put("ai", "application/postscript");
        map.put("aif", "audio/x-aiff");
        map.put("aifc", "audio/x-aiff");
        map.put("aiff", "audio/x-aiff");
        map.put("asc", HTTP.PLAIN_TEXT_TYPE);
        map.put("atom", "application/atom+xml");
        map.put("au", "audio/basic");
        map.put("avi", MimeTypes.VIDEO_AVI);
        map.put("bcpio", "application/x-bcpio");
        map.put("bin", "application/octet-stream");
        map.put("bmp", MimeTypes.IMAGE_BMP);
        map.put("cdf", "application/x-netcdf");
        map.put("cgm", "image/cgm");
        map.put(Const.CLASS, "application/octet-stream");
        map.put("cpio", "application/x-cpio");
        map.put("cpt", "application/mac-compactpro");
        map.put("csh", "application/x-csh");
        map.put("css", "text/css");
        map.put("dcr", "application/x-director");
        map.put("dif", "video/x-dv");
        map.put("dir", "application/x-director");
        map.put("djv", "image/vnd.djvu");
        map.put("djvu", "image/vnd.djvu");
        map.put("dll", "application/octet-stream");
        map.put("dmg", "application/octet-stream");
        map.put("dms", "application/octet-stream");
        map.put(Const.DOC, "application/msword");
        map.put("dtd", "application/xml-dtd");
        map.put("dv", "video/x-dv");
        map.put("dvi", "application/x-dvi");
        map.put("dxr", "application/x-director");
        map.put("eps", "application/postscript");
        map.put("etx", "text/x-setext");
        map.put("exe", "application/octet-stream");
        map.put("ez", "application/andrew-inset");
        map.put("flv", "video/x-flv");
        map.put("gif", "image/gif");
        map.put("gram", "application/srgs");
        map.put("grxml", "application/srgs+xml");
        map.put("gtar", "application/x-gtar");
        map.put("gz", MIMETYPE_GZIP);
        map.put("hdf", "application/x-hdf");
        map.put("hqx", "application/mac-binhex40");
        map.put("htm", MIMETYPE_HTML);
        map.put("html", MIMETYPE_HTML);
        map.put("ice", "x-conference/x-cooltalk");
        map.put(Constants.NOTIF_ICON, "image/x-icon");
        map.put("ics", "text/calendar");
        map.put("ief", "image/ief");
        map.put("ifb", "text/calendar");
        map.put("iges", "model/iges");
        map.put("igs", "model/iges");
        map.put("jnlp", "application/x-java-jnlp-file");
        map.put("jp2", "image/jp2");
        map.put("jpe", "image/jpeg");
        map.put("jpeg", "image/jpeg");
        map.put("jpg", "image/jpeg");
        map.put("js", "application/x-javascript");
        map.put("kar", MimeTypes.AUDIO_MIDI);
        map.put("latex", "application/x-latex");
        map.put("lha", "application/octet-stream");
        map.put("lzh", "application/octet-stream");
        map.put("m3u", "audio/x-mpegurl");
        map.put("m4a", "audio/mp4a-latm");
        map.put("m4p", "audio/mp4a-latm");
        map.put("m4u", "video/vnd.mpegurl");
        map.put("m4v", "video/x-m4v");
        map.put("mac", "image/x-macpaint");
        map.put("man", "application/x-troff-man");
        map.put("mathml", "application/mathml+xml");
        map.put(TournamentShareDialogURIBuilder.f586me, "application/x-troff-me");
        map.put("mesh", "model/mesh");
        map.put("mid", MimeTypes.AUDIO_MIDI);
        map.put("midi", MimeTypes.AUDIO_MIDI);
        map.put("mif", "application/vnd.mif");
        map.put("mov", "video/quicktime");
        map.put("movie", "video/x-sgi-movie");
        map.put("mp2", "audio/mpeg");
        map.put("mp3", "audio/mpeg");
        map.put("mp4", "video/mp4");
        map.put("mpe", "video/mpeg");
        map.put("mpeg", "video/mpeg");
        map.put("mpg", "video/mpeg");
        map.put("mpga", "audio/mpeg");
        map.put("ms", "application/x-troff-ms");
        map.put("msh", "model/mesh");
        map.put("mxu", "video/vnd.mpegurl");
        map.put("nc", "application/x-netcdf");
        map.put("oda", "application/oda");
        map.put("ogg", "application/ogg");
        map.put("ogv", "video/ogv");
        map.put("pbm", "image/x-portable-bitmap");
        map.put("pct", "image/pict");
        map.put("pdb", "chemical/x-pdb");
        map.put(Const.PDF, "application/pdf");
        map.put("pgm", "image/x-portable-graymap");
        map.put("pgn", "application/x-chess-pgn");
        map.put("pic", "image/pict");
        map.put("pict", "image/pict");
        map.put("png", MimeTypes.IMAGE_PNG);
        map.put("pnm", "image/x-portable-anymap");
        map.put("pnt", "image/x-macpaint");
        map.put("pntg", "image/x-macpaint");
        map.put("ppm", "image/x-portable-pixmap");
        map.put(Const.PPT, "application/vnd.ms-powerpoint");
        map.put("ps", "application/postscript");
        map.put("qt", "video/quicktime");
        map.put("qti", "image/x-quicktime");
        map.put("qtif", "image/x-quicktime");
        map.put("ra", "audio/x-pn-realaudio");
        map.put("ram", "audio/x-pn-realaudio");
        map.put("ras", "image/x-cmu-raster");
        map.put("rdf", "application/rdf+xml");
        map.put("rgb", "image/x-rgb");
        map.put("rm", "application/vnd.rn-realmedia");
        map.put("roff", "application/x-troff");
        map.put("rtf", "text/rtf");
        map.put("rtx", "text/richtext");
        map.put("sgm", "text/sgml");
        map.put("sgml", "text/sgml");
        map.put("sh", "application/x-sh");
        map.put("shar", "application/x-shar");
        map.put("silo", "model/mesh");
        map.put("sit", "application/x-stuffit");
        map.put("skd", "application/x-koan");
        map.put("skm", "application/x-koan");
        map.put("skp", "application/x-koan");
        map.put("skt", "application/x-koan");
        map.put("smi", "application/smil");
        map.put("smil", "application/smil");
        map.put("snd", "audio/basic");
        map.put("so", "application/octet-stream");
        map.put("spl", "application/x-futuresplash");
        map.put("src", "application/x-wais-source");
        map.put("sv4cpio", "application/x-sv4cpio");
        map.put("sv4crc", "application/x-sv4crc");
        map.put("svg", "image/svg+xml");
        map.put(ServiceAbbreviations.SimpleWorkflow, "application/x-shockwave-flash");
        map.put("t", "application/x-troff");
        map.put("tar", "application/x-tar");
        map.put("tcl", "application/x-tcl");
        map.put("tex", "application/x-tex");
        map.put("texi", "application/x-texinfo");
        map.put("texinfo", "application/x-texinfo");
        map.put("tif", "image/tiff");
        map.put("tiff", "image/tiff");
        map.put("tr", "application/x-troff");
        map.put("tsv", "text/tab-separated-values");
        map.put("txt", HTTP.PLAIN_TEXT_TYPE);
        map.put("ustar", "application/x-ustar");
        map.put("vcd", "application/x-cdlink");
        map.put("vrml", "model/vrml");
        map.put("vxml", "application/voicexml+xml");
        map.put("wav", "audio/x-wav");
        map.put("wbmp", "image/vnd.wap.wbmp");
        map.put("wbxml", "application/vnd.wap.wbxml");
        map.put("webm", "video/webm");
        map.put("wml", "text/vnd.wap.wml");
        map.put("wmlc", "application/vnd.wap.wmlc");
        map.put("wmls", "text/vnd.wap.wmlscript");
        map.put("wmlsc", "application/vnd.wap.wmlscriptc");
        map.put("wmv", "video/x-ms-wmv");
        map.put("wrl", "model/vrml");
        map.put("xbm", "image/x-xbitmap");
        map.put("xht", "application/xhtml+xml");
        map.put("xhtml", "application/xhtml+xml");
        map.put(Const.XLS, "application/vnd.ms-excel");
        map.put(AbstractHttpOverXmpp.Xml.ELEMENT, MIMETYPE_XML);
        map.put("xpm", "image/x-xpixmap");
        map.put("xsl", MIMETYPE_XML);
        map.put("xslt", "application/xslt+xml");
        map.put("xul", "application/vnd.mozilla.xul+xml");
        map.put("xwd", "image/x-xwindowdump");
        map.put("xyz", "chemical/x-xyz");
        map.put("zip", "application/zip");
    }

    public static synchronized Mimetypes getInstance() {
        Mimetypes mimetypes2 = mimetypes;
        if (mimetypes2 != null) {
            return mimetypes2;
        }
        mimetypes = new Mimetypes();
        if (log.isDebugEnabled()) {
            HashMap<String, String> map = mimetypes.extensionToMimetypeMap;
            for (String str : map.keySet()) {
                log.debug("Setting mime type for extension '" + str + "' to '" + map.get(str) + "'");
            }
        }
        return mimetypes;
    }

    public void loadAndReplaceMimetypes(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            String strTrim = line.trim();
            if (strTrim.startsWith(MqttTopic.MULTI_LEVEL_WILDCARD) || strTrim.length() == 0) {
                log.debug("Ignoring comments and empty lines.");
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(strTrim, " \t");
                if (stringTokenizer.countTokens() > 1) {
                    String strNextToken = stringTokenizer.nextToken();
                    while (stringTokenizer.hasMoreTokens()) {
                        String strNextToken2 = stringTokenizer.nextToken();
                        this.extensionToMimetypeMap.put(StringUtils.lowerCase(strNextToken2), strNextToken);
                        Log log2 = log;
                        if (log2.isDebugEnabled()) {
                            log2.debug("Setting mime type for extension '" + StringUtils.lowerCase(strNextToken2) + "' to '" + strNextToken + "'");
                        }
                    }
                } else {
                    Log log3 = log;
                    if (log3.isDebugEnabled()) {
                        log3.debug("Ignoring mimetype with no associated file extensions: '" + strTrim + "'");
                    }
                }
            }
        }
    }

    public String getMimetype(String str) {
        int i;
        int iLastIndexOf = str.lastIndexOf(InstructionFileId.DOT);
        if (iLastIndexOf > 0 && (i = iLastIndexOf + 1) < str.length()) {
            String strLowerCase = StringUtils.lowerCase(str.substring(i));
            if (this.extensionToMimetypeMap.containsKey(strLowerCase)) {
                String str2 = this.extensionToMimetypeMap.get(strLowerCase);
                Log log2 = log;
                if (log2.isDebugEnabled()) {
                    log2.debug("Recognised extension '" + strLowerCase + "', mimetype is: '" + str2 + "'");
                }
                return str2;
            }
            Log log3 = log;
            if (log3.isDebugEnabled()) {
                log3.debug("Extension '" + strLowerCase + "' is unrecognized in mime type listing, using default mime type: 'application/octet-stream'");
                return "application/octet-stream";
            }
            return "application/octet-stream";
        }
        Log log4 = log;
        if (log4.isDebugEnabled()) {
            log4.debug("File name has no extension, mime type cannot be recognised for: " + str);
            return "application/octet-stream";
        }
        return "application/octet-stream";
    }

    public String getMimetype(File file) {
        return getMimetype(file.getName());
    }

    public void registerMimetype(String str, String str2) {
        this.extensionToMimetypeMap.put(StringUtils.lowerCase(str), str2);
    }
}
