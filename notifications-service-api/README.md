***********************Steps to use the microservice archetype************

1. cd into the folder that your project will reside.

2. Generate the new microservice using the following command
- mvn archetype:generate -DarchetypeGroupId=za.co.discovery.pace.archetype -DarchetypeArtifactId=micro-service-archetype
      -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=newMicroserviceGroupId
      -DartifactId=newMicroserviceArtifactId -DpackageName=newMicroserviceName -DinteractiveMode=false
      
- Replace place holders with relevant details.

3. The command will generate a parent project with 3 modules.

4. In the api module find bootstrap.yml and application.yml files and update port to correct one.

5. Update the micro-service-config repository to add configuration for the new microservice