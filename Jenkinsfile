pipeline {
  agent none
  stages {
    stage('Build') {
      steps {
        powershell 'maven deploy'
      }
    }
  }
}