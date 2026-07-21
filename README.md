# Task Manager — Spring Boot + GitHub Actions CI/CD + Docker

## 📌 Présentation du projet

**Task Manager** est une API REST développée avec **Spring Boot 3.2.5 / Java 17** ayant pour objectif de mettre en pratique les concepts modernes de développement backend et de **DevOps CI/CD avec GitHub Actions**.

Le projet simule un cycle de vie applicatif professionnel :

* développement avec une architecture en couches ;
* gestion du code avec Git Flow (main / develop / feature branches) ;
* automatisation des tests ;
* intégration continue avec GitHub Actions ;
* packaging Maven ;
* conteneurisation Docker ;
* préparation à un déploiement automatisé.

L'objectif principal est de construire progressivement une chaîne CI/CD complète, proche des pratiques utilisées en entreprise.

---

# 🏗️ Architecture applicative

L'application suit une architecture Spring Boot classique :

```
task-manager

src/main/java
│
├── controller
│     └── TaskController
│
├── service
│     └── TaskService
│
├── model
│     └── Task
│
└── TaskManagerApplication
```

Flux applicatif :

```
Client HTTP

      |
      ↓

REST Controller

      |
      ↓

Service Layer

      |
      ↓

Business Logic

      |
      ↓

Response JSON
```

---

# 🚀 Fonctionnalités actuelles

L'API expose un CRUD complet :

| Fonction                    | HTTP   | Endpoint          |
| --------------------------- | ------ | ----------------- |
| Récupérer toutes les tâches | GET    | `/api/tasks`      |
| Récupérer une tâche par ID  | GET    | `/api/tasks/{id}` |
| Créer une tâche             | POST   | `/api/tasks`      |
| Modifier une tâche          | PUT    | `/api/tasks/{id}` |
| Supprimer une tâche         | DELETE | `/api/tasks/{id}` |

Exemple d'objet métier :

```json
{
  "id": 1,
  "title": "Configurer CI/CD",
  "done": false
}
```

---

# 🧪 Tests automatisés

Le projet contient plusieurs niveaux de tests :

## Tests unitaires

Technologies utilisées :

* JUnit 5
* AssertJ

Tests réalisés :

* création d'une tâche ;
* génération automatique d'identifiant ;
* récupération des tâches ;
* suppression ;
* gestion des erreurs.

## Tests d'intégration

Avec :

* Spring Boot Test
* MockMvc

Validation du parcours complet :

```
HTTP Request

      ↓

Controller

      ↓

Service

      ↓

HTTP Response
```

---

# 🔧 Stack technique

## Backend

| Technologie       | Utilisation                  |
| ----------------- | ---------------------------- |
| Java 17           | Langage principal            |
| Spring Boot 3.2.5 | Framework backend            |
| Spring Web        | API REST                     |
| Spring Actuator   | Health checks et monitoring  |
| Maven             | Build et gestion dépendances |
| JUnit 5           | Tests automatisés            |

## DevOps

| Technologie              | Utilisation         |
| ------------------------ | ------------------- |
| Git                      | Gestion de version  |
| GitHub                   | Hébergement du code |
| GitHub Actions           | CI/CD               |
| Docker                   | Conteneurisation    |
| Docker Multi-stage Build | Optimisation image  |

---

# 🔄 Stratégie Git utilisée

Le projet suit une organisation inspirée de Git Flow :

```
main
 |
 |
develop
 |
 |
feature/*
```

Branches utilisées :

```
feature/add-update-task
feature/github-actions
feature/add-PR
feature/add-package-stage
```

Workflow :

```
Feature branch

      ↓

Pull Request

      ↓

GitHub Actions validation

      ↓

Merge develop

      ↓

Release vers main
```

---

# ⚙️ Pipeline CI/CD GitHub Actions

Le pipeline actuel automatise :

```
Developer

    |
    |
Git Push / Pull Request

    |
    |
GitHub Actions

    |
    |
Checkout repository

    |
    |
Setup Java 17

    |
    |
Maven build

    |
    |
Tests automatisés

    |
    |
Package application

    |
    |
Docker ready
```

---

# 📦 Concepts CI/CD implémentés

Le projet met en pratique les concepts suivants :

| Concept CI/CD           | Implémentation                            |
| ----------------------- | ----------------------------------------- |
| Workflow                | `.github/workflows/*.yml`                 |
| Jobs                    | Séparation des étapes pipeline            |
| Steps                   | Actions individuelles                     |
| Runner                  | `ubuntu-latest`                           |
| Pull Request validation | Workflow déclenché sur PR                 |
| Maven build             | `mvn clean package`                       |
| Tests automatiques      | JUnit + MockMvc                           |
| Docker build            | Dockerfile multi-stage                    |
| Artifacts               | Publication des fichiers générés          |
| Cache Maven             | Optimisation des builds                   |
| Secrets                 | Gestion sécurisée des variables sensibles |
| Environments            | Préparation dev/staging/production        |

