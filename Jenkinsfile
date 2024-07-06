pipeline {
    agent any

    tools {
        maven 'Maven3.9.8' // Ensure this matches the Maven version installed on your Jenkins server
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Gokul19797/springboot.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                bat 'scp target/spring-boot-app.jar user@your-server:/path/to/deploy'
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
