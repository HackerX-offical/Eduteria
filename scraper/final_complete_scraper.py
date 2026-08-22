#!/usr/bin/env python3
"""
COMPLETE EDUTERIA Content Scraper
Authorization: EDUTERIA Written Approval (AUTHORIZATION.md)
Purpose: Extract ALL accessible content for security assessment
"""
import requests
import json
import re
from pathlib import Path
import time

COURSE_ID = "48297"
BASE_DIR = Path("../data/complete_scrape")
BASE_DIR.mkdir(parents=True, exist_ok=True)

print("="*80)
print("COMPLETE EDUTERIA CONTENT EXTRACTION")
print("Authorization: EDUTERIA Written Approval")
print("="*80)

# Track what we find
results = {
    "firebase_databases": {},
    "urls_found": [],
    "video_references": [],
    "course_data": {}
}

print("\n[1/5] Scraping ALL Firebase databases...")
firebase_dbs = ["166", "176", "Eduteria_Live", "Eduteria_appsquadz", "Rajput_appsquadz", "chat_master", "poc"]

for db in firebase_dbs:
    url = f"https://eduteria-b9a30-default-rtdb.firebaseio.com/{db}.json"
    try:
        print(f"  Fetching: {db}...", end=" ")
        r = requests.get(url, timeout=25)
        
        if r.status_code == 200 and r.text and r.text != "null":
            data = r.json()
            size_kb = len(r.text) / 1024
            print(f"✓ {size_kb:.1f} KB")
            
            results["firebase_databases"][db] = {
                "size_kb": size_kb,
                "has_course_48297": COURSE_ID in json.dumps(data),
                "has_video_refs": "video" in json.dumps(data).lower()
            }
            
            # Save
            (BASE_DIR / "firebase").mkdir(exist_ok=True)
            with open(BASE_DIR / "firebase" / f"{db}.json", "w") as f:
                json.dump(data, f, indent=2)
            
            # Extract URLs
            data_str = json.dumps(data)
            urls = re.findall(r'https?://[^\s"<>]+', data_str)
            results["urls_found"].extend(urls)
            
            # Look for course 48297
            if COURSE_ID in data_str:
                print(f"    → COURSE {COURSE_ID} MENTIONED!")
                # Try to extract context
                idx = data_str.find(COURSE_ID)
                context = data_str[max(0, idx-200):idx+200]
                results["course_data"][db] = context
        else:
            print(f"✗ Empty/null")
    except Exception as e:
        print(f"✗ Error: {str(e)[:50]}")
    
    time.sleep(0.5)  # Be respectful

print(f"\n[2/5] Analyzing {len(results['urls_found'])} URLs found...")
unique_urls = list(set(results["urls_found"]))
print(f"  Unique URLs: {len(unique_urls)}")

# Categorize URLs
video_urls = [u for u in unique_urls if any(x in u.lower() for x in ['.mp4', '.m3u8', 'video', 'stream', 'cdn'])]
api_urls = [u for u in unique_urls if 'api' in u.lower() or 'videocrypt' in u.lower()]

print(f"  Video-related: {len(video_urls)}")
print(f"  API-related: {len(api_urls)}")

# Save URLs
with open(BASE_DIR / "all_urls.txt", "w") as f:
    f.write("\n".join(unique_urls))

with open(BASE_DIR / "video_urls.txt", "w") as f:
    f.write("\n".join(video_urls))

print("\n[3/5] Checking S3 bucket...")
try:
    bucket = "vc-10000386-38616500102"
    r = requests.get(f"https://s3.ap-south-1.amazonaws.com/{bucket}/", timeout=15)
    
    if r.status_code == 200:
        files = re.findall(r'<Key>(.*?)</Key>', r.text)
        print(f"  ✓ S3 accessible: {len(files)} files found")
        
        # Look for course-related files
        course_files = [f for f in files if COURSE_ID in f or 'video' in f.lower()]
        print(f"  Course-related files: {len(course_files)}")
        
        # Save
        with open(BASE_DIR / "s3_all_files.txt", "w") as f:
            f.write("\n".join(files))
        
        with open(BASE_DIR / "s3_course_files.txt", "w") as f:
            f.write("\n".join(course_files))
        
        results["s3_files"] = len(files)
        results["s3_course_files"] = course_files
    else:
        print(f"  ✗ S3 not accessible ({r.status_code})")
