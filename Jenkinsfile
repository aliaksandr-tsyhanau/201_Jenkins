pipeline {
    agent {
        docker { image 'hseeberger/scala-sbt:8u222_1.3.5_2.13.1' }
    }
    stages {
        stage('build') {
            steps {
            echo "sbt build--------------------------------------------------"
                sh 'sbt build'
            }
        }
    }
}