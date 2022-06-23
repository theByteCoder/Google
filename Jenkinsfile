node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def scannerHome = tool 'SonarQube Scanner 4.7.0.2747';
    withSonarQubeEnv() {
        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=local-development -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_8f92cb86929e1c009c7dcc42df98fea0572d594b"
//         mvn clean verify sonar:sonar -Dsonar.projectKey=local-development -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_8f92cb86929e1c009c7dcc42df98fea0572d594b
    }
  }
}