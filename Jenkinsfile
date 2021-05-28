pipeline {

    agent any
    
    triggers {
    	pollSCM('* * * * *')
    }
    
    stages {
    	
    	stage('Compile stage') {
            steps {
                echo '-------- Compile Stage -----'
                sh 'mvn clean compile'
            }
        }
        
        stage('Test stage') {
            steps {
                echo '-------- Test stage -----'
                sh 'mvn clean test'
            }
        }
        
        
        stage('Build stage') {
            steps {
                echo '-------- Build stage -----'
                sh 'mvn clean package -DskipsTest'
            }
        }        
        
        stage('Deploy stage') {
            steps {
                echo '-------- Deploy stage -----'
            }
        }
    }
}