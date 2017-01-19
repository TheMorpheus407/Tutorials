import socket

host = ''
port = 1337
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.bind((host, port))
s.listen(3)
connection, addr = s.accept()
print("Connection established to " + addr[0])
data = connection.recv(256)
print(data)
while True:
    cmd = raw_input("Command: ")
    connection.send(cmd)
    data = connection.recv(256)
    print(data)
connection.close()