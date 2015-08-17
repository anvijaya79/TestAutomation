# TestAutomation
This is a java project developed for the test automation of IMDb site . The tools used are Selenium Webdriver(For GUI automation),TestNG (for the test suite), ANT(build and execution tool).

The project name is IMDb.Design Approach followed is Page Object Model.In this approach each Page is represented by a Java class and GUI operations in that webpage is represented by functions in that class file.

Packages in this project are.

1. com.fyber.common.utils-Comprises of the class files  related to the automation framework.Logging.class is the file that has the API supporting logging using the log4j. 

2. com.fyber.imdb.testClasses-Comprises of the class files related to the tests that are to be executed as part of Automation.
Imdp.class is the file that has the testNg tests for this project Base.class is the file that has api for initialization of browser,implicit wait(webdriver wait and fluent wait)

3.  com.fyber.imdb.utils -Comprises of the classfiles that represent each webpage in the site-IMDbChartsPage , Locatorsandconstants -comprises of the element locators for each web page.

4. Inorder to make the build and for execution of the automation scripts the build.xml file of ANT is used. The ANT targets "compile" is used for the compilation of the class files of this project. Ant target "report" will execute the automation scripts and generate the test report.The folder testng-xslt has the report for the test exectuion. If the index.html file in this folder will display the report.testng.xml file has the class file and parameter details for the test execution.

5. The logs for the test execution will get generated in the folder Automationlogstestclasses.


