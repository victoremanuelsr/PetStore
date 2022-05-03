pipeline{
  agent {label 'linux'}
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
      agent {
        docker {
          image 'releases-docker.jfrog.io/jfrog/jfrog-cli-v2-jf'
          reuseNode true
        }
      }
      steps{
        sh 'jfrog rt upload --url https://victoremanuelsr.jfrog.io/artifactory/ --access-token ${ARTIFACTORY_ACCESS_TOKEN} target/PetStore.war petstore/'
      }
    }
  }
}
