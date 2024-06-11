# Pet Store API Automation And Performace 

This project demonstrates automated testing of the Pet Store API using a combination of Java, Serenity, RestAssured, and Cucumber. The primary focus is on the "Get Pet" APIs, ensuring they function correctly and meet the specified requirements.

## Project Structure
- Java: The programming language used for the test implementation.
- Gradle Build automation tool to manage dependencies and run tests
- Serenity: Provides BDD-style reporting and integrates seamlessly with Cucumber.
- RestAssured: Simplifies the process of testing REST APIs.
- Cucumber: Enables Behavior-Driven Development (BDD) and defines test scenarios in a human-readable format.

## Project Step Up 
1. Clone the Repository:
```sh
 git clone https://github.com/alexavalencia/petstore-api-automation.git
```

2. Run Test
```sh
 gradle clean test -Denvironment=prod
```

if you have the Swagger Pet store project running locally you can use 
```sh
 gradle clean test -Denvironment=dev
```

## Reporting
Serenity will generate detailed reports in the target/serenity directory. Open index.html in a browser to view the test results.

## Directory Structure:
```.
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── performance-test
│   ├── Dockerfile
│   ├── getPetByStatus-Stress.js
│   └── getPetByStatus.js
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── petstore
    │   │           └── constants
    │   │               └── BasePaths.java
    │   └── resources
    └── test
        ├── java
        │   └── com
        │       └── petstore
        │           ├── runner
        │           │   └── CucumberTestSuite.java
        │           └── stepdefinitions
        │               └── Pet.java
        └── resources
            ├── feature
            │   └── getPet.feature
            ├── schema
            │   ├── getPetByIdSchema.json
            │   └── getPetByTagsSchema.json
            └── serenity.conf
```

## Performance Testing

## Project Step Up 
1. Go to the performance directory:
```sh
 cd performance-test
```

2. build the image for K6 
```sh
 docker build . -t dock-k6
```

3. Run load testing  
```sh
 docker run -i dock-k6 run - <getPetByStatus.js 
```

4. Run Stress testing  
```sh
 docker run -i dock-k6 run - <getPetByStatus-Stress.js 
```

I conducted tests on the API responsible for retrieving animal data from the state. The GET method, which retrieves information from the database, can be impacted by performance due to handling large data volumes.

Since this is our initial interaction with the API and we have no non-functional requirements, the tests aim to determine response times and the request capacity per second. This information will help define the requirements for the business owner.

We will conduct load tests to ensure that 99.9% of response times are below 100ms and to identify failure points under a specific number of users.

It's important to monitor the environment to analyze CPU and memory consumption, and to observe if any containers were restarted or new instances were created as the number of users increased.

### Load

### Stress

![image](https://github.com/alexavalencia/petstore-api-automation/assets/14083095/04af65cd-8424-4d91-b4e4-d68b24fb8b13)

