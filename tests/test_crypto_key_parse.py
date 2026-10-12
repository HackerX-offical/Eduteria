from scraper.crypto_key_parse import decrypt_password, derive_indexed_string


def test_decrypt_password_splits_marker():
    raw = "prefix1090##aGVsbG8=1090##suffix"
    out = decrypt_password(raw)
    assert isinstance(out, str)
    assert len(out) > 0


def test_derive_indexed_string_pads():
    s = derive_indexed_string("abcdefghij", "01", size=16)
    assert len(s) == 16
