pipeline {
    agent {
        docker {
        image 'hseeberger/scala-sbt:8u222_1.3.5_2.13.1'
        reuseNode true
         }
    }
    stages {
        stage('build') {
            steps {
            echo "sbt assembly--------------------------------------------------"
                sh 'sbt -Dsbt.global.base=.sbt -Dsbt.boot.directory=.sbt -Dsbt.ivy.home=.ivy2 assembly'
            }
        }
        stage('test') {
            steps {
            echo "sbt testOnly--------------------------------------------------"
                sh 'sbt -Dsbt.global.base=.sbt -Dsbt.boot.directory=.sbt -Dsbt.ivy.home=.ivy2 testOnly'
            }
        }

    }
}
