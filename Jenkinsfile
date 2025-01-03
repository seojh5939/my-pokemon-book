pipeline {
    agent any

    environment {
            PATH = "/usr/local/bin:${env.PATH}"
    }
    stages {
        stage('install-android-sdk') {
            steps {
                sh "wget https://dl.google.com/android/repository/commandlinetools-linux-6858069_latest.zip"
                sh "unzip *.zip"
                sh "rm *.zip"
                sh "echo 'y' | cmdline-tools/bin/sdkmanager --sdk_root=sdk 'platform-tools'"
                sh "echo 'ANDROID_SDK_ROOT : $WORKSPACE/sdk'"
            }
        }
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
