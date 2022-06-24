node {
  stage('SCM') {
    checkout scm
  }
  // add webhook https://<user>:<api token>@<ngrok url>/job/<job name>/build?token=<token>
   stage('SonarQube Analysis') {
       def mvn = tool 'Maven 3.8.4';
       withSonarQubeEnv() {
         sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=local-development -Dsonar.host.url=https://97fd-116-193-141-246.ngrok.io -Dsonar.login=sqp_0ee40bc3e763cf9f35760dd9df763aac2d20123e"
       }
       waitForQualityGate(webhookSecretId: 'secret')
   }
}