pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your code from SCM
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project using Maven.'
                sh 'cd my-App-mvn'
                sh 'mvn -B clean package'
            }
        }

        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit and integration tests using JUnit and Mockito.'
                sh 'cd my-App-mvn'
                sh 'mvn test'
            }
        }

        stage('Code Analysis') {
            steps {
                echo 'Analyzing code with SonarQube.'
                 sh 'cd my-App-mvn'
                sh 'mvn sonar:sonar'
            }
        }

        stage('Security Scan') {
            steps {
                echo 'Performing security scan with OWASP ZAP.'
                sh 'cd my-App-mvn'
                sh 'zap-cli quick-scan'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to AWS EC2 staging instance.'
                sh 'cd my-App-mvn'
                sh 'deploy-to-aws.sh staging'
            }
        }

        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on staging environment.'
                sh 'run-integration-tests.sh'
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Deploying to AWS EC2 production instance.'
                sh 'deploy-to-aws.sh production'
            }
        }
    }

    post {
        always {
            emailext(
                to: 'mehboobmaitla@gmail.com',
                subject: "Jenkins Pipeline Notification: '${env.STAGE_NAME}'",
                body: """Stage '${env.STAGE_NAME}' completed with status: ${currentBuild.result}. 
                         Check the attached logs for more details.""",
                attachmentsPattern: '**/target/*.log'
            )
        }
    }
}
