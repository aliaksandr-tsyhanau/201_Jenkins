pipeline {
  agent any

  stages {
    stage("Hello") {
      steps {
        sh 'echo "hello world"'
      }
    }
    stage('Test') {
            steps {
                echo 'Unit testing...'
                sh "sbt test"
      }
    }
  }
}