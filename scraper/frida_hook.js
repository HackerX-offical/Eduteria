/**
 * Frida Hook for EDUTERIA Video URL Extraction
 * Usage: frida -U -f com.eduteria.app.app -l frida_hook.js --no-pause
 */

console.log("[*] EDUTERIA Video Hook Starting...");

Java.perform(function() {
    console.log("[*] Java environment loaded");
    
    try {
        // Hook 1: YoutubePlayerActivity - Video URL
        var YoutubePlayer = Java.use("com.appnew.android.player.YoutubePlayerActivity");
        console.log("[*] Found YoutubePlayerActivity");
        
        YoutubePlayer.playVideo.overload('java.lang.String').implementation = function(url) {
            console.log("[VIDEO URL] " + url);
            send({type: "video_url", url: url});
            return this.playVideo(url);
        };
        
        // Hook 2: M3U8 URL generation
        YoutubePlayer.generateurl.overload('java.lang.String', 'java.lang.String').implementation = function(line, str) {
            var result = this.generateurl(line, str);
            console.log("[M3U8 URL] " + result);
            send({type: "m3u8_url", url: result});
            return result;
        };
        
    } catch(e) {
        console.log("[!] YoutubePlayer hook failed: " + e);
    }
    
    try {
        // Hook 3: Liveawsactivity - Live streaming
        var Liveaws = Java.use("com.appnew.android.player.Liveawsactivity");
        console.log("[*] Found Liveawsactivity");
        
        Liveaws.playVideo.overload('java.lang.String').implementation = function(url) {
            console.log("[LIVE URL] " + url);
            send({type: "live_url", url: url});
            return this.playVideo(url);
        };
        
    } catch(e) {
        console.log("[!] Liveaws hook failed: " + e);
    }
    
    try {
        // Hook 4: VODPlayerActivity - VOD content
        var VODPlayer = Java.use("com.appnew.android.player.VODPlayerActivity");
        console.log("[*] Found VODPlayerActivity");
        
        VODPlayer.playVideo.overload('java.lang.String').implementation = function(url) {
            console.log("[VOD URL] " + url);
            send({type: "vod_url", url: url});
            return this.playVideo(url);
        };
        
    } catch(e) {
        console.log("[!] VODPlayer hook failed: " + e);
    }
    
    try {
        // Hook 5: Content access control bypass
        var YoutubePlayer2 = Java.use("com.appnew.android.player.YoutubePlayerActivity");
        
        // Override islocked check
        YoutubePlayer2.islocked.value = "0";  // Always unlocked
        console.log("[*] Set islocked = 0 (unlocked)");
        
    } catch(e) {
        console.log("[!] islocked bypass failed: " + e);
    }
    
    try {
        // Hook 6: Network requests to capture API calls
        var OkHttpClient = Java.use("okhttp3.OkHttpClient");
        var Request = Java.use("okhttp3.Request");
        
        console.log("[*] Hooking OkHttp requests");
        
        OkHttpClient.newCall.overload('okhttp3.Request').implementation = function(request) {
            var url = request.url().toString();
            if (url.indexOf("videocrypt") !== -1 || url.indexOf("video") !== -1) {
                console.log("[API CALL] " + url);
                send({type: "api_call", url: url});
            }
            return this.newCall(request);
        };
        
    } catch(e) {
        console.log("[!] OkHttp hook failed: " + e);
    }
    
    console.log("[*] All hooks installed! Open a video in the app...");
});

// Handle messages from hooks
recv(function(message) {
    if (message.type === 'video_found') {
        console.log("[+] Video URL captured: " + message.url);
    }
});
