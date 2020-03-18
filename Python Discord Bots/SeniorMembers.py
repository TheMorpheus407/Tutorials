import asyncio
import discord
import random
import datetime
from discord.utils import get
import time

async def add_senior_role():
    while True:
        try:
            guild = get(client.guilds, name="The Morpheus Tutorials")
            members = guild.members
            senior_role = get(guild.roles, name="Senior")
            members = [i for i in members if not i.bot and not senior_role in i.roles]
            for i in members:
                if datetime.datetime.now() - i.joined_at > datetime.timedelta(days=30):
                    await i.add_roles(senior_role)
                    print("Added Senior Role for " + i.name + "#" + i.discriminator)
        except:
            pass
        await asyncio.sleep(60*60*24)

class MyClient(discord.Client):
    #Einloggen
    async def on_ready(self):
        print("Ich habe mich eingeloggt. Beep bop.")

    #Wenn Nachricht gepostet wird
    async def on_message(self, message):
        if message.author == client.user:
            return

        if message.content == "$help":
            print("Help")

        if message.content == "SeniorBot Go":
            while True:
                members = message.guild.members
                senior_role = get(message.guild.roles, name="Kotlin")
                print(members)
                members = [i for i in members if not i.bot and not senior_role in i.roles]
                print(members)
                for i in members:
                    if datetime.datetime.now() - i.joined_at > datetime.timedelta(days=30):
                        await i.add_roles(senior_role)
                        print("Added Senior Role for " + i.name +"#" + i.discriminator)
                time.sleep(60)

client = MyClient()
client.loop.create_task(add_senior_role())
client.run("")