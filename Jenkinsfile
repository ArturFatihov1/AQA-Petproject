pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        maven 'maven-3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile -DskipTests'
            }
        }

        stage('Run API and UI Tests') {
            steps {
                withCredentials([string(credentialsId: 'REQRES_API_KEY', variable: 'SECRET_TOKEN')]) {
                    sh 'mvn test -Dremote=true -DgridUrl=http://selenoid:4444/wd/hub -Dapi.key=${SECRET_TOKEN}'
                }
            }
        }
    }

    post {
        always {
            allure results: [[path: 'target/allure-results']]
        }
    }
}