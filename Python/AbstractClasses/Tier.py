from abc import ABCMeta, abstractmethod


class Tier:
    __metaclass__ = ABCMeta

    @abstractmethod
    def laufen(self):
        pass
