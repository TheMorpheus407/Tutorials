import zipfile
import itertools
import string
from threading import Thread
import hashlib

zipFile = zipfile.ZipFile("/home/morpheus/Tuts/Python/Python.jpg.zip")

def bruteforce():
    myLetters = string.ascii_letters + string.digits + string.punctuation
    for i in range(3,10):
        for j in map(''.join, itertools.product(myLetters, repeat=i)):
            t = Thread(target=crack, args=(zipFile, j))
            t.start()

def dictionary():
    passwords = open("passwordlist.txt")
    for line in passwords.readlines():
        pwd = line.strip('\n')
        t = Thread(target=crack, args=(zipFile, pwd))
        t.start()

def gen_rainbowtable():
    passwords = open("passwordlist.txt")
    output = open("rainbowtable.txt", "w")
    for line in passwords.readlines():
        pwd = line.strip('\n')
        hash = hashlib.sha512(str.encode(pwd))
        output.write(hash.hexdigest() + "#" + pwd + "\n")
    output.close()
    passwords.close()

def crackHash(hash):
    rainbowtable = open("rainbowtable.txt")
    for line in rainbowtable.readlines():
        hashpwd = line.split('#', 1)
        if hash == hashpwd[0]:
            print("Success: Password is " + hashpwd[1])

def crack(zip, pwd):
    try:
        zip.extractall(pwd=str.encode(pwd))
        print('Success: Password is ' + pwd)
    except:
        pass

crackHash("a2f4dd0f4cac3707e2ec53a8fed5d3e38698e5b0fd4260fb9a2b14fcfb3f2ba052ae79ce02fac9fef291010c55d2ddb79b23132fad4d10e3e7de186d2b5d70aa")


