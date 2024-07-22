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

Running our project with: 'mvn clean verify sonar:sonar'



After clicking 'Continue' select the build. Because I am using a Maven project, we choose Maven.


mvn clean verify sonar:sonar \
  -Dsonar.projectKey=devops \
  -Dsonar.projectName='devops' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=sqp_ec87a46dddbee9d64b3b0329423a15822f748115

  D. Setup Jenkins
We will access jenkins with 'http://localhost:8080/'. This will display the Unlock Jenkins page.

3)Add it to pom.xml in <properties></properties>.

4)After that, go to Sonarqube again and look in the Overview Menu section. Congratulations, our sonarqube has been analyzed as shown below.

We can get the administrator password via the Jenkins container log.

After we login, we will be directed to the Customize Zenkins page.

Choose install suggested plugins. After that you will be directed to create a new Jenkins account.

Fill in all the columns and click 'Save and Continue'.

Fill in all the columns and click 'Save and Continue'.

Click 'Save and Finish' with default URL. Click 'Start Jenkins', then we will be directed to the Jenkins Dashboard page.


Fill in all the columns and click 'Save and Continue'.

![1712202119002](https://github.com/user-attachments/assets/ccf4e68e-fec7-418e-975d-9032dee9fa55)



Click 'Save and Finish' with default URL. Click 'Start Jenkins', then we will be directed to the Jenkins Dashboard page.

Choose manage jenkins and click plugins.

Check whether the plugin is enabled.
Go back to the Manage Jenkins page, then click Credentials. Click System and then click Global Credentials to add New Credentials. The results are as below.

Select "Kind" with "Secret text," then fill in the "Secret" field with the SonarQube token. Next, fill in the "ID" and "Description" fields with "sonar-token." Click create.



Go back to the Manage Jenkins page, then click System. Find sonarqube server. Fill the forms with Name:'SonarQube', serverURL:'http://sonarqube:9000' and sonar-token.




Search for SonarQube Scanner and click install. Conveniently there is a Jenkins restart button. Click Restart Jenkins.


Go to Manage Jenkins — Tools. Add the Java home. Here i use Open JDK Zulu(17.0.10).

Add Maven and save it.

