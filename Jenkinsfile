pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               sh 'echo Hello, World!'
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