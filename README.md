#JungleShoeTestProject

==== Summary & Description for Project ====
UI test project JungleShoe Project developed in Java using Selenium webdriver and testng frameworks 
Used Page object based apporach for creating page object for each page and web elements. 
Question - https://gist.github.com/sturnquest/308557fb46d0b36cb49c

Automated Regression suite is divided in 3 sections 

Tests for Home page 
BrowserTests.java - Has code for loading home page and product selection 
verification of dropdown box 

Functional Tests for Product page 
Each product entry and calculate subtotal based on price and entered qty 
Multiple products selection and calculate subtotal 
Negative Tests for Invalid input for product quantity and error validation (TODO)

Functional Tests for Checkout Page
Validate Sales Tax , Total calculation for all states (1 item and different states)
Validate purchase for CA
Validate subtotal , tax and total 
Validate purchase for ny
Validate subtotal , tax and total 
Validate purchase for MN 
Validate subtotal , tax and total 
Validate purchase of other states (default 0.05%)
Validate subtotal , tax and total 
Validate Sales Tax and , total calculation for all states with multiple products


==== project directory structure ====
/pages ~ include page objects for UI screens - Product page and Checkout page 
/tests 	~ include tests for above UI pages
	~ BrowserTests.java - Include tests execution for chrome and Firefox browser - test loadhomePage - verify loading page in each browser and UI elements
	~ ProductTests.java - Verify purchase flow for individual product and multiple product selection (with predefine states in dataprovider)
	~ StateTests.java - Verify Sales tax selection for all states (with predefine states in dataprovider) 
	~ testng.xml - Include all tests configurations to run together 


==== Environment and dependancies ====
Language - Java
Framework 
 - Selenium webdriver ( please include jar files and lib files ) selenium-2.48.2
 - Testng (please include jar file) testng-6.9.6.jar (http://mvnrepository.com/artifact/org.testng/testng/6.9.6)
IDE - Eclipse 
chormedriver - chrome extension driver to run tests in chrome browser 

==== Instructions to run project in Eclipse ====
1. Download project src files in new project 
2. Include project dependancy for Project 
Project right click > Properties > Java build path > Select Library and add all Selenium and testng jar files and save . 
3. Select tests/testng.xml file and run as testng suite OR Select individual tests and run as testng tests 


==== Instructions to run project from command line ====
1. Download project and depandancies 
2. Set Environment veriables and class path
3. Command to run 
java -cp "Path to testng.jar" org.testng.TestNG ~/tests/testng.xml 



