from AbstractClasses.Tier import Tier


class Hund(Tier):
    def laufen(self):
        print("laufen")


einTier = Tier()
einTier.laufen()
