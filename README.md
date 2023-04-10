# Framework con selenium, cucumber, junit y allure

## System Requirements:
+ jdk: https://docs.oracle.com/en/java/javase/index.html
+ maven: https://maven.apache.org/download.cgi
+ git client: https://www.atlassian.com/git/tutorials/install-git 
+ allure: https://github.com/allure-framework/allure2

# Getting started

- ## Running with Maven

    + ### First Step

        + Download and unzip the source repository for this guide, or clone it using Git:
      ```
      $ git clone https://gitlab.com/lippia/products/samples/lippia-web-sample-project.git
      ```

        + Go to root directory:
      ```
      $ cd lippia-web-sample-project
      ```   

    + ### Second Step

      If you want to run tests locally, you need maven as a minimum requirement
        + Make sure you have installed maven correctly

      ```
      $ mvn --version
  
        OUTPUT:
          Apache Maven 3.8.2 (ea98e05a04480131370aa0c110b8c54cf726c06f)
          Maven home: /opt/apache-maven-3.8.2
          Java version: 13.0.5.1, vendor: Debian, runtime: /usr/lib/jvm/java-13-openjdk-amd64
          Default locale: en_US, platform encoding: UTF-8
          OS name: "linux", version: "5.10.0-6parrot1-amd64", arch: "amd64", family: "unix"
      ```

      If you don't see a similar output:
        + Make sure you have the maven path configured
      #### Linux user
      ```
      $ grep -Ew '(.*)(M2_HOME)' ~/.bashrc
  
        OUTPUT:
          M2_HOME=/opt/apache-maven-3.8.2
          PATH=$PATH:$M2_HOME/bin
      ```   
      #### Windows user
      ```
      $ set
  
        OUTPUT:
          M2_HOME=C:\Program Files\apache-maven-3.8.2
          PATH=%PATH%;%M2_HOME%\bin;
      ```

    + ### Third Step

        + To run the tests with maven, we must execute the following command:

      ```
      $ mvn clean test
      ```
# Reports

To generate reports I'm use the Allure framework.
    
```
$ mvn allure:serve
```

## Project structure


```
  .
├── main
│     └── java
│           └── com
│                 └──crowdar
│                     ├── pages
│                     │     ├── HomePage
│                     │     └── LoginPage
│                     └── utilities 
│                           ├── ConfigReader
│                           └── DriverFactory
│
├── test
│     ├── java
│     │     ├── crowdar
│     │            ├──runner
│     │            │    └── TestRunner
│     │            └──step_definitions
│     │                  ├── StepDefinitionsWeb
│     │                  └── StepDefinitionsWs    
│     └──resources      
│          ├──config
│          │    └──config
│          └──features
│               ├──web
│               │    └──web.feature
│               └──ws
│                    └──ws.feature
```

## Driver options in DriverFactory file:

The WebDrivers for the following browser version are located in the 'drivers' folder.

| **Driver**    | **Description**      | 
|---------------|----------------------| 
| ChromeDriver  | Chrome 112.0.5615.50 |  
| Geckodriver   | Firefox 111.0.1      |
| EdgeDrive     | Edge 112.0.1722.34   |  
