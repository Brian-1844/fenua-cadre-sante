# Cadre Fenua – Formations santé et gestion

Une seule application, sept voies de formation au choix dès l'écran d'entrée :

| Voie | Contenu |
| --- | --- |
| 🩺 Cadre de santé | Concours, entretien, management d'une unité, planning, simulations (9 niveaux, 45 séances) |
| 👥 Ressources humaines | Droit du travail polynésien, paie, CPS, fonction publique du Pays (15 niveaux, 75 séances) |
| 📈 Économie | Bases, indicateurs, monnaie et budget, économie du fenua, calculs d'entreprise (4 niveaux) |
| 💉 Soins infirmiers et urgences | Gestes d'urgence, voie veineuse et perfusion, plaies et sutures, médicaments et transfusion (4 niveaux) |
| 👶 Sage-femme | Remise à niveau : grossesse et travail, urgences obstétricales, nouveau-né, périnée, spécificités du fenua, pathologies locales, gynécologie et contraception (8 niveaux) |
| 📱 Concepteur d'application | Besoin, briques du web, sécurité, IA, GitHub, Firebase, Supabase (7 niveaux) |
| 📊 Excel | Bases, formules, fonctions, tableaux croisés dynamiques (4 niveaux) |

Chaque voie a ses fiches, ses quiz, ses mises en situation, son jury, ses ateliers de calcul ou de procédure, ses dilemmes, ses épreuves chronométrées et son aide-mémoire. La progression est enregistrée sur l'appareil, séparément pour chaque voie.

## Fichiers

- `index.html` : toute l'application (aucune dépendance).
- `manifest.webmanifest`, `sw.js`, `icon-192.png`, `icon-512.png` : installation et fonctionnement hors connexion.
- `version.json` : numéro de version lu par le bouton « Mettre à jour ».
- `android/` : petite application Android qui affiche le site (pour l'APK).
- `.github/workflows/apk.yml` : construction automatique de l'APK.

## Mettre en ligne (GitHub Pages)

1. Déposer tous les fichiers à la racine du dépôt (en gardant les dossiers `android` et `.github`).
2. Settings → Pages → branche `main`, dossier `/ (root)`.
3. L'application est à l'adresse `https://<compte>.github.io/<dépôt>/`.

## Obtenir l'APK

1. Settings → Actions → General → Workflow permissions → **Read and write permissions**.
2. Onglet Actions → « Construire l'APK » → **Run workflow**.
3. Quand tout est vert, l'APK est dans **Releases** (`cadre-fenua.apk`). Le bouton « Télécharger l'APK Android » de l'écran d'entrée pointe vers la dernière version.

L'APK affiche la version en ligne : il n'a pas besoin d'être reconstruit quand le contenu change. Il se reconstruit tout seul uniquement si le dossier `android/` est modifié. Sans réseau au tout premier lancement, il affiche la copie embarquée.

### Signature

Par défaut, l'APK est signé avec `android/fenua-test.keystore`, une clé **de test visible dans le dépôt** (mot de passe `cadrefenua`). Elle garantit que les mises à jour s'installent par-dessus l'ancienne version, mais n'importe qui peut l'utiliser : c'est suffisant pour un usage personnel, pas pour une diffusion publique.

Pour une vraie clé : la créer avec `keytool`, puis ajouter dans Settings → Secrets and variables → Actions : `KEYSTORE_B64` (le fichier encodé en base64), `KEYSTORE_PASS`, `KEYSTORE_ALIAS`. Le workflow l'utilisera automatiquement. Changer de clé oblige à désinstaller une fois l'ancienne version.

## Publier une mise à jour

1. Remplacer `index.html`.
2. Changer le numéro dans `version.json` et `VERSION` dans `sw.js`.
3. Dans l'application : écran d'entrée → « Mettre à jour » (site installé comme APK).

## Modifier le contenu

Dans `index.html`, chaque voie est une fonction `run` de la liste `TRACKS`. À l'intérieur :

- `L` : niveaux, avec `f` fiches `[titre, html]`, `q` QCM `[question, [bonne réponse, autres…], explication]`, `c` situations `{t, s, o: [[option, points 0 à 2, retour]]}`, `o` questions du jury `[juré, question, [points attendus]]`, `e` écrit `[sujet, [pistes]]`.
- `AT` : ateliers ; exercice chiffré `{k:"num", q, a, tol, u, x}` ou mise en ordre `{k:"ord", q, it:[étapes dans l'ordre], x}`.
- `SIMMAP` : l'activité pratique de chaque niveau (`at0`, `at1`…, `dil`).
- `DIL` : dilemmes `[choix, points, effet à court terme, conséquence à long terme]`.
- `REP` : aide-mémoire `[rubrique, [[repère, valeur, référence]]]`.

Les voies Cadre de santé et Ressources humaines gardent leurs clés d'enregistrement (`cadre-fenua-v1`, `rh-fenua-v1`) : la progression déjà acquise à la même adresse est conservée.

## Avertissement

Outil d'entraînement, sans valeur de diplôme. Les contenus de soins servent à réviser : ils ne remplacent ni la formation pratique, ni les protocoles du service, ni la prescription médicale ; les doses et seuils cités sont des repères à vérifier. Les contenus juridiques et chiffrés (droit du travail, CPS, tarifs des services en ligne) datent de novembre 2026 et changent : vérifier sur les sources officielles. Personnages et entreprises fictifs.
