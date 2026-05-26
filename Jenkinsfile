pipeline {
    agent any

    tools {
        // Имена бандлов должны совпадать с тем, как они настроены в Global Tool Configuration вашего Jenkins
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
                // REQRES_API_KEY — это ID Credentials (тип Secret text) в настройках Jenkins
                withCredentials([string(credentialsId: 'REQRES_API_KEY', variable: 'SECRET_TOKEN')]) {

                    // Передаем токен для API и настройки сетки для UI-тестов
                    sh 'mvn test -Dremote=true -DgridUrl=http://host.docker.internal:4445/wd/hub -Dapi.key=${SECRET_TOKEN}'
                }
            }
        }
    }

    post {
        always {
            // Плагин Allure в Jenkins подтянет результаты
            allure results: [[path: 'target/allure-results']]
        }
    }
}