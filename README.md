# Avance
Diplomado, Módulo 5, Avance del Proyecto

# M5-Avance-main

Ejercicio 4 - cambio en rama FEATURE

# # # Practica 1 # # #

## Estrategia de RamasPara gestionar el desarrollo del proyecto, utilizamos la estrategia **Git Flow**:

-`main`: Contiene la versión estable.
-`develop`: Se integran las nuevas funcionalidades antes de lanzar una versión.
-`feature/*`: Ramas individuales para cada funcionalidad, en éste caso carga-articulos y asigna-costo.
-`release/*`: Se preparan versiones antes de su lanzamiento.
-`hotfix/*`: Se corrigen errores críticos en producción.

### Flujo de trabajo:1.Se crean ramas `feature/*`a partir de `develop`.

2.Al completar la funcionalidad, se fusionan en `develop`.
3.Se crean ramas `release/*`cuando una versión está lista.
4.Se fusiona en `main`y se etiqueta la nueva versión.

Ejemplo de comandos:

git checkout -b feature/carga-articulos develop
git push origin feature/carga-articulos
git checkout develop
git merge feature/carga-articulos
git push origin develop


