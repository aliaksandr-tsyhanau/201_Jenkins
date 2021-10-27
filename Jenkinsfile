pipeline {
    agent { docker { image 'hseeberger/scala-sbt:8u222_1.3.5_2.13.1' } }
    stages {
        stage('check sbt') {
            steps {
                sh 'sbt --version'
            }
        }
        stage('build') {
            steps {
                sh 'sbt --build'
            }
        }
    }
}