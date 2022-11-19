import struct
import random
numbers = [random.randint(0, 1000) for i in range(0, 10)]
with open("prob4.txt", "w") as f:
    for number in numbers:
        f.write("{}\n".format(number))
with open("prob4.bin", "wb") as f:
    for number in numbers:
        f.write(struct.pack(">I", number)) # < for little endian, I for 4-bit
