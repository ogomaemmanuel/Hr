pipeline {
     agent any
     tools {
             maven 'apache-maven-3.0.1'
         }
     stages {
          stage("Compile") {
               steps {
                    sh "./mvnw compile"
               }
          }
          stage("Unit test") {
               steps {
                    sh "./mvnw test"
               }
                post {
                      always {
                         junit 'target/surefire-reports/*.xml'
                       }
                  }
          }
          stage("Package") {
               steps {
                    sh "./mvnw clean  package"
               }
          }
          stage("Docker build") {
               steps {
                    sh "docker build -t mudho/hr:${env.BUILD_ID} ."
               }
          }
          stage("Docker push") {
              //should run with docker credentials here, will add this;
               steps {
                    sh "docker push mudho/hr:${env.BUILD_ID}"
               }
          }
          stage("Deploy to staging") {
               steps {
                    sh "docker run -d --rm -p 8765:8080 --name hr mudho/hr"
               }
          }
     }
     post {
          always {
               sh "docker stop hr"
          }
     }
}