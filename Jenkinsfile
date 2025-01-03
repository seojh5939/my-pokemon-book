pipeline {
  agent any
  stages {
    stage('install-android-sdk') {
      steps {
        sh 'curl -0 https://dl.google.com/android/repository/commandlinetools-linux-6858069_latest.zip > /Users/david/.jenkins/workspace/my-pokemon-book_develop/commandlinetools-linux-6858069_latest.zip'
       sh '''
           pwd
           ls -l
       '''
        sh 'unzip *.zip'
        sh 'rm *.zip'
        sh 'echo \'y\' | cmdline-tools/bin/sdkmanager --sdk_root=sdk \'platform-tools\''
        sh "echo 'ANDROID_SDK_ROOT : $WORKSPACE/sdk'"
      }
    }

    stage('Checkout') {
      steps {
        git(branch: 'develop', url: 'https://github.com/seojh5939/my-pokemon-book.git')
      }
    }

    stage('Build') {
      steps {
        sh 'echo "sdk.dir=/Users/david/.jenkins/workspace/my-pokemon-book_develop/sdk" >> local.properties'
        sh './gradlew assembleDebug'
      }
    }

    stage('Unit Test') {
      steps {
        sh './gradlew testDebugUnitTest'
      }
    }
  }
  post {
    always {
      archiveArtifacts(artifacts: '**/build/outputs/**/*.apk', allowEmptyArchive: true)
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