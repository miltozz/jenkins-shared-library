def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-private-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t miltosdev/my-private-repo:jda-simple-1.0.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push miltosdev/my-private-repo:jda-simple-1.0.0'
    }
} 
