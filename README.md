# Activité 1-3 : Connexion sur deux machines et calculatrice améliorée

## Objectif
Améliorer l’application précédente pour :
1. Établir la communication Client/Serveur sur **deux machines différentes** du même réseau local.
2. Étendre le service de calculatrice pour inclure **Addition, Soustraction, Multiplication et Division**.

## Fonctionnalités
- Le client choisit une opération via un menu.
- Le client saisit une valeur `x`.
- Le serveur effectue le calcul selon l’opération choisie et renvoie le résultat.
- La connexion fonctionne même si le serveur et le client sont sur deux machines différentes (utilisation de l’adresse IP locale au lieu de `localhost`).

## Étapes de test
1. Configurer le serveur pour écouter sur l’adresse IP réelle de la machine.
2. Lancer le serveur.
3. Lancer le client depuis une autre machine sur le même réseau et remplacer `localhost` par l’adresse IP du serveur.
4. Tester chaque opération avec différentes valeurs.

