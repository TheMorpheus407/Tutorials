import random
class Entry:
	def __init__(self, deutsch, englisch):
		self.deutsch = deutsch
		self.englisch = englisch

eintraege = [Entry("hallo", "hello")]
	
def eingabe():
	while True:
		deutsch = input("Deutsches Wort: ")
		englisch = input("Englisches Wort: ")
		if deutsch == "#fertig" or englisch == "#fertig":
			return
		eintraege.append(Entry(deutsch, englisch))
		
def abfrage():
	while True:
		i = random.randint(0,len(eintraege)-1)
		englisch = input("Englische Übersetzung von " + eintraege[i].deutsch + ": ")
		if englisch == "#fertig":
			return
		if eintraege[i].englisch == englisch:
			print("korrekt!")
		else:
			print("leider falsch. Richtige Antwort: " + eintraege[i].englisch)
			
def printall():
	for eintrag in eintraege:
		print(eintrag.deutsch + " - " + eintrag.englisch)

while True:
	befehl = input("Befehl: ")
	if befehl == "eingabe":
		eingabe()
	elif befehl == "abfrage":
		abfrage()
	elif befehl == "beenden":
		break
	elif befehl == "ausgabe":
		printall()
	else:
		print("keine bekannte Ausgabe. Tippe: eingabe, abfrage, ausgabe oder beenden")