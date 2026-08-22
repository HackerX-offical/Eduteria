#!/usr/bin/env python3
"""
NUCLEAR OPTION: Scrape ENTIRE Firebase database recursively
Get ALL content, videos, PDFs, links - EVERYTHING
"""
import requests
import json
from pathlib import Path
import time
import re

FIREBASE = "https://eduteria-b9a30-default-rtdb.firebaseio.com"
USER_ID = "54204924"
COURSE_ID = "48297"

output = Path("data/NUCLEAR_SCRAPE")
output.mkdir(parents=True, exist_ok=True)

print("="*80)
print("NUCLEAR SCRAPE - DOWNLOADING ENTIRE DATABASE")
print("="*80)
print()

# Strategy 1: Download ENTIRE Firebase database
print("[1] Downloading ENTIRE Firebase database (this will take time)...")
print()

try:
    print("  Fetching root...")
    r = requests.get(f"{FIREBASE}/.json", timeout=60)
    if r.status_code == 200:
        entire_db = r.json()
        
        # Save entire database
        db_file = output / "ENTIRE_FIREBASE_DATABASE.json"
        with open(db_file, 'w') as f:
            json.dump(entire_db, f, indent=2)
        
        size_mb = db_file.stat().st_size / (1024*1024)
        print(f"  ✓ Downloaded entire database: {size_mb:.2f} MB")
        print(f"  ✓ Saved to: {db_file}")
        print()
        
        # Parse for useful data
        print("[2] Parsing database for content...")
        print()
        
        # Find all video IDs
        video_ids = set()
        video_urls = set()
        pdf_urls = set()
        content_urls = set()
        
        def extract_content(obj, path=""):
            if isinstance(obj, dict):
                # Look for video IDs
                for key in ['video_id', 'vdocipher_id', 'vdo_id', 'videoId']:
                    if key in obj and obj[key]:
                        video_ids.add(str(obj[key]))
                
                # Look for URLs
                for key in ['url', 'video_url', 'pdf_url', 'link', 'file_url', 'thumbnail']:
                    if key in obj and obj[key]:
                        val = str(obj[key])
                        if 'http' in val:
                            if '.pdf' in val.lower():
                                pdf_urls.add(val)
                            elif 'video' in val.lower() or 'vdo' in val.lower():
                                video_urls.add(val)
                            else:
                                content_urls.add(val)
                
                # Look for course 48297 specifically
                if 'course_id' in obj and str(obj.get('course_id')) == COURSE_ID:
                    filename = f"COURSE_{COURSE_ID}_data_{len(list(output.glob('COURSE_48297_*')))}.json"
                    with open(output / filename, 'w') as f:
                        json.dump(obj, f, indent=2)
                    print(f"  ✓ Found course {COURSE_ID} data! Saved: {filename}")
                
                for k, v in obj.items():
                    extract_content(v, f"{path}/{k}")
            
            elif isinstance(obj, list):
                for item in obj:
                    extract_content(item, path)
            
            elif isinstance(obj, str):
                # Check for URLs in strings
                if 'http' in obj:
                    if '.pdf' in obj.lower():
                        pdf_urls.add(obj)
                    elif any(x in obj.lower() for x in ['video', 'vdo', 'm3u8', 'mp4']):
                        video_urls.add(obj)
                    else:
                        content_urls.add(obj)
        
        extract_content(entire_db)
        
        print()
        print(f"  ✓ Found {len(video_ids)} video IDs")
        print(f"  ✓ Found {len(video_urls)} video URLs")
        print(f"  ✓ Found {len(pdf_urls)} PDF URLs")
        print(f"  ✓ Found {len(content_urls)} other content URLs")
        print()
        
        # Save all findings
        if video_ids:
            with open(output / "ALL_VIDEO_IDS.json", 'w') as f:
                json.dump(sorted(list(video_ids)), f, indent=2)
            print(f"  Sample video IDs: {list(video_ids)[:5]}")
        
        if video_urls:
            with open(output / "ALL_VIDEO_URLS.txt", 'w') as f:
                f.write('\n'.join(sorted(video_urls)))
            print(f"  Sample video URLs: {list(video_urls)[:3]}")
        
        if pdf_urls:
            with open(output / "ALL_PDF_URLS.txt", 'w') as f:
                f.write('\n'.join(sorted(pdf_urls)))
            print(f"  ✓ Saved {len(pdf_urls)} PDF URLs")
        
        if content_urls:
            with open(output / "ALL_CONTENT_URLS.txt", 'w') as f:
                f.write('\n'.join(sorted(content_urls)))
        
        print()

except Exception as e:
    print(f"  ✗ Error: {e}")
    print()

