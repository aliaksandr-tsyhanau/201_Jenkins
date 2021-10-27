pipeline {
    agent {
        docker {
        image 'hseeberger/scala-sbt:8u222_1.3.5_2.13.1'
        reuseNode true
         }
    }
    stages {
        stage('prepare') {
            steps {
            echo "sbt prepare--------------------------------------------------"
                sh 'sbt -Dsbt.global.base=.sbt -Dsbt.boot.directory=.sbt -Dsbt.ivy.home=.ivy2'
            }
        }
        stage('build') {
            steps {
            echo "sbt build--------------------------------------------------"
                sh 'sbt build'
            }
        }
        stage('test') {
            steps {
            echo "sbt testOnly--------------------------------------------------"
                sh 'sbt testOnly'
            }
        }

    }
}