#!/usr/bin/env python3
"""
DIRECT API VIDEO SCRAPER - NO APP NEEDED!
We have the Bearer token and AES encryption - access videos directly!
"""
import requests
import json
from aes_crypto import EduteriaAES
from pathlib import Path
import re

print("="*80)
print("DIRECT API VIDEO EXTRACTION - BYPASSING APP COMPLETELY")
print("="*80)
print("")

# Setup
BEARER = "Bearer 117#Nerglnw3@@OI)30@I*Dm'@@_166"
BASE = "https://appapi.videocrypt.in"
COURSE_ID = "48297"
aes = EduteriaAES()

output_dir = Path("../data/api_extracted_videos")
output_dir.mkdir(parents=True, exist_ok=True)

headers = {
    "Authorization": BEARER,
    "Content-Type": "application/json",
    "User-Agent": "okhttp/4.9.0"
}

# Try multiple API endpoints to get video data
endpoints_to_try = [
    {
        "name": "Get course sections",
        "url": f"{BASE}/index.php/data_model/course/get_course_sections",
        "data": {"course_id": COURSE_ID}
    },
    {
        "name": "Get course content",
        "url": f"{BASE}/index.php/data_model/course/get_course_content", 
        "data": {"course_id": COURSE_ID}
    },
    {
        "name": "Get all videos",
        "url": f"{BASE}/index.php/data_model/course/get_all_videos",
        "data": {"course_id": COURSE_ID}
    },
    {
        "name": "Course details",
        "url": f"{BASE}/index.php/data_model/course/course_details",
        "data": {"course_id": COURSE_ID}
    },
    {
        "name": "Get videos list",
        "url": f"{BASE}/index.php/data_model/video/get_course_videos",
        "data": {"course_id": COURSE_ID}
    },
]

print("[1/3] Trying all possible API endpoints...")
print("")

all_video_data = {}

for i, endpoint in enumerate(endpoints_to_try, 1):
    print(f"  [{i}/{len(endpoints_to_try)}] {endpoint['name']}...")
    
    try:
        # Try without encryption first
        r = requests.post(
            endpoint['url'],
            headers=headers,
            json=endpoint['data'],
            timeout=15
        )
        
        if r.status_code == 200:
            try:
                data = r.json()
                # Save response
                filename = f"{endpoint['name'].replace(' ', '_').lower()}.json"
                with open(output_dir / filename, "w") as f:
                    json.dump(data, f, indent=2)
                
                if data.get("status"):
                    print(f"     ✓ SUCCESS! {len(str(data))} bytes")
                    all_video_data[endpoint['name']] = data
                else:
                    msg = data.get("message", "Unknown error")
                    print(f"     ✗ {msg}")
            except:
                print(f"     Response: {r.text[:100]}")
        else:
            print(f"     ✗ HTTP {r.status_code}")
            
    except Exception as e:
        print(f"     ✗ Error: {str(e)[:50]}")

print("")
print("[2/3] Searching for video URLs in all data...")
print("")

all_urls = set()
video_info = []

# Search all responses for video URLs and data
for name, data in all_video_data.items():
    data_str = json.dumps(data)
    
    # Find URLs
    urls = re.findall(r'https?://[^\s"<>]+', data_str)
    for url in urls:
        if any(x in url.lower() for x in ['.m3u8', '.mp4', 'video', 'stream']):
            all_urls.add(url)
    
    # Look for video objects
    def find_videos(obj, path=""):
        if isinstance(obj, dict):
            if 'video_url' in obj or 'url' in obj or 'link' in obj:
                video_info.append({
                    'path': path,
                    'data': obj
                })
            for k, v in obj.items():
                find_videos(v, f"{path}/{k}")
        elif isinstance(obj, list):
            for i, v in enumerate(obj):
                find_videos(v, f"{path}[{i}]")
    
    find_videos(data, name)

print(f"  Found {len(all_urls)} video URLs")
print(f"  Found {len(video_info)} video objects")

# Save all URLs
if all_urls:
    with open(output_dir / "all_video_urls.txt", "w") as f:
        f.write("\n".join(sorted(all_urls)))
    
    print("")
    print("  Sample URLs:")
    for url in list(all_urls)[:5]:
        print(f"    {url}")

# Save video info
if video_info:
    with open(output_dir / "video_objects.json", "w") as f:
        json.dump(video_info, f, indent=2)

print("")
print("[3/3] Trying to access specific course videos...")
print("")

# If we found video IDs, try to get their playback URLs
video_ids_found = set()
for info in video_info:
    data = info['data']
    if 'id' in data:
        video_ids_found.add(str(data['id']))
    if 'video_id' in data:
        video_ids_found.add(str(data['video_id']))

print(f"  Found {len(video_ids_found)} video IDs")

for vid_id in list(video_ids_found)[:10]:
    print(f"  Getting playback URL for video {vid_id}...")
    
    try:
        r = requests.post(
            f"{BASE}/index.php/data_model/video/get_video_url",
            headers=headers,
            json={"video_id": vid_id},
            timeout=10
        )
        
        if r.status_code == 200:
            data = r.json()
            if data.get("status") and data.get("data"):
                url = data['data'].get('url') or data['data'].get('video_url')
                if url:
                    print(f"     ✓ Got URL: {url[:60]}...")
                    all_urls.add(url)
    except:
        pass

# Final summary
print("")
print("="*80)
print("EXTRACTION COMPLETE!")
print("="*80)
print("")
print(f"Total video URLs found: {len(all_urls)}")
print(f"Total API responses saved: {len(all_video_data)}")
print("")
print("Files saved to:", output_dir)
print("")

if all_urls:
    print("✓✓✓ SUCCESS! Video URLs extracted without app!")
    print("")
    print("Next: Download videos with:")
    print(f"  cd {output_dir}")
    print("  while read url; do wget \"$url\"; done < all_video_urls.txt")
else:
    print("⚠ No video URLs found. API may require different approach.")
    print("Check saved JSON files for available data.")

print("")
print("="*80)
