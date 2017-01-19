from Crypto import Random
from Crypto.Cipher import AES
import hashlib

def pad(str):
    while len(str)%16 != 0:
        str = str + " "
    return str

def enc(key, message):
    iv = Random.new().read(16)
    message = pad(message)
    key = hashlib.sha256(str.encode(key))
    cipher = AES.new(key.digest(), AES.MODE_CBC, iv)
    return (cipher.encrypt(message), iv)

def dec(key, ciphertext, iv):
    key = hashlib.sha256(str.encode(key))
    cipher = AES.new(key.digest(), AES.MODE_CBC, iv)
    return cipher.decrypt(ciphertext)

(cipher, iv) = enc("password", "Oct(31) = Dec(25)")
print(cipher)
print(dec("password", cipher, iv))