#JungleShoeTestProject

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

