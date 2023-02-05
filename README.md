# Dafa Bet API Test Automation Framework

This Test Automation Framework is created using Java + TestNG + RestAssured + Allure-reports, 
which can be used for api web services. 

# Pre-Requisites
* IntelliJ or Eclipse
* Java JDK-1.8 or higher
* Apache Maven 3 or higher
* Git
* Allure Reports Package  

# Reporting

* The framework supports Allure Report for Reporting purpose. 
* On execution, new directory is created under target folder where all artifacts related to the execution resides. 
* The report gives the details information on the Request & Response for each API executed.

Steps to run Framework
1. Install Java, Maven
2. Configure environment variables JAVA_HOME, and MAVEN_HOME
3. Install git
4. Install allure-reports 
   1. Through powershell for Windows
   2. Through brew for Mac
5. Import project in Eclipse or IntelliJ
6. Run the command mvn clean install test
7. Test execution will happen and result will be generated target/allure-results
8. Run following commands 
   1. Change Directory to target folder using -> cd target
   2. Run command - allure serve allure-results

