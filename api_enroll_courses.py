#!/usr/bin/env python3
"""
Try to enroll user via API endpoints
"""
import requests
import json

BEARER = "Bearer 117#Nerglnw3@@OI)30@I*Dm'@@_166"
BASE = "https://appapi.videocrypt.in"
USER_ID = "54204924"
COURSE_ID = "48297"

headers = {
    "Authorization": BEARER,
    "Content-Type": "application/json",
    "User-Agent": "okhttp/4.9.0"
}

print("="*80)
print("TRYING TO ENROLL VIA API")
print("="*80)
print()

# Try 1: Get my courses (see current state)
print("[1] Checking current enrolled courses...")
try:
    r = requests.post(
        f"{BASE}/index.php/data_model/course/get_my_courses",
        headers=headers,
        json={"user_id": USER_ID},
        timeout=10
    )
    print(f"Status: {r.status_code}")
    print(f"Response: {r.text[:500]}")
    print()
except Exception as e:
    print(f"Error: {e}\n")

# Try 2: Get my courses list
print("[2] Getting my course list...")
try:
    r = requests.post(
        f"{BASE}/index.php/data_model/courses/my_courses/get_list_of_my_courses",
        headers=headers,
        json={"user_id": USER_ID},
        timeout=10
    )
    print(f"Status: {r.status_code}")
    print(f"Response: {r.text[:500]}")
    print()
except Exception as e:
    print(f"Error: {e}\n")

# Try 3: Look for enrollment endpoints
enrollment_endpoints = [
    "/index.php/data_model/course/enroll",
    "/index.php/data_model/course/add_enrollment",  
    "/index.php/data_model/courses/enrollment/add",
    "/index.php/data_model/user/enroll_course",
    "/index.php/data_model/courses/my_courses/add_course"
]

print("[3] Trying enrollment endpoints...")
for endpoint in enrollment_endpoints:
    print(f"Trying: {endpoint}")
    try:
        r = requests.post(
            BASE + endpoint,
            headers=headers,
            json={
                "user_id": USER_ID,
                "course_id": COURSE_ID,
                "payment_status": "paid",
                "is_paid": "1"
            },
            timeout=10
        )
        print(f"  Status: {r.status_code}")
        if r.status_code != 404:
            print(f"  Response: {r.text[:200]}")
            if r.status_code == 200:
                try:
                    data = r.json()
                    if data.get('status'):
                        print("  ✓✓✓ SUCCESS!")
                        break
                except:
                    pass
        print()
    except Exception as e:
        print(f"  Error: {e}\n")

print("="*80)
