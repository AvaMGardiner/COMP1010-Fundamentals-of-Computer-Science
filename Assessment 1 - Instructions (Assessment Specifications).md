# Assignment 1

**Due Date:** 16th March, 21:00  
**Weight:** 5%

**Starting Point/Template:** [assignment1template.zip](<ins>assignment1template.zip</ins>) (located at the bottom of the page)

**Instructions for Importing into Eclipse:**

1. Open Eclipse.
2. Go to `File`.
3. Select `Import`.
4. Choose `General`.
5. Click on `Existing Projects into Workspace`.
6. Select `Archive File`.
7. Browse for the file.
8. Click `Finish`.

**Relevant Video:** [Importing Projects from Archive File](https://www.youtube.com/watch?list=PL25sMKw559Gg9xlmLVLkmpS5XZJ-pvCd-&v=enbPj-RvXdE)

---

**Introduction**

Assignment 1 involves working with a fundamental data structure - an array of arrays. The array **data** inside the class **Analytics.java** is an instance variable and is automatically available in all the functions. Detailed explanations will be provided in weeks 3 and 4. There are 10 functions (plus 2 non-assessed) that operate on this array and other parameters, where required. The description of each function is provided above the header.

**Relevant Video:** [Arrays #6: Multi-Dimensional Arrays](https://www.youtube.com/watch?list=PL25sMKw559Gg9xlmLVLkmpS5XZJ-pvCd-&v=TgGm7lScfeA)

(Additionally, videos prefixed with **Array Problems** in the same YouTube Playlist will be beneficial.)

---

**Grade Distribution**

Your task is to code each of the 10 methods in **Analytics.java** and pass the corresponding tests in **AnalyticsTest.java**. There are 4 tests for each method (P, CR, D, HD). Pass level tests are the most basic, while HD level tests are the most comprehensive.

**Important Note:** The instance variable (the array of array of integers: data) can be accessed inside any of the functions without having to pass it as a parameter. For example:

```java
System.out.println(data[4][2]);
```

To display the last item of the last sub-array (assuming it's not null and contains at least one item), you can use:

```java
int lastSubArrayIndex = data.length - 1;
int lastItemOfLastSubArrayIndex = data[lastSubArrayIndex].length - 1;
System.out.println(data[lastSubArrayIndex][lastItemOfLastSubArrayIndex]);
```

---

**Helper Functions**

You can add other functions inside the class and call them in the functions you are supposed to complete. You can also use existing functions to help you with the more advanced functions if needed.

---

**Note on JUnit Test Cases Provided**

Understanding what the tests are asking is crucial for solving the assignment.

Note that while passing the given tests is likely to result in passing the final tests, some students may hard-code their solutions. Therefore, passing these tests does not guarantee marks in the final test. Your code will be tested on another dataset to prevent hard-coding.

---

**Use of Functions Outside the Class**

You cannot use any function that is not defined in the class. Avoid using functions like **Math.abs(double)** or **Arrays.toString()**.

**Using an external function will result in a zero grade.**

---

**Coding Style**

Coding style will not be marked in assignment 1, but it will be evaluated in later assignments. Ensure the following:

1. Indent your code correctly.
2. Use consistent coding style throughout the submission.
3. Include comments for non-trivial implementations.

---

**Breach of Academic Integrity**

Ensure your Student ID and Name are at the top of **Analytics.java**, and mark the checkbox to confirm that you haven't viewed any other person's code. Plagiarism will result in disciplinary action. Update the top of **Analytics.java** as follows:

```java
// Your Name
// Your Student ID
//[x]   I confirm this is my own work (in design and implementation) 
//      and that I have not viewed another student's code OR design.
```

---

**Submission**

Submit only the file **Analytics.java** by dragging it from the Eclipse package explorer and dropping it into the submission box. Do not include **AnalyticsTest.java** or **Analytics.class** accidentally.

**DO NOT RENAME THE FILE. IT MUST BE NAMED Analytics.java**

You can make multiple submissions, but only the last one will be marked. Late submissions will incur a penalty of 20% per day.

Errors in submission, such as compilation errors, incorrect file names, or programs taking longer than 5 seconds to run, will result in a zero grade.

---

Wishing you the best of luck!
