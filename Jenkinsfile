pipeline {
    agent any

    stages {
        stage('check code') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '8b6c7900-9c92-4cba-888f-cd5a93b83ab2', url: 'https://github.com/xiangfu-zhong/product-server.git']])
            }
        }


        stage('maven package') {
            steps {
                echo 'maven package'
                sh 'mvn -v'
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }

        stage('build image') {
            steps {
                echo 'build image'
                sh 'mv ./target/*.jar .'
                sh 'docker build -t product-server .'
            }
        }

        stage('push image') {
            steps {
                echo 'push image'
                sh '''docker login -u admin -p Harbor12345 192.168.126.146:80
                docker tag order-server 192.168.126.146:80/repo/product:v1.0.0
                docker push 192.168.126.146:80/repo/product:v1.0.0'''
            }
        }

        stage('deploy') {
            steps {
                echo 'deploy'
                sshPublisher(publishers: [sshPublisherDesc(configName: 'k8s', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'k8s-product.yml')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                sh '''ssh root@192.168.126.147
                kubectl delete -f k8s-product.yml
                kubectl apply -f k8s-product.yml
                kubectl rollout restart deployment product -n test'''
            }
        }
    }
}
