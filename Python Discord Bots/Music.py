import discord
import random
import datetime
from discord.utils import get
import time


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

        if message.content.startswith("$play"):
            where = message.content.split(" ")[1]
            channel = get(message.guild.channels, name=where)
            voicechannel = await channel.connect()
            voicechannel.play(discord.FFmpegPCMAudio('ES_Evicted.mp3'))
            while voicechannel.is_playing():
                time.sleep(5)
            voicechannel.play(discord.FFmpegPCMAudio('ES_Evicted.mp3'))
            if voicechannel.is_paused():
                pass
            voicechannel.stop()
            voicechannel.pause()
            voicechannel.resume()


client = MyClient()
client.run("")