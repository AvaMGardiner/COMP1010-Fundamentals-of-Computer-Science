**Opened:** Friday, 21 August 2020, 12:00 AM **Due:** Sunday, 11 April 2021, 9:00 PM

**(10% of the final grade, Due Sunday 11th April 21:00, Late penalty 20% per day or part of)**

**Starting point/template: <ins>assignment2template.zip</ins> (bottom of page)**

**Topics assessed**

1. Classes and objects
2. Class containing arrays

**Expectations**

We assume that you have watched weeks 3 and 4 lecture, attended and participated in week 4 practical class, and solved at least 50% of questions from **classesObjects** practice package.

**Introduction**

The assignment is about video hosting websites' analytics. The class **VideoAnalytics** contains:

1. title: String - this is the title of the video
2. views: int[] - this is the number of views each day. first day views in views[0], second day views in views[1], ...

You should complete the functions in **VideoAnalytics** and then create a client code in **VideoAnalyticsClient**. Completing the functions in **PlaylistAnalytics** is optional and unassessed.

You can add instance methods and variables inside any class, but they must be declared as **private** and not **public**. Thus, only the class in which you define them should have knowledge of these methods.

**Coding style**

We will assess you on coding style in this assignment. It is a topic embedded throughout COMP1000, COMP1010. Aspects of the coding style include,

1. Variable names (5 marks) - must clearly indicate purpose. Not extremely long (like "numberOfStudentsInTheClass") or vague (like "a", "b", "c", "d", or "pog", "reee", "yeet")
2. Comments (5 marks) - must be clear, brief and where needed. So don't comment a statement "i=i+1;" as //increase value of i by 1
3. Indentation (5 marks) - choose one indentation style (C/Java) and stick to it. Marks will be deduced for inconsistent indentation.
4. Logic (5 marks) - you'll get marks for this unless your logic is convoluted.

**EXAMPLE 1:**

if(x < y) {

`   `//do nothing }

else {

`   `x++;

}

should be written as:

if(x >= y) {

`   `x++;

} 

**EXAMPLE 2:**

public static boolean containsNeg(int[] a) {    boolean foundNeg = false;

`   `for(int i=0; i < a.length; i++) {

`     `if(a[i] < 0) {

`       `foundNeg = true;

`      `}

`   `}

`   `if(foundNeg) {       return true;    }

`   `else {

`      `return false;    }

}

should be written as:

public static boolean containsNeg(int[] a) {    for(int i=0; i < a.length; i++) {

`      `if(a[i] < 0) {

`         `return true;

`      `}

`   `}

`   `return false;

}

**Grade distribution**

- VideoAnalytics (76 marks) Auto-marked
- VideoAnalyticsClient (4 marks) Auto-marked
- Coding Style (20 marks) Hand-marked

**Submission Format**

Drag and drop VideoAnalytics.java and VideoAnalyticsClient.java from package explorer to submission box.

**Use of functions from outside**

Use of functions from outside the submitted files will result in an automatic zero.

**Penalties**

Unfortunately, I have to add this section because of a very small percentage of students. So, here we go -

- 20 marks penalty for not adding student declaration at the top of **VideoAnalytics.java.**
- Any compilation error and/or infinite loop in ANY of the submitted files will result in an automatics zero.
- Submissions must be self-contained and not require any other file (besides my test files) to execute. Any dependency on an external file will result in an automatic zero.
- Changing any package declaration in any file will result in an automatic zero.
- Adding any import statement in any file will result in an automatic zero.
- Use of functions from outside the submitted files will result in an automatic zero.
