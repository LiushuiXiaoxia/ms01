# Continuous Integration and Delivery

---

## Jenkins

https://www.jenkins.io/

```shell
brew install jenkins

brew services start jenkins

/usr/local/opt/openjdk@11/bin/java -Dmail.smtp.starttls.enable=true -jar /usr/local/opt/jenkins/libexec/jenkins.war \ 
  --httpListenAddress=127.0.0.1 --httpPort=8080
```

```shell
echo "Grant permission"
chmod u+x jenkins_build.sh

echo "Build docker"
bash jenkins_build_docker.sh
```

```shell
echo "Grant permission"
chmod u+x jenkins_build.sh

echo "Build docker"
bash jenkins_build_compose.sh
```