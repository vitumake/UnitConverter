pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('vitumake')
        DOCKERHUB_REPO = 'vitumake/unitconverter'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {

        stage('Checkout') {
            
            steps {
                git branch: 'main', url: 'https://github.com/vitumake/UnitConverter'
            }
        }
        
        
        stage('Test') {
            
            steps{
                bat 'mvn -f ./projteht test'
            }

            post {
                success {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/TEST-*.xml'
                    // Generate JaCoCo code coverage report
                    jacoco(execPattern: '**/target/jacoco.exec')
                }
            }
            
        }

        stage('Build and push Docker image') {

            steps {
                script {
                    // Build the Docker image
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")

                    // Push the Docker image to Docker Hub
                    docker.withRegistry('https://index.docker.io/v1/', 'DOCKERHUB_CREDENTIALS') {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}
