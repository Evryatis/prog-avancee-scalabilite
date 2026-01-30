# Approximation de Pi par la méthode de Monte Carlo

Ce programme utilise la méthode de Monte Carlo pour estimer la valeur de Pi en simulant des points aléatoires dans un carré et en calculant combien tombent dans un cercle inscrit à l'intérieur de ce carré. Le calcul est parallélisé pour améliorer les performances.

### Monte Carlo
Le principe de la méthode de Monte Carlo consiste à générer des points aléatoires dans un carré de côté 1, puis à vérifier si le point est dans un cercle inscrit (condition : `x² + y² ≤ 1`).

### Approximation de Pi
Le ratio des points dans le cercle par rapport au total des points générés donne une estimation de Pi.

## Parallélisation

Le programme utilise plusieurs workers (threads) pour effectuer les calculs en parallèle, ce qui accélère l'exécution lorsque le nombre d'itérations est élevé.

Le problème de Monte Carlo est *embarassingly parallel*, car dans sa boucle principale, aucune itération ne dépend des autres. Il est donc très simple de paralléliser le problème.

## Structure du Code

- **Pi** : Lance l'exécution de l'approximation de Pi en appelant la méthode `doRun` de la classe `Master`.
- **Master** : Gère les workers et collecte leurs résultats pour calculer la valeur de Pi.
- **Worker** : Effectue une partie du calcul en générant des points aléatoires et en comptant ceux qui tombent dans le cercle.

## Exécution

Le programme peut être exécuté sur un IDE comme **Visual Studio Code**, avec un JDK de Java installé.

## Exemple de Test

Le programme effectue des tests, comme dans le fichier `Test_Pi.java`, avec différents nombres d'itérations et de workers pour estimer Pi. Par exemple :

- **Test 1** : 10 itérations, 1 worker
- **Test 2** : 10 000 itérations, 5 workers

## Conclusion

Ce programme montre comment paralléliser un calcul de simulation pour estimer Pi plus rapidement et plus précisément. Vous pouvez ajuster le nombre d'itérations et de workers pour tester les performances.
