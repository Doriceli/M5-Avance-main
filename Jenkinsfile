pipeline {

    agent any

    tools {
        maven 'maven'
        jdk 'JDK17'
    }

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dim-docker-registry')
        DOCKER_IMAGE = 'doriceli/avance_rest:v5'
    }

    stages {  // ÚNICO bloque "stages"
    
        stage('Initialize') {
            steps {
                sh '''
                echo "PATH = $PATH"
                echo "JAVA_HOME = $JAVA_HOME"
                echo "M2_HOME = $M2_HOME"
                java -version
                echo "** Starting Notificaciones Compilation **"
                echo "** End Notificaciones Compilation **"
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'sudo docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Login & Push') {
            steps {
                sh '''
                    echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin docker.io
                    sudo docker push ${DOCKER_IMAGE}
                '''
            }
        }

    }  // Cierre correcto del bloque "stages"

}  // Cierre correcto del "pipeline"

