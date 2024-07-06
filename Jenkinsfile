pipeline {
    agent any

    tools {
        maven 'Maven 3.23' // Ensure this matches the Maven version installed on your Jenkins server
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Gokul19797/springboot.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                sh 'scp target/spring-boot-app.jar user@your-server:/path/to/deploy'
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
