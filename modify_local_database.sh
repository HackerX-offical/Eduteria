#!/bin/bash
#
# Modify EDUTERIA's local database to add purchased courses
#

set -e

ADB="$HOME/platform-tools/adb"
PACKAGE="com.eduteria.app.app"
USER_ID="54204924"
COURSE_ID="48297"
COURSE_TITLE="Samarth - 72nd BPSC Mains Foundation"

echo "========================================================================"
echo "MODIFYING LOCAL DATABASE TO ADD COURSES"
echo "========================================================================"
echo

# Find the database file
echo "[1] Finding database location..."
DB_PATH=$($ADB shell "run-as $PACKAGE find /data/data/$PACKAGE/databases -name '*.db' 2>/dev/null | head -1" 2>/dev/null || echo "")

if [ -z "$DB_PATH" ]; then
 echo " Trying alternative path..."
 DB_PATH="/data/data/$PACKAGE/databases/utkash.db"
fi

echo " Database: $DB_PATH"
echo

# Pull the database
echo "[2] Pulling database from phone..."
TMP_DB="/tmp/eduteria_db.db"

$ADB shell "run-as $PACKAGE cat $DB_PATH" > "$TMP_DB" 2>/dev/null || {
 echo " Cannot access database (app may not be debuggable)"
 echo
 echo " Trying root access..."
 $ADB root 2>/dev/null && sleep 2
 $ADB pull "$DB_PATH" "$TMP_DB" || {
 echo " Root access failed"
 echo
 echo " ALTERNATIVE: Try manual SQL injection via ADB shell..."
 echo
 echo " Run these commands on your computer:"
 echo " $ adb shell"
 echo " $ run-as com.eduteria.app.app"
 echo " $ sqlite3 databases/utkash.db"
 echo " sqlite> INSERT INTO MycourseTable (id, title, userid, purchase_date, is_activated) VALUES ('$COURSE_ID', '$COURSE_TITLE', '$USER_ID', datetime('now'), '1');"
 echo " sqlite> .quit"
 echo
 exit 1
 }
}

echo " Database pulled"
echo

# Check if sqlite3 is available
if ! command -v sqlite3 &> /dev/null; then
 echo " sqlite3 not installed"
 echo " Install with: brew install sqlite3"
 exit 1
fi

# Modify the database
echo "[3] Modifying database..."

# First, check tables
echo " Available tables:"
sqlite3 "$TMP_DB" ".tables"
echo

# Insert course into MycourseTable
echo " Adding course $COURSE_ID..."

sqlite3 "$TMP_DB" <<EOF
INSERT OR REPLACE INTO MycourseTable 
 (id, title, userid, purchase_date, expiry_date, is_activated, delete) 
VALUES 
 ('$COURSE_ID', '$COURSE_TITLE', '$USER_ID', datetime('now'), '2030-12-31 23:59:59', '1', 0);
EOF

# Verify insertion
COUNT=$(sqlite3 "$TMP_DB" "SELECT COUNT(*) FROM MycourseTable WHERE id='$COURSE_ID';")
echo " Course added (count: $COUNT)"
echo

# Show added course
echo " Course details:"
sqlite3 "$TMP_DB" "SELECT * FROM MycourseTable WHERE id='$COURSE_ID';"
echo

# Push back to phone
echo "[4] Pushing modified database to phone..."

$ADB shell "run-as $PACKAGE cat > $DB_PATH" < "$TMP_DB" 2>/dev/null || {
 $ADB push "$TMP_DB" "$DB_PATH" || {
 echo " Cannot push database"
 echo " You may need to:"
 echo " 1. Stop the app"
 echo " 2. Copy database manually"
 exit 1
 }
}

echo " Database updated on phone"
echo

echo "========================================================================"
echo "SUCCESS!"
echo "========================================================================"
echo
echo "Course $COURSE_ID added to local database!"
echo
echo "TO TEST:"
echo " 1. Force stop EDUTERIA app"
echo " 2. Reopen app"
echo " 3. Go to 'My Courses'"
echo " 4. Course should appear!"
echo
echo "========================================================================"

# Cleanup
rm -f "$TMP_DB"
