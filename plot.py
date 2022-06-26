import matplotlib.pyplot as plt
n =[ ]
time = []

f = open("/home/aniket/IdeaProjects/DS/data.txt")

for i in f:
    entry = i.split()
    n.append(int(entry[0]))
    time.append(int(entry[1]))

plt.plot(n, time, markersize=12, marker='*', markerfacecolor='red', markeredgecolor='yellow')
plt.show()

