pipeline{
  agent any
  environment {
    ARTIFACTORY_ACCESS_TOKEN = credentials('artifactory-access-token')
  }
  stages{
    stage('Test'){
      steps{
        sh './gradlew test'
      }
    }
    stage('Build'){
      steps{
        sh './gradlew clean build'
      }
    }
    stage('Publish Artifactory'){
      steps{
        sh '/usr/local/bin/jf rt upload --url https://victoremanuelsr.jfrog.io/artifactory/ --access-token ${ARTIFACTORY_ACCESS_TOKEN} *.war petstore/'
        
      }
    }
  }
}