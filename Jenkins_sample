pipeline {
    agent agent1{
            image 'hseeberger/scala-sbt:8u222_1.3.5_2.13.1'
    }
    stages {
        stage('Check docker') {
            steps {
                echo 'docker -v...'
                sh "docker -v"
            }
        }
    }
        stage('build') {
             steps {
                 echo 'Building..'
                 sh "sbt build"
             }
        }
        stage('Test') {
            steps {
                echo 'Building..'
                sh "sbt testOnly"
            }
        }
}

