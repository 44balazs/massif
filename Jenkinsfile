// Tell Jenkins how to build projects from this repository
pipeline {
	agent any 
	parameters {
		string(name: 'VIATRA_REPOSITORY', defaultValue: 'https://hudson.eclipse.org/viatra/job/viatra-master/lastSuccessfulBuild/artifact/releng/org.eclipse.viatra.update/target/repository')
	}

    // Keep only the last 20 builds
	options {
		buildDiscarder(logRotator(numToKeepStr: '20'))
	}
	
	tools { 
        maven 'Maven 3.3.9' 
        jdk 'Oracle JDK 8' 
    }
	 
    stages { 
       stage('Build') { 
            steps {
                configFileProvider([configFile(fileId: 'default-maven-toolchains', variable: 'TOOLCHAIN'), configFile(fileId: 'default-maven-settings', variable: 'MAVEN_SETTINGS')]) {
                    sh "mvn clean install -B -t $TOOLCHAIN -s $MAVEN_SETTINGS -f releng/hu.bme.mit.massif.parent/pom.xml -Dviatra.repository.url=${env.VIATRA_REPOSITORY} -Dmaven.repo.local=$WORKSPACE/.repository"
                    sh "mvn clean deploy -B -t $TOOLCHAIN -s $MAVEN_SETTINGS -f releng/hu.bme.mit.massif.parent/pom.xml -Dviatra.repository.url=${env.VIATRA_REPOSITORY} -Dmaven.repo.local=$WORKSPACE/.repository"
                }
            	sh './releng/massif.commandevaluation.server-package/prepareMatlabServerPackage.sh'
            	sh './releng/hu.bme.mit.massif.simulink.cli-package/prepareCLIPackage.sh'
            }
		}
        stage('Sonar') {
            when {
                expression {return !params.SKIP_SONAR }
            }
            steps {
                wrap([$class: 'TimestamperBuildWrapper']) {
                    configFileProvider([
                        configFile(fileId: 'maven-toolchain-oldjdk', variable: 'TOOLCHAIN'),
                        configFile(fileId: 'default-maven-settings', variable: 'MAVEN_SETTINGS')]) {
                            withSonarQubeEnv('IncQuery Labs SonarQube') {
                                sh "mvn sonar:sonar -B -t $TOOLCHAIN -s $MAVEN_SETTINGS -f releng/hu.bme.mit.massif.parent/pom.xml -Dmaven.repo.local=$WORKSPACE/.repository -DBUILD_TYPE=${params.BUILD_TYPE} -Dmirror-integration=false -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.scm.disabled=true"
                            }
                    }
                }
            }
        }
        stage('Deployment') {
            steps{
                sh "if [ -d 'massif-install-artifacts' ]; then rm -fr massif-install-artifacts; fi"
                sh "mkdir massif-install-artifacts"
                sh "mkdir massif-install-artifacts/${params.BUILD_TYPE}"
                sh "mkdir massif-install-artifacts/${params.BUILD_TYPE}/site"

                sh "cp -R releng/hu.bme.mit.massif.site/target/repository/* massif-install-artifacts/${params.BUILD_TYPE}/site/"
                sh "cp releng/massif.commandevaluation.server-package/massif.commandevaluation.server.zip massif-install-artifacts/${params.BUILD_TYPE}/massif.commandevaluation.server-${params.BUILD_TYPE}_${env.BUILD_NUMBER}.zip"
                sh "cp releng/hu.bme.mit.massif.simulink.cli-package/hu.bme.mit.massif.simulink.cli-example.zip massif-install-artifacts/${params.BUILD_TYPE}/hu.bme.mit.massif.simulink.cli-example-${params.BUILD_TYPE}_${env.BUILD_NUMBER}.zip"
                sshagent(['24f0908d-7662-4e93-80cc-1143b7f92ff1']) {
                    sh 'scp -P 45678 -r massif-install-artifacts/* jenkins@static.incquerylabs.com:/home/jenkins/static/projects/massif/massif-artifacts'
                    sh 'ssh -p 45678 jenkins@static.incquerylabs.com /home/jenkins/static/projects/massif/massif-artifacts.sh'
                }
            }
        }
    }
    
    post {
        always {
            archiveArtifacts 'releng/hu.bme.mit.massif.site/target/repository/**'
            archiveArtifacts 'releng/massif.commandevaluation.server-package/massif.commandevaluation.server.zip'
            archiveArtifacts 'releng/hu.bme.mit.massif.simulink.cli-package/hu.bme.mit.massif.simulink.cli-example.zip'
   		}
        success {
            slackSend channel: "viatra-notifications", 
    			color: "good",
			message: "Build Successful - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)",
    			teamDomain: "incquerylabs",
    			tokenCredentialId: "6ff98023-8c20-4d9c-821a-b769b0ea0fad" 
        }
		unstable {
	   		slackSend channel: "viatra-notifications", 
    			color: "warning",
    			message: "Build Unstable - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)",
    			teamDomain: "incquerylabs",
    			tokenCredentialId: "6ff98023-8c20-4d9c-821a-b769b0ea0fad"
    		}
		failure {
    			slackSend channel: "viatra-notifications", 
    			color: "danger",
    			message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)",
    			teamDomain: "incquerylabs",
    			tokenCredentialId: "6ff98023-8c20-4d9c-821a-b769b0ea0fad"
		}
	}
}
