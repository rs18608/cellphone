# Cell Phone Usage Report
Quick effort for the Cell Phone Usage Report

### Data Model
Database tables are in comma separated files with the header in the first row. 

**CellPhone.csv**
*	employeeId
*	employeeName
*	purchaseDate
*	model

**CellPhoneUsageByMonth.csv** (beware that there may be more than one record for an employee on a single date, so it is not a perfect data in a perfect world)
*	employeeId
*	year
*	month
*	minutesUsed
*	dataUsed

### Report  

The report should contain the following information

**Header Section**

*	Report Run Date
*	Number of Phones
*	Total Minutes
*	Total Data
*	Average Minutes
*	Average Data

**Details Section**

For each company cell phone provide the following information
*	Employee Id
*	Employee Name
*	Model
*	Purchase Date
*	Minutes Usage
    *	one column for each month
*	Data Usage
    *	one column for each month

Report should be printed to a local printer in your computer.

# Tech Stack
Java is the programming language we want you use. Any version of Java will be fine. You can use open source libraries if you like.

# Guidelines
Build your own public repo on GitHub, and call it whatever you like. Build your solution in your repo, and include a README.md file that contains some instructions and notes about design choices you made that you want us be aware while reviewing your code. Email the URL for your github repo to your hiring manager once you begin the project so we can review your progress. Once your project is completed, please email your hiring manager.

One of the major goals in this project is to see how you fill in ambiguities in your own creative way. There is no such thing as a perfect project here, just interpretations of the instructions above, so be creative in your approach.

Thank you for your time. We are excited to review your project!
