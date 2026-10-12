"""Pure helpers extracted from AES key material parsing (testable without network)."""

import base64


def decrypt_password(encoded_key: str) -> str:
    parts = encoded_key.split("1090##", 1)
    if len(parts) != 2:
        return encoded_key
    middle_parts = parts[1].split("==", 1)
    if not middle_parts:
        return encoded_key
    middle = middle_parts[0] + "=="
    try:
        return base64.b64decode(middle).decode("utf-8")
    except Exception:
        return middle


def derive_indexed_string(char_array: str, base_string: str, size: int = 16) -> str:
    result = ""
    for char in base_string:
        idx = int(char)
        if idx < len(char_array):
            result += char_array[idx]
    while len(result) < size:
        result += "0"
    return result[:size]
