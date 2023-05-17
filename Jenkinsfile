pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk11'
        }
   
        stages {
        stage('Check Out') {
            steps {
              checkout([$class: 'SubversionSCM', additionalCredentials: [], excludedCommitMessages: '', excludedRegions: '', excludedRevprop: '', excludedUsers: '', filterChangelog: false, ignoreDirPropChanges: false, includedRegions: '', locations: [[credentialsId: 'fc2c9edf-9bb5-4d6f-bed9-e9d19eddfe03', depthOption: 'infinity', ignoreExternalsOption: true, local: 'pt.irn.generate', remote: 'https://mobifly.xp-dev.com/svn/einvoice/trunk/NIC/ec2.irn.pt.api.generate']], quietOperation: true, workspaceUpdater: [$class: 'UpdateUpdater']])
            }			
        }
        stage('Build') {
				steps {         dir ('pt.irn.generate')
								{
								bat 'mvn clean install'
								}
						}
								post {  
       
          always {
            
               emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}", 
				to: "ashish@mobifly.in"
            
            
        }
          
     }
								 
								
								 							
            }
		stage('Deploy on EInvoice Dev(11.0.2.173)') {
            steps {
			timeout(time: 10, unit: "MINUTES") {
                input('Do you want to proceed?')
            bat 'echo y | pscp -pw P@ss1234 pt.irn.generate/target/*.jar root@11.0.2.173:/dev-env/einvoice-nic'
			
            }
			}
			  post {  
       
          always {
            
              emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Dev Deploy ${currentBuild.currentResult}: Job ${env.JOB_NAME}", 
				to: "ashish@mobifly.in"
            
            
        }
          
     }
	 }   

stage('Deploy on EInvoice QA(11.0.2.174)') {
            steps {
	    timeout(time: 10, unit: "MINUTES") {
                input('Do you want to proceed?')
            bat 'pscp -pw P@ss1234 pt.irn.generate/target/*.jar root@11.0.2.174:/qa-env/einvoice-nic'
			bat "echo y"
}
			
            }
			  post {  
       
          always {
            
              emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Dev Deploy ${currentBuild.currentResult}: Job ${env.JOB_NAME}", 
				to: "ashish@mobifly.in"
            
            
        }
          
     }
	 }   	 
    }
}