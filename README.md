# Hr Application

This application is an Hr application written with spring boot framework and java programming language in the backend
The front-end is written with VueJs. 

## Features
A quick list of Hr application capabilities are
* Employee Management
* Access Control
* Project Management
* Real time chat between employee
* Payroll processing 
* Attendance Management
* Leave application and processing
* File Management
* Performance tracking 
* Reports
* PWA 

## Running the application
### Using Docker Compose
Make sure you have docker and docker-compose installed on your computer

First create a .env file in the root directory of the application and add the following env variables
* MYSQL_PASSWORD=yourdbpassword
* HR_SCHEMA=yourschema
* DB_USER=dbuser
* DB_USER_SECRET=dbusersecret

Run 
> docker-compose up
>
The above command will build and run a docker image 

To run image from docker-hub, run
> docker-compose -f docker-compose.prod.yml


##Current Backlog
* assign roles to users
* assign permissions to roles
* Edit employees
* Chat features
* Employee Performance evaluation
* Side Menu Access depending on role
* File Management


## Road Map
After doing basic Hr features, these will be the features we would like to add
* Oauth2 authentication
* Multi-tenancy
* Bulk sms 
* Bulk sending money/credit to employees
* Two factor authentication
* Desktop and Mobile versions
