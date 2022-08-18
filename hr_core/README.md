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
The above command will build and run a docker image, to rebuild the image, add __--build__ option

To run image from docker-hub, run
> docker-compose -f docker-compose.prod.yml


### Using helm
Cd to helm directory and Run 
> helm install ogoma .  --create-namespace --namespace ogoma --set hr_deployment.image=mudho/hr --set hr_deployment.ingress.host=ogoma.bettle.com --set hr_deployment.databasePassword="Test%&123456"  --set hr_deployment.tenantName=ogoma  --debug

## Current Backlog
* [x] assign roles to users
* [ ] assign permissions to roles
* [ ] Edit employees
* [ ] Chat features
* [ ] Employee Performance evaluation
* [ ] Side Menu Access depending on role
* [ ] File Management


## Road Map
After doing basic Hr features, these will be the features we would like to add
* Oauth2 authentication
* Multi-tenancy using k8 and helm chart
* Bulk sms 
* Bulk sending money/credit to employees
* Two factor authentication
* Desktop and Mobile versions

## UI template references
* [Smart hr by dreamguys](https://smarthr.dreamguystech.com/smarthr-laravel/html-template/orange/index.html)
* [Lucid](http://www.wrraptheme.com/templates/lucid/hr/html/light/)
* [Epic Hr](https://preview.themeforest.net/item/epice-laravel-admin-template-for-hr-project-management/full_screen_preview/24466729?_ga=2.267228430.1032879915.1592443235-532036504.1591740750)
* [Hrsale](https://hrsale.com)
* [NewHrm by bdtask ltd](https://newhrm.bdtask.com/hrmv3_demo/login)
* [Hrm saas](https://hrm-saas.froid.works/panel/dashboard)
* [Mambu](https://support.mambu.com/docs/linking-products-to-accounting)
* [mostdesk](https://mostdesk.com)

