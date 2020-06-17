pipeline {
     agent any
     stages {
          stage("Checkout") {
               steps {
                    git url: 'https://github.com/leszko/calculator.git'
               }
          }
          stage("Compile") {
               steps {
                    sh "./mvnw compile"
               }
          }
          stage("Unit test") {
               steps {
                    sh "./mvnw test"
               }
          }
          stage("Package") {
               steps {
                    sh "./mvnw package"
               }
          }
          stage("Docker build") {
               steps {
                    sh "docker build -t mudho/hr ."
               }
          }
          stage("Docker push") {
               steps {
                    sh "docker push mudho/hr"
               }
          }
          stage("Deploy to staging") {
               steps {
                    sh "docker run -d --rm -p 8765:8080 --name hr leszko/calculator"
               }
          }
     }
     post {
          always {
               sh "docker stop calculator"
          }
     }
}