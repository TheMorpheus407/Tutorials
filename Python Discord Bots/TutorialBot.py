import discord
import time

class MyClient(discord.Client):
    #Einloggen
    async def on_ready(self):
        print("Ich habe mich eingeloggt. Beep bop.")

    #Wenn Nachricht gepostet wird
    async def on_message(self, message):
        if message.author == client.user:
            return

        if message.content.startswith("hello bot"):
            await message.channel.send('Hello!!!einseinself')
            await message.author.send("Du hast mich kontaktiert, was gibt's", delete_after=3.1)

        elif message.content.startswith("stats"):
            messages = await message.channel.history(limit=50).flatten()
            for i in messages:
                print(i.content)
            counter = 0
            async for m in message.channel.history():
                if m.author == client.user and m.content == "Leider verloren :(":
                    counter = counter + 1
            print(counter)
        elif message.content.startswith("onlinemembers"):
            members = client.guilds[0].members
            for i in members:
                if i.status == discord.Status.offline:
                    members.remove(i)
            for i in members:
                print(str(i))
        else:
            #await message.delete()
            #await message.edit(content=message.content + " - edited by TutBot")
            await message.pin()
            time.sleep(5)
            await message.unpin()
            await message.add_reaction("💩")

    async def on_typing(self, channel, user, when):
        return
        print(str(user) + " tippt gerade in " + str(channel) + " channel seit " + str(when))

    async def on_message_delete(self, message):
        print("Gelöschte Nachricht " + message.content)

    async def on_message_edit(self, before, after):
        print("Changed message " + before.content + " to " + after.content)

    async def on_reaction_add(self, reaction, user):
        await reaction.message.channel.send(str(user) + " reacted on " + reaction.message.content + " with " + reaction.emoji)
        await reaction.message.channel.send("Count: " + str(reaction.count))

    async def on_raw_reaction_add(self, payload):
        print(str(payload))
        channel = client.get_channel(payload.channel_id)
        user = client.get_user(payload.user_id)
        message = await channel.fetch_message(payload.message_id)
        await channel.send(str(user) + " reacted on " + message.content + " with " + str(payload.emoji))

    async def on_member_join(self, member):
        pass

    async def on_member_remove(self, member):
        pass

    async def on_member_update(self, before, after):
        #print(str(before.joined_at))
        #print(str(before.activities))
        #print(str(before.guild))
        #print(str(before.nick))
        #print(str(before.mobile_status))
        #print(str(before.desktop_status))
        #print(str(before.web_status))
        #print(str(before.roles))
        roles = discord.utils.get(after.guild.roles, name='Zum Verteilen')
        await after.add_roles(roles)



client = MyClient()
client.run("")