pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Windows\\System32" // Update the PATH to include the directory of cmd.exe

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
        
        stage('Build and push Docker image') {
            steps {
                script {
                    // Build the Docker image
                    docker.build("vitumake/unitconverter:latest", "./projteht")

                    // Push the Docker image to Docker Hub
                    docker.withRegistry('https://index.docker.io/v1/', 'DOCKERHUB_CREDENTIALS') {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
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
    }
}
