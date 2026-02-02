# Version de Monte-Carlo implementée avec le Socket

On implémente ici l'algorithme de Monte-Carlo avec la technologie de socket en Java.

La technologie des sockets qu'on va observer ici est basée sur le protocole TCP/IP, qui permet une communication client server.

Ce protocole permet d'établir des connexions entre un ou plusieurs clients, avec un ou plusieurs maîtres.

## Explication du setup en Java

La plupart des méthodes dont nous avons besoin se trouve dans le package java.net, qui est importé dans le code.

Le WorkerSocket (le serveur), ici s'execute et met en argument un port, qui est celui avec lequel le MasterSocket (le client), va pouvoir se connecter.

Une fois la connexion en place, le client et le server peuvent communiquer sans fin, tant que les deux sockets sont ouverts et pas fermées.

## WorkerSocket

Le code MasterSocket main récupère la chaine de caractère, et crée son socket avec un writer et un reader.

Puis, il va envoyer un message en utilisant son writer, et peut en recevoir en utilisant reader.

Dans la pratique, ce code est mal fichu, car tout doit-être fait à la main.
