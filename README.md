# Hr Application

This application is an Hr application written with spring boot framework and java programming language in the backend
The front-end is written with VueJs. 

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