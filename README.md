# Task Manager — Projet d'entraînement GitHub Actions CI/CD

Petite API REST Spring Boot (gestion de tâches en mémoire) accompagnée d'un
workflow `.github/workflows/ci-cd.yml` complet, adapté du guide **GitLab
CI/CD — Comprehensive Guide** pour pratiquer les mêmes concepts sur GitHub.

## Ce que couvre le pipeline (équivalences GitLab → GitHub Actions)

| Concept GitLab CI/CD        | Équivalent GitHub Actions                          |
|-------------------------------|------------------------------------------------------|
| Stages                        | `jobs:` liés par `needs:` (build → test → package → docker → deploy) |
| Jobs                          | `build`, `test`, `package`, `docker`, `deploy_*`     |
| Cache (`.m2/repository/`)     | `cache: maven` dans `setup-java`                     |
| Artifacts                     | `actions/upload-artifact`                            |
| Reports (JUnit)                | rapports uploadés en artifact `test-reports`         |
| Runner GitLab                 | `runs-on: ubuntu-latest` (runner GitHub hébergé)     |
| Rules (`if: branch == main`)  | `if: github.ref == 'refs/heads/main'`                |
| Environments                  | `environment:` (`development`, `staging`, `production`) |
| Déploiement manuel            | `environment: production` + "Required reviewers"     |
| Docker build & registry       | `docker/build-push-action` vers GitHub Container Registry (`ghcr.io`) |
| Variables prédéfinies         | `github.sha`, `github.repository_owner`, etc.        |

## Mise en pratique, étape par étape

1. **Crée un nouveau repo sur GitHub** (vide, sans README auto-généré).
2. **Pousse ce projet** :
   ```bash
   cd cicd-github-demo
   git init
   git remote add origin <URL_DE_TON_REPO_GITHUB>
   git add .
   git commit -m "Initial commit: Spring Boot + GitHub Actions"
   git branch -M main
   git push -u origin main
   ```
3. Va dans l'onglet **Actions** de ton repo GitHub : le workflow se déclenche
   automatiquement au push.
4. Regarde le graphe des jobs s'enchaîner (build → test → package → ...).
5. Va dans **Settings > Environments** : tu y verras `development`, `staging`,
   `production` apparaître après leur premier déploiement.

### Pour rendre `deploy_prod` réellement "manuel"

GitHub Actions n'a pas de `when: manual` natif comme GitLab, mais on obtient
le même effet avec une **protection d'environnement** :
1. Va dans **Settings > Environments > production**.
2. Coche **Required reviewers** et ajoute-toi comme reviewer.
3. Le job `deploy_prod` restera alors en attente d'approbation avant de
   s'exécuter — exactement comme un `when: manual` sur GitLab.

## Exercices suggérés (pour aller plus loin)

- Casse un test exprès et observe comment le workflow s'arrête au job `test`.
- Ajoute un secret dans **Settings > Secrets and variables > Actions** et
  utilise-le dans un step (`${{ secrets.MA_VARIABLE }}`).
- Restreins `docker` pour qu'il ne se lance que si `src/**` a changé, via
  `paths:` dans le déclencheur `on: push:`.
- Découpe le workflow en plusieurs fichiers réutilisables avec
  `workflow_call` (l'équivalent de `include:` sur GitLab).
- Ajoute un job `rollback_prod` manuel (même logique que `deploy_prod`).
- Ajoute un déclenchement planifié avec `on: schedule:` (cron) pour relancer
  les tests chaque nuit.

## Lancer le projet en local (optionnel)

```bash
mvn spring-boot:run
# puis
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Premier test","done":false}'
curl http://localhost:8080/api/tasks
```
