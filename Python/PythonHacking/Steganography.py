f = open("/home/morpheus/Tuts/Python/Python.jpg",
         encoding="ISO-8859-1", mode="r")
# f.write("Warum bringen Informatiker immer Helloween und Weihnachten durcheinander?")
try:
    byte = f.read(1)
    str = ""
    while byte != "":
        str = str + byte
        byte = f.read(1)
    print(str)
finally:
    f.close()