except Exception as e:
    print(f"  ✗ S3 error: {e}")

print("\n[4/5] Testing video URLs...")
tested = 0
working = []

for url in video_urls[:10]:  # Test first 10
    try:
        r = requests.head(url, timeout=10, allow_redirects=True)
        status = "✓" if r.status_code == 200 else "✗"
        print(f"  {status} {r.status_code}: {url[:60]}...")
        if r.status_code == 200:
            working.append(url)
        tested += 1
    except:
        pass

results["working_video_urls"] = working

print("\n[5/5] Generating final report...")

# Create comprehensive report
report = f"""
COMPLETE EDUTERIA CONTENT EXTRACTION REPORT
===========================================

Date: {time.strftime('%Y-%m-%d %H:%M:%S')}
Target: Course {COURSE_ID} - Samarth 72nd BPSC Mains Foundation
Authorization: EDUTERIA Written Approval

RESULTS:
--------

1. Firebase Databases Scraped: {len(results['firebase_databases'])}
"""

for db, info in results['firebase_databases'].items():
    report += f"\n   {db}:"
    report += f"\n     Size: {info['size_kb']:.1f} KB"
    report += f"\n     Has Course {COURSE_ID}: {'YES' if info['has_course_48297'] else 'NO'}"
    report += f"\n     Has Video Refs: {'YES' if info['has_video_refs'] else 'NO'}"

report += f"""

2. URLs Extracted: {len(unique_urls)} unique URLs
   - Video-related: {len(video_urls)}
   - API-related: {len(api_urls)}
   - Working video URLs: {len(working)}

3. S3 Bucket: {'Accessible' if results.get('s3_files') else 'Not accessible'}
"""

if results.get('s3_files'):
    report += f"   - Total files: {results['s3_files']}\n"
    report += f"   - Course-related: {len(results.get('s3_course_files', []))}\n"

report += f"""

4. Course {COURSE_ID} References:
"""

if results['course_data']:
    for db, context in results['course_data'].items():
        report += f"\n   Found in {db}:\n   {context[:200]}...\n"
else:
    report += "   No direct references found in Firebase\n"

report += """

FILES CREATED:
--------------
"""

files_created = list(BASE_DIR.rglob("*"))
for f in files_created:
    if f.is_file():
        size_kb = f.stat().st_size / 1024
        report += f"  {f.relative_to(BASE_DIR)}: {size_kb:.1f} KB\n"

report += f"""

NEXT STEPS:
-----------
1. Review firebase/*.json for course data
2. Test URLs in video_urls.txt  
3. Check S3 files for accessible content
4. Use Frida/MITM for app-level video extraction

SUMMARY:
--------
Total data scraped: {sum(info['size_kb'] for info in results['firebase_databases'].values()):.1f} KB
Databases explored: {len(firebase_dbs)}
URLs found: {len(unique_urls)}
Working video URLs: {len(working)}

Assessment Status: {'COMPLETE' if working or results.get('s3_course_files') else 'PARTIAL - Need device for video extraction'}
"""

# Save report
with open(BASE_DIR / "EXTRACTION_REPORT.txt", "w") as f:
    f.write(report)

# Save results JSON
with open(BASE_DIR / "results.json", "w") as f:
    json.dump(results, f, indent=2)

print(report)

print("\n" + "="*80)
print("EXTRACTION COMPLETE!")
print(f"All data saved to: {BASE_DIR}")
print("="*80)

# Print working video URLs if any
if working:
    print("\n✓✓✓ WORKING VIDEO URLs FOUND! ✓✓✓")
    for url in working:
        print(f"  {url}")
