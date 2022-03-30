pipeline {
    agent any

    stages {
        stage('clone code') {
            steps {
                // Get some code from a GitHub repository
                git (url: 'https://github.com/BenBarnhill/project-3-back-end.git', branch:'main')
                
                echo 'clone step'
            }
        }
        stage('build code') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean package -DskipTests"
                echo 'build step'
            }
        }
        stage('staging') {
            steps {
            	echo 'deploy step'
            	
               sh "docker-compose down"
                   
               sh "docker-compose up"
            }
        }
    }
}