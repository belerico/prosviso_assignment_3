# ASSIGNMENT 3 - Let's Card Webapp

## Members:
+ Avogadro Roberto 807387
+ Belotti Federico 808708    
+ Carta Costantino 808417
    
## Project Repository and import information
+ Gitlab repository link: `https://gitlab.com/belerico/prosviso_assignment_3`

+ The project was developed using `Intellij IDEA`, you can directly import project from gitlab on IntelliJ.
+ On intelliJ --> 'File/new/Project from version control/git'
    + Insert the link of the gitlab repo.

+ Download IntelliJ --> `https://www.jetbrains.com/idea/`

## Requirements

+ Install MySQL v.5.7
+ The program will look for a db instance on `mysql://localhost:3306` running with a db within it called 'assignment3'
+ (If there is not any db called 'assignment3' it will be automatically created)
    + username: root
    + password: root
+ N.B: you can change access informations in file `src/main/resources/META-INF/persistence.xml`

+ Install maven : 
    + `sudo apt install maven`

+ Tested using openjdk 11.0.1 2018-10-16

+ Operating systems: Ubuntu 18.10 and 16.04 


## Run the webapp

+ View of the index page of the webapp

![](.README/CardWebapp.png)

+ Install the project
    + `mvn clean install`

+ Compile the project
    + `mvn compile`

+ Run jetty server
    + `mvn jetty:run`


## Test cases

We have implemented JUnit test cases for testing 'Services' of the application as they abstract "DAOs" which manage "CRUD" operations.
We used faker classes for testing the application as they were useful to generate entry in rapid way:
+ `src/main/java/com.assignment3/utils/faker`.

## Run test cases
+ command: `mvn test`

+ Snapshot of the console after running tests

![](.README/Test.png)




