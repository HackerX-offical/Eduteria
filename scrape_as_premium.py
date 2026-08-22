#!/usr/bin/env python3
"""
Scrape actual course content using premium Firebase status
"""
import requests
import json
import sys
from pathlib import Path

sys.path.insert(0, 'scraper')
from aes_crypto import encrypt_payload, decrypt_response

BEARER = "Bearer 117#Nerglnw3@@OI)30@I*Dm'@@_166"
BASE = "https://appapi.videocrypt.in"
FIREBASE = "https://eduteria-b9a30-default-rtdb.firebaseio.com"

USER_ID = "54204924"
COURSE_ID = "48297"

output = Path("data/PREMIUM_CONTENT")
output.mkdir(parents=True, exist_ok=True)

print("="*80)
print("SCRAPING CONTENT AS PREMIUM USER")
print("="*80)
print()

headers = {
    "Authorization": BEARER,
    "Content-Type": "application/json",
    "User-Agent": "okhttp/4.9.0",
    "Accept": "application/json"
}

# Strategy 1: Try different API endpoints without version check
print("[1] Trying alternate API endpoints (bypass version check)...")
print()

endpoints = [
    {
        "name": "Get course master data (direct)",
        "url": f"{BASE}/index.php/data_model/course/get_master_data",
        "data": {"course_id": COURSE_ID, "user_id": USER_ID},
        "needs_encryption": True
    },
    {
        "name": "Get course videos",
        "url": f"{BASE}/index.php/data_model/course/get_videos",
        "data": {"course_id": COURSE_ID, "user_id": USER_ID},
        "needs_encryption": False
    },
    {
        "name": "Get course content",
        "url": f"{BASE}/index.php/data_model/course/get_course_content",
        "data": {"course_id": COURSE_ID, "user_id": USER_ID},
        "needs_encryption": False
    },
    {
        "name": "Get live videos",
        "url": f"{BASE}/index.php/data_model/course/get_live_videos",
        "data": {"course_id": COURSE_ID},
        "needs_encryption": False
    }
]

for endpoint in endpoints:
    print(f"Trying: {endpoint['name']}...")
    
    try:
        if endpoint.get('needs_encryption'):
            # Try with AES encryption
            encrypted = encrypt_payload(endpoint['data'])
            r = requests.post(
                endpoint['url'],
                headers=headers,
                json={"enc_data": encrypted},
                timeout=15
            )
        else:
            r = requests.post(
                endpoint['url'],
                headers=headers,
                json=endpoint['data'],
                timeout=15
            )
        
        print(f"  Status: {r.status_code}")
        
        if r.status_code == 200:
            try:
                resp = r.json()
                print(f"  Response: {json.dumps(resp, indent=2)[:300]}")
                
                # Save successful responses
                if resp.get('status') or resp.get('data'):
                    filename = endpoint['name'].replace(' ', '_').lower() + '.json'
                    with open(output / filename, 'w') as f:
                        json.dump(resp, f, indent=2)
                    print(f"  ✓ Saved to: {filename}")
            except:
                print(f"  Response (text): {r.text[:200]}")
        print()
    except Exception as e:
        print(f"  Error: {e}\n")

# Strategy 2: Read course data from Firebase directly
print("[2] Reading course content from Firebase...")
print()

firebase_paths = [
    f"{FIREBASE}/166/course_data/{COURSE_ID}.json",
    f"{FIREBASE}/courses/{COURSE_ID}.json",
    f"{FIREBASE}/Eduteria_Live/courses/{COURSE_ID}.json",
    f"{FIREBASE}/166/videos/{COURSE_ID}.json",
    f"{FIREBASE}/live_videos/{COURSE_ID}.json"
]

for path in firebase_paths:
    try:
        r = requests.get(path, timeout=10)
        if r.status_code == 200:
            data = r.json()
            if data and data != "null":
                print(f"✓ Found data at: {path}")
                filename = path.split('/')[-2] + '_' + path.split('/')[-1]
                with open(output / filename, 'w') as f:
                    json.dump(data, f, indent=2)
                print(f"  Saved: {filename}")
                print(f"  Preview: {json.dumps(data, indent=2)[:200]}")
                print()
    except:
        pass

# Strategy 3: Try to get video URLs using VideoCrypt API
print("[3] Trying VideoCrypt API for video access...")
print()

# First, get course structure
try:
    r = requests.get(f"{FIREBASE}/166.json", timeout=10)
    if r.status_code == 200:
        firebase_data = r.json()
        
        # Look for video IDs in the data
        print("Searching for video IDs in Firebase...")
        
        def find_video_ids(obj, path=""):
            video_ids = []
            if isinstance(obj, dict):
                if 'video_id' in obj:
                    video_ids.append(obj['video_id'])
                if 'vdocipher_id' in obj:
                    video_ids.append(obj['vdocipher_id'])
                for key, val in obj.items():
                    video_ids.extend(find_video_ids(val, f"{path}/{key}"))
            elif isinstance(obj, list):
                for item in obj:
                    video_ids.extend(find_video_ids(item, path))
            return video_ids
        
        video_ids = find_video_ids(firebase_data)
        video_ids = list(set(video_ids))[:10]  # Get first 10 unique
        
        if video_ids:
            print(f"✓ Found {len(video_ids)} video IDs")
            with open(output / 'discovered_video_ids.json', 'w') as f:
                json.dump(video_ids, f, indent=2)
            print(f"  Sample: {video_ids[:3]}")
except:
    pass

print()

# Strategy 4: Get user's enrolled courses from Firebase
print("[4] Getting your enrolled courses from Firebase...")
print()

user_paths = [
    f"{FIREBASE}/user_courses/{USER_ID}.json",
    f"{FIREBASE}/166/user_data/{USER_ID}.json",
    f"{FIREBASE}/enrollments/{USER_ID}.json"
]

for path in user_paths:
    try:
        r = requests.get(path, timeout=10)
        if r.status_code == 200:
            data = r.json()
            if data and data != "null":
                print(f"✓ Found enrollment data: {path}")
                print(f"  Data: {json.dumps(data, indent=2)[:300]}")
                
                filename = 'user_' + path.split('/')[-1]
                with open(output / filename, 'w') as f:
                    json.dump(data, f, indent=2)
                print()
    except:
        pass

print("="*80)
print("SCRAPING COMPLETE")
print("="*80)
print()
print(f"All data saved to: {output.absolute()}")
print()
print("Check the files for:")
print("  - Video IDs")
print("  - Course content")
print("  - Video URLs")
print("  - Access tokens")
print()
print("="*80)
