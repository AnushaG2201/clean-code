def groovy
pipeline {
    agent { docker 'maven:3.3.3' }

    stages {
        stage('Build') {
            steps {
                script {
                    sh "echo Hello, World!!!"
                    echo 'hrllo'
                }
            }
        }

        stage('Test'){
            steps {
                sh 'make check'
                junit 'reports/**/*.xml'
        }
        }

        stage('Deploy'){
            steps {
                sh 'make publish'
            }
    }
}
}