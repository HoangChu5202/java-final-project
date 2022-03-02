# Final Project

This is the final project for my CIS-171 Java course at Kirkwood Community College. Below is a journal of all the things I learned throughout the class.

## Introduction

In this week I set up Git, Github, Slack and some other stuff for class.

I also learned how to use Markdown. 
- \# to make a heading.
- \## to make a subheading, add more \# will make subheading smaller.
- Put "\_" or "\*" at beginning and the end to make text italic.
- Use "\__" or "\**" to make text bold.
- Use "\```" at beginning and end to make text look like code.

## Chapter 1

- In this chapter I learned about some simple Java program like how to output and input. 
`System.out.println("Hello, World!");`
- To ask user for input we need to do a little different with Python:
```Java
    Scanner sc = new Scanner(System.in);
    System.out.print("What is your age? ");
    int age = sc.nextInt();
    sc.close;
```
- Round off errors occur because storing decimal values in binary is not exact. In general, to avoid round off errors it is best to use the BigDecimal opens in new window class rather than the double data type. 

- If statement:
```Java
if (a<b) {
    System.out.println(a);
}
```
- For loop:
```Java
for(count = 0; count < 5; count = count+1) {
    System.out.println("This is count: " + count); 
}
```

## Chapter 2

**The math class**

Java provides a built-in Math opens in new window opens in new window class with many helpful methods. Common items include: 
- Math.PI
- Math.abs()
- Math.ceil() and Math.floor() 
- Math.max() and Math.min()
- Math.pow()
- Math.random()
- Math.round() 
- Math.sqrt()
- Math.hypot() 

**The char Data Type**

- A character must have single quotation marks around it to be assigned to the variable.
- Every character is represented by a decimal value between 0 and 127. Any of these int values can be assigned to a char variable and it will automatically be converted without the use of casting.

**Escape Characters**

Some characters are difficult to print because they are reserved for other things. To print them you need to add the backslash escape character. Escape characters in Java are basically the same as those in Python: 

   -  \'   print a single quotation mark
   -  \"   print a double quotation mark
   -  \\   print a single backslash
   -  \r   print a carriage return
   -  \n   print a new line
   -  \t   print a horizontal tab

**Variable Scope**

- Code blocks include if statements, loops, methods, and classes. Their code is enclosed inside opening { and closing } curly brackets.
- Any variable declared outside the curly brackets is considered to have a global scope.
- Any variable declared within the curly brackets is considered to have a local scope.
- Scopes can be nested, meaning an inner scope has access to all variables in its outer scope. 

**Logical Operators**

Logical operators in Java are the same as logical operators in Python.
   - < less than, <= less than or equal to, > greater than, >= greater than or equal to, == equal to, != not equal to.
