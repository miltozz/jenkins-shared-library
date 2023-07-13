def call(String imageName) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-private-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName . "
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push $imageName"
    }
} 