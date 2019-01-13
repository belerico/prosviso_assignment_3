# ASSIGNMENT 3

Members:
+ Avogadro Roberto 807387
+ Belotti Federico 808708    
+ Carta Costantino 808417
    
+ Repository with the project's code:
https://gitlab.com/belerico/prosviso_assignment_3

## Requirements

+ Install MySQL v.5.7
+ The program will look for a db instance on 'mysql://localhost:3306' running with a db within it called 'assignment3'
+ (If there is not any db called 'assignment3' it will be automatically created)
    + username: root
    + password: root
+ N.B: you can change settings in file src/main/resources/META-INF/persistence.xml

+ Install maven : 
        + sudo apt install maven

+ Tested with openjdk 11.0.1 2018-10-16

+ Ubuntu 18.10 and 16.04 


## Run the project

+ Install the project
    + mvn clean install

+ Compile the project
    + mvn compile

+ Run jetty server
    + mvn jetty:run


## Test cases

We have implemented JUnit test cases for testing services of the application.
This because "Services" abstract "DAOs" which have to manage "CRUD" operations.
We used faker classes for testing the application as they were useful to generate entry in rapid way:
+ src/main/java/com.assignment3/utils/faker.


### Run test cases
+ mvn test




