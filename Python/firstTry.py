class Lebewesen:
	augen = 3
	def __init__(self):
		self.klasse = "säuger"
	
	def lebe(self):
		self.augen = 4

class Haustier(Lebewesen):
	pfoten = 4
	ohren = 3
		
class Saeuger(Lebewesen):
	ohren = 2
		
class Hund(Haustier, Saeuger):
	augen = 5
	beine = 42
	name = "bulldogge"
	
	def __init__(self, buchstabeneu='a'):
		self.buchstabe = buchstabeneu
		self.list = []
	
	def do_something(self, neuezahl):
		self.augen = neuezahl
		self.lebe()
		
	def lebe(self):
		self.beine = 43
		
fiffi =  Hund()
print(fiffi.augen)





