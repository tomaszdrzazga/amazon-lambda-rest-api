# AWS Lambda JAVA8 REST API - serverless 

### Spring boot application with Rest API as a proxy to Amazon RDS MySQL databse.


#### 1 Usage : 

##### 1.1. Clone project and configure database

    spring.datasource.url=jdbc:mysql://url-to-database.rds.amazonaws.com:3306/batabase-name
    spring.datasource.username=user
    spring.datasource.password=password

##### 1.2. Build and run project 

    mvn clean install
    mvn spring-boot:run

##### 1.3. Check localy 

    http://localhost:9000/status
    expected response : "ALIVE"


##### 1.4. Rest API methods for entity User

    @Entity
    public class User {
    
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String name;
        private String email;

Rest API methods :

    GET http://localhost:9000/users
    POST http://localhost:9000/users?name=Tom&email=mail@amazon.com
    GET http://localhost:9000/users/{id}
    DELETE http://localhost:9000/users/{id}
    PUT http://localhost:9000/users/{id}?name=newname&email=mail@amazon.com
    
    GET http://localhost:9000/status
    
#### 2. Deploy target/amazon-lambda-rest-api-0.0.1-SNAPSHOT.jar as AWS Lambda and expose as AWS Api Gateway

##### 2.1 Youtube movie :

https://www.youtube.com/watch?v=LLEvZJn-8-E

Important : Lambda needs time to warm up. Click 2-3 times to "Test" button.

    
#### 3. Publish API and test 

##### 3.1 Youtube movie :

https://www.youtube.com/watch?v=Q98vrCeU97A

##### 3.2 Index.html - test page :

Project contains index.html page to test API. You need to change 'YOUR-API-URL' for Your new amazon url received after publish. (example value : 7g6esdddssal.execute-api.eu-central-1.amazonaws.com)