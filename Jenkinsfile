node('node1') {
    stage('Build') {
        docker.image('hseeberger/scala-sbt:8u222_1.3.5_2.13.1').inside {
           echo 'docker -v...'
           sh "docker -v"
        }
    }
}

