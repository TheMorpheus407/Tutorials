import math


def isPrime(number):
    if number > 1:
        if number == 2:
            return True
        if number % 2 == 0:
            return False
        for i in range(3, int(math.sqrt(number) + 1), 2):
            if number % i == 0:
                return False
        return True
    return False


def fetchPrimes(number=2):
    while True:
        if isPrime(number):
            yield number
        number += 1

prime_generator = fetchPrimes()
for i in range(500):
    print(prime_generator.send(None))
