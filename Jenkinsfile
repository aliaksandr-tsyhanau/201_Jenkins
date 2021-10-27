pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'sbt --version'
                sh 'sbt --version'

            }
        }
        stage('Build') {
            steps {
                echo 'sbt --build..'
                sh 'sbt --build..'

            }
        }
        stage('TEST') {
            steps {
                echo 'sbt --test..'
                sh 'sbt --test..'
            }
        }
    }
}