'''
Multithreading
- Shared Memory
- UIs
- I/O
- Hyper Threading
- Threads spawnen schneller
- Python ist zuständig

Multiprocessing
- Eigener Memory Space
- eigener CPU Kern
- Kindprozesse kann man töten
- Prozesse brauchen länger bis sie erstellt sind
- System verwaltet
'''
import multiprocessing
import math
import threading
import random
import time
import sys

# 4 = 2*2
def factorize(num):
    res = []
    i = 2
    while True:
        if num == 1:
            return res
        rest = num % i
        if rest == 0:
            res.append(i)
            num = num // i
        else:
            i = i+1

def mt_worker(outdict, numbers):
        for num in numbers:
            outdict[num] = factorize(num)

def mt_factor(numbers, num_threads):
    chunk = int(math.ceil(len(numbers) / num_threads))
    threads = []
    outs = [{} for i in range(num_threads)]
    for i in range(num_threads):
        t = threading.Thread(
            target=mt_worker,
            args=(outs[i], numbers[chunk * i:chunk * (i + 1)]))
        threads.append(t)
        t.start()

    for t in threads:
        t.join()

    return {key: v for out_dict in outs for key, v in out_dict.items()}

#{42: [2*7*3], 1337:...}
def mp_worker(queue, numbers):
    result = {}
    for i in numbers:
        result[i] = factorize(i)
    queue.put(result)

def mp_factor(numbers, processes):
    queue = multiprocessing.Queue()
    chunks = int(math.ceil(len(numbers) / processes))
    procs = []
    for i in range(processes):
        proc = multiprocessing.Process(target=mp_worker, args=(queue, numbers[chunks*i:chunks*(i+1)]))
        procs.append(proc)
        proc.start()

    results = {}
    for i in range(processes):
        results.update(queue.get())

    for i in procs:
        i.join()
    return results


if __name__ == '__main__':
    numbers = []
    for i in range(8*1024*16):
        numbers.append(random.randint(1, 50000))
    for procs in [1,2,4,8]:
        start = time.time()
        res = mp_factor(numbers, procs)
        print("Multiprocessing with " + str(procs) +" Processes took " + str((time.time() - start)) + " seconds.")
    for threads in [2,4,8]:
        start = time.time()
        res = mt_factor(numbers, threads)
        print("Multithreading with " + str(threads) +" Threads took " + str((time.time() - start)) + " seconds.")