# Strategy 2: Search for all course data
print("[3] Searching for ALL course data in database...")
print()

try:
    # Get course lists from different paths
    course_paths = [
        "/166/courses",
        "/courses",
        "/Eduteria_Live",
        "/course_master",
        "/all_courses"
    ]
    
    all_courses = {}
    
    for path in course_paths:
        try:
            r = requests.get(f"{FIREBASE}{path}.json", timeout=20)
            if r.status_code == 200:
                data = r.json()
                if data and data != "null":
                    print(f"  ✓ Found courses at: {path}")
                    
                    # Save it
                    filename = path.replace('/', '_') + '_courses.json'
                    with open(output / filename, 'w') as f:
                        json.dump(data, f, indent=2)
                    
                    # Count courses
                    if isinstance(data, dict):
                        all_courses.update(data)
        except:
            pass
    
    print(f"  ✓ Total unique courses found: {len(all_courses)}")
    print()

except Exception as e:
    print(f"  ✗ Error: {e}")

# Strategy 3: Get ALL user data (you're premium now)
print("[4] Getting ALL your user data...")
print()

try:
    user_data_paths = [
        f"/users/{USER_ID}",
        f"/166/users/{USER_ID}",
        f"/user_data/{USER_ID}",
        f"/166/user_data/{USER_ID}",
        f"/user_courses/{USER_ID}",
        f"/enrollments/{USER_ID}",
        f"/subscriptions/{USER_ID}",
        f"/my_courses/{USER_ID}"
    ]
    
    for path in user_data_paths:
        try:
            r = requests.get(f"{FIREBASE}{path}.json", timeout=10)
            if r.status_code == 200:
                data = r.json()
                if data and data != "null" and data != {}:
                    filename = 'USER_' + path.replace('/', '_') + '.json'
                    with open(output / filename, 'w') as f:
                        json.dump(data, f, indent=2)
                    print(f"  ✓ Saved: {filename}")
        except:
            pass
    print()

except Exception as e:
    print(f"  ✗ Error: {e}")

# Strategy 4: Try to find video content by searching for common patterns
print("[5] Searching for video content patterns...")
print()

try:
    # Common video storage paths
    video_paths = [
        "/videos",
        "/166/videos",
        "/video_master",
        "/live_videos",
        "/recorded_videos",
        "/vod_videos",
        "/course_videos"
    ]
    
    for path in video_paths:
        try:
            r = requests.get(f"{FIREBASE}{path}.json?shallow=true", timeout=10)
            if r.status_code == 200:
                data = r.json()
                if data and data != "null":
                    print(f"  ✓ Videos found at: {path}")
                    
                    # Get full data
                    r2 = requests.get(f"{FIREBASE}{path}.json", timeout=30)
                    if r2.status_code == 200:
                        full_data = r2.json()
                        filename = path.replace('/', '_') + '_videos.json'
                        with open(output / filename, 'w') as f:
                            json.dump(full_data, f, indent=2)
                        print(f"    Saved: {filename}")
        except:
            pass
    print()

except Exception as e:
    print(f"  ✗ Error: {e}")

print("="*80)
print("NUCLEAR SCRAPE COMPLETE")
print("="*80)
print()
print(f"All data saved to: {output.absolute()}/")
print()

# Summary
files = list(output.glob('*'))
total_size = sum(f.stat().st_size for f in files if f.is_file()) / (1024*1024)

print(f"✓ Scraped {len(files)} files")
print(f"✓ Total size: {total_size:.2f} MB")
print()

# List important files
print("IMPORTANT FILES:")
for f in files:
    if f.is_file():
        size = f.stat().st_size / 1024
        print(f"  - {f.name} ({size:.1f} KB)")

print()
print("="*80)
print()

# Final summary
if (output / "ALL_VIDEO_IDS.json").exists():
    with open(output / "ALL_VIDEO_IDS.json") as f:
        vids = json.load(f)
    print(f"✓✓✓ FOUND {len(vids)} VIDEO IDs IN DATABASE!")
    print(f"    These can potentially be accessed via VideoCrypt API")
    print()

if (output / "ALL_VIDEO_URLS.txt").exists():
    with open(output / "ALL_VIDEO_URLS.txt") as f:
        urls = f.read().strip().split('\n')
    print(f"✓✓✓ FOUND {len(urls)} DIRECT VIDEO URLs!")
    print(f"    These are REAL video links you can try!")
    print()

if (output / "ALL_PDF_URLS.txt").exists():
    with open(output / "ALL_PDF_URLS.txt") as f:
        pdfs = f.read().strip().split('\n')
    print(f"✓✓✓ FOUND {len(pdfs)} PDF URLs!")
    print(f"    Direct download links for course materials!")
    print()

print("="*80)
