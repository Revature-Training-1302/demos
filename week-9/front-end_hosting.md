## Hosting an Angular project on AWS

### Prerequisites
1. Make sure your back-end is hosted on AWS Elastic Beanstalk.
2. Ensure that your Spring controllers are annotated with @CrossOrigins(origins = "*")

### Steps
1. Make sure to replace all instances of localhost:8080 with the endpoint to your elastic beanstalk. 
    - it will look something like this: http://petebs-env.eba-guijimgt.us-east-1.elasticbeanstalk.com/
2. Run ng build within your Angular project.
    - The built project will appear in a folder "dist"
3. On AWS, create an S3 bucket.
4. Upload the contents of the dist folder into the bucket. 
5. Select all items in the bucket and make them public. 
6. From your bucket, select Properties tab and scroll to the bottom of the page.
7. Under "Static website hosting" click Edit.
8. Select Enable and specify index.html as the index document.
9. Click "Save Changes" and you will see your link appear. 

### Issues to Look out for
1. If you get an issue about not being able to provide service, include all of your services in the providers array in app.module.ts.
2. Ensure you have CORS enabled on all of your controllers. 
3. Make sure you click the link under "Static website hosting", NOT the public url of the bucket item.