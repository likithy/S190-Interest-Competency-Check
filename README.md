# S190-Interest-Competency-Check
Test Case Scenarios :
AUT - http://automationpractice.com/index.php

Assumptions: Data on the site is static

Navigate to multiple pages of the website and automate verification of header and footer.

Automate Newsletter subscription scenarios. The newsletter subscription is placed in the footer.

Automate Women > Dresses > Summer Dresses listing page. Note that filters and sorting options are broken on the site. Hence to verify filters and sorting, consider the default listing itself. (Tip - These two tests should obviously fail)

Consider the default listing and verify the results for any one of the filters.

Without applying any sorting for Price and Product name, verify the sorting results.

Verify the checkout journey by adding any product to the cart. *

Pre-requisities:
Eclipse
Maven
Chrome
ChromeDriver(if broswer updates)

Description:

The framework is designed using page object model. Excel sheets are used considering the number of test cases.Selenium 3.141 is used to automate the test cases. Chromium driver is used for the browser.

Execution:

The project can be executed by running the Test class as TestNG suite under the Tests package.

