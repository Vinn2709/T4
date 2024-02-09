pipeline {
    agent any
    tools {
        jdk 'JDK17'
        maven 'maven3'
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Vinn2709/Petclinic.git'
            }
        }
        stage('Code Compile') {
            steps {
                bat label: 'Compile', script: 'mvn clean compile'
            }
        }
        stage('Unit Tests') {
            steps {
                bat label: 'Run Tests', script: 'mvn test'
            }
        }
     }
  }
