import matplotlib.pyplot as plt

# Nombre de workers testés
workers = [1, 5, 10]

# Données
donnesImport = "resultatScalabiliteForte.txt"

# Lecture des données depuis le fichier
avg_times_ms = []
with open(donnesImport, "r") as file:
    for line in file:
        avg_times_ms.append(float(line.strip()))

plt.figure(figsize=(8, 5))
plt.plot(workers, avg_times_ms, marker='o', linestyle='-', linewidth=2)


plt.xlabel("Nombre de workers")
plt.ylabel("Durée moyenne (ms)")
plt.title("Performance – Estimation de Pi")

plt.xticks(workers)
plt.grid(True)

# Affichage
plt.show()
