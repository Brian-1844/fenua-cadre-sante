# Cadre Fenua – Objectif cadre de santé

Jeu sérieux d'entraînement quotidien (environ 1 h par jour, 45 séances : 72 fiches, 270 questions) pour préparer le métier de cadre de santé en Polynésie française : métier, système de santé du fenua, CHPF et fonction publique du Pays, droit et statut (normes, discipline, code du travail), management, organisation, qualité et droits du patient, projet et santé publique, concours et entretien.

## Utilisation

Ouvrir `index.html` dans un navigateur. Aucun serveur, aucune dépendance. La progression est enregistrée dans le navigateur (Profil → Sauvegarde pour la transférer).

## Publier sur GitHub Pages

1. Créer un dépôt et y déposer `index.html` et ce `README.md`.
2. Settings → Pages → Source : branche `main`, dossier `/ (root)`.
3. Le jeu est en ligne à `https://<compte>.github.io/<depot>/`.

## Modifier le contenu

Tout le contenu est dans le tableau `L` au début du script de `index.html`, un objet par niveau :

- `f` : fiches `[titre, html]`
- `q` : QCM `[question, [bonne réponse, autres réponses…], explication]` (la bonne réponse est toujours la première, l'ordre est mélangé à l'affichage)
- `c` : mises en situation `{t, s, o: [[option, points 0 à 2, retour]]}`
- `o` : questions d'oral `[juré (DS, CSS, MED, DRH), question, [points attendus]]`
- `e` : sujet d'écrit `[sujet, [pistes]]`

Chaque niveau attend 8 fiches, 30 QCM, 3 situations et 5 questions d'oral (les 3 fiches et 15 QCM supplémentaires de chaque niveau sont dans le tableau `EXT`).

## Avertissement

Outil d'entraînement rédigé en novembre 2026. Les chiffres et conditions de concours doivent être revérifiés sur les sources officielles (DTI, Lexpol, CHPF, Légifrance). Les membres du « Conseil » sont des personnages fictifs.

## Audio et annales

- Bouton « 🔊 Écouter » en haut de chaque fiche, question, situation et sujet : lecture par la synthèse vocale du navigateur (voix française du téléphone ou de l'ordinateur, sans connexion).
- Fiches → « Annales et sujets d'entraînement » : thèmes tombés aux concours et 8 sujets d'écrit (tableau `AN` dans le script).

## Conditions réelles (onglet Examens)

- Oral IFCS de 30 min (exposé de 10 min coupé par le jury, puis questions et relances lues à voix haute), entretien type concours du Pays de 20 min, écrit de 4 h sur document, QCM de 30 questions en 20 min.
- Chrono sans pause, attendus visibles seulement au débriefing, note sur 20 avec la grille du jury, historique des résultats.
- Données : tableaux `X` (questions difficiles), `RELANCES`, `CRIT` (grille), `DOCS` (documents de l'écrit).

## Simulations

- **Atelier planning** (`PSC`) : Facile (construire la semaine), Moyen (réparer après deux arrêts), Difficile (semaine de tension, 15 min). Contrôle en direct du repos de 11 h, des 48 h, du jour de repos, de la couverture et de l'équité ; solution de référence vérifiée par un solveur.
- **Dilemmes du cadre** (`DIL`) : 14 situations avec effets à court terme et conséquences à long terme.
- **Une semaine de cadre** (`EV`) : 21 situations dont certaines n'apparaissent qu'en fonction des choix précédents (effet domino), 6 indicateurs.
- **Niveaux** (Profil) : Normal, Difficile (chrono 45 s, corrections à la fin), Expert (25 s, indicateurs masqués, pénalités renforcées).

## Installer sur Android

1. Publier le dépôt avec GitHub Pages.
2. Ouvrir l'adresse dans Chrome → bouton « Installer » (Profil) ou menu ⋮ → « Installer l'application ».
3. Pour un fichier .apk : coller l'adresse sur pwabuilder.com → Android.

Fichiers nécessaires : `index.html`, `manifest.webmanifest`, `sw.js`, `icon-192.png`, `icon-512.png`.

## Publier une mise à jour

Modifier `APP_V` dans `index.html` et `VERSION` dans `sw.js`, puis pousser sur GitHub. Dans l'application : Profil → « Mettre à jour ».

## Lecture audio

Le bouton « 🔊 Écouter » utilise la voix du téléphone (Chrome, Safari ou application installée).
