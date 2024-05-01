# Assignment 1

Due 16th March 21:00, Worth 5%  
Starting point/ Template: [assignment1template.zip](<ins>assignment1template.zip</ins>) (bottom of the page)  

**Import into Eclipse Using:**

1. File
2. Import
3. General
4. Existing projects into workspace
5. Select Archive File
6. Browse for file
7. Finish

**Relevant Video:** [Importing Projects from Archive File](https://www.youtube.com/watch?list=PL25sMKw559Gg9xlmLVLkmpS5XZJ-pvCd-&v=enbPj-RvXdE)  

---

**Introduction**

Assignment 1 deals with handling a very fundamental data structure - an array of arrays. The array **data** inside class **Analytics.java** is an instance variable and thus automatically available in all the functions. (We will talk about this in weeks 3 and 4). There are 10 functions (plus 2 non-assessed) that operate on this array and other parameters, where required. The description of each function is above the header.

**Relevant Video:** [Arrays #6: Multi-Dimensional Arrays](https://www.youtube.com/watch?list=PL25sMKw559Gg9xlmLVLkmpS5XZJ-pvCd-&v=TgGm7lScfeA)

(Also, the videos prefixed with **Array Problems** in the same YouTube Playlist will be very useful.)

---

**Grade Distribution**

Your job is to code each of the 10 methods in **Analytics.java** and pass the corresponding tests in **AnalyticsTest.java**. There are 4 tests for each method (P, CR, D, HD). Pass level tests are the most basic and HD level tests are the most comprehensive.

**IMPORTANT** Note that the instance variable (the array of array of integers: data) can be accessed inside any of the functions without having to pass it as a parameter. As an example, assuming the third item of the fifth sub-array exists, we can access it (say, for displaying) as,

```java
System.out.println(data[4][2]);
```

If we want to display the last item of the last sub-array (assuming the last sub-array is not null and it contains at least one item), that can be done as:

```java
int lastSubArrayIndex = data.length - 1;
int lastItemOfLastSubArrayIndex = data[lastSubArrayIndex].length - 1;
System.out.println(data[lastSubArrayIndex][lastItemOfLastSubArrayIndex]);
```

---

**Helper Functions**

You can add other functions inside the class and call them in the functions you are supposed to complete. You can also use existing functions to help you with the more advanced functions if needed.

---

**Note of JUnit Test Cases Provided**

Understanding what the tests are asking will be critical to you solving the assignment.

Note that the tests are for your convenience only and while it's likely that if your code passes the given tests, it will also pass the final tests, in a few cases students hard-code their solutions.

Therefore, passing these tests does not guarantee that you WILL get marks in the final test. We will test your code on another data set (nothing too absurd) to eliminate hard-coding. So, instead of 4 sub-arrays, I might use 40 sub-arrays, or I might negate each value.

However, if your code works for a generic data set, you don't need to worry.

Bottom line: **DON'T HARD-CODE**

**Relevant video:** [Tracing an Error when a JUnit Test Cas…](https://www.youtube.com/watch?list=PL25sMKw559Gg9xlmLVLkmpS5XZJ-pvCd-&v=ySeBxF-LtH4)![](Aspose.Words.d6cbeacc-fee8-49f7-a51e-c2cb16acdf1d.003.png) 

---

**Use of Functions Outside the Class**

You cannot use any function that is not defined in the class. So, you cannot use **Math.abs(double)** or **Arrays.toString()** and so on.

YOU WILL BE GIVEN A ZERO IF YOU USE AN EXTERNAL FUNCTION

---

**Coding Style**

We are not going to mark coding style in assignment 1, but we will mark it in one of the later assignments. Make sure you,

1. Indent your code correctly. [Indentation style](https://en.wikipedia.org/wiki/Indentation_style)
2. Use consistent coding style (C-style indentation with C-style variable naming OR Java-style indentation with Java-style variable naming) and stick with it throughout the submission.
3. Have documentation in the form of comments where required. Especially important for non-trivial implementations.

---

**Breach of Academic Integrity**

You must add your Student ID, Name at the top of **Analytics.java** and put an x in the square brackets to confirm that you haven't viewed any other person's code. If your code is found to be similar to other students, you will be referred to the faculty disciplinary committee (FDC) and it's a painful process. So, make sure you design and write your own code and don't even look at another person's code.

Make sure you update the top of **Analytics.java** with the information required.

For example:

```java
//Gaurav Gupta
//40404040
//[x]   I confirm this is my own work (in design and implementation) 
//      and that I have not viewed another student's code OR design.
```

---

**Submission**

Submit only file **Analytics.java** by dragging from Eclipse package explorer and dropping it right into the submission box. Do not drag **AnalyticsTest.java** or **Analytics.class** accidentally.

DO NOT RENAME THE FILE. WE NEED THE FILE TO BE NAMED **Analytics.java**

You can make the submission as many times as you want, and only the last one will be marked. If you make a submission after the due date, a late penalty will be applied at the rate of 20% per day or part of (1 second to 24 hours: 20%, 24 hours 1 second to 48 hours: 40%, and so on). For example, if your raw mark is 68 and it's late by 1 second, your mark will be reduced to 48.

Any errors in submission (compilation error, even because of a single extra curly bracket or a missing semi-colon), any file with a different name than the required one (**Analytics.java**), any programs that take longer than 5 seconds to run, use of external functions will automatically get a zero grade.

---

Wishing you the best of luck! 

---

- [assignment1template.zip](https://github.com/AvaMGardiner/COMP1010-Fundamentals-of-Computer-Science/files/15182029/assignment1template.zip)