---

# 🐳 Conteneurisation Docker

Le projet utilise un Dockerfile multi-stage :

```
Build Stage

Maven + JDK 17

        ↓

Compilation

        ↓

task-manager.jar


Runtime Stage

JRE Alpine

        ↓

Application Spring Boot
```

Avantages :

* image finale plus légère ;
* séparation build/runtime ;
* réduction de la surface d'attaque ;
* meilleure pratique DevOps.

L'application expose :

```
Port : 8080
```

Health check disponible via Spring Actuator :

```
/actuator/health
```

---

# 🎯 Objectif final de la formation

L'objectif est de faire évoluer ce projet vers une chaîne CI/CD professionnelle :

```
Developer
    |
    |
Feature branch
    |
    |
Pull Request
    |
    |
GitHub Actions
    |
    |
=========================
 CI PIPELINE
=========================

- Checkout
- Cache Maven
- Build
- Unit tests
- Integration tests
- Code quality
- Package JAR
- Upload artifact

=========================
 CD PIPELINE
=========================

- Build Docker image
- Security scan
- Push Docker image
- Deploy
- Health check
- Rollback

    |
    |
Production
```

---

# 📈 Roadmap d'évolution

## Phase 1 — Amélioration CI

Objectifs :

* ajouter des jobs séparés ;
* mettre en place les artifacts Maven ;
* optimiser avec le cache Maven ;
* utiliser des workflows réutilisables ;
* ajouter des matrices de tests.

---

## Phase 2 — Industrialisation Docker

Objectifs :

* construire automatiquement l'image Docker ;
* versionner les images ;
* publier dans un registry ;
* gérer les secrets Docker.

Architecture cible :

```
GitHub Actions

      ↓

Docker Build

      ↓

Docker Image

      ↓

Container Registry
```

---

## Phase 3 — Passage en environnement réel

Objectifs :

* ajouter PostgreSQL ;
* utiliser Docker Compose ;
* gérer plusieurs environnements :

```
development

staging

production
```

---

## Phase 4 — Déploiement Cloud

Objectifs :

* automatiser le déploiement ;
* gérer les variables d'environnement ;
* mettre en place les stratégies de rollback.

---

## Phase 5 — Kubernetes

Objectif final :

```
GitHub Actions

      ↓

Docker Image

      ↓

Kubernetes Deployment

      ↓

Service

      ↓

Production
```

---

# ▶️ Lancer le projet localement

## Prérequis

* Java 17
* Maven
* Docker (optionnel)

## Démarrage Spring Boot

```bash
mvn spring-boot:run
```

---

## Tester l'API

Créer une tâche :

```bash
curl -X POST http://localhost:8080/api/tasks \
-H "Content-Type: application/json" \
-d '{"title":"Premier test CI/CD","done":false}'
```

Lister les tâches :

```bash
curl http://localhost:8080/api/tasks
```

---

# 🧠 Compétences démontrées

Ce repository démontre :

✅ Développement backend Java/Spring Boot
✅ Création d'API REST
✅ Tests automatisés
✅ Maven lifecycle
✅ Git workflow professionnel
✅ GitHub Actions CI/CD
✅ Dockerisation d'application Java
✅ Automatisation des builds
✅ Préparation au déploiement Cloud
✅ Approche DevOps progressive

---

# 📌 Prochaines améliorations prévues

* [ ] Migration vers PostgreSQL + Spring Data JPA
* [ ] Ajout DTO + validation API
* [ ] Gestion globale des exceptions
* [ ] Pipeline CI/CD complet
* [ ] Build automatique Docker
* [ ] Publication image Docker
* [ ] Déploiement automatique
* [ ] Monitoring avancé
* [ ] Kubernetes deployment
## 📦 Fonctionnement du cache Maven dans GitHub Actions

Le cache Maven dans GitHub Actions permet de réutiliser les dépendances déjà téléchargées entre plusieurs exécutions d'un pipeline CI/CD.

L'idée principale est de sauvegarder le dossier local Maven :

```
~/.m2/repository
```

afin d'éviter de télécharger les mêmes dépendances à chaque exécution.

---

## 1. Relation entre `pom.xml`, hash et cache

On peut mentalement représenter le cache GitHub Actions comme une structure de type :

```text
Cache GitHub Actions

{
   hash_1 : .m2/repository,
   hash_2 : .m2/repository,
   hash_3 : .m2/repository
}
```

- **Hash** : une clé générée à partir de la configuration Maven (notamment le `pom.xml`).
- **`.m2/repository`** : le dossier contenant les dépendances Maven téléchargées.

Exemple :

```text
Cache GitHub Actions

{
   "Linux-java17-maven-11X" : archive(.m2/repository),
   "Linux-java17-maven-11Y" : archive(.m2/repository)
}
```

Chaque modification du `pom.xml` peut produire un nouveau hash et donc un nouveau cache.

---

# 2. Premier lancement du pipeline

Lors de la première exécution :

```yaml
- name: Setup Java
  uses: actions/setup-java@v4
  with:
    java-version: '17'
    distribution: 'temurin'
    cache: maven
```

GitHub Actions effectue les opérations suivantes :

### Étape 1 : Configuration de Java

`setup-java` installe et configure Java 17 dans le runner.

---

### Étape 2 : Calcul de la clé du cache

GitHub lit le fichier `pom.xml` et calcule une clé :

```
pom.xml
   |
   v
Calcul du hash
   |
   v
Cache key = 11X
```

Il cherche ensuite un cache correspondant :

```
Cache["11X"] ?
```

Résultat :

```
❌ Cache introuvable
```

À ce moment :

```
~/.m2/repository
```

est vide.

---

### Étape 3 : Exécution de Maven

Ensuite le pipeline lance par exemple :

```bash
mvn clean package
```

Maven télécharge les dépendances nécessaires :

```
Maven Central
      |
      v
~/.m2/repository

spring-boot.jar
junit.jar
lombok.jar
...
```

Le dossier `.m2` est maintenant rempli.

---

### Étape 4 : Sauvegarde du cache

À la fin du job GitHub Actions sauvegarde le dossier :

```
~/.m2/repository
        |
        v
Compression
        |
        v
Cache GitHub Actions

Cache["11X"]
        |
        v
   .m2/repository
```

Le cache est maintenant disponible pour les prochains pipelines.

---

# 3. Deuxième exécution avec le même `pom.xml`

Le fichier `pom.xml` n'a pas changé.

Le hash est toujours :

```
11X
```

GitHub cherche :

```
Cache["11X"]
```

Résultat :

```
✅ Cache trouvé
```

Le cache est restauré :

```
GitHub Cache
      |
      v
Runner GitHub

      |
      v

~/.m2/repository
```

Puis Maven démarre :

```bash
mvn package
```

Maven trouve déjà les dépendances :

```
spring-boot.jar ✅
junit.jar        ✅
lombok.jar       ✅
```

Il n'a donc pas besoin de tout télécharger.

---

# 4. Modification du `pom.xml`

Supposons une modification :

Avant :

```xml
spring-boot 3.3.0
```

Après :

```xml
spring-boot 3.4.0
```

Le contenu du `pom.xml` change :

```
pom.xml
   |
   v
Nouveau hash

11Y
```

GitHub cherche :

```
Cache["11Y"]
```

Résultat :

```
❌ Cache inexistant
```

Maven télécharge alors les nouvelles dépendances nécessaires :

```
Maven Central
      |
      v

~/.m2/repository
      |
      ├── spring-boot 3.4.0
      ├── junit
      └── lombok
```

À la fin :

```
Cache["11Y"]

       |
       v

~/.m2/repository
```

Un nouveau cache est créé.

---

# 5. Différence entre cache et `.m2`

Il faut bien distinguer les deux :

| Élément | Rôle |
|---|---|
| `.m2/repository` | Stockage local utilisé par Maven pendant le build |
| Cache GitHub Actions | Sauvegarde temporaire de `.m2` entre plusieurs pipelines |

Le cache ne remplace pas Maven.

Il permet simplement de restaurer rapidement un `.m2` déjà rempli.

---

# 6. Schéma global

```
                 pom.xml
                    |
                    |
             Calcul du hash
                    |
        -------------------------
        |                       |
       11X                     11Y
        |                       |
        v                       v

  Cache GitHub            Cache GitHub
     11X                     11Y

        |                       |
        | restauration           |
        |                       |
        v                       v

 ~/.m2/repository       ~/.m2/repository

        |
        |
        v

       Maven
   mvn clean package

        |
        |
        v

   Application construite

      target/
        |
        |
        v

     Artifact
   (ex: app.jar)
```

---

# À retenir

- `setup-java@v4` **ne télécharge pas les dépendances Maven**.
- `setup-java@v4` prépare Java et gère la restauration/sauvegarde du cache Maven.
- Maven est responsable du téléchargement des dépendances dans `.m2`.
- Le hash sert uniquement à identifier quelle version du cache utiliser.
- Un changement du `pom.xml` peut créer une nouvelle entrée de cache.
- Le cache accélère les builds, mais il ne contient pas le résultat du build.

```
Artifact = ce que le projet produit.
Cache = ce dont le projet a besoin pour être construit.
```