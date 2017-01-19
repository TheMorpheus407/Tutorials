import threading
import time

class myFred(threading.Thread):
	Ergebnis = [0,1]
	def __init__(self, iD, name):
		threading.Thread.__init__(self)
		self.iD = iD
		self.name = name
	def run(self):
		i = 0
		while i < 20:
			zahl = myFred.Ergebnis[len(myFred.Ergebnis)-2] + myFred.Ergebnis[len(myFred.Ergebnis)-1]
			lockMe.acquire()
			myFred.Ergebnis.append(zahl)
			lockMe.release()
			i = i+1
lockMe = threading.Lock()
t1 = myFred(1, "t1")
t2 = myFred(2, "t2")
t3 = myFred(3, "t2")
t2.start()
t1.start()
t3.start()
t1.join()
t2.join()
t3.join()
print(myFred.Ergebnis[50])