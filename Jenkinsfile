node {
  stage('SCM') {
    checkout scm
  }
  stage('Build') {
    steps {
        sh 'mvn -B clean package -DskipTests'
    }
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Default Maven';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=local-development"
    }
  }
}