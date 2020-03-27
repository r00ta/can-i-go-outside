cd ..
mvn clean package
sudo docker build . -t r00ta/canigoout:latest
sudo docker push r00ta/canigoout:latest
