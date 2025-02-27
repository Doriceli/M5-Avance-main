# M5-Avance-main
## Descripción del Proyecto

El proyecto M5-Avance-main es una aplicación desarrollada en Java que implementa una API RESTful para la gestión de productos en un sistema de e-commerce.

## Características principales:
- Permite a los usuarios realizar operaciones como creación, actualización y eliminación de productos.
- Gestión de pedidos con verificación de disponibilidad de productos.
- Conexión a una base de datos para almacenar y recuperar información esencial.

Además, la aplicación utiliza archivos YAML en la carpeta manifests para definir los recursos de despliegue en Kubernetes, lo que facilita la configuración y gestión del entorno de producción.

## Funcionalidad del Código Java
El núcleo de la aplicación está construido en Java y ofrece las siguientes funcionalidades:

- Gestión de Productos, registro, actualización y eliminación de usuarios.
- Manejo de autenticación y autorización con tokens JWT para asegurar el acceso a la API.
- Procesamiento de Productos, los usuarios pueden crear, actualizar y cancelar precios.

El código sigue una arquitectura Modelo-Vista-Controlador (MVC) para mantener una separación clara entre la lógica de negocio, la presentación y el acceso a datos.

## Conexión a la Base de Datos
La aplicación se conecta a una base de datos **MongoDB** (NoMySQL) para gestionar la persistencia de los datos. La configuración de la conexión se encuentra en el archivo **application.properties** ubicado en *src/main/resources/* cuyo datos se le pasan a través de Dockerfile.

IMAGEN DOCKERFILE

## Archivos YAML y su función
Dentro de la carpeta **manifests**, encontrarás varios archivos YAML que se utilizan para definir los recursos necesarios para desplegar la aplicación en un clúster de Kubernetes.

| Archivo |	Descripción |
|---------|-------------|
|deployment.yaml|	Define el despliegue de la aplicación, especificando el número de réplicas, la imagen de Docker y las variables de entorno necesarias. También incluye la estrategia de actualización para minimizar el tiempo de inactividad.|
|service.yaml	|Configura el servicio que expone la aplicación, permitiendo el acceso desde fuera del clúster. Especifica el tipo de servicio (NodePort en entornos de desarrollo o LoadBalancer en producción).|
|configmap.yaml	|Contiene configuraciones que pueden ser inyectadas en los pods, como variables de entorno o archivos de configuración. Permite modificar parámetros sin necesidad de reconstruir la imagen de la aplicación.|
|secret.yaml|	Almacena información sensible, como credenciales de bases de datos o claves API, de manera segura y cifrada.|
|git-clone-taskrun|Copia el código del repositorio.|


### deployment.yaml
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: m5-avance-app
spec:
  replicas: 3
  selector:
    matchLabels:
      app: m5-avance
  template:
    metadata:
      labels:
        app: m5-avance
    spec:
      containers:
      - name: m5-avance-container
        image: doriceli/m5-avance:latest
        ports:
        - containerPort: 8080
```
# Cómo Empezar

## Clona el repositorio
```
kubectl create -f manifest/taskrun/git-clone-taskrun.yaml
```
## Configura la base de datos
Asegúrate de tener una instancia de MoboDB en funcionamiento y actualiza los parámetros de conexión en *src/main/resources/application.properties*.

## Construye y ejecuta la aplicación
```
./mvnw clean install
./mvnw spring-boot:run
```
## Despliegue en Kubernetes

Si deseas desplegar la aplicación en un clúster de Kubernetes, aplica los archivos YAML en la carpeta **manifests/tekton** y **manifest/taskrun**:

```
kubectl apply -f manifests/tekton/tekton-sa.yaml -n diploe2
kubectl apply -f manifests/tekton/tekton-role.yaml -n diploe2
kubectl apply -f manifests/tekton/tekton-rolebinding.yaml -n diploe2
kubectl create -f manifests/taskrun/task-deploy.yaml -n diploe2
```



--------------------------------------------------------------------
######## TEXTO QUE SE AÑADIÓ PARA LA PRÁCTICA 1
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


