node{
    stage ('Git Checkout') {
  steps {
      git branch: 'main', url: 'https://github.com/Steffina1/Dtc-Website.git'
     }
  }
    stage('SCM checkout'){
    git 'https://github.com/Steffina1/Dtc-Website'
      }
    stage('Compile-Package'){
      sh 'mvn package'
    } 
}

