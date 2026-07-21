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
