from pathlib import Path


def test_scraper_package_has_aes_module():
    root = Path(__file__).resolve().parents[1]
    assert (root / "scraper" / "aes_crypto.py").is_file()
    assert (root / "scraper" / "crypto_key_parse.py").is_file()
