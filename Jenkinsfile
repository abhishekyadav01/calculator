pipeline {
    agent any 
    stages {
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage("Unit Test") {
            steps {
                sh "./gradlew test"
            }
	}
	stage("Code Coverage") {
	    steps {
		sh "./gradlew jacocoTestReport"
  		publishHTML (target: [
			reportDir: 'build/reports/jacoco/test/html',
			reportFiles: 'index.html',
			reportName: "Jacoco Report"
		])
		sh "./gradlew jacocoTestCoverageVerification"	
		}
          }
	stage("Static Code Analysis") {
	    steps {
		sh "./gradlew checkstyleMain"
		publishHTML (target: [
			reportDir: 'build/reports/checkstyle/',
			reportFiles: 'main.html',
			reportName: "Checkstyle Report"
		])
		}
	}
	stage("Package") {
	    steps {
		sh "./gradlew build"
		}
	}
	stage("Docker Build") {
	    steps {
		sh "docker build -t calculator ."
		}
	}
	stage("Docker Push") {
	    steps {
		sh "docker push build01.centos.com/calculator"
		}
	}	
    }
}
