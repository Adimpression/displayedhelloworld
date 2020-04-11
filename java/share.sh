set -e

echo "Remember to change your username from 'adimpression' to yours before pushing"
docker build -t adimpression/displayedhelloworld:1.0.0 .
docker push adimpression/displayedhelloworld:1.0.0
echo "Image will be available at https://hub.docker.com/repository/docker/adimpression/displayedhelloworld. Again, remember, this points to 'adimpression' and you should change it to your username"