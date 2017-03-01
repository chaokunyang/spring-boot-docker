1、if you are using boot2docker you need to run it first before you do anything with the Docker command line or with the build tools (it runs a daemon process that handles the work for you in a virtual machine).

2、To build the image you can use some tooling for Maven or Gradle from the community (big thanks to Transmode and Spotify for making those tools available).

3、You can build a tagged docker image and then push it to a remote repository using the "docker" command line like this:

  $ mvn package docker:build -DpushImage
  
  package MUST be run before docker:build. Otherwise, it will fail.
  
  4、gradle构建则是：./gradlew build buildDocker
  
  5、使用  docker run -p 8080:8080 -t chaokunyang/spring-boot-docker
  启动容器，在浏览器打开网址：http://192.168.99.100:8085/ 得到内容：spring boot gradle docker
  
  6、Using Spring Profiles
    
   Running your freshly minted Docker image with Spring profiles is as easy as passing an environment variable to the Docker run command：
   docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t chaokunyang/spring-boot-docker
   
   or :
   docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 -t chaokunyang/spring-boot-docker
   
 7、
 Debugging the application in a Docker container
 
 To debug the application JPDA Transport can can be used. So we’ll treat the container like a remote server. To enable this feature pass a java agent settings in JAVA_OPTS variable and map agent’s port to localhost during a container run. With the Docker for Mac there is limitation due to that we can’t access container by IP without black magic usage.
 
 $ docker run -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t chaokunyang/spring-boot-docker
