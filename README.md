# Activité 1-2 : Service de calculatrice

## Objectif
Étendre l’application Client/Serveur pour que le serveur effectue une **multiplication par 5** à partir d’un entier envoyé par le client.

## Fonctionnalités
- Le client saisit un entier `x`.
- Le client envoie `x` au serveur.
- Le serveur calcule `x * 5` et renvoie le résultat.
- Le client affiche le résultat.
- La communication continue tant que l’utilisateur ne saisit pas `0`.

## Étapes de test
1. Lancer le serveur.
2. Lancer le client.
3. Saisir différents entiers (positifs, négatifs, 0) pour tester la communication.
4. Taper `0` pour fermer proprement la connexion.



## Remarques
L’échange utilise `DataInputStream` et `DataOutputStream` pour gérer correctement les entiers envoyés.


