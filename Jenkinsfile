pipeline {
    agent any
    environment {
        BRANCHE_DEV = 'origin/develop'
        BRANCHE_PROD = 'origin/main'
        NEXUS_DOCKER_REGISTRY = "http://prod.local:5003"
        NEXUS_CREDENTIALS_ID = "nexus-credentials"
        DOCKER_IMAGE_NAME = "devops-project-samples"
        DOCKER_IMAGE_TAG = "prod.local:5002"
    }
    stages {
      

        stage('Docker Build and Push to Nexus') {
            steps {
                script {
                    envName = "dev"
                    if(env.GIT_BRANCH == BRANCHE_PROD) {
                        envName = "prod"
                    }
                    envVersion  =  getEnvVersion(envName)
                    withCredentials([usernamePassword(credentialsId: "${NEXUS_CREDENTIALS_ID}", usernameVariable: 'USER', passwordVariable: 'PASSWORD')]){
                        sh 'docker login -u $USER -p yassine $NEXUS_DOCKER_REGISTRY' 
                        sh 'docker system prune -af'
                        sh "docker build -t $DOCKER_IMAGE_TAG/$DOCKER_IMAGE_NAME:$envVersion --no-cache --pull ."
                        sh "docker push $DOCKER_IMAGE_TAG/$DOCKER_IMAGE_NAME:$envVersion"
                    }
                }
            }
        }
      

       
    }
}
def getEnvVersion(envName) {
    def pom = readMavenPom file: 'pom.xml'
    // get the current development version
    artifactVersion = "${pom.version}"
    def gitCommit = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
    def versionNumber;
    if (gitCommit == null) {
        versionNumber =artifactVersion+"-${envName}."+env.BUILD_NUMBER;
    } else {
        versionNumber =artifactVersion+"-${envName}."+env.BUILD_NUMBER+'.'+gitCommit.take(8);
    }
    print 'build ${environnement} versions...'
    print versionNumber
    return versionNumber
}
