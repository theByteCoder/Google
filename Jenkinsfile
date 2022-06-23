node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def scannerHome = tool 'SonarQube Scanner 4.7.0.2747';
    withSonarQubeEnv() {
        sh 'mvn clean package sonar:sonar'
    }
  }
}