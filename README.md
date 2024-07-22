A. Create a Simple Project
B. Create a Container for Sonarqube and Jenkins with Docker Compose


testing
#docker-compose up -d

We access port 50000, Jenkins provides this information as part of the JNLP handshake process. This is part of the internal workings of Jenkins and usually does not need to be known to end users unless they are doing advanced troubleshooting or configuration.


On the docker desktop, we can see that docker-compose has started running.

C. Setup Sonarqube

After docker-compose is running, we access Sonarqube via the link : 'http://localhost:9000'. This will display the login page for Sonarqube on the web. Fill in the first login with the default configuration, namely 'admin' in both the login and password fields

After logging in, Sonarqube will direct you to the password update page. Fill in the password update and don't forget it

Set up project with the global setting and click Create Project.

After creating a new project, select and click 'Locally' to start analyzing the project.

sqp_ec87a46dddbee9d64b3b0329423a15822f748115

After clicking 'Continue' select the build. Because I am using a Maven project, we choose Maven.


mvn clean verify sonar:sonar \
  -Dsonar.projectKey=devops \
  -Dsonar.projectName='devops' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=sqp_ec87a46dddbee9d64b3b0329423a15822f748115




