pipeline {
    agent any
    environment {
        BRANCHE_DEV = 'origin/develop'
        BRANCHE_PROD = 'origin/main'
        NEXUS_DOCKER_REGISTRY = "http://localhost:5003"
        NEXUS_CREDENTIALS_ID = "nexus-credentials"
        DOCKER_IMAGE_NAME = "devops-project-samples"
        DOCKER_IMAGE_TAG = "localhost:5003"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Pulling... ' + env.GIT_BRANCH
            }
        }

        stage('Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Sonarqube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('sonar-server') {
                        sh "mvn sonar:sonar -Dintegration-tests.skip=true -Dmaven.test.failure.ignore=true"
                    }
                    timeout(time: 1, unit: 'MINUTES') {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
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
