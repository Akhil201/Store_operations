

# Store_operations
For Calculating discounts based on customer types 

## Sonar Report
[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=Akhil201_Store_operations2)](https://sonarcloud.io/dashboard?id=Akhil201_Store_operations2)

## Class Diagram
![Alt text](store_operations_class_diagram.png?raw=true "Class Diagram")


## Coverage Report
![Alt text](store_operation_coverage_test.png?raw=true "Coverage Result")


## JUnit Execution Result
![Alt text](store_operations_junit_test.png?raw=true "JUnit Execution Report")


## Running JUnit and Coverage Test

1.  Using Eclipse
      
      Right click on your project in the Project Explorer then select "Coverage As" > "JUnit Test". Eclipse will run the test and generate a report about the Junit execution as well as the coverage result. 

2.  Using Maven 
      
      i. Install Maven. 
      
      ii. Go to the project directory, then run mvn test. Maven will run the test and generate the Junit execution report. Coverage report will be generated at PROJECT_DIRECTORY\target\surefire-reports\