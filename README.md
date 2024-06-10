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