#!/usr/bin/env python3
"""
EDUTERIA AES Encryption Module
Extracted from: com.appnew.android.Utils.AES.java
Purpose: Encrypt API payloads to bypass version check
"""

import base64
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad

class EduteriaAES:
    """AES encryption matching EDUTERIA Android app"""
    
    # Extracted from AES.java
    ARRAY_KEY = "MTA5MCMj1090##JSFGKiZeJClfKiUzZiZCKw==XWc7dnMnMmFs"
    ARRAY_VECTOR = "MTA5MCMj1090##IyokREp2eXcydyUhXy0kQA==XWc7dnMnMmFs"
    
    # For user_id = 0 (unauthenticated)
    BASE_STRING = "0117108641864451"  # "01171086418644515_166".substring(0, 16)
    
    def __init__(self):
        self.key = self._generate_key_api()
        self.iv = self._generate_vector_api()
        print(f"[AES] Key: {self.key[:8]}... IV: {self.iv[:8]}...")
    
    def _decrypt_password(self, encoded_key):
        """
        Decrypt the base64 encoded key array
        From: encryptPassword() in AES.java
        """
        # Split by "1090##"
        parts = encoded_key.split("1090##", 1)
        if len(parts) != 2:
            return encoded_key
        
        # Get the middle part before "=="
        middle_parts = parts[1].split("==", 1)
        if len(middle_parts) < 1:
            return encoded_key
        
        middle = middle_parts[0] + "=="
        
        # Decode base64
        try:
            decoded = base64.b64decode(middle).decode('utf-8')
            return decoded
        except:
            return middle
    
    def _generate_key_api(self):
        """
        Generate API encryption key
        From: generatekeyAPI() in AES.java lines 77-89
        """
        # Decrypt the array key
        char_array = self._decrypt_password(self.ARRAY_KEY)
        
        # Build key from base string
        result = ""
        for char in self.BASE_STRING:
            idx = int(char)
            if idx < len(char_array):
                result += char_array[idx]
        
        # Pad to 16 bytes
        while len(result) < 16:
            result += "0"
        
        return result[:16]
    
    def _generate_vector_api(self):
        """
        Generate API encryption IV
        From: generateVectorAPI() in AES.java lines 91-103
        """
        # Decrypt the array vector
        char_array = self._decrypt_password(self.ARRAY_VECTOR)
        
        # Build IV from base string
        result = ""
        for char in self.BASE_STRING:
            idx = int(char)
            if idx < len(char_array):
                result += char_array[idx]
        
        # Pad to 16 bytes
        while len(result) < 16:
            result += "0"
        
        return result[:16]
    
    def encrypt(self, data):
        """
        Encrypt data for API request
        From: encrypt() in AES.java lines 26-40
        """
        try:
            # Create cipher
            cipher = AES.new(
                self.key.encode('utf-8'),
                AES.MODE_CBC,
                self.iv.encode('utf-8')
            )
            
            # Pad data to 16-byte boundary
            padded_data = pad(data.encode('utf-8'), AES.block_size)
            
            # Encrypt
            encrypted = cipher.encrypt(padded_data)
            
            # Base64 encode and add colon
            encoded = base64.b64encode(encrypted).decode('utf-8')
            
            return encoded + ":"
        except Exception as e:
            print(f"[AES] Encryption error: {e}")
            return None
    
    def decrypt(self, data, key=None, iv=None):
        """
        Decrypt API response
        From: decrypt() in AES.java lines 57-75
        """
        try:
            # Remove colon if present
            if ":" in data:
                data = data.split(":")[0]
            
            # Use provided key/iv or defaults
            key = key or self.key
            iv = iv or self.iv
            
            # Create cipher
            cipher = AES.new(
                key.encode('utf-8'),
                AES.MODE_CBC,
                iv.encode('utf-8')
            )
            
            # Decode and decrypt
            decoded = base64.b64decode(data)
            decrypted = cipher.decrypt(decoded)
            
            # Remove padding
            unpadded = unpad(decrypted, AES.block_size)
            
            return unpadded.decode('utf-8')
        except Exception as e:
            print(f"[AES] Decryption error: {e}")
            return None

def test_encryption():
    """Test the encryption"""
    crypto = EduteriaAES()
    
    # Test payload
    test_data = '{"user_id":"0"}'
    
    print(f"\n[TEST] Original: {test_data}")
    encrypted = crypto.encrypt(test_data)
    print(f"[TEST] Encrypted: {encrypted[:50]}...")
    
    return crypto

if __name__ == "__main__":
    test_encryption()
