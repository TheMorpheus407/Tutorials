import socket
import sys
from datentime import datentime

target = "scanme.nmap.org"
targetIP = socket.gethostbyname(target)

tstart = datentime.now()

try:
    for p in range(1, 30):
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        res = sock.connect_ex((targetIP, p))
        if res == 0:
            print("Offene Verbindung in Port " + str(p))
        sock.close()
except Exception:
    print("There was an error.")
    sys.exit()

tend = datentime.now()
diff = tend - tstart

print("Scan completed in " + str(diff))

