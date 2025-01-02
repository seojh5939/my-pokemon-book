pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'develop', url: 'https://github.com/seojh5939/my-pokemon-book.git'
            }
        }
        stage('Build') {
            steps {
                // Gradle 빌드 실행
                sh './gradlew assembleDebug'
            }
        }
        stage('Unit Test') {
            steps {
                // Gradle 테스트 실행
                sh './gradlew testDebugUnitTest'
            }
        }
        stage('Instrumentation Test') {
            steps {
                // Android 기기 또는 에뮬레이터에서 테스트 실행
                sh './gradlew connectedDebugAndroidTest'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/build/outputs/**/*.apk', allowEmptyArchive: true
            junit 'app/build/test-results/**/*.xml'
        }
        failure {
            echo 'Build failed!'
        }
        success {
            echo 'Build succeeded!'
        }
    }
}
