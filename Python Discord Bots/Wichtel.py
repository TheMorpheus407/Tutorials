import discord
import random

try:
    with open("users.txt", "r") as users_file:
        users = []
        for i in users_file.readlines():
            if i == "" or i == "\n":
                continue
            users.append(i.replace("\n", ""))

except FileNotFoundError:
    users = []
f = open("users.txt", "a")

print(users)

def add_user(user):
    if not str(user) in users:
        print("added " + str(user))
        f.writelines(str(user) + "\n")
        users.append(str(user))
        f.flush()
        return
    print("did not enter " + str(user) + ", because he's already participating.")


def is_self_sender(receivers, senders):
    for i, u in enumerate(receivers):
        if u == senders[i]:
            return True
    return False


class MyClient(discord.Client):
    # Einloggen
    async def on_ready(self):
        print("Ich habe mich eingeloggt. Beep bop.")

    # Wenn Nachricht gepostet wird
    async def on_message(self, message):
        if message.author == client.user:
            return

        if message.content.startswith("$wichteln"):
            msg = """Du hast dich zum Wichteln für Dezember 2019 beworben!
Dabei wird jemand zufälliges dir ein Geschenk zusenden und du wirst jemand anderem ein Geschenk zusenden.
Das erfordert Ehrlichkeit, du musst hier also nochmals zustimmen, dass du mitmachen möchtest. Wir verlassen uns darauf, dass alle Teilnehmer sich an die Abmachung halten.
Außerdem benötigt dein Partner natürlich eventuell Kontaktdaten von dir - Steam Account, Adresse ... . Dafür wird dein Discord Name an diese Person weitergeleitet, um einen Chat möglich zu machen.
Achte daher darauf, dass du Nachrichten erlaubt hast und auch regelmäßig dein Discord überprüfst.
Die Registrierung ist offen bis 30.11.19, die Geschenke sollten dann bis Weihnachten angekommen sein.
Um der Teilnahme ENDGÜLTIG zuzustimmen, antworte auf diese Nachricht mit "WICHTELN" (ohne Anführungsstriche).
"""
            await message.author.send(msg)

        if message.content.lower() == "wichteln" and str(message.channel.type) == "private":
            add_user(message.author)
            await message.author.send("Okay, du nimmst Teil. Dein Partner wird dir am 01.12. zugewiesen.")

        if message.content.startswith("$frage") and str(message.channel.type) == "private":
            add_user(message.author)
            await message.author.send("Okay, du nimmst Teil. Dein Partner wird dir am 01.12. zugewiesen.")

        if message.content.startswith("$notifywichtlers") and str(message.author) == "Morpheus#9581":
            for u in users:
                user_to_check = discord.utils.get(message.guild.members, name=u.split('#')[0],
                                                  discriminator=u.split('#')[1].replace('\n', ''))
                if user_to_check is None:
                    users.remove(u)
            receivers = users[:]
            senders = users[:]
            while is_self_sender(receivers, senders):
                print("recalculating")
                random.shuffle(receivers)
                random.shuffle(senders)
            # u ~ Username#Tag\n
            for i, u in enumerate(senders):
                user = discord.utils.get(message.guild.members, name=u.split('#')[0],
                                         discriminator=u.split('#')[1].replace('\n', ''))
                target = discord.utils.get(message.guild.members, name=receivers[i].split('#')[0],
                                           discriminator=receivers[i].split('#')[1].replace('\n', ''))
                await user.send(
                    "Dein Wichtelpartner ist " + target.mention + ". \n Antworte bitte bis zum 08.12. auf diese Nachricht mit $frage DEINENACHRICHT, um notwendige Daten von deinem Wichtelpartner zu bekommen.")
                await user.send(
                    "Deine Geschenkesender wird dich ebenfalls bis zum 08.12. über diesen Bot anschreiben.\n Sende ihm/ihr die Daten bzw Informationen, die er/sie benötigt mit $antwort DEINEANTWORT, damit alles reibungslos vonstatten gehen kann.")
                await user.send(
                    "Ihr solltet bis spätestens 15.12. alle Fragen geklärt haben! In der Woche darauf sollten sich die Geschenke auf den Weg machen. \n Es ist natürlich völlig in Ordnung mehrmals hin und her zu schreiben, damit zB Wünsche klar werden (wie zB nur online-Geschenke). \n Versucht dabei anonym zu bleiben, sonst geht der Spaß verloren.")


client = MyClient()
client.run("")
