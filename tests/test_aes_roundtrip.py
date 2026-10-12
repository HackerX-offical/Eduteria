from scraper.aes_crypto import EduteriaAES


def test_encrypt_decrypt_roundtrip():
    crypto = EduteriaAES.__new__(EduteriaAES)
    crypto.key = "0123456789abcdef"
    crypto.iv = "fedcba9876543210"
    payload = '{"user_id":"0"}'
    enc = crypto.encrypt(payload)
    assert enc is not None
    dec = crypto.decrypt(enc)
    assert dec == payload
