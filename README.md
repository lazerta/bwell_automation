# Framework Test 

##  Prerequisites For Running Test
 1. Java version 1.8 installed
 2. Chrome Browser(Any version)
 3. Internet connection
 4. Apache Maven 3.6.2 installed
 5.  make sure you have both Java and Maven in your PATH 

## Running the test 
Enter following command from your terminal 
 ```shell script
mvn test 
 ```
## Reporting
A HTML report will be generated in ``target/cucumber-report`` under working directory of the project

## Note 
Driver for Chrome will be downloaded automatically.
Check POM.xml for dependencies 

## Import Project Into Intelli 
Please follow 
https://vaadin.com/learn/tutorials/import-maven-project-intellij-idea

## Import Project Into VSCode
Please follow 
https://stackoverflow.com/questions/46671308/how-to-create-a-java-maven-project-that-works-in-visual-studio-code


## Structure
<pre>
├───main
│   ├───java
│   └───resources
└───test
    ├───java
    │   ├───generic  # all generic AUT independent code  
    │   │   ├───base  #  base utility
    │   │   ├───listeners 
    │   │   │   └───web # Selenium listener 
    │   │   └───po   # page object for complex web elements such as table
    │   ├───page_objects  # Page Object of AUT
    │   ├───runners  # Cucumber runner
    │   └───steps
    │       └───hooks
    └───resources
        └───features
</pre>
