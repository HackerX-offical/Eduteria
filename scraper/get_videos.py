#!/usr/bin/env python3
"""
Extract Video URLs - Direct approach
Try multiple methods to get actual video links
"""

import requests
import json
from pathlib import Path

# Known patterns
COURSE_ID = "48297"
BEARER = "Bearer 117#Nerglnw3@@OI)30@I*Dm'@@_166"

def try_videocrypt_api():
    """Try VideoCrypt API directly"""
    print("[1] Trying VideoCrypt API...")
    
    # From decompiled code: appapi.videocrypt.in
    endpoints = [
        f"https://appapi.videocrypt.in/api/v1/course/{COURSE_ID}/videos",
        f"https://appapi.videocrypt.in/api/course/{COURSE_ID}",
        f"https://appapi.videocrypt.in/course/{COURSE_ID}",
        f"https://appapi.videocrypt.in/v1/videos?course_id={COURSE_ID}",
    ]
    
    for url in endpoints:
        try:
            r = requests.get(url, headers={"Authorization": BEARER}, timeout=10)
            print(f"  {url}: {r.status_code}")
            if r.status_code == 200:
                data = r.json()
                print(f"  ✓ GOT DATA: {str(data)[:200]}")
                return data
        except:
            pass
    
    return None

def try_jwplayer_patterns():
    """Try JWPlayer CDN patterns"""
    print("\n[2] Trying JWPlayer CDN patterns...")
    
    # Common video IDs around course ID
    test_ids = [
        "48297",
        "482970001",  # Course + video index
        str(int(COURSE_ID) * 100),
        f"eduteria_{COURSE_ID}",
    ]
    
    for vid in test_ids:
        url = f"https://cdn.jwplayer.com/v2/media/{vid}"
        try:
            r = requests.get(url, timeout=10)
            print(f"  {vid}: {r.status_code}")
            if r.status_code == 200:
                data = r.json()
                print(f"  ✓ FOUND VIDEO: {data.get('title', 'No title')}")
                if 'playlist' in data:
                    for source in data['playlist'][0].get('sources', []):
                        print(f"    VIDEO URL: {source.get('file')}")
                return data
        except:
            pass
    
    return None

def try_firebase_video_paths():
    """Try Firebase video storage paths"""
    print("\n[3] Trying Firebase video paths...")
    
    base = "https://eduteria-b9a30-default-rtdb.firebaseio.com"
    paths = [
        f"/courses/{COURSE_ID}.json",
        f"/videos/{COURSE_ID}.json",
        f"/content/{COURSE_ID}.json",
        f"/166/courses/{COURSE_ID}.json",
        f"/166/videos.json",
        f"/course_data/{COURSE_ID}.json",
    ]
    
    for path in paths:
        url = base + path
        try:
            r = requests.get(url, timeout=10)
            if r.status_code == 200 and r.text != "null":
                data = r.json()
                print(f"  ✓ {path}: Found data")
                return data
        except:
            pass
    
    return None

def try_cloudfront_patterns():
    """Try CloudFront CDN"""
    print("\n[4] Trying CloudFront CDN...")
    
    # From BuildConfig: IMAGE_URL_PREFIX
    base = "https://d1i3vm6evcjhiu.cloudfront.net"
    
    patterns = [
        f"/{COURSE_ID}/video_001.m3u8",
        f"/courses/{COURSE_ID}/playlist.m3u8",
        f"/videos/{COURSE_ID}.m3u8",
    ]
    
    for path in patterns:
        url = base + path
        try:
            r = requests.head(url, timeout=10)
            print(f"  {path}: {r.status_code}")
            if r.status_code == 200:
                print(f"  ✓ FOUND: {url}")
                return url
        except:
            pass
    
    return None

def search_firebase_for_any_videos():
    """Search Firebase for ANY video references"""
    print("\n[5] Searching Firebase for video references...")
    
    try:
        r = requests.get("https://eduteria-b9a30-default-rtdb.firebaseio.com/166.json")
        data = r.json()
        
        # Convert to string and search
        data_str = json.dumps(data)
        
        # Look for video-like patterns
        patterns = ["http", "mp4", "m3u8", "video", "stream", "jwplayer", "cloudfront"]
        
        for pattern in patterns:
            if pattern in data_str.lower():
                # Find context around pattern
                idx = data_str.lower().find(pattern)
                context = data_str[max(0, idx-100):idx+200]
                print(f"  Found '{pattern}': ...{context}...")
                
        # Save for manual inspection
        with open("../data/firebase_video_search.json", "w") as f:
            json.dump(data, f, indent=2)
        
        print(f"  Full data saved to: ../data/firebase_video_search.json")
        return data
    except Exception as e:
        print(f"  Error: {e}")
    
    return None

def try_direct_api_endpoints():
    """Try other API endpoints without encryption"""
    print("\n[6] Trying unencrypted API endpoints...")
    
    api_base = "https://appapi.videocrypt.in"
    
    endpoints = [
        f"/api/v1/course/{COURSE_ID}",
        f"/api/v2/course/{COURSE_ID}",  
        f"/v1/course/{COURSE_ID}",
        f"/public/course/{COURSE_ID}",
        f"/course/detail/{COURSE_ID}",
    ]
    
    for path in endpoints:
        url = api_base + path
        try:
            r = requests.get(url, headers={"Authorization": BEARER}, timeout=10)
            print(f"  {path}: {r.status_code}")
            if r.status_code == 200:
                try:
                    data = r.json()
                    print(f"  ✓ GOT DATA: {str(data)[:150]}")
                    return data
                except:
                    print(f"  Response: {r.text[:150]}")
        except:
            pass
    
    return None

def main():
    print("="*70)
    print("EXTRACTING ACTUAL VIDEO URLs")
    print(f"Target: Course {COURSE_ID}")
    print("="*70)
    
    results = {}
    
    # Try all methods
    results['videocrypt'] = try_videocrypt_api()
    results['jwplayer'] = try_jwplayer_patterns()
    results['firebase'] = try_firebase_video_paths()
    results['cloudfront'] = try_cloudfront_patterns()
    results['firebase_search'] = search_firebase_for_any_videos()
    results['direct_api'] = try_direct_api_endpoints()
    
    # Summary
    print("\n" + "="*70)
    print("RESULTS SUMMARY")
    print("="*70)
    
    found_something = False
    for method, data in results.items():
        if data:
            print(f"✓ {method}: Found data")
            found_something = True
        else:
            print(f"✗ {method}: No data")
    
    if not found_something:
        print("\n⚠ No direct video URLs found via automated methods")
        print("\nNEXT STEPS:")
        print("1. Manual Firebase exploration (saved to firebase_video_search.json)")
        print("2. Install APK on device and intercept with mitmproxy")
        print("3. Use Frida to hook video player and extract URLs")
        print("4. Search decompiled code for video URL construction")
    
    print("\n" + "="*70)

if __name__ == "__main__":
    main()
