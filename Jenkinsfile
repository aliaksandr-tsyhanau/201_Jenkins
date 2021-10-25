stage("Prepare container") {
  stages {
    stage('Build') {
      steps {
        checkout master
        sh 'sbt compile'
        echo 'Compiled'
      }
    }
    stage('Build') {
          steps {
            checkout master
            sh 'sbt testOnly'
            echo 'Tested'
          }
    }
  }
}