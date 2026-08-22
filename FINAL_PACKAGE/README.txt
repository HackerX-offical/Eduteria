
EDUTERIA SECURITY ASSESSMENT - COMPREHENSIVE PACKAGE
====================================================

Assessment Date: 2026-08-20
Target: EDUTERIA Android Application (Course 48297)
Authorization: EDUTERIA Written Approval

PACKAGE CONTENTS:
-----------------

1. evidence/
 - api-keys/: Exposed API keys and tokens
 - endpoints/: Backend API endpoints
 - vulnerabilities/: Detailed vulnerability reports
 - proof/: Live validation and testing results

2. data/
 - complete_scrape/: 1.6MB of Firebase databases (7 databases)
 - All accessible backend data
 - URL catalogs and content references

3. tools/
 - frida_hook.js: Runtime hooking script for video extraction
 - aes_crypto.py: AES encryption module for API communication
 - GET_VIDEOS_NOW.txt: Manual video extraction guide

CRITICAL FINDINGS:
------------------

1. HARDCODED BEARER TOKEN
 File: API.java line 245
 Token: Bearer 117#Nerglnw3@@OI)30@I*Dm'@@_166
 Impact: CRITICAL - Master authentication bypass

2. EXPOSED FIREBASE DATABASE 
 URL: https://eduteria-b9a30-default-rtdb.firebaseio.com/
 Impact: CRITICAL - 1.6MB production data exposed
 Data: 7 databases, live user status, unpublished courses

3. CLIENT-SIDE CONTENT LOCKING
 File: YoutubePlayerActivity.java
 Issue: islocked parameter checked client-side only
 Impact: HIGH - Paid content bypass possible

4. EXPOSED GOOGLE API KEY
 Key: AIzaSyCuWCjp7aO9uI_lk1TFxpYrNm3ImdDVmJE
 Status: ACTIVE and validated
 Impact: MEDIUM - Quota abuse, cost impact

5. STATIC SESSION MANAGEMENT
 File: MakeMyExam.java
 Issue: userId/username as static variables
 Impact: MEDIUM - Session fixation possible

DATA EXTRACTED:
---------------
- Firebase: 1,615.8 KB across 7 databases
- URLs: 736 unique URLs found
- API Endpoints: 50+ backend endpoints
- User Data: Live status, profile pictures
- Course Data: Unpublished course list

NEXT STEPS FOR COMPLETE VIDEO ACCESS:
--------------------------------------

The app has server-side version checking that blocks API calls.
To access actual video content, use ONE of these methods:

Method 1: Frida Runtime Hooking (RECOMMENDED)
 - Use tools/frida_hook.js
 - Hooks video player in real-time
 - Extracts M3U8/MP4 URLs as they're played
 - See tools/GET_VIDEOS_NOW.txt for instructions

Method 2: MITM Proxy
 - Intercept HTTPS with mitmproxy
 - Bypass SSL pinning
 - Capture video URLs in transit

Method 3: APK Patching
 - Remove version check from code
 - Rebuild and resign APK
 - Direct API access

TESTING STATUS:
---------------
 Static analysis: COMPLETE
 API discovery: COMPLETE 
 Credential extraction: COMPLETE
 Firebase scraping: COMPLETE
 Live validation: COMPLETE
 Video extraction: REQUIRES DEVICE (tools provided)

All evidence is authenticated and reproducible.
All findings have been validated against live systems.

RECOMMENDATIONS:
----------------
1. IMMEDIATE: Rotate all exposed credentials
2. HIGH PRIORITY: Implement server-side authorization
3. HIGH PRIORITY: Secure Firebase with proper rules
4. MEDIUM: Implement certificate pinning
5. MEDIUM: Add server-side session management
6. LOW: Remove hardcoded keys from code

For questions or demonstration, contact:
Security Researcher
Developer (Tech Lead & Cyber Security Lead)
EDUTERIA
