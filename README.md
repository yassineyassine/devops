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


Add Sonarqube Scanner



Add Maven and save it.

After that, go to the dashboard then click new item to create a job. Give the job a name and then select Pipeline.


After that, go to the dashboard then click new item to create a job. Give the job a name and then select Pipeline.

Go to the General section and provide your Git repo URL.

Back to Jenkins Container and execute 'ssh-keygen' and Click Enter until Finish.


Execute and get your Jenkins private key with :'cat .<your/directory>id_rsa'. In my case, i do this 'cat ./var/jenkins_home/.ssh/id_rsa'. Copy Private Key.

-----BEGIN OPENSSH PRIVATE KEY-----
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
-----END OPENSSH PRIVATE KEY-----
