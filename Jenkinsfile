pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        powershell 'maven deploy'
      }
    }
  }
}