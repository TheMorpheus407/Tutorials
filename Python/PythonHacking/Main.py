from Crypto.Cipher import AES
import base64, random, string, sys

BLOCK_SIZE = 32
PADDING = '{'

pad = lambda s: str(s) + (BLOCK_SIZE - len(str(s)) % BLOCK_SIZE) * PADDING
Enc = lambda c, m: base64.b64encode(c.encrypt(pad(m)))
Dec = lambda c, e: c.decrypt(base64.b64decode(e)).rstrip(PADDING)

def randomKey(bytes):
    return ''.join(random.choice(string.ascii_letters + string.digits
                                 + "{}!@#$[]|?/&^") for i in range(bytes))
def randomName():
    return ''.join(random.choice(string.ascii_letters + string.digits) for i in range(3))

def randomAscii():
    return ''.join(random.choice(string.ascii_letters) for i in range(3))



key = randomKey(32)
iv = randomKey(16)

cipher = AES.new(key, AES.MODE_CBC, iv)

input = open("Passwordcracker.py").readlines()
output = open("myFile_encrypted.py", mode='w')

imports = list()
lines = list()

for s in input:
    if not s.startswith('#'):
        if "import" in s:
            imports.append(s.strip())
        else:
            lines.append(s)
enced = Enc(cipher, "".join(lines))

b64name = randomAscii() + randomName()
aesName = randomAscii() + randomName()
imports.append("from base64 import b64decode as " + b64name)
imports.append("from Crypto.Cipher import AES as " + aesName)
random.shuffle(imports)
output.write(";".join(imports) + "\n")
cmd = "exec(%s.new(\"%s\", %s.MODE_CBC, \"%s\").decrypt(%s(\"%s\")).rstrip('{'))\n" %(aesName, key, aesName, iv, b64name, enced)
output.write("exec(%s(\"%s\"))" % (b64name, base64.b64encode(cmd)))
output.close()