# Cadre Fenua – Objectif cadre de santé

Jeu sérieux d'entraînement quotidien (environ 1 h par jour, 45 séances) pour préparer le métier de cadre de santé en Polynésie française : métier, système de santé du fenua, CHPF et fonction publique du Pays, droit et statut (normes, discipline, code du travail), management, organisation, qualité et droits du patient, projet et santé publique, concours et entretien.

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

Chaque niveau attend 5 fiches, 15 QCM, 3 situations et 5 questions d'oral.

## Avertissement

Outil d'entraînement rédigé en novembre 2026. Les chiffres et conditions de concours doivent être revérifiés sur les sources officielles (DTI, Lexpol, CHPF, Légifrance). Les membres du « Conseil » sont des personnages fictifs.

## Audio et annales

- Bouton « 🔊 Écouter » en haut de chaque fiche, question, situation et sujet : lecture par la synthèse vocale du navigateur (voix française du téléphone ou de l'ordinateur, sans connexion).
- Fiches → « Annales et sujets d'entraînement » : thèmes tombés aux concours et 8 sujets d'écrit (tableau `AN` dans le script).

## Conditions réelles (onglet Examens)

- Oral IFCS de 30 min (exposé de 10 min coupé par le jury, puis questions et relances lues à voix haute), entretien type concours du Pays de 20 min, écrit de 4 h sur document, QCM de 30 questions en 20 min.
- Chrono sans pause, attendus visibles seulement au débriefing, note sur 20 avec la grille du jury, historique des résultats.
- Données : tableaux `X` (questions difficiles), `RELANCES`, `CRIT` (grille), `DOCS` (documents de l'écrit).

## Lecture audio

- Le dossier `audio/` contient une version lue de chaque fiche et des documents de l'écrit (voix de synthèse française, 47 fichiers MP3). Dépose-le sur GitHub à côté de `index.html`.
- Le bouton « 🔊 Écouter » utilise la voix du téléphone quand le navigateur en a une (Chrome, Safari) ; sinon il lit le fichier enregistré. Dans les lecteurs intégrés sans voix (comme l'appli Claude), seules les fiches et les documents de l'écrit sont lus.
- Nom des fichiers : `f<niveau>-<fiche>.mp3` (à partir de 0) et `d<document>.mp3`. Si tu modifies une fiche, régénère son fichier.
