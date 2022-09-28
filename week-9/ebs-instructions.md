## Overview
1. Create a Spring Boot project.
2. Create an S3 bucket to store the output of the build.
3. Create a Code Build to facilitate updates to the project.
4. Create an Elastic Beanstalk to host the project on the cloud.
5. Create and configure a Code Pipeline to send the build to the Elastic Beanstalk whenever changes are made to the repo.

## Set up the project
1. Create a file named .ebextensions in your root directory and include this text:
```
container_commands:
  fix_path:
    command: "unzip ROOT.jar 2>&1 > /var/log/my_last_deploy.log"
```
2. Create a file called "buildpsec.yml" in your root directory and include this: 
```
version: 0.2

phases:
  install:
    runtime-versions:
      java: corretto11
  post_build:
    commands:
      - mvn package
      - mv target/pet-0.0.1-SNAPSHOT.jar ROOT.jar
artifacts:
  files:
    - ROOT.jar
    - .ebextensions/**/*
```
- Note: "pet-0.0.1-SNAPSHOT.jar" should be whatever is output from a Maven package. You can verify this by running a maven package command on your local computer and examining the target folder for the output.
3. Upload your project to a repository. Make sure the root of the project is the root of the repository. 

## Create an S3 Bucket
1. Navigate to AWS S3
2. Click "Create Bucket"
3. Give it a name, must be unique
4. Leave other parameters default
5. To find the public S3 url for an item, navigate to the S3 bucket, find the specified file (ex: out.zip) and look at its properties

## Code Build
1. Naviage to AWS Code Build
2. Click on "Create build project"
3. Enter a name for this code build
4. For Source
  - Select Github for provider
  - Select Public Repository
  - For reporitory url, enter the url of your repository
5. Leave all other settings default except for the following:
- For Environment:
  - For Environment image, choose Managed image.
  - For Operating system, choose Amazon Linux 2.
  - For Runtime(s), choose Standard.
  - For Image, choose aws/codebuild/amazonlinux2-x86_64-standard:3.0.
- For Artifacts:
  - For Type, choose Amazon S3.
  - For Bucket name, enter the name of the S3 bucket that you created earlier
  - For Name, enter a build output file name that's easy for you to remember. Include the .zip extension. (ex: out.zip)
  - For Artifacts packaging, choose Zip.
6. Create the build and start it, ensure that it is successful. If not, examing the output and verify your buildspec file. It's usually most helpful to scroll to the bottom of the log and examine the output there.

## Create an Elastic Beanstalk app
1. Navigate to AWS Elastic Beanstalk
2. Click "Create a new environment"
3. Select Web server environment
4. Give it a name
5. For platform, choose Managed Platform
  - Platform = Java
  - Platform branch = Correto 11
  - Keep Platform version default
6. For application code, select upload your code
  - Public S3 url: the url of the S3 bucket from Code Build
  - It should look something like: https://out-rory.s3.amazonaws.com/out.zip
  - It will take a while to create the environment.
7. When done, click on and test the generated url. In Postman, you would just replace localhost:8080 with this new link
  - It should look something like this: http://pet-env.eba-ag72eu3d.us-east-1.elasticbeanstalk.com/
  - If you get a 502 error, you can go to the logs section and request either the last 100 lines or the entire log
  - Make sure RDS is up and running
  - To restart the environment, click on Actions and then Restart App Server
  - To rebuild the application (like if you made changes to the source code), click on Actions and then Rebuild Environment
  - Make sure to set port number to 5000

  ## Create a Code Pipeline
  1. Navigate to AWS Code Pipeline
  2. Click "Create Pipeline"
  3. For source, click Github version 2
  4. Create a connection to your Github account
    - Give a connection name
    - Click Install new app
    - Choose your account, or whatever org your repo is attached to
  5. Enter the repository name
  6. Under branch, select main
  7. Keep CodePipeline default
  8. For Build Provider, select AWS CodeBuild and select the code build that we set up
  9. For deploy, select Elastic Beanstalk
  10. Pick the Elastic Beanstalk that we set up